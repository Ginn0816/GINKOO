-- CIPS_902_LIST,CIPS_AUTH 两张表增加 CCY CHAR(3)
ALTER TABLE CIPS_902_LIST ADD CCY CHAR(3);
ALTER TABLE CIPS_AUTH ADD CCY CHAR(3);

COMMENT ON COLUMN CIPS_902_LIST.CCY IS '币种';
COMMENT ON COLUMN CIPS_AUTH.CCY IS '币种'

--报文发送时间扩长
ALTER TABLE CIPS_111 MODIFY CRE_DT_TM CHAR(29);
ALTER TABLE CIPS_112 MODIFY CRE_DT_TM CHAR(29);


--CIPS_111_REMIT的备份和创建
CREATE TABLE CIPS_111_REMIT_BAK202604 AS SELECT * FROM CIPS_111_REMIT;

drop table CIPS_111_REMIT;
-- auto-generated definition
create table CIPS_111_REMIT
(
    SEQ_NO                   CHAR(20) not null
        constraint CIPS_111_REMIT_PK
            primary key,
    CORP_ID                  VARCHAR2(20),
    TXN_SEQ_NO               CHAR(20) not null,
    ORI_SEQ_NO               CHAR(20),
    TXN_DIR                  CHAR,
    SND_ST_BRNO              VARCHAR2(35),
    SND_ST_BRNAME            VARCHAR2(420),
    RCV_ST_BRNO              VARCHAR2(35),
    RCV_ST_BRNAME            VARCHAR2(420),
    SYS_CODE                 CHAR(4),
    SRC_SYS                  CHAR(4),
    DEST_SYS                 CHAR(4),
    MSG_TYPE                 VARCHAR2(20),
    MSG_SND_TIME             CHAR(14),
    MSG_PRIO                 CHAR,
    MSG_ID                   VARCHAR2(35),
    WORK_DATE                CHAR(8),
    COMM_STATUS              CHAR(2),
    PBOC_STATUS              CHAR(4),
    CRE_DT_TM                CHAR(29),
    NB_OF_TXS                VARCHAR2(15),
    STTLM_MTD                CHAR(4),
    INSTR_ID                 VARCHAR2(16),
    END_TO_END_ID            VARCHAR2(35),
    TX_ID                    VARCHAR2(35),
    UETR                     CHAR(36),
    CLR_SYS_REF              VARCHAR2(35),
    SVC_LVL1                 VARCHAR2(4),
    SVC_LVL2                 VARCHAR2(4),
    SVC_LVL3                 VARCHAR2(4),
    SVC_LVLX1                VARCHAR2(35),
    SVC_LVLX2                VARCHAR2(35),
    SVC_LVLX3                VARCHAR2(35),
    CTGY_PURP                VARCHAR2(4),
    CTGY_PURPX               VARCHAR2(35),
    AMT_CURCD                CHAR(3),
    AMT                      NUMBER(18),
    INTR_BK_STTLM_DT         CHAR(8),
    STTLM_PRTY               CHAR(4),
    DBT_DT_TM                CHAR(14),
    CDT_DT_TM                CHAR(14),
    INSTD_AMTX_CURCD         CHAR(3),
    INSTD_AMTX               NUMBER(18, 5),
    XCHG_RATE                NUMBER(11, 10),
    CHRG_BR                  CHAR(4),
    PRE_AGT1_BIC             VARCHAR2(11),
    PRE_AGT1_CLR_SYS         VARCHAR2(5),
    PRE_AGT1_CLR_SYSX        VARCHAR2(35),
    PRE_AGT1_CLR_SYS_MMBID   VARCHAR2(35),
    PRE_AGT1_LEI             VARCHAR2(20),
    PRE_AGT1_NAME            VARCHAR2(420),
    PRE_AGT1_ADR_DEPT        VARCHAR2(210),
    PRE_AGT1_ADR_SDEPT       VARCHAR2(210),
    PRE_AGT1_ADR_STRT_NM     VARCHAR2(210),
    PRE_AGT1_ADR_BLDG_NB     VARCHAR2(16),
    PRE_AGT1_ADR_BLDG_NM     VARCHAR2(105),
    PRE_AGT1_ADR_FLR         VARCHAR2(70),
    PRE_AGT1_ADR_PST_BX      VARCHAR2(16),
    PRE_AGT1_ADR_ROOM        VARCHAR2(210),
    PRE_AGT1_ADR_PST_CD      VARCHAR2(16),
    PRE_AGT1_ADR_TWN         VARCHAR2(105),
    PRE_AGT1_ADR_TWN_LOC     VARCHAR2(105),
    PRE_AGT1_ADR_DSTRCT      VARCHAR2(105),
    PRE_AGT1_ADR_AREA        VARCHAR2(105),
    PRE_AGT1_ADR_CTRY        CHAR(2),
    PRE_AGT1_ADR_ADR_LINE1   VARCHAR2(105),
    PRE_AGT1_ADR_ADR_LINE2   VARCHAR2(105),
    PRE_AGT1_ID              VARCHAR2(34),
    PRE_AGT1_ID_SCHEX        VARCHAR2(35),
    PRE_AGT1_AC_IBAN         VARCHAR2(34),
    PRE_AGT1_AC_ID           VARCHAR2(34),
    PRE_AGT1_AC_ID_SCHE      VARCHAR2(4),
    PRE_AGT1_AC_ID_SCHEX     VARCHAR2(35),
    PRE_AGT1_AC_ID_ISSR      VARCHAR2(35),
    PRE_AGT1_AC_TYPE         VARCHAR2(4),
    PRE_AGT1_AC_TYPEX        VARCHAR2(105),
    PRE_AGT1_AC_CCY          CHAR(3),
    PRE_AGT1_AC_NAME         VARCHAR2(210),
    PRE_AGT1_AC_AKA_ID_TP    VARCHAR2(4),
    PRE_AGT1_AC_AKA_ID_TPX   VARCHAR2(35),
    PRE_AGT1_AC_AKA_ID       VARCHAR2(2048),
    PRE_AGT2_BIC             VARCHAR2(11),
    PRE_AGT2_CLR_SYS         VARCHAR2(5),
    PRE_AGT2_CLR_SYSX        VARCHAR2(35),
    PRE_AGT2_CLR_SYS_MMBID   VARCHAR2(35),
    PRE_AGT2_LEI             VARCHAR2(20),
    PRE_AGT2_NAME            VARCHAR2(420),
    PRE_AGT2_ADR_DEPT        VARCHAR2(210),
    PRE_AGT2_ADR_SDEPT       VARCHAR2(210),
    PRE_AGT2_ADR_STRT_NM     VARCHAR2(210),
    PRE_AGT2_ADR_BLDG_NB     VARCHAR2(16),
    PRE_AGT2_ADR_BLDG_NM     VARCHAR2(105),
    PRE_AGT2_ADR_FLR         VARCHAR2(70),
    PRE_AGT2_ADR_PST_BX      VARCHAR2(16),
    PRE_AGT2_ADR_ROOM        VARCHAR2(210),
    PRE_AGT2_ADR_PST_CD      VARCHAR2(16),
    PRE_AGT2_ADR_TWN         VARCHAR2(105),
    PRE_AGT2_ADR_TWN_LOC     VARCHAR2(105),
    PRE_AGT2_ADR_DSTRCT      VARCHAR2(105),
    PRE_AGT2_ADR_AREA        VARCHAR2(105),
    PRE_AGT2_ADR_CTRY        CHAR(2),
    PRE_AGT2_ADR_ADR_LINE1   VARCHAR2(105),
    PRE_AGT2_ADR_ADR_LINE2   VARCHAR2(105),
    PRE_AGT2_ID              VARCHAR2(34),
    PRE_AGT2_ID_SCHEX        VARCHAR2(35),
    PRE_AGT2_AC_IBAN         VARCHAR2(34),
    PRE_AGT2_AC_ID           VARCHAR2(34),
    PRE_AGT2_AC_ID_SCHE      VARCHAR2(4),
    PRE_AGT2_AC_ID_SCHEX     VARCHAR2(35),
    PRE_AGT2_AC_ID_ISSR      VARCHAR2(35),
    PRE_AGT2_AC_TYPE         VARCHAR2(4),
    PRE_AGT2_AC_TYPEX        VARCHAR2(105),
    PRE_AGT2_AC_CCY          CHAR(3),
    PRE_AGT2_AC_NAME         VARCHAR2(210),
    PRE_AGT2_AC_AKA_ID_TP    VARCHAR2(4),
    PRE_AGT2_AC_AKA_ID_TPX   VARCHAR2(35),
    PRE_AGT2_AC_AKA_ID       VARCHAR2(2048),
    PRE_AGT3_BIC             VARCHAR2(11),
    PRE_AGT3_CLR_SYS         VARCHAR2(5),
    PRE_AGT3_CLR_SYSX        VARCHAR2(35),
    PRE_AGT3_CLR_SYS_MMBID   VARCHAR2(35),
    PRE_AGT3_LEI             VARCHAR2(20),
    PRE_AGT3_NAME            VARCHAR2(420),
    PRE_AGT3_ADR_DEPT        VARCHAR2(210),
    PRE_AGT3_ADR_SDEPT       VARCHAR2(210),
    PRE_AGT3_ADR_STRT_NM     VARCHAR2(210),
    PRE_AGT3_ADR_BLDG_NB     VARCHAR2(16),
    PRE_AGT3_ADR_BLDG_NM     VARCHAR2(105),
    PRE_AGT3_ADR_FLR         VARCHAR2(70),
    PRE_AGT3_ADR_PST_BX      VARCHAR2(16),
    PRE_AGT3_ADR_ROOM        VARCHAR2(210),
    PRE_AGT3_ADR_PST_CD      VARCHAR2(16),
    PRE_AGT3_ADR_TWN         VARCHAR2(105),
    PRE_AGT3_ADR_TWN_LOC     VARCHAR2(105),
    PRE_AGT3_ADR_DSTRCT      VARCHAR2(105),
    PRE_AGT3_ADR_AREA        VARCHAR2(105),
    PRE_AGT3_ADR_CTRY        CHAR(2),
    PRE_AGT3_ADR_ADR_LINE1   VARCHAR2(105),
    PRE_AGT3_ADR_ADR_LINE2   VARCHAR2(105),
    PRE_AGT3_ID              VARCHAR2(34),
    PRE_AGT3_ID_SCHEX        VARCHAR2(35),
    PRE_AGT3_AC_IBAN         VARCHAR2(34),
    PRE_AGT3_AC_ID           VARCHAR2(34),
    PRE_AGT3_AC_ID_SCHE      VARCHAR2(4),
    PRE_AGT3_AC_ID_SCHEX     VARCHAR2(35),
    PRE_AGT3_AC_ID_ISSR      VARCHAR2(35),
    PRE_AGT3_AC_TYPE         VARCHAR2(4),
    PRE_AGT3_AC_TYPEX        VARCHAR2(105),
    PRE_AGT3_AC_CCY          CHAR(3),
    PRE_AGT3_AC_NAME         VARCHAR2(210),
    PRE_AGT3_AC_AKA_ID_TP    VARCHAR2(4),
    PRE_AGT3_AC_AKA_ID_TPX   VARCHAR2(35),
    PRE_AGT3_AC_AKA_ID       VARCHAR2(2048),
    INSTG_AGT_BIC            VARCHAR2(11),
    INSTG_AGT_CLR_SYS        VARCHAR2(5),
    INSTG_AGT_CLR_SYS_MMBID  VARCHAR2(35),
    INSTG_AGT_LEI            VARCHAR2(20),
    INSTD_AGT_BIC            VARCHAR2(11),
    INSTD_AGT_CLR_SYS        VARCHAR2(5),
    INSTD_AGT_CLR_SYS_MMBID  VARCHAR2(35),
    INSTD_AGT_LEI            VARCHAR2(20),
    IM_AGT1_BIC              VARCHAR2(11),
    IM_AGT1_CLR_SYS          VARCHAR2(5),
    IM_AGT1_CLR_SYSX         VARCHAR2(35),
    IM_AGT1_CLR_SYS_MMBID    VARCHAR2(35),
    IM_AGT1_LEI              VARCHAR2(20),
    IM_AGT1_NAME             VARCHAR2(420),
    IM_AGT1_ADR_DEPT         VARCHAR2(210),
    IM_AGT1_ADR_SDEPT        VARCHAR2(210),
    IM_AGT1_ADR_STRT_NM      VARCHAR2(210),
    IM_AGT1_ADR_BLDG_NB      VARCHAR2(16),
    IM_AGT1_ADR_BLDG_NM      VARCHAR2(105),
    IM_AGT1_ADR_FLR          VARCHAR2(70),
    IM_AGT1_ADR_PST_BX       VARCHAR2(16),
    IM_AGT1_ADR_ROOM         VARCHAR2(210),
    IM_AGT1_ADR_PST_CD       VARCHAR2(16),
    IM_AGT1_ADR_TWN          VARCHAR2(105),
    IM_AGT1_ADR_TWN_LOC      VARCHAR2(105),
    IM_AGT1_ADR_DSTRCT       VARCHAR2(105),
    IM_AGT1_ADR_AREA         VARCHAR2(105),
    IM_AGT1_ADR_CTRY         CHAR(2),
    IM_AGT1_ADR_ADR_LINE1    VARCHAR2(105),
    IM_AGT1_ADR_ADR_LINE2    VARCHAR2(105),
    IM_AGT1_ID               VARCHAR2(34),
    IM_AGT1_ID_SCHEX         VARCHAR2(35),
    IM_AGT1_AC_IBAN          VARCHAR2(34),
    IM_AGT1_AC_ID            VARCHAR2(34),
    IM_AGT1_AC_ID_SCHE       VARCHAR2(4),
    IM_AGT1_AC_ID_SCHEX      VARCHAR2(35),
    IM_AGT1_AC_ID_ISSR       VARCHAR2(35),
    IM_AGT1_AC_TYPE          VARCHAR2(4),
    IM_AGT1_AC_TYPEX         VARCHAR2(105),
    IM_AGT1_AC_CCY           CHAR(3),
    IM_AGT1_AC_NAME          VARCHAR2(210),
    IM_AGT1_AC_AKA_ID_TP     VARCHAR2(4),
    IM_AGT1_AC_AKA_ID_TPX    VARCHAR2(35),
    IM_AGT1_AC_AKA_ID        VARCHAR2(2048),
    IM_AGT2_BIC              VARCHAR2(11),
    IM_AGT2_CLR_SYS          VARCHAR2(5),
    IM_AGT2_CLR_SYSX         VARCHAR2(35),
    IM_AGT2_CLR_SYS_MMBID    VARCHAR2(35),
    IM_AGT2_LEI              VARCHAR2(20),
    IM_AGT2_NAME             VARCHAR2(420),
    IM_AGT2_ADR_DEPT         VARCHAR2(210),
    IM_AGT2_ADR_SDEPT        VARCHAR2(210),
    IM_AGT2_ADR_STRT_NM      VARCHAR2(210),
    IM_AGT2_ADR_BLDG_NB      VARCHAR2(16),
    IM_AGT2_ADR_BLDG_NM      VARCHAR2(105),
    IM_AGT2_ADR_FLR          VARCHAR2(70),
    IM_AGT2_ADR_PST_BX       VARCHAR2(16),
    IM_AGT2_ADR_ROOM         VARCHAR2(210),
    IM_AGT2_ADR_PST_CD       VARCHAR2(16),
    IM_AGT2_ADR_TWN          VARCHAR2(105),
    IM_AGT2_ADR_TWN_LOC      VARCHAR2(105),
    IM_AGT2_ADR_DSTRCT       VARCHAR2(105),
    IM_AGT2_ADR_AREA         VARCHAR2(105),
    IM_AGT2_ADR_CTRY         CHAR(2),
    IM_AGT2_ADR_ADR_LINE1    VARCHAR2(105),
    IM_AGT2_ADR_ADR_LINE2    VARCHAR2(105),
    IM_AGT2_ID               VARCHAR2(34),
    IM_AGT2_ID_SCHEX         VARCHAR2(35),
    IM_AGT2_AC_IBAN          VARCHAR2(34),
    IM_AGT2_AC_ID            VARCHAR2(34),
    IM_AGT2_AC_ID_SCHE       VARCHAR2(4),
    IM_AGT2_AC_ID_SCHEX      VARCHAR2(35),
    IM_AGT2_AC_ID_ISSR       VARCHAR2(35),
    IM_AGT2_AC_TYPE          VARCHAR2(4),
    IM_AGT2_AC_TYPEX         VARCHAR2(105),
    IM_AGT2_AC_CCY           CHAR(3),
    IM_AGT2_AC_NAME          VARCHAR2(210),
    IM_AGT2_AC_AKA_ID_TP     VARCHAR2(4),
    IM_AGT2_AC_AKA_ID_TPX    VARCHAR2(35),
    IM_AGT2_AC_AKA_ID        VARCHAR2(2048),
    IM_AGT3_BIC              VARCHAR2(11),
    IM_AGT3_CLR_SYS          VARCHAR2(5),
    IM_AGT3_CLR_SYSX         VARCHAR2(35),
    IM_AGT3_CLR_SYS_MMBID    VARCHAR2(35),
    IM_AGT3_LEI              VARCHAR2(20),
    IM_AGT3_NAME             VARCHAR2(420),
    IM_AGT3_ADR_DEPT         VARCHAR2(210),
    IM_AGT3_ADR_SDEPT        VARCHAR2(210),
    IM_AGT3_ADR_STRT_NM      VARCHAR2(210),
    IM_AGT3_ADR_BLDG_NB      VARCHAR2(16),
    IM_AGT3_ADR_BLDG_NM      VARCHAR2(105),
    IM_AGT3_ADR_FLR          VARCHAR2(70),
    IM_AGT3_ADR_PST_BX       VARCHAR2(16),
    IM_AGT3_ADR_ROOM         VARCHAR2(210),
    IM_AGT3_ADR_PST_CD       VARCHAR2(16),
    IM_AGT3_ADR_TWN          VARCHAR2(105),
    IM_AGT3_ADR_TWN_LOC      VARCHAR2(105),
    IM_AGT3_ADR_DSTRCT       VARCHAR2(105),
    IM_AGT3_ADR_AREA         VARCHAR2(105),
    IM_AGT3_ADR_CTRY         CHAR(2),
    IM_AGT3_ADR_ADR_LINE1    VARCHAR2(105),
    IM_AGT3_ADR_ADR_LINE2    VARCHAR2(105),
    IM_AGT3_ID               VARCHAR2(34),
    IM_AGT3_ID_SCHEX         VARCHAR2(35),
    IM_AGT3_AC_IBAN          VARCHAR2(34),
    IM_AGT3_AC_ID            VARCHAR2(34),
    IM_AGT3_AC_ID_SCHE       VARCHAR2(4),
    IM_AGT3_AC_ID_SCHEX      VARCHAR2(35),
    IM_AGT3_AC_ID_ISSR       VARCHAR2(35),
    IM_AGT3_AC_TYPE          VARCHAR2(4),
    IM_AGT3_AC_TYPEX         VARCHAR2(105),
    IM_AGT3_AC_CCY           CHAR(3),
    IM_AGT3_AC_NAME          VARCHAR2(210),
    IM_AGT3_AC_AKA_ID_TP     VARCHAR2(4),
    IM_AGT3_AC_AKA_ID_TPX    VARCHAR2(35),
    IM_AGT3_AC_AKA_ID        VARCHAR2(2048),
    ULTMT_DBTR_NAME          VARCHAR2(420),
    ULTMT_DBTR_ADR_DEPT      VARCHAR2(210),
    ULTMT_DBTR_ADR_SDEPT     VARCHAR2(210),
    ULTMT_DBTR_ADR_STRT_NM   VARCHAR2(210),
    ULTMT_DBTR_ADR_BLDG_NB   VARCHAR2(16),
    ULTMT_DBTR_ADR_BLDG_NM   VARCHAR2(105),
    ULTMT_DBTR_ADR_FLR       VARCHAR2(70),
    ULTMT_DBTR_ADR_PST_BX    VARCHAR2(16),
    ULTMT_DBTR_ADR_ROOM      VARCHAR2(210),
    ULTMT_DBTR_ADR_PST_CD    VARCHAR2(16),
    ULTMT_DBTR_ADR_TWN       VARCHAR2(105),
    ULTMT_DBTR_ADR_TWN_LOC   VARCHAR2(105),
    ULTMT_DBTR_ADR_DSTRCT    VARCHAR2(105),
    ULTMT_DBTR_ADR_AREA      VARCHAR2(105),
    ULTMT_DBTR_ADR_CTRY      CHAR(2),
    ULTMT_DBTR_ADR_ADR_LINE1 VARCHAR2(105),
    ULTMT_DBTR_ADR_ADR_LINE2 VARCHAR2(105),
    ULTMT_DBTR_C_BIC         VARCHAR2(11),
    ULTMT_DBTR_C_LEI         VARCHAR2(20),
    ULTMT_DBTR_C_ID1         VARCHAR2(35),
    ULTMT_DBTR_C_ID2         VARCHAR2(35),
    ULTMT_DBTR_C_ID_SCHE1    VARCHAR2(4),
    ULTMT_DBTR_C_ID_SCHE2    VARCHAR2(4),
    ULTMT_DBTR_C_ID_SCHEX1   VARCHAR2(35),
    ULTMT_DBTR_C_ID_SCHEX2   VARCHAR2(35),
    ULTMT_DBTR_C_ID_ISSR1    VARCHAR2(35),
    ULTMT_DBTR_C_ID_ISSR2    VARCHAR2(35),
    ULTMT_DBTR_P_BIRTH_DATE  CHAR(8),
    ULTMT_DBTR_P_BIRTH_PRVC  VARCHAR2(105),
    ULTMT_DBTR_P_BIRTH_CITY  VARCHAR2(105),
    ULTMT_DBTR_P_BIRTH_CTRY  CHAR(2),
    ULTMT_DBTR_P_ID1         VARCHAR2(105),
    ULTMT_DBTR_P_ID2         VARCHAR2(105),
    ULTMT_DBTR_P_ID_SCHE1    VARCHAR2(4),
    ULTMT_DBTR_P_ID_SCHE2    VARCHAR2(4),
    ULTMT_DBTR_P_ID_SCHEX1   CHAR(2),
    ULTMT_DBTR_P_ID_SCHEX2   CHAR(2),
    ULTMT_DBTR_P_ID_ISSR1    VARCHAR2(35),
    ULTMT_DBTR_P_ID_ISSR2    VARCHAR2(35),
    ULTMT_DBTR_RES_CTRY      CHAR(2),
    INITG_PTY_NAME           VARCHAR2(420),
    INITG_PTY_ADR_DEPT       VARCHAR2(210),
    INITG_PTY_ADR_SDEPT      VARCHAR2(210),
    INITG_PTY_ADR_STRT_NM    VARCHAR2(210),
    INITG_PTY_ADR_BLDG_NB    VARCHAR2(16),
    INITG_PTY_ADR_BLDG_NM    VARCHAR2(105),
    INITG_PTY_ADR_FLR        VARCHAR2(70),
    INITG_PTY_ADR_PST_BX     VARCHAR2(16),
    INITG_PTY_ADR_ROOM       VARCHAR2(210),
    INITG_PTY_ADR_PST_CD     VARCHAR2(16),
    INITG_PTY_ADR_TWN        VARCHAR2(105),
    INITG_PTY_ADR_TWN_LOC    VARCHAR2(105),
    INITG_PTY_ADR_DSTRCT     VARCHAR2(105),
    INITG_PTY_ADR_AREA       VARCHAR2(105),
    INITG_PTY_ADR_CTRY       CHAR(2),
    INITG_PTY_ADR_ADR_LINE1  VARCHAR2(105),
    INITG_PTY_ADR_ADR_LINE2  VARCHAR2(105),
    INITG_PTY_C_BIC          VARCHAR2(11),
    INITG_PTY_C_LEI          VARCHAR2(20),
    INITG_PTY_C_ID1          VARCHAR2(35),
    INITG_PTY_C_ID2          VARCHAR2(35),
    INITG_PTY_C_ID_SCHE1     VARCHAR2(4),
    INITG_PTY_C_ID_SCHE2     VARCHAR2(4),
    INITG_PTY_C_ID_SCHEX1    VARCHAR2(35),
    INITG_PTY_C_ID_SCHEX2    VARCHAR2(35),
    INITG_PTY_C_ID_ISSR1     VARCHAR2(35),
    INITG_PTY_C_ID_ISSR2     VARCHAR2(35),
    INITG_PTY_P_BIRTH_DATE   CHAR(8),
    INITG_PTY_P_BIRTH_PRVC   VARCHAR2(105),
    INITG_PTY_P_BIRTH_CITY   VARCHAR2(105),
    INITG_PTY_P_BIRTH_CTRY   CHAR(2),
    INITG_PTY_P_ID1          VARCHAR2(105),
    INITG_PTY_P_ID2          VARCHAR2(105),
    INITG_PTY_P_ID_SCHE1     VARCHAR2(4),
    INITG_PTY_P_ID_SCHE2     VARCHAR2(4),
    INITG_PTY_P_ID_SCHEX1    CHAR(2),
    INITG_PTY_P_ID_SCHEX2    CHAR(2),
    INITG_PTY_P_ID_ISSR1     VARCHAR2(35),
    INITG_PTY_P_ID_ISSR2     VARCHAR2(35),
    INITG_PTY_RES_CTRY       CHAR(2),
    DBTR_NAME                VARCHAR2(420),
    DBTR_ADR_DEPT            VARCHAR2(210),
    DBTR_ADR_SDEPT           VARCHAR2(210),
    DBTR_ADR_STRT_NM         VARCHAR2(210),
    DBTR_ADR_BLDG_NB         VARCHAR2(16),
    DBTR_ADR_BLDG_NM         VARCHAR2(105),
    DBTR_ADR_FLR             VARCHAR2(70),
    DBTR_ADR_PST_BX          VARCHAR2(16),
    DBTR_ADR_ROOM            VARCHAR2(210),
    DBTR_ADR_PST_CD          VARCHAR2(16),
    DBTR_ADR_TWN             VARCHAR2(105),
    DBTR_ADR_TWN_LOC         VARCHAR2(105),
    DBTR_ADR_DSTRCT          VARCHAR2(105),
    DBTR_ADR_AREA            VARCHAR2(105),
    DBTR_ADR_CTRY            CHAR(2),
    DBTR_ADR_ADR_LINE1       VARCHAR2(105),
    DBTR_ADR_ADR_LINE2       VARCHAR2(105),
    DBTR_C_BIC               VARCHAR2(11),
    DBTR_C_LEI               VARCHAR2(20),
    DBTR_C_ID1               VARCHAR2(35),
    DBTR_C_ID2               VARCHAR2(35),
    DBTR_C_ID_SCHE1          VARCHAR2(4),
    DBTR_C_ID_SCHE2          VARCHAR2(4),
    DBTR_C_ID_SCHEX1         VARCHAR2(35),
    DBTR_C_ID_SCHEX2         VARCHAR2(35),
    DBTR_C_ID_ISSR1          VARCHAR2(35),
    DBTR_C_ID_ISSR2          VARCHAR2(35),
    DBTR_P_BIRTH_DATE        CHAR(8),
    DBTR_P_BIRTH_PRVC        VARCHAR2(105),
    DBTR_P_BIRTH_CITY        VARCHAR2(105),
    DBTR_P_BIRTH_CTRY        CHAR(2),
    DBTR_P_ID1               VARCHAR2(105),
    DBTR_P_ID2               VARCHAR2(105),
    DBTR_P_ID_SCHE1          VARCHAR2(4),
    DBTR_P_ID_SCHE2          VARCHAR2(4),
    DBTR_P_ID_SCHEX1         CHAR(2),
    DBTR_P_ID_SCHEX2         CHAR(2),
    DBTR_P_ID_ISSR1          VARCHAR2(35),
    DBTR_P_ID_ISSR2          VARCHAR2(35),
    DBTR_RES_CTRY            CHAR(2),
    DBTR_AC_IBAN             VARCHAR2(34),
    DBTR_AC_ID               VARCHAR2(34),
    DBTR_AC_ID_SCHE          VARCHAR2(4),
    DBTR_AC_ID_SCHEX         VARCHAR2(35),
    DBTR_AC_ID_ISSR          VARCHAR2(35),
    DBTR_AC_TYPE             VARCHAR2(4),
    DBTR_AC_TYPEX            VARCHAR2(105),
    DBTR_AC_CCY              CHAR(3),
    DBTR_AC_NAME             VARCHAR2(210),
    DBTR_AC_AKA_ID_TP        VARCHAR2(4),
    DBTR_AC_AKA_ID_TPX       VARCHAR2(35),
    DBTR_AC_AKA_ID           VARCHAR2(2048),
    DBTR_AGT_BIC             VARCHAR2(11),
    DBTR_AGT_CLR_SYS         VARCHAR2(5),
    DBTR_AGT_CLR_SYSX        VARCHAR2(35),
    DBTR_AGT_CLR_SYS_MMBID   VARCHAR2(35),
    DBTR_AGT_LEI             VARCHAR2(20),
    DBTR_AGT_NAME            VARCHAR2(420),
    DBTR_AGT_ADR_DEPT        VARCHAR2(210),
    DBTR_AGT_ADR_SDEPT       VARCHAR2(210),
    DBTR_AGT_ADR_STRT_NM     VARCHAR2(210),
    DBTR_AGT_ADR_BLDG_NB     VARCHAR2(16),
    DBTR_AGT_ADR_BLDG_NM     VARCHAR2(105),
    DBTR_AGT_ADR_FLR         VARCHAR2(70),
    DBTR_AGT_ADR_PST_BX      VARCHAR2(16),
    DBTR_AGT_ADR_ROOM        VARCHAR2(210),
    DBTR_AGT_ADR_PST_CD      VARCHAR2(16),
    DBTR_AGT_ADR_TWN         VARCHAR2(105),
    DBTR_AGT_ADR_TWN_LOC     VARCHAR2(105),
    DBTR_AGT_ADR_DSTRCT      VARCHAR2(105),
    DBTR_AGT_ADR_AREA        VARCHAR2(105),
    DBTR_AGT_ADR_CTRY        CHAR(2),
    DBTR_AGT_ADR_ADR_LINE1   VARCHAR2(105),
    DBTR_AGT_ADR_ADR_LINE2   VARCHAR2(105),
    DBTR_AGT_ID              VARCHAR2(34),
    DBTR_AGT_ID_SCHEX        VARCHAR2(35),
    DBTR_AGT_AC_IBAN         VARCHAR2(34),
    DBTR_AGT_AC_ID           VARCHAR2(34),
    DBTR_AGT_AC_ID_SCHE      VARCHAR2(4),
    DBTR_AGT_AC_ID_SCHEX     VARCHAR2(35),
    DBTR_AGT_AC_ID_ISSR      VARCHAR2(35),
    DBTR_AGT_AC_TYPE         VARCHAR2(4),
    DBTR_AGT_AC_TYPEX        VARCHAR2(105),
    DBTR_AGT_AC_CCY          CHAR(3),
    DBTR_AGT_AC_NAME         VARCHAR2(210),
    DBTR_AGT_AC_AKA_ID_TP    VARCHAR2(4),
    DBTR_AGT_AC_AKA_ID_TPX   VARCHAR2(35),
    DBTR_AGT_AC_AKA_ID       VARCHAR2(2048),
    CDTR_AGT_BRANCH_ID       VARCHAR2(35),
    CDTR_AGT_BIC             VARCHAR2(11),
    CDTR_AGT_CLR_SYS         VARCHAR2(5),
    CDTR_AGT_CLR_SYSX        VARCHAR2(35),
    CDTR_AGT_CLR_SYS_MMBID   VARCHAR2(35),
    CDTR_AGT_LEI             VARCHAR2(20),
    CDTR_AGT_NAME            VARCHAR2(420),
    CDTR_AGT_ADR_DEPT        VARCHAR2(210),
    CDTR_AGT_ADR_SDEPT       VARCHAR2(210),
    CDTR_AGT_ADR_STRT_NM     VARCHAR2(210),
    CDTR_AGT_ADR_BLDG_NB     VARCHAR2(16),
    CDTR_AGT_ADR_BLDG_NM     VARCHAR2(105),
    CDTR_AGT_ADR_FLR         VARCHAR2(70),
    CDTR_AGT_ADR_PST_BX      VARCHAR2(16),
    CDTR_AGT_ADR_ROOM        VARCHAR2(210),
    CDTR_AGT_ADR_PST_CD      VARCHAR2(16),
    CDTR_AGT_ADR_TWN         VARCHAR2(105),
    CDTR_AGT_ADR_TWN_LOC     VARCHAR2(105),
    CDTR_AGT_ADR_DSTRCT      VARCHAR2(105),
    CDTR_AGT_ADR_AREA        VARCHAR2(105),
    CDTR_AGT_ADR_CTRY        CHAR(2),
    CDTR_AGT_ADR_ADR_LINE1   VARCHAR2(105),
    CDTR_AGT_ADR_ADR_LINE2   VARCHAR2(105),
    CDTR_AGT_ID              VARCHAR2(34),
    CDTR_AGT_ID_SCHEX        VARCHAR2(35),
    CDTR_AGT_AC_IBAN         VARCHAR2(34),
    CDTR_AGT_AC_ID           VARCHAR2(34),
    CDTR_AGT_AC_ID_SCHE      VARCHAR2(4),
    CDTR_AGT_AC_ID_SCHEX     VARCHAR2(35),
    CDTR_AGT_AC_ID_ISSR      VARCHAR2(35),
    CDTR_AGT_AC_TYPE         VARCHAR2(4),
    CDTR_AGT_AC_TYPEX        VARCHAR2(105),
    CDTR_AGT_AC_CCY          CHAR(3),
    CDTR_AGT_AC_NAME         VARCHAR2(210),
    CDTR_AGT_AC_AKA_ID_TP    VARCHAR2(4),
    CDTR_AGT_AC_AKA_ID_TPX   VARCHAR2(35),
    CDTR_AGT_AC_AKA_ID       VARCHAR2(2048),
    CDTR_NAME                VARCHAR2(420),
    CDTR_ADR_DEPT            VARCHAR2(210),
    CDTR_ADR_SDEPT           VARCHAR2(210),
    CDTR_ADR_STRT_NM         VARCHAR2(210),
    CDTR_ADR_BLDG_NB         VARCHAR2(16),
    CDTR_ADR_BLDG_NM         VARCHAR2(105),
    CDTR_ADR_FLR             VARCHAR2(70),
    CDTR_ADR_PST_BX          VARCHAR2(16),
    CDTR_ADR_ROOM            VARCHAR2(210),
    CDTR_ADR_PST_CD          VARCHAR2(16),
    CDTR_ADR_TWN             VARCHAR2(105),
    CDTR_ADR_TWN_LOC         VARCHAR2(105),
    CDTR_ADR_DSTRCT          VARCHAR2(105),
    CDTR_ADR_AREA            VARCHAR2(105),
    CDTR_ADR_CTRY            CHAR(2),
    CDTR_ADR_ADR_LINE1       VARCHAR2(105),
    CDTR_ADR_ADR_LINE2       VARCHAR2(105),
    CDTR_C_BIC               VARCHAR2(11),
    CDTR_C_LEI               VARCHAR2(20),
    CDTR_C_ID1               VARCHAR2(35),
    CDTR_C_ID2               VARCHAR2(35),
    CDTR_C_ID_SCHE1          VARCHAR2(4),
    CDTR_C_ID_SCHE2          VARCHAR2(4),
    CDTR_C_ID_SCHEX1         VARCHAR2(35),
    CDTR_C_ID_SCHEX2         VARCHAR2(35),
    CDTR_C_ID_ISSR1          VARCHAR2(35),
    CDTR_C_ID_ISSR2          VARCHAR2(35),
    CDTR_P_BIRTH_DATE        CHAR(8),
    CDTR_P_BIRTH_PRVC        VARCHAR2(105),
    CDTR_P_BIRTH_CITY        VARCHAR2(105),
    CDTR_P_BIRTH_CTRY        CHAR(2),
    CDTR_P_ID1               VARCHAR2(105),
    CDTR_P_ID2               VARCHAR2(105),
    CDTR_P_ID_SCHE1          VARCHAR2(4),
    CDTR_P_ID_SCHE2          VARCHAR2(4),
    CDTR_P_ID_SCHEX1         CHAR(2),
    CDTR_P_ID_SCHEX2         CHAR(2),
    CDTR_P_ID_ISSR1          VARCHAR2(35),
    CDTR_P_ID_ISSR2          VARCHAR2(35),
    CDTR_RES_CTRY            CHAR(2),
    CDTR_AC_IBAN             VARCHAR2(34),
    CDTR_AC_ID               VARCHAR2(34),
    CDTR_AC_ID_SCHE          VARCHAR2(4),
    CDTR_AC_ID_SCHEX         VARCHAR2(35),
    CDTR_AC_ID_ISSR          VARCHAR2(35),
    CDTR_AC_TYPE             VARCHAR2(4),
    CDTR_AC_TYPEX            VARCHAR2(105),
    CDTR_AC_CCY              CHAR(3),
    CDTR_AC_NAME             VARCHAR2(210),
    CDTR_AC_AKA_ID_TP        VARCHAR2(4),
    CDTR_AC_AKA_ID_TPX       VARCHAR2(35),
    CDTR_AC_AKA_ID           VARCHAR2(2048),
    ULTMT_CDTR_NAME          VARCHAR2(420),
    ULTMT_CDTR_ADR_DEPT      VARCHAR2(210),
    ULTMT_CDTR_ADR_SDEPT     VARCHAR2(210),
    ULTMT_CDTR_ADR_STRT_NM   VARCHAR2(210),
    ULTMT_CDTR_ADR_BLDG_NB   VARCHAR2(16),
    ULTMT_CDTR_ADR_BLDG_NM   VARCHAR2(105),
    ULTMT_CDTR_ADR_FLR       VARCHAR2(70),
    ULTMT_CDTR_ADR_PST_BX    VARCHAR2(16),
    ULTMT_CDTR_ADR_ROOM      VARCHAR2(210),
    ULTMT_CDTR_ADR_PST_CD    VARCHAR2(16),
    ULTMT_CDTR_ADR_TWN       VARCHAR2(105),
    ULTMT_CDTR_ADR_TWN_LOC   VARCHAR2(105),
    ULTMT_CDTR_ADR_DSTRCT    VARCHAR2(105),
    ULTMT_CDTR_ADR_AREA      VARCHAR2(105),
    ULTMT_CDTR_ADR_CTRY      CHAR(2),
    ULTMT_CDTR_ADR_ADR_LINE1 VARCHAR2(105),
    ULTMT_CDTR_ADR_ADR_LINE2 VARCHAR2(105),
    ULTMT_CDTR_C_BIC         VARCHAR2(11),
    ULTMT_CDTR_C_LEI         VARCHAR2(20),
    ULTMT_CDTR_C_ID1         VARCHAR2(35),
    ULTMT_CDTR_C_ID2         VARCHAR2(35),
    ULTMT_CDTR_C_ID_SCHE1    VARCHAR2(4),
    ULTMT_CDTR_C_ID_SCHE2    VARCHAR2(4),
    ULTMT_CDTR_C_ID_SCHEX1   VARCHAR2(35),
    ULTMT_CDTR_C_ID_SCHEX2   VARCHAR2(35),
    ULTMT_CDTR_C_ID_ISSR1    VARCHAR2(35),
    ULTMT_CDTR_C_ID_ISSR2    VARCHAR2(35),
    ULTMT_CDTR_P_BIRTH_DATE  CHAR(8),
    ULTMT_CDTR_P_BIRTH_PRVC  VARCHAR2(105),
    ULTMT_CDTR_P_BIRTH_CITY  VARCHAR2(105),
    ULTMT_CDTR_P_BIRTH_CTRY  CHAR(2),
    ULTMT_CDTR_P_ID1         VARCHAR2(105),
    ULTMT_CDTR_P_ID2         VARCHAR2(105),
    ULTMT_CDTR_P_ID_SCHE1    VARCHAR2(4),
    ULTMT_CDTR_P_ID_SCHE2    VARCHAR2(4),
    ULTMT_CDTR_P_ID_SCHEX1   CHAR(2),
    ULTMT_CDTR_P_ID_SCHEX2   CHAR(2),
    ULTMT_CDTR_P_ID_ISSR1    VARCHAR2(35),
    ULTMT_CDTR_P_ID_ISSR2    VARCHAR2(35),
    ULTMT_CDTR_RES_CTRY      CHAR(2),
    INSTR_FOR_CDTR_AGT1      VARCHAR2(140),
    INSTR_FOR_CDTR_AGT2      VARCHAR2(140),
    INSTR_FOR_NXT_AGT1       VARCHAR2(35),
    INSTR_FOR_NXT_AGT2       VARCHAR2(35),
    INSTR_FOR_NXT_AGT3       VARCHAR2(35),
    INSTR_FOR_NXT_AGT4       VARCHAR2(35),
    INSTR_FOR_NXT_AGT5       VARCHAR2(35),
    INSTR_FOR_NXT_AGT6       VARCHAR2(35),
    PURP                     VARCHAR2(4),
    PURPX                    VARCHAR2(35),
    RMT_INF                  VARCHAR2(140),
    PLC_AND_NM               VARCHAR2(350),
    XPCTD_STTLM_DT           CHAR(14),
    DAY_NIGHT_FLG            CHAR(4),
    RSV1                     VARCHAR2(420),
    RSV2                     VARCHAR2(420),
    RSV3                     VARCHAR2(420),
    RSV4                     VARCHAR2(420),
    RSV5                     VARCHAR2(420)
)
/

