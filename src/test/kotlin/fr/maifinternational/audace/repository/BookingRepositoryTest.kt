package fr.maifinternational.audace.repository

import fr.maifinternational.audace.booking.domain.entities.Booking
import fr.maifinternational.audace.booking.domain.repository.BookingRepository
import fr.maifinternational.audace.booking.infra.repository.insert
import fr.maifinternational.audace.util.WithPostgresContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.r2dbc.core.DatabaseClient
import reactor.test.StepVerifier
import java.time.Duration
import java.util.*
import kotlin.test.Test

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