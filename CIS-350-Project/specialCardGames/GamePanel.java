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
            inOutLabel, suitLabel, randomLabel, pointsLabel, questionLabel, leaderBoard;

    // First stage ImageIcons for all of the cards
    private ImageIcon dealerCard, redBlackCard, highLowCard,
            inOutCard, suitCard, randomCard;

    private ImageIcon faceDownCard;

    // Creates the color buttons
    private JButton redButton, blackButton;

    // Creates the highLow buttons
    private JButton higherButton, lowerButton, hiLowEqualButton;

    // Creates the inOutButtons
    private JButton insideButton, outsideButton, inOutEqualButton;

    // Creates the suits buttons
    private JButton spadesButton, heartsButton, clubsButton, diamondsButton;

    // Creates the buttons for the numbers
    private JButton twoButton, threeButton, fourButton, fiveButton, sixButton,
            sevenButton, eightButton, nineButton, tenButton,
            jackButton, queenButton, kingButton, aceButton;

    // First stage JButtons
    private JButton[] colors, highLow, inOut, suits, numbers;

    // Second Stage Cards
    private JLabel[] blankCards;

    // Second Stage buttons of which path to take
    private JButton chosenPathHigh1, chosenPathHigh2, chosenPathHigh3, chosenPathHigh4, chosenPathHigh5,
            chosenPathHigh6, chosenPathHigh7, chosenPathLow1, chosenPathLow2, chosenPathLow3,
            chosenPathLow4, chosenPathLow5, chosenPathLow6, chosenPathLow7;

    // Button array that holds all of the Second Stage Buttons
    private JButton[] upPath, downPath;

    private GameLogic logic;

    private JPanel firstStage, secondStage, pointsPanel, questionPanel, leaderBoardPanel;

    // Final variables for first stage
    private final int BUTTONS_X_VALUE = 1, BUTTONS_Y_VALUE = 2, CARDS_X_VALUE = 0, CARDS_Y_VALUE = 1;

    private final int X_CARD_POSITION = 0, Y_CARD_POSITION = 0;


    /******************************************************************
     * default Constructor for the game panel.
     *****************************************************************/
    public GamePanel() {

        logic = new GameLogic();

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        //set preferred size to the size of the screen
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Creates the buttons and Labels for stage One
        stageOneButtonsAndLabels();

        //initialize the points label
        pointsLabel = new JLabel("Players points: " + logic.getScore());
        pointsLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        //initialize the question label
        questionLabel = new JLabel("What's the color of the card?");
        questionLabel.setFont(new Font("Cooper Black", Font.BOLD, 40));
        questionLabel.setForeground(Color.RED);

        //initialize the leader board
        leaderBoard = new JLabel("Leader Board is here");

        // Create one JPanel for the first stage of the game
        firstStage = new JPanel(new GridBagLayout());
        firstStage.setPreferredSize(new Dimension(screenWidth, screenHeight / 2));

        // Create one JPanel for the second stage of the game
        secondStage = new JPanel(new GridBagLayout());
        secondStage.setPreferredSize(new Dimension(screenWidth, screenHeight));

        // Sets layout of how cards are set
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 8;


        // Adding the cards of First Stage
        placingCards(c);

        // Question buttons for first stage
        placingQuestionButtons(c);

        // Second Stage creations
        blankCards = new JLabel[16];
        faceDownCard = new ImageIcon(getClass().getResource("cardImages/small/BackSmall.png"));
        for (int card = 0; card < blankCards.length; card++) {
            blankCards[card] = new JLabel(faceDownCard);
        }

        // Arrays to hold the path buttons
        upPath = new JButton[6];
        downPath = new JButton[6];

        // Create up path buttons and add to the array
        chosenPathHigh1 = new JButton("Go High");
        chosenPathHigh2 = new JButton("Go High");
        chosenPathHigh3 = new JButton("Go High");
        chosenPathHigh4 = new JButton("Go High");
        chosenPathHigh5 = new JButton("Go High");
        chosenPathHigh6 = new JButton("Go High");
        upPath[0] = chosenPathHigh1;
        upPath[1] = chosenPathHigh2;
        upPath[2] = chosenPathHigh3;
        upPath[3] = chosenPathHigh4;
        upPath[4] = chosenPathHigh5;
        upPath[5] = chosenPathHigh6;

        // Create down path buttons and add to the array
        chosenPathLow1 = new JButton("Go Low");
        chosenPathLow2 = new JButton("Go Low");
        chosenPathLow3 = new JButton("Go Low");
        chosenPathLow4 = new JButton("Go Low");
        chosenPathLow5 = new JButton("Go Low");
        chosenPathLow6 = new JButton("Go Low");
        downPath[0] = chosenPathLow1;
        downPath[1] = chosenPathLow2;
        downPath[2] = chosenPathLow3;
        downPath[3] = chosenPathLow4;
        downPath[4] = chosenPathLow5;
        downPath[5] = chosenPathLow6;

        // Create up path actionListeners
        for (JButton upPath : upPath) {
            upPath.addActionListener(this);
        }

        // Create down path actionListeners
        for (JButton downPath : downPath) {
            downPath.addActionListener(this);
        }

        // placing the cards
        // ------------------------------------------------------------------------------
        // column 1
        c.gridwidth = 1;
        c.gridheight = 4;
        c.ipady = 8;
        c.gridx = X_CARD_POSITION;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[0], c);

        // Column 2
        c.gridheight = 3;
        c.gridx = X_CARD_POSITION + 1;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[1], c);

        c.gridy = Y_CARD_POSITION + 1;
        secondStage.add(blankCards[2], c);

        // Column 3
        c.gridheight = 2;
        c.gridx = X_CARD_POSITION + 2;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[3], c);

        c.gridy = Y_CARD_POSITION + 1;
        secondStage.add(blankCards[4], c);

        c.gridy = Y_CARD_POSITION + 2;
        secondStage.add(blankCards[5], c);

        // Column 4
        c.gridheight = 1;
        c.gridx = X_CARD_POSITION + 3;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[6], c);

        c.gridy = Y_CARD_POSITION + 1;
        secondStage.add(blankCards[7], c);

        c.gridy = Y_CARD_POSITION + 2;
        secondStage.add(blankCards[8], c);

        c.gridy = Y_CARD_POSITION + 3;
        secondStage.add(blankCards[9], c);

        // Column 5
        c.gridheight = 2;
        c.gridx = X_CARD_POSITION + 4;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[10], c);

        c.gridy = Y_CARD_POSITION + 1;
        secondStage.add(blankCards[11], c);

        c.gridy = Y_CARD_POSITION + 2;
        secondStage.add(blankCards[12], c);

        // Column 6
        c.gridheight = 3;
        c.gridx = X_CARD_POSITION + 5;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[13], c);

        c.gridy = Y_CARD_POSITION + 1;
        secondStage.add(blankCards[14], c);

        // Column 7
        c.gridheight = 4;
        c.gridx = X_CARD_POSITION + 6;
        c.gridy = Y_CARD_POSITION;
        secondStage.add(blankCards[15], c);

        // Adding the path buttons first column
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = X_CARD_POSITION;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh1, c);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow1, c);

        // Second Column
        c.gridx = X_CARD_POSITION + 1;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh2, c);
        chosenPathHigh2.setVisible(false);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow2, c);
        chosenPathLow2.setVisible(false);

        // Third Column
        c.gridx = X_CARD_POSITION + 2;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh3, c);
        chosenPathHigh3.setVisible(false);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow3, c);
        chosenPathLow3.setVisible(false);

        // Fourth Column
        c.gridx = X_CARD_POSITION + 3;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh4, c);
        chosenPathHigh4.setVisible(false);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow4, c);
        chosenPathLow4.setVisible(false);

        // Fifth Column
        c.gridx = X_CARD_POSITION + 4;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh5, c);
        chosenPathHigh5.setVisible(false);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow5, c);
        chosenPathLow5.setVisible(false);

        // Sixth Column
        c.gridx = X_CARD_POSITION + 5;
        c.gridy = Y_CARD_POSITION + 4;
        secondStage.add(chosenPathHigh6, c);
        chosenPathHigh6.setVisible(false);

        c.gridy = Y_CARD_POSITION + 5;
        secondStage.add(chosenPathLow6, c);
        chosenPathLow6.setVisible(false);

        // ------------------------------------------------------------------------------

        // Adding the points label to the points panel
        pointsPanel = new JPanel();
        pointsPanel.add(pointsLabel);

        // Adding the question label to the question panel
        questionPanel = new JPanel();
        questionPanel.add(questionLabel);

        // Adding the leaderboard label to the leaderboard panel
        leaderBoardPanel = new JPanel();
        leaderBoardPanel.add(leaderBoard);

        // Add the question label to the main panel
        add(questionPanel, BorderLayout.PAGE_START);

        // Add the cards panel to the main panel
        add(firstStage, BorderLayout.CENTER);

        // Add the leaderBoard label to the main panel
        // add(leaderBoardPanel, BorderLayout.AFTER_LAST_LINE);

        // Add the points label to the main panel
        add(pointsPanel, BorderLayout.SOUTH);

        // Add the second stage to the main panel
        add(secondStage, BorderLayout.CENTER);

        //make all the panels transparent
        firstStage.setOpaque(false);
        questionPanel.setOpaque(false);
        pointsPanel.setOpaque(false);
        secondStage.setOpaque(false);
        secondStage.setVisible(false);

        //get the image from the directory
        changeImage();

        //set the size of the superPanel
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    private void stageOneButtonsAndLabels() {

        // Arrays for different buttons
        colors = new JButton[2];
        highLow = new JButton[3];
        inOut = new JButton[3];
        suits = new JButton[4];
        numbers = new JButton[13];

        try {
            //get Card images for display
            dealerCard = new ImageIcon(getClass().getResource("cardImages/big/BackBig.png"));
            redBlackCard = new ImageIcon(getClass().getResource(logic.bigCardString(1)));
            highLowCard = new ImageIcon(getClass().getResource(logic.bigCardString(2)));
            inOutCard = new ImageIcon(getClass().getResource(logic.bigCardString(3)));
            suitCard = new ImageIcon(getClass().getResource(logic.bigCardString(4)));
            randomCard = new ImageIcon(getClass().getResource(logic.bigCardString(5)));
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

        // initialize the color buttons
        redButton = new JButton("Red");
        blackButton = new JButton("Black");
        colors[0] = redButton;
        colors[1] = blackButton;

        // Initialize the highLow buttons
        higherButton = new JButton("Higher");
        lowerButton = new JButton("Lower");
        hiLowEqualButton = new JButton("Equal");
        highLow[0] = higherButton;
        highLow[1] = lowerButton;
        highLow[2] = hiLowEqualButton;

        // Initialize the inOut buttons
        insideButton = new JButton("Inside");
        outsideButton = new JButton("Outside");
        inOutEqualButton = new JButton("Equal");
        inOut[0] = insideButton;
        inOut[1] = outsideButton;
        inOut[2] = inOutEqualButton;

        // Initialize the suit buttons
        spadesButton = new JButton("Spades");
        heartsButton = new JButton("Hearts");
        clubsButton = new JButton("Clubs");
        diamondsButton = new JButton("Diamonds");
        suits[0] = spadesButton;
        suits[1] = heartsButton;
        suits[2] = clubsButton;
        suits[3] = diamondsButton;

        // Initialize the number buttons
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
        numbers[0] = twoButton;
        numbers[1] = threeButton;
        numbers[2] = fourButton;
        numbers[3] = fiveButton;
        numbers[4] = sixButton;
        numbers[5] = sevenButton;
        numbers[6] = eightButton;
        numbers[7] = nineButton;
        numbers[8] = tenButton;
        numbers[9] = jackButton;
        numbers[10] = queenButton;
        numbers[11] = kingButton;
        numbers[12] = aceButton;

        // add action listeners to the color buttons
        for (JButton color : colors) {
            color.addActionListener(this);
        }
        // Add action listeners to the highLow buttons
        for (JButton aHighLow : highLow) {
            aHighLow.addActionListener(this);
        }

        // Add action listeners to the inOut buttons
        for (JButton anInOut : inOut) {
            anInOut.addActionListener(this);
        }

        // Add action listeners to the suit buttons
        for (JButton suit : suits) {
            suit.addActionListener(this);
        }

        // Add action listeners to the number buttons
        for (JButton number : numbers) {
            number.addActionListener(this);
        }
    }

    private void placingCards(GridBagConstraints c) {
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
    }

    private void placingQuestionButtons(GridBagConstraints c) {

        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = BUTTONS_X_VALUE;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(redButton, c);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(blackButton, c);


        // Second questions buttons
        c.gridx = BUTTONS_X_VALUE + 1;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(higherButton, c);
        higherButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(lowerButton, c);
        lowerButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(hiLowEqualButton, c);
        hiLowEqualButton.setVisible(false);

        // Third questions buttons
        c.gridx = BUTTONS_X_VALUE + 2;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(insideButton, c);
        insideButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(outsideButton, c);
        outsideButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(inOutEqualButton, c);
        inOutEqualButton.setVisible(false);

        // Fourth Questions buttons
        c.gridx = BUTTONS_X_VALUE + 3;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(spadesButton, c);
        spadesButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(heartsButton, c);
        heartsButton.setVisible(false);

        c.gridx = BUTTONS_X_VALUE + 4;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(clubsButton, c);
        clubsButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(diamondsButton, c);
        diamondsButton.setVisible(false);

        // Fifth Questions buttons
        c.gridx = BUTTONS_X_VALUE + 5;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(twoButton, c);
        twoButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(fiveButton, c);
        fiveButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(eightButton, c);
        eightButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(jackButton, c);
        jackButton.setVisible(false);

        c.gridx = BUTTONS_X_VALUE + 6;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(threeButton, c);
        threeButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(sixButton, c);
        sixButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(nineButton, c);
        nineButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(queenButton, c);
        queenButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 4;
        firstStage.add(aceButton, c);
        aceButton.setVisible(false);

        c.gridx = BUTTONS_X_VALUE + 7;
        c.gridy = BUTTONS_Y_VALUE;
        firstStage.add(fourButton, c);
        fourButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 1;
        firstStage.add(sevenButton, c);
        sevenButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 2;
        firstStage.add(tenButton, c);
        tenButton.setVisible(false);

        c.gridy = BUTTONS_Y_VALUE + 3;
        firstStage.add(kingButton, c);
        kingButton.setVisible(false);
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
    /******************************************************************
     * Creates all of the events whenever a user clicks on something
     * @param e - the event of the user clicking something
     *****************************************************************/
    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();
        pointsLabel.setText("Players points: " + logic.getScore());

        // Checks if user clicks on red or black
        clickingColor(choice);

        // Checks if user clicked higher or lower
        clickingHighOrLow(choice);

        // Checks if user clicked in or out
        clickingInOrOut(choice);

        // Checks what suit the user picked
        clickingSuit(choice);

        // Checks what number the user picked
        clickingNumber(choice);

        // Checks if user wants to go up or down

        // Clicking higher in the first column
        if (choice == chosenPathHigh1) {
            chosenPathHigh2.setVisible(true);
            chosenPathLow2.setVisible(true);

            chosenPathHigh1.setVisible(false);
            chosenPathLow1.setVisible(false);
        }

        // Clicking lower in the first column
        if (choice == chosenPathLow1) {
            chosenPathHigh2.setVisible(true);
            chosenPathLow2.setVisible(true);

            chosenPathHigh1.setVisible(false);
            chosenPathLow1.setVisible(false);
        }

        // Clicking higher in the second column
        if (choice == chosenPathHigh2) {
            chosenPathHigh3.setVisible(true);
            chosenPathLow3.setVisible(true);

            chosenPathHigh2.setVisible(false);
            chosenPathLow2.setVisible(false);
        }

        // Clicking lower in the second column
        if (choice == chosenPathLow2) {
            chosenPathHigh3.setVisible(true);
            chosenPathLow3.setVisible(true);

            chosenPathHigh2.setVisible(false);
            chosenPathLow2.setVisible(false);
        }

        // Clicking higher in the third column
        if (choice == chosenPathHigh3) {
            chosenPathHigh4.setVisible(true);
            chosenPathLow4.setVisible(true);

            chosenPathHigh3.setVisible(false);
            chosenPathLow3.setVisible(false);
        }

        // Clicking lower in the third column
        if (choice == chosenPathLow3) {
            chosenPathHigh4.setVisible(true);
            chosenPathLow4.setVisible(true);

            chosenPathHigh3.setVisible(false);
            chosenPathLow3.setVisible(false);
        }

        // Clicking higher in the fourth column
        if (choice == chosenPathHigh4) {
            chosenPathHigh5.setVisible(true);
            chosenPathLow5.setVisible(true);

            chosenPathHigh4.setVisible(false);
            chosenPathLow4.setVisible(false);
        }

        // Clicking lower in the fourth column
        if (choice == chosenPathLow4) {
            chosenPathHigh5.setVisible(true);
            chosenPathLow5.setVisible(true);

            chosenPathHigh4.setVisible(false);
            chosenPathLow4.setVisible(false);
        }

        // Clicking higher in the fifth column
        if (choice == chosenPathHigh5) {
            chosenPathHigh6.setVisible(true);
            chosenPathLow6.setVisible(true);

            chosenPathHigh5.setVisible(false);
            chosenPathLow5.setVisible(false);
        }

        // Clicking lower in the fifth column
        if (choice == chosenPathLow5) {
            chosenPathHigh6.setVisible(true);
            chosenPathLow6.setVisible(true);

            chosenPathHigh5.setVisible(false);
            chosenPathLow5.setVisible(false);
        }

        // Clicking higher in the sixth column
        if (choice == chosenPathHigh6) {

            chosenPathHigh6.setVisible(false);
            chosenPathLow6.setVisible(false);
        }

        // Clicking lower in the sixth column
        if (choice == chosenPathLow6) {

            chosenPathHigh6.setVisible(false);
            chosenPathLow6.setVisible(false);
        }


    }

    private void clickingColor(Object choice) {
        if (choice == redButton || choice == blackButton) {

            char cardColor;

            //check if the card is not a 10, which will increase the length
            if (logic.smallCardString(1).length() == 23) {

                //get color char from the path
                cardColor = (logic.smallCardString(1)).charAt(18);

            } else {

                cardColor = (logic.smallCardString(1)).charAt(19);
            }

            // Make color buttons invisible
            for (JButton color : colors) {
                color.setVisible(false);
            }

            redBlackLabel.setVisible(true);

//            if ((choice == redButton && (cardColor == 'D' || cardColor == 'H')) ||
//                    (choice == blackButton && (cardColor == 'S' || cardColor == 'C'))) {
//                JOptionPane.showMessageDialog(null,
//                        "You got it right!");
//
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Ouch!");
//            }

            // Make highLow buttons visible
            for (JButton aHighLow : highLow) {
                aHighLow.setVisible(true);
            }

            //change the question
            questionLabel.setText("Higher or lower than the previous card?");
        }
    }

    private void clickingHighOrLow(Object choice) {
        if (choice == higherButton || choice == lowerButton ||
                choice == hiLowEqualButton) {

            highLowLabel.setVisible(true);

            //variable to pass the choice to the logic
            int userChoice;

            //read the user's choice and assign the correct value
            // to compare it
            if (choice == higherButton) userChoice = -1;
            else if (choice == lowerButton) userChoice = 1;
            else userChoice = 0;


            // Make highLow buttons invisible
            for (JButton aHighLow : highLow) {
                aHighLow.setVisible(false);
            }

//            if (logic.lowerOrHigherScore(userChoice)) {
//                JOptionPane.showMessageDialog(null,
//                        "Correct");
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Ouch");
//            }


            // Makes inOut buttons visible
            for (JButton anInOut : inOut) {
                anInOut.setVisible(true);
            }

            //change the question
            questionLabel.setText("Inside or outside the previous two cards?");

        }
    }

    private void clickingInOrOut(Object choice) {
        if (choice == insideButton || choice == outsideButton ||
                choice == inOutEqualButton) {

            inOutLabel.setVisible(true);

            int userChoice;

            if (choice == insideButton)
                userChoice = -1;
            else if (choice == outsideButton)
                userChoice = 1;
            else
                userChoice = 0;

            // Makes inOut buttons invisible
            for (JButton anInOut : inOut) {
                anInOut.setVisible(false);
            }
//
//            if (logic.insideOrOutsideScore(userChoice)) {
//
//                JOptionPane.showMessageDialog(null,
//                        "Correct");
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Ouch");
//            }


            // Make suit buttons visible
            for (JButton suit : suits) {
                suit.setVisible(true);
            }

            //change the question
            questionLabel.setText("What's the suit of the card?");
        }
    }

    private void clickingSuit(Object choice) {
        if (choice == spadesButton || choice == heartsButton ||
                choice == clubsButton || choice == diamondsButton) {

            suitLabel.setVisible(true);

            // Make suit buttons invisible
            for (JButton suit : suits) {
                suit.setVisible(false);
            }


            char userChoice;

            //check if the card is not a 10, which will increase the length
            if (logic.smallCardString(1).length() == 23) {

                //get color char from the path
                userChoice = (logic.smallCardString(4)).charAt(18);

            } else {

                userChoice = (logic.smallCardString(4)).charAt(19);
            }

//            if ((choice == diamondsButton && userChoice == 'D') ||
//                    (choice == heartsButton && userChoice == 'H') ||
//                    (choice == clubsButton && userChoice == 'C') ||
//                    (choice == spadesButton && userChoice == 'S')) {
//
//                JOptionPane.showMessageDialog(null,
//                        "You got it right!");
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Ouch!");
//            }

            // Make the number buttons visible
            for (JButton number : numbers) {
                number.setVisible(true);
            }

            //change the question
            questionLabel.setText("What's the value of the card?");
        }
    }

    private void clickingNumber(Object choice) {
        if (choice == twoButton || choice == threeButton || choice == fourButton ||
                choice == fiveButton || choice == sixButton || choice == sevenButton ||
                choice == eightButton || choice == nineButton || choice == tenButton ||
                choice == jackButton || choice == queenButton || choice == kingButton ||
                choice == aceButton) {

            randomLabel.setVisible(true);

            // Make the number buttons invisible
            for (JButton number : numbers) {
                number.setVisible(false);
            }

            //get the user's choice
            String userChoice;

            if (choice == twoButton) userChoice = "2";
            else if (choice == threeButton) userChoice = "3";
            else if (choice == fourButton) userChoice = "4";
            else if (choice == fiveButton) userChoice = "5";
            else if (choice == sixButton) userChoice = "6";
            else if (choice == sevenButton) userChoice = "7";
            else if (choice == eightButton) userChoice = "8";
            else if (choice == nineButton) userChoice = "9";
            else if (choice == tenButton) userChoice = "10";
            else if (choice == jackButton) userChoice = "J";
            else if (choice == queenButton) userChoice = "Q";
            else if (choice == kingButton) userChoice = "K";
            else if (choice == aceButton) userChoice = "A";
            else userChoice = "Something happened";

            //get card value from path of the card

            String cardValue;

            //check if the card is not a 10, which will increase the length
            if (logic.smallCardString(5).length() == 23) {

                //get color char from the path
                cardValue = logic.smallCardString(5).substring(17, 18);

            } else {

                cardValue = (logic.smallCardString(5)).substring(17, 17);
            }

//            if (cardValue.equals(userChoice)) {
//                JOptionPane.showMessageDialog(null,
//                        "Awesome!!!");
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "Damn it!");
//            }

            //change the question
            questionLabel.setText("The first stage is done. Wait a second");

            //sleep for 5 seconds
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e1) {
//                System.out.println("The time got interrupted");
//            }
//
//            JOptionPane.showMessageDialog(null, "Time for stage 2!");

            // Sets first stage panels to false so stage two can begin
            firstStage.setVisible(false);
            secondStage.setVisible(true);
        }
    }
}