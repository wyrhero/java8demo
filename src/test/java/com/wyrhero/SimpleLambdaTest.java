package com.wyrhero;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SimpleLambdaTest {

    @Test
    public void ThreadRunTest(){
        //原来的创建线程方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Wolld! old method");
            }
        });
        t.run();

        //Lambda表达式创建线程
        Thread t1 = new Thread(()->{
            System.out.println("Hello Wolld! Lambda method");
        });
        t1.run();

        System.out.println(new Integer(1) == Integer.valueOf(1));
        System.out.println(new Integer(1) == 1);
        System.out.println(new Integer(1) == new Integer(1));

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs);
    }
}
