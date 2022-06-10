package fr.iutvalence.info.but.s2_01.jrava.main;

import fr.iutvalence.info.but.s2_01.jrava.mmi.GraphicalMmi;
import fr.iutvalence.info.but.s2_01.jrava.model.ActivityTracker;
import fr.iutvalence.info.but.s2_01.jrava.model.Storage;
import fr.iutvalence.info.but.s2_01.jrava.model.StorageAccessException;
import fr.iutvalence.info.but.s2_01.jrava.storage.NoStorage;

/**
 * Activity tracker application launcher.
 * Graphical mode, no storage service
 *
 * @author Sebastien Jean
 * @version 1.0
 */
public class GraphicalMmiNoStorageMain {
    /**
     * Application's main.
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        System.out.println("Jrava [graphical mode, no storage] starting...");
        Storage storage = new NoStorage();
        ActivityTracker tracker = new ActivityTracker();
        try {
            tracker.setStorage(storage);
        } catch (StorageAccessException e) {
            System.out.println("unable to access storage, activities won't be loaded/saved");
        }
        new GraphicalMmi(tracker).displayMMI();
    }
}
