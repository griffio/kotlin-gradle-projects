package griffio.railroading

data class Request(val name: String, val email: String)

sealed class Result<out TSuccess, out TFailure> {
    class Success<out TSuccess>(val value: TSuccess): Result<TSuccess, Nothing>()
    class Failure<out TFailure>(val error: String):Result<Nothing, TFailure>()
}

val emailBlank =  Result.Failure<String>("Email must not be blank")
val nameBlank = Result.Failure<String>("Name must not be blank")

fun validateInput(input: Request): Result<Request, String> {
    return if (input.name.isBlank()) nameBlank
    else if (input.email.isBlank()) emailBlank
    else Result.Success<Request>(input)
}