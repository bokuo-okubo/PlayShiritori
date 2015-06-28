package controllers;

import helpers.FileHandler;
import helpers.JsonHandler;
import play.mvc.*;

import java.io.FileNotFoundException;

public class Application extends Controller {

    public Result index() {
        try {
            debugging();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ok("your api is ok");
    }

    public  Result shiritori(){
        return ok();
    }


    //TODO : delete
    public void debugging() throws FileNotFoundException {
        JsonHandler jh = new JsonHandler();
        jh.parsiong();

        FileHandler fh = new FileHandler();
        String str = fh.openFile("app/data/dictionary.json");
        System.out.println(str);
    }

}
