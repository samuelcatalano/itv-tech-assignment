package itv.assignment.model;

import itv.assignment.model.base.BaseModel;
import itv.assignment.rules.SpecialPrice;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseModel {

    private String code;
    private Double price;
    private transient SpecialPrice specialPrice;

    public Double calculateSpecialPrice(final int number) throws Exception {
        return specialPrice.calculatePrice(number, price);
    }
}
