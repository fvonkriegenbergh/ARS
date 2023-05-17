import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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
    private void loginUser(String username, String password) {

        User theUser = new User();
        // if username or password entry is empty, printout missing credential message to user
        if ((username.equals("")) || (password.equals(""))) {

            // Display error message box to user if no username or password
            JOptionPane.showMessageDialog(this, "No username or password");
        } else {

            // send user credentials to database to check if valid user
//            System.out.println("Login method");

            //Replace my "<username>" and "<password>" with your own unique ones

            MongoClient client = MongoClients.create(
                    "mongodb+srv://Nelso177:Beartear836@cluster0.uwuwakt.mongodb.net/?retryWrites=true&w=majority");

            MongoDatabase db = client.getDatabase("AirlineResSystem");

            MongoCollection tUser = db.getCollection("tUser");

            Document foundUser = new Document("username", username).append("password", password);

            //specific doc retrieve in collection
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("username", username);
            MongoCursor<Document> theCursor = tUser.find(searchQuery).iterator();
            while (theCursor.hasNext()) {
                theUser.setUserName((String) theCursor.next().get("username"));
            }
            theCursor = tUser.find(searchQuery).iterator();
            while (theCursor.hasNext()) {
                theUser.setFullName((String) theCursor.next().get("fullname"));
            }
            theCursor = tUser.find(searchQuery).iterator();
            while (theCursor.hasNext()) {
                theUser.setUserPassword((String) theCursor.next().get("password"));
            }
            while (theCursor.hasNext()) {
                theUser.setFlierMiles((Integer) theCursor.next().get("fliermiles"));
            }

            String currentUserPassword = theUser.getUserPassword();

            if (currentUserPassword.equals(password)) {
                DashboardForm newDash = new DashboardForm(theUser) ;
            }
            else if (!currentUserPassword.equals(password)) {
                JOptionPane.showMessageDialog(this, "Login information incorrect!");
            }

            System.out.println(theUser.getUserName());
            System.out.println(theUser.getEmail());
            System.out.println(theUser.getFullName());
            System.out.println(theUser.getUserPassword());

            System.out.println("Getting user");
            System.out.println(theUser.getUserName());
            tUser.find(foundUser);

//            tUser.insertOne(test);
            if (foundUser != null) {
                DashboardForm newDash = new DashboardForm(theUser);
            }
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
            //Replace my "<username>" and "<password>" with your own unique ones

            MongoClient client = MongoClients.create(
                    "mongodb+srv://Nelso177:Beartear836@cluster0.uwuwakt.mongodb.net/?retryWrites=true&w=majority");

            MongoDatabase db = client.getDatabase("AirlineResSystem");

            MongoCollection tUser = db.getCollection("tUser");

            Document test = new Document("username", username).append("password", password).append
                    ("fullname", name).append("fliermiles",0);

            tUser.insertOne(test);

        }
    }
}

//public User getUser()
