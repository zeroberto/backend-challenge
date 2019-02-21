package com.invillia.acme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static com.invillia.acme.constants.ConfigConstants.*;

/**
 * Class responsible for enabling the asynchronicity feature.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(ASYNC_CORE_POOL_SIZE);
        executor.setMaxPoolSize(ASYNC_MAX_POOL_SIZE);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix(ASYNC_PREFIX);
        executor.setQueueCapacity(ASYNC_QUEUE_CAPACITY);
        executor.initialize();
        return executor;
    }

}
