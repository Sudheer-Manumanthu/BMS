package com.sudheer.bookmyshow.repositries;

import com.sudheer.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer integer);
}

