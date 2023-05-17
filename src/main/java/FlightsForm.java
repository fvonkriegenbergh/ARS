import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FlightsForm extends JFrame implements ActionListener, MouseListener {

    private JPanel rootPanel;
    private JTable flightsTable;
    private JButton bookButton;
    private JLabel flightNumLabel;
    private JLabel departDestLabel;
    private JLabel arriveDestLabel;
    private JLabel departTimeLabel;
    private JLabel arriveTimeLabel;
    private JLabel baggageLabel;
    private JLabel seatNumLabel;
    private JLabel ticketNumLabel;
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

        this.backButton.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);
    }

    // default constructor
    // set FlightForm current user to currUser takes from parameter
    public FlightsForm(User currUser){



        // set title of frame
        this.setTitle("Your Flights") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        // add action listener to backButton to allow user to go back to Dashboard
        // call setYourFlights method to add in data to Flights table
        this.currUser = currUser ;
        this.customerSupportBtn.addActionListener(this);
        this.backButton.addActionListener(this) ;

        // populate table with currUser flights
//        setYourFlights(this.currUser.getFlightData()) ;
//        populate table with currUser flights
        if(!this.currUser.getUserFlights().isEmpty()){

            // add mouse listener to check which flight is clicked
            setYourFlights(this.currUser.getFlightData()) ;
            this.flightsTable.addMouseListener(this) ;
        }

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

            System.out.println("support");
            DashboardForm prevDash = new DashboardForm(currUser) ;
            this.dispose() ;
        }
        if(e.getSource() == customerSupportBtn){

            // customer support live chat method
            SupportChatbotForm initChat = new SupportChatbotForm() ;
            System.out.println("support");
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

    //
    // override mouslistener methods
    //
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
        // empty mousePressed method
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // empty mouseReleased method
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // empty mouseEntered method
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // empty mouseExited method
    }
}
