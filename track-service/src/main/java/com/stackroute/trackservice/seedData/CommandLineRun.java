//package com.stackroute.trackservice.seedData;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//@Component
//public class CommandLineRun implements CommandLineRunner {
//    private TrackRepository trackRepository;
//    @Autowired
//    public CommandLineRun(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        Track track1=new Track(4,"vijay","he is good");
//        trackRepository.save(track1);
//        Track track2=new Track(5,"ram","is bad");
//        trackRepository.save(track2);
//    }
//
//}
