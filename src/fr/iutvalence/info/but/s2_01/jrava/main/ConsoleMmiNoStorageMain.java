package fr.iutvalence.info.but.s2_01.jrava.main;

import fr.iutvalence.info.but.s2_01.jrava.mmi.ConsoleMmi;
import fr.iutvalence.info.but.s2_01.jrava.model.ActivityTracker;
import fr.iutvalence.info.but.s2_01.jrava.model.Mmi;
import fr.iutvalence.info.but.s2_01.jrava.model.Storage;
import fr.iutvalence.info.but.s2_01.jrava.model.StorageAccessException;
import fr.iutvalence.info.but.s2_01.jrava.storage.NoStorage;

/**
 * Activity tracker application launcher.
 * Console mode, no storage service.
 *
 * @author Sebastien Jean
 * @version 1.0
 */
public class ConsoleMmiNoStorageMain {
    /**
     * Application's main.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("Jrava [console mode, no storage] starting...");
        Storage storage = new NoStorage();
        ActivityTracker tracker = new ActivityTracker();
        try {
            tracker.setStorage(storage);
        } catch (StorageAccessException e) {
            System.out.println("unable to access storage, activities won't be loaded/saved");
        }
        Mmi mmi = new ConsoleMmi(tracker);
        mmi.displayMMI();
        System.out.println("... exiting");
    }
}
