package itv.assignment;

import itv.assignment.exception.InvalidProductCodeException;
import itv.assignment.model.Item;
import itv.assignment.service.Checkout;
import itv.assignment.service.impl.CheckoutImpl;
import itv.assignment.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItvAssignmentAppTest {

    private final ItemServiceImpl itemService;
    private final Checkout checkout;

    private static final String EXCEPTION_MESSAGE = "One or more products have invalid codes!";

    ItvAssignmentAppTest() {
        itemService = new ItemServiceImpl();
        checkout = new CheckoutImpl();
    }

    @Test
    void test_validate_predefined_items_size() throws Exception {
        //given
        var items = itemService.getPredefinedItems();
        // then
        assertThat(items.size(), is(4));
    }

    @Test
    void test_validate_amount_predefined_items() throws Exception {
        // given
        var items = itemService.getPredefinedItems();
        var amountGiven = items.stream().map(Item::getPrice).reduce(0.0, Double::sum);
        // when
        var amountExpected = Double.valueOf(115.0);
        // then
        assertThat(amountGiven, is(amountExpected));
    }

    @Test
    void test_validate_item_code_A_predefined_items() throws Exception {
        //given
        var cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList("A", "A", "A"));
        for (var item : cart) {
            checkout.scan(item);
        }

        var amountGiven = checkout.total();
        // when
        var amountExpected = Double.valueOf(130.0);
        // then
        assertThat(amountGiven, is(amountExpected));
    }

    @Test
    void test_validate_item_code_B_predefined_items() throws Exception {
        //given
        var cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList("B", "B"));
        for (var item : cart) {
            checkout.scan(item);
        }

        var amountGiven = checkout.total();
        // when
        var amountExpected = Double.valueOf(45.0);
        // then
        assertThat(amountGiven, is(amountExpected));
    }

    @Test
    void test_validate_items_both_A_and_B_codes_predefined_items() throws Exception {
        //given
        var cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList("A", "A", "A", "B", "B"));
        for (var item : cart) {
            checkout.scan(item);
        }

        var amountGiven = checkout.total();
        // when
        var amountExpected = Double.valueOf(175.0);
        // then
        assertThat(amountGiven, is(amountExpected));
    }

    @Test
    void test_validate_items_random_codes_predefined_items() throws Exception {
        //given
        var cart = itemService.addProductsOnBaskByListOfCodes(Arrays.asList("D", "B", "C", "A"));
        for (var item : cart) {
            checkout.scan(item);
        }

        var amountGiven = checkout.total();
        // when
        var amountExpected = Double.valueOf(115.0);
        // then
        assertThat(amountGiven, is(amountExpected));
    }

    @Test()
    void test_validate_invalid_product_code() {
        InvalidProductCodeException thrown = assertThrows(
                InvalidProductCodeException.class,
                () -> itemService.addProductsOnBaskByListOfCodes(Collections.singletonList("X")),
                "Expected throw a new InvalidProductCodeException()"
        );
        assertTrue(thrown.getMessage().contains(EXCEPTION_MESSAGE));
    }
}
