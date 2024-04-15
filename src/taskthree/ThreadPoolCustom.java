package taskthree;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author SDudin
 */
public class ThreadPoolCustom {

    LinkedList<Runnable> runnableList = new LinkedList<>();
    final Object obj = new Object();
    AtomicBoolean aBoolean = new AtomicBoolean(true);


    public ThreadPoolCustom(int countPool) throws InterruptedException {
        for (int i = 0; i < countPool; i++) {
            new Thread(() -> {
                synchronized (obj) {
                    while (runnableList.isEmpty()) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }
                while (!listIsEmpty()) {
                    runnable().run();
                }
            }).start();
        }
    }


    public void execute(Runnable runnable) {
        synchronized (obj) {
            if (aBoolean.get()) {
                runnableList.add(runnable);
                obj.notifyAll();
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void shutdown() {
        aBoolean.set(false);
        Thread.currentThread().interrupt();
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
