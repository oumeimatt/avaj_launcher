package launcher.simulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import launcher.exceptions.FileException;
import launcher.exceptions.InvalidInputException;
import launcher.aircraft.Flayable;
import launcher.aircraft.AircraftFactory;
import launcher.Coordinates;
import launcher.WeatherTower;

public class simulation {

    private static ArrayList<String> data = new ArrayList<String>();
    private static int weatherChanges = 0;
    private static ArrayList<Flayable> aircrafts = new ArrayList<Flayable>();

    private static void registerSimulation(){
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("simulation.txt", false);
            if(out != null)
                out.close();
        }
        catch (IOException e) {
            System.err.println("Simulation file error: " + e.getMessage());
            System.exit(0);
        }
    }

    private static void startSimulator()throws InvalidInputException{
        if (data.size() < 1)
            throw new InvalidInputException("Invalid input! please add an aircraft to senario file !");
        registerSimulation();
        WeatherTower tower = new WeatherTower();
        for (String aircraft: data){
            String [] aircraftData = aircraft.split(" ");
            Coordinates coordinates = 
                new Coordinates(Integer.parseInt(aircraftData[2]),
                                Integer.parseInt(aircraftData[3]),
                                Integer.parseInt(aircraftData[4]));
            Flayable flayable = 
                AircraftFactory.newAircraft(aircraftData[0], aircraftData[1], coordinates);
            aircrafts.add(flayable);
            flayable.registerTower(tower);
            tower.register(flayable);
        }
        while (weatherChanges > 0){
            tower.changeWeather();
            weatherChanges--;
        }

    }

    private static boolean isValidCoordinate(String coordinate, boolean isHeight){
        try {
            int coord = Integer.parseInt(coordinate);
            if (coord < 0 || (isHeight == true && coord > 100))
                throw new NumberFormatException("Invalid coordinates !");
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static void validateInput(String line) throws InvalidInputException{
        if (line != null && !line.equals("")){
            String[] aircarftInfo = line.split(" ");
            if ((aircarftInfo[0].equals("JetPlane") || aircarftInfo[0].equals("Baloon") 
                || aircarftInfo[0].equals("Helicopter")) && isValidCoordinate(aircarftInfo[2], false)
                && isValidCoordinate(aircarftInfo[3], false) && isValidCoordinate(aircarftInfo[4], true))
                data.add(line);
            else
                throw new InvalidInputException("Invalid aircraft type or coordinates");
        }
    }

    private static void getWeatherChanges(String line) throws NumberFormatException{
        try {
            weatherChanges = Integer.parseInt(line);
            if (weatherChanges <= 0)
                throw new NumberFormatException("Invalid input. The number of times the weather will change should be a positive integer number!");

        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Invalid input. The number of times the weather will change should be a positive integer number!");
        }
    }

    public static void main(String args[]){
        BufferedReader reader;
        if (args.length == 1){
            try {
                reader = new BufferedReader(new FileReader(args[0]));
                String line = reader.readLine();
                getWeatherChanges(line);
                while (line != null){
                    line = reader.readLine();
                    validateInput(line);
                }
                startSimulator();
                reader.close();
            } catch (IOException | NumberFormatException | InvalidInputException e){
                try {
                    if (e.getMessage().startsWith(args[0])){
                        System.out.print(args[0]+ " : ");
                        throw new FileException("No such file !", e);
                    }
                    else
                        throw new InvalidInputException(e.getMessage(), e);
                }
                catch (FileException | InvalidInputException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}