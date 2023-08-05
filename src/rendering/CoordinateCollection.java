package rendering;

import java.awt.*;

public class CoordinateCollection{
    Dimension spriteSize;
    Coordinate[] coords;

    public CoordinateCollection(Dimension spriteSize, Coordinate[] coords) {
        this.spriteSize = spriteSize;
        this.coords = coords;
    }
}