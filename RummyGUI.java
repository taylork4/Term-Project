import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;

public class RummyGUI extends JFrame implements ActionListener {
    /**************************************************************************************************************************************************************************************
     * The RummyGUI class is an extension of JFrame that also implements the
     * ActionListener class. Within this class, the program creates a usable
     * menu that allows for the changing of screens, game modes, number of
     * players, settings, and closing the GUI.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    // JFrame declarations
    private JFrame mainMenuFrame, gameFrame, settingsFrame, rummyHowFrame;

    // JMenuBar declarations
    private JMenuBar menu;

    // JMenu declarations
    private JMenu options, tutorial;

    // JMenuItem declarations
    private JMenuItem returnMenu, rummyHow, settings, exit;

    // JButton declarations
    private JButton playButton, rummyButton, lakersRummyButton, makeMeldButton,
            addToMeldButton, blGreenButton, dGreenButton, lTanButton, confirmButton,
            cancelButton, readyButton;
    private JButton discard1, discard2, discard3, discard4, discard5,
            discard6, discard7, discard8;
    private JButton select1, select2, select3, select4, select5, select6,
            select7, select8;

    // JLabel declarations
    private JLabel titleLabel, p1Label, p2Label, p3Label, p4Label, cardDeckLabel,
            dash1Label, dash2Label, dash3Label, rectangleLeftLabel, octopusLabel,
            rectangleRightLabel, seaGullLabel, whaleLabel, crabLabel, underWLabel,
            crabGIFLabel, coolSquare1Label, coolSquare2Label, ex1Label, ex2Label,
            ex3Label, ex4Label, ex5Label, ex6Label, ex7Label, ex8Label, ex9Label,
            ex10Label, ex11Label, ex12Label, ex13Label, p1NumCards, p2NumCards,
            p3NumCards, p4NumCards, discardLabel, waitingLabel, waitTitleLabel;
    private JLabel cardAnchorAS, cardAnchor2S, cardAnchor3S, cardAnchor4S, // Anchor label for suit (Small)
            cardAnchor5S, cardAnchor6S, cardAnchor7S, cardAnchor8S, cardAnchor9S,
            cardAnchor10S, cardAnchorJS, cardAnchorQS, cardAnchorKS;
    private JLabel cardClockTowAS, cardClockTow2S, cardClockTow3S, cardClockTow4S, // Clock Tower label for suit (Small)
            cardClockTow5S, cardClockTow6S, cardClockTow7S, cardClockTow8S,
            cardClockTow9S, cardClockTow10S, cardClockTowJS, cardClockTowQS,
            cardClockTowKS;
    private JLabel cardGVLogoAS, cardGVLogo2S, cardGVLogo3S, cardGVLogo4S, // GVLogo label for suit (Small)
            cardGVLogo5S, cardGVLogo6S, cardGVLogo7S, cardGVLogo8S, cardGVLogo9S,
            cardGVLogo10S, cardGVLogoJS, cardGVLogoQS, cardGVLogoKS;
    private JLabel cardSailorAS, cardSailor2S, cardSailor3S, cardSailor4S, // Sailor label for suit (Small)
            cardSailor5S, cardSailor6S, cardSailor7S, cardSailor8S, cardSailor9S,
            cardSailor10S, cardSailorJS, cardSailorQS, cardSailorKS;
    private JLabel hand1, hand2, hand3, hand4, hand5, hand6, hand7, hand8;
    private JLabel[] handLabels = { hand1, hand2, hand3, hand4, hand5, hand6, hand7, hand8 };

    // ImageIcon declarations
    private ImageIcon settingsGear, redX, backOfCardLR, how2Play, returnBack,
            rectangleLeft, rectangleRight, avatar1, avatar2, avatar3, avatar4,
            underWater, crabGIF, GValleyJava, waiting;
    private ImageIcon anchorA, anchor2, anchor3, anchor4, anchor5, // Anchor suit images
            anchor6, anchor7, anchor8, anchor9, anchor10, anchorJ,
            anchorQ, anchorK;
    private ImageIcon clockTowA, clockTow2, clockTow3, clockTow4, // Clock Tower suit images
            clockTow5, clockTow6, clockTow7, clockTow8, clockTow9,
            clockTow10, clockTowJ, clockTowQ, clockTowK;
    private ImageIcon logoGVA, logoGV2, logoGV3, logoGV4, logoGV5, // GV Logo card suit images
            logoGV6, logoGV7, logoGV8, logoGV9, logoGV10, logoGVJ,
            logoGVQ, logoGVK;
    private ImageIcon sailorA, sailor2, sailor3, sailor4, sailor5, // Sailor card suit images
            sailor6, sailor7, sailor8, sailor9, sailor10, sailorJ,
            sailorQ, sailorK;
    private ImageIcon anchorAS, anchor2S, anchor3S, anchor4S, anchor5S, // Anchor suit images (Small)
            anchor6S, anchor7S, anchor8S, anchor9S, anchor10S, anchorJS,
            anchorQS, anchorKS;
    private ImageIcon clockTowAS, clockTow2S, clockTow3S, clockTow4S, // Clock Tower suit images (Small)
            clockTow5S, clockTow6S, clockTow7S, clockTow8S, clockTow9S,
            clockTow10S, clockTowJS, clockTowQS, clockTowKS;
    private ImageIcon logoGVAS, logoGV2S, logoGV3S, logoGV4S, logoGV5S, // GV Logo card suit images (Small)
            logoGV6S, logoGV7S, logoGV8S, logoGV9S, logoGV10S, logoGVJS,
            logoGVQS, logoGVKS;
    private ImageIcon sailorAS, sailor2S, sailor3S, sailor4S, sailor5S, // Sailor card suit images (Small)
            sailor6S, sailor7S, sailor8S, sailor9S, sailor10S, sailorJS,
            sailorQS, sailorKS;

    // Font declarations
    private Font titleFont, menuFont, subMenuFont, playButtonFont,
            gameButtonFont, numPlayersButtonFont, avatarFont,
            coolSquareFont, howTitleFont, settingsTextFont, confCelFont;

    // LineBorder declarations
    private LineBorder cardBorder, cardHighlightBorder, menuBorder,
            buttonBorder, meldBorder, currentPlayerBorder;

    // Color declarations
    private Color black, darkGrey, grey, lightGrey, white,
            red, orange, brightOrange, yellow, green, blue,
            aquaBlue, cyan, magenta, pink, darkTan, tan,
            blueGreen, darkGreen;

    // Container declarations
    private Container pane;

    // Insets declarations
    private Insets insets;

    // Game status variable declarations
    private final int MENU, GAME, SETTINGS, RUMMYHOW, BLGREEN, DGREEN, LTAN;
    private int whichGame, numPlayers, currentScreen, turn, gameColor;
    private boolean makeMeld, addToMeld, drawn, setup, discard, waitingTime;
    private Rummy rummy = new Rummy();
    Player current;
    private HashMap<Card, JLabel> cardMap = new HashMap<Card, JLabel>();
    private HashMap<Card, JLabel> cardMapSmall = new HashMap<Card, JLabel>();

    /**************************************************************************************************************************************************************************************
     * The default constructor for the RummyGUI() class. Within this constructor,
     * a menu bars is created allowing for access to the settings as well as the
     * ability to close out of the game.
     */
    public RummyGUI() {
        // Creating image icons
        GValleyJava = new ImageIcon("images/GValleyJava.png");
        settingsGear = new ImageIcon("images/settings-gear.png");
        redX = new ImageIcon("images/red-x.png");
        returnBack = new ImageIcon("images/returnBack.png");
        how2Play = new ImageIcon("images/how2Play.png");

        // Creating Labels
        waitingLabel = new JLabel(waiting = new ImageIcon("images/waiting.png"));
        underWLabel = new JLabel(underWater = new ImageIcon("images/underWater.png"));
        crabGIFLabel = new JLabel(crabGIF = new ImageIcon("images/crabGif.gif"));
        seaGullLabel = new JLabel(avatar1 = new ImageIcon("images/seaGull.jpg"));
        whaleLabel = new JLabel(avatar2 = new ImageIcon("images/whale.jpg"));
        octopusLabel = new JLabel(avatar3 = new ImageIcon("images/octopus.jpg"));
        crabLabel = new JLabel(avatar4 = new ImageIcon("images/crab.jpg"));
        rectangleLeftLabel = new JLabel(rectangleLeft = new ImageIcon("images/gameBackgroundTan.png"));
        rectangleRightLabel = new JLabel(rectangleRight = new ImageIcon("images/gameBackgroundTan.png"));
        cardDeckLabel = new JLabel(backOfCardLR = new ImageIcon("images/LR_Cards/LRBackCardDesign.jpg"));
        cardAnchorAS = new JLabel(anchorAS = new ImageIcon("images/LR_Cards/AnchorsS/AceAnchorS.jpg"));
        cardAnchor2S = new JLabel(anchor2S = new ImageIcon("images/LR_Cards/AnchorsS/2AnchorS.jpg"));
        cardAnchor3S = new JLabel(anchor3S = new ImageIcon("images/LR_Cards/AnchorsS/3AnchorS.jpg"));
        cardAnchor4S = new JLabel(anchor4S = new ImageIcon("images/LR_Cards/AnchorsS/4AnchorS.jpg"));
        cardAnchor5S = new JLabel(anchor5S = new ImageIcon("images/LR_Cards/AnchorsS/5AnchorS.jpg"));
        cardAnchor6S = new JLabel(anchor6S = new ImageIcon("images/LR_Cards/AnchorsS/6AnchorS.jpg"));
        cardAnchor7S = new JLabel(anchor7S = new ImageIcon("images/LR_Cards/AnchorsS/7AnchorS.jpg"));
        cardAnchor8S = new JLabel(anchor8S = new ImageIcon("images/LR_Cards/AnchorsS/8AnchorS.jpg"));
        cardAnchor9S = new JLabel(anchor9S = new ImageIcon("images/LR_Cards/AnchorsS/9AnchorS.jpg"));
        cardAnchor10S = new JLabel(anchor10S = new ImageIcon("images/LR_Cards/AnchorsS/10AnchorS.jpg"));
        cardAnchorJS = new JLabel(anchorJS = new ImageIcon("images/LR_Cards/AnchorsS/JackAnchorS.jpg"));
        cardAnchorQS = new JLabel(anchorQS = new ImageIcon("images/LR_Cards/AnchorsS/QueenAnchorS.jpg"));
        cardAnchorKS = new JLabel(anchorKS = new ImageIcon("images/LR_Cards/AnchorsS/KingAnchorS.jpg"));
        cardClockTowAS = new JLabel(clockTowAS = new ImageIcon("images/LR_Cards/ClockTowersS/AceCTS.jpg"));
        cardClockTow2S = new JLabel(clockTow2S = new ImageIcon("images/LR_Cards/ClockTowersS/2CTS.jpg"));
        cardClockTow3S = new JLabel(clockTow3S = new ImageIcon("images/LR_Cards/ClockTowersS/3CTS.jpg"));
        cardClockTow4S = new JLabel(clockTow4S = new ImageIcon("images/LR_Cards/ClockTowersS/4CTS.jpg"));
        cardClockTow5S = new JLabel(clockTow5S = new ImageIcon("images/LR_Cards/ClockTowersS/5CTS.jpg"));
        cardClockTow6S = new JLabel(clockTow6S = new ImageIcon("images/LR_Cards/ClockTowersS/6CTS.jpg"));
        cardClockTow7S = new JLabel(clockTow7S = new ImageIcon("images/LR_Cards/ClockTowersS/7CTS.jpg"));
        cardClockTow8S = new JLabel(clockTow8S = new ImageIcon("images/LR_Cards/ClockTowersS/8CTS.jpg"));
        cardClockTow9S = new JLabel(clockTow9S = new ImageIcon("images/LR_Cards/ClockTowersS/9CTS.jpg"));
        cardClockTow10S = new JLabel(clockTow10S = new ImageIcon("images/LR_Cards/ClockTowersS/10CTS.jpg"));
        cardClockTowJS = new JLabel(clockTowJS = new ImageIcon("images/LR_Cards/ClockTowersS/JackCTS.jpg"));
        cardClockTowQS = new JLabel(clockTowQS = new ImageIcon("images/LR_Cards/ClockTowersS/QueenCTS.jpg"));
        cardClockTowKS = new JLabel(clockTowKS = new ImageIcon("images/LR_Cards/ClockTowersS/KingCTS.jpg"));
        cardGVLogoAS = new JLabel(logoGVAS = new ImageIcon("images/LR_Cards/GVLogoS/AceGVLogoS.jpg"));
        cardGVLogo2S = new JLabel(logoGV2S = new ImageIcon("images/LR_Cards/GVLogoS/2GVLogoS.jpg"));
        cardGVLogo3S = new JLabel(logoGV3S = new ImageIcon("images/LR_Cards/GVLogoS/3GVLogoS.jpg"));
        cardGVLogo4S = new JLabel(logoGV4S = new ImageIcon("images/LR_Cards/GVLogoS/4GVLogoS.jpg"));
        cardGVLogo5S = new JLabel(logoGV5S = new ImageIcon("images/LR_Cards/GVLogoS/5GVLogoS.jpg"));
        cardGVLogo6S = new JLabel(logoGV6S = new ImageIcon("images/LR_Cards/GVLogoS/6GVLogoS.jpg"));
        cardGVLogo7S = new JLabel(logoGV7S = new ImageIcon("images/LR_Cards/GVLogoS/7GVLogoS.jpg"));
        cardGVLogo8S = new JLabel(logoGV8S = new ImageIcon("images/LR_Cards/GVLogoS/8GVLogoS.jpg"));
        cardGVLogo9S = new JLabel(logoGV9S = new ImageIcon("images/LR_Cards/GVLogoS/9GVLogoS.jpg"));
        cardGVLogo10S = new JLabel(logoGV10S = new ImageIcon("images/LR_Cards/GVLogoS/10GVLogoS.jpg"));
        cardGVLogoJS = new JLabel(logoGVJS = new ImageIcon("images/LR_Cards/GVLogoS/JackGVLogoS.jpg"));
        cardGVLogoQS = new JLabel(logoGVQS = new ImageIcon("images/LR_Cards/GVLogoS/QueenGVLogoS.jpg"));
        cardGVLogoKS = new JLabel(logoGVKS = new ImageIcon("images/LR_Cards/GVLogoS/KingGVLogoS.jpg"));
        cardSailorAS = new JLabel(sailorAS = new ImageIcon("images/LR_Cards/SailorS/AceSailorS.jpg"));
        cardSailor2S = new JLabel(sailor2S = new ImageIcon("images/LR_Cards/SailorS/2SailorS.jpg"));
        cardSailor3S = new JLabel(sailor3S = new ImageIcon("images/LR_Cards/SailorS/3SailorS.jpg"));
        cardSailor4S = new JLabel(sailor4S = new ImageIcon("images/LR_Cards/SailorS/4SailorS.jpg"));
        cardSailor5S = new JLabel(sailor5S = new ImageIcon("images/LR_Cards/SailorS/5SailorS.jpg"));
        cardSailor6S = new JLabel(sailor6S = new ImageIcon("images/LR_Cards/SailorS/6SailorS.jpg"));
        cardSailor7S = new JLabel(sailor7S = new ImageIcon("images/LR_Cards/SailorS/7SailorS.jpg"));
        cardSailor8S = new JLabel(sailor8S = new ImageIcon("images/LR_Cards/SailorS/8SailorS.jpg"));
        cardSailor9S = new JLabel(sailor9S = new ImageIcon("images/LR_Cards/SailorS/9SailorS.jpg"));
        cardSailor10S = new JLabel(sailor10S = new ImageIcon("images/LR_Cards/SailorS/10SailorS.jpg"));
        cardSailorJS = new JLabel(sailorJS = new ImageIcon("images/LR_Cards/SailorS/JackSailorS.jpg"));
        cardSailorQS = new JLabel(sailorQS = new ImageIcon("images/LR_Cards/SailorS/QueenSailorS.jpg"));
        cardSailorKS = new JLabel(sailorKS = new ImageIcon("images/LR_Cards/SailorS/KingSailorS.jpg"));

        // Creating colors
        black = Color.BLACK;
        darkGrey = Color.DARK_GRAY;
        grey = Color.GRAY;
        lightGrey = Color.LIGHT_GRAY;
        white = Color.WHITE;
        red = Color.RED;
        orange = Color.ORANGE;
        brightOrange = new Color(255, 135, 0);
        yellow = Color.YELLOW;
        green = Color.GREEN;
        blueGreen = new Color(0, 150, 170);
        darkGreen = new Color(0, 150, 100);
        blue = Color.BLUE;
        aquaBlue = new Color(5, 195, 228);
        cyan = Color.CYAN;
        magenta = Color.MAGENTA;
        pink = Color.PINK;
        darkTan = new Color(255, 190, 130);
        tan = new Color(255, 215, 175);

        // Creating fonts
        titleFont = new Font("Segoe Script", Font.BOLD, 120);
        settingsTextFont = new Font("Georgia", Font.PLAIN, 70);
        menuFont = new Font("Georgia", Font.PLAIN, 21);
        subMenuFont = new Font("Cooper Black", Font.PLAIN, 21);
        confCelFont = new Font("Cooper Black", Font.PLAIN, 15);
        coolSquareFont = new Font("Courier", Font.BOLD, 200);
        avatarFont = new Font("Georgia", Font.ITALIC, 15);
        playButtonFont = new Font("Courier", Font.BOLD, 50);
        gameButtonFont = new Font("Courier", Font.BOLD, 40);
        numPlayersButtonFont = new Font("Courier", Font.BOLD, 30);
        howTitleFont = new Font("Segoe Script", Font.BOLD, 80);

        // Creating borders
        currentPlayerBorder = new LineBorder(red, 4);
        cardBorder = new LineBorder(black, 2);
        cardHighlightBorder = new LineBorder(magenta, 3);
        meldBorder = new LineBorder(black, 3);
        menuBorder = new LineBorder(black, 1);
        buttonBorder = new LineBorder(black, 5);

        // Initializing final int values
        MENU = 1;
        SETTINGS = 2;
        GAME = 3;
        RUMMYHOW = 4;
        LTAN = 1;
        DGREEN = 2;
        BLGREEN = 3;
        gameColor = LTAN;
        makeMeld = false;
        addToMeld = false;
        drawn = false;
        setup = false;
        discard = false;
        waitingTime = false;

        // Calls method to create main menu
        mainMenuScreen();
    }

