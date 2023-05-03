package launcher;
import java.util.ArrayList;
import launcher.WeatherTower;
import launcher.aircraft.Flayable;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tower {
    private ArrayList<Flayable> observers = new ArrayList<Flayable>();
    
    public Tower(){}
    public void register(Flayable p_flayable){
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("simulation.txt", true);
            out = new BufferedWriter(fstream);
            String registration = "Tower says: " + p_flayable.getType() + "#" + p_flayable.getName()
                + "(" + p_flayable.getId()+ ") registered to weather tower.\n";
            out.write(registration);
            if(out != null)
                out.close();
        }
        catch (IOException e) {
            System.err.println("Simulation file error: " + e.getMessage());
        }
        this.observers.add(p_flayable);
    }
    public void unregister(Flayable p_flayable) {
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("simulation.txt", true);
            out = new BufferedWriter(fstream);
            String landing = p_flayable.getType() + "#" + p_flayable.getName()
                + "(" + p_flayable.getId()+ ") landing.\n";
            String unregistration = "Tower says: " + p_flayable.getType() + "#" + p_flayable.getName()
                + "(" + p_flayable.getId()+ ") unregistered from weather tower.\n";
            out.write(landing);
            out.write(unregistration);
            if(out != null)
                out.close();
        }
        catch (IOException e) {
            System.err.println("Simulation file error: " + e.getMessage());
        }
        this.observers.remove(p_flayable);
    }
    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
            if (observers.get(i).isLanding()){
                this.unregister(observers.get(i));
                i--;
            }
        }
    }
}