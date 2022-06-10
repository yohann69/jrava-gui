package fr.iutvalence.info.but.s2_01.jrava.mmi;

import fr.iutvalence.info.but.s2_01.jrava.model.ActivityTracker;
import fr.iutvalence.info.but.s2_01.jrava.model.Mmi;

import javax.swing.*;

/**
 * Graphical implementation of mmi service.
 *
 * @version 1.0
 */
public class GraphicalMmi implements Mmi {

    private ActivityTracker activityTracker;
    private final GraphicalMmiMainFrame mainFrame;

    public GraphicalMmi(ActivityTracker theActivityTracker) {
        activityTracker = theActivityTracker;
        mainFrame = new GraphicalMmiMainFrame(this);
    }


    public void displayMMI() {
        SwingUtilities.invokeLater(mainFrame);
    }


    @Override
    public void setActivityTracker(ActivityTracker activityTracker) {
        this.activityTracker = activityTracker;
    }

    public void displayCreateActivityFrame() {
        new GraphicalMmiCreateActivityFrame(this).display();
        mainFrame.setVisible(false);
    }

    public void displayActivityFrame() {
        new GraphicalMmiActivitiesFrame(this).display();
        mainFrame.setVisible(false);
    }

    public void displayStatsFrame() {
        new GraphicalMmiStatsFrame(this).display();
        mainFrame.setVisible(false);
    }

    public void reload() {
        mainFrame.refresh();
        mainFrame.setVisible(true);
    }

    public ActivityTracker getActivityTracker() {
        return activityTracker;
    }
}