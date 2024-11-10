package com.example.async.config

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.core.task.TaskDecorator

class AsyncTaskDecorator : TaskDecorator {
    val logger = LoggerFactory.getLogger(javaClass)
    override fun decorate(runnable: Runnable): Runnable {
        val map = MDC.getCopyOfContextMap()
        return Runnable {
            try {
                logger.info("decorator")
                if (map != null) {
                    MDC.setContextMap(map)
                }
                runnable.run()
            } finally {
                MDC.clear()
            }
        }
    }
}