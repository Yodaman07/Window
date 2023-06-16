import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Arrays;

public class Item extends JComponent {
    int x;
    int y;
    Dimension size;
    CoordinateCollection coordCollection;

    public Item(int PosX, int PosY, Dimension dimension, CoordinateCollection coordCollection) {
        this.x = PosX;
        this.y = PosY;
        this.size = dimension;
        this.coordCollection = coordCollection;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
//        graphics.drawRect(x, y, getWidth(), getHeight());
//        g.fillRect(this.x, this.y, this.size.width, this.size.height);

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

            //Help from https://stackoverflow.com/questions/10767265/drawing-a-line-on-a-jframe
            Line2D line = new Line2D.Float(current.x, current.y, next.x, next.y);

//            System.out.println(Arrays.toString(current.getCoordinate()));
//            System.out.println(Arrays.toString(next.getCoordinate()));
//            System.out.println();
            g.draw(line);
        }
    }
}
