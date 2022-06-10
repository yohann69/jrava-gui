package fr.iutvalence.info.but.s2_01.jrava.mmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Graphical Mmi "Main" frame, displaying main menu.
 *
 * @version 1.0
 */
public class GraphicalMmiMainFrame extends GraphicalMmiJFrame implements ActionListener, Runnable {

    private JLabel activityCountLabel;
    private JPanel activityCountPanel;
    private JPanel buttonsPanel;
    private JButton createButton;
    private JButton exitButton;
    private JButton listButton;
    private JButton statsButton;


    public GraphicalMmiMainFrame(GraphicalMmi graphicalMmi) {
        super(graphicalMmi);
    }

    @Override
    public void display() {
        setTitle("Main menu");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(2, 1));
        this.createButtonsPanel();
        this.add(buttonsPanel);
        this.createActivityCountPanel();
        this.add(activityCountPanel);
        super.display();

    }

    private void createButtonsPanel() {
        buttonsPanel = new JPanel(new GridLayout(1, 4));

        createButton = new JButton("Create");
        createButton.addActionListener(this);
        buttonsPanel.add(createButton);

        listButton = new JButton("List");
        listButton.addActionListener(this);
        buttonsPanel.add(listButton);

        statsButton = new JButton("Stats");
        statsButton.addActionListener(this);
        buttonsPanel.add(statsButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonsPanel.add(exitButton);
    }

    private void createActivityCountPanel() {
        activityCountPanel = new JPanel(new GridLayout(1, 1));
        activityCountLabel = new JLabel(getUpdateActivityCountText());
        activityCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        activityCountPanel.add(activityCountLabel);
    }

    public void actionPerformed(ActionEvent event) {
        setVisible(false);
        if (event.getSource() == createButton) {
            this.mmi.displayCreateActivityFrame();
        }
        if (event.getSource() == statsButton) {
            this.mmi.displayStatsFrame();
        }
        if (event.getSource() == listButton) {
            this.mmi.displayActivityFrame();
        }
        if (event.getSource() == exitButton) {
            this.dispose();
            System.exit(0);
        }
    }

    public void run() {
       this.display();
    }

    public void refresh(){
        activityCountLabel.setText(getUpdateActivityCountText() );

    }


    private String getUpdateActivityCountText() {
        return String.valueOf(tracker.getActivityCount()) + " activities";
    }
}