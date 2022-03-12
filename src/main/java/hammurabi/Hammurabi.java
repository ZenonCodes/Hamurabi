package hammurabi;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    int storedBushels = 2800;
    int population = 100;
    int ownedAcres = 1000;
    int landPrice = 19;
    int starvedPopulation = 0;
    int bushelsFedToPeople;
    int ravagedGrain = grainEatenByRats();

    Random rand = new Random();
    Scanner speech = new Scanner(System.in);

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
        askHowManyAcresToBuy();


    }

    int askHowManyAcresToBuy(int landPrice, int storedBushels){

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
