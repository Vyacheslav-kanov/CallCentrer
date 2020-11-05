import java.util.concurrent.LinkedBlockingQueue;

public class Specialist extends Thread {


    private LinkedBlockingQueue callList;

    public Specialist(LinkedBlockingQueue callList){
        this.callList = callList;
    }

    @Override
    public void run() {
        try {
            while (callList.size() > 0) {
                try {
                    callList.remove();
                    System.out.println(Thread.currentThread().getName() + " вязл звонок!");
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                }
            }
        }finally {
            System.out.println(Thread.currentThread().getName() + " поток завершен!");
        }
    }
}
