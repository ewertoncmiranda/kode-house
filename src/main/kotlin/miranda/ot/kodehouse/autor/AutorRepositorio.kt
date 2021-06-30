package miranda.ot.kodehouse.autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import miranda.ot.kodehouse.autor.Autor
import java.util.*

@Repository
interface AutorRepositorio : CrudRepository <Autor,Long>{
    fun findByNome (nome : String ,) : Optional<Autor>
}