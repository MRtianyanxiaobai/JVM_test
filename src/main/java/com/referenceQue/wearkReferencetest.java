package com.referenceQue;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


public class wearkReferencetest {

//    public  ReferenceQueue<WeakReference>
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch(InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();


        Object value = new Object();
        Map<Object, Object> map = new WeakHashMap<>();
        for(int i = 0;i < 10000;i++) {
            byte[] bytes = new byte[1 * 1024 * 1024];
            //这里使用弱引用，GC时就会回收之前的所有弱引用
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes,referenceQueue);
            map.put(weakReference, value);
        }
        Thread.sleep(1000);
        System.out.println("map.size->" + map.size());
        System.out.println("map.keySey.size->"+map.keySet().size());
        for (Object o : map.keySet()){
            System.out.println(((WeakReference<byte[]>)o).get());
        }
    }
}
