-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table work.address: ~30 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`id`, `street`, `city`, `country`, `number`, `zipcode`) VALUES
	(1, 'sad', 'ád', 1, 'ád', 'ád'),
	(2, 'Street B', 'City B', 2, '456', '67890'),
	(3, 'Street C', 'City C', 3, '789', '54321'),
	(4, 'Street D', 'City D', 4, '321', '98765'),
	(5, 'Street E', 'City E', 5, '654', '11223'),
	(6, 'Street F', 'City F', 6, '987', '44556'),
	(7, 'Street G', 'City G', 7, '147', '77889'),
	(8, 'Street H', 'City H', 8, '258', '99001'),
	(9, 'Street I', 'City I', 9, '369', '12346'),
	(10, 'Street J', 'City J', 10, '159', '65432'),
	(11, 'Street K', 'City K', 11, '753', '88776'),
	(12, 'Street L', 'City L', 12, '852', '99887'),
	(13, 'Street M', 'City M', 13, '951', '33445'),
	(14, 'Street N', 'City N', 14, '147', '22112'),
	(15, 'Street O', 'City O', 15, '258', '77665'),
	(16, 'Street P', 'City P', 16, '369', '66554'),
	(17, 'Street Q', 'City Q', 17, '159', '55443'),
	(18, 'Street R', 'City R', 18, '753', '44332'),
	(19, 'Street S', 'City S', 19, '852', '33221'),
	(20, 'Street T', 'City T', 20, '951', '22110'),
	(21, 'Street U', 'City U', 21, '741', '99900'),
	(22, 'Street V', 'City V', 22, '852', '88811'),
	(23, 'ád', 'sda', 2, 'sad', 'ád'),
	(24, 'Street X', 'City X', 24, '147', '66633'),
	(25, 'Street Y', 'City Y', 25, '258', '55544'),
	(26, 'Street Z', 'City Z', 26, '369', '44455'),
	(27, 'Street AA', 'City AA', 27, '951', '33366'),
	(28, 'Street BB', 'City BB', 28, '753', '22277'),
	(29, 'Street CC', 'City CC', 29, '852', '11188'),
	(30, 'Street DD', 'City DD', 30, '963', '00099');

-- Dumping data for table work.candidate: ~28 rows (approximately)
DELETE FROM `candidate`;
INSERT INTO `candidate` (`id`, `dob`, `email`, `full_name`, `phone`, `address`) VALUES
	(1, '2024-12-14', 'minhthat9090@gmail.com', '21321', '123', 1),
	(2, '2024-12-14', 'anhtuan4026@gmail.com', 'anh tuan', '0825371577', 23),
	(3, '2000-01-01', 'user3@gmail.com', 'Candidate 3', '1234567890', 3),
	(4, '2000-02-02', 'user4@gmail.com', 'Candidate 4', '1234567891', 4),
	(5, '2000-03-03', 'user5@gmail.com', 'Candidate 5', '1234567892', 5),
	(6, '2000-04-04', 'user6@gmail.com', 'Candidate 6', '1234567893', 6),
	(7, '2000-05-05', 'user7@gmail.com', 'Candidate 7', '1234567894', 7),
	(8, '2000-06-06', 'user8@gmail.com', 'Candidate 8', '1234567895', 8),
	(9, '2000-07-07', 'user9@gmail.com', 'Candidate 9', '1234567896', 9),
	(10, '2000-08-08', 'user10@gmail.com', 'Candidate 10', '1234567897', 10),
	(11, '2000-09-09', 'user11@gmail.com', 'Candidate 11', '1234567898', 11),
	(12, '2000-10-10', 'user12@gmail.com', 'Candidate 12', '1234567899', 12),
	(13, '2000-11-11', 'user13@gmail.com', 'Candidate 13', '1234567800', 13),
	(14, '2000-12-12', 'user14@gmail.com', 'Candidate 14', '1234567801', 14),
	(15, '2001-01-01', 'user15@gmail.com', 'Candidate 15', '1234567802', 15),
	(16, '2001-02-02', 'user16@gmail.com', 'Candidate 16', '1234567803', 16),
	(17, '2001-03-03', 'user17@gmail.com', 'Candidate 17', '1234567804', 17),
	(18, '2001-04-04', 'user18@gmail.com', 'Candidate 18', '1234567805', 18),
	(19, '2001-05-05', 'user19@gmail.com', 'Candidate 19', '1234567806', 19),
	(20, '2001-06-06', 'user20@gmail.com', 'Candidate 20', '1234567807', 20),
	(21, '2001-07-07', 'user21@gmail.com', 'Candidate 21', '1234567808', 21),
	(22, '2001-08-08', 'user22@gmail.com', 'Candidate 22', '1234567809', 22),
	(24, '2001-10-10', 'user24@gmail.com', 'Candidate 24', '1234567811', 24),
	(25, '2001-11-11', 'user25@gmail.com', 'Candidate 25', '1234567812', 25),
	(26, '2001-12-12', 'user26@gmail.com', 'Candidate 26', '1234567813', 26),
	(27, '2002-01-01', 'user27@gmail.com', 'Candidate 27', '1234567814', 27),
	(28, '2002-02-02', 'user28@gmail.com', 'Candidate 28', '1234567815', 28),
	(29, '2002-03-03', 'user29@gmail.com', 'Candidate 29', '1234567816', 29);

