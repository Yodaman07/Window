import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static java.lang.Math.max;

public class Window extends JFrame{

    int tileSize;
    Dimension defaultSize;
    JPanel grid;

    Color[] colors = {Color.white, Color.white};

    public Window(String name, Dimension size) {
        this.defaultSize = size;

        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(size);

        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    void setColor(Color content, Color bar){
        this.colors = new Color[]{content, bar};
        this.getContentPane().setBackground(content);
        this.setBackground(bar);
    }

    void renderSprite(CoordinateCollection coordCollection, String name, Window parent){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, this);
        i.setName(name);
        parent.add(i);
        this.pack();
    }

    void renderSprite(CoordinateCollection coordCollection, String name, JPanel parent){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, this);
        i.setName(name);
        parent.add(i);
        this.pack();
    }

    void initGrid(int tileSize){
        JPanel grid = new JPanel();
        grid.setName("System: Grid");
        grid.setBackground(this.colors[0]);
        grid.setLayout(new GridLayout(max(getHeight()/tileSize,getWidth()/tileSize), max(getHeight()/tileSize,getWidth()/tileSize), 0, 0));

        this.add(grid);
        this.tileSize = tileSize;
        this.grid = grid;
        this.pack();
    }

    void setGrid(){
        Coordinate[] square = {
                new Coordinate(0, 0),
                new Coordinate(this.tileSize, 0),
                new Coordinate(this.tileSize, this.tileSize),
                new Coordinate(0, this.tileSize),
        };

        CoordinateCollection gridSquare = new CoordinateCollection(new Dimension(this.tileSize, this.tileSize), square);
        for (int i = 0; i < (getHeight()/this.tileSize); i++) {
            for (int j = 0; j < (getWidth()/this.tileSize); j++) {
                this.renderSprite(gridSquare, "SYSTEM: Grid_Tile", this.grid);
            }
        }
        this.pack();
    }

    void clearGrid(){
        Component[] compList = this.getContentPane().getComponents();
        for (Component component: compList) {
            if (component.getName().contains("System: Grid")){
                this.remove(component);
            }
        }
    }
}
