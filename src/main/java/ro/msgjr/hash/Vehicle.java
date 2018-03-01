package ro.msgjr.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Vehicle {
    private Long id;
    private Long currentRide;
    private Long ttLive;
    private List<Long> rideIds;

    public Vehicle(Long id, Long currentRide, Long ttLive) {
        this.id = id;
        this.currentRide = currentRide;
        this.ttLive = ttLive;
        this.rideIds = new ArrayList<>();
    }

    private List<Long> sortRides(Long time, Point currLoc, List<Ride> rides) {
        Set<RideCost> rideCosts = new TreeSet<>();
        rides.forEach(ride -> rideCosts.add(new RideCost(ride.getId(), calculateSingleCost(time, currLoc, ride))));
        return rideCosts.stream().map(RideCost::getRideId).collect(Collectors.toList());
    }

    private Long calculateSingleCost(Long time, Point currLoc, Ride ride) {
        Long result = 0L;
        if (Main.distance(currLoc, ride.getStartPoint()) + ride.getLength() > Math.abs(ride.getLatestFinish() - time)) {
            return Long.MAX_VALUE;
        }

        if (Main.distance(currLoc, ride.getStartPoint()) <= ride.getEarliestStart() - time) {
            result += Main.bonus;
        }

        return Math.max(0, ride.getEarliestStart() - time - Main.distance(currLoc, ride.getStartPoint())) + Main.distance(currLoc, ride.getStartPoint()) + result;


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Long currentRide) {
        this.currentRide = currentRide;
    }

    public Long getTtLive() {
        return ttLive;
    }

    public void setTtLive(Long ttLive) {
        this.ttLive = ttLive;
    }

    public List<Long> getRideIds() {
        return rideIds;
    }

    public void setRideIds(List<Long> rideIds) {
        this.rideIds = rideIds;
    }

}
