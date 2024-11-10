package com.example.async

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class AsyncDemoServiceTest(
    private val asyncDemoService: AsyncDemoService,
    private val asyncDemo: AsyncDemo,
) {

    private val log = LoggerFactory.getLogger(javaClass)
    @Test
    fun demo() {
        asyncDemoService.demo()
        log.info("test")
    }

    @Test
    fun `mdc 추가`() {
        val mdcKey = "test"
        val mdcValue = "test"
        MDC.put(mdcKey, mdcValue)
        val result1 = asyncDemo.getMdcValue(mdcKey)
        val result2 = asyncDemo.getMdcValue(mdcKey)

        Assertions.assertThat(result1.get()).isEqualTo(mdcValue)
        Assertions.assertThat(result2.get()).isEqualTo(mdcValue)
    }
}