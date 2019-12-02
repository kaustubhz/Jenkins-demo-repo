USE javadb;

DROP TABLE IF EXISTS voters;
DROP TABLE IF EXISTS candidates;
CREATE TABLE IF NOT EXISTS voters
(id INTEGER PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(30) UNIQUE ,
password VARCHAR(30),
status VARCHAR(3)
);

CREATE TABLE IF NOT EXISTS candidates
(id INTEGER PRIMARY KEY AUTO_INCREMENT
,name VARCHAR(30),
political_party VARCHAR(30),
votes INTEGER DEFAULT 0
);

INSERT INTO voters(email,password,status)
VALUES("shubendu@gmail.com","shu#123","N"),("michael@gmail.com","mic#123","N"),("venky@gmail.com","ven#123","N"),
("vinit@gmail.com","vin#123","N"),("kaustubh@gmail.com","kau#123","N");

INSERT INTO candidates
(name,political_party)
VALUES("Devendra Fadanvis","BJP"),("Uddhav Thackrey","Shivsena"),("Sharad Pawar","NCP"),("Balasaheb Thorat","INC");

SELECT *FROM voters WHERE email="shubendu@gmail.com" and password="shu#123";

UPDATE voters SET status='YES' WHERE id="2";
UPDATE candidates SET votes=votes+1 WHERE id=1;