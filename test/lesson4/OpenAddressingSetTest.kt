package lesson4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class OpenAddressingSetTest {

    @Test
    @Tag("Example")
    fun add() {
        val set = OpenAddressingSet<String>(16)
        assertTrue(set.isEmpty())
        set.add("Alpha")
        set.add("Beta")
        set.add("Omega")
        assertSame(3, set.size)
        assertTrue("Beta" in set)
        assertFalse("Gamma" in set)
        assertTrue("Omega" in set)
    }

    @Test
    @Tag("Example")
    fun remove() {
        val set = OpenAddressingSet<String>(16)
        assertTrue(set.isEmpty())
        set.add("Свиноферма")
        set.add("Хрюша")
        set.add("Пятачок")
        set.add("Ниф-Ниф")
        set.add("Наф-Наф")
        set.add("Нуф-Нуф")
        set.add("Фунтик")
        set.add("Бэйб")
        set.add("Пеппа")
        set.add("Нюша")
        set.add("Пумба")

        set.remove("Свиноферма")
        assertSame(10, set.size)

        assertFalse("Свиноферма" in set)
        assertTrue("Хрюша" in set)
        assertTrue("Хрюша" in set)

        set.remove("Пеппа")
        assertTrue("Нюша" in set)
        assertTrue("Пумба" in set)

        assertSame(9, set.size)
        set.add("Мясокомбинат")

        set.remove("Нуф-Нуф")
        set.remove("Бэйб")
        assertTrue("Фунтик" in set)
        set.remove("Пумба")
        assertFalse("Пумба" in set)
        assertFalse("Бэйб" in set)

    }

    @Test
    @Tag("Example")
    fun exThrow() {
        val exception: Exception =
            assertThrows(IllegalArgumentException::class.java) {
                OpenAddressingSet<String>(32)
            }
        assertEquals("Failed requirement.", exception.message)
    }

    @Test
    @Tag("Example")
    fun exThrow2() {
        val exception: Exception =
            assertThrows(IllegalStateException::class.java) {
                val set = OpenAddressingSet<String>(2)
                set.add("Хрюша")
                set.add("Пятачок")
                set.add("Ниф-Ниф")
                set.add("Наф-Наф")
                set.add("Нуф-Нуф")
            }
        assertEquals("Table is full", exception.message)

    }
}