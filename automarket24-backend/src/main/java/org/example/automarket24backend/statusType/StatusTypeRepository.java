package org.example.automarket24backend.statusType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTypeRepository extends JpaRepository<StatusType, Integer> {
    StatusType getStatusTypeByName(String statusTypeName);
}