comment on table CIPS_111_REMIT is '客户汇款报文表'
/

comment on column CIPS_111_REMIT.SEQ_NO is '序号'
/

comment on column CIPS_111_REMIT.CORP_ID is '法人ID'
/

comment on column CIPS_111_REMIT.TXN_SEQ_NO is '业务表关联序号'
/

comment on column CIPS_111_REMIT.ORI_SEQ_NO is '关联接口表序号'
/

comment on column CIPS_111_REMIT.TXN_DIR is '来往账方向'
/

comment on column CIPS_111_REMIT.SND_ST_BRNO is '发起直接参与机构'
/

comment on column CIPS_111_REMIT.SND_ST_BRNAME is '发起直接参与机构名'
/

comment on column CIPS_111_REMIT.RCV_ST_BRNO is '接收直接参与机构'
/

comment on column CIPS_111_REMIT.RCV_ST_BRNAME is '接收直接参与机构名'
/

comment on column CIPS_111_REMIT.SYS_CODE is '系统类别'
/

comment on column CIPS_111_REMIT.SRC_SYS is '发送系统号'
/

comment on column CIPS_111_REMIT.DEST_SYS is '接收系统号'
/

comment on column CIPS_111_REMIT.MSG_TYPE is '报文号'
/

comment on column CIPS_111_REMIT.MSG_SND_TIME is '报文发送时间'
/

