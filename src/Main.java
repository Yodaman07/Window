import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //64 * 8 for scaled graphics (maybe not)
        Window app = new Window("Awesome window!", new Dimension(256, 256));
        int tileSize = 32;

        app.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        app.initGrid(tileSize);
        app.setGrid();
        Scanner scanner =  new Scanner(System.in);
        if (scanner.nextInt() == 1){
            System.out.println("1");

            int defaultTileSize = app.tileSize;
            int defaultCols = app.defaultSize.width/defaultTileSize;
            int defaultRows = app.defaultSize.height/defaultTileSize;
//            System.out.println(app.getHeight()/defaultRows + " : " + app.defaultSize.height + ";" + app.getHeight());
//            System.out.println(app.getWidth()/defaultCols + " : " + app.defaultSize.width + ";" + app.getWidth());


            //Fix to maintain ratio
            if (app.getWidth() >= app.getHeight()){
                int w = app.getWidth();
                app.initGrid(tileSize);
                app.setSize(w, w);
                System.out.println(w);
            }else if(app.getWidth() <= app.getHeight()){
                int h = app.getHeight();
                app.initGrid(tileSize);
                app.setSize(h, h);
                System.out.println(h);
            }

            app.clearGrid();
//            app.setGrid();
        }
    }
}