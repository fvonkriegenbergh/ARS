import java.util.ArrayList;

public class User {

    private String userName ;
    private String fullName ;
    private String userPassword ;
    private String userID ;
    private String email ;
    private ArrayList<Flight> userFlights ;
    private int flierMiles ;

    // default constructor
    public User(){}

    // constructor that takes in all instance variables
    public User(String userName, String fullName, String userPassword, String email,
                String userID, ArrayList<Flight> userFlights, int flierMiles) {
        this.userName = userName;
        this.fullName = fullName;
        this.userPassword = userPassword;
        this.email = email ;
        this.userID = userID;
        this.userFlights = userFlights;
        this.flierMiles = flierMiles;
    }

    //
    // Setters and getters for instance variables
    //
    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getEmail(){return email; }

    public String getUserID() {
        return userID;
    }

    public ArrayList<Flight> getUserFlights() {
        return userFlights;
    }

    public int getFlierMiles() {
        return flierMiles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setEmail(String email){this.email = email;}

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserFlights(ArrayList<Flight> userFlights) {
        this.userFlights = userFlights;
    }

    public void setFlierMiles(int flierMiles) {
        this.flierMiles = flierMiles;
    }
    //
    // End of setters and getters
    //


    // method to add new additional miles to user's flier miles
    public void addFlierMiles(int newFlierMiles){
        this.flierMiles = flierMiles + newFlierMiles ;
    }

    // method to add new flight to user's flights data struct
    // takes in flight object
    public void bookFlight(Flight newFlight){
        this.userFlights.add(newFlight)  ;
    }


    public String toString(){
        return this.userID + "\n" + this.fullName + "\n" + this.userPassword + "\n" + this.userID
                + "\n" + this.email + "\n" + this.flierMiles ;
    }
}