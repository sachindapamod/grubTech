package com.squad.roboticRovers.controller;

import com.squad.roboticRovers.model.LandingPosition;
import com.squad.roboticRovers.model.Rover;
import com.squad.roboticRovers.services.RoverPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RoverPosition")
public class RoverController {

    @Autowired
    RoverPositionService roverPositionService;
    final Logger logger = LoggerFactory.getLogger(RoverController.class);
    @PostMapping("/getLandingPosition")
    public ResponseEntity<List<LandingPosition>> getPosition(@RequestBody List<Rover> rovers ,@RequestParam int gridX,@RequestParam int gridY){
        logger.info("RoverController Get Position Rovers List: {} {} {} ",rovers.toString(),gridX,gridY);
        return new ResponseEntity<List<LandingPosition>>(roverPositionService.setLandingPosition(rovers, gridX, gridY), new HttpHeaders(), HttpStatus.OK);
    }

}
