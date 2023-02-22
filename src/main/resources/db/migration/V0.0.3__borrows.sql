CREATE TABLE borrows (
    BORROW_ID bigint PRIMARY KEY,
    BOOK_ID bigint,
    MEMBER_ID bigint,
    BORROW_DATE date,
    RETURN_DATE date,
    TERM int,
    FOREIGN KEY (BOOK_ID) REFERENCES books(BOOK_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MEMBER_ID) REFERENCES members(MEMBER_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CREATED_AT DATETIME,
    UPDATED_AT DATETIME
);