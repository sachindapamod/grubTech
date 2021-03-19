package com.squad.roboticRovers.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Arrays;

@EntityScan
public class Rover {

    private int id;
    private int startPositionX;
    private int startPositionY;
    private char facingDirection;
    private char[] landingSteps;

    public int getId() {
        return id;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public char getFacingDirection() {
        return facingDirection;
    }

    public char[] getLandingSteps() {
        return landingSteps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public void setStartPositionY(int startPositionY) {
        this.startPositionY = startPositionY;
    }

    public void setFacingDirection(char facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void setLandingSteps(char[] landingSteps) {
        this.landingSteps = landingSteps;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id=" + id +
                ", startPositionX=" + startPositionX +
                ", startPositionY=" + startPositionY +
                ", facingDirection=" + facingDirection +
                ", landingSteps=" + Arrays.toString(landingSteps) +
                '}';
    }
}