comment on column CIPS_111_REMIT.MSG_PRIO is '报文优先级'
/

comment on column CIPS_111_REMIT.MSG_ID is '报文标识号'
/

comment on column CIPS_111_REMIT.WORK_DATE is '工作日期'
/

comment on column CIPS_111_REMIT.COMM_STATUS is '通讯状态'
/

comment on column CIPS_111_REMIT.PBOC_STATUS is '人行状态'
/

comment on column CIPS_111_REMIT.CRE_DT_TM is '报文发送时间'
/

comment on column CIPS_111_REMIT.NB_OF_TXS is '交易笔数'
/

comment on column CIPS_111_REMIT.STTLM_MTD is '结算方式'
/

comment on column CIPS_111_REMIT.INSTR_ID is '指令标识号'
/

comment on column CIPS_111_REMIT.END_TO_END_ID is '端到端标识号'
/

comment on column CIPS_111_REMIT.TX_ID is '交易标识号'
/

comment on column CIPS_111_REMIT.UETR is 'UETR'
/

comment on column CIPS_111_REMIT.CLR_SYS_REF is '系统追踪标识号'
/

comment on column CIPS_111_REMIT.SVC_LVL1 is '服务级别1'
/

comment on column CIPS_111_REMIT.SVC_LVL2 is '服务级别2'
/

