package fr.maifinternational.audace.booking.domain.repository

import fr.maifinternational.audace.booking.domain.entities.Booking
import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface BookingRepository: R2dbcRepository<Booking, UUID>