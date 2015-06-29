package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import helpers.FileHandler;
import helpers.JsonHandler;
import play.mvc.*;
import shiritori.Shiritori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Application extends Controller {

    public Result index() {
        return ok("api is working");
    }

    public Result randomword() {
        String body = "";
        try {
            body = debugging();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (IOException e) {
            System.out.println(e);
        }

        return ok(body);
    }

    public Result shiritori() throws IOException {
        JsonNode json = request().body().asJson();

        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String message = json.findPath("post").findPath("message").textValue();
            if(message == null) {
                return badRequest("Missing parameter [name]");
            } else {
                int idStr =json.findPath("post").findPath("account").findPath("id").intValue();
                /////////////////////////////////////
                FileHandler fh = new FileHandler();
                String str = fh.openFile("app/data/dictionary.json");
                JsonHandler jh = new JsonHandler();
                Map dictionary = jh.parse(str);

                String reqponseWord = Shiritori.shiritori(message, dictionary);

                String test = " { \"message\": \""+ reqponseWord +",\" \"replyTo\": "+ idStr + "}";
                return ok(test);
            }
        }
    }

    //TODO : delete
    public String debugging() throws IOException {
        FileHandler fh = new FileHandler();
        String str = fh.openFile("app/data/dictionary.json");
        //System.out.println(str);

        JsonHandler jh = new JsonHandler();
        Map json = jh.parse(str);
        String word = "じあ";

        return Shiritori.shiritori(word, json);
    }
}
