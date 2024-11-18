import java.sql.SQLOutput;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class EventTester {
    public static void main(String[] args) {
        System.out.println("Testing Deadline Class: ");
        testDeadline();
        System.out.println("\nTesting Meeting Class: ");
        testMeeting();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            //Create event
            Date initialDate = new Date();
            Event cruise = new Cruise("Carnival Breeze", initialDate);

            //Observers
            EventLogger logger1 = new EventLogger("Logger1");
            EventLogger logger2 = new EventLogger("Logger2");

            //Add to event
            cruise.addObserver(logger1);
            cruise.addObserver(logger2);

            //Invoker
            CommandInvoker invoker = new CommandInvoker();

            //Display starting state
            System.out.println("Initial Event");
            displayEvent(cruise);

            //Execute SetNameCommand
            Command setName = new SetNameCommand(cruise, "Carnival Breeze");
            invoker.execute(setName);

            //Execute SetDateTimeCommand
            Date newDate = Calendar.getInstance().getTime();
            Command setDateTime = new SetDateTimeCommand(cruise, newDate);
            invoker.execute(setDateTime);

            //Undo
            invoker.undo();
            //Undo again
            invoker.undo();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void displayEvent(Event event) {
        System.out.println("Event: " + event.getName());
        System.out.println("Date and Time: " + event.getDateTime());
    }

    public static void testDeadline(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date deadlineDate = calendar.getTime();

        Deadline deadline = new Deadline("Deadline", deadlineDate);
        System.out.println("Name: " + deadline.getName());
        System.out.println("Date/Time: " + deadline.getDateTime());
        System.out.println("Is Complete: " + deadline.isComplete());

        deadline.complete();
        System.out.println("Is complete after deadline: " + deadline.isComplete());

    }

    public static void testMeeting() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date meetingStartDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date meetingEndDate = calendar.getTime();

        Meeting meeting = new Meeting("Meeting", meetingStartDate, meetingEndDate,"Conference Room");
        System.out.println("Name: " + meeting.getName());
        System.out.println("Start Date/Time: " + meeting.getDateTime());
        System.out.println("End Date/Time: " + meetingEndDate);
        System.out.println("Duration: " + meeting.getDuration());
        System.out.println("Location: " + meeting.getLocation());
        System.out.println("Is Complete: " + meeting.isComplete());

        meeting.complete();
        System.out.println("Is complete after Meeting: " + meeting.isComplete());

    }
}
