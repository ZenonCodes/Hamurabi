package hammurabi.test;

public class GenerateReportTestVersion extends GameTestVersion {
    String salutationIntro = "O Hammurabi!\n";
    String landReport = "The city owns " + getOwnedAcres() + " acres of land\n";
    String harvestReport =  "We harvested " + getHarvestedCrops() + "bushels at " + getSeedYield() + "/acre.\n";
    String ravageReport = "Rats destroyed " + getRavagedGrain() + " bushels leaving 2800 bushels in storage.\n";
    String populationReport = "You now reign over " + getPopulation() + " citizens.\n";
    String landPriceReport = "Land is currently worth " +  getLandPrice() + " bushels/acre.\n";
    String plagueReport = "";
    String uprisingReport = "I report to you no longer! Guards, escort him to the lion's den!";
    String report = salutationIntro + landReport + harvestReport +
            ravageReport + populationReport + landPriceReport + plagueReport;

    public String getReport(){
        if (getReignDuration() == 1){
            return report;
        } else {
            if ((getPopulation() > 200) && (getStarvedPopulation() < (.15 * getPrevPopulation()))) {
                salutationIntro = "O great Hammurabi, benevolent ruler of many!\n";
                populationReport = "You now oversee " + getPopulation() + " faithful citizens.\n";
            }
            if (getOwnedAcres() > 2000){
                landReport = "Your kingdom stretches far and wide totaling " + getOwnedAcres() + " acres of land\n";
            }
            if (getHarvestedCrops() >= 1000 && getSeedYield() > getSeedYield()) {
                harvestReport = "Our" + getHarvestedCrops() + "bushel harvest was bountiful at " + +
                        getSeedYield() + "/acre.\n";
            }
            ravageReport = "Rats destroyed " + getRavagedGrain() + " bushels leaving 2800 bushels in storage.\n";
            if (getPopulation() > 200) {

            }
            if (getLandPrice() > 20)
                landPriceReport = "Land is currently worth " + getLandPrice() + " bushels/acre.\n";
            if(plague){
                plagueReport = "A plague unlike any before or after has swept through your kingdom. \n " +
                        "All around Sumer, weeping is heard.";
            }
            if(uprising){
                return uprisingReport;
            }

            return report;
        }

    }
}
