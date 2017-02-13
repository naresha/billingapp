package app.model

import groovy.transform.ToString

/**
 * Created by naresha on 13/02/17.
 */
@ToString(includeNames = true)
class ShoppingCart {

    Map<StockKeepingUnit, Integer> items = [:]

    boolean isEmpty() {
        items.isEmpty()
    }

    def addItem(StockKeepingUnit sku, Integer quantity) {
        items[sku] = quantity
    }

}
