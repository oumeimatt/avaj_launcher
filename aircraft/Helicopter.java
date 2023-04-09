package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;
import weather.WeatherTower;

public class Helicopter extends Aircraft{

    protected WeatherTower weatherTower;
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";
    }
    public void updateConditions(){
        String weather = this.WeatherTower.getWeather(p_coordinates);
        switch(weather){
            case "SUN":
                this.Coordinates.setLongitude(this.Coordinates.getLongitude() + 10);
                this.Coordinates.setHeight(this.Coordinates.getHeight() + 2);
            case "RAIN":
                this.Coordinates.setLongitude(this.Coordinates.getLongitude() + 5);
            case "FOG":
                this.Coordinates.setLongitude(this.Coordinates.getLongitude() + 1);
            case "SNOW":
                this.Coordinates.setHeight(this.Coordinates.getHeight() - 12);
        }
    }
}