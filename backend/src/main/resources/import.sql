--tb_user
INSERT INTO tb_user (user_id, first_name, last_name, email) VALUES('84794b77-dd91-4050-9831-7de6007d103e', 'Alex', 'Brown', 'alex@gmail.com');
INSERT INTO tb_user (user_id, first_name, last_name, email) VALUES('d477f8ca-ff5b-4eff-a66e-fd83b102371b', 'Claudio', 'Cardoso', 'claudio.c.lima@hormail.com');

--Insert tb_category
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('e15b531f-d0cf-44fe-b6d5-ee4410a2d6f0', 'Books', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('edbab41d-80ce-4bec-a166-f129a6b295fc', 'Eletronics', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('74fd5bd5-dcbc-41b5-8b5a-3282e366e00a', 'Computes', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('a4e7673a-3f4b-4ac1-a49a-59549e59523e', 'Compras', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('74d420cd-7b94-48b6-b9ed-2d52aa95be74', 'Alimentação', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('6d9fa7a0-084c-4a8d-ab05-656c2b73429b', 'Salário', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('5efac57a-8ec1-4f45-86cb-eedc299c53e9', 'Carro', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('f997072a-4997-4936-8b26-578b4c80f64c', 'Lazer', now(), 1);
INSERT INTO tb_category (category_id, name, created_at, active) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Estudos', now(), 1);

--Insert tb_room
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96ebd303435d', 'Room 01', 6, NOW(), 1);
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('9591c390-7acc-47c0-96bf-9490ee055783', 'Room 02', 3, NOW(), 1);

--Insert tb_allocation
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('b3d10688-9183-4432-a0f7-c45c56425405', 'Subject 01', '2023-11-27T11:54:28.480Z', '2023-11-27T11:54:28.480Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');