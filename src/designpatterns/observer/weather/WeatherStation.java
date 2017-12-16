package designpatterns.observer.weather;

/**
 * Created by nsarvar on 12/15/17.
 */
public class WeatherStation {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.registerObservers(currentDisplay);
        weatherData.registerObservers(statisticsDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(90, 65, 30.4f);
        weatherData.setMeasurements(10, 65, 30.4f);
    }
}
