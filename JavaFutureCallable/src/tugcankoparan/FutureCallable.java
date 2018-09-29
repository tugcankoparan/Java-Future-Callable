package tugcankoparan;
import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.Future;

public class FutureCallable{
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		FactorialCalculator task = new FactorialCalculator(4); 
		System.out.println("Submitting Task ..."); 
		Future<Long> future = threadpool.submit(task);
        long factorial = (long) future.get();
        System.out.println("Factorial is : " + factorial); 
        threadpool.shutdown();
	} 
	private static class FactorialCalculator implements Callable<Long> { 

		private final long number; 
		
		public FactorialCalculator(long number) { 
			this.number = number; 
			}
		
	     	@Override
	     	public Long call() { 
			long output = 0;
			try { 
				output = factorial(number);
			} catch (InterruptedException ex) { 
			}
			return output;
		}
	     	
		private long factorial(long number) throws InterruptedException {
			if (number < 0) { 
				throw new IllegalArgumentException("Number must be greater than zero"); 
				}
		long result = 1;
		while (number > 0) {
			Thread.sleep(1);
			 result = result * number;
             number--;
		}
		 return result;
    }
}
}
 