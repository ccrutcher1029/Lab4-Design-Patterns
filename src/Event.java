import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Event implements Comparable<Event> {
    public String name;
    public Date dateTime;
    private List<EventObserver> observers = new ArrayList<>();

    public Event(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public abstract String getName();

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
        notifyObservers("Date/Time changed to: " + dateTime);
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers("Name changed to: " + name);
    }

    public void addObserver(EventObserver observer){
        observers.add(observer);
    }

    public void removeObserver(EventObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(String message){
        for (EventObserver observer : observers){
            observer.update(this, message);
        }

    }

    public int compareTo(Event o) {
        return this.dateTime.compareTo(o.getDateTime());
    }
}
