public class Time
{
    public static double[] insertionTimes = new double[10];
    public static double[] countingTimes = new double[10];
    public static double[] pigeonholeTimes = new double[10];
    public static double[] mergeTimes = new double[10];

    public static double[] sortedInsertionTimes = new double[10];
    public static double[] sortedCountingTimes = new double[10];
    public static double[] sortedPigeonholeTimes = new double[10];
    public static double[] sortedMergeTimes = new double[10];

    public static double[] reverseInsertionTimes = new double[10];
    public static double[] reverseCountingTimes = new double[10];
    public static double[] reversePigeonholeTimes = new double[10];
    public static double[] reverseMergeTimes = new double[10];

    public static void calculateRandomTime(int[] originalArray, int[] inputData)
    {
        int[] temp1 = new int[10];
        int[] temp2 = new int[10];
        int[] temp3 = new int[10];
        int[] temp4 = new int[10];

        for(int i = 0; i < inputData.length; i++)
        {
            int[] iArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, iArr, 0, inputData[i]);
            SortingAlgorithm ia = new SortingAlgorithm(iArr);

            for(int j = 0; j < 10; j++)
            {
                int ipt;
                long startTime = System.nanoTime();
                ia.insertionSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e7);
                temp1[j] = ipt;
                System.arraycopy(originalArray, 0, ia.arr, 0, inputData[i]);
            }
            int iMean = calculateAverageTime(temp1);
            insertionTimes[i] = iMean;

            int[] cArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, cArr, 0, inputData[i]);
            SortingAlgorithm ca = new SortingAlgorithm(cArr);

            for(int j = 0; j < 10; j++)
            {
                int ipt;
                long startTime = System.nanoTime();
                ca.countingSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp2[j] = ipt;
                System.arraycopy(originalArray, 0, ca.arr, 0, inputData[i]);
            }
            int cMean = calculateAverageTime(temp2);
            countingTimes[i] = cMean;

            int[] pArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, pArr, 0, inputData[i]);
            SortingAlgorithm pa = new SortingAlgorithm(pArr);

            for(int j = 0; j < 10; j++)
            {
                int ipt;
                long startTime = System.nanoTime();
                pa.pigeonholeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp3[j] = ipt;
                System.arraycopy(originalArray, 0, pa.arr, 0, inputData[i]);
            }
            int pMean = calculateAverageTime(temp3);
            pigeonholeTimes[i] = pMean;

            int[] mArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, mArr, 0, inputData[i]);
            SortingAlgorithm ma = new SortingAlgorithm(mArr);

            for(int j = 0; j < 10; j ++)
            {
                int ipt;
                long startTime = System.nanoTime();
                ma.callMergeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp4[j] = ipt;
                System.arraycopy(originalArray, 0, ma.arr, 0, inputData[i]);
            }
            int mMean = calculateAverageTime(temp4);
            mergeTimes[i] = mMean;
        }
    }


    public static void calculateSortedTime(int[] originalArray, int[] inputData)
    {
        int[] temp1 = new int[10];
        int[] temp2 = new int[10];
        int[] temp3 = new int[10];
        int[] temp4 = new int[10];

        for(int i = 0; i < inputData.length; i++)
        {
            int[] iArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, iArr, 0, inputData[i]);
            SortingAlgorithm ia = new SortingAlgorithm(iArr);

            for(int j = 0; j < 10; j++)
            {
                ia.callMergeSort();
                int ipt;
                long startTime = System.nanoTime();
                ia.insertionSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e5);
                temp1[j] = ipt;
            }
            int iMean = calculateAverageTime(temp1);
            sortedInsertionTimes[i] = iMean;

            int[] cArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, cArr, 0, inputData[i]);
            SortingAlgorithm ca = new SortingAlgorithm(cArr);

            for(int j = 0; j < 10; j++)
            {
                ca.callMergeSort();
                int ipt;
                long startTime = System.nanoTime();
                ca.countingSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp2[j] = ipt;
            }
            int cMean = calculateAverageTime(temp2);
            sortedCountingTimes[i] = cMean;

            int[] pArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, pArr, 0, inputData[i]);
            SortingAlgorithm pa = new SortingAlgorithm(pArr);

            for(int j = 0; j < 10; j++)
            {
                pa.callMergeSort();
                int ipt;
                long startTime = System.nanoTime();
                pa.pigeonholeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp3[j] = ipt;
            }
            int pMean = calculateAverageTime(temp3);
            sortedPigeonholeTimes[i] = pMean;

            int[] mArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, mArr, 0, inputData[i]);
            SortingAlgorithm ma = new SortingAlgorithm(mArr);

            for(int j = 0; j < 10; j ++)
            {
                ma.callMergeSort();
                int ipt;
                long startTime = System.nanoTime();
                ma.callMergeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp4[j] = ipt;
            }
            int mMean = calculateAverageTime(temp4);
            sortedMergeTimes[i] = mMean;
        }
    }


    public static void calculateReverseTime(int[] originalArray, int[] inputData)
    {
        int[] temp1 = new int[10];
        int[] temp2 = new int[10];
        int[] temp3 = new int[10];
        int[] temp4 = new int[10];

        for(int i = 0; i < inputData.length; i++)
        {
            int[] iArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, iArr, 0, inputData[i]);
            SortingAlgorithm ia = new SortingAlgorithm(iArr);

            for(int j = 0; j < 10; j++)
            {
                ia.reverse();
                int ipt;
                long startTime = System.nanoTime();
                ia.insertionSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e7);
                temp1[j] = ipt;
            }
            int iMean = calculateAverageTime(temp1);
            reverseInsertionTimes[i] = iMean;

            int[] cArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, cArr, 0, inputData[i]);
            SortingAlgorithm ca = new SortingAlgorithm(cArr);

            for(int j = 0; j < 10; j++)
            {
                ca.reverse();
                int ipt;
                long startTime = System.nanoTime();
                ca.countingSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp2[j] = ipt;
            }
            int cMean = calculateAverageTime(temp2);
            reverseCountingTimes[i] = cMean;

            int[] pArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, pArr, 0, inputData[i]);
            SortingAlgorithm pa = new SortingAlgorithm(pArr);

            for(int j = 0; j < 10; j++)
            {
                pa.reverse();
                int ipt;
                long startTime = System.nanoTime();
                pa.pigeonholeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp3[j] = ipt;
            }
            int pMean = calculateAverageTime(temp3);
            reversePigeonholeTimes[i] = pMean;

            int[] mArr = new int[inputData[i]];
            System.arraycopy(originalArray, 0, mArr, 0, inputData[i]);
            SortingAlgorithm ma = new SortingAlgorithm(mArr);

            for(int j = 0; j < 10; j ++)
            {
                ma.reverse();
                int ipt;
                long startTime = System.nanoTime();
                ma.callMergeSort();
                long stopTime = System.nanoTime();
                ipt = (int) ((stopTime - startTime) / 1e6);
                temp4[j] = ipt;

            }
            int mMean = calculateAverageTime(temp4);
            reverseMergeTimes[i] = mMean;
        }
    }


    private static int calculateAverageTime(int[] times)
    {
        int sum = 0;

        for(int i = 0; i < times.length; i++)
        {
            sum += times[i];
        }

        int mean = sum / 10;

        return mean;
    }
}
