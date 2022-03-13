package hammurabi;

public class GenerateReport {

    public String getReport(Hammurabi game){

        String salutationIntro = "\nO Hammurabi!\n";
        String landReport = "The city owns " + game.getOwnedAcres() + " acres of land\n";
        String harvestReport =  "We harvested " + game.getHarvestedCrops() + " bushels at " + game.getSeedYield() + " bushels/acre.\n";
        String ravageReport = "Rats destroyed " + game.getRavagedGrain() + " bushels leaving "+ game.getStoredBushels() + " in storage.\n";
        String populationReport = "You now reign over " + game.getPopulation() + " citizens.\n";
        String landPriceReport = "Land is currently worth " +  game.getLandPrice() + " bushels/acre.\n";
        String plagueReport = "";
        String soldLandRev = "";
        String uprisingReport = "I report to you no longer! Guards, escort him to the lion's den!\n *Yells of uprising echo off the kingdom walls* \n";
        int profit = game.getAcresSold() * game.getLandPrice();
        String report = salutationIntro + landReport + harvestReport +
                ravageReport + populationReport + landPriceReport + plagueReport + "\n";

        if ((game.getPopulation() > 150) && (game.getStarvedPopulation() < (.15 * game.getPrevPopulation()))) {
            salutationIntro = "O great Hammurabi, benevolent ruler of many!\n";
            populationReport = "You now oversee " + game.getPopulation() + " faithful citizens.\n";
        }
        if (game.getOwnedAcres() > 1200){
            landReport = "Your kingdom stretches far and wide totaling " + game.getOwnedAcres() + " acres of land\n";
        }
        if (game.getHarvestedCrops() >= 1000 && game.getSeedYield() > 1) {
            harvestReport = "Our" + game.getHarvestedCrops() + "bushel harvest was bountiful at " + +
                    game.getSeedYield() + "/acre.\n";
        }
        if (game.getRavagedGrain() >= 0) {
            ravageReport = "Rats destroyed " + game.getRavagedGrain() + " bushels leaving " +
                    game.getStoredBushels() + " in storage.\n";
        }

        if (game.getLandPrice() > 20) {
            landPriceReport = "Land is currently worth " + game.getLandPrice() + " bushels/acre.\n";
        }
        if(game.isCastPlague()){
            plagueReport = "A plague unlike any before or after has swept through your kingdom. \n " +
                    "All around Sumer, weeping is heard.";
        }

        if(game.isUprising()){
            return uprisingReport;
        }

        return report;
    }

}

