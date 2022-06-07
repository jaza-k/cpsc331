// Jaza Khan UCID 30119100
// CPSC 331 Assignment 1
// Tutorial 03

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * outputAndGraph.java class, contains methods to generate output
 * file and plot a JavaFX graph
 * @author Jaza K.
 * 
 */
public class OutputAndGraph extends fibAlgorithms {

    // get runtimes from Fib1
    public static long[] getRunTimesFib1(int[] input) throws IOException {
        long[] runTimes = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            long startTime = System.nanoTime();
            Fib1(input[i]);
            long endTime = System.nanoTime();
            runTimes[i] = endTime - startTime;
        }
        return runTimes;
    }

    // get runtimes from Fib2
    public static long[] getRunTimesFib2(int[] input) throws IOException {
        long[] runTimes = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            long startTime = System.nanoTime();
            Fib2(input[i]);
            long endTime = System.nanoTime();
            runTimes[i] = endTime - startTime;
        }
        return runTimes;
    }

    // get runtimes from Fib3
    public static long[] getRunTimesFib3(int[] input) throws IOException {
        long[] runTimes = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            long startTime = System.nanoTime();
            Fib3(input[i]);
            long endTime = System.nanoTime();
            runTimes[i] = endTime - startTime;
        }
        return runTimes;
    }

    /** 
     * writeToFile() method
     * @param fileWriter FileWriter object for output.txt
     * @param fib1Runtimes array containing calculated runtimes for Fib1
     * @param fib2Runtimes array containing calculated runtimes for Fib2
     * @param fib3Runtimes array containing calculated runtimes for Fib3
     * 
     */
    public static void writeToFile(FileWriter fileWriter, long[] fib1Runtimes, long[] fib2Runtimes, long[] fib3Runtimes, int[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            fileWriter.write("Fib1 computes F" + array[i] + " in " + fib1Runtimes[i] + " nanoseconds (" + fib1Runtimes[i]/1000000.0 + ") milliseconds\n");
        }
        fileWriter.write("\n");
        for (int i = 0; i < array.length; i++) {
            fileWriter.write("Fib2 computes F" + array[i] + " in " + fib2Runtimes[i] + " nanoseconds (" + fib2Runtimes[i]/1000000.0 + ") milliseconds\n");
        }
        fileWriter.write("\n");
        for (int i = 0; i < array.length; i++) {
            fileWriter.write("Fib3 computes F" + array[i] + " in " + fib3Runtimes[i] + " nanoseconds (" + fib3Runtimes[i]/1000000.0 + ") milliseconds\n");
        }
    }

    /** 
     * createOutputAndGraph() method, used to generate output.txt file as well create JavaFX 
     * graph plotting the runtimes
     * 
     * @param inputArray an integer array taken as input and passed into the Fibonacci algorithms 
     */
    public static void createOutputAndGraph(int[] inputArray) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");

            XYChart.Series series1 = new Series<>();
            XYChart.Series series2 = new Series<>();
            XYChart.Series series3 = new Series<>();

            series1.setName("Fib 1");
            series2.setName("Fib 2");
            series3.setName("Fib 3");

            for (int i = 0; i < inputArray.length; i++) {
                series1.getData().add(new Data<>(inputArray[i], getRunTimesFib1(inputArray)[i]));
                series2.getData().add(new Data<>(inputArray[i], getRunTimesFib2(inputArray)[i]));
                series3.getData().add(new Data<>(inputArray[i], getRunTimesFib3(inputArray)[i]));
            }

            writeToFile(fileWriter, getRunTimesFib1(inputArray), getRunTimesFib2(inputArray), getRunTimesFib3(inputArray), inputArray);
            fileWriter.close(); // close file writer

            fibonacciChart lineChart = new fibonacciChart();
            lineChart.setVals(series1, series2, series3);
            fibonacciChart.launch(lineChart.getClass());
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
    }
}