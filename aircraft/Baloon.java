package aircraft;
import aircraft.Coordinates;
import aircraft.Aircraft;
import weather.WeatherTower;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        System.out.println("Baloon weather == " + weather);
        switch(weather){
            case "SUN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");
                System.out.println("This is hot.");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("It's raining. Better watch out for lightings.");
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("Let's enjoy the good weather and take some pics.");
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("My rotor is going to freeze!");
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;

    }

}