package miranda.ot.kodehouse.endereco

import io.micronaut.core.annotation.Introspected

@Introspected
class EnderecoResponse (val cep: String ,
                            val logradouro:String,
                            val complemento:String,
                            val bairro:String,
                            val localidade:String,
                            val uf:String,
                            val ibge:String){
    fun toModel():Endereco = Endereco(cep,logradouro ,complemento,bairro,localidade,uf,ibge)
}

