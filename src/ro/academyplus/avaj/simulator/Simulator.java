package src.ro.academyplus.avaj.simulator;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import src.ro.academyplus.avaj.simulator.MyException;
import src.ro.academyplus.avaj.simulator.aircrafts.Flayable;
import src.ro.academyplus.avaj.simulator.aircrafts.AircraftFactory;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.weather.WeatherTower;

public class Simulator {

    private static ArrayList<String> data = new ArrayList<String>();
    private static ArrayList<Flayable> aircrafts = new ArrayList<Flayable>();
    private static WeatherTower weatherTower;
    private static int simulations = 0;

    private static void generateSimulation(){
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("simulation.txt", false);
            if(out != null)
                out.close();
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private static void startSimulator()throws MyException{
        weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        if (data.size() < 1)
            throw new MyException("Invalid input! please add an aircraft to senario file !");
        generateSimulation();
        for (String aircraft: data){
            String [] aircraftData = aircraft.split(" ");
            Coordinates coordinates = 
                new Coordinates(Integer.parseInt(aircraftData[2]),
                                Integer.parseInt(aircraftData[3]),
                                Integer.parseInt(aircraftData[4]));
            Flayable flayable = 
                aircraftFactory.newAircraft(aircraftData[0], aircraftData[1], coordinates);
            aircrafts.add(flayable);
            flayable.registerTower(weatherTower);
        }
        for (; simulations > 0; simulations--){
            weatherTower.changeWeather();
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

    private static void validateInput(String line, int lineNumber) throws MyException{
        if (line != null && !line.equals("")){
            String error;
            String[] aircarftInfo = line.split(" ");
            if (aircarftInfo.length != 5){
                error = "Line " + lineNumber + " is Invalid! ( example of a valid line: TYPE NAME LONGITUDE LATITUDE HEIGHT)";
                throw new MyException(error);
            }
            else if (!aircarftInfo[0].equals("JetPlane") && !aircarftInfo[0].equals("Baloon") 
                && !aircarftInfo[0].equals("Helicopter")){
                    error = "Line " + lineNumber + " :Invalid aircraft type!";
                    throw new MyException(error);
            }
            else if (!isValidCoordinate(aircarftInfo[2], false)
                || !isValidCoordinate(aircarftInfo[3], false)){
                    error = "Line " + lineNumber + " :Invalid aircraft coordinates!";
                    throw new MyException(error);
            }

            else if (!isValidCoordinate(aircarftInfo[4], true)){
                error = "Line " + lineNumber + " :Invalid aircraft height!";
                throw new MyException(error);
            }
            else
                data.add(line);
        }
    }

    private static void getSimulationNumber(String line) throws NumberFormatException{
        try {
            simulations = Integer.parseInt(line);
            if (simulations <= 0)
                throw new NumberFormatException();

        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Line 1: Invalid input! The numer of simulations should be a positive integer!");
        }
    }

    public static void main(String args[]){
        BufferedReader reader;
        if (args.length == 1){
            try {
                reader = new BufferedReader(new FileReader(args[0]));
                String line = reader.readLine();
                getSimulationNumber(line);
                int lineNumber = 2;
                while (line != null){
                    line = reader.readLine();
                    validateInput(line, lineNumber);
                    lineNumber++;
                }
                startSimulator();
                reader.close();
            } catch (IOException | NumberFormatException | MyException e){
                try {
                    if (e.getMessage().startsWith(args[0])){
                        System.out.print(args[0]+ " : ");
                        throw new MyException("No such file !", e);
                    }
                    else
                        throw new MyException(e.getMessage(), e);
                }
                catch (MyException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}