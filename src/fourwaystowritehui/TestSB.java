package fourwaystowritehui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestSB {

	public void test() {
		
		List<String> sbs = new ArrayList<>();
		sbs.add("��Ʒ");
		sbs.add("��ά");
		sbs.add("�Լ�");
		sbs.add("����");
		sbs.add("�û�");
		
		Collections.shuffle(sbs);
		for (String sb : sbs) {
			boolean isSB = check(sb);
			if (sb.equals("�Լ�")) {
				isSB = false;
			} else {
				
			}
			if (isSB) {
				System.out.println(sb + "��SB�����ˣ� Ϊ��SB" + sb + "�һ��Ǹ�һ�İ�");
				break;
			} else {
				System.out.println(sb + "����SB��������һ��");
			}
		}
	}
	
	private boolean check (String sb){
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
