package ru.innopolis.course.java2016.girevoy.lessons.lesson18;

import java.sql.*;

/**
 * Created by masterlomaster on 26.10.16.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TestBD;","sa","Testarosa123");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from ATT");
        while (rs.next()) {
            System.out.println(rs.getInt("user_id") + " " + rs.getInt("lesson_id"));
        }
        connection.close();
    }

}
