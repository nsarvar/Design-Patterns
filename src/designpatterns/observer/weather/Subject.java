package designpatterns.observer.weather;

/**
 * Created by nsarvar on 12/15/17.
 */
public interface Subject {
    public void registerObservers(Observer o);

    public void removeObservers(Observer o);

    public void notifyObservers();
}
