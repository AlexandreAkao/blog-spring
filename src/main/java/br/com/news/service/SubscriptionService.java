package br.com.news.service;

import br.com.news.model.Subscription;
import br.com.news.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription create(Subscription subscription) {
        return this.subscriptionRepository.save(subscription);
    }
}
