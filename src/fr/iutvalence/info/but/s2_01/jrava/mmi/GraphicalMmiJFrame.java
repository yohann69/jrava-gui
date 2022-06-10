package fr.iutvalence.info.but.s2_01.jrava.mmi;

import fr.iutvalence.info.but.s2_01.jrava.model.ActivityTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Convenience superclass for graphical mmi frames.
 * Frame is its own window listener, allowing to reload main frame on closing.
 *
 * @version 1.0
 */
public abstract class GraphicalMmiJFrame extends JFrame implements WindowListener {
    // To be completed
    protected final GraphicalMmi mmi;
    protected final ActivityTracker tracker;

    public GraphicalMmiJFrame(GraphicalMmi mmi) {
        this.mmi = mmi;
        this.tracker = mmi.getActivityTracker();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    public void display() {
         pack();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void windowClosed() {
        this.dispose();
        mmi.reload();
    }


}