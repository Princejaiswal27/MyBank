CREATE TABLE Account (
  account_number bigint NOT NULL AUTO_INCREMENT,
  customer_id bigint NOT NULL,
  balance double ,
  PRIMARY KEY (`account_number`)
) 