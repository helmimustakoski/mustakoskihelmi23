-- Tapparan kotiottelut. Tulosjoukossa pitää olla seuraavat tiedot: pelipäivä, pelipaikkakunta,
--kotijoukkueen nimi (joka tietysti on tässä Tappara) ja vierasjoukkueen nimi.

SELECT o.ottelu_id,
o.ottelupaiva AS pelipaiva,
j.kotipaikka AS pelipaikkakunta,
'Tappara' AS kotijoukkue,
vierasjoukkue.nimi AS vierasjoukkue
FROM ottelu o
JOIN joukkue j ON o.kotijoukkue_id = j.joukkue_id
JOIN joukkue vierasjoukkue ON o.vierasjoukkue_id = vierasjoukkue.joukkue_id
WHERE j.nimi = 'Tappara';
