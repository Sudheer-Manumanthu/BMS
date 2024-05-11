package com.sudheer.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private int bookingId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @OneToMany
    private List<Payment> payments;
    private int amount;
}
