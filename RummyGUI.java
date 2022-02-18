import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.FontConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class RummyGUI extends JFrame implements ActionListener {
    /**************************************************************************************************************************************************************************************
     * 
     * The RummyGUI class is an extension of JFrame that also implements the
     * ActionListener class.
     * Within this class, the program creates a usable menu that allows for the
     * changing of screens,
     * changing game modes, changing settings, and closing the GUI.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 1/30/2022
     * 
     */

    private JMenuBar menu;
    private JFrame mainMenuFrame;
    private JFrame gameFrame;
    private JLabel title;
    private JLabel cardDeck;
    private Container pane;
    private Insets insets;

    private JMenu options;
    private JMenu tutorial;
    private JMenuItem rummyHow;
    private JMenuItem lakersRummyHow;
    private JMenuItem settings;
    private JMenuItem exit;

    private JButton playButton;
    private JButton rummyButton;
    private JButton lakersRummyButton;
    private JButton onePlayerButton;
    private JButton twoPlayerButton;
    private JButton threePlayerButton;
    private JButton fourPlayerButton;

    private ImageIcon settingsGear;
    private ImageIcon redX;
    private ImageIcon backOfCardLR;
    private ImageIcon how2Play;

    private Font titleFont;
    private Font menuFont;
    private Font subMenuFont;
    private Font playButtonFont;
    private Font gameButtonFont;
    private Font numPlayersButtonFont;

    private LineBorder menubarBorder;
    private LineBorder menuBorder;
    private LineBorder buttonBorder;

    private Color black;
    private Color white;
    private Color yellow;
    private Color blue;
    private Color aquaBlue;
    private Color red;
    private Color pink;
    private Color magenta;
    private Color green;
    private Color orange;
    private Color brightOrange;
    private Color tan;
    private Color cyan;
    private Color grey;
    private Color lightGrey;
    private Color darkGrey;

    private int whichGame;
    private int numPlayers;

    // private JPanel panel;
    /**************************************************************************************************************************************************************************************
     * 
     * The default constructor for the RummyGUI() class. Within this constructor,
     * a menu bars is created allowing for access to the settings as well as the
     * ability to close out of the game.
     * 
     * 
     */

    public RummyGUI() {
        // Creating image icons
        settingsGear = new ImageIcon("images/settings-gear.png");
        redX = new ImageIcon("images/red-x.png");
        backOfCardLR = new ImageIcon("images/LR_Cards/LRBackCardDesign.jpg");
        how2Play = new ImageIcon("images/how2Play.png");

        // Creating colors
        black = Color.BLACK;
        white = Color.WHITE;
        yellow = Color.YELLOW;
        blue = Color.BLUE;
        aquaBlue = new Color(5, 195, 228);
        red = Color.RED;
        pink = Color.PINK;
        magenta = Color.MAGENTA;
        green = Color.GREEN;
        orange = Color.ORANGE;
        brightOrange = new Color(255, 135, 0);
        tan = new Color(255, 215, 175);
        cyan = Color.CYAN;
        grey = Color.GRAY;
        lightGrey = Color.LIGHT_GRAY;
        darkGrey = Color.DARK_GRAY;

        // Creating fonts
        titleFont = new Font("Segoe Script", Font.BOLD, 120);
        menuFont = new Font("Georgia", Font.PLAIN, 21);
        subMenuFont = new Font("Cooper Black", Font.PLAIN, 21);
        playButtonFont = new Font("Courier", Font.BOLD, 50);
        gameButtonFont = new Font("Courier", Font.BOLD, 40);
        numPlayersButtonFont = new Font("Courier", Font.BOLD, 30);

        // Creating borders
        menubarBorder = new LineBorder(black, 2);
        menuBorder = new LineBorder(black, 1);
        buttonBorder = new LineBorder(black, 5);

        mainMenuScreen();
    }

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

        // Creating buttons
        playButton = new JButton("Play");

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
        UIManager.put("MenuBar.background", lightGrey);

        // Setting foreground colors
        options.setForeground(black);
        tutorial.setForeground(black);
        exit.setForeground(black);
        settings.setForeground(black);
        rummyHow.setForeground(black);
        lakersRummyHow.setForeground(black);

        // Setting fonts
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        lakersRummyHow.setFont(subMenuFont);

        // Setting borders
        cardDeck.setBorder(buttonBorder);

        // Setting locations & sizes of certain elements
        insets = pane.getInsets();
        cardDeck.setBounds(700 + insets.left, 150 + insets.top, 340, 475);
        // title.setVerticalAlignment(JLabel.NORTH);
        // title.setHorizontalAlignment(JLabel).CENTER);

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
        gameFrame.add(menu);
        gameFrame.add(pane);

        // Adding elements to pane
        pane.add(cardDeck);

        // Addiing action listeners to elements
        settings.addActionListener(this);
        tutorial.addActionListener(this);
        exit.addActionListener(this);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting elements compatible with the frame
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setSize(1700, 920);
        gameFrame.setJMenuBar(menu);
        gameFrame.getContentPane().setBackground(tan);
    }

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
        title.setBounds(400 + insets.left, 100 + insets.top, 1000, 150);
        playButton.setBounds(750 + insets.left, 300 + insets.top, 200, 120);
        rummyButton.setBounds(515 + insets.left, 500 + insets.top, 275, 130);
        lakersRummyButton.setBounds(910 + insets.left, 500 + insets.top, 325, 130);
        onePlayerButton.setBounds(375 + insets.left, 650 + insets.top, 100, 80);
        twoPlayerButton.setBounds(525 + insets.left, 650 + insets.top, 100, 80);
        threePlayerButton.setBounds(675 + insets.left, 650 + insets.top, 100, 80);
        fourPlayerButton.setBounds(825 + insets.left, 650 + insets.top, 100, 80);
        // title.setVerticalAlignment(JLabel.NORTH);
        // title.setHorizontalAlignment(JLabel.CENTER);

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
        mainMenuFrame.setSize(1700, 920);
        mainMenuFrame.setJMenuBar(menu);
        mainMenuFrame.getContentPane().setBackground(aquaBlue);

        // Setting default whichGame and howManyPlayers
        whichGame = 1;
        numPlayers = 1;
    }

    /**************************************************************************************************************************************************************************************
     * 
     * The actionPerformed(ActionEvent) method allows the user to click different
     * menu items.
     * The method also allows the user to click an itme in the table and rent/return
     * an item
     * from that given row.
     *
     * @param e - The ActionEvent e parameter receives input from the user depending
     *          on where
     *          they click within the GUI screens/menus.
     * 
     */

    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();
        if (action == exit) {
            System.exit(1);
        }

        if (action == playButton) {
            mainMenuFrame.dispose();
            gameScreen();
        }

        // rummyButton is clicked
        if (action == rummyButton) {
            // Selects rummyButton
            rummyButton.setBackground(orange);
            rummyButton.setForeground(black);

            // Fades out lakersRummyButton
            lakersRummyButton.setBackground(darkGrey);
            lakersRummyButton.setForeground(lightGrey);

            // Sets numPlayerButtons underneath rummyButton
            onePlayerButton.setBounds(375 + insets.left, 650 + insets.top, 100, 80);
            twoPlayerButton.setBounds(525 + insets.left, 650 + insets.top, 100, 80);
            threePlayerButton.setBounds(675 + insets.left, 650 + insets.top, 100, 80);
            fourPlayerButton.setBounds(825 + insets.left, 650 + insets.top, 100, 80);
            whichGame = 1;
        }

        if (action == lakersRummyButton) {
            // Selects lakersRummyButton
            lakersRummyButton.setBackground(orange);
            lakersRummyButton.setForeground(black);

            // Fades out rummyButton
            rummyButton.setBackground(darkGrey);
            rummyButton.setForeground(lightGrey);

            // Sets numPlayerButtons underneath lakersRummyButton
            onePlayerButton.setBounds(800 + insets.left, 650 + insets.top, 100, 80); // Sets
            twoPlayerButton.setBounds(950 + insets.left, 650 + insets.top, 100, 80);
            threePlayerButton.setBounds(1100 + insets.left, 650 + insets.top, 100, 80);
            fourPlayerButton.setBounds(1250 + insets.left, 650 + insets.top, 100, 80);

            // Setting whichGame
            whichGame = 2;
        }

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
     * 
     * The main(String[] args) method allows for the RummyGUI class to be ran.
     * 
     * @param args - A String[] array representing the arguments being passed to
     *             main.
     * 
     */

    public static void main(String[] args) {
        new RummyGUI();
    }
}
