package br.com.surb.surbcatalog.shared.AppConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppExecutorConfiguration {

    @Bean
    public Executor controllersExecutor(
            @Value("${surbcatalog.taskExecutor.poll.corePollSize:10}") int corePollSize,
            @Value("${surbcatalog.taskExecutor.poll.maxPollSixe:20}") int maxPollSixe,
            @Value("${surbcatalog.taskExecutor.poll.queueCapaciy:50}") int queueCapaciy,
            @Value("${surbcatalog.taskExecutor.poll.keepAliveSeconds:60}") int keepAliveSeconds){
        return new ThreadPoolExecutor(corePollSize, maxPollSixe, keepAliveSeconds, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueCapaciy, true));
    }
}
