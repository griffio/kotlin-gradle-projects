package griffio.railroading

data class Request(val name: String, val email: String)

sealed class Result<out S, out F> {
    class Success<out S>(val value: S) : Result<S, Nothing>()
    class Failure<out F>(val error: String) : Result<Nothing, F>()
}

val emailBlank = Result.Failure<String>("Email must not be blank")
val nameBlank = Result.Failure<String>("Name must not be blank")
val nameMax = Result.Failure<String>("Name must be 40 chars or less")

fun validateInput(input: Request): Result<Request, String> {
    return if (input.name.isBlank()) nameBlank
    else if (input.email.isBlank()) emailBlank
    else Result.Success<Request>(input)
}

val validateMaxName = { input: Request ->
    if (input.name.length > 40) nameMax else Result.Success<Request>(input)
}

val validateNameBlank = { input: Request ->
    if (input.name.isBlank()) nameBlank else Result.Success<Request>(input)
}

val validateEmailBlank = { input: Request ->
    if (input.email.isBlank()) emailBlank else Result.Success<Request>(input)
}

