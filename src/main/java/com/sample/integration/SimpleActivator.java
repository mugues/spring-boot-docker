package com.sample.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleActivator {
    private static final Logger logger = LoggerFactory.getLogger(SimpleActivator.class);

    public String activate(String message) {

        logger.debug("handle message {}", message);
        return message;
    }
}