    /**************************************************************************************************************************************************************************************
     * The mainMenuScreen() method creates the main menu screen.
     */
    public void mainMenuScreen() {
        // Creating menu bar
        menu = new JMenuBar();

        // Creating frame
        mainMenuFrame = new JFrame();

        // Creating pane
        pane = new Container();
        pane.setLayout(null);

        // Creating labels
        titleLabel = new JLabel("Lakers Rummy");

        // Creating buttons
        playButton = new JButton("Play");
        rummyButton = new JButton("Rummy");
        lakersRummyButton = new JButton("Lakers Rummy");

        // Creating menus
        options = new JMenu("Options");
        tutorial = new JMenu(" How to Play");

        // Creating menu items
        settings = new JMenuItem(" Settings", settingsGear);
        exit = new JMenuItem(" Exit", redX);
        rummyHow = new JMenuItem(" How to Play", how2Play);

        // Setting frame icon
        mainMenuFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        playButton.setBackground(brightOrange);
        rummyButton.setBackground(orange);
        lakersRummyButton.setBackground(darkGrey);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        titleLabel.setForeground(black);
        options.setForeground(black);
        tutorial.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);
        rummyHow.setForeground(black);
        playButton.setForeground(black);
        rummyButton.setForeground(black);
        lakersRummyButton.setForeground(lightGrey);

