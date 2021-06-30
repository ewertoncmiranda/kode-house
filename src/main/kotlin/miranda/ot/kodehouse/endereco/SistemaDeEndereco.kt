package miranda.ot.kodehouse.endereco

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client


@Client("http://viacep.com.br/ws")
open interface SistemaDeEndereco {

    @Get("/{cep}/json" )
    fun buscaCEP(@PathVariable cep:String):HttpResponse<EnderecoResponse>

}