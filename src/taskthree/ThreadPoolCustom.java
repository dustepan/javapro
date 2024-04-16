package taskthree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SDudin
 */
public class ThreadPoolCustom {

    private LinkedList<Runnable> runnableList = new LinkedList<>();
    private List<Thread> threadList = new ArrayList<>();
    private final Object obj = new Object();
    private volatile boolean isShutdown = false;

    public ThreadPoolCustom(int countPool) {
        for (int i = 0; i < countPool; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    synchronized (obj) {
                        while (listIsEmpty()) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (!listIsEmpty()) {
                        runnable().run();
                    }
                    if (listIsEmpty() && isShutdown) {
                        return;
                    }
                }
            });
            threadList.add(thread);
            threadList.get(i).start();
        }
    }


    public void execute(Runnable runnable) {
        synchronized (obj) {
            if (!isShutdown) {
                runnableList.add(runnable);
                obj.notifyAll();
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (Thread thread : threadList) {
            thread.interrupt();
        }
    }

    private boolean listIsEmpty() {
        synchronized (obj) {
            return runnableList.isEmpty();
        }
    }

    private Runnable runnable() {
        synchronized (obj) {
            return runnableList.removeFirst();
        }
    }

}
