/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author canif
 */
public class DatabaseUpdate extends Database{
    
    public DatabaseUpdate(){}
    
    
    
    public void checkOut(int book_Id, int member_id) throws SQLException{
        int checkedOut = 1;
        String bookIDString = Integer.toString(book_Id);
        String sql;
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
        int results;
        
        
        //this code will write 3rd databse "1" when book checked in
        DatabaseWriter.updateMemberCheck(book_Id, member_id, checkedOut);
        DatabaseWriter dbWriter = new DatabaseWriter();
        
        
        
        //change status of book at db
            sql=String.format("UPDATE %s.%s "
                    + "SET Status = '%s' "
                    + "WHERE book_id = '%s';",
                    DB_NAME, TABLE_NAME_BOOKS,BookStatus.CHECKED_OUT, bookIDString);
            results = stmt.executeUpdate(sql);
            
            
            
             
    }catch (Exception e) {
            System.out.println(e+" updateMemberCheckOut");
            
        }
    }
    
    public void checkIn(int book_Id, int member_id) throws SQLException{
        int checkedOut = 0;
        String bookIDString = Integer.toString(book_Id);
        String sql;
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
        int results;
        
        
        //this code will write 3rd databse "1" when book checked in
        DatabaseWriter.updateMemberCheck(book_Id, member_id, checkedOut);
        DatabaseWriter dbWriter = new DatabaseWriter();
        
        
        
        //change status of book at db
            sql=String.format("UPDATE %s.%s "
                    + "SET Status = '%s' "
                    + "WHERE book_id = '%s';",
                    DB_NAME, TABLE_NAME_BOOKS,BookStatus.AVAILABLE, bookIDString);
            results = stmt.executeUpdate(sql);
            
            
            
             
    }catch (Exception e) {
            System.out.println(e+" updateMemberCheckOut");
            
        }
    }
    
    
}
