package Tests;
import Pages.OpenGetTitle;
import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenGetTitleTest extends TestBase {

    @Test
    void openAndGetTitle(){
        OpenGetTitle haTitle= new OpenGetTitle(page);
        haTitle.openAndGetTitle();
        assertEquals(haTitle.getTitle(), page.title());
    }
}
