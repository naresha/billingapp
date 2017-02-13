package app.model

import spock.lang.Specification

/**
 * Created by naresha on 13/02/17.
 */
class LineItemSpec extends Specification {

    def "Selling price without tax is unit price multiplied by selected quantity"() {
        given:
        def lineItem = new LineItem(unitPrice: 10.25, quantity: 5)

        when:
        def sellingPriceWithoutTax = lineItem.sellingPriceBeforeTax

        then:
        sellingPriceWithoutTax == lineItem.unitPrice * lineItem.quantity
    }

    def "Selling price with tax is selling price before tax plus applicable taxes"() {
        given:
        def lineItem = new LineItem(unitPrice: 10.25, quantity: 5, applicableTaxes: 2.5)

        when:
        def sellingPriceWithTax = lineItem.sellingPriceWithTax

        then:
        sellingPriceWithTax == lineItem.sellingPriceBeforeTax + lineItem.applicableTaxes
    }

}
