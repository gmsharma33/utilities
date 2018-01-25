package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPrimeOccurances {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 3, 3, 3, 3, 4, 4, 5 };
		int k = 2;
		new FindPrimeOccurances().findPrimeFrequencyNos(arr, k);
	}

	private void findPrimeFrequencyNos(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			if (isPrime(m.getValue())) {
				System.out.print(m.getKey() + ",");
			}
		}
	}

	private boolean isPrime(int in) {
		if (in == 1 || (in > 2 && in % 2 == 0)) {
			return false;
		}
		for (int i = 3; i <= (int) Math.sqrt(in); i+=2) {
			if (in % i == 0) {
				return false;
			}
		}
		return true;
	}

}
