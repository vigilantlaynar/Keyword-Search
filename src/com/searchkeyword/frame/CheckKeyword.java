/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CheckKeyword.java
 *
 * Created on May 9, 2011, 6:09:24 PM
 */

package com.searchkeyword.frame;

import com.searchkeyword.bean.Keywords;
import com.searchkeyword.bean.RankTrackerBean;
import com.searchkeyword.common.CommonHelper;
import com.searchkeyword.test.PageRankService;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import java.util.List;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Euphern_Java
 */
public class CheckKeyword extends javax.swing.JFrame implements ActionListener{

    private RankTrackerBean rankTrackerBean;



    public final static int ONE_SECOND = 1000;

 // private JProgressBar progressBar;

  private Timer timer;

  //private JButton startButton;

  private LongTask task;

 // private JTextArea taskOutput;

  //private String newline = "\n";

  private int actualRank=0;

    /** Creates new form CheckKeyword */
    public CheckKeyword() {
        initComponents();
        prgMain.setMinimum( 0 );
	prgMain.setMaximum( 300 );
	prgMain.setValue( 0 );
         task = new LongTask();

        // checkURL("http://euphern.com");

//         int rank=getKeywordRank("euphern","www.google.com");

         List keywordList=new ArrayList();
         keywordList.add("euphern");
         keywordList.add("image");
           changePrgStatus(false);
         if(keywordList!=null && keywordList.size()>0)
         {
             int noOfKeyword=keywordList.size();

             for(int i=0;i<noOfKeyword;i++)
             {
                  pnlPrg.add(new JButton("Button"));
                  pnlPrg.getComponent(0).setName("btn1");
                  pnlPrg.getComponent(0).setVisible(true);
                //  System.out.println(pnlPrg.getComponent(0).getName());
                  pnlPrg.revalidate();
                  validate();
             }

             /*
             int i=0;
             JProgressBar prg=new JProgressBar();

             if(noOfKeyword>=1)
             {
                 prg1.setVisible(true);
             }

             if(noOfKeyword>=2)
             {
                 prg2.setVisible(true);
             }

             if(noOfKeyword>=3)
             {
                 prg3.setVisible(true);
             }

             if(noOfKeyword>=4)
             {
                 prg4.setVisible(true);
             }

             if(noOfKeyword>=5)
             {
                 prg5.setVisible(true);
             }

             if(noOfKeyword>=6)
             {
                 prg6.setVisible(true);
             }
*/




         }

    /*
        super(new BorderLayout());
    task = new LongTask();

    //Create the demo's UI.
    startButton = new JButton("Start");
    startButton.setActionCommand("start");
    startButton.addActionListener(this);

    progressBar = new JProgressBar(0, task.getLengthOfTask());
    progressBar.setValue(0);

    //We call setStringPainted, even though we don't want the
    //string to show up until we switch to determinate mode,
    //so that the progress bar height stays the same whether
    //or not the string is shown.
    progressBar.setStringPainted(true); //get space for the string
    progressBar.setString(""); //but don't paint it

    taskOutput = new JTextArea(5, 20);
    taskOutput.setMargin(new Insets(5, 5, 5, 5));
    taskOutput.setEditable(false);

    JPanel panel = new JPanel();
    panel.add(startButton);
    panel.add(progressBar);

    add(panel, BorderLayout.PAGE_START);
    add(new JScrollPane(taskOutput), BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
*/
    //Create a timer.
    timer = new Timer(ONE_SECOND, new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        prgMain.setValue(task.getCurrent());
        String s = task.getMessage();
        if (s != null) {
          if (prgMain.isIndeterminate()) {
            prgMain.setIndeterminate(false);
            prg1.setIndeterminate(false);
            prg1.setVisible(false);
           //  prg2.setIndeterminate(true);
            prgMain.setString(null); //display % string           
          }
           else if (prg2.isIndeterminate()) {
            prg2.setIndeterminate(false);
            prg2.setVisible(false);
            // prg3.setIndeterminate(true);
          }
          else if (prg3.isIndeterminate()) {
            prg3.setIndeterminate(false);
            prg3.setVisible(false);
            // prg4.setIndeterminate(true);
          }
          else if (prg4.isIndeterminate()) {
            prg4.setIndeterminate(false);
            prg4.setVisible(false);
           //  prg6.setIndeterminate(true);
          }
          else if (prg5.isIndeterminate()) {
            prg5.setIndeterminate(false);
            prg5.setVisible(false);
           //  prg6.setIndeterminate(true);
          }
          else if (prg6.isIndeterminate()) {
            prg6.setIndeterminate(false);
            prg6.setVisible(false);
             //prg3.setIndeterminate(true);
          }

        //   System.out.print("test "+ task.getCurrent());
         // taskOutput.append(s + newline);
         // taskOutput.setCaretPosition(taskOutput.getDocument()
         //     .getLength());
        }
        if (prgMain.getValue()==300) {
          //   System.out.print("test12");
          Toolkit.getDefaultToolkit().beep();
          timer.stop();
          changePrgStatus(false);
          btnAction.setEnabled(true);
          prgMain.setValue(prgMain.getMinimum());
          prgMain.setString(""); //hide % string
        }
      }
    });

      
    }




    /*
     *
     * Function Chenge Progress bar Status
     */

    private void changePrgStatus(boolean  status)
    {

          prg1.setIndeterminate(status);
          prg2.setIndeterminate(status);
          prg3.setIndeterminate(status);
          prg4.setIndeterminate(status);
          prg5.setIndeterminate(status);
          prg6.setIndeterminate(status);
          prg1.setVisible(status);
          prg2.setVisible(status);
          prg3.setVisible(status);
          prg4.setVisible(status);
          prg5.setVisible(status);
          prg6.setVisible(status);

    }




    public void actionPerformed(ActionEvent evt) {
    prgMain.setIndeterminate(true);
    btnAction.setEnabled(false);
    task.go();
    timer.start();
  }

    public CheckKeyword(RankTrackerBean rankTBean) {
        initComponents();
        this.setTitle("Check Keyword");
        CommonHelper.setScreenInCenter(this);
        CommonHelper.installCloseHandler(this);
        prgMain.setMinimum( 0 );
	prgMain.setMaximum( 300 );
	prgMain.setValue( 0 );
        rankTrackerBean=rankTBean;

        task = new LongTask();

     
 final long startTime = System.currentTimeMillis();
        //Create a timer.
    timer = new Timer(ONE_SECOND, new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          
        prgMain.setValue(task.getCurrent());
        String s = task.getMessage();
        if (s != null) {
          if (prgMain.isIndeterminate()) {
            prgMain.setIndeterminate(false);
            prg6.setIndeterminate(false);
            prg6.setVisible(false);
           //  prg2.setIndeterminate(true);
            prgMain.setString(null); //display % string
          }
           else if (prg5.isIndeterminate()) {
            prg5.setIndeterminate(false);
            prg5.setVisible(false);
            // prg3.setIndeterminate(true);
          }
          else if (prg4.isIndeterminate()) {
            prg4.setIndeterminate(false);
            prg4.setVisible(false);
            // prg4.setIndeterminate(true);
          }
          else if (prg3.isIndeterminate()) {
            prg3.setIndeterminate(false);
            prg3.setVisible(false);
           //  prg6.setIndeterminate(true);
          }
          else if (prg2.isIndeterminate()) {
            prg2.setIndeterminate(false);
            prg2.setVisible(false);
           //  prg6.setIndeterminate(true);
          }
          else if (prg1.isIndeterminate()) {
            prg1.setIndeterminate(false);
            prg1.setVisible(false);
             //prg3.setIndeterminate(true);
          }

        //   System.out.print("test "+ task.getCurrent());
         // taskOutput.append(s + newline);
         // taskOutput.setCaretPosition(taskOutput.getDocument()
         //     .getLength());
        }
        if (prgMain.getValue()==300) {
          //   System.out.print("test12");
          Toolkit.getDefaultToolkit().beep();
          timer.stop();
          changePrgStatus(false);
          btnAction.setEnabled(true);
          prgMain.setValue(prgMain.getMinimum());
          prgMain.setString(""); //hide % string
          long endTime = System.currentTimeMillis();
          long totaltime=endTime-startTime;
          // System.out.println(totaltime);
         // double timeelapsed=totaltime/600;
          // System.out.println(timeelapsed);
          DecimalFormat df = new DecimalFormat("#.##");
          String timeelapsed=df.format(totaltime/600);
          if(timeelapsed.length()==1)
          {
              timeelapsed="0:"+timeelapsed+"0";
          }
          else if(timeelapsed.length()==2)
          {
              timeelapsed="0:"+timeelapsed;
          }
         // System.out.println(timeelapsed);
          rankTrackerBean.setTimeelapsed(String.valueOf(timeelapsed));
           SearchResult searchResult=new SearchResult(rankTrackerBean);
            searchResult.setVisible(true);
            setVisible(false);
        }
      }
    });


        changePrgStatus(true);
        btnAction.setEnabled(false);
        task.go();
        timer.start();

        List keywordList=rankTrackerBean.getKeywordList();
        String domain=rankTrackerBean.getWebsiteurl();
        
        List countryList=new ArrayList();
        countryList.add(null);       // creating and setting countryList with null and Denmark value
        countryList.add("in");
        
           for(int j=0;j<keywordList.size();j++)
           {
               Keywords keywords=(Keywords)keywordList.get(j);
               for(int i=0;i<countryList.size();i++) {
                   String countrycode=(String)countryList.get(i);
                   int rank=getKeywordRank(keywords.getKeyword(),domain,countrycode);
                   if(countrycode!=null){
                       keywords.setLocalrank(rank);
                   }
                   else{
                       keywords.setRank(rank);
                   }
                   
               }
            }
        
        
       /* List keywordList1=rankTrackerBean.getKeywordList();
           for(int j=0;j<keywordList1.size();j++)
           {
               Keywords keywords=(Keywords)keywordList1.get(j);
               System.out.println("Keywords "+keywords.getKeyword());
               System.out.println("Rank "+keywords.getRank());
           }
*/
       


        /*checkPR(rankTrackerBean.getWebsiteurl());
        List keywordList=rankTrackerBean.getKeywordList();
        for(int i=0;i<keywordList.size();i++)
        {

                JProgressBar progressBar = new JProgressBar();
                progressBar.setValue(25);
                progressBar.setStringPainted(true);
                Border border = BorderFactory.createTitledBorder("Reading...");
                progressBar.setBorder(border);
                pnlPrg.add(progressBar, BorderLayout.SOUTH);

                


//
//            JProgressBar prg=new JProgressBar();
//             prg.setMinimum( 0 );
//             prg.setMaximum( 200 );
//             prg.setValue( 0 );
//             prg.setVisible(true);
//             jPanel3.add(prg);
        }*/
    }


    private void checkPR(String domain)
    {
       // String [] args=null;
         long start = System.currentTimeMillis();
        PageRankService prService = new PageRankService();
        //String domain = "http://www.gmail.com";
//        if (args.length > 0) {
//            domain = args[0];
//        }
        uploadProgress("test");
        System.out.println("Checking " + domain);
        System.out.println("Google PageRank: " + prService.getPR(domain));
        System.out.println("Took: " + (System.currentTimeMillis() - start) + "ms");
    }


    public void uploadProgress(String filename)
{
for( int iCtr = 1; iCtr < 201; iCtr++ )
			{
				// Do some sort of simulated task
				DoBogusTask( iCtr );
                                   //System.out.print("I "+iCtr);
                                  // if(iCtr==50)
                                  // {
                                       uploadProgress2("Test",prg1);
                                 //  }
                                  // else if(iCtr==100)
                                  // {
                                       uploadProgress2("Test",prg2);
                                 //  }
                                  // else if(iCtr==150)
                                 //  {
                                      // uploadProgress2("Test",lblKeyword2,prgThree);
                                  // }
				// Update the progress indicator and label
				/*lblKeyword.setText(filename);
				Rectangle labelRect = lblKeyword.getBounds();
				labelRect.x = 0;
				labelRect.y = 0;
				lblKeyword.paintImmediately( labelRect );
*/
				prgMain.setValue( iCtr );
				Rectangle progressRect = prgMain.getBounds();
				progressRect.x = 0;
				progressRect.y = 0;
				prgMain.paintImmediately( progressRect );
			}
}



    public void uploadProgress2(String filename,JProgressBar prg)
{
for( int iCtr = 1; iCtr < 21; iCtr++ )
			{
				// Do some sort of simulated task
				DoBogusTask( iCtr );
				// Update the progress indicator and label
//				lbl.setText(filename);
//				Rectangle labelRect = lbl.getBounds();
//				labelRect.x = 0;
//				labelRect.y = 0;
//				lbl.paintImmediately( labelRect );

				prg.setValue( iCtr );
				Rectangle progressRect = prg.getBounds();
				progressRect.x = 0;
				progressRect.y = 0;
				prg.paintImmediately( progressRect );
			}
}

