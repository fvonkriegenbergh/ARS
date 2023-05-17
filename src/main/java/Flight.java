public class Flight {

    private boolean baggage ;
    private String ticketNum ;
    private String arrivalTime ;
    private String departTime ;
    private String arrivalDest ;
    private String departDest ;
    private String airline ;
    private String flightMileage ;
    private int flightPrice ;
    private String flightDuration ;
    private String departDate ;
    private String returnDate ;


    // default constructor
    public Flight(){
    }

    // constructor that takes in all data for instance variables
    public Flight(boolean baggage, String ticketNum, String arrivalTime, String departTime,
                  String arrivalDest, String departDest, String airline, String flightMileage,
                  int flightPrice, String flightDuration, String departDate, String returnDate) {
        this.baggage = baggage;
        this.ticketNum = ticketNum;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
        this.arrivalDest = arrivalDest;
        this.departDest = departDest;
        this.airline = airline;
        this.flightMileage = flightMileage ;
        this.flightPrice = flightPrice ;
        this.flightDuration = flightDuration ;
        this.departDate = departDate ;
        this.returnDate = returnDate ;
    }

    //
    // Setters and getters for flight class
    //
    public boolean isBaggage() {
        return baggage;
    }

    public String getTicketNum() {
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

    public String getFlightMileage() {return flightMileage; }

    public int getFlightPrice() { return flightPrice; }

    public String getFlightDuration() { return flightDuration; }

    public String getDepartDate() { return departDate; }

    public String getReturnDate() { return returnDate; }

    public void setBaggage(boolean baggage) {
        this.baggage = baggage;
    }

    public void setTicketNum(String ticketNum) {
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

    public void setFlightMileage(String newFlightMileage) { this.flightMileage = newFlightMileage; }

    public void setFlightPrice(int newFlightPrice) { this.flightPrice = newFlightPrice; }

    public void setFlightDuration(String newFlightDuration) {this.flightDuration = newFlightDuration; }

    public void setDepartDate(String newDepartDate) { this.departDate = newDepartDate; }

    public void setReturnDate(String newReturnDate) { this.returnDate = newReturnDate; }
    //
    // End of setters and getters flights
    //

    public String toString(){
        return "Ticket Num:\n" + this.ticketNum + "Arrival Depart Time:\n" + this.departTime + "Airline:\n" + this.airline ;
    }

    public String[] getFlightInformation(){
        return new String[]{this.baggage + "", this.ticketNum + "", this.arrivalTime, this.departTime,
                            this.arrivalDest, this.departDest} ;
    }
}