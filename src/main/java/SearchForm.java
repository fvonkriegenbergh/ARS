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
    // send input ot database for search query and return desired flights
    private void searchFlights(String departLocInput, String arrivalLocInput, String departDateInput, String returnDateInput){

        ArrayList<Flight> availFlight = new ArrayList<Flight>() ;
        BookingForm newBook = new BookingForm(this.currUser) ;
    }

}
