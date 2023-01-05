CREATE TABLE credit (
  id BIGINT AUTO_INCREMENT NOT NULL,
   credit_code UUID NOT NULL,
   credit_value DECIMAL NOT NULL,
   day_first_installment date NOT NULL,
   number_of_installments INT NOT NULL,
   status INT,
   customer_id BIGINT,
   CONSTRAINT pk_credit PRIMARY KEY (id)
);

ALTER TABLE credit ADD CONSTRAINT FK_CREDIT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);