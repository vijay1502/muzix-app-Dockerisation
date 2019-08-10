package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import com.stackroute.trackservice.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/")
//@Request Mapping for providing the Request path to the Server
public class TrackController {
    private TrackService trackServiceImpl;

    public TrackController() {
    }
//   @Autowired
//   public void trackQualifier(@Qualifier("dummy") TrackService trackService){
//        this.trackService=trackService;
//   }

    @Autowired
    public TrackController(TrackService trackServiceImpl) {
        this.trackServiceImpl = trackServiceImpl;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackIdAlreadyExistsException {
        ResponseEntity responseEntity;

        trackServiceImpl.saveTrack(track);
            responseEntity=new ResponseEntity(trackServiceImpl.saveTrack(track),HttpStatus.CREATED);


        return responseEntity;
    }
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrack(@PathVariable int trackId) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackServiceImpl.getTrackById(trackId);
            responseEntity=new ResponseEntity(trackServiceImpl.getTrackById(trackId),HttpStatus.CREATED);

                return responseEntity;
    }
   /* @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks(){
        Track getAllTracks=trackService.getAllTracks();
        return new ResponseEntity<>(getAllTracks,HttpStatus.CREATED);
    }*/
  @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks() throws Exception {
      ResponseEntity responseEntity;

      trackServiceImpl.getAllTracks();
      responseEntity=new ResponseEntity(trackServiceImpl.getAllTracks(),HttpStatus.CREATED);

      return responseEntity;
  }

  @DeleteMapping("trackde/{trackId}")
    public ResponseEntity<?> trackDelete(@PathVariable int trackId) throws TrackNotFoundException {
      ResponseEntity responseEntity;

      trackServiceImpl.trackDeleteById(trackId);
          responseEntity=new ResponseEntity(trackServiceImpl.trackDeleteById(trackId),HttpStatus.CREATED);


     return responseEntity;
  }


    @PutMapping("tracker/{trackId}")
    public ResponseEntity<?> updateById(@PathVariable int trackId,@RequestBody Track track) throws TrackNotFoundException {
      ResponseEntity responseEntity;

        trackServiceImpl.updateTrack(trackId,track);
        responseEntity= new ResponseEntity(trackServiceImpl.updateTrack(trackId,track), HttpStatus.OK);

      return responseEntity;
    }
   @GetMapping("tracks/{trackName}")
    public ResponseEntity<?> trackByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {
      ResponseEntity responseEntity;

       trackServiceImpl.getTrackByName(trackName);
      responseEntity=new ResponseEntity(trackServiceImpl.getTrackByName(trackName),HttpStatus.CREATED);


    return responseEntity;}

}




