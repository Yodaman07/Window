package rendering;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Window extends JFrame{

    int tileSize;
    Dimension defaultSize;
    JPanel grid;

    Color[] colors = {Color.white, Color.white};
    List<Coordinate> coords = new ArrayList<Coordinate>();

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

    public void renderSprite(CoordinateCollection coordCollection, String name,  Color color, Window parent, boolean filled){
        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, filled);
        i.setName(name);
        i.setColor(color);
        parent.add(i);
        this.pack();
    }

    public void renderSprite(CoordinateCollection coordCollection, String name, Color color, JPanel parent, boolean filled){

        Dimension spriteSize = coordCollection.spriteSize;
        Item i = new Item(spriteSize, coordCollection, filled);
        i.setName(name);
        i.setColor(color);
        parent.add(i);
        this.pack();
    }

    public void initGrid(int tileSize){
        JPanel grid = new JPanel();
        grid.setName("SYSTEM: Grid");
        grid.setBackground(this.colors[0]);

        grid.setLayout(new GridLayout(getHeight()/tileSize, getWidth()/tileSize, 0, 0));

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
        Color renderColor = Color.GRAY;

        Coordinate[] square = {
                new Coordinate(0, 0),
                new Coordinate(this.tileSize, 0),
                new Coordinate(this.tileSize, this.tileSize),
                new Coordinate(0, this.tileSize),
        };

        if (fillCords != null){
            for (Coordinate c:fillCords){
                //error catching v
                //X and Y are diff bc convert to grid only mods the y value
                if ((c.x > (getWidth()/this.tileSize)) || (c.y < 0)){
                    int fakeY = c.y;
                    int fakeX = c.x;

                    if (fakeY < 0){ fakeY = ((getHeight()/this.tileSize) - (fakeY + 1)); }

                    if (c.x > (getWidth()/this.tileSize)) {
                        Coordinate layout = new Coordinate(fakeX, fakeY).convertToGrid((getHeight() / this.tileSize));
                        fakeY = layout.y;
                    }
                    throw new RuntimeException("ERROR:OUT OF BOUNDS -> (" + fakeX + "," + fakeY + ")");
                }
            }
        }

        CoordinateCollection gridSquare = new CoordinateCollection(new Dimension(this.tileSize, this.tileSize), square);
        for (int y = 0; y < (getHeight()/this.tileSize); y++) {
            for (int x = 0; x < (getWidth()/this.tileSize); x++) {
                match = false;
                //j is x-axis and i is y-axis
                if(fillCords == null) {
                    this.renderSprite(gridSquare, "SYSTEM: Grid_Tile", this.colors[0], this.grid, false);
                }else{
                    for (Coordinate coord:fillCords) {

                        match = ((x == coord.x) && (y == coord.y));
                        if (match){
                            this.coords.add(coord);
                            renderColor = coord.color;
                            break;
                        }
                        //More Debug stuff
//                        System.out.println(coord.x + ":" + x);
//                        System.out.println(coord.y + ":" + y);
//                        System.out.println(match);
//                        System.out.println();
                    }
                    this.renderSprite(gridSquare, "SYSTEM: Grid_Tile", renderColor, this.grid, match);
                    renderColor = Color.GRAY;
                    //^resets 'renderColor'
                }
            }
        }
        this.pack();
    }

    public void clearGrid(){
        Component[] compList = this.grid.getComponents();
        //  this.grid.removeAll();
        //^^ works but im using the other method bc i can delete certain tiles for future purposes. Currently, im clearing everything
        //https://stackoverflow.com/questions/38349445/how-to-delete-all-components-in-a-jpanel-dynamically
        for (Component component: compList) {
            if (component.getName().contains("SYSTEM: Grid_Tile")){
                this.grid.remove(component);
            }
        }
        this.grid.revalidate();
        this.grid.repaint();
    }


    public void addToGrid(Coordinate[] fillCords){
        boolean dupe = false;
        int changes = 0;
        //1. get the current filled spaces and their data
        //2. validate the coords and merge/delete any if necessary
        //2. call setGrid and add the new fill coords


        for (Coordinate newCoord: fillCords) {

            for (Coordinate storedCoord:this.coords) {
                if ((newCoord.x == storedCoord.x) && (newCoord.y == storedCoord.y)){
                    dupe = true;
                    break;
                }
            }

            if (!dupe){
                this.coords.add(newCoord);
                changes++;
            }else{
                dupe = false;
            }
        }

//        System.out.println();
//        for (Coordinate stored: this.coords) {
//            System.out.println(stored.getCoordinate());
//        }
        if (changes > 0) {
            this.setGrid(this.coords.toArray(new Coordinate[0]));
        }
    }
}
