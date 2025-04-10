# Our Wishify Project 

Dette projekt er lavet af gruppe 3 der består af Julius, Frederik, Noah og Tobias. 
Formålet med vores program er, at man som bruger kan oprette en konto, oprette en ønskeliste og oprette ønsker inde i ønskelisten
Derudover kan man dele ønskelisten med andre brugere, som kan reservere ønsket. Ejeren af ønskelisten kan ikke se hvem eller om hvorvidt ønsker er reserveret.
Vi har draget meget inspiration fra ønskeskyen. 

## Hvordan er det lavet

Vi har brugt Spring.framework, CSS, HTML og Javascript
Vi har sat Controllers op der bruger get og post mapping, som taler med vores HTML sider. 
Vores controllers får metoder fra vores repositories og fra vores service klasser, og vores repositories får information fra vores modeller.

Derudover har vi et database script med 3 tables, som fortæller om vores users, wishes og wishlists. Det script snakker sammen med vores repositories igennem datasource. 


## Hvordan bruger man programmet

For at bruge programmet kan i enten lave en ny bruger selv også logge ind, eller i kan bruge en af de brugere der allerede eksistere. 
Herefter kan i oprette ønskelister, og oprette ønsker inde i de ønskerliste. I kan derefter dele ønselister med hinanden. 

## Optimeringer

Vi vil naturligvis gerne have gjort mere ud af styling, og derudover kan du godt provokere en whitelabel error ved at skrive alm tekst, når du skal lave et ønske.


## Test af programmet

Vi har 2 profiler ledige til aftestning af programmet, og derudover kan man selv oprette brugere for at teste.
Hjemmedesiden bliver holdt kørende fra 19-04-2025 til og med 24-04-2025
Hjemmesidens url: wishify.azurewebsites.net

Bruger1 (Kun på azure hjemmeside):  Brugernavn: demo@mail.dk
                                    Password: demo1234

Bruger2 (Både azure og lokalt): Brugernavn = frmo@dong.dk
                                Password = blyat


## Glossary / Ordliste
Glossary

Glossary:
En betegnelse for en ordbog

ReadMe:
En ReadMe-fil er en fil, der er i de fleste projekter. Som navnet antyder, er det en fil du skal læse, og ofte inden du gør brug af programmet.

Azure:
Azure er en cloud løsning, og er en af de største og mest brugte på markedet. Azure bruges til at deploye programmer til webbet.

ResponseEntity
Denne klasse fra spring.framework bruges til HTTP. Den er smart fordi du også kan give respons koder som fx. ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
Her står den får at fortælle hvis du ikke er logget ind, altså “unautherized”

Fragments:
Fragments bruges til at genbruge elementer på vores hjemmeside, som vi bruger ofte. Dette er for eksempel Header og Footer, da det bruges gentagne gange på vores hjemmeside. Login og Registration pop ups er også fragments.

Thymeleaf / th:
Thymeleaf er en form for skabelon som hjælper med at oprette og vise hjemmesider, både lokalt og web-baseret.

Modal/modal content:
Et navn der bruges til vores pop up form. Modal refererer til en form.

@GetMapping
Håndterer HTTP Get anmodninger. Henter data til programmet.

@PostMapping
Håndterer HTTP Post anmodninger. Brugt til at oprette ressourcer.

@Controller
En java-klasse som håndterer HTTP anmodninger og returnerer en respons. Bliver brugt til at formidle information mellem server og program.

@Autowired
“The Spring framework enables automatic dependency injection”
Det betyder egentlig at du kan skrive @Autowired i din klasse kan du forbinde to klasser igennem noget der hedder beans

@RequestParam
Request som betyder anmodning, betyder at metoden anmoder om noget information. Hvis du har en metoder, hvor der skal opdateres en ønskeliste, så vil du have request parametre til alle de variabler der skal opdateres.

@Repository
Markerer en klasse som et Data Access Object (DAO). Bliver brugt til at vise at det er denne klasse som giver information omkring data.

@Service
Bruges til at markere, at beans indeholder business logic. Altså at holde styr på user inputs og formidler user inputs mellem data og user interface.


