
package DbCITESystemDL;

import DbCITESystemModels.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class CITE_Database {
    String url = "jdbc:mysql://localhost:3306/db_cite?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user = "root";
    String password = "MarkLee@Pogi99!";
    
    public ArrayList<StudentModels> GetStudentInfo(){
        
       String selectStatement 
        = "SELECT stud_id, stud_lastname, stud_firstname, stud_middlename, course, stud_year, address, contact_number, birthday, position, affiliation FROM tbl_cite";
       
       
       ArrayList<StudentModels> studInfo = new ArrayList<StudentModels>();
       
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url, user, password);
           PreparedStatement selectCommand = connection.prepareStatement(selectStatement);
           ResultSet resultSet = selectCommand.executeQuery();

            while(resultSet.next()) {
                
                
                String studID = resultSet.getString("stud_id");
                String studLastName = resultSet.getString("stud_lastname");
                String studFirstName = resultSet.getString("stud_firstname");
                String studMiddleName = resultSet.getString("stud_middlename");
                String course = resultSet.getString("course");
                String yearLevel = resultSet.getString("stud_year");
                String address = resultSet.getString("address");
                String number = resultSet.getString("contact_number");
                String birthDate = resultSet.getString("birthday");
                String position = resultSet.getString("position");
                String affiliation = resultSet.getString("affiliation");
                  

                StudentModels readStudInfo = new StudentModels();
                readStudInfo.StudID =  studID;
                readStudInfo.StudLastName = studLastName;
                readStudInfo.StudFirstName =  studFirstName;
                readStudInfo.StudMiddleName = studMiddleName;
                readStudInfo.Course =  course;
                readStudInfo.Year = yearLevel;
                readStudInfo.Address =  address;
                readStudInfo.ContactNumber = number;
                readStudInfo.BirthDay =  birthDate;
                readStudInfo.Position = position;
                readStudInfo.Affiliation =  affiliation;
              
               
                studInfo.add(readStudInfo);
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    
        return studInfo;
    }
    
    public UserCredentials GetLoginUser()
   {
        String selectStatement 
        = "select username, password from tbl_credentials";
       
        UserCredentials loginCredentials = new UserCredentials();
       
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url, user, password);
           PreparedStatement selectCommand = connection.prepareStatement(selectStatement);
           ResultSet resultSet = selectCommand.executeQuery();

            while(resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                
                loginCredentials.username = username;
                loginCredentials.password = password;
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    
        return loginCredentials;
    }
    
    public void AddStudent(String studID, String studLastName, String studFirstName, String studMiddleName,String course,String year,String address, String conNumber,String bday,String position,String affiliation){
        
       String insertStatement 
        = "INSERT INTO tbl_cite (stud_id, stud_lastname, stud_firstname, stud_middlename, course, stud_year, address, contact_number, birthday, position, affiliation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
       
       
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url, user, password);
           PreparedStatement insertCommand = connection.prepareStatement(insertStatement);
          

            {
            insertCommand.setString(1, studID);   
            insertCommand.setString(2, studLastName);
            insertCommand.setString(3, studFirstName);
            insertCommand.setString(4, studMiddleName);
            insertCommand.setString(5, course);
            insertCommand.setString(6, year);   
            insertCommand.setString(7, address);
            insertCommand.setString(8, conNumber);
            insertCommand.setString(9, bday);
            insertCommand.setString(10, position);
            insertCommand.setString(11, affiliation);
            
            insertCommand.executeUpdate();
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}
