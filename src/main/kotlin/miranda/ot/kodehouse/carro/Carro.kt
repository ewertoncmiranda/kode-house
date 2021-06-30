package miranda.ot.kodehouse.carro

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Carro(
      @field:NotNull
      val modelo:String,

      @Column(unique = true ,nullable = false )
      val placa:String){
    @Id  @GeneratedValue
    var id :Long? = null
}