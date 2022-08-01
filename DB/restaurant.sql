-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-08-2022 a las 03:36:39
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

--
-- Volcado de datos para la tabla `discount`
--

INSERT INTO `discount` (`id`, `value`, `type`, `description`) VALUES
(1, 10, 'BONO 10%', 'BONO FAMILIA & AMIGOS'),
(2, 20, 'BONO 20%', 'BONO FAMILIA & AMIGOS'),
(3, 30, 'BONO 30%', 'BONO FAMILIA & AMIGOS'),
(4, 40, 'BONO 40%', 'BONO FAMILIA & AMIGOS'),
(5, 50, 'BONO 50%', 'BONO FAMILIA & AMIGOS'),
(6, 60, 'BONO 60%', 'BONO FAMILIA & AMIGOS'),
(7, 70, 'BONO 70%', 'BONO FAMILIA & AMIGOS'),
(8, 80, 'BONO 80%', 'BONO FAMILIA & AMIGOS'),
(9, 90, 'BONO 90%', 'BONO FAMILIA & AMIGOS'),
(10, 100, 'BONO 100%', 'BONO FAMLIA & AMIGOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `measure_unit`
--

CREATE TABLE `measure_unit` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `measure_unit`
--

INSERT INTO `measure_unit` (`id`, `type`, `description`) VALUES
(1, 'Gr', 'Gramo'),
(2, 'KG', 'Kilogramo'),
(3, 'mL', 'Mili Litro'),
(4, 'LT', 'Litro'),
(5, 'Cm3', 'Cm3'),
(6, 'Und', 'Unidades');

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
(2, 1, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón con un compañamiento', '20000', 'https://cdn.shopify.com/s/files/1/0479/8467/2933/products/P-46_6bf0587d-f4f4-488f-b0a8-a08d2ed957a9.jpg?v=1601179289', ''),
(3, 1, 'Churrasco', 'Churrasco con dos acompañamientos', '20000', 'https://www.elespectador.com/resizer/D40nB1QQOdrNOZ_s8SKVXpoeDRM=/920x613/filters:format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/PBOUWEWMORD7ZOXXSJSJDUIBDQ.jpg', ''),
(4, 1, 'Arroz con Pollo', 'Arroz con Pollo con un acompañamiento', '13000', 'https://images.aws.nestle.recipes/original/8f592ab965966eef0763c05328927a0d_arroz-con-pollo-frito.jpg', ''),
(5, 1, 'Almuerzo del dia', 'Presa de Pollo, Arroz y Papa, Sopa y Limonada', '13000', 'https://www.laylita.com/recetas/wp-content/uploads/2012/10/Fritada-ecuatoriana-de-pollo-o-gallina-1024x683.jpg', ''),
(7, 2, 'Papa a la Francesa', 'Papa Francesa', '5000', 'https://www.cocinacaserayfacil.net/wp-content/uploads/2014/12/patatas-fritas-crujientes.jpg', ''),
(8, 2, 'Papa Criolla', 'Papa Criolla', '5000', 'https://www.laconstanciacolombina.com/wp-content/uploads/2019/10/495.jpg', ''),
(9, 2, 'Yuca Frita', 'Yuca Frita', '5000', 'https://www.cocinacaserayfacil.net/wp-content/uploads/2019/01/Yuca-frita-receta.jpg', ''),
(10, 2, 'Platano con Queso y Bocadillo', 'Platano con Queso y Bocadillo', '7000', 'https://tucocina.b-cdn.net/wp-content/uploads/2021/03/Platanos-con-bocadillo-y-queso.jpg', ''),
(11, 2, 'Platano Calao', 'Platano Calao', '4000', 'https://www.mycolombianrecipes.com/wp-content/uploads/2009/06/platanos-calados-085.jpg', ''),
(12, 2, 'Arroz Blanco', 'Arroz Blanco', '3000', 'https://www.hogarmania.com/archivos/202204/como-hacer-arroz-blanco-xl-1280x720x80xX.jpg', ''),
(13, 3, 'Sopa Grande', 'Sopa Grande', '7000', 'https://media-cdn.tripadvisor.com/media/photo-s/1b/35/d7/fa/sopa-patacon-grande.jpg', ''),
(14, 3, 'Sopa Pequeña', 'Sopa Pequeña', '4000', 'https://previews.123rf.com/images/ziashusha/ziashusha1501/ziashusha150100050/35097117-sopa-con-peque%C3%B1as-pastas-verduras-y-trozos-de-carne-en-un-taz%C3%B3n-de-cer%C3%A1mica-sobre-una-superficie-de-.jpg', ''),
(15, 5, 'Cerveza Poker', 'Cerveza Poker', '3000', 'https://www.semana.com/resizer/e8cWWJlUleQYmormg5ptZDFgDR4=/1200x675/filters:format(jpg):quality(50)//cloudfront-us-east-1.images.arcpublishing.com/semana/AVDGTTBQVNH2FFKC5NGDJZJCWY.jpg', ''),
(16, 5, 'Cerveza Aguila', 'Cerveza Aguila', '3000', 'https://mir-s3-cdn-cf.behance.net/project_modules/fs/f59a2c76043789.5df7f96fa627a.jpg', ''),
(17, 5, 'Cerveza Cub Colombia', 'Cerveza Club Colombia', '3500', 'https://www.comedordelosmilagros.com/wp-content/uploads/2021/09/cervezaclubcolombia2.jpg', ''),
(18, 5, 'Cola y Pola', 'Cola y Pola', '3000', 'https://distriplaza.co/wp-content/uploads/2020/07/IMAGEN-6.jpg', ''),
(19, 5, 'Gaseosa 1.5 LT', 'Gaseosa 1.5 LT', '6000', 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', ''),
(20, 5, 'Coca Cola 400mL', 'Coca Cola 400mL', '2800', 'https://piragua.com.co/wp-content/uploads/2020/08/coca-cola-400-x12-piragua.jpg', ''),
(21, 5, 'Coca Cola 350mL', 'Coca Cola 350mL', '2500', 'https://elranchodejonas.com/tienda/wp-content/uploads/sites/2/2020/08/COCACOLA.jpg', ''),
(22, 5, 'Coca cola 250mL', 'Coca Cola 250mL', '2000', 'https://piragua.com.co/wp-content/uploads/2019/11/cocacola-original-250-x12-piragua.jpg', ''),
(23, 5, 'Gaseosa Postobon 350mL', 'Gaseosa Postobon 350mL', '2500', 'https://static.wixstatic.com/media/368840_4ff11ac3f2124ff8b44cd80b1c9ede7a.jpg/v1/fill/w_498,h_373,al_c,lg_1,q_85/368840_4ff11ac3f2124ff8b44cd80b1c9ede7a.jpg', ''),
(24, 5, 'Botella de Agua', 'Botella de Agua', '2500', 'https://es.factsaboutbpa.org/wp-content/uploads/2018/08/water-bottles.png', ''),
(25, 5, 'Botella de Agua Saborizada', 'Botella de Agua Saborizada', '2500', 'https://sumicorp.com/wp-content/uploads/2019/05/AGUA-EN-BOTELLA-H2O-SABORIZADA-LIMON-X-600-ML-PACA-X-15-UNIDADES.jpg', ''),
(26, 5, 'Jarra de Limionada', 'Jarra de Limonada', '10000', 'https://sanchopaisa.com/wp-content/uploads/2020/10/Jarra-limonada-scaled.jpg', ''),
(27, 4, 'Parrilla para dos', 'Parrilla para dos', '45000', 'https://media-cdn.tripadvisor.com/media/photo-s/0c/9a/73/4f/la-porcion.jpg', ''),
(28, 5, 'Jugo Natural', 'Jugo Natural', '7000', 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', '');

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
(4, 'Parrilla'),
(5, 'Bebidas');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `modules`
--

INSERT INTO `modules` (`id`, `name`, `description`, `image`, `uri`) VALUES
(1, 'Modulo de Meseros', 'Modulo de meseros restaurante', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQawzmx0m43sjEuXP_ljQ41dWWpkHKrNCAdfA&usqp=CAU', '192.168.0.254:8080/service');

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
(1, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, '20000', 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(2, 48, 5, NULL, 'Gaseosa 1.5L', 'Gaseosa 1.5L', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(3, 51, 5, NULL, 'Jugo Natural 500mL', 'Jugo Natural 500mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(4, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Bajito de sal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 1, 1, 1, 1, 0, '7000', 2, 0, 'EFECTIVO', '2022-07-23 19:34:23'),
(5, 44, 5, NULL, 'Cerveza Club Colombia', 'Cerveza Club Colombia', 'Bien fria', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'http://bucaramanga.gruposotillo.com/wp-content/uploads/2014/08/Cerveza_Club_Colombia.jpg', 1, 1, 1, 1, 1, 0, '3000', 3, 0, 'EFECTIVO', '2022-07-23 19:34:23'),
(6, 2, 1, NULL, 'Taza de aguapanela con queso', 'Una deliciosa Taza de aguapanela caliente con queso ', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://unsplash.com/photos/oBoELXgJR1w/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dCVDMyVBOXxlc3wwfHx8fDE2NTY2OTQxMjM&force=true&w=640', 0, 0, 0, 0, 0, 1, '4000', 2, 0, NULL, '2022-07-23 19:38:15'),
(7, 59, 1, NULL, 'Almuerzo Completo', 'Almuerzo completo viene con sopa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://old.bodytechperu.com/uploads/post/fc1ec1d12917418aa1c9caa645f82a07/7-almuerzos-para-una-semana-saludable_1200x640.jpg', 1, 1, 1, 1, 1, 0, '13000', 2, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(8, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Con mazorca', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 0, 0, 0, 0, 1, '7000', 1, 0, NULL, '2022-07-23 19:47:44'),
(9, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 1, 1, 1, 1, 0, '7000', 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(10, 59, 6, NULL, 'Almuerzo Completo', 'Almuerzo completo viene con sopa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'https://old.bodytechperu.com/uploads/post/fc1ec1d12917418aa1c9caa645f82a07/7-almuerzos-para-una-semana-saludable_1200x640.jpg', 1, 1, 1, 1, 1, 0, '13000', 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(11, 51, 5, NULL, 'Jugo Natural 500mL', 'Jugo Natural 500mL', 'Lulo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(12, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 1, 1, 1, 1, 0, '35000', 1, 0, 'EFECTIVO', '2022-07-23 20:21:50'),
(13, 48, 5, NULL, 'Gaseosa 1.5L', 'Gaseosa 1.5L', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-23 20:30:36'),
(14, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Con papá y yuca', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, '20000', 1, 0, 'EFECTIVO', '2022-07-23 21:44:45'),
(15, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Con papá a la francesa y yuca ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 0, 0, 0, 0, 1, '20000', 1, 0, NULL, '2022-07-23 21:51:31'),
(16, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 0, 0, 0, 0, 1, '20000', 1, 0, NULL, '2022-07-24 22:02:42'),
(17, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, '20000', 1, 0, 'EFECTIVO', '2022-07-23 21:55:02'),
(18, 46, 5, NULL, 'Cerveza Coronita', 'Cerveza Coronita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.seekpng.com/png/detail/16-169043_corona-light.png', 1, 1, 1, 1, 1, 0, '3500', 1, 0, 'EFECTIVO', '2022-07-23 21:59:39'),
(19, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 0, 0, 0, 0, 1, '35000', 1, 0, NULL, '2022-07-24 20:26:08'),
(20, 35, 3, NULL, 'Papa a la francesa', 'Papa a la francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', 1, 0, 0, 0, 0, 1, '6000', 1, 0, NULL, '2022-07-24 20:26:08'),
(21, 36, 3, NULL, 'Papa criolla', 'Papa criolla', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', 1, 0, 0, 0, 0, 1, '6000', 1, 0, NULL, '2022-07-24 20:26:08'),
(22, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', 'Dos acompañamientos', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', 18, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 0, 0, 0, 0, 1, '48000', 2, 0, NULL, '2022-07-24 20:26:08'),
(23, 37, 3, NULL, 'Yuca frita', 'Yuca frita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(24, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', 'Dos acomp', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', 18, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 1, 1, 1, 1, 0, '48000', 2, 0, 'EFECTIVO', '2022-07-24 22:22:30'),
(25, 43, 5, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://www.seekpng.com/png/detail/239-2398645_botella-de-aguila-producto-colombiano-cerveza-aguila-png.png', 0, 0, 0, 0, 1, 0, '3000', 2, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(26, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 1, 1, 1, 1, 0, '2500', 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(27, 8, 2, NULL, 'Combo Q´leko al camino', 'Combo Q´leko al camino', 'Sin Observaciones', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', 20, 'https://unsplash.com/photos/HQ22vVXhWcc/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', 1, 1, 1, 1, 1, 0, '40000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(28, 43, 5, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://www.seekpng.com/png/detail/239-2398645_botella-de-aguila-producto-colombiano-cerveza-aguila-png.png', 1, 1, 1, 1, 1, 0, '3000', 6, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(29, 49, 5, NULL, 'Gaseosa Personal 350mL', 'Gaseosa Personal 350mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://www.misterpollo.co/domicilios/166-large_default/-gaseosa-350-ml.jpg', 1, 1, 1, 1, 1, 0, '2500', 2, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(30, 35, 3, NULL, 'Papa a la francesa', 'Papa a la francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(31, 37, 3, NULL, 'Yuca frita', 'Yuca frita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(32, 36, 3, NULL, 'Papa criolla', 'Papa criolla', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', 1, 1, 1, 1, 1, 0, '6000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(33, 38, 3, NULL, 'Platano al horno con queso y bocadillo', 'Platano al horno con queso y bocadillo', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, 'https://tucocina.b-cdn.net/wp-content/uploads/2021/03/Platanos-con-bocadillo-y-queso.jpg', 1, 1, 1, 1, 1, 0, '8000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(34, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Agua', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 0, 0, 0, 0, 1, '2500', 1, 0, NULL, '2022-07-24 21:54:41'),
(35, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 0, 0, 0, 0, 1, '2500', 1, 0, NULL, '2022-07-24 21:54:41'),
(36, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Agua', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 1, 1, 1, 1, 0, '2500', 1, 0, 'EFECTIVO', '2022-07-24 22:21:37'),
(37, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', '2 acomp', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', 2, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 1, 1, 1, 1, 0, '48000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:31'),
(38, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', '2 acomp', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 1, 1, 1, 1, 0, '35000', 1, 0, 'EFECTIVO', '2022-07-24 22:21:11'),
(39, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 0, 0, 0, 0, 0, 1, '35000', 1, 0, NULL, '2022-07-24 22:04:55'),
(40, 1, 1, NULL, 'Pollo Q\'leko al Carbon', 'Pollo Q\'leko al carbon con dos acompañamientos', 'Sin Observaciones', 'Papa Francesa - Papa Criolla', NULL, NULL, NULL, NULL, NULL, NULL, 4, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pollo-barbacoa-1-1594813233.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*', 1, 1, 1, 1, 1, 0, '35000', 1, 0, 'EFECTIVO', '2022-07-29 22:37:16'),
(41, 1, 1, NULL, 'Pollo Q\'leko al Carbon', 'Pollo Q\'leko al carbon con dos acompañamientos', 'Sin Observaciones', 'Yuca Frita - Papa Francesa', NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pollo-barbacoa-1-1594813233.jpg?crop=1.00xw:1.00xh;0,0&resize=640:*', 1, 1, 1, 1, 1, 0, '35000', 1, 100, 'EFECTIVO', '2022-07-29 22:33:57'),
(42, 6, 4, NULL, 'cocacola 400', 'cocacola', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '2800', 1, 100, 'EFECTIVO', '2022-07-29 22:34:00'),
(45, 16, 4, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Socias', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '3000', 3, 100, 'EFECTIVO', '2022-07-30 01:01:30'),
(46, 17, 4, NULL, 'Cerveza Cub Colombia', 'Cerveza Club Colombia', 'Socios', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '3500', 6, 100, 'EFECTIVO', '2022-07-30 01:01:30'),
(47, 16, 4, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Socios', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '3000', 2, 100, 'EFECTIVO', '2022-07-30 01:51:03'),
(48, 22, 4, NULL, 'Coca cola 250mL', 'Coca Cola 250mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, '', 0, 0, 0, 0, 0, 1, '2000', 1, 0, NULL, '2022-07-30 18:53:23'),
(49, 22, 4, NULL, 'Coca cola 250mL', 'Coca Cola 250mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, '', 1, 1, 1, 1, 1, 0, '2000', 1, 0, 'EFECTIVO', '2022-07-30 06:57:49'),
(50, 16, 4, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, '', 1, 1, 1, 1, 1, 0, '3000', 2, 100, 'EFECTIVO', '2022-07-30 18:58:47'),
(51, 15, 4, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, '', 0, 0, 0, 0, 0, 1, '3000', 1, 0, NULL, '2022-07-30 19:29:04'),
(52, 7, 2, NULL, 'Papa a la Francesa', 'Papa Francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.cocinacaserayfacil.net/wp-content/uploads/2014/12/patatas-fritas-crujientes.jpg', 1, 1, 1, 1, 1, 0, '5000', 3, 100, 'EFECTIVO', '2022-07-30 21:33:00'),
(53, 7, 2, NULL, 'Papa a la Francesa', 'Papa Francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'https://www.cocinacaserayfacil.net/wp-content/uploads/2014/12/patatas-fritas-crujientes.jpg', 1, 1, 1, 1, 1, 0, '5000', 1, 100, 'EFECTIVO', '2022-07-30 21:33:00'),
(54, 9, 2, NULL, 'Yuca Frita', 'Yuca Frita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '5000', 1, 100, 'EFECTIVO', '2022-07-30 21:33:00'),
(55, 13, 3, NULL, 'Sopa Grande', 'Sopa Grande', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 19, '', 1, 1, 1, 1, 1, 0, '7000', 1, 0, 'EFECTIVO', '2022-07-30 22:12:46'),
(56, 3, 1, NULL, 'Churrasco', 'Churrasco con dos acompañamientos', 'Sin Observaciones', 'Papa Francesa - Papa Criolla', NULL, NULL, NULL, NULL, NULL, NULL, 19, 'https://www.elespectador.com/resizer/D40nB1QQOdrNOZ_s8SKVXpoeDRM=/920x613/filters:format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/PBOUWEWMORD7ZOXXSJSJDUIBDQ.jpg', 1, 1, 1, 1, 1, 0, '20000', 1, 0, 'EFECTIVO', '2022-07-30 22:12:46'),
(57, 4, 1, NULL, 'Arroz con Pollo', 'Arroz con Pollo con un acompañamiento', 'Sin Observaciones', 'Papa Francesa', NULL, NULL, NULL, NULL, NULL, 'Limonada', 19, 'https://images.aws.nestle.recipes/original/8f592ab965966eef0763c05328927a0d_arroz-con-pollo-frito.jpg', 1, 1, 1, 1, 1, 0, '13000', 1, 0, 'EFECTIVO', '2022-07-30 22:12:46'),
(58, 24, 4, NULL, 'Botella de Agua', 'Botella de Agua', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '', 1, 1, 1, 1, 1, 0, '2500', 2, 0, 'EFECTIVO', '2022-07-30 22:13:05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse`
--

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL,
  `number_product` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
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
  `date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `warehouse`
--

INSERT INTO `warehouse` (`id`, `number_product`, `name`, `type`, `status`, `measure_unit`, `price_unit`, `date_price_unit`, `sale_price`, `date_sale_price`, `cant_disp`, `cant_order`, `cant_min_inv`, `total_inventory`, `date`) VALUES
(1, 'BE012', 'Cerveza Aguila', 'Bebida', 'Activo', 'Cm3', '1700', NULL, '3000', NULL, 132, 132, 132, NULL, 'Sun Jul 31 00:53:55 COT 2022'),
(2, 'BE002', 'Cerveza Poker', 'Bebida', 'Activo', 'Cm3', '1700', NULL, '3000', NULL, 98, 98, 30, NULL, 'Sat Jul 30 21:39:11 COT 2022'),
(3, 'BE003', 'Cerveza Club Colombia', 'Bebida', 'Activo', 'Cm3', '2200', NULL, '3500', NULL, 6, 6, 30, NULL, 'Sat Jul 30 21:39:23 COT 2022'),
(4, 'BE004', 'Cola y Pola', 'Bebida', 'Activo', 'Cm3', '1700', NULL, '3000', NULL, 11, 11, 30, NULL, 'Sat Jul 30 21:42:54 COT 2022'),
(5, 'BE005', 'Colombiana 400ml', 'Bebida', 'Activo', 'mL', '1500', NULL, '2800', NULL, 9, 9, 30, NULL, 'Sat Jul 30 21:43:49 COT 2022'),
(6, 'BE006', 'Coca Cola 250ml', 'Bebida', 'Activo', 'mL', '1000', NULL, '2000', NULL, 86, 86, 20, NULL, 'Sat Jul 30 21:44:00 COT 2022'),
(7, 'BE007', 'Coca Cola 400 ml', 'Bebida', 'Activo', 'mL', '2000', NULL, '2800', NULL, 33, 33, 30, NULL, 'Sat Jul 30 21:43:35 COT 2022'),
(8, 'BE008', 'Coca cola 1.5LT', 'Bebida', 'Activo', 'LT', '4500', NULL, '6000', NULL, 1, 1, 10, NULL, 'Sat Jul 30 21:44:24 COT 2022'),
(9, 'BE009', 'Sprite 1.5LT', 'Bebida', 'Activo', 'LT', '4500', NULL, '6000', NULL, 2, 2, 5, NULL, 'Sat Jul 30 21:44:49 COT 2022'),
(10, 'BE010', 'Agua zalva 600ml', 'Bebida', 'Activo', 'mL', '1000', NULL, '2500', NULL, 5, 5, 10, NULL, 'Sat Jul 30 21:45:15 COT 2022'),
(11, 'BE011', 'Agua Brisa', 'Bebida', 'Activo', 'mL', '1000', NULL, '2500', NULL, 60, 60, 24, NULL, 'Sat Jul 30 21:45:28 COT 2022'),
(12, 'PO001', 'Pollos ', 'Pollo', 'Activo', 'KG', '15000', NULL, '25000', NULL, 116, 116, 30, NULL, 'Sat Jul 30 18:05:43 COT 2022'),
(13, 'TU001', 'Yuca', 'Tuberculo', 'Activo', 'KG', '2000', NULL, '5000', NULL, 241, 241, 20, NULL, 'Sat Jul 30 18:05:25 COT 2022'),
(14, 'TU002', 'Papa francesa', 'Tuberculo', 'Activo', 'KG', '2000', NULL, '5000', NULL, 211, 211, 20, NULL, 'Sat Jul 30 18:05:09 COT 2022'),
(16, 'TU003', 'Papa criolla', 'Tuberculo', 'Activo', 'KG', '2000', NULL, '5000', NULL, 253, 253, 20, NULL, 'Sat Jul 30 18:04:54 COT 2022'),
(17, 'PO002', 'Pechuga de Pollo', 'Pollo', 'Activo', 'KG', '0000', NULL, '0000', NULL, 4, 4, 1, NULL, 'Sat Jul 30 18:41:53 COT 2022'),
(18, 'PE001', 'Salmon', 'Pescado', 'Activo', 'KG', '0000', NULL, '0000', NULL, 9, 9, 1, NULL, 'Sat Jul 30 18:57:43 COT 2022'),
(19, 'PO003', 'Muslos ', 'Pollo', 'Activo', 'KG', '0000', NULL, '0000', NULL, 6, 6, 1, NULL, 'Sat Jul 30 18:41:38 COT 2022'),
(20, 'PE002', 'Mojarra', 'Pescado', 'Activo', 'KG', '0000', NULL, '0000', NULL, 5, 5, 1, NULL, 'Sat Jul 30 18:57:59 COT 2022'),
(21, 'CA001', 'Churrasco', 'Carne', 'Activo', 'KG', '0000', NULL, '0000', NULL, 3, 3, 1, NULL, 'Sat Jul 30 18:39:56 COT 2022'),
(23, 'PE003', 'Viudo de Capaz', 'Pescado', 'Activo', 'KG', '0000', NULL, '0000', NULL, 4, 4, 1, NULL, 'Sat Jul 30 18:58:34 COT 2022'),
(24, 'PE004', 'Mixura', 'Pescado', 'Activo', 'KG', '0000', NULL, '0000', NULL, 10, 10, 1, NULL, 'Sat Jul 30 19:01:08 COT 2022'),
(25, 'EM001', 'Empaque QLEKO', 'Empaques - Bolsas', 'Activo', 'Und', '0', NULL, '0', NULL, 0, 0, 0, NULL, 'Sun Jul 31 00:57:09 COT 2022'),
(29, 'EM002', 'Bolsas', 'Empaques - Bolsas', 'Activo', 'Und', '0', NULL, '0', NULL, 0, 0, 0, NULL, 'Sun Jul 31 01:22:54 COT 2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `warehouse_type_product`
--

CREATE TABLE `warehouse_type_product` (
  `id` int(11) NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `warehouse_type_product`
--

INSERT INTO `warehouse_type_product` (`id`, `type`) VALUES
(1, 'Bebida'),
(2, 'Pollo'),
(3, 'Pescado'),
(4, 'Carne'),
(5, 'Empaques - Bolsas'),
(6, 'Verdura'),
(7, 'Fruta'),
(8, 'Hortalizas'),
(9, 'Tuberculos');

--
-- Índices para tablas volcadas
--

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
-- AUTO_INCREMENT de la tabla `discount`
--
ALTER TABLE `discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `measure_unit`
--
ALTER TABLE `measure_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `warehouse_type_product`
--
ALTER TABLE `warehouse_type_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
