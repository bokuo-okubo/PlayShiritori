package shiritori;

import play.mvc.Controller;

import java.util.*;

/**
 * Created by bko on 6/28/15.
 */
public class Shiritori extends Controller {
    private Map wordDictionary;

    public Shiritori(){
        //TODO : read yaml, or some extarnal file.
        this.wordDictionary = new HashMap<String,ArrayList<String>>();
        ArrayList ary = new ArrayList<String>();
        ary.add("あざらし");
        ary.add("あじさい");
        ary.add("あめんぼ");
        this.wordDictionary.put("あ",ary);
    }

    public String shiritori(String lastWord, Map<String,Set<String>> dictionary) {
        //TODO : check the word type カタカナ or ひらがな or the other.
        if (lastWord == null) {
            return "wrong operation in Shiritori";
        }else if(lastWord == "ん" ){
            return "m9(゜Д ゜)お前は既に死んでいる";
        }

        //debug
        char c = lastWord.charAt(lastWord.length() - 1) ;
        lastWord = String.valueOf(c);
        System.out.print("-----------" + c);
        //-----
        Set wordSet = takeWordArray(lastWord, dictionary);
        List<String> word_array = new ArrayList<String>(wordSet);
        System.out.println("--------------------------------" + lastWord);
        System.out.println(word_array);
        if (word_array.size() > 0){
            Collections.shuffle(word_array);
            return word_array.get(0);
        }else{
            return "wrong operation in Shiritori : Keyword NotFound";
        }
    }

    private Set<String> takeWordArray(String key_word,Map<String,Set<String>> dictionary){
        if (dictionary.containsKey(key_word)) {
            System.out.println( "==================================" +
                    dictionary.get(key_word).getClass() );
            return dictionary.get(key_word);
        }else{
            return new HashSet<String>();
        }
    }
}
