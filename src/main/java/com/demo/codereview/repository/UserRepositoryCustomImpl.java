package com.demo.codereview.repository;

import com.demo.codereview.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

 /*   @Override
    public List<User> searchByEmailVulnerable(String email) {
        // Cas de test volontaire pour la démo IA : injection JPQL par concaténation directe
        String jpql = "SELECT u FROM User u WHERE u.email = '" + email + "'";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }*/
}
