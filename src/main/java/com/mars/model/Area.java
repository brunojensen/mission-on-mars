package com.mars.model;

import com.mars.exception.OutOfSpaceException;

public class Area {

    private final Coordinates initialCoordinates;
    private final Coordinates finalCoordinates;

    public Area(int xi, int yi, int xf, int yf) {
        this.initialCoordinates = new Coordinates.Unmodifiable(xi, yi);
        this.finalCoordinates = new Coordinates.Unmodifiable(xf, yf);
    }

    public Coordinates getFinalCoordinates() {
        return finalCoordinates;
    }

    public Coordinates getInitialCoordinates() {
        return initialCoordinates;
    }

    public void testCollision(final Coordinates coordinates) throws OutOfSpaceException {
        if (coordinates.compareTo(initialCoordinates) < 0)
            throw new OutOfSpaceException("Bot cross the deadline !");
        if (coordinates.compareTo(finalCoordinates) > 0)
            throw new OutOfSpaceException("Bot was lost !");
    }
}
