/*
 * TCSS 305 - Assignment 5: PowerPaint 
 */
package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Represent JMenuBar for PowerPaint. 
 * 
 * @author vvien
 * @version 2.3
 */
public class PowerPaintMenuBar extends JMenuBar implements PropertyChangeListener {

    /**
     * The SerialVersionUID.
     */
    private static final long serialVersionUID = 7355267268391913302L;
    
    /**
     * The Max thickness.
     */
    private static final int MAX_THICKNESS = 20;
    
    /**
     * The initial starting thickness.
     */
    private static final int INITIAL_THICKNESS = 1;
    
    /**
     * The major tick spacing.
     */
    private static final int MAJOR_TICK_SPACING = 5;
    
    /**
     * The minor tick spacing. 
     */
    private static final int MINOR_TICK_SPACING = 1;

    /** 
     * A button group for radio buttons. 
     */
    private final ButtonGroup myRadioButtonGroup;
    
    /**
     * The main JFrame.
     */
    private final JFrame myFrame;
    
    /**
     * The toolMenu need to be a field to connect the tools button.
     */
    private final JMenu myToolMenu;
    
    /**
     * The Paint panel.
     */
    private final PowerPaintPanel myPanel;
    
    /**
     * The undo all button, needs to be up here for outside button access.
     */
    private final JMenuItem myUndoAllButton;
    
    /**
     * The undo, needs to be up here for outside button access.
     */
    private final JMenuItem myUndo;
    
    /**
     * The re-do, needs to be up here for outside button access.
     */
    private final JMenuItem myRedo;
    
    /**
     * The constructor for the MenuBar.
     * 
     * @param theFrame The main JFrame.
     * @param thePanel The Paint Panel. 
     */
    public PowerPaintMenuBar(final JFrame theFrame, final PowerPaintPanel thePanel) {
        
        super();
        myFrame = theFrame;
        myPanel = thePanel;
        myRadioButtonGroup = new ButtonGroup();
        myToolMenu = new JMenu("Tools");
        myUndoAllButton = new JMenuItem(createUndoAllAction());
        myUndo = new JMenuItem(createUndoAction());
        myRedo = new JMenuItem(createRedoAction());
        
        setUpBar();
    }
    
