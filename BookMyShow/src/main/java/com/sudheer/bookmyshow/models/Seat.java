package com.sudheer.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int x;
    private int y;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
