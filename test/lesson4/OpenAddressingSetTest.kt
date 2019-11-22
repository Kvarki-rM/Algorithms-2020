package lesson4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import java.util.NoSuchElementException

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
        set.add("Свинарник")
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

        set.remove("Свинарник")
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
        val exception1: Exception =
            assertThrows(IllegalArgumentException::class.java) {
                OpenAddressingSet<String>(32)
            }
        assertEquals("Failed requirement.", exception1.message)
        //   val exception2: Exception =
        //       assertThrows(NoSuchElementException::class.java) {
        //           val set = OpenAddressingSet<String>(3)
        //           set.add("Свинарник")
        //           set.remove("Пеппа")
        //       }
        //   assertEquals("No such element", exception2.message)

        val exception3: Exception =
            assertThrows(IllegalStateException::class.java) {
                val set = OpenAddressingSet<String>(3)
                set.add("Свинарник")
                set.add("Хрюша")
                set.add("Пятачок")
                set.add("Ниф-Ниф")
                set.add("Наф-Наф")
                set.add("Нуф-Нуф")
                set.add("Фунтик")
                set.add("Бэйб")
                set.add("Пеппа")
            }
        assertEquals("Table is full", exception3.message)
    }

}