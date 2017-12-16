package designpatterns.observer.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private float temperature;
    private float humidity;
    private float pressure;
    WeatherData weatherData;
    CurrentDisplay currentDisplay;

    @FXML
    private TextField temperatureText;
    @FXML
    private TextField humidityText;
    @FXML
    private TextField pressureText;
    @FXML
    private Label currentStatus;


    public Controller(){
        weatherData = new WeatherData();
        currentDisplay = new CurrentDisplay(weatherData, this);
    }

    public void changeMeasurements(ActionEvent actionEvent) {

        this.temperature = Float.parseFloat(temperatureText.getText());
        this.humidity = Float.parseFloat(humidityText.getText());
        this.pressure = Float.parseFloat(pressureText.getText());

        weatherData.setMeasurements(temperature, humidity, pressure);
    }

    public void updateCurrentDisplayText(String text){
        currentStatus.setText(text);
    }
}
