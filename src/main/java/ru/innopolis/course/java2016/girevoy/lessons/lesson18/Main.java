package ru.innopolis.course.java2016.girevoy.lessons.lesson18;

import java.sql.*;

/**
 * Created by masterlomaster on 26.10.16.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from att");
        while (rs.next()) {
            System.out.println(rs.getInt("USER_ID") + " " + rs.getInt("LESSON_ID"));
        }
        connection.close();
    }

}
