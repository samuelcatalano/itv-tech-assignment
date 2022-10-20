package itv.assignment.service.impl;

import itv.assignment.model.Item;
import itv.assignment.service.Checkout;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckoutImpl implements Checkout {

    private final Map<Item, Integer> specialPrices = new HashMap<>();
    private Double sum = 0.0;

    /**
     * Scan an item on the cart.
     * @param item the item to be scanned
     */
    @Override
    public void scan(final Item item) {
        if (hasItemSpecialPrice(item)) {
            storeItem(item);
        } else {
            sum = sum + item.getPrice();
        }
    }

    /**
     * Calculates the total of all items on the cart.
     * @return the total of all items
     * @throws Exception thrown
     */
    @Override
    public Double total() throws Exception {
        var subTotal = calculateSpecialPriceItems();
        return sum + subTotal;
    }

    /**
     * Calculates the subTotal os all items on the cart.
     * @return the subTotal os all items
     * @throws Exception thrown
     */
    private Double calculateSpecialPriceItems() throws Exception {
        var subTotal = new BigDecimal("0");
        for (Map.Entry<Item, Integer> entry : specialPrices.entrySet()) {
            subTotal = subTotal.add(BigDecimal.valueOf(entry.getKey().calculateSpecialPrice(entry.getValue())));
        }
        return subTotal.doubleValue();
    }

    /**
     * Verifies if an item is present with the special price.
     * @param item the item to be verified
     */
    private void storeItem(final Item item) {
        if (specialPrices.containsKey(item)) {
            var count = specialPrices.get(item);
            count++;
            specialPrices.put(item, count);
        } else {
            specialPrices.put(item, 1);
        }
    }

    /**
     * Validates if a itenm has a special price.
     * @param item the item to be validated
     * @return <code>true</code> or <code>false</code>
     */
    private boolean hasItemSpecialPrice(final Item item) {
        return item.getSpecialPrice() != null;
    }
}
