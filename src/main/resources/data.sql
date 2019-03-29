insert into users(id, email ,name, comment,  passwd, regdate) values (1, 'counterchord89@gmail.com', '민경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (2, 'counterchord79@gmail.com', '김경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (3, 'counterchord69@gmail.com', '박경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (4, 'counterchord59@gmail.com', '이경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (5, 'counterchord49@gmail.com', '홍경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (6, 'counterchord39@gmail.com', '서경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (7, 'counterchord29@gmail.com', '최경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (8, 'counterchord19@gmail.com', '송경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (9, 'counterchord09@gmail.com', '조경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());
insert into users(id, email ,name, comment,  passwd, regdate) values (10, 'counterchord99@gmail.com', '임경수', '만나서 반가워요', '{bcrypt}$2a$10$cSJx.TaMP5iKxX2a5omtrulHsNPSsVhtdx.lzS/RO2i24dQuKlOTC', now());

insert into books(id, isbn ,title, author,  translator, thumbnail_image, publisher) values (1, '9788968481475', '이것이 자바다', '신용권','-', 'http://www.hanbit.co.kr/data/books/B1460673937_l.jpg', '한빛미디어');
insert into books(id, isbn ,title, author,  translator, thumbnail_image, publisher) values (2, '9788968481476', '이것도 자바다', '신용만','-', 'http://www.hanbit.co.kr/data/books/B1460673937_l.jpg', '두빛미디어');
insert into books(id, isbn ,title, author,  translator, thumbnail_image, publisher) values (3, '9788968481477', '이것은 자바다', '신용훈','-', 'http://www.hanbit.co.kr/data/books/B1460673937_l.jpg', '세빛미디어');
insert into books(id, isbn ,title, author,  translator, thumbnail_image, publisher) values (4, '9788968481478', '이것만이 자바다', '신용수','-', 'http://www.hanbit.co.kr/data/books/B1460673937_l.jpg', '네빛미디어');
insert into books(id, isbn ,title, author,  translator, thumbnail_image, publisher) values (5, '9788968481479', '이것까지 자바다', '신용민','-', 'http://www.hanbit.co.kr/data/books/B1460673937_l.jpg', '오빛미디어');

insert into roles(id, name) values(1, 'ADMIN');
insert into roles(id, name) values(2, 'USER');

insert into user_roles(user_id, role_id) values (1, 1);
insert into user_roles(user_id, role_id) values (1, 2);
insert into user_roles(user_id, role_id) values (2, 2);
insert into user_roles(user_id, role_id) values (3, 2);
insert into user_roles(user_id, role_id) values (4, 2);
insert into user_roles(user_id, role_id) values (5, 2);
insert into user_roles(user_id, role_id) values (6, 2);
insert into user_roles(user_id, role_id) values (7, 2);
insert into user_roles(user_id, role_id) values (8, 2);
insert into user_roles(user_id, role_id) values (9, 2);
insert into user_roles(user_id, role_id) values (10, 2);

insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(1, '2019-03-25 23:59:59', '2019-04-23 23:59:59',30, 1,  '읽는중', 1, 1);
insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(2, '2019-03-26 23:59:59', '2019-04-24 23:59:59',30, 1,  '읽는중', 2, 2);
insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(3, '2019-03-27 23:59:59', '2019-04-25 23:59:59',30, 0,  '읽는중', 3, 3);
insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(4, '2019-03-28 23:59:59', '2019-04-26 23:59:59',30, 1,  '읽는중', 4, 4);
insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(5, '2019-03-29 23:59:59', '2019-04-27 23:59:59',30, 1,  '읽는중', 5, 5);
insert into challenges(id, start_date, end_date, days, visibility, status, user_id, book_id) values(6, '2019-03-29 23:59:59', '2019-04-27 23:59:59',30, 0,    '완료', 1, 1);

insert into diaries(id, day, content,  challenge_id) values(1, 1, '자바 존나 어렵네',  1);
insert into diaries(id, day, content,  challenge_id) values(2, 1, '자바 겁나 어렵네',  1);
insert into diaries(id, day, content,  challenge_id) values(3, 1, '자바 지젼 어렵네',  3);
insert into diaries(id, day, content,  challenge_id) values(4, 1, '자바 어렵네',  4);
insert into diaries(id, day, content,  challenge_id) values(5, 1, '자바 존나 쉽네',  5);