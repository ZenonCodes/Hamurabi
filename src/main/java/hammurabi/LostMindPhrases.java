package hammurabi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LostMindPhrases{
    File phrasesFile = new File ("src/main/java/hammurabi/LostMindPhrases.txt");
    String endPhrase = "...please pick a more reasonable answer.";
    String[] phrases = new String[4];
    Random pickPhrase = new Random();
    int j = 0;

    public String setPhrase() throws IOException {
        if(phrases.length == 4){
            return phrases[pickPhrase.nextInt(0,4)] + endPhrase;
        }
        try {
            Scanner phrasesGrab = new Scanner(phrasesFile);
            while (phrasesGrab.hasNextLine()){
                for(String currPhrase: phrases){
                    if (j == 4) break;
                    phrases[j++] = phrasesGrab.nextLine();
                }
            }
            phrasesGrab.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (phrases.length < 4){
            return "Hammurabi, that doesn't sound right" + endPhrase;
        }
        return phrases[pickPhrase.nextInt(0,4)] + endPhrase;
    }

}
