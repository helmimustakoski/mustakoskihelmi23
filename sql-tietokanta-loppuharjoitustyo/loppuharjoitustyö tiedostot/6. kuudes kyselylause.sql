--montako ottelua on  on ratkaistu jatkoajalla, varsinaisella peliajalla tai voittolaukauksella? erittely montako mitakin

SELECT t.ratkaisutapa,
COUNT(*) AS pelatut_ottelut
FROM ottelu o
JOIN tulos t ON o.tulos_id = t.tulos_id
WHERE t.ratkaisutapa IN ('varsinaisella peliajalla', 'jatkoajalla', 'voittolaukauskilpailulla')
GROUP BY t.ratkaisutapa;
