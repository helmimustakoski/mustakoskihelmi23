--Mikä on Ilveksen yhteenlaskettu maalimäärä pelatuissa otteluissa?

SELECT 'Ilves' AS joukkue,
SUM(COALESCE(t.kotijoukkueen_maalit, 0) + COALESCE(t.vierasjoukkueen_maalit, 0)) AS yhteenlaskettu_maalimaarä
FROM ottelu o
JOIN tulos t ON o.tulos_id = t.tulos_id
JOIN joukkue kotijoukkue ON o.kotijoukkue_id = kotijoukkue.joukkue_id
JOIN joukkue vierasjoukkue ON o.vierasjoukkue_id = vierasjoukkue.joukkue_id
WHERE kotijoukkue.nimi = 'Ilves' OR vierasjoukkue.nimi = 'Ilves';
