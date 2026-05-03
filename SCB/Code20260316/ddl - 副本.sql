-- CIPS_TXN新增VIP标志字段
ALTER TABLE CIPS_TXN ADD VIP_ACTNO_FLAG VARCHAR2(2);
COMMENT ON COLUMN CIPS_TXN.VIP_ACTNO_FLAG IS 'VIP账户等级';

--- SCB_VIPACCT_INFO 表添加 VIP_TYPE 字段

ALTER TABLE SCB_VIPACCT_INFO ADD VIP_TYPE VARCHAR2(1);

--- SCB_VIPACCT_INFO_TMP表添加 VIP_TYPE 字段

ALTER TABLE SCB_VIPACCT_INFO_TMP ADD VIP_TYPE VARCHAR2(1);


--来往账查询增加VIP等级查询
create or replace view SCB_TXN_SUMMARY as
SELECT
    A.MSG_TYPE,
    A.TXN_SEQ_NO,
    A.TXN_SRC,
    A.WORK_DATE,
    A.TXN_DIR,
    A.MSG_ID,
    A.VIP_ACTNO_FLAG AS VIP_LEVEL,
    '' AS TXN_ID,
    A.CENTER_DATE,
    A.DAY_NIGHT_FLG,
    A.AMT,
    A.REF_NO,
    B.INTR_DATE,
    A.TXN_STATUS,
    A.COMM_STATUS,
    A.PBOC_STATUS,
    A.BIZ_PROC_INFO,
    A.MSG_NO,
    A.CORE_FWD_FLAG,
    A.CORE_PROC_CODE,
    A.CORE_ACK_TIME,
    A.CORE_PROC_STATUS,
    A.CORE_PROC_STATUS_SCPAY,
    A.CORE_FWD_FLAG_SCPAY,
    B.E2E_ID,
    B.BIZ_CATE_CODE,
    A.MADE_USER,
    A.MADE_TIME,
    A.CHK_USER,
    A.CHK_TIME,
    A.APV_USER,
    A.APV_TIME,
    B.MSG_SND_TIME,
    B.ST_TIME,
    A.BIZ_REJ_INFO,
    A.SCB_PRIORITY,
    A.ORG_ID,
    A.LARGE_AMT_FLG,
    A.UPD_TIME,
    A.UPD_TIME AS TXN_TIME,
    B.PAYER_ST_BRNO,
    B.PAYER_ST_BRNAME,
    B.PAYER_BRNO,
    B.PAYER_BRNAME,
    B.PAYER_ACCT_BRNO,
    B.PAYER_ACCT_BRNAME,
    B.PAYER_ACTNO,
    '' AS PAYER_BR_BRNO,
    B.PAYER_NAME,
    B.PAYER_ADDR_M,
    B.PAYEE_ST_BRNO,
    B.PAYEE_ST_BRNAME,
    B.PAYEE_BRNO,
    B.PAYEE_BRNAME,
    B.PAYEE_ACCT_BRNO,
    B.PAYEE_ACCT_BRNAME,
    B.PAYEE_ACTNO,
    '' AS PAYEE_BR_BRNO,
    B.PAYEE_NAME,
    B.PAYEE_ADDR_M,
    B.PS1,
    B.PS2,
    B.PS3,
    B.PS4,
    B.IM1_BANK,
    B.IM1_NAME,
    B.IM2_BANK,
    B.IM2_NAME,
    B.CHARGE_BEARER,
    B.BIZ_PRIO,
    B.RATE,
    B.ORI_AMT_CURCD,
    B.ORI_AMT,
    B.FEE1_AMT,
    B.FEE1_BRNO,
    B.FEE2_AMT,
    B.FEE2_BRNO,
    ''     AS ORI_MSG_ID,
    ''     AS COV_PAYER_ACTNO,
    ''     AS COV_PAYER_NAME,
    ''     AS COV_PAYER_ADDR_M,
    ''     AS COV_PAYER_ACCT_BRNO,
    ''     AS COV_PAYER_ACCT_BRNAME,
    ''     AS COV_IM1_BANK,
    ''     AS COV_IM1_NAME,
    ''     AS COV_PAYEE_ACCT_BRNO,
    ''     AS COV_PAYEE_ACCT_BRNAME,
    ''     AS COV_PAYEE_ACTNO,
    ''     AS COV_PAYEE_NAME,
    ''     AS COV_PAYEE_ADDR_M,
    ''     AS COV_AMT_CURCD,
    NULL   AS COV_AMT,
    ''     AS COV_PS1,
    ''     AS COV_PS2,
    ''     AS COV_PS3,
    ''     AS COV_PS4,
    B.RSV5 AS MSG_RCV_TIME,
    B.INS_INFORMATION_M AS INS_INFORMATION,
    A.BATCH_ID,
    A.BIZ_CNCL_INFO,
    B.ORDER_ID,
    B.ORDER_DESC_M,
    B.PAYER_ORG_ID,
    B.PAYER_ID_NO,
    B.PAYER_ID_TYPE,
    B.PAYER_RES_CTRY,
    B.PAYER_BR_ADDR1,
    B.PAYER_BR_ACTNO,
    B.PAYER_EID,
    B.PAYEE_ORG_ID,
    B.PAYEE_ID_NO,
    B.PAYEE_ID_TYPE,
    B.PAYEE_RES_CTRY,
    B.PAYEE_BR_ADDR1,
    B.PAYEE_BR_ACTNO,
    B.PAYEE_EID,
    '' AS COV_PAYER_ORG_ID,
    '' AS COV_PAYER_ID_NO,
    '' AS COV_PAYER_ID_TYPE,
    '' AS COV_PAYER_RES_CTRY,
    '' AS COV_PAYER_BR_ADDR_M,
    '' AS COV_PAYER_BR_ACTNO,
    '' AS COV_PAYER_EID,
    '' AS COV_PAYEE_ORG_ID,
    '' AS COV_PAYEE_ID_NO,
    '' AS COV_PAYEE_ID_TYPE,
    '' AS COV_PAYEE_RES_CTRY,
    '' AS COV_PAYEE_BR_ADDR_M,
    '' AS COV_PAYEE_BR_ACTNO,
    '' AS COV_PAYEE_EID,
    '' AS NET_DATE,
    '' AS NET_ROUND,
    A.DC_FLAG,
    '' AS REF_NO_153,
    '' AS PRTRY_STATUS_153,
    '' AS ORI_MSG_ID_153,
    '' AS ORI_ST_SND_BRNO_153,
    '' AS ORI_ST_SND_BRNAME_153,
    '' AS ORI_SND_BRNO_153,
    '' AS ORI_SND_BRNAME_153,
    '' AS RT_BIZ_STATUS_153,
    '' AS BIZ_REJ_INFO_153,
		'' AS IS_CHARGE,
    '' AS ORI_109_MSG_ID,
		'' AS ORI_111_REF_ID,
		'' AS FEE_MATCH
FROM
    CIPS_TXN A
LEFT JOIN
    CIPS_111 B
ON
    A.SEQ_NO = B.SEQ_NO
WHERE
    A.MSG_NO = '111'
UNION ALL
SELECT
    A.MSG_TYPE,
    A.TXN_SEQ_NO,
    A.TXN_SRC,
    A.WORK_DATE,
    A.TXN_DIR,
    A.MSG_ID,
    '' as VIP_LEVEL,
    A.TXN_ID,
    A.CENTER_DATE,
    A.DAY_NIGHT_FLG,
    A.AMT,
    A.REF_NO,
    B.INTR_DATE,
    A.TXN_STATUS,
    A.COMM_STATUS,
    A.PBOC_STATUS,
    A.BIZ_PROC_INFO,
    A.MSG_NO,
    A.CORE_FWD_FLAG,
    A.CORE_PROC_CODE,
    A.CORE_ACK_TIME,
    A.CORE_PROC_STATUS,
    A.CORE_PROC_STATUS_SCPAY,
    A.CORE_FWD_FLAG_SCPAY,
    B.E2E_ID,
    B.BIZ_CATE_CODE,
    A.MADE_USER,
    A.MADE_TIME,
    A.CHK_USER,
    A.CHK_TIME,
    A.APV_USER,
    A.APV_TIME,
    B.MSG_SND_TIME,
    B.ST_TIME,
    A.BIZ_REJ_INFO,
    A.SCB_PRIORITY,
    A.ORG_ID,
    A.LARGE_AMT_FLG,
    A.UPD_TIME,
    A.UPD_TIME AS TXN_TIME,
    B.PAYER_ST_BRNO,
    B.PAYER_ST_BRNAME,
    B.PAYER_BRNO,
    B.PAYER_BRNAME,
    B.PAYER_ACCT_BRNO,
    B.PAYER_ACCT_BRNAME,
    B.PAYER_ACTNO,
    '' AS PAYER_BR_BRNO,
    B.PAYER_NAME,
    B.PAYER_ADDR_M,
    B.PAYEE_ST_BRNO,
    B.PAYEE_ST_BRNAME,
    B.PAYEE_BRNO,
    B.PAYEE_BRNAME,
    B.PAYEE_ACCT_BRNO,
    B.PAYEE_ACCT_BRNAME,
    B.PAYEE_ACTNO,
    '' AS PAYEE_BR_BRNO,
    B.PAYEE_NAME,
    B.PAYEE_ADDR_M,
    B.PS1,
    B.PS2,
    B.PS3,
    B.PS4,
    B.IM1_BANK,
    B.IM1_NAME,
    B.IM2_BANK,
    B.IM2_NAME,
    B.CHARGE_BEARER,
    B.BIZ_PRIO,
    B.RATE,
    B.ORI_AMT_CURCD,
    B.ORI_AMT,
    B.FEE1_AMT,
    B.FEE1_BRNO,
    B.FEE2_AMT,
    B.FEE2_BRNO,
    ''     AS ORI_MSG_ID,
    ''     AS COV_PAYER_ACTNO,
    ''     AS COV_PAYER_NAME,
    ''     AS COV_PAYER_ADDR_M,
    ''     AS COV_PAYER_ACCT_BRNO,
    ''     AS COV_PAYER_ACCT_BRNAME,
    ''     AS COV_IM1_BANK,
    ''     AS COV_IM1_NAME,
    ''     AS COV_PAYEE_ACCT_BRNO,
    ''     AS COV_PAYEE_ACCT_BRNAME,
    ''     AS COV_PAYEE_ACTNO,
    ''     AS COV_PAYEE_NAME,
    ''     AS COV_PAYEE_ADDR_M,
    ''     AS COV_AMT_CURCD,
    NULL   AS COV_AMT,
    ''     AS COV_PS1,
    ''     AS COV_PS2,
    ''     AS COV_PS3,
    ''     AS COV_PS4,
    B.RSV5 AS MSG_RCV_TIME,
    B.INS_INFORMATION_M AS INS_INFORMATION,
    A.BATCH_ID,
    A.BIZ_CNCL_INFO,
    B.ORDER_ID,
    B.ORDER_DESC_M,
    B.PAYER_ORG_ID,
    B.PAYER_ID_NO,
    B.PAYER_ID_TYPE,
    B.PAYER_RES_CTRY,
    B.PAYER_BR_ADDR1,
    B.PAYER_BR_ACTNO,
    B.PAYER_EID,
    B.PAYEE_ORG_ID,
    B.PAYEE_ID_NO,
    B.PAYEE_ID_TYPE,
    B.PAYEE_RES_CTRY,
    B.PAYEE_BR_ADDR1,
    B.PAYEE_BR_ACTNO,
    B.PAYEE_EID,
    '' AS COV_PAYER_ORG_ID,
    '' AS COV_PAYER_ID_NO,
    '' AS COV_PAYER_ID_TYPE,
    '' AS COV_PAYER_RES_CTRY,
    '' AS COV_PAYER_BR_ADDR_M,
    '' AS COV_PAYER_BR_ACTNO,
    '' AS COV_PAYER_EID,
    '' AS COV_PAYEE_ORG_ID,
    '' AS COV_PAYEE_ID_NO,
    '' AS COV_PAYEE_ID_TYPE,
    '' AS COV_PAYEE_RES_CTRY,
    '' AS COV_PAYEE_BR_ADDR_M,
    '' AS COV_PAYEE_BR_ACTNO,
    '' AS COV_PAYEE_EID,
    A.NET_DATE,
    A.NET_ROUND,
    A.DC_FLAG,
    '' AS REF_NO_153,
    '' AS PRTRY_STATUS_153,
    '' AS ORI_MSG_ID_153,
    '' AS ORI_ST_SND_BRNO_153,
    '' AS ORI_ST_SND_BRNAME_153,
    '' AS ORI_SND_BRNO_153,
    '' AS ORI_SND_BRNAME_153,
    '' AS RT_BIZ_STATUS_153,
    '' AS BIZ_REJ_INFO_153,
		'' AS IS_CHARGE,
    '' AS ORI_109_MSG_ID,
		'' AS ORI_111_REF_ID,
		'' AS FEE_MATCH
