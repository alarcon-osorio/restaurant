-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 20-01-2024 a las 03:40:53
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurant`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE `clients` (
  `id_client` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clients`
--

INSERT INTO `clients` (`id_client`, `name`, `lastname`, `username`, `email`, `role`, `password`, `enabled`) VALUES
(1, 'Jeison', 'Alarcon', 'jalarcono@udistrital.edu.co', 'jalarcono@udistrital.edu.co', 'client', '$2a$10$Sh2nGMhmzBKy1PMZVk0/su0mPiP6CDSjvjn952M9/HxDkoYYhTqA2', 1),
(4, 'Jeison', 'Alarcon Osorio', 'alarcon_osorio@hotmail.com', 'alarcon_osorio@hotmail.com', 'client', '$2a$10$GmQA0VAA3n7beREOLtz41./Hj3rJftFu7iHHAY5JVLdh8dG7bGwHK', 1),
(5, 'Andres', 'Melo', 'andres.melo.p@gmail.com', 'andres.melo.p@gmail.com', 'client', '$2a$10$FbQ0NRgqmYhwxHkacxzGSO0t8YZ56G.UN4FWu9BGdBzGZlZluWNWW', 1),
(9, 'Pepino', 'Perez', 'pepito_perez@fakemail.com', 'pepito_perez@fakemail.com', 'client', '$2a$10$leTyQNFysGB2Yp7ntsrB4.pywq9uaSRfy09/e.KwjlmF8ZsRsz6s2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `discount`
--

CREATE TABLE `discount` (
  `id` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `discount`
--

INSERT INTO `discount` (`id`, `value`, `type`, `description`) VALUES
(4, 10, 'Descuento cliente frecuente', 'Descuento cliente frecuente'),
(6, 25, 'Cliente Fiel', 'Cliente Fiel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `measure_unit`
--

CREATE TABLE `measure_unit` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `measure_unit`
--

INSERT INTO `measure_unit` (`id`, `type`, `description`) VALUES
(1, 'ML', 'Mililitros'),
(2, 'KG', 'Kilogramo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `ordered` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `id_menu_type`, `name`, `description`, `price`, `image`, `ordered`) VALUES
(1, 2, 'Espagueti Italiano', 'Especial de Italia', '20000', 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', '0'),
(2, 2, 'Plato de lentejas especiales', 'Plato de lentejas especiales', '15000', 'https://unareceta.com/wp-content/uploads/2016/10/lentejas.jpg', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_accompaniment`
--

CREATE TABLE `menu_accompaniment` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `accompaniment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_accompaniment`
--

INSERT INTO `menu_accompaniment` (`id`, `id_menu`, `id_menu_type`, `accompaniment`) VALUES
(1, 1, 2, 'Bebidas'),
(15, 2, 2, 'Papas fritas'),
(17, 2, 2, 'Licor'),
(18, 9, 2, 'Bebidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_includes`
--

CREATE TABLE `menu_includes` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_includes`
--

INSERT INTO `menu_includes` (`id`, `id_menu`, `id_menu_type`, `name`, `price`) VALUES
(2, 1, 2, 'Ensalada', '2500'),
(3, 1, 2, 'Ajonjolih', '2500'),
(6, 9, 2, 'Sprint 13', '100');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_optional`
--

CREATE TABLE `menu_optional` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `option1` varchar(255) NOT NULL COMMENT 'Caldo',
  `option2` varchar(255) NOT NULL COMMENT 'Huevos',
  `option3` varchar(255) NOT NULL COMMENT 'Bebida',
  `option4` varchar(255) NOT NULL COMMENT 'Complemento',
  `option5` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_optional`
--

INSERT INTO `menu_optional` (`id`, `id_menu`, `id_menu_type`, `option1`, `option2`, `option3`, `option4`, `option5`) VALUES
(6, 1, 2, 'Pajarilla', 'Revueltos', 'Chocolate', 'Arepa', '-'),
(7, 1, 2, 'Costilla', 'Cocido', '-', '-', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_options`
--

CREATE TABLE `menu_options` (
  `id` int(11) NOT NULL,
  `options` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_form`
--

CREATE TABLE `menu_personal_form` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_form`
--

INSERT INTO `menu_personal_form` (`id`, `name`, `type`) VALUES
(1, 'Arroz Blanco', 1),
(2, 'Lentejas', 2),
(3, 'Pollo', 3),
(4, 'Papas en Casco', 4),
(5, 'Sin vegetales', 5),
(6, 'Sin ensalada', 6),
(7, 'Gaseosa', 7),
(9, 'Arroz con ajonjoli', 1),
(10, 'Limonada', 7),
(12, 'Frijol', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_type`
--

CREATE TABLE `menu_personal_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT 'options = cereal'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_type`
--

INSERT INTO `menu_personal_type` (`id`, `name`) VALUES
(1, 'options'),
(2, 'principles'),
(3, 'proteins'),
(4, 'entries'),
(5, 'vegetables'),
(6, 'salad'),
(7, 'drinks');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_view`
--

CREATE TABLE `menu_personal_view` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name_dish` varchar(255) NOT NULL,
  `options` int(11) NOT NULL,
  `principles` int(11) NOT NULL,
  `proteins` int(11) NOT NULL,
  `entries` int(11) NOT NULL,
  `vegetables` int(11) NOT NULL,
  `salad` int(11) NOT NULL,
  `drinks` int(11) NOT NULL,
  `observations` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_view`
--

INSERT INTO `menu_personal_view` (`id`, `username`, `id_menu_type`, `name_dish`, `options`, `principles`, `proteins`, `entries`, `vegetables`, `salad`, `drinks`, `observations`, `time`) VALUES
(3, 'alarcon_osorio@hotmail.com', 1, '', 1, 2, 3, 4, 5, 6, 7, 'pedido en alarcon_osorio', '2023-05-08 18:33:58'),
(7, 'alarcon_osorio@hotmail.com', 1, 'Plato Personalizado', 1, 2, 3, 4, 5, 6, 7, '', '2023-05-08 18:33:58'),
(14, 'jalarcono@udistrital.edu.co', 1, 'Plato Personalizado', 1, 2, 3, 4, 5, 6, 7, 'Pedido en Fila', '2023-05-08 18:37:04'),
(15, 'jalarcono@udistrital.edu.co', 1, 'Plato Personalizado', 1, 2, 3, 4, 5, 6, 7, 'Bien rico', '2023-05-08 18:37:28'),
(17, 'pepito_perez@fakemail.com', 1, 'Plato Personalizado', 9, 2, 3, 4, 5, 6, 7, 'Bajo de sal el arroz y las lentejas', '2023-05-22 02:17:16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_price`
--

CREATE TABLE `menu_price` (
  `id` int(11) NOT NULL,
  `value` varchar(255) NOT NULL,
  `menu_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_price`
--

INSERT INTO `menu_price` (`id`, `value`, `menu_type`) VALUES
(1, '25000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_type`
--

CREATE TABLE `menu_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_type`
--

INSERT INTO `menu_type` (`id`, `name`) VALUES
(1, 'Personalizado'),
(2, 'Restaurante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modules`
--

CREATE TABLE `modules` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `uri` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modules`
--

INSERT INTO `modules` (`id`, `name`, `description`, `image`, `uri`) VALUES
(2, 'Servicio', 'Modulo de Servicio', 'https://www.repagas.com/wp-content/uploads/2017/06/restaurantes_madrid-e1506434717978.png', 'http://localhost:8081/menu'),
(3, 'Cocina', 'Modulo de Cocina', 'https://static.vecteezy.com/system/resources/previews/002/687/253/non_2x/cartoon-restaurant-chefs-preparing-meal-and-desserts-vector.jpg', 'http://localhost:8082/kitchen'),
(4, 'Caja', 'Modulo de Caja', 'https://img.freepik.com/vector-premium/vendedor-caja-registradora-restaurante-comida-rapida-personaje-femenino-delantal-lugar-trabajo-cafeteria-linda-mujer-trabaja-catering-diferentes-tipos-cafe-comida-marcador-ilustracion-vectorial_609547-158.jpg?w=360', 'http://localhost:8083/cash'),
(5, 'Inventario', 'Modulo de Inventario', 'https://icm.aexp-static.com/content/dam/contenthub/mx/es/images/2022/02/Inf_FT_4metodosInvent_Preview.jpg', 'http://localhost:8085/warehouse');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `method` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `payment_method`
--

INSERT INTO `payment_method` (`id`, `method`, `description`) VALUES
(1, 'Efectivo', 'Pago en efectivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant_data`
--

CREATE TABLE `restaurant_data` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant_table`
--

CREATE TABLE `restaurant_table` (
  `id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `restaurant_table`
--

INSERT INTO `restaurant_table` (`id`, `table_number`) VALUES
(1, 1),
(23, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_order`
--

CREATE TABLE `service_order` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) DEFAULT NULL,
  `id_menu_type` int(11) NOT NULL,
  `number_order` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `observations` varchar(255) NOT NULL,
  `accompaniment` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `option5` varchar(255) DEFAULT NULL,
  `drinks_includes` varchar(255) DEFAULT NULL,
  `options` varchar(255) DEFAULT NULL,
  `principles` varchar(255) DEFAULT NULL,
  `proteins` varchar(255) DEFAULT NULL,
  `entries` varchar(255) DEFAULT NULL,
  `vegetables` varchar(255) DEFAULT NULL,
  `salad` varchar(255) DEFAULT NULL,
  `drinks` varchar(255) DEFAULT NULL,
  `table_number` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `ordered` int(11) DEFAULT NULL,
  `prepare` int(11) DEFAULT NULL,
  `prepared` int(11) DEFAULT NULL,
  `served` int(11) DEFAULT NULL,
  `close` int(11) DEFAULT NULL,
  `cancel` int(11) DEFAULT NULL,
  `price` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `service_order`
--

INSERT INTO `service_order` (`id`, `id_menu`, `id_menu_type`, `number_order`, `name`, `username`, `description`, `observations`, `accompaniment`, `option1`, `option2`, `option3`, `option4`, `option5`, `drinks_includes`, `options`, `principles`, `proteins`, `entries`, `vegetables`, `salad`, `drinks`, `table_number`, `image`, `ordered`, `prepare`, `prepared`, `served`, `close`, `cancel`, `price`, `cant`, `discount`, `payment_method`, `time`) VALUES
(61, 0, 1, NULL, 'Plato Personalizado', 'pepito_perez@fakemail.com', 'Plato personalizado', 'Bajo de sal el arroz y las lentejas... Gracias', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Arroz con ajonjoli', 'Lentejas', 'Pollo', 'Papas en Casco', 'Sin vegetales', 'Sin ensalada', 'Gaseosa', 1, '../images/personalized.png', 1, 1, 1, 1, 1, 0, '25000', 1, 25, 'Efectivo', '2023-05-22 02:30:22'),
(62, 1, 1, NULL, 'Plato Personalizado', NULL, 'Plato personalizado', 'Bajo de sal el arroz y las lentejas ... Mesero', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Arroz con ajonjoli', 'Lentejas', 'Pollo', 'Papas en Casco', 'Sin vegetales', 'Sin ensalada', 'Gaseosa', 2, '../images/personalized.png', 1, 0, 0, 0, 0, 0, '25000', 1, 0, NULL, '2023-05-22 03:15:20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `enabled` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `name`, `username`, `password`, `role`, `enabled`) VALUES
(1, 'admin', 'admin', '$2a$10$HY2QyA8BFka0DIQOqbaXtOuKcIA3CkoYmonOzLjM8iemV37XIofE.', 'admin', '1'),
(3, 'Usuario Cocina', 'cocina', '$2a$10$YH3FvIKUHU92rxK3F5nzIeHcPFOADboJwSMfpev58C.FLm9gkJ7R2', 'admin', '1'),
(5, 'servicio', 'servicio', '$2a$10$QkaVjCCgS2lGE7gnr4yum.vpwdc3wzLZA.3sMa1FrfuvyDT7MJAiy', 'admin', '1'),
(6, 'caja', 'caja', '$2a$10$ggmb4i86L3JHhCg2TURgou1b03pk7FqfcnhGmyZXACeGnXaEFB3Ua', 'admin', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse`
--

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL,
  `number_product` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `measure_unit` varchar(255) DEFAULT NULL,
  `price_unit` varchar(255) DEFAULT NULL,
  `date_price_unit` timestamp NULL DEFAULT NULL,
  `date_sale_price` timestamp NULL DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `sale_price` varchar(255) DEFAULT NULL,
  `cant_disp` int(11) DEFAULT NULL,
  `cant_order` int(11) DEFAULT NULL,
  `cant_min_inv` int(11) DEFAULT NULL,
  `total_inventory` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `warehouse`
--

INSERT INTO `warehouse` (`id`, `number_product`, `name`, `type`, `description`, `status`, `measure_unit`, `price_unit`, `date_price_unit`, `date_sale_price`, `date`, `sale_price`, `cant_disp`, `cant_order`, `cant_min_inv`, `total_inventory`) VALUES
(2, '123', 'Gaseosas 350ML', 'Gaseosas', 'Gaseosas', 'Activo', 'ML', '1500', NULL, NULL, 'Sun May 21 22:02:25 COT 2023', '2500', 100, 100, 1, NULL),
(4, 'GR124', 'Arroz', 'Granos', NULL, 'Activo', 'KG', '30000', NULL, NULL, 'Sun May 21 22:01:35 COT 2023', '20000', 10, 10, 1, NULL),
(6, 'GR125', 'Lentejas', 'Granos', NULL, 'Activo', 'KG', '15000', NULL, NULL, 'Sun May 21 22:06:03 COT 2023', '10000', 10, 14, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse_type_product`
--

CREATE TABLE `warehouse_type_product` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `warehouse_type_product`
--

INSERT INTO `warehouse_type_product` (`id`, `type`) VALUES
(1, 'Gaseosas'),
(5, 'Granos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indices de la tabla `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `measure_unit`
--
ALTER TABLE `measure_unit`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_accompaniment`
--
ALTER TABLE `menu_accompaniment`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_includes`
--
ALTER TABLE `menu_includes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_optional`
--
ALTER TABLE `menu_optional`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_options`
--
ALTER TABLE `menu_options`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_form`
--
ALTER TABLE `menu_personal_form`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_type`
--
ALTER TABLE `menu_personal_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_view`
--
ALTER TABLE `menu_personal_view`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_price`
--
ALTER TABLE `menu_price`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `restaurant_data`
--
ALTER TABLE `restaurant_data`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `restaurant_table`
--
ALTER TABLE `restaurant_table`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `service_order`
--
ALTER TABLE `service_order`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indices de la tabla `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `warehouse_type_product`
--
ALTER TABLE `warehouse_type_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `discount`
--
ALTER TABLE `discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `measure_unit`
--
ALTER TABLE `measure_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `menu_accompaniment`
--
ALTER TABLE `menu_accompaniment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `menu_includes`
--
ALTER TABLE `menu_includes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `menu_optional`
--
ALTER TABLE `menu_optional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `menu_options`
--
ALTER TABLE `menu_options`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menu_personal_form`
--
ALTER TABLE `menu_personal_form`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `menu_personal_type`
--
ALTER TABLE `menu_personal_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `menu_personal_view`
--
ALTER TABLE `menu_personal_view`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `menu_price`
--
ALTER TABLE `menu_price`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `restaurant_data`
--
ALTER TABLE `restaurant_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `restaurant_table`
--
ALTER TABLE `restaurant_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `service_order`
--
ALTER TABLE `service_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `warehouse_type_product`
--
ALTER TABLE `warehouse_type_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
