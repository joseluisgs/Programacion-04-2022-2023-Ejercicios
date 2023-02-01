package exceptions

sealed class ReservaException(message: String): RuntimeException(message)
class ReservaNotFound(message: String): ReservaException(message)
class ReservaAlreadyExisting(message: String): ReservaException(message)
class ReservaBadRequest(message: String): ReservaException(message)
class ReservaEmpty(message: String): ReservaException(message)