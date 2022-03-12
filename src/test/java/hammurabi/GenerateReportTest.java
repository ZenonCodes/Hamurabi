package hammurabi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateReportTest {

    @Test
    void getReport() {
        // Given
        GenerateReport testReport = new GenerateReport();

        // When
        String printReport = testReport.getReport();

        // Then
        System.out.println(printReport);
    }
}