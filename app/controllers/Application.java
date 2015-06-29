package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import helpers.FileHandler;
import helpers.JsonHandler;
import play.mvc.*;
import shiritori.Shiritori;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Application extends Controller {

    public Result index() {
        return ok("api is working");
    }

    public Result randomword() {
        String body = "";
        try {
            body = random();
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
                FileHandler fh = new FileHandler();
                String str = fh.openFile("app/data/dictionary.json");
                JsonHandler jh = new JsonHandler();
                Map dictionary = jh.parse(str);

                String reqponseWord = Shiritori.shiritori(message, dictionary);

                String test = " { \"message\": \"" + reqponseWord + "\" , \"replyTo\": "+ idStr + "}";
                return ok(test);
            }
        }
    }

    public String random() throws IOException {
        FileHandler fh = new FileHandler();
        String str = fh.openFile("app/data/dictionary.json");

        JsonHandler jh = new JsonHandler();
        Map json = jh.parse(str);
        ArrayList<String> list = new ArrayList<String>();
        list.add("あ");list.add("い");list.add("う");list.add("え");list.add("お");
        list.add("が");list.add("ぎ");list.add("ぐ");list.add("げ");list.add("ご");
        list.add("か");list.add("き");list.add("く");list.add("け");list.add("こ");
        list.add("さ");list.add("し");list.add("す");list.add("せ");list.add("そ");
        list.add("ざ");list.add("じ");list.add("ず");list.add("ぜ");list.add("ぞ");
        list.add("た");list.add("ち");list.add("つ");list.add("て");list.add("と");
        list.add("だ");list.add("ぢ");list.add("づ");list.add("で");list.add("ど");
        list.add("な");list.add("に");list.add("ぬ");list.add("ね");list.add("の");
        list.add("は");list.add("ひ");list.add("ふ");list.add("へ");list.add("ほ");
        list.add("ば");list.add("び");list.add("ぶ");list.add("べ");list.add("ぼ");
        list.add("ぱ");list.add("ぴ");list.add("ぷ");list.add("ぺ");list.add("ぽ");
        list.add("ま");list.add("み");list.add("む");list.add("め");list.add("も");
        list.add("や");list.add("ゆ");list.add("よ");
        list.add("ら");list.add("り");list.add("る");list.add("れ");list.add("ろ");
        list.add("わ");
        list.add("を");

        Collections.shuffle(list);
        String word = list.get(0);
        return Shiritori.shiritori(word, json);
    }
}
