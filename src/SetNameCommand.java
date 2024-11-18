public class SetNameCommand implements Command {
    private Event event;
    private String newName;
    private String oldName;

    public SetNameCommand(Event event, String newName) {
        this.event = event;
        this.newName = newName;
    }

    @Override
    public void execute() {
        oldName = event.getName();
        event.setName(newName);
    }

    @Override
    public void undo() {
        event.setName(oldName);
    }
}
