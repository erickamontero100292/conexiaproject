-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-04-2019 a las 14:37:34
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
SET GLOBAL time_zone = '-5:00';


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conexia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cooks`
--

CREATE TABLE `cooks` (
  `idcooks` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `surname` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `lastname` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `cooks`
--

INSERT INTO `cooks` (`idcooks`, `name`, `surname`, `lastname`) VALUES
(2, 'Maria', 'Montero', 'Montero'),
(3, 'Pedro', 'Hernandez', 'Hernandez'),
(4, 'Maria', 'Montero', 'Montero'),
(5, 'Maria', 'Montero', 'Montero'),
(6, 'Pedro', 'Hernandez', 'Hernandez'),
(7, 'Maria', 'Montero', 'Montero'),
(8, 'Maria', 'Montero', 'Montero'),
(9, 'Pedro', 'Hernandez', 'Hernandez'),
(10, 'Maria', 'Montero', 'Montero'),
(12, 'Ericka', 'Montero', 'Montero'),
(13, 'Luisito', 'Perez', 'Perez'),
(14, 'popi', 'ASAS', 'ASAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customers`
--

CREATE TABLE `customers` (
  `idcustomer` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `surname` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `lastname` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `observations` varchar(150) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `customers`
--

INSERT INTO `customers` (`idcustomer`, `name`, `surname`, `lastname`, `observations`) VALUES
(2, 'Pablo', 'Hernandez', 'Hernandez', NULL),
(3, 'Juan', 'Martinez', 'Martinez', NULL),
(4, 'Pedro', 'Hernandez', 'Hernandez', NULL),
(5, 'Pedro', 'Hernandez', 'Hernandez', 'suroeste'),
(6, 'Juan', 'Martinez', 'Martinez', NULL),
(7, 'Maria', 'Montero', 'Montero', NULL),
(8, 'Juan', 'Martinez', 'Martinez', NULL),
(9, 'Maria', 'Montero', 'Montero', NULL),
(10, 'Maria', 'Montero', 'Montero', NULL),
(11, 'Juan', 'Martinez', 'Martinez', NULL),
(12, 'zxf', 'asd', 'aasd', 'asd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detailinvoices`
--

CREATE TABLE `detailinvoices` (
  `iddetailinvoices` int(11) NOT NULL,
  `idinvoice` int(11) NOT NULL,
  `idcook` int(11) NOT NULL,
  `plate` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `importe` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `detailinvoices`
--

INSERT INTO `detailinvoices` (`iddetailinvoices`, `idinvoice`, `idcook`, `plate`, `importe`) VALUES
(1, 2, 2, 'OESTE', 100000),
(2, 11, 2, 'OESTE', 11545),
(3, 2, 2, 'pasta', 12),
(4, 11, 2, 'PIZZA', 1000),
(5, 11, 2, 'PIZZA', 100000),
(6, 11, 2, 'PIZZA', 222),
(7, 11, 2, 'PIZZA', 222),
(8, 12, 2, 'PIZZA', 5554),
(11, 11, 2, 'PIZZA', 21212),
(13, 15, 2, 'PIZZA', 1212),
(14, 27, 3, 'sushi', 6566),
(15, 28, 3, 'sushi', 1445),
(16, 29, 2, 'arroz', 41),
(17, 30, 2, 'arroz', 46464),
(18, 31, 3, 'pasta', 6659),
(19, 28, 3, 'jugo', 4654),
(20, 30, 3, 'jugo', 10000),
(21, 32, 3, 'zdf', 234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invoices`
--

CREATE TABLE `invoices` (
  `idinvoice` int(11) NOT NULL,
  `idcustomer` int(11) NOT NULL,
  `idwaiter` int(11) NOT NULL,
  `idtable` int(11) NOT NULL,
  `invoicedate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `invoices`
--

INSERT INTO `invoices` (`idinvoice`, `idcustomer`, `idwaiter`, `idtable`, `invoicedate`) VALUES
(2, 2, 2, 10, '2019-05-24'),
(11, 4, 4, 4, '2019-04-24'),
(12, 4, 4, 4, '2019-04-24'),
(13, 3, 3, 3, '2019-04-24'),
(14, 4, 4, 4, '2019-04-24'),
(15, 3, 3, 3, '2019-04-24'),
(17, 3, 3, 3, '2019-04-24'),
(18, 4, 4, 4, '2019-04-24'),
(19, 3, 3, 3, '2019-04-24'),
(20, 3, 3, 3, '2019-04-24'),
(21, 4, 3, 10, '2019-04-25'),
(22, 4, 2, 9, '2019-05-25'),
(23, 7, 4, 9, '2019-04-25'),
(24, 3, 3, 9, '2019-04-25'),
(25, 3, 3, 10, '2019-04-25'),
(26, 3, 4, 5, '2019-04-25'),
(27, 3, 6, 9, '2019-04-25'),
(28, 7, 3, 10, '2019-04-25'),
(29, 2, 2, 9, '2019-01-02'),
(30, 3, 2, 5, '2019-02-07'),
(31, 3, 2, 3, '2019-03-13'),
(32, 2, 2, 11, '2019-04-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tables`
--

CREATE TABLE `tables` (
  `idtable` int(11) NOT NULL,
  `maxdiners` int(11) NOT NULL,
  `location` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tables`
--

INSERT INTO `tables` (`idtable`, `maxdiners`, `location`) VALUES
(3, 4, 'OESTE'),
(4, 4, 'OESTE'),
(5, 4, 'NORTE'),
(6, 4, 'NORTE'),
(7, 4, 'NORTE'),
(8, 4, 'SUR'),
(9, 4, 'ESTE'),
(10, 4, 'NORTE'),
(11, 4, 'NORTE'),
(12, 4, 'SUR'),
(13, 4, 'OESTE'),
(14, 4, 'ESTE'),
(15, 4, 'ESTE'),
(16, 4, 'SUR'),
(17, 4, 'NORTE'),
(18, 4, 'OESTE'),
(19, 4, 'NORTE'),
(20, 5, 'OESTE'),
(21, 4, 'SUR'),
(22, 4, 'NORTE'),
(23, 4, 'NORTE'),
(24, 4, 'OESTE'),
(25, 4, 'SUR'),
(26, 4, 'ESTE'),
(27, 4, 'OESTE'),
(28, 4, 'NORTE'),
(29, 4, 'ESTE'),
(30, 4, 'SUR'),
(31, 4, 'NORTE'),
(32, 4, 'ESTE'),
(33, 4, 'OESTE'),
(34, 4, 'ESTE'),
(35, 4, 'OESTE'),
(36, 4, 'SUR'),
(37, 4, 'ESTE'),
(38, 4, 'OESTE'),
(39, 4, 'NORTE'),
(40, 4, 'OESTE'),
(41, 4, 'OESTE'),
(42, 4, 'NORTE'),
(43, 4, 'ESTE'),
(44, 4, 'SUR'),
(45, 4, 'ESTE'),
(46, 4, 'NORTE'),
(47, 4, 'NORTE'),
(48, 4, 'SUR'),
(49, 4, 'OESTE'),
(50, 4, 'SUR'),
(51, 4, 'ESTE'),
(52, 4, 'SUR'),
(53, 4, 'OESTE'),
(54, 4, 'ESTE'),
(55, 4, 'ESTE'),
(56, 4, 'ESTE'),
(57, 4, 'SUR'),
(58, 4, 'SUR'),
(63, 4, 'OESTE'),
(64, 500, 'OESTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `waiters`
--

CREATE TABLE `waiters` (
  `idwaiter` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `surname` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `lastname` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `waiters`
--

INSERT INTO `waiters` (`idwaiter`, `name`, `surname`, `lastname`) VALUES
(2, 'Luis', 'Martinez', 'Martinez'),
(3, 'Juan', 'Martinez', 'Martinez'),
(4, 'Maria', 'Montero', 'Montero'),
(5, 'Maria', 'Montero', 'Montero'),
(6, 'Pedro', 'Hernandez', 'Hernandez'),
(7, 'Maria', 'Montero', 'Montero'),
(8, 'Pedro', 'Hernandez', 'Hernandez'),
(9, 'Pedro', 'Hernandez', 'Hernandez'),
(10, 'Maria', 'Montero', 'Montero'),
(11, 'Perez', 'sd', 'asd');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cooks`
--
ALTER TABLE `cooks`
  ADD PRIMARY KEY (`idcooks`);

--
-- Indices de la tabla `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`idcustomer`);

--
-- Indices de la tabla `detailinvoices`
--
ALTER TABLE `detailinvoices`
  ADD PRIMARY KEY (`iddetailinvoices`,`idinvoice`),
  ADD KEY `fk_cook` (`idcook`),
  ADD KEY `fk_invoice` (`idinvoice`);

--
-- Indices de la tabla `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`idinvoice`),
  ADD KEY `fk_customer` (`idcustomer`),
  ADD KEY `fk_waiter` (`idwaiter`),
  ADD KEY `fk_table` (`idtable`);

--
-- Indices de la tabla `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`idtable`);

--
-- Indices de la tabla `waiters`
--
ALTER TABLE `waiters`
  ADD PRIMARY KEY (`idwaiter`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cooks`
--
ALTER TABLE `cooks`
  MODIFY `idcooks` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `customers`
--
ALTER TABLE `customers`
  MODIFY `idcustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `detailinvoices`
--
ALTER TABLE `detailinvoices`
  MODIFY `iddetailinvoices` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `invoices`
--
ALTER TABLE `invoices`
  MODIFY `idinvoice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `tables`
--
ALTER TABLE `tables`
  MODIFY `idtable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `waiters`
--
ALTER TABLE `waiters`
  MODIFY `idwaiter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detailinvoices`
--
ALTER TABLE `detailinvoices`
  ADD CONSTRAINT `fk_cook` FOREIGN KEY (`idcook`) REFERENCES `cooks` (`idcooks`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_invoice` FOREIGN KEY (`idinvoice`) REFERENCES `invoices` (`idinvoice`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `fk_customer` FOREIGN KEY (`idcustomer`) REFERENCES `customers` (`idcustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_table` FOREIGN KEY (`idtable`) REFERENCES `tables` (`idtable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_waiter` FOREIGN KEY (`idwaiter`) REFERENCES `waiters` (`idwaiter`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