        // Setting fonts
        titleLabel.setFont(titleFont);
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        playButton.setFont(playButtonFont);
        rummyButton.setFont(gameButtonFont);
        lakersRummyButton.setFont(gameButtonFont);

        // Setting borders
        playButton.setBorder(buttonBorder);
        rummyButton.setBorder(buttonBorder);
        lakersRummyButton.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        crabGIFLabel.setBounds(565 + insets.left, 75 + insets.top, 100, 75);
        underWLabel.setBounds(0 + insets.left, 0 + insets.top, 1500, 700);
        titleLabel.setBounds(185 + insets.left, 10 + insets.top, 1000, 150);
        playButton.setBounds(520 + insets.left, 150 + insets.top, 200, 120);
        rummyButton.setBounds(285 + insets.left, 300 + insets.top, 275, 130);
        lakersRummyButton.setBounds(675 + insets.left, 300 + insets.top, 325, 130);

        // Adding elements to menubar
        menu.add(options);
        menu.add(tutorial);

        // Adding elements to menu items
        options.add(settings);
        options.addSeparator();
        options.add(exit);
        tutorial.add(rummyHow);

        // Adding elements to frame
        mainMenuFrame.add(menu);
        mainMenuFrame.add(pane);

        // Adding elements to pane
        pane.add(titleLabel);
        pane.add(crabGIFLabel);
        pane.add(playButton);
        pane.add(rummyButton);
        pane.add(lakersRummyButton);

        pane.add(underWLabel);

        // Addiing action listeners to elements
        settings.addActionListener(this);
        tutorial.addActionListener(this);
        exit.addActionListener(this);
        playButton.addActionListener(this);
        rummyButton.addActionListener(this);
        lakersRummyButton.addActionListener(this);
        rummyHow.addActionListener(this);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        mainMenuFrame.pack();
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setSize(1280, 720);
        mainMenuFrame.setJMenuBar(menu);
        mainMenuFrame.getContentPane().setBackground(aquaBlue);

