package Day7;

class order extends Thread {
    public void run() {
        try {
            System.out.println(getName() + " started");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Order is being processed...");
                Thread.sleep(1000);
            }
            System.out.println(getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

class Payment extends Thread {
    public void run() {
        System.out.println(getName() + " started");
        System.out.println("Payment is being processed...");
        System.out.println(getName() + " finished");
    }
}

class Notification extends Thread {
    public void run() {
        System.out.println(getName() + " started");
        System.out.println("Notification sent");
        System.out.println(getName() + " finished");
    }
}

public class multi {
    public static void main(String[] args) throws InterruptedException {

        order o = new order();
        Payment p = new Payment();
        Notification n = new Notification();

       
        o.setName("Order-Thread");
        p.setName("Payment-Thread");
        n.setName("Notification-Thread");

        
        o.setPriority(Thread.MAX_PRIORITY);
        p.setPriority(Thread.NORM_PRIORITY);
        n.setPriority(Thread.MIN_PRIORITY);

        o.start();

        System.out.println(o.getName() + " isAlive: " + o.isAlive());

      
        o.join();

  
        p.start();
        p.join();

    
        n.start();

        System.out.println(n.getName() + " isAlive: " + n.isAlive());
    }
}