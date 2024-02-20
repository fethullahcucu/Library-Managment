/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.management.system;

import java.sql.SQLException;

/**
 *
 * @author canif
 */
public class LibraryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //DatabaseSetup.databaseSetup(); -- working well
        //DatabaseWriter writer = new DatabaseWriter(); -- working well 
        
        Menu menu = new Menu();
        //menu.bookCheckOut();
        menu.checkedList();
        //Menu menu = new Menu();
       // menu.addBooks();
        
        
    }
    
}
