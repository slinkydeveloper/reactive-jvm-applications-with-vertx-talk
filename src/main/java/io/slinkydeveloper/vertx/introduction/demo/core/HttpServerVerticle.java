package io.slinkydeveloper.vertx.introduction.demo.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HttpServerVerticle extends AbstractVerticle {

  private final int id;

  public HttpServerVerticle(int id) {
    this.id = id;
  }

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.createHttpServer().requestHandler(req ->
      vertx
        .eventBus()
        .<String>send("randomquote.myapplication", "quote", ar -> {
          System.out.println(String.format("Handling from HttpServerVerticle thread: %d, id: %d", Thread.currentThread().getId(), id));
          if (ar.succeeded()) {
            req.response()
              .putHeader("content-type", "text/plain")
              .end(ar.result().body());
          } else {
            req.response()
              .setStatusCode(500)
              .putHeader("content-type", "text/plain")
              .end(ar.cause().getMessage());
          }
        })
    ).listen(8080, ar -> {
      if (ar.succeeded()) startFuture.complete();
      else startFuture.fail(ar.cause());
    });
  }
}
