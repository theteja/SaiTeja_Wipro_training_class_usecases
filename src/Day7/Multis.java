package Day7;


import java.lang.*;

class orders extends Thread

{

	public void run() {
	try {
		for(int i=1; i<=5; i++) {
		System.out.println("Order is being processed...");
		Thread.sleep(3000);
	}
	}	
	catch(InterruptedException e)
	{
		System.out.println("Thread interrupted");

    }

}

}

class Payments extends Thread

{

public void run()

{

	System.out.println("Payment is being processed...");

}

}

class Notifications extends Thread

{

public void run()

{

	System.out.println("Notification sent");

}

}

public class Multis {

public static void main(String[] args)

{

orders o =new orders();

Payments p= new Payments();

Notifications n= new Notifications();

o.start();

p.start();

n.start();

}

}