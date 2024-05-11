package com.sudheer.bookmyshow.repositries;

import com.sudheer.bookmyshow.models.Booking;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    Booking save(Booking booking);

    Booking findByBookingId(int bookingId);
}
