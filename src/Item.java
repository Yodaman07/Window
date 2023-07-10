import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class Item extends JComponent {
    Dimension spriteSize;
    CoordinateCollection coordCollection;
    Boolean filled;


    public Item(Dimension spriteSize, CoordinateCollection coordCollection, Boolean filled) {
        this.spriteSize = spriteSize;
        this.coordCollection = coordCollection;
        this.filled = filled;
    }

    Path2D createPath(CoordinateCollection coordCollection){
        Path2D path = new Path2D.Float();
        //Help from
        //https://stackoverflow.com/questions/43738536/filling-shape-made-of-line2d-with-color
        int coordCount = coordCollection.coords.length;
        for (int i = 0; i < coordCount ; i++) {
            Coordinate current = coordCollection.coords[i];
            Coordinate next;
            if (i + 1 == coordCount) {
                //Connect to first point
                next = coordCollection.coords[0];
            } else {
                //Continue connecting points
                next = coordCollection.coords[i + 1];
            }

            if ((current.x > spriteSize.width || current.x < 0) || (current.y > spriteSize.height || current.y < 0)) {
                throw new RuntimeException("The coordinates don't match the sprite size");
            }

            //Debuging stuff
//            System.out.println(Arrays.toString(current.getCoordinate()));
//            System.out.println(Arrays.toString(next.getCoordinate()));
//            System.out.println();

            //Help from https://stackoverflow.com/questions/10767265/drawing-a-line-on-a-jframe
            Line2D line = new Line2D.Float(current.x, current.y, next.x, next.y);
            path.append(line, path.getCurrentPoint() != null);
        }
        path.closePath(); //???
        return path;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
//        g.drawRect(10, 10, 50, 50);
//        g.fillRect(0,0,50, 50);

        if(filled){
            g.fill(createPath(this.coordCollection));
        }else{
            g.draw(createPath(this.coordCollection));
        }
    }
}
