import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel control;
    private JPanel display;
    private JComboBox<String> sortDropDown;
    private JCheckBox filterButton;
    private JButton addEventButton;

    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());
        control = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] sortOption = {"Sort by Name", "Sort by Date", "Sort by Time"};
        sortDropDown = new JComboBox<>(sortOption);
        sortDropDown.addActionListener(e -> sortEvents((String) sortDropDown.getSelectedItem()));
        control.add(sortDropDown);

        filterButton = new JCheckBox("Filter Events");
        filterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateEvent();
            }
        });
        control.add(filterButton);

        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener (e -> openAddEventModal());
        control.add(addEventButton);

        add(control, BorderLayout.SOUTH);

        display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        JScrollPane displayPane = new JScrollPane(display);
        add(displayPane, BorderLayout.CENTER);
        
    }

    public void addEvent(Event event) {
        events.add(event);
        updateEvent();

    }

    private void sortEvents(String sort) {
        switch (sort) {
            case "Sort by Name":
                Collections.sort(events, Comparator.comparing(Event::getName));
                break;
                case "Sort by Date":
                    Collections.sort(events, Comparator.comparing(Event::getDateTime));
                    break;


        }
        updateEvent();

    }

    private void updateEvent() {
        display.removeAll();

        for (Event e : events) {
            if (filterButton.isSelected() && e instanceof Completable && ((Completable) e).isComplete()) {
                continue;
            }

            EventPanel eventPanel = new EventPanel(e);
            display.add(eventPanel);
        }
        display.revalidate();
        display.repaint();
    }

    private void openAddEventModal() {
        JOptionPane.showMessageDialog(null, addEventButton.getText());
    }
}