FROM
    CIPS_TXN A
LEFT JOIN
    CIPS_113 B
ON
    A.SEQ_NO = B.SEQ_NO
WHERE
    A.MSG_NO = '113'
UNION ALL
SELECT
    A.MSG_TYPE,
    A.TXN_SEQ_NO,
    A.TXN_SRC,
    A.WORK_DATE,
    A.TXN_DIR,
    A.MSG_ID,
        '' AS VIP_LEVEL,
    A.TXN_ID,
    A.CENTER_DATE,
    A.DAY_NIGHT_FLG,
    A.AMT,
    A.REF_NO,
    A.CENTER_DATE AS INTR_DATE,
    A.TXN_STATUS,
    A.COMM_STATUS,
    A.PBOC_STATUS,
    A.BIZ_PROC_INFO,
    A.MSG_NO,
    A.CORE_PROC_STATUS_SCPAY,
    A.CORE_FWD_FLAG_SCPAY,
    A.CORE_FWD_FLAG,
    A.CORE_PROC_CODE,
    A.CORE_ACK_TIME,
    A.CORE_PROC_STATUS,
    '' AS E2E_ID,
    '' AS BIZ_CATE_CODE,
    A.MADE_USER,
    A.MADE_TIME,
    A.CHK_USER,
    A.CHK_TIME,
    A.APV_USER,
    A.APV_TIME,
    B.MSG_SND_TIME,
    B.ST_TIME,
    A.BIZ_REJ_INFO,
    A.SCB_PRIORITY,
    A.ORG_ID,
    A.LARGE_AMT_FLG,
    A.UPD_TIME,
    A.UPD_TIME AS TXN_TIME,
    B.INSTG_AGT_BIC AS PAYER_ST_BRNO,
    '' AS PAYER_ST_BRNAME,
    B.PRE_AGT1_BIC AS PAYER_BRNO,
    B.PRE_AGT1_NAME AS PAYER_BRNAME,
    CASE
        WHEN B.DBTR_AGT_BIC IS NOT NULL THEN B.DBTR_AGT_BIC
            WHEN B.DBTR_AGT_CLR_SYS_MMBID IS NOT NULL THEN B.DBTR_AGT_CLR_SYS_MMBID
            ELSE
                ''
        END AS PAYER_ACCT_BRNO,
    B.DBTR_AGT_NAME AS PAYER_ACCT_BRNAME,
    B.DBTR_PTY_C_ID AS PAYER_ACTNO,
    B.DBTR_PTYF_BIC AS PAYER_BR_BRNO,
    B.DBTR_PTY_NAME AS PAYER_NAME,
    '' AS PAYER_ADDR_M,
    B.INSTD_AGT_BIC AS PAYEE_ST_BRNO,
    '' AS PAYEE_ST_BRNAME,
    B.IM_AGT1_BIC AS PAYEE_BRNO,
    B.IM_AGT1_NAME AS PAYEE_BRNAME,
    CASE
        WHEN B.CDTR_AGT_BIC IS NOT NULL THEN B.CDTR_AGT_BIC
            WHEN B.CDTR_AGT_CLR_SYS_MMBID IS NOT NULL THEN B.CDTR_AGT_CLR_SYS_MMBID
            ELSE
                ''
        END AS PAYEE_ACCT_BRNO,
    B.CDTR_AGT_NAME AS PAYEE_ACCT_BRNAME,
    B.CDTR_PTY_C_ID AS PAYEE_ACTNO,
    B.CDTR_PTYF_BIC AS PAYEE_BR_BRNO,
    B.CDTR_PTY_NAME AS PAYEE_NAME,
    '' AS PAYEE_ADDR_M,
    '' AS PS1,
    '' AS PS2,
    '' AS PS3,
    '' AS PS4,
    B.IM_AGT1_BIC AS IM1_BANK,
    B.IM_AGT1_NAME AS IM1_NAME,
    B.IM_AGT2_BIC AS IM2_BANK,
    B.IM_AGT2_NAME AS IM2_NAME,
    B.CHRG_BEAR AS CHARGE_BEARER,
    B.ST_PRIO AS BIZ_PRIO,
    '' AS RATE,
    B.OTXN_AMT_CURCD AS ORI_AMT_CURCD,
    B.OTXN_AMT AS ORI_AMT,
    NULL AS FEE1_AMT,
    '' AS FEE1_BRNO,
    NULL AS FEE2_AMT,
    '' AS FEE2_BRNO,
    ''     AS ORI_MSG_ID,
    ''     AS COV_PAYER_ACTNO,
    ''     AS COV_PAYER_NAME,
    ''     AS COV_PAYER_ADDR_M,
    ''     AS COV_PAYER_ACCT_BRNO,
    ''     AS COV_PAYER_ACCT_BRNAME,
    ''     AS COV_IM1_BANK,
    ''     AS COV_IM1_NAME,
    ''     AS COV_PAYEE_ACCT_BRNO,
    ''     AS COV_PAYEE_ACCT_BRNAME,
    ''     AS COV_PAYEE_ACTNO,
    ''     AS COV_PAYEE_NAME,
    ''     AS COV_PAYEE_ADDR_M,
    ''     AS COV_AMT_CURCD,
    NULL   AS COV_AMT,
    ''     AS COV_PS1,
    ''     AS COV_PS2,
    ''     AS COV_PS3,
    ''     AS COV_PS4,
    B.RSV5 AS MSG_RCV_TIME,
    A.INS_INFORMATION,
    A.BATCH_ID,
    A.BIZ_CNCL_INFO,
    '' AS ORDER_ID,
    '' AS ORDER_DESC_M,
    B.UDBTR_C_ID AS PAYER_ORG_ID,
    B.UDBTR_P_ID AS PAYER_ID_NO,
    B.UDBTR_P_ID_SCHEX AS PAYER_ID_TYPE,
    '' AS PAYER_RES_CTRY,
    '' AS PAYER_BR_ADDR1,
    '' AS PAYER_BR_ACTNO,
    '' AS PAYER_EID,
    B.UCDTR_C_ID AS PAYEE_ORG_ID,
    B.UCDTR_P_ID AS PAYEE_ID_NO,
    B.UCDTR_P_ID_SCHEX AS PAYEE_ID_TYPE,
    '' AS PAYEE_RES_CTRY,
    '' AS PAYEE_BR_ADDR1,
    '' AS PAYEE_BR_ACTNO,
    '' AS PAYEE_EID,
    '' AS COV_PAYER_ORG_ID,
    '' AS COV_PAYER_ID_NO,
    '' AS COV_PAYER_ID_TYPE,
    '' AS COV_PAYER_RES_CTRY,
    '' AS COV_PAYER_BR_ADDR_M,
    '' AS COV_PAYER_BR_ACTNO,
    '' AS COV_PAYER_EID,
    '' AS COV_PAYEE_ORG_ID,
    '' AS COV_PAYEE_ID_NO,
    '' AS COV_PAYEE_ID_TYPE,
    '' AS COV_PAYEE_RES_CTRY,
    '' AS COV_PAYEE_BR_ADDR_M,
    '' AS COV_PAYEE_BR_ACTNO,
    '' AS COV_PAYEE_EID,
    A.NET_DATE,
    A.NET_ROUND,
    A.DC_FLAG,
    '' AS REF_NO_153,
    '' AS PRTRY_STATUS_153,
    '' AS ORI_MSG_ID_153,
    '' AS ORI_ST_SND_BRNO_153,
    '' AS ORI_ST_SND_BRNAME_153,
    '' AS ORI_SND_BRNO_153,
    '' AS ORI_SND_BRNAME_153,
    '' AS RT_BIZ_STATUS_153,
    '' AS BIZ_REJ_INFO_153,
    '' AS IS_CHARGE,
    '' AS ORI_109_MSG_ID,
		'' AS ORI_111_REF_ID,
		'' AS FEE_MATCH
FROM
    CIPS_TXN A
LEFT JOIN
    CIPS_114 B
ON
    A.SEQ_NO = B.SEQ_NO
WHERE
    A.MSG_NO = '114'
