/*
 * TCSS 305 - Assignment 5: PowerPaint
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * Represent an icon for color chooser. 
 * 
 * @author vvien
 * @version 1.5
 */
public class ColorIcon implements Icon {
    
    /**
     * The width of the icon.
     */
    private static final int WIDTH = 14;
    
   /**
    * The height of the icon.
    */
    private static final int HEIGHT = 14;
    
    /**
     * The color. 
     */
    private final Color myColor;
    
    /**
     * The constructor for the ColorIcon. 
     * 
     * @param theColor The color passed.
     */
    public ColorIcon(final Color theColor) {
        
        myColor = theColor;
    }
    
    /**
     * Paint the Icon.
     * 
     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
     * @param theC The component.
     * @param theG The Graphics.
     * @param theX The x component.
     * @param theY The y component.
     */
    @Override
    public void paintIcon(final Component theC, final Graphics theG, 
                          final int theX, final int theY) {
        
        theG.setColor(myColor);  
        theG.fillRect(theX, theY, WIDTH - 1, HEIGHT - 1);  
  
        theG.setColor(Color.BLACK);  
        theG.drawRect(theX, theY, WIDTH - 1, HEIGHT - 1);

    }

    /**
     * Get the icon width component.
     * 
     * @see javax.swing.Icon#getIconWidth()
     * @return integer The width.
     */
    @Override
    public int getIconWidth() {
        
        return WIDTH;
    }

    /**
     * Get the icon height component.
     * 
     * @see javax.swing.Icon#getIconHeight()
     * @return integer The height;
     */
    @Override
    public int getIconHeight() {

        return HEIGHT;
    }

}
