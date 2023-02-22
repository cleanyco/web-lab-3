import beans.Processor;
import utils.DatabaseConnector;
import utils.DatabaseManager;
import utils.Hit;

import java.sql.SQLException;

public class TestClass {

    public static void main(String[] args) throws SQLException {
        Processor  processor = new Processor();
        processor.hit.setX(2);
        processor.hit.setY(1);
        processor.hit.setX(3);
        processor.addHit();
    }
}
