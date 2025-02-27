import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {
    private String toDisplay;
    private JButton resetButton;
    private int clickCounter = 0;
    private JPanel panel;
/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MousePressCounter");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resetButton = new JButton("Reset");
        frame.add(resetButton);
      

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		 panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
                toDisplay = "Clicks : " + clickCounter;
				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

               
				g.drawString(toDisplay, xStart, yStart);
                
                
                

			}
            
		};
        panel.add(resetButton);
		frame.add(panel);
        resetButton.addActionListener(this);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    @Override 
    public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked: " + e);
        clickCounter++;
        panel.repaint();

	}
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == resetButton){
            clickCounter = 0 ;
            panel.repaint();
        }
    }
    public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}

}
