package com.example.async

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service


@Service
class AsyncDemoService(
    private val asyncDemo: AsyncDemo
) {
    private val log = LoggerFactory.getLogger(javaClass)
    fun demo() {
        log.info("Demo service called")
        asyncDemo.demoMethod()
    }
}