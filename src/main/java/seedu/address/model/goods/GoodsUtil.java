package seedu.address.model.goods;

import java.util.List;

/**
 * Contains a set of utility methods for goods.
 */
public class GoodsUtil {
    /**
     * Return a list of goods belonging to a specific supplier.
     * @param supplier A valid supplier name.
     * @param goodsList A list of goods.
     */
    public static List<Goods> filterGoodsBySuppliers(String supplier, List<Goods> goodsList) {
        return goodsList.stream().filter(g -> g.isFromSupplier(supplier)).toList();
    }

    /**
     * Return the total quantity of goods belonging to a specific supplier.
     * @param supplier A valid supplier name.
     * @param goodsList A list of goods.
     */
    public static int sumQuantityBySuppliers(String supplier, List<Goods> goodsList) {
        return goodsList.stream().filter(g -> g.isFromSupplier(supplier))
                                 .map(g -> g.getQuantity())
                                 .reduce((t, g) -> t + g)
                                 .orElse(0);
    }

    /**
     * Return the sum of price totals from a list of goods.
     * @param goodsList A list of goods.
     */
    public static int sumTotals(List<Goods> goodsList) {
        return goodsList.stream().map(g -> g.getPriceTotal())
                                 .reduce((t, g) -> t + g)
                                 .orElse(0);
    }
}
