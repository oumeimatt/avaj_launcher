package avaj_launcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import exceptions.FileException;
import exceptions.InvalidInputException;
import java.util.ArrayList;

public class simulation {

    private static ArrayList<String> data = new ArrayList<String>();
    // private static void simulator(int n)

    private static boolean isInteger(String coordinate, boolean isHeight){
        try {
            int coord = Integer.parseInt(coordinate);
            if (coord < 0 || (isHeight == true && coord > 100))
                throw new NumberFormatException("Invalid coordinates !");
        }
        catch(NumberFormatException e){
            System.out.println(e);
            System.out.println(coordinate);
            return false;
        }
        return true;
    }

    private static void validateInput(String line) throws InvalidInputException{
            if (line != null && !line.equals("")){
                String[] aircarftInfo = line.split(" ");
                if ((aircarftInfo[0].equals("JetPlane") || aircarftInfo[0].equals("Baloon") 
                    || aircarftInfo[0].equals("Helicopter")) && isInteger(aircarftInfo[2], false)
                    && isInteger(aircarftInfo[3], false) && isInteger(aircarftInfo[4], true))
                    data.add(line);
                else
                    throw new InvalidInputException("Invalid input");
            }
    }

    public static void main(String args[]){
        int n = 0;
        BufferedReader reader;
        if (args.length == 1){
            try {
                reader = new BufferedReader(new FileReader(args[0]));
                String line = reader.readLine();
                n = Integer.parseInt(line);
                if (n <= 0)
                    throw new InvalidInputException("Invalid input");
                while (line != null){
                    line = reader.readLine();
                    validateInput(line);
                }
                System.out.println(data);
                reader.close();
            } catch (IOException | NumberFormatException | InvalidInputException e){
                try {
                    if (e.getMessage().startsWith(args[0]))
                        throw new FileException("PLease check File Name or path", e);
                    else
                        throw new InvalidInputException("Invalid input", e);
                }
                catch (FileException | InvalidInputException e2){
                    System.out.println(e2.toString());
                }
            }

        }
        
    }
}