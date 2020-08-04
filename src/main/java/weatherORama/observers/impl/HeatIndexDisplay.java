package weatherORama.observers.impl;

import weatherORama.observers.DisplayElement;
import weatherORama.observers.Observer;
import weatherORama.subject.Subject;

/**
 * This display implements Observer
 * so it can get changes from the WeatherData object
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {

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
        float heatIndex = computeHeatIndex(temperature, humidity);
        System.out.println("Heat index is " + heatIndex);

    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    private float computeHeatIndex(float t, float rh) {
        float index = (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }
}
