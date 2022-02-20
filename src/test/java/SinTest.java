
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
    public void testPiGetSeriesFirst() {
       double x = Math.PI;
       double e = 0.001;
       assertEquals(0, sin.getSeries(x, e), e);
    }

    @Test
    public void testPiGetSeriesSecond() {
        double x = Math.PI/2;
        double e = 0.001;
        assertEquals(1, sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesFirst() {
        double x = 0.5;
        double e = 0.1;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesSecond() {
        double x = 1;
        double e = 0.01;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesThird() {
        double x = -1.5;
        double e = 0.0001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesFourth() {
        double x = -2;
        double e = 0.00001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test
    public void testGetSeriesFifth() {
        double x = 3;
        double e = 0.0000001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test(expected = OverflowException.class)
    public void testGetSeriesSixth() {
        double x = 3;
        double e = 0.0000000000001;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }

    @Test(expected = OverflowException.class)
    public void testGetSeriesSeventh() {
        double x = 100;
        double e = 0.01;
        assertEquals(Math.sin(x), sin.getSeries(x, e), e);
    }


}