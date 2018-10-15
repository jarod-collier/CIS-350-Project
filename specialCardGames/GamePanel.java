package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel {
    private Image backGround = null;
    private Button cardFaceDown;
    private Button cardFlipped;


    /******************************************************************
     * default Constructor for the game panel.
     *****************************************************************/
    public GamePanel()
    {

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        //create 3 panels for points, cards, leader board
        //TODO: create leaderBoard panel
        JPanel cardsPanel = new JPanel();
        JPanel pointsPanel = new JPanel();





        //set the size of points panel to quarter of the screen
        pointsPanel.setPreferredSize(new Dimension(screenWidth/4, screenHeight));

        //set the size of the cards panel to half of the screen
        cardsPanel.setPreferredSize(new Dimension(screenWidth/2,screenHeight));

        //create a splitter to place the panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //add the panels to the splitter
        splitPane.setLeftComponent(pointsPanel);
        splitPane.setRightComponent(cardsPanel);


        //make the splitter expandable
        splitPane.setOneTouchExpandable(true);

        //set preferred size to the size of the screen
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        //create buttons for the cards panel
        cardFaceDown = new Button("face down card");

        cardFlipped = new Button("flipped card");
        cardsPanel.setLayout(new GridLayout());

        //place the card face down button
        GridBagConstraints loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        cardsPanel.add(cardFaceDown, loc);


        //place the card flipped button
        loc.gridx = 1;
        loc.gridy = 0;
        cardsPanel.add(cardFlipped, loc);

        //make the panels & splitter transparent
        cardsPanel.setOpaque(false);
        pointsPanel.setOpaque(false);
        splitPane.setOpaque(false);

        splitPane.resetToPreferredSizes();
        add(splitPane);

        //get the image from the directory
        changeImage();

        //set the size of the superPanel
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