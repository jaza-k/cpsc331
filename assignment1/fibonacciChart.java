

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class fibonacciChart extends Application{
	
	static XYChart.Series fib1Series;
	static XYChart.Series fib2Series;
	static XYChart.Series fib3Series;
	
	/**
	 * Setter for setting the 3 series of XY values in the fibonacci line chart
	 * @param fib1_Input XYChart.Series object 
	 * @param fib2_Input
	 * @param fib3_Input
	 */
	public void setVals(XYChart.Series fib1_Input,XYChart.Series fib2_Input,XYChart.Series fib3_Input) {
		this.fib1Series = fib1_Input;
		this.fib2Series = fib2_Input;
		this.fib3Series = fib3_Input;
	}
 
 
    @Override public void start(Stage stage) {
        stage.setTitle("Graph");
        
        // Axes and titles
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Fibonacci Number");
        yAxis.setLabel("Time Elapsed (Nanoseconds)");
        
        // build the chart, add the data and the title
        LineChart lineChart = new LineChart (xAxis,yAxis);
        lineChart.setTitle("Time Elapsed vs Fibonacci Number");
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(fib1Series);
        lineChart.getData().add(fib2Series);
        lineChart.getData().add(fib3Series);
        
        // set the scene and start
        stage.setScene(scene);
        stage.show();
    }
}