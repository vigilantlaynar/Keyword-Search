/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.common;


import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;


/**
 *
 * @author Euphern_Java
 */
public class CommonHelper {

    public static void setScreenInCenter(JFrame window)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    // Determine the new location of the window
    int w = window.getSize().width;
    int h = window.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;

    // Move the window
    window.setLocation(x, y);
    }


    public static void installCloseHandler(final JFrame f) {
// deactivate default handler
f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);

// now install your own
f.addWindowListener(new WindowAdapter() {
public void windowClosing(java.awt.event.WindowEvent e) {
int result = JOptionPane.showConfirmDialog(f,
"Are you sure you want to close the frame?");
if (result == JOptionPane.YES_OPTION) {
f.setVisible(false);
f.dispose();
}
}
});
}


    public static boolean checkURL(String url)
    {
        if (!url.matches("^http[s]?://[-a-zA-Z0-9_.:]+[-a-zA-Z0-9_:@&?=+,.!/~*'%$]*$"))
            return false;
        else
            return true;
    }

    public static void openHelpURL()
    {
         try{
            Desktop desktop=null;
            URI uri=new URI("http://google.com");
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if(desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
        } catch(Exception ex) {
            System.out.println("Exception "+ex);
        }
    }


    public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}



}
