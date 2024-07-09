
package DbCITESystemBL;


import DbCITESystemModels.*;
import DbCITESystemDL.*;
import java.util.ArrayList;


public class CITE_features {
    CITE_data citeData = new CITE_data();

    public ArrayList<StudentModels> StudInfoDisplay() 
    {
         ArrayList<StudentModels> studInfo = citeData.GetStudentInfo();
         return studInfo;
    }
    
    public UserCredentials GetLoginCredentials(){
        return citeData.GetLoginCredentials();
    }
    
    public void AddStudent(StudentModels studModels) 
    {
        citeData.AddStudent(studModels);
    }
}
