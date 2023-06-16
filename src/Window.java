import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window(String name, Dimension size) {
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(size));


        this.pack();
        this.setVisible(true);
        this.setResizable(true);
    }

    void setColor(Color content, Color bar){
        this.getContentPane().setBackground(content);
        this.setBackground(bar);
    }

    void renderItem(CoordinateCollection coordCollection){
        Item i = new Item(10,10, new Dimension(coordCollection.spriteSize.width, coordCollection.spriteSize.height), coordCollection);
        this.add(i);
        this.pack();
    }
}
