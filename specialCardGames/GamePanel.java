package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel {
    private Image backGround = null;

    public GamePanel()
    {
        JPanel superPanel = new JPanel();
        superPanel.setLayout(new GridLayout());
        add(superPanel, "Center");

        changeImage();
        setPreferredSize(new Dimension(1020, 570));
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(this.backGround, 0, 0, null);
    }

    public void changeImage()
    {
        try
        {
            this.backGround = ImageIO.read(getClass().getResource("bG.jpg"));
            repaint();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Couldn't load background");
        }
    }
}
