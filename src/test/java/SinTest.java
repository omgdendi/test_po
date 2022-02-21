
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinTest {

    private Sin sin;

    @Before
    public void sinInit() {
        sin = new Sin();
    }



    @Test
    public void testGetSeriesWithPi() {
        double x = Math.PI/2;
        double e = 0.001;
        assertEquals(1, sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesSimple() {
        double x = 0.5;
        double e = 0.1;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesWithNegativeNumber() {
        double x = -1.5;
        double e = 0.0001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesWithSmallAccuracy() {
        double x = 3;
        double e = 0.0000001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test(expected = OverflowException.class)
    public void testGetSeriesWithVerySmallAccuracy() {
        double x = 3;
        double e = 0.0000000000001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test(expected = OverflowException.class)
    public void testGetSeriesWithBigNumber() {
        double x = 100;
        double e = 0.01;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }


}