public void DoBogusTask( int iCtr )
	{
		Random random = new Random( iCtr );

		// Waste some time
		for( int iValue = 0; iValue < random.nextFloat() * 100000; iValue++ )
		{
			//System.out.println("hi   "+iValue);
		}
	}



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnFinish = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        prgMain = new javax.swing.JProgressBar();
        btnAction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrg = new javax.swing.JPanel();
        prg1 = new javax.swing.JProgressBar();
        prg2 = new javax.swing.JProgressBar();
        prg3 = new javax.swing.JProgressBar();
        prg4 = new javax.swing.JProgressBar();
        prg5 = new javax.swing.JProgressBar();
        prg6 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleFinish(evt);
            }
        });

        btnNext.setText("Next >>");
        btnNext.setEnabled(false);

        btnBack.setText("<< Back");
        btnBack.setEnabled(false);

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelphandleHelp(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelhandleCancel(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHelp)
                    .addComponent(btnBack)
                    .addComponent(btnNext)
                    .addComponent(btnFinish)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAction.setText("Start");
        btnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleStart(evt);
            }
        });

        prg1.setMaximum(20);

        prg2.setMaximum(20);

        javax.swing.GroupLayout pnlPrgLayout = new javax.swing.GroupLayout(pnlPrg);
        pnlPrg.setLayout(pnlPrgLayout);
        pnlPrgLayout.setHorizontalGroup(
            pnlPrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prg6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prg5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(566, Short.MAX_VALUE))
        );
        pnlPrgLayout.setVerticalGroup(
            pnlPrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prg6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prg5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlPrg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(prgMain, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prgMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAction))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchKeywordMsg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleStart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleStart
        // TODO add your handling code here:
        // uploadProgress("test");
       //  btnAction.setText("Stop");

