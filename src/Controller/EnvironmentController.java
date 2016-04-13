package Controller;

import Model.*;
import java.util.Timer;
import java.util.TimerTask;

public class EnvironmentController {

    Timer timer;
    long s = 0;
    Iterator queue1;
    Iterator queue2;
    Iterator queue3;
    Iterator queue4;
    Environment environment;

    public EnvironmentController() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Iterate(), 100, 10);
        environment = Environment.getEnvironment(480, 70, 880, 70, 330, 130, 1030, 130);
        queue1 = environment.getIterator1();
        queue2 = environment.getIterator1();
        queue3 = environment.getIterator1();
        queue4 = environment.getIterator1();
    }

    public Shapes nextLUH() {
        return queue1.next_horzontal();
    }

    public Shapes nextLUV() {
        return queue1.next_vertical();
    }

    public Shapes nextRUH() {
        return queue2.next_horzontal();
    }

    public Shapes nextRUV() {
        return queue2.next_vertical();
    }

    public Shapes nextLDH() {
        return queue3.next_horzontal();
    }

    public Shapes nextLDV() {
        return queue3.next_vertical();
    }

    public Shapes nextRDH() {
        return queue4.next_horzontal();
    }

    public Shapes nextRDV() {
        return queue4.next_vertical();
    }

    public void beginLUH() {
        queue1.begin_horizontal();
    }

    public void beginLUV() {
        queue1.begin_vertical();
    }

    public void beginRUH() {
        queue2.begin_horizontal();
    }

    public void beginRUV() {
        queue2.begin_vertical();
    }

    public void beginLDH() {
        queue3.begin_horizontal();
    }

    public void beginLDV() {
        queue3.begin_vertical();
    }

    public void beginRDH() {
        queue4.begin_horizontal();
    }

    public void beginRDV() {
        queue4.begin_vertical();
    }

    class Iterate extends TimerTask {

        long beforeTime, timeDiff, sleep;

        @Override
        public void run() {
            environment.update();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 50 - timeDiff;

//            if (sleep < 0) {
//                sleep = 2;
//            }
//            try {
//                Thread.sleep(sleep);
//            } catch (InterruptedException e) {
//                System.out.println("interrupted");
//            }
//
//            beforeTime = System.currentTimeMillis();
        }
    }
}
