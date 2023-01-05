-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jan 2023 pada 17.30
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `game_leaderboard2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `leaderboard`
--

CREATE TABLE `leaderboard` (
  `Nama` varchar(50) NOT NULL,
  `Score` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `leaderboard`
--

INSERT INTO `leaderboard` (`Nama`, `Score`) VALUES
('Lava', 5),
('lava', 0),
('l', 0),
('el', 0),
('lv', 5),
('el', 10),
('el', 5),
('lavahard', 0),
('lava', 0),
('null', 32),
('null', 16),
('null', 0),
('null', 0),
('null', 0),
('null', 20),
('lava', 144),
('hard', 130),
('null', 130),
('hard1', 50),
('null', 50),
('null', 50),
('null', 110),
('null', 70),
('rara', 70),
('rara', 110),
('lava', 56),
('kentangrebus', 50),
('eci', 10),
('null', 0),
('null', 0),
('null', 25);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
