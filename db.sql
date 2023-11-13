--tb_user
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('f04f684a-797b-4d82-8805-c8887a4eface', 'Alex','Brown', '1977-07-26', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('d1e2c857-2005-4d66-a0a3-b964cc5912ed', 'Maria','Green', '1977-07-26', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('e574e274-c95c-40de-b4c3-40cd11cb7f41', 'João','Silva', '1977-07-26','joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('5ae7e6f7-99f3-48b4-9988-473acd1d2039', 'Ana','Pereira', '1977-07-26','ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES('5dc2689d-0200-4c87-8afe-9e70e89b7a37', 'Joaquim', 'Ferreira', '1977-07-26','joaquim@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);

--tb_role
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('90b81fe6-0a57-4d36-8bd5-482ec042f9cd', 'ROLE_OPERATOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('e5827bd6-4b5d-4e95-a416-0532601bc595', 'ROLE_STUDENT', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('ed16fe0e-b015-451d-a094-279b162ba145', 'ROLE_INSTRUCTOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37742-540c-4751-a2c8-d6675d25ed9f', 'ROLE_ADMIN', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37757-540c-4751-a2c8-d6675d25ed9f', 'ROLE_MASTER', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37757-540c-4751-a2c8-d6675d25ed4r', 'ROLE_USER', now(), 0);

--tb_user_role
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 4);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 4);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 5);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 6);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 4);

--Insert tb_category
INSERT INTO tb_category (code, name, created_at, status) VALUES ('e15b531f-d0cf-44fe-b6d5-ee4410a2d6f0', 'Books', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('edbab41d-80ce-4bec-a166-f129a6b295fc', 'Eletronics', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Computes', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Compras', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Alimentação', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Salário', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Carro', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Lazer', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-48b2-4456-90e0-612e485810d1', 'Estudos', now(), 'ENABLED');

--Insert tb_room
INSERT INTO tb_room (roomId, name, seats, created_at, active ) VALUES('fd1616cf-38b2-40d0-8241-96ebd303435d', 'Room 01', 6, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96ebd374435d', 'Room 02', 3, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96eb2303435d', 'Room 03', 2, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96e89303435d', 'Room 04', 7, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96e54308735d', 'Room 05', 6, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96ebd301235d', 'Room 06', 7, NOW(), 'TRUE');
INSERT INTO tb_room (roomId, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96ebd305435d', 'Room 07', 8, NOW(), 'TRUE');