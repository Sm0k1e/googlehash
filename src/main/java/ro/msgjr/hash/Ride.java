package ro.msgjr.hash;

public class Ride implements Comparable<Ride>{
    private Long id;
    private Point startPoint;
    private Point endPoint;
    private Long earliestStart;
    private Long latestFinish;
    private Long length;

    public Ride(Long id, Point startPoint, Point endPoint, Long earliestStart, Long latestFinish) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
        this.length = Main.distance(startPoint, endPoint);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Long getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(Long earliestStart) {
        this.earliestStart = earliestStart;
    }

    public Long getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(Long latestFinish) {
        this.latestFinish = latestFinish;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public int compareTo(Ride o) {
        return 0;
    }
}
