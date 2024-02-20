/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author canif
 */
public enum BookCategory {
    FICTION(1),
    NON_FICTION(2),
    SCIENCE(3),
    HISTORY(4),
    TECHNOLOGY(5),
    ART(6);
    
    
    
    
    //just for use the values of the enums. learn later.
    private int bookCategory;
    private BookCategory(int bookCategory){
        this.bookCategory = bookCategory;
    }
    public int getBookCategory() {
        return bookCategory;
    }
    
    public static BookCategory bookCategory(int userChoose){
        for (BookCategory category : BookCategory.values()) {
            if (category.getBookCategory() == userChoose) {
                System.out.println("category trying");
                return category;
            }
        }
        
        return null;
    }
    
    
    
}
