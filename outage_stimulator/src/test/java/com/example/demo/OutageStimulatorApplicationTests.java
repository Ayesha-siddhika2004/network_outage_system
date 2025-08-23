package com.example.demo;

import com.example.outage.OutageStimulatorApplication; // Corrected: Import your actual main application class
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource; // Import this

@SpringBootTest(classes = OutageStimulatorApplication.class) // Corrected: Reference your actual main application class
// This line disables the Spring Cloud Config client for this test context.
// This is the cleanest way to prevent the "No spring.config.import set" error during tests.
@TestPropertySource(properties = {"spring.cloud.config.enabled=false"})
class OutageStimulatorApplicationTests {

    @Test
    void contextLoads() {
        // This test method ensures the Spring application context loads successfully.
        // If it passes, your main application class is being found without
        // trying to connect to a Config Server.
    }
}
