import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JTextField usernameLoginTextField;
    private JPasswordField loginPasswordField;
    private JTextField nameCreateAccountTextField;
    private JTextField usernameCreateAccountTextField;
    private JTextField passwordCreateAccountPasswordField;
    private JTextField cnfmPassCreateAccountPasswordField;
    private JButton createAccountButton;
    private JButton loginButton;
    private JLabel arsTitleLabel;

    public LoginForm(){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        // add action listener to login and signup button
        loginButton.addActionListener(this) ;
        createAccountButton.addActionListener(this); ;

        this.setTitle("Login") ;
        this.setLocationRelativeTo(null);
        this.setContentPane(this.rootPanel) ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.pack() ;
        this.setVisible(true) ;
    }

    //override action listener method of login and signup button
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){

            // check the username and password when login button is clicked
            loginUser(this.usernameLoginTextField.getText(),
                        String.valueOf(this.loginPasswordField.getPassword()));
        }
        if(e.getSource() == createAccountButton){

            // addUser method with text from create account text fields data
            addUser(this.nameCreateAccountTextField.getText(),
                    this.usernameCreateAccountTextField.getText(),
                    this.passwordCreateAccountPasswordField.getText(),
                    this.cnfmPassCreateAccountPasswordField.getText()) ;
        }
    }

    // loginUser method to check database if user credentials are valid
    // if valid, dispose this frame and open new DashBoardForm object with User object in parameter
    // User object created with user data in parameters
    private void loginUser(String username, String password){

        // if username or passwod entry is empty, printout missing credential message to user
        if((username.equals("")) || (password.equals(""))){

            // Display error message box to user if no username or password
            JOptionPane.showMessageDialog(this, "No username or password") ;
        }
        else{

            // send user credentials to database to check if valid user
            System.out.println("Login method") ;

            DashboardForm newDash = new DashboardForm() ;
        }
    }

    // addUser method to take in data from create account text fields and send them to database to create new user
    private void addUser(String name, String username, String password, String cnfmPassword){

        // send user data from sign up text boxes to database to add new user
        if(!password.equals(cnfmPassword)){
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
        }
        else{

            // send user data to database to create new user

        }
    }
}
