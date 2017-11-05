package com.mars.model;

public class Coordinates implements Comparable<Coordinates> {

    public static final Coordinates ZERO = new Coordinates(0, 0);

    private long x;
    private long y;

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Coordinates add(final Coordinates coordinates) {
        return new Coordinates(x + coordinates.x, y + coordinates.y);
    }

    public double distance(Coordinates coordinates) {
        return Math.sqrt(Math.abs(Math.pow(this.getX() - coordinates.getX(), 2))
                + Math.abs(Math.pow(this.getY() - coordinates.getY(), 2)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (x ^ (x >>> 32));
        result = prime * result + (int) (y ^ (y >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public static class Unmodifiable extends Coordinates {

        public Unmodifiable(long x, long y) {
            super(x, y);
        }

        @Override
        public Coordinates add(final Coordinates coordinates) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public int compareTo(Coordinates coordinates) {
        final long compareX = Long.compare(this.x, coordinates.x);
        final long compareY = Long.compare(this.y, coordinates.y);
        return compareX == compareY ? 0 : compareX > 0 || compareY > 0 ? 1 : -1;
    }
}
