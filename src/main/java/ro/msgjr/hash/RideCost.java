package ro.msgjr.hash;

import java.util.Objects;

public class RideCost implements Comparable<RideCost> {
    private Long rideId;
    private Long cost;

    RideCost(Long rideId, Long cost) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideCost rideCost = (RideCost) o;
        return Objects.equals(rideId, rideCost.rideId) &&
                Objects.equals(cost, rideCost.cost);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rideId);
    }

    @Override
    public int compareTo(RideCost o) {
        return cost.compareTo(o.cost);
    }
}
