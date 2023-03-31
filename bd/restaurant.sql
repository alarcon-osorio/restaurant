-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-03-2023 a las 05:40:16
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

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
(1, 'Jeison', 'Alarcon', 'jalarcono@udistrital.edu.co', 'jalarcono@udistrital.edu.co', 'client', '$2a$10$Sh2nGMhmzBKy1PMZVk0/su0mPiP6CDSjvjn952M9/HxDkoYYhTqA2', 1);

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
(4, 10, 'Descuento cliente frecuente', 'Descuento cliente frecuente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `measure_unit`
--

CREATE TABLE `measure_unit` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(6, 1, 'Espagueti Italiano', 'Especial de Italia', '20000', 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', '0');

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_optional`
--

CREATE TABLE `menu_optional` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `option5` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_drinks`
--

CREATE TABLE `menu_personal_drinks` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_drinks`
--

INSERT INTO `menu_personal_drinks` (`id`, `name`) VALUES
(1, 'Gaseosa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_entries`
--

CREATE TABLE `menu_personal_entries` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_entries`
--

INSERT INTO `menu_personal_entries` (`id`, `name`) VALUES
(1, 'Papas Fritas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_options`
--

CREATE TABLE `menu_personal_options` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_options`
--

INSERT INTO `menu_personal_options` (`id`, `name`) VALUES
(1, 'Arroz Blanco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_principles`
--

CREATE TABLE `menu_personal_principles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_principles`
--

INSERT INTO `menu_personal_principles` (`id`, `name`) VALUES
(1, 'Lentejas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_proteins`
--

CREATE TABLE `menu_personal_proteins` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_proteins`
--

INSERT INTO `menu_personal_proteins` (`id`, `name`) VALUES
(1, 'Pollo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_salad`
--

CREATE TABLE `menu_personal_salad` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_salad`
--

INSERT INTO `menu_personal_salad` (`id`, `name`) VALUES
(1, 'Sin Ensalada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_personal_vegetables`
--

CREATE TABLE `menu_personal_vegetables` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu_personal_vegetables`
--

INSERT INTO `menu_personal_vegetables` (`id`, `name`) VALUES
(1, 'Sin Vegetales');

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
(5, 'Tipico');

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
(10, 'Efectivo', 'Pago en efectivo');

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
(22, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_order`
--

CREATE TABLE `service_order` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `number_order` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `observations` varchar(255) NOT NULL,
  `accompaniment` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `option5` varchar(255) DEFAULT NULL,
  `drinks_includes` varchar(255) DEFAULT NULL,
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

INSERT INTO `service_order` (`id`, `id_menu`, `id_menu_type`, `number_order`, `name`, `description`, `observations`, `accompaniment`, `option1`, `option2`, `option3`, `option4`, `option5`, `drinks_includes`, `table_number`, `image`, `ordered`, `prepare`, `prepared`, `served`, `close`, `cancel`, `price`, `cant`, `discount`, `payment_method`, `time`) VALUES
(21, 6, 1, NULL, 'Espagueti Italiano', 'Especial de Italia', 'Que tenga Mucha albondiga', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', 1, 1, 1, 1, 1, 0, '20000', 1, 10, 'Efectivo', '2023-03-17 22:17:55'),
(22, 6, 1, NULL, 'Espagueti Italiano', 'Especial de Italia', 'mucho queso', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', 1, 1, 1, 1, 1, 0, '20000', 1, 10, 'Efectivo', '2023-03-17 22:26:24'),
(23, 6, 1, NULL, 'Espagueti Italiano', 'Especial de Italia', 'Con mas queso', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', 1, 1, 1, 1, 1, 0, '20000', 1, 10, 'Efectivo', '2023-03-18 00:11:39'),
(24, 6, 1, NULL, 'Espagueti Italiano', 'Especial de Italia', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://d320djwtwnl5uo.cloudfront.net/recetas/cover/spagh_e8DiuI5qVF4d3xokhn0EQAtHJYXSU6.png', 0, 0, 0, 0, 0, 1, '20000', 1, 0, NULL, '2023-03-22 02:56:04');

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
(1, 'admin', 'admin', '$2a$12$EMwlzqzTcj1cX36MFV4RWOtugEnl/gJPXgbIDq1ppZ1/dIiyellSK', 'admin', 'true');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse`
--

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL,
  `number_product` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `measure_unit` varchar(255) DEFAULT NULL,
  `price_unit` varchar(255) DEFAULT NULL,
  `date_price_unit` timestamp NULL DEFAULT NULL,
  `sale_price` varchar(255) DEFAULT NULL,
  `date_sale_price` timestamp NULL DEFAULT NULL,
  `cant_disp` int(11) DEFAULT NULL,
  `cant_order` int(11) DEFAULT NULL,
  `cant_min_inv` int(11) DEFAULT NULL,
  `total_inventory` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse_type_product`
--

CREATE TABLE `warehouse_type_product` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Indices de la tabla `menu_personal_drinks`
--
ALTER TABLE `menu_personal_drinks`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_entries`
--
ALTER TABLE `menu_personal_entries`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_options`
--
ALTER TABLE `menu_personal_options`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_principles`
--
ALTER TABLE `menu_personal_principles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_proteins`
--
ALTER TABLE `menu_personal_proteins`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_salad`
--
ALTER TABLE `menu_personal_salad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `menu_personal_vegetables`
--
ALTER TABLE `menu_personal_vegetables`
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
  ADD PRIMARY KEY (`id_user`);

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
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `discount`
--
ALTER TABLE `discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `measure_unit`
--
ALTER TABLE `measure_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `menu_accompaniment`
--
ALTER TABLE `menu_accompaniment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `menu_includes`
--
ALTER TABLE `menu_includes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_optional`
--
ALTER TABLE `menu_optional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `menu_personal_drinks`
--
ALTER TABLE `menu_personal_drinks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_entries`
--
ALTER TABLE `menu_personal_entries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_options`
--
ALTER TABLE `menu_personal_options`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_principles`
--
ALTER TABLE `menu_personal_principles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_proteins`
--
ALTER TABLE `menu_personal_proteins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_salad`
--
ALTER TABLE `menu_personal_salad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_personal_vegetables`
--
ALTER TABLE `menu_personal_vegetables`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `restaurant_data`
--
ALTER TABLE `restaurant_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `restaurant_table`
--
ALTER TABLE `restaurant_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `service_order`
--
ALTER TABLE `service_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `warehouse_type_product`
--
ALTER TABLE `warehouse_type_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
