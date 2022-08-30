drop table if exists Dog;


drop table if exists Owner;


CREATE TABLE Dog(
    Dog_Id INTEGER AUTO_INCREMENT,
    Nickname NVARCHAR(120),
    CONSTRAINT PK_Dog PRIMARY KEY  (Dog_Id)
    );

CREATE TABLE Owner(
                         Owner_id INTEGER AUTO_INCREMENT,
                         Owner_name NVARCHAR(40)  NOT NULL,
                         phone NVARCHAR(24),
                         city NVARCHAR(40),
                         CONSTRAINT pk_Owner PRIMARY KEY  (Owner_id)
);

