package src.ro.academyplus.avaj.simulator.aircrafts;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.simulator.aircrafts.Flayable;
import src.ro.academyplus.avaj.weather.WeatherTower;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Aircraft implements Flayable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    protected WeatherTower weatherTower;


    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.type = "default";
    }

    public String getType(){
        return this.type;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    public abstract void updateConditions();
    
    public void registerTower(WeatherTower weatherTower){}

    public boolean isLanding(){
        if (this.coordinates.getHeight() == 0){
            return true;
        }
        return false;
    }

    protected void registerMessage(String Message){
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("simulation.txt", true);
            out = new BufferedWriter(fstream);
            out.write(Message);
            if(out != null)
                out.close();
        }
        catch (IOException e) {
            System.err.println("Simulation file error: " + e.getMessage());
            System.exit(0);
        }
    }
}