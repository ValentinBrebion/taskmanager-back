# TaskManager

Application de gestion de tâches développée avec **Java Spring Boot**, **PostgreSQL** et, à terme, **Angular** pour l'interface utilisateur.

## Technologies utilisées

- **Java 21** : langage de programmation
- **Spring Boot** : framework backend
- **Maven** : gestion des dépendances et compilation
- **Spring Web** : création d'une API REST
- **Spring Data JPA** : accès aux données
- **PostgreSQL** : système de gestion de base de données
- **pgAdmin 4** : administration de la base de données
- **Angular** : frontend prévu

## Prérequis

Avant de lancer le projet, les outils suivants doivent être installés :

- [Java JDK 21](https://adoptium.net/)
- [Git](https://git-scm.com/install/windows)
- [PostgreSQL](https://www.postgresql.org/download/)
- [pgAdmin 4](https://www.pgadmin.org/download/)
- [Visual Studio Code](https://code.visualstudio.com/) ou un autre IDE

## Initialisation du projet

### 1. Création du backend Spring Boot

Le projet a été créé avec **Spring Initializr**, le générateur officiel de projets Spring Boot.

Site utilisé : https://start.spring.io/

Configuration choisie :

| Paramètre | Valeur |
|---|---|
| Project | Maven |
| Language | Java |
| Spring Boot | Version proposée compatible avec Java 21 |
| Group | À confirmer dans le projet |
| Artifact | `taskmanager` |
| Packaging | Jar |
| Java | 21 |

Dépendances ajoutées :

- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Validation

Après avoir téléchargé le projet généré, les fichiers ont été extraits dans le dossier `C:\Git\taskmanager\taskmanager`.

### 2. Configuration de PostgreSQL

La base de données est gérée avec PostgreSQL et administrée graphiquement depuis pgAdmin 4.

Dans pgAdmin :

1. Se connecter au serveur PostgreSQL local.
2. Ouvrir l'outil Query Tool.
3. Créer une base de données nommée `taskmanager` si elle n'existe pas déjà.

Commande SQL :

```sql
CREATE DATABASE taskmanager;
```

La base de données doit correspondre à celle indiquée dans la configuration Spring Boot.

### 3. Configuration du backend

Dans le fichier `src/main/resources/application.properties`, configurer la connexion à PostgreSQL :

```properties
spring.application.name=taskmanager

spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=postgres
spring.datasource.password=VOTRE_MOT_DE_PASSE

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

**Important :** remplacer `VOTRE_MOT_DE_PASSE` par le mot de passe du compte PostgreSQL utilisé. Ne jamais publier son vrai mot de passe dans un dépôt Git public.

L'option `spring.jpa.hibernate.ddl-auto=update` permet à Hibernate de mettre à jour le schéma de la base à partir des entités JPA.

## Lancer le backend

Ouvrir un terminal dans le dossier du backend :

```powershell
cd C:\Git\taskmanager\taskmanager
```

Lancer Spring Boot avec le Maven Wrapper fourni dans le projet :

```powershell
.\mvnw.cmd spring-boot:run
```

Lorsque le message indiquant que `TaskmanagerApplication` a démarré apparaît, le backend est lancé.


## Structure du projet

```text
taskmanager/
├── taskmanager/                 # Backend Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/            # Code Java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                # Tests
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
└── frontend/                    # Frontend Angular prévu
```




## Prochaines étapes

- [ ] Finaliser les entités et les opérations CRUD des tâches.
- [ ] Tester les routes de l'API REST.
- [ ] Créer le frontend avec Angular.
- [ ] Connecter Angular à l'API Spring Boot.
- [ ] Ajouter des tests automatisés.
- [ ] Améliorer la gestion des erreurs et la validation des données.

## Objectif

L'objectif est de développer une application permettant de créer, consulter, modifier et supprimer des tâches, avec une API REST en Java et une interface web Angular connectée à PostgreSQL.