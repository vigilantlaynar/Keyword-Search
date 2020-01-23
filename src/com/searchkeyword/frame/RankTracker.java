/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RankTracker.java
 *
 * Created on May 9, 2011, 12:45:24 PM
 */

package com.searchkeyword.frame;

import com.searchkeyword.bean.CompanyProfileBean;
import com.searchkeyword.bean.KeywordRank;
import com.searchkeyword.bean.Keywords;
import com.searchkeyword.bean.RankTrackerBean;
import com.searchkeyword.common.CommonHelper;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.event.HyperlinkEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Euphern_Java
 */
public class RankTracker extends javax.swing.JFrame {

    private RankTrackerBean rankTrackerBean;
    private CompanyProfileBean cpb;
    String fileName=null;
    /** Creates new form RankTracker */
    public RankTracker() {
        System.out.print("RT12 "+rankTrackerBean);
        initComponents();
        this.setBackground(new Color(236, 233, 216));
        this.setTitle("Rank Tracker123");
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        CommonHelper.installCloseHandler(this);
        pnlTabbed.setVisible(false);
    }

     public RankTracker(RankTrackerBean rankTBean) {
         System.out.print("RT "+rankTBean);
        initComponents();
        this.setTitle("Rank Tracker123");
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        CommonHelper.installCloseHandler(this);
        rankTrackerBean=rankTBean;
        if(rankTrackerBean!=null)
        {
        lblSiteURL.setText(rankTrackerBean.getWebsiteurl());
        List keywordList=rankTrackerBean.getKeywordList();
        String data[][] = {{},{},{}};
        String col[] = { "#", "Keyword", "Google Rank","Google.co.in Rank", "Tag"};
        DefaultTableModel model = new DefaultTableModel(data,col);

        for(int i=0;i<keywordList.size();i++)
        {
             Keywords keywords=(Keywords)keywordList.get(i);
             int rank=keywords.getRank();
             int localRank=keywords.getLocalrank();
             String keyRank=String.valueOf(rank);
             String localKeyRank=String.valueOf(localRank);
             if(rank==0)
             {
                 keyRank="Not in top 100";
             }
             if(localRank==0)
             {
                 localKeyRank="Not in top 100";
             }
             model.insertRow(i,new Object[]{keywords.getKeywordid(),keywords.getKeyword(),keyRank,localKeyRank,""});
        }
        tblKeywordResult.setModel(model);


        //code for getting the company information and
        // set those info in comapanyprofilebean

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


        javax.swing.ImageIcon icon;
        if(fileName!=null) {
        try {
            image = javax.imageio.ImageIO.read(new java.io.File(fileName));
        } catch (java.io.IOException ex) {
                java.util.logging.Logger.getLogger(CompanyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        icon=new javax.swing.ImageIcon(image);        
        
        logoLabel.setIcon(icon);
        }



        
        lblWebSiteName.setText(rankTrackerBean.getWebsiteurl());
        lblCurrentDate.setText(CommonHelper.getDate());
        jEditorPane1.setText("<html>This search engine rankings report has been created by"+
                " <a href=\""+cpb.getWebsite()+"\">"+cpb.getName()+"</a> for your personal information."+
                " It is tailored for your specific website and will give you detailed information on the"+
                " exact ranking positions of your targeted keyword phrases in google search engines for every"+
                " page within your website. All information was accurate at the time the report was generated.<br><br>"+
                "For further details please do not hesitate to <a href=\"mailto:"+cpb.getEmail()+"\">"+"contact us</a>.<br><br>Regards,<br><a href=\""+cpb.getWebsite()+"\">"+cpb.getName()+"</a> </html>");

        String data1[][] = {};
        String col1[] = { "Search Engine", "In Top 10", "In Top 20", "In Top 30", "In Top 100", "Visibility"};
        DefaultTableModel model1 = new DefaultTableModel(data1,col1);

        int keyWordinTop10=0;
        int keyWordinTop20=0;
        int keyWordinTop30=0;
        int keyWordinTop100=0;

        int keyWordinTop10_loc=0;
        int keyWordinTop20_loc=0;
        int keyWordinTop30_loc=0;
        int keyWordinTop100_loc=0;


        List keywordRankList=new ArrayList();
        for(int i=0;i<keywordList.size();i++)
        {
            KeywordRank keywordRank=new KeywordRank();
             Keywords keywords=(Keywords)keywordList.get(i);
             int rank=keywords.getRank();
             
             if(rank>0 && rank<=10) {
                keyWordinTop10++;
             }
             if(rank>0 && rank<=20) {
                keyWordinTop20++;
             }
             if(rank>0 && rank<=30) {
                keyWordinTop30++;
             }
             if(rank>0 && rank<=100) {
                keyWordinTop100++;
             }
             
             int localRank=keywords.getLocalrank();

             if(localRank>0 && localRank<=10) {
                keyWordinTop10_loc++;
             }
             if(localRank>0 && localRank<=20) {
                keyWordinTop20_loc++;
             }
             if(localRank>0 && localRank<=30) {
                keyWordinTop30_loc++;
             }
             if(localRank>0 && localRank<=100) {
                keyWordinTop100_loc++;
             }
             keywordRank.setKeyword(keywords.getKeyword());
             keywordRank.setInTop10(keyWordinTop10+keyWordinTop10_loc);
             keywordRank.setInTop20(keyWordinTop20+keyWordinTop20_loc);
             keywordRank.setInTop30(keyWordinTop30+keyWordinTop30_loc);
             keywordRank.setInTop100(keyWordinTop100+keyWordinTop100_loc);

             keywordRankList.add(keywordRank);

        }
        model1.insertRow(0,new Object[]{"Google.com",keyWordinTop10,keyWordinTop20,keyWordinTop30,keyWordinTop100,""});
        model1.insertRow(1,new Object[]{"Google.co.in",keyWordinTop10_loc,keyWordinTop20_loc,keyWordinTop30_loc,keyWordinTop100_loc,""});
        jTable3.setModel(model1);



        String data2[][] = {};
        String col2[] = { "Keyword", "In Top 10", "In Top 20", "In Top 30", "In Top 100", "Visibility"};
        DefaultTableModel model2 = new DefaultTableModel(data2,col2);

        for(int i=0;i<keywordRankList.size();i++) {
            KeywordRank keywordRank=(KeywordRank)keywordRankList.get(i);
            model2.insertRow(i,new Object[]{keywordRank.getKeyword(),keywordRank.getInTop10(),keywordRank.getInTop20(),keywordRank.getInTop30(),keywordRank.getInTop100(),""});
        }
        jTable2.setModel(model2);


        pnlTabbed.setVisible(true);
        mnuiSave.setEnabled(true);
        mnuiSaveAs.setEnabled(true);


         }

 else
        {
             pnlTabbed.setVisible(false);
        }
        
        

        

    }

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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlTabbed = new javax.swing.JTabbedPane();
        pnlKeyword = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnChkKeyword = new javax.swing.JButton();
        btnNewKeyword = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKeywordResult = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblSiteURL = new javax.swing.JLabel();
        pnlReport = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblSummary = new javax.swing.JLabel();
        lblSearchEngine = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        pnlSearchKeyword = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        pnlSerachEngine1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        logoPnl = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblWebSiteName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCurrentDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuiNew = new javax.swing.JMenuItem();
        mnuiOpen = new javax.swing.JMenuItem();
        mnuiSave = new javax.swing.JMenuItem();
        mnuiSaveAs = new javax.swing.JMenuItem();
        mnuiQuit = new javax.swing.JMenuItem();
        mnuTools = new javax.swing.JMenu();
        mnuiAddKeyword = new javax.swing.JMenuItem();
        mnuiRemoveKeyword = new javax.swing.JMenuItem();
        mnuiGetKeywordSuggestion = new javax.swing.JMenuItem();
        mnuPreferences = new javax.swing.JMenu();
        mnuiCompanyProfile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new1.jpg"))); // NOI18N
        btnNew.setToolTipText("New Project");
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBtnNewProject(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/open1.png"))); // NOI18N
        btnOpen.setToolTipText("Open Project");
        btnOpen.setFocusable(false);
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBtnOpenProject(evt);
            }
        });
        jToolBar1.add(btnOpen);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save1.png"))); // NOI18N
        btnSave.setToolTipText("Save Project");
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBtnSaveProject(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close1.png"))); // NOI18N
        btnClose.setToolTipText("Close Project");
        btnClose.setEnabled(false);
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBtnCloseProject(evt);
            }
        });
        jToolBar1.add(btnClose);

        pnlTabbed.setFont(new java.awt.Font("Tahoma", 1, 11));

        btnChkKeyword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chkRank.png"))); // NOI18N

        btnNewKeyword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addKeyword.png"))); // NOI18N
        btnNewKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleAddNewKeyword(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChkKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnChkKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblKeywordResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Keyword", "Google Rank", "Tags"
            }
        ));
        jScrollPane1.setViewportView(tblKeywordResult);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Site URL:  ");

        lblSiteURL.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(lblSiteURL))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSiteURL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlKeywordLayout = new javax.swing.GroupLayout(pnlKeyword);
        pnlKeyword.setLayout(pnlKeywordLayout);
        pnlKeywordLayout.setHorizontalGroup(
            pnlKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKeywordLayout.createSequentialGroup()
                .addGroup(pnlKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlKeywordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
                    .addGroup(pnlKeywordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlKeywordLayout.setVerticalGroup(
            pnlKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeywordLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnlTabbed.addTab("Keywords", pnlKeyword);

        pnlReport.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblSummary.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        lblSummary.setForeground(new java.awt.Color(0, 102, 204));
        lblSummary.setText("Summary");

        lblSearchEngine.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        lblSearchEngine.setForeground(new java.awt.Color(0, 102, 204));
        lblSearchEngine.setText("By Search Engine");

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 14));
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("By Keyword");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSummary)
                    .addComponent(lblSearchEngine)
                    .addComponent(jLabel7))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblSummary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSearchEngine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(4685, 570));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        pnlSearchKeyword.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18));
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Best ranked keywords :");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Keyword", "Rank", "Difference", "URL Found"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout pnlSearchKeywordLayout = new javax.swing.GroupLayout(pnlSearchKeyword);
        pnlSearchKeyword.setLayout(pnlSearchKeywordLayout);
        pnlSearchKeywordLayout.setHorizontalGroup(
            pnlSearchKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchKeywordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        pnlSearchKeywordLayout.setVerticalGroup(
            pnlSearchKeywordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchKeywordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jEditorPane1.setBorder(null);
        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.setFont(new java.awt.Font("Arial", 0, 13));
        jEditorPane1.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                jEditorPane1HyperlinkUpdate(evt);
            }
        });
        jScrollPane3.setViewportView(jEditorPane1);

        pnlSerachEngine1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Search Engine", "In Top 10", "In Top 20", "In Top 30", "In Top 100", "Visibility"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18));
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Serach engines overview :");

        javax.swing.GroupLayout pnlSerachEngine1Layout = new javax.swing.GroupLayout(pnlSerachEngine1);
        pnlSerachEngine1.setLayout(pnlSerachEngine1Layout);
        pnlSerachEngine1Layout.setHorizontalGroup(
            pnlSerachEngine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSerachEngine1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSerachEngine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(3995, Short.MAX_VALUE))
        );
        pnlSerachEngine1Layout.setVerticalGroup(
            pnlSerachEngine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSerachEngine1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSerachEngine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSearchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSerachEngine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSearchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1012, 1012, 1012))
        );

        jScrollPane2.setViewportView(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(3, 106, 166));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        logoPnl.setBackground(new java.awt.Color(255, 255, 255));

        logoLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout logoPnlLayout = new javax.swing.GroupLayout(logoPnl);
        logoPnl.setLayout(logoPnlLayout);
        logoPnlLayout.setHorizontalGroup(
            logoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoPnlLayout.setVerticalGroup(
            logoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(3, 106, 166));
        jPanel7.setPreferredSize(new java.awt.Dimension(696, 194));

        lblWebSiteName.setFont(new java.awt.Font("Arial Black", 1, 12));
        lblWebSiteName.setForeground(new java.awt.Color(255, 255, 255));
        lblWebSiteName.setText("jLabel4");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search Engine Ranking Report");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Report Created on:");

        lblCurrentDate.setFont(new java.awt.Font("Arial Black", 1, 11));
        lblCurrentDate.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentDate.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ranking data based on top 100 Result");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ranking diffrent based on the previous Result");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblWebSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(162, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addGap(367, 367, 367))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(317, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addGap(367, 367, 367))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addGap(367, 367, 367))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblWebSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCurrentDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlReportLayout = new javax.swing.GroupLayout(pnlReport);
        pnlReport.setLayout(pnlReportLayout);
        pnlReportLayout.setHorizontalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlReportLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlReportLayout.setVerticalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReportLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(552, 552, 552))
        );

        pnlTabbed.addTab("Report", pnlReport);

        mnuFile.setText("File");

        mnuiNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuiNew.setText("New Project");
        mnuiNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuNewProject(evt);
            }
        });
        mnuFile.add(mnuiNew);

        mnuiOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnuiOpen.setText("Open Existing Project");
        mnuiOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuOpenProject(evt);
            }
        });
        mnuFile.add(mnuiOpen);

        mnuiSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuiSave.setText("Save Project");
        mnuiSave.setEnabled(false);
        mnuiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuSaveProject(evt);
            }
        });
        mnuFile.add(mnuiSave);

        mnuiSaveAs.setText("Save Project As..");
        mnuiSaveAs.setEnabled(false);
        mnuiSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuSaveAsProject(evt);
            }
        });
        mnuFile.add(mnuiSaveAs);

        mnuiQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnuiQuit.setText("Quit Program");
        mnuiQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuQuitProject(evt);
            }
        });
        mnuFile.add(mnuiQuit);

        jMenuBar1.add(mnuFile);

        mnuTools.setText("Tools");

        mnuiAddKeyword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
        mnuiAddKeyword.setText("Add Keyword(s)");
        mnuiAddKeyword.setEnabled(false);
        mnuTools.add(mnuiAddKeyword);

        mnuiRemoveKeyword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mnuiRemoveKeyword.setText("Remove Keyword(s)");
        mnuiRemoveKeyword.setEnabled(false);
        mnuTools.add(mnuiRemoveKeyword);

        mnuiGetKeywordSuggestion.setText("Get Keyword Suggestions");
        mnuiGetKeywordSuggestion.setEnabled(false);
        mnuTools.add(mnuiGetKeywordSuggestion);

        jMenuBar1.add(mnuTools);

        mnuPreferences.setText("Preferences");

        mnuiCompanyProfile.setText("Company Profile");
        mnuiCompanyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMnuCompanyProfile(evt);
            }
        });
        mnuPreferences.add(mnuiCompanyProfile);

        jMenuBar1.add(mnuPreferences);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleMnuNewProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuNewProject
        // TODO add your handling code here:
        createNewProject();
    }//GEN-LAST:event_handleMnuNewProject

    private void handleMnuOpenProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuOpenProject
        // TODO add your handling code here:
        openProject();
    }//GEN-LAST:event_handleMnuOpenProject

    private void handleMnuSaveProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuSaveProject
        // TODO add your handling code here:
        saveProject();
    }//GEN-LAST:event_handleMnuSaveProject

    private void handleMnuSaveAsProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuSaveAsProject
        // TODO add your handling code here:
        saveAsProject();
    }//GEN-LAST:event_handleMnuSaveAsProject

    private void handleMnuQuitProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuQuitProject
        // TODO add your handling code here:

       int i= JOptionPane.showConfirmDialog(rootPane, "Are you realy want to close the application?", "Close Application", WIDTH);
      // System.out.print(i);
       if(i==0)
       {
       // this.setVisible(false);
       // this.dispose();
        System.exit(0);
        }

    }//GEN-LAST:event_handleMnuQuitProject

    private void handleBtnNewProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleBtnNewProject
        // TODO add your handling code here:
        createNewProject();
    }//GEN-LAST:event_handleBtnNewProject

    private void handleBtnSaveProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleBtnSaveProject
        // TODO add your handling code here:
         saveProject();
    }//GEN-LAST:event_handleBtnSaveProject

    private void handleBtnOpenProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleBtnOpenProject
        // TODO add your handling code here:
         openProject();
    }//GEN-LAST:event_handleBtnOpenProject

    private void handleBtnCloseProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleBtnCloseProject
        // TODO add your handling code here:
        closeProject();
    }//GEN-LAST:event_handleBtnCloseProject

    private void handleAddNewKeyword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleAddNewKeyword
        // TODO add your handling code here:

        EnterKeyWord enterKeyWord=new EnterKeyWord(getRankTrackerBean());
        enterKeyWord.setVisible(true);
    }//GEN-LAST:event_handleAddNewKeyword

    private void jEditorPane1HyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_jEditorPane1HyperlinkUpdate
        // TODO add your handling code here:

        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(evt.getURL().toURI());
                } catch (Exception e1) {
                    System.out.println("exception:::"+e1);
                }
            }
    }//GEN-LAST:event_jEditorPane1HyperlinkUpdate

    private void handleMnuCompanyProfile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMnuCompanyProfile
        // TODO add your handling code here:        
        openCompanyProfile();
    }//GEN-LAST:event_handleMnuCompanyProfile



    private void createNewProject()
    {
         NewProject np=new NewProject();
        np.setVisible(true);
    }

    private void openCompanyProfile()
    {
         CompanyProfile cp=new CompanyProfile();
        cp.setVisible(true);
    }

    private void openProject()
    {
        //NewProject np=new NewProject();
        //np.setVisible(true);
        JOptionPane.showMessageDialog(rootPane, "Your Version of Rank Tracker is based on a Free License.", "Please Upgrade Your License! ", WIDTH, null);
    }

    private void saveProject()
    {
        // NewProject np=new NewProject();
       // np.setVisible(true);
        JOptionPane.showMessageDialog(rootPane, "Your Version of Rank Tracker is based on a Free License.", "Please Upgrade Your License! ", WIDTH, null);
    }

    private void saveAsProject()
    {
        // NewProject np=new NewProject();
       // np.setVisible(true);
        JOptionPane.showMessageDialog(rootPane, "Your Version of Rank Tracker is based on a Free License.", "Please Upgrade Your License! ", WIDTH, null);
    }

    private void closeProject()
    {
        // NewProject np=new NewProject();
        //np.setVisible(true);
    }


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new RankTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChkKeyword;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNewKeyword;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCurrentDate;
    private javax.swing.JLabel lblSearchEngine;
    private javax.swing.JLabel lblSiteURL;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JLabel lblWebSiteName;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel logoPnl;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuPreferences;
    private javax.swing.JMenu mnuTools;
    private javax.swing.JMenuItem mnuiAddKeyword;
    private javax.swing.JMenuItem mnuiCompanyProfile;
    private javax.swing.JMenuItem mnuiGetKeywordSuggestion;
    private javax.swing.JMenuItem mnuiNew;
    private javax.swing.JMenuItem mnuiOpen;
    private javax.swing.JMenuItem mnuiQuit;
    private javax.swing.JMenuItem mnuiRemoveKeyword;
    private javax.swing.JMenuItem mnuiSave;
    private javax.swing.JMenuItem mnuiSaveAs;
    private javax.swing.JPanel pnlKeyword;
    private javax.swing.JPanel pnlReport;
    private javax.swing.JPanel pnlSearchKeyword;
    private javax.swing.JPanel pnlSerachEngine1;
    private javax.swing.JTabbedPane pnlTabbed;
    private javax.swing.JTable tblKeywordResult;
    // End of variables declaration//GEN-END:variables
    private java.awt.image.BufferedImage image;
    /**
     * @return the rankTrackerBean
     */
    public RankTrackerBean getRankTrackerBean() {
        return rankTrackerBean;
    }

    /**
     * @param rankTrackerBean the rankTrackerBean to set
     */
    public void setRankTrackerBean(RankTrackerBean rankTrackerBean) {
        this.rankTrackerBean = rankTrackerBean;
    }




    



}
