--tb_user
INSERT INTO tb_user (user_id, api_key, first_name, last_name, email, active, created_at, updated_at) VALUES('84794b77-dd91-4050-9831-7de6007d103e', 'd4c0e714-1297-4c11-9805-f6ad10cab6bf', 'Alex', 'Brown', 'alex@gmail.com', 1, NOW(), NOW());
INSERT INTO tb_user (user_id, api_key, first_name, last_name, email, active, created_at, updated_at) VALUES('d477f8ca-ff5b-4eff-a66e-fd83b102371b', 'ecf978fc-2087-440c-848b-2b0452c00b31', 'Claudio', 'Cardoso', 'claudio.c.lima@hormail.com', 1, NOW(), NOW());

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