//        prgMain.setIndeterminate(true);
//        prg1.setIndeterminate(true);
//        prg2.setIndeterminate(true);
//        prg3.setIndeterminate(true);
//        prg4.setIndeterminate(true);
//        prg5.setIndeterminate(true);
//        prg6.setIndeterminate(true);

        changePrgStatus(true);
        btnAction.setEnabled(false);
        task.go();
        timer.start();
    }//GEN-LAST:event_handleStart

    private void handleFinish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleFinish
        // TODO add your handling code here:

        SearchResult sr=new SearchResult(rankTrackerBean);
        sr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_handleFinish

    private void btnHelphandleHelp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelphandleHelp
        // TODO add your handling code here:
       CommonHelper.openHelpURL();
}//GEN-LAST:event_btnHelphandleHelp

    private void btnCancelhandleCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelhandleCancel
        // TODO add your handling code here:
        this.setVisible(false);
}//GEN-LAST:event_btnCancelhandleCancel




    private static void createAndShowGUI() {

      new CheckKeyword().setVisible(true);
       
    //Make sure we have nice window decorations.
//    JFrame.setDefaultLookAndFeelDecorated(true);
//
//    //Create and set up the window.
//    JFrame frame = new JFrame("ProgressBarDemo2");
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    //Create and set up the content pane.
//    JComponent newContentPane = new ProgressBarDemo2();
//    newContentPane.setOpaque(true); //content panes must be opaque
//    frame.setContentPane(newContentPane);
//
//    //Display the window.
//    frame.pack();
//    frame.setVisible(true);
  }





