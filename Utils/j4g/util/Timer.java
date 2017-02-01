package j4g.util;

/**
 * Time watch for Runnable objects.
 */
public class Timer implements Runnable {

    private Runnable runnable;
    private long start;
    private long end;

    private Timer() {}

    public void run() {
        this.start = System.currentTimeMillis();
        this.runnable.run();
        this.end = System.currentTimeMillis();
    }

    public long ellapsedTime() {
        return this.end - this.start;
    }

    public static Timer with(Runnable object) {
        Timer timer = new Timer();
        timer.runnable = object;
        timer.run();
        return timer;
    }
}
