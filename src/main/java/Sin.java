public class Sin {
    private static long getFactorial(int f) {
        long result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
            if (result < 0) {
                throw new OverflowException();
            }
        }
        return result;
    }

    public double getSeries(double x, double e) {
        double seriesSum = 0;
        double preSeriesSum;
        int i = 1;
        do {
            preSeriesSum = seriesSum;
            seriesSum = preSeriesSum + Math.pow(-1, i-1)/getFactorial(2*i - 1)*Math.pow(x, 2*i - 1);
            //System.out.println(i + ") " + seriesSum + " " + getFactorial(2*i - 1));
            i++;
        } while (Math.abs(preSeriesSum - seriesSum) > e);
        //System.out.println();
        return seriesSum;
    }
}
