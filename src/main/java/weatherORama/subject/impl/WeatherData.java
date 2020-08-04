package weatherORama.subject.impl;


import weatherORama.observers.Observer;
import weatherORama.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        observers.forEach(o -> o.update(temperature, humidity, pressure));
    }

    /* we notify the Observers when we get updated
    measurements from the Weather Station
     */
    public void measurementsChanged() {

        notifyObservers();


         /*
         ---old code
         float temp = getTemperature();
         float humidity = getHumidity();
         float pressure = getPressure();

         * call each display element to update its display,
         passing it the most recent measurements

         * by coding to concrete implementations
         we have no way to add or remove other display elements
         without making changes to the program

         * at least we seem to be using a common interface
         to talk to the display elements
         they all have an update() method that takes the temp, humidity and pressure

         *area of change
         we need to encapsulate this

         --- old code
        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
          */
    }


    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
