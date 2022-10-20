package itv.assignment.service.impl;

import itv.assignment.exception.InvalidProductCodeException;
import itv.assignment.model.Item;
import itv.assignment.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl {

    private final ItemRepository itemRepository;

    /**
     * Constructor.
     */
    public ItemServiceImpl() {
        itemRepository = new ItemRepository();
    }

    /**
     * Returns an item by its code.
     * @param code the item code to be filtered.
     * @return an item by its code
     */
    public Item getItemByCode(final String code) throws InvalidProductCodeException {
        return getPredefinedItems().stream()
               .filter(item -> item.getCode().equals(code))
               .findFirst()
               .orElseThrow(InvalidProductCodeException::new);
    }

    /**
     * Returns a list of items.
     * @return a list of items
     */
    public List<Item> getPredefinedItems() throws InvalidProductCodeException {
        return itemRepository.getPredefinedItems();
    }

    /**
     * Add a list of product codes to be scanned.
     * @param productCodes the list of product codes
     * @return list of {@link Item}
     */
    public List<Item> addProductsOnBaskByListOfCodes(final List<String> productCodes) throws InvalidProductCodeException {
        final List<Item> items = new ArrayList<>();
        for (var code : productCodes) {
            try {
                items.add(getItemByCode(code));
            } catch (final Exception e) {
                throw new InvalidProductCodeException();
            }
        }
        return items;
    }
}
