import java.util.ArrayList;

public class WordSynonyms {
    private String word;
    private ArrayList<String> synonyms;

    public WordSynonyms(String word) {
        this.word = word;
        this.synonyms = new ArrayList<String>();
    }

    public String getWord() {
        return word;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void addSynonym(String synonym) {
        synonyms.add(synonym);
    }
}
