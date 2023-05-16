import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingForm extends JFrame implements ActionListener, TableModelListener {
    private JTable flightsTable;
    private JPanel rootPanel;
    private JButton customerSupportBtn;
    private JButton backButton;
    private JLabel flightNumLabel;
    private JLabel departDestLabel;
    private JLabel arriveDestLabel;
    private JLabel departTimeLabel;
    private JLabel arriveTimeLabel;
    private JLabel baggageLabel;
    private JLabel seatNumLabel;
    private JLabel ticketNumLabel;
    private JButton bookButton;
    private User currUser;

    // default constructor
    public BookingForm(){

        backButton.addActionListener(this);
        customerSupportBtn.addActionListener(this);

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // default constructor
    public BookingForm(User currUser){
        // set title of frame
        this.setTitle("Flights") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        this.currUser = currUser ;
        this.backButton.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){

            // open the dashboard frame with the current User object passed back
            System.out.println("support");
            DashboardForm prevDash = new DashboardForm(currUser) ;
            this.dispose() ;
        }
        if(e.getSource() == customerSupportBtn){

            // customer support live chat method
            SupportChatbotForm initChat = new SupportChatbotForm() ;
            System.out.println("support");
        }
    }

    // Override TableModelListener method for TableModel object
    @Override
    public void tableChanged(TableModelEvent e) {

        // Override TableModelListener
    }
}
