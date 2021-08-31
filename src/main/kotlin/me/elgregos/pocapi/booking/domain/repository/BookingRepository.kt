package me.elgregos.pocapi.booking.domain.repository

import me.elgregos.pocapi.booking.domain.Booking
import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface BookingRepository: R2dbcRepository<Booking, UUID>