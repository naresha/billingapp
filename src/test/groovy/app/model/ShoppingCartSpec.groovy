package app.model

import spock.lang.Specification

/**
 * Created by naresha on 13/02/17.
 */
class ShoppingCartSpec extends Specification {

    def "A shopping cart is initially empty"() {
        when:
        ShoppingCart cart = new ShoppingCart()

        then:
        cart.isEmpty()
    }

    def "Items can be added to the cart"() {
        given:
        StockKeepingUnit book = new StockKeepingUnit(
                description: 'book',
                category: ProductCategory.BOOK,
                unitPrice: 12.49,
                imported: false)
        ShoppingCart cart = new ShoppingCart()
        StockKeepingUnit perfume = new StockKeepingUnit(
                description: 'Imported Perfume',
                category: ProductCategory.OTHER,
                unitPrice: 47.50,
                imported: true)

        when:
        cart.addItem(book, 2)

        then:
        cart.items.size() == 1
        and:
        cart.items[book] == 2

        when:
        cart.addItem(perfume, 1)

        then:
        cart.items.size() == 2
        and:
        cart.items[perfume] == 1
    }
}
