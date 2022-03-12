package hammurabi;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner speech = new Scanner(System.in);
    int storedBushels = 2800;
    int population = 100;
    int prevPopulation = 95;
    int totalImmigrants = 0;
    int newImmigrants = 0;
    int ownedAcres = 1000;
    int landPrice = 19;
    int harvest = 3000;
    int seedYield = 3;
    int starvedPopulation = 0;
    int bushelsFedToPeople = rand.nextInt((int)((20*population) *.55), 20*population);
    int ravagedGrain = 200;
    int reignDuration = 1;
    String salutationIntro = "O great Hammurabi!";
    String landReport = "The city owns " + ownedAcres + " acres of land";
    String harvestReport =  "We harvested " + harvest + "bushels at " + seedYield + "/acre.\n";
    String ravageReport = "Rats destroyed" + ravagedGrain + "bushels leaving 2800 bushels in storage.\n";
    String populationReport = "The population is now " + population + ".";
    String landPriceReport = "Land is currently worth " +  landPrice + " bushels/acre.";

    public static void main(String[] args) {
//        new Hammurabi().playGame();
    }

    void playGame() {
        /**
         * O great Hammurabi!
         * You are in year 1 of your ten year rule.
         * In the previous year 0 people starved to death.
         * In the previous year 5 people entered the kingdom.
         * The population is now 100.
         * We harvested 3000 bushels at 3 bushels per acre.
         * Rats destroyed 200 bushels, leaving 2800 bushels in storage.
         * The city owns 1000 acres of land.
         * Land is currently worth 19 bushels per acre.
         * */



    }

    int askHowManyAcresToBuy(int landPrice, int storedBushels){
return 0;
    }
    public int plagueDeaths(int population){
        return 0;
    }
    public int starvationDeaths(int population, int bushelsFedToPeople){
        return 0;
    }
    public boolean uprising(int population, int starvedPopulation){
        return false;
    }

    public int immigrants(int population, int ownedAcres, int storedBushels){
        return 0;
    }
    public int harvest(int acres){
        return 0;
    }
    public int grainEatenByRats(){
        int bushels = storedBushels;
        return 0;
    }

}
