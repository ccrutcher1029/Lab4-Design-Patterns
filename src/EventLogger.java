public class EventLogger implements EventObserver{
    private String loggerName;

    public EventLogger(String loggerName){
        this.loggerName = loggerName;
    }

    @Override
    public void update(Event event) {
        System.out.println(loggerName + ": " + event.getName() +
                " Is scheduled for " + event.getDateTime());
    }
}
