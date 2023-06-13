import beans.Processor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Hit;

import java.sql.SQLException;

public class HitTest {

    @Test
    @DisplayName("Should return \"Hit\" on valid data to hit")
    void testHitOnCorrectData() {
        Processor processor = null;
        try {
            processor = new Processor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Hit hit = new Hit(2, 1, 3);
        processor.setHit(hit);

        try {
            processor.addHit();
            Assertions.assertEquals("Hit", hit.getHit());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Should return \"Miss\" on invalid data to hit")
    void testHitOnIncorrectData() {
        Processor processor = null;
        try {
            processor = new Processor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Hit hit = new Hit(30, 1, 3);
        processor.setHit(hit);

        try {
            processor.addHit();
            Assertions.assertEquals("Miss", hit.getHit());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Should return \"Hit\" on data hit limits")
    void testHitOnCorrectLimitData() {
        Processor processor = null;
        try {
            processor = new Processor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Hit hit = new Hit(0, 2.999999999, 3);
        processor.setHit(hit);

        try {
            processor.addHit();
            Assertions.assertEquals("Hit", hit.getHit());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
