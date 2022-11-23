import org.example.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTile {
    @Test
    public void testConstructor(){
        Tile myTestTile = new Tile(" B ", " - ");
        Assertions.assertEquals(" B ",myTestTile.GetActual(), "Actual value ' B ' did not pass");
        Assertions.assertEquals(" - ", myTestTile.GetDisplay(), "Boop");
    }
}
