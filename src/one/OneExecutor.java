package one;

import one.observer.CurrentConditionDisplay;
import one.observer.Observer;
import one.observer.StatisticDisplay;
import one.observer.Subject;
import one.observer.WeatherData;

/**
 * This class has no other purpose but to execute some code because this class
 * contains main method.
 * <p>
 * Ovo je DRUGI komentar koji opisuje drugi commit.
 * <p>
 * @author grupa 3
 */
public class OneExecutor {

    public static void main(String[] args) {
        //SUBJECT/Observable
        WeatherData weatherData = new WeatherData();
        //Observer
        Observer observer1 = new CurrentConditionDisplay(weatherData);
        Observer observer2 = new StatisticDisplay(weatherData);
        //ažurirali izmjerene podatke
        weatherData.setMeasurements(23, 70, 950);
        weatherData.removeObserver(observer1);
        weatherData.setMeasurements(24, 80, 900);
    }
}
