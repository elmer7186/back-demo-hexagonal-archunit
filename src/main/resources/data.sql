INSERT INTO category(id_category, name, description) VALUES (NEXTVAL('SQ_CATEGORY'), 'Tecnologia', 'Dispositivos inteligentes, electronicos y accesorios');

INSERT INTO product(id_product, name, description, id_category, price) VALUES (NEXTVAL('SQ_PRODUCT'), 'Televisor LG', 'televisor de 43 pulgadas FHD', 1, 1300000);