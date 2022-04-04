package br.com.cvc.controller;

import br.com.cvc.exceptions.BusinessException;
import br.com.cvc.requests.BookingByCityRequest;
import br.com.cvc.responses.BookingResponse;
import br.com.cvc.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Operation(summary = "Get booking information by city")
    @ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successful operation",
                        content =
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = BookingResponse.class))),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not found",
                        content =
                        @Content(
                                mediaType = "application/json"))
        })
    @GetMapping(value = "/city")
    public ResponseEntity<List<BookingResponse>> getBookByCity(@RequestBody BookingByCityRequest bookingRequest) {
        var response = bookingService.getBookingByCity(bookingRequest);
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Get booking information by hotel id")
    @ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successful operation",
                        content =
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = BookingResponse.class))),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not found",
                        content =
                        @Content(
                                mediaType = "application/json"))
        })
    @GetMapping(value = "/hotel/{id}")
    public ResponseEntity<List<BookingResponse>> getBookByHotel(@PathVariable("id") Integer id) {
        var response = bookingService.getBookingByHotel(id);
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
