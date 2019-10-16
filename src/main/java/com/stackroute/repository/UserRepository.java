package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Track, Integer> {
    /* the implementation will be provided to us in run time*/
    @Query("from Track where trackName=?1")
    public List<Track> findByName(String trackName);


}
