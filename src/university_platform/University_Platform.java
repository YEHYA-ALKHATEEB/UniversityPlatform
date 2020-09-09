/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package university_platform;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Yehya
 */
public class University_Platform {

    /**
     * @param args the command line arguments
     */
    static Scanner scannedInput = new Scanner(System.in);
    public static void main(String[] args) {
         
       //  insertfaculty();
           selectFaculties();
            insertIntoMajor();
      // insertintomajor();
       //insertintoCourses();
      
    }
    
    static void selectFaculties(){
        System.out.println("Please choose your faculty name");
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/universitydb","root","");  
            String query= "SELECT `id`,`name` FROM `faculty`";
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();
             System.out.println("Id\tname");
             
             while(rs.next()){
                 System.out.print(rs.getInt(1));
                 System.out.print("\t"+rs.getString(2));
                 System.out.println();
             }
             stmt.setInt(1,1);
             stmt.setString(2,"MUBS");

           
             con.close();

            }
        catch(Exception e)
            {
                System.out.println(e);
            }  
 //System.in is a standard input stream.

    }  
    
 /*public static void main(String[] args)
 {
  System.out.print("Enter an integer: ");
  int i = GetAnInteger();
  System.out.println("You entered " + i);
 }*/
 public static int GetFacultyId()
 {
  while (true)
  {
   try
   {
    return scannedInput.nextInt();
   }
   catch (InputMismatchException e)
   {
    scannedInput.next();
    System.out.print("the ID must be an integer");
   }
  }}
    
    static void insertfaculty(){
           
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/universitydb","root","");  
            String query = "INSERT INTO `faculty`(`name`) VALUES (?)";

             PreparedStatement stmt = con.prepareStatement(query);
               scannedInput = new Scanner(System.in);
              System.out.print("Please Enter Faculty Name:\t");
              int input = GetFacultyId();
             stmt.setInt(1,input);

             int i = stmt.executeUpdate();
             System.out.println(i+"records inserted");

             con.close();

            }
        catch(Exception e)
            {
                System.out.println(e);
            }                              
    }
    
    /***************************INSERT INTO MAJOR DB TABLE**********************************************************/
    
     static void insertIntoMajor(){
           
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/universitydb","root","");  
            String query ="INSERT INTO major( `facultyId`,`name`) VALUES (?,?)"; 
                

             PreparedStatement stmt = con.prepareStatement(query);
               scannedInput = new Scanner(System.in);
              System.out.print("Please Enter Faculty Id:\t");
              int input = GetFacultyId();
             stmt.setInt(1,input);
             scannedInput = new Scanner(System.in);
             System.out.println("Please Enter Your major");
             String name = scannedInput.nextLine();
             stmt.setString(2,name);
             int i = stmt.executeUpdate();
             System.out.println(i+"major has been inserted");

             con.close();

            }
        catch(Exception e)
            {
                System.out.println(e);
            }                              
    }
     
       static void insertintoCourses(){
            
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/universitydb","root","");  
             PreparedStatement stmt = con.prepareStatement("INSERT INTO Courses(majorId,name,DORO) values(?,?,?)");
             
             stmt.setInt(1,1);
             stmt.setString(2,"programing one");
             stmt.setString(3,"2-2-2020" );

             int i = stmt.executeUpdate();
             System.out.println(i+"5 records inserted");

             con.close();

            }
        catch(Exception e)
            {
                System.out.println(e);
            }  
}
}