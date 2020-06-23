package br.unifor.app.repository;

import br.unifor.app.model.Image;
import br.unifor.app.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
