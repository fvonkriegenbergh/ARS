import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BookingForm extends JFrame implements ActionListener, MouseListener {
    private JScrollPane scrollFlight;
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
    private JTable flightsTable;
    private User currUser;
    private ArrayList<Flight> displayFlight ;
    private int currClickFlight ;

    // default constructor
    public BookingForm(){

        backButton.addActionListener(this);
        customerSupportBtn.addActionListener(this);

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(700, 500);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // Constructor that takes in user as parameter
    public BookingForm(User currUser){
        // set title of frame
        this.setTitle("Available Flights") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        this.currUser = currUser ;
        this.backButton.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);
        this.bookButton.addActionListener(this) ;
        this.flightsTable.addMouseListener(this) ;

        displayAvailableFlights(this.currUser.getFlightData());

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(700, 500);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // Constructor that takes in user as parameter
    public BookingForm(User currUser, ArrayList<Flight> newFlights){
        // set title of frame
        this.setTitle("Available Flights") ;

        // set UI display look consistent with login page
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.toString());
        }

        this.currUser = currUser ;
        this.displayFlight = newFlights ;
        this.backButton.addActionListener(this);
        this.customerSupportBtn.addActionListener(this);
        this.bookButton.addActionListener(this) ;
        this.flightsTable.addMouseListener(this) ;

        displayAvailableFlights(displayFlightData(this.displayFlight));

        this.setContentPane(this.rootPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(700, 500);
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
        if(e.getSource() == bookButton){
            bookNewFlight(displayFlight.get(this.currClickFlight));
        }
    }

    public void bookNewFlight(Flight newFlight){
        this.currUser.bookFlight(newFlight) ;
        this.currUser.addFlierMiles(Integer.parseInt(newFlight.getFlightMileage())) ;
        // send new flight to user's flights in the database

    }

    // method to display avaiable flights pulled from db
    public void displayAvailableFlights(String[][] data){
        String[] column=new String[]{"BAGGAGE","TICKET NUM","ARRIVAL TIME", "DEPARTURE TIME", "ARRIVAL", "DEPARTURE"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300) ;

        this.flightsTable.setColumnModel(jt.getColumnModel());
        this.flightsTable.setModel(jt.getModel());
        this.flightsTable.setEnabled(false) ;
        this.scrollFlight.getViewport().add(flightsTable);
    }

    // generate 2d array to return for populating the JTable for FlightsForm
    public String[][] displayFlightData(ArrayList<Flight> displayFlight){
        String[][] returnFlightData = new String[displayFlight.size()][6] ;
        if(!displayFlight.isEmpty()){
            for(int i = 0; i < displayFlight.size(); i++){
                returnFlightData[i] = displayFlight.get(i).getFlightInformation() ;
            }
            return returnFlightData ;
        }
        return new String[0][0] ;
    }

    //
    // override mouselistener methods
    //
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.flightsTable.rowAtPoint(e.getPoint()) ;
        Flight clickedFlight = displayFlight.get(row) ;
        this.currClickFlight = row ;
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
