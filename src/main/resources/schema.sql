CREATE Table advertiser(
    id int(11) NOT NULL AUTO_INCREMENT,
    ADVERTISER_NAME varchar(255) not null,
    PRIMARY_CONTACT_NAME varchar(255) not null,
    MAX_LIMIT int(11) NOT NULL,
    PRIMARY KEY (id)
);