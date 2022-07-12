-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 12-07-2022 a las 18:57:28
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
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `ordered` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `id_menu_type`, `name`, `description`, `price`, `image`, `ordered`) VALUES
(1, 1, 'Desayuno completo', 'Caldo (pescado / costilla / pata / \npajarilla), huevos al gusto, bebida (chocolate / café / \naguapanela / tinto), arepa pequeña o pan', '12000', 'https://unsplash.com/photos/JVkGUwTYQag/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8Nnx8Y2FsZG98ZXN8MHx8fHwxNjU2NjcwMTk5&force=true&w=640', 0),
(2, 1, 'Taza de aguapanela con queso', 'Una deliciosa Taza de aguapanela caliente con queso ', '4000', 'https://unsplash.com/photos/oBoELXgJR1w/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dCVDMyVBOXxlc3wwfHx8fDE2NTY2OTQxMjM&force=true&w=640', 0),
(3, 1, 'Huevo con arroz', 'Plato de huevo con arroz', '6000', 'https://unsplash.com/photos/YWCEn9Jr4gw/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MTV8fGh1ZXZvcyUyMGNvbiUyMGFycm96fGVzfDB8fHx8MTY1NjcxNzA3MA&force=true&w=640', 0),
(4, 1, 'Cacerola con huevos', 'Huevos al gusto en cacerola', '4500', 'https://unsplash.com/photos/R-J5t4aHj3I/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MTl8fGNhY2Vyb2xhJTIwaHVldm9zfGVzfDB8fHx8MTY1NjcxNzUwOQ&force=true&w=640', 0),
(5, 1, 'Arepa con Queso', 'Deliciosa arepa con queso', '2500', 'https://unsplash.com/photos/4C_k18o_tnk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MXx8YXJlcGElMjBxdWVzb3xlc3wwfHx8fDE2NTY3ODIyNzc&force=true&w=640', 0),
(6, 1, 'Chocolate con quedo', 'Tasa de chocolate con queso', '5000', 'https://unsplash.com/photos/8gnJu1Brcpk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NHx8dGF6YSUyMGNob2NvbGF0ZXxlc3wwfHx8fDE2NTY3Nzk1NjE&force=true&w=640', 0),
(7, 2, 'Combo Familiar', 'Combo para cuatro personas', '48000', 'https://i.pinimg.com/originals/c5/77/ef/c577efeac84736382690c8824056465b.jpg', 0),
(8, 2, 'Combo Q´leko al camino', 'Combo Q´leko al camino', '40000', 'https://unsplash.com/photos/HQ22vVXhWcc/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', 0),
(9, 2, 'Combo Dúo', 'Combo para dos personas', '25000', 'https://unsplash.com/photos/gE28aTnlqJA/download?i…BvbGxvfGVzfDB8fHx8MTY1Njk0NDA0NA&force=true&w=640', 0),
(10, 2, 'Combo personal', 'Combo personal', '16000', 'https://unsplash.com/photos/GyV6SL_fKsI/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8Nnx8cG9sbG98ZXN8MHx8fHwxNjU2OTQ0MDQ0&force=true&w=640', 0),
(11, 2, 'Combo Q´lekito', 'Combo Q´lekito', '13000', 'https://unsplash.com/photos/b94AylTxWqA/download?i…YXNhZG98ZXN8MHx8fHwxNjU2OTY0NDUx&force=true&w=640', 0),
(31, 3, 'Pollo Q\'leko al carbón', 'Pollo Q\'leko al carbón', '35000', 'https://unsplash.com/photos/9zLa37VNL38/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjEyMzkw&force=true&w=640', 0),
(32, 3, '1/2 Pollo Q\'leko al carbón', '1/2 Pollo Q\'leko al carbón', '20000', 'https://unsplash.com/photos/gE28aTnlqJA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NjQ2MDk3&force=true&w=640', 0),
(33, 3, '1/4 Pollo Q\'leko al carbón', '1/4 Pollo Q\'leko al carbón', '10000', 'https://unsplash.com/photos/GyV6SL_fKsI/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyMjY0&force=true&w=640', 0),
(34, 3, 'Churrasco con un acompañamiento', 'Churrasco con un acompañamiento', '23000', 'https://unsplash.com/photos/NYBnDWeOX2c/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzExOTI5&force=true&w=640', 0),
(35, 3, 'Papa a la francesa', 'Papa a la francesa', '6000', 'https://unsplash.com/photos/ocrTZ78Et08/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyNDg1&force=true&w=640', 0),
(36, 3, 'Papa criolla', 'Papa criolla', '6000', 'https://unsplash.com/photos/ECxiHN817xE/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzEyODI3&force=true&w=640', 0),
(37, 3, 'Yuca frita', 'Yuca frita', '6000', 'https://www.divinacocina.es/wp-content/uploads/yuca-frita.jpg', 0),
(38, 3, 'Platano al horno con queso y bocadillo', 'Platano al horno con queso y bocadillo', '8000', 'https://tucocina.b-cdn.net/wp-content/uploads/2021/03/Platanos-con-bocadillo-y-queso.jpg', 0),
(39, 4, 'Ajiaco', 'Ajiaco', '7000', 'https://unsplash.com/photos/apjyDlT5adw/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjU2NzE0MDIx&force=true&w=640', 0),
(40, 4, 'Mazamorra', 'Mazamorra', '7000', 'http://1.bp.blogspot.com/-Gj-hx0A5xaQ/Ttp3NwanPiI/AAAAAAAAAGU/bAM_EAQYDQg/s1600/mazamorra+chiquita.JPG', 0),
(41, 4, '1/2 Sopa', '1/2 Sopa', '5000', 'http://www.comedera.com/wp-content/uploads/2019/11/sopa-de-arroz.jpg', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_accompaniment`
--

CREATE TABLE `menu_accompaniment` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `accompaniment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menu_accompaniment`
--

INSERT INTO `menu_accompaniment` (`id`, `id_menu`, `id_menu_type`, `accompaniment`) VALUES
(1, 1, 2, 'Yuca'),
(2, 1, 2, 'Papa Francesa'),
(3, 1, 2, 'Papa Criolla');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_includes`
--

CREATE TABLE `menu_includes` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menu_includes`
--

INSERT INTO `menu_includes` (`id`, `id_menu`, `name`, `price`) VALUES
(1, 1, '2 Gaseosas pequeñas', ''),
(2, 1, 'Jarra de Limonada Pequeña', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_type`
--

CREATE TABLE `menu_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menu_type`
--

INSERT INTO `menu_type` (`id`, `name`) VALUES
(1, 'Desayunos'),
(2, 'Combos'),
(3, 'Platos principales'),
(4, 'Sopas'),
(5, 'Bebidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant_table`
--

CREATE TABLE `restaurant_table` (
  `id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `restaurant_table`
--

INSERT INTO `restaurant_table` (`id`, `table_number`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service_order`
--

CREATE TABLE `service_order` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_menu_type` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `observations` varchar(255) NOT NULL,
  `accompaniment` varchar(255) DEFAULT NULL,
  `drinks_includes` varchar(255) DEFAULT NULL,
  `price` varchar(255) NOT NULL,
  `table_number` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Indices de la tabla `menu_type`
--
ALTER TABLE `menu_type`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `menu_accompaniment`
--
ALTER TABLE `menu_accompaniment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `menu_includes`
--
ALTER TABLE `menu_includes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `restaurant_table`
--
ALTER TABLE `restaurant_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `service_order`
--
ALTER TABLE `service_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
