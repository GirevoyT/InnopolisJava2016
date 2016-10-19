package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class MyUDPClient {
	public static void main(String[] args) {
		try(DatagramSocket ds = new DatagramSocket();){
			byte[] data = "Привет".getBytes();
			InetAddress addr = InetAddress.getByName("localhost");
			DatagramPacket pack =
					new DatagramPacket(data, data.length, addr, 8080);
			ds.send(pack);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
