-- Kết nối đến database webapp_db (nếu cần, tùy thuộc vào công cụ bạn dùng)
-- \connect webapp_db;

-- Xóa các bảng nếu tồn tại (theo thứ tự ngược để xử lý khóa ngoại)
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS classies CASCADE;
DROP TABLE IF EXISTS shools CASCADE;

-- Tạo bảng shools
CREATE TABLE shools (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Tạo bảng classies
CREATE TABLE classies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    school_id BIGINT NOT NULL,
    CONSTRAINT fk_classies_school FOREIGN KEY (school_id) REFERENCES shools(id)
);

-- Tạo bảng students
CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER,
    class_id BIGINT NOT NULL,
    CONSTRAINT fk_students_class FOREIGN KEY (class_id) REFERENCES classies(id)
);