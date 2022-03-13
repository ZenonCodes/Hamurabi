package hammurabi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void askHowManyAcresToBuyAddsCorrectAcres() {
        // Given
        Game buy = new Game();
        int oldAcreage = buy.getOwnedAcres();
        int addedAcreage = buy.askHowManyAcresToBuy(buy.getLandPrice(), buy.getStoredBushels());
        // When
        int actual = buy.getOwnedAcres();
        int expected = addedAcreage + oldAcreage;
        System.out.println("Old Acreage: " + oldAcreage + "\nAdded Acreage: " + addedAcreage + "\nNew Acreage " + actual);

        // Then
        Assert.assertEquals(actual,expected);


    }

    @Test
    void askHowManyAcresToSellSubtractsCorrectAcres() {
        // Given
        Game sell = new Game();
        int oldAcreage = sell.getOwnedAcres();
        int soldAcreage = sell.askHowManyAcresToSell(oldAcreage);
        // When
        int actual = sell.getOwnedAcres();
        int expected = oldAcreage - soldAcreage;
        System.out.println("Old Acreage: " + oldAcreage + "\nSold Acreage: " + soldAcreage + "\nNew Acreage " + actual);
        // Then
        Assert.assertEquals(actual,expected);

    }

    @Test
    void askHowMuchGrainToFeedPeopleRemovesGrain() {
        // Given
        Game feed = new Game();
        int oldStorage = feed.getStoredBushels();
        int distributedStorage = feed.askHowMuchGrainToFeedPeople(oldStorage);
        // When
        int actual = feed.getStoredBushels();
        int expected = oldStorage - distributedStorage;
        System.out.println("Old Bushel Reserve: " + oldStorage + "\nDistributed Bushels: " + distributedStorage + "\nNew Bushel Reserve " + actual);
        // Then
        Assert.assertEquals(actual,expected);
    }


    @Test
    void plagueDeaths() {
        // Given
        Game plague = new Game();
        int prePlaguePopulation = plague.getPopulation();
        int chancePlague = plague.plagueDeaths(prePlaguePopulation);
        // When
        int actual = prePlaguePopulation - plague.getPlagueDeaths();
        int expected = prePlaguePopulation - chancePlague;
        System.out.println("Pre-plague population: " + prePlaguePopulation + "\nDeceased citizens " + chancePlague + "\nNew population " + actual);
        // Then
        System.out.println(actual + " " + expected);
        Assert.assertEquals(actual,expected);
    }

    @Test
    void starvationDeaths() {
        // Given
        Game starvedOrFed = new Game();
        int yesterdaysPopulation = starvedOrFed.getPopulation();
        int starvedPeople = starvedOrFed.starvationDeaths (starvedOrFed.getPopulation(), starvedOrFed.getBushelsFedToPeople());
        // When
        int actual = yesterdaysPopulation - starvedOrFed.getStarvedPopulation();
        int expected = yesterdaysPopulation - starvedPeople;
        System.out.println("Yesterday's population: " + yesterdaysPopulation + "\nStarved citizens " + starvedPeople + "\nNew population " + actual);
        // Then
        System.out.println(actual + " " + expected);
        Assert.assertEquals(actual,expected);
    }

    @Test
    void uprising() {
    }

    @Test
    void immigrants() {
    }

    @Test
    void harvest() {
    }

    @Test
    void grainEatenByRats() {
    }

    @Test
    void endDay() {
    }

}