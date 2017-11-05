package com.mars.model;

public class Bot {

    private Coordinates coordinates;
    private char direction;

    public Bot(Coordinates coordinates, char direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void move(Coordinates coordinates) {
        this.coordinates = this.coordinates.add(coordinates);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public String finalPosition() {
        return String.format("(%d, %d, %s)", coordinates.getX(), coordinates.getY(), direction);
    }

    public static synchronized Bot create(final Coordinates coordinates, char direction) {
        return new Bot(coordinates, direction);
    }

}
