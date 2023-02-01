package exceptions

sealed class HabitacionException(message: String): RuntimeException(message)
class HabitacionNotFound(message: String): HabitacionException(message)
class HabitacionBadRequest(message: String): ReservaException(message)
class RoomNotEmpty(message: String): ReservaException(message)
class RoomCannotBeEmpty(message: String): ReservaException(message)
class RoomCannorBeFormalize(message: String): ReservaException(message)