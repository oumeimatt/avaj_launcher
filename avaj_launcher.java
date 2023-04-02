package examples;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// import java.io.NumberFormatException;

public class avaj_launcher {
    static boolean validCoordinates(String[] coord){
        try {
            int longitude = Integer.parseInt(coord[2]);
            int latitude = Integer.parseInt(coord[3]);
            int height = Integer.parseInt(coord[4]);
            if (longitude <= 0 || latitude <= 0 || height <= 0)
                return false;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Coordinates!");
            return (false);
        }
        return true;
    }

    static boolean isDataValid(String data[]){
        if (data.length == 5){
            if (!data[0].equals("Baloon") && !data[0].equals("JetPlane") 
                && !data[0].equals("Helicopter"))
                return false;
            if (validCoordinates(data))
                System.out.println("valid Coordinates :)");
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        // System.out.println(args[0]);
        if (args.length == 1){
            try {
                File myObj = new File(args[0]);
                Scanner myReader = new Scanner(myObj);
                while(myReader.hasNextLine()){
                    String line = myReader.nextLine();
                    System.out.println(line);
                    String data[] = line.split(" ");
                    isDataValid(data);
                }
                myReader.close();
            } catch (FileNotFoundException e){
                System.out.println("Invalid file !");
                e.printStackTrace();
            }

        }
        
    }
}