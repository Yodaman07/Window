package rendering;

import javax.swing.*;
import java.awt.*;


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

    public void setColor(Color content, Color bar){
        this.colors = new Color[]{content, bar};
        this.getContentPane().setBackground(content);
        this.setBackground(bar);
    }

    public void renderSprite(CoordinateCollection coordCollection, String name, Window parent, boolean filled){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, filled);
        i.setName(name);
        parent.add(i);
        this.pack();
    }

    public void renderSprite(CoordinateCollection coordCollection, String name, JPanel parent, boolean filled){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, filled);
        i.setName(name);
        parent.add(i);
        this.pack();
    }

    public void initGrid(int tileSize){
        JPanel grid = new JPanel();
        grid.setName("System: Grid");
        grid.setBackground(this.colors[0]);
        grid.setLayout(new GridLayout(max(getHeight()/tileSize,getWidth()/tileSize), max(getHeight()/tileSize,getWidth()/tileSize), 0, 0));

        this.add(grid);
        this.tileSize = tileSize;
        this.grid = grid;
        this.pack();
    }


    //rendering.Coordinate is being used differently here. Instead of being used as a way to draw sprites, it's an x and y coord for the grid
    //unlike positioning of items, the fillGrid method will the bottom left as (0,0) and act as a traditional grid
    public void setGrid(Coordinate[] fillCords){
        clearGrid();
        boolean match;
        Coordinate[] square = {
                new Coordinate(0, 0),
                new Coordinate(this.tileSize, 0),
                new Coordinate(this.tileSize, this.tileSize),
                new Coordinate(0, this.tileSize),
        };

        CoordinateCollection gridSquare = new CoordinateCollection(new Dimension(this.tileSize, this.tileSize), square);
        for (int y = 0; y < (getHeight()/this.tileSize); y++) {
            for (int x = 0; x < (getWidth()/this.tileSize); x++) {
                match = false;
                //j is x-axis and i is y-axis
                if(fillCords == null) {
                    this.renderSprite(gridSquare, "SYSTEM: Grid_Tile", this.grid, false);
                }else{
                    for (Coordinate coord:fillCords) {
                        match = ((x == coord.x) && (y == coord.y));
                        if (match){
                            break;
                        }
                        //More Debug stuff
//                        System.out.println(coord.x + ":" + x);
//                        System.out.println(coord.y + ":" + y);
//                        System.out.println(match);
//                        System.out.println();
                    }
                    this.renderSprite(gridSquare, "SYSTEM: Grid_Tile", this.grid, match);
                }
            }
        }
        this.pack();
    }

    public void clearGrid(){
        Component[] compList = this.grid.getComponents();
        for (Component component: compList) {
            if (component.getName().contains("System: Grid")){
                this.remove(component);
            }
        }
    }
}
