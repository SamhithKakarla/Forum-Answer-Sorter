import java.util.ArrayList;

public class Answer {

    String answer;
    int score;
    int numUpVotes;

    public Answer(String answer, int numUpVotes){
        this.answer = answer;
        this.score = score;
        this.numUpVotes = numUpVotes;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumUpVotes() {
        return numUpVotes;
    }

    public void setNumUpVotes(int numUpVotes) {
        this.numUpVotes = numUpVotes;
    }

    public String[] splitIntoWords(){
        return answer.split(" ");
    }

    public double getPercentSynonymsWithQuestion(ArrayList<String> questionSynonyms){
        String[] answerwords = splitIntoWords();
        double counter = 0;
        for (int i = 0; i < answerwords.length; i++) {
            for (int j = 0; j < questionSynonyms.size(); j++) {
                if (answerwords[i].equals(questionSynonyms.get(j))){
                    counter++;
                }
            }
        }

        return counter;

    }

    public int numKeyTermsFromQuestion(ArrayList<String> questionKeyTerms){
        String[] answerwords = splitIntoWords();
        int counter = 0;
        for (int i = 0; i < answerwords.length; i++) {
            for (int j = 0; j < questionKeyTerms.size(); j++) {
                if (answerwords[i].equals(questionKeyTerms.get(j))){
                    counter++;
                }
            }
        }

        return counter;

    }

    public boolean IfImportantTerms(){
        if(answer.contains("because") || answer.contains("such as") || answer.contains("depends") || answer.contains("answer")){
            return true;
        }

        return false;
    }

    public void giveScore(ArrayList<String> questionSynonyms,ArrayList<String> questionKeyTerms ) {
        if (getPercentSynonymsWithQuestion(questionSynonyms) >= 0.3) {
            setScore(getScore() + 15);
        } else if (getPercentSynonymsWithQuestion(questionSynonyms) >= 0.2 && getPercentSynonymsWithQuestion(questionSynonyms) < 0.3) {
            setScore(getScore() + 10);
        } else if (getPercentSynonymsWithQuestion(questionSynonyms) >= 0.1 && getPercentSynonymsWithQuestion(questionSynonyms) < 0.2) {
            setScore(getScore() + 5);
        }

        if (numKeyTermsFromQuestion(questionKeyTerms) > 7) {
            setScore(getScore() + 25);
        } else if (numKeyTermsFromQuestion(questionKeyTerms) >= 5 && numKeyTermsFromQuestion(questionKeyTerms) <= 7) {
            setScore(getScore() + 15);
        } else if (numKeyTermsFromQuestion(questionKeyTerms) >= 2 && numKeyTermsFromQuestion(questionKeyTerms) <= 5) {
            setScore(getScore() + 7);
        }

        if(IfImportantTerms() == true){
            setScore(getScore() + 10);
        }


    }
}

