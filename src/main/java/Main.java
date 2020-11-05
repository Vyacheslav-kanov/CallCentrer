import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    static private LinkedBlockingQueue callList = new LinkedBlockingQueue();

    public static void main(String[] args) {

        Atc atc = new Atc(callList);
        Thread atcThread = new Thread(atc, "ATC");
        atcThread.start();

        Specialist specialist1 = new Specialist(callList);
        Thread specialistThread1 = new Thread(specialist1, "Специалист1");
        specialistThread1.start();

        Specialist specialist2 = new Specialist(callList);
        Thread specialistThread2 = new Thread(specialist2, "Специалист2");
        specialistThread2.start();

        try {
            atcThread.join();

            specialist1.join();
            specialist2.join();

        } catch (InterruptedException e) {}
    }
}
