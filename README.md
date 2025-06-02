# 🧑‍🎓 Plateforme de gestion des stages et alternances

Projet développé dans le cadre de mon stage de fin d'études, cette application web vise à digitaliser et centraliser la gestion des stages et alternances pour les étudiants de mon école.  
Elle facilite les interactions entre **étudiants**, **tuteurs (enseignants)** et **entreprises**.

---

## ✨ Fonctionnalités principales

🔐 **Authentification par rôle (JWT)**  
L'application dispose de trois espaces distincts avec des droits spécifiques :

- 🎓 **Espace Étudiant**
  - Consultation et postulation aux offres de stage ou d’alternance
  - Suivi de ses candidatures
  - Dépôt de **feedbacks sur son expérience**, consultables par les futurs étudiants (traçabilité)

- 🧑‍🏫 **Espace Tuteur (Professeur)**
  - Suivi des étudiants affectés
  - Validation ou retour sur les expériences déclarées
  - Interaction avec les entreprises

- 🏢 **Espace Entreprise**
  - Publication d’offres de stage / alternance
  - Consultation de profils étudiants par **compétences**
  - Affectation de tuteurs

---

## 🛠️ Stack technique

- **Frontend** : React + TypeScript
- **Backend** : Symfony (API REST)
- **Authentification** : JWT (JSON Web Token)
- **Base de données** : MySQL
- **ORM** : Doctrine
- **Gestion des états** : React Context API
- **Outils** : Docker (facultatif), Postman pour le test de l'API

---

## ▶️ Lancer le projet en local

### 🔙 Back-end (Symfony)
cd back-end
composer install
php bin/console doctrine:migrations:migrate
symfony server:start
🔜 Front-end (React)
cd front-end
npm install
npm start


📸 Quelques captures d’écran 


![Image1](https://github.com/user-attachments/assets/04e6dc74-b682-4e5d-ae81-eb6e9395b7e9)

![Image2](https://github.com/user-attachments/assets/cfd7e6b1-c411-485e-8978-bbd961155955)