/*
 *
 * Function To get All related URL List By a single URL
 */




    private int getKeywordRank(String keyword,String domain,String countrycode)
    {
         int rank=0;
         if(keyword!=null && domain!=null && !keyword.equals("") && !domain.equals(""))
         {
       // System.out.println("keyword  "+keyword);
        String newkeyword=keyword.replaceAll(" ", "_");
       //  System.out.println("keyword  "+keyword);
         String domainName=getdomainName(domain);
        //  System.out.println("domainName  "+domainName);
        boolean pagest=false;
         if(domainName!=null && !domainName.equals("") && domainName.toUpperCase().equals(keyword.toUpperCase()))
         {
              String pagecontent=WebPageStatus.getPageContent(domain);
              String[] strTitle1=pagecontent.split("<title>");
               String[] strTitle2=strTitle1[1].split("</title>");
               String title=strTitle2[0];
               System.out.print("title  "+title);
                System.out.print("keyword  "+keyword);
              //System.out.print("pagecontent  "+pagecontent);
                String s1=title.toUpperCase().trim();
                String s2=keyword.toUpperCase().trim();
              if(s1.equals(s2))
              {
                 rank=1;
//                  rank=actualRank;
                 pagest=true;
              }
         }

             else if(domainName != null && !domainName.equals(""))
         {
       
        String str="\\[";
        String googleBaseUrl=null;
        if(countrycode!=null) {
            googleBaseUrl="http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q="+newkeyword+"&hl=en&safe=off&start=0&rsz=8&sa=N&gl="+countrycode+"";
        } else {
            googleBaseUrl="http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q="+newkeyword+"&hl=en&safe=off&start=0&rsz=8&sa=N";
        }
        
         String pagecontent=WebPageStatus.getPageContent(googleBaseUrl);
         //System.out.println("Page Content  "+pagecontent);

         String[] resultArray1=pagecontent.split("\\[");
        // System.out.println("Page Content2  "+resultArray1[1]);

         String[] resultArray2=resultArray1[1].split("\\]");
       //  System.out.println("Page Content3  "+resultArray2[0]);
         if(resultArray2[0].toUpperCase().indexOf(domainName.toUpperCase())>0)
         {
         String result1=resultArray2[0].replaceAll("\\{", "");
        // System.out.println("result  "+result1);
         String[] result2=result1.split("\\},");
        // System.out.println("result2  "+result2[0]);


         boolean status=false;
         for(int i=0;i<result2.length;i++)
         {
                actualRank++;
              String[] result_T3=result2[i].split("title");
              if(result_T3.length>1)
              {
            // System.out.println("result_T3  "+result_T3[1]);
             String[] result_T4=result_T3[1].split(",");
             if(result_T4.length>0)
             {
             // System.out.println("result_T4  "+result_T4[0]);
              String chkResult=result_T4[0].toUpperCase();
              int indx_T=chkResult.indexOf(keyword.toUpperCase());
             // System.out.println("Indx "+indx_T);
              if(indx_T>0)
              {

             String[] result3=result2[i].split("visibleUrl");
             if(result3.length>1)
             {
            // System.out.println("result3  "+result3[1]);
             String[] result4=result3[1].split(",");
             if(result4.length>0)
             {
             // System.out.println("result4  "+result4[0]);
              String linkedUrl=result4[0].toUpperCase();
            //  System.out.println("linkedUrl  "+linkedUrl);
             // if(domain.indexOf("http")>0)
             // {
              String chekdomain=domain.replaceAll("http://", "");
              chekdomain=chekdomain.replaceAll("www", "");
            //  System.out.println("chekdomain  "+chekdomain);
               int indx1=linkedUrl.indexOf(chekdomain.toUpperCase());
              //System.out.println("Indx "+indx);
              if(indx1>0)
              {
                  rank=1;
//                  rank=actualRank;
                  status=true;
                  break;
              }


              int indx=result4[0].indexOf(".com");
              //System.out.println("Indx "+indx);
              if(indx>0)
              {
                  rank++;
              }
                  }
                // }

                  }
             }
             }
             }

             
         }

          if(!status)
              {
                rank=(10-rank)*3;
              }

         
        }
        }
        }

         // System.out.println("Rank "+rank);
          return rank;
    }






    public String getdomainName(String websiteURL)
        {
            String domainName=null;
            //websiteURL="http://euphern.com";
            //System.out.println("websiteURL  "+websiteURL);
            if(websiteURL!=null && !websiteURL.equals(""))
            {
            if(websiteURL.toUpperCase().indexOf("www".toUpperCase())>0)
            {
                 String[] str=websiteURL.split("\\.");
                 if(str.length>1)
                 domainName=str[1];
            }
            else{
                 String[] str1=websiteURL.split("/");
                  if(str1.length>1)
                  {
                     // System.out.println("str1[2] "+str1[2]);
                    String[] str2=str1[2].split("\\.");
                      if(str2.length>1)
                         domainName=str2[0];
                  }

            }
            }

            return domainName;
        }




    private void checkURL(String websiteurl)
    {

        String pagecontent=WebPageStatus.getPageContent(websiteurl);
			List urllinkList=WebPageStatus.getLink(pagecontent);
			List webpageUrlList=new ArrayList();

			if(urllinkList!=null && urllinkList.size()>0)
			{

				for(int i=0;i<urllinkList.size();i++)
				{
					WebSitePageLink pageLink=new WebSitePageLink();
					pageLink.setPageid(i);
					String pageurl=String.valueOf(urllinkList.get(i));
					if(pageurl.indexOf("http://") != -1)
					pageLink.setPageurl(pageurl);
					else
					{
                                            pageLink.setPageurl(websiteurl+"/"+pageurl);
                                            pageLink.setPagetitle(pageurl.substring(0, pageurl.length()-5).toUpperCase());
					}
					//String pagecontent2=WebPageStatus.getPageContent(String.valueOf(urllinkList.get(i)));
					//String pagetitle=WebPageStatus.getPageTitle(pagecontent2);
					//pageLink.setPagetitle(pagetitle);

					webpageUrlList.add(pageLink);

					//System.out.println("Link "+urllinkList.get(i));
				}
			}
			else
			{
				WebSitePageLink pageLink=new WebSitePageLink();
				pageLink.setPageid(1);
				pageLink.setPageurl("No Page Link Found");
				webpageUrlList.add(pageLink);
			}

                        if(webpageUrlList!=null && webpageUrlList.size()>0)
                        {
                            for(int i=0;i<webpageUrlList.size();i++)
                            {
                                WebSitePageLink pageLink=(WebSitePageLink)webpageUrlList.get(i);
                                System.out.println("URL "+pageLink.getPageurl());
                                System.out.println("Title  "+pageLink.getPagetitle());
                            }
                        }

    }







    /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CheckKeyword().setVisible(true);
