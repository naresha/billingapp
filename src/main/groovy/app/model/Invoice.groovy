package app.model
/**
 * Created by naresha on 13/02/17.
 */
class Invoice {

    List<LineItem> lineItems = []

    def addItem(LineItem item) {
        lineItems << item
    }

    BigDecimal getTotalCost() {
        lineItems.collect { it.sellingPriceBeforeTax }.sum()
    }

    BigDecimal getTotalTaxes() {
        lineItems.collect { it.applicableTaxes }.sum()
    }

    BigDecimal getTotalInvoiceAmount() {
        lineItems.collect { it.sellingPriceWithTax }.sum()
    }

}
