package ru.innopolis;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * Created by MasterPc on 22.11.2016.
 */
public class Main {
	public static void main(String[] args) throws BeansException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

		IgniteConfiguration igniteConfiguration = (IgniteConfiguration) ctx.getBean("ignite.cfg");

		Ignite ignite = Ignition.start(igniteConfiguration);

		IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

//		cache.clear();
//		for (int i = 0 ; i <10;i++) {
//			cache.put(i,"Мвахаха х"+i);
//		}
//
//
////		System.out.println(cache.getAndPut(11,"Test"));
//		cache.forEach((e) -> System.out.println(e.getValue()));



		IgniteCompute igniteCompute = ignite.compute();

		List<List<Integer>> separateArgs = separateList();
		Collection<Long> result = igniteCompute.apply(
				(List<Integer> arg) ->  {
					final AtomicLong sum  = new AtomicLong();
					arg.stream().filter((a) -> a%2==0).
							forEach((a) -> sum.accumulateAndGet(a,((b,c)->b+c)));
					return sum.get();
				}, separateArgs);
		System.out.println(result);
		ignite.close();

	}

	private static List<List<Integer>> separateList() {
		List<List<Integer>> result = new ArrayList<>();
		result.add(getArgList());
		result.add(getArgList());
		return result;
	}

	private static List<Integer> getArgList() {
		List<Integer> result = new ArrayList<>();
		Random random = new Random();
		for (int i = 0;i <100;i++) {
			int val = random.nextInt(100);
			result.add(val);
		}
		return result;
	}
}
