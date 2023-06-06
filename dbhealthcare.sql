-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 18, 2023 at 08:19 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhealthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `diease`
--

CREATE TABLE `diease` (
  `Diease_ID` int(11) NOT NULL,
  `Doctor_ID` int(11) NOT NULL,
  `Doctor_Name` varchar(100) NOT NULL,
  `Specialist` varchar(50) NOT NULL,
  `Complaint` text NOT NULL,
  `Diagnose` varchar(200) NOT NULL,
  `Receipt` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diease`
--

INSERT INTO `diease` (`Diease_ID`, `Doctor_ID`, `Doctor_Name`, `Specialist`, `Complaint`, `Diagnose`, `Receipt`) VALUES
(7, 191001, 'Ngurah Surya Adi Sentana', 'Dentist', 'Nosebleed', 'Tired of daily activities', 'Compress with cold water'),
(8, 191004, 'Mahen Gaharu Adyatma', 'General Practitioner', 'Dizzy', 'Headache or Stress', 'Aspirin for mild to moderate headache, Indomethacin'),
(9, 191001, 'Ngurah Surya Adi Sentana', 'Dentist', 'Gum pain', 'Gingivitis', 'Ibuprofen (relieve pain in the gums), Antibiotic (Gingivitis medication caused by a bacterial infection), Chlorhexidine (Medication to treat inflammation and swelling of the gums)'),
(15, 191003, 'Diksa Farel', 'Ophtalmologist', 'blurry when looking at distant objects', 'Miopi	', 'Check to ophthalmologists directly for checking the miopi and to choose glass lens'),
(16, 191003, 'Diksa Farel', 'Ophtalmologist', 'difficulty or blurry when seeing objects that are close', 'Hipermitopi', 'Go to ophthalmologists and choose glass lens'),
(17, 191003, 'Diksa Farel', 'Ophtalmologist', 'blurred or distorted vision. Eyes feel uncomfortable. Eyes feel strained', 'Astigmatisme', 'Medical check to ophthalmologists dan get the right glass lenses'),
(18, 191002, 'Arya Regana', 'Pediatric', 'abdominal pain and frequent bowel movements', 'diarrhea', 'Oralit, Hot  Ginger, Plain Yogurt and Lacto-B'),
(19, 191002, 'Arya Regana', 'Pediatric', 'appeared red spots on the skin and watery', 'chicken pox', 'Paracetamol, Isprinol, Isoprinosine, Dextamine Syrup, Acyclovir'),
(20, 191005, 'Yulia Febryanthi Setiawan Putri', 'Neurologist', 'Part of body feels numb', 'Stroke', 'Require referral to hospital');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_profile`
--

CREATE TABLE `doctor_profile` (
  `Doctor_ID` int(11) NOT NULL,
  `Specialist` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Joined_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor_profile`
--

INSERT INTO `doctor_profile` (`Doctor_ID`, `Specialist`, `Email`, `Joined_Date`) VALUES
(191001, 'Dentist', 'suryaadisentana@gmail.com', '2016-01-14'),
(191002, 'Pediatric', 'aryaregan@gmail.com', '2012-11-22'),
(191003, 'Ophtalmologist', 'diksa@gmail.com', '2018-02-09'),
(191004, 'General Practitioner', 'mahenadyatma@gmail.com', '2016-04-09'),
(191005, 'Neurologist', 'yulia@gmail.com', '2018-06-06');

-- --------------------------------------------------------

--
-- Table structure for table `patient_data`
--

CREATE TABLE `patient_data` (
  `Patient_ID` int(11) NOT NULL,
  `Patient_Name` varchar(100) NOT NULL,
  `Patient_Birth` date NOT NULL,
  `Patient_Gender` varchar(10) NOT NULL,
  `Patient_Complaint` text NOT NULL,
  `Patient_CheckUpDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient_data`
--

INSERT INTO `patient_data` (`Patient_ID`, `Patient_Name`, `Patient_Birth`, `Patient_Gender`, `Patient_Complaint`, `Patient_CheckUpDate`) VALUES
(1, 'yulia', '2022-12-01', 'Woman', 'headache', '2022-12-06'),
(2, 'putra', '2002-07-06', 'Man', 'Nosebleed', '2022-12-06'),
(3, 'Narendra', '2022-12-01', 'Man', 'Hidung tersumbat', '2022-12-11'),
(4, 'Sri Rasmiani Putri', '2022-12-01', 'Woman', 'headache', '2022-12-29'),
(5, 'Sri Rasmiani Putri', '2022-12-01', 'Woman', 'pilek', '2022-12-29'),
(6, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Gum pain', '2023-01-10'),
(7, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Gum pain', '2023-01-10'),
(8, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Gum pain', '2023-01-10'),
(9, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Dizzy', '2023-01-10'),
(10, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Nosebleed', '2023-01-10'),
(11, 'Hening Triswari', '2003-01-16', 'Woman', 'Dizzy', '2023-01-10'),
(12, 'Dandi Febryansyah', '2007-02-14', 'Man', 'Dizzy', '2023-01-10'),
(13, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'Nosebleed', '2023-01-12'),
(14, 'Nadiska Cahya', '2005-05-18', 'Woman', 'Gum pain', '2023-01-17'),
(15, 'Rasya Farelsyah', '2003-01-07', 'Man', 'Dizzy', '2023-01-17'),
(16, 'Nandika Ramayana', '2003-06-10', 'Man', 'Gum pain', '2023-01-17'),
(17, 'Maria Aprilia', '2003-04-02', 'Woman', 'Dizzy', '2023-01-17'),
(18, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'blurry when looking at distant objects', '2023-01-17'),
(19, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'abdominal pain and frequent bowel movements', '2023-01-18'),
(20, 'Hening Triswari', '2003-01-16', 'Woman', 'blurry when looking at distant objects', '2023-01-18'),
(21, 'Sri Rasmiani Putri', '2002-12-16', 'Woman', 'blurry when looking at distant objects', '2023-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `Role` varchar(20) NOT NULL,
  `Full_Name` varchar(100) NOT NULL,
  `DateofBirth` date NOT NULL,
  `Phone_Number` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Confirm_Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`Role`, `Full_Name`, `DateofBirth`, `Phone_Number`, `Email`, `Address`, `Password`, `Confirm_Password`) VALUES
('Dokter', 'Arya Regana', '2004-12-03', '0883618381', 'aryaregan@gmail.com', 'Medan', 'arya123', 'arya123'),
('Pasien', 'Dandi Febryansyah Valentino', '2007-02-14', '089746253617', 'dandi@gmail.com', 'Jln Raya Diponegoro', '1234', '1234'),
('Dokter', 'Diksa Farel', '1999-10-06', '089162816826', 'diksa@gmail.com', 'Jln Kamboja', 'diksa123', 'diksa123'),
('Pasien', 'Arya Gumilang', '2002-10-15', '089261738134', 'gumilang34@gmail.com', 'Badung, Bali', 'arya123', 'arya123'),
('Pasien', 'Hening Triswari', '2003-01-16', '089164728113', 'hening@gmail.com', 'Jln. Taman Baruna', 'hening123', 'hening123'),
('Dokter', 'Mahen Gaharu Adyatma Satya', '1995-01-27', '086728173668', 'mahenadyatma@gmail.com', 'Jln Raden Saleh Barat , Sumatera UtaraNo.24, Indonesia', 'mahen123', 'mahen123'),
('Pasien', 'Maria Aprilia Sain', '2003-04-02', '083721472913', 'maria@gmail.com', 'Jln. Raya Sesetan No 34', '12345', '12345'),
('Pasien', 'Nadiska Cahya', '2005-05-18', '086372819563', 'nadiska@gmail.com', 'Jln. Tukad Yeh Aya No 16', '123', '123'),
('Pasien', 'Nandika Ramayana Dharmaveda', '2003-06-10', '086273462174', 'nandika@gmail.com', 'Jln Tukad Balian Denpasar', '1234', '1234'),
('Pasien', 'Putra Wiryanata', '2002-07-06', '08628261363', 'putra@gmail.com', 'Denpasar', 'putra123', 'putra123'),
('Pasien', 'Sri Rasmiani Putri', '2002-12-16', '089617372183', 'putri@gmail.com', 'klungkung', 'putri123', 'putri123'),
('Pasien', 'Rasya Farelsyah Maheswara', '2003-01-07', '086372462174', 'rasya@gmail.com', 'Jln. Tukad Badung No 56 ', '1234', '1234'),
('Pasien', 'Ridho Munasri', '2002-05-07', '089362818361', 'ridho@gmail.com', 'tabanan', 'ridho123', 'ridho123'),
('Pasien', 'Sonia', '2002-10-17', '089271322', 'sonia@gmail.com', 'Gianyar', 'sonia123', 'sonia123'),
('Dokter', 'Ngurah Surya Adi Sentana', '2003-02-08', '086271813174', 'suryaadisentana@gmail.com', 'Denpasar Barat', 'ngurah123', 'ngurah123'),
('Dokter', 'Yulia Febryanthi Setiawan Putri', '2003-08-02', '0891638139', 'yulia@gmail.com', 'Jln Raya Pemogan', 'yulia123', 'yulia123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diease`
--
ALTER TABLE `diease`
  ADD PRIMARY KEY (`Diease_ID`),
  ADD KEY `fk_diease` (`Doctor_ID`);

--
-- Indexes for table `doctor_profile`
--
ALTER TABLE `doctor_profile`
  ADD PRIMARY KEY (`Doctor_ID`),
  ADD KEY `fk_doctor_profile` (`Email`);

--
-- Indexes for table `patient_data`
--
ALTER TABLE `patient_data`
  ADD PRIMARY KEY (`Patient_ID`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diease`
--
ALTER TABLE `diease`
  MODIFY `Diease_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `patient_data`
--
ALTER TABLE `patient_data`
  MODIFY `Patient_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diease`
--
ALTER TABLE `diease`
  ADD CONSTRAINT `fk_diease` FOREIGN KEY (`Doctor_ID`) REFERENCES `doctor_profile` (`Doctor_ID`);

--
-- Constraints for table `doctor_profile`
--
ALTER TABLE `doctor_profile`
  ADD CONSTRAINT `fk_doctor_profile` FOREIGN KEY (`Email`) REFERENCES `register` (`Email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
