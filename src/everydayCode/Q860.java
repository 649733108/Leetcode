package everydayCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2020/12/11 10:34
 */


public class Q860 {
	public boolean lemonadeChange(int[] bills) {

		Map<Integer,Integer> account = new HashMap<>();
		account.put(5, 0);
		account.put(10, 0);
		account.put(20, 0);
		if (bills.length == 0){
			return true;
		}
		for (int i = 0 ; i<bills.length ; i++){
			if (bills[i]==5){
				account.put(5, account.get(5)+1);
			}else if (bills[i]==10){
				if (account.get(5)>0){
					account.put(5, account.get(5)-1);
					account.put(10, account.get(10)+1);
				}else {
					return false;
				}
			}else {//bills[i]==20
				if (account.get(10)>0){
					if (account.get(5)>0){
						account.put(10, account.get(10)-1);
						account.put(5, account.get(5)-1);
						account.put(20, account.get(20)+1);
					}else {
						return false;
					}
				}else {
					if (account.get(5)>=3){
						account.put(5, account.get(5)-3);
						account.put(20, account.get(20)+1);
					}else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
