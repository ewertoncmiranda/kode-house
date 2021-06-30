package miranda.ot.kodehouse.autor

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import javax.inject.Inject

@MicronautTest
internal class AutorControllerTest{

    @field:Inject
    @field:Client("/autor")
    lateinit var client:HttpClient

    @Test
    fun `cadastrar novo autor`(){

        val novoAutorRequester = NovoAutorRequester(nome = "Tomas" ,
                                                    email = "tomas@miranda.com",
                                                    descricao = "Um super autor")

        val request = HttpRequest.POST("",novoAutorRequester)

        val response = client.toBlocking().exchange(request , Any::class.java)

        assertEquals(HttpStatus.CREATED , response.status)
        assertTrue(response.headers.contains("Location"))
        assertTrue(response.header("Location")!!.matches("/autor/\\d".toRegex()))


    }

}