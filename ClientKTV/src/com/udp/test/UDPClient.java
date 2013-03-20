package com.udp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public UDPClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ∑¢ÀÕ÷∏¡Ó≤‚ ‘∫Ø ˝
	 * 
	 * @param portEtxtStr
	 * @param ipEtxtStr
	 * @param codeEtxtStr
	 * 
	 * @throws IOException
	 */
	public String send_msg(String codeEtxtStr, String ipEtxtStr, int portEtxtStr)
			throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket client = new DatagramSocket();
		String sendStr = codeEtxtStr;
		byte[] sendBuf;
		sendBuf = sendStr.getBytes();
		InetAddress addr = InetAddress.getByName(ipEtxtStr);
		int port = portEtxtStr;
		DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,
				addr, port);
		client.send(sendPacket);
		byte[] recvBuf = new byte[100];
		DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
		client.receive(recvPacket);
		String recvStr = new String(recvPacket.getData(), 0, recvPacket
				.getLength());
		client.close();
		return recvStr;
	}
}
