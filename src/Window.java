import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    int WINDOW_POS_CENTER_X;
    int WINDOW_POS_CENTER_Y;

    public Window(String name, Dimension size) {
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(size));

        this.WINDOW_POS_CENTER_X = getWidth()/2;
        this.WINDOW_POS_CENTER_Y = getHeight()/2;

        this.pack();
        this.setVisible(true);
        this.setResizable(true);
    }

    void setColor(Color content, Color bar){
        this.getContentPane().setBackground(content);
        this.setBackground(bar);
    }

    void renderSprite(CoordinateCollection coordCollection, Dimension pos){
        Dimension spriteSize = new Dimension(coordCollection.spriteSize.width, coordCollection.spriteSize.height);
        Item i = new Item(spriteSize, pos, coordCollection);
        this.add(i);
        this.pack();
    }
}
