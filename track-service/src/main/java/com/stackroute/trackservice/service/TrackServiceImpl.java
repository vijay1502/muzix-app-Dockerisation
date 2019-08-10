package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.client.HttpServerErrorException.*;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl() {
    }

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackIdAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackIdAlreadyExistsException("Track Id Already Exists, Try new One");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException {


        if (!trackRepository.existsById(trackId)) {
            throw new TrackNotFoundException("Track Not Found Exception");
        }
        return trackRepository.findById(trackId);
    }
 /*   @Override
    public List<Track> getAllTracks(int trackId) {
       List<Track> trackList=trackRepository.findAll();
       return trackList;
    }*/

    @Override
    public List<Track> getAllTracks() throws Exception {
        List<Track> trackList = trackRepository.findAll();
        System.out.println("****" + trackList);
        if (trackList.isEmpty()) {
            throw new Exception("TrackS NOT fOUnd");
        }
        return trackList;
    }

    @Override
    public Optional<Track> trackDeleteById(int trackId) throws TrackNotFoundException {
        Optional<Track> trackDelete = trackRepository.findById(trackId);
        if (!trackDelete.isPresent()) {
            throw new TrackNotFoundException("Track Not Found Exception");

        }
        else {
            trackRepository.deleteById(trackId);
        }
        return trackDelete;
    }

    @Override
    public Track updateTrack(int trackId, Track track) throws TrackNotFoundException {

        if (!trackRepository.findById(trackId).isPresent()) {
            throw new TrackNotFoundException("Track Not Found Exception");
        }
        else {
        Track update = trackRepository.findById(trackId).get();
        update.setTrackName(track.getTrackName());
        update.setComments(track.getComments());
        return trackRepository.save(track);}
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        List<Track> trackByName = trackRepository.findByTrackName(trackName);
            if (trackRepository.findByTrackName(trackName).isEmpty()) {
            throw new TrackNotFoundException("Track Not Found Exception");
        }
        else{List<Track> trackList=trackRepository.findByTrackName(trackName);
        return trackList;}
    }
}
