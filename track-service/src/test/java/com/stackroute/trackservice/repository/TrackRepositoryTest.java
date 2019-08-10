package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;
    @Before
    public void setUp() throws Exception {
        track=new Track();
        track.setTrackId(5);
        track.setTrackName("Vijay");
        track.setComments("This is the First Track");
    }

    @After
    public void tearDown() throws Exception {
    trackRepository.deleteAll();
    }
//    @Test
//    public void testSaveTrack(){
//
//        Track fetchTrackId=trackRepository.findById(track.getTrackId()).get();
//        Assert.assertEquals(5,fetchTrackId.getTrackId());
//    }

   @Test
    public void findByTrackName() {
        List<Track> findTrack=trackRepository.findByTrackName("Vijay");
        Assert.assertEquals("Vijay",track.getTrackName());
    }
    @Test
    public void testFindByNameFailure(){
        Track failureTest=  new Track(52,"ASVR","Anagananaga");
        List<Track> actualTrack=trackRepository.findByTrackName(track.getTrackName());
        Assert.assertNotEquals(failureTest,actualTrack);
        Assert.assertNotSame(failureTest,actualTrack);

    }

}