UNION ALL
SELECT
    A.MSG_TYPE,
    A.TXN_SEQ_NO,
    A.TXN_SRC,
    A.WORK_DATE,
    A.TXN_DIR,
    A.MSG_ID,
    A.VIP_ACTNO_FLAG AS VIP_LEVEL,
    '' AS TXN_ID,
    A.CENTER_DATE,
    A.DAY_NIGHT_FLG,
    A.AMT,
    A.REF_NO,
    B.INTR_DATE,
    A.TXN_STATUS,
    A.COMM_STATUS,
    A.PBOC_STATUS,
    A.BIZ_PROC_INFO,
    A.MSG_NO,
    A.CORE_FWD_FLAG,
    A.CORE_PROC_CODE,
    A.CORE_ACK_TIME,
    A.CORE_PROC_STATUS,
    A.CORE_PROC_STATUS_SCPAY,
    A.CORE_FWD_FLAG_SCPAY,
    B.E2E_ID,
    B.BIZ_CATE_CODE,
    A.MADE_USER,
    A.MADE_TIME,
    A.CHK_USER,
    A.CHK_TIME,
    A.APV_USER,
    A.APV_TIME,
    B.MSG_SND_TIME,
    B.ST_TIME,
    A.BIZ_REJ_INFO,
    A.SCB_PRIORITY,
    A.ORG_ID,
    A.LARGE_AMT_FLG,
    A.UPD_TIME,
    A.UPD_TIME AS TXN_TIME,
    B.PAYER_ST_BRNO,
    B.PAYER_ST_BRNAME,
    B.PAYER_BRNO,
    B.PAYER_BRNAME,
    B.PAYER_ACCT_BRNO,
    B.PAYER_ACCT_BRNAME,
    B.PAYER_ACTNO,
    B.PAYER_BR_BRNO,
    B.PAYER_NAME,
    B.PAYER_ADDR_M,
    B.PAYEE_ST_BRNO,
    B.PAYEE_ST_BRNAME,
    B.PAYEE_BRNO,
    B.PAYEE_BRNAME,
    B.PAYEE_ACCT_BRNO,
    B.PAYEE_ACCT_BRNAME,
    B.PAYEE_ACTNO,
    B.PAYEE_BR_BRNO,
    B.PAYEE_NAME,
    B.PAYEE_ADDR_M,
    B.PS1,
    B.PS2,
    B.PS3,
    B.PS4,
    B.IM1_BANK,
    B.IM1_NAME,
    B.IM2_BANK,
    B.IM2_NAME,
    '' AS CHARGE_BEARER,
    B.BIZ_PRIO,
    ''   AS RATE,
    ''   AS ORI_AMT_CURCD,
    NULL AS ORI_AMT,
    NULL AS FEE1_AMT,
    ''   AS FEE1_BRNO,
    NULL AS FEE2_AMT,
    ''   AS FEE2_BRNO,
    B.ORI_MSG_ID,
    B.COV_PAYER_ACTNO,
    B.COV_PAYER_NAME,
    B.COV_PAYER_ADDR_M,
    B.COV_PAYER_ACCT_BRNO,
    B.COV_PAYER_ACCT_BRNAME,
    B.COV_IM1_BANK,
    B.COV_IM1_NAME,
    B.COV_PAYEE_ACCT_BRNO,
    B.COV_PAYEE_ACCT_BRNAME,
    B.COV_PAYEE_ACTNO,
    B.COV_PAYEE_NAME,
    B.COV_PAYEE_ADDR_M,
    B.COV_AMT_CURCD,
    B.COV_AMT,
    B.COV_PS1,
    B.COV_PS2,
    B.COV_PS3,
    B.COV_PS4,
    B.RSV5 AS MSG_RCV_TIME,
    B.INS_INFORMATION_M AS INS_INFORMATION,
    A.BATCH_ID,
    A.BIZ_CNCL_INFO,
    B.ORDER_ID,
    B.ORDER_DESC AS ORDER_DESC_M,
    ''           AS PAYER_ORG_ID,
    ''           AS PAYER_ID_NO,
    ''           AS PAYER_ID_TYPE,
    ''           AS PAYER_RES_CTRY,
    ''           AS PAYER_BR_ADDR1,
    ''           AS PAYER_BR_ACTNO,
    ''           AS PAYER_EID,
    ''           AS PAYEE_ORG_ID,
    ''           AS PAYEE_ID_NO,
    ''           AS PAYEE_ID_TYPE,
    ''           AS PAYEE_RES_CTRY,
    ''           AS PAYEE_BR_ADDR1,
    ''           AS PAYEE_BR_ACTNO,
    ''           AS PAYEE_EID,
    B.COV_PAYER_ORG_ID,
    B.COV_PAYER_ID_NO,
    B.COV_PAYER_ID_TYPE,
    B.COV_PAYER_RES_CTRY,
    B.COV_PAYER_BR_ADDR_M,
    B.COV_PAYER_BR_ACTNO,
    B.COV_PAYER_EID,
    B.COV_PAYEE_ORG_ID,
    B.COV_PAYEE_ID_NO,
    B.COV_PAYEE_ID_TYPE,
    B.COV_PAYEE_RES_CTRY,
    B.COV_PAYEE_BR_ADDR_M,
    B.COV_PAYEE_BR_ACTNO,
    B.COV_PAYEE_EID,
    '' AS NET_DATE,
    '' AS NET_ROUND,
    A.DC_FLAG,
    '' AS REF_NO_153,
    '' AS PRTRY_STATUS_153,
    '' AS ORI_MSG_ID_153,
    '' AS ORI_ST_SND_BRNO_153,
    '' AS ORI_ST_SND_BRNAME_153,
    '' AS ORI_SND_BRNO_153,
    '' AS ORI_SND_BRNAME_153,
    '' AS RT_BIZ_STATUS_153,
    '' AS BIZ_REJ_INFO_153,
		B.IS_CHARGE AS IS_CHARGE,
    B.ORI_109_MSG_ID AS ORI_109_MSG_ID,
		B.ORI_111_REF_ID AS ORI_111_REF_ID,
		B.FEE_MATCH AS FEE_MATCH
FROM
    CIPS_TXN A
LEFT JOIN
    CIPS_112 B
ON
    A.SEQ_NO = B.SEQ_NO
WHERE
    A.MSG_NO = '112'
UNION ALL
SELECT
    A.MSG_TYPE,
    A.TXN_SEQ_NO,
    A.TXN_SRC,
    A.WORK_DATE,
    A.TXN_DIR,
    A.MSG_ID,
        '' AS VIP_LEVEL,
    A.TXN_ID,
    A.CENTER_DATE,
    A.DAY_NIGHT_FLG,
    A.AMT,
    A.REF_NO,
    '' AS INTR_DATE,
    A.TXN_STATUS,
    A.COMM_STATUS,
    A.PBOC_STATUS,
    A.BIZ_PROC_INFO,
    A.MSG_NO,
    A.CORE_FWD_FLAG,
    A.CORE_PROC_CODE,
    A.CORE_ACK_TIME,
    A.CORE_PROC_STATUS,
    A.CORE_PROC_STATUS_SCPAY,
    A.CORE_FWD_FLAG_SCPAY,
    B.E2E_ID,
    B.BIZ_CATE_CODE,
    A.MADE_USER,
    A.MADE_TIME,
    A.CHK_USER,
    A.CHK_TIME,
    A.APV_USER,
    A.APV_TIME,
    B.MSG_SND_TIME,
    '' AS ST_TIME,
    A.BIZ_REJ_INFO,
    A.SCB_PRIORITY,
    A.ORG_ID,
    A.LARGE_AMT_FLG,
    A.UPD_TIME,
    A.UPD_TIME AS TXN_TIME,
    B.PAYER_ST_BRNO,
    B.PAYER_ST_BRNAME,
    B.PAYER_BRNO,
    B.PAYER_BRNAME,
    B.PAYER_ACCT_BRNO,
    B.PAYER_ACCT_BRNAME,
    B.PAYER_ACTNO,
    '' AS PAYER_BR_BRNO,
    B.PAYER_NAME,
    B.PAYER_ADDR1||B.PAYER_ADDR2||B.PAYER_ADDR3||B.PAYER_ADDR4|| B.PAYER_ADDR5||B.PAYER_ADDR6||
    B.PAYER_ADDR7 AS PAYER_ADDR_M,
    B.PAYEE_ST_BRNO,
    B.PAYEE_ST_BRNAME,
    B.PAYEE_BRNO,
    B.PAYEE_BRNAME,
    B.PAYEE_ACCT_BRNO,
    B.PAYEE_ACCT_BRNAME,
    B.PAYEE_ACTNO,
    '' AS PAYEE_BR_BRNO,
    B.PAYEE_NAME,
    B.PAYEE_ADDR1||B.PAYEE_ADDR2||B.PAYEE_ADDR3||B.PAYEE_ADDR4|| B.PAYEE_ADDR5||B.PAYEE_ADDR6||
    B.PAYEE_ADDR7 AS PAYEE_ADDR_M,
    B.PS          AS PS1,
    ''            AS PS2,
    ''            AS PS3,
    ''            AS PS4,
    ''            AS IM1_BANK,
    ''            AS IM1_NAME,
    ''            AS IM2_BANK,
    ''            AS IM2_NAME,
    ''            AS CHARGE_BEARER,
    A.BIZ_PRIO,
    ''     AS RATE,
    ''     AS ORI_AMT_CURCD,
    NULL   AS ORI_AMT,
    NULL   AS FEE1_AMT,
    ''     AS FEE1_BRNO,
    NULL   AS FEE2_AMT,
    ''     AS FEE2_BRNO,
    ''     AS ORI_MSG_ID,
    ''     AS COV_PAYER_ACTNO,
    ''     AS COV_PAYER_NAME,
    ''     AS COV_PAYER_ADDR_M,
    ''     AS COV_PAYER_ACCT_BRNO,
    ''     AS COV_PAYER_ACCT_BRNAME,
    ''     AS COV_IM1_BANK,
    ''     AS COV_IM1_NAME,
    ''     AS COV_PAYEE_ACCT_BRNO,
    ''     AS COV_PAYEE_ACCT_BRNAME,
    ''     AS COV_PAYEE_ACTNO,
    ''     AS COV_PAYEE_NAME,
    ''     AS COV_PAYEE_ADDR_M,
    ''     AS COV_AMT_CURCD,
    NULL   AS COV_AMT,
    ''     AS COV_PS1,
    ''     AS COV_PS2,
    ''     AS COV_PS3,
    ''     AS COV_PS4,
    B.RSV5 AS MSG_RCV_TIME,
    A.INS_INFORMATION,
    A.BATCH_ID,
    A.BIZ_CNCL_INFO,
    '' AS ORDER_ID,
    '' AS ORDER_DESC_M,
    '' AS PAYER_ORG_ID,
    '' AS PAYER_ID_NO,
    '' AS PAYER_ID_TYPE,
    B.PAYER_RES_CTRY,
    '' AS PAYER_BR_ADDR1,
    '' AS PAYER_BR_ACTNO,
    '' AS PAYER_EID,
    '' AS PAYEE_ORG_ID,
    '' AS PAYEE_ID_NO,
    '' AS PAYEE_ID_TYPE,
    B.PAYEE_RES_CTRY,
    '' AS PAYEE_BR_ADDR1,
    '' AS PAYEE_BR_ACTNO,
    '' AS PAYEE_EID,
    '' AS COV_PAYER_ORG_ID,
    '' AS COV_PAYER_ID_NO,
    '' AS COV_PAYER_ID_TYPE,
    '' AS COV_PAYER_RES_CTRY,
    '' AS COV_PAYER_BR_ADDR_M,
    '' AS COV_PAYER_BR_ACTNO,
    '' AS COV_PAYER_EID,
    '' AS COV_PAYEE_ORG_ID,
    '' AS COV_PAYEE_ID_NO,
    '' AS COV_PAYEE_ID_TYPE,
    '' AS COV_PAYEE_RES_CTRY,
    '' AS COV_PAYEE_BR_ADDR_M,
    '' AS COV_PAYEE_BR_ACTNO,
    '' AS COV_PAYEE_EID,
    '' AS NET_DATE,
    '' AS NET_ROUND,
    A.DC_FLAG,
    B.REF_NO            AS REF_NO_153,
    B.PRTRY_STATUS      AS PRTRY_STATUS_153,
    B.ORI_MSG_ID        AS ORI_MSG_ID_153,
    B.ORI_ST_SND_BRNO   AS ORI_ST_SND_BRNO_153,
    B.ORI_ST_SND_BRNAME AS ORI_ST_SND_BRNAME_153,
    B.ORI_SND_BRNO      AS ORI_SND_BRNO_153,
    B.ORI_SND_BRNAME    AS ORI_SND_BRNAME_153,
    A.RT_BIZ_STATUS     AS RT_BIZ_STATUS_153,
    C.BIZ_REJ_INFO      AS BIZ_REJ_INFO_153,
		'' AS IS_CHARGE,
    '' AS ORI_109_MSG_ID,
		'' AS ORI_111_REF_ID,
		'' AS FEE_MATCH