comment on column CIPS_111_REMIT.SVC_LVL3 is '服务级别3'
/

comment on column CIPS_111_REMIT.SVC_LVLX1 is '服务级别Proprietary1'
/

comment on column CIPS_111_REMIT.SVC_LVLX2 is '服务级别Proprietary2'
/

comment on column CIPS_111_REMIT.SVC_LVLX3 is '服务级别Proprietary3'
/

comment on column CIPS_111_REMIT.CTGY_PURP is '业务种类编码'
/

comment on column CIPS_111_REMIT.CTGY_PURPX is '业务种类Proprietary'
/

comment on column CIPS_111_REMIT.AMT_CURCD is '币种'
/

comment on column CIPS_111_REMIT.AMT is '金额'
/

comment on column CIPS_111_REMIT.INTR_BK_STTLM_DT is '银行间结算日期'
/

comment on column CIPS_111_REMIT.STTLM_PRTY is '业务优先级'
/

comment on column CIPS_111_REMIT.DBT_DT_TM is '借记时间'
/

comment on column CIPS_111_REMIT.CDT_DT_TM is '贷记时间'
/

comment on column CIPS_111_REMIT.INSTD_AMTX_CURCD is '原始货币'
/

comment on column CIPS_111_REMIT.INSTD_AMTX is '原始货币符号、金额'
/

