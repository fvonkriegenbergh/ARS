import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightsForm extends JFrame implements ActionListener {


    private JPanel rootPanel;
    private JLabel flightNumLabel;
    private JLabel departDestLabel;
    private JLabel arriveDestLabel;
    private JLabel departTimeLabel;
    private JLabel arriveTimeLabel;
    private JLabel baggageLabel;
    private JLabel seatNumLabel;
    private JLabel ticketNumLabel;
    private JButton bookButton;
    private JTable flightsTable;
    private JButton customerSupportBtn;
    private JButton backButton;
    private User currUser ;

    // default constructor
    public FlightsForm(){

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // default constructor
    public FlightsForm(User currUser){

        this.currUser = currUser ;

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // Override actionListener method for back, book, and customerSupportBtn
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){

            // open the dashboard frame with the current User object passed back
            DashboardForm prevDash = new DashboardForm(currUser) ;
            this.dispose() ;
        }
        if(e.getSource() == customerSupportBtn){

            // customer support live chat method
        }
        if(e.getSource() == bookButton){

            // method to book flight and add to user's flights
        }
    }
}
