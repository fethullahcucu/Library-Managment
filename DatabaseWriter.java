/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static library.management.system.Database.DB_URL;
import static library.management.system.Database.PASSWORD;
import static library.management.system.Database.TABLE_NAME_MEMBERS;
import static library.management.system.Database.TABLE_NAME_BOOKS;
import static library.management.system.Database.USER;

/**
 *
 * @author canif
 */
public class DatabaseWriter extends Database{
    public boolean addBook(Book book) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            System.out.println("addCostumer try worked");
                                                                                                                //with that way, we are specify the column names with variables.
            String sql = String.format("INSERT INTO " + TABLE_NAME_BOOKS + " (name,Author, Category, Status) VALUES ('%s', '%s', '%s', '%s');",
     book.getTitle(),book.getAuthor(), book.getCategory(), book.getStatus());

            //taking last cell of the id column.
            stmt.execute(sql);
            String columnName = "id";
            ResultSet results = stmt.executeQuery(String.format("SELECT %s FROM "
                    + "%s ORDER BY %s DESC LIMIT 1;",
                    columnName,TABLE_NAME_BOOKS, columnName));
            
            //let costumer know what is their id. 
            if (results.next()) {
                int lastId = results.getInt(columnName);
                System.out.println("book  ID: " + lastId);
            } else {
                System.out.println("No data found.");
            }
            
            System.out.println("add Book finished.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean addMember(Member member) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            System.out.println("addmember try worked");
                                                                                                                //with that way, we are specify the column names with variables.
            String sql = String.format("INSERT INTO " + TABLE_NAME_MEMBERS + " (Name) VALUES ('%s');",
     member.getName());

            //taking last cell of the id column.
            stmt.execute(sql);
            String columnName = "member_id";
            ResultSet results = stmt.executeQuery(String.format("SELECT %s FROM "
                    + "%s ORDER BY %s DESC LIMIT 1;",
                    columnName,TABLE_NAME_MEMBERS, columnName));
            
            //let user know what is their id. 
            if (results.next()) {
                int lastId = results.getInt(columnName);
                System.out.println("User ID: " + lastId);
            } else {
                System.out.println("No data found.");
            }
            
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean updateMemberCheck(int book_id ,int memberId,int status){
    
    try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            System.out.println("updateMemberCheckOut  worked");
                    
                    Member result_member = DatabaseReader.getMemberById(memberId);
                    int result_member_id = result_member.getId();
                    System.out.println("resultmember worked");
                    
                    
                    
                    Book result_book = DatabaseReader.getBookById(book_id);
                    int result_book_id = result_book.getId();
                    System.out.println("member_id:"+result_member_id+"-"+"result_id:"+result_book_id);
                    
            String sql = String.format("INSERT INTO " + TABLE_NAME_CHECKEDOUT + " (book_id,user_id,status) VALUES ('%d','%d','%d');",
     result_book_id,result_member_id,status);
            
            stmt.execute(sql);
            

            return true;
        } catch (Exception e) {
            System.out.println(e+" dbwriter.updateMemberCheckOut error ");
            return false;
        }
    }
    
    
    
}
