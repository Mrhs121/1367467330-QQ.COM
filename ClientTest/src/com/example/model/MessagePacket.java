package com.example.model;


import com.example.utils.Util;

public class MessagePacket extends Packet {
	private String mfriendName;
	private String mContent;
	
	public void process() {
		System.out.println("message to: " + mfriendName + ", content: " + mContent);
	}
	
	/**
	 * �����л�����
	 */
	@Override
	public byte[] serialize() {
		byte[] message = new byte[Util.INT_TYPE+Util.INT_NAME+mfriendName.length()+mContent.length()];
		int offset = 0;
		
		// �����������  ռ4������
		byte[] type = Util.int2byte(Util.PACKET_TYPE_MESSAGE);
		System.arraycopy(type, 0, message, offset, Util.INT_TYPE); // ���һ������Ϊ������ռ�ĳ���
		offset+=Util.INT_TYPE;
		
		// ����friendName�ĳ���  ռ4������
		byte[] nameLength = Util.int2byte(mfriendName.length());
		System.arraycopy(nameLength, 0, message, offset, Util.INT_NAME);
		offset+=Util.INT_NAME;
		
		//����friendName ռ��friendName.length()������
		System.arraycopy(mfriendName.getBytes(), 0, message, offset, mfriendName.length());
		offset+=mfriendName.length();
		
		// ��������Ҫ���͵���Ϣ
		System.arraycopy(mContent.getBytes(), 0, message, offset, mContent.length());
		offset+=mContent.length();
		
		return message;
	}

	public String getMfriendName() {
		return mfriendName;
	}

	public void setMfriendName(String mfriendName) {
		this.mfriendName = mfriendName;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
	
}
