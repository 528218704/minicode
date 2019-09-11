package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digits2Letters {
	private static Map<String,String> digitLetterMap;
	
	static {
		digitLetterMap = new HashMap<String, String>();
		digitLetterMap.put("2", "ABC");
		digitLetterMap.put("3", "DEF");
		digitLetterMap.put("4", "GHI");
		digitLetterMap.put("5", "JKL");
		digitLetterMap.put("6", "MNO");
		digitLetterMap.put("7", "PQRS");
		digitLetterMap.put("8", "TUV");
		digitLetterMap.put("9", "WXYZ");
	}
	
	//Êý×Ö×ª×Ö·û
	public static List<String> convertDigits2Letters(int arr[]) {
		
		List<Integer> intList = new ArrayList<Integer>();
		if(arr.length == 1) {
			intList.add(arr[0]);
		}else {
			for(int i=0;i<arr.length-1;i++) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i] == 0) {
						break;
					}
					Integer a = Integer.parseInt(String.valueOf(arr[i]) + String.valueOf(arr[j]));
					if(a >= 0 && a <= 99 && !intList.contains(a)) {
						intList.add(a);
					}
				}
			}
		}
		
		List<String> strList = new ArrayList<String>();
		for(int d : intList) {
			if(d >=0 && d<= 9) {
				String letters = digitLetterMap.get(String.valueOf(d));
				if(letters != null) {
					char[] chars = letters.toCharArray();
					for(char ch : chars) {
						strList.add(String.valueOf(ch));
					}
				}
			}else {
				String str1 = String.valueOf(d).substring(0, 1);
				String str2 = String.valueOf(d).substring(1, 2);
				String letters1 = digitLetterMap.get(str1);
				String letters2 = digitLetterMap.get(str2);
				if(letters1 != null && letters2 != null) {
					for(char c1 : letters1.toCharArray()) {
						for(char c2 : letters2.toCharArray()) {
							strList.add(String.valueOf(c1) + String.valueOf(c2));
						}
					}
				}else {
					String str = (letters1==null?"":letters1) + (letters2==null?"":letters2);
					char[] chars = str.toCharArray();
					for(char ch : chars) {
						strList.add(String.valueOf(ch));
					}
				}
			}
		}
		
		return strList;
	}
}
