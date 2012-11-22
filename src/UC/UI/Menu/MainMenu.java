package UC.UI.Menu;

import javax.swing.JMenuBar;

/**
 * @author Terry Tan
 * 
 */
public class MainMenu extends JMenuBar {
	private final String FILE_LABEL = "File";
	private final String DEVICES_LABEL = "Devices";
	
	public MainMenu() {
		super();

		MenuFile file = new MenuFile(FILE_LABEL);
		this.add(file);
		
		MenuDevices devices = new MenuDevices(DEVICES_LABEL);
		this.add(devices);
	}
}