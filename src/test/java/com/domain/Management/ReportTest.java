

import com.domain.Drink;
import com.domain.Report;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportTest {

    private Report report;

    @Before
    public void init (){
        report = new Report();
    }

    @Test
    public void shouldReportNumberOfEachDrinkSoldAndTotalEarn (){
        assertEquals("No drinks Sold",report.print());
        report.addDrink(Drink.TEA);
        assertEquals("sold 1 TEA and earned 0,4 euros",report.print());
        report.addDrink(Drink.TEA);
        report.addDrink(Drink.TEA);
        report.addDrink(Drink.CHOCOLATE);
        assertEquals("sold 3 TEA and 1 CHOCOLATE and earned 1,7 euros",report.print());
    }
}