comment on column CIPS_111_REMIT.XCHG_RATE is '汇率'
/

comment on column CIPS_111_REMIT.CHRG_BR is '费用承担方'
/

comment on column CIPS_111_REMIT.PRE_AGT1_BIC is '前序机构1_BIC码'
/

comment on column CIPS_111_REMIT.PRE_AGT1_CLR_SYS is '前序机构1_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_CLR_SYSX is '前序机构1_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_CLR_SYS_MMBID is '前序机构1_参与者身份标识'
/

comment on column CIPS_111_REMIT.PRE_AGT1_LEI is '前序机构1_LEI码'
/

comment on column CIPS_111_REMIT.PRE_AGT1_NAME is '前序机构1_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_DEPT is '前序机构1_地址_部门'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_SDEPT is '前序机构1_地址_分部'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_STRT_NM is '前序机构1_地址_街道名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_BLDG_NB is '前序机构1_地址_建筑编号'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_BLDG_NM is '前序机构1_地址_建筑名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_FLR is '前序机构1_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_PST_BX is '前序机构1_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_ROOM is '前序机构1_地址_房间号'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_PST_CD is '前序机构1_地址_邮政编码'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_TWN is '前序机构1_地址_城镇名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_TWN_LOC is '前序机构1_地址_城镇地址'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_DSTRCT is '前序机构1_地址_地区名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_AREA is '前序机构1_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_CTRY is '前序机构1_地址_国家'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_ADR_LINE1 is '前序机构1_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ADR_ADR_LINE2 is '前序机构1_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ID is '前序机构1_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT1_ID_SCHEX is '前序机构1_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_IBAN is '前序机构1账户_IBAN码'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_ID is '前序机构1账户_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_ID_SCHE is '前序机构1账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_ID_SCHEX is '前序机构1账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_ID_ISSR is '前序机构1账户_发码方'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_TYPE is '前序机构1账户_类型代码'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_TYPEX is '前序机构1账户_用途说明'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_CCY is '前序机构1账户_币种'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_NAME is '前序机构1账户_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_AKA_ID_TP is '前序机构1账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_AKA_ID_TPX is '前序机构1账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT1_AC_AKA_ID is '前序机构1账户_账户别名'
/

comment on column CIPS_111_REMIT.PRE_AGT2_BIC is '前序机构2_BIC码'
/

comment on column CIPS_111_REMIT.PRE_AGT2_CLR_SYS is '前序机构2_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_CLR_SYSX is '前序机构2_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_CLR_SYS_MMBID is '前序机构2_参与者身份标识'
/

comment on column CIPS_111_REMIT.PRE_AGT2_LEI is '前序机构2_LEI码'
/

comment on column CIPS_111_REMIT.PRE_AGT2_NAME is '前序机构2_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_DEPT is '前序机构2_地址_部门'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_SDEPT is '前序机构2_地址_分部'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_STRT_NM is '前序机构2_地址_街道名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_BLDG_NB is '前序机构2_地址_建筑编号'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_BLDG_NM is '前序机构2_地址_建筑名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_FLR is '前序机构2_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_PST_BX is '前序机构2_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_ROOM is '前序机构2_地址_房间号'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_PST_CD is '前序机构2_地址_邮政编码'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_TWN is '前序机构2_地址_城镇名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_TWN_LOC is '前序机构2_地址_城镇地址'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_DSTRCT is '前序机构2_地址_地区名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_AREA is '前序机构2_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_CTRY is '前序机构2_地址_国家'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_ADR_LINE1 is '前序机构2_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ADR_ADR_LINE2 is '前序机构2_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ID is '前序机构2_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT2_ID_SCHEX is '前序机构2_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_IBAN is '前序机构2账户_IBAN码'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_ID is '前序机构2账户_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_ID_SCHE is '前序机构2账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_ID_SCHEX is '前序机构2账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_ID_ISSR is '前序机构2账户_发码方'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_TYPE is '前序机构2账户_类型代码'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_TYPEX is '前序机构2账户_用途说明'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_CCY is '前序机构2账户_币种'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_NAME is '前序机构2账户_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_AKA_ID_TP is '前序机构2账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_AKA_ID_TPX is '前序机构2账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT2_AC_AKA_ID is '前序机构2账户_账户别名'
/

comment on column CIPS_111_REMIT.PRE_AGT3_BIC is '前序机构3_BIC码'
/

comment on column CIPS_111_REMIT.PRE_AGT3_CLR_SYS is '前序机构3_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_CLR_SYSX is '前序机构3_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_CLR_SYS_MMBID is '前序机构3_参与者身份标识'
/

comment on column CIPS_111_REMIT.PRE_AGT3_LEI is '前序机构3_LEI码'
/

comment on column CIPS_111_REMIT.PRE_AGT3_NAME is '前序机构3_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_DEPT is '前序机构3_地址_部门'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_SDEPT is '前序机构3_地址_分部'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_STRT_NM is '前序机构3_地址_街道名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_BLDG_NB is '前序机构3_地址_建筑编号'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_BLDG_NM is '前序机构3_地址_建筑名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_FLR is '前序机构3_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_PST_BX is '前序机构3_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_ROOM is '前序机构3_地址_房间号'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_PST_CD is '前序机构3_地址_邮政编码'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_TWN is '前序机构3_地址_城镇名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_TWN_LOC is '前序机构3_地址_城镇地址'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_DSTRCT is '前序机构3_地址_地区名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_AREA is '前序机构3_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_CTRY is '前序机构3_地址_国家'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_ADR_LINE1 is '前序机构3_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ADR_ADR_LINE2 is '前序机构3_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ID is '前序机构3_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT3_ID_SCHEX is '前序机构3_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_IBAN is '前序机构3账户_IBAN码'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_ID is '前序机构3账户_账号'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_ID_SCHE is '前序机构3账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_ID_SCHEX is '前序机构3账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_ID_ISSR is '前序机构3账户_发码方'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_TYPE is '前序机构3账户_类型代码'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_TYPEX is '前序机构3账户_用途说明'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_CCY is '前序机构3账户_币种'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_NAME is '前序机构3账户_名称'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_AKA_ID_TP is '前序机构3账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_AKA_ID_TPX is '前序机构3账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.PRE_AGT3_AC_AKA_ID is '前序机构3账户_账户别名'
/

