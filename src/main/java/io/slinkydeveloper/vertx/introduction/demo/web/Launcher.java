package io.slinkydeveloper.vertx.introduction.demo.web;

import io.slinkydeveloper.vertx.introduction.demo.core.QuoteVerticle;
import io.vertx.core.Vertx;

public class Launcher {

  public static void main(String[] args) throws InterruptedException {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new WebServerVerticle());
    vertx.deployVerticle(new QuoteVerticle(0));
  }

}
