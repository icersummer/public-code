package sunday;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * 随机生成一个长度为100的数组，里面数值的范围为【1-10】，找出出现次数最多和最少的数值？
 */
public class FrequencyFinding {

	public static void main(String[] args) {
		
		int[] array = generateArray();
		
		printArray(array);
		
		Map<Integer, Integer> middleResult = calculateTimes(array);

		printFinalResult(middleResult);
	}

	private static void printFinalResult(Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		Collection<Integer> values = map.values();
		
		Integer[] ints = values.toArray(new Integer[values.size()]);
		
		int[] a = getBiggestAndSmallest(ints);
		
		int bigNo =  getRightNo(map, a, 1);
		int smallNo = getRightNo(map, a, 0);
		
		System.out.println("big   most times: " + bigNo + ", tims " + a[0]);
		System.out.println("small most times: " + smallNo + ", tims " + a[1]);
	}

	private static int getRightNo(Map<Integer, Integer> map, int[] a, int i) {
		// TODO Auto-generated method stub
		int n;
		if(i == 1)	
			n = a[0];
		else 
			n = a[1];
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			Integer x = it.next();
			if(map.get(x).intValue() == n){
				// 需要考虑次数相等的情况
				return x;
			}
		}		
		
		return 0;
	}

	private static int[] getBiggestAndSmallest(Integer[] ints) {
		// TODO Auto-generated method stub
		int big = getNumber(ints, 1);
		int small = getNumber(ints, 0);
		
		int[] a = new int[2];
		a[0] = big;
		a[1] = small;
		return a;
	}

	private static int getNumber(Integer[] ints, int flag) {
		int len = ints.length;
		int resultNo = ints[0];
		for(int i = 1; i < len; i++){
			if(flag == 1)
				resultNo = (ints[i] > resultNo) ? ints[i].intValue() : resultNo;
			else if(flag == 0)
				resultNo = (ints[i] < resultNo) ? ints[i].intValue() : resultNo;					
		}
		
		return resultNo;
	}

	private static Map<Integer, Integer> calculateTimes(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int a : array){
			Integer currenyKey = new Integer(a);
			if(map.get(currenyKey) != null){
				map.put(currenyKey, map.get(currenyKey).intValue() + 1);
			} else {
				map.put(currenyKey, 1);
			}
		}
		return map;
	}

	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " , ");
			if((i+1) % 10 == 0)
				System.out.println();
		}
	}
	
	private static int[] generateArray() {
		// TODO Auto-generated method stub
		
		int[] a = new int[100];
		for(int i =0; i<a.length; i++ ){
//			int x = (int)(Math.random() * 10);
//			i = x;
			
			Random generator = new Random();
			int y = generator.nextInt(10);
			a[i] = y;
		}
		
		return a;
	}

}
