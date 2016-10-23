package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class ClientSocket {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8080);
			OutputStream outputStream = socket.getOutputStream();
			for (int i = 1;i < 2;i++) {
				outputStream.write(("Привет" + i).getBytes());
			}

		} catch (IOException e) {


		}
	}
}
