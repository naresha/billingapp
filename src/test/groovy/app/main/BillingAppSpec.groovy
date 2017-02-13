package app.main

import app.model.Invoice
import app.model.ProductCategory
import app.model.ShoppingCart
import app.model.StockKeepingUnit
import spock.lang.Specification

/**
 * Created by naresha on 13/02/17.
 */
class BillingAppSpec extends Specification {

    public static final StockKeepingUnit BOOK = new StockKeepingUnit(description: 'Book', unitPrice: 12.49,
            category: ProductCategory.BOOK)
    public static final StockKeepingUnit MUSIC_CD = new StockKeepingUnit(description: 'Music CD', unitPrice: 14.99,
            category: ProductCategory.OTHER)
    public static final StockKeepingUnit IMPORTED_PERFUME = new StockKeepingUnit(description: 'Imported Perfume',
            unitPrice: 47.50, category: ProductCategory.OTHER, imported: true)

    BillingApp billingApp = new BillingApp()


    def "Cannot checkout empty cart"() {
        given:
        ShoppingCart cart = new ShoppingCart()

        when:
        billingApp.checkout(cart)

        then:
        thrown IllegalArgumentException
    }


    def "Checkout shopping cart with three items"() {
        given:
        ShoppingCart cart = new ShoppingCart()
        cart.addItem(BOOK, 1)
        cart.addItem(MUSIC_CD, 1)
        cart.addItem(IMPORTED_PERFUME, 1)

        when:
        Invoice invoice = billingApp.checkout(cart)

        then:
        invoice.lineItems.size() == 3
        and:
        invoice.lineItems[0].quantity == 1
        and:
        invoice.lineItems[0].unitPrice == BOOK.unitPrice
        and:
        invoice.lineItems[0].applicableTaxes == 0.00
        and: "Sales tax is applied"
        invoice.lineItems[1].applicableTaxes == 1.50
        and: "Both sales tax and import duty applied"
        invoice.lineItems[2].applicableTaxes == 7.15
    }

}
