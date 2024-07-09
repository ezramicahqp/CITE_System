package DbCITESystemUI;

import DbCITESystemBL.CITE_features;
import DbCITESystemModels.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

public class RegistrationPage extends JFrame {
    
    
    private final JPanel mainPanel;
    private final JPanel upperPanel;
    private final JPanel upperPanelLining;
    private final JLabel lblBanner;
    private final JLabel lblLiningBanner;
    private final JLabel lblIBITSLogo;
    private final JLabel lblPUPLogo;
    
    private final JPanel panelBody;
    
    private final JLabel StudID;
    private final JTextField txtStudID;
    private final JLabel lblStudName;
    private final JTextField txtStudLastName;
    private final JTextField txtStudFirstName;
    private final JTextField txtStudMiddleName;
    private final JLabel lblCourse;
    private static final String[]Course={"Bachelor of Science in Information Technology","Diploma in Information Technology","Diploma in Information Communication Technology"};
    private JComboBox<String> cmbCourse;
    private final JLabel lblYear;
    private static final String[]Year={"First Year", "Second Year","Third Year","Fourth Year"};
    private JComboBox<String> cmbYearLevel;
    private final JLabel lblAddress;
    private final JTextField txtAddress;
    private final JLabel lblContactNumber;
    private final JTextField txtContactNumber;
    private final JLabel lblBirthDay;
    private final JTextField txtBirthDay;
    private final JLabel lblPosition;
    private final JTextField txtPosition;
    private final JLabel lblAffiliation;
    private static final String[]Affiliation={"Institute of Bachelors in Information Technology Studies"};
    private JComboBox<String> cmbAffiliation;
    private JComboBox<String> cmbDay;
    private JComboBox<String> cmbYear;
    private JComboBox<String> cmbMonth;
    private static final String[] month = {"01", "02", "03","04","05","06","07","08","09","10","11","12"};
    private static final String[] day = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private static final String[] year = {"1999","2000","2001","2002","2003","2004","2005","2006","2007","2008"};
    private final JButton btnRegister;
    private JLabel selectedCourse = new JLabel();
    private JLabel selectedYear = new JLabel();
    private JLabel selectedAffil = new JLabel();
    private JLabel selectedDate = new JLabel();
    
    public RegistrationPage (){
        
     
    mainPanel = new JPanel();
    upperPanel = new JPanel();
    panelBody = new JPanel();
    upperPanelLining = new JPanel();
    lblBanner = new JLabel("IBITS Zone{}");
    lblLiningBanner = new JLabel("Registration Form");
    lblIBITSLogo = new JLabel();
    lblPUPLogo = new JLabel();   
    StudID = new JLabel("Student Number");
    txtStudID = new JTextField();
    lblStudName = new JLabel("Student Name");
    txtStudLastName = new JTextField("Last Name");
    txtStudFirstName = new JTextField("First Name");
    txtStudMiddleName = new JTextField("Middle Name");
    lblCourse = new JLabel("Course");
    lblYear = new JLabel("Year Level");
    lblAddress = new JLabel("Address");
    txtAddress = new JTextField();
    lblContactNumber = new JLabel("Contact Number");
    txtContactNumber = new JTextField();
    lblBirthDay = new JLabel("Birth Date");
    txtBirthDay = new JTextField();
    lblPosition = new JLabel("Position");
    txtPosition = new JTextField();
    lblAffiliation = new JLabel("Affiliation");
    btnRegister = new JButton("Register");
    
    //LETTER ONLY FILTER
        ((AbstractDocument) txtStudLastName.getDocument()).setDocumentFilter(new FilterLetter());
        ((AbstractDocument) txtStudFirstName.getDocument()).setDocumentFilter(new FilterLetter());
        ((AbstractDocument) txtStudMiddleName.getDocument()).setDocumentFilter(new FilterLetter());
        ((AbstractDocument) txtPosition.getDocument()).setDocumentFilter(new FilterLetter());

        //NUMBERS ONLY FILTER
         ((AbstractDocument) txtContactNumber.getDocument()).setDocumentFilter(new FilterNumber());
    
    
       setSize(1050,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);
       setVisible(true);
       setLocationRelativeTo(null);
       
       
       add(mainPanel);   
       
       MainPanel();
       UpperPanel();
       UpperPanelLining();
       PanelBody();
      
    }
    
    public void MainPanel() {
        mainPanel.add(upperPanel);
        
        mainPanel.setBounds(0, 0, 1050, 700); 
        mainPanel.setBackground(new Color(217,217,217));
        mainPanel.setLayout(null);
        
        mainPanel.add(upperPanel);
 
    }

