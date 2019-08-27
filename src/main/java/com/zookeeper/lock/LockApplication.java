package com.zookeeper.lock;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LockApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                while (true) {
//                    try {
//                        DistributedLock lock = new DistributedLock();
//                        try {
//                            lock.lock();
//                            for (int j = 0; j < 5; j++) {
//                                Thread.sleep(500);
//                                System.out.println(Thread.currentThread());
//                                Thread.sleep(1000);
//                            }
//                        }finally {
//                            lock.unlock();
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
    }
}
