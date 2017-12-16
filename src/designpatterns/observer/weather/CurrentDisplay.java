package designpatterns.observer.weather;

/**
 * Created by nsarvar on 12/15/17.
 */
public class CurrentDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    public CurrentDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + weatherData.getTemperature() + ", Humadity: " + weatherData.getHumadity());
    }
}