//            }
//        });

       javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrg;
    private javax.swing.JProgressBar prg1;
    private javax.swing.JProgressBar prg2;
    private javax.swing.JProgressBar prg3;
    private javax.swing.JProgressBar prg4;
    private javax.swing.JProgressBar prg5;
    private javax.swing.JProgressBar prg6;
    private javax.swing.JProgressBar prgMain;
    // End of variables declaration//GEN-END:variables

}





/*
 * Code for Grnerate and run the progress bar
 */



abstract class SwingWorker {
  private Object value; // see getValue(), setValue()

  /**
   * Class to maintain reference to current worker thread under separate
   * synchronization control.
   */
  private static class ThreadVar {
    private Thread thread;

    ThreadVar(Thread t) {
      thread = t;
    }

    synchronized Thread get() {
      return thread;
    }

    synchronized void clear() {
      thread = null;
    }
  }

  private ThreadVar threadVar;

  /**
   * Get the value produced by the worker thread, or null if it hasn't been
   * constructed yet.
   */
  protected synchronized Object getValue() {
    return value;
  }

  /**
   * Set the value produced by worker thread
   */
  private synchronized void setValue(Object x) {
    value = x;
  }

  /**
   * Compute the value to be returned by the <code>get</code> method.
   */
  public abstract Object construct();

