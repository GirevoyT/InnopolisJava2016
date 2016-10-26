package ru.innopolis.course.java2016.girevoy.lessons.lesson18;

import java.sql.*;

/**
 * Created by masterlomaster on 26.10.16.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/test","postgres","Testarosa123");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from public.\"ATT\"");
        while (rs.next()) {
            System.out.println(rs.getInt("user_id") + " " + rs.getInt("lesson_id"));
        }
        connection.close();
    }

}
