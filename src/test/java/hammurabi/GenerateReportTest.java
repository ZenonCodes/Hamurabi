package hammurabi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateReportTest {

    @Test
    void getReport() {
        // Given
        GenerateReport testReport = new GenerateReport();
        Hammurabi testGame = new Hammurabi();

        // When
        String printReport = testReport.getReport(testGame);

        // Then
        System.out.println(printReport);
    }
}