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
    public void testBubbleSortWithDataFromUsfca() {
        float[] arr = {20, 96, 1, 54, 97, 61, 18, 64, 13, 27, 90,
                68, 9, 97, 55, 69, 16, 70, 52, 22, 27, 9, 79, 71,
                47, 41, 11, 4, 64, 58, 11, 8, 20, 28, 2, 41, 17,
                67, 68, 7, 86, 77, 99, 62, 59, 61, 9, 63, 82, 53};
        float[] sortArr = {1, 2, 4, 7, 8, 9, 9, 9, 11, 11, 13, 16,
                17, 18, 20, 20, 22, 27, 27, 28, 41, 41, 47, 52, 53,
                54, 55, 58, 59, 61, 61, 62, 63, 64, 64, 67, 68, 68,
                69, 70, 71, 77, 79, 82, 86, 90, 96, 97, 97, 99};
        assertArrayEquals(sortArr, bubbleSortExample.bubbleSort(arr), 0);
    }

    @Test
    public void testBubbleSortWithIntNumbers() {
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
    public void testBubbleSortWithNullData() {
        float[] arr = {};
        float[] sortArr = {};
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
