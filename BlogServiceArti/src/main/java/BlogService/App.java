package BlogService;

import static spark.Spark.*;
import static spark.Spark.post;
import spark.Request;
import spark.Response;
import spark.Route;
import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        port(8080);
        get("/hello", (req, res) -> {
            return "Hello Sparkingly World!";
        });

        get("/world", (req, res) -> {
            return "Hello uurs World!";
        });

        /*get("/posts", (request, response) -> {
            response.status(200);
            response.type("application/json");
            return dataToJson(model.getAllPosts());
        });*/

        Gson gson = new Gson();
        post("/hello1", (request, response) ->
             new MyMessage("Hello World"), gson::toJson);

        post("/hello2", "application/json", (request, response) -> {
            System.out.println(" request attri " +
                    ":"+request.queryMap("apiKey").value());
            return new MyMessage("Hello World");
        }, new JsonTransformer());


    }
}
