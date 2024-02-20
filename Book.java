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

/**
 *
 * @author canif
 */
public class Book {
    
    private int id;
    private String title;
    private String author;
    private BookCategory category;
    private String category_string;
    private BookStatus status;
    private String status_string;
    
    
    public Book(String title, String author, BookCategory category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = BookStatus.AVAILABLE; // Default status
    }
    
    public Book (int id, String title, String author, String category,String status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.category_string = category;
        this.status_string = status;
        
    
    }
    

    public int getId() {
        return id;
    }

    public String getCategory_string() {
        return category_string;
    }

    // Getters and setters
    public String getStatus_string() {    
        return status_string;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", status=" + status +
                '}';
    }
    
    
    
    
}

