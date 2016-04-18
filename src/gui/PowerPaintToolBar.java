/*
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The toolBar for PowerPaint. 
 * 
 * @author vvien
 * @version 2.2
 */
public class PowerPaintToolBar extends JToolBar {
    
    /**
     * The generated serialVersionUID.
     */
    private static final long serialVersionUID = 625967673605728168L;
    
    /** 
     * A button group for the mutually exclusive tool bar buttons. 
     */ 
    private final ButtonGroup myGroup;
    
    /**
     * Constructor for PowerPaintJToolBar.
     */
    public PowerPaintToolBar() {
        
        super();
        myGroup = new ButtonGroup();
    }
    
    /**
     * Create a JToggleButton for the ToolBar.
     * For the tools available. 
     * 
     * @param theAction Action that relate to the button. 
     */
    public void createToolBarButton(final Action theAction) {
        
        final JToggleButton button = new JToggleButton(theAction);
        myGroup.add(button);
        add(button);
    }
}
