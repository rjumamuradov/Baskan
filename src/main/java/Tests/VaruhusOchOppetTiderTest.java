package Tests;

import Pages.*;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VaruhusOchOppetTiderTest extends TestBase {
    @Test
    void varuhusOchOppetTider() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        int dayOfWeekAsInt = dayOfWeek.getValue();
        String openHours=(dayOfWeekAsInt<6)? "07-20":"09-18";
        VaruhusOchOppetTider vHusAndOpenTime = new VaruhusOchOppetTider(page);
        vHusAndOpenTime.varuhusAndOppetTider();
        assertThat(vHusAndOpenTime.getHeaderAndTime()).hasText("Öppet idag: "+openHours);

    }
}
