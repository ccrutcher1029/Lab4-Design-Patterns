import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EventPanel extends JPanel {
    private Event event;
    private JButton complete;
    private JLabel nameLabel, timeLabel, durationLabel, locationLabel, statusLabel;


    public EventPanel(Event event) {
        this.event = event;
        this.setLayout(new GridLayout(5, 1));

        nameLabel = new JLabel("Event: " + event.getName());
        timeLabel = new JLabel("Time: " + event.getDateTime());
        statusLabel = new JLabel("Status: " + (event instanceof Completable ? ((Completable) event).isComplete() ? "Complete" : "Incomplete" : "Not Completable"));

        this.add(nameLabel);
        this.add(timeLabel);
        this.add(statusLabel);

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            durationLabel = new JLabel("Duration: " + meeting.getDuration());
            locationLabel = new JLabel("Location: " + meeting.getLocation());
            this.add(durationLabel);
            this.add(locationLabel);
        }

        if (event instanceof Completable) {
            complete = new JButton("Complete");
            complete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete();
                    updateUrgency();
                }
            });
            this.add(complete);
        }
        updateUrgency();

    }

    public void updateUrgency() {
        Date now = new Date();
        long diff = now.getTime() - event.getDateTime().getTime();

        long oneDayInMillis = 24 * 60 * 60 * 1000;
        long days = diff / oneDayInMillis;

        if (event instanceof Completable && ((Completable) event).isComplete()) {
            setBackground(Color.GRAY);
        } else if (diff < 0) {
            setBackground(Color.RED);
        } else if (diff < days) {
            setBackground(Color.YELLOW);
        } else {
            setBackground(Color.GREEN);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
