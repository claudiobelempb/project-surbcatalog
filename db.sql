--tb_user
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('f04f684a-797b-4d82-8805-c8887a4eface', 'Alex','Brown', '1977-07-26', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('d1e2c857-2005-4d66-a0a3-b964cc5912ed', 'Maria','Green', '1977-07-26', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('e574e124-c95c-40de-b4c3-40cd10cb7f41', 'João','Silva', '1977-07-26','joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES ('5ae7e6f7-99f3-00b4-9988-473acd1d2039', 'Ana','Pereira', '1977-07-26','ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (code, first_name, last_name, birth, email, password, created_at, status) VALUES('5dc2689d-0200-4c87-8afe-9e70e89b7a37', 'Joaquim', 'Ferreira', '1977-07-26','joaquim@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);

--tb_role
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('90b81fe6-0a57-4d36-8bd5-002ec042f9cd', 'ROLE_OPERATOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('e5812bd6-4b5d-4e95-a416-0532601bc595', 'ROLE_STUDENT', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('ed16fe0e-b015-451d-a094-129b162ba145', 'ROLE_INSTRUCTOR', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37742-000c-4751-a2c8-d6675d25ed9f', 'ROLE_ADMIN', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37757-000c-4751-a2c8-d6675d25ed9f', 'ROLE_MASTER', now(), 0);
INSERT INTO tb_role (code, authority, created_at, status) VALUES ('5de37757-000c-4751-a2c8-d6675d25ed4r', 'ROLE_USER', now(), 0);

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
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Computes', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Compras', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Alimentação', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Salário', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Carro', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Lazer', now(), 'ENABLED');
INSERT INTO tb_category (code, name, created_at, status) VALUES ('be6caa0c-00b2-4456-90e0-612e005810d1', 'Estudos', now(), 'ENABLED');

--Insert tb_room
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('fd1616cf-38b2-40d0-8241-96ebd303435d', 'Room 01', 6, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('9591c390-7acc-47c0-96bf-9490ee055783', 'Room 02', 3, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('dd668b0d-ccc0-4908-b563-2b135d90700b', 'Room 03', 2, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('0cf6e29d-c845-4fe6-8183-f6451a171f10', 'Room 04', 7, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('44d1b4cf-f591-4a7f-8cc1-5f369a741476', 'Room 05', 6, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('2466cde3-e750-4d24-896c-5acfff0e7be4', 'Room 06', 7, NOW(), 'TRUE');
INSERT INTO tb_room (room_id, name, seats, created_at, active) VALUES('c10fa373-b878-4384-8069-300604dfee0b', 'Room 07', 8, NOW(), 'TRUE');

--Insert tb_allocation
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('b3d10688-9183-4432-a0f7-c45c56420005', 'Reunião A', '2024-10-12T09:00:00.000Z', '2024-10-12T10:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('d477f8ca-ff5b-4eff-a66e-fd83b102371b', 'Reunião B', '2024-10-12T10:00:00.000Z', '2024-10-12T11:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('d3db3190-5f3c-4dc0-94ee-835602912ffe', 'Reunião C', '2024-10-12T11:00:00.000Z', '2024-10-12T12:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('c0197cb7-4df5-4785-bae5-c9421f87744d', 'Reunião D', '2024-10-12T11:00:00.000Z', '2024-10-12T13:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('a7940006-7eab-4cb3-8ded-9061bfe5ff0b', 'Reunião E', '2024-10-12T13:00:00.000Z', '2024-10-12T14:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('de822194-c9ba-4646-968c-774b6d9e6a68', 'Reunião F', '2024-10-12T14:00:00.000Z', '2024-10-12T15:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('c25fb313-8655-4f7b-b845-14b9faed59b0', 'Reunião G', '2024-10-12T15:00:00.000Z', '2024-10-12T16:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('d1a50882-37f3-4126-8f2d-bc0061d5fa06', 'Reunião H', '2024-10-12T16:00:00.000Z', '2024-10-12T17:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('2c519cc9-0626-49ae-b974-a39c2d538387', 'Reunião I', '2024-10-12T17:00:00.000Z', '2024-10-12T18:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');
INSERT INTO tb_allocation (allocation_id, subject, start_at, end_at, created_at, active, user_id, room_id) VALUES('ddeb82bd-ce86-4156-88c0-34d5745f496d', 'Reunião J', '2024-10-12T18:00:00.000Z', '2024-10-12T19:00:00.000Z', NOW(), 1, '84794b77-dd91-4050-9831-7de6007d103e', 'fd1616cf-38b2-40d0-8241-96ebd303435d');

