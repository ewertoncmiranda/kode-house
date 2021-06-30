package miranda.ot.kodehouse.carro

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface CarroRepositorio:CrudRepository<Carro ,Long> {
    fun existsByPlaca(placa:String) : Boolean
}