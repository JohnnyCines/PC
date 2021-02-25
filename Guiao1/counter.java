class Counter {
    long i;

    void increment(){
        i=i+1;
    }

    public long value(){
        return i;
    }
}

    
class Incrementer extends Thread{
    final Counter c;
    final int I;
    public Incrementer(int I, Counter c){
        this.I=I;
        this.c=c;
    }
    public void run(){
        for(int i=0; i<I; i++)
            c.increment();
        
        
    }
}

class Main{
        public static void main(String[] args) throws InterruptedException{
        final int N = Integer.parseInt(args[0]);
        final int I = Integer.parseInt(args[1]);
        Counter c=new Counter();
        Thread a[] = new Thread [N];
        for( int i=0; i<N; i++)
            a[i]=new Incrementer(I,c);
        for(int i=0; i<N; i++)
            a[i].start();
        for(int i=0; i<N; i++)
            a[i].join();
        System.out.println(c.value());
    }
}
