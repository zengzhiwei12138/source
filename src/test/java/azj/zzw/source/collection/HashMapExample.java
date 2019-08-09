package azj.zzw.source.collection;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * hashMap相关测试用例
 *
 * @author zzw zengzhiwei_hfut@163.com
 * @see java.util.HashMap
 * @since 2019/8/9 0009-9:20
 */
public class HashMapExample {


    /**
     * 循环的阀值
     */
    private final Integer HOLD_SIZE = 100;

    /**
     * tableSizeFor方法返回的传入的参数最近的一个2的幂次方
     * 测试 HashMap 中的 tableSizeFor 方法
     * 调用 this(initialCapacity,loadFactor) 的时候  threshold 扩容的阀值调用的是 tableSizeFor方法
     */
    @Test
    public void testTableSizeFor() {
        try {
            // 根据反射获取hashMap的clazz
            Class<?> clazz = Class.forName("java.util.HashMap");
            // 获取clazz的方法 tableSizeFor
            Method method = clazz.getDeclaredMethod("tableSizeFor", int.class);
            // 设置方法可访问
            method.setAccessible(true);
            // 根据传入的参数调用方法
            for (int i = 1; i < HOLD_SIZE; i++) {
                Integer result = (Integer) method.invoke(null, i);
                System.out.println(i + "调用tableSizeFor方法的返回值是:" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试hashmap中的hash方法
     * 观察一下hashmap返回的hash值是否分散
     */
    @Test
    public void testHash() {
        try {
            // 根据反射获取hashmap的clazz
            Class<?> clazz = Class.forName("java.util.HashMap");
            // 获取hashmap的hash()方法
            Method method = clazz.getDeclaredMethod("hash", Object.class);
            // 设置方法可访问
            method.setAccessible(true);
            // 循环调用方法 打印返回值的二进制
            for (int j = 100; j < HOLD_SIZE * HOLD_SIZE; j++) {
                String key = "我是最帅的" + j;
                System.out.println("hashcode = " + Integer.toBinaryString(key.hashCode()));
                System.out.println(">>> = "+Integer.toBinaryString(key.hashCode() >>> 16));
                System.out.println("hash = " + Integer.toBinaryString((key.hashCode()) ^ (key.hashCode() >>> 16)));
                Integer result = (Integer) method.invoke(null, key);
                System.out.println(j + "调用hash方法的返回值是:" + Integer.toBinaryString(result));
            }

            // 1101101010111111111011011100001
            // 0000000000000000110110101011111
            // 1101101010111111001101110111110


            // 1101101010111111001101110111110
            // 1101101010111111001101110111110
            // hashmap的hash方法如下
            Object key = new Object();
            // ...
            int h;
            int result = key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
