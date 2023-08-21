package com.blog.accountservice.domain.repository;

import com.blog.accountservice.domain.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dai.le-anh
 * @since 8/15/2023
 */

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
