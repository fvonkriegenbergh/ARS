import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Replace my "<username>" and "<password>" with your own unique ones

        MongoClient client = MongoClients.create(
                "mongodb+srv://Naver001:Cnavera12345@cluster0.uwuwakt.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("AirlineResSystem");

        MongoCollection tUser = db.getCollection("tUser");

        Document test = new Document("username", "Ali068").append("email", "Charles@email.com")
                .append("password", "12345").append("fullname", "Ahmed Ali").append("fliermiles", 0);

        tUser.insertOne(test);

        // initialize login form page
        LoginForm initLogin = new LoginForm() ;
    }
}