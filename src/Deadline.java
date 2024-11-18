import java.util.Date;

public class Deadline extends Event implements Completable {
    private boolean complete;

    public Deadline(String name, Date dateTime) {
        super(name, dateTime);
        this.complete = false;
    }

    public String getName(){
        return name;
    }

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }
}
