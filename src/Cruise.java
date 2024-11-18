import java.util.Date;

public class Cruise extends Event{
    public Cruise(String name, Date dateTime){
        super(name, dateTime);
    }

    @Override
public String getName(){
        return "Cruise: " + super.getDateTime();
    }
}
