package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;


public class GamePanel extends JPanel implements ActionListener {

    private Image backGround = null;

    // Labels for all of the different cards
    private JLabel dealerLabel;
    private JLabel redBlackLabel;
    private JLabel highLowLabel;
    private JLabel inOutLabel;
    private JLabel suitLabel;
    private JLabel randomLabel;

    private JLabel pointsLabel;

    // ImageIcons for all of the cards
    private ImageIcon dealerCard;
    private ImageIcon redBlackCard;
    private ImageIcon highLowCard;
    private ImageIcon inOutCard;
    private ImageIcon suitCard;
    private ImageIcon randomCard;

    // Creates the buttons for the usersChoicePanel
    private JButton redButton;
    private JButton blackButton;

    private JButton higherButton;
    private JButton lowerButton;
    private JButton hiLowEqualButton;

    private JButton insideButton;
    private JButton outsideButton;
    private JButton inOutEqualButton;

    private JButton spadesButton;
    private JButton heartsButton;
    private JButton clubsButton;
    private JButton diamondsButton;

    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton tenButton;
    private JButton jackButton;
    private JButton queenButton;
    private JButton kingButton;
    private JButton aceButton;

    private GameLogic logic;


    /******************************************************************
     * default Constructor for the game panel.
     *****************************************************************/
    public GamePanel() {

        logic = new GameLogic();

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height - 200;

        System.out.println(screenHeight);
        System.out.println(screenWidth);

        //create 3 panels for points, cards, leader board
        JPanel cardsPanel = new JPanel();
        JPanel pointsPanel = new JPanel();
        JPanel usersChoicePanel = new JPanel();


        //set the size of points panel to quarter of the screen
        pointsPanel.setPreferredSize(new Dimension(screenWidth/6, screenHeight /4));
        //pointsPanel.setPreferredSize(new Dimension(400, 200));


        //set the size of the cards panel to half of the screen
        cardsPanel.setPreferredSize(new Dimension(screenWidth / 2, screenHeight /2));

        //set the size of the usersChoicePanel to the length of the screen
        usersChoicePanel.setPreferredSize(new Dimension(screenWidth, screenHeight / 2));

        //set preferred size to the size of the screen
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        try {
            //get Card images for display
            dealerCard = new ImageIcon(getClass().getResource("cardImages/small/BackSmall.png"));
            redBlackCard = new ImageIcon(getClass().getResource(logic.cardString(1)));
            highLowCard = new ImageIcon(getClass().getResource(logic.cardString(2)));
            inOutCard = new ImageIcon(getClass().getResource(logic.cardString(3)));
            suitCard = new ImageIcon(getClass().getResource(logic.cardString(4)));
            randomCard = new ImageIcon(getClass().getResource(logic.cardString(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create cards for the cards panel
        dealerLabel = new JLabel(dealerCard);
        redBlackLabel = new JLabel(redBlackCard);
        highLowLabel = new JLabel(highLowCard);
        inOutLabel = new JLabel(inOutCard);
        suitLabel = new JLabel(suitCard);
        randomLabel = new JLabel(randomCard);

        //resize the label to fit the card images
        dealerLabel.setSize(dealerCard.getIconWidth(), dealerCard.getIconHeight());
        redBlackLabel.setSize(redBlackCard.getIconWidth(), redBlackCard.getIconHeight());
        highLowLabel.setSize(highLowCard.getIconWidth(), highLowCard.getIconHeight());
        inOutLabel.setSize(inOutCard.getIconWidth(), inOutCard.getIconHeight());
        suitLabel.setSize(suitCard.getIconWidth(), suitCard.getIconHeight());
        randomLabel.setSize(randomCard.getIconWidth(), randomCard.getIconHeight());

        // Sets the cards to be invisible
        redBlackLabel.setVisible(true);
        highLowLabel.setVisible(true);
        inOutLabel.setVisible(true);
        suitLabel.setVisible(true);
        randomLabel.setVisible(true);

        // Creating the layout for the card panel
        cardsPanel.setLayout(new GridLayout(1,6,10,10));
        //cardsPanel.setLayout(new GridLayout());

        //place the dealers card
        GridBagConstraints loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        cardsPanel.add(dealerLabel, loc);

        //place the redBlack card
        loc.gridx = 1;
        cardsPanel.add(redBlackLabel, loc);

        //place the highLow card
        loc.gridx = 2;
        cardsPanel.add(highLowLabel, loc);


        //place the inOut card
        loc.gridx = 3;
        cardsPanel.add(inOutLabel, loc);


        //place the suit card
        loc.gridx = 4;
        cardsPanel.add(suitLabel, loc);


        //place the random card
        loc.gridx = 5;
        cardsPanel.add(randomLabel, loc);

        // initialize the buttons
        redButton = new JButton("Red Button");
        blackButton = new JButton("Black Button");

        higherButton = new JButton("Higher");
        lowerButton = new JButton("Lower");
        hiLowEqualButton = new JButton("Equal");

        insideButton = new JButton("Inside");
        outsideButton = new JButton("Outside");
        inOutEqualButton = new JButton("Equal");

        spadesButton = new JButton("Spades");
        heartsButton = new JButton("Hearts");
        clubsButton = new JButton("Clubs");
        diamondsButton = new JButton("Diamonds");

        twoButton = new JButton("Two");
        threeButton = new JButton("Three");
        fourButton = new JButton("Four");
        fiveButton = new JButton("Five");
        sixButton = new JButton("Six");
        sevenButton = new JButton("Seven");
        eightButton = new JButton("Eight");
        nineButton = new JButton("Nine");
        tenButton = new JButton("Ten");
        jackButton = new JButton("Jack");
        queenButton = new JButton("Queen");
        kingButton = new JButton("King");
        aceButton = new JButton("Ace");

        // Creating the layout for the card panel
        usersChoicePanel.setLayout(new GridLayout(4,10, 10, 10));

        //place the first round's buttons
        GridBagConstraints pos = new GridBagConstraints();
        //redButton.setPreferredSize(new Dimension(50,50));
        pos.gridx = 0;
        pos.gridy = 0;
        usersChoicePanel.add(redButton, pos);

        pos.gridy = -1;
        usersChoicePanel.add(blackButton, pos);

        pos.gridx = 1;
        pos.gridy = 0;
        usersChoicePanel.add(higherButton, pos);

        pos.gridy = -1;
        usersChoicePanel.add(lowerButton, pos);

        pos.gridy = -2;
        usersChoicePanel.add(hiLowEqualButton, pos);

        pos.gridx = 2;
        pos.gridy = 0;
        usersChoicePanel.add(insideButton, pos);

        pos.gridy = -1;
        usersChoicePanel.add(outsideButton, pos);

        pos.gridy = -2;
        usersChoicePanel.add(inOutEqualButton, pos);

        pos.gridx = 3;
        pos.gridy = 0;
        usersChoicePanel.add(spadesButton, pos);

        pos.gridy = -1;
        usersChoicePanel.add(heartsButton, pos);

        pos.gridy = -2;
        usersChoicePanel.add(clubsButton, pos);

        pos.gridy = -3;
        usersChoicePanel.add(diamondsButton, pos);



        //initialize the points label and place it on pointsPanel
        pointsLabel = new JLabel("Players points: 0"); ///FIX ME
        pointsLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));
        pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointsPanel.add(pointsLabel, BorderLayout.WEST);

        //make the panels & splitter transparent
        cardsPanel.setOpaque(false);
        pointsPanel.setOpaque(false);
        usersChoicePanel.setOpaque(false);

        add(pointsPanel, BorderLayout.WEST);
        add(cardsPanel, BorderLayout.NORTH);
        add(usersChoicePanel, BorderLayout.SOUTH);

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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.backGround, 0, 0, null);
    }

    /******************************************************************
     * This method reads the background image from the directory
     * before it displays it on the panel.
     * @throws IOException if the image can't be loaded
     *****************************************************************/
    private void changeImage() {
        try {
            this.backGround = ImageIO.read(getClass().getResource(
                    "bG.jpg"));
            repaint();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Couldn't load background");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}