package org.example.automarket24backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmailContaining(String email);
    User findUserByPhoneNumberContaining(String phoneNumber);
}
