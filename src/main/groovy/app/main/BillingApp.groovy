package app.main

import app.model.Invoice
import app.model.LineItem
import app.model.ShoppingCart
import app.model.StockKeepingUnit
import app.tax.ImportDuty
import app.tax.SalesTax
import app.tax.TaxCalculator
import app.util.RoundOffUtil

import java.math.RoundingMode

/**
 * Created by naresha on 13/02/17.
 */
class BillingApp {

    private static final def TAX_RULES = [new SalesTax(), new ImportDuty()]
    private static final RoundOffUtil roundOffUtil = new RoundOffUtil(0.05, RoundingMode.UP)
    private static final TaxCalculator taxCalculator = new TaxCalculator(roundOffUtil)

    Invoice checkout(ShoppingCart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Empty cart")
        }
        Invoice invoice = new Invoice()
        List<LineItem> lineItems = cart.items.collect { StockKeepingUnit sku, Integer quantity ->
            LineItem lineItem = createLineItem(sku, quantity)
            lineItem.applicableTaxes = calculateTax(lineItem, sku)
            lineItem
        }
        lineItems.each {
            invoice.addItem(it)
        }
        invoice
    }

    private def createLineItem(StockKeepingUnit sku, Integer quantity) {
        new LineItem(
                description: sku.description,
                unitPrice: sku.unitPrice,
                quantity: quantity
        )
    }

    private def calculateTax(LineItem lineItem, StockKeepingUnit sku) {
        TAX_RULES.collect { taxRule ->
            BigDecimal taxPercent = taxRule.calculateTaxPercentage(sku)
            taxCalculator.calculateTax(lineItem.sellingPriceBeforeTax, taxPercent)
        }.sum()
    }

}
