import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Replace my "<username>" and "<password>" with your own unique ones

        /*MongoClient client = MongoClients.create(
                "mongodb+srv://<username>:<password>@cluster0.uwuwakt.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("AirlineResSystem");

        MongoCollection tUser = db.getCollection("tUser");

        Document test = new Document("username", "Ali068").append("email", "Charles@email.com")
                .append("password", "12345").append("fullname", "Ahmed Ali").append("fliermiles", 0);

        tUser.insertOne(test);*/

        // initialize login form page
        //LoginForm initLogin = new LoginForm() ;
        // test FlightForm
        Flight newFlight = new Flight(true, 123, "13:30", "05:30", "Sao Paulo, BR",
                "Tokyo, JP", "ANA", 200, 850, "16:00",
                "5-17-2023", "5-23-2023") ;
        Flight newFlight1 = new Flight(false, 567, "50:30", "05:30", "Sao Paulo, BR",
                "Los Angeles, US", "LAX", 200, 850, "16:00",
                "5-17-2023", "5-23-2023") ;
        Flight newFlight2 = new Flight(false, 4554, "90:30", "05:30", "Sao Paulo, BR",
                "Seoul, KR", "KAL", 200, 850, "16:00",
                "5-17-2023", "5-23-2023") ;
        User testUser = new User("testUserName", "John Smith", "testPassword", "testEmail",
                "ID123456", new ArrayList<Flight>(), 5678) ;

        testUser.bookFlight(newFlight) ;
        testUser.bookFlight(newFlight1) ;
        testUser.bookFlight(newFlight2) ;
        // initialize login form page
        //LoginForm initLogin = new LoginForm() ;
        //DashboardForm newDash = new DashboardForm(testUser) ;
        //FlightSearchForm newFlightSearchForm = new FlightSearchForm() ;
        FlightsForm newFlights = new FlightsForm(testUser) ;
        //BookingForm newBook = new BookingForm(testUser) ;
    }
}