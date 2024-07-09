
package DbCITESystemUI;
  
import DbCITESystemModels.*;
import DbCITESystemBL.*;
import DbCITESystemDL.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HomePage extends JFrame {
    
    
    private final JPanel mainPanel;
    private final JPanel upperPanel;
    private final JPanel upperPanelLining;
    private final JLabel lblBanner;
    private final JLabel lblLiningBanner;
    private final JLabel lblIBITSLogo;
    private final JLabel lblPUPLogo;
    
    private final JPanel panelBody;
    private JScrollPane scrollPane;
    private JTable table;
    
    public HomePage (){
        
    CITE_features citeFeatures = new CITE_features();
    
    mainPanel = new JPanel();
    upperPanel = new JPanel();
    panelBody = new JPanel();
    upperPanelLining = new JPanel();
    lblBanner = new JLabel("IBITS Zone{}");
    lblLiningBanner = new JLabel();
    lblIBITSLogo = new JLabel();
    lblPUPLogo = new JLabel();   
    
    
    
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
        
        String liningBanner = "Member Information Viewing Page";
        lblLiningBanner.setText(liningBanner);
        lblLiningBanner.setBounds(20, 0, 765, 40);
        lblLiningBanner.setFont(new Font ("Courier New", Font.PLAIN, 20));
        upperPanelLining.add(lblLiningBanner);
        
    }
    
    public void PanelBody(){
        mainPanel.add(panelBody);
        
        panelBody.setBounds(10, 150, 1015, 500);
        //panelBody.setBackground(new Color(217,217,217));
        panelBody.setLayout(null);
        
        CITE_features citeFeatures = new CITE_features();
        ArrayList<StudentModels> studentInfo = citeFeatures.StudInfoDisplay();
    
        DefaultTableModel model = new DefaultTableModel ();
        model.setColumnIdentifiers(new String[]{"Student ID", "Last Name","First Name", "Middle Name", "Course", "Year Level", "Address", "Contact Number", "Birth Date" , "Position" , "Affiliation"});
        //table = new JTable (model);
        
        
//        scrollPane = new JScrollPane(table);
//        panelBody.add(scrollPane);
        
        for (int i = 0; i < studentInfo.size(); i++) {
//        Object [][] data = {{}};
//        String[] columnNames = {};
        
        final StudentModels student = studentInfo.get(i);       
        model.addRow(new Object[]{student.StudID,student.StudLastName,student.StudFirstName,student.StudMiddleName,student.Course,student.Year,student.Address,student.ContactNumber,student.BirthDay,student.Position,student.Affiliation, });
        
        }
        
        table = new JTable(model);
        table.setVisible(true);
        table.setLayout(null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 20, 995, 470); 
        panelBody.add(scrollPane);
        
        panelBody.revalidate();
        panelBody.repaint();
    
    }
    
}
