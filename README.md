# Code Review Demo — Projet Java / Spring Boot (Maven)

Ce projet illustre la démonstration de revue de code automatisée avec **GitHub + n8n + Google Gemini + Gmail** sur la branche `develop`.

## Structure du projet

```text
code-review-demo-java/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/demo/codereview/
    │   │   ├── CodeReviewDemoApplication.java
    │   │   ├── model/User.java
    │   │   ├── repository/UserRepository.java
    │   │   ├── repository/UserRepositoryCustom.java
    │   │   ├── repository/UserRepositoryCustomImpl.java
    │   │   └── controller/UserController.java
    │   └── resources/
    │       ├── application.yml
    │       └── data.sql
    └── test/
        └── java/com/demo/codereview/
            └── UserControllerTest.java
```

## Lancer le projet en local

```bash
mvn clean test
mvn spring-boot:run
```

## Scénario de démonstration sur `develop`

1. **Commit initial sain** : `UserController` utilise `UserRepository.findByEmailIgnoreCase(email)` et un secret externalisé `${APP_API_SECRET}`.
2. **Commit de test avec anomalie volontaire** : ajout de `UserRepositoryCustomImpl.searchByEmailVulnerable(String email)` avec concaténation JPQL (`"SELECT u FROM User u WHERE u.email = '" + email + "'"`) pour vérifier la détection `[CRITIQUE]` par Gemini lors d'un `git push origin develop`.
# code-review-demo-java
