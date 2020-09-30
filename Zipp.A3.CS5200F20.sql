--
-- File generated with SQLiteStudio v3.2.1 on Sun Sep 27 19:22:03 2020
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Author
CREATE TABLE Author (
    aid INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    certifications TEXT CHECK (certifications IN ('PMP', 'CBAP', 'CSM', 'CSTE', 'CAP')),
    bio TEXT);

-- Table: course
CREATE TABLE course (number TEXT PRIMARY KEY, title TEXT, length NUMBER);

-- Table: CourseTopic
CREATE TABLE CourseTopic (
    number TEXT,
    tid NUMBER,
    CONSTRAINT con_CourseTopic PRIMARY KEY (number, tid), 
    FOREIGN KEY (number) REFERENCES course (number) ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (tid) REFERENCES Topic (tid) ON DELETE CASCADE ON UPDATE NO ACTION);

-- Table: Topic
CREATE TABLE Topic (
    tid NUMBER PRIMARY KEY AUTO_INCREMENT,
    aid NUMBER,
    name TEXT, 
    length NUMBER,
    subjectArea TEXT,
    FOREIGN KEY (aid) REFERENCES Author (aid) ON DELETE CASCADE ON UPDATE NO ACTION );

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
