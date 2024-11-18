import java.util.Date;

public class Meeting extends Event implements Completable {
    private Date endDateTime;
    private String location;
    private boolean complete;

    public Meeting(String name, Date startDateTime, Date endDateTime, String location) {
       super(name, startDateTime);
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
    }

    public String getName() {
        return name;
    }

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public Date getEndTime() {
        return this.endDateTime;
    }

    public int getDuration() {
        long durationInMillis = this.endDateTime.getTime() - this.getDateTime().getTime();
        return (int) (durationInMillis / (1000 * 60));
    }

    public String getLocation() {
        return this.location;
    }

    public void setEndTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
