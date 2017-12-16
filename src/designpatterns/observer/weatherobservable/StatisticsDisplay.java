package designpatterns.observer.weatherobservable;

import designpatterns.observer.weather.DisplayElement;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by nsarvar on 12/15/17.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0;
    private float minTemp = 200;
    private float tempSum = 0;
    private int numReadings = 0;

    public StatisticsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg. temp: " + tempSum/numReadings + ", Min.temp: " + minTemp + ", Max.temp: " + maxTemp);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            tempSum += weatherData.getTemperature();

            if(maxTemp < weatherData.getTemperature())
                maxTemp = weatherData.getTemperature();

            if(minTemp > weatherData.getTemperature())
                minTemp = weatherData.getTemperature();

            numReadings++;
            display();
        }
    }
}