  /**
   * Called on the event dispatching thread (not on the worker thread) after
   * the <code>construct</code> method has returned.
   */
  public void finished() {
  }

  /**
   * A new method that interrupts the worker thread. Call this method to force
   * the worker to stop what it's doing.
   */
  public void interrupt() {
    Thread t = threadVar.get();
    if (t != null) {
      t.interrupt();
    }
    threadVar.clear();
  }

  /**
   * Return the value created by the <code>construct</code> method. Returns
   * null if either the constructing thread or the current thread was
   * interrupted before a value was produced.
   *
   * @return the value created by the <code>construct</code> method
   */
  public Object get() {
    while (true) {
      Thread t = threadVar.get();
      if (t == null) {
        return getValue();
      }
      try {
        t.join();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // propagate
        return null;
      }
    }
  }

  /**
   * Start a thread that will call the <code>construct</code> method and
   * then exit.
   */
  public SwingWorker() {
    final Runnable doFinished = new Runnable() {
      public void run() {
        finished();
      }
    };

    Runnable doConstruct = new Runnable() {
      public void run() {
        try {
          setValue(construct());
        } finally {
          threadVar.clear();
        }

        SwingUtilities.invokeLater(doFinished);
      }
    };

    Thread t = new Thread(doConstruct);
    threadVar = new ThreadVar(t);
  }

