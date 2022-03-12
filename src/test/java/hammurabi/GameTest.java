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
        Game sell = new Game();
        int oldStorage = sell.getStoredBushels();
        int distributedStorage = sell.askHowMuchGrainToFeedPeople(oldStorage);
        // When
        int actual = sell.getStoredBushels();
        int expected = oldStorage - distributedStorage;
        System.out.println("Old Bushel Reserve: " + oldStorage + "\nDistributed Bushels: " + distributedStorage + "\nNew Bushel Reserve " + actual);
        // Then
        Assert.assertEquals(actual,expected);
    }


    @Test
    void plagueDeaths() {
    }

    @Test
    void starvationDeaths() {
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