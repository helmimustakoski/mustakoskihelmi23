-- Luettelo otteluista, jotka on pelattu marraskuun 2023 aikana, sekä niiden tulokset. Tulosjoukossa pitää olla seuraavat tiedot: pelipäivä, pelipaikkakunta (voidaan olettaa, että se
-- on ottelun kotijoukkueen kotipaikka), kotijoukkueen nimi ja maalimäärä, sekä vierasjoukkueen nimi ja maalimäärä

SELECT o.ottelu_id,
o.ottelupaiva AS pelipaiva,
j.kotipaikka AS pelipaikkakunta,
kotijoukkue.nimi AS kotijoukkue,
t.kotijoukkueen_maalit AS kotijoukkueen_maalit,
vierasjoukkue.nimi AS vierasjoukkue,
t.vierasjoukkueen_maalit AS vierasjoukkueen_maalit
FROM ottelu o
JOIN joukkue kotijoukkue ON o.kotijoukkue_id = kotijoukkue.joukkue_id
JOIN joukkue vierasjoukkue ON o.vierasjoukkue_id = vierasjoukkue.joukkue_id
JOIN tulos t ON o.tulos_id = t.tulos_id
JOIN joukkue j ON kotijoukkue.joukkue_id = j.joukkue_id
WHERE o.ottelupaiva BETWEEN '2023-11-01' AND '2023-11-30';