-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2024 at 06:23 PM
-- Wersja serwera: 10.4.28-MariaDB
-- Wersja PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `produkty`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `napoje`
--

CREATE TABLE `napoje` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `pojemnosc` int(11) NOT NULL,
  `cena` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `napoje`
--

INSERT INTO `napoje` (`id`, `nazwa`, `pojemnosc`, `cena`) VALUES
(1, 'Soda', 330, 4.90),
(2, 'Oranżada', 330, 4.50),
(3, 'Woda gazowana', 330, 2.90),
(4, 'Woda niegazowana', 330, 2.90),
(5, 'Sok pomarańczowy', 500, 4.70),
(6, 'Sok jabłkowy', 500, 5.50),
(7, 'Energetyk', 500, 6.50),
(8, 'Kawa mrożona', 330, 4.70),
(9, 'Shake', 330, 4.90),
(10, 'Herbata', 330, 3.50);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `transakcje`
--

CREATE TABLE `transakcje` (
  `id` int(11) NOT NULL,
  `id_napoju` int(11) NOT NULL,
  `data_transakcji` date NOT NULL,
  `kwota` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transakcje`
--

INSERT INTO `transakcje` (`id`, `id_napoju`, `data_transakcji`, `kwota`) VALUES
(1, 4, '2024-02-01', 2.90),
(2, 9, '2024-02-01', 4.90),
(3, 6, '2024-02-01', 5.50),
(4, 7, '2024-02-01', 6.50),
(5, 1, '2024-02-01', 4.90),
(6, 3, '2024-02-01', 2.90),
(7, 10, '2024-02-01', 3.50),
(8, 2, '2024-02-02', 4.50),
(9, 5, '2024-02-02', 4.70),
(10, 8, '2024-02-02', 4.70),
(11, 10, '2024-02-02', 3.50),
(12, 6, '2024-02-02', 5.50),
(13, 1, '2024-02-04', 4.90),
(14, 2, '2024-02-04', 4.50),
(15, 4, '2024-02-04', 2.90),
(16, 4, '2024-02-04', 2.90);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `napoje`
--
ALTER TABLE `napoje`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `transakcje`
--
ALTER TABLE `transakcje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_napoju` (`id_napoju`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `napoje`
--
ALTER TABLE `napoje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `transakcje`
--
ALTER TABLE `transakcje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transakcje`
--
ALTER TABLE `transakcje`
  ADD CONSTRAINT `transakcje_ibfk_1` FOREIGN KEY (`id_napoju`) REFERENCES `napoje` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
