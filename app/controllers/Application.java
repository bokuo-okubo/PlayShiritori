package controllers;

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

    public Result shiritori(){
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
