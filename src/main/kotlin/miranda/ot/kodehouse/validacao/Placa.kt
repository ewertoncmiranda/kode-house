package miranda.ot.kodehouse.validacao

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.RUNTIME
@MustBeDocumented
@Retention(RUNTIME)
@Constraint(validatedBy = [PlacaValidador::class])
@Target(AnnotationTarget.FIELD ,AnnotationTarget.CONSTRUCTOR)
annotation class Placa

@Singleton
class PlacaValidador :ConstraintValidator<Placa ,String>{
    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Placa>,
        context: ConstraintValidatorContext,
    ): Boolean {
        if(value == null) return  true
        return value.matches("[A-Z]{3}[0-9][A-Z 0-9][0-9]{2}".toRegex())
    }


}
