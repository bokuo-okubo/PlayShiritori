package shiritori;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by bko on 6/28/15.
 */
public class HiraganaDictionary implements Dictionary {

    private Map<String,Set<String>> dictionary;
    public static final String MATCH_HIRAGANA = "^[\\u3040-\\u309F]+$";
    public static final String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";
    public static final String MATCH_HANKANA = "^[\\uFF65-\\uFF9F]+$";
    public static final String MATCH_ZENKAKU = "^[\\u3040-\\u30FF]+$";

    public HiraganaDictionary(){
        Map<String,Set<String>> dictionary = new HashMap<String,Set<String>>();
    }

    @Override
    public Map<String, Set<String>> addWord(String word) {
        if ( !word.equals(MATCH_HIRAGANA) ){
            return dictionary;
        }
        return null;
    }

    @Override
    public Map<String, Set<String>> addWords(Set words) {
        return null;
    }
}
