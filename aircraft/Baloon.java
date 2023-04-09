package aircraft;
import aircraft.Coordinates;
import aircraft.Aircraft;
import weather.WeatherTower;
public class Baloon extends Aircraft {

    protected WeatherTower weatherTower;
    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(p_coordinates);
        switch(weather){
            case "SUN":
                this.Coordinates.setLongitude(this.Coordinates.getLongitude() + 2);
                this.Coordinates.setHeight(this.Coordinates.getHeight() + 4);
            case "RAIN":
                this.Coordinates.setHeight(this.Coordinates.getHeight() - 5);
            case "FOG":
                this.Coordinates.setHeight(this.Coordinates.getHeight() - 3);
            case "SNOW":
                this.Coordinates.setHeight(this.Coordinates.getHeight() - 15);
        }
    }
}