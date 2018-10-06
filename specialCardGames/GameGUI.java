package specialCardGames;

/**
 * @author jarod
 *
 */
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameGUI
		extends JComponent
{
	public static void main(String[] args)
	{
		JFrame rideTheBus = new JFrame("Ride The Bus");
		GamePanel panel = new GamePanel();
		rideTheBus.setDefaultCloseOperation(3);
		rideTheBus.getContentPane().add(panel);
		rideTheBus.pack();
		rideTheBus.setVisible(true);
	}
}
