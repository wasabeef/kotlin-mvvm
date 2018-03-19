package jp.wasabeef.util

import java.lang.RuntimeException

/**
 * Created by Wasabeef on 2017/12/04.
 */
open class AppError : RuntimeException {

    enum class Cause {
        /** ネットワーク未接続  */
        UNKNOWN_HOST,
        /** ネットワーク通信タイムアウト  */
        TIMEOUT,
        /** ネットワーク全般  */
        NETWORK,
        /** APIエラー全般  */
        API,
        /** DBエラー全般  */
        DB,
        /** その他エラー全般  */
        ANY
    }

    private val causeType: Cause

    constructor(type: Cause = Cause.ANY) : super() {
        this.causeType = type
    }

    constructor(message: String?, type: Cause = Cause.ANY) : super(message) {
        this.causeType = type
    }

    constructor(error: Throwable?, type: Cause = Cause.ANY) : super(error) {
        this.causeType = type
    }

    constructor(message: String?, error: Throwable?, type: Cause = Cause.ANY) : super(message, error) {
        this.causeType = type
    }
}