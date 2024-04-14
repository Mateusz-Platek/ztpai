package org.example.automarket24backend.userType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    UserType findUserTypeByName(String userTypeName);
}
