Aquest codi Java és un programa bàsic de gestió de compres anomenat "SAPAMERCAT". Ens permet afegir productes de diferents categories a un carret de compres, mostrar el contingut del carret, passar per caixa per "pagar" i registrar les excepcions que ocorrin durant l'execució del programa i guardar-ho en un fitxer de registres.

### Estructura del Codi i com ho he organitzat:

1. **Importacions de paquets**: Importa les classes necessàries del paquet `Productes` i altres classes com `Scanner`, `File`, `PrintStream`, `LocalTime`, `ArrayList`, `HashMap`, etc.

2. **Declaracions de Variables**: Declara variables estàtiques i constants per a la gestió de productes, preus, carret de compres, etc.

3. **Mètode `crearCarpetasFitxers()`**: Crea l'estructura de carpetes i fitxers necessaris per al programa.

4. **Mètodes `comprarProductes()`, `afegirAlimentCarro()`, `afegirTextilCarro()`, `afegirElectronicaCarro()`**: Permeten a l'usuari afegir productes d'alimentació, tèxtils o electrònics al carret de compres. Manejen excepcions i validen l'entrada de l'usuari.

5. **Mètodes `afegirProducte()`, `afegirProductesLlistaCaixa()`, `mostrarCarroDeCompra()`, `passarPerCaixa()`**: Gestionen l'afegida de productes al carret de compres, mostrant el seu contingut, calculant el preu total i buidant el carret després de pagar.

6. **Mètodes de Menú**: `menuInici()` i `menuProducte()` mostren els menús d'inici i de selecció de productes.

7. **Mètode `afegirException(Exception e)`**: Registra les excepcions que ocorrin durant l'execució del programa en un fitxer de registre.

### Notes Finals:
- No he tingut temps a fer una de les parts de Tèxtil, ja que aquest cap de setmana no he estat a casa i no em vaig organitzar correctament el temps.
- En el meu cas he triat ArryList, per al fet que ja havia tractat amb ella anteriorment i ja tenia coneixements d'ella
- HashMap, en aquest cas no havia tractat en cap d'ells, però després de mirar una mica creia que per aquest codi era millor el hashMap, ja que tot ho podia guardar en una Key (el codi o el codi+preu) i tota la resta d'informació podien anar a dins i no tenir cap problema.
- Pel meu cas he anat afegint tot simultàniament a les diferents cistelles, pel fet que creia que era més fàcil fer-ho al moment i no quan ho necessitava això fa que vagi una mica més lent, però per imprimir ho fa de cop i no ha de calcular-ho tot de cop.