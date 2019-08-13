import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(10000);
                return new Object();
            }
        });
        task.run();
        System.out.println("321");
        task.get();
        System.out.println("123");

    }
}
