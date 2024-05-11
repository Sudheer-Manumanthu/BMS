package com.sudheer.bookmyshow.dtos;

import com.sudheer.bookmyshow.models.BookingResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketBookingResponseDto {
    private String bookingId;
    private BookingResponseStatus bookingStatus;
}
