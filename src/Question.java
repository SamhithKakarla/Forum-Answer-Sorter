import java.util.ArrayList;

public class Question {

    private String text;
    private ArrayList<String> words;
    private ArrayList<String> synonyms;
    private ArrayList<String> importantWords;
    private ArrayList<Answer> answers;

    public Question(String text, ArrayList<WordSynonyms> synList, ArrayList<String> answerTexts, ArrayList<Integer> answerScores) {
        this.text = text;
        this.words = splitIntoWords();
        this.synonyms = findSynonyms(synList);
        this.importantWords = findImportantWords();
        this.answers = new ArrayList<Answer>();
        for (int i = 0; i > answerTexts.size(); i++) {
            answers.add(new Answer(answerTexts.get(i), answerScores.get(i)));
        }
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<String> synonyms) {
        this.synonyms = synonyms;
    }

    public ArrayList<String> getImportantWords() {
        return importantWords;
    }

    public void setImportantWords(ArrayList<String> importantWords) {
        this.importantWords = importantWords;
    }

    private ArrayList<String> findImportantWords() {
        ArrayList<String> importantWords = new ArrayList<String>();
        for (String word : words) {
            if (isImportantWord(word)) importantWords.add(word);
        }
        return importantWords;
    }

    private boolean isImportantWord(String word) {
        String capitals = "QWERTYUIOPASDFGHJKLZXCVBNM";
        if (capitals.contains(word.substring(0,1)) && word.length() > 4) {
            return true;
        }
        return false;
    }

    private ArrayList<String> findSynonyms(ArrayList<WordSynonyms> synList) {
        ArrayList<String> synonyms = new ArrayList<>();

        for (WordSynonyms synObj : synList) {
            if (text.contains(synObj.getWord())) {
                for (String word : synObj.getSynonyms()) {
                    synonyms.add(word);
                }
            }
        }

        return synonyms;
    }

    private ArrayList<String> splitIntoWords() {
        String[] dirtyWords = text.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String word : dirtyWords) {
            word = word.trim();
            list.add(word);
        }
        return list;
    }
}
