import java.awt.*;

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinate() {
        return new int[]{this.x, this.y};
    }
}

class CoordinateCollection{
    Dimension spriteSize;
    Coordinate[] coords;

    public CoordinateCollection(Dimension spriteSize, Coordinate[] coords) {
        this.spriteSize = spriteSize;
        this.coords = coords;
    }
}