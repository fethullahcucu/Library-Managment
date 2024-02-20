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
public class DatabaseSetup extends Database{
    public static boolean databaseSetup() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        System.out.println("Connecting to database...");

        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                

                Statement stmt = conn.createStatement();
            ){
            
            //setup the database
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            
            System.out.println(" sql worked");
            String sql_1 = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_BOOKS + " ("
                    + "BookId INT(10) PRIMARY KEY AUTO_INCREMENT ,"
                    + "BookName VARCHAR(255),"
                    + "BookAuthor VARCHAR(255),"
                    + "BookCategory VARCHAR(255),"
                    + "BookStatus VARCHAR(255)"
                    + ");";
                    
             String sql_2 = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_MEMBERS + " ("
                    + "MemberId INT(10) PRIMARY KEY AUTO_INCREMENT,"
                    + "MemberName VARCHAR(255)"
                    + ");";
             
             
             
             String sql_3 = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_CHECKEDOUT;
             /*
             INSERT INTO merged_data (id, name, author, category, status, member_id, member_name)
            SELECT id, name, author, category, status, NULL, NULL
            FROM librarybooks
            UNION
            SELECT NULL, name, NULL, NULL, NULL, id, name
            FROM librarymembers;
                    
*/
             String[] sqlList = {sql_1,sql_2,sql_3};
             
             for (String sql : sqlList){
                 System.out.println("worked");
                 stmt.execute(sql);
                 System.out.println("worked again");
             }
             
            System.out.println("Table created successfully.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    
}}
