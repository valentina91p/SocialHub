-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2016 a las 20:57:40
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `socialhub`
--
CREATE DATABASE IF NOT EXISTS `socialhub` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `socialhub`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `redsocial`
--

CREATE TABLE IF NOT EXISTS `redsocial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `urlConnect` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `redsocial`
--

INSERT INTO `redsocial` (`id`, `nombre`, `urlConnect`) VALUES
(1, 'twitter', 'connect/twitter'),
(2, 'facebook', 'connect/facebook');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userconnection`
--

CREATE TABLE IF NOT EXISTS `userconnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL DEFAULT '',
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(512) NOT NULL,
  `secret` varchar(512) DEFAULT NULL,
  `refreshToken` varchar(512) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `userconnection`
--

INSERT INTO `userconnection` (`userId`, `providerId`, `providerUserId`, `rank`, `displayName`, `profileUrl`, `imageUrl`, `accessToken`, `secret`, `refreshToken`, `expireTime`) VALUES
('c.valentinamm@gmail.com', 'facebook', '740324729423285', 1, 'Valentina Maldonado', 'https://www.facebook.com/app_scoped_user_id/740324729423285/', 'https://graph.facebook.com/v2.3/740324729423285/picture', 'CAAB5hBCZCoZAABAGDalzMZCaO1ZA1nZBu1ZBWUfpPHqBGzfOx3Sk0eCTDpLZBjiBOqmwJZBunJkuJKvZBZAssVLewPgZCxFwZBhqxXsEyuCRmxEejojWNkB2afUmYoIbBdxRzuSbdVszoQBymbZCL0lxrafgnlZBPP3aC9VwbXwrMbobZAtg9C2p3K6q9Q5PiSp7f1wZBSFTemTX13cxJkPZCPyNqf9ve', NULL, NULL, 1442529443594),
('c.valentinamm@gmail.com', 'twitter', '1089934819', 1, '@CValentinamm', 'http://twitter.com/CValentinamm', 'http://abs.twimg.com/sticky/default_profile_images/default_profile_1_normal.png', '1089934819-zgY0eC6q3y8cwWCme6UdDsgOsojYEtwqp6qAPvp', 'OkJKldcc7LKZFJVX23LbXCNDNSrUfFTFGDb4ePmJ1EzY5', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(250) NOT NULL,
  `contrasena` varchar(150) NOT NULL,
  `nombre` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `contrasena`, `nombre`) VALUES
(6, 'c.valentinamm@gmail.com', '123456', 'Valentina Maldonado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_red`
--

CREATE TABLE IF NOT EXISTS `usuario_red` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `red_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
