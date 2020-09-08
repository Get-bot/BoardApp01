DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    MID NVARCHAR2(20) CONSTRAINT PK_MEMBER1 PRIMARY KEY,
    MPASSWORD NVARCHAR2(20),
    MNAME NVARCHAR2(10),
    MBIRTH DATE,
    MPHONE NVARCHAR2(20),
    MEMAIL NVARCHAR2(30),
    MPOSTCODE NVARCHAR2(30), 
    MADDRDSS NVARCHAR2(50),
    MDETAILADDRESS NVARCHAR2(50),
    MEXTRAADDRESS NVARCHAR2(50),
    MGENDER NVARCHAR2(10)
    );

SELECT * FROM MEMBER;

DROP TABLE BOARD1;
CREATE TABLE BOARD1(
    BNUMBER NUMBER CONSTRAINT PK_BOARD1 PRIMARY KEY,
    BWRITER NVARCHAR2(20),
    BTITLE NVARCHAR2(50),
    BCONTENTS NVARCHAR2(1000),
    BDATE DATE,
    BHITS NUMBER);

CREATE SEQUENCE BOARD1_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
DROP SEQUENCE BOARD1_SEQ;
    
--ALTER TABLE--
ALTER TABLE BOARD1 ADD BFILENAME NVARCHAR2(50);
ALTER TABLE BOARD1 ADD BPASSWORD NVARCHAR2(50);
ALTER TABLE MEMBER ADD PROFILE NVARCHAR2(50);

COMMIT;    

--CREATE VIEW--
CREATE VIEW BOARDLIST AS SELECT B.*, ROW_NUMBER() OVER(ORDER BY BNUMBER DESC) AS RN FROM BOARD1 B;        

    
    