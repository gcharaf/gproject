package UC.UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Terry Tan
 *
 */
public class MainScreen {
	
	private JFrame frame;
	private Container container;
	
	/**
	 * @param width
	 * @param height
	 */
	public MainScreen(int width, int height) {
		initialize(width, height);
	}
	
	/**
	 * @param width
	 * @param height
	 */
	private void initialize(int width, int height) {
		frame = new JFrame("Unit Control");
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		setElements(frame);
	}
	
	/**
	 * @param frame
	 */
	private void setElements(JFrame frame) {
		// Container
		container = new Container();
		container = frame.getContentPane();
        
		// Panel Center
		JPanel panelCenter = new JPanel();
		container.add(panelCenter, BorderLayout.CENTER);
		
        // Panel South
		JPanel panelSouth = new JPanel();
		container.add(panelSouth, BorderLayout.SOUTH);
		setPanelSouth(panelSouth);
	}
	
	private void setPanelSouth(JPanel panelSouth) {
		// Left Button
		JButton leftBtn = new JButton("Left button");
		leftBtn.addActionListener(new ButtonActionListener(leftBtn));
		panelSouth.add(leftBtn);
		
		// Right Button
		JButton rightBtn = new JButton("Right button");
		rightBtn.addActionListener(new ButtonActionListener(rightBtn));
		panelSouth.add(rightBtn);
	}
	
	// Button ActionListener
	class ButtonActionListener implements ActionListener{
		private String str;
		
		public ButtonActionListener(JButton btn) {
			str = btn.getText();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(str + " is pressed");
			
		}
		
	}
}