    /**
     * Set up the toolBar.
     */
    private void setUpBar() {
        
     // ------------ set up the File menu ----------------------- //
        final JMenu fileMenu = new JMenu("File");
        setJMenuMnemonic(fileMenu, 'f', KeyEvent.VK_F);
        fileMenu.add(myUndoAllButton);
        fileMenu.addSeparator();
        myUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        myUndo.setIcon(new ImageIcon("./images./undoicon.png"));
        fileMenu.add(myUndo);
        myRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        myRedo.setIcon(new ImageIcon("./images./redoicon.png"));
        fileMenu.add(myRedo);
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem(createExitAction()));
        add(fileMenu);
        
        
        // ------------ set up the Option menu ---------------------- //
        final JMenu optionMenu = new JMenu("Option");
        setJMenuMnemonic(optionMenu, 'o', KeyEvent.VK_O);
        optionMenu.add(createCheckBox());
        optionMenu.addSeparator();
        optionMenu.add(createThicknessButton());
        optionMenu.addSeparator();
        optionMenu.add(createColorButton());
        add(optionMenu);
        
        
        // ------------ set up the Tools menu ----------------------- //
        //Option menu already constructed in constructor. 
        setJMenuMnemonic(myToolMenu, 't', KeyEvent.VK_T);
        add(myToolMenu);
        
        
        // ------------ set up the Helps menu ----------------------- //
        final JMenu helpMenu = new JMenu("Help");
        setJMenuMnemonic(helpMenu, 'h', KeyEvent.VK_H);
        helpMenu.add(new JMenuItem(createAboutAction()));
        add(helpMenu);
        
    }
    
    /**
     * Private helper method to set mnemonic key for JMenu.
     * 
     * @param theMenu The JMenu.
     * @param theChar The character.
     * @param theKey The KeyEvent VK.
     */
    private void setJMenuMnemonic(final JMenu theMenu, final char theChar, final int theKey) {
        
        theMenu.setMnemonic(theChar);
        theMenu.setMnemonic(theKey);
    }
    
    /**
     * This method is to create the radio button for tools.
     * 
     * @param theAction The action connected to the button. 
     */
    public void createToolRadioButton(final Action theAction) {
        
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        //createdButton.setIcon(null);  // if i wanted empty icon on the top
        myRadioButtonGroup.add(createdButton);
        myToolMenu.add(createdButton);
    }
    
    /**
     * Create the JCheck Box Menu Item.
     * 
     * @return grid The JCheckBoxMenuItem.
     */
    private JCheckBoxMenuItem createCheckBox() {
        
        final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
        grid.addActionListener(new AbstractAction() {
            
            /** The SerialVersionUID */
            private static final long serialVersionUID = -6008220251827737096L;
            
            /**
             * Turn on grid or turn off. 
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.displayGrid();
                myPanel.repaint();
            }
        });
        grid.setMnemonic(KeyEvent.VK_G);
        return grid;
    }
    
    /**
     * Create the thickness button, with slider attached.
     * 
     * @return thickness The JMenu.
     */
    private JMenu createThicknessButton() {
        
        final JMenu thickness = new JMenu("Thickness");
        setJMenuMnemonic(thickness, 't', KeyEvent.VK_T);
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, MAX_THICKNESS,
                               INITIAL_THICKNESS);
        slider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /**
             * Changing the thickness of the drawings.
             * @param theEvent The changeEvent. 
             */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();
                myPanel.setMyWidth(value);
            }
        });
        thickness.add(slider);
        return thickness;
    }
    
    /**
     * Create the color selection action.
     * 
     * @return colorButton The color button.
     */
    private JMenuItem createColorButton() {
        
        final JMenuItem colorButton = new JMenuItem(new AbstractAction("Color...", 
                                                       new ColorIcon(Color.BLACK)) {
            /** The SerialVersionUID. */
            private static final long serialVersionUID = 4714223979813918232L;

            /**
             * Change the color. 
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color colorChosen = JColorChooser.showDialog(null, 
                                                             "JColorChooser", null);
                myPanel.setColor(colorChosen); //change panel color
                putValue(Action.SMALL_ICON, new ColorIcon(colorChosen));
                
            }
        });
        colorButton.setMnemonic(KeyEvent.VK_C);
        return colorButton;
    }
    
    
    /**
     * Private helper method to create the Exit Action.
     * 
     * @return Action The exit Action.
     */
    private Action createExitAction() {
    
        final Action exitAction = new AbstractAction("Exit") {
            /** The SerialVersionUID */
            private static final long serialVersionUID = 5971781995372335613L;
            
            /**
             * Exit the program.
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispatchEvent(new WindowEvent(myFrame,
                                                       WindowEvent.WINDOW_CLOSING));
            }
        };
        exitAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        return exitAction;
    }
    
    /**
     * This method is for propertyChange of the panel, to enable the undoAll Button. 
     * 
     * @param theEvent The event that happened. 
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        
        if ("Enable".equals(theEvent.getPropertyName())) {
            
            //Enable the undo all button. 
            myUndoAllButton.setEnabled(true);
            myUndo.setEnabled(true);
        } else if ("DisableRedo".equals(theEvent.getPropertyName())) {
            myRedo.setEnabled(false);
        } else {
            myUndoAllButton.setEnabled(false);
            myUndo.setEnabled(false);
        }
    }
    
    /**
     * Private helper method to create the Undo all Action.
     * 
     * @return Action The undo all Action.
     */
    private Action createUndoAllAction() {

        final Action undoAllAction = new AbstractAction("Undo All Changes") {

            /** The SerialVersionUID */
            private static final long serialVersionUID = -280670658272434959L;
            
            /**
             * The action to undo all action.
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.clearPanel();
                setEnabled(false);
            }
        };
        undoAllAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
        undoAllAction.setEnabled(false);
        return undoAllAction;
    }
    
    /**
     * Private helper method to create the Undo Action.
     * 
     * @return Action The undo Action.
     */
    private Action createUndoAction() {

        final Action undo = new AbstractAction("Undo") {

            /** The SerialVersionUID */
            private static final long serialVersionUID = 3120732775958314943L;
            
            /**
             * The action to undo action.
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.undoLast();
                if (myPanel.isClear()) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                } //if 
                myRedo.setEnabled(true);
            } //action performed
        };
        undo.setEnabled(false);
        return undo;
    }
    
    /**
     * Private helper method to create the re-do Action.
     * 
     * @return Action The re-do Action.
     */
    private Action createRedoAction() {

        final Action redo = new AbstractAction("Redo") {

            /** The SerialVersionUID */
            private static final long serialVersionUID = -2811783095205743807L;
            
            /**
             * The action to re-do action.
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.redoLast();
                if (myPanel.isUndoClear()) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                } //if 
            }
        };
        redo.setEnabled(false);
        return redo;
    }
    
    
    /**
     * Private helper method to create the About Action.
     * 
     * @return Action The about Action.
     */
    private Action createAboutAction() {

        final Action aboutAction = new AbstractAction("About...") {
            /** The SerialVerisonUID */
            private static final long serialVersionUID = 2175707911621823936L;
            /**
             * Pops up a message. 
             * @param theEvent The Action event.
             */
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                //Get imageIcon, set size in image, turn it back.
                ImageIcon imgIcon = new ImageIcon("./images./eye.png");
                final Image img = imgIcon.getImage();
                final Image newimg = img.getScaledInstance(40, 40, 
                                                           java.awt.Image.SCALE_SMOOTH);   
                imgIcon = new ImageIcon(newimg);  // transform it back
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint\nSpring 2015", 
                                              "About", JOptionPane.INFORMATION_MESSAGE, 
                                              imgIcon);
            }
        };
        aboutAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
        return aboutAction;
    }
}