FROM
    CIPS_TXN A
LEFT JOIN
    CIPS_153 B
ON
    A.SEQ_NO = B.SEQ_NO
LEFT JOIN
  CIPS_154 C
ON
  A.RT_SEQ_NO = C.SEQ_NO
WHERE
    A.MSG_NO = '153'-- auto-generated definition
create table CIPS_PMTS_NODE
(
    APP_NODE         VARCHAR2(35),
    APP_SERVER_NAME  VARCHAR2(20) not null,
    SND_QMGR         VARCHAR2(48),
    SND_CHL          VARCHAR2(20),
    PMTS_NODE        VARCHAR2(35),
    PMTS_SERVER_NAME VARCHAR2(20) not null,
    PMTS_QMGR        VARCHAR2(48),
    DTT_RSP_QUEUE    VARCHAR2(48),
    NODE_STATUS      CHAR(4),
    NODE_LOAD        VARCHAR2(16),
    DTT_PORT_OUT     VARCHAR2(64),
    BIZ_PORT_OUT     VARCHAR2(64),
    START_TIME       CHAR(14),
    LAST_REQ_TIME    CHAR(14),
    LAST_RSP_TIME    CHAR(14),
    primary key (APP_SERVER_NAME, PMTS_SERVER_NAME)
)
/

comment on column CIPS_PMTS_NODE.APP_NODE is '报文发起节点'
/

comment on column CIPS_PMTS_NODE.APP_SERVER_NAME is '发送服务器名'
/

comment on column CIPS_PMTS_NODE.SND_QMGR is '发起队列管理器名'
/

comment on column CIPS_PMTS_NODE.SND_CHL is '发送通道名'
/

comment on column CIPS_PMTS_NODE.PMTS_NODE is '接收节点'
/

comment on column CIPS_PMTS_NODE.PMTS_SERVER_NAME is '接收服务器名'
/

comment on column CIPS_PMTS_NODE.PMTS_QMGR is '接收队列管理器'
/

comment on column CIPS_PMTS_NODE.DTT_RSP_QUEUE is 'CAE端探测回应报文放入的队列名'
/

comment on column CIPS_PMTS_NODE.NODE_STATUS is '节点状态'
/

comment on column CIPS_PMTS_NODE.NODE_LOAD is '节点负载系数'
/

comment on column CIPS_PMTS_NODE.DTT_PORT_OUT is '探测PORT出口服务名称'
/

comment on column CIPS_PMTS_NODE.BIZ_PORT_OUT is '业务PORT出口服务名称'
/

comment on column CIPS_PMTS_NODE.START_TIME is '启动时间'
/

comment on column CIPS_PMTS_NODE.LAST_RSP_TIME is '最后一次应答时间'
/





-- auto-generated definition
create table CIPS_PMTS_NODE_STATUS_CHG_LOG
(
    SEQ_NO           CHAR(20) not null
        primary key,
    APP_SERVER_NAME  VARCHAR2(20),
    PMTS_SERVER_NAME VARCHAR2(20),
    STATUS_CHG_TIME  CHAR(14),
    STATUS_CHG_DATE  CHAR(8),
    OLD_NODE_STATUS  CHAR(4),
    NEW_NODE_STATUS  CHAR(4)
)
/

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.SEQ_NO is '流水号'
/

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.STATUS_CHG_TIME is '状态变更时间'
/

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.STATUS_CHG_DATE is '状态变更日期'
/

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.OLD_NODE_STATUS is '变更前状态'
/

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.NEW_NODE_STATUS is '变更后状态'
/


-- auto-generated definition
create table CIPS_PMTS_DTT_LOG
(
    SEQ_NO           CHAR(20) not null
        primary key,
    APP_SERVER_NAME  VARCHAR2(20),
    PMTS_SERVER_NAME VARCHAR2(20),
    DTT_REQ_SND_TIME CHAR(14),
    DTT_RSP_RCV_TIME CHAR(14),
    DTT_RSP_SND_TIME CHAR(14),
    LOAD_INFO        VARCHAR2(1024)
)
/

comment on column CIPS_PMTS_DTT_LOG.SEQ_NO is '流水号'
/

comment on column CIPS_PMTS_DTT_LOG.APP_SERVER_NAME is '应用服务器名称'
/

comment on column CIPS_PMTS_DTT_LOG.PMTS_SERVER_NAME is 'PMTS服务器名称'
/

comment on column CIPS_PMTS_DTT_LOG.DTT_REQ_SND_TIME is '探测请求发出时间'
/

comment on column CIPS_PMTS_DTT_LOG.DTT_RSP_RCV_TIME is '探测响应接收时间'
/

comment on column CIPS_PMTS_DTT_LOG.DTT_RSP_SND_TIME is 'PMTS发出响应时间'
/

comment on column CIPS_PMTS_DTT_LOG.LOAD_INFO is '流水号'
/

create table CIPS_108
(
    SEQ_NO          CHAR(20) not null
        constraint CIPS_108_PK
            primary key,
    CORP_ID         VARCHAR2(20),
    TXN_SEQ_NO      CHAR(20),
    ORI_SEQ_NO      CHAR(20),
    TXN_DIR         CHAR,
    SND_ST_BRNO     VARCHAR2(35),
    SND_ST_BRNAME   VARCHAR2(420),
    RCV_ST_BRNO     VARCHAR2(35),
    RCV_ST_BRNAME   VARCHAR2(420),
    SYS_CODE        CHAR(4),
    SRC_SYS         CHAR(4),
    DEST_SYS        CHAR(4),
    MSG_TYPE        VARCHAR2(20),
    MSG_SND_TIME    CHAR(14),
    MSG_PRIO        CHAR,
    MSG_ID          VARCHAR2(35),
    WORK_DATE       CHAR(8),
    CENTER_DATE     CHAR(8),
    COMM_STATUS     CHAR(2),
    PBOC_STATUS     CHAR(4),
    CHRGS_NUM       NUMBER(15),
    CTRL_SUM_AMT    NUMBER(18),
    CHRGS_AMT_CURCD CHAR(3),
    TOT_CHRGS_AMT   NUMBER(18),
    RSV1            VARCHAR2(420),
    RSV2            VARCHAR2(420),
    RSV3            VARCHAR2(420),
    RSV4            VARCHAR2(420),
    RSV5            VARCHAR2(420)
);

comment on column CIPS_108.SEQ_NO is '序号';

comment on column CIPS_108.CORP_ID is '法人ID';

comment on column CIPS_108.TXN_SEQ_NO is '业务表关联序号';

comment on column CIPS_108.ORI_SEQ_NO is '关联接口表序号';

comment on column CIPS_108.TXN_DIR is '来往账方向';

comment on column CIPS_108.SND_ST_BRNO is '发起直接参与机构';

comment on column CIPS_108.SND_ST_BRNAME is '发起直接参与机构名';

comment on column CIPS_108.RCV_ST_BRNO is '接收直接参与机构';

comment on column CIPS_108.RCV_ST_BRNAME is '接收直接参与机构名';

comment on column CIPS_108.SYS_CODE is '系统类别';

comment on column CIPS_108.SRC_SYS is '发送系统号';

comment on column CIPS_108.DEST_SYS is '接收系统号';

comment on column CIPS_108.MSG_TYPE is '报文号';

comment on column CIPS_108.MSG_SND_TIME is '报文发送时间';

comment on column CIPS_108.MSG_PRIO is '报文优先级';

comment on column CIPS_108.MSG_ID is '报文标识号';

comment on column CIPS_108.WORK_DATE is '工作日期';

comment on column CIPS_108.CENTER_DATE is '人行日期';

comment on column CIPS_108.COMM_STATUS is '通讯状态';

comment on column CIPS_108.PBOC_STATUS is '人行状态';

comment on column CIPS_108.CHRGS_NUM is '所含费用笔数';

comment on column CIPS_108.CTRL_SUM_AMT is '总金额';

comment on column CIPS_108.CHRGS_AMT_CURCD is '币种';

comment on column CIPS_108.TOT_CHRGS_AMT is '总费用';

comment on column CIPS_108.RSV1 is '备用1';

comment on column CIPS_108.RSV2 is '备用2';

comment on column CIPS_108.RSV3 is '备用3';

comment on column CIPS_108.RSV4 is '备用4';

comment on column CIPS_108.RSV5 is '备用5';

create table CIPS_108_DLIST
(
    SEQ_NO            CHAR(20) not null
        constraint CIPS_108_DLIST_PK
            primary key,
    CORP_ID           VARCHAR2(20),
    T_SEQ_NO          CHAR(20),
    P_SEQ_NO          CHAR(20),
    TXN_DTL_SEQNO     VARCHAR2(20),
    TXN_SEQ_NO        CHAR(20),
    MSG_ID            VARCHAR2(35),
    MSG_TYPE          VARCHAR2(35),
    AC_SVCR_REF       VARCHAR2(35),
    PAY_INF_ID        VARCHAR2(35),
    INSTR_ID          VARCHAR2(35),
    E2E_ID            VARCHAR2(35),
    UETR              VARCHAR2(36),
    TXN_ID            VARCHAR2(35),
    MANDATE_ID        VARCHAR2(35),
    CHEQUE_NO         VARCHAR2(35),
    CLR_SYS_REF       VARCHAR2(35),
    ACCT_OWNER_TXN_ID VARCHAR2(35),
    ACCT_SVCR_TXN_ID  VARCHAR2(35),
    MI_TXN_ID         VARCHAR2(35),
    PROC_ID           VARCHAR2(35),
    RSV1              VARCHAR2(420),
    RSV2              VARCHAR2(420),
    RSV3              VARCHAR2(420),
    RSV4              VARCHAR2(420),
    RSV5              VARCHAR2(420)
);

