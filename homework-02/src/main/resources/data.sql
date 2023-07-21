INSERT INTO authors (id, `name`) values
                   (1, 'А.С.Пушкин'),
                   (2, 'Л.Н.Толстой'),
                   (3,'Л.М.Олкотт');

INSERT INTO genres (id, `genretitle`) values
                   (1, 'поэма'),
                   (2, 'повесть'),
                   (3,'роман'),
                   (4, 'рассказ'),
                   (5, 'комедия'),
                   (6,'очерк');

INSERT INTO books (id, `title`, `authorId`, `genreId` ) values
                   (1, 'Анна Каренина', 2, 2),
                   (2, 'Маленькие женщины', 3, 2),
                   (3,'Евгений Онегин', 1, 3);
