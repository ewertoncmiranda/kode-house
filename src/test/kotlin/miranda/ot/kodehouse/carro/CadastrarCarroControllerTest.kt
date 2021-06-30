package miranda.ot.kodehouse.carro

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(rollback = false)
internal class CadastrarCarroControllerTest{

    @Inject
    lateinit var  repositorio: CarroRepositorio

    @Test
    fun`deve inserir um novo carro`(){
        repositorio.save(Carro(modelo = "Gol" ,placa = "FAS-4578"))
        assertEquals(1 ,repositorio.count())
    }

}