package two;
//MAIN Thread 
public class MainExecutor {
    public static void main(String[] args) {
        System.out.println("Pozdrav iz MAIN THREAD : " + Thread.currentThread().getName());
        RunnableImplementation runnableImplementation = new RunnableImplementation();
        new Thread(runnableImplementation).start();
        new AnotherThread().start();
    }
}
