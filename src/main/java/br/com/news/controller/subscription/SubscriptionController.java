package br.com.news.controller.subscription;

import br.com.news.model.Image;
import br.com.news.model.News;
import br.com.news.model.Subscription;
import br.com.news.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<Object> crete(@RequestBody Subscription subscription) {
        try {
            Subscription newSubscription = this.subscriptionService.create(subscription);

            return ResponseEntity.status(201).body(newSubscription);
        } catch (Exception e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Ocorreu um erro");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
