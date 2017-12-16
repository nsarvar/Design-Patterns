package designpatterns.observer.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nsarvar on 12/15/17.
 */
// implementing Observer interface from java.util
public class CurrentDisplay implements Observer {

    private float temperature;
    private float humidity;
    private Controller controller;

    public CurrentDisplay(Observable observable, Controller controller) {
        // take observable object or subject (WeatherData obj in our example)
        // and add this observer object (CurrentDisplay) into observable
        // Controller object needs to call its method to display text on the screen
        observable.addObserver(this);
        this.controller = controller;
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
        controller.updateCurrentDisplayText("Temperature: " + this.temperature + ", Humadity: " + this.humidity);
        System.out.println("Temperature: " + this.temperature + ", Humadity: " + this.humidity);
    }
}
