package com.squad.roboticRovers.controller;

import com.squad.roboticRovers.model.LandingPosition;
import com.squad.roboticRovers.model.Rover;
import com.squad.roboticRovers.services.RoverPositionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(value = MockitoJUnitRunner.class)
@SpringBootTest
class RoverControllerTest extends RoverController {

    @Mock
    RoverPositionService roverPositionService;

    @InjectMocks
    RoverController roverController;

    @Before
    public void setUp ()throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testGetPosition() {
        LandingPosition landingPosition = new LandingPosition();
        landingPosition.setStatus("Rover Landed Successfully");
        landingPosition.setFacingDirection('N');
        landingPosition.setPositionX(4);
        landingPosition.setPositionY(3);
        landingPosition.setRoverId(1);

        List<LandingPosition> landingPositions = new ArrayList<>();
        landingPositions.add(landingPosition);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);


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

        Mockito.when(roverPositionService.setLandingPosition(Mockito.anyList(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(landingPositions);

        ResponseEntity<List<LandingPosition>> returnVal = roverController.getPosition(rovers,gridX,gridY);
        assertNotNull(returnVal);





    }
}