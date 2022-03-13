package hammurabi;

import java.util.Random;
import java.util.Scanner;

public class PlayHammurabi {
    static Hammurabi newGame = new Hammurabi();
    static PlayHammurabi start = new PlayHammurabi();
    static GenerateReport dailyReport = new GenerateReport();


    public static void main(String[] args) {
        start.playGame();

        }

         void playGame() {
             System.out.printf(dailyReport.getReport(newGame));
             while (newGame.getReignDuration() <= 10 && !(newGame.isUprising())) {
                 newGame.askHowManyAcresToBuy();
                 newGame.askHowManyAcresToSell();
                 newGame.askHowMuchGrainToFeedPeople();
                 newGame.askHowManyAcresToPlant();
                 newGame.plagueDeaths();
                 newGame.starvationDeaths();
                 newGame.triggerUprising();
                 newGame.immigrants();
                 newGame.harvest();
                 newGame.grainEatenByRats();
                 newGame.setReignDuration(newGame.getReignDuration()+ 1);
                 System.out.printf(dailyReport.getReport(newGame));
                 newGame.endDay();

             }
             System.out.printf( '\n' + "Thus, concludes your reign!");
         }
}



