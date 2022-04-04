package br.com.cvc.services;

import br.com.cvc.requests.BookingByCityRequest;
import br.com.cvc.responses.BookingResponse;

import java.util.List;

public interface BookingService {

    List<BookingResponse> getBookingByCity(BookingByCityRequest bookingRequest);
    List<BookingResponse> getBookingByHotel(int hotelId);
}
