package shop.mockito

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.mockito.Mockito.*
import shop.PaymentEngine
import shop.PricingEngine
import shop.Shop
import shop.StockCheckEngine

class ShopSpec : ShouldSpec() {
    private val pricingEngine    = mock(PricingEngine::class.java)
    private val paymentEngine    = mock(PaymentEngine::class.java)
    private val stockCheckEngine = mock(StockCheckEngine::class.java)

    override fun isolationMode() = IsolationMode.InstancePerTest

    init {
        should("be able to make a purchase with valid quantities") {
            `when`(stockCheckEngine.check("AB12")).thenReturn(20)
            `when`(pricingEngine.price("AB12", 19)).thenReturn(27.30)
            `when`(paymentEngine.authorize("010203XYZ", 27.30)).thenReturn(true)

            val shop = Shop(pricingEngine, stockCheckEngine, paymentEngine)
            shop.makePurchase("AB12", 19, "010203XYZ") shouldBe true

            verify(stockCheckEngine).check("AB12")
            verify(pricingEngine).price("AB12", 19)
            verify(paymentEngine).authorize("010203XYZ", 27.30)
        }
        should("be unable to make a purchase with invalid quantities") {
            `when`(stockCheckEngine.check("AB12")).thenReturn(20)

            val shop = Shop(pricingEngine, stockCheckEngine, paymentEngine)
            shop.makePurchase("AB12", 21, "010203XYZ") shouldBe false

            verify(stockCheckEngine).check("AB12")
            verify(pricingEngine, never()).price(anyString(), anyInt())
            verify(paymentEngine, never()).authorize(anyString(), anyDouble())
        }
    }
}
