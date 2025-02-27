import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArtProject implements Runnable {
    public JFrame frame;
    public JPanel panel;
public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("ArtProject");
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

            //drawing oval
            g.setColor(Color.CYAN);
            g.drawOval(50, 20, 300, 400);
            g.fillOval(50, 20, 300, 400);
            
            //drawig rectangle
            g.setColor(Color.RED);
            g.drawRect(100, 100, 100, 50);
            g.fillRect(100, 100, 100, 50);

            // drawing arc
            g.setColor(Color.BLUE);
            g.drawArc(150,200,100,100,40,60);
            g.fillArc(150, 200, 100, 100, 40, 60);
            


            g.setColor(Color.BLACK);
            g.drawLine(100, 300, 300, 300);
            int a[] = {250,300, 250 ,300 , 275};
            int b[] = {100, 100, 150, 150, 200};

            //drawing polygon
            g.drawPolygon(a, b, 5);
            g.fillPolygon(a, b, 5);

            

            
           
        }
    }
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }

}
