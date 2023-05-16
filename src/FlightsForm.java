import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FlightsForm extends JFrame implements ActionListener, MouseListener {

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
    private JTable flightsTable ;
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

        // set FlightForm current user to currUser takes from parameter
        // add action listener to backButton to allow user to go back to Dashboard
        // call setYourFlights method to add in data to Flights table
        this.currUser = currUser ;
        this.backButton.addActionListener(this) ;
        setYourFlights(this.currUser.getFlightData()) ;

        // add mouse listener to check which flight is clicked
        this.flightsTable.addMouseListener(this) ;

        this.setContentPane(this.rootPanel) ;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(700, 500) ;
        this.setLocationRelativeTo(null) ;
        this.setVisible(true) ;
    }

    // Override actionListener method for back, book, and customerSupportBtn
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){

            // open the dashboard frame with the current User object passed back
            DashboardForm newDash = new DashboardForm(currUser) ;
            this.dispose() ;
        }
        if(e.getSource() == customerSupportBtn){

            // customer support live chat method
        }
        if(e.getSource() == bookButton){

            // method to book flight and add to user's flights
        }
    }

    public void setYourFlights(String[][] data){

        String[] column=new String[]{"BAGGAGE","TICKET NUM","ARRIVAL TIME", "DEPARTURE TIME", "DEPARTURE", "ARRIVAL"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300) ;

        this.flightsTable.setColumnModel(jt.getColumnModel());
        this.flightsTable.setModel(jt.getModel());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.flightsTable.rowAtPoint(e.getPoint()) ;
        Flight clickedFlight = currUser.getUserFlights().get(row) ;
        this.departDestLabel.setText(clickedFlight.getDepartDest()) ;
        this.arriveDestLabel.setText(clickedFlight.getArrivalDest()) ;
        this.departTimeLabel.setText(clickedFlight.getDepartTime()) ;
        this.arriveTimeLabel.setText(clickedFlight.getArrivalTime()) ;
        this.ticketNumLabel.setText(clickedFlight.getTicketNum() + "") ;
        if(clickedFlight.isBaggage()){
            this.baggageLabel.setText("yes");
        }
        else{
            this.baggageLabel.setText("no");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
