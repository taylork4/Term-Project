import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.Buffer;
import java.util.HashMap;

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
    private JFrame mainMenuFrame, gameFrame, settingsFrame;

    // JMenuBar declarations
    private JMenuBar menu;

    // JMenu declarations
    private JMenu options, tutorial;

    // JMenuItem declarations
    private JMenuItem returnMenu, returnGame, rummyHow, lakersRummyHow,
            settings, exit;

    // JButton declarations
    private JButton playButton, rummyButton, lakersRummyButton, makeMeldButton,
            addToMeldButton;
    private JButton onePlayerButton, twoPlayerButton, threePlayerButton, // Number of players buttons
            fourPlayerButton;

    // JLabel declarations
    private JLabel titleLabel, p1Label, p2Label, p3Label, p4Label, cardDeckLabel,
            dash1Label, dash2Label, dash3Label, rectangleLeftLabel, octopusLabel,
            rectangleRightLabel, seaGullLabel, whaleLabel, crabLabel, underWLabel,
            crabGIFLabel;
    private JLabel cardAnchorA, cardAnchor2, cardAnchor3, cardAnchor4, // Anchor label for suit
            cardAnchor5, cardAnchor6, cardAnchor7, cardAnchor8, cardAnchor9,
            cardAnchor10, cardAnchorJ, cardAnchorQ, cardAnchorK;
    private JLabel cardClockTowA, cardClockTow2, cardClockTow3, cardClockTow4, // Clock Tower label for suit
            cardClockTow5, cardClockTow6, cardClockTow7, cardClockTow8,
            cardClockTow9, cardClockTow10, cardClockTowJ, cardClockTowQ,
            cardClockTowK;
    private JLabel cardGVLogoA, cardGVLogo2, cardGVLogo3, cardGVLogo4, // GVLogo label for suit
            cardGVLogo5, cardGVLogo6, cardGVLogo7, cardGVLogo8, cardGVLogo9,
            cardGVLogo10, cardGVLogoJ, cardGVLogoQ, cardGVLogoK;
    private JLabel cardSailorA, cardSailor2, cardSailor3, cardSailor4, // Sailor label for suit
            cardSailor5, cardSailor6, cardSailor7, cardSailor8, cardSailor9,
            cardSailor10, cardSailorJ, cardSailorQ, cardSailorK;
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
    private JLabel hand1, hand2, hand3, hand4, hand5, hand6, hand7;
    private JLabel[] handLabels = { hand1, hand2, hand3, hand4, hand5, hand6, hand7 };

    // ImageIcon declarations
    private ImageIcon settingsGear, redX, backOfCardLR, how2Play, returnBack,
            rectangleLeft, rectangleRight, avatar1, avatar2, avatar3, avatar4,
            underWater, crabGIF, GValleyJava;
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
            gameButtonFont, numPlayersButtonFont, avatarFont;

    // LineBorder declarations
    private LineBorder cardBorder, cardHighlightBorder, menuBorder,
            buttonBorder, meldBorder;

    // Color declarations
    private Color black, darkGrey, grey, lightGrey, white,
            red, orange, brightOrange, yellow, green, blue,
            aquaBlue, cyan, magenta, pink, darkTan, tan;

    // Container declarations
    private Container pane;

    // Insets declarations
    private Insets insets;

    // Game status variable declarations
    private final int MENU, GAME, SETTINGS;
    private int whichGame, numPlayers, currentScreen;
    private boolean gameInProg, deckClick, handCardClick, hasSetClicks;
    private Rummy rummy = new Rummy();
    private HashMap<Card, JLabel> cardMap = new HashMap<Card, JLabel>();

    /**************************************************************************************************************************************************************************************
     * The default constructor for the RummyGUI() class. Within this constructor,
     * a menu bars is created allowing for access to the settings as well as the
     * ability to close out of the game.
     */
    public RummyGUI() {
        // Creating image icons
        GValleyJava = new ImageIcon("images/GValleyJava.png");
        avatar1 = new ImageIcon("images/seaGull.jpg");
        avatar2 = new ImageIcon("images/whale.jpg");
        avatar3 = new ImageIcon("images/octopus.jpg");
        avatar4 = new ImageIcon("images/crab.jpg");
        crabGIF = new ImageIcon("images/crabGif.gif");
        underWater = new ImageIcon("images/underWater.png");
        rectangleLeft = new ImageIcon("images/gameBackgroundTan.png");
        rectangleRight = new ImageIcon("images/gameBackgroundTan.png");
        settingsGear = new ImageIcon("images/settings-gear.png");
        redX = new ImageIcon("images/red-x.png");
        how2Play = new ImageIcon("images/how2Play.png");
        returnBack = new ImageIcon("images/returnBack.png");
        backOfCardLR = new ImageIcon("images/LR_Cards/LRBackCardDesign.jpg");
        anchorA = new ImageIcon("images/LR_Cards/Anchors/AceAnchor.jpg");
        anchor2 = new ImageIcon("images/LR_Cards/Anchors/2Anchor.jpg");
        anchor3 = new ImageIcon("images/LR_Cards/Anchors/3Anchor.jpg");
        anchor4 = new ImageIcon("images/LR_Cards/Anchors/4Anchor.jpg");
        anchor5 = new ImageIcon("images/LR_Cards/Anchors/5Anchor.jpg");
        anchor6 = new ImageIcon("images/LR_Cards/Anchors/6Anchor.jpg");
        anchor7 = new ImageIcon("images/LR_Cards/Anchors/7Anchor.jpg");
        anchor8 = new ImageIcon("images/LR_Cards/Anchors/8Anchor.jpg");
        anchor9 = new ImageIcon("images/LR_Cards/Anchors/9Anchor.jpg");
        anchor10 = new ImageIcon("images/LR_Cards/Anchors/10Anchor.jpg");
        anchorJ = new ImageIcon("images/LR_Cards/Anchors/JackAnchor.jpg");
        anchorQ = new ImageIcon("images/LR_Cards/Anchors/QueenAnchor.jpg");
        anchorK = new ImageIcon("images/LR_Cards/Anchors/KingAnchor.jpg");
        clockTowA = new ImageIcon("images/LR_Cards/ClockTowers/AceCT.jpg");
        clockTow2 = new ImageIcon("images/LR_Cards/ClockTowers/2CT.jpg");
        clockTow3 = new ImageIcon("images/LR_Cards/ClockTowers/3CT.jpg");
        clockTow4 = new ImageIcon("images/LR_Cards/ClockTowers/4CT.jpg");
        clockTow5 = new ImageIcon("images/LR_Cards/ClockTowers/5CT.jpg");
        clockTow6 = new ImageIcon("images/LR_Cards/ClockTowers/6CT.jpg");
        clockTow7 = new ImageIcon("images/LR_Cards/ClockTowers/7CT.jpg");
        clockTow8 = new ImageIcon("images/LR_Cards/ClockTowers/8CT.jpg");
        clockTow9 = new ImageIcon("images/LR_Cards/ClockTowers/9CT.jpg");
        clockTow10 = new ImageIcon("images/LR_Cards/ClockTowers/10CT.jpg");
        clockTowJ = new ImageIcon("images/LR_Cards/ClockTowers/JackCT.jpg");
        clockTowQ = new ImageIcon("images/LR_Cards/ClockTowers/QueenCT.jpg");
        clockTowK = new ImageIcon("images/LR_Cards/ClockTowers/KingCT.jpg");
        logoGVA = new ImageIcon("images/LR_Cards/GVLogo/AceGVLogo.jpg");
        logoGV2 = new ImageIcon("images/LR_Cards/GVLogo/2GVLogo.jpg");
        logoGV3 = new ImageIcon("images/LR_Cards/GVLogo/3GVLogo.jpg");
        logoGV4 = new ImageIcon("images/LR_Cards/GVLogo/4GVLogo.jpg");
        logoGV5 = new ImageIcon("images/LR_Cards/GVLogo/5GVLogo.jpg");
        logoGV6 = new ImageIcon("images/LR_Cards/GVLogo/6GVLogo.jpg");
        logoGV7 = new ImageIcon("images/LR_Cards/GVLogo/7GVLogo.jpg");
        logoGV8 = new ImageIcon("images/LR_Cards/GVLogo/8GVLogo.jpg");
        logoGV9 = new ImageIcon("images/LR_Cards/GVLogo/9GVLogo.jpg");
        logoGV10 = new ImageIcon("images/LR_Cards/GVLogo/10GVLogo.jpg");
        logoGVJ = new ImageIcon("images/LR_Cards/GVLogo/JackGVLogo.jpg");
        logoGVQ = new ImageIcon("images/LR_Cards/GVLogo/QueenGVLogo.jpg");
        logoGVK = new ImageIcon("images/LR_Cards/GVLogo/KingGVLogo.jpg");
        sailorA = new ImageIcon("images/LR_Cards/Sailor/AceSailor");
        sailor2 = new ImageIcon("images/LR_Cards/Sailor/2Sailor");
        sailor3 = new ImageIcon("images/LR_Cards/Sailor/3Sailor");
        sailor4 = new ImageIcon("images/LR_Cards/Sailor/4Sailor");
        sailor5 = new ImageIcon("images/LR_Cards/Sailor/5Sailor");
        sailor6 = new ImageIcon("images/LR_Cards/Sailor/6Sailor");
        sailor7 = new ImageIcon("images/LR_Cards/Sailor/7Sailor");
        sailor8 = new ImageIcon("images/LR_Cards/Sailor/8Sailor");
        sailor9 = new ImageIcon("images/LR_Cards/Sailor/9Sailor");
        sailor10 = new ImageIcon("images/LR_Cards/Sailor/10Sailor");
        sailorJ = new ImageIcon("images/LR_Cards/Sailor/JackSailor");
        sailorQ = new ImageIcon("images/LR_Cards/Sailor/QueenSailor");
        sailorK = new ImageIcon("images/LR_Cards/Sailor/KingSailor");
        anchorAS = new ImageIcon("images/LR_Cards/AnchorsS/AceAnchorS.jpg");
        anchor2S = new ImageIcon("images/LR_Cards/AnchorsS/2AnchorS.jpg");
        anchor3S = new ImageIcon("images/LR_Cards/AnchorsS/3AnchorS.jpg");
        anchor4S = new ImageIcon("images/LR_Cards/AnchorsS/4AnchorS.jpg");
        anchor5S = new ImageIcon("images/LR_Cards/AnchorsS/5AnchorS.jpg");
        anchor6S = new ImageIcon("images/LR_Cards/AnchorsS/6AnchorS.jpg");
        anchor7S = new ImageIcon("images/LR_Cards/AnchorsS/7AnchorS.jpg");
        anchor8S = new ImageIcon("images/LR_Cards/AnchorsS/8AnchorS.jpg");
        anchor9S = new ImageIcon("images/LR_Cards/AnchorsS/9AnchorS.jpg");
        anchor10S = new ImageIcon("images/LR_Cards/AnchorsS/10AnchorS.jpg");
        anchorJS = new ImageIcon("images/LR_Cards/AnchorsS/JackAnchorS.jpg");
        anchorQS = new ImageIcon("images/LR_Cards/AnchorsS/QueenAnchorS.jpg");
        anchorKS = new ImageIcon("images/LR_Cards/AnchorsS/KingAnchorS.jpg");
        clockTowAS = new ImageIcon("images/LR_Cards/ClockTowersS/AceCTS.jpg");
        clockTow2S = new ImageIcon("images/LR_Cards/ClockTowersS/2CTS.jpg");
        clockTow3S = new ImageIcon("images/LR_Cards/ClockTowersS/3CTS.jpg");
        clockTow4S = new ImageIcon("images/LR_Cards/ClockTowersS/4CTS.jpg");
        clockTow5S = new ImageIcon("images/LR_Cards/ClockTowersS/5CTS.jpg");
        clockTow6S = new ImageIcon("images/LR_Cards/ClockTowersS/6CTS.jpg");
        clockTow7S = new ImageIcon("images/LR_Cards/ClockTowersS/7CTS.jpg");
        clockTow8S = new ImageIcon("images/LR_Cards/ClockTowersS/8CTS.jpg");
        clockTow9S = new ImageIcon("images/LR_Cards/ClockTowersS/9CTS.jpg");
        clockTow10S = new ImageIcon("images/LR_Cards/ClockTowersS/10CTS.jpg");
        clockTowJS = new ImageIcon("images/LR_Cards/ClockTowersS/JackCTS.jpg");
        clockTowQS = new ImageIcon("images/LR_Cards/ClockTowersS/QueenCTS.jpg");
        clockTowKS = new ImageIcon("images/LR_Cards/ClockTowersS/KingCTS.jpg");
        logoGVAS = new ImageIcon("images/LR_Cards/GVLogoS/AceGVLogoS.jpg");
        logoGV2S = new ImageIcon("images/LR_Cards/GVLogoS/2GVLogoS.jpg");
        logoGV3S = new ImageIcon("images/LR_Cards/GVLogoS/3GVLogoS.jpg");
        logoGV4S = new ImageIcon("images/LR_Cards/GVLogoS/4GVLogoS.jpg");
        logoGV5S = new ImageIcon("images/LR_Cards/GVLogoS/5GVLogoS.jpg");
        logoGV6S = new ImageIcon("images/LR_Cards/GVLogoS/6GVLogoS.jpg");
        logoGV7S = new ImageIcon("images/LR_Cards/GVLogoS/7GVLogoS.jpg");
        logoGV8S = new ImageIcon("images/LR_Cards/GVLogoS/8GVLogoS.jpg");
        logoGV9S = new ImageIcon("images/LR_Cards/GVLogoS/9GVLogoS.jpg");
        logoGV10S = new ImageIcon("images/LR_Cards/GVLogoS/10GVLogoS.jpg");
        logoGVJS = new ImageIcon("images/LR_Cards/GVLogoS/JackGVLogoS.jpg");
        logoGVQS = new ImageIcon("images/LR_Cards/GVLogoS/QueenGVLogoS.jpg");
        logoGVKS = new ImageIcon("images/LR_Cards/GVLogoS/KingGVLogoS.jpg");
        sailorAS = new ImageIcon("images/LR_Cards/SailorS/AceSailorS");
        sailor2S = new ImageIcon("images/LR_Cards/SailorS/2SailorS");
        sailor3S = new ImageIcon("images/LR_Cards/SailorS/3SailorS");
        sailor4S = new ImageIcon("images/LR_Cards/SailorS/4SailorS");
        sailor5S = new ImageIcon("images/LR_Cards/SailorS/5SailorS");
        sailor6S = new ImageIcon("images/LR_Cards/SailorS/6SailorS");
        sailor7S = new ImageIcon("images/LR_Cards/SailorS/7SailorS");
        sailor8S = new ImageIcon("images/LR_Cards/SailorS/8SailorS");
        sailor9S = new ImageIcon("images/LR_Cards/SailorS/9SailorS");
        sailor10S = new ImageIcon("images/LR_Cards/SailorS/10SailorS");
        sailorJS = new ImageIcon("images/LR_Cards/SailorS/JackSailorS");
        sailorQS = new ImageIcon("images/LR_Cards/SailorS/QueenSailorS");
        sailorKS = new ImageIcon("images/LR_Cards/SailorS/KingSailorS");

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
        blue = Color.BLUE;
        aquaBlue = new Color(5, 195, 228);
        cyan = Color.CYAN;
        magenta = Color.MAGENTA;
        pink = Color.PINK;
        darkTan = new Color(255, 190, 130);
        tan = new Color(255, 215, 175);

        // Creating fonts
        titleFont = new Font("Segoe Script", Font.BOLD, 120);
        menuFont = new Font("Georgia", Font.PLAIN, 21);
        subMenuFont = new Font("Cooper Black", Font.PLAIN, 21);
        avatarFont = new Font("Georgia", Font.ITALIC, 15);
        playButtonFont = new Font("Courier", Font.BOLD, 50);
        gameButtonFont = new Font("Courier", Font.BOLD, 40);
        numPlayersButtonFont = new Font("Courier", Font.BOLD, 30);

        // Creating borders
        cardBorder = new LineBorder(black, 2);
        cardHighlightBorder = new LineBorder(magenta, 3);
        meldBorder = new LineBorder(black, 3);
        menuBorder = new LineBorder(black, 1);
        buttonBorder = new LineBorder(black, 5);

        // Initializing final int values
        MENU = 1;
        SETTINGS = 2;
        GAME = 3;

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
        underWLabel = new JLabel(underWater);
        crabGIFLabel = new JLabel(crabGIF);

        // Creating buttons
        playButton = new JButton("Play");
        rummyButton = new JButton("Rummy");
        lakersRummyButton = new JButton("Lakers Rummy");
        onePlayerButton = new JButton("1-P");
        twoPlayerButton = new JButton("2-P");
        threePlayerButton = new JButton("3-P");
        fourPlayerButton = new JButton("4-P");

        // Creating menus
        options = new JMenu("Options");
        tutorial = new JMenu(" How to Play");

        // Creating menu items
        settings = new JMenuItem(" Settings", settingsGear);
        exit = new JMenuItem(" Exit", redX);
        rummyHow = new JMenuItem(" Rummy", how2Play);
        lakersRummyHow = new JMenuItem(" Lakers Rummy", how2Play);

        // Setting frame icon
        mainMenuFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        playButton.setBackground(brightOrange);
        rummyButton.setBackground(orange);
        lakersRummyButton.setBackground(darkGrey);
        onePlayerButton.setBackground(yellow);
        twoPlayerButton.setBackground(darkGrey);
        threePlayerButton.setBackground(darkGrey);
        fourPlayerButton.setBackground(darkGrey);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        titleLabel.setForeground(black);
        options.setForeground(black);
        tutorial.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);
        rummyHow.setForeground(black);
        lakersRummyHow.setForeground(black);
        playButton.setForeground(black);
        rummyButton.setForeground(black);
        lakersRummyButton.setForeground(lightGrey);
        onePlayerButton.setForeground(black);
        twoPlayerButton.setForeground(lightGrey);
        threePlayerButton.setForeground(lightGrey);
        fourPlayerButton.setForeground(lightGrey);

        // Setting fonts
        titleLabel.setFont(titleFont);
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        lakersRummyHow.setFont(subMenuFont);
        playButton.setFont(playButtonFont);
        rummyButton.setFont(gameButtonFont);
        lakersRummyButton.setFont(gameButtonFont);
        onePlayerButton.setFont(numPlayersButtonFont);
        twoPlayerButton.setFont(numPlayersButtonFont);
        threePlayerButton.setFont(numPlayersButtonFont);
        fourPlayerButton.setFont(numPlayersButtonFont);

        // Setting borders
        playButton.setBorder(buttonBorder);
        rummyButton.setBorder(buttonBorder);
        lakersRummyButton.setBorder(buttonBorder);
        onePlayerButton.setBorder(buttonBorder);
        twoPlayerButton.setBorder(buttonBorder);
        threePlayerButton.setBorder(buttonBorder);
        fourPlayerButton.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        crabGIFLabel.setBounds(565 + insets.left, 75 + insets.top, 100, 75);
        underWLabel.setBounds(0 + insets.left, 0 + insets.top, 1500, 700);
        titleLabel.setBounds(185 + insets.left, 10 + insets.top, 1000, 150);
        playButton.setBounds(520 + insets.left, 150 + insets.top, 200, 120);
        rummyButton.setBounds(285 + insets.left, 300 + insets.top, 275, 130);
        lakersRummyButton.setBounds(675 + insets.left, 300 + insets.top, 325, 130);
        onePlayerButton.setBounds(150 + insets.left, 450 + insets.top, 100, 80);
        twoPlayerButton.setBounds(300 + insets.left, 450 + insets.top, 100, 80);
        threePlayerButton.setBounds(450 + insets.left, 450 + insets.top, 100, 80);
        fourPlayerButton.setBounds(600 + insets.left, 450 + insets.top, 100, 80);

        // Adding elements to menubar
        menu.add(options);
        menu.add(tutorial);

        // Adding elements to menu items
        options.add(settings);
        options.addSeparator();
        options.add(exit);
        tutorial.add(rummyHow);
        tutorial.add(lakersRummyHow);

        // Adding elements to frame
        mainMenuFrame.add(menu);
        mainMenuFrame.add(pane);

        // Adding elements to pane
        pane.add(titleLabel);
        pane.add(crabGIFLabel);
        pane.add(playButton);
        pane.add(rummyButton);
        pane.add(lakersRummyButton);
        pane.add(onePlayerButton);
        pane.add(twoPlayerButton);
        pane.add(threePlayerButton);
        pane.add(fourPlayerButton);
        pane.add(underWLabel);

        // Addiing action listeners to elements
        settings.addActionListener(this);
        tutorial.addActionListener(this);
        exit.addActionListener(this);
        playButton.addActionListener(this);
        rummyButton.addActionListener(this);
        lakersRummyButton.addActionListener(this);
        onePlayerButton.addActionListener(this);
        twoPlayerButton.addActionListener(this);
        threePlayerButton.addActionListener(this);
        fourPlayerButton.addActionListener(this);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        mainMenuFrame.pack();
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setSize(1280, 720);
        mainMenuFrame.setJMenuBar(menu);
        mainMenuFrame.getContentPane().setBackground(aquaBlue);

        // Setting default whichGame and howManyPlayers
        whichGame = 1;
        numPlayers = 1;
        currentScreen = MENU;
        gameInProg = false;
        deckClick = false;
        handCardClick = false;
        hasSetClicks = false;
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
        seaGullLabel = new JLabel(avatar1);
        whaleLabel = new JLabel(avatar2);
        octopusLabel = new JLabel(avatar3);
        crabLabel = new JLabel(avatar4);
        p1Label = new JLabel("Cards in hand: ");
        p2Label = new JLabel("Cards in hand: ");
        p3Label = new JLabel("Cards in hand: ");
        p4Label = new JLabel("Cards in hand: ");
        dash1Label = new JLabel("_______");
        dash2Label = new JLabel("_______");
        dash3Label = new JLabel("_______");
        rectangleLeftLabel = new JLabel(rectangleLeft);
        rectangleRightLabel = new JLabel(rectangleRight);
        cardDeckLabel = new JLabel(backOfCardLR);
        cardAnchorA = new JLabel(anchorA);
        cardAnchor2 = new JLabel(anchor2);
        cardAnchor3 = new JLabel(anchor3);
        cardAnchor4 = new JLabel(anchor4);
        cardAnchor5 = new JLabel(anchor5);
        cardAnchor6 = new JLabel(anchor6);
        cardAnchor7 = new JLabel(anchor7);
        cardAnchor8 = new JLabel(anchor8);
        cardAnchor9 = new JLabel(anchor9);
        cardAnchor10 = new JLabel(anchor10);
        cardAnchorJ = new JLabel(anchorJ);
        cardAnchorQ = new JLabel(anchorQ);
        cardAnchorK = new JLabel(anchorK);
        cardClockTowA = new JLabel(clockTowA);
        cardClockTow2 = new JLabel(clockTow2);
        cardClockTow3 = new JLabel(clockTow3);
        cardClockTow4 = new JLabel(clockTow4);
        cardClockTow5 = new JLabel(clockTow5);
        cardClockTow6 = new JLabel(clockTow6);
        cardClockTow7 = new JLabel(clockTow7);
        cardClockTow8 = new JLabel(clockTow8);
        cardClockTow9 = new JLabel(clockTow9);
        cardClockTow10 = new JLabel(clockTow10);
        cardClockTowJ = new JLabel(clockTowJ);
        cardClockTowQ = new JLabel(clockTowQ);
        cardClockTowK = new JLabel(clockTowK);
        cardGVLogoA = new JLabel(logoGVA);
        cardGVLogo2 = new JLabel(logoGV2);
        cardGVLogo3 = new JLabel(logoGV3);
        cardGVLogo4 = new JLabel(logoGV4);
        cardGVLogo5 = new JLabel(logoGV5);
        cardGVLogo6 = new JLabel(logoGV6);
        cardGVLogo7 = new JLabel(logoGV7);
        cardGVLogo8 = new JLabel(logoGV8);
        cardGVLogo9 = new JLabel(logoGV9);
        cardGVLogo10 = new JLabel(logoGV10);
        cardGVLogoJ = new JLabel(logoGVJ);
        cardGVLogoQ = new JLabel(logoGVQ);
        cardGVLogoK = new JLabel(logoGVK);
        cardSailorA = new JLabel(sailorA);
        cardSailor2 = new JLabel(sailor2);
        cardSailor3 = new JLabel(sailor3);
        cardSailor4 = new JLabel(sailor4);
        cardSailor5 = new JLabel(sailor5);
        cardSailor6 = new JLabel(sailor6);
        cardSailor7 = new JLabel(sailor7);
        cardSailor8 = new JLabel(sailor8);
        cardSailor9 = new JLabel(sailor9);
        cardSailor10 = new JLabel(sailor10);
        cardSailorJ = new JLabel(sailorJ);
        cardSailorQ = new JLabel(sailorQ);
        cardSailorK = new JLabel(sailorK);
        cardAnchorAS = new JLabel(anchorAS);
        cardAnchor2S = new JLabel(anchor2S);
        cardAnchor3S = new JLabel(anchor3S);
        cardAnchor4S = new JLabel(anchor4S);
        cardAnchor5S = new JLabel(anchor5S);
        cardAnchor6S = new JLabel(anchor6S);
        cardAnchor7S = new JLabel(anchor7S);
        cardAnchor8S = new JLabel(anchor8S);
        cardAnchor9S = new JLabel(anchor9S);
        cardAnchor10S = new JLabel(anchor10S);
        cardAnchorJS = new JLabel(anchorJS);
        cardAnchorQS = new JLabel(anchorQS);
        cardAnchorKS = new JLabel(anchorKS);
        cardClockTowAS = new JLabel(clockTowAS);
        cardClockTow2S = new JLabel(clockTow2S);
        cardClockTow3S = new JLabel(clockTow3S);
        cardClockTow4S = new JLabel(clockTow4S);
        cardClockTow5S = new JLabel(clockTow5S);
        cardClockTow6S = new JLabel(clockTow6S);
        cardClockTow7S = new JLabel(clockTow7S);
        cardClockTow8S = new JLabel(clockTow8S);
        cardClockTow9S = new JLabel(clockTow9S);
        cardClockTow10S = new JLabel(clockTow10S);
        cardClockTowJS = new JLabel(clockTowJS);
        cardClockTowQS = new JLabel(clockTowQS);
        cardClockTowKS = new JLabel(clockTowKS);
        cardGVLogoAS = new JLabel(logoGVAS);
        cardGVLogo2S = new JLabel(logoGV2S);
        cardGVLogo3S = new JLabel(logoGV3S);
        cardGVLogo4S = new JLabel(logoGV4S);
        cardGVLogo5S = new JLabel(logoGV5S);
        cardGVLogo6S = new JLabel(logoGV6S);
        cardGVLogo7S = new JLabel(logoGV7S);
        cardGVLogo8S = new JLabel(logoGV8S);
        cardGVLogo9S = new JLabel(logoGV9S);
        cardGVLogo10S = new JLabel(logoGV10S);
        cardGVLogoJS = new JLabel(logoGVJS);
        cardGVLogoQS = new JLabel(logoGVQS);
        cardGVLogoKS = new JLabel(logoGVKS);
        cardSailorAS = new JLabel(sailorAS);
        cardSailor2S = new JLabel(sailor2S);
        cardSailor3S = new JLabel(sailor3S);
        cardSailor4S = new JLabel(sailor4S);
        cardSailor5S = new JLabel(sailor5S);
        cardSailor6S = new JLabel(sailor6S);
        cardSailor7S = new JLabel(sailor7S);
        cardSailor8S = new JLabel(sailor8S);
        cardSailor9S = new JLabel(sailor9S);
        cardSailor10S = new JLabel(sailor10S);
        cardSailorJS = new JLabel(sailorJS);
        cardSailorQS = new JLabel(sailorQS);
        cardSailorKS = new JLabel(sailorKS);

        for (int i = 0; i < 7; i++) {
            handLabels[i] = new JLabel("Text");
        }

        // Creating menus
        options = new JMenu("Options");
        tutorial = new JMenu(" How to Play");

        // Creating menu items
        settings = new JMenuItem(" Settings", settingsGear);
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);
        rummyHow = new JMenuItem(" Rummy", how2Play);
        lakersRummyHow = new JMenuItem(" Lakers Rummy", how2Play);

        // Creating buttons
        makeMeldButton = new JButton("Make Meld");
        addToMeldButton = new JButton("Add to Meld");

        // Setting frame icon
        gameFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        makeMeldButton.setBackground(orange);
        addToMeldButton.setBackground(orange);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        makeMeldButton.setForeground(black);
        addToMeldButton.setForeground(black);
        p1Label.setForeground(black);
        p2Label.setForeground(black);
        p3Label.setForeground(black);
        p4Label.setForeground(black);
        dash1Label.setForeground(black);
        dash2Label.setForeground(black);
        dash3Label.setForeground(black);
        options.setForeground(black);
        tutorial.setForeground(black);
        returnMenu.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);
        rummyHow.setForeground(black);
        lakersRummyHow.setForeground(black);

        // Setting fonts
        makeMeldButton.setFont(menuFont);
        addToMeldButton.setFont(menuFont);
        p1Label.setFont(avatarFont);
        p2Label.setFont(avatarFont);
        p3Label.setFont(avatarFont);
        p4Label.setFont(avatarFont);
        dash1Label.setFont(playButtonFont);
        dash2Label.setFont(playButtonFont);
        dash3Label.setFont(playButtonFont);
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        returnMenu.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        lakersRummyHow.setFont(subMenuFont);

        // Setting borders
        makeMeldButton.setBorder(meldBorder);
        addToMeldButton.setBorder(meldBorder);
        crabLabel.setBorder(cardBorder);
        octopusLabel.setBorder(cardBorder);
        whaleLabel.setBorder(cardBorder);
        seaGullLabel.setBorder(cardBorder);
        rectangleLeftLabel.setBorder(buttonBorder);
        rectangleRightLabel.setBorder(buttonBorder);
        cardDeckLabel.setBorder(cardBorder);
        cardAnchorA.setBorder(cardBorder);
        cardAnchor2.setBorder(cardBorder);
        cardAnchor3.setBorder(cardBorder);
        cardAnchor4.setBorder(cardBorder);
        cardAnchor5.setBorder(cardBorder);
        cardAnchor6.setBorder(cardBorder);
        cardAnchor7.setBorder(cardBorder);
        cardAnchor8.setBorder(cardBorder);
        cardAnchor9.setBorder(cardBorder);
        cardAnchor10.setBorder(cardBorder);
        cardAnchorJ.setBorder(cardBorder);
        cardAnchorQ.setBorder(cardBorder);
        cardAnchorK.setBorder(cardBorder);
        cardClockTowA.setBorder(cardBorder);
        cardClockTow2.setBorder(cardBorder);
        cardClockTow3.setBorder(cardBorder);
        cardClockTow4.setBorder(cardBorder);
        cardClockTow5.setBorder(cardBorder);
        cardClockTow6.setBorder(cardBorder);
        cardClockTow7.setBorder(cardBorder);
        cardClockTow8.setBorder(cardBorder);
        cardClockTow9.setBorder(cardBorder);
        cardClockTow10.setBorder(cardBorder);
        cardClockTowJ.setBorder(cardBorder);
        cardClockTowQ.setBorder(cardBorder);
        cardClockTowK.setBorder(cardBorder);
        cardGVLogoA.setBorder(cardBorder);
        cardGVLogo2.setBorder(cardBorder);
        cardGVLogo3.setBorder(cardBorder);
        cardGVLogo4.setBorder(cardBorder);
        cardGVLogo5.setBorder(cardBorder);
        cardGVLogo6.setBorder(cardBorder);
        cardGVLogo7.setBorder(cardBorder);
        cardGVLogo8.setBorder(cardBorder);
        cardGVLogo9.setBorder(cardBorder);
        cardGVLogo10.setBorder(cardBorder);
        cardGVLogoJ.setBorder(cardBorder);
        cardGVLogoQ.setBorder(cardBorder);
        cardGVLogoK.setBorder(cardBorder);
        cardSailorA.setBorder(cardBorder);
        cardSailor2.setBorder(cardBorder);
        cardSailor3.setBorder(cardBorder);
        cardSailor4.setBorder(cardBorder);
        cardSailor5.setBorder(cardBorder);
        cardSailor6.setBorder(cardBorder);
        cardSailor7.setBorder(cardBorder);
        cardSailor8.setBorder(cardBorder);
        cardSailor9.setBorder(cardBorder);
        cardSailor10.setBorder(cardBorder);
        cardSailorJ.setBorder(cardBorder);
        cardSailorQ.setBorder(cardBorder);
        cardSailorK.setBorder(cardBorder);
        cardAnchorAS.setBorder(cardBorder);
        cardAnchor2S.setBorder(cardBorder);
        cardAnchor3S.setBorder(cardBorder);
        cardAnchor4S.setBorder(cardBorder);
        cardAnchor5S.setBorder(cardBorder);
        cardAnchor6S.setBorder(cardBorder);
        cardAnchor7S.setBorder(cardBorder);
        cardAnchor8S.setBorder(cardBorder);
        cardAnchor9S.setBorder(cardBorder);
        cardAnchor10S.setBorder(cardBorder);
        cardAnchorJS.setBorder(cardBorder);
        cardAnchorQS.setBorder(cardBorder);
        cardAnchorKS.setBorder(cardBorder);
        cardClockTowAS.setBorder(cardBorder);
        cardClockTow2S.setBorder(cardBorder);
        cardClockTow3S.setBorder(cardBorder);
        cardClockTow4S.setBorder(cardBorder);
        cardClockTow5S.setBorder(cardBorder);
        cardClockTow6S.setBorder(cardBorder);
        cardClockTow7S.setBorder(cardBorder);
        cardClockTow8S.setBorder(cardBorder);
        cardClockTow9S.setBorder(cardBorder);
        cardClockTow10S.setBorder(cardBorder);
        cardClockTowJS.setBorder(cardBorder);
        cardClockTowQS.setBorder(cardBorder);
        cardClockTowKS.setBorder(cardBorder);
        cardGVLogoAS.setBorder(cardBorder);
        cardGVLogo2S.setBorder(cardBorder);
        cardGVLogo3S.setBorder(cardBorder);
        cardGVLogo4S.setBorder(cardBorder);
        cardGVLogo5S.setBorder(cardBorder);
        cardGVLogo6S.setBorder(cardBorder);
        cardGVLogo7S.setBorder(cardBorder);
        cardGVLogo8S.setBorder(cardBorder);
        cardGVLogo9S.setBorder(cardBorder);
        cardGVLogo10S.setBorder(cardBorder);
        cardGVLogoJS.setBorder(cardBorder);
        cardGVLogoQS.setBorder(cardBorder);
        cardGVLogoKS.setBorder(cardBorder);
        cardSailorAS.setBorder(cardBorder);
        cardSailor2S.setBorder(cardBorder);
        cardSailor3S.setBorder(cardBorder);
        cardSailor4S.setBorder(cardBorder);
        cardSailor5S.setBorder(cardBorder);
        cardSailor6S.setBorder(cardBorder);
        cardSailor7S.setBorder(cardBorder);
        cardSailor8S.setBorder(cardBorder);
        cardSailor9S.setBorder(cardBorder);
        cardSailor10S.setBorder(cardBorder);
        cardSailorJS.setBorder(cardBorder);
        cardSailorQS.setBorder(cardBorder);
        cardSailorKS.setBorder(cardBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        makeMeldButton.setBounds(35 + insets.left, 250 + insets.top, 145, 50);
        addToMeldButton.setBounds(35 + insets.left, 340 + insets.top, 145, 50);
        seaGullLabel.setBounds(1090 + insets.left, 20 + insets.top, 145, 105);
        whaleLabel.setBounds(1090 + insets.left, 180 + insets.top, 145, 110);
        octopusLabel.setBounds(1090 + insets.left, 350 + insets.top, 145, 110);
        crabLabel.setBounds(1090 + insets.left, 510 + insets.top, 145, 110);
        p1Label.setBounds(1090 + insets.left, 120 + insets.top, 200, 50);
        p2Label.setBounds(1090 + insets.left, 285 + insets.top, 200, 50);
        p3Label.setBounds(1090 + insets.left, 450 + insets.top, 200, 50);
        p4Label.setBounds(1090 + insets.left, 605 + insets.top, 200, 50);
        dash1Label.setBounds(1055 + insets.left, 100 + insets.top, 300, 75);
        dash2Label.setBounds(1055 + insets.left, 267 + insets.top, 300, 75);
        dash3Label.setBounds(1055 + insets.left, 428 + insets.top, 300, 75);
        rectangleLeftLabel.setBounds(0 + insets.left, 0 + insets.top, 215, 655);
        rectangleRightLabel.setBounds(1054 + insets.left, 0 + insets.top, 215, 655);
        cardDeckLabel.setBounds(40 + insets.left, 20 + insets.top, 135, 190);
        cardAnchorA.setBounds(40 + insets.left, 435 + insets.top, 135, 190);
        // cardAnchor2.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor3.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor4.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor5.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor6.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor7.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor8.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor9.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchor10.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchorJ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchorQ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardAnchorK.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTowA.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow2.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow3.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow4.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow5.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow6.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow7.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow8.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow9.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTow10.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTowJ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTowQ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardClockTowK.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogoA.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo2.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo3.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo4.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo5.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo6.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo7.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo8.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo9.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogo10.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogoJ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogoQ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardGVLogoK.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailorA.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor2.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor3.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor4.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor5.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor6.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor7.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor8.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor9.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailor10.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailorJ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailorQ.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        // cardSailorK.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        for (int i = 0; i < 7 * 120; i += 120) { // loop to add cards in hand to bottom of screen
            handLabels[i / 120].setBounds(220 + i + insets.left, 500 + insets.bottom, 186, 135);
        }

        // Adding elements to menubar
        menu.add(options);
        menu.add(tutorial);

        // Adding elements to menu items
        options.add(settings);
        options.add(returnMenu);
        options.addSeparator();
        options.add(exit);
        tutorial.add(rummyHow);
        tutorial.add(lakersRummyHow);

        // Adding elements to frame
        gameFrame.add(menu);
        gameFrame.add(pane);

        // Adding elements to pane
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
        pane.add(dash1Label);
        pane.add(dash2Label);
        pane.add(dash3Label);
        pane.add(cardDeckLabel);
        pane.add(cardAnchorA);
        pane.add(cardAnchor2);
        pane.add(cardAnchor3);
        pane.add(cardAnchor4);
        pane.add(cardAnchor5);
        pane.add(cardAnchor6);
        pane.add(cardAnchor7);
        pane.add(cardAnchor8);
        pane.add(cardAnchor9);
        pane.add(cardAnchor10);
        pane.add(cardAnchorJ);
        pane.add(cardAnchorQ);
        pane.add(cardAnchorK);
        pane.add(cardClockTowA);
        pane.add(cardClockTow2);
        pane.add(cardClockTow3);
        pane.add(cardClockTow4);
        pane.add(cardClockTow5);
        pane.add(cardClockTow6);
        pane.add(cardClockTow7);
        pane.add(cardClockTow8);
        pane.add(cardClockTow9);
        pane.add(cardClockTow10);
        pane.add(cardClockTowJ);
        pane.add(cardClockTowQ);
        pane.add(cardClockTowK);
        pane.add(cardGVLogoA);
        pane.add(cardGVLogo2);
        pane.add(cardGVLogo3);
        pane.add(cardGVLogo4);
        pane.add(cardGVLogo5);
        pane.add(cardGVLogo6);
        pane.add(cardGVLogo7);
        pane.add(cardGVLogo8);
        pane.add(cardGVLogo9);
        pane.add(cardGVLogo10);
        pane.add(cardGVLogoJ);
        pane.add(cardGVLogoQ);
        pane.add(cardGVLogoK);
        pane.add(cardSailorA);
        pane.add(cardSailor2);
        pane.add(cardSailor3);
        pane.add(cardSailor4);
        pane.add(cardSailor5);
        pane.add(cardSailor6);
        pane.add(cardSailor7);
        pane.add(cardSailor8);
        pane.add(cardSailor9);
        pane.add(cardSailor10);
        pane.add(cardSailorJ);
        pane.add(cardSailorQ);
        pane.add(cardSailorK);
        pane.add(cardAnchorAS);
        pane.add(cardAnchor2S);
        pane.add(cardAnchor3S);
        pane.add(cardAnchor4S);
        pane.add(cardAnchor5S);
        pane.add(cardAnchor6S);
        pane.add(cardAnchor7S);
        pane.add(cardAnchor8S);
        pane.add(cardAnchor9S);
        pane.add(cardAnchor10S);
        pane.add(cardAnchorJS);
        pane.add(cardAnchorQS);
        pane.add(cardAnchorKS);
        pane.add(cardClockTowAS);
        pane.add(cardClockTow2S);
        pane.add(cardClockTow3S);
        pane.add(cardClockTow4S);
        pane.add(cardClockTow5S);
        pane.add(cardClockTow6S);
        pane.add(cardClockTow7S);
        pane.add(cardClockTow8S);
        pane.add(cardClockTow9S);
        pane.add(cardClockTow10S);
        pane.add(cardClockTowJS);
        pane.add(cardClockTowQS);
        pane.add(cardClockTowKS);
        pane.add(cardGVLogoAS);
        pane.add(cardGVLogo2S);
        pane.add(cardGVLogo3S);
        pane.add(cardGVLogo4S);
        pane.add(cardGVLogo5S);
        pane.add(cardGVLogo6S);
        pane.add(cardGVLogo7S);
        pane.add(cardGVLogo8S);
        pane.add(cardGVLogo9S);
        pane.add(cardGVLogo10S);
        pane.add(cardGVLogoJS);
        pane.add(cardGVLogoQS);
        pane.add(cardGVLogoKS);
        pane.add(cardSailorAS);
        pane.add(cardSailor2S);
        pane.add(cardSailor3S);
        pane.add(cardSailor4S);
        pane.add(cardSailor5S);
        pane.add(cardSailor6S);
        pane.add(cardSailor7S);
        pane.add(cardSailor8S);
        pane.add(cardSailor9S);
        pane.add(cardSailor10S);
        pane.add(cardSailorJS);
        pane.add(cardSailorQS);
        pane.add(cardSailorKS);
        pane.add(rectangleLeftLabel);
        pane.add(rectangleRightLabel);

        for (int i = 0; i < 7; i++) {
            pane.add(handLabels[i]);
        }

        // Addiing action listeners to elements
        settings.addActionListener(this);
        tutorial.addActionListener(this);
        returnMenu.addActionListener(this);
        exit.addActionListener(this);
        cardDeckLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cardDeckLabel.setBorder(cardHighlightBorder);
            }
        });

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setSize(1280, 720);
        gameFrame.setJMenuBar(menu);
        gameFrame.getContentPane().setBackground(tan);

        // Setting game as in progress
        gameInProg = true;
        currentScreen = GAME;

        // adding players, dealing, and populating cardmap
        rummy.addPlayer(numPlayers);
        rummy.deal();

        cardMap.put(rummy.getCard(0), cardAnchorA);
        cardMap.put(rummy.getCard(1), cardClockTowA);
        cardMap.put(rummy.getCard(2), cardGVLogoA);
        cardMap.put(rummy.getCard(3), cardSailorA);
        cardMap.put(rummy.getCard(4), cardAnchor2);
        cardMap.put(rummy.getCard(5), cardClockTow2);
        cardMap.put(rummy.getCard(6), cardGVLogo2);
        cardMap.put(rummy.getCard(7), cardSailor2);
        cardMap.put(rummy.getCard(8), cardAnchor3);
        cardMap.put(rummy.getCard(9), cardClockTow3);
        cardMap.put(rummy.getCard(10), cardGVLogo3);
        cardMap.put(rummy.getCard(11), cardSailor3);
        cardMap.put(rummy.getCard(12), cardAnchor4);
        cardMap.put(rummy.getCard(13), cardClockTow4);
        cardMap.put(rummy.getCard(14), cardGVLogo4);
        cardMap.put(rummy.getCard(15), cardSailor4);
        cardMap.put(rummy.getCard(16), cardAnchor5);
        cardMap.put(rummy.getCard(17), cardClockTow5);
        cardMap.put(rummy.getCard(18), cardGVLogo5);
        cardMap.put(rummy.getCard(19), cardSailor5);
        cardMap.put(rummy.getCard(20), cardAnchor6);
        cardMap.put(rummy.getCard(21), cardClockTow6);
        cardMap.put(rummy.getCard(22), cardGVLogo6);
        cardMap.put(rummy.getCard(23), cardSailor6);
        cardMap.put(rummy.getCard(24), cardAnchor7);
        cardMap.put(rummy.getCard(25), cardClockTow7);
        cardMap.put(rummy.getCard(26), cardGVLogo7);
        cardMap.put(rummy.getCard(27), cardSailor7);
        cardMap.put(rummy.getCard(28), cardAnchor8);
        cardMap.put(rummy.getCard(29), cardClockTow8);
        cardMap.put(rummy.getCard(30), cardGVLogo8);
        cardMap.put(rummy.getCard(31), cardSailor8);
        cardMap.put(rummy.getCard(32), cardAnchor9);
        cardMap.put(rummy.getCard(33), cardClockTow9);
        cardMap.put(rummy.getCard(34), cardGVLogo9);
        cardMap.put(rummy.getCard(35), cardSailor9);
        cardMap.put(rummy.getCard(36), cardAnchor10);
        cardMap.put(rummy.getCard(37), cardClockTow10);
        cardMap.put(rummy.getCard(38), cardGVLogo10);
        cardMap.put(rummy.getCard(39), cardSailor10);
        cardMap.put(rummy.getCard(40), cardAnchorJ);
        cardMap.put(rummy.getCard(41), cardClockTowJ);
        cardMap.put(rummy.getCard(42), cardGVLogoJ);
        cardMap.put(rummy.getCard(43), cardSailorJ);
        cardMap.put(rummy.getCard(44), cardAnchorQ);
        cardMap.put(rummy.getCard(45), cardClockTowQ);
        cardMap.put(rummy.getCard(46), cardGVLogoQ);
        cardMap.put(rummy.getCard(47), cardSailorQ);
        cardMap.put(rummy.getCard(48), cardAnchorK);
        cardMap.put(rummy.getCard(49), cardClockTowK);
        cardMap.put(rummy.getCard(50), cardGVLogoK);
        cardMap.put(rummy.getCard(51), cardSailorK);

        // this.updateHand(0);
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

        // Creating buttons
        // playButton = new JButton("Play");

        // Creating menus
        options = new JMenu("Options");

        // Creating menu items
        returnGame = new JMenuItem(" Return to Game", returnBack);
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);

        // Setting frame icon
        settingsFrame.setIconImage(GValleyJava.getImage());

        // Setting background colors
        exit.setBackground(yellow);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        options.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);

        // Setting fonts
        returnMenu.setFont(subMenuFont);
        returnGame.setFont(subMenuFont);
        exit.setFont(subMenuFont);

        // Setting borders
        playButton.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();

        // Adding elements to menubar
        menu.add(options);

        // Adding elements to menu items
        if (gameInProg) {
            options.add(returnGame);
        } else {
            options.add(returnMenu);
        }
        options.addSeparator();
        options.add(exit);

        // Adding elements to frame
        settingsFrame.add(menu);
        settingsFrame.add(pane);

        // Adding elements to pane

        // Addiing action listeners to elements
        exit.addActionListener(this);
        if (gameInProg) {
            returnGame.addActionListener(this);
        } else {
            returnMenu.addActionListener(this);
        }
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        settingsFrame.pack();
        settingsFrame.setVisible(true);
        settingsFrame.setSize(800, 600);
        settingsFrame.setJMenuBar(menu);
        settingsFrame.getContentPane().setBackground(lightGrey);

        // Setting current screen location
        currentScreen = SETTINGS;
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
            if (currentScreen == GAME) { // Returns to menu from game screen
                gameFrame.dispose();
                mainMenuScreen();
            } else if (currentScreen == SETTINGS) { // Returns to menu from settings screen
                settingsFrame.dispose();
                mainMenuScreen();
            }
        }

        // returnGame menu item is clicked
        if (action == returnGame) {
            settingsFrame.dispose();
            gameScreen();
        }

        // settings menu item is clicked
        if (action == settings) {
            if (currentScreen == GAME) { // Changes from game screen to settings screen
                gameFrame.dispose();
                settingsScreen();
            } else if (currentScreen == MENU) { // Changes from menu screen to settings screen
                mainMenuFrame.dispose();
                settingsScreen();
            }
        }

        // playButton button is clicked
        if (action == playButton) {
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

            // Sets numPlayerButtons underneath rummyButton
            onePlayerButton.setBounds(150 + insets.left, 450 + insets.top, 100, 80);
            twoPlayerButton.setBounds(300 + insets.left, 450 + insets.top, 100, 80);
            threePlayerButton.setBounds(450 + insets.left, 450 + insets.top, 100, 80);
            fourPlayerButton.setBounds(600 + insets.left, 450 + insets.top, 100, 80);
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

            // Sets numPlayerButtons underneath lakersRummyButton
            onePlayerButton.setBounds(565 + insets.left, 450 + insets.top, 100, 80);
            twoPlayerButton.setBounds(715 + insets.left, 450 + insets.top, 100, 80);
            threePlayerButton.setBounds(865 + insets.left, 450 + insets.top, 100, 80);
            fourPlayerButton.setBounds(1015 + insets.left, 450 + insets.top, 100, 80);

            // Setting whichGame
            whichGame = 2;
        }

        // onePlayerButton button is clicked
        if (action == onePlayerButton) {
            // Selects onePlayerButton
            onePlayerButton.setBackground(yellow);
            onePlayerButton.setForeground(black);

            // Fades out other player buttons
            twoPlayerButton.setForeground(lightGrey);
            threePlayerButton.setForeground(lightGrey);
            fourPlayerButton.setForeground(lightGrey);
            twoPlayerButton.setBackground(darkGrey);
            threePlayerButton.setBackground(darkGrey);
            fourPlayerButton.setBackground(darkGrey);

            // Setting numPlayers
            numPlayers = 1;
        }

        // twoPlayerButton button is clicked
        if (action == twoPlayerButton) {
            // Selects onePlayerButton
            twoPlayerButton.setBackground(yellow);
            twoPlayerButton.setForeground(black);

            // Fades out other player buttons
            onePlayerButton.setForeground(lightGrey);
            threePlayerButton.setForeground(lightGrey);
            fourPlayerButton.setForeground(lightGrey);
            onePlayerButton.setBackground(darkGrey);
            threePlayerButton.setBackground(darkGrey);
            fourPlayerButton.setBackground(darkGrey);

            // Setting numPlayers
            numPlayers = 2;
        }

        // threePlayerButton button is clicked
        if (action == threePlayerButton) {
            // Selects onePlayerButton
            threePlayerButton.setBackground(yellow);
            threePlayerButton.setForeground(black);

            // Fades out other player buttons
            onePlayerButton.setForeground(lightGrey);
            twoPlayerButton.setForeground(lightGrey);
            fourPlayerButton.setForeground(lightGrey);
            onePlayerButton.setBackground(darkGrey);
            twoPlayerButton.setBackground(darkGrey);
            fourPlayerButton.setBackground(darkGrey);

            // Setting numPlayers
            numPlayers = 3;
        }

        // fourPlayerButton button is clicked
        if (action == fourPlayerButton) {
            // Selects onePlayerButton
            fourPlayerButton.setBackground(yellow);
            fourPlayerButton.setForeground(black);

            // Fades out other player buttons
            onePlayerButton.setForeground(lightGrey);
            twoPlayerButton.setForeground(lightGrey);
            threePlayerButton.setForeground(lightGrey);
            onePlayerButton.setBackground(darkGrey);
            twoPlayerButton.setBackground(darkGrey);
            threePlayerButton.setBackground(darkGrey);

            // Setting numPlayers
            numPlayers = 4;
        }
    }

    /**************************************************************************************************************************************************************************************
     * The updateHand(int playerNum) method populates the bottom of the screen with
     * the cards in the player's hand
     * 
     * @param playerNum number of player whose cards are shown
     */
    private void updateHand(int playerNum) {
        // for(int i = 0; i < rummy.getPlayer(playerNum).hand.cardArr.size(); i++){
        // hand1 = cardMap.get(rummy.getPlayer(playerNum).hand.cardArr.get(0));
        // }

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
