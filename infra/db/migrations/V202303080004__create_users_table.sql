-- Whenever you need to reference the user in some other table, use this table. That way, when you need to erase user data, you don't need to cascade erase data.
create table if not exists users_identifiers (
    id uuid primary key default gen_random_uuid()
);

-- Never create relationship between this table and any other.
create table if not exists users_data (
    id uuid unique not null,
    name text,
    email text unique not null,
    constraint fk_id_users_identifiers_id foreign key (id) references users_identifiers(id)
);