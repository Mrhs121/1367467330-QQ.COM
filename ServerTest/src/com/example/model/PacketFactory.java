package com.example.model;


import com.example.utils.Util;


public class PacketFactory {
	public static Packet createPacket(byte[] data) throws Exception {
		Packet packet;
		
		byte[] packetTypeBuffer = new byte[Util.INT_SIZE];
		System.arraycopy(data, 0, packetTypeBuffer, 0, Util.INT_SIZE);
		int packetType = Util.byte2int(packetTypeBuffer);
		System.out.println("packet type" + packetType);
		if (packetType == Util.PACKET_TYPE_LOGIN) {
			System.out.println("��¼��");
			packet = new LoginPacket();
		} else if(packetType == Util.PACKET_TYPE_MESSAGE) {
			System.out.println("��Ϣ��");
			packet = new MessagePacket();
		} else {
			throw new Exception("unknown packet!!!!");
			//packet = new LoginPacket(); 
		}
		return packet;
	}
}
