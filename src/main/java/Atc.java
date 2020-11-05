import sun.misc.Queue;

import java.util.concurrent.LinkedBlockingQueue;

public class Atc extends Thread{

    private LinkedBlockingQueue callList;

    public Atc (LinkedBlockingQueue callList){
        this.callList = callList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    for (int j = 0; j < 10; j++) {
                        callList.put(new Object());
                    }

                    System.out.println(Thread.currentThread().getName() + " 10 новых звонков!");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {}

            }
        }finally {
            System.out.println(Thread.currentThread().getName() + " поток завершен!");
        }
    }
}
