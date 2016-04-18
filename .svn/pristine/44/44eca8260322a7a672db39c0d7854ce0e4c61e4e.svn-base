/*
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package tools;

import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

import javax.swing.ImageIcon;

/**
 * The Rectangle tool object.
 * 
 * @author vvien
 * @version 1.7
 */
public class RectangleTool extends AbstractTools {
    
    /**
     * The name of the Rectangle.
     */
    private static final String DEFAULT_DESCRIPTION = "Rectangle";
    
    /**
     * The image related to the Rectangle.
     */
    private static final ImageIcon DEFAULT_IMAGE  = 
                    new ImageIcon("./images./rectangle_bw.gif");
    
    /**
     * The mnemonic related to the Rectangle.
     */
    private static final int DEFAULT_MNEMONIC = KeyEvent.VK_R;
    
    /**
     * Constructor for the object.
     */
    public RectangleTool() {
        
        super(DEFAULT_DESCRIPTION, DEFAULT_IMAGE, DEFAULT_MNEMONIC);
        final RectangularShape rectangle = new Rectangle2D.Double();
        setBox((RectangularShape) rectangle.clone());
    }
    
    
}
