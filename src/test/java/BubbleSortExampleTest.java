import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortExampleTest {

    private BubbleSortExample bubbleSortExample;

    @Before
    public void bubbleSortExampleInit() {
        bubbleSortExample = new BubbleSortExample();
    }

    @Test
    public void testBubbleSortWithIntNumbersFirst() {
        float[] arr = {5, 2, 6, 9, 1, 3, 10};
        float[] sortArr = {1, 2, 3, 5, 6, 9, 10};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithFloatNumbers() {
        float[] arr = {3.2f, 2.5f, 9.8f, 1.5f, 20, 13.24f, 10.1f};
        float[] sortArr = {1.5f, 2.5f, 3.2f, 9.8f, 10.1f, 13.24f, 20};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithSmallData() {
        float[] arr = {1};
        float[] sortArr = {1};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithSameData() {
        float[] arr = {2, 2, 1, 2, 1, 1, 2};
        float[] sortArr = {1, 1, 1, 2, 2, 2, 2};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithNegativeNumbers() {
        float[] arr = {-2, 0, -45, 12, -6, 7};
        float[] sortArr = {-45, -6, -2, 0, 7, 12};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithNegativeAndFloatNumbers() {
        float[] arr = {-2.5f, 0, -100.23f, 12.4f, -5, 8};
        float[] sortArr = {-100.23f, -5, -2.5f, 0, 8, 12.4f};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithBigNumbers() {
        float[] arr = {50000, 234040, 1002, -80000000, -50000};
        float[] sortArr = {-80000000,-50000, 1002, 50000, 234040};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }
}
