package hammurabi;

import hammurabi.test.GameTestVersion;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void askHowManyAcresToBuyAddsCorrectAcres() {
        // Given
        GameTestVersion buy = new GameTestVersion();
        int oldAcreage = buy.getOwnedAcres();
        int addedAcreage = buy.askHowManyAcresToBuy(buy.getLandPrice(), buy.getStoredBushels());
        // When
        int actual = buy.getOwnedAcres();
        int expected = addedAcreage + oldAcreage;
        System.out.println("Old Acreage: " + oldAcreage + "\nAdded Acreage: " + addedAcreage + "\nNew Acreage " + actual + "\n\n\tENDTEST\n");

        // Then
        Assert.assertEquals(actual,expected);


    }

    @Test
    void askHowManyAcresToSellSubtractsCorrectAcres() {
        // Given
        GameTestVersion sell = new GameTestVersion();
        int oldAcreage = sell.getOwnedAcres();
        int soldAcreage = sell.askHowManyAcresToSell(oldAcreage);
        // When
        int actual = sell.getOwnedAcres();
        int expected = oldAcreage - soldAcreage;
        System.out.println("Old Acreage: " + oldAcreage + "\nSold Acreage: " + soldAcreage + "\nNew Acreage " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);

    }

    @Test
    void askHowMuchGrainToFeedPeopleRemovesGrain() {
        // Given
        GameTestVersion feed = new GameTestVersion();
        int oldStorage = feed.getStoredBushels();
        int distributedStorage = feed.askHowMuchGrainToFeedPeople(oldStorage);
        // When
        int actual = feed.getStoredBushels();
        int expected = oldStorage - distributedStorage;
        System.out.println("Old Bushel Reserve: " + oldStorage + "\nDistributed Bushels: " + distributedStorage + "\nNew Bushel Reserve " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }


    @Test
    void plagueDeaths() {
        // Given
        GameTestVersion plague = new GameTestVersion();
        int prePlaguePopulation = plague.getPopulation();
        int chancePlague = plague.plagueDeaths(prePlaguePopulation);
        // When
        int actual = prePlaguePopulation - plague.getPlagueDeaths();
        int expected = prePlaguePopulation - chancePlague;
        System.out.println("Pre-plague population: " + prePlaguePopulation + "\nDeceased citizens " + chancePlague + "\nNew population " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void starvationDeaths() {
        // Given
        GameTestVersion starvedOrFed = new GameTestVersion();
        int yesterdaysPopulation = starvedOrFed.getPopulation();
        int starvedPeople = starvedOrFed.starvationDeaths (starvedOrFed.getPopulation(), starvedOrFed.getBushelsFedToPeople());
        // When
        int actual = yesterdaysPopulation - starvedOrFed.getStarvedPopulation();
        int expected = yesterdaysPopulation - starvedPeople;
        System.out.println("Yesterday's population: " + yesterdaysPopulation + "\nStarved citizens " + starvedPeople
                + "\nNew population " + actual
                + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void uprising() {
        // Given
        GameTestVersion uprising = new GameTestVersion();
        int yesterdaysPopulation = uprising.getPopulation();
        int starvedPeople;

        // When
        starvedPeople = uprising.starvationDeaths (uprising.getPopulation(), uprising.getBushelsFedToPeople());
        boolean actual = uprising.triggerUprising(uprising.getPopulation(), uprising.getStarvedPopulation());
        boolean expected = uprising.getUprising();
        System.out.println("Starved population uprising threshold : " + Math.round(uprising.getPrevPopulation() * .54) + "\nStarved citizens "
                + uprising.getStarvedPopulation() + "\nUprising threshold met? " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void newImmigrantsMathCorrect() {

        // Given
        GameTestVersion immigrants = new GameTestVersion();
        immigrants.immigrants(immigrants.getPopulation(), immigrants.getOwnedAcres(), immigrants.getStoredBushels());
        // When
        int actual = immigrants.getNewImmigrants();
        int expected = (20 * immigrants.getOwnedAcres() + immigrants.getStoredBushels()) / (100*immigrants.getPopulation()) + 1;
        System.out.println("New Immigrants: " + actual + "\nExpected Immigrants: " + expected + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void newImmigrantsZeroForStarvingKingdoms() {

        // Given
        GameTestVersion immigrants = new GameTestVersion();
        immigrants.setStarvedPopulation(100);
        immigrants.immigrants(immigrants.getPopulation(), immigrants.getOwnedAcres(), immigrants.getStoredBushels());
        // When
        int actual = immigrants.getNewImmigrants();
        int expected = 0;
        System.out.println("New Immigrants: " + actual + "\nExpected Immigrants: " + expected
                + "\nStarving Citizens " + immigrants.getStarvedPopulation() + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void askHowManyAcresToPlant (){
        //Given
        GameTestVersion plant = new GameTestVersion();
        int plantedAcres = plant.getAcresToPlant();
        plant.setPopulation(10*plantedAcres);
        plant.setStoredBushels(2*plantedAcres);
        // When
        int actual = plant.askHowManyAcresToPlant(plant.getOwnedAcres(), plant.getPopulation(),plant.getStoredBushels());
        int expected = plant.getAcresToPlant();
        System.out.println("Expected Acres: " + expected  + "\nActual Acres: " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);

    }


    @Test
    void harvestIsLinkedToSeedYield() {
        // Given
        GameTestVersion harvest = new GameTestVersion();
        int harvestYield = harvest.harvest(harvest.getOwnedAcres());
        // When
        int actual = harvestYield;
        int expected = harvest.getAcresToPlant() * harvest.getSeedYield();
        System.out.println("Expected Harvest: " + expected  + "\nActual Harvest: " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    void harvestGetsAddedToStoredBushels() {
        // Given
        GameTestVersion harvest = new GameTestVersion();
        int oldStoredBushels = harvest.getStoredBushels();
        int harvestYield = harvest.harvest(harvest.getOwnedAcres());
        int newStoredBushels = harvestYield + oldStoredBushels;

        // When
        int actual = harvestYield;
        int expected = newStoredBushels - oldStoredBushels;
        System.out.println("\nFormer Bushel Amount: " + oldStoredBushels + "\nExpected crops to be added: " + expected  + "\nActual crops added: " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }



    @Test
    void grainEatenByRats() {
        // Given
        GameTestVersion rats = new GameTestVersion();
        int oldBushels = rats.getStoredBushels();
        // When
        rats.setDeployRats(true);
        int ravagedGrain = rats.grainEatenByRats(oldBushels);
        int postRavagedBushels = rats.getStoredBushels();
        int actual = oldBushels - ravagedGrain;
        int expected = postRavagedBushels;
        System.out.println("Pre-Ravaged Bushels: " + oldBushels  + "\nRavaged Bushels: " + ravagedGrain
                + "\nPost-Ravaged Bushels: " + actual + "\n\n\tENDTEST\n");
        // Then
        Assert.assertEquals(actual,expected);
    }

}