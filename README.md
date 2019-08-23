# Week1
Week one exercises

Læringsmål mandag:

 1) Understand the fundamental benefits in having the same set up locally for all developers, as on the production server
    - Gør det lettere at dele ting imellem sig på et developer team, og man undgår konflikter mellem det de forskellige
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
    - Jeg syntes ikke vi har hørt om andre persistensmetoder, men kan være jeg bare har sovet. Så kan ikke rigtigt svare på den her.
 
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
    - Har allerede beskrevet EntityManagerFactory og EntityManager i punkt 3. Persistence filen bruges til at specificere hvilken DB
    man arbejder på og hvordan man arbejder på den (fx drop and create i stedet for create)
 
 6) Demonstrere Insert og Select
    - Jeg har brugt em.persist() i stedet for queries med insert. Se fx addCustomer() metoden i CustomerFacade i tirsdagUge1Opg3.
    - Select kan ses et eksempel på i samme facade i allCustomers() metoden.
    
 Læringsmål onsdag:   
 
 1) Redegøre for begrebet Restfull webservices
 - Jeg er stadig lidt usikker på præcist hvad det indebærer. Sådan som jeg forstår det er det en form for webservice hvor du via nogle
 endpoints sender noget data ud som kan tilgås af andre lige meget hvilket sprog de har skrevet deres application i. I vores tilfælde 
 er det Json, men det kunne også være xml og måske andre ting?
 
 2) Redegøre for konventioner ved opbygning af REST api'er
 - Lidt det samme som svaret ovenfor. Det handler overordnet set om at applikationer lavet på alle mulige forskellige måder kan bruge
 den data du med din RESTful api sætter til rådighed.
 
 3) Oprette et Java projekt med REST endpoints
 - Se alle opgaver fra onsdag, torsdag og fredag for eksempler.
 
 4) Implementere kode indeholdende de mest grundlæggende REST annotationer (GET kun)
 - Se alle opgaver fra onsdag, torsdag og fredag for eksempler.
 
 5) Håndtere parametre i REST endpoints i egne kodeeksempler
 - Se metoden getCustomerById(@PathParam("id") int id) i klassen CustomerResource i projektet OnsdagUge1Opg2 for eksempel.
 
 6) Redegøre for, og demonstrere det udleverede start project til brug for JPA/REST-projekter
 - Det udleverede startprojekt er lavet så vi ikke behøver kører wizarden for at lave en entity klasse og en RESTful web service, 
 samt at de dependencies vi skal bruge allerede er tilføjet. Se projekter fra torsdag og fredag for eksempel.
 
 Læringsmål torsdag:
 1) Designe simple GET-endpoints med brug af en underliggende database tilgået via JPA
 - Se EmployeeRessource klassen i TorsdagUge1Opg1 for eksempler på endpoints der gør brug af underlæggende DB.
 
 2) Kunne redegøre for nødvendigheden af i brug af JSON
 - Json er nødvendigt fordi det kan bruges til at representer vores java objekter som strings der kan forstås af en masse andre sprog,
 hvilket er hele ideen med at følge RESTful guidelines til sin api, nemlig at alle skal kunne gøre brug af den data man tilbyder.
 
 3) Kunne redegøre for korrekt JSON syntaks
 - Jeg er nok ikke helt stærk i korrekt JSON syntaks. Overordnet set er det en string med en række key/value pairs.
 
 4) Kunne redegøre for Data Tranfer Objects (DTO's) og serialisering mellem Java objekter og JSON
 - DTO'er bruges når du gerne vil bestemme præcist hvilken information om objekter du vil sende ud, fx med dine endpoints. Hvis man
 fx har et bruger objekt er men nok ikke interesseret i at sende hans password med ud, hvis man fx skal lave en liste over alle brugere.
 
 5) Kunne konvertere frem og tilbage mellem Java objekter og JSON i egen kode
 - Jeg tror ikke jeg har nogen eksempler hvor jeg går fra JSON til java objekt, men alle projekter fra OnsdagUge1Opg2 og frem laver
 java objekter om til JSON i resource klasserne. Vi bruger librariet Gson og det kan konvertere begge veje, fromJson og toJson.
 
