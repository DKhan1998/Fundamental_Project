package com.qa.billyshakes.repo;

import com.qa.billyshakes.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLIneRepository extends JpaRepository<OrderLine, Long> {
}
