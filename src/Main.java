import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window app = new Window("Awesome window!", new Dimension(700, 500));
        app.setColor(new Color(213, 212, 234), new Color(46, 13, 255));

        Coordinate[] coords = {
                new Coordinate(25, 0),
                new Coordinate(0, 50),
                new Coordinate(50, 50),
        };

        CoordinateCollection coordCollection = new CoordinateCollection(new Dimension(50, 50), coords);
        app.renderItem(coordCollection);
    }

//    static void displayWindow(String name){
//        JFrame jFrame = new JFrame(name);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setMinimumSize(new Dimension(700, 500));
//        jFrame.pack();
//
//        JLabel emptyLabel = new JLabel("HI");
//        jFrame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
//        jFrame.setVisible(true);
//    }
}