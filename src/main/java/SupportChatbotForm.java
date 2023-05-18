import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupportChatbotForm extends JFrame implements ActionListener {
    private JTextArea chatTextArea;
    private JButton sendButton;
    private JTextField chatTextField;
    private JPanel rootPanel;


    public SupportChatbotForm(){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        sendButton.addActionListener(this) ;
        chatTextField.addActionListener(this);

        this.setTitle("Support") ;
        this.setLocationRelativeTo(null);
        this.setContentPane(this.rootPanel) ;
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.pack() ;
        this.setVisible(true) ;
        this.chatTextArea.append("Support: Welcome to the ARS Support chatbot. How may I help you?\n\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sendButton || e.getSource() == chatTextField){

            String message;
            message = this.chatTextField.getText();
            this.chatTextField.setText("");
            if (message == ""){
                return;
            }

            this.chatTextArea.append("You: " + message + "\n\n");
            message = message.toLowerCase();
            if (message.contains("view") || message.contains("booked") || message.contains("track")) {
                this.chatTextArea.append("Support: To view your booked flights, first navigate to the dashboard by clicking the back button if you aren't already there. Then, choose the Book Flight option in the navigation pane. You should then be able to view your booked flights on the list, and clicking one will bring up a pane with more information in the bottom right corner.\n\n");
            } else if (message.contains("book")){
                this.chatTextArea.append("Support: To book a flight, first navigate to the dashboard by clicking the back button if you aren't already there. Then, choose the Book Flight option in the navigation pane. Enter your desired departure and arrival destinations. You should then be able to pick a flight from the list, and book it after viewing more detailed information about the flight in the bottom right corner.\n\n");
            } else {
                this.chatTextArea.append("Support: I'm sorry, but I don't know how to answer that. Please try again with a different wording, or ask a different question");
            }
        }
    }
}
