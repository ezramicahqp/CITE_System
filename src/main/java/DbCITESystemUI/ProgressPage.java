
package DbCITESystemUI;

import DbCITESystemModels.*;
//import DbCITESystemBL.*;
import DbCITESystemDL.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class ProgressPage extends JFrame{
    
    private final JPanel mainPanel;
    private final JPanel upperPanel;
    private final JPanel upperPanelLining;
    private final JLabel lblBanner;
    private final JLabel lblLiningBanner;
    private final JLabel lblIBITSLogo;
    private final JLabel lblPUPLogo;
    
    private final JPanel panelBody;
    private final JProgressBar progressBar;
    
    public ProgressPage(){
        
    mainPanel = new JPanel();
    upperPanel = new JPanel();
    panelBody = new JPanel();
    upperPanelLining = new JPanel();
    lblBanner = new JLabel("IBITS Zone{}");
    lblLiningBanner = new JLabel("");
    progressBar = new JProgressBar();
    
    lblIBITSLogo = new JLabel();
    lblPUPLogo = new JLabel();
    
   
       setSize(900,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);
       setLocationRelativeTo(null);
       //setVisible(true);
       add(mainPanel);
       
       MainPanel();
       UpperPanel();
       UpperPanelLining();
       PanelBody();
      
    }
    
    public void MainPanel(){
        mainPanel.add(upperPanel);
        
        mainPanel.setBounds(0, 0, 900,700);
        mainPanel.setBackground(new Color(217,217,217));
        mainPanel.setLayout(null);
        
    }
    
    public void UpperPanel(){
        upperPanel.add(upperPanelLining);
        
        upperPanel.setBounds(10, 10, 865, 150);
        upperPanel.setBackground(new Color(0,32,96));
        upperPanel.setLayout(null);
        upperPanel.add(lblBanner);
                
        lblBanner.setBounds(30, 20, 710, 100);
        lblBanner.setFont(new Font ("Courier New", Font.PLAIN, 60));
        lblBanner.setForeground(Color.WHITE);
        
        lblPUPLogo.setBounds(740, -25,170, 170);
        ImageIcon PUP = new ImageIcon(new ImageIcon("PUP_Logo.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
        lblPUPLogo.setIcon(PUP);
        upperPanel.add(lblPUPLogo);
        
        lblIBITSLogo.setBounds(650, -35, 190, 190);
        ImageIcon IBITS = new ImageIcon(new ImageIcon("IBITS_Logo.png").getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
        lblIBITSLogo.setIcon(IBITS);
        upperPanel.add(lblIBITSLogo);
        
        
        
    }
    
    public void UpperPanelLining(){
        
        upperPanelLining.setBounds(0, 110, 865, 40);
        upperPanelLining.setBackground(new Color(255, 192, 0));
        upperPanelLining.setLayout(null);
        
        String liningBanner = " Polytechnic University of the Philippines";
        lblLiningBanner.setText(liningBanner);
        lblLiningBanner.setBounds(20, 0, 765, 40);
        lblLiningBanner.setFont(new Font ("Courier New", Font.PLAIN, 20));
        upperPanelLining.add(lblLiningBanner);
    }
    
    public void PanelBody(){
        
        mainPanel.add(panelBody);
        
        panelBody.setBounds(10, 150, 865, 500);
        panelBody.setBackground(new Color(217,217,217));
        panelBody.setLayout(null);
        
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(100, 200, 665, 50);
        progressBar.setForeground(new Color(255, 192, 0));
        progressBar.setFont(new Font ("Courier New", Font.PLAIN, 20));
        panelBody.add(progressBar);
        
        new ProgressWorker().execute();
    }


    class ProgressWorker extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            int counter = 0;

            while (counter <= 100) {
                publish(counter);
                Thread.sleep(100); 
                counter++;
            }

            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            for (int value : chunks) {
                progressBar.setValue(value);
            }
        }

        @Override
        protected void done() {
            new RegistrationPage();
            dispose();
        }
    }
    
}
