package shop

interface PricingEngine {
    fun price(itemNo: String, quantity: Int): Double
}
