-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 30, 2019 at 04:43 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `aksum`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `iditem` int(11) NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  `auteur` varchar(45) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `description` varchar(450) DEFAULT NULL,
  `itemPriv` varchar(45) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`iditem`, `iduser`, `auteur`, `prix`, `description`, `itemPriv`, `photo`, `nom`) VALUES
(1, NULL, 'Giovanni Strazza', 700, 'Vierge voile en marbre grec taille en Italie ', NULL, 'images/itemsGallerie/Buste.jpg', 'Buste'),
(2, NULL, 'carl Aubock', 1322, 'sculpture taille avec cuivre et bois.', NULL, 'images/itemsGallerie/Poisson.jpg', 'Poisson'),
(3, NULL, 'Cab', 150, 'Peinture du typique établissement Montréalais, le « dépanneur », originalement un concept pour une bande dessine de l’auteur.', NULL, 'images/itemsGallerie/Dep.jpg', 'Dep'),
(4, NULL, 'Nata S.', 367, 'Peinture à l’acrylique sur canvas étirer, illustrant l’automne et ses couleurs.', NULL, 'images/itemsGallerie/Pourpre.jpg', 'Pourpre'),
(5, NULL, 'Anonyme', 200, 'Fait entierement a la main, figure du renard animalement tant gracieux que ruse.\r\nAuteur : Anonyme\r\n', NULL, 'images/itemsGallerie/Renard.jpg', 'Renard'),
(6, NULL, 'Anonyme', 500, 'Image du legendaire artiste Tupac Amaru Shakur, œuvre represente le ying et yang qui habite chacun.', NULL, 'images/itemsGallerie/Dualite.jpg', 'Dualite'),
(7, NULL, 'Anonyme', 500, 'Image du legendaire artiste Tupac Amaru Shakur, œuvre represente le ying et yang qui habite chacun.', NULL, 'images/itemsGallerie/Dualite.jpg', 'Dualite');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`iditem`),
  ADD UNIQUE KEY `idItem_UNIQUE` (`iditem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `iditem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
