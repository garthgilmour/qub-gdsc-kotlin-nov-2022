package shop

interface PaymentEngine {
    fun authorize(cardNo: String, amount: Double): Boolean
}
