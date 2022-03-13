package hammurabi;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Random rand = new Random();
    Scanner speech = new Scanner(System.in);
    LostMindPhrases getPhrase = new LostMindPhrases();
//  GenerateReport report = new GenerateReport();

    private int storedBushels = 2800;
    private int population = 100;
    private int prevPopulation = 95;
    private int starvedPopulation, newImmigrants, totalImmigrants,impossibleAnswers, plagueDeaths = 0;
    private int ownedAcres = 1000;
    private int landPrice = 19;
    private int harvestedCrops = 3000;
    private int seedYield = 3;
    private int ravagedGrain = 200;
    private int reignDuration = 1;
    boolean revolt, plague, boughtLand = false;






    private int bushelsFedToPeople = rand.nextInt((int)((20*population) *.55), 20*population);
    private int acresToBuy = rand.nextInt(0, storedBushels/landPrice + 500);
    private int acresToSell = rand.nextInt(0, ownedAcres + 120);
    private boolean castPlague = rand.nextInt(100) < 15;


//
//    int getNumber(String message) {
//        while (true) {
//            System.out.print(message);
//            try {
//                return speech.nextInt();
//            }
//            catch (InputMismatchException e) {
//                System.out.println("\"" + speech.next() + "\" isn't a number!");
//            }
//        }
//    }



    public int askHowManyAcresToBuy(int landPrice, int storedBushels){
        int requestedAcres = acresToBuy;
        while (requestedAcres > storedBushels/landPrice && (impossibleAnswers < 10)) {
            tryCatchBody();
        }
        if (requestedAcres != 0) {
            boughtLand = true;
            return 0;
        }
        ownedAcres += requestedAcres;

    return requestedAcres;
    }
    public int askHowManyAcresToSell(int acresOwned){

        int soldAcres = acresToSell;
        if (boughtLand) {
           return 0;
        }
        //noinspection DuplicatedCode
        while (acresToSell > acresOwned && (impossibleAnswers < 10)) {
            tryCatchBody();
        }
        ownedAcres -= soldAcres;
        return soldAcres;
    }
       public int askHowMuchGrainToFeedPeople(int bushels) {
           while (bushelsFedToPeople > storedBushels && (impossibleAnswers < 10)) {
               tryCatchBody();
           }
           storedBushels -= bushelsFedToPeople;

           return bushelsFedToPeople;
    }

    public int plagueDeaths (int population){
        int prePlaguePopulation = population;
        if(castPlague){
            plagueDeaths = (int) (this.population * .5);
        }
        return plagueDeaths;
    }
    public int starvationDeaths (int population, int bushelsFedToPeople){
        int starvationDeaths = (population * 20) % bushelsFedToPeople;
        int fedPopulation = bushelsFedToPeople/20;
        // if you have a population of 10 people you need 200 bushels
        // if bushels fed to people < 20 * population -> 20 * 10 = 200 % bushelsFed(60) / 20 60 - 3 people
        // population = bushelsFed/ 20
        starvedPopulation = population - fedPopulation;
        this.population -= starvedPopulation;
        return starvedPopulation;
    }
    public boolean uprising ( int population, int starvedPopulation){
        return false;
    }

    public int immigrants( int population, int ownedAcres, int storedBushels){
        return 0;
    }
    public int harvest( int acres){
        return 0;
    }
    public int grainEatenByRats(int storedBushels){
        int bushels = storedBushels;
        return 0;
    }
    public void endDay(){
        boughtLand = false;
        bushelsFedToPeople = acresToSell = acresToBuy = impossibleAnswers = 0;
        reignDuration++;
    }


    public int getStoredBushels() {
        return storedBushels;
    }

    public void setStoredBushels(int storedBushels) {
        this.storedBushels = storedBushels;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPrevPopulation() {
        return prevPopulation;
    }

    public void setPrevPopulation(int prevPopulation) {
        this.prevPopulation = prevPopulation;
    }

    public int getTotalImmigrants() {
        return totalImmigrants;
    }

    public void setTotalImmigrants(int totalImmigrants) {
        this.totalImmigrants = totalImmigrants;
    }

    public int getNewImmigrants() {
        return newImmigrants;
    }

    public void setNewImmigrants(int newImmigrants) {
        this.newImmigrants = newImmigrants;
    }

    public int getOwnedAcres() {
        return ownedAcres;
    }

    public void setOwnedAcres(int ownedAcres) {
        this.ownedAcres = ownedAcres;
    }

    public int getLandPrice() {
        return landPrice;
    }

    public void setLandPrice(int landPrice) {
        this.landPrice = landPrice;
    }

    public int getHarvestedCrops() {
        return harvestedCrops;
    }

    public void setHarvestedCrops(int harvestedCrops) {
        this.harvestedCrops = harvestedCrops;
    }

    public int getSeedYield() {
        return seedYield;
    }

    public void setSeedYield(int seedYield) {
        this.seedYield = seedYield;
    }

    public int getStarvedPopulation() {
        return starvedPopulation;
    }

    public void setStarvedPopulation(int starvedPopulation) {
        this.starvedPopulation = starvedPopulation;
    }

    public int getBushelsFedToPeople() {
        return bushelsFedToPeople;
    }

    public void setBushelsFedToPeople(int bushelsFedToPeople) {
        this.bushelsFedToPeople = bushelsFedToPeople;
    }

    public int getRavagedGrain() {
        return ravagedGrain;
    }

    public void setRavagedGrain(int ravagedGrain) {
        this.ravagedGrain = ravagedGrain;
    }

    public int getReignDuration() {
        return reignDuration;
    }

    public void setReignDuration(int reignDuration) {
        this.reignDuration = reignDuration;
    }
    public void setUprising(boolean revolt) {
        this.revolt = revolt;
    }
    public boolean getUprising() {
        return revolt;
    }

    public int getImpossibleAnswers() {
        return impossibleAnswers;
    }

    public void setImpossibleAnswers(int impossibleAnswers) {
        this.impossibleAnswers = impossibleAnswers;
    }

    public int getAcresToBuy() {
        return acresToBuy;
    }

    public void setAcresToBuy(int acresToBuy) {
        this.acresToBuy = acresToBuy;
    }

    public int getAcresToSell() {
        return acresToSell;
    }

    public void setAcresToSell(int acresToSell) {
        this.acresToSell = acresToSell;
    }

    public int getPlagueDeaths() {
        return plagueDeaths;
    }

    public void setPlagueDeaths(int plagueDeaths) {
        this.plagueDeaths = plagueDeaths;
    }

    public void tryCatchBody(){
        try {
            System.out.println(getPhrase.setPhrase());
        } catch (IOException e) {
            e.printStackTrace();
        }
        impossibleAnswers++;
    }
}
