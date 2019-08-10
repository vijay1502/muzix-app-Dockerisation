//package com.stackroute.trackservice.service;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.exceptions.TrackIdAlreadyExistsException;
//import com.stackroute.trackservice.exceptions.TrackNotFoundException;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//@Primary
//@Qualifier("dummy")
//public class TrackServiceDummyImpl implements TrackService {
//    @Override
//    public Track saveTrack(Track track) throws TrackIdAlreadyExistsException {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Track> getAllTracks() throws Exception {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> trackDeleteById(int trackId) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public Track updateTrack(int trackId, Track track) throws TrackNotFoundException {
//        return null;
//    }
//
//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
//        return null;
//    }
//}
