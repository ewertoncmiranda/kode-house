package miranda.ot.kodehouse.autor

import io.micronaut.core.annotation.Introspected
import miranda.ot.kodehouse.autor.Autor
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import kotlin.math.max

@Introspected
data class NovoAutorRequester(@field:NotBlank  val nome : String,
                              @field:NotBlank  @field:Email(message = "Insira um formato de email válido.") val email : String,
                              @field:NotBlank  @field:Size(max=400 ,message = "Máximo de 400 Caracteres")  val descricao : String )
{
    fun paraAutor():Autor=Autor(nome,email,descricao)
}
