package hammurabi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner speech = new Scanner(System.in);
    LostMindPhrases getPhrase = new LostMindPhrases();

    private int storedBushels = 2800;
    private int population = 100;
    private int prevPopulation = 95;
    private int starvedPopulation, newImmigrants, totalImmigrants, plagueDeaths = 0;
    private int ownedAcres = 1000;
    private int landPrice = 19;
    private int harvestedCrops = 3000;
    private int seedYield = 3;
    private int ravagedGrain = 200;
    private int reignDuration = 1;
    boolean uprising, boughtLand = false;
    private int acresSold, acresBought, bushelsFedToPeople,acresPlanted = 0;

    private boolean castPlague = false;
    private boolean deployRats = false;

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return speech.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + speech.next() + "\" isn't a number!");
            }
        }
    }


    public void setLandPrice(){
        landPrice = rand.nextInt(23 - 17 + 1) + 17;

    }

    public void askHowManyAcresToBuy(){
        int requestedAcres = getNumber("Honorable Hammurabi, how many acres of land would you like to buy?\n");
        while (requestedAcres > storedBushels/landPrice) {
            tryCatchBody();
            requestedAcres = getNumber("Honorable Hammurabi, how many acres of land would you like to buy?\n");
        }

            boughtLand = (requestedAcres > 0);

        acresBought = requestedAcres;
        ownedAcres += requestedAcres;
    }

    public void askHowManyAcresToSell(){
        if (!boughtLand) {
            int soldAcres = getNumber("Honorable Hammurabi, how many acres of land would you like to sell?\n");
            while (soldAcres > ownedAcres) {
                tryCatchBody();
                soldAcres = getNumber("Honorable Hammurabi, how many acres of land would you like to sell?\n");
            }
            acresSold = soldAcres;
            storedBushels += acresSold * landPrice;
            ownedAcres -= soldAcres;
        }
    }
    public void askHowMuchGrainToFeedPeople() {
        int fedBushels = getNumber("Honorable Hammurabi, how many bushels of grain would you like to feed your people?\n");
        while (fedBushels > storedBushels) {
            tryCatchBody();
            fedBushels = getNumber("Honorable Hammurabi, how many bushels of grain would you like to feed your people?\n");
        }
        storedBushels -= fedBushels;
        bushelsFedToPeople = fedBushels;

    }

    public void askHowManyAcresToPlant() {
        int acresRequested = getNumber("Honorable Hammurabi, how many acres of land would you like to plant?\n");
        while (acresRequested > ownedAcres
                || acresRequested > (population * 10)
                || acresRequested > storedBushels/2)
        {
            tryCatchBody();
            acresRequested = getNumber("Honorable Hammurabi, how many acres of land would you like to plant?\n");
        }

        acresPlanted = acresRequested;
    }

    public void plagueDeaths (){
        prevPopulation = population;
        castPlague = rand.nextInt(100) < 15;
        if(castPlague){
            plagueDeaths = (int) (this.population * .5);
        }
        population -= plagueDeaths;
    }

    public void starvationDeaths (){
        int fedPopulation = bushelsFedToPeople/20;
        starvedPopulation = population - fedPopulation;
        population = fedPopulation;
    }

    public void triggerUprising(){
        uprising = (starvedPopulation > .45 * prevPopulation);



    }

    public void immigrants(){
        if (starvedPopulation > 0){
            newImmigrants = 0;
        } else {
            newImmigrants = (20 * (ownedAcres + storedBushels)) / (100 * population) + 1;
            population += newImmigrants;
            totalImmigrants += newImmigrants;
        }
    }

    public void harvest(){
        seedYield = rand.nextInt(1,7);
        harvestedCrops = seedYield * acresPlanted;
        storedBushels += harvestedCrops;
    }
    public void grainEatenByRats(){
        deployRats = rand.nextInt(100) < 40;
        if(deployRats) {
            ravagedGrain = rand.nextInt((int) (.10 * storedBushels), (int) (.30 * storedBushels));
            this.storedBushels -= ravagedGrain;
        }
    }
    public void endDay(){
        setLandPrice();
        acresSold = acresBought = ravagedGrain = newImmigrants = bushelsFedToPeople = 0;
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

    public int getAcresBought() {
        return acresBought;
    }

    public void setAcresBought(int acresBought) {
        this.acresBought = acresBought;
    }

    public int getAcresSold() {
        return acresSold;
    }

    public void setAcresSold(int acresSold) {
        this.acresSold = acresSold;
    }

    public int getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public int getPlagueDeaths() {
        return plagueDeaths;
    }


    public void setPlagueDeaths(int plagueDeaths) {
        this.plagueDeaths = plagueDeaths;
    }

    public boolean isCastPlague() {
        return castPlague;
    }

    public void setCastPlague(boolean castPlague) {
        this.castPlague = castPlague;
    }

    public boolean isUprising() {
        return uprising;
    }

    public boolean isDeployRats() {
        return deployRats;
    }

    public void setDeployRats(boolean deployRats) {
        this.deployRats = deployRats;
    }


    public void tryCatchBody(){
        try {
            System.out.println(getPhrase.setPhrase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


