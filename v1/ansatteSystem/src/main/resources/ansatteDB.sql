CREATE TABLE IF NOT EXISTS ANSATT (
                                      id INTEGER AUTO_INCREMENT PRIMARY KEY,
                                      fornavn VARCHAR(100) NOT NULL,
    etternavn VARCHAR(100) NOT NULL,
    stilling VARCHAR(100) NOT NULL,
    mndlonn INTEGER NOT NULL
    );
