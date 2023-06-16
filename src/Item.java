import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Item extends JComponent {
    Dimension spriteSize;

    Dimension pos;
    CoordinateCollection coordCollection;


    public Item(Dimension dimension, Dimension pos, CoordinateCollection coordCollection) {
        this.spriteSize = dimension;
        this.pos = pos;
        this.coordCollection = coordCollection;
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
//        graphics.drawRect(10, 10, 50, 50);
//        g.fillRect(0,0,50, 50);
        int coordCount = this.coordCollection.coords.length;
        for (int i = 0; i < coordCount ; i++) {
            Coordinate current = this.coordCollection.coords[i];
            Coordinate next;
            if (i+1 == coordCount){
                //Connect to first point
                next = this.coordCollection.coords[0];
            }else{
                //Continue connecting points
                next = this.coordCollection.coords[i+1];
            }

            if ((current.x > 50 || current.x < -50) || (current.y > 50 || current.y < -50)){
                throw new RuntimeException("The coordinates don't match the sprite size");
            }

            //Help from https://stackoverflow.com/questions/10767265/drawing-a-line-on-a-jframe
            Line2D line = new Line2D.Float(current.x + pos.width, current.y + pos.height, next.x + pos.width, next.y + pos.height);
//            System.out.println(Arrays.toString(current.getCoordinate()));
//            System.out.println(Arrays.toString(next.getCoordinate()));
//            System.out.println();
            g.draw(line);
        }
    }
}
