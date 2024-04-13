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
                while (!runnableList.isEmpty()) {
                    try {
                    runnableList.removeFirst().run();
                    Thread.sleep(20);
                    } catch (Exception e){
                        //здесь иногда возникает удаление из листста двумя потоками одновременно,
                        // к сожалению идей как это починить не пришло. При синхронизации начинает работать некорректно код.
                        //То есть выполнять задачи в одном потоке. Если у Вас есть решение данной проблемы, буду рад его выслушать.
                        //При добалвении sleep проблемы более не наблюдал
                    }
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
    }

}
