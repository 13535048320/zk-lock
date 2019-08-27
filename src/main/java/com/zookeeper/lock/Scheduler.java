package com.zookeeper.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔10秒执行一次
    @Scheduled(fixedRate = 10000)
    public void testTasks() {
        DistributedLock lock = new DistributedLock();
        try {
            lock.lock();
            System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
            try {
                for (int i = 0; i < 3; i++) {
                    new Thread(() -> {
                        System.out.println("线程" + Thread.currentThread() + "开始启动");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程" + Thread.currentThread() + "结束");
                    }).start();
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("定时任务结束时间：" + dateFormat.format(new Date()));
            System.out.println();
        } finally {
            lock.unlock();
        }
    }

}