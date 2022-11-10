package shop

interface StockCheckEngine {
    fun check(itemNo: String): Int
}
