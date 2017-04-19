package org.dao;

import org.db.DBConn;
import org.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class BookDao {
    Connection conn;

    public Book selectBook(String ISBN) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE ISBN = ?");
            preparedStatement.setString(1,ISBN);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Book book = new Book();
                book.setISBN(resultSet.getString(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPublisher(resultSet.getString(4));
                book.setPrice(resultSet.getFloat(5));
                book.setCnum(resultSet.getInt(6));
                book.setSnum(resultSet.getInt(7));
                book.setSummary(resultSet.getString(8));
                book.setPhoto(resultSet.getBytes(9));
                return book;
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBConn.CloseConn();
        }
    }

    public boolean updateBook(Book book) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE book SET bookName=?," +
                    "author=?,publisher=?,price=?,cnum=?,snum=?,summary=?,photo=? WHERE ISBN=?");
            preparedStatement.setString(1,book.getBookName());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getPublisher());
            preparedStatement.setFloat(4, book.getPrice());
            preparedStatement.setInt(5,book.getCnum());
            preparedStatement.setInt(6,book.getSnum());
            preparedStatement.setString(7,book.getSummary());
            preparedStatement.setBytes(8,book.getPhoto());
            preparedStatement.setString(9,book.getISBN());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConn.CloseConn();
        }
    }
    public boolean addBook(Book book) {
        try {
            conn =DBConn.getConn();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,book.getISBN());
            pstmt.setString(2,book.getBookName());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPublisher());
            pstmt.setFloat(5,book.getPrice());
            pstmt.setInt(6,book.getCnum());
            pstmt.setInt(7,book.getSnum());
            pstmt.setString(8,book.getSummary());
            pstmt.setBytes(9,book.getPhoto());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBConn.CloseConn();
        }
    }
    public boolean deleteBook(String ISBN)
    {
        try {
            conn = DBConn.getConn();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM book WHERE ISBN=?");
            pstmt.setString(1,ISBN);
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBConn.CloseConn();
        }
    }

}
