package ��������;

/**
 * �̲߳��ֻ�������
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class List {
	/*
	 * ����һ������add���������Person���������У����ܱ����ظ��Ķ���
	 */
	public void add(Object[] o, Person newP) {
		if (newP == null)
			return;// ���Ҫ��ӵ�����Ϊ�գ����˳�
		if (!(newP instanceof Person))
			return;// �������Ҫ��ӵ���������͵Ķ������˳�
		boolean hasSame = false;// Ĭ�ϲ��ظ�
		for (int i = 0; i < o.length; i++) {
			// if����ж�����Ҳ������ôд��newP.equals(p[i]) �����Ϳ��Ա���p[i]Ϊ��ָ������
			// �����newP�ǵ���add�����Ķ���
			if (o[i] != null && o[i].equals(newP)) {
				System.out.println("�����ж����ظ�");
				hasSame = true;
				break;
			}
		}
		// ������ظ��������
		if (!hasSame) {
			boolean isFull = false;// Ĭ�ϲ���
			for (int i = 0; i < o.length; i++) {
				// ������鲻������ֱ�����
				if (o[i] == null) {
					o[i] = newP;
					break;
				}

				if (i == o.length - 1) {
					isFull = true;
				}
			}
			// ����������ˣ���̬����
			Person[] p1 = new Person[o.length + 1];
			p1[o.length] = newP;
			for (int j = 0; j < o.length; j++) {
				p1[j] = (Person) o[j];
			}
			o = p1;
		}
	}

	/*
	 * ����һ������contains(Person p).�ж��������Ƿ�����˸ö���(�������Ҳ�����)
	 */
	public boolean contains(Person[] p, Person pp) {
		if (pp == null)
			return false;// ���Ҫ��ӵ�����Ϊ�գ����˳�
		if (!(pp instanceof Person))
			return false;// �������Ҫ�Աȵ���������͵Ķ������˳�
		// boolean isContains = false;// Ĭ�ϲ�����
		for (int i = 0; i < p.length; i++) {
			if (pp.equals(p[i])) {
				// System.out.println("������" + pp.toString() + "����");
				// isContains = true;
				return true;

			}
		}
		return false;
//		if (!isContains) {
//			System.out.println("������" + pp.toString() + "����");
//		}
	}

	/*
	 * ����һ������indexOf(Person p).���������иö���(�����������)���±ꡣ
	 */
	public int indexOf(Person[] p, Person pp) {
		if (pp == null)
			return -1;
		if (!(pp instanceof Person))
			return -1;
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals(pp)) {

				return i;
			}
		}
		return -1;
	}

	/*
	 * ����һ������get (int index).�����±�Ϊindex�Ķ���
	 */
	public Person get(Person[] p, int index) {

		if (index < 0 || index > p.length - 1) {
			System.out.println("�������");
			return null;
		} else {
			return p[index];
		}

	}

	/*
	 * ����һ������clear().�����������������������
	 */
	public void clear(Person[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i] = null;
		}
	}
}
