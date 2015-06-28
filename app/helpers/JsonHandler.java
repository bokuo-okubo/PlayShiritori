package helpers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by bko on 6/28/15.
 */
public class JsonHandler  {
    Person person = new Person();

    public void parse(String jsonStr) throws IOException {
        person.firstName = "Foo";
        person.lastName = "Bar";
        person.age = 30;
        JsonNode personJson = Json.toJson(person);
        System.out.println(personJson);

        String json = "{\"id\":20, \"name\":\"HOGE\"}";

        ObjectMapper mapper = new ObjectMapper();
        try{
            HashMap<String,Set> result = mapper.readValue(jsonStr,HashMap.class);
            System.out.println(result);
        }catch (JsonParseException e){
            System.out.println(e);
        }
    }
}