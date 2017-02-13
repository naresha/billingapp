package app.model

import spock.lang.Specification

/**
 * Created by naresha on 13/02/17.
 */
class InvoiceSpec extends Specification {

    def "Invoice can be added with line items"() {
        given:
        def lineItem1 = new LineItem(unitPrice: 10.25, quantity: 5)
        def lineItem2 = new LineItem(unitPrice: 15.50, quantity: 8)
        def invoice = new Invoice()

        when:
        invoice.addItem(lineItem1)
        invoice.addItem(lineItem2)

        then:
        invoice.lineItems.size() == 2
    }

    def "Total taxes paid should be sum of taxes on individual line items"() {
        given:
        def lineItem1 = new LineItem(unitPrice: 10.25, quantity: 5, applicableTaxes: 2.4)
        def lineItem2 = new LineItem(unitPrice: 15.50, quantity: 8, applicableTaxes: 2.8)
        def invoice = new Invoice()

        when:
        invoice.addItem(lineItem1)
        invoice.addItem(lineItem2)

        then:
        invoice.totalTaxes == lineItem1.applicableTaxes + lineItem2.applicableTaxes
    }

    def "Total invoice amount should be sum of line totals"() {
        given:
        def lineItem1 = new LineItem(unitPrice: 10.25, quantity: 5, applicableTaxes: 2.4)
        def lineItem2 = new LineItem(unitPrice: 15.50, quantity: 8, applicableTaxes: 2.8)
        def invoice = new Invoice()

        when:
        invoice.addItem(lineItem1)
        invoice.addItem(lineItem2)

        then:
        invoice.totalInvoiceAmount == lineItem1.sellingPriceWithTax + lineItem2.sellingPriceWithTax
    }

    def "Total cost should be sum of line level costs"() {
        given:
        def lineItem1 = new LineItem(unitPrice: 10.25, quantity: 5, applicableTaxes: 2.4)
        def lineItem2 = new LineItem(unitPrice: 15.50, quantity: 8, applicableTaxes: 2.8)
        def invoice = new Invoice()

        when:
        invoice.addItem(lineItem1)
        invoice.addItem(lineItem2)

        then:
        invoice.totalCost == lineItem1.sellingPriceBeforeTax + lineItem2.sellingPriceBeforeTax
    }

}
