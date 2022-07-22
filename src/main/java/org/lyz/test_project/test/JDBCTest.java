package org.lyz.test_project.test;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///my_test?charactorEncoding=utf-8";
            String user = "root";
            String pwd = "zc00xzc00x";
            Connection con = DriverManager.getConnection(url, user, pwd);
            String sql = "select u.username as name, u.nickname as nick, u.tel from `user_info` as u where u.tel = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1, "1");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String nick = rs.getString("nick");
                int tel = rs.getInt("tel");
                System.out.println(name + "-" + nick + "-" + tel);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
