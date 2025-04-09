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
