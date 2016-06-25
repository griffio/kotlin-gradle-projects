package griffio.railroading

import griffio.railroading.Result.Failure

data class Request(val name: String, val email: String)

sealed class Result<out S, out F> {
    class Success<out S>(val value: S) : Result<S, Nothing>()
    class Failure<out F>(val error: String) : Result<Nothing, F>()
}

val emailBlank = Failure<String>("Email must not be blank")
val nameBlank = Failure<String>("Name must not be blank")
val nameMax = Failure<String>("Name must be 40 chars or less")

val nameCheck: (input: Request) -> Result<Request, String> = { input -> if (input.name.isBlank()) nameBlank else Result.Success<Request>(input) }
val emailCheck: (input: Request) -> Result<Request, String> = { input -> if (input.email.isBlank()) emailBlank else Result.Success<Request>(input) }
val maxNameCheck: (input: Request) -> Result<Request, String> = { input -> if (input.name.length > 40) nameMax else Result.Success<Request>(input) }

fun bind(request: (Request) -> Result<Request, String>, result: Result<Request, String>): Result<Request, String> {
    return when(result) {
        is Result.Success<Request> -> request(result.value)
        else -> result
    }
}

fun main(args: Array<String>) {
    var result = nameCheck(Request("x", ""))
    result = bind(emailCheck, result)
    result = bind(maxNameCheck, result)
    println("expect fail: $result")
}