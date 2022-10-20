package itv.assignment;

import itv.assignment.model.Item;
import itv.assignment.service.impl.CheckoutImpl;
import itv.assignment.service.impl.ItemServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ItvAssignmentApp {

    private static final ItemServiceImpl itemService = new ItemServiceImpl();

    public static void main(String[] args) throws Exception {
        List<Item> cart;

        if (args.length > 0) {
            var codes = args[0].split(",");
            cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList(codes));
        } else {
            cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList("A", "A", "A"));
        }

        var checkout = new CheckoutImpl();
        for (var item : cart) {
            checkout.scan(item);
        }

        var codes = cart.stream().map(item -> "".concat(item.getCode())
                                        .concat(","))
                                        .reduce("", String::concat);

        var productCodes = new StringBuilder(codes);
        productCodes.setCharAt((codes.length() - 1), ' ');

        System.out.println("\n\nCheckout:");
        System.out.println("----------------------------");
        System.out.println("Basket: " + productCodes);
        System.out.println("Total price expected: £" + checkout.total());
    }
}
