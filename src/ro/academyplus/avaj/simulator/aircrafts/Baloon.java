package src.ro.academyplus.avaj.simulator.aircrafts;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.simulator.aircrafts.Aircraft;
import src.ro.academyplus.avaj.weather.WeatherTower;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        String Message = "";
        switch(weather){
            case "SUN":
                Message = this.type + "#" + this.name + "(" + this.id + "): Lets enjoy the good weather and take some pictures.\n";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "): Damn you rain! You messed up my baloon!.\n";
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "): Im lost in the mist!.\n";
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "):  It's snowing.  We're gonna crash! !\n";
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        }
        registerMessage(Message);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

}