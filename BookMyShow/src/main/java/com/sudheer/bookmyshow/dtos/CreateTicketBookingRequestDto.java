package com.sudheer.bookmyshow.dtos;

import com.sudheer.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateTicketBookingRequestDto {
    private int userID;
    private List<Integer> showSeatIds;
    private int showId;
}
