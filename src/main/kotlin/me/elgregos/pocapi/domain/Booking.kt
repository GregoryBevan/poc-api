package me.elgregos.pocapi.domain

import java.time.LocalDateTime
import java.util.*

data class Booking(val id: UUID = UUID.randomUUID(), val details: String)

data class VehicleMovement(
    val id: String,
    val creationDate: LocalDateTime,
    val deliveryDate: LocalDateTime,
    val pickUpCity: String,
    val pickUpPostalCode: String,
    val dropOffCity: String,
    val dropOffPostalCode: String,
    val distance: Int,
    val pickUpDate: LocalDateTime,
    val dropOffDate: LocalDateTime
)
