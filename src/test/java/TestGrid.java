import org.example.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGrid {
    @Test
    public void testConstructor(){
        Grid myTestGrid = new Grid(10, 10);
        Assertions.assertEquals(false, myTestGrid.isInteger("5.0"), "5.0 not pass IsInteger()");
        Assertions.assertEquals(false, myTestGrid.isInteger("tee"), "tee not pass IsInteger()");
        Assertions.assertEquals(true, myTestGrid.isInteger("023"), "023 not pass IsInteger()");
        Assertions.assertEquals(true, myTestGrid.isInteger("15"), "15 not pass IsInteger()");
    }
}
