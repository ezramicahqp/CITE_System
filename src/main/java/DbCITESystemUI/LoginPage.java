
package DbCITESystemUI;

import DbCITESystemBL.CITE_features;
import DbCITESystemModels.*;
//import DbCITESystemBL.*;
import DbCITESystemDL.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginPage extends JFrame implements ActionListener{
   
    private final JPanel mainPanel;
    private final JPanel upperPanel;
    private final JPanel upperPanelLining;
    private final JLabel lblBanner;
    private final JLabel lblLiningBanner;
    private final JLabel lblIBITSLogo;
    private final JLabel lblPUPLogo;
    
    private final JPanel panelBody;
    
    private final JLabel lblProceed;
    private final JLabel lblUsername;
    private final JTextField txtUsername;
    private final JLabel lblPassword;
    private final JTextField txtPassword;   
    private final JLabel lblRegistration;
    private final JButton btnRegister;
    private final JButton btnLogin;
    private int attemptsCounter = 0;
    
    public LoginPage(){
        
    mainPanel = new JPanel();
    upperPanel = new JPanel();
    panelBody = new JPanel();
    upperPanelLining = new JPanel();
    lblBanner = new JLabel("IBITS Zone{}");
    lblLiningBanner = new JLabel("");
    
    lblIBITSLogo = new JLabel();
    lblPUPLogo = new JLabel();
    lblProceed = new JLabel("Login to proceed . . .");
    lblUsername = new JLabel("username");
    lblPassword = new JLabel("password");
    lblRegistration = new JLabel("not a member yet?");
    txtUsername = new JTextField();
    txtPassword = new JTextField();
    btnLogin = new JButton("Login");
    btnRegister = new JButton("register here!");
   
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
        //panelBody.setBackground(Color.red);
        panelBody.setLayout(null);
        
        lblProceed.setFont(new Font ("Courier New", Font.PLAIN, 20));
        lblProceed.setBounds(50, 70, 710, 50);
        panelBody.add(lblProceed);
        
        txtUsername.setBounds(70, 170, 400, 35);
        panelBody.add(txtUsername);
             
        lblUsername.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblUsername.setBounds(80, 210, 710, 30);
        panelBody.add(lblUsername);
        
        txtPassword.setBounds(70, 270, 400, 35);
        panelBody.add(txtPassword);
        
        lblPassword.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblPassword.setBounds(80, 310, 710, 30);
        panelBody.add(lblPassword);
        
        btnLogin.setFont(new Font ("Courier New", Font.PLAIN, 16));
        btnLogin.setBounds(650, 270, 100, 40);
        btnLogin.setBackground(new Color(255, 192, 0));
        btnLogin.addActionListener(this);
        panelBody.add(btnLogin);
        
        lblRegistration.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblRegistration.setBounds(270, 430, 710, 30);
        panelBody.add(lblRegistration);
        
        btnRegister.setFont(new Font ("Courier New", Font.PLAIN, 16));
        btnRegister.setBounds(450, 430, 150, 30);
        btnRegister.setBorder(null);
        btnRegister.setOpaque(false);
        btnRegister.setBackground(new Color(255,255,255,0));
        btnRegister.setForeground(Color.blue);
        btnRegister.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            ProgressPage progPage = new ProgressPage();
            progPage.setVisible(true);
            dispose();
        } 
    });
    
        panelBody.add(btnRegister);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = txtUsername.getText();
                String Password = txtPassword.getText();
                
                CITE_features citeFeatures = new CITE_features();
                UserCredentials user = new UserCredentials();
                user = citeFeatures.GetLoginCredentials();
                
                 if(Username.equals(user.username) && Password.equals(user.password)) {
                     JOptionPane.showMessageDialog(null, "Login Successful. Welcome!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                     HomePage hp = new HomePage();
                     dispose();

                } else {
                    attemptsCounter++;
                    if (attemptsCounter >= 5) {
                        JOptionPane.showMessageDialog(null, "Too many failed attempts. Exiting...");
                        System.exit(0);
                    } else {
                    JOptionPane.showMessageDialog(null, "Login Failed. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            }
    
    
       });
        
        
    }
    
}
