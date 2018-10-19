package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GamePanel extends JPanel implements ActionListener {
    private Image backGround = null;
    private JLabel cardFaceDown;
    private ImageIcon dealerCard;
    private JLabel cardFlipped;
    private ImageIcon lastCard;
    private JLabel pointsLabel;


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
        //pointsPanel.setPreferredSize(new Dimension(400, 200));


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

        //get Card images for display
        dealerCard = new ImageIcon(getClass().getResource("cardImages/small/BackSmall.png"));
        lastCard = new ImageIcon(getClass().getResource("cardImages/small/AH.png"));

        //create cards for the cards panel
        cardFaceDown = new JLabel(dealerCard);
        cardFlipped = new JLabel(lastCard);

        //resize the label to fit the card images
        cardFaceDown.setSize(dealerCard.getIconWidth(),dealerCard.getIconHeight());
        cardFlipped.setSize(lastCard.getIconWidth(),dealerCard.getIconHeight());


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


        //initialize the points label and place it on pointsPanel
        pointsLabel = new JLabel("Players points: 0"); ///FIX ME
        pointsLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));
        pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointsPanel.add(pointsLabel, BorderLayout.CENTER);

        //make the panels & splitter transparent
        cardsPanel.setOpaque(false);
        pointsPanel.setOpaque(false);
        splitPane.setOpaque(false);

        splitPane.resetToPreferredSizes();

        //make the splitPane not expandable
        splitPane.setOneTouchExpandable(false);
        splitPane.setBorder(null);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}