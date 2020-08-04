package weatherORama.observers.impl;

import weatherORama.observers.DisplayElement;
import weatherORama.observers.Observer;
import weatherORama.subject.Subject;

/**
 * This display implements Observer
 * so it can get changes from the WeatherData object
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {

        /*
        the subject is only used here because, in the future,
        we may want to un-register ourselves as an observer
        and it would be handy to already have a reference to the subject
         */
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
