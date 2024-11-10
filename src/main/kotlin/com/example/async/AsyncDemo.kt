package com.example.async

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future

@Component
class AsyncDemo {
    private val log = LoggerFactory.getLogger(javaClass)
    @Async
    fun demoMethod() {
        log.info("Demo method called ${Thread.currentThread()}")
    }

    @Async
    fun getMdcValue(mdcKey: String): Future<String> {
        log.info("Demo method called")
        val value = MDC.get(mdcKey)
        return CompletableFuture.completedFuture(value)
    }
}