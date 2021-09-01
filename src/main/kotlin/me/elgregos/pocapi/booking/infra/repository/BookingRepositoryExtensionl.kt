package me.elgregos.pocapi.booking.infra.repository

import me.elgregos.pocapi.booking.domain.entities.Booking
import me.elgregos.pocapi.booking.domain.repository.BookingRepository
import reactor.core.publisher.Mono

fun BookingRepository.insert(booking: Booking): Mono<Booking> = save(booking.also { it.markNew() })