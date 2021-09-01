package me.elgregos.pocapi.booking.domain.entities

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import java.time.LocalDateTime
import java.util.*

data class Booking(
    @Id val id: UUID = UUID.randomUUID(),
    val details: String
) : BaseView<UUID>(id)

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

abstract class BaseView<ID>(
    private val id: ID,
) : Persistable<ID> {

    @Transient
    private var isNew = false

    @Transient
    override fun isNew() = isNew

    fun markNew() {
        isNew = true
    }

    override fun getId() = id
}
