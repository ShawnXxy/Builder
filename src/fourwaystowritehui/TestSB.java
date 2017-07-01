package fourwaystowritehui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestSB {

	public void test() {
		
		List<String> sbs = new ArrayList<>();
		sbs.add("产品");
		sbs.add("运维");
		sbs.add("自己");
		sbs.add("测试");
		sbs.add("用户");
		
		Collections.shuffle(sbs);
		for (String sb : sbs) {
			boolean isSB = check(sb);
			if (sb.equals("自己")) {
				isSB = false;
			} else {
				
			}
			if (isSB) {
				System.out.println(sb + "是SB，算了， 为了SB" + sb + "我还是改一改吧");
				break;
			} else {
				System.out.println(sb + "不是SB，继续下一个");
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
