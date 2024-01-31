-- Kaikki tamperelaisten joukkueiden ottelut (ts. sellaiset ottelut, joissa tamperelainen joukkue on joko kotijoukkue tai vierasjoukkue).

SELECT o.ottelu_id,
o.ottelupaiva AS pelipaiva,
kotijoukkue.nimi AS kotijoukkue,
vierasjoukkue.nimi AS vierasjoukkue
FROM ottelu o
JOIN joukkue kotijoukkue ON o.kotijoukkue_id = kotijoukkue.joukkue_id
JOIN joukkue vierasjoukkue ON o.vierasjoukkue_id = vierasjoukkue.joukkue_id
JOIN joukkue j ON kotijoukkue.joukkue_id = j.joukkue_id OR vierasjoukkue.joukkue_id = j.joukkue_id
WHERE j.kotipaikka = 'Tampere';
