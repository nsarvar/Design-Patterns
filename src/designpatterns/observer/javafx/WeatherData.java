package designpatterns.observer.javafx;

import java.util.Observable;

/**
 * Created by nsarvar on 12/16/17.
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void changed(){
        // setChanged method of Observable class indicates the state has changed
        // and notifyObservers() will be called
        // if setchanged is not called, observers will not be notified
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humadity, float pressure){
        this.temperature = temperature;
        this.humidity = humadity;
        this.pressure = pressure;

        changed();
    }
}
