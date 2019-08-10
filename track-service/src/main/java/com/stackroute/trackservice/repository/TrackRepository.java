package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

    //    @Query("select t from Track t where t.trackName = ?1")
//    List<Track> getTrackByName(String trackName);

//    @Query
    List<Track> findByTrackName(String trackName);
}
