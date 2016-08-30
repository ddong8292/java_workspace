select g.TITLE, m.title, m.movie_id, m.openday, m.showtime from movie m, genre g
where m.genre_id=g.genre_id;

insert into genre (genre_id, title);

--기존테이블 수정 DDL,DML,DCL

ALTER TABLE movie 
add img varchar2(50);

update movie set img='movie_default.png'
where movie_id >=21;

