package two;
//int i = 0
//Thread 1  
//Thread 2 
//1. DOhvatiti podatak
// Thread 1--> i = 1
// Thread 2--> i = 1
//2. Izmijeniti podatak
// Thread 1 --> i++ -> i = 2
// Thread 2 --> i-- -> i = 0
//3. Vratiti izmijenjeni podatak
// Thread 1 -> vraća i = 2
// Thread 2 -> vraća i = 0
public class RunnableImplementation implements Runnable{

    @Override
    public void run() {
        System.out.println("Pozdrav iz drugog Threada: " + Thread.currentThread().getName());
    }   
}
