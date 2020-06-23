package br.unifor.app.controller.pub;

import br.unifor.app.model.Subscription;
import br.unifor.app.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subscription")
public class _SubscriptionController {
    private final SubscriptionService subscriptionService;

    public _SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // CREATE - POST http://localhost:8081/subscription
    @PostMapping
    public ResponseEntity<Subscription> add(@RequestBody Subscription body) {
        try {
            var subscription = subscriptionService.save(body);
            return ResponseEntity.status(201).build();
        } catch (Exception ex) {
            // ignora isso aqui é so que eu quis deixar bonitinho kk
            System.err.println("*************\nError on: " +
                    this.getClass().getName() +"\n"+ex.toString() + "\n*************");
            return ResponseEntity.status(404).build();
        }
    }
}
