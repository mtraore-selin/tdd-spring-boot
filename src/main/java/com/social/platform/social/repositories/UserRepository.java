package com.social.platform.social.repositories;

import com.social.platform.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Specify here the custom method yo want
}
