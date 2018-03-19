package jp.wasabeef.util

/**
 * Created by Wasabeef on 2018/03/08.
 */
sealed class Result<T> {
    class Loading<T> : Result<T>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val message: Throwable) : Result<T>()

    companion object {
        fun <T> loading(): Result<T> = Loading()
        fun <T> success(data: T): Result<T> = Success(data)
        fun <T> failure(message: Throwable): Result<T> = Failure(message)
    }
}