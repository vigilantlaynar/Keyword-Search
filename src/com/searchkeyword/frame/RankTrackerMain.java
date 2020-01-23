/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.frame;

import com.searchkeyword.bean.CompanyProfileBean;
import com.searchkeyword.bean.RankTrackerBean;
import javax.swing.UIManager;

/**
 *
 * @author Euphern_Java
 */
public class RankTrackerMain {


private static RankTrackerBean rankTrackerBean;
private static CompanyProfileBean cpb;
     /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                RankTracker rankTracker=new RankTracker(rankTrackerBean);
               // new RankTracker().setVisible(true);
               // rankTrackerBean.setRankTracker(rankTracker);
               rankTracker.setVisible(true);
                new NewProject(rankTracker).setVisible(true);
                getCompanyProfilePreferences();
            }
        });
    }

        public static void getCompanyProfilePreferences() {
            cpb=new CompanyProfileBean();
        try{
            // Open the file that is the first
            // command line parameter
            java.io.FileInputStream fstream = new java.io.FileInputStream("companyProfileInformation.txt");
            // Get the object of DataInputStream
            java.io.DataInputStream in = new java.io.DataInputStream(fstream);
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
//                System.out.println (strLine);
                if(strLine.contains("Name")) {
                    cpb.setName(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Email")) {
                    cpb.setEmail(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Website")) {
                    cpb.setWebsite(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Address")) {
                    cpb.setAddress(strLine.substring(strLine.indexOf(" ")+1));
                }
                
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }


        
    }

}
