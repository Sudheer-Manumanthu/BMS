package com.sudheer.bookmyshow.repositries;

import com.sudheer.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    @Override
    Optional<ShowSeat> findById(Integer integer);

    @Override
    List<ShowSeat> findAllById(Iterable<Integer> integers);
}
