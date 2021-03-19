package com.squad.roboticRovers.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class LandingPosition {

    private  int roverId;
    private  int positionX;
    private  int positionY;
    private char facingDirection;
    private String Status;

    public int getRoverId() {
        return roverId;
    }

    public void setRoverId(int roverId) {
        this.roverId = roverId;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(char facingDirection) {
        this.facingDirection = facingDirection;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "LandingPosition{" +
                "roverId=" + roverId +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", facingDirection=" + facingDirection +
                ", Status='" + Status + '\'' +
                '}';
    }
}
