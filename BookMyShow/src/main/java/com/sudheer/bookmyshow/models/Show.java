package com.sudheer.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    private String showName;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;
    private Date startDate;
    private Date endDate;
}
