package com.smash.Transfertron5000;

import javax.swing.JTextPane;

//Solution for no wrap text pane.
// http://tips4java.wordpress.com/2009/01/25/no-wrap-text-pane/
// http://stackoverflow.com/q/20713631/1690799
public class JTextPanePlus extends JTextPane {

    private static final long serialVersionUID = -6995797924751310710L;
    
    @Override
    public boolean getScrollableTracksViewportWidth() {
        
        return getUI().getPreferredSize(this).width 
            <= getParent().getSize().width;
        
    }

}
