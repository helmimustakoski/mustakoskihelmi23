-- joukkue-taulu
CREATE TABLE joukkue (
    joukkue_id INT PRIMARY KEY,
    nimi VARCHAR(25),
    kotipaikka VARCHAR(25)
);

-- ottelu-taulu
CREATE TABLE ottelu (
    ottelu_id INT PRIMARY KEY,
    ottelupaiva DATE,
    kotijoukkue_id INT,
    vierasjoukkue_id INT,
    tulos_id INT,
    FOREIGN KEY (kotijoukkue_id) REFERENCES joukkue(joukkue_id),
    FOREIGN KEY (vierasjoukkue_id) REFERENCES joukkue(joukkue_id),
    FOREIGN KEY (tulos_id) REFERENCES tulos(tulos_id)
);

-- tulos-taulu
CREATE TABLE tulos (
    tulos_id INT PRIMARY KEY,
    kotijoukkueen_maalit INT,
    vierasjoukkueen_maalit INT,
    ratkaisutapa VARCHAR(25)
);
