/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author canif
 */
public abstract class Database {
    protected final static String DB_BASE_URL = "jdbc:mysql://localhost";
    protected final static String USER = "root";
    protected final static String PASSWORD = "itsasecret";
    protected final static String DB_NAME = "Library";
    protected final static String TABLE_NAME_BOOKS = "LibraryBooks";
    protected final static String TABLE_NAME_MEMBERS = "LibraryMembers";
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    protected final static String TABLE_NAME_CHECKEDOUT = "thirdtable";
}
