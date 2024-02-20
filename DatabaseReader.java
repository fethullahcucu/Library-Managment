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
import java.util.ArrayList;

/**
 *
 * @author canif
 */
public class DatabaseReader extends Database{
    public String getAllMembers() {
        
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME_MEMBERS));
            

            //call the costumers from database and assign into variables.
            while (results.next()) { 
                int id = results.getInt("member_id"); 
                String name = results.getString("Name"); 
                System.out.println(id+"-"+name);

                            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public String getAllBooks() {
        
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME_BOOKS));


            //call the costumers from database and assign into variables.
            while (results.next()) { 
                int id = results.getInt("book_id"); 
                String name = results.getString("name"); 
                String author = results.getString("author"); 
                String category = results.getString("category");
                String status = results.getString("status");
                System.out.println(id+"-"+name+"-"+author+"-"+category+"-"+status);

                            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public static Book getBookById (int book_id) throws SQLException{
        //int book_id;
        String book_name;
        String author;
        String category;
        String status;
        ResultSet results_book;
        Book book;
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ){
         results_book = stmt.executeQuery(String.format("SELECT * FROM %s WHERE book_id=%s;", TABLE_NAME_BOOKS,book_id));
         results_book.next();
         
         System.out.println("getBookById start");
         book_id = results_book.getInt("book_id");
         book_name= results_book.getString("name");
         author = results_book.getString("author");
         category = results_book.getString("category");
         status = results_book.getString("status");
         System.out.println("getBookById finished");
         book = new Book(book_id,book_name,author,category,status);
         System.out.println("new book created");
         
    }
        System.out.println(book_id+"-"+book_name+"-"+author+"-"+category+"-"+status);
        
        return book;
    }
    
    public static Member getMemberById (int memberId) throws SQLException{
        
        ResultSet results_member;
        Member member;
        
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ){
        results_member = stmt.executeQuery(String.format("SELECT * FROM %s WHERE member_id=%d;", TABLE_NAME_MEMBERS,memberId));
        results_member.next();
        int member_id = results_member.getInt("member_id");
        String member_name = results_member.getString("name");
        
        member = new Member(member_id,member_name);
        
    }
    return  member;
    
    
    }
    
    public void getCheckedList(){
    String status_string = null;
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME_CHECKEDOUT));


            //call the costumers from database and assign into variables.
            while (results.next()) { 
                int start_id = results.getInt("start_id"); 
                int user_id = results.getInt("user_id"); 
                int book_id = results.getInt("book_id");
                int status = results.getInt("status");
                
                if(status==1){
                    status_string = "Check Out";
                    
                }else if (status==0){
                
                status_string = "Check In";
                
                }else{status_string="getCheckedList else - if error";}
                
                String user_name_match = DatabaseReader.getMemberById(user_id).getName();
                String book_name_match= DatabaseReader.getBookById(book_id).getTitle();
                String book_author_match = DatabaseReader.getBookById(book_id).getAuthor();
                String book_category_match = DatabaseReader.getBookById(book_id).getCategory_string();
                
                
                
                System.out.println(""
                        + "log ID:"+start_id+
                        "user_id:"+user_id+
                        "user_name"+user_name_match+
                        "book_id:"+book_id+
                        "book_name"+user_name_match+
                        "book_author"+book_author_match+
                        "book_category"+book_category_match+
                        "Status:"+status_string);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    
    
    
    }
}
