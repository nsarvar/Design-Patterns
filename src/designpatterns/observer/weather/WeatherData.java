package designpatterns.observer.weather;

import java.util.ArrayList;

/**
 * Created by nsarvar on 12/15/17.
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humadity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumadity() {
        return humadity;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public void registerObservers(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObservers(Observer o) {
        int i = observers.indexOf(o);
        if (i>=0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }

    public void setMeasurements(float temperature, float humadity, float pressure){
        this.temperature = temperature;
        this.humadity = humadity;
        this.pressure = pressure;

        notifyObservers();
    }
}
