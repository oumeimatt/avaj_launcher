package src.ro.academyplus.avaj.simulator.aircrafts;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.simulator.aircrafts.Aircraft;
import src.ro.academyplus.avaj.weather.WeatherTower;


public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";

    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        String Message = "";
        switch(weather){
            case "SUN":
                Message = this.type + "#" + this.name + "(" + this.id + "): This is hot.\n";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "):Damn! It's raining. i forgot my umbrella xD .\n";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "): MY EYEESS!! MY EYEEESS!! this fog is going to kill me.\n";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "):  My rotor is going to freeze !\n";
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
        }
        registerMessage(Message);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

}