# WebServicesProject
projet Younsi Web Services (Hotel management)26/02/2015


RAF (Reste A Faire)

Manage post request,
Link the table using JPA (one to many, many to one etc...),
Display response result from readAll request



Pour executer le projet, 3 étapes sont nécessaires:

  1 - Récupérer le projet sous "Intelli J"
    VCS -> Checkout from Version Control -> Git:
      Git Repository Url: https://github.com/olivierGitHub/WebServicesProject
  
  2- Modifier le fichier "Persistence.xml":
    src -> main -> Ressources -> META-INF
      Remplacer le user et password (ligne 9 et 10) avec vos identifiants MySQL
      
  3- Creer sous MySQL UNIQUEMENT le schema "webproject":
      CREATE SCHEMA webproject

REMARQUE:
    Pour vérifier la bonne execution des requêtes, faire sous "Google Chrome":
        F12 -> onglet "Network"
            puis cliquer sur la requête correspondante

