package zw.co.afrosoft;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread "+Thread.currentThread().getName());
            }
        });

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread "+t.getName()+"the error is "+e.getMessage());
            }
        });

        thread.setName("New worker thread");
        System.out.println("We are in thread: "+ Thread.currentThread().getName()+ " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: "+ Thread.currentThread().getName()+ " after starting a new thread");

        Thread.sleep(10000);
    }
}
