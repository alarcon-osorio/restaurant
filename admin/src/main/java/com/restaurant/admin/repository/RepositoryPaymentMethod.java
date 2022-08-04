package com.restaurant.admin.repository;

import com.restaurant.admin.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaymentMethod extends JpaRepository<PaymentMethod, Long> {

    @Modifying
    @Query(value = "UPDATE service_order SET payment_method = ?1, discount = ?2, close = 1 WHERE table_number = ?3 AND close = 0 AND cancel = 0", nativeQuery = true)
    void savePaymentMethod(String method, long discount, long table);

}
