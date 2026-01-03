package store.model;

import java.util.Map;

public class Buyer implements Runnable {

    private final String name;
    private final Store store;
    private final Map<String, Integer> basket;

    public Buyer(String name, Store store, Map<String, Integer> basket) {
        this.name = name;
        this.store = store;
        this.basket = basket;
    }

    @Override
    public void run() {
        System.out.println("🛒 " + name + " започва пазаруване");

        for (Map.Entry<String, Integer> item : basket.entrySet()) {
            store.sell(item.getKey(), item.getValue(), name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("✅ " + name + " приключи покупките\n");
    }
}
