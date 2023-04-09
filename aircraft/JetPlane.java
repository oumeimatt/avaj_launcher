package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;
import weather.WeatherTower;

public class jetPlane extends Aircraft{

    protected WeatherTower weatherTower;
    public jetPlane(long p_id, string p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "JetPlane";
    }
    
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(p_coordinates);
        switch(weather){
            case "SUN":
                this.Coordinates.setLatitude(this.Coordinates.getLatitude() + 10);
                this.Coordinates.setHeight(this.Coordinates.getHeight() + 2);
            case "RAIN":
                this.Coordinates.setLatitude(this.Coordinates.getLatitude() + 5);
            case "FOG":
                this.Coordinates.setLatitude(this.Coordinates.getLatitude() + 1);
            case "SNOW":
                this.Coordinates.setHeight(this.Coordinates.getHeight() -7);
        }
    }
}