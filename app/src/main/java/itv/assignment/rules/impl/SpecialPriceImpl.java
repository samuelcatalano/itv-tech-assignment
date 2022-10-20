package itv.assignment.rules.impl;

import itv.assignment.rules.SpecialPrice;

public class SpecialPriceImpl implements SpecialPrice {

    private final Integer number;
    private final Double discountPrice;

    /**
     * Constructor.
     * @param discountPrice the discount price for quantity
     * @param number the number os items to reach the discount price
     */
    public SpecialPriceImpl(final Double discountPrice, final int number) {
        this.discountPrice = discountPrice;
        this.number = number;
    }

    /**
     * Calculate the price given a quantity and an item price.
     * @param quantity the quantity in offer
     * @param priceItem the item price
     * @return the sum of the special price
     */
    @Override
    public Double calculatePrice(final int quantity, final Double priceItem) {
        if (quantity == this.number) {
            return discountPrice;
        } else if (quantity < this.number) {
            return (priceItem * quantity);
        } else {
            int division = quantity / this.number;
            int rest = quantity % this.number;
            return ((division * this.discountPrice) + (rest * priceItem));
        }
    }
}