  /**
   * Start the worker thread.
   */
  public void start() {
    Thread t = threadVar.get();
    if (t != null) {
      t.start();
    }
  }
}

class LongTask {
  private int lengthOfTask;

  private int current = 0;

  private boolean done = false;

  private boolean canceled = false;

  private String statMessage;

  public LongTask() {
    //Compute length of task...
    //In a real program, this would figure out
    //the number of bytes to read or whatever.
    lengthOfTask = 1000;
  }

  /**
   * Called from ProgressBarDemo to start the task.
   */
  public void go() {
    final SwingWorker worker = new SwingWorker() {
      public Object construct() {
        current = 0;
        done = false;
        canceled = false;
        statMessage = null;
        return new ActualTask();
      }
    };
    worker.start();
  }

  /**
   * Called from ProgressBarDemo to find out how much work needs to be done.
   */
  public int getLengthOfTask() {
    return lengthOfTask;
  }

  /**
   * Called from ProgressBarDemo to find out how much has been done.
   */
  public int getCurrent() {
    return current;
  }

  public void stop() {
    canceled = true;
    statMessage = null;
  }

  /**
   * Called from ProgressBarDemo to find out if the task has completed.
   */
  public boolean isDone() {
    return done;
  }

  /**
   * Returns the most recent status message, or null if there is no current
   * status message.
   */
  public String getMessage() {
    return statMessage;
  }

  /**
   * The actual long running task. This runs in a SwingWorker thread.
   */
  class ActualTask {
    ActualTask() {
      //Fake a long task,
      //making a random amount of progress every second.
      while (!canceled && !done) {
        try {
          Thread.sleep(1000); //sleep for a second
          current += Math.random() * 100; //make some progress
          if (current >= lengthOfTask) {
            done = true;
            current = lengthOfTask;
          }
          statMessage = "Completed " + current + " out of "
              + lengthOfTask + ".";
        } catch (InterruptedException e) {
          System.out.println("ActualTask interrupted");
        }
      }
    }
  }
}


/*
 * End the progress bar code
 */




