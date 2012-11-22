package UC.UI.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author Terry Tan
 * 
 */
public class MenuFile extends JMenu implements MenuTemplate {
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem exitItem;

	private static String NEW_ITEM = "New";
	private static String OPEN_ITEM = "Open";
	private static String EXIT_ITEM = "Exit";

	public MenuFile(String label) {
		super(label);
		initialize();
	}

	@Override
	public void initialize() {
		newItem = new JMenuItem(NEW_ITEM);
		add(newItem);

		openItem = new JMenuItem(OPEN_ITEM);
		add(openItem);

		exitItem = new JMenuItem(EXIT_ITEM);
		add(exitItem);
		
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New is pressed");
			}
		});
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Open is pressed");
			}
		});
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit is pressed");
			}
		});
	}

	@Override
	public void active() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inactive() {
		// TODO Auto-generated method stub

	}
}