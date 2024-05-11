package com.sudheer.bookmyshow.services;

import com.sudheer.bookmyshow.models.Show;
import com.sudheer.bookmyshow.models.ShowSeat;
import com.sudheer.bookmyshow.models.ShowSeatType;
import com.sudheer.bookmyshow.repositries.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllById(show);
        int amount = 0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType)){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
