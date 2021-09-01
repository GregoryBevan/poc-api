package me.elgregos.pocapi.repository

import me.elgregos.pocapi.booking.domain.Booking
import me.elgregos.pocapi.booking.domain.repository.BookingRepository
import me.elgregos.pocapi.booking.infra.repository.insert
import me.elgregos.pocapi.util.WithPostgresContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.r2dbc.core.DatabaseClient
import reactor.test.StepVerifier
import java.time.Duration
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class BookingRepositoryTest : WithPostgresContainer() {

    @Autowired
    lateinit var bookingRepository: BookingRepository

    @Autowired
    lateinit var databaseClient: DatabaseClient

    @Test
    fun `should store new booking`() {
        val booking = Booking(UUID.randomUUID(), "This a test")

        bookingRepository.insert(booking).block(Duration.ofSeconds(5))
        this.bookingRepository.findById(booking.id)
            .`as` { StepVerifier.create(it) }
            .expectNext(booking)
            .verifyComplete()
    }
}