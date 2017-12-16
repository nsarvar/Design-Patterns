package designpatterns.observer.weather;

/**
 * Created by nsarvar on 12/15/17.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0;
    private float minTemp = 200;
    private float tempSum = 0;
    private int numReadings = 0;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        tempSum += weatherData.getTemperature();

        if(maxTemp < weatherData.getTemperature())
            maxTemp = weatherData.getTemperature();

        if(minTemp > weatherData.getTemperature())
            minTemp = weatherData.getTemperature();

        numReadings++;

        display();
    }

    @Override
    public void display() {
        System.out.println("Avg. temp: " + tempSum/numReadings + ", Min.temp: " + minTemp + ", Max.temp: " + maxTemp);
    }
}
