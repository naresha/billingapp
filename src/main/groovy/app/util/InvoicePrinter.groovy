package app.util

import app.model.Invoice
import app.model.LineItem

/**
 * Created by naresha on 13/02/17.
 */
class InvoicePrinter {


    public static final int QUANTITY_LENGTH = 5
    public static final int DESCRIPTION_LENGTH = 50
    public static final int PRICE_LENGTH = 10

    def printInvoice(Invoice invoice) {
        printHeader()
        printlLineHeader()
        printSeparator()
        invoice.lineItems.each {
            printLineItem(it)
        }
        printSeparator()
        printSummary("Total Cost", invoice.totalCost)
        printSummary("Total Tax", invoice.totalTaxes)
        printSummary("Grand Total", invoice.totalInvoiceAmount)
        printSeparator()

    }

    def printHeader() {
        printSeparator()
        println "INVOICE".center(QUANTITY_LENGTH + DESCRIPTION_LENGTH + PRICE_LENGTH)
        printSeparator()
    }

    def printlLineHeader() {
        String text = "Qty".padRight(QUANTITY_LENGTH) +
                "Item".padRight(DESCRIPTION_LENGTH) +
                "Price".padRight(PRICE_LENGTH)
        println text
    }

    def printSeparator() {
        println "".padRight(QUANTITY_LENGTH + DESCRIPTION_LENGTH + PRICE_LENGTH, "-")
    }

    def printLineItem(LineItem lineItem) {
        String text = String.valueOf(lineItem.quantity).padRight(QUANTITY_LENGTH) +
                lineItem.description.padRight(DESCRIPTION_LENGTH) +
                String.valueOf(lineItem.sellingPriceWithTax).padLeft(PRICE_LENGTH)
        println text
    }

    def printSummary(String text, BigDecimal amount) {
        println " ".padRight(QUANTITY_LENGTH) +
                text.padRight(DESCRIPTION_LENGTH) +
                String.valueOf(amount).padLeft(PRICE_LENGTH)
    }


}