comment on column CIPS_108_DLIST.SEQ_NO is '序号';

comment on column CIPS_108_DLIST.CORP_ID is '法人ID';

comment on column CIPS_108_DLIST.T_SEQ_NO is '最上级记录序号';

comment on column CIPS_108_DLIST.P_SEQ_NO is '父级记录序号';

comment on column CIPS_108_DLIST.TXN_DTL_SEQNO is '交易明细序号';

comment on column CIPS_108_DLIST.TXN_SEQ_NO is '交易流水号';

comment on column CIPS_108_DLIST.MSG_ID is '报文标识号';

comment on column CIPS_108_DLIST.MSG_TYPE is '报文类型';

comment on column CIPS_108_DLIST.AC_SVCR_REF is '账户服务参考号';

comment on column CIPS_108_DLIST.PAY_INF_ID is '支付信息标识';

comment on column CIPS_108_DLIST.INSTR_ID is '业务标识号（业务交易编号）';

comment on column CIPS_108_DLIST.E2E_ID is '端到端标识号';

comment on column CIPS_108_DLIST.UETR is 'UETR';

comment on column CIPS_108_DLIST.TXN_ID is '交易标识号';

comment on column CIPS_108_DLIST.MANDATE_ID is '授权标识';

comment on column CIPS_108_DLIST.CHEQUE_NO is '票据号码';

comment on column CIPS_108_DLIST.CLR_SYS_REF is '清算系统参考号';

comment on column CIPS_108_DLIST.ACCT_OWNER_TXN_ID is '账户所有者交易标识';

comment on column CIPS_108_DLIST.ACCT_SVCR_TXN_ID is '账户服务商交易标识';

comment on column CIPS_108_DLIST.MI_TXN_ID is '市场基础设施交易标识';

comment on column CIPS_108_DLIST.PROC_ID is '处理标识';

comment on column CIPS_108_DLIST.RSV1 is '备用1';

comment on column CIPS_108_DLIST.RSV2 is '备用2';

comment on column CIPS_108_DLIST.RSV3 is '备用3';

comment on column CIPS_108_DLIST.RSV4 is '备用4';

comment on column CIPS_108_DLIST.RSV5 is '备用5';

create table CIPS_108_LIST
(
    SEQ_NO                         CHAR(20) not null
        constraint CIPS_108_LIST_PK
            primary key,
    CORP_ID                        VARCHAR2(20),
    P_SEQ_NO                       CHAR(20),
    CHRGS_DTL_SEQNO                VARCHAR2(20),
    CHRGS_REC_ID                   VARCHAR2(35),
    AMT_CURCD                      CHAR(3),
    AMT                            NUMBER(18),
    CHRG_DC_FLAG                   CHAR(4),
    VALUE_DATE                     CHAR(8),
    VALUE_TIME                     CHAR(14),
    CHRGS_TYPE                     VARCHAR2(4),
    CHRGS_TYPEX                    VARCHAR2(35),
    INSTR_FOR_INSTD_AGT_INSTR_CD   VARCHAR2(4),
    INSTR_FOR_INSTD_AGT_INSTR_INF  VARCHAR2(420),
    ADDTL_INF                      VARCHAR2(420),
    DR_AGT_BIC                     VARCHAR2(11),
    DR_AGT_CLR_SYS                 VARCHAR2(5),
    DR_AGT_CLR_SYSX                VARCHAR2(35),
    DR_AGT_CLR_SYS_MMBID           VARCHAR2(35),
    DR_AGT_LEI                     VARCHAR2(20),
    DR_AGT_NAME                    VARCHAR2(420),
    DR_AGT_ADDR_DEPT               VARCHAR2(210),
    DR_AGT_ADDR_SUB_DEPT           VARCHAR2(210),
    DR_AGT_ADDR_STRT_NM            VARCHAR2(210),
    DR_AGT_ADDR_BLDG_NB            VARCHAR2(48),
    DR_AGT_ADDR_BLDG_NM            VARCHAR2(105),
    DR_AGT_ADDR_FLR                VARCHAR2(210),
    DR_AGT_ADDR_PST_BX             VARCHAR2(48),
    DR_AGT_ADDR_ROOM               VARCHAR2(210),
    DR_AGT_ADDR_PST_CD             VARCHAR2(48),
    DR_AGT_ADDR_TWN_NM             VARCHAR2(105),
    DR_AGT_ADDR_TWN_LCTN_NM        VARCHAR2(105),
    DR_AGT_ADDR_DSTRCT_NM          VARCHAR2(105),
    DR_AGT_ADDR_CTRY_SUB_DIV       VARCHAR2(105),
    DR_AGT_ADDR_CTRY               VARCHAR2(2),
    DR_AGT_ADDR_ADR_LINE1          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE2          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE3          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE4          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE5          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE6          VARCHAR2(210),
    DR_AGT_ADDR_ADR_LINE7          VARCHAR2(210),
    DR_AGT_ACCT_IBAN               VARCHAR2(34),
    DR_AGT_ACCT_OTHER_ID           VARCHAR2(34),
    DR_AGT_ACCT_OTHER_ID_SCHE      VARCHAR2(4),
    DR_AGT_ACCT_OTHER_ID_SCHEX     VARCHAR2(35),
    DR_AGT_ACCT_OTHER_ID_ISSR      VARCHAR2(35),
    DR_AGT_ACCT_TYPE               VARCHAR2(4),
    DR_AGT_ACCT_TYPEX              VARCHAR2(105),
    DR_AGT_ACCT_CCY                CHAR(3),
    DR_AGT_ACCT_NAME               VARCHAR2(210),
    DR_AGT_ACCT_PROXY_ID_TYPE      VARCHAR2(4),
    DR_AGT_ACCT_PROXY_ID_TYPEX     VARCHAR2(35),
    DR_AGT_ACCT_PROXY_ID           VARCHAR2(2048),
    CHRGS_ACCT_AGT_BIC             VARCHAR2(11),
    CHRGS_ACCT_AGT_CLR_SYS         VARCHAR2(5),
    CHRGS_ACCT_AGT_CLR_SYSX        VARCHAR2(35),
    CHRGS_ACCT_AGT_CLR_SYS_MMBID   VARCHAR2(35),
    CHRGS_ACCT_AGT_LEI             VARCHAR2(20),
    CHRGS_ACCT_AGT_NAME            VARCHAR2(420),
    CHRGS_AC_AGT_ADDR_DEPT         VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_SUB_DEPT     VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_STRT_NM      VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_BLDG_NB      VARCHAR2(48),
    CHRGS_AC_AGT_ADDR_BLDG_NM      VARCHAR2(105),
    CHRGS_AC_AGT_ADDR_FLR          VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_PST_BX       VARCHAR2(48),
    CHRGS_AC_AGT_ADDR_ROOM         VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_PST_CD       VARCHAR2(48),
    CHRGS_AC_AGT_ADDR_TWN_NM       VARCHAR2(105),
    CHRGS_AC_AGT_ADDR_TWN_LCTN_NM  VARCHAR2(105),
    CHRGS_AC_AGT_ADDR_DSTRCT_NM    VARCHAR2(105),
    CHRGS_AC_AGT_ADDR_CTRY_SUB_DIV VARCHAR2(105),
    CHRGS_AC_AGT_ADDR_CTRY         CHAR(2),
    CHRGS_AC_AGT_ADDR_ADR_LINE1    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE2    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE3    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE4    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE5    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE6    VARCHAR2(210),
    CHRGS_AC_AGT_ADDR_ADR_LINE7    VARCHAR2(210),
    CHRGS_AC_AGT_AC_IBAN           VARCHAR2(34),
    CHRGS_AC_AGT_AC_OTH_ID         VARCHAR2(34),
    CHRGS_AC_AGT_AC_OTH_ID_SCHE    VARCHAR2(4),
    CHRGS_AC_AGT_AC_OTH_ID_SCHEX   VARCHAR2(35),
    CHRGS_AC_AGT_AC_OTH_ID_ISSR    VARCHAR2(35),
    CHRGS_AC_AGT_AC_TYPE           VARCHAR2(4),
    CHRGS_AC_AGT_AC_TYPEX          VARCHAR2(105),
    CHRGS_AC_AGT_AC_CCY            CHAR(3),
    CHRGS_AC_AGT_AC_NAME           VARCHAR2(210),
    CHRGS_AC_AGT_AC_PROXY_ID_TYPE  VARCHAR2(4),
    CHRGS_AC_AGT_AC_PROXY_ID_TYPEX VARCHAR2(35),
    CHRGS_AC_AGT_AC_PROXY_ID       VARCHAR2(2048),
    RSV1                           VARCHAR2(420),
    RSV2                           VARCHAR2(420),
    RSV3                           VARCHAR2(420),
    RSV4                           VARCHAR2(420),
    RSV5                           VARCHAR2(420)
);

comment on column CIPS_108_LIST.SEQ_NO is '序号';

comment on column CIPS_108_LIST.CORP_ID is '法人ID';

comment on column CIPS_108_LIST.P_SEQ_NO is '父级记录序号';

comment on column CIPS_108_LIST.CHRGS_DTL_SEQNO is '费用明细序号';

comment on column CIPS_108_LIST.CHRGS_REC_ID is '收费记录标识号';

comment on column CIPS_108_LIST.AMT_CURCD is '币种';

comment on column CIPS_108_LIST.AMT is '费用';

comment on column CIPS_108_LIST.CHRG_DC_FLAG is '借贷标识';

comment on column CIPS_108_LIST.VALUE_DATE is '起息日期';

comment on column CIPS_108_LIST.VALUE_TIME is '起息时间';

comment on column CIPS_108_LIST.CHRGS_TYPE is '收费类型';

comment on column CIPS_108_LIST.CHRGS_TYPEX is '收费类型附加说明';

comment on column CIPS_108_LIST.INSTR_FOR_INSTD_AGT_INSTR_CD is '致收报方指示_指示编码';

comment on column CIPS_108_LIST.INSTR_FOR_INSTD_AGT_INSTR_INF is '致收报方指示_指示信息';

comment on column CIPS_108_LIST.ADDTL_INF is '其他信息';

comment on column CIPS_108_LIST.DR_AGT_BIC is '付款机构_BIC码';

comment on column CIPS_108_LIST.DR_AGT_CLR_SYS is '付款机构_清算系统代码';

comment on column CIPS_108_LIST.DR_AGT_CLR_SYSX is '付款机构_清算系统附加说明';

comment on column CIPS_108_LIST.DR_AGT_CLR_SYS_MMBID is '付款机构_CIPS ID';

comment on column CIPS_108_LIST.DR_AGT_LEI is '付款机构_LEI';

comment on column CIPS_108_LIST.DR_AGT_NAME is '付款机构_名称';

comment on column CIPS_108_LIST.DR_AGT_ADDR_DEPT is '付款机构_地址_部门';

