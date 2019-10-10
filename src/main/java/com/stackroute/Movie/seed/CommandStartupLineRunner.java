package com.stackroute.Movie.seed;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.logging.Logger;

public class CommandStartupLineRunner implements CommandLineRunner {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CommandStartupLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started with command-line arguments");
    }
}