comment on column CIPS_111_REMIT.INSTG_AGT_BIC is '发报方_BIC码'
/

comment on column CIPS_111_REMIT.INSTG_AGT_CLR_SYS is '发报方_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.INSTG_AGT_CLR_SYS_MMBID is '发报方_参与者身份标识'
/

comment on column CIPS_111_REMIT.INSTG_AGT_LEI is '发报方_LEI码'
/

comment on column CIPS_111_REMIT.INSTD_AGT_BIC is '收报方_BIC码'
/

comment on column CIPS_111_REMIT.INSTD_AGT_CLR_SYS is '收报方_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.INSTD_AGT_CLR_SYS_MMBID is '收报方_参与者身份标识'
/

comment on column CIPS_111_REMIT.INSTD_AGT_LEI is '收报方_LEI码'
/

comment on column CIPS_111_REMIT.IM_AGT1_BIC is '中介机构1_BIC码'
/

comment on column CIPS_111_REMIT.IM_AGT1_CLR_SYS is '中介机构1_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT1_CLR_SYSX is '中介机构1_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT1_CLR_SYS_MMBID is '中介机构1_参与者身份标识'
/

comment on column CIPS_111_REMIT.IM_AGT1_LEI is '中介机构1_LEI码'
/

comment on column CIPS_111_REMIT.IM_AGT1_NAME is '中介机构1_名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_DEPT is '中介机构1_地址_部门'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_SDEPT is '中介机构1_地址_分部'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_STRT_NM is '中介机构1_地址_街道名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_BLDG_NB is '中介机构1_地址_建筑编号'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_BLDG_NM is '中介机构1_地址_建筑名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_FLR is '中介机构1_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_PST_BX is '中介机构1_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_ROOM is '中介机构1_地址_房间号'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_PST_CD is '中介机构1_地址_邮政编码'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_TWN is '中介机构1_地址_城镇名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_TWN_LOC is '中介机构1_地址_城镇地址'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_DSTRCT is '中介机构1_地址_地区名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_AREA is '中介机构1_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_CTRY is '中介机构1_地址_国家'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_ADR_LINE1 is '中介机构1_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.IM_AGT1_ADR_ADR_LINE2 is '中介机构1_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.IM_AGT1_ID is '中介机构1_账号'
/

comment on column CIPS_111_REMIT.IM_AGT1_ID_SCHEX is '中介机构1_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_IBAN is '中介机构1账户_IBAN码'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_ID is '中介机构1账户_账号'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_ID_SCHE is '中介机构1账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_ID_SCHEX is '中介机构1账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_ID_ISSR is '中介机构1账户_发码方'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_TYPE is '中介机构1账户_类型代码'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_TYPEX is '中介机构1账户_用途说明'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_CCY is '中介机构1账户_币种'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_NAME is '中介机构1账户_名称'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_AKA_ID_TP is '中介机构1账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_AKA_ID_TPX is '中介机构1账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT1_AC_AKA_ID is '中介机构1账户_账户别名'
/

comment on column CIPS_111_REMIT.IM_AGT2_BIC is '中介机构2_BIC码'
/

comment on column CIPS_111_REMIT.IM_AGT2_CLR_SYS is '中介机构2_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT2_CLR_SYSX is '中介机构2_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT2_CLR_SYS_MMBID is '中介机构2_参与者身份标识'
/

comment on column CIPS_111_REMIT.IM_AGT2_LEI is '中介机构2_LEI码'
/

comment on column CIPS_111_REMIT.IM_AGT2_NAME is '中介机构2_名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_DEPT is '中介机构2_地址_部门'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_SDEPT is '中介机构2_地址_分部'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_STRT_NM is '中介机构2_地址_街道名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_BLDG_NB is '中介机构2_地址_建筑编号'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_BLDG_NM is '中介机构2_地址_建筑名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_FLR is '中介机构2_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_PST_BX is '中介机构2_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_ROOM is '中介机构2_地址_房间号'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_PST_CD is '中介机构2_地址_邮政编码'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_TWN is '中介机构2_地址_城镇名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_TWN_LOC is '中介机构2_地址_城镇地址'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_DSTRCT is '中介机构2_地址_地区名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_AREA is '中介机构2_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_CTRY is '中介机构2_地址_国家'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_ADR_LINE1 is '中介机构2_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.IM_AGT2_ADR_ADR_LINE2 is '中介机构2_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.IM_AGT2_ID is '中介机构2_账号'
/

comment on column CIPS_111_REMIT.IM_AGT2_ID_SCHEX is '中介机构2_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_IBAN is '中介机构2账户_IBAN码'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_ID is '中介机构2账户_账号'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_ID_SCHE is '中介机构2账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_ID_SCHEX is '中介机构2账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_ID_ISSR is '中介机构2账户_发码方'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_TYPE is '中介机构2账户_类型代码'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_TYPEX is '中介机构2账户_用途说明'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_CCY is '中介机构2账户_币种'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_NAME is '中介机构2账户_名称'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_AKA_ID_TP is '中介机构2账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_AKA_ID_TPX is '中介机构2账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT2_AC_AKA_ID is '中介机构2账户_账户别名'
/

comment on column CIPS_111_REMIT.IM_AGT3_BIC is '中介机构3_BIC码'
/

comment on column CIPS_111_REMIT.IM_AGT3_CLR_SYS is '中介机构3_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT3_CLR_SYSX is '中介机构3_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT3_CLR_SYS_MMBID is '中介机构3_参与者身份标识'
/

comment on column CIPS_111_REMIT.IM_AGT3_LEI is '中介机构3_LEI码'
/

comment on column CIPS_111_REMIT.IM_AGT3_NAME is '中介机构3_名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_DEPT is '中介机构3_地址_部门'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_SDEPT is '中介机构3_地址_分部'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_STRT_NM is '中介机构3_地址_街道名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_BLDG_NB is '中介机构3_地址_建筑编号'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_BLDG_NM is '中介机构3_地址_建筑名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_FLR is '中介机构3_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_PST_BX is '中介机构3_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_ROOM is '中介机构3_地址_房间号'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_PST_CD is '中介机构3_地址_邮政编码'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_TWN is '中介机构3_地址_城镇名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_TWN_LOC is '中介机构3_地址_城镇地址'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_DSTRCT is '中介机构3_地址_地区名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_AREA is '中介机构3_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_CTRY is '中介机构3_地址_国家'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_ADR_LINE1 is '中介机构3_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.IM_AGT3_ADR_ADR_LINE2 is '中介机构3_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.IM_AGT3_ID is '中介机构3_账号'
/

comment on column CIPS_111_REMIT.IM_AGT3_ID_SCHEX is '中介机构3_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_IBAN is '中介机构3账户_IBAN码'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_ID is '中介机构3账户_账号'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_ID_SCHE is '中介机构3账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_ID_SCHEX is '中介机构3账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_ID_ISSR is '中介机构3账户_发码方'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_TYPE is '中介机构3账户_类型代码'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_TYPEX is '中介机构3账户_用途说明'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_CCY is '中介机构3账户_币种'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_NAME is '中介机构3账户_名称'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_AKA_ID_TP is '中介机构3账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_AKA_ID_TPX is '中介机构3账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.IM_AGT3_AC_AKA_ID is '中介机构3账户_账户别名'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_NAME is '最终付款人_个人或组织名称'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_DEPT is '最终付款人_地址_部门'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_SDEPT is '最终付款人_地址_分部'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_STRT_NM is '最终付款人_地址_街道名称'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_BLDG_NB is '最终付款人_地址_建筑编号'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_BLDG_NM is '最终付款人_地址_建筑名称'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_FLR is '最终付款人_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_PST_BX is '最终付款人_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_ROOM is '最终付款人_地址_房间号'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_PST_CD is '最终付款人_地址_邮政编码'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_TWN is '最终付款人_地址_城镇名称'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_TWN_LOC is '最终付款人_地址_城镇地址'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_DSTRCT is '最终付款人_地址_地区名称'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_AREA is '最终付款人_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_CTRY is '最终付款人_地址_国家'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_ADR_LINE1 is '最终付款人_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_ADR_ADR_LINE2 is '最终付款人_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_BIC is '最终付款人_【组织】BIC码'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_LEI is '最终付款人_【组织】LEI码'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID1 is '最终付款人_【组织】CIPS ID或组织机构代码1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID2 is '最终付款人_【组织】CIPS ID或组织机构代码2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_SCHE1 is '最终付款人_【组织】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_SCHE2 is '最终付款人_【组织】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_SCHEX1 is '最终付款人_【组织】身份标识方案名称（自定义内容）1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_SCHEX2 is '最终付款人_【组织】身份标识方案名称（自定义内容）2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_ISSR1 is '最终付款人_【组织】发码方1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_C_ID_ISSR2 is '最终付款人_【组织】发码方2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_BIRTH_DATE is '最终付款人_【个人】出生日期'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_BIRTH_PRVC is '最终付款人_【个人】出生省份'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_BIRTH_CITY is '最终付款人_【个人】出生城市'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_BIRTH_CTRY is '最终付款人_【个人】出生国家'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID1 is '最终付款人_【个人】证件号码1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID2 is '最终付款人_【个人】证件号码2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_SCHE1 is '最终付款人_【个人】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_SCHE2 is '最终付款人_【个人】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_SCHEX1 is '最终付款人_【个人】证件类型1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_SCHEX2 is '最终付款人_【个人】证件类型2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_ISSR1 is '最终付款人_【个人】发码方1'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_P_ID_ISSR2 is '最终付款人_【个人】发码方2'
/

comment on column CIPS_111_REMIT.ULTMT_DBTR_RES_CTRY is '最终付款人_居住国家'
/

