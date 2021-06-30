package miranda.ot.kodehouse.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated

import javax.validation.Valid

@Controller("/carro")
@Validated
class CadastrarCarroController(val  carroRepositorio: CarroRepositorio){

    @Post
    fun criarCarro(@Valid @Body carro:CarroRequester):HttpResponse<Any>{

     var carroCriado =  carroRepositorio.save(carro.toModel())

    return  HttpResponse.ok(carroCriado)
    }

}