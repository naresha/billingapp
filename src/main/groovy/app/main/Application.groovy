package app.main

import app.model.Invoice
import app.model.ProductCategory
import app.model.ShoppingCart
import app.model.StockKeepingUnit
import app.util.InvoicePrinter

/**
 * Created by naresha on 13/02/17.
 */
class Application {
    public static void main(String[] args) {
        BillingApp billingApp = new BillingApp()
        InvoicePrinter invoicePrinter = new InvoicePrinter()
        ShoppingCart cart1 = new ShoppingCart()
        cart1.addItem(new StockKeepingUnit(description: 'Book', category: ProductCategory.BOOK, unitPrice: 12.49), 1)
        cart1.addItem(new StockKeepingUnit(description: 'Music CD',
                category: ProductCategory.OTHER, unitPrice: 14.99), 1)
        cart1.addItem(new StockKeepingUnit(description: 'Chocolate Bar', category: ProductCategory.FOOD, unitPrice: 0.85), 1)

        Invoice invoice = billingApp.checkout(cart1)
        invoicePrinter.printInvoice(invoice)
        3.times { println "" }

        ShoppingCart cart2 = new ShoppingCart()
        cart2.addItem(new StockKeepingUnit(description: 'imported box of chocolates',
                category: ProductCategory.FOOD, unitPrice: 10.00, imported: true), 1)
        cart2.addItem(new StockKeepingUnit(description: 'imported bottle of perfume',
                category: ProductCategory.OTHER, unitPrice: 47.50, imported: true), 1)
        invoicePrinter.printInvoice(billingApp.checkout(cart2))
        3.times { println "" }

        ShoppingCart cart3 = new ShoppingCart()
        cart3.addItem(new StockKeepingUnit(description: 'imported bottle of perfume',
                category: ProductCategory.OTHER, unitPrice: 27.99, imported: true), 1)
        cart3.addItem(new StockKeepingUnit(description: 'bottle of perfume',
                category: ProductCategory.OTHER, unitPrice: 18.99), 1)
        cart3.addItem(new StockKeepingUnit(description: 'packet of Headache pills',
                category: ProductCategory.MEDICINE, unitPrice: 9.75), 1)
        cart3.addItem(new StockKeepingUnit(description: 'imported chocolates',
                category: ProductCategory.FOOD, unitPrice: 11.25, imported: true), 1)
        invoicePrinter.printInvoice(billingApp.checkout(cart3))
    }


}
