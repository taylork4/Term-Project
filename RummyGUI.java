import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.FontConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.GregorianCalendar;

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
    private JButton playButton, rummyButton, lakersRummyButton;
    private JButton onePlayerButton, twoPlayerButton, threePlayerButton, // Number of players buttons
            fourPlayerButton;

    // JLabel declarations
    private JLabel title, cardDeck;
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

    // ImageIcon declarations
    private ImageIcon settingsGear, redX, backOfCardLR, how2Play, returnBack;
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

    // Font declarations
    private Font titleFont, menuFont, subMenuFont, playButtonFont,
            gameButtonFont, numPlayersButtonFont;

    // LineBorder declarations
    private LineBorder cardBorder, cardHighlightBorder, menuBorder,
            buttonBorder;

    // Color declarations
    private Color black, darkGrey, grey, lightGrey, white,
            red, orange, brightOrange, yellow, green, blue,
            aquaBlue, cyan, magenta, pink, tan;

    // Container declarations
    private Container pane;

    // Insets declarations
    private Insets insets;

    // Game status variable declarations
    private final int MENU, GAME, SETTINGS;
    private int whichGame, numPlayers, currentScreen;
    private boolean gameInProg, deckClick, handCardClick, hasSetClicks;

    /**************************************************************************************************************************************************************************************
     * The default constructor for the RummyGUI() class. Within this constructor,
     * a menu bars is created allowing for access to the settings as well as the
     * ability to close out of the game.
     */
    public RummyGUI() {
        // Creating image icons
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
        tan = new Color(255, 215, 175);

        // Creating fonts
        titleFont = new Font("Segoe Script", Font.BOLD, 120);
        menuFont = new Font("Georgia", Font.PLAIN, 21);
        subMenuFont = new Font("Cooper Black", Font.PLAIN, 21);
        playButtonFont = new Font("Courier", Font.BOLD, 50);
        gameButtonFont = new Font("Courier", Font.BOLD, 40);
        numPlayersButtonFont = new Font("Courier", Font.BOLD, 30);

        // Creating borders
        cardBorder = new LineBorder(black, 2);
        cardHighlightBorder = new LineBorder(magenta, 3);
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
        title = new JLabel("Lakers Rummy");

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
        title.setForeground(black);
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
        title.setFont(titleFont);
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
        title.setBounds(175 + insets.left, 10 + insets.top, 1000, 150);
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
        pane.add(title);
        pane.add(playButton);
        pane.add(rummyButton);
        pane.add(lakersRummyButton);
        pane.add(onePlayerButton);
        pane.add(twoPlayerButton);
        pane.add(threePlayerButton);
        pane.add(fourPlayerButton);

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
        cardDeck = new JLabel(backOfCardLR);
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

        // Creating buttons
        playButton = new JButton("Play");

        // Creating menus
        options = new JMenu("Options");
        tutorial = new JMenu(" How to Play");

        // Creating menu items
        settings = new JMenuItem(" Settings", settingsGear);
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);
        rummyHow = new JMenuItem(" Rummy", how2Play);
        lakersRummyHow = new JMenuItem(" Lakers Rummy", how2Play);

        // Setting background colors
        exit.setBackground(yellow);
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        options.setForeground(black);
        tutorial.setForeground(black);
        returnMenu.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);
        rummyHow.setForeground(black);
        lakersRummyHow.setForeground(black);

        // Setting fonts
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        returnMenu.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        lakersRummyHow.setFont(subMenuFont);

        // Setting borders
        cardDeck.setBorder(cardBorder);
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

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        cardDeck.setBounds(650 + insets.left, 300 + insets.top, 135, 190);
        cardAnchorA.setBounds(550 + insets.left, 400 + insets.top, 135, 190);
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
        // title.setVerticalAlignment(JLabel.NORTH);
        // title.setHorizontalAlignment(JLabel).CENTER);

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
        pane.add(cardDeck);
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

        // Addiing action listeners to elements
        settings.addActionListener(this);
        tutorial.addActionListener(this);
        returnMenu.addActionListener(this);
        exit.addActionListener(this);
        cardDeck.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cardDeck.setBorder(cardHighlightBorder);
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
        title = new JLabel("Settings");

        // Creating buttons
        // playButton = new JButton("Play");

        // Creating menus
        options = new JMenu("Options");

        // Creating menu items
        returnGame = new JMenuItem(" Return to Game", returnBack);
        returnMenu = new JMenuItem(" Return to Menu", returnBack);
        exit = new JMenuItem(" Exit", redX);

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
        // title.setBounds(400 + insets.left, 100 + insets.top, 1000, 150);

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
        // pane.add(title);

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
     * The main(String[] args) method allows for the RummyGUI class to be ran.
     * 
     * @param args - A String[] array representing the arguments being passed to
     *             main.
     */
    public static void main(String[] args) {
        new RummyGUI();
    }
}
