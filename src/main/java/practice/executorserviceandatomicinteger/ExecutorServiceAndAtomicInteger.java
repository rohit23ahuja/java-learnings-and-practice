package practice.executorserviceandatomicinteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorServiceAndAtomicInteger {

	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(1);
		Runnable r = () -> {
			log.info("Current Thread name [{}] and Current value of Counter [{}]", Thread.currentThread().getName(),
					counter.incrementAndGet());
		};
		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			service.submit(r);
		}
		service.shutdown();
	}
}
