package com.stackroute.trackservice.service;

import com.stackroute.trackservice.controller.TrackController;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;
    @Mock
    TrackRepository trackRepository;
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(23);
        track.setTrackName("John");
        track.setComments("THis is another comment");
        list = new ArrayList<>();
        list.add(track);
        track.setTrackId(25);
        track.setTrackName("Joe");
        track.setComments("Some Comment");
        list.add(track);


    }


    @Test
    public void saveTrackTestSuccess() throws TrackIdAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track saveTrack=trackService.saveTrack(track);
        Assert.assertEquals(track,saveTrack);
        verify(trackRepository,times(1)).save(track);
    }

@Test(expected =TrackIdAlreadyExistsException.class)
public void saveTrackTestFailure() throws TrackIdAlreadyExistsException
{
//    Track track1=new Track(23,"Joe","Some Comment");
    when(trackRepository.existsById(track.getTrackId())).thenReturn(true);
    when(trackRepository.save((Track) any())).thenReturn(track);
    Track savedTrack = trackService.saveTrack(track);
    System.out.println("savedTrack" + savedTrack);
    Assert.assertEquals(track,savedTrack);
}
@Test
    public void testGetTrackById() throws TrackNotFoundException{
        trackRepository.save(track);
        Track track4=new Track(25,"Joe","Some Comment");
        when(trackRepository.existsById(25)).thenReturn(true);
        when(trackRepository.findById(25)).thenReturn(Optional.of(track4));
       // Optional<Track> track2=trackService.getTrackById(25);
        Assert.assertEquals(track4,track);

//        Optional<Track> track1=trackService.getTrackById(23);
//        Assert.assertEquals(track1,track);
//        verify(trackRepository,times(1)).findById(23);
}

    @Test(expected =TrackNotFoundException.class)
    public void testGetTrackByIdFailure() throws TrackNotFoundException{
        when(trackRepository.existsById(28)).thenReturn(false);
        when(trackRepository.findById(28)).thenReturn(Optional.ofNullable(track));
        Optional<Track> getBYId=trackService.getTrackById(28);
        Assert.assertEquals("Track Not Found Exception",getBYId);
    }


    @Test
    public void getAllTracks() throws Exception {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> music=trackService.getAllTracks();
        Assert.assertEquals(list,music);
    }

    @Test(expected = Exception.class)
    public void testGetAllTracksFailure() throws Exception{
        when(trackRepository.equals(null)).thenReturn(false);
        when(trackRepository.findAll()).thenReturn((List<Track>) track);
        List<Track> getAllTracks=trackService.getAllTracks();
        Assert.assertEquals(Exception.class,getAllTracks);
    }
    @Test
    public void updateTrackTestSuccess() throws TrackNotFoundException
    {

        trackRepository.save(track);
        Track track1 = new Track();
        track1.setTrackName("Better");
        track1.setComments("Best Track");
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.of(track));
        Track updateTrack =  trackService.updateTrack(25,track1);
        when(trackRepository.save(updateTrack)).thenReturn(updateTrack);
        Assert.assertNotEquals(updateTrack,track);
        verify(trackRepository,times(1)).save(track);
    }
    @Test
    public void deleteTrackTestSuccess() throws TrackNotFoundException
    {
        trackRepository.save(track);
        when(trackRepository.existsById(track.getTrackId())).thenReturn(true);
        when(trackRepository.findById(track.getTrackId())).thenReturn(java.util.Optional.of(track));
        Optional<Track> track1 = trackService.trackDeleteById(track.getTrackId());
        Assert.assertEquals(true,trackRepository.existsById(track.getTrackId()));

    }

}