-- Dumping data for table work.candidate_skill: ~0 rows (approximately)
DELETE FROM `candidate_skill`;

-- Dumping data for table work.company: ~1 rows (approximately)
DELETE FROM `company`;
INSERT INTO `company` (`comp_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `address`) VALUES
	(123, '231', 'mthat456@gmail.com', 'That909kk', '0825371577', 'ww.that909kk.com', 1);

-- Dumping data for table work.job: ~0 rows (approximately)
DELETE FROM `job`;

-- Dumping data for table work.job_candidate: ~9 rows (approximately)
DELETE FROM `job_candidate`;
INSERT INTO `job_candidate` (`job_posting_id`, `candidate_id`) VALUES
	(12334, 1),
	(12334, 2),
	(12336, 2),
	(12335, 11),
	(12336, 11),
	(12334, 18),
	(12334, 22),
	(12335, 22),
	(12336, 22);

-- Dumping data for table work.job_posting: ~4 rows (approximately)
DELETE FROM `job_posting`;
INSERT INTO `job_posting` (`id`, `description`, `expires_at`, `job_type`, `posted_at`, `title`, `company_id`, `position`, `required_skills`, `status`, `suggested_salary`, `year_of_experience`, `quantity`) VALUES
	(12334, '21312', '2024-12-14', 'FULL_TIME', '2024-12-14', 'Java Intren', 123, 'manager', 'comunication', b'1', 2000000, 2, 2),
	(12335, 'Do anything about IT job', '2024-12-29', NULL, '2024-12-14', 'IT Job', 123, 'Director', 'java, SQL', b'1', 90000000, 0, 2),
	(12336, 'IT Job for everyone', '2024-12-18', NULL, '2024-12-15', 'Hello', 123, 'Director', 'Python, C#', b'1', 900000, 4, 6),
	(12338, 'Have a good time with us. Helllo', '2025-01-04', NULL, '2024-12-15', 'IT', 123, 'Manager', 'Java', b'1', 10000000, 5, 3);

-- Dumping data for table work.job_skill: ~0 rows (approximately)
DELETE FROM `job_skill`;

-- Dumping data for table work.skill: ~30 rows (approximately)
DELETE FROM `skill`;
INSERT INTO `skill` (`skill_id`, `skill_description`, `skill_name`, `type`) VALUES
	(1, 'Java dev, untity dev', 'Developer', 1),
	(2, 'Data Analysis', 'Data Analyst', 1),
	(3, 'Front-end development skills', 'Front-end Developer', 2),
	(4, 'Back-end development skills', 'Back-end Developer', 1),
	(5, 'Network Management', 'Network Engineer', 2),
	(6, 'Software Testing', 'QA Tester', 1),
	(7, 'Cloud and DevOps', 'Cloud Engineer', 2),
	(8, 'UX/UI Design', 'UI/UX Designer', 2),
	(9, 'Cybersecurity Skills', 'Security Analyst', 1),
	(10, 'Database Administration', 'DBA', 2),
	(11, 'Machine Learning', 'ML Engineer', 1),
	(12, 'Artificial Intelligence', 'AI Engineer', 2),
	(13, 'Python Development', 'Python Developer', 1),
	(14, 'Java Development', 'Java Developer', 1),
	(15, 'Technical Writing', 'Content Writer', 2),
	(16, 'Business Analysis', 'Business Analyst', 2),
	(17, 'HR Skills', 'HR Specialist', 1),
	(18, 'Project Management', 'Project Manager', 1),
	(19, 'Technical Support', 'IT Support', 2),
	(20, 'Mobile Development', 'Mobile Developer', 2),
	(21, 'DevOps Tools', 'DevOps Engineer', 1),
	(22, 'Networking Technologies', 'Network Specialist', 2),
	(23, 'System Administration', 'System Admin', 1),
	(24, 'Cloud Computing', 'Cloud Specialist', 1),
	(25, 'Agile/Scrum Knowledge', 'Agile Specialist', 2),
	(26, 'Data Science', 'Data Scientist', 1),
	(27, 'Kotlin Development', 'Kotlin Developer', 2),
	(28, 'Flutter Development', 'Flutter Developer', 1),
	(29, 'SEO Content Writing', 'SEO Writer', 2),
	(30, 'Web Design', 'Graphic Designer', 2);

-- Dumping data for table work.user: ~3 rows (approximately)
DELETE FROM `user`;
INSERT INTO `user` (`id`, `password`, `role`, `username`, `company_id`, `candidate_id`) VALUES
	(7, '$2a$12$jNrxt1FZKRWAouM5XuKG6uax.ofYSRXiSGAGPFSQhntLFuRA4ORdK', 'ADMIN', 'admin', NULL, 22),
	(8, '$2a$12$jNrxt1FZKRWAouM5XuKG6uax.ofYSRXiSGAGPFSQhntLFuRA4ORdK', 'HR', 'hr1', 123, 15),
	(9, '$2a$12$jNrxt1FZKRWAouM5XuKG6uax.ofYSRXiSGAGPFSQhntLFuRA4ORdK', 'CANDIDATE', 'candidate1', NULL, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
