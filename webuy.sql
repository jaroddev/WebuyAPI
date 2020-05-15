INSERT INTO `address` (`id`, `city`, `department`, `postal_code`) VALUES
(1, 'Tours', '37', '37000'),
(2, 'Orléans', '45', '45000'),
(3, 'Bourges', '18', '18000'),
(4, 'Blois', '41', '41000'),
(5, 'Châteauroux', '36', '36000'),
(6, 'Chartres', '28', '28000'),
(7, 'Joué-lès-Tours', '37', '37300'),
(8, 'Dreux', '28', '28100'),
(9, 'Vierzon', '18', '18100'),
(10, 'Olivet', '45', '45160'),
(11, 'Paris', '75', '75001'),
(12, 'Marseille', '13', '13001'),
(13, 'Lyon', '69M', '69001'),
(14, 'Toulouse', '31', '31000'),
(15, 'Nice', '06', '06000'),
(16, 'Nantes', '44', '44000'),
(17, 'Montpellier', '34', '34000'),
(18, 'Strasbourg', '67', '67000'),
(19, 'Bordeaux', '33', '33000'),
(20, 'Lille', '59', '59000');

INSERT INTO `product` (`id`, `name`, `stock`, `shop_id`) VALUES
(1, 'Iphone ', 40, 1),
(2, 'Coca cola', 2500, 1);

INSERT INTO `shop` (`id`, `image`, `name`, `address_id`) VALUES
(1, 'hahihahy', 'hihi', 1),
(2, 'nia nia niou kanda roka koulou', 'ouya ouya', 2);

