class Singleton{
    private static Singleton obj = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(obj==null)
            obj = new Singleton();
        
        return obj;
    }
}

// --------------------------- Threads --------------------
class Counter{
    private int i;
    void inc() {
        i++;
    }
    int getI() return i;
}

class TestThread implements Runnable{
    private i;
    void run(){
        for(int i=0; i<5; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        TestThread thread = new TestThread();
        Thread t = new Thread(thread);
        t.start();
    }
}

class Another{
    public static void main(String[] args) throws Exception{
        Counter c = new Counter;
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<1000; i++){
                    c.inc();
                }
            }
        });

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<1000; i++){
                    c.inc();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join(); // ask main to complete its job
        t2.join();

        System.out.println(c.getI());
    }
}