package shop

class Shop(private val pricingEngine: PricingEngine,
           private val stockCheckEngine: StockCheckEngine,
           private val paymentEngine: PaymentEngine) {

    fun makePurchase(itemNo: String, quantity: Int, cardNo: String): Boolean {
        if (stockCheckEngine.check(itemNo) >= quantity) {
            val charge = pricingEngine.price (itemNo, quantity)
            if (paymentEngine.authorize(cardNo, charge)) {
                return true
            }
        }
        return false
    }
}
