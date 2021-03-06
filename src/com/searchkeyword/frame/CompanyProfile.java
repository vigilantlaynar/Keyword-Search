/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CompanyProfile.java
 *
 * Created on Jun 10, 2011, 5:16:20 PM
 */

package com.searchkeyword.frame;

import com.searchkeyword.bean.CompanyProfileBean;
import com.searchkeyword.bean.RankTrackerBean;
import com.searchkeyword.common.CommonHelper;
import com.searchkeyword.component.ImageFileView;
import com.searchkeyword.component.ImageFilter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author mayukh
 */
public class CompanyProfile extends javax.swing.JFrame {

     RankTrackerBean rankTrackerBean=new RankTrackerBean();

     CompanyProfileBean cpb=new CompanyProfileBean();
     

    /** Creates new form CompanyProfile */
    public CompanyProfile() {
        initComponents();
        this.setTitle("Edit RankTracker123 Preferences");
        CommonHelper.setScreenInCenter(this);
        CommonHelper.installCloseHandler(this);
        getCompanyProfilePreferences();
    }



    public CompanyProfile(RankTracker rankTracker) {
        initComponents();
        this.setTitle("Edit RankTracker123 Preferences");
        CommonHelper.setScreenInCenter(this);
        CommonHelper.installCloseHandler(this);
//        rankTrackerBean.setRankTracker(rankTracker);
//        if(rankTrackerBean!=null && rankTrackerBean.getWebsiteurl()!=null && !rankTrackerBean.getWebsiteurl().equals(""))
//        {
//            txtURL.setText(rankTrackerBean.getWebsiteurl());
//        }
    }



    public CompanyProfile(RankTrackerBean rankTBean) {
        initComponents();
        this.setTitle("Edit RankTracker123 Preferences");
        CommonHelper.setScreenInCenter(this);
        CommonHelper.installCloseHandler(this);
//        rankTrackerBean=rankTBean;
//        if(rankTrackerBean!=null && rankTrackerBean.getWebsiteurl()!=null && !rankTrackerBean.getWebsiteurl().equals(""))
//        {
//            txtURL.setText(rankTrackerBean.getWebsiteurl());
//        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        websiteTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/companyprofileMsg.PNG"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setText("Name :");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel3.setText("Email :");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel4.setText("Website :");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel6.setText("Logo :");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel5.setText("Address :");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton4.setFont(new java.awt.Font("Arial", 0, 11));
        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleSelectLogo(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addressTextField)
                        .addComponent(websiteTextField)
                        .addComponent(emailTextField)
                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(websiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Help");

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handlerOK(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCancel(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton3)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCancel
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_handleCancel

    private void handleSelectLogo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleSelectLogo
        // TODO add your handling code here:
        //Set up the file chooser.
        if (fc == null) {
            fc = new javax.swing.JFileChooser();

	    //Add a custom file filter and disable the default
	    //(Accept All) file filter.
            fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(false);

	    //Add custom icons for file types.
            fc.setFileView(new ImageFileView());

	    //Add the preview pane.
//            fc.setAccessory(new ImagePreview(fc));
        }

        //Show it.
        int returnVal = fc.showDialog(CompanyProfile.this, "Open");

        javax.swing.ImageIcon icon;
        //Process the results.
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            fileName = file.getName();
            fileExt = fileName.substring(fileName.indexOf(".")+1);
            try {
//                buffImage = javax.imageio.ImageIO.read(file);
                image = javax.imageio.ImageIO.read(file);
            } catch (java.io.IOException ex) {
                java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            if(image.getWidth(this)<=460 && image.getHeight(this)<=240) {
                icon=new javax.swing.ImageIcon(image);
            } else {
                icon=new javax.swing.ImageIcon(getScaledImage(image, 430, 240));
            }
            logoLabel.setIcon(icon);
        } 
        
        
        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);
    }//GEN-LAST:event_handleSelectLogo

    private void handlerOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handlerOK
        // TODO add your handling code here:
        saveCompanyProfilePreferences();

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
//                System.out.println(strLine);
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
                else if(strLine.contains("Logo")) {
                    fileName=strLine.substring(strLine.indexOf(" ")+1);
//                    fileExt = fileName.substring(fileName.indexOf(".")+1);
                }
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        this.setVisible(false);
    }//GEN-LAST:event_handlerOK

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
//        System.out.println("height::"+srcImg.getHeight(this)+" "+"width::"+srcImg.getWidth(this));
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);       
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    public void saveCompanyProfilePreferences() {
        try {
            java.io.Writer output = null;
            java.io.File file = new java.io.File("companyProfileInformation.txt");
            output = new java.io.BufferedWriter(new java.io.FileWriter(file));
            
            output.write("Name"+" "+nameTextField.getText()+"\n");
            output.write("Email"+" "+emailTextField.getText()+"\n");
            output.write("Website"+" "+websiteTextField.getText()+"\n");
            output.write("Address"+" "+addressTextField.getText()+"\n");
            output.write("Logo"+" "+fileName+"\n");
            if(fileName!=null) {
                javax.imageio.ImageIO.write(image, fileExt, new java.io.File(fileName));
            }
            
//            output.write(text);
            output.close();
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
    }

    public void getCompanyProfilePreferences() {
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
//                System.out.println(strLine);
                if(strLine.contains("Name")) {                    
                    nameTextField.setText(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Email")) {
                    emailTextField.setText(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Website")) {
                    websiteTextField.setText(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Address")) {
                    addressTextField.setText(strLine.substring(strLine.indexOf(" ")+1));
                }
                else if(strLine.contains("Logo")) {
                    fileName=strLine.substring(strLine.indexOf(" ")+1);
                    fileExt = fileName.substring(fileName.indexOf(".")+1);
                }
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

           
        javax.swing.ImageIcon icon;
        if(fileName!=null) {
        try {
            image = javax.imageio.ImageIO.read(new java.io.File(fileName));
        } catch (java.io.IOException ex) {
                java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if(image.getWidth(this)<=460 && image.getHeight(this)<=240) {
            icon=new javax.swing.ImageIcon(image);
        } else {
            icon=new javax.swing.ImageIcon(getScaledImage(image, 430, 240));
        }
        logoLabel.setIcon(icon);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField websiteTextField;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFileChooser fc;
    private java.awt.image.BufferedImage image;
//    private java.awt.image.BufferedImage buffImage = null;
    private String fileName=null;
    private String fileExt=null;
}
