package itv.assignment.repository;

import itv.assignment.exception.InvalidProductCodeException;
import itv.assignment.model.Item;
import itv.assignment.rules.SpecialPrice;
import itv.assignment.rules.impl.SpecialPriceImpl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static itv.assignment.constants.SpecialPriceConstants.*;

public class ItemRepository implements Serializable {

    /**
     * Returns a list of items.
     * @return a list of items
     */
    public List<Item> getPredefinedItems() throws InvalidProductCodeException {
        return Arrays.asList(
               loadPredefinedItem(ITEM_CODE_A),
               loadPredefinedItem(ITEM_CODE_B),
               loadPredefinedItem(ITEM_CODE_C),
               loadPredefinedItem(ITEM_CODE_D)
        );
    }

    /**
     * Load a predefined item according its code.
     * @param code the product code
     * @return an item
     */
    private Item loadPredefinedItem(final String code) throws InvalidProductCodeException {
        final SpecialPrice specialPrice;
        final Item item;

        switch (code){
            case ITEM_CODE_A:
                specialPrice = new SpecialPriceImpl(130.0, 3);
                item = Item.builder().code(ITEM_CODE_A).price(50.0).build();
                item.setSpecialPrice(specialPrice);
                return item;
            case ITEM_CODE_B:
                specialPrice = new SpecialPriceImpl(45.0, 2);
                item = Item.builder().code(ITEM_CODE_B).price(30.0).build();
                item.setSpecialPrice(specialPrice);
                return item;
            case ITEM_CODE_C:
                item = Item.builder().code(ITEM_CODE_C).price(20.0).build();
                return item;
            case ITEM_CODE_D:
                item = Item.builder().code(ITEM_CODE_D).price(15.0).build();
                return item;
            default:
                throw new InvalidProductCodeException();
        }
    }
}