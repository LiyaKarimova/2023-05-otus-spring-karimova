insert into authors(`name`)
values ('Author_1'), ('Author_2'), ('Author_3');

insert into genres(`genretitle`)
values ('Genre_1'), ('Genre_2'), ('Genre_3');

insert into books(`title`, `authorId`, `genreId`)
values ('BookTitle_1', 1, 1), ('BookTitle_2', 2, 2), ('BookTitle_3', 3, 3);