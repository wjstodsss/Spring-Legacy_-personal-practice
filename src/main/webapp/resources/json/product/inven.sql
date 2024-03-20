use db_ecommerce;
drop table tbl_inventory;
show tables;

CREATE TABLE tbl_inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(255) NOT NULL,
    stockQuantity INT ,
    salesQuantity INT DEFAULT 0,
    orderedQuantity INT DEFAULT 0,
    remarks VARCHAR(255)
);

INSERT INTO tbl_inventory (productName, stockQuantity, salesQuantity, orderedQuantity, remarks)
VALUES ('청사과', 70, 30, 10, '신선한 사과');

INSERT INTO tbl_inventory (productName, stockQuantity, salesQuantity, orderedQuantity, remarks)
VALUES ('사과', 88, 12, 10, '신선한 사과');

select * from tbl_inventory;

commit; 