    public void UpperPanel() {
        
        upperPanel.add(upperPanelLining);
        
        upperPanel.setBounds(10, 10, 1015, 150);
        upperPanel.setBackground(new Color(0,32,96));
        upperPanel.setLayout(null);
        upperPanel.add(lblBanner);
                
        lblBanner.setBounds(30, 20, 710, 100);
        lblBanner.setFont(new Font ("Courier New", Font.PLAIN, 60));
        lblBanner.setForeground(Color.WHITE);
        
        lblPUPLogo.setBounds(890, -25,170, 170);
        ImageIcon PUP = new ImageIcon(new ImageIcon("PUP_Logo.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
        lblPUPLogo.setIcon(PUP);
        upperPanel.add(lblPUPLogo);
        
        lblIBITSLogo.setBounds(800, -35, 190, 190);
        ImageIcon IBITS = new ImageIcon(new ImageIcon("IBITS_Logo.png").getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
        lblIBITSLogo.setIcon(IBITS);
        upperPanel.add(lblIBITSLogo);
        
        
    }

    public void UpperPanelLining() {
        
        upperPanelLining.setBounds(0, 110, 1015, 40);
        upperPanelLining.setBackground(new Color(255, 192, 0));
        upperPanelLining.setLayout(null);
        
        String liningBanner = "Registration Form";
        lblLiningBanner.setText(liningBanner);
        lblLiningBanner.setBounds(20, 0, 765, 40);
        lblLiningBanner.setFont(new Font ("Courier New", Font.PLAIN, 20));
        upperPanelLining.add(lblLiningBanner);
        
    }
    
    public void PanelBody(){
        
        CITE_features citeFeatures = new CITE_features();
        
        mainPanel.add(panelBody);
        
        panelBody.setBounds(10, 150, 1015, 500);
        panelBody.setBackground(new Color(217,217,217));
        panelBody.setLayout(null);
        
        StudID.setFont(new Font ("Courier New", Font.PLAIN, 16));
        StudID.setBounds(30, 50, 170, 30);
        panelBody.add(StudID);
        
        txtStudID.setBounds(30, 90, 200, 30);
        panelBody.add(txtStudID);
        
        lblStudName.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblStudName.setBounds(270, 50, 200, 30);
        panelBody.add(lblStudName);
        
        txtStudLastName.setBounds(270, 90, 200, 30);
        txtStudLastName.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtStudLastName);
        
        txtStudFirstName.setBounds(485, 90, 300, 30);
        txtStudFirstName.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtStudFirstName);
        
        txtStudMiddleName.setBounds(800, 90, 190, 30);
        txtStudMiddleName.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtStudMiddleName);
        
        lblCourse.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblCourse.setBounds(30, 140, 200, 30);
        panelBody.add(lblCourse);
        
        cmbCourse = new JComboBox<>(Course);
        cmbCourse.setBounds(30, 170, 500, 30);
        cmbCourse.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(cmbCourse);
        
        lblYear.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblYear.setBounds(560, 140, 200, 30);
        panelBody.add(lblYear);
        
        cmbYearLevel = new JComboBox<>(Year);
        cmbYearLevel.setBounds(560, 170, 200, 30);
        cmbYearLevel.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(cmbYearLevel);
        
        lblContactNumber.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblContactNumber.setBounds(790, 140, 200, 30);
        panelBody.add(lblContactNumber);
        
        txtContactNumber.setBounds(790, 170, 200, 30);
        txtContactNumber.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtContactNumber);
        
        lblAffiliation.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblAffiliation.setBounds(30, 220, 200, 30);
        panelBody.add(lblAffiliation);
        
        cmbAffiliation = new JComboBox<>(Affiliation);
        cmbAffiliation.setBounds(30, 250, 500, 30);
        cmbAffiliation.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(cmbAffiliation);
        
        lblPosition.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblPosition.setBounds(560, 220, 200, 30);
        panelBody.add(lblPosition);
        
        txtPosition.setBounds(560, 250, 430, 30);
        txtPosition.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtPosition);
        
        lblAddress.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblAddress.setBounds(30, 300, 200, 30);
        panelBody.add(lblAddress);
        
        txtAddress.setBounds(30, 330, 500, 30);
        txtAddress.setFont(new Font ("Courier New", Font.PLAIN, 12));
        panelBody.add(txtAddress);
        
        lblBirthDay.setFont(new Font ("Courier New", Font.PLAIN, 16));
        lblBirthDay.setBounds(560, 300, 230, 30);
        panelBody.add(lblBirthDay);
        

        cmbYear = new JComboBox<>(year);
        cmbYear.setBounds(560, 330, 100, 30);
        panelBody.add(cmbYear);
       

        cmbMonth = new JComboBox<>(month);
        cmbMonth.setBounds(680, 330, 100, 30);
        panelBody.add(cmbMonth);
        

        cmbDay = new JComboBox<>(day);
        cmbDay.setBounds(800, 330, 100, 30);
        panelBody.add(cmbDay);
        
        btnRegister.setFont(new Font ("Courier New", Font.PLAIN, 16));
        btnRegister.setBounds(800, 420, 150, 40);
        btnRegister.setBackground(new Color(255, 192, 0));
        panelBody.add(btnRegister);
        btnRegister.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String inputCourse = (String) cmbCourse.getSelectedItem();
            selectedCourse.setText( inputCourse);
            
            String inputYear = (String) cmbYearLevel.getSelectedItem();
            selectedYear.setText( inputYear);
            
            String inputAffil = (String) cmbAffiliation.getSelectedItem();
            selectedAffil.setText( inputAffil);
       
        String day = (String) cmbDay.getSelectedItem();
        String month = (String) cmbMonth.getSelectedItem();
        String year = (String) cmbYear.getSelectedItem();
        
        String birthDate = "" +year+ "-" +month+ "-" + "" +day+ "";
            
            StudentModels studInfo = new StudentModels();
            studInfo.StudID = txtStudID.getText();
            studInfo.StudLastName = txtStudLastName.getText();
            studInfo.StudFirstName = txtStudFirstName.getText();
            studInfo.StudMiddleName = txtStudMiddleName.getText();
            studInfo.Course = selectedCourse.getText();
            studInfo.Year = selectedYear.getText();
            studInfo.Address = txtAddress.getText();
            studInfo.ContactNumber = txtContactNumber.getText();
            studInfo.BirthDay = birthDate;
            studInfo.Position = txtPosition.getText();
            studInfo.Affiliation = selectedDate.getText();
            
            citeFeatures.AddStudent(studInfo);
            
            JOptionPane.showMessageDialog(null, "You are now registered!", "", JOptionPane.INFORMATION_MESSAGE);
            HomePage hp = new HomePage();
            dispose();
        } 
    });
        
        
        
    }
    

    

}


