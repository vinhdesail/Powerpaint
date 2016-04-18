/*
 * TCSS 305 - Assignment 5: PowerPaint
 */
package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import tools.EllipseTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;



/**
 * The Main GUI of PowerPaint. 
 * 
 * @author vvien
 * @version 1.1
 */
public class PowerPaintGUI {
    
    /**
     * The main JFrame.
     */
    private final JFrame myFrame;
    
    /**
     * Constructor for PowerPaintGUI.
     */
    public PowerPaintGUI() {
        
        myFrame = new JFrame("PowerPaint");
        
        setUpTools();
        
        final ImageIcon img = new ImageIcon("./images./w.gif");
        myFrame.setIconImage(img.getImage());
        myFrame.pack();
    }
    
    /**
     * A helper method to set up the tools.
     */
    private void setUpTools() {
        
        final PowerPaintPanel drawPanel = new PowerPaintPanel();
        
        final List<ToolAction> toolAction = new ArrayList<>();
        toolAction.add(new ToolAction(new PencilTool(), drawPanel));
        toolAction.add(new ToolAction(new LineTool(), drawPanel));
        toolAction.add(new ToolAction(new RectangleTool(), drawPanel));
        toolAction.add(new ToolAction(new EllipseTool(), drawPanel));
        
        
        final PowerPaintToolBar toolBar = new PowerPaintToolBar();
        final PowerPaintMenuBar menuBar = new PowerPaintMenuBar(myFrame, drawPanel);
        
        drawPanel.addPropertyChangeListener(menuBar);
        
        for (final ToolAction tempToolAction : toolAction) {
            toolBar.createToolBarButton(tempToolAction);
            menuBar.createToolRadioButton(tempToolAction);
        }
        
        myFrame.add(drawPanel, BorderLayout.CENTER);
        myFrame.add(toolBar, BorderLayout.SOUTH);
        myFrame.setJMenuBar(menuBar);
    }
    
    /**
     * The start to the GUI.
     */
    public void start() {
        
        //End of the program, center and make visible.
        //Since constructor already start the program. 
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        
    }
    
   
} // end class
