package com.MOOC.OnlineLearningPlatfrom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MOOC.OnlineLearningPlatfrom.Entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    // you can add custom queries later, e.g. findByEmail
    UserAccount findByEmail(String email);
}
