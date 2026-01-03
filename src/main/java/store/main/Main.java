package store.main;

import store.model.Buyer;
import store.model.Store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Store store = new Store();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {

            Map<String, Integer> basket = new HashMap<>();
            basket.put("Хляб", 2);
            basket.put("Мляко", 1);
            basket.put("Яйца", 3);

            Buyer buyer = new Buyer("Купувач " + i, store, basket);
            executor.execute(buyer);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        store.printStock();
    }
}
