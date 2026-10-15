//
// This makes 0 sense holy shit.
// 


import java.awt.*;
import java.awt.event.*;
import java.awt.GraphicsEnvironment;

public class GraphicalTesting extends Frame{
    // example taken from: https://www.geeksforgeeks.org/java/what-is-java-awt-graphics/
    /*
    public GraphicalTesting()
    {
        setVisible(true);
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g)
     {
        g.setColor(Color.green);
        g.setXORMode(Color.black);
        g.fillRect(100, 100, 100, 50);
    }

    */


    public static void main(String[] args)
    {
        // DEBUG: 
        System.out.println(GraphicsEnvironment.isHeadless());

        /* Main shi:
        GraphicalTesting frame = new GraphicalTesting();
        Graphics g = frame.getGraphics();
        System.out.println("drawing...");
        g.drawRect(100, 100, 10, 10);
        System.out.println("drawn...");
        */
        
        Frame frame = new Frame("Basic Program");
        Button button = new Button("Click Here");

        button.setBounds(80, 100, 64, 30);

        frame.add(button);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // Using WindowListener for closing the window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}

/* UPDATE:
    Graphics are a pain in the ass because the default openjdk install seems to be headless.
    I daily drive Fedora 44 w/ KDE Plasma, which uses X11, here was the fix:
    - sudo dnf install java-latest-openjdk-devel
    - sudo alternatives --config java
        - Set it to java-latest-openjdk instead of java-25-openjdk, or i guess for other people just whatever other version is available post dnf install
    
    ok thats it :D
*/