package controllers;

import helpers.JsonHandler;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        debugging();
        return ok("your api is ok");
    }

    public  Result shiritori(){
        return ok();
    }


    //TODO : delete
    public void debugging(){
        JsonHandler jh = new JsonHandler();
        jh.parsiong();
    }

}
