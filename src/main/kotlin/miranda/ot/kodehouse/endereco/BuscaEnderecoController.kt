package miranda.ot.kodehouse.endereco

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable



@Controller("/endereco")
class BuscaEnderecoController(val endereco: SistemaDeEndereco) {

    @Get("/{cep}")
    fun buscaCPF(@PathVariable cep:String):HttpResponse<Any>{

        var response = endereco.buscaCEP(cep)

            if(response.body() == null) return HttpResponse.badRequest()

        val endereco = response.body()!!

        return HttpResponse.ok(endereco)
    }
}