comment on column CIPS_108_LIST.DR_AGT_ADDR_SUB_DEPT is '付款机构_地址_分部';

comment on column CIPS_108_LIST.DR_AGT_ADDR_STRT_NM is '付款机构_地址_街道名称';

comment on column CIPS_108_LIST.DR_AGT_ADDR_BLDG_NB is '付款机构_地址_建筑编号';

comment on column CIPS_108_LIST.DR_AGT_ADDR_BLDG_NM is '付款机构_地址_建筑名称';

comment on column CIPS_108_LIST.DR_AGT_ADDR_FLR is '付款机构_地址_建筑楼层';

comment on column CIPS_108_LIST.DR_AGT_ADDR_PST_BX is '付款机构_地址_邮政信箱';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ROOM is '付款机构_地址_房间号';

comment on column CIPS_108_LIST.DR_AGT_ADDR_PST_CD is '付款机构_地址_邮政编码';

comment on column CIPS_108_LIST.DR_AGT_ADDR_TWN_NM is '付款机构_地址_城镇名称';

comment on column CIPS_108_LIST.DR_AGT_ADDR_TWN_LCTN_NM is '付款机构_地址_城镇地址';

comment on column CIPS_108_LIST.DR_AGT_ADDR_DSTRCT_NM is '付款机构_地址_地区名称';

comment on column CIPS_108_LIST.DR_AGT_ADDR_CTRY_SUB_DIV is '付款机构_地址_国家区域（区/洲）';

comment on column CIPS_108_LIST.DR_AGT_ADDR_CTRY is '付款机构_地址_国家';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE1 is '付款机构_地址_地址栏1';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE2 is '付款机构_地址_地址栏2';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE3 is '付款机构_地址_地址栏3';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE4 is '付款机构_地址_地址栏4';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE5 is '付款机构_地址_地址栏5';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE6 is '付款机构_地址_地址栏6';

comment on column CIPS_108_LIST.DR_AGT_ADDR_ADR_LINE7 is '付款机构_地址_地址栏7';

comment on column CIPS_108_LIST.DR_AGT_ACCT_IBAN is '付款机构账户_IBAN账户账号';

comment on column CIPS_108_LIST.DR_AGT_ACCT_OTHER_ID is '付款机构账户_账号';

comment on column CIPS_108_LIST.DR_AGT_ACCT_OTHER_ID_SCHE is '付款机构账户_其他标识的识别方法';

comment on column CIPS_108_LIST.DR_AGT_ACCT_OTHER_ID_SCHEX is '付款机构账户_其他标识的识别方法附加说明';

comment on column CIPS_108_LIST.DR_AGT_ACCT_OTHER_ID_ISSR is '付款机构账户_其他标识的发码方';

comment on column CIPS_108_LIST.DR_AGT_ACCT_TYPE is '付款机构账户_账户类型代码';

comment on column CIPS_108_LIST.DR_AGT_ACCT_TYPEX is '付款机构账户_账户用途说明';

comment on column CIPS_108_LIST.DR_AGT_ACCT_CCY is '付款机构账户_账户币种';

comment on column CIPS_108_LIST.DR_AGT_ACCT_NAME is '付款机构账户_账户名称';

comment on column CIPS_108_LIST.DR_AGT_ACCT_PROXY_ID_TYPE is '付款机构账户_备用账户类型';

comment on column CIPS_108_LIST.DR_AGT_ACCT_PROXY_ID_TYPEX is '付款机构账户_备用账户类型的用途说明';

comment on column CIPS_108_LIST.DR_AGT_ACCT_PROXY_ID is '付款机构账户_备用账户标识';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_BIC is '收费账户_BIC码';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_CLR_SYS is '收费账户_清算系统';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_CLR_SYSX is '收费账户_清算系统的附加说明';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_CLR_SYS_MMBID is '收费账户_CIPS ID';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_LEI is '收费账户_LEI';

comment on column CIPS_108_LIST.CHRGS_ACCT_AGT_NAME is '收费账户_名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_DEPT is '收费账户_地址_部门';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_SUB_DEPT is '收费账户_地址_分部';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_STRT_NM is '收费账户_地址_街道名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_BLDG_NB is '收费账户_地址_建筑编号';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_BLDG_NM is '收费账户_地址_建筑名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_FLR is '收费账户_地址_建筑楼层';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_PST_BX is '收费账户_地址_邮政信箱';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ROOM is '收费账户_地址_房间号';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_PST_CD is '收费账户_地址_邮政编码';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_TWN_NM is '收费账户_地址_城镇名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_TWN_LCTN_NM is '收费账户_地址_城镇地址';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_DSTRCT_NM is '收费账户_地址_地区名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_CTRY_SUB_DIV is '收费账户_地址_国家区域（区/洲）';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_CTRY is '收费账户_地址_国家';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE1 is '收费账户_地址_地址栏1';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE2 is '收费账户_地址_地址栏2';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE3 is '收费账户_地址_地址栏3';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE4 is '收费账户_地址_地址栏4';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE5 is '收费账户_地址_地址栏5';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE6 is '收费账户_地址_地址栏6';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_ADDR_ADR_LINE7 is '收费账户_地址_地址栏7';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_IBAN is '收费账户所有方_IBAN账户账号';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_OTH_ID is '收费账户所有方_账号';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_OTH_ID_SCHE is '收费账户所有方_其他标识识别方法';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_OTH_ID_SCHEX is '收费账户所有方_其他标识识别方法的附加说明';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_OTH_ID_ISSR is '收费账户所有方_其他标识发码方';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_TYPE is '收费账户所有方_账户类型代码';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_TYPEX is '收费账户所有方_账户用途说明';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_CCY is '收费账户所有方_账户币种';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_NAME is '收费账户所有方_账户名称';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_PROXY_ID_TYPE is '收费账户所有方_备用账户类型';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_PROXY_ID_TYPEX is '收费账户所有方_备用账户类型的用途说明';

comment on column CIPS_108_LIST.CHRGS_AC_AGT_AC_PROXY_ID is '收费收费账户所有方_备用账户标识';

comment on column CIPS_108_LIST.RSV1 is '备用1';

comment on column CIPS_108_LIST.RSV2 is '备用2';

comment on column CIPS_108_LIST.RSV3 is '备用3';

comment on column CIPS_108_LIST.RSV4 is '备用4';

comment on column CIPS_108_LIST.RSV5 is '备用5';

create table CIPS_BAL_RECORD
(
    SEQ_NO         CHAR(20) not null
        constraint CIPS_BAL_RECORD_PK
            primary key,
    WORK_DATE      VARCHAR2(20),
    REQ_TXN_SEQ_NO CHAR(20),
    RSP_IS_SUCCESS CHAR,
    RSP_BAL_AMT    NUMBER(18),
    CRT_TIME       CHAR(14),
    UPD_TIME       CHAR(14),
    RSV1           VARCHAR2(180),
    RSV2           VARCHAR2(180),
    RSV3           VARCHAR2(180),
    RSV4           VARCHAR2(180),
    RSV5           VARCHAR2(180)
);

comment on column CIPS_BAL_RECORD.SEQ_NO is '序号';

comment on column CIPS_BAL_RECORD.WORK_DATE is '工作日期';

comment on column CIPS_BAL_RECORD.REQ_TXN_SEQ_NO is '查询txn_seq_no';

comment on column CIPS_BAL_RECORD.RSP_IS_SUCCESS is '查询是否成功';

comment on column CIPS_BAL_RECORD.RSP_BAL_AMT is 'cips余额';

comment on column CIPS_BAL_RECORD.CRT_TIME is '创建时间';

comment on column CIPS_BAL_RECORD.UPD_TIME is '最后更新日期';

comment on column CIPS_BAL_RECORD.RSV1 is '备用1';

comment on column CIPS_BAL_RECORD.RSV2 is '备用2';

comment on column CIPS_BAL_RECORD.RSV3 is '备用3';

comment on column CIPS_BAL_RECORD.RSV4 is '备用4';

comment on column CIPS_BAL_RECORD.RSV5 is '备用5';

create table CIPS_BRDM_LIST
(
    COUNTRY         VARCHAR2(2)  default 'CN',
    PAYMENT_TYPE    VARCHAR2(4)  default 'RTGS',
    ROUTING_TYPE    VARCHAR2(3)  default 'BIC',
    CURRENCY        VARCHAR2(3)  default 'CNY',
    CLEARING_SYSTEM VARCHAR2(10) default 'CN CIPS-SC',
    ROUTING_CODE    VARCHAR2(11) not null
        primary key,
    CN_BRNAME       VARCHAR2(300),
    EN_BRNAME       VARCHAR2(300),
    CNTY_REG_CODE   VARCHAR2(2),
    BANK_CATEGORY   VARCHAR2(1),
    ST_BRNO         VARCHAR2(11),
    MAP_BIC         VARCHAR2(11),
    MAP_DIR_BIC     VARCHAR2(1),
    BK_COUNTRY_NAME VARCHAR2(140),
    WORK_DATE       CHAR(8),
    RSV1            VARCHAR2(100),
    RSV2            VARCHAR2(100),
    RSV3            VARCHAR2(100),
    RSV4            VARCHAR2(100)
);

create table CIPS_DNS_LIM_AMT
(
    CENTER_DATE CHAR(8)      not null,
    OP_ST_BRNO  VARCHAR2(35) not null,
    LIM_AMT     NUMBER(18)   not null,
    USED_AMT    NUMBER(18)   not null,
    CRT_TIME    CHAR(14)     not null,
    UPD_TIME    CHAR(14)     not null,
    RSV1        VARCHAR2(180),
    RSV2        VARCHAR2(180),
    RSV3        VARCHAR2(180),
    RSV4        VARCHAR2(180),
    RSV5        VARCHAR2(180),
    constraint CIPS_DNS_LIM_AMT_PK
        primary key (CENTER_DATE, OP_ST_BRNO)
);

comment on column CIPS_DNS_LIM_AMT.CENTER_DATE is '人行日期';

comment on column CIPS_DNS_LIM_AMT.OP_ST_BRNO is '对手直参行行号';

comment on column CIPS_DNS_LIM_AMT.LIM_AMT is '发起方限额';

comment on column CIPS_DNS_LIM_AMT.USED_AMT is '已使用限额';

comment on column CIPS_DNS_LIM_AMT.CRT_TIME is '创建时间';

comment on column CIPS_DNS_LIM_AMT.UPD_TIME is '更新时间';

comment on column CIPS_DNS_LIM_AMT.RSV1 is '备用1';

comment on column CIPS_DNS_LIM_AMT.RSV2 is '备用2';

comment on column CIPS_DNS_LIM_AMT.RSV3 is '备用3';

comment on column CIPS_DNS_LIM_AMT.RSV4 is '备用4';

comment on column CIPS_DNS_LIM_AMT.RSV5 is '备用5';

create table CIPS_PMTS_DTT_LOG
(
    SEQ_NO           CHAR(20) not null
        primary key,
    APP_SERVER_NAME  VARCHAR2(20),
    PMTS_SERVER_NAME VARCHAR2(20),
    DTT_REQ_SND_TIME CHAR(14),
    DTT_RSP_RCV_TIME CHAR(14),
    DTT_RSP_SND_TIME CHAR(14),
    LOAD_INFO        VARCHAR2(1024)
);

comment on column CIPS_PMTS_DTT_LOG.SEQ_NO is '流水号';

comment on column CIPS_PMTS_DTT_LOG.APP_SERVER_NAME is '应用服务器名称';

comment on column CIPS_PMTS_DTT_LOG.PMTS_SERVER_NAME is 'PMTS服务器名称';

comment on column CIPS_PMTS_DTT_LOG.DTT_REQ_SND_TIME is '探测请求发出时间';

comment on column CIPS_PMTS_DTT_LOG.DTT_RSP_RCV_TIME is '探测响应接收时间';

comment on column CIPS_PMTS_DTT_LOG.DTT_RSP_SND_TIME is 'PMTS发出响应时间';

comment on column CIPS_PMTS_DTT_LOG.LOAD_INFO is '流水号';

create table CIPS_PMTS_NODE
(
    APP_NODE         VARCHAR2(35),
    APP_SERVER_NAME  VARCHAR2(20) not null,
    SND_QMGR         VARCHAR2(48),
    SND_CHL          VARCHAR2(20),
    PMTS_NODE        VARCHAR2(35),
    PMTS_SERVER_NAME VARCHAR2(20) not null,
    PMTS_QMGR        VARCHAR2(48),
    DTT_RSP_QUEUE    VARCHAR2(48),
    NODE_STATUS      CHAR(4),
    NODE_LOAD        VARCHAR2(16),
    DTT_PORT_OUT     VARCHAR2(64),
    BIZ_PORT_OUT     VARCHAR2(64),
    START_TIME       CHAR(14),
    LAST_REQ_TIME    CHAR(14),
    LAST_RSP_TIME    CHAR(14),
    primary key (APP_SERVER_NAME, PMTS_SERVER_NAME)
);

comment on column CIPS_PMTS_NODE.APP_NODE is '报文发起节点';

comment on column CIPS_PMTS_NODE.APP_SERVER_NAME is '发送服务器名';

comment on column CIPS_PMTS_NODE.SND_QMGR is '发起队列管理器名';

comment on column CIPS_PMTS_NODE.SND_CHL is '发送通道名';

comment on column CIPS_PMTS_NODE.PMTS_NODE is '接收节点';

comment on column CIPS_PMTS_NODE.PMTS_SERVER_NAME is '接收服务器名';

comment on column CIPS_PMTS_NODE.PMTS_QMGR is '接收队列管理器';

comment on column CIPS_PMTS_NODE.DTT_RSP_QUEUE is 'CAE端探测回应报文放入的队列名';

comment on column CIPS_PMTS_NODE.NODE_STATUS is '节点状态';

comment on column CIPS_PMTS_NODE.NODE_LOAD is '节点负载系数';

comment on column CIPS_PMTS_NODE.DTT_PORT_OUT is '探测PORT出口服务名称';

comment on column CIPS_PMTS_NODE.BIZ_PORT_OUT is '业务PORT出口服务名称';

comment on column CIPS_PMTS_NODE.START_TIME is '启动时间';

comment on column CIPS_PMTS_NODE.LAST_RSP_TIME is '最后一次应答时间';

create table CIPS_PMTS_NODE_STATUS_CHG_LOG
(
    SEQ_NO           CHAR(20) not null
        primary key,
    APP_SERVER_NAME  VARCHAR2(20),
    PMTS_SERVER_NAME VARCHAR2(20),
    STATUS_CHG_TIME  CHAR(14),
    STATUS_CHG_DATE  CHAR(8),
    OLD_NODE_STATUS  CHAR(4),
    NEW_NODE_STATUS  CHAR(4)
);

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.SEQ_NO is '流水号';

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.STATUS_CHG_TIME is '状态变更时间';

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.STATUS_CHG_DATE is '状态变更日期';

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.OLD_NODE_STATUS is '变更前状态';

comment on column CIPS_PMTS_NODE_STATUS_CHG_LOG.NEW_NODE_STATUS is '变更后状态';

create table CIPS_SIGN_FAIL
(
    SEQ_NO       CHAR(20) not null
        constraint CIPS_SIGN_FAIL_PK
            primary key,
    CORP_ID      VARCHAR2(20),
    MSG_TYPE     VARCHAR2(20),
    MSG_NO       CHAR(3),
    WORK_DATE    CHAR(8),
    CENTER_DATE  CHAR(8),
    MSG_SND_BRNO VARCHAR2(35),
    MSG_ID       VARCHAR2(35),
    SIGN_RESULT  CHAR(2),
    SIGN_DESC    VARCHAR2(180),
    MSG_RCV_DATE CHAR(8),
    MSG_RCV_TIME CHAR(14),
    MSG_FILE     VARCHAR2(1024),
    RSV1         VARCHAR2(180),
    RSV2         VARCHAR2(180),
    RSV3         VARCHAR2(180),
    RSV4         VARCHAR2(180),
    RSV5         VARCHAR2(180)
);

comment on column CIPS_SIGN_FAIL.SEQ_NO is '关联PKG表或TXN表主键';

comment on column CIPS_SIGN_FAIL.CORP_ID is '法人ID';

comment on column CIPS_SIGN_FAIL.MSG_TYPE is '报文类型';

comment on column CIPS_SIGN_FAIL.MSG_NO is '报文编号';

comment on column CIPS_SIGN_FAIL.WORK_DATE is '工作日期';

comment on column CIPS_SIGN_FAIL.CENTER_DATE is '中心日期';

comment on column CIPS_SIGN_FAIL.MSG_SND_BRNO is '报文发起机构';

comment on column CIPS_SIGN_FAIL.MSG_ID is '报文标识号';

comment on column CIPS_SIGN_FAIL.SIGN_RESULT is '加核签状态';

comment on column CIPS_SIGN_FAIL.SIGN_DESC is '加核签描述';

comment on column CIPS_SIGN_FAIL.MSG_RCV_DATE is '报文接收日期';

comment on column CIPS_SIGN_FAIL.MSG_RCV_TIME is '报文接收时间';

comment on column CIPS_SIGN_FAIL.MSG_FILE is '消息文件名';

comment on column CIPS_SIGN_FAIL.RSV1 is '备用1';

comment on column CIPS_SIGN_FAIL.RSV2 is '备用2';

comment on column CIPS_SIGN_FAIL.RSV3 is '备用3';

comment on column CIPS_SIGN_FAIL.RSV4 is '备用4';

comment on column CIPS_SIGN_FAIL.RSV5 is '备用5';

create table GMON_MQ_LSR
(
    SEQ_NO       VARCHAR2(64) not null
        constraint GMON_MQ_LSR_PK
            primary key,
    NODE_ID      VARCHAR2(32),
    LSR          VARCHAR2(32),
    STATUS       VARCHAR2(32),
    COLLECT_TIME CHAR(14),
    CRT_TIME     CHAR(14),
    RSV1         VARCHAR2(180),
    RSV2         VARCHAR2(180),
    RSV3         VARCHAR2(180),
    RSV4         VARCHAR2(180),
    RSV5         VARCHAR2(180)
);

comment on column GMON_MQ_LSR.SEQ_NO is '序号';

comment on column GMON_MQ_LSR.NODE_ID is '服务器ID';

comment on column GMON_MQ_LSR.LSR is '监听器名';

comment on column GMON_MQ_LSR.STATUS is '监听器状态';

comment on column GMON_MQ_LSR.COLLECT_TIME is '采集时间';

comment on column GMON_MQ_LSR.CRT_TIME is '创建时间';

comment on column GMON_MQ_LSR.RSV1 is '备用1';

comment on column GMON_MQ_LSR.RSV2 is '备用2';

comment on column GMON_MQ_LSR.RSV3 is '备用3';

comment on column GMON_MQ_LSR.RSV4 is '备用4';

comment on column GMON_MQ_LSR.RSV5 is '备用5';

create table GPAY_BLACKLIST_TMP
(
    BLACK_NAME  VARCHAR2(1024) not null
        constraint SYS_C0070205
            primary key,
    DESCRIPTION VARCHAR2(4000),
    MATCH_STR   CHAR(180),
    REMARKS     VARCHAR2(180),
    OP_TYPE     CHAR(2),
    CRT_USER    VARCHAR2(20),
    CRT_TIME    CHAR(14),
    UPD_USER    VARCHAR2(20),
    UPD_TIME    CHAR(14),
    RSV1        VARCHAR2(180),
    RSV2        VARCHAR2(180),
    RSV3        VARCHAR2(180),
    RSV4        VARCHAR2(180),
    RSV5        VARCHAR2(180)
);

comment on column GPAY_BLACKLIST_TMP.BLACK_NAME is 'VIP账号';

comment on column GPAY_BLACKLIST_TMP.DESCRIPTION is 'VIP客户名称';

comment on column GPAY_BLACKLIST_TMP.MATCH_STR is 'VIP等级';

comment on column GPAY_BLACKLIST_TMP.REMARKS is '备注';

comment on column GPAY_BLACKLIST_TMP.OP_TYPE is '操作类型';

comment on column GPAY_BLACKLIST_TMP.CRT_USER is '创建用户';

comment on column GPAY_BLACKLIST_TMP.CRT_TIME is '创建时间';

comment on column GPAY_BLACKLIST_TMP.UPD_USER is '更新用户';

comment on column GPAY_BLACKLIST_TMP.UPD_TIME is '更新时间';

comment on column GPAY_BLACKLIST_TMP.RSV1 is '备用1';

comment on column GPAY_BLACKLIST_TMP.RSV2 is '备用2';

comment on column GPAY_BLACKLIST_TMP.RSV3 is '备用3';

comment on column GPAY_BLACKLIST_TMP.RSV4 is '备用4';

comment on column GPAY_BLACKLIST_TMP.RSV5 is '备用5';

create table GPAY_RPT_REC
(
    SYSTEM   VARCHAR2(128),
    CORP_ID  VARCHAR2(20)  not null,
    ORG_ID   VARCHAR2(20)  not null,
    RPT_ID   VARCHAR2(128) not null,
    RPT_NAME VARCHAR2(60),
    RPT_TYPE CHAR,
    RPT_DATE CHAR(8)       not null,
    RPT_FILE VARCHAR2(4000),
    CRT_DATE CHAR(8),
    CRT_TIME CHAR(14),
    RSV1     VARCHAR2(60),
    RSV2     VARCHAR2(60),
    RSV3     VARCHAR2(60),
    RSV4     VARCHAR2(60),
    RSV5     VARCHAR2(60),
    constraint GPAY_RPT_REC_PK
        primary key (CORP_ID, ORG_ID, RPT_ID, RPT_DATE)
);

