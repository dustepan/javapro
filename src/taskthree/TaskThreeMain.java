package taskthree;

/**
 * @author SDudin
 */
public class TaskThreeMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolCustom threadPoolCustom = new ThreadPoolCustom(3);
        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 1);
        });

        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 2);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 2);
        });

        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 3);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 3);
        });

        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 4);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 4);
        });


        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 5);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 5);
        });

        threadPoolCustom.shutdown();

        threadPoolCustom.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Start runnable " + 6);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Finish runnable " + 6);
        });
    }
}

