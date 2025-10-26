// Bill pugh

class MyThread extends Thread{
    // @override
    public void run(){
        Singleton inst1 = Singleton.getInstance();
        // LLSingleton inst2 = LLSingleton.getInstance();
        
        // NonSingleton inst3 = new NonSingleton();
        
        for(int i = 0; i < 100; i++){
            try {
                System.out.println(Thread.currentThread().getName() + " inst1 " + inst1.val++);
                // System.out.println(Thread.currentThread().getName() + " inst2 "+ inst2.val++);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

class NonSingleton{
    public int val;
    public NonSingleton(){
        System.out.println("Instance created ");
    }
}

// Lazy Loading
class LLSingleton{
    private static LLSingleton instance;
    public int val;
    private LLSingleton(){
        System.out.println("Instance created ");
    }
    
    public static LLSingleton getInstance(){
        if(instance == null){
            instance = new LLSingleton();
        }
        return instance;
    }
}

// Bill pugh
class Singleton{
    public int val;
    private Singleton(){
        System.out.println("Instance created ");
    }

    public static class singletonHolder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        System.out.println("Getting Instance ");
        return singletonHolder.instance;
    }
}


class Main{
    public static void main(String[] args){
        // Singleton inst1 = Singleton.getInstance();
        // Singleton inst2 = Singleton.getInstance();
        // NonSingleton inst3 = new NonSingleton();

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        
        t1.setName("t1");
        t2.setName("t2");
        
        t1.start();
        // for(int i = 0; i < 1000000; i++);
        t2.start();

    }
}
