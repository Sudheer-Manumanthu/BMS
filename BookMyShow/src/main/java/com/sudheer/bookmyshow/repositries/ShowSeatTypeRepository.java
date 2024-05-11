package com.sudheer.bookmyshow.repositries;

import com.sudheer.bookmyshow.models.Show;
import com.sudheer.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer>{

    List<ShowSeatType> findAllById(Show show);
}
