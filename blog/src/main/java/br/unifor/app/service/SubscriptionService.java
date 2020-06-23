package br.unifor.app.service;

import br.unifor.app.model.Category;
import br.unifor.app.model.Subscription;
import br.unifor.app.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription save(Subscription item){
        return subscriptionRepository.save(item);
    }

    public void subscribe(String email, Category category){
        // TODO
    }

    public void unscribe(String email, Category category){

    }

    public List subscribeByCategory(Category category){
        return Collections.emptyList();
    }
}

