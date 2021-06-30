package miranda.ot.kodehouse.endereco

import io.micronaut.core.annotation.Introspected


data class Endereco(var cep: String ,
               var logradouro:String,
               var complemento:String,
               var bairro:String,
               var localidade:String,
               var uf:String,
               var ibge:String)