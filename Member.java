/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author canif
 */
import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private List<Book> checkedOutBooks;

    public Member(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }
    public Member(int id,String name) {
        this.id=id;
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    public Member(int id) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    
    public void checkoutBook(Book book) {
        checkedOutBooks.add(book);
        //book.setStatus(BookStatus.CHECKED_OUT);
        //db update ile statusu degistir. 
        //there is gonna bi a 3th table which is about member's checkouted books. 
    }

    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        //book.setStatus(BookStatus.AVAILABLE);
        //db update ile statusu degistir.
    }

    // Getters

    public String getName() {
        return name;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", checkedOutBooks=" + checkedOutBooks +
                '}';
    }
}

