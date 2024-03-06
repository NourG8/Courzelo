package com.example.corzello.Controller;
import com.example.corzello.Service.PythonScriptRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/scrape")
@CrossOrigin(origins = "http://localhost:4200")
public class ScrapingController {
    private final RestTemplate restTemplate;

    public ScrapingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/api/scrape")
    public ResponseEntity<Object> callPythonAI(@RequestBody Object request) {
        PythonScriptRunner psr = new PythonScriptRunner();
        boolean success = psr.runPythonScript();

        if (success) {
            return ResponseEntity.ok().build(); // Success response
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Error response
        }
    }
}