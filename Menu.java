/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author canif
 */
public  class Menu {
    private Scanner input = new Scanner(System.in);
    
    
    public void addUser() throws SQLException{
        System.out.println("what is user name?");
        String name = input.nextLine();

        Member member = new Member(name);  
        DatabaseWriter.addMember(member);
        System.out.println("userAdded finished.");
        
    }
    
    public void addBooks(){
    
    System.out.println("what is book name?");
    String bookName = input.nextLine();
    System.out.println("who is author of the book?");
    String bookAuthor = input.nextLine();
    System.out.println("what is category of the book?\n"
                + "1-FICTION \n"
                + "2-NON_FICTION\n"
                + "3-SCIENCE\n"
                + "4-HISTORY\n"
                + "5-TECHNOLOGY\n"
                + "6-ART");
    
    
    int userChoose = input.nextInt(); //idk how to choose enum by user input-----------------------------------------------------------------
    BookCategory bookCategory = BookCategory.bookCategory(userChoose);
    
    
    

    Book book = new Book(bookName,bookAuthor,bookCategory);
   
        
    
    }
    
    public void bookCheckIn() throws SQLException{
        System.out.println("id of book");
            int bookId = input.nextInt();
        System.out.println("user id");
            int userId = input.nextInt();
            
        DatabaseUpdate dbUpdateStatus = new DatabaseUpdate();
        dbUpdateStatus.checkIn(bookId, userId);
            
        
        
    }
    
    public void bookCheckOut() throws SQLException{
    
        System.out.println("id of book");
        int bookId = input.nextInt();
        System.out.println("user id");
        int userId = input.nextInt();
        
        DatabaseUpdate dbUpdateStatus = new DatabaseUpdate();
        dbUpdateStatus.checkOut(bookId, userId);
        
        
        
        //update database by id of book
        //add the book into 3. table with memberID,memberName,Book.
        
    
    }
    
    public void checkedList(){
    
        DatabaseReader dbReader = new DatabaseReader();
        dbReader.getCheckedList();
        
        
        
    
    
    }
    
    //1-new user -done
    //2- new book -done
    //3-book checked in
    //4-book checked out
    //5-users checked lists

}
