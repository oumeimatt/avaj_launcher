package weather;
import aircraft.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coordinates){
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }
    public void changeWeather(){
        this.conditionChanged();
    }
}