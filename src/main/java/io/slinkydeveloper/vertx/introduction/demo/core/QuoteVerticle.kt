package io.slinkydeveloper.vertx.introduction.demo.core

import io.vertx.ext.web.client.WebClient
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.ext.web.client.sendAwait
import kotlinx.coroutines.launch

class QuoteVerticle(val id: Integer) : CoroutineVerticle() {

  lateinit var webClient: WebClient

  override suspend fun start() {
    webClient = WebClient.create(vertx)
    vertx.eventBus().consumer<String>("randomquote.myapplication") { msg ->
      launch {
        println("Consuming message in QuoteVerticle ")
        val result = webClient
          .getAbs("http://api.icndb.com/jokes/random")
          .sendAwait()
          .bodyAsJsonObject()
        println("Handling from QuoteVerticle thread: ${Thread.currentThread().id}, id: $id")
        msg.reply(
          result.getJsonObject("value").getString("joke")
        )
      }
    }
    println("QuoteVerticle deployed")
  }
}
.result()..body()
