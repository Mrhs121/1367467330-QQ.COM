package com.example.utils;

public class Util {
	public static final int PACKET_TYPE_LOGIN = 0x1001;
	public static final int PACKET_TYPE_MESSAGE = 0x1002;
	
	public static final int INT_SIZE = 4;
	public static final int INT_TYPE = 4;  // ����������ռ����
	public static final int INT_NAME = 4;  // ��Ϣ�ĳ��ȵ���Ϣ�ĳ���
	public static final int SHORT_SIZE = 2;
	
	
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];

		targets[0] = (byte) (res & 0xff);// ���λ
		targets[1] = (byte) ((res >> 8) & 0xff);// �ε�λ
		targets[2] = (byte) ((res >> 16) & 0xff);// �θ�λ
		targets[3] = (byte) (res >>> 24);// ���λ,�޷������ơ�
		return targets;
	}

	public static int byte2int(byte[] res) {
		// һ��byte��������24λ���0x??000000��������8λ���0x00??0000

		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | ��ʾ��λ��
				| ((res[2] << 24) >>> 8) | (res[3] << 24);
		return targets;
	}

}
