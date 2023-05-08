import javax.swing.*;

public class LoginForm {
    private JPanel rootPanel;
    private JTextField usernameLoginTextField;
    private JPasswordField loginPasswordField;
    private JTextField nameCreateAccountTextField;
    private JTextField usernameCreateAccountTextField;
    private JTextField passwordCreateAccountTextField;
    private JTextField textField1;
    private JButton createAccountButton;
    private JButton loginButton;
    private JLabel arsTitleLabel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
