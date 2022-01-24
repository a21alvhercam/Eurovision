# Eurovision
Es vol desenvolupar un programa per a simular la votació de la final del concurs
d'Eurovisió. De cada país ens interessa emmagatzemar únicament el seu nom i el
nombre de vots acumulat.
El programa principal definirà la estructura de dades per a emmagatzemar el total de
països que participen en la final (26 països), i li demanarà a l'usuari que ompli els seus
noms (només els noms), inicialitzant el comptador de vots a 0 per a cada país. Després,
des del programa principal es farà el següent:
1. Es generaran les votacions aleatòries per a cada país. Per a cada país, es triaran
aleatòriament altres 10 països als qui votar, i se'ls atorgaran les puntuacions de
1, 2, 3, 4, 5, 6, 7, 8, 10 i 12 punts, respectivament. Aquesta selecció aleatòria ha
de complir dues condicions:
• Un país no pot votar més d'una vegada a un altre país.
• Un país no pot votar-se a si mateix.
2. Amb les votacions aleatòries de cada país, es sumaran els corresponents punts
als països afectats.
3. En acabar la votació de cada país, es mostren les votacions efectuades pel país
ordenades de major a menor puntuació i la classificació general, també ordenada
de major a menor puntuació. Presentar el llistat a dues columnes.
M03 - Programació
UF2 – Programació modular
Projecte 1
Creat per Iriana Bonet
Adaptat per Santi Rivas
Pàgina 2 de 9
4. Els passos 1, 2 i 3 es repetiran successivament per a cada país, simulant així el
seu vot a la resta de països.
5. Una vegada completades les votacions, es mostra la classificació final ordenada
per punts de major a menor puntuació. Mostrar el llistat a dues columnes.
6. Es donarà un premi extraordinari “TheBest” a aquell país que hagi obtingut un
nombre més alt de dotzes (puntuació màxima). Mostra el nom del país (o països
en cas d’empat).
7. Es donarà un segon premi extraordinari “TheLooser” a aquell país que hagi
obtingut un nombre més alt de zeros (sense puntuació). Mostra el nom del país (o
països en cas d’empat).
8. Al finalitzar el procés, el programa preguntarà a l'usuari si vol repetir el concurs
amb els mateixos països. Si contesta que sí (S), amb els mateixos noms de països
es repetirà el concurs, amb els vots aleatoris novament (és a dir, tornarem al pas
1). Si contesta que no (N), finalitza el programa.
9. Has d’afegir a l’estructura de dades un camp que sigui una matriu, i després
implementar, com a mínim, una funció i un procediment que treballin amb la
matriu. Penseu bé que voleu guardar a la matriu perquè tingui sentit en aquest
programa.
