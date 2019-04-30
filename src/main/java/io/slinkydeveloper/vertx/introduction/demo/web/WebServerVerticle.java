package io.slinkydeveloper.vertx.introduction.demo.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class WebServerVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) {
    Router router = Router.router(vertx);

    SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
    BridgeOptions options = new BridgeOptions()
      .addInboundPermitted(new PermittedOptions().setAddress("randomquote.myapplication"))
      .addOutboundPermitted(new PermittedOptions().setAddress("randomquote.myapplication"));
    sockJSHandler.bridge(options);

    router.route("/eventbus/*").handler(sockJSHandler);

    router.route().handler(StaticHandler.create());

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080, h -> {
        System.out.println("WebVerticle deployed");
        startFuture.complete();
      });
  }
}
