package org.dao;

import org.db.DBConn;
import org.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class StudentDao {
    Connection conn;
    public Student  selectByReaderId(String readerId) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from student WHERE readerId = ?");
            preparedStatement.setString(1,readerId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                Student student = new Student();
                student.setReaderId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setSex(rs.getBoolean(4));
                //student.setSex(rs.getBoolean(4));
                student.setBorn(rs.getDate(5));
                student.setSpec(rs.getString(3));
                student.setNum(rs.getInt(6));
                //student.setSnum(rs.getInt(7));
                System.out.println(student.getNum());
                student.setPhoto(rs.getBytes(8));
                return student;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBConn.CloseConn();
        }
    }

    public void updateStudent(Student student) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE student SET num = ? WHERE readerId=?");
            preparedStatement.setInt(1,student.getNum());
            preparedStatement.setString(2,student.getReaderId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.CloseConn();
        }
    }

}
