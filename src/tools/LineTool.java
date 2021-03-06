/*
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package tools;


import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;

/**
 * The Line tool object.
 * 
 * @author vvien
 * @version 1.6
 */
public class LineTool extends AbstractTools {
    
    /**
     * The name of the Line.
     */
    private static final String DEFAULT_DESCRIPTION = "Line";
    
    /**
     * The image related to the Line.
     */
    private static final ImageIcon DEFAULT_IMAGE  = new ImageIcon("./images./line_bw.gif");
    
    /**
     * The mnemonic related to the Line.
     */
    private static final int DEFAULT_MNEMONIC = KeyEvent.VK_L;
    
    /**
     * The new line each time drawn.
     */
    private final Line2D.Double myNewLine;
    
    
    /**
     * Constructor for the object.
     */
    public LineTool() {
        
        super(DEFAULT_DESCRIPTION, DEFAULT_IMAGE, DEFAULT_MNEMONIC);
        myNewLine = new Line2D.Double();
    }
    
    /**
     * Return the shape when clicked.
     * Line makes a dot.
     * 
     * @param thePoint The point related to the shape. 
     * @return myNewLine The shape when clicked. 
     */
    @Override
    public Shape getClickedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myNewLine.setLine(myInitialPoint, myInitialPoint);
        return (Line2D.Double) myNewLine.clone();
    }
    
    /**
     * Return the shape when pressed.
     * In this case line draws a dot. 
     * 
     * @param thePoint The point related to Pressed.
     * @return myNewLine The shape that line makes.
     */
    @Override
    public Shape getPressedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        myNewLine.setLine(myInitialPoint, myInitialPoint);
        return (Line2D.Double) myNewLine.clone();
    }
    
    /**
     * Return the shape when Dragged.
     * In this case line draws from pressed point to dragged point. 
     * 
     * @param thePoint The point related to Dragged.
     * @return myNewLine The shape that line makes.
     */
    @Override
    public Shape getDraggedShape(final Point thePoint) {
        
        myEndPoint = (Point) thePoint.clone();
        myNewLine.setLine(myInitialPoint, myEndPoint);
        return (Line2D.Double) myNewLine.clone();
    }
    
    /**
     * Return the shape when Released.
     * In this case line draws a line from pressed to released. 
     * 
     * @param thePoint The point related to Released.
     * @return myNewLine The shape that line makes.
     */
    @Override
    public Shape getReleasedShape(final Point thePoint) {
        
        myEndPoint = (Point) thePoint.clone();
        myNewLine.setLine(myInitialPoint, myEndPoint);
        return (Line2D.Double) myNewLine.clone();
    }

}
