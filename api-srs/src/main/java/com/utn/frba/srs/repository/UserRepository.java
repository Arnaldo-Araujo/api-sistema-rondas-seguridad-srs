package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySecurityCompany_id(Long empresaId);

    List<User> findByRole(String role);

    User findTop1ByDocumentTypeAndDocumentValue(String type, String value);

    Optional<User> findByName(String username);
}