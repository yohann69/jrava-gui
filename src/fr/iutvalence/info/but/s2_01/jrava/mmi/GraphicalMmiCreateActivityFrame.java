package fr.iutvalence.info.but.s2_01.jrava.mmi;

import fr.iutvalence.info.but.s2_01.jrava.model.Activity;
import fr.iutvalence.info.but.s2_01.jrava.model.ActivityType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Creates new activity frame.
 *
 * @version 1.0
 */
public class GraphicalMmiCreateActivityFrame extends GraphicalMmiJFrame implements ActionListener {
    private JButton addActivityButton;
    private JButton cancelButton;
    private JTextField dateTextField;
    private JPanel descriptionPanel;
    private JTextArea descriptionTextArea;
    private JTextField distanceTextField;
    private JTextField durationTextField;
    private JPanel formPanel;
    private JPanel submitPanel;
    private JTextField titleTextField;
    private JComboBox<String> typeComboBox;

    public GraphicalMmiCreateActivityFrame(GraphicalMmi graphicalMmi) {
        super(graphicalMmi);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        if (e.getSource() == addActivityButton) {

            if (createNewActivityFromFields() == null) {
                this.dispose();
                this.mmi.reload();
            } else {
                tracker.addActivity(createNewActivityFromFields());
                this.dispose();
                this.mmi.reload();
            }
        }
        if (e.getSource() == cancelButton) {
            this.dispose();
            this.mmi.reload();

        }
    }


    private void createFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));
        JLabel date = new JLabel("Date: ");
        dateTextField = new JTextField("24/03/2022");
        JLabel duration = new JLabel("Duration: ");
        durationTextField = new JTextField("3600");
        JLabel distance = new JLabel("Distance: ");
        distanceTextField = new JTextField("10000");
        JLabel type = new JLabel("Type: ");
        titleTextField = new JTextField("A valid activity");
        JLabel title = new JLabel("Title: ");
        typeComboBox = new JComboBox(ActivityType.values());

        formPanel.add(type);
        formPanel.add(typeComboBox);
        formPanel.add(title);
        formPanel.add(titleTextField);
        formPanel.add(date);
        formPanel.add(dateTextField);
        formPanel.add(duration);
        formPanel.add(durationTextField);
        formPanel.add(distance);
        formPanel.add(distanceTextField);


    }

    private void createDescriptionPanel() {
        descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridLayout(10, 5));
        JLabel description = new JLabel("Description: ");
        descriptionTextArea = new JTextArea("Optional description btw");
        descriptionPanel.add(description);
        descriptionPanel.add(descriptionTextArea);
    }


    private void createSubmitPanel() {
        submitPanel = new JPanel(new GridLayout(1, 2));

        addActivityButton = new JButton("Add Activity");
        addActivityButton.addActionListener(this);
        submitPanel.add(addActivityButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        submitPanel.add(cancelButton);
    }

    //    public Activity(ActivityType theType, String theTitle, Calendar theDate, int theDuration, double theDistance, String theDescription) {
    private Activity createNewActivityFromFields() {
        if (titleTextField.getText().isEmpty() || dateTextField.getText().isEmpty() || durationTextField.getText().isEmpty() || distanceTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Remplir tous les champs svp");
            return null;
        } else {
            String dateString = dateTextField.getText();
            String[] dateArray = dateString.split("/");
            int day = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);

            Calendar date = Calendar.getInstance();
            date.set(year, month, day);

            ActivityType type = (ActivityType) typeComboBox.getSelectedItem();
            return new Activity(type, this.titleTextField.getText(), date, Integer.parseInt(this.durationTextField.getText()), Integer.parseInt(this.distanceTextField.getText()), this.descriptionTextArea.getText());
        }

    }


    public void display() {
        this.setTitle("Create new activity");
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;

        this.createFormPanel();
        this.add(formPanel, gbc);
        this.createDescriptionPanel();
        this.add(descriptionPanel, gbc);
        this.createSubmitPanel();
        this.add(submitPanel, gbc);
        super.display();
    }

}
