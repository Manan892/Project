-- Database: `library`

CREATE TABLE `login` (
  `id` varchar(10) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `pin` char(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `users` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `Balance` int(11) DEFAULT 500,
  PRIMARY KEY (`id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id`) REFERENCES `login` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `books` (
  `bookId` varchar(8) NOT NULL,
  `title` varchar(50) NOT NULL,
  `author` varchar(30) DEFAULT NULL,
  `lang` varchar(10) NOT NULL,
  `genre` varchar(15) DEFAULT NULL,
  `location` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `records` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) NOT NULL,
  `bookId` varchar(8) NOT NULL,
  `issueDate` date NOT NULL,
  `returnDate` date DEFAULT NULL,
  `due` int(11) DEFAULT 0,
  `dueDate` date DEFAULT (`issueDate` + interval 15 day),
  PRIMARY KEY (`recordId`),
  KEY `userId` (`userId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `records_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  CONSTRAINT `records_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `books` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
