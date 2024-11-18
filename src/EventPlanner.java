import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class EventPlanner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EventListPanel eventListPanel = new EventListPanel();

        addDefaultEvents(eventListPanel);

        frame.add(eventListPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void addDefaultEvents(EventListPanel eventListPanel) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER,25, 3, 0 );
        Date deadlineDate = calendar.getTime();
        Deadline deadline = new Deadline("Submit Lab", deadlineDate);


        calendar.set(2024,Calendar.SEPTEMBER,29,2, 0);
        Date meetingStart = calendar.getTime();
        calendar.set(2024,Calendar.SEPTEMBER,29,3, 0);
        Date meetingEnd = calendar.getTime();
        Meeting meeting = new Meeting("Group Meeting", meetingStart, meetingEnd, "Room 308");

        eventListPanel.addEvent(deadline);
        eventListPanel.addEvent(meeting);
    }
}
