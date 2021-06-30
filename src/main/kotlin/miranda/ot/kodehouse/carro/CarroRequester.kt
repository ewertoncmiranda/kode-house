package miranda.ot.kodehouse.carro

import io.micronaut.core.annotation.Introspected
import miranda.ot.kodehouse.validacao.Placa
import javax.validation.constraints.NotBlank

@Introspected
data class CarroRequester(@field:NotBlank val modelo:String,
                          @field:Placa  val placa:String ) {

    fun toModel():Carro = Carro(modelo,placa)
}
