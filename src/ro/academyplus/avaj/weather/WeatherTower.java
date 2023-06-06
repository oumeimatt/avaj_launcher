package src.ro.academyplus.avaj.weather;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.weather.WeatherProvider;
import src.ro.academyplus.avaj.simulator.Tower;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates p_coordinates){
        // return "SUN";
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }
    public void changeWeather(){
        this.conditionChanged();
    }
}