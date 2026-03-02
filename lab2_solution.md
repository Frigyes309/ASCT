0.a
list_property
Előnyök:
 - Kevesebb csomópont és kapcsolat kell
 - Kisebb tárhelyigény

Hátrány:
 - Lassú


HAS_GENRE:
Előnyök:
 - Gyors
 - Skálázható (önálló csomópont)

Hátrány:
 - Több komponens
 - Nagyobb lekérdezés


0.b
Színés -[k: Karakter]-> Film
Karakter -[sz: Színész]-> Film
Színész -[f: Film]-> Karakter

Így lehet ugyanaz a karakter több filmben is és lehet önálló tulajdonsága is
A gráf viszont sokkal komplexebb lesz

1.3.a
MATCH (a:Person)-[:ACTED_IN]->(m:Movie)
RETURN a.name AS name, count(m) AS total
ORDER BY total DESC, name
limit 10;

1.3.b
MATCH (a:Person)-[r1:ACTED_IN]->(:Movie {title: 'The Matrix Reloaded'}),
      (a)-[r2:ACTED_IN]->(:Movie {title: 'John Wick'})
RETURN a.name AS name, r1.roles AS roles1, r2.roles AS roles2
OREDER BY name, roles1, roles2;

1.3.c
MATCH path=allshortestpaths(
    (m:Person {name: "Steven Spielberg"})-[:PRODUCED*]-(n:Person)
)
WHERE n.person_id <> m.person_id
RETURN length(path)/2 AS spielberg_number, count(distinct n.person_id) AS total
ORDER BY spielberg_number;

2.a
MATCH (m:Movie)
WHERE m.title IN ["Diana: In Her Own Words", "Samurai Jack: The Premiere Movie", "Kobe Bryant's Muse", "Money Heist: The Phenomenon"]
DETACH DELETE m;

2.b.1
(Person) [0..*] – :ACTED_IN ➞ [0..*] (Movie)
(Person) [0..*] – :DIRECTED ➞ [0..*] (Movie)
(Person) [0..*] – :WROTE ➞ [0..*] (Movie)
(Person) [0..*] – :PRODUCED ➞ [0..*] (Movie)

2.b.2 isolation
MATCH (n)
WHERE NOT (n)--()
RETURN count(n) AS isolated_nodes;

18

2.b.3 min-max-avg actor
MATCH (a:Person)-[:ACTED_IN]->(m:Movie)
WITH a, count(m) AS film_count
RETURN min(film_count) AS min_films, 
       avg(film_count) AS avg_films, 
       max(film_count) AS max_films;

1
1.7515...
19

2.b.4 min-max-avg film
MATCH (p:Person)
OPTIONAL MATCH (p)-[:ACTED_IN]->(m:Movie)
WITH p, count(m) AS film_count
RETURN min(film_count) AS min_films, 
       avg(film_count) AS avg_films, 
       max(film_count) AS max_films;

0
0.7764...
19

2.b.5
MATCH (m:Movie)
OPTIONAL MATCH (a:Person)-[:ACTED_IN]->(m)
WITH m, count(a) AS count
RETURN min(count) AS min, avg(count) AS count, max(count) AS max;

ACTED_IN
1
3.9674...
19

DIRECTED
0
1.0704...
6

WROTE
0
1.675...
6

PRODUCED
0
1.7409...
5

2.c
Property graph:
 - Az kapcsolatokra (élekre) lehet írni tulajdonságokat.
   - ER diagrammon ugyanehhez szükségünk van egy külön entitásra
 - Nincs "kötelező" séma, két személynek lehetnek teljesen különböző attribútumai.
   - ER diagrammon ilyet nem lehet megcsinálni, mert oszlopokra illesztünk
 - Könnyű külső kulcsos lekérdezéseket csinálni benne, mert kapcsolatokat tárolunk le benne 
   - A külső kulcsos lekérdezések drágák, mert mélységi beárás kell, ami költséges.
