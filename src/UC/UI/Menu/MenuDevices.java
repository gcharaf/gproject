package UC.UI.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author Terry Tan
 * 
 */
public class MenuDevices extends JMenu implements MenuTemplate {
	private JMenuItem detectItem;
	private JMenuItem newItem1;
	private JMenuItem newItem2;

	private static String DETECT_ITEM = "Detect Devices";
	private static String NEW_ITEM1 = "Not implement yet...";
	private static String NEW_ITEM2 = "Not implement yet...";

	public MenuDevices(String label) {
		super(label);
		initialize();
	}

	@Override
	public void initialize() {
		detectItem = new JMenuItem(DETECT_ITEM);
		add(detectItem);

		newItem1 = new JMenuItem(NEW_ITEM1);
		add(newItem1);

		newItem2 = new JMenuItem(NEW_ITEM2);
		add(newItem2);

		detectItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Detect is pressed");
			}
		});
		
		newItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Not implement yet...");
			}
		});
		
		newItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Not implement yet...");
			}
		});
		
		// For the first time, there is no device menu item activated
		inactive();
	}

	@Override
	public void active() {
		newItem1.setEnabled(true);
		newItem2.setEnabled(true);
	}

	@Override
	public void inactive() {
		newItem1.setEnabled(false);
		newItem2.setEnabled(false);
	}
}