# Week1
Week one exercises

Læringsmål mandag:

 1) Understand the fundamental benefits in having the same set up locally for all developers, as on the production server
    -Gør det lettere at dele ting imellem sig på et developer team, og man undgår konflikter mellem det de forskellige
    medlemmer har lavet lokalt når det hele bliver pushed op og gerne skulle virke som helhed.
 
 2) Start a local Virtual Ubuntu 18.04 Server using Vagrant
    - Ikke så meget at sige om dette læringsmål.
 
 
 3) SSH into a local Virtual Ubuntu 18.04 server, started by Vagrant and Virtual Box
    - Ikke så meget at sige om dette læringsmål.
 
 4) Connect to a MySQL server running on a local Virtual Ubuntu 18.04 server, started by Vagrant and Virtual Box
    - Ikke så meget at sige om dette læringsmål.
    
Læringsmål tirsdag:
 
 1) Redegøre for ORM frameworks generelt og deres pros/cons
    - ORM (Object Relational Mapping) frameworket gør det meget lettere at arbejde med crud metoder, da man ikke skal lave dem selv,
    frameworket indeholder alle de metoder man har brug for. Frameworket kan også automatisk oprette tabeller i en DB, så længe man 
    allerede har oprettet DB'en. Frameworket kan også, ud fra annoteringer, finde ud af hvordan tabellerne skal skal oprettes
    og hvilke datatyper de forskellige kolonner skal have osv. ORM kan også finde ud af at oprette entitets klasser ud fra tabeller i en DB.
    Problemet med ORM er at det kan være svært at styre hvordan tabellerne helt kommer til at blive udformet, med mindre man er meget
    præcis i sine annoteringer og det kan ende med at man får lavet en DB med en meget rodet struktur.
 
 2) Redegøre for forskellen mellem JPA og andre persistensmetoder
 
 
 3) Redegøre for de mest brugte klasser og metoder i JPA
    - EntityManagerFactory: Bruges til at lave EntityManagers. Det er i factory'en at man bestemmer hvilken DB der skal arbejdes på.
    - EntityManager: Det er den der har alle crud metoderne samt metoder til at lave queries.
    (I de følgende metoder står em for EntityManager)
    - em.getTransaction().begin(); starter en transaction til DB'en og først der efter kan crud metoderne køres.
    - em.getTransaction().commit(); comitter de ændringer man har lavet efter en transaction er startet.
    - em.close(); lukker forbindelsen til serveren. Skal gøres i slutningen af alle metoder det starter en transaction.
    - em.createQuery(); laver et JPQL query.
    - em.persist(); opdeler et objekt i dets attributter og gemmer dem i en tabel i DB'en.
    
 4) Oprette et basalt Java projekt med JPA og benytte annoteringer til at persistere entiteter i database
    - Se Book klassen i projektet TirsdagUge1Opg1 for eksempel på en etitesklasse med nogle få annoteringer.
 
 5) Redegøre for og demonstrere brug af begreber som EntityManager, EntityManagerFactory samt Persistence.xml
    Har allerede beskrevet EntityManagerFactory og EntityManager i punkt 3. Persistence filen bruges til at specificere hvilken DB
    man arbejder på og hvordan man arbejder på den (fx drop and create i stedet for create)
 
 6) Demonstrere Insert og Select
 
