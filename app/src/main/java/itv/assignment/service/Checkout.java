package itv.assignment.service;

import itv.assignment.model.Item;

public interface Checkout {

    void scan(Item item) throws Exception;
    Double total() throws Exception;
}
