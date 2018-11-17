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
    private ImageIcon dealerCard, redBlackCard, highLowCard,
            inOutCard, suitCard, randomCard;

    // Creates the color buttons
    private JButton redButton, blackButton;
    private JButton[] colors;

    // Creates the highLow buttons
    private JButton higherButton, lowerButton, hiLowEqualButton;
    private JButton[] highLow;

    // Creates the inOutButtons
    private JButton insideButton, outsideButton, inOutEqualButton;
    private JButton[] inOut;

    // Creates the suits buttons
    private JButton spadesButton, heartsButton, clubsButton, diamondsButton;
    private JButton[] suits;

    // Creates the buttons for the numbers
    private JButton twoButton, threeButton, fourButton, fiveButton, sixButton,
            sevenButton, eightButton, nineButton, tenButton,
            jackButton, queenButton, kingButton, aceButton;
    private JButton[] numbers;

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

        // Arrays for different buttons
        colors = new JButton[2];
        highLow = new JButton[3];
        inOut = new JButton[3];
        suits = new JButton[4];
        numbers = new JButton[13];

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

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
        for (int colorsSize = 0; colorsSize < colors.length; colorsSize++) {
            colors[colorsSize].addActionListener(this);
        }
        // Add action listeners to the highLow buttons
        for (int highLowSize = 0; highLowSize < highLow.length; highLowSize++) {
            highLow[highLowSize].addActionListener(this);
        }

        // Add action listeners to the inOut buttons
        for (int inOutSize = 0; inOutSize < inOut.length; inOutSize++) {
            inOut[inOutSize].addActionListener(this);
        }

        // Add action listeners to the suit buttons
        for (int suitSize = 0; suitSize < suits.length; suitSize++) {
            suits[suitSize].addActionListener(this);
        }

        // Add action listeners to the number buttons
        for (int numbersSize = 0; numbersSize < numbers.length; numbersSize++) {
            numbers[numbersSize].addActionListener(this);
        }

        //initialize the points label
        pointsLabel = new JLabel("Players points: " + logic.getScore());
        pointsLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        // Create one JPanel for the first stage of the game
        JPanel firstStage = new JPanel(new GridBagLayout());
//        firstStage.setPreferredSize(new Dimension(screenWidth, screenHeight));

        // --------------------------------------------------------------------------------

        // Sets layout of how cards are set
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

        // --------------------------------------------------------------------------------

        // Add the points label to the panel in line with cards
        c.gridx = BUTTONS_X_VALUE + 8;
        c.gridy = CARDS_Y_VALUE;
        firstStage.add(pointsLabel, c);

        //make the panel transparent
        firstStage.setOpaque(false);

        // Place the panel in the frame
        add(firstStage, BorderLayout.CENTER);
//        add(firstStage);

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
    /******************************************************************
     * Creates all of the events whenever a user clicks on something
     * @param e - the event of the user clicking something
     *****************************************************************/
    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();

        // Checks if user clicks on red or black
        if (choice == redButton || choice == blackButton) {
            redBlackLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            // Make highLow buttons visible
            for (int highLowSize = 0; highLowSize < highLow.length; highLowSize++) {
                highLow[highLowSize].setVisible(true);
            }

            // Make color buttons invisible
            for (int colorsSize = 0; colorsSize < colors.length; colorsSize++) {
                colors[colorsSize].setVisible(false);
            }
        }

        // Checks if user clicked higher or lower
        if (choice == higherButton || choice == lowerButton ||
                choice == hiLowEqualButton) {
            highLowLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            // Makes inOut buttons visible
            for (int inOutSize = 0; inOutSize < inOut.length; inOutSize++) {
                inOut[inOutSize].setVisible(true);
            }

            // Make highLow buttons invisible
            for (int highLowSize = 0; highLowSize < highLow.length; highLowSize++) {
                highLow[highLowSize].setVisible(false);
            }
        }

        // Checks if user clicked in or out
        if (choice == insideButton || choice == outsideButton ||
                choice == inOutEqualButton) {
            inOutLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            // Make suit buttons visible
            for (int suitSize = 0; suitSize < suits.length; suitSize++) {
                suits[suitSize].setVisible(true);
            }

            // Makes inOut buttons invisible
            for (int inOutSize = 0; inOutSize < inOut.length; inOutSize++) {
                inOut[inOutSize].setVisible(false);
            }
        }

        // Checks what suit the user picked
        if (choice == spadesButton || choice == heartsButton ||
                choice == clubsButton || choice == diamondsButton) {
            suitLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            // Make the number buttons visible
            for (int numbersSize = 0; numbersSize < numbers.length; numbersSize++) {
                numbers[numbersSize].setVisible(true);
            }

            // Make suit buttons invisible
            for (int suitSize = 0; suitSize < suits.length; suitSize++) {
                suits[suitSize].setVisible(false);
            }
        }

        // Checks what number the user picked
        if (choice == twoButton || choice == threeButton || choice == fourButton ||
                choice == fiveButton || choice == sixButton || choice == sevenButton ||
                choice == eightButton || choice == nineButton || choice == tenButton ||
                choice == jackButton || choice == queenButton || choice == kingButton ||
                choice == aceButton) {
            randomLabel.setVisible(true);

            JOptionPane.showMessageDialog(null,
                    "Check if this guess is correct somehow");

            // Make the number buttons invisible
            for (int numbersSize = 0; numbersSize < numbers.length; numbersSize++) {
                numbers[numbersSize].setVisible(false);
            }
        }
    }
}