package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel {
    private Image backGround = null;

    /******************************************************************
     * default Constructor for the game panel.
     *****************************************************************/
    public GamePanel()
    {
        JPanel superPanel = new JPanel();
        superPanel.setLayout(new GridLayout());
        add(superPanel, "Center");

        //get the image from the directory
        changeImage();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    /******************************************************************
     * Overriding the paintComponent method from the Component Class
     * to set the wallpaper of the game.
     * @param g the Graphics object to protect
     *****************************************************************/
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(this.backGround, 0, 0, null);
    }

    /******************************************************************
     * This method reads the background image from the directory
     * before it displays it on the panel.
     * @throws IOException if the image can't be loaded
     *****************************************************************/
    public void changeImage()
    {
        try
        {
            this.backGround = ImageIO.read(getClass().getResource(
                    "bG.jpg"));
            repaint();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this,
                    "Couldn't load background");
        }
    }
}