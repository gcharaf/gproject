package UC.UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import UC.UI.Menu.MainMenu;

/**
 * @author Terry Tan
 * 
 */
public class MainScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;

	/**
	 * @param width
	 * @param height
	 */
	public MainScreen(String label, int width, int height) {
		super(label);

		initialize(width, height);
	}

	/**
	 * @param width
	 * @param height
	 */
	private void initialize(int width, int height) {
		// frame = new JFrame("Unit Control");
		setVisible(true);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setResizable(false);

		MainMenu bar = new MainMenu();
		setJMenuBar(bar);
		setElements(this);
	}

	/**
	 * @param frame
	 */
	private void setElements(JFrame frame) {
		// Container
		container = frame.getContentPane();

		// Panel Center
		JPanel panelCenter = new JPanel();
		container.add(panelCenter, BorderLayout.CENTER);

		// Panel South
		JPanel panelSouth = new JPanel();
		container.add(panelSouth, BorderLayout.SOUTH);
		setPanelSouth(panelSouth);

		// Panel East
		// JPanel panelEast = new JPanel();
		// container.add(panelEast, BorderLayout.EAST);
		// setPanelEast(panelEast);
	}

	/**
	 * 
	 * @param panelEast
	 */
	private void setPanelEast(JPanel panelEast) {
		panelEast.setLayout(null);
		panelEast.setVisible(true);

		// Draw 2D Button
		// JPanel panel2D = new JPanel();
		// panelEast.add(panel2D);
		// JButton draw2DBtn = new JButton("Draw 2D Map");
		// draw2DBtn.addActionListener(new ButtonActionListener(draw2DBtn));
		// draw2DBtn.setLocation(0, 100);
		// panel2D.add(draw2DBtn);

		JButton draw2DBtn = new JButton("Draw 2D Map");
		draw2DBtn.addActionListener(new ButtonActionListener(draw2DBtn));
		panelEast.add(draw2DBtn);
		draw2DBtn.setBounds(50, 60, 50, 60);

		// Draw 3D Button
		// JPanel panel3D = new JPanel();
		// panelEast.add(panel3D);
		// JButton draw3DBtn = new JButton("Draw 3D Map");
		// draw3DBtn.addActionListener(new ButtonActionListener(draw3DBtn));
		// panel3D.add(draw3DBtn);

		JButton draw3DBtn = new JButton("Draw 3D Map");
		draw3DBtn.setBounds(50, 90, 100, 60);
		draw3DBtn.addActionListener(new ButtonActionListener(draw3DBtn));
		// draw2DBtn.setLocation(0, 300);

		panelEast.add(draw3DBtn);

	}

	/**
	 * 
	 * @param panelSouth
	 */
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
	class ButtonActionListener implements ActionListener {
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
