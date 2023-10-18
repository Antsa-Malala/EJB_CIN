# EJB_CIN
*BanqueApp
    L'application java contenant les dto et les interfaces remotes de la section banque
*FoncierApp
    L'application java contenant les dto et les interfaces remotes de la section foncière
*EjbBanque
    Le module EJB java contenant les sessionBean et les entitybean de la section banque
*EjbFoncier
    Le module EJB contenant les sessionBean et les entitybean de la section foncière
*EnterpriseFoncierApplication
    L'application entreprise regroupant le module EJB banque et son application web ainsi que le web services à travers lequel il peut être accessible
*EntrepriseBanqueApplication
    L'application entreprise regroupant le module EJB foncier et son application web ainsi que le web services à travers lequel il peut être accessible
*TestSante
    Le web services contenant toutes les fonctionnalités de la section santé ainsi que les webservices des deux autres sections qui seront appelé par le client
*clientpresidence
    Le serveur d'affichage qui va appeler les trois services pour afficher les informations regroupées
*database
    Un dossier qui contient tout les scripts des trois SGBD avec leur données de test
*Jar
    Un dossier contenant tout les jars utils au projet 