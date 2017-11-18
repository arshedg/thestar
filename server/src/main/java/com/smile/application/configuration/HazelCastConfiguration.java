package com.smile.application.configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by agulshan on 14/11/17.
 */
@Component
public class HazelCastConfiguration {
    @Bean
    HazelcastInstance hazelcastInstance() {
        HazelcastInstance instance =  Hazelcast.newHazelcastInstance();
        return instance;
    }
}
