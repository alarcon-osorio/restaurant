package com.restaurant.kitchen.repository;

import com.restaurant.kitchen.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPrepared extends JpaRepository<ServiceOrder, Long> {

    @Modifying
    @Query(value = "UPDATE service_order SET prepare = 1 WHERE id = ?1 AND close = 0 AND cancel = 0", nativeQuery = true)
    void prepareById(long id);

    @Modifying
    @Query(value = "UPDATE service_order SET prepared = 1 WHERE id = ?1 AND close = 0 AND cancel = 0", nativeQuery = true)
    void preparedById(long id);

    @Modifying
    @Query(value = "UPDATE service_order SET prepare = 1 WHERE table_number = ?1 AND close = 0 AND cancel = 0", nativeQuery = true)
    void prepareByTable(long table);

    @Modifying
    @Query(value = "UPDATE service_order SET prepared = 1 WHERE table_number = ?1 AND close = 0 AND cancel = 0", nativeQuery = true)
    void preparedByTable(long table);

}
