package org.dao;

import org.db.DBConn;
import org.model.Login;

import java.sql.*;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class LoginDao {
    Connection conn;

    public Login checkLogin(String name, String password) {
        try {
            conn = DBConn.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM login WHERE name=? AND password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                login.setId(rs.getInt(1));
                login.setName(rs.getString(2));
                login.setPassword(rs.getString(3));
                login.setRole(rs.getBoolean(4));
                return login;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBConn.CloseConn();
        }
        //return null;
        // }
    }
}