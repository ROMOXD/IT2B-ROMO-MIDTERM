        
package student;
import java.util.Scanner;
public class Student {

    public static void main(String[] args) {
      
     Scanner sc = new Scanner(System.in);    
     String response;
        
        do{
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        
            System.out.print("Enter action: ");
            int action = sc.nextInt();
            
            Student sample = new Student();
            switch(action){
               case 1:
                   sample.addStudent();
                break;
               case 2:
                   sample.viewStudent();          
                break;   
                case 3:
                   sample.updateStudent();  
                break;
                case 4:
                   sample.deleteStudent();  
                break;
                case 5:
                    
                break;
            }
            
            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
       
    } while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank you, See you!!");

    }
    
    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Student Name: ");
        String sname = sc.next();
        System.out.print("Student Age: ");
        int sage = sc.nextInt();
        System.out.print("Student Email: ");
        String semail = sc.next();
        System.out.print("Student Address: ");
        String sadr = sc.next();
        System.out.print("Student phone number: ");
        int spnum = sc.nextInt();

        String sql = "INSERT INTO tbl_student (s_name, s_age, s_email, s_address, s_pnum) VALUES (?, ?, ?, ?, ?)"; 

        conf.addRecord(sql, sname, sage, semail, sadr, spnum);
            
    }
    
    public void viewStudent() {
        
        config conf = new config();
        String qry = "SELECT * FROM tbl_student";
        String[] hdrs = {"ID", "Name", "Age", "Email", "Address", "PHONE NUM"};
        String[] clmn = {"s_id", "s_name", "s_age", "s_email", "s_address", "s_pnum"};

        conf.viewRecords(qry, hdrs, clmn);
    }
    
    public void updateStudent(){
    
    Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        
        System.out.print("New Name: ");
        String nname = sc.next();
        System.out.print("New Age: ");
        String nage = sc.next();
        System.out.print("New Email: ");
        String nemail = sc.next();
        System.out.print("New Address: ");
        String nadr = sc.next();
        System.out.print("New Phone Number: ");
        int nspnum = sc.nextInt();
        
        String qry = "UPDATE tbl_student SET s_name = ?,s_age = ?,s_email = ?,s_address = ?,s_pnum WHERE s_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nname, nage, nemail, nadr, nspnum);
    
    }
    
    public void deleteStudent(){
        
        Scanner sc = new Scanner(System.in);
    
    
        System.out.print("Enter customer ID: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_student WHERE s_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);   
    
    
    }

}
