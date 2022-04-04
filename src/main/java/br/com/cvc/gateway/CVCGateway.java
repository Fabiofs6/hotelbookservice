package br.com.cvc.gateway;

import br.com.cvc.exceptions.GatewayResponseException;
import br.com.cvc.gateway.responses.CVCResponse;
import br.com.cvc.requests.BookingByCityRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CVCGateway {

    @Value("${CVC_BOOKING_INFORMATION_BY_CITY_URL}")
    private String CVCBookingInformationByCityURL;

    @Value("${CVC_BOOKING_INFORMATION_BY_HOTEL_URL}")
    private String CVCBookingInformationByHotelURL;

    private RestTemplate restTemplate;

    public CVCGateway() {
        this.restTemplate = new RestTemplate();
    }

    public List<CVCResponse> getBookingFromByCityId(BookingByCityRequest bookingRequest) {
        try {
            String uri = CVCBookingInformationByCityURL + bookingRequest.getCityCode();
            ResponseEntity<List<CVCResponse>> response =
                    restTemplate.exchange(uri, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<CVCResponse>>() {});
            return response.getBody();
        } catch (RuntimeException e) {
            throw new GatewayResponseException(e.getMessage(), e.getCause());
        }
    }

    public List<CVCResponse> getBookingFromByHotelId(int hotelId) {
        try {
            String uri = CVCBookingInformationByHotelURL + hotelId;
            ResponseEntity<List<CVCResponse>> response =
                    restTemplate.exchange(uri, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<CVCResponse>>() {});
            return response.getBody();
        } catch (RuntimeException e) {
            throw new GatewayResponseException(e.getMessage(), e.getCause());
        }
    }
}
