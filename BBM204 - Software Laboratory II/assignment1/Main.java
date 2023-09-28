import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};

        double[][] randomYAxis = new double[4][10];
        double[][] sortedYAxis = new double[4][10];
        double[][] reversedYAxis = new double[4][10];

        String csvFile = args[0];
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        List<String[]> content = new ArrayList<>();
        String line = "";

        while((line = br.readLine()) != null)
            content.add(line.split(","));

        List<Integer> arrayList = new ArrayList<>();

        for(int i = 1; i < 251282; i++)
        {
            arrayList.add(Integer.parseInt(content.get(i)[7]));
        }

        int[] originalArr = new int[251282];        // Original array with random data

        for(int i = 0; i < 251281; i++)
        {
            originalArr[i] = arrayList.get(i);
        }

        Time.calculateRandomTime(originalArr, inputAxis);

        randomYAxis[0] = Time.countingTimes;                                // countingSort random data
        randomYAxis[1] = Time.pigeonholeTimes;                              // pigeonholeSort random data
        randomYAxis[2] = Time.mergeTimes;                                   // mergeSort random data
        randomYAxis[3] = Time.insertionTimes;                               // insertionSort random data

        System.out.println("-----Random-----");
        printArray(randomYAxis[0]);
        printArray(randomYAxis[1]);
        printArray(randomYAxis[2]);
        printArray(randomYAxis[3]);

        Time.calculateSortedTime(originalArr, inputAxis);

        sortedYAxis[0] = Time.sortedCountingTimes;                          // countingSort sorted data
        sortedYAxis[1] = Time.sortedPigeonholeTimes;                        // pigeonholeSort sorted data
        sortedYAxis[2] = Time.sortedMergeTimes;                             // mergeSort sorted data
        sortedYAxis[3] = Time.sortedInsertionTimes;                         // insertionSort sorted data

        System.out.println("-----Sorted-----");
        printArray(sortedYAxis[0]);
        printArray(sortedYAxis[1]);
        printArray(sortedYAxis[2]);
        printArray(sortedYAxis[3]);

        Time.calculateReverseTime(originalArr, inputAxis);

        reversedYAxis[0] = Time.reverseCountingTimes;                       // countingSort reversed data
        reversedYAxis[1] = Time.reversePigeonholeTimes;                     // pigeonholeSort reversed data
        reversedYAxis[2] = Time.reverseMergeTimes;                          // mergeSort reversed data
        reversedYAxis[3] = Time.reverseInsertionTimes;                      // insertionSort reversed data

        System.out.println("-----Reversed-----");
        printArray(reversedYAxis[0]);
        printArray(reversedYAxis[1]);
        printArray(reversedYAxis[2]);
        printArray(reversedYAxis[3]);

        showAndSaveChart("Random Input Data", inputAxis, randomYAxis);
        showAndSaveChart("Sorted Input Data", inputAxis, sortedYAxis);
        showAndSaveChart("Reversed Input Data", inputAxis, reversedYAxis);
    }


    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException
    {
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        chart.addSeries("Counting Sort", doubleX, yAxis[0]);
        chart.addSeries("Pigeonhole Sort", doubleX, yAxis[1]);
        chart.addSeries("Merge Sort", doubleX, yAxis[2]);
        chart.addSeries("Insertion Sort", doubleX, yAxis[3]);

        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        new SwingWrapper(chart).displayChart();
    }


    public static void printArray(double[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
