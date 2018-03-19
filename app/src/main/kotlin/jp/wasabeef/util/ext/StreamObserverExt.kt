package jp.wasabeef.util.ext

import io.grpc.stub.StreamObserver
import io.reactivex.Observable

/**
 * Created by Wasabeef on 2018/03/08.
 */
inline fun <T> asObservable(crossinline body: (StreamObserver<T>) -> Unit): Observable<T> {
    return Observable.create { subscription ->
        val observer = object : StreamObserver<T> {
            override fun onNext(value: T) {
                subscription.onNext(value)
            }

            override fun onError(error: Throwable) {
                subscription.onError(error)
            }

            override fun onCompleted() {
                subscription.onComplete()
            }
        }
        body(observer)
    }
}