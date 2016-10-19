package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class MyServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket socket = serverSocket.accept();
			Scanner scanner = new Scanner(socket.getInputStream());
			System.out.println(scanner.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
