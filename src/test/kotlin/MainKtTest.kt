import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun limitsTypeCard_VK_limit_month_is_not_exhausted() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 0
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_month_reached() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 40_000
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_day_is_not_exhausted() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 15000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_Day_reached() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_600_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_month_is_not_exhausted() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 15_000
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_month_reached() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 550_000
        val amountKop: Int = 5_100_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_day_is_not_exhausted() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_Day_reached() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 15_000_100

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_non_existent_card() {
        val typeCard: String = "Test"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_typeCard_default() {
        val previousAmountRub: Int = 5
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_previousAmountRub_default() {

        val typeCard: String = "Mastercard"
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            amountKop = amountKop
        )
        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Mir() {

        val typeCard: String = "Mir"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Mir_limit_Day_reached() {

        val typeCard: String = "Mir"
        val previousAmountRub: Int = 0
        val amountKop: Int = 100_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Mir_limit_Month_reached() {

        val typeCard: String = "Mir"
        val previousAmountRub: Int = 600_000
        val amountKop: Int = 10_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Mastercard() {

        val typeCard: String = "Mastercard"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(true, result)
    }

    @Test
    fun commissionTypeCardKop_Mastercard_limit_is_not_exhausted() {
        val typeCard: String = "Mastercard"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(0.0, result)
    }

    @Test
    fun commissionTypeCardKop_Mastercard_limit_reached() {
        val typeCard: String = "Mastercard"
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(8000.0, result)
    }

    @Test
    fun commissionTypeCardKop_Visa_min_commission() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 100_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(3500.0, result)
    }

    @Test
    fun commissionTypeCardKop_Visa_commission() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(7500.0, result)
    }

    @Test
    fun commissionTypeCardKop_Mir_commission() {
        val typeCard: String = "Mir"
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(7500.0, result)
    }

    @Test
    fun commissionTypeCardKop_non_existent_card() {
        val typeCard: String = "Test"
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(0.0, result)
    }

    @Test
    fun commissionTypeCardKop_default_typeCard() {
        val previousAmountRub: Int = 75_000
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(0.0, result)
    }

    @Test
    fun commissionTypeCardKop_default_previousAmountRub() {
        val typeCard: String = "Visa"
        val amountKop: Int = 1_000_000

        val result = commissionTypeCardKop(
            typeCard = typeCard,
            amountKop = amountKop
        )

        assertEquals(0.0, result)
    }
}