comment on column CIPS_111_REMIT.INITG_PTY_NAME is '发起方_个人或组织名称'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_DEPT is '发起方_地址_部门'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_SDEPT is '发起方_地址_分部'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_STRT_NM is '发起方_地址_街道名称'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_BLDG_NB is '发起方_地址_建筑编号'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_BLDG_NM is '发起方_地址_建筑名称'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_FLR is '发起方_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_PST_BX is '发起方_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_ROOM is '发起方_地址_房间号'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_PST_CD is '发起方_地址_邮政编码'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_TWN is '发起方_地址_城镇名称'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_TWN_LOC is '发起方_地址_城镇地址'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_DSTRCT is '发起方_地址_地区名称'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_AREA is '发起方_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_CTRY is '发起方_地址_国家'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_ADR_LINE1 is '发起方_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.INITG_PTY_ADR_ADR_LINE2 is '发起方_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_BIC is '发起方_【组织】BIC码'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_LEI is '发起方_【组织】LEI码'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID1 is '发起方_【组织】CIPS ID或组织机构代码1'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID2 is '发起方_【组织】CIPS ID或组织机构代码2'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_SCHE1 is '发起方_【组织】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_SCHE2 is '发起方_【组织】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_SCHEX1 is '发起方_【组织】身份标识方案名称（自定义内容）1'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_SCHEX2 is '发起方_【组织】身份标识方案名称（自定义内容）2'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_ISSR1 is '发起方_【组织】发码方1'
/

comment on column CIPS_111_REMIT.INITG_PTY_C_ID_ISSR2 is '发起方_【组织】发码方2'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_BIRTH_DATE is '发起方_【个人】出生日期'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_BIRTH_PRVC is '发起方_【个人】出生省份'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_BIRTH_CITY is '发起方_【个人】出生城市'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_BIRTH_CTRY is '发起方_【个人】出生国家'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID1 is '发起方_【个人】证件号码1'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID2 is '发起方_【个人】证件号码2'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_SCHE1 is '发起方_【个人】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_SCHE2 is '发起方_【个人】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_SCHEX1 is '发起方_【个人】证件类型1'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_SCHEX2 is '发起方_【个人】证件类型2'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_ISSR1 is '发起方_【个人】发码方1'
/

comment on column CIPS_111_REMIT.INITG_PTY_P_ID_ISSR2 is '发起方_【个人】发码方2'
/

comment on column CIPS_111_REMIT.INITG_PTY_RES_CTRY is '发起方_居住国家'
/

comment on column CIPS_111_REMIT.DBTR_NAME is '付款人_个人或组织名称'
/

comment on column CIPS_111_REMIT.DBTR_ADR_DEPT is '付款人_地址_部门'
/

comment on column CIPS_111_REMIT.DBTR_ADR_SDEPT is '付款人_地址_分部'
/

comment on column CIPS_111_REMIT.DBTR_ADR_STRT_NM is '付款人_地址_街道名称'
/

comment on column CIPS_111_REMIT.DBTR_ADR_BLDG_NB is '付款人_地址_建筑编号'
/

comment on column CIPS_111_REMIT.DBTR_ADR_BLDG_NM is '付款人_地址_建筑名称'
/

comment on column CIPS_111_REMIT.DBTR_ADR_FLR is '付款人_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.DBTR_ADR_PST_BX is '付款人_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.DBTR_ADR_ROOM is '付款人_地址_房间号'
/

comment on column CIPS_111_REMIT.DBTR_ADR_PST_CD is '付款人_地址_邮政编码'
/

comment on column CIPS_111_REMIT.DBTR_ADR_TWN is '付款人_地址_城镇名称'
/

comment on column CIPS_111_REMIT.DBTR_ADR_TWN_LOC is '付款人_地址_城镇地址'
/

comment on column CIPS_111_REMIT.DBTR_ADR_DSTRCT is '付款人_地址_地区名称'
/

comment on column CIPS_111_REMIT.DBTR_ADR_AREA is '付款人_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.DBTR_ADR_CTRY is '付款人_地址_国家'
/

comment on column CIPS_111_REMIT.DBTR_ADR_ADR_LINE1 is '付款人_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.DBTR_ADR_ADR_LINE2 is '付款人_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.DBTR_C_BIC is '付款人_【组织】BIC码'
/

comment on column CIPS_111_REMIT.DBTR_C_LEI is '付款人_【组织】LEI码'
/

comment on column CIPS_111_REMIT.DBTR_C_ID1 is '付款人_【组织】CIPS ID或组织机构代码1'
/

comment on column CIPS_111_REMIT.DBTR_C_ID2 is '付款人_【组织】CIPS ID或组织机构代码2'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_SCHE1 is '付款人_【组织】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_SCHE2 is '付款人_【组织】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_SCHEX1 is '付款人_【组织】身份标识方案名称（自定义内容）1'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_SCHEX2 is '付款人_【组织】身份标识方案名称（自定义内容）2'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_ISSR1 is '付款人_【组织】发码方1'
/

comment on column CIPS_111_REMIT.DBTR_C_ID_ISSR2 is '付款人_【组织】发码方2'
/

comment on column CIPS_111_REMIT.DBTR_P_BIRTH_DATE is '付款人_【个人】出生日期'
/

comment on column CIPS_111_REMIT.DBTR_P_BIRTH_PRVC is '付款人_【个人】出生省份'
/

comment on column CIPS_111_REMIT.DBTR_P_BIRTH_CITY is '付款人_【个人】出生城市'
/

comment on column CIPS_111_REMIT.DBTR_P_BIRTH_CTRY is '付款人_【个人】出生国家'
/

comment on column CIPS_111_REMIT.DBTR_P_ID1 is '付款人_【个人】证件号码1'
/

comment on column CIPS_111_REMIT.DBTR_P_ID2 is '付款人_【个人】证件号码2'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_SCHE1 is '付款人_【个人】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_SCHE2 is '付款人_【个人】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_SCHEX1 is '付款人_【个人】证件类型1'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_SCHEX2 is '付款人_【个人】证件类型2'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_ISSR1 is '付款人_【个人】发码方1'
/

comment on column CIPS_111_REMIT.DBTR_P_ID_ISSR2 is '付款人_【个人】发码方2'
/

comment on column CIPS_111_REMIT.DBTR_RES_CTRY is '付款人_居住国家'
/

comment on column CIPS_111_REMIT.DBTR_AC_IBAN is '付款人账户_IBAN码'
/

comment on column CIPS_111_REMIT.DBTR_AC_ID is '付款人账户_账号'
/

comment on column CIPS_111_REMIT.DBTR_AC_ID_SCHE is '付款人账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.DBTR_AC_ID_SCHEX is '付款人账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AC_ID_ISSR is '付款人账户_发码方'
/

comment on column CIPS_111_REMIT.DBTR_AC_TYPE is '付款人账户_类型代码'
/

comment on column CIPS_111_REMIT.DBTR_AC_TYPEX is '付款人账户_用途说明'
/

comment on column CIPS_111_REMIT.DBTR_AC_CCY is '付款人账户_币种'
/

comment on column CIPS_111_REMIT.DBTR_AC_NAME is '付款人账户_名称'
/

comment on column CIPS_111_REMIT.DBTR_AC_AKA_ID_TP is '付款人账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.DBTR_AC_AKA_ID_TPX is '付款人账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AC_AKA_ID is '付款人账户_账户别名'
/

comment on column CIPS_111_REMIT.DBTR_AGT_BIC is '付款人开户行_BIC码'
/

comment on column CIPS_111_REMIT.DBTR_AGT_CLR_SYS is '付款人开户行_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_CLR_SYSX is '付款人开户行_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_CLR_SYS_MMBID is '付款人开户行_参与者身份标识'
/

comment on column CIPS_111_REMIT.DBTR_AGT_LEI is '付款人开户行_LEI码'
/

comment on column CIPS_111_REMIT.DBTR_AGT_NAME is '付款人开户行_名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_DEPT is '付款人开户行_地址_部门'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_SDEPT is '付款人开户行_地址_分部'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_STRT_NM is '付款人开户行_地址_街道名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_BLDG_NB is '付款人开户行_地址_建筑编号'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_BLDG_NM is '付款人开户行_地址_建筑名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_FLR is '付款人开户行_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_PST_BX is '付款人开户行_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_ROOM is '付款人开户行_地址_房间号'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_PST_CD is '付款人开户行_地址_邮政编码'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_TWN is '付款人开户行_地址_城镇名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_TWN_LOC is '付款人开户行_地址_城镇地址'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_DSTRCT is '付款人开户行_地址_地区名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_AREA is '付款人开户行_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_CTRY is '付款人开户行_地址_国家'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_ADR_LINE1 is '付款人开户行_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ADR_ADR_LINE2 is '付款人开户行_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ID is '付款人开户行_账号'
/

comment on column CIPS_111_REMIT.DBTR_AGT_ID_SCHEX is '付款人开户行_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_IBAN is '付款人开户行账户_IBAN码'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_ID is '付款人开户行账户_账号'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_ID_SCHE is '付款人开户行账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_ID_SCHEX is '付款人开户行账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_ID_ISSR is '付款人开户行账户_发码方'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_TYPE is '付款人开户行账户_类型代码'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_TYPEX is '付款人开户行账户_用途说明'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_CCY is '付款人开户行账户_币种'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_NAME is '付款人开户行账户_名称'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_AKA_ID_TP is '付款人开户行账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_AKA_ID_TPX is '付款人开户行账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.DBTR_AGT_AC_AKA_ID is '付款人开户行账户_账户别名'
/

comment on column CIPS_111_REMIT.CDTR_AGT_BRANCH_ID is '收款人开户行_分支机构'
/

comment on column CIPS_111_REMIT.CDTR_AGT_BIC is '收款人开户行_BIC码'
/

comment on column CIPS_111_REMIT.CDTR_AGT_CLR_SYS is '收款人开户行_清算系统标识（代码）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_CLR_SYSX is '收款人开户行_清算系统标识（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_CLR_SYS_MMBID is '收款人开户行_参与者身份标识'
/

comment on column CIPS_111_REMIT.CDTR_AGT_LEI is '收款人开户行_LEI码'
/

comment on column CIPS_111_REMIT.CDTR_AGT_NAME is '收款人开户行_名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_DEPT is '收款人开户行_地址_部门'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_SDEPT is '收款人开户行_地址_分部'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_STRT_NM is '收款人开户行_地址_街道名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_BLDG_NB is '收款人开户行_地址_建筑编号'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_BLDG_NM is '收款人开户行_地址_建筑名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_FLR is '收款人开户行_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_PST_BX is '收款人开户行_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_ROOM is '收款人开户行_地址_房间号'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_PST_CD is '收款人开户行_地址_邮政编码'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_TWN is '收款人开户行_地址_城镇名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_TWN_LOC is '收款人开户行_地址_城镇地址'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_DSTRCT is '收款人开户行_地址_地区名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_AREA is '收款人开户行_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_CTRY is '收款人开户行_地址_国家'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_ADR_LINE1 is '收款人开户行_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ADR_ADR_LINE2 is '收款人开户行_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ID is '收款人开户行_账号'
/

comment on column CIPS_111_REMIT.CDTR_AGT_ID_SCHEX is '收款人开户行_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_IBAN is '收款人开户行账户_IBAN码'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_ID is '收款人开户行账户_账号'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_ID_SCHE is '收款人开户行账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_ID_SCHEX is '收款人开户行账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_ID_ISSR is '收款人开户行账户_发码方'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_TYPE is '收款人开户行账户_类型代码'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_TYPEX is '收款人开户行账户_用途说明'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_CCY is '收款人开户行账户_币种'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_NAME is '收款人开户行账户_名称'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_AKA_ID_TP is '收款人开户行账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_AKA_ID_TPX is '收款人开户行账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AGT_AC_AKA_ID is '收款人开户行账户_账户别名'
/

comment on column CIPS_111_REMIT.CDTR_NAME is '收款人_个人或组织名称'
/

comment on column CIPS_111_REMIT.CDTR_ADR_DEPT is '收款人_地址_部门'
/

comment on column CIPS_111_REMIT.CDTR_ADR_SDEPT is '收款人_地址_分部'
/

comment on column CIPS_111_REMIT.CDTR_ADR_STRT_NM is '收款人_地址_街道名称'
/

comment on column CIPS_111_REMIT.CDTR_ADR_BLDG_NB is '收款人_地址_建筑编号'
/

comment on column CIPS_111_REMIT.CDTR_ADR_BLDG_NM is '收款人_地址_建筑名称'
/

comment on column CIPS_111_REMIT.CDTR_ADR_FLR is '收款人_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.CDTR_ADR_PST_BX is '收款人_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.CDTR_ADR_ROOM is '收款人_地址_房间号'
/

comment on column CIPS_111_REMIT.CDTR_ADR_PST_CD is '收款人_地址_邮政编码'
/

comment on column CIPS_111_REMIT.CDTR_ADR_TWN is '收款人_地址_城镇名称'
/

comment on column CIPS_111_REMIT.CDTR_ADR_TWN_LOC is '收款人_地址_城镇地址'
/

comment on column CIPS_111_REMIT.CDTR_ADR_DSTRCT is '收款人_地址_地区名称'
/

comment on column CIPS_111_REMIT.CDTR_ADR_AREA is '收款人_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.CDTR_ADR_CTRY is '收款人_地址_国家'
/

comment on column CIPS_111_REMIT.CDTR_ADR_ADR_LINE1 is '收款人_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.CDTR_ADR_ADR_LINE2 is '收款人_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.CDTR_C_BIC is '收款人_【组织】BIC码'
/

comment on column CIPS_111_REMIT.CDTR_C_LEI is '收款人_【组织】LEI码'
/

comment on column CIPS_111_REMIT.CDTR_C_ID1 is '收款人_【组织】CIPS ID或组织机构代码1'
/

comment on column CIPS_111_REMIT.CDTR_C_ID2 is '收款人_【组织】CIPS ID或组织机构代码2'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_SCHE1 is '收款人_【组织】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_SCHE2 is '收款人_【组织】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_SCHEX1 is '收款人_【组织】身份标识方案名称（自定义内容）1'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_SCHEX2 is '收款人_【组织】身份标识方案名称（自定义内容）2'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_ISSR1 is '收款人_【组织】发码方1'
/

comment on column CIPS_111_REMIT.CDTR_C_ID_ISSR2 is '收款人_【组织】发码方2'
/

comment on column CIPS_111_REMIT.CDTR_P_BIRTH_DATE is '收款人_【个人】出生日期'
/

comment on column CIPS_111_REMIT.CDTR_P_BIRTH_PRVC is '收款人_【个人】出生省份'
/

comment on column CIPS_111_REMIT.CDTR_P_BIRTH_CITY is '收款人_【个人】出生城市'
/

comment on column CIPS_111_REMIT.CDTR_P_BIRTH_CTRY is '收款人_【个人】出生国家'
/

comment on column CIPS_111_REMIT.CDTR_P_ID1 is '收款人_【个人】证件号码1'
/

comment on column CIPS_111_REMIT.CDTR_P_ID2 is '收款人_【个人】证件号码2'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_SCHE1 is '收款人_【个人】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_SCHE2 is '收款人_【个人】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_SCHEX1 is '收款人_【个人】证件类型1'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_SCHEX2 is '收款人_【个人】证件类型2'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_ISSR1 is '收款人_【个人】发码方1'
/

comment on column CIPS_111_REMIT.CDTR_P_ID_ISSR2 is '收款人_【个人】发码方2'
/

comment on column CIPS_111_REMIT.CDTR_RES_CTRY is '收款人_居住国家'
/

comment on column CIPS_111_REMIT.CDTR_AC_IBAN is '收款人账户_IBAN码'
/

comment on column CIPS_111_REMIT.CDTR_AC_ID is '收款人账户_账号'
/

comment on column CIPS_111_REMIT.CDTR_AC_ID_SCHE is '收款人账户_身份标识方案名称（代码）'
/

comment on column CIPS_111_REMIT.CDTR_AC_ID_SCHEX is '收款人账户_身份标识方案名称（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AC_ID_ISSR is '收款人账户_发码方'
/

comment on column CIPS_111_REMIT.CDTR_AC_TYPE is '收款人账户_类型代码'
/

comment on column CIPS_111_REMIT.CDTR_AC_TYPEX is '收款人账户_用途说明'
/

comment on column CIPS_111_REMIT.CDTR_AC_CCY is '收款人账户_币种'
/

comment on column CIPS_111_REMIT.CDTR_AC_NAME is '收款人账户_名称'
/

comment on column CIPS_111_REMIT.CDTR_AC_AKA_ID_TP is '收款人账户_账户别名类型（代码）'
/

comment on column CIPS_111_REMIT.CDTR_AC_AKA_ID_TPX is '收款人账户_账户别名类型（自定义内容）'
/

comment on column CIPS_111_REMIT.CDTR_AC_AKA_ID is '收款人账户_账户别名'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_NAME is '最终收款人_个人或组织名称'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_DEPT is '最终收款人_地址_部门'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_SDEPT is '最终收款人_地址_分部'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_STRT_NM is '最终收款人_地址_街道名称'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_BLDG_NB is '最终收款人_地址_建筑编号'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_BLDG_NM is '最终收款人_地址_建筑名称'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_FLR is '最终收款人_地址_建筑楼层'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_PST_BX is '最终收款人_地址_邮政信箱'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_ROOM is '最终收款人_地址_房间号'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_PST_CD is '最终收款人_地址_邮政编码'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_TWN is '最终收款人_地址_城镇名称'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_TWN_LOC is '最终收款人_地址_城镇地址'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_DSTRCT is '最终收款人_地址_地区名称'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_AREA is '最终收款人_地址_国家区域（区/洲）'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_CTRY is '最终收款人_地址_国家'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_ADR_LINE1 is '最终收款人_地址_自由格式地址1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_ADR_ADR_LINE2 is '最终收款人_地址_自由格式地址2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_BIC is '最终收款人_【组织】BIC码'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_LEI is '最终收款人_【组织】LEI码'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID1 is '最终收款人_【组织】CIPS ID或组织机构代码1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID2 is '最终收款人_【组织】CIPS ID或组织机构代码2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_SCHE1 is '最终收款人_【组织】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_SCHE2 is '最终收款人_【组织】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_SCHEX1 is '最终收款人_【组织】身份标识方案名称（自定义内容）1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_SCHEX2 is '最终收款人_【组织】身份标识方案名称（自定义内容）2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_ISSR1 is '最终收款人_【组织】发码方1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_C_ID_ISSR2 is '最终收款人_【组织】发码方2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_BIRTH_DATE is '最终收款人_【个人】出生日期'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_BIRTH_PRVC is '最终收款人_【个人】出生省份'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_BIRTH_CITY is '最终收款人_【个人】出生城市'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_BIRTH_CTRY is '最终收款人_【个人】出生国家'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID1 is '最终收款人_【个人】证件号码1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID2 is '最终收款人_【个人】证件号码2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_SCHE1 is '最终收款人_【个人】身份标识方案名称（代码）1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_SCHE2 is '最终收款人_【个人】身份标识方案名称（代码）2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_SCHEX1 is '最终收款人_【个人】证件类型1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_SCHEX2 is '最终收款人_【个人】证件类型2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_ISSR1 is '最终收款人_【个人】发码方1'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_P_ID_ISSR2 is '最终收款人_【个人】发码方2'
/

comment on column CIPS_111_REMIT.ULTMT_CDTR_RES_CTRY is '最终收款人_居住国家'
/

comment on column CIPS_111_REMIT.INSTR_FOR_CDTR_AGT1 is '至收款行开户行附言1'
/

comment on column CIPS_111_REMIT.INSTR_FOR_CDTR_AGT2 is '至收款行开户行附言2'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT1 is '至收报行的附言1'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT2 is '至收报行的附言2'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT3 is '至收报行的附言3'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT4 is '至收报行的附言4'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT5 is '至收报行的附言5'
/

comment on column CIPS_111_REMIT.INSTR_FOR_NXT_AGT6 is '至收报行的附言6'
/

comment on column CIPS_111_REMIT.PURP is '付款目的'
/

comment on column CIPS_111_REMIT.PURPX is '付款目的Proprietary'
/

comment on column CIPS_111_REMIT.RMT_INF is '附言'
/

comment on column CIPS_111_REMIT.PLC_AND_NM is 'PLC_AND_NM'
/

comment on column CIPS_111_REMIT.XPCTD_STTLM_DT is '结算时间'
/

comment on column CIPS_111_REMIT.DAY_NIGHT_FLG is '日间夜间标志'
/

comment on column CIPS_111_REMIT.RSV1 is '备用1'
/

comment on column CIPS_111_REMIT.RSV2 is '备用2'
/

comment on column CIPS_111_REMIT.RSV3 is '备用3'
/

comment on column CIPS_111_REMIT.RSV4 is '备用4'
/

comment on column CIPS_111_REMIT.RSV5 is '备用5'
/

