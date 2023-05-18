import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchForm extends JFrame implements ActionListener {
    private JPanel mainSearchPan;
    private JLabel departDate;
    private JPanel departArrivalLocationPan;
    private JPanel departArrivalDatePan;
    private JTextField departLocInput;
    private JLabel departureLocationLbl;
    private JLabel arrivalLocLbl;
    private JTextField arrivalLocationInput;
    private JTextField departDateInput;
    private JTextField returnDateInput;
    private JLabel returnDateILbl;
    private JButton searchFlightBtn;
    private JButton searchBackBtn;
    private User currUser ;

    // default constructor
    public SearchForm(){

        this.searchFlightBtn.addActionListener(this) ;
        this.searchBackBtn.addActionListener(this) ;

        this.setTitle("Search Flight");
        this.setContentPane(this.mainSearchPan);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 400);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // constructor that takes in user in parameter
    public SearchForm(User currUser){

        this.currUser = currUser ;

        this.searchFlightBtn.addActionListener(this) ;
        this.searchBackBtn.addActionListener(this) ;

        this.setTitle("Search Flight");
        this.setContentPane(this.mainSearchPan);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        this.setSize(600, 300);
        this.setLocationRelativeTo(null) ;
        this.setVisible(true);
    }

    // override actionListener for searchFlightBtn
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchFlightBtn){
            String departLocInput = this.departLocInput.getText() ;
            String arrivalLocInput = this.arrivalLocationInput.getText() ;
            String departDateInput = this.departDate.getText() ;
            String returnDateInput = this.returnDateInput.getText() ;

            if((departLocInput.equals("")) || (arrivalLocInput.equals("")) || (departDateInput.equals("")) || (returnDateInput.equals(""))){
                JOptionPane.showMessageDialog(this, "One or more fields missing input!");
            }
            else{
                System.out.println("test Showing available flights") ;
                searchFlights(departLocInput, arrivalLocInput, departDateInput, returnDateInput) ;
            }
        }
        if(e.getSource() == searchBackBtn){
            DashboardForm newDash = new DashboardForm(this.currUser) ;
            this.dispose() ;
        }
    }

    // take in user input for desired searched flight
    // send input to database for search query and return desired flights
    private void searchFlights(String departLocInput, String arrivalLocInput, String departDateInput, String returnDateInput){
        Flight theFlight ;
        ArrayList<Flight> newFlight = new ArrayList<Flight>();
        MongoClient client = MongoClients.create(
                "mongodb+srv://Nelso177:Beartear836@cluster0.uwuwakt.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("AirlineResSystem");

        MongoCollection tFlights = db.getCollection("tFlights");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("departure",departLocInput);
        MongoCursor<Document> theCursor = tFlights.find(searchQuery).iterator();
        while (theCursor.hasNext()) {
            theFlight = new Flight() ;
            var doc = theCursor.next();
            theFlight.setDepartDest((String) doc.get("departure"));
            theFlight.setArrivalDest((String) doc.get("arrival"));
            theFlight.setDepartDate((String) doc.get("departDate"));
            theFlight.setReturnDate((String) doc.get("returnDate"));
            theFlight.setFlightPrice((Integer) doc.get("flightPrice"));
            theFlight.setBaggage((Boolean) doc.get("baggage"));
            theFlight.setFlightDuration((String) doc.get("flightDuration"));
            theFlight.setFlightMileage((String) doc.get("flightMileage"));
            theFlight.setTicketNum((String) doc.get("ticketNum"));
            theFlight.setDepartTime((String) doc.get("departTime"));
            theFlight.setArrivalTime((String) doc.get("arrivalTime"));


            if (theFlight.getDepartDest().equals(departLocInput) && theFlight.getArrivalDest().equals(arrivalLocInput)){
                newFlight.add(theFlight);
                System.out.println(newFlight.toString());
            }
        }

        if (!newFlight.isEmpty()){
            //display on BookingForm: baggage, ticket, dept/arriv time, dept/arriv location
            BookingForm bookingForm = new BookingForm(this.currUser, newFlight);
            this.dispose() ;
        }
        else{
            JOptionPane.showMessageDialog(this, "No Flights found with those search parameters.");
        }





    }

}
