package miranda.ot.kodehouse

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("miranda.ot.kodehouse")
		.start()
}

