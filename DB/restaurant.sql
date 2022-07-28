-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-07-2022 a las 06:05:02
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.29

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
-- Estructura de tabla para la tabla `discount`
--

CREATE TABLE `discount` (
  `id` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `price` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `ordered` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `id_menu_type`, `name`, `description`, `price`, `image`, `ordered`) VALUES
(1, 1, 'Pollo Q\'leko al Carbon', 'Pollo Q\'leko al carbon con dos acompañamientos', '35000', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pollo-barbacoa-1-1594813233.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*', ''),
(2, 1, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón con un compañamiento', '20000', 'https://t2.rg.ltmcdn.com/es/posts/6/9/0/pollo_marinado_al_carbon_43096_orig.jpg', ''),
(3, 1, 'Churrasco', 'Churrasco con dos acompañamientos', '20000', 'https://www.elespectador.com/resizer/D40nB1QQOdrNOZ_s8SKVXpoeDRM=/920x613/filters:format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/PBOUWEWMORD7ZOXXSJSJDUIBDQ.jpg', ''),
(4, 1, 'Arroz con Pollo', 'Arroz con Pollo con un acompañamiento', '13000', 'https://images.aws.nestle.recipes/original/8f592ab965966eef0763c05328927a0d_arroz-con-pollo-frito.jpg', ''),
(5, 1, 'Almuerzo del dia', 'Presa de Pollo, Arroz y Papa, Sopa y Limonada', '13000', 'https://www.laylita.com/recetas/wp-content/uploads/2012/10/Fritada-ecuatoriana-de-pollo-o-gallina-1024x683.jpg', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_accompaniment`
--

CREATE TABLE `menu_accompaniment` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `accompaniment` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_accompaniment`
--

INSERT INTO `menu_accompaniment` (`id`, `id_menu`, `id_menu_type`, `accompaniment`) VALUES
(1, 1, 1, 'Yuca Frita - Papa Francesa'),
(2, 1, 1, 'Yuca Frita - Papa Criolla'),
(3, 1, 1, 'Papa Francesa - Papa Criolla'),
(4, 2, 1, 'Yuca Frita'),
(5, 2, 1, 'Papa Francesa'),
(6, 2, 1, 'Papa Criolla'),
(7, 3, 1, 'Yuca Frita - Papa Francesa'),
(8, 3, 1, 'Yuca Frita - Papa Criolla'),
(9, 3, 1, 'Papa Francesa - Papa Criolla'),
(10, 4, 1, 'Yuca Frita'),
(11, 4, 1, 'Papa Francesa'),
(12, 4, 1, 'Papa Criolla');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_includes`
--

CREATE TABLE `menu_includes` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `price` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_includes`
--

INSERT INTO `menu_includes` (`id`, `id_menu`, `id_menu_type`, `name`, `price`) VALUES
(1, 4, 1, 'Limonada', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_optional`
--

CREATE TABLE `menu_optional` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `option1` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `option2` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `option3` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `option4` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `option5` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_optional`
--

INSERT INTO `menu_optional` (`id`, `id_menu`, `id_menu_type`, `option1`, `option2`, `option3`, `option4`, `option5`) VALUES
(1, 0, 1, 'Caldo de Pescado', 'Huevos Revueltos', 'Chocolate', 'Arepa', '-'),
(2, 0, 1, 'Caldo de Costilla', 'Huevo Fritos', 'Perico', 'Pan', '-'),
(3, 0, 1, 'Caldo de Pata', 'Huevos Pericos', 'Agua de Panela', '-', '-'),
(4, 0, 1, 'Caldo de Pajarilla', '-', 'Tinto', '-', '-'),
(5, 0, 1, '-', '-', '-', '-', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_type`
--

CREATE TABLE `menu_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `menu_type`
--

INSERT INTO `menu_type` (`id`, `name`) VALUES
(1, 'Menú Q\'LEKO'),
(2, 'Porciones'),
(3, 'Sopa del dia'),
(4, 'Bebidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `method` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `payment_method`
--

INSERT INTO `payment_method` (`id`, `method`, `description`) VALUES
(1, 'EFECTIVO', 'Bancolombia Pagos'),
(2, 'NEQUI', 'Nequi Pagos'),
(3, 'DAVIPLATA', 'Davivienda'),
(4, 'BANCOLOMBIA', 'BANCOLOMBIA'),
(5, 'TARJETA DEBITO', 'TD'),
(6, 'TARJETA CREDITO', 'TC');

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
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 100);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `service_order`
--

INSERT INTO `service_order` (`id`, `id_menu`, `id_menu_type`, `number_order`, `name`, `description`, `observations`, `accompaniment`, `option1`, `option2`, `option3`, `option4`, `option5`, `drinks_includes`, `table_number`, `image`, `ordered`, `prepare`, `prepared`, `served`, `close`, `cancel`, `price`, `cant`, `discount`, `payment_method`, `time`) VALUES
(21, 2, 1, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón con un compañamiento', 'Sin Observaciones', 'Papa Francesa', NULL, NULL, NULL, NULL, NULL, NULL, 2, 'https://t2.rg.ltmcdn.com/es/posts/6/9/0/pollo_marinado_al_carbon_43096_orig.jpg', 1, 1, 1, 1, 1, 0, '20000', 1, 50, 'EFECTIVO', '2022-07-28 03:56:22'),
(22, 2, 1, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón con un compañamiento', 'Sin Observaciones', 'Yuca Frita', NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://t2.rg.ltmcdn.com/es/posts/6/9/0/pollo_marinado_al_carbon_43096_orig.jpg', 1, 1, 1, 1, 1, 0, '20000', 1, 50, 'NEQUI', '2022-07-28 03:56:26'),
(23, 2, 1, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón con un compañamiento', 'Sin Observaciones', 'Papa Francesa', NULL, NULL, NULL, NULL, NULL, NULL, 4, 'https://t2.rg.ltmcdn.com/es/posts/6/9/0/pollo_marinado_al_carbon_43096_orig.jpg', 1, 1, 1, 1, 1, 0, '20000', 1, 50, 'BANCOLOMBIA', '2022-07-28 03:56:30'),
(24, 1, 1, NULL, 'Pollo Q\'leko al Carbon', 'Pollo Q\'leko al carbon con dos acompañamientos', 'Sin Observaciones', 'Yuca Frita - Papa Francesa', NULL, NULL, NULL, NULL, NULL, NULL, 4, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pollo-barbacoa-1-1594813233.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*', 1, 1, 1, 1, 1, 0, '35000', 1, 0, 'NEQUI', '2022-07-27 03:23:26');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `discount`
--
ALTER TABLE `discount`
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
-- Indices de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `payment_method`
--
ALTER TABLE `payment_method`
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
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `discount`
--
ALTER TABLE `discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
-- AUTO_INCREMENT de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `restaurant_table`
--
ALTER TABLE `restaurant_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `service_order`
--
ALTER TABLE `service_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
