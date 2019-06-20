package io.slinkydeveloper.vertx.introduction.demo.core;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.impl.cpu.CpuCoreSensor;

public class Launcher {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Available processors: " + CpuCoreSensor.availableProcessors());
    Vertx vertx = Vertx.vertx(new VertxOptions());
    for (int i = 0; i < 8; i++) vertx.deployVerticle(new HttpServerVerticle(i));
    for (int i = 0; i < 8; i++) vertx.deployVerticle(new QuoteVerticle(8 + i));
    Thread.sleep(4000);
    System.out.println("Current threads: " + Thread.activeCount());
  }

}
