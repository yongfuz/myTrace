package com.pactera.bg.budsc.bank.zhang_yong_fu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pactera.bg.budsc.bank.yongfu.YongFuBootStrap;
import com.pactera.bg.budsc.bank.yongfu.util.RedisUtil;

/**
 * Unit test for simple App.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {YongFuBootStrap.class})
public class AppTest {

	@Resource
	private RedisUtil redisUtil;

	@Test
	public void test1() {
		String str = "fds67gvd8safd8saf8ds";
		String str1 = "67v";
		boolean contains = str.contains(str1);
		System.out.println(contains);
	}

	@Test
	public void test2() {
		redisUtil.set(15,"aaa", "111111111111111");
		redisUtil.set(15,"aaa", "111111111111111");
	}

	public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		@SuppressWarnings("unchecked")
		List<T> dest = (List<T>) in.readObject();
		return dest;
	}
	
	@Test
	public void test3(){
		String str="'',152531,210204,210211,210212,220104,110102,110105,110108,110114,130631,130682,610112,610404,610423,\',\',''";
		String substring = str.substring(2).substring(0,str.length()-8);
		System.out.println(substring);
	}
}
