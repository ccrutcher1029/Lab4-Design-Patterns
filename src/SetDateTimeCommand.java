import java.util.Date;

public class SetDateTimeCommand implements Command {
    private Event event;
    private Date newDateTime;
    private Date oldDateTime;

    public SetDateTimeCommand(Event event, Date newDateTime) {
        this.event = event;
        this.newDateTime = newDateTime;
    }

    @Override
    public void execute() {
        oldDateTime = event.getDateTime();
        event.setDateTime(newDateTime);
    }

    @Override
    public void undo() {
        event.setDateTime(oldDateTime);
    }
}