comment on table GPAY_RPT_REC is '报表配置表';

comment on column GPAY_RPT_REC.SYSTEM is '所属系统';

comment on column GPAY_RPT_REC.CORP_ID is '所属法人';

comment on column GPAY_RPT_REC.ORG_ID is '所属机构';

comment on column GPAY_RPT_REC.RPT_ID is '报表ID';

comment on column GPAY_RPT_REC.RPT_NAME is '报表名称';

comment on column GPAY_RPT_REC.RPT_TYPE is '报表类型';

comment on column GPAY_RPT_REC.RPT_DATE is '报表日期';

comment on column GPAY_RPT_REC.RPT_FILE is '报表文件';

comment on column GPAY_RPT_REC.CRT_DATE is '创建日期';

comment on column GPAY_RPT_REC.CRT_TIME is '创建时间';

comment on column GPAY_RPT_REC.RSV1 is '保留，暂不使用';

comment on column GPAY_RPT_REC.RSV2 is '保留，暂不使用';

comment on column GPAY_RPT_REC.RSV3 is '保留，暂不使用';

comment on column GPAY_RPT_REC.RSV4 is '保留，暂不使用';

comment on column GPAY_RPT_REC.RSV5 is '保留，暂不使用';

create table GPRINT_VOUCHER_CFG
(
    SEQ_NO         VARCHAR2(20)   not null
        constraint GPRINT_VOUCHER_CFG_PK
            primary key,
    SYSTEM         VARCHAR2(20)   not null,
    CORP_ID        VARCHAR2(20)   not null,
    ORG_ID         VARCHAR2(20)   not null,
    VOUCHER_LAYOUT CHAR(4)        not null,
    VOUCHER_ID     VARCHAR2(64)   not null,
    VOUCHER_NAME   VARCHAR2(256)  not null,
    VOUCHER_FILE   VARCHAR2(2048) not null,
    DATA_KEY_FIELD VARCHAR2(32)   not null,
    REMARKS        VARCHAR2(60),
    CRT_TIME       CHAR(14),
    UPT_TIME       CHAR(14),
    RSV1           VARCHAR2(60),
    RSV2           VARCHAR2(60),
    RSV3           VARCHAR2(60),
    RSV4           VARCHAR2(60),
    RSV5           VARCHAR2(60)
);

create unique index GPRINT_VOUCHER_CFG_UK
    on GPRINT_VOUCHER_CFG (SYSTEM, CORP_ID, ORG_ID, VOUCHER_ID);

create table GPRINT_VOUCHER_DATA_SQL_CFG
(
    SEQ_NO              VARCHAR2(20)   not null
        constraint GPRINT_VOUCHER_DATA_SQL_CFG_PK
            primary key,
    P_SEQ_NO            VARCHAR2(20)   not null,
    DATA_LAYER          CHAR(4),
    SUB_LAYER_LIST_NAME VARCHAR2(64),
    INQ_SQL             VARCHAR2(4000) not null,
    LINK_FIELD          VARCHAR2(64),
    REMARKS             VARCHAR2(60),
    CRT_TIME            CHAR(14),
    UPT_TIME            CHAR(14),
    RSV1                VARCHAR2(60),
    RSV2                VARCHAR2(60),
    RSV3                VARCHAR2(60),
    RSV4                VARCHAR2(60),
    RSV5                VARCHAR2(60)
);

create table G_DATA_DIC
(
    CORP_ID    VARCHAR2(32) not null,
    DIC_ID     VARCHAR2(32) not null,
    DATA_VALUE VARCHAR2(64) not null,
    DATA_DESC  VARCHAR2(384),
    DATA_TYPE  VARCHAR2(64) not null,
    IDX        NUMBER(8),
    REMARKS    VARCHAR2(180),
    SYSTEM     VARCHAR2(128),
    CRT_TIME   CHAR(14),
    UPT_TIME   CHAR(14),
    RSV1       VARCHAR2(180),
    RSV2       VARCHAR2(180),
    RSV3       VARCHAR2(180),
    RSV4       VARCHAR2(180),
    RSV5       VARCHAR2(180),
    constraint G_DATA_DIC_PK
        primary key (CORP_ID, DIC_ID, DATA_VALUE, DATA_TYPE)
);

comment on column G_DATA_DIC.CORP_ID is '法人号';

comment on column G_DATA_DIC.DIC_ID is '数据类型';

comment on column G_DATA_DIC.DATA_VALUE is '数据值';

comment on column G_DATA_DIC.DATA_DESC is '值描述';

comment on column G_DATA_DIC.DATA_TYPE is '数据类型';

comment on column G_DATA_DIC.IDX is '数据排序';

comment on column G_DATA_DIC.REMARKS is '类型说明';

comment on column G_DATA_DIC.SYSTEM is '所属系统';

comment on column G_DATA_DIC.CRT_TIME is '创建时间';

comment on column G_DATA_DIC.UPT_TIME is '最近一次修改时间';

comment on column G_DATA_DIC.RSV1 is '保留，暂不使用';

comment on column G_DATA_DIC.RSV2 is '保留，暂不使用';

comment on column G_DATA_DIC.RSV3 is '保留，暂不使用';

comment on column G_DATA_DIC.RSV4 is '保留，暂不使用';

comment on column G_DATA_DIC.RSV5 is '保留，暂不使用';

create table G_JOB_STEP_LOG
(
    RUN_ID     VARCHAR2(128) not null,
    SYSTEM     VARCHAR2(128),
    CORP_ID    VARCHAR2(20),
    JOB_ID     VARCHAR2(128),
    STEP_ID    NUMBER(8)     not null,
    ENV        VARCHAR2(4000),
    ERR_MSG    VARCHAR2(4000),
    START_DATE CHAR(8),
    END_DATE   CHAR(8),
    START_TIME CHAR(14),
    END_TIME   CHAR(14),
    STATUS     CHAR(2),
    RSV1       VARCHAR2(60),
    RSV2       VARCHAR2(60),
    RSV3       VARCHAR2(60),
    RSV4       VARCHAR2(60),
    RSV5       VARCHAR2(60),
    constraint G_JOB_STEP_LOG_PK
        primary key (RUN_ID, STEP_ID)
);

comment on table G_JOB_STEP_LOG is '任务步骤日志表';

comment on column G_JOB_STEP_LOG.RUN_ID is '执行ID';

comment on column G_JOB_STEP_LOG.SYSTEM is '所属系统';

comment on column G_JOB_STEP_LOG.CORP_ID is '法人ID';

comment on column G_JOB_STEP_LOG.JOB_ID is '任务ID';

comment on column G_JOB_STEP_LOG.STEP_ID is '步骤ID';

comment on column G_JOB_STEP_LOG.ENV is '步骤执行环境';

comment on column G_JOB_STEP_LOG.ERR_MSG is '错误信息';

comment on column G_JOB_STEP_LOG.START_DATE is '启动日期';

comment on column G_JOB_STEP_LOG.END_DATE is '结束日期';

comment on column G_JOB_STEP_LOG.START_TIME is '启动时间';

comment on column G_JOB_STEP_LOG.END_TIME is '结束时间';

comment on column G_JOB_STEP_LOG.STATUS is '状态';

comment on column G_JOB_STEP_LOG.RSV1 is '保留，暂不使用';

comment on column G_JOB_STEP_LOG.RSV2 is '保留，暂不使用';

comment on column G_JOB_STEP_LOG.RSV3 is '保留，暂不使用';

comment on column G_JOB_STEP_LOG.RSV4 is '保留，暂不使用';

comment on column G_JOB_STEP_LOG.RSV5 is '保留，暂不使用';

ALTER TABLE CIPS_109 MODIFY PAYMENT_REMARK VARCHAR(1750);
ALTER TABLE CIPS_109 MODIFY RECEIPT_REMARK VARCHAR(1750);
ALTER TABLE CIPS_109_LIST ADD AMT_MES CHAR(3);
ALTER TABLE CIPS_111 ADD FEE3_AMT NUMBER(18,0);
ALTER TABLE CIPS_111 ADD FEE3_BRNO VARCHAR2(35);
ALTER TABLE CIPS_111 ADD FEE4_AMT NUMBER(18,0);
ALTER TABLE CIPS_111 ADD FEE4_BRNO VARCHAR2(35);
ALTER TABLE CIPS_111 ADD FEE5_AMT NUMBER(18,0);
ALTER TABLE CIPS_111 ADD FEE5_BRNO VARCHAR2(35);
ALTER TABLE CIPS_111 ADD SOURCE_FLAG VARCHAR2(20);
ALTER TABLE CIPS_112 ADD SOURCE_FLAG VARCHAR2(20);
ALTER TABLE CIPS_113 ADD SOURCE_FLAG VARCHAR2(20);
ALTER TABLE CIPS_133 ADD SEND_FLAG VARCHAR2(20);
ALTER TABLE CIPS_382_LIST ADD AGT_PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_382_LIST ADD AGT_PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_382_LIST ADD AGT_PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_382_LIST ADD AGT_PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_382_LIST ADD PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_382_LIST ADD PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_382_LIST ADD PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_382_LIST ADD PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_382_LIST MODIFY RELIABILITY NUMBER(18,2);
ALTER TABLE CIPS_713_LIST ADD F_DBCR VARCHAR2(4);
ALTER TABLE CIPS_REMIT_PATH ADD AGT_PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_REMIT_PATH ADD AGT_PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH ADD AGT_PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH ADD AGT_PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_REMIT_PATH ADD PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_REMIT_PATH ADD PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH ADD PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH ADD PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_REMIT_PATH MODIFY RELIABILITY NUMBER(18,2);
ALTER TABLE CIPS_REMIT_PATH ADD RSV4 VARCHAR2(180);
ALTER TABLE CIPS_REMIT_PATH ADD RSV5 VARCHAR2(180);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD AGT_PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD AGT_PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD AGT_PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD AGT_PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD PTC_BIC VARCHAR2(11);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD PTC_CIPSID VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD PTC_LEI VARCHAR2(20);
ALTER TABLE CIPS_REMIT_PATH_TMP ADD PTC_OTHER VARCHAR2(35);
ALTER TABLE CIPS_REMIT_PATH_TMP MODIFY RELIABILITY NUMBER(18,2);
ALTER TABLE CIPS_TXN ADD VIP_ACTNO_FLAG VARCHAR2(2);
ALTER TABLE SCB_VIPACCT_INFO ADD VIP_TYPE VARCHAR2(1);
ALTER TABLE SCB_VIPACCT_INFO_TMP ADD VIP_TYPE VARCHAR2(1);

ALTER TABLE GNO_Q ADD MSG_CONTENT_TMP CLOB;
UPDATE GNO_Q SET MSG_CONTENT_TMP = TO_CLOB(MSG_CONTENT);
ALTER TABLE GNO_Q DROP COLUMN MSG_CONTENT;
ALTER TABLE GNO_Q RENAME COLUMN MSG_CONTENT_TMP TO MSG_CONTENT;

