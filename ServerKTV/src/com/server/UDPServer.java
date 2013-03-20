package com.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket server = new DatagramSocket(8080);
		byte[] recvBuf = new byte[100];
		DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
		server.receive(recvPacket);
		String recvStr = new String(recvPacket.getData(), 0, recvPacket
				.getLength());
		System.out.println("Client Data:" + recvStr);
		int port = recvPacket.getPort();
		InetAddress addr = recvPacket.getAddress();
		String sendStr = "we have received data that client sent!";
		byte[] sendBuf;
		sendBuf = sendStr.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,
				addr, port);
		server.send(sendPacket);
		server.close();
	}
}
