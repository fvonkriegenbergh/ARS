public class Flight {

    private boolean baggage ;
    private int flightID ;
    private int ticketNum ;
    private String arrivalTime ;
    private String departTime ;
    private String arrivalDest ;
    private String departDest ;
    private String airline ;

    // default constructor
    public Flight(){
    }

    // constructor that takes in all data for instance variables
    public Flight(boolean baggage, int flightID, int ticketNum,
                  String arrivalTime, String departTime,
                  String arrivalDest, String departDest, String airline) {
        this.baggage = baggage;
        this.flightID = flightID;
        this.ticketNum = ticketNum;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
        this.arrivalDest = arrivalDest;
        this.departDest = departDest;
        this.airline = airline;
    }

    //
    // Setters and getters for flight class
    //
    public boolean isBaggage() {
        return baggage;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public String getArrivalDest() {
        return arrivalDest;
    }

    public String getDepartDest() {
        return departDest;
    }

    public String getAirline() {
        return airline;
    }

    public void setBaggage(boolean baggage) {
        this.baggage = baggage;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setArrivalDest(String arrivalDest) {
        this.arrivalDest = arrivalDest;
    }

    public void setDepartDest(String departDest) {
        this.departDest = departDest;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
    //
    // End of setters and getters flights
    //

}