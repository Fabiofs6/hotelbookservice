package br.com.cvc.services.impl;

import br.com.cvc.gateway.CVCGateway;
import br.com.cvc.gateway.responses.CVCPriceResponse;
import br.com.cvc.gateway.responses.CVCResponse;
import br.com.cvc.gateway.responses.CVCResponseRoom;
import br.com.cvc.requests.BookingByCityRequest;
import br.com.cvc.responses.BookingResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookingServiceImplTest {

    @Mock
    private CVCGateway cvcGateway;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private List<CVCResponse> cvcResponseList;

    @BeforeAll
    private void setUp(){
        cvcResponseList = new ArrayList<>();
        List<CVCResponseRoom> cvcResponseRoomList = new ArrayList<>();
        CVCResponseRoom cvcResponseRoom = new CVCResponseRoom(1, "Standard",
                new CVCPriceResponse(new BigDecimal("500.00"), new BigDecimal("300.00")));
        cvcResponseRoomList.add(cvcResponseRoom);
        CVCResponse cvcResponse = new CVCResponse(1, "Hotel 1", 1, "City Name", cvcResponseRoomList);
        cvcResponseList.add(cvcResponse);
    }

    @Test
    public void getBookingByCityTest() {
        BookingByCityRequest bookingByCityRequest = new BookingByCityRequest(1, LocalDate.now(), LocalDate.now(), 1, 1);
        Mockito.when(cvcGateway.getBookingFromByCityId(bookingByCityRequest)).thenReturn(cvcResponseList);

        List<BookingResponse> responses = bookingService.getBookingByCity(bookingByCityRequest);
        Assertions.assertTrue(!responses.isEmpty());
    }

    @Test
    public void getBookingByHotelTest() {
        Mockito.when(cvcGateway.getBookingFromByHotelId(1)).thenReturn(cvcResponseList);
        List<BookingResponse> responses = bookingService.getBookingByHotel(1);
        Assertions.assertTrue(!responses.isEmpty());
    }
}
