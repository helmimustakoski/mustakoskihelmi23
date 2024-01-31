-- kyselylause jossa selvitetään montako ottelua kärpät ovat voittaneet ja millä ratkaisu tavalla annetulla aikavälillä?

SELECT 'Kärpät' AS joukkue,
COUNT(*) AS voitot, t.ratkaisutapa
FROM ottelu o
JOIN tulos t ON o.tulos_id = t.tulos_id
JOIN joukkue AS kotijoukkue ON o.kotijoukkue_id = kotijoukkue.joukkue_id
JOIN joukkue AS vierasjoukkue ON o.vierasjoukkue_id = vierasjoukkue.joukkue_id
WHERE (kotijoukkue.nimi = 'Kärpät' OR vierasjoukkue.nimi = 'Kärpät')
AND o.ottelupaiva BETWEEN '2023-11-01' AND '2023-11-30'
GROUP BY t.ratkaisutapa;
