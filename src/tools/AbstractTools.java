/*
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

import javax.swing.ImageIcon;



/**
 * The abstract tools for all the tools. 
 * 
 * @author vvien
 * @version 1.4
 */
public abstract class AbstractTools implements Tool {
    
    /**
     * The default point.
     */
    private static final Point DEFAULT_POINT = new Point(-50, -50);
    
    /**
     * The initial point.
     */
    protected Point myInitialPoint;
    
    /**
     * The end point.
     */
    protected Point myEndPoint;
    
    /**
     * The image of the objects.
     */
    private final ImageIcon myImage;
    
    /**
     * The description of the object.
     */
    private final String myDescription;
    
    /**
     * The mnemonic key attached.
     */
    private final int myMnemonic;
    
    /**
     * The box for the share code of rectangle and ellipse.
     */
    private RectangularShape myBox;
    
    
    /**
     * The constructor for this class.
     * It is protected for only the lower class to use.
     * 
     * @param theDescription The description of the object.
     * @param theImage The image of the object.
     * @param theMnemonic The mnemonic for the tools related. 
     */
    protected AbstractTools(final String theDescription, final ImageIcon theImage, 
                            final int theMnemonic) {
        
        super();
        myDescription = theDescription;
        myImage = theImage;
        myMnemonic = theMnemonic;
        // For default rectangle shape in cases methods were not override. 
        myBox = new Rectangle2D.Double();
    }
    
    /**
     * The setter to change the box.
     * 
     * @param theBox The rectangular shape passed up.
     */
    protected void setBox(final RectangularShape theBox) {
        
        myBox = (RectangularShape) theBox.clone();
    }
    
    /**
     * Return to name of the object.
     * 
     * @return String The description related to the object.
     */
    public String getDescription() {
        
        return myDescription;
    }
    
    /**
     * Return the relate image icon.
     * 
     * @return Image The Image related to the object.
     */
    public ImageIcon getImage() {
        
        return myImage;
    }
    
    /**
     * Return the related mnemonic.
     * 
     * @return myMnemonic The related mnemonic.
     */
    public int getMnemonic() {
        
        return myMnemonic;
    }
    
    /**
     * Return the shape when clicked.
     * Rectangle makes a dot.
     * Ellipse makes a shape but it is not visible.
     * 
     * @param thePoint The point related to the shape. 
     * @return myBox The shape when clicked. 
     */
    @Override
    public Shape getClickedShape(final Point thePoint) {
        
        // Reset the box. 
        myBox.setFrameFromDiagonal(DEFAULT_POINT, DEFAULT_POINT);
        myInitialPoint = (Point) thePoint.clone();
        myBox.setFrameFromDiagonal(myInitialPoint, myInitialPoint);
        return (Shape) myBox.clone();
    }
    
    /**
     * Return the shape when pressed.
     * In this case rectangle draws a dot. 
     * For ellipse it starts making a ellipse. 
     * 
     * @param thePoint The point related to Pressed.
     * @return myBox The shape that box makes.
     */
    @Override
    public Shape getPressedShape(final Point thePoint) {
        
        myInitialPoint = (Point) thePoint.clone();
        // Reset the box.
        myBox.setFrameFromDiagonal(DEFAULT_POINT, DEFAULT_POINT);
        myBox.setFrameFromDiagonal(myInitialPoint, myInitialPoint);
        return (Shape) myBox.clone();
    }
    
    /**
     * Return the shape when Dragged.
     * In this case rectangle draws a rectangle from Pressed to Dragged.
     * In this case ellipse draws a ellipse from Pressed to Dragged.
     * 
     * @param thePoint The point related to Dragged.
     * @return myBox The shape that box makes.
     */
    @Override
    public Shape getDraggedShape(final Point thePoint) {
        
        myEndPoint = (Point) thePoint.clone();
        myBox.setFrameFromDiagonal(myInitialPoint, myEndPoint);
        return (Shape) myBox.clone();
    }
    
    /**
     * Return the shape when Released.
     * In this case rectangle draws a rectangle from Pressed to Released. 
     * In this case ellipse draws a ellipse from Pressed to Released. 
     * 
     * @param thePoint The point related to Released.
     * @return myBox The shape that box makes.
     */
    @Override
    public Shape getReleasedShape(final Point thePoint) {
        
        myEndPoint = (Point) thePoint.clone();
        myBox.setFrameFromDiagonal(myInitialPoint, myEndPoint);
        return (Shape) myBox.clone();
    }

}
