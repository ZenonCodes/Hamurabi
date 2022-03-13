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
             while (newGame.getReignDuration() <= 10) {
                 System.out.printf(dailyReport.getReport(newGame));
                 System.out.println(newGame.getReignDuration());
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
                 newGame.endDay();

             }
             System.out.printf(dailyReport.getReport(newGame) + '\n' + "Thus, concludes your reign!");
         }
}



