package com.squad.roboticRovers.services;

import com.squad.roboticRovers.controller.RoverController;
import com.squad.roboticRovers.model.LandingPosition;
import com.squad.roboticRovers.model.Rover;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(value = MockitoJUnitRunner.class)
@SpringBootTest
class RoverPositionServiceImplTest extends RoverController {

    @InjectMocks
    RoverPositionServiceImpl roverPositionService;

    @Test
    void setLandingPosition() {
        int gridX=5;
        int gridY=5;

        Rover rover = new Rover();
        rover.setId(1);
        rover.setStartPositionX(1);
        rover.setStartPositionY(2);
        rover.setFacingDirection('N');
        char [] steps={'L','M','L','M','L','M','L','M','M'};
        rover.setLandingSteps(steps);

        List<Rover> rovers = new ArrayList<>();
        rovers.add(rover);

        List<LandingPosition>returnVal = roverPositionService.setLandingPosition(rovers,gridX,gridY);
        assertNotNull(returnVal);
    }

    @Test
    void setLandingPosition2() {
        int gridX=5;
        int gridY=5;


        Rover rover = new Rover();
        rover.setId(2);
        rover.setStartPositionX(3);
        rover.setStartPositionY(3);
        rover.setFacingDirection('N');
        char [] steps1={'M','M','R','M','M','R','M','R','R','M'};
        rover.setLandingSteps(steps1);

        List<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        //rovers.add(rover1);


        List<LandingPosition>returnVal = roverPositionService.setLandingPosition(rovers,gridX,gridY);
        assertNotNull(returnVal);
    }

    @Test
    void setLandingPosition3() {
        int gridX=5;
        int gridY=5;


        Rover rover = new Rover();
        rover.setId(3);
        rover.setStartPositionX(5);
        rover.setStartPositionY(5);
        rover.setFacingDirection('E');
        char [] steps1={'M','M','R','M','M','R','M','R','R','M','M','M','M'};
        rover.setLandingSteps(steps1);

        List<Rover> rovers = new ArrayList<>();
        rovers.add(rover);

        List<LandingPosition>returnVal = roverPositionService.setLandingPosition(rovers,gridX,gridY);
        assertNotNull(returnVal);
    }
}