package com.squad.roboticRovers.services;

import com.squad.roboticRovers.model.LandingPosition;
import com.squad.roboticRovers.model.Rover;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoverPositionService {

    List<LandingPosition> setLandingPosition(List<Rover> rovers , int gridX, int gridY);
}
