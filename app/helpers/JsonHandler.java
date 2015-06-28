package helpers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bko on 6/28/15.
 */
public class JsonHandler  {
    Person person = new Person();

    public Map<String,Set> parse(String jsonStr) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        try{
            HashMap<String,Set> result = mapper.readValue(jsonStr,HashMap.class);
            System.out.println(result);
            return result;
        }catch (JsonParseException e){
            System.out.println(e);
            return new HashMap<String,Set>();
        }
    }
}