public class TwoThreadDemo {

    public static class TaskA implements Runnable {
        private TwoThreadDemo demo;

        public TaskA(TwoThreadDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            synchronized (demo) {
                for (;;) {
                    System.out.println("A");
                    demo.notify();
                    try {
                        demo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static class TaskB implements Runnable {
        private TwoThreadDemo demo;

        public TaskB(TwoThreadDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            synchronized (demo) {
                for (;;) {
                    try {
                        demo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    demo.notify();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadDemo demo = new TwoThreadDemo();
        TaskA taskA = new TaskA(demo);
        TaskB taskB = new TaskB(demo);
        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskB);
        t2.start();
        t1.start();

        t1.join();
        t2.join();
    }
}
