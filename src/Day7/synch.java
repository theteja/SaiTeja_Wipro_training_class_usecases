package Day7;

class FoodDeliverys extends Thread {

    static synchronized void process(String name) {
        try {
            System.out.println(name + " started");
            Thread.sleep(2000);
            System.out.println(name + " completed");
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }

    public FoodDeliverys(String name) {
        setName(name);
    }

    public void run() {
        process(getName()); 
    }
}

public class synch {
    public static void main(String[] args) throws InterruptedException {

        FoodDelivery order = new FoodDelivery("Order Processing ");
        FoodDelivery kitchen = new FoodDelivery("Kitchen Processing ");
        FoodDelivery delivery = new FoodDelivery("Delivery Processing ");

        order.setPriority(Thread.MAX_PRIORITY);
        kitchen.setPriority(Thread.NORM_PRIORITY);
        delivery.setPriority(Thread.MIN_PRIORITY);

        order.start();
        kitchen.start();

        System.out.println("Is order Alive? " + order.isAlive());

        order.join();
        kitchen.join();

        delivery.start();
        delivery.join();

        System.out.println("All tasks completed.");
    }
}