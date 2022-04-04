package br.com.cvc.services.impl;

import br.com.cvc.entities.Price;
import br.com.cvc.entities.Room;
import br.com.cvc.exceptions.BusinessException;
import br.com.cvc.gateway.CVCGateway;
import br.com.cvc.gateway.responses.CVCResponse;
import br.com.cvc.gateway.responses.CVCResponseRoom;
import br.com.cvc.requests.BookingByCityRequest;
import br.com.cvc.responses.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements br.com.cvc.services.BookingService {

    @Value("${DEFAULT_ADULT_QUANTITY}")
    private int defaultAdultQuantity;

    @Value("${DEFAULT_CHILD_QUANTITY}")
    private int defaultChildQuantity;

    @Value("${DEFAULT_TRAVEL_DAYS}")
    private int defaultTravelDays;

    @Autowired
    private CVCGateway cvcGateway;

    private static final BigDecimal DEFAULT_FEE = new BigDecimal("0.7");

    public List<BookingResponse> getBookingByCity(BookingByCityRequest bookingRequest) {
        return calculateBooking(cvcGateway.getBookingFromByCityId(bookingRequest), calculateTravelDays(bookingRequest),
                bookingRequest.getAdultQuantity(), bookingRequest.getChildQuantity());
    }

    public List<BookingResponse> getBookingByHotel(int hotelId) {
        return calculateBooking(cvcGateway.getBookingFromByHotelId(hotelId), defaultTravelDays, defaultAdultQuantity, defaultChildQuantity);
    }

    private int calculateTravelDays(BookingByCityRequest bookingRequest) {
        return (int) ChronoUnit.DAYS.between(bookingRequest.getCheckIn(), bookingRequest.getCheckOut());
    }

    private List<BookingResponse> calculateBooking(List<CVCResponse> cvcCityResponseList, int travelDays, int daysAdult, int daysChild) {
        try {
            List<BookingResponse> bookingResponses = new ArrayList<>();
            for (CVCResponse cvcResponse : cvcCityResponseList) {
                bookingResponses.add(new BookingResponse(
                        cvcResponse.getId(),
                        cvcResponse.getCityName(),
                        parseCVCRoomToRoom(cvcResponse.getRoomsList(), travelDays, daysAdult, daysChild)
                ));
            }
            return bookingResponses;
        } catch (RuntimeException e) {
            throw new BusinessException(e.getMessage(), e.getCause());
        }
    }

    private List<Room> parseCVCRoomToRoom(List<CVCResponseRoom> cvcResponseRoomList, int travelDays, int daysAdult, int daysChild) {
        List<Room> parsedRoomList = new ArrayList<>();
        for (CVCResponseRoom cvcResponseRoom : cvcResponseRoomList) {
            BigDecimal calculatedAdultStayWithFee =
                    calculateStayWithFee(cvcResponseRoom.getPrice().getAdult());
            BigDecimal calculatedChildStayWithFee =
                    calculateStayWithFee(cvcResponseRoom.getPrice().getChild());
            BigDecimal calculatedTotalStayValue =
                    calculateTotalStayValue(calculatedAdultStayWithFee, calculatedChildStayWithFee, travelDays, daysAdult, daysChild);
            parsedRoomList.add(new Room(cvcResponseRoom.getRoomID(), cvcResponseRoom.getCategoryName(),
                    calculatedTotalStayValue, new Price(calculatedAdultStayWithFee, calculatedChildStayWithFee)));
        }
        return parsedRoomList;
    }

    private BigDecimal calculateStayWithFee(BigDecimal price) {
        return price.divide(DEFAULT_FEE, MathContext.DECIMAL32).setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal calculateTotalStayValue(BigDecimal calculatedAdultStayWithFee, BigDecimal calculatedChildStayWithFee, int travelDays, int daysAdult, int daysChild) {
        BigDecimal calculatedAdultsValue = calculatedAdultStayWithFee.multiply(new BigDecimal(daysAdult));
        BigDecimal calculatedChildrenValue = calculatedChildStayWithFee.multiply(new BigDecimal(daysChild));
        return (new BigDecimal(travelDays).multiply(calculatedAdultsValue)
                .add((calculatedChildrenValue.multiply(new BigDecimal(travelDays)))))
                .setScale(2, RoundingMode.CEILING);
    }
}
