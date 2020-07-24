import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SynonymReader {

    public static ArrayList<String> readSynonymFile(String filename) {


        Scanner scanner;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            scanner = new Scanner(new FileInputStream(filename), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return lines;
    }

    public static ArrayList<WordSynonyms> parseLines(ArrayList<String> lines) {
        ArrayList<WordSynonyms> synList = new ArrayList<WordSynonyms>();
        for (int i = 0; i < lines.size() - 8; i += 8) {
            String wordLine = lines.get(i + 2);
            String synLine = lines.get(i + 4).substring(lines.get(i + 4).indexOf(" "), lines.get(i + 4).length() - 1);
            String word = wordLine.substring(wordLine.indexOf(" ") + 1, wordLine.length() - 1);

            WordSynonyms temp = new WordSynonyms(word);
            String[] wordList = synLine.split(",");

            for (String synonym : wordList) {
                if (!synonym.contains("{")) {
                    temp.addSynonym(synonym.trim().toLowerCase());
                }
            }
            synList.add(temp);
        }
        return synList;
    }

    public void generateSynList(String filename) {
        parseLines(readSynonymFile(filename));
    }
}

