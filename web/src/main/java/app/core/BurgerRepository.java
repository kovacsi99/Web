package app.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
