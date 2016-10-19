package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class MyUDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(8080);
			while (true) {
				DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
				ds.receive(pack);
				System.out.println(new String(pack.getData(),0,pack.getLength()));
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}