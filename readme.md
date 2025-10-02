# Kafka Spring Boot Demo Project

## Description du Projet

Ce projet est une application de démonstration complète utilisant **Apache Kafka** et **Spring Cloud Streams** pour illustrer les concepts de messaging, de streaming de données en temps réel, et d'analyse de données.

## Objectifs d'Apprentissage

### 1. Installation et Configuration Kafka Manuelle

- Télécharger et installer Apache Kafka
- Démarrer Zookeeper
- Démarrer Kafka Server
- Tester la communication avec Kafka-console-producer et kafka-console-consumer

### 2. Configuration Kafka avec Docker

- Créer un fichier `compose.yml` pour orchestrer les services
- Démarrer les conteneurs Docker : Zookeeper et Kafka Broker
- Tester la connectivité avec les outils en ligne de commande Kafka

### 3. Développement d'Applications Spring Boot avec Kafka

- **Service Producer** : API REST pour publier des messages dans Kafka
- **Service Consumer** : Service pour consommer et traiter les messages
- **Service Supplier** : Service pour fournir des données en continu
- **Service Data Analytics** : Traitement de flux en temps réel avec Kafka Streams
- **Application Web** : Interface utilisateur pour visualiser les résultats d'analyse en temps réel

## Architecture Technique

- **Framework** : Spring Boot 3.x
- **Messaging** : Apache Kafka + Spring Cloud Streams
- **Stream Processing** : Kafka Streams
- **Frontend** : Application Web temps réel
- **Containerisation** : Docker & Docker Compose

## Statut du Projet

🚧 **En cours de développement**

Ce projet est actuellement en phase de développement. Les fonctionnalités seront ajoutées progressivement selon les objectifs d'apprentissage définis.

---

_Ce projet sert de base d'apprentissage pour maîtriser l'écosystème Kafka dans un environnement Spring Boot moderne._
