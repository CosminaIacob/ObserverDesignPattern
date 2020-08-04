package weatherORama.observers;


public interface Observer {

    /*
    The params are the state values the Observers get from the
    when a weather measurement changes
     */
    void update(float temp, float humidity, float pressure);
}
