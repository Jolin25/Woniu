package com.woniuxy.multithreading.basic;

public class InterruptDemo implements Runnable {

	@Override
	public void run() {
		while(true) {
			
			if(Thread.interrupted()) {
				System.out.println("Thread has been interrupted");
				/*Thread.interruptedֻ���ж����ã�����һ������ֵ��
				�жϣ�Thread.interrupt���������ø��̳߳��׵Ľ�������ֹͣ��
				��Ϊ�̵߳Ľ�����ֹͣ��ȡ�����������״̬����CPU��Դ��
				���һ���̱߳��жϺ����������״̬��
				���������߳�������CPU��Դ�������������
				������Ҫ��Ϊ�����жϺ�Ľ������
				*/
				return;
			}else {
				System.out.println("keep on...");
			}
		}
	}

}
