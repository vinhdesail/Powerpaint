/*
 * TCSS 305 - Assignment 5: PowerPaint
 */
package gui;

import java.awt.EventQueue;

/**
 * Runs PowerPaint by starting the PowerPaintGUI.
 * 
 * @author vvien
 * @version 1.0
 */
public final class PowerPaintMain {
    
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerPaintMain() {
        
        throw new IllegalStateException();
    }

    /**
     * The main method to start the GUI. 
     * 
     * @param theArgs The command line argument.
     */
    public static void main(final String[] theArgs) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
        
    }

}
