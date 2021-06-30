
package miranda.ot.kodehouse.autor
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor (var nome:String ,
             val email:String ,
             var descricao:String ){

    @Id  @GeneratedValue  var id : Long? = null

    var criadoEm : LocalDateTime = LocalDateTime.now()
}