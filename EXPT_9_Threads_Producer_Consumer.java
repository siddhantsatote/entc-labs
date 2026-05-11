class SharedBuffer {
    private int data;
    private boolean hasData = false;

    synchronized void produce(int v) throws InterruptedException {
        while (hasData) {
            wait();  // buffer full, wait
        }
        data = v;
        hasData = true;
        System.out.println("Produced: " + v);
        notify();  // wake consumer
    }

    synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();  // buffer empty, wait
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();  // wake producer
    }
}

class Producer extends Thread {
    SharedBuffer buf;

    Producer(SharedBuffer b) {
        buf = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buf.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    SharedBuffer buf;

    Consumer(SharedBuffer b) {
        buf = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buf.consume();
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        SharedBuffer buf = new SharedBuffer();
        new Producer(buf).start();
        new Consumer(buf).start();
    }
}
