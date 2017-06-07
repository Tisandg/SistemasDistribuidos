-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-06-2017 a las 18:08:04
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdusuarios_audio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscrito`
--

CREATE TABLE `suscrito` (
  `login` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `suscrito`
--

INSERT INTO `suscrito` (`login`) VALUES
('rey');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombresUsuario` varchar(30) NOT NULL,
  `apellidosUsuario` varchar(20) NOT NULL,
  `loginUsuario` varchar(10) NOT NULL,
  `claveUsuario` varchar(15) NOT NULL,
  `imagenUsuario` varchar(50) DEFAULT NULL,
  `privilegiosUsuario` tinyint(1) DEFAULT '0',
  `desactivado` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombresUsuario`, `apellidosUsuario`, `loginUsuario`, `claveUsuario`, `imagenUsuario`, `privilegiosUsuario`, `desactivado`) VALUES
(2, 'santiago', 'chicangana', 'tisandg', '12345', 'sdsdfssfsd', 1, 0),
(3, 'Esteban', 'Chicangana', 'teban', '123456', 'asdasd', 0, 1),
(4, 'eliza', 'chicangana', 'elizita', '123456', 'defecto', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `loginUsuario` (`loginUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
