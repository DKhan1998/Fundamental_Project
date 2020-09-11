package com.qa.billyshakes.repo;

import com.qa.billyshakes.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
