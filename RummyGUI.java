import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class RummyGUI extends JFrame implements ActionListener {
    /**************************************************************************************************************************************************************************************
 	 * 
	 * The RummyGUI class is an extension of JFrame that also implements the ActionListener class.
     * Within this class, the program creates a usable menu that allows for the changing of screens,
     * changing game modes, changing settings, and closing the GUI.
     * 
     * @author Noah Arden
     * @author Owen Carroll
	 * @author Kyle Taylor
     * @version 1/30/2022
 	 * 
 	 */
    
    private JMenuBar menu;
    private JFrame frame;
    private JLabel title;
    private Container pane;
    private Insets insets;


    private JMenu options;
    private JMenu tutorial;
    private JMenuItem rummyHow;
    private JMenuItem lakersRummyHow;
    private JMenuItem settings;
    private JMenuItem exit;
    
    private ImageIcon settingsGear;
    private ImageIcon redX;
    private ImageIcon backOfCardLR;
    private ImageIcon how2Play;

    private Font titleFont;
    private Font menuFont;
    private Font subMenuFont;

    

    

    //private JPanel panel;
    /**************************************************************************************************************************************************************************************
 	 * 
 	 * The default constructor for the RummyGUI() class. Within this constructor,
     * a menu bars is created allowing for access to the settings as well as the
     * ability to close out of the game.
     * 
     * 
 	 */

    public RummyGUI() {
        settingsGear = new ImageIcon("images/settings-gear.png");
        redX = new ImageIcon("images/red-x.png");
        backOfCardLR = new ImageIcon("images/LR_Cards/LRBackCardDesign.jpg");
        how2Play = new ImageIcon("images/how2Play.png");
        menu = new JMenuBar();
        frame = new JFrame();
        title = new JLabel();
        pane = new Container();
        pane.setLayout(null);
        titleFont = new Font("Segoe Script", Font.BOLD, 120);
        menuFont = new Font("Georgia",Font.PLAIN, 21);
        subMenuFont = new Font("Cooper Black",Font.PLAIN, 21);
        

        //label = new JLabel(backOfCardLR);
        options = new JMenu("Options");
        settings = new JMenuItem(" Settings", settingsGear);
        tutorial = new JMenu(" How to Play");
        rummyHow = new JMenuItem(" Rummy", how2Play);
        lakersRummyHow = new JMenuItem(" Lakers Rummy", how2Play);
        exit = new JMenuItem(" Exit", redX);
        exit.setBackground(Color.YELLOW);
        //menu.setBackground(Color.GRAY);

        insets = pane.getInsets();
        pane.add(title);
        title.setFont(titleFont);
        options.setFont(menuFont);
        tutorial.setFont(menuFont);
        exit.setFont(subMenuFont);
        settings.setFont(subMenuFont);
        rummyHow.setFont(subMenuFont);
        lakersRummyHow.setFont(subMenuFont);

        title.setText("Lakers Rummy");
        title.setForeground(Color.BLACK);
        title.setBounds(380 + insets.left, 100 + insets.top,
                     1000, 150);
        //title.setVerticalAlignment(JLabel.NORTH);
        //title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(menu);
        frame.add(pane);
        //frame.add(label);

        menu.add(options);
        menu.add(tutorial);
        options.add(settings);
        options.addSeparator();
        options.add(exit);
        tutorial.add(rummyHow);
        tutorial.add(lakersRummyHow);

        settings.addActionListener(this);
        tutorial.addActionListener(this);
        exit.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(1700,920);
        frame.setJMenuBar(menu);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setVisible(true);
        // setSize(1700,920);
    }
    /**************************************************************************************************************************************************************************************
 	 * 
 	 * The actionPerformed(ActionEvent) method allows the user to click different menu items.
     * The method also allows the user to click an itme in the table and rent/return an item
     * from that given row.
     *
     * @param e - The ActionEvent e parameter receives input from the user depending on where
     *            they click within the GUI screens/menus.
     *  
 	 */

    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();
        if (action == exit) {
            System.exit(1);
        }
    }
    /**************************************************************************************************************************************************************************************
 	 * 
     * The main(String[] args) method allows for the RummyGUI class to be ran.
     *  
     * @param args - A String[] array representing the arguments being passed to main.
     * 
 	 */

    public static void main(String[] args) {
        new RummyGUI();
    }
}
