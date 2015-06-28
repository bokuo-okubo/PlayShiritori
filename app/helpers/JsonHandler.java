package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by bko on 6/28/15.
 */
public class JsonHandler {
    Person person = new Person();

    public void parsiong(){
        person.firstName = "Foo";
        person.lastName = "Bar";
        person.age = 30;
        JsonNode personJson = Json.toJson(person);
        System.out.println(personJson);
    }
}
