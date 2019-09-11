package minicode;

import java.util.List;

import org.junit.Test;

import util.Digits2Letters;

/**
 * µ¥Ôª²âÊÔ´úÂë
 * @author chenyongjian
 *
 */
public class MiniCodeTest {
	@Test
	public void test() {
		int[] arr = {1,2,3,4};
		List<String> strList = Digits2Letters.convertDigits2Letters(arr);
		for(String str : strList) {
			System.out.println(str);
		}
	}
}
