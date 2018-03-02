package ro.msgjr.hash;

import ro.msgjr.hash.inout.FileReader;
import ro.msgjr.hash.inout.FileWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {

    private static final String fileName = "e_high_bonus";

    static Long bonus;
    static List<Ride> rides;
    static List<Ride> allRides;
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
        rides = getRides(iterator);
        allRides = new ArrayList<>(rides);

        List<Vehicle> vehicles = new ArrayList<>();
        for (Long i = 0L; i < simulation.getVehicles(); i++) {
            vehicles.add(new Vehicle(i, null, 0L));
        }

        for (int i = 0; i < simulation.getSimulationSteps(); i++) {
            System.out.println(i);
            globalTime = (long) i;
            for (Vehicle v : vehicles) {
                Long rideId = v.update();
                if (rideId != null) {
                    vehicles.stream().filter(e -> !e.getId().equals(v.getId())).forEach(f -> f.getRideIds().removeAll(f.getRideIds().stream().filter(e1 -> e1.equals(rideId)).collect(Collectors.toList())));
                    rides.removeAll(rides.stream().filter(e -> e.getId().equals(rideId)).collect(Collectors.toList()));
                }

                if (rides.isEmpty()) {
                    break;
                }
            }
            if (rides.isEmpty()) {
                break;
            }
        }

        AtomicReference<String> output = new AtomicReference<>("");
        vehicles.forEach(v -> {
            output.updateAndGet(v1 -> v1 + v.getRideHistory().size());
            v.getRideHistory().forEach(rh -> output.updateAndGet(vl -> vl + " " + rh));
            output.updateAndGet(vl -> vl + "\n");
        });
        //////////////////////////////////////////////////////////
        // Write result
        new FileWriter(fileName, output.get());
    }

    static Long distance(Point start, Point end) {
        return Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
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
