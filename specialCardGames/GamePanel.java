package specialCardGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class GamePanel extends JPanel implements ActionListener {

    private Image backGround = null;

    // Labels for all of the different cards
    private JLabel dealerLabel, redBlackLabel, highLowLabel,
            inOutLabel, suitLabel, randomLabel, pointsLabel;

    // ImageIcons for all of the cards
    private ImageIcon dealerCard , redBlackCard, highLowCard,
            inOutCard, suitCard, randomCard;

    // Creates the buttons for the usersChoicePanel
    private JButton redButton, blackButton;

    private JButton higherButton, lowerButton, hiLowEqualButton;

    private JButton insideButton, outsideButton, inOutEqualButton;

    private JButton spadesButton, heartsButton, clubsButton, diamondsButton;

    private JButton twoButton, threeButton, fourButton, fiveButton, sixButton,
            sevenButton, eightButton, nineButton, tenButton,
            jackButton, queenButton, kingButton, aceButton;

    private GameLogic logic;

    private final int BUTTONS_X_VALUE = 1;

    private final int BUTTONS_Y_VALUE = 1;

    private final int CARDS_X_VALUE = 0;

    private final int CARDS_Y_VALUE = 0;


    /******************************************************************
     * default Constructor for the game panel.
     *****************************************************************/
    public GamePanel() {

        logic = new GameLogic();

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height - 200;

        System.out.println(screenHeight);
        System.out.println(screenWidth);

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

        // initialize the buttons
        redButton = new JButton("Red");
        blackButton = new JButton("Black");

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

        // add action listeners to the buttons
        redButton.addActionListener(this);
        blackButton.addActionListener(this);

        higherButton.addActionListener(this);
        lowerButton.addActionListener(this);
        hiLowEqualButton.addActionListener(this);

        insideButton.addActionListener(this);
        outsideButton.addActionListener(this);
        inOutEqualButton.addActionListener(this);

        spadesButton.addActionListener(this);
        heartsButton.addActionListener(this);
        clubsButton.addActionListener(this);
        diamondsButton.addActionListener(this);

        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        tenButton.addActionListener(this);
        jackButton.addActionListener(this);
        queenButton.addActionListener(this);
        kingButton.addActionListener(this);
        aceButton.addActionListener(this);

        //initialize the points label
        pointsLabel = new JLabel("Players points: 0"); ///FIX ME
        pointsLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        // Create one JPanel for the first stage of the game
        JPanel firstStage = new JPanel(new GridBagLayout());
//        firstStage.setPreferredSize(new Dimension(screenWidth, screenHeight));

        // --------------------------------------------------------------------------------

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 8;

        // Adding the cards
        c.gridx = CARDS_X_VALUE;
        c.gridy = CARDS_Y_VALUE;
        firstStage.add(dealerLabel, c);

        // First questions card
        c.gridx = CARDS_X_VALUE + 1;
        firstStage.add(redBlackLabel, c);
        redBlackLabel.setVisible(false);

        // Second question's card
        c.gridx = CARDS_X_VALUE + 2;
        firstStage.add(highLowLabel, c);
        highLowLabel.setVisible(false);

        // Third question's card
        c.gridx = CARDS_X_VALUE + 3;
        firstStage.add(inOutLabel, c);
        inOutLabel.setVisible(false);

        // Fourth question's card
        c.gridx = CARDS_X_VALUE + 4;
        c.gridwidth = 2;
        firstStage.add(suitLabel, c);
        suitLabel.setVisible(false);

        // Fifth question's card
        c.gridx = CARDS_X_VALUE + 6;
        c.gridwidth = 3;
        firstStage.add(randomLabel, c);
        randomLabel.setVisible(false);

        // --------------------------------------------------------------------------------

        // First questions buttons
        c.gridheight = 2;
        c.gridwidth = 1;
        c.gridx = BUTTONS_X_VALUE;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(redButton, c);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(blackButton, c);

        // Second questions buttons
        c.gridheight = 1;
        c.gridx = BUTTONS_X_VALUE + 1;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(higherButton, c);
//        higherButton.setVisible(false);
        higherButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(lowerButton, c);
//        lowerButton.setVisible(false);
        lowerButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(hiLowEqualButton, c);
//        hiLowEqualButton.setVisible(false);
        hiLowEqualButton.setEnabled(false);

        // Third questions buttons
        c.gridx = BUTTONS_X_VALUE + 2;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(insideButton, c);
//        insideButton.setVisible(false);
        insideButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(outsideButton, c);
//        outsideButton.setVisible(false);
        outsideButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(inOutEqualButton, c);
//        inOutEqualButton.setVisible(false);
        inOutEqualButton.setEnabled(false);

        // Fourth Questions buttons
        c.gridheight = 2;
        c.gridx = BUTTONS_X_VALUE + 3;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(spadesButton, c);
//        spadesButton.setVisible(false);
        spadesButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(heartsButton, c);
//        heartsButton.setVisible(false);
        heartsButton.setEnabled(false);

        c.gridx = BUTTONS_X_VALUE + 4;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(clubsButton, c);
//        clubsButton.setVisible(false);
        clubsButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(diamondsButton, c);
//        diamondsButton.setVisible(false);
        diamondsButton.setEnabled(false);

        // Fifth Questions buttons
        c.gridheight = 1;
        c.gridx = BUTTONS_X_VALUE + 5;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(twoButton, c);
//        twoButton.setVisible(false);
        twoButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(fiveButton, c);
//        fiveButton.setVisible(false);
        fiveButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(eightButton, c);
//        eightButton.setVisible(false);
        eightButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(jackButton, c);
//        jackButton.setVisible(false);
        jackButton.setEnabled(false);

        c.gridx = BUTTONS_X_VALUE + 6;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(threeButton, c);
//        threeButton.setVisible(false);
        threeButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(sixButton, c);
//        sixButton.setVisible(false);
        sixButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(nineButton, c);
//        nineButton.setVisible(false);
        nineButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(queenButton, c);
//        queenButton.setVisible(false);
        queenButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 4;
        firstStage.add(aceButton, c);
//        aceButton.setVisible(false);
        aceButton.setEnabled(false);

        c.gridx = BUTTONS_X_VALUE + 7;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(fourButton, c);
//        fourButton.setVisible(false);
        fourButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(sevenButton, c);
//        sevenButton.setVisible(false);
        sevenButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(tenButton, c);
//        tenButton.setVisible(false);
        tenButton.setEnabled(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(kingButton, c);
//        kingButton.setVisible(false);
        kingButton.setEnabled(false);

        // --------------------------------------------------------------------------------

        //make the panel transparent
        firstStage.setOpaque(false);

        // Place the panel in the frame
        add(firstStage, BorderLayout.CENTER);
//        add(firstStage);


//        //create 3 panels for points, cards, leader board
//        JPanel cardsPanel = new JPanel();
//        JPanel pointsPanel = new JPanel();
//        JPanel usersChoicePanel = new JPanel();
//
//
//        //set the size of points panel to quarter of the screen
//        pointsPanel.setPreferredSize(new Dimension(screenWidth/6, screenHeight /4));
//        //pointsPanel.setPreferredSize(new Dimension(400, 200));
//
//
//        //set the size of the cards panel to half of the screen
//        cardsPanel.setPreferredSize(new Dimension(screenWidth / 2, screenHeight /2));
//
//        //set the size of the usersChoicePanel to the length of the screen
//        usersChoicePanel.setPreferredSize(new Dimension(screenWidth, screenHeight / 2));
//
//        // Creating the layout for the card panel
//        cardsPanel.setLayout(new GridLayout(1,6,10,10));
//        //cardsPanel.setLayout(new GridLayout());
//
//        //place the dealers card
//        GridBagConstraints loc = new GridBagConstraints();
//        loc.gridx = 0;
//        loc.gridy = 0;
//        cardsPanel.add(dealerLabel, loc);
//
//        //place the redBlack card
//        loc.gridx = 1;
//        cardsPanel.add(redBlackLabel, loc);
//
//        //place the highLow card
//        loc.gridx = 2;
//        cardsPanel.add(highLowLabel, loc);
//
//
//        //place the inOut card
//        loc.gridx = 3;
//        cardsPanel.add(inOutLabel, loc);
//
//
//        //place the suit card
//        loc.gridx = 4;
//        cardsPanel.add(suitLabel, loc);
//
//
//        //place the random card
//        loc.gridx = 5;
//        cardsPanel.add(randomLabel, loc);
//
//        // Creating the layout for the usersChoicePanel
//        usersChoicePanel.setLayout(new GridLayout(3,5, 10, 10));
//
//        //place the first round's buttons
//        GridBagLayout pos = new GridBagLayout();
//        redButton.setPreferredSize(new Dimension(50,50));
//
//        usersChoicePanel.add(redButton, pos.location(0,0));
//
//        usersChoicePanel.add(blackButton, pos.location(0,1));
//
//        usersChoicePanel.add(higherButton, pos.location(1,0));
//
//        usersChoicePanel.add(lowerButton, pos.location(1,1));
//
//        usersChoicePanel.add(hiLowEqualButton, pos.location(1,2));
//
////        pos.gridx = 2;
////        pos.gridy = 0;
////        usersChoicePanel.add(insideButton, pos);
////
////        pos.gridy = -1;
////        usersChoicePanel.add(outsideButton, pos);
////
////        pos.gridy = -2;
////        usersChoicePanel.add(inOutEqualButton, pos);
////
////        pos.gridx = 3;
////        pos.gridy = 0;
////        usersChoicePanel.add(spadesButton, pos);
////
////        pos.gridy = -1;
////        usersChoicePanel.add(heartsButton, pos);
////
////        pos.gridy = -2;
////        usersChoicePanel.add(clubsButton, pos);
////
////        pos.gridy = -3;
////        usersChoicePanel.add(diamondsButton, pos);
//
//
//
//        // Place pointsLabel on panel
//        pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        pointsPanel.add(pointsLabel, BorderLayout.WEST);
//
//        //make the panels & splitter transparent
//        cardsPanel.setOpaque(false);
//        pointsPanel.setOpaque(false);
//        usersChoicePanel.setOpaque(false);
//
//        add(pointsPanel, BorderLayout.WEST);
//        add(cardsPanel, BorderLayout.NORTH);
//        add(usersChoicePanel, BorderLayout.SOUTH);

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
        Object choice = e.getSource();

        if (choice == redButton || choice == blackButton){
            redBlackLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

//            higherButton.setVisible(true);
//            lowerButton.setVisible(true);
//            hiLowEqualButton.setVisible(true);
            higherButton.setEnabled(true);
            lowerButton.setEnabled(true);
            hiLowEqualButton.setEnabled(true);

            redButton.setEnabled(false);
            blackButton.setEnabled(false);
        }

        if (choice == higherButton || choice == lowerButton ||
                choice == hiLowEqualButton) {
            highLowLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

//            insideButton.setVisible(true);
//            outsideButton.setVisible(true);
//            inOutEqualButton.setVisible(true);
            insideButton.setEnabled(true);
            outsideButton.setEnabled(true);
            inOutEqualButton.setEnabled(true);

            higherButton.setEnabled(false);
            lowerButton.setEnabled(false);
            hiLowEqualButton.setEnabled(false);
        }

        if (choice == insideButton || choice == outsideButton ||
                choice == inOutEqualButton) {
            inOutLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

//            spadesButton.setVisible(true);
//            heartsButton.setVisible(true);
//            clubsButton.setVisible(true);
//            diamondsButton.setVisible(true);
            spadesButton.setEnabled(true);
            heartsButton.setEnabled(true);
            clubsButton.setEnabled(true);
            diamondsButton.setEnabled(true);

            insideButton.setEnabled(false);
            outsideButton.setEnabled(false);
            inOutEqualButton.setEnabled(false);
        }

        if (choice == spadesButton || choice == heartsButton ||
                choice == clubsButton || choice == diamondsButton) {
            suitLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

//            twoButton.setVisible(true);
//            threeButton.setVisible(true);
//            fourButton.setVisible(true);
//            fiveButton.setVisible(true);
//            sixButton.setVisible(true);
//            sevenButton.setVisible(true);
//            eightButton.setVisible(true);
//            nineButton.setVisible(true);
//            tenButton.setVisible(true);
//            jackButton.setVisible(true);
//            queenButton.setVisible(true);
//            kingButton.setVisible(true);
//            aceButton.setVisible(true);
            twoButton.setEnabled(true);
            threeButton.setEnabled(true);
            fourButton.setEnabled(true);
            fiveButton.setEnabled(true);
            sixButton.setEnabled(true);
            sevenButton.setEnabled(true);
            eightButton.setEnabled(true);
            nineButton.setEnabled(true);
            tenButton.setEnabled(true);
            jackButton.setEnabled(true);
            queenButton.setEnabled(true);
            kingButton.setEnabled(true);
            aceButton.setEnabled(true);

            spadesButton.setEnabled(false);
            heartsButton.setEnabled(false);
            clubsButton.setEnabled(false);
            diamondsButton.setEnabled(false);
        }

        if (choice == twoButton || choice == threeButton || choice == fourButton ||
                choice == fiveButton || choice == sixButton || choice == sevenButton ||
                choice == eightButton || choice == nineButton || choice == tenButton ||
                choice == jackButton || choice == queenButton || choice == kingButton ||
                choice == aceButton) {
            randomLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            twoButton.setEnabled(false);
            threeButton.setEnabled(false);
            fourButton.setEnabled(false);
            fiveButton.setEnabled(false);
            sixButton.setEnabled(false);
            sevenButton.setEnabled(false);
            eightButton.setEnabled(false);
            nineButton.setEnabled(false);
            tenButton.setEnabled(false);
            jackButton.setEnabled(false);
            queenButton.setEnabled(false);
            kingButton.setEnabled(false);
            aceButton.setEnabled(false);

        }
    }
}