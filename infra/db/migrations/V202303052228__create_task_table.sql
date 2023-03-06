create table if not exists tasks(
    id uuid primary key default gen_random_uuid(),
    title text not null,
    description text,
    due_date timestamp with time zone,
    status text,
    user_id uuid not null
);