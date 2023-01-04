CREATE TABLE customer_credits (
  customer_id BIGINT NOT NULL,
   credits_id BIGINT NOT NULL
);

ALTER TABLE customer_credits ADD CONSTRAINT uc_customer_credits_credits UNIQUE (credits_id);
ALTER TABLE customer_credits ADD CONSTRAINT fk_cuscre_on_credit FOREIGN KEY (credits_id) REFERENCES credit (id);
ALTER TABLE customer_credits ADD CONSTRAINT fk_cuscre_on_customer FOREIGN KEY (customer_id) REFERENCES customer (id);