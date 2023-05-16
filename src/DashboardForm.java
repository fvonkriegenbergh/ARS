import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardForm extends JFrame implements ActionListener {
    private JPanel mainDashPanel;
    private JPanel userNameDashPanel;
    private JPanel frequentFlyerMilePanel;
    private JPanel NavigationPanel;
    private JButton bookFlightBtn;
    private JButton logOutBtn;
    private JButton helpBtn;
    private JButton trackFlightBtn;
    private JLabel flyerMileCount;
    private JPanel accountInfoPanel;
    private JLabel accountUserNameLbl;
    private JLabel accountNameLbl;
    private JLabel accountEmailLbl;
    private JLabel userUsername;
    private JLabel userName;
    private JLabel userEmail;
    private JPanel customerServicePanel;
    private JButton customerSupportBtn;
    private JLabel displayUsername;
    private User currentUser ;

    // default constructor for Dashboard frame
    public DashboardForm(){

        // set title of frame
        this.setTitle("Dashboard") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        // add actionlisteners to all buttons in dashboard
        this.bookFlightBtn.addActionListener(this) ;
        this.logOutBtn.addActionListener(this) ;
        this.helpBtn.addActionListener(this); ;
        this.trackFlightBtn.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);

        this.setContentPane(this.mainDashPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // constructor to take in user info at login
    public DashboardForm(User loginUser){

        // set title of frame
        this.setTitle("Dashboard") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        // set currentUser to user taken in parameter
        this.currentUser = loginUser ;

        // set jlabels username, email, name, flyermiles with user information
        this.displayUsername.setText(loginUser.getUserName()) ;
        this.flyerMileCount.setText(loginUser.getFlierMiles() + "");
        this.userUsername.setText(loginUser.getUserName());
        this.userName.setText(loginUser.getFullName());
        this.userEmail.setText(loginUser.getEmail());

        // add actionlisteners to all buttons in dashboard
        this.bookFlightBtn.addActionListener(this) ;
        this.logOutBtn.addActionListener(this) ;
        this.helpBtn.addActionListener(this); ;
        this.trackFlightBtn.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);


        this.setContentPane(this.mainDashPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bookFlightBtn){

            // open available flights page
            FlightSearchForm newSearchForm = new FlightSearchForm(this.currentUser) ;
            this.dispose() ;
        }
        if(e.getSource() == trackFlightBtn){

            // open user flights page
            FlightsForm newFlights = new FlightsForm(this.currentUser) ;
            this.dispose() ;
        }
        if(e.getSource() == helpBtn){

            // open help page

        }
        if(e.getSource() == logOutBtn){

            // log out user
            JOptionPane.showMessageDialog(this, "Logged out successful!") ;
            this.dispose() ;
            LoginForm newLogin = new LoginForm() ;
        }
        if(e.getSource() == customerSupportBtn){

            // open customer service live chat box
            SupportChatbotForm initChat = new SupportChatbotForm() ;

        }

    }

}
