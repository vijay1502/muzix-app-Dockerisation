package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackIdAlreadyExistsException;
    public Optional<Track> getTrackById (int trackId)throws TrackNotFoundException;
    public List<Track> getAllTracks() throws Exception;
    public Optional<Track> trackDeleteById(int trackId) throws TrackNotFoundException;
    public Track updateTrack(int trackId,Track track) throws TrackNotFoundException;
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
