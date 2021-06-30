package miranda.ot.kodehouse.endereco

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class BuscaEnderecoControllerTest(){

    @field:Inject
    lateinit var sistemaDeEndereco: SistemaDeEndereco

    @field:Client("/endereco")
    @field:Inject
    lateinit var  client: HttpClient

    @Test
    fun `deve devolver um EnderecoResponse`(){
        // WHEN QUANDO
         val cep = "13650000"
         val enderecoResponse = EnderecoResponse("136031222",
                                                "Rua Recife",
                                                "Fundos",
                                                "Candida",
                                                "Zona norte",
                                                "SP",
                                                "135589974")

        val request:HttpRequest<Any> = HttpRequest.GET("/$cep")

        Mockito.`when`(sistemaDeEndereco.buscaCEP(cep)).thenReturn(HttpResponse.ok(enderecoResponse))

        val response = client.toBlocking().exchange(request ,Any::class.java)

        assertEquals(HttpStatus.OK ,response.status())
        assertNotNull(response.body())
        assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.status())

    }

    @MockBean(SistemaDeEndereco::class)
    fun enderecoSistemaMock():SistemaDeEndereco = Mockito.mock(SistemaDeEndereco::class.java)

}