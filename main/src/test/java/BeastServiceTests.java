import beans.Beast;
import org.junit.jupiter.api.Test;
import services.BeastService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BeastServiceTests {
    @Test
    public void testBeastService() throws IOException {
        BeastService beastService = new BeastService();
        List<Beast> beasts = beastService.getAllBeasts();
        assertNotNull(beasts);
        assertTrue(beasts.size() > 0);
        assertEquals(new File("src/main/resources/beasts").listFiles().length, beasts.size());
    }
}
