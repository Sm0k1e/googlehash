package ro.msgjr.hash;

public class Simulation {
    private Long rows;
    private Long columns;
    private Long vehicles;
    private Long rides;
    private Long bonus;
    private Long simulationSteps;

    public Simulation(Long rows, Long columns, Long vehicles, Long rides, Long bonus, Long simulationSteps) {
        this.rows = rows;
        this.columns = columns;
        this.vehicles = vehicles;
        this.rides = rides;
        this.bonus = bonus;
        this.simulationSteps = simulationSteps;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public Long getColumns() {
        return columns;
    }

    public void setColumns(Long columns) {
        this.columns = columns;
    }

    public Long getVehicles() {
        return vehicles;
    }

    public void setVehicles(Long vehicles) {
        this.vehicles = vehicles;
    }

    public Long getRides() {
        return rides;
    }

    public void setRides(Long rides) {
        this.rides = rides;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getSimulationSteps() {
        return simulationSteps;
    }

    public void setSimulationSteps(Long simulationSteps) {
        this.simulationSteps = simulationSteps;
    }
}
