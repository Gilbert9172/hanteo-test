SET NAMES utf8mb4;

CREATE TABLE `category` (
                            `id` bigint NOT NULL,
                            `title` varchar(36) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category_seq` (
                                `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO category_seq (next_val)  values (16);

INSERT INTO category values (1, '남자');
INSERT INTO  category values (2 ,'여자');
INSERT INTO  category values (3 ,'엑소');
INSERT INTO  category values (4 ,'방탄소년단');
INSERT INTO  category values (5 ,'블랙핑크');
INSERT INTO  category values (6 ,'공지사항');
INSERT INTO  category values (7 ,'첸');
INSERT INTO  category values (8 ,'백현');
INSERT INTO  category values (9 ,'시우민');
INSERT INTO  category values (10 ,'공지사항');
INSERT INTO  category values (11 ,'익명게시판');
INSERT INTO  category values (12 ,'뷔');
INSERT INTO  category values (13 ,'공지사항');
INSERT INTO  category values (14 ,'익명게시판');
INSERT INTO  category values (15 ,'로제');

CREATE TABLE `category_relation_seq` (
                                `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO category_relation_seq (next_val)  values (24);

CREATE TABLE `category_relation` (
                                     `id` bigint NOT NULL,
                                     `category_id` bigint NOT NULL,
                                     `child_id` bigint DEFAULT NULL,
                                     `parent_idx` bigint DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `FKm7xecotghl6ptvn2f5qpa4u7e` (`category_id`),
                                     KEY `FKqkxedl03q5sibywpc12n4v0gv` (`child_id`),
                                     KEY `FKdhyb3yx254msc4ki40vdcr16o` (`parent_idx`),
                                     CONSTRAINT `FKdhyb3yx254msc4ki40vdcr16o` FOREIGN KEY (`parent_idx`) REFERENCES `category` (`id`),
                                     CONSTRAINT `FKm7xecotghl6ptvn2f5qpa4u7e` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
                                     CONSTRAINT `FKqkxedl03q5sibywpc12n4v0gv` FOREIGN KEY (`child_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (1, 1, null, 3);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (2 , 1, null, 4);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (3 , 2, null, 5);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (4 , 3, 1, 6);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (5 , 3, 1, 7);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (6 , 3, 1, 8);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (7 , 3, 1, 9);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (8 , 4, 1, 10);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (9 , 4, 1, 11);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (10, 4, 1, 12);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (11, 5, 2, 13);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (12, 5, 2, 14);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (13, 5, 2, 15);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (14, 6, 3, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (15, 7, 3, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (16, 8, 3, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (17, 9, 3, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (18, 10, 4, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (19, 11, 4, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (20, 12, 4, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (21, 13, 5, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (22, 14, 5, null);
INSERT INTO category_relation (id, category_id, parent_idx, child_id) values (23, 15, 5, null);
