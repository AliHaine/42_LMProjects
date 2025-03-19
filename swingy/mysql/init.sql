GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE data;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    champ VARCHAR(100),
    level INT,
    experience INT,
    attack INT,
    defense INT,
    hitpoint INT
);