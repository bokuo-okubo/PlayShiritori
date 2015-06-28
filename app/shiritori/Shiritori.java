package shiritori;

import play.mvc.Controller;

import java.util.*;

/**
 * Created by bko on 6/28/15.
 */
public class Shiritori extends Controller {
//
//    public Shiritori(){
//        //TODO : read yaml, or some extarnal file.
//        this.wordDictionary = new HashMap<String,ArrayList<String>>();
//        ArrayList ary = new ArrayList<String>();
//        ary.add("あざらし");
//        ary.add("あじさい");
//        ary.add("あめんぼ");
//        this.wordDictionary.put("あ",ary);
//    }

    public static String shiritori(String word, Map<String,Set<String>> dictionary) {
        //TODO : check the word type カタカナ or ひらがな or the other.
        if ( word == null) {
            return "wrong operation in Shiritori";
        }else if( word == "ん" ){
            return "m9(゜Д ゜)お前は既に死んでいる";
        }

        String lastWord = cutLastWord(word);

        Set wordSet = takeWordSet(lastWord, dictionary);
        List<String> word_array = new ArrayList<String>(wordSet);
        System.out.println(word_array);
        if (word_array.size() > 0){
            Collections.shuffle(word_array);
            return word_array.get(0);
        }else{
            return "wrong operation in Shiritori : Keyword NotFound";
        }
    }

    private static String cutLastWord(String word){
        String last_word = word.substring( word.length() - 1, word.length() );
        return last_word;
    }

    private static Set<String> takeWordSet(String key_word, Map<String,Set<String>> dictionary){
        if (dictionary.containsKey(key_word)) {
            dictionary.get(key_word);
            return dictionary.get(key_word);
        }else{
            return new HashSet<String>();
        }
    }
}
