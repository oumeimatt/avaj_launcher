package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;
import weather.WeatherTower;

public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";

    }
    public void updateConditions(){
        System.out.println("helicopter updated");
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        }
    }

    public void registerTower(WeatherTower weatherTower){        weatherTower.register(this);
        weatherTower.register(this);
    }

}