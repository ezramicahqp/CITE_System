
package DbCITESystemDL;

import DbCITESystemModels.*;
import java.util.ArrayList;


public class CITE_data {
    
    
    ArrayList<StudentModels> studInfo;
    CITE_Database citeDatabase;
        
    public CITE_data()
    {
        studInfo = new ArrayList<StudentModels>();
        citeDatabase = new CITE_Database();

    }


    public ArrayList<StudentModels> GetStudentInfo() 
    {
        return studInfo = citeDatabase.GetStudentInfo();
    }
    
    public UserCredentials GetLoginCredentials(){
        return citeDatabase.GetLoginUser();
    }
    
    public void AddStudent(StudentModels studModels) 
    {
        citeDatabase.AddStudent(studModels.StudID, studModels.StudLastName, studModels.StudFirstName, studModels.StudMiddleName, studModels.Course,studModels.Year,studModels.Address, studModels.ContactNumber, studModels.BirthDay, studModels.Position, studModels.Affiliation);
    }
    
}
