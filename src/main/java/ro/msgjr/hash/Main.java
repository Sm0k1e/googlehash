package ro.msgjr.hash;

import ro.msgjr.hash.inout.FileReader;
import ro.msgjr.hash.inout.FileWriter;

import java.util.*;

public class Main {

    private static final String fileName = "a_example";

    static Long bonus;
    static List<Ride> rides;
    static Long globalTime = 0L;


    public static void main(String... args) {
        // Read file
        FileReader fileReader = new FileReader(fileName);
        List<String> fileRows = fileReader.getRows();
        //////////////////////////////////////////////////////////
        ////////////////////  CODE  //////////////////////////////
        //////////////////////////////////////////////////////////
        Iterator<String> iterator = fileRows.iterator();
        Scanner scanner = new Scanner(iterator.next());
        Simulation simulation = new Simulation(scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong());
        bonus = simulation.getBonus();
//        globalTime = simulation.getSimulationSteps();
        rides = getRides(iterator);

        //////////////////////////////////////////////////////////
        // Write result
        new FileWriter(fileName, fileRows.toString());
    }

    static Long distance(Point start, Point end){
        return Math.abs(start.getX()-end.getX())+Math.abs(start.getY()-end.getY());
    }

    private static List<Ride> getRides(Iterator<String> iterator) {
        List<Ride> rides = new ArrayList<>();
        int rideNr = 1;
        while (iterator.hasNext()) {
            Scanner scan = new Scanner(iterator.next());
            rides.add(new Ride((long) (rideNr - 1), new Point(scan.nextLong(), scan.nextLong()), new Point(scan.nextLong(), scan.nextLong()), scan.nextLong(), scan.nextLong()));
            rideNr++;
        }
        return rides;
    }
}
