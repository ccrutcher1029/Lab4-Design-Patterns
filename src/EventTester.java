import java.sql.SQLOutput;
import java.util.Date;
import java.util.Calendar;

public class EventTester {
    public static void main(String[] args) {
        System.out.println("Testing Deadline Class: ");
        testDeadline();
        System.out.println("\nTesting Meeting Class: ");
        testMeeting();
    }

    public static void testDeadline() {
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
