CREATE TABLE `urls` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `full_url` varchar(2048) DEFAULT NULL,
                        `short_url` varchar(50) DEFAULT NULL,
                        `creator` varchar(16) DEFAULT NULL,
                        `uses` bigint DEFAULT 0,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `full_url` varchar(2048) DEFAULT NULL,
                       `short_url` varchar(50) DEFAULT NULL,
                       `creator` varchar(16) DEFAULT NULL,
                       `uses` bigint DEFAULT 0,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;