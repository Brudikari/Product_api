DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          name VARCHAR(250) NOT NULL,
                          number VARCHAR(250) NOT NULL,
                          description VARCHAR(250) NOT NULL,
                          price FLOAT NOT NULL,
                          stock INT
);

INSERT INTO products (name, number, description, price, stock) VALUES
                                                                   ('Café Arabica Premium', 'CA101', 'Café arabica de haute qualité, torréfié artisanalement', 50.00, 120),
                                                                   ('Café Robusta Intense', 'CR202', 'Café robusta avec une saveur intense et une forte teneur en caféine', 40.50, 150),
                                                                   ('Café Espresso', 'CE303', 'Mélange spécialement conçu pour espresso, riche et crémeux', 60.75, 100),
                                                                   ('Café Décaféiné', 'CD404', 'Café décaféiné sans perdre le goût authentique du café', 55.20, 80),
                                                                   ('Café Moka', 'CM505', 'Café moka avec des notes de chocolat et une acidité équilibrée', 70.40, 90);
