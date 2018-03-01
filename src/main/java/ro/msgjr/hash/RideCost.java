package ro.msgjr.hash;

public class RideCost implements Comparable<RideCost> {
    Long rideId;
    Long cost;

    public RideCost(Long rideId, Long cost) {
        this.rideId = rideId;
        this.cost = cost;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(RideCost o) {
        return cost.compareTo(o.cost);
    }
}
