import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Item extends JComponent {
    Dimension spriteSize;
    CoordinateCollection coordCollection;
    Window source;


    public Item(Dimension spriteSize, CoordinateCollection coordCollection, Window source) {
        this.spriteSize = spriteSize;
        this.coordCollection = coordCollection;
        this.source = source;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
//        g.drawRect(10, 10, 50, 50);
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

            if ((current.x > spriteSize.width || current.x < 0) || (current.y > spriteSize.height || current.y < 0)){
                throw new RuntimeException("The coordinates don't match the sprite size");
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
