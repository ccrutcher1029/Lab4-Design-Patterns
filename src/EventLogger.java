public class EventLogger implements EventObserver{
    private String loggerName;

    public EventLogger(String loggerName){
        this.loggerName = loggerName;
    }

    @Override
    public void update(Event event, String message) {
        System.out.println(loggerName + ": " + message);
    }
}
