package fr.maifinternational.audace.booking.infra.repository

import fr.maifinternational.audace.booking.domain.entities.Booking
import fr.maifinternational.audace.booking.domain.repository.BookingRepository
import reactor.core.publisher.Mono

fun BookingRepository.insert(booking: Booking): Mono<Booking> = save(booking.also { it.markNew() })