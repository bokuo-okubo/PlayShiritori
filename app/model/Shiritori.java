package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bko on 6/28/15.
 */
public class Shiritori {
    private Map wordDictionary;
    public static final String MATCH_HIRAGANA = "^[\\u3040-\\u309F]+$";
    public static final String MATCH_KATAKANA = "^[\\u30A0-\\u30FF]+$";
    public static final String MATCH_HANKANA = "^[\\uFF65-\\uFF9F]+$";
    public static final String MATCH_ZENKAKU = "^[\\u3040-\\u30FF]+$";

    public Shiritori(){
        //TODO : read yaml, or some extarnal file.
        this.wordDictionary = new HashMap<String,ArrayList<String>>();
        ArrayList ary = new ArrayList<String>();
        ary.add("あざらし");
        ary.add("あじさい");
        ary.add("あめんぼ");
        this.wordDictionary.put("あ",ary);
    }

    public String shiritori(String lastWord) {
        //TODO : check the word type カタカナ or ひらがな or the other.
        if (lastWord == null) {
            return "wrong operation in Shiritori";
        }else if(lastWord == "ん" ){
            return "m9(゜Д ゜)お前は既に死んでいる";
        }

        ArrayList<String> word_array = takeWordArray(lastWord);
        if (word_array.size() > 0){
            Collections.shuffle(word_array);
            return word_array.get(0);
        }else{
            return "wrong operation in Shiritori : Keyword NotFound";
        }
    }
    
    private ArrayList<String> takeWordArray(String key_word){
        if (this.wordDictionary.containsKey(key_word)) {
            return (ArrayList<String>) this.wordDictionary.get(key_word);
        }else{
            return new ArrayList<String>();
        }
    }
}
