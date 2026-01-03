package store.model;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private final Map<String, Integer> products = new HashMap<>();

    public Store() {
        products.put("Хляб", 50);
        products.put("Мляко", 40);
        products.put("Яйца", 100);
        products.put("Сирене", 30);
    }

    public synchronized void sell(String product, int quantity, String buyerName) {
        int available = products.getOrDefault(product, 0);

        if (available >= quantity) {
            products.put(product, available - quantity);
            System.out.printf(
                    "[%s] ✔ Купи %d бр. %s | остава: %d%n",
                    buyerName, quantity, product, products.get(product)
            );
        } else {
            System.out.printf(
                    "[%s] ✖ Няма достатъчно %s (иска %d, налични %d)%n",
                    buyerName, product, quantity, available
            );
        }
    }


    public void printStock() {
        System.out.println("\n==============================");
        System.out.println("📦 ФИНАЛНИ НАЛИЧНОСТИ В МАГАЗИНА");
        System.out.println("==============================");

        products.forEach((product, quantity) ->
                System.out.printf("• %-10s : %d бр.%n", product, quantity)
        );
    }

}
