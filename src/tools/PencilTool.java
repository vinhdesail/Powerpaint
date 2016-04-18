/* 
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;

import javax.swing.ImageIcon;

/**
 * The Pencil tool object.
 * 
 * @author vvien
 * @version 1.5
 */
public class PencilTool extends AbstractTools {
    
    /**
     * The name of the Pencil.
     */
    private static final String DEFAULT_DESCRIPTION = "Pencil";
    
    /**
     * The image related to the Pencil.
     */
    private static final ImageIcon DEFAULT_IMAGE  = new ImageIcon("./images./pencil_bw.gif");
    
    /**
     * The mnemonic related to the Pencil.
     */
    private static final int DEFAULT_MNEMONIC = KeyEvent.VK_P;
    
    /**
     * The Path for pencil. 
     */
    private final Path2D myPath;
    
    /**
     * Constructor for the object. 
     */
    public PencilTool() {
        
        super(DEFAULT_DESCRIPTION, DEFAULT_IMAGE, DEFAULT_MNEMONIC);
        myPath = new Path2D.Double();
    }
    
    /**
     * Return the shape when clicked.
     * Pencil makes a dot. 
     * 
     * @param thePoint The point related to the shape. 
     * @return myPath The shape when clicked. 
     */
    @Override
    public Shape getClickedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myPath.reset();
        myPath.moveTo(myInitialPoint.getX(), myInitialPoint.getY());
        myPath.lineTo(myInitialPoint.getX(), myInitialPoint.getY());
        return (Path2D) myPath.clone();
    }
    
    /**
     * Return the shape when pressed.
     * In this case is the pencil marks
     * 
     * @param thePoint The point related to Pressed.
     * @return myPath The shape that pencil makes.
     */
    @Override
    public Shape getPressedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myPath.reset();
        myPath.moveTo(myInitialPoint.getX(), myInitialPoint.getY());
        myPath.lineTo(myInitialPoint.getX(), myInitialPoint.getY());
        return (Path2D) myPath.clone();
    }
    
    /**
     * Return the shape when Dragged.
     * In this case is the pencil marks
     * 
     * @param thePoint The point related to Dragged.
     * @return myPath The shape that pencil makes.
     */
    @Override
    public Shape getDraggedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myPath.lineTo(myInitialPoint.getX(), myInitialPoint.getY());
        return (Path2D) myPath.clone();
    }
    
    /**
     * Return the shape when Released.
     * In this case is the pencil marks
     * 
     * @param thePoint The point related to Released.
     * @return myPath The shape that pencil makes.
     */
    @Override
    public Shape getReleasedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myPath.lineTo(myInitialPoint.getX(), myInitialPoint.getY());
        return (Path2D) myPath.clone();
    }
    
    
    
}
