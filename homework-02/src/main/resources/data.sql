INSERT INTO authors ( `name`) values
                   ('А.С.Пушкин'),
                   ('Л.Н.Толстой'),
                   ('Л.М.Олкотт');

INSERT INTO genres (`genre_title`) values
                   ('поэма'),
                   ('повесть'),
                   ('роман'),
                   ('рассказ'),
                   ('комедия'),
                   ('очерк');

INSERT INTO books (`title`, `author_id`, `genre_id` ) values
                   ('Анна Каренина', 2, 2),
                   ('Маленькие женщины', 3, 2),
                   ('Евгений Онегин', 1, 3);
