package designpatterns.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nsarvar on 12/15/17.
 */
// implementing Observer interface from java.util
public class CurrentDisplay implements Observer {

    private float temperature;
    private float humidity;

    public CurrentDisplay(Observable observable) {
        // take observable object or subject (WeatherData obj in our example)
        // and add this observer object (CurrentDisplay) into observable
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        // make sure observable is of type WeatherData
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable; // typecasting
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();

            display();
        }
    }

    public void display() {
        System.out.println("Temperature: " + this.temperature + ", Humadity: " + this.humidity);
    }
}
