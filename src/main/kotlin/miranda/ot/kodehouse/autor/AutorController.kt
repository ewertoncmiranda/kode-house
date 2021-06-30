
package miranda.ot.kodehouse.autor
import io.micronaut.http.HttpMethod
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated


import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/autor")
@Validated
class AutorController(val autorRepositorio: AutorRepositorio) {

    @Post
    fun cadastrarNovoAutor(@Body @Valid request: NovoAutorRequester):HttpResponse<Any> {
        println("O resultado da request foi : $request")
        val autor = request.paraAutor()
        autorRepositorio.save(autor);

        val URI = UriBuilder.of("/autor/{id}").expand(mutableMapOf(Pair("id",autor.id)))

        return HttpResponse.created(URI)
    }


    fun listaAutores ():HttpResponse<Any>{
    val autores = autorRepositorio.findAll()
        val resposta = autores.map { autor -> DetalheAutorResponse(autor) }
        return  HttpResponse.ok(resposta)
    }

    @Delete("/{id}")
    fun deleteAutorPorId(@PathVariable  id: Long):HttpResponse<Any>{

        var possivelAutor = autorRepositorio.findById(id)

        if(possivelAutor.isEmpty) return HttpResponse.notFound()

        var autor = possivelAutor.get()
        autorRepositorio.delete(autor)

        return HttpResponse.ok()
    }

    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") nome:String) : HttpResponse<Any>{
           if(nome.isBlank()) return HttpResponse.ok(autorRepositorio.findAll()
                                    .map { DetalheAutorResponse(it) })
        var possivelAutor = autorRepositorio.findByNome(nome)
           if(possivelAutor.isEmpty) return  HttpResponse.notFound()

        return  HttpResponse.ok(DetalheAutorResponse(possivelAutor.get()))

    }

    @Patch("/{id}")
    fun atualizaAutor( @PathVariable id:Long , descricao:String ,nome:String  ):HttpResponse<Any>{
        val possivelAutor = autorRepositorio.findById(id)

        if(possivelAutor.isEmpty){ return HttpResponse.notFound();}

        var autor = possivelAutor.get()

        autor.descricao = descricao
        autor.nome  = nome
        autorRepositorio.update(autor)

        return  HttpResponse.ok(DetalheAutorResponse(autor))
    }

}