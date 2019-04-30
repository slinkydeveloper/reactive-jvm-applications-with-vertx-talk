package io.slinkydeveloper.vertx.introduction.demo.core

import io.vertx.kotlin.core.eventbus.sendAwait
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch

class HttpServerVerticle(val id: Integer) : CoroutineVerticle() {

  override suspend fun start() {
    vertx.createHttpServer().requestHandler { req ->
      launch {
        val quoteMessage = vertx
          .eventBus()
          .sendAwait<String>("randomquote.myapplication", "quote")
        println("Handling from HttpServerVerticle thread: ${Thread.currentThread().id}, id: $id")
        req.response()
          .putHeader("content-type", "text/plain")
          .end(quoteMessage.body())
      }
    }.listenAwait(8080)
    println("HttpServerVerticle deployed")
  }
}
