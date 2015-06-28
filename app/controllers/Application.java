package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok("your api is ok");
    }

    public  Result shiritori(){
        return ok();
    }
}
