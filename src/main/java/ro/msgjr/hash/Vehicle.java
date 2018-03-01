package ro.msgjr.hash;

import java.util.*;
import java.util.stream.Collectors;

public class Vehicle {
    private Long id;
    private Long currentRide;
    private Long ttLive;
    private List<Long> rideIds;

    public List<Long> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(List<Long> rideHistory) {
        this.rideHistory = rideHistory;
    }

    private List<Long> rideHistory;

    public Vehicle(Long id, Long currentRide, Long ttLive) {
        this.id = id;
        this.currentRide = currentRide;
        this.ttLive = ttLive;
        this.rideIds = sortRides(0L,new Point(0L,0L), Main.rides);
        this.rideHistory = new ArrayList<>();
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

    private Long costToStart(Ride ride, Point currLoc,Long time ) {
        return Math.max(0, ride.getEarliestStart() - time - Main.distance(currLoc, ride.getStartPoint())) + Main.distance(currLoc, ride.getStartPoint());
    }

    private Long scheduleNewRide(){
        if(this.currentRide == null){
            this.currentRide = this.rideIds.get(0);
            Ride newRide = Main.allRides.stream().filter(e -> e.getId().equals(this.currentRide)).findFirst().get();
            this.rideHistory.add(this.currentRide);
            this.ttLive = costToStart(newRide,new Point(0L,0L),Main.globalTime);
            return this.currentRide;
        }
        Ride justFinished = Main.allRides.stream().filter(e -> e.getId().equals(this.currentRide)).findFirst().get();
        this.currentRide = this.rideIds.get(0);
        Ride newRide = Main.allRides.stream().filter(e -> e.getId().equals(this.currentRide)).findFirst().get();
        this.rideHistory.add(this.currentRide);
        this.ttLive = costToStart(newRide,justFinished.getEndPoint(),Main.globalTime);
        this.rideIds = sortRides(Main.globalTime + costToStart(newRide, justFinished.getEndPoint(), Main.globalTime), newRide.getEndPoint(), Main.rides);
        return this.currentRide;
    }

    public Long update() {
        if(ttLive>0) {
            ttLive--;
            return null;
        }
     return scheduleNewRide();
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
