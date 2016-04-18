package tools;

import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

import javax.swing.ImageIcon;

/*
 * TCSS 305 - Assignment 5: PowerPaint  
 */

/**
 *  The Ellipse tool object.
 * 
 * @author vvien
 * @version 1.8
 */
public class EllipseTool extends AbstractTools {
    
    /**
     * The name of the Ellipse.
     */
    private static final String DEFAULT_DESCRIPTION = "Ellipse";
    
    /**
     * The image related to the Ellipse.
     */
    private static final ImageIcon DEFAULT_IMAGE  = new ImageIcon("./images./ellipse_bw.gif");
    
    /**
     * The mnemonic related to the Ellipse.
     */
    private static final int DEFAULT_MNEMONIC = KeyEvent.VK_E;
    
    /**
     * Constructor for the object.
     */
    public EllipseTool() {
        
        super(DEFAULT_DESCRIPTION, DEFAULT_IMAGE, DEFAULT_MNEMONIC);
        final RectangularShape ellipse = new Ellipse2D.Double(); 
        setBox((RectangularShape) ellipse.clone());
    }
    
    
}
