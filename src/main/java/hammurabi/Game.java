package hammurabi;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Random rand = new Random();
    Scanner speech = new Scanner(System.in);
    LostMindPhrases getPhrase = new LostMindPhrases();

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
    boolean uprising, plague, boughtLand = false;


    public int getAcresToPlant() {
        return acresToPlant;
    }

    public void setAcresToPlant(int acresToPlant) {
        this.acresToPlant = acresToPlant;
    }

    private int bushelsFedToPeople = rand.nextInt((int)((20*population) *.10), 20*population); //test input
    private int acresToBuy = rand.nextInt(0, storedBushels/landPrice + 500); //test input
    private int acresToSell = rand.nextInt(0, ownedAcres + 120); //test input
    private int acresToPlant = rand.nextInt(0, ownedAcres); //test input
    private boolean castPlague = rand.nextInt(100) < 15;
    private boolean deployRats = rand.nextInt(100) < 40;

    public boolean isDeployRats() {
        return deployRats;
    }

    public void setDeployRats(boolean deployRats) {
        this.deployRats = deployRats;
    }

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

    public int askHowManyAcresToPlant(int ownedAcres, int population, int storedBushels) {
       int acresToPlant = this.acresToPlant;
        while (acresToPlant > ownedAcres
                || acresToPlant > (population * 10)
                || acresToPlant > storedBushels/2
                && (impossibleAnswers < 10))
        {
            tryCatchBody();
            //reprompt
        }


        return acresToPlant;
    }

    public int plagueDeaths (int population){
        prevPopulation = population;
        if(castPlague){
            plagueDeaths = (int) (this.population * .5);
        }
        return plagueDeaths;
    }
    public int starvationDeaths (int population, int bushelsFedToPeople){
//        int starvationDeaths = (population * 20) % bushelsFedToPeople;
        int fedPopulation = bushelsFedToPeople/20;
        starvedPopulation = population - fedPopulation;
        this.population -= starvedPopulation;
        return starvedPopulation;
    }
    public boolean triggerUprising(int population, int starvedPopulation){
        if (starvedPopulation > .55 * prevPopulation) {
            uprising = true;
            return true;
        }
        return false;
    }

    public int immigrants( int population, int ownedAcres, int storedBushels){
        if (starvedPopulation > 0){
            newImmigrants = 0;
            return newImmigrants;
        }
        newImmigrants = (20 * this.ownedAcres + this.storedBushels)/ (100 * population) + 1;
        return newImmigrants;
    }

    public int harvest(int ownedAcres){
        seedYield = rand.nextInt(1,7);
        harvestedCrops = seedYield * acresToPlant;
        storedBushels += harvestedCrops;
        return harvestedCrops;
    }
    public int grainEatenByRats(int storedBushels){
        if(deployRats) {
            ravagedGrain = rand.nextInt((int) (.10 * storedBushels), (int) (.30 * storedBushels));
            this.storedBushels -= ravagedGrain;
            return ravagedGrain;
        }
        return 0;
    }
    public void endDay(){
        castPlague = boughtLand = false;
        totalImmigrants += newImmigrants;
        population += newImmigrants;
        newImmigrants = bushelsFedToPeople = acresToSell = acresToBuy = impossibleAnswers = 0;
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
    public void setUprising(boolean uprising) {
        this.uprising = uprising;
    }
    public boolean getUprising() {
        return uprising;
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
