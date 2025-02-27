import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system

public class HelloGraphics implements Runnable {
    public JFrame frame;
    public JPanel panel;
    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

   
    class GraphicsPanel extends JPanel {
        public int panelWidth;
        public int panelHeight;
        public int stringWidth;
        public int stringHeight;
        public String outputString;
        @Override
        public void paintComponent(Graphics g) {
            
            // first, we should call the paintComponent method we are
            // overriding in JPanel
            super.paintComponent(g);
            panelWidth = panel.getWidth();
            panelHeight = panel.getHeight();
            outputString = "Hello, Java Graphics World!";
            FontMetrics fontMetrics = g.getFontMetrics();
            stringWidth = fontMetrics.stringWidth(outputString);
            stringHeight = fontMetrics.getAscent();
            Font currentFont = g.getFont();
            Font newFont = new Font("Monospaced",Font.BOLD , currentFont.getSize());
            g.setFont(newFont);
            panel.setForeground(Color.RED);
            panel.setBackground(Color.BLUE);

            
    
            // the Graphics object passed to this method has many methods
            // we can use to draw in the area of the panel, one of which
            // allows us to draw a String at a given x,y position
            g.drawString(outputString, panelWidth /2 - stringWidth / 2, panelHeight /2 - stringHeight / 2);
           
        }
    }
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
    
}
