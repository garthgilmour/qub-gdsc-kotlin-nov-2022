package shop.mockk

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import shop.PaymentEngine
import shop.PricingEngine
import shop.Shop
import shop.StockCheckEngine

class ShopSpec : ShouldSpec() {
    private val pricingEngine: PricingEngine       = mockk()
    private val paymentEngine: PaymentEngine       = mockk()
    private val stockCheckEngine: StockCheckEngine = mockk()

    init {
        isolationMode = IsolationMode.InstancePerTest

        should("be able to make a purchase with valid quantities") {
            every { stockCheckEngine.check("AB12") } returns 20
            every { pricingEngine.price("AB12", 19) } returns 27.30
            every { paymentEngine.authorize("010203XYZ", 27.30) } returns true

            val shop = Shop(pricingEngine, stockCheckEngine, paymentEngine)
            shop.makePurchase("AB12", 19, "010203XYZ") shouldBe true


            verifySequence {
                stockCheckEngine.check("AB12")
                pricingEngine.price("AB12", 19)
                paymentEngine.authorize("010203XYZ", 27.30)
            }
        }

        should("be unable to make a purchase with invalid quantities") {
            every { stockCheckEngine.check("AB12") } returns 20

            val shop = Shop(pricingEngine, stockCheckEngine, paymentEngine)
            shop.makePurchase("AB12", 21, "010203XYZ") shouldBe false

            verify {
                stockCheckEngine.check("AB12")
                pricingEngine wasNot Called
                paymentEngine wasNot Called
            }
        }
    }
}
