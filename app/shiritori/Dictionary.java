package shiritori;

import play.api.mvc.Controller;

import java.util.Map;
import java.util.Set;

/**
 * Created by bko on 6/28/15.
 */
public interface Dictionary  {

    //add a single word into dictionary
    Map<String,Set<String>> addWord(String word);

}
