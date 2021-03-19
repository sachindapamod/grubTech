package com.squad.roboticRovers.services;

import com.squad.roboticRovers.constant.RoverConstant;
import com.squad.roboticRovers.controller.RoverController;
import com.squad.roboticRovers.model.LandingPosition;
import com.squad.roboticRovers.model.Rover;
import jdk.jshell.Snippet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class RoverPositionServiceImpl implements RoverPositionService {

    int currentPositionX=0; //Rover current x position
    int currentPositionY=0;//Rover current x position

    int gridMaxX=0; //Upper-right coordinates of the plateau
    int gridMaxY=0;//lower-left coordinates of the plateau
    String status="";
    final Logger logger = LoggerFactory.getLogger(RoverPositionServiceImpl.class);

    @Override
    public List<LandingPosition> setLandingPosition(List<Rover> rovers , int gridX, int gridY) {
        List<LandingPosition> landingPositions = new ArrayList<>();
        gridMaxX=gridX;
        gridMaxY=gridY;

        for (Rover rover:rovers) {
            landingPositions.add(getPosition(rover));
        }
        logger.info("RoverPositionServiceImpl setLandingPosition Landing Positions: {}"+landingPositions.toString());
        return landingPositions;
    }

    private  LandingPosition getPosition(Rover rover){
        LandingPosition landingPosition = new LandingPosition();
        int x =0;
        char faceDirection =rover.getFacingDirection();
        currentPositionX=rover.getStartPositionX();
        currentPositionY=rover.getStartPositionY();



        for (char command:rover.getLandingSteps()) {
            switch (command)
            {
                case RoverConstant.TURN_RIGHT:
                    if(faceDirection==RoverConstant.MOVE_NORTH){
                        faceDirection=RoverConstant.MOVE_EAST; //When rover face into North direction if it turn into Right new face direction will be East
                    }
                    else if(faceDirection==RoverConstant.MOVE_EAST){
                        faceDirection=RoverConstant.MOVE_SOUTH;//When rover face into East direction if it turn into Right new face direction will be South
                    }
                    else if(faceDirection==RoverConstant.MOVE_SOUTH){
                        faceDirection=RoverConstant.MOVE_WEST;//When rover face into South direction if it turn into Right new face direction will be West
                    }
                    else if(faceDirection==RoverConstant.MOVE_WEST){
                        faceDirection=RoverConstant.MOVE_NORTH;//When rover face into West direction if it turn into Right new face direction will be North
                    }
                    break;
                case RoverConstant.TURN_LEFT:
                    if(faceDirection==RoverConstant.MOVE_NORTH){
                        faceDirection=RoverConstant.MOVE_WEST;//When rover face into North direction if it turn into Left new face direction will be West
                    }
                    else if(faceDirection==RoverConstant.MOVE_EAST){
                        faceDirection=RoverConstant.MOVE_NORTH;//When rover face into East direction if it turn into Left new face direction will be North
                    }
                    else if(faceDirection==RoverConstant.MOVE_SOUTH){
                        faceDirection=RoverConstant.MOVE_EAST;//When rover face into South direction if it turn into Left new face direction will be East
                    }
                    else if(faceDirection==RoverConstant.MOVE_WEST){
                        faceDirection=RoverConstant.MOVE_SOUTH;//When rover face into West direction if it turn into Left new face direction will be South
                    }
                    break;
                default:
                    setPositionXY(faceDirection,currentPositionX,currentPositionY); //Pass face Direction and Current Positions  set rover position
                    break;
            }
        }

        if (status.equals(RoverConstant.LAND)) {
            landingPosition.setRoverId(rover.getId());
            landingPosition.setPositionX(this.currentPositionX);
            landingPosition.setPositionY(this.currentPositionY);
            landingPosition.setFacingDirection(faceDirection);
            landingPosition.setStatus(this.status);

        }
        else {
            landingPosition.setRoverId(rover.getId());
            landingPosition.setPositionX(0);
            landingPosition.setPositionY(0);
            landingPosition.setFacingDirection('X');
            landingPosition.setStatus(this.status);
        }
    return landingPosition;
    }

    private void setPositionXY(char faceDirection ,int currentPositionX ,int currentPositionY){
        logger.info("RoverPositionServiceImpl setPositionXY: faceDirection {}{}{}",faceDirection,currentPositionX,currentPositionY);
        switch (faceDirection)
        {
            case  RoverConstant.MOVE_NORTH:
                currentPositionY=currentPositionY+1; // If rover direction command is move to north y increase by 1
                logger.info("RoverPositionServiceImpl setPositionXY:currentPositionY North{}",currentPositionY);
                break;
            case RoverConstant.MOVE_EAST:
                currentPositionX=currentPositionX+1;// If rover direction command is move to east x increase by 1
                logger.info("RoverPositionServiceImpl setPositionXY:currentPositionY EAST {}",currentPositionX);
                break;
            case RoverConstant.MOVE_SOUTH:
                currentPositionY=currentPositionY-1;// If rover direction command is move to south y decrease by 1
                logger.info("RoverPositionServiceImpl setPositionXY:currentPositionY south{}",currentPositionY);
                break;
            case RoverConstant.MOVE_WEST:
                currentPositionX=currentPositionX-1;// If rover direction command is move to west x decrease by 1
                logger.info("RoverPositionServiceImpl setPositionXY:currentPositionY West{}",currentPositionX);
                break;
            default:
                break;
        }

        if (currentPositionX >= 0 && currentPositionY >= 0 && currentPositionX <= gridMaxX && currentPositionY <= gridMaxY){ // Check rover is in the grid
            this.currentPositionX=currentPositionX;
            this.currentPositionY=currentPositionY;
            this.status=RoverConstant.LAND;
        }
        else {
            status=RoverConstant.OUT_OF_RANGE;
        }


    }

}
