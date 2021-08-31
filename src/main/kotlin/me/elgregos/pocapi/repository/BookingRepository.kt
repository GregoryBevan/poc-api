package me.elgregos.pocapi.repository

import me.elgregos.pocapi.domain.Booking
import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface BookingRepository: R2dbcRepository<Booking, UUID>