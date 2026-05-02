CREATE TABLE link (
	id SERIAL PRIMARY KEY,
	link TEXT NOT NULL,
	link_description TEXT,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP NOT NULL
);