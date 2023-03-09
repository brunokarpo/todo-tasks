insert into users_identifiers (id) values ('c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2');
insert into users_data (id, name, email) values ('c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2', 'Alice', 'alice@example.com');

insert into users_identifiers (id) values ('d2b66bc6-56c6-4ef6-b166-3f4aa9651dfc');
insert into users_data (id, name, email) values ('d2b66bc6-56c6-4ef6-b166-3f4aa9651dfc', 'Bob', 'bob@example.com');

INSERT INTO tasks (id, title, description, due_date, status, user_id) VALUES
    ('c67620e7-9832-4c8b-91ad-6efed7a9aa3a', 'Comprar leite', 'Ir ao supermercado e comprar 1 litro de leite integral', '2023-03-08 10:00:00-03', 'TODO', 'c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2'),
    ('75b1c1d8-d28f-4b35-a09b-9f9bc778008d', 'Fazer exercício', 'Fazer 30 minutos de caminhada no parque', '2023-03-07 18:00:00-03', 'IN_PROGRESS', 'd2b66bc6-56c6-4ef6-b166-3f4aa9651dfc'),
    ('089cd1cf-6d36-4e5f-9f0e-f5a5b5d5b1c5', 'Ler livro', 'Ler o capítulo 3 do livro "O Hobbit"', '2023-03-10 15:30:00-03', 'TODO', 'c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2'),
    ('37a51d7c-35c9-49a1-97de-c9d802a8b45f', 'Fazer compras', 'Ir ao mercado e comprar frutas, verduras e carne para a semana', '2023-03-09 11:00:00-03', 'TODO', 'd2b66bc6-56c6-4ef6-b166-3f4aa9651dfc'),
    ('d98d8e7d-b00f-41de-853d-962f76cfa0a9', 'Estudar Kotlin', 'Ler a documentação do Kotlin e fazer alguns exercícios', '2023-03-07 14:00:00-03', 'DONE', 'c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2');
