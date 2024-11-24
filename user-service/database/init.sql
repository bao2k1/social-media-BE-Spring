-- Create the users table if it does not exist
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Insert mock users into the users table
INSERT INTO users (id, username, password) VALUES
(1, 'user1', 'pass1'),
(2, 'user2', 'pass2');
