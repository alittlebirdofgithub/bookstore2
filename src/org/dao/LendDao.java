package org.dao;

import org.db.DBConn;
import org.model.Lend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class LendDao {
    Connection conn;

    public List selectLend(String readerId, int pageNow, int pageSize) {
        try {
            List list = new ArrayList();
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "SELECT l.bookId,l.ISBN,b.bookName,b.publisher,b.price,l.lTime " +
                    "FROM lend AS l, book AS b " +
                    "WHERE readerId=? AND b.ISBN=l.ISBN limit "+(pageNow-1)*pageSize+","+pageSize);/* AND l.bookId NOT IN " +
                    "(SELECT l.bookId FROM lend AS l limit 0,"+pageSize*(pageNow-1) +") " +
                    "limit 0,"+ pageSize);*/
            preparedStatement.setString(1,readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lend lend = new Lend();
                lend.setBookId(resultSet.getString(1));
                lend.setISBN(resultSet.getString(2));
                lend.setBookName(resultSet.getString(3));
                lend.setPublisher(resultSet.getString(4));
                lend.setPrice(resultSet.getFloat(5));
                lend.setLendTime(resultSet.getString(6));
                list.add(lend);
                System.out.println("The reslutSet Date: \n "+ resultSet.getTimestamp(6).toString()+"\nGet The SQL Result --- selectLend by readerId !");
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBConn.CloseConn();
        }
    }

    public int selectLendSize(String readerId) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "SELECT COUNT(*) FROM lend WHERE readerId = ?");
            preparedStatement.setString(1,readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int pageCount = resultSet.getInt(1);
                System.out.println("Get The SQL Result --- selectLendSize by readerId !");
                return pageCount;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBConn.CloseConn();
        }
    }

    public Lend selectByBookId(String bookId) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM lend WHERE bookId=?");
            preparedStatement.setString(1,bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Lend lend = new Lend();
                lend.setBookId(resultSet.getString(1));
                lend.setReaderId(resultSet.getString(2));
                lend.setBookName(resultSet.getString(3));
                lend.setPublisher(resultSet.getString(4));
                lend.setPrice(resultSet.getFloat(5));
                lend.setISBN(resultSet.getString(6));
                lend.setLendTime(resultSet.getString(7));
                return lend;
            } else  return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBConn.CloseConn();
        }
    }

    public boolean addLend(Lend lend) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO lend VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,lend.getBookId());
            preparedStatement.setString(2,lend.getReaderId());
            preparedStatement.setString(3,lend.getBookName());
            preparedStatement.setString(4,lend.getPublisher());
            preparedStatement.setFloat(5,lend.getPrice());
            preparedStatement.setString(6,lend.getISBN());
            preparedStatement.setString(7, new Timestamp(System.currentTimeMillis()).toString());
            preparedStatement.execute();
            return true;
        } catch ( Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConn.CloseConn();
        }
    }

}
