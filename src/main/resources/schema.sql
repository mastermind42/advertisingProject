CREATE TABLE IF NOT EXISTS Advertiser
{
    id long auto_increment primary key not null,
    advertiserName varchar(255) not null,
    primaryContactName varchar(255) not null,
}