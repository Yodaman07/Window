import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static java.lang.Math.max;

public class Window extends JFrame{

    int tileSize;
    Dimension defaultSize;

    public Window(String name, Dimension size) {
        this.defaultSize = size;

        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(size);
        this.setMinimumSize(size);

        this.pack();
        this.setVisible(true);
        this.setResizable(true);
    }

    void setColor(Color content, Color bar){
        this.getContentPane().setBackground(content);
        this.setBackground(bar);
    }

    void renderSprite(CoordinateCollection coordCollection, String name){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, this);
        i.setName(name);
        this.add(i);
        this.pack();
    }

    void initGrid(int tileSize){
        this.tileSize = tileSize;

        this.setLayout(new GridLayout(max(getHeight()/tileSize,getWidth()/tileSize), max(getHeight()/tileSize,getWidth()/tileSize), 0, 0));
        System.out.println(getHeight() + ":" + getWidth());
        this.pack();
    }

    void setGrid(){
        Coordinate[] square = {
                new Coordinate(0, 0),
                new Coordinate(this.tileSize, 0),
                new Coordinate(this.tileSize, this.tileSize),
                new Coordinate(0, this.tileSize),
        };

        CoordinateCollection grid = new CoordinateCollection(new Dimension(this.tileSize, this.tileSize), square);
        for (int i = 0; i < (getHeight()/this.tileSize); i++) {
            for (int j = 0; j < (getWidth()/this.tileSize); j++) {
                this.renderSprite(grid, "SYSTEM: tile");
            }
        }
    }

    void clearGrid(){
        Component[] compList = this.getContentPane().getComponents();
        for (Component component: compList) {
            if (component.getName().contains("SYSTEM: tile")){
                this.remove(component);
            }
        }
    }

    void resizedPack(){
        int w = getWidth();
        int h = getHeight();
        this.pack();
        this.setSize(w, h);;
    }
}