        // Setting default whichGame and howManyPlayers
        whichGame = 1;
        numPlayers = 4;
        currentScreen = MENU;
    }

    /**************************************************************************************************************************************************************************************
     * The gameScreen() method creates the game screen.
     */
    public void gameScreen() {
        // Creating menu bar
        menu = new JMenuBar();

        // Creating frame
        gameFrame = new JFrame();

        // Creating pane
        pane = new Container();
        pane.setLayout(null);

        // Creating labels
        p1Label = new JLabel("Cards in hand: ");
        p2Label = new JLabel("Cards in hand: ");
        p3Label = new JLabel("Cards in hand: ");
        p4Label = new JLabel("Cards in hand: ");
        dash1Label = new JLabel("_______");
        dash2Label = new JLabel("_______");
        dash3Label = new JLabel("_______");

        if (!setup) {
            // populating hashmap with smol cards
            cardMapSmall.put(rummy.getCard(0), cardAnchorAS);
            cardMapSmall.put(rummy.getCard(1), cardClockTowAS);
            cardMapSmall.put(rummy.getCard(2), cardGVLogoAS);
            cardMapSmall.put(rummy.getCard(3), cardSailorAS);
            cardMapSmall.put(rummy.getCard(4), cardAnchor2S);
            cardMapSmall.put(rummy.getCard(5), cardClockTow2S);
            cardMapSmall.put(rummy.getCard(6), cardGVLogo2S);
            cardMapSmall.put(rummy.getCard(7), cardSailor2S);
            cardMapSmall.put(rummy.getCard(8), cardAnchor3S);
            cardMapSmall.put(rummy.getCard(9), cardClockTow3S);
            cardMapSmall.put(rummy.getCard(10), cardGVLogo3S);
            cardMapSmall.put(rummy.getCard(11), cardSailor3S);
            cardMapSmall.put(rummy.getCard(12), cardAnchor4S);
            cardMapSmall.put(rummy.getCard(13), cardClockTow4S);
            cardMapSmall.put(rummy.getCard(14), cardGVLogo4S);
            cardMapSmall.put(rummy.getCard(15), cardSailor4S);
            cardMapSmall.put(rummy.getCard(16), cardAnchor5S);
            cardMapSmall.put(rummy.getCard(17), cardClockTow5S);
            cardMapSmall.put(rummy.getCard(18), cardGVLogo5S);
            cardMapSmall.put(rummy.getCard(19), cardSailor5S);
            cardMapSmall.put(rummy.getCard(20), cardAnchor6S);
            cardMapSmall.put(rummy.getCard(21), cardClockTow6S);
            cardMapSmall.put(rummy.getCard(22), cardGVLogo6S);
            cardMapSmall.put(rummy.getCard(23), cardSailor6S);
            cardMapSmall.put(rummy.getCard(24), cardAnchor7S);
            cardMapSmall.put(rummy.getCard(25), cardClockTow7S);
            cardMapSmall.put(rummy.getCard(26), cardGVLogo7S);
            cardMapSmall.put(rummy.getCard(27), cardSailor7S);
            cardMapSmall.put(rummy.getCard(28), cardAnchor8S);
            cardMapSmall.put(rummy.getCard(29), cardClockTow8S);
            cardMapSmall.put(rummy.getCard(30), cardGVLogo8S);
            cardMapSmall.put(rummy.getCard(31), cardSailor8S);
            cardMapSmall.put(rummy.getCard(32), cardAnchor9S);
            cardMapSmall.put(rummy.getCard(33), cardClockTow9S);
            cardMapSmall.put(rummy.getCard(34), cardGVLogo9S);
            cardMapSmall.put(rummy.getCard(35), cardSailor9S);
            cardMapSmall.put(rummy.getCard(36), cardAnchor10S);
            cardMapSmall.put(rummy.getCard(37), cardClockTow10S);
            cardMapSmall.put(rummy.getCard(38), cardGVLogo10S);
            cardMapSmall.put(rummy.getCard(39), cardSailor10S);
            cardMapSmall.put(rummy.getCard(40), cardAnchorJS);
            cardMapSmall.put(rummy.getCard(41), cardClockTowJS);
            cardMapSmall.put(rummy.getCard(42), cardGVLogoJS);
            cardMapSmall.put(rummy.getCard(43), cardSailorJS);
            cardMapSmall.put(rummy.getCard(44), cardAnchorQS);
            cardMapSmall.put(rummy.getCard(45), cardClockTowQS);
            cardMapSmall.put(rummy.getCard(46), cardGVLogoQS);
            cardMapSmall.put(rummy.getCard(47), cardSailorQS);
            cardMapSmall.put(rummy.getCard(48), cardAnchorKS);
            cardMapSmall.put(rummy.getCard(49), cardClockTowKS);
            cardMapSmall.put(rummy.getCard(50), cardGVLogoKS);
            cardMapSmall.put(rummy.getCard(51), cardSailorKS);

            rummy.deck.shuffle(); // for testing purposes, did not shuffle yet
            rummy.deal();
        }
        current = rummy.getPlayer(turn % numPlayers);
        final int maxHandSize = 8;
        for (int i = 0; i < maxHandSize; i++) { // adding cards in hand to be displayed
            if (i < current.hand.cardArr.size()) {
                handLabels[i] = cardMapSmall.get(current.hand.cardArr.get(i));
                handLabels[i].setBorder(cardBorder);
            } else {
                handLabels[i] = null;
            }
        }
        waitTitleLabel = new JLabel("Player " + ((turn % numPlayers) + 1) + "! It's Your Turn");
        p1NumCards = new JLabel("" + rummy.getPlayer(0).hand.cardArr.size());
        p2NumCards = new JLabel("" + rummy.getPlayer(1).hand.cardArr.size());
        p3NumCards = new JLabel("" + rummy.getPlayer(2).hand.cardArr.size());
        p4NumCards = new JLabel("" + rummy.getPlayer(3).hand.cardArr.size());
        /*
         * if (numPlayers == 2) {
         * p2NumCards = new JLabel("" + rummy.getPlayer(1).hand.cardArr.size());
         * }
         * if (numPlayers == 3) {
         * p3NumCards = new JLabel("" + rummy.getPlayer(2).hand.cardArr.size());
         * }
         * if (numPlayers == 4) {
         * p3NumCards = new JLabel("" + rummy.getPlayer(3).hand.cardArr.size());
         * }
         */

        // Creating menus
        options = new JMenu("Options");

        // Creating menu items
        exit = new JMenuItem(" Exit", redX);

        // Creating buttons
        makeMeldButton = new JButton("Make Meld");
        addToMeldButton = new JButton("Add to Meld");
        discard1 = new JButton("Discard");
        discard2 = new JButton("Discard");
        discard3 = new JButton("Discard");
        discard4 = new JButton("Discard");
        discard5 = new JButton("Discard");
        discard6 = new JButton("Discard");
        discard7 = new JButton("Discard");
        discard8 = new JButton("Discard");
        select1 = new JButton("Select");
        select2 = new JButton("Select");
        select3 = new JButton("Select");
        select4 = new JButton("Select");
        select5 = new JButton("Select");
        select6 = new JButton("Select");
        select7 = new JButton("Select");
        select8 = new JButton("Select");
        cancelButton = new JButton("Cancel");
        confirmButton = new JButton("Confirm");
        readyButton = new JButton("Ready?");

        // Setting frame icon
        gameFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        makeMeldButton.setBackground(orange);
        addToMeldButton.setBackground(orange);
        discard1.setBackground(orange);
        discard2.setBackground(orange);
        discard3.setBackground(orange);
        discard4.setBackground(orange);
        discard5.setBackground(orange);
        discard6.setBackground(orange);
        discard7.setBackground(orange);
        discard8.setBackground(orange);
        select1.setBackground(orange);
        select2.setBackground(orange);
        select3.setBackground(orange);
        select4.setBackground(orange);
        select5.setBackground(orange);
        select6.setBackground(orange);
        select7.setBackground(orange);
        select8.setBackground(orange);
        cancelButton.setBackground(brightOrange);
        confirmButton.setBackground(brightOrange);
        readyButton.setBackground(blueGreen);

        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        makeMeldButton.setForeground(black);
        addToMeldButton.setForeground(black);
        waitTitleLabel.setForeground(black);
        readyButton.setForeground(black);
        p1Label.setForeground(black);
        p2Label.setForeground(black);
        p3Label.setForeground(black);
        p4Label.setForeground(black);
        p1NumCards.setForeground(black);
        p2NumCards.setForeground(black);
        p3NumCards.setForeground(black);
        p4NumCards.setForeground(black);
        dash1Label.setForeground(black);
        dash2Label.setForeground(black);
        dash3Label.setForeground(black);
        discard1.setForeground(black);
        discard2.setForeground(black);
        discard3.setForeground(black);
        discard4.setForeground(black);
        discard5.setForeground(black);
        discard6.setForeground(black);
        discard7.setForeground(black);
        discard8.setForeground(black);
        select1.setForeground(black);
        select2.setForeground(black);
        select3.setForeground(black);
        select4.setForeground(black);
        select5.setForeground(black);
        select6.setForeground(black);
        select7.setForeground(black);
        select8.setForeground(black);
        cancelButton.setForeground(black);
        confirmButton.setForeground(black);
        options.setForeground(black);
        exit.setForeground(black);

        // Setting fonts
        waitTitleLabel.setFont(howTitleFont);
        readyButton.setFont(playButtonFont);
        makeMeldButton.setFont(menuFont);
        addToMeldButton.setFont(menuFont);
        discard1.setFont(menuFont);
        discard2.setFont(menuFont);
        discard3.setFont(menuFont);
        discard4.setFont(menuFont);
        discard5.setFont(menuFont);
        discard6.setFont(menuFont);
        discard7.setFont(menuFont);
        discard8.setFont(menuFont);
        select1.setFont(menuFont);
        select2.setFont(menuFont);
        select3.setFont(menuFont);
        select4.setFont(menuFont);
        select5.setFont(menuFont);
        select6.setFont(menuFont);
        select7.setFont(menuFont);
        select8.setFont(menuFont);
        cancelButton.setFont(confCelFont);
        confirmButton.setFont(confCelFont);
        p1Label.setFont((avatarFont));
        p2Label.setFont(avatarFont);
        p3Label.setFont(avatarFont);
        p4Label.setFont(avatarFont);
        p1NumCards.setFont((avatarFont));
        p2NumCards.setFont(avatarFont);
        p3NumCards.setFont(avatarFont);
        p4NumCards.setFont(avatarFont);
        dash1Label.setFont(playButtonFont);
        dash2Label.setFont(playButtonFont);
        dash3Label.setFont(playButtonFont);
        options.setFont(menuFont);
        exit.setFont(subMenuFont);

        // Setting borders
        makeMeldButton.setBorder(meldBorder);
        addToMeldButton.setBorder(meldBorder);
        discard1.setBorder(meldBorder);
        discard2.setBorder(meldBorder);
        discard3.setBorder(meldBorder);
        discard4.setBorder(meldBorder);
        discard5.setBorder(meldBorder);
        discard6.setBorder(meldBorder);
        discard7.setBorder(meldBorder);
        discard8.setBorder(meldBorder);
        select1.setBorder(meldBorder);
        select2.setBorder(meldBorder);
        select3.setBorder(meldBorder);
        select4.setBorder(meldBorder);
        select5.setBorder(meldBorder);
        select6.setBorder(meldBorder);
        select7.setBorder(meldBorder);
        select8.setBorder(meldBorder);
        readyButton.setBorder(buttonBorder);
        cancelButton.setBorder(meldBorder);
        confirmButton.setBorder(meldBorder);
        rectangleLeftLabel.setBorder(buttonBorder);
        rectangleRightLabel.setBorder(buttonBorder);
        cardDeckLabel.setBorder(cardBorder);

        if (turn % numPlayers == 0) {
            seaGullLabel.setBorder(currentPlayerBorder);
            whaleLabel.setBorder(cardBorder);
            octopusLabel.setBorder(cardBorder);
            crabLabel.setBorder(cardBorder);
        } else if (turn % numPlayers == 1) {
            seaGullLabel.setBorder(cardBorder);
            whaleLabel.setBorder(currentPlayerBorder);
            octopusLabel.setBorder(cardBorder);
            crabLabel.setBorder(cardBorder);
        } else if (turn % numPlayers == 2) {
            seaGullLabel.setBorder(cardBorder);
            whaleLabel.setBorder(cardBorder);
            octopusLabel.setBorder(currentPlayerBorder);
            crabLabel.setBorder(cardBorder);
        } else if (turn % numPlayers == 3) {
            seaGullLabel.setBorder(cardBorder);
            whaleLabel.setBorder(cardBorder);
            octopusLabel.setBorder(cardBorder);
            crabLabel.setBorder(currentPlayerBorder);
        }
        // seaGullLabel.setBorder(currentPlayerBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        seaGullLabel.setBounds(1090 + insets.left, 20 + insets.top, 145, 105);
        whaleLabel.setBounds(1090 + insets.left, 180 + insets.top, 145, 110);
        octopusLabel.setBounds(1090 + insets.left, 350 + insets.top, 145, 110);
        crabLabel.setBounds(1090 + insets.left, 510 + insets.top, 145, 110);
        p1Label.setBounds(1090 + insets.left, 120 + insets.top, 200, 50);
        p2Label.setBounds(1090 + insets.left, 285 + insets.top, 200, 50);
        p3Label.setBounds(1090 + insets.left, 450 + insets.top, 200, 50);
        p4Label.setBounds(1090 + insets.left, 605 + insets.top, 200, 50);
        p1NumCards.setBounds(1200 + insets.left, 120 + insets.top, 50, 50);
        p2NumCards.setBounds(1200 + insets.left, 285 + insets.top, 50, 50);
        p3NumCards.setBounds(1200 + insets.left, 450 + insets.top, 50, 50);
        p4NumCards.setBounds(1200 + insets.left, 605 + insets.top, 50, 50);
        dash1Label.setBounds(1055 + insets.left, 100 + insets.top, 300, 75);
        dash2Label.setBounds(1055 + insets.left, 267 + insets.top, 300, 75);
        dash3Label.setBounds(1055 + insets.left, 428 + insets.top, 300, 75);
        rectangleLeftLabel.setBounds(0 + insets.left, 0 + insets.top, 215, 655);
        rectangleRightLabel.setBounds(1054 + insets.left, 0 + insets.top, 215, 655);
        cardDeckLabel.setBounds(40 + insets.left, 20 + insets.top, 135, 190);
        // loop to add cards in hand to bottom of screen
        for (int j = 0; j < 7 * 120; j += 120) {
            if (handLabels[j / 120] != null) {
                handLabels[j / 120].setBounds(225 + j + insets.left, 500 + insets.bottom, 100, 135);
            }
        }
        if (handLabels[7] != null) {
            handLabels[7].setBounds((int) handLabels[6].getLocation().getX(),
                    (int) handLabels[6].getLocation().getY() - 200, 100, 135);
        }

        // Adding elements to menubar
        menu.add(options);

        // Adding elements to menu items
        options.add(exit);

        // Adding elements to frame
        gameFrame.add(menu);
        gameFrame.add(pane);

        // Adding elements to pane
        if (waitingTime) {
            waitingLabel.setBounds(0 + insets.left, 0 + insets.top, 1500, 700);
            waitTitleLabel.setBounds(120 + insets.left, 40 + insets.top, 1200, 200);
            readyButton.setBounds(475 + insets.left, 180 + insets.top, 300, 80);
            readyButton.addActionListener(this);

            pane.add(waitTitleLabel);
            pane.add(readyButton);
            pane.add(waitingLabel);
            waitingTime = false;
        }
        pane.add(makeMeldButton);
        pane.add(addToMeldButton);
        pane.add(seaGullLabel);
        pane.add(whaleLabel);
        pane.add(octopusLabel);
        pane.add(crabLabel);
        pane.add(p1Label);
        pane.add(p2Label);
        pane.add(p3Label);
        pane.add(p4Label);
        pane.add(p1NumCards);
        pane.add(p2NumCards);
        pane.add(p3NumCards);
        pane.add(p4NumCards);
        pane.add(dash1Label);
        pane.add(dash2Label);
        pane.add(dash3Label);
        pane.add(cardDeckLabel);
        pane.add(rectangleLeftLabel);
        pane.add(rectangleRightLabel);
        pane.add(discard1);
        pane.add(discard2);
        pane.add(discard3);
        pane.add(discard4);
        pane.add(discard5);
        pane.add(discard6);
        pane.add(discard7);
        pane.add(discard8);
        pane.add(select1);
        pane.add(select2);
        pane.add(select3);
        pane.add(select4);
        pane.add(select5);
        pane.add(select6);
        pane.add(select7);
        pane.add(select8);
        pane.add(confirmButton);
        pane.add(cancelButton);

        for (int j = 0; j < 8; j++) {
            if (handLabels[j] != null)
                pane.add(handLabels[j]);
        }

        // adding discard buttons
        setDiscardButtons(current);
        setMeldButtons(current);

        // displaying discard pile
        displayDiscard();

        // Addiing action listeners to elements
        exit.addActionListener(this);
        makeMeldButton.addActionListener(this);
        addToMeldButton.addActionListener(this);
        discard1.addActionListener(this);
        discard2.addActionListener(this);
        discard3.addActionListener(this);
        discard4.addActionListener(this);
        discard5.addActionListener(this);
        discard6.addActionListener(this);
        discard7.addActionListener(this);
        discard8.addActionListener(this);
        select1.addActionListener(this);
        select2.addActionListener(this);
        select3.addActionListener(this);
        select4.addActionListener(this);
        select5.addActionListener(this);
        select6.addActionListener(this);
        select7.addActionListener(this);
        select8.addActionListener(this);
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        cardDeckLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // cardDeckLabel.setBorder(cardHighlightBorder);
                if (!drawn) {
                    if(!rummy.deck.cardArr.isEmpty())
                        rummy.draw(rummy.deck, rummy.getPlayer(turn % numPlayers).hand);
                    else
                        rummy.draw(rummy.getDiscard(), rummy.getPlayer(turn % numPlayers).hand);
                    gameFrame.dispose();
                    setup = true;
                    drawn = true;
                    gameScreen();
                    makeMeldButton.setBounds(35 + insets.left, 235 + insets.top, 145, 50);
                    addToMeldButton.setBounds(35 + insets.left, 355 + insets.top, 145, 50);
                }
            }
        });

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setSize(1280, 720);
        gameFrame.setJMenuBar(menu);

        // Color of game screen depends on what player selects in settings
        if (gameColor == LTAN) {
            gameFrame.getContentPane().setBackground(tan);
        } else if (gameColor == DGREEN) {
            gameFrame.getContentPane().setBackground(darkGreen);
        } else if (gameColor == BLGREEN) {
            gameFrame.getContentPane().setBackground(blueGreen);
        }

        // Setting screen as game screen
        currentScreen = GAME;
    }

    /**************************************************************************************************************************************************************************************
     * The settingsScreen() method creates the settings screen.
     */
    public void settingsScreen() {
        // Creating menu bar
        menu = new JMenuBar();

        // Creating frame
        settingsFrame = new JFrame();

        // Creating pane
        pane = new Container();
        pane.setLayout(null);

        // Creating labels
        titleLabel = new JLabel("Settings");
        coolSquare1Label = new JLabel("⬛⬛⬛⬛⬛⬛");
        coolSquare2Label = new JLabel("⬛⬛⬛⬛⬛⬛");
        dash1Label = new JLabel("________________________________________");
        ex1Label = new JLabel("Game Background Color");

        // Creating buttons
        blGreenButton = new JButton("Blue-Green");
        dGreenButton = new JButton("Dark Green");
        lTanButton = new JButton("Tan");

        // Creating menus
        options = new JMenu("Options");

        // Creating menu items
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);

        // Setting frame icon
        settingsFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        if (gameColor == LTAN) {
            blGreenButton.setBackground(darkGrey);
            dGreenButton.setBackground(darkGrey);
            lTanButton.setBackground(yellow);
        } else if (gameColor == DGREEN) {
            blGreenButton.setBackground(darkGrey);
            dGreenButton.setBackground(yellow);
            lTanButton.setBackground(darkGrey);
        } else if (gameColor == BLGREEN) {
            blGreenButton.setBackground(yellow);
            dGreenButton.setBackground(darkGrey);
            lTanButton.setBackground(darkGrey);
        }

        // Setting foreground colors
        if (gameColor == LTAN) {
            blGreenButton.setForeground(lightGrey);
            dGreenButton.setForeground(lightGrey);
            lTanButton.setForeground(black);
        } else if (gameColor == DGREEN) {
            blGreenButton.setForeground(lightGrey);
            dGreenButton.setForeground(black);
            lTanButton.setForeground(lightGrey);
        } else if (gameColor == BLGREEN) {
            blGreenButton.setForeground(black);
            dGreenButton.setForeground(lightGrey);
            lTanButton.setForeground(lightGrey);
        }
        titleLabel.setForeground(black);
        ex1Label.setForeground(black);
        dash1Label.setForeground(black);
        coolSquare1Label.setForeground(yellow);
        coolSquare2Label.setForeground(green);
        options.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);

        // Setting fonts
        options.setFont(menuFont);
        titleLabel.setFont(howTitleFont);
        ex1Label.setFont(settingsTextFont);
        dash1Label.setFont(playButtonFont);
        blGreenButton.setFont(numPlayersButtonFont);
        dGreenButton.setFont(numPlayersButtonFont);
        lTanButton.setFont(numPlayersButtonFont);
        coolSquare1Label.setFont(coolSquareFont);
        coolSquare2Label.setFont(coolSquareFont);
        returnMenu.setFont(subMenuFont);
        exit.setFont(subMenuFont);

        // Setting borders
        blGreenButton.setBorder(buttonBorder);
        dGreenButton.setBorder(buttonBorder);
        lTanButton.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        titleLabel.setBounds(325 + insets.left, 10 + insets.top, 600, 100);
        dash1Label.setBounds(0 + insets.left, 50 + insets.top, 1300, 100);
        coolSquare1Label.setBounds(-30 + insets.left, -40 + insets.top, 1300, 200);
        coolSquare2Label.setBounds(10 + insets.left, -40 + insets.top, 1300, 200);
        blGreenButton.setBounds(50 + insets.left, 300 + insets.top, 200, 100);
        dGreenButton.setBounds(400 + insets.left, 300 + insets.top, 200, 100);
        lTanButton.setBounds(750 + insets.left, 300 + insets.top, 200, 100);
        ex1Label.setBounds(130 + insets.left, 180 + insets.top, 1500, 100);

        // Adding elements to menubar
        menu.add(options);

        // Adding elements to menu items
        options.add(returnMenu);
        options.addSeparator();
        options.add(exit);

        // Adding elements to frame
        settingsFrame.add(menu);
        settingsFrame.add(pane);

        // Adding elements to pane
        pane.add(titleLabel);
        pane.add(ex1Label);
        pane.add(dash1Label);
        pane.add(blGreenButton);
        pane.add(dGreenButton);
        pane.add(lTanButton);
        pane.add(coolSquare1Label);
        pane.add(coolSquare2Label);

        // Addiing action listeners to elements
        exit.addActionListener(this);
        blGreenButton.addActionListener(this);
        dGreenButton.addActionListener(this);
        lTanButton.addActionListener(this);
        returnMenu.addActionListener(this);
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        settingsFrame.pack();
        settingsFrame.setVisible(true);
        settingsFrame.setSize(1000, 720);
        settingsFrame.setJMenuBar(menu);
        if (gameColor == LTAN) {
            settingsFrame.getContentPane().setBackground(tan);
        } else if (gameColor == DGREEN) {
            settingsFrame.getContentPane().setBackground(darkGreen);
        } else if (gameColor == BLGREEN) {
            settingsFrame.getContentPane().setBackground(blueGreen);
        }

        // Setting current screen location
        currentScreen = SETTINGS;
    }

    /**************************************************************************************************************************************************************************************
     * The rummyHowScreen() method creates the How to Play screen.
     */
    public void rummyHowScreen() {
        // Creating menu bar
        menu = new JMenuBar();

        // Creating frame
        rummyHowFrame = new JFrame();

        // Creating pane
        pane = new Container();
        pane.setLayout(null);

        // Creating Title
        titleLabel = new JLabel("How to Play");

        // Creating Labels
        coolSquare1Label = new JLabel("⬛⬛⬛⬛⬛⬛");
        coolSquare2Label = new JLabel("⬛⬛⬛⬛⬛⬛");
        dash1Label = new JLabel("________________________________________");
        ex1Label = new JLabel("Making Melds:");
        ex2Label = new JLabel("In a game of Rummy, so long as it is the Player's turn and they have 3 or more of the");
        ex3Label = new JLabel("same card value ~OR~ 4 or more sequential cards of the suit, they can make a meld.");
        dash2Label = new JLabel("----------------------------------------");
        ex4Label = new JLabel("How are points awarded?");
        ex5Label = new JLabel("In Rummy, the less points you have, the better. If a round ends, all players except");
        ex6Label = new JLabel("for the player who plays all of their cards receive points that reflect what is left");
        ex7Label = new JLabel("over in their hand.");
        ex8Label = new JLabel("- Numbered Cards --> # on card = points received");
        ex9Label = new JLabel("- J,K,Q,A --> 10 points each");
        dash3Label = new JLabel("----------------------------------------");
        ex10Label = new JLabel("The Lakers Rummy 'Twist':");
        ex11Label = new JLabel("Lakers Rummy, while mostly the same as rummy, allows a player to cheat. If a player");
        ex12Label = new JLabel("can get away with a cheat without another player noticing within a turn, the player");
        ex13Label = new JLabel(
                "will go unpunished. Otherwise, the player receives 10 points every time they are caught.");

        // Creating buttons
        // playButton = new JButton("Play");

        // Creating menus
        options = new JMenu("Options");

        // Creating menu items
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);

        // Setting frame icon
        rummyHowFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        titleLabel.setForeground(black);
        dash1Label.setForeground(black);
        dash2Label.setForeground(darkGrey);
        dash3Label.setForeground(darkGrey);
        ex1Label.setForeground(black);
        ex2Label.setForeground(black);
        ex3Label.setForeground(black);
        ex4Label.setForeground(black);
        ex5Label.setForeground(black);
        ex6Label.setForeground(black);
        ex7Label.setForeground(black);
        ex8Label.setForeground(black);
        ex9Label.setForeground(black);
        ex10Label.setForeground(black);
        ex11Label.setForeground(black);
        ex12Label.setForeground(black);
        ex13Label.setForeground(black);
        coolSquare1Label.setForeground(orange);
        coolSquare2Label.setForeground(brightOrange);
        options.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);

        // Setting fonts
        options.setFont(menuFont);
        titleLabel.setFont(howTitleFont);
        dash1Label.setFont(playButtonFont);
        dash2Label.setFont(playButtonFont);
        dash3Label.setFont(playButtonFont);
        ex1Label.setFont(playButtonFont);
        ex2Label.setFont(subMenuFont);
        ex3Label.setFont(subMenuFont);
        ex4Label.setFont(playButtonFont);
        ex5Label.setFont(subMenuFont);
        ex6Label.setFont(subMenuFont);
        ex7Label.setFont(subMenuFont);
        ex8Label.setFont(subMenuFont);
        ex9Label.setFont(subMenuFont);
        ex10Label.setFont(playButtonFont);
        ex11Label.setFont(subMenuFont);
        ex12Label.setFont(subMenuFont);
        ex13Label.setFont(subMenuFont);
        coolSquare1Label.setFont(coolSquareFont);
        coolSquare2Label.setFont(coolSquareFont);
        returnMenu.setFont(subMenuFont);
        exit.setFont(subMenuFont);

        // Setting borders
        playButton.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        titleLabel.setBounds(225 + insets.left, 10 + insets.top, 600, 100);
        dash1Label.setBounds(0 + insets.left, 50 + insets.top, 1300, 100);
        dash2Label.setBounds(0 + insets.left, 185 + insets.top, 1300, 100);
        dash3Label.setBounds(0 + insets.left, 350 + insets.top, 1300, 100);
        ex1Label.setBounds(20 + insets.left, 110 + insets.top, 600, 100);
        ex2Label.setBounds(10 + insets.left, 145 + insets.top, 1000, 100);
        ex3Label.setBounds(10 + insets.left, 165 + insets.top, 1000, 100);
        ex4Label.setBounds(20 + insets.left, 215 + insets.top, 1000, 100);
        ex5Label.setBounds(10 + insets.left, 250 + insets.top, 1000, 100);
        ex6Label.setBounds(10 + insets.left, 270 + insets.top, 1000, 100);
        ex7Label.setBounds(10 + insets.left, 290 + insets.top, 1000, 100);
        ex8Label.setBounds(10 + insets.left, 310 + insets.top, 1000, 100);
        ex9Label.setBounds(10 + insets.left, 330 + insets.top, 1000, 100);
        ex10Label.setBounds(20 + insets.left, 380 + insets.top, 1000, 100);
        ex11Label.setBounds(10 + insets.left, 415 + insets.top, 1000, 100);
        ex12Label.setBounds(10 + insets.left, 435 + insets.top, 1000, 100);
        ex13Label.setBounds(10 + insets.left, 455 + insets.top, 1000, 100);
        coolSquare1Label.setBounds(-30 + insets.left, -40 + insets.top, 1300, 200);
        coolSquare2Label.setBounds(10 + insets.left, -40 + insets.top, 1300, 200);

        // Adding elements to menubar
        menu.add(options);

        // Adding elements to menu items
        options.add(returnMenu);
        options.addSeparator();
        options.add(exit);

        // Adding elements to frame
        rummyHowFrame.add(menu);
        rummyHowFrame.add(pane);

        // Adding elements to pane
        pane.add(titleLabel);
        pane.add(dash1Label);
        pane.add(dash2Label);
        pane.add(dash3Label);
        pane.add(ex1Label);
        pane.add(ex2Label);
        pane.add(ex3Label);
        pane.add(ex4Label);
        pane.add(ex5Label);
        pane.add(ex6Label);
        pane.add(ex7Label);
        pane.add(ex8Label);
        pane.add(ex9Label);
        pane.add(ex10Label);
        pane.add(ex11Label);
        pane.add(ex12Label);
        pane.add(ex13Label);
        pane.add(coolSquare1Label);
        pane.add(coolSquare2Label);

        // Addiing action listeners to elements
        exit.addActionListener(this);
        returnMenu.addActionListener(this);
        rummyHowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        rummyHowFrame.pack();
        rummyHowFrame.setVisible(true);
        rummyHowFrame.setSize(1000, 720);
        rummyHowFrame.setJMenuBar(menu);
        rummyHowFrame.getContentPane().setBackground(tan);
        // Setting current screen location
        currentScreen = RUMMYHOW;
    }

    /**************************************************************************************************************************************************************************************
     * The actionPerformed(ActionEvent) method allows the user to click different
     * menu items, buttons, and cards.
     * 
     * @param e - The ActionEvent e parameter receives input from the user depending
     *          on where they click within the GUI screens/menus.
     */
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        // exit menu item is clicked
        if (action == exit) {
            System.exit(1);
        }

        // returnMenu menu item is clicked
        if (action == returnMenu) {
            if (currentScreen == SETTINGS) { // Returns to menu from settings screen
                settingsFrame.dispose();
                mainMenuScreen();
            } else if (currentScreen == RUMMYHOW) { // Returns to menu from how to play screen
                rummyHowFrame.dispose();
                mainMenuScreen();
            }
        }

        // settings menu item is clicked
        if (action == settings) {
            if (currentScreen == MENU) { // Changes from menu screen to settings screen
                mainMenuFrame.dispose();
                settingsScreen();
            }
        }

        // how to play menu item is clicked
        if (action == rummyHow) {
            if (currentScreen == MENU) { // Changes from menu screen to how to play screen
                mainMenuFrame.dispose();
                rummyHowScreen();
            }
        }

        // playButton button is clicked
        if (action == playButton) {
            rummy.addPlayer(numPlayers);
            mainMenuFrame.dispose();
            gameScreen();
        }

        // rummyButton button is clicked
        if (action == rummyButton) {
            // Selects rummyButton
            rummyButton.setBackground(orange);
            rummyButton.setForeground(black);

            // Fades out lakersRummyButton
            lakersRummyButton.setBackground(darkGrey);
            lakersRummyButton.setForeground(lightGrey);

            whichGame = 1;
        }

        // lakersRummyButton is clicked
        if (action == lakersRummyButton) {
            // Selects lakersRummyButton
            lakersRummyButton.setBackground(orange);
            lakersRummyButton.setForeground(black);

            // Fades out rummyButton
            rummyButton.setBackground(darkGrey);
            rummyButton.setForeground(lightGrey);

            // Setting whichGame
            whichGame = 2;
        }

        // blGreenButton is clicked
        if (action == blGreenButton) {
            // Selects blue-green color
            blGreenButton.setForeground(black);
            blGreenButton.setBackground(yellow);

            // Fades out other color buttons
            dGreenButton.setForeground(lightGrey);
            lTanButton.setForeground(lightGrey);
            dGreenButton.setBackground(darkGrey);
            lTanButton.setBackground(darkGrey);

            // Sets settings and game screen to blue-green color
            settingsFrame.getContentPane().setBackground(blueGreen);
            gameColor = BLGREEN;
        }

        // dGreenButton is clicked
        if (action == dGreenButton) {
            // Selects dark green color
            dGreenButton.setForeground(black);
            dGreenButton.setBackground(yellow);

            // Fades out other color buttons
            blGreenButton.setForeground(lightGrey);
            lTanButton.setForeground(lightGrey);
            blGreenButton.setBackground(darkGrey);
            lTanButton.setBackground(darkGrey);

            // Sets settings and game screen to dark green color
            settingsFrame.getContentPane().setBackground(darkGreen);
            gameColor = DGREEN;
        }

        // lTanButton is clicked
        if (action == lTanButton) {
            // Selects tan color
            lTanButton.setForeground(black);
            lTanButton.setBackground(yellow);

            // Fades out other color buttons
            blGreenButton.setForeground(lightGrey);
            dGreenButton.setForeground(lightGrey);
            blGreenButton.setBackground(darkGrey);
            dGreenButton.setBackground(darkGrey);

            // sets settings and game screen to tan color
            settingsFrame.getContentPane().setBackground(tan);
            gameColor = LTAN;
        }

        // ---------- GAMEPLAY ACTIONS ------------
        // discard1 button is clicked and card has been drawn
        if (action == discard1 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(0));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard2 button is clicked and card has been drawn
        if (action == discard2 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(1));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard3 button is clicked and card has been drawn
        if (action == discard3 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(2));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard4 button is clicked and card has been drawn
        if (action == discard4 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(3));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard5 button is clicked and card has been drawn
        if (action == discard5 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(4));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard6 button is clicked and card has been drawn
        if (action == discard6 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(5));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard7 button is clicked and card has been drawn
        if (action == discard7 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(6));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // discard8 button is clicked and card has been drawn
        if (action == discard8 && drawn) {
            rummy.discard(rummy.getPlayer(turn % numPlayers), current.hand.cardArr.get(7));
            drawn = false;
            turn++;
            waitingTime = true;
            makeMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            addToMeldButton.setBounds(2000 + insets.left, 2000 + insets.top, 145, 50);
            pane.remove(waitingLabel);
            pane.remove(readyButton);
            pane.remove(waitingLabel);
            gameFrame.dispose();
            gameScreen();
            // UNSURE WHAT ELSE TO DO HERE OR EVEN IF THIS IS RIGHT
        }

        // makeMeldButton is clicked
        if (action == makeMeldButton && drawn) {
            makeMeld = true;
            addToMeld = false;
            makeMeldButton.setBackground(yellow);
            addToMeldButton.setBackground(orange);
            confirmButton.setBounds(25 + insets.left, 305 + insets.top, 75, 30);
            cancelButton.setBounds(120 + insets.left, 305 + insets.top, 75, 30);
            select1.setBackground(orange);
            select2.setBackground(orange);
            select3.setBackground(orange);
            select4.setBackground(orange);
            select5.setBackground(orange);
            select6.setBackground(orange);
            select7.setBackground(orange);
            select8.setBackground(orange);
            discard1.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard2.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard3.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard4.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard5.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard6.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard7.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard8.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            setMeldButtons(current);
        }

        // select1 button is clicked and makeMeldButton has been clicked
        if (action == select1 && makeMeld && drawn) {
            select1.setBackground(yellow);
        }

        // select2 button is clicked and makeMeldButton has been clicked
        if (action == select2 && makeMeld && drawn) {
            select2.setBackground(yellow);
        }

        // select3 button is clicked and makeMeldButton has been clicked
        if (action == select3 && makeMeld && drawn) {
            select3.setBackground(yellow);
        }

        // select4 button is clicked and makeMeldButton has been clicked
        if (action == select4 && makeMeld && drawn) {
            select4.setBackground(yellow);
        }

        // select5 button is clicked and makeMeldButton has been clicked
        if (action == select5 && makeMeld && drawn) {
            select5.setBackground(yellow);
        }

        // select6 button is clicked and makeMeldButton has been clicked
        if (action == select6 && makeMeld && drawn) {
            select6.setBackground(yellow);
        }

        // select7 button is clicked and makeMeldButton has been clicked
        if (action == select7 && makeMeld && drawn) {
            select7.setBackground(yellow);
        }

        // select8 button is clicked and makeMeldButton has been clicked
        if (action == select8 && makeMeld && drawn) {
            select8.setBackground(yellow);
        }

        // addToMeldButton is clicked
        if (action == addToMeldButton && drawn) {
            addToMeld = true;
            makeMeld = false;
            makeMeldButton.setBackground(orange);
            addToMeldButton.setBackground(yellow);
            confirmButton.setBounds(25 + insets.left, 305 + insets.top, 75, 30);
            cancelButton.setBounds(120 + insets.left, 305 + insets.top, 75, 30);
            select1.setBackground(orange);
            select2.setBackground(orange);
            select3.setBackground(orange);
            select4.setBackground(orange);
            select5.setBackground(orange);
            select6.setBackground(orange);
            select7.setBackground(orange);
            select8.setBackground(orange);
            discard1.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard2.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard3.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard4.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard5.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard6.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard7.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            discard8.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            setMeldButtons(current);
        }

        // select1 button is clicked and addToMeldButton has been clicked
        if (action == select1 && addToMeld && drawn) {
            select1.setBackground(yellow);
        }

        // select2 button is clicked and addToMeldButton has been clicked
        if (action == select2 && addToMeld && drawn) {
            select2.setBackground(yellow);
        }

        // select3 button is clicked and addToMeldButton has been clicked
        if (action == select3 && addToMeld && drawn) {
            select3.setBackground(yellow);
        }

        // select4 button is clicked and addToMeldButton has been clicked
        if (action == select4 && addToMeld && drawn) {
            select4.setBackground(yellow);
        }

        // select5 button is clicked and addToMeldButton has been clicked
        if (action == select5 && addToMeld && drawn) {
            select5.setBackground(yellow);
        }

        // select6 button is clicked and addToMeldButton has been clicked
        if (action == select6 && addToMeld && drawn) {
            select6.setBackground(yellow);
        }

        // select7 button is clicked and addToMeldButton has been clicked
        if (action == select7 && addToMeld && drawn) {
            select7.setBackground(yellow);
        }

        // select8 button is clicked and addToMeldButton has been clicked
        if (action == select8 && addToMeld && drawn) {
            select8.setBackground(yellow);
        }

        // cancelButton is clicked and addToMeldButton has been clicked
        if (action == cancelButton && addToMeld && drawn) {
            addToMeld = false;
            makeMeldButton.setBackground(orange);
            addToMeldButton.setBackground(orange);
            confirmButton.setBounds(2000 + insets.left, 2000 + insets.top, 75, 30);
            cancelButton.setBounds(2000 + insets.left, 2000 + insets.top, 75, 30);
            select1.setBackground(orange);
            select2.setBackground(orange);
            select3.setBackground(orange);
            select4.setBackground(orange);
            select5.setBackground(orange);
            select6.setBackground(orange);
            select7.setBackground(orange);
            select8.setBackground(orange);
            select1.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select2.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select3.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select4.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select5.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select6.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select7.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select8.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            setDiscardButtons(current);
        }

        // cancelButton is clicked and makMeldButton has been clicked
        if (action == cancelButton && makeMeld && drawn) {
            makeMeld = false;
            makeMeldButton.setBackground(orange);
            addToMeldButton.setBackground(orange);
            confirmButton.setBounds(2000 + insets.left, 2000 + insets.top, 75, 30);
            cancelButton.setBounds(2000 + insets.left, 2000 + insets.top, 75, 30);
            select1.setBackground(orange);
            select2.setBackground(orange);
            select3.setBackground(orange);
            select4.setBackground(orange);
            select5.setBackground(orange);
            select6.setBackground(orange);
            select7.setBackground(orange);
            select8.setBackground(orange);
            select1.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select2.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select3.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select4.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select5.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select6.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select7.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            select8.setBounds(2000 + insets.left, 2000 + insets.top, 600, 100);
            setDiscardButtons(current);
        }

        if (action == readyButton) {
            waitingLabel.setBounds(2000 + insets.left, 2000 + insets.top, 1500, 700);
            waitTitleLabel.setBounds(2000 + insets.left, 2000 + insets.top, 1200, 200);
            readyButton.setBounds(2000 + insets.left, 2000 + insets.top, 300, 80);
        }
        // if(action == hand1){
        // if(makeMeld){

        // } else if(addToMeld){

        // } else { // if card is clicked and not trying to make a new meld or add to
        // meld, discard
        // if(drawn){
        // rummy.discard(rummy.getPlayer(turn % numPlayers), rummy.getPlayer(turn %
        // numPlayers).hand.cardArr.get(0));
        // }
        // }
        // }
    }

    /**************************************************************************************************************************************************************************************
     * The updateHand(int playerNum) method populates the bottom of the screen with
     * the cards in the player's hand
     * 
     * @param playerNum number of player whose cards are shown
     */
    private void updateHand(int playerNum) {
        gameFrame.dispose();
        gameScreen();

    }

    /**************************************************************************************************************************************************************************************
     * adds discard buttons for each card in the player's hand
     * 
     * @param player the player whose turn it currently is
     */
    private void setDiscardButtons(Player player) {
        // Checks how many cards remain in hand and adds buttons accordingly
        if (player.hand.cardArr.size() > 0 && drawn) {
            discard1.setBounds(handLabels[0].getX() + 5, handLabels[0].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 1 && drawn) {
            discard2.setBounds(handLabels[1].getX() + 5, handLabels[1].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 2 && drawn) {
            discard3.setBounds(handLabels[2].getX() + 5, handLabels[2].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 3 && drawn) {
            discard4.setBounds(handLabels[3].getX() + 5, handLabels[3].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 4 && drawn) {
            discard5.setBounds(handLabels[4].getX() + 5, handLabels[4].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 5 && drawn) {
            discard6.setBounds(handLabels[5].getX() + 5, handLabels[5].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 6 && drawn) {
            discard7.setBounds(handLabels[6].getX() + 5, handLabels[6].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 7 && drawn) {
            discard8.setBounds(handLabels[7].getX() + 5, handLabels[7].getY() - 55, 90, 40);
        }
    }

    /**************************************************************************************************************************************************************************************
     * adds meld buttons for each card in the player's hand
     * 
     * @param player the player whose turn it currently is
     */
    private void setMeldButtons(Player player) {
        // Checks how many cards remain in hand and adds buttons accordingly
        if (player.hand.cardArr.size() > 0 && makeMeld || addToMeld) {
            select1.setBounds(handLabels[0].getX() + 5, handLabels[0].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 1 && makeMeld || addToMeld) {
            select2.setBounds(handLabels[1].getX() + 5, handLabels[1].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 2 && makeMeld || addToMeld) {
            select3.setBounds(handLabels[2].getX() + 5, handLabels[2].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 3 && makeMeld || addToMeld) {
            select4.setBounds(handLabels[3].getX() + 5, handLabels[3].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 4 && makeMeld || addToMeld) {
            select5.setBounds(handLabels[4].getX() + 5, handLabels[4].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 5 && makeMeld || addToMeld) {
            select6.setBounds(handLabels[5].getX() + 5, handLabels[5].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 6 && makeMeld || addToMeld) {
            select7.setBounds(handLabels[6].getX() + 5, handLabels[6].getY() - 55, 90, 40);
        }
        if (player.hand.cardArr.size() > 7 && makeMeld || addToMeld) {
            select8.setBounds(handLabels[7].getX() + 5, handLabels[7].getY() - 55, 90, 40);
        }
    }

    private void displayDiscard() {
        if (!rummy.getDiscard().cardArr.isEmpty()) {
            Card discardShowing = rummy.getDiscard().cardArr.get(rummy.getDiscard().cardArr.size() - 1);
            discardLabel = cardMapSmall.get(discardShowing);
            discardLabel.setBounds(60 + insets.left, 470 + insets.bottom, 100, 135);
            pane.remove(rectangleLeftLabel);
            pane.add(discardLabel);
            pane.add(rectangleLeftLabel);
            discardLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (!drawn) {
                        rummy.draw(rummy.getDiscard(), rummy.getPlayer(turn % numPlayers).hand);
                        gameFrame.dispose();
                        setup = true;
                        drawn = true;
                        gameScreen();
                        makeMeldButton.setBounds(35 + insets.left, 235 + insets.top, 145, 50);
                        addToMeldButton.setBounds(35 + insets.left, 355 + insets.top, 145, 50);
                    }
                }
            });
        }
    }

    /**************************************************************************************************************************************************************************************
     * The main(String[] args) method allows for the RummyGUI class to be ran.
     * 
     * @param args - A String[] array representing the arguments being passed to
     *             main.
     */
    public static void main(String[] args) {
        new RummyGUI();
    }
}
