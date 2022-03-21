package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wxn
 * 2022/2/16 17:28
 */


public class Test {
	int b = 3;
	public void a(AtomicInteger n){
		if (n.intValue() == 205) {
			return;
		}
		System.out.println(n);
		n.getAndIncrement();
		a(n);
		System.out.println(n);
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.a(new AtomicInteger(200));
	}
}
