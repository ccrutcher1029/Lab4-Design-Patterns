import java.util.Date;

public abstract class Event {
    public String name;
    public Date dateTime;

    public Event(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public abstract String getName();

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Event o) {
        return this.dateTime.compareTo(o.getDateTime());
    }
    //Changing this random comment to see if this works
}
