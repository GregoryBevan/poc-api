package me.elgregos.pocapi.repository

import me.elgregos.pocapi.domain.Booking
import me.elgregos.pocapi.util.WithPostgresContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class BookingRepositoryTest: WithPostgresContainer() {

    @Autowired
    lateinit var bookingRepository: BookingRepository

    @Test
    fun `should store booking`() {
        val booking = Booking(UUID.randomUUID(), "This a test")

        val result = bookingRepository.save(booking.also { it.markNew() }).block()

        assertEquals(booking, result)

    }
}