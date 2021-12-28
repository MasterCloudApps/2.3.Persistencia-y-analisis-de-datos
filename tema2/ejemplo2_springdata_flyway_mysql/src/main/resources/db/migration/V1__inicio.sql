CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB;

-- Tabla de productos
CREATE TABLE `producto` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `datos` JSON NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Diferentes opciones para insertar datos: string o función JSON
INSERT INTO `producto`(`datos`) VALUES ('{\"nombre\": \"Macbook\", \"marca\": \"Apple\", \"etiquetas\":[\"Portátil\",\"Mac\"]}');
INSERT INTO `producto`(`datos`) VALUES (JSON_OBJECT('nombre','Macbook Air','marca','Apple','etiquetas',JSON_ARRAY('Portátil','Mac','Ligero')));
INSERT INTO `producto`(`datos`) VALUES ('{\"nombre\": \"P30 Lite 4\", \"marca\": \"Huawei\", \"etiquetas\":[\"Móvil\"]}');
INSERT INTO `producto`(`datos`) VALUES ('{\"nombre\": \"iPhone 11 Pro\", \"marca\": \"Apple\", \"etiquetas\":[\"Móvil\"]}');
INSERT INTO `producto`(`datos`) VALUES (JSON_OBJECT('nombre','Teclado 105','marca','Logitech'));
