import java.util.ArrayList;

public class MainMV {
    public static void main(String[] args) {

        String filename = "";
        ArrayList<WordSynonyms> masterSynList = SynonymReader.parseLines(SynonymReader.readSynonymFile(filename));

        ArrayList<Question> questions = new ArrayList<Question>();


    }

    public ArrayList<Answer> rankAnswers(Question question, ArrayList<Answer> answers) {
        for (Answer answer : answers) {
            answer.giveScore(question.getSynonyms(), question.getImportantWords());
        }
        boolean interrupted = true;
        while (interrupted = true) {
            interrupted = false;
            for (int i = 0; i < answers.size()-1; i++) {
                Answer temp1 = answers.get(i);
                Answer temp2 = answers.get(i+1);
                if (temp2.getScore() > temp1.getScore()) {
                    answers.set(i, temp2);
                    answers.set(i + 1, temp1);
                    interrupted = true;
                }
            }
        }
        return answers;
    }
}
