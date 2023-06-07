package src.ro.academyplus.avaj.weather;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.weather.WeatherProvider;
import src.ro.academyplus.avaj.simulator.Tower;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates p_coordinates){
        WeatherProvider x = WeatherProvider.getInstance();
        return x.getCurrentWeather(p_coordinates);
    }
    public void changeWeather(){
        this.conditionChanged();
    }
}