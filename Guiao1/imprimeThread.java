class Printer extends Thread{
    final int I;
    final int id;
    public Printer(int I, int id){
        this.I = I;
        this.id=id;
    }
    public void run(){
        for(int i=0; i<I; ++i)
            System.out.println("Thread:" + id + "num:" + i+1);
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException{
        final int N=Integer.parseInt(args[0]);
        final int I=Integer.parseInt(args[1]);
        Thread a[]= new Thread[N];
        for(int i=0; i<N; ++i)
            a[i]=new Printer(I,i);
        for(int i=0; i<N; ++i)
            a[i].start();
        for(int i=0; i<N; ++i)
            a[i].join();
    }
}