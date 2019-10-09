package kotlintest

import org.junit.Assert
import org.junit.Test

class CalculatorTest {

    @Test
    fun `empty string should return 0`() {
        Assert.assertEquals(0, Calculator().add(""))
    }

    @Test
    fun `string of 1 should return 1`() {
        Assert.assertEquals(1, Calculator().add("1"))
    }

    @Test
    fun `should return 3 for input of 1,2`() {
        Assert.assertEquals(3, Calculator().add("1,2"))
    }

    @Test
    fun `should return 6 for input of 1,2,3`() {
        Assert.assertEquals(6, Calculator().add("1,2,3"))
    }

    @Test
    fun `should return 6 for input containing newline delim`() {
        Assert.assertEquals(6, Calculator().add("1\n2,3"))
    }

    @Test
    fun `should return 6 for input starting with custom delimiter`() {
        Assert.assertEquals(6, Calculator().add("//;\n1;2;3"))
    }
}