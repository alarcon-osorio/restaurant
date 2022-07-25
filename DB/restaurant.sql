-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-07-2022 a las 05:31:48
-- Versión del servidor: 10.4.24-MariaDB
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
(1, 1, 'Desayuno completo', 'Caldo (pescado / costilla / pata / \npajarilla), huevos al gusto, bebida (chocolate / café / \naguapanela / tinto), arepa pequeña o pan', '12000', 'https://unsplash.com/photos/JVkGUwTYQag/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8Nnx8Y2FsZG98ZXN8MHx8fHwxNjU2NjcwMTk5&force=true&w=640', '0'),
(2, 1, 'Taza de aguapanela con queso', 'Una deliciosa Taza de aguapanela caliente con queso ', '4000', 'https://unsplash.com/photos/oBoELXgJR1w/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dCVDMyVBOXxlc3wwfHx8fDE2NTY2OTQxMjM&force=true&w=640', '0'),
(3, 1, 'Huevo con arroz', 'Plato de huevo con arroz', '6000', 'https://unsplash.com/photos/YWCEn9Jr4gw/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MTV8fGh1ZXZvcyUyMGNvbiUyMGFycm96fGVzfDB8fHx8MTY1NjcxNzA3MA&force=true&w=640', '0'),
(4, 1, 'Cacerola con huevos', 'Huevos al gusto en cacerola', '4500', 'https://unsplash.com/photos/R-J5t4aHj3I/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MTl8fGNhY2Vyb2xhJTIwaHVldm9zfGVzfDB8fHx8MTY1NjcxNzUwOQ&force=true&w=640', '0'),
(5, 1, 'Arepa con Queso', 'Deliciosa arepa con queso', '2500', 'https://unsplash.com/photos/4C_k18o_tnk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MXx8YXJlcGElMjBxdWVzb3xlc3wwfHx8fDE2NTY3ODIyNzc&force=true&w=640', '0'),
(6, 1, 'Chocolate con queso', 'Taza de chocolate con queso', '5000', 'https://unsplash.com/photos/8gnJu1Brcpk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dGF6YSUyMGNob2NvbGF0ZXxlc3wwfHx8fDE2NTY3Nzk1NjE&force=true&w=640', '0'),
(7, 2, 'Combo Familiar', 'Combo para cuatro personas', '48000', 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', '0'),
(8, 2, 'Combo Q´leko al camino', 'Combo Q´leko al camino', '40000', 'https://unsplash.com/photos/HQ22vVXhWcc/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', '0'),
(9, 2, 'Combo Dúo', 'Combo para dos personas', '25000', 'https://unsplash.com/photos/gE28aTnlqJA/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', '0'),
(10, 2, 'Combo personal', 'Combo personal', '16000', 'https://unsplash.com/photos/GyV6SL_fKsI/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8Nnx8cG9sbG98ZXN8MHx8fHwxNjU2OTQ0MDQ0&force=true&w=640', '0'),
(11, 2, 'Combo Q´lekito', 'Combo Q´lekito', '13000', 'https://unsplash.com/photos/b94AylTxWqA/download?i…YXNhZG98ZXN8MHx8fHwxNjU2OTY0NDUx&force=true&w=640', '0'),
(31, 3, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', '35000', 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', '0'),
(32, 3, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', '20000', 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', '0'),
(33, 3, '1/4 Pollo Q\'leko al carbón', '1/4 Pollo Q\'leko al carbón', '10000', 'https://unsplash.com/photos/GyV6SL_fKsI/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyMjY0&force=true&w=640', '0'),
(34, 3, 'Churrasco con un acompañamiento', 'Churrasco con un acompañamiento', '23000', 'https://unsplash.com/photos/NYBnDWeOX2c/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzExOTI5&force=true&w=640', '0'),
(35, 3, 'Papa a la francesa', 'Papa a la francesa', '6000', 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', '0'),
(36, 3, 'Papa criolla', 'Papa criolla', '6000', 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', '0'),
(37, 3, 'Yuca frita', 'Yuca frita', '6000', 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', '0'),
(38, 3, 'Platano al horno con queso y bocadillo', 'Platano al horno con queso y bocadillo', '8000', 'https://tucocina.b-cdn.net/wp-content/uploads/2021/03/Platanos-con-bocadillo-y-queso.jpg', '0'),
(39, 4, 'Ajiaco', 'Ajiaco', '7000', 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', '0'),
(40, 4, 'Mazamorra', 'Mazamorra', '7000', 'http://1.bp.blogspot.com/-Gj-hx0A5xaQ/Ttp3NwanPiI/AAAAAAAAAGU/bAM_EAQYDQg/s1600/mazamorra+chiquita.JPG', '0'),
(41, 4, '1/2 Sopa', '1/2 Sopa', '5000', 'http://www.comedera.com/wp-content/uploads/2019/11/sopa-de-arroz.jpg', '0'),
(42, 5, 'Cerveza Poker', 'Cerveza Poker', '2500', 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', '0'),
(43, 5, 'Cerveza Aguila', 'Cerveza Aguila', '3000', 'https://www.seekpng.com/png/detail/239-2398645_botella-de-aguila-producto-colombiano-cerveza-aguila-png.png', '0'),
(44, 5, 'Cerveza Club Colombia', 'Cerveza Club Colombia', '3000', 'http://bucaramanga.gruposotillo.com/wp-content/uploads/2014/08/Cerveza_Club_Colombia.jpg', '0'),
(45, 5, 'Cerveza Aguila Light', 'Cerveza Aguila Light', '3000', 'https://elamigodelanoche.com/wp-content/uploads/2018/10/Cerveza-Aguila-Light-330-ML.jpg', '0'),
(46, 5, 'Cerveza Coronita', 'Cerveza Coronita', '3500', 'https://www.seekpng.com/png/detail/16-169043_corona-light.png', '0'),
(47, 5, 'Cerveza Costeña Bacana', 'Cerveza Costeña Bacana', '2500', 'https://cdn.forbes.co/2020/07/Botela-coste%C3%B1a-bacana-1000x600.jpg', '0'),
(48, 5, 'Gaseosa 1.5L', 'Gaseosa 1.5L', '6000', 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', '0'),
(49, 5, 'Gaseosa Personal 350mL', 'Gaseosa Personal 350mL', '2500', 'https://www.misterpollo.co/domicilios/166-large_default/-gaseosa-350-ml.jpg', '0'),
(50, 5, 'Jugos Hit', 'Jugos Hit', '2500', 'https://ponchocarrielysombrerocomidatipica.com/53-large_default/jugos-hit.jpg', '0'),
(51, 5, 'Jugo Natural 500mL', 'Jugo Natural 500mL', '6000', 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', '0'),
(52, 5, 'Limonada de Yerbabuena', 'Limonada de Yerbabuena', '6000', 'https://www.receta-vegetariana.com/base/stock/Recipe/27-image/27-image_web.jpg', '0'),
(53, 5, 'Limonada de coco', 'Limonada de coco', '6000', 'https://asaderolagranllanera.com/wp-content/uploads/2021/04/1056.png', '0'),
(54, 5, 'Limonada cerezada', 'Limonada cerezada', '6000', 'https://i0.wp.com/lasrocas.com.co/wp-content/uploads/2021/08/LIMONADA-CEREZADA-scaled.jpg?fit=2560%2C1707&ssl=1', '0'),
(55, 5, 'Limonada jarra 2L', 'Limonada jarra 2L', '10000', 'https://broasteryasadochia.com/wp-content/uploads/2020/03/descarga-42.jpg', '0'),
(56, 5, 'Limonada jarra1L', 'Limonada jarra1L', '5000', 'https://envato-shoebox-0.imgix.net/1923/251b-6e91-47fc-9a6d-0d2e9d4d7b32/Apricot+Iced+Lemonade+pitcher-1-Edit+copy.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fst', '0'),
(57, 5, 'Agua Personal 350mL', 'Gaseosa Personal 350mL', '2500', 'https://zeferinos.com/wp-content/uploads/2015/05/agua.png', '0'),
(58, 5, 'Botella de agua saborizada', 'Botella de agua saborizada', '2500', 'https://olimpica.vtexassets.com/arquivos/ids/641332-800-450?v=637626577548230000&width=800&height=450&aspect=true', '0'),
(59, 6, 'Almuerzo Completo', 'Almuerzo completo viene con sopa', '13000', 'https://old.bodytechperu.com/uploads/post/fc1ec1d12917418aa1c9caa645f82a07/7-almuerzos-para-una-semana-saludable_1200x640.jpg', '');

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
(1, 7, 2, 'Yuca'),
(2, 7, 2, 'Papa Francesa'),
(3, 7, 2, 'Papa Criolla');

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
(1, 7, 2, '2 Gaseosas pequeñas', ''),
(2, 7, 2, 'Jarra de Limonada Pequeña', '');

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
(1, 1, 1, 'Caldo de Pescado', 'Huevos Revueltos', 'Chocolate', 'Arepa', '-'),
(2, 1, 1, 'Caldo de Costilla', 'Huevo Fritos', 'Perico', 'Pan', '-'),
(3, 1, 1, 'Caldo de Pata', 'Huevos Pericos', 'Agua de Panela', '-', '-'),
(4, 1, 1, 'Caldo de Pajarilla', '-', 'Tinto', '-', '-'),
(5, 1, 1, '-', '-', '-', '-', '-');

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
(1, 'Desayunos'),
(2, 'Combos'),
(3, 'Platos principales'),
(4, 'Sopas'),
(5, 'Bebidas'),
(6, 'Almuerzo corriente');

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
(6, 'TARJETA CREDITO', 'TC'),
(7, 'BONO 100%', 'BONOS FAMILIARES & AMIGOS '),
(8, 'BONO 20%', 'BONOS FAMILIARES & AMIGOS ');

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
  `price` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `table_number` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `ordered` int(11) DEFAULT NULL,
  `prepare` int(11) DEFAULT NULL,
  `prepared` int(11) DEFAULT NULL,
  `served` int(11) DEFAULT NULL,
  `close` int(11) DEFAULT NULL,
  `cancel` int(11) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `service_order`
--

INSERT INTO `service_order` (`id`, `id_menu`, `id_menu_type`, `number_order`, `name`, `description`, `observations`, `accompaniment`, `option1`, `option2`, `option3`, `option4`, `option5`, `drinks_includes`, `price`, `cant`, `table_number`, `image`, `ordered`, `prepare`, `prepared`, `served`, `close`, `cancel`, `payment_method`, `time`) VALUES
(1, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '20000', 1, 3, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(2, 48, 5, NULL, 'Gaseosa 1.5L', 'Gaseosa 1.5L', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 3, 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(3, 51, 5, NULL, 'Jugo Natural 500mL', 'Jugo Natural 500mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 3, 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(4, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Bajito de sal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '7000', 2, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:34:23'),
(5, 44, 5, NULL, 'Cerveza Club Colombia', 'Cerveza Club Colombia', 'Bien fria', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3000', 3, 10, 'http://bucaramanga.gruposotillo.com/wp-content/uploads/2014/08/Cerveza_Club_Colombia.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:34:23'),
(6, 2, 1, NULL, 'Taza de aguapanela con queso', 'Una deliciosa Taza de aguapanela caliente con queso ', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '4000', 2, 3, 'https://unsplash.com/photos/oBoELXgJR1w/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dCVDMyVBOXxlc3wwfHx8fDE2NTY2OTQxMjM&force=true&w=640', 0, 0, 0, 0, 0, 1, NULL, '2022-07-23 19:38:15'),
(7, 59, 1, NULL, 'Almuerzo Completo', 'Almuerzo completo viene con sopa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '13000', 2, 3, 'https://old.bodytechperu.com/uploads/post/fc1ec1d12917418aa1c9caa645f82a07/7-almuerzos-para-una-semana-saludable_1200x640.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 19:55:29'),
(8, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Con mazorca', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '7000', 1, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-23 19:47:44'),
(9, 39, 4, NULL, 'Ajiaco', 'Ajiaco', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '7000', 1, 10, 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(10, 59, 6, NULL, 'Almuerzo Completo', 'Almuerzo completo viene con sopa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '13000', 1, 10, 'https://old.bodytechperu.com/uploads/post/fc1ec1d12917418aa1c9caa645f82a07/7-almuerzos-para-una-semana-saludable_1200x640.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(11, 51, 5, NULL, 'Jugo Natural 500mL', 'Jugo Natural 500mL', 'Lulo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 10, 'https://k-listo.com/wp-content/uploads/2020/04/JUGOS_NATURALES.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 20:20:13'),
(12, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '35000', 1, 100, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 20:21:50'),
(13, 48, 5, NULL, 'Gaseosa 1.5L', 'Gaseosa 1.5L', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 1, 'https://comidasrapidasolafo.com/wp-content/uploads/2021/02/1.5l.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 20:30:36'),
(14, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Con papá y yuca', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '20000', 1, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 21:44:45'),
(15, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Con papá a la francesa y yuca ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '20000', 1, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-23 21:51:31'),
(16, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '20000', 1, 2, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 22:02:42'),
(17, 32, 3, NULL, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '20000', 1, 1, 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 21:55:02'),
(18, 46, 5, NULL, 'Cerveza Coronita', 'Cerveza Coronita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3500', 1, 1, 'https://www.seekpng.com/png/detail/16-169043_corona-light.png', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-23 21:59:39'),
(19, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '35000', 1, 18, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 20:26:08'),
(20, 35, 3, NULL, 'Papa a la francesa', 'Papa a la francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 18, 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 20:26:08'),
(21, 36, 3, NULL, 'Papa criolla', 'Papa criolla', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 18, 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 20:26:08'),
(22, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', 'Dos acompañamientos', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', '48000', 2, 18, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 20:26:08'),
(23, 37, 3, NULL, 'Yuca frita', 'Yuca frita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 18, 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(24, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', 'Dos acomp', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', '48000', 2, 18, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(25, 43, 5, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3000', 2, 18, 'https://www.seekpng.com/png/detail/239-2398645_botella-de-aguila-producto-colombiano-cerveza-aguila-png.png', 0, 0, 0, 0, 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(26, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2500', 1, 18, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:22:04'),
(27, 8, 2, NULL, 'Combo Q´leko al camino', 'Combo Q´leko al camino', 'Sin Observaciones', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', '40000', 1, 20, 'https://unsplash.com/photos/HQ22vVXhWcc/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(28, 43, 5, NULL, 'Cerveza Aguila', 'Cerveza Aguila', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3000', 6, 20, 'https://www.seekpng.com/png/detail/239-2398645_botella-de-aguila-producto-colombiano-cerveza-aguila-png.png', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(29, 49, 5, NULL, 'Gaseosa Personal 350mL', 'Gaseosa Personal 350mL', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2500', 2, 20, 'https://www.misterpollo.co/domicilios/166-large_default/-gaseosa-350-ml.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(30, 35, 3, NULL, 'Papa a la francesa', 'Papa a la francesa', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 20, 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(31, 37, 3, NULL, 'Yuca frita', 'Yuca frita', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 20, 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(32, 36, 3, NULL, 'Papa criolla', 'Papa criolla', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '6000', 1, 20, 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(33, 38, 3, NULL, 'Platano al horno con queso y bocadillo', 'Platano al horno con queso y bocadillo', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8000', 1, 20, 'https://tucocina.b-cdn.net/wp-content/uploads/2021/03/Platanos-con-bocadillo-y-queso.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:20'),
(34, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Agua', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2500', 1, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 21:54:41'),
(35, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2500', 1, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 0, 0, 0, 0, 1, NULL, '2022-07-24 21:54:41'),
(36, 42, 5, NULL, 'Cerveza Poker', 'Cerveza Poker', 'Agua', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2500', 1, 1, 'https://www.bavaria.co/sites/g/files/phfypu1316/f/BOTELLA-550PX.png', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:37'),
(37, 7, 2, NULL, 'Combo Familiar', 'Combo para cuatro personas', '2 acomp', 'Yuca', NULL, NULL, NULL, NULL, NULL, '2 Gaseosas pequeñas', '48000', 1, 2, 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:31'),
(38, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', '2 acomp', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '35000', 1, 3, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 1, 1, 1, 1, 1, 0, 'EFECTIVO', '2022-07-24 22:21:11'),
(39, 31, 3, NULL, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', 'Sin Observaciones', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '35000', 1, 3, 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 0, 0, 0, 0, 0, 1, NULL, '2022-07-24 22:04:55');

--
-- Índices para tablas volcadas
--

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
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `menu_accompaniment`
--
ALTER TABLE `menu_accompaniment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `menu_includes`
--
ALTER TABLE `menu_includes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `menu_optional`
--
ALTER TABLE `menu_optional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
