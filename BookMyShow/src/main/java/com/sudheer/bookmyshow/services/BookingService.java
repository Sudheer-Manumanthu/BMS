package com.sudheer.bookmyshow.services;

import com.sudheer.bookmyshow.exceptions.SeatNotAvailableException;
import com.sudheer.bookmyshow.exceptions.ShowNotFound;
import com.sudheer.bookmyshow.exceptions.UserNotFound;
import com.sudheer.bookmyshow.models.*;
import com.sudheer.bookmyshow.repositries.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final PriceCalculator priceCalculator;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, ShowSeatTypeRepository showSeatTypeRepository, PriceCalculator priceCalculator, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
        this.priceCalculator = priceCalculator;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(int userId, List<Integer> showSeatIds, int showId) throws UserNotFound, ShowNotFound, SeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFound("User not found with UserId: " + userId);
        }

        User user = optionalUser.get();

        if (optionalShow.isEmpty()) {
            throw new ShowNotFound("Show not found with showID: " + showId);
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getStatus().equals(Status.AVAILABLE)) throw new SeatNotAvailableException("Seat not available with show seat ID: " + showSeat.getId());
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setStatus(Status.BLOCKED);
        }

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculator.calculatePrice(show, showSeats));
        booking.setPaymentStatus(PaymentStatus.PENDING);
        bookingRepository.save(booking);


//        for (Integer shoeSeatId : showSeatIds) {
//            Optional<ShowSeat> optionalShowSeat = showSeatRepository.findById(shoeSeatId);
//            if(optionalShowSeat.isEmpty()) {
//                throw new ShowNotFound("shoeSeatId not found with shoeSeatId: " + shoeSeatId);
//            }
//            showSeats.add(optionalShowSeat.get());
//        }

        return bookingRepository.save(booking);
    }
}
