-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 07 Ağu 2017, 16:57:49
-- Sunucu sürümü: 5.7.19-0ubuntu0.16.04.1
-- PHP Sürümü: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `yds`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kelimeler`
--

CREATE TABLE `kelimeler` (
  `id` int(11) NOT NULL,
  `INGKelime` varchar(50) NOT NULL,
  `grup` int(11) NOT NULL,
  `seviye` int(11) NOT NULL,
  `TRKelime` varchar(50) NOT NULL,
  `INGKelimeEs` varchar(50) NOT NULL,
  `INGKelimeZit` varchar(50) NOT NULL,
  `INGKelimeCumle` varchar(400) NOT NULL,
  `TRKeliemeCumle` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kelimeler`
--
ALTER TABLE `kelimeler`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kelimeler`
--
ALTER TABLE `kelimeler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
