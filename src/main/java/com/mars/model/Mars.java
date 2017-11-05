package com.mars.model;

public class Mars {

    private static final class MarsHolder {
        private static final Mars INSTANCE = new Mars(new Area(0, 0, 5, 5));
    }

    public static Mars instance() {
        return MarsHolder.INSTANCE;
    }

    private final Area area;

    public Mars(final Area area) {
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

}
