package one.observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticDisplay implements Observer, DisplayElement {

    private List<Float> temperatures = new ArrayList<>();
    private List<Float> humidities = new ArrayList<>();
    private List<Float> pressures = new ArrayList<>();

    public StatisticDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatures.add(temperature);
        humidities.add(humidity);
        pressures.add(pressure);
        display();
    }

    @Override
    public void display() {
        float averageTemp = average(temperatures);
        float averageHumidity = average(humidities);
        float averagePressure = average(pressures);
        System.out.printf("Average temp/humidity/pressure = %s/%s/%s%n", averageTemp, averageHumidity, averagePressure);
    }

    //3, 4, 5
    private float average(List<Float> values) {
        float sum = 0f;
        for (Float value : values) {
            sum += value;
        }
        float average = sum / values.size();
        return average;
    }
}
