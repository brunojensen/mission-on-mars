package com.mars.model;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mars.exception.OutOfSpaceException;

public class AreaTest {

    private Area area;

    @Before
    public void testCreation() {
        area = new Area(0, 0, 5, 5);
        Assert.assertNotNull(area);
        Assert.assertNotNull(area.getInitialCoordinates());
        Assert.assertNotNull(area.getFinalCoordinates());
    }

    @Test(expected = OutOfSpaceException.class)
    public void collisionError() {
        IntStream.rangeClosed(0, 6).forEach(i -> {
            IntStream.rangeClosed(0, 6).forEach(j -> {
                area.testCollision(new Coordinates(i, j));
            });
        });
    }

    @Test
    public void collision() {
        IntStream.rangeClosed(0, 5).forEach(i -> {
            IntStream.rangeClosed(0, 5).forEach(j -> {
                area.testCollision(new Coordinates(i, j));
            });
        });
    }

}
