import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventModal extends JDialog {
    private JTextField nameField, dateField, timeField, locationField, endDateField, endTimeField;
    private JRadioButton deadlineButton, meetingButton;
    private JButton addButton, cancelButton;
    private EventListPanel eventListPanel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AddEventModal(JFrame parent, EventListPanel eventListPanel) {
        super(parent, "Add Event", true);
        this.eventListPanel = eventListPanel;

        setLayout(new GridLayout(8,2));
        setSize(400,300);

        add(new JLabel("Name:"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("Date:"));
        dateField = new JTextField(10);
        add(dateField);

        add(new JLabel("Time:"));
        timeField = new JTextField(10);
        add(timeField);

        deadlineButton = new JRadioButton("Deadline");
        meetingButton = new JRadioButton("Meeting");
        ButtonGroup group = new ButtonGroup();
        group.add(deadlineButton);
        group.add(meetingButton);

        add(new JLabel("Location:"));
        locationField = new JTextField(10);
        locationField.setEnabled(false);
        add(locationField);

        add(new JLabel("End Date:"));
        endDateField = new JTextField(10);
        endDateField.setEnabled(false);
        add(endDateField);

        add(new JLabel("End Time:"));
        endTimeField = new JTextField(10);
        endTimeField.setEnabled(false);
        add(endTimeField);

        meetingButton.addActionListener(e -> {
            endDateField.setEnabled(true);
            endTimeField.setEnabled(true);
            locationField.setEnabled(true);
        });

        deadlineButton.addActionListener(e -> {
            deadlineButton.setSelected(true);
            meetingButton.setSelected(false);
            locationField.setEnabled(false);
        });

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });
        add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelButton);

    }

    private void addEvent() {
        String name = nameField.getText();
        String date = dateField.getText();

        try{
            Date dateTime = dateFormat.parse(date);

            if (deadlineButton.isSelected()) {

                Deadline deadline = new Deadline(name, dateTime);
                eventListPanel.addEvent(deadline);
            }else if (meetingButton.isSelected()) {
                String endDate = endDateField.getText();
                String endTime = endTimeField.getText();
                Date endDateTime = dateFormat.parse(endDate);

                String location = locationField.getText();
                Meeting meeting = new Meeting(name, dateTime, endDateTime, location);
                eventListPanel.addEvent(meeting);
            }
            dispose();

        }catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Invalid Date or Time");
        }
    }
}
