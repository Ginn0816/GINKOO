delete from G_INQ_CFG where SQL_ID='053092001';
INSERT INTO G_INQ_CFG (CORP_ID, SQL_ID, SQL_STRING, DETAIL_SQL_STRING, SYSTEM, REMARKS, UPD_TIME, CRT_TIME, RSV1, RSV2, RSV3, RSV4, RSV5) VALUES ('ALL', '053092001', 'SELECT
seq_no,
  txn_seq_no,
  work_date,
  center_date,
  txn_dir,
  msg_id,
  tsaas_ref_no,
  ref_no,
  CASE WHEN txn_dir = ''1''
    THEN rcv_st_brno
  ELSE snd_st_brno END   AS op_st_brno,
  CASE WHEN txn_dir = ''1''
    THEN rcv_st_brname
  ELSE snd_st_brname END AS op_st_brname,
  pboc_status,
  tsaas_rsp_info,
  tsaas_status,
  cers_status,
  BIZ_PROC_INFO,
  comm_status,
  txn_status,
  upd_time,
  made_user,
  made_time,
  apv_user,
  apv_time
FROM @cips_info
WHERE msg_no = ''309'' AND REF_NO = :"REF_NO" AND msg_id = :"MSG_ID" AND txn_dir = :"TXN_DIR" AND
      center_date >= :"START_CENTER_DATE" AND center_date <= :"END_CENTER_DATE"  AND work_date >= :"START_WORK_DATE" AND work_date <= :"END_WORK_DATE" AND
      TXN_SEQ_NO like ''%'' || :"TXN_SEQ_NO" || ''%''
ORDER BY upd_time', null, 'CIPS', null, null, null, null, null, null, null, null);

--清算机构借贷通知查询SCPAY
delete from G_INQ_CFG where SQL_ID='051530001';
INSERT INTO G_INQ_CFG (CORP_ID, SQL_ID, SQL_STRING, DETAIL_SQL_STRING, SYSTEM, REMARKS, UPD_TIME, CRT_TIME, RSV1, RSV2, RSV3, RSV4, RSV5) VALUES ('SCB', '051530001', 'SELECT A.CENTER_DATE, A.DAY_NIGHT_FLG, A.TXN_SEQ_NO, A.MSG_ID, A.AMT, A.REF_NO, A.CIPS_DC_FLAG, B.COMM_STATUS, B.TXN_STATUS, B.PBOC_STATUS, B.BIZ_PROC_INFO, A.PAYER_ST_BRNO, A.PAYER_ST_BRNAME, A.PAYEE_ST_BRNO, A.PAYEE_ST_BRNAME,B.CORE_FWD_FLAG_SCPAY,B.CORE_PROC_STATUS_SCPAY FROM CIPS_153 A, CIPS_TXN B WHERE A.TXN_SEQ_NO = B.TXN_SEQ_NO AND A.CENTER_DATE >= :"START_CENTER_DATE" AND A.CENTER_DATE <= :"END_CENTER_DATE" AND A.AMT >= :"START_AMT" AND A.AMT <= :"END_AMT" AND A.MSG_ID LIKE ''%'' || :"MSG_ID" || ''%'' AND B.PBOC_STATUS = :"PBOC_STATUS" AND A.DAY_NIGHT_FLG = :"DAY_NIGHT_FLG" AND A.TXN_SEQ_NO = :"TXN_SEQ_NO" AND A.REF_NO = :"REF_NO" AND A.CIPS_DC_FLAG = :"CIPS_DC_FLAG" ORDER BY B.TXN_SEQ_NO DESC', null, 'CIPS', null, null, null, null, null, null, null, null);

--VIP账号维护查询VIP类型
delete from G_INQ_CFG where SQL_ID='050319901';
INSERT INTO G_INQ_CFG (CORP_ID, SQL_ID, SQL_STRING, DETAIL_SQL_STRING, SYSTEM, REMARKS, UPD_TIME, CRT_TIME, RSV1, RSV2, RSV3, RSV4, RSV5) VALUES ('SCB', '050229801', 'SELECT t.VIP_TYPE,
    t.VIP_ACTNO,
    t.VIP_NAME,
    t.VIP_LEVEL,
    t.REMARKS,
    case t.MOD_STATUS when ''00'' then ''正常'' else ''修改中'' end as MOD_STATUS,
    t.CRT_USER,
    t.CRT_TIME,
    t.UPD_USER,
    t.UPD_TIME,
    t.APV_USER,
    t.APV_TIME
FROM
    SCB_VIPACCT_INFO t
WHERE
    1=1
AND t.VIP_ACTNO=:"VIP_ACTNO"
', null, 'SCB', null, null, null, null, null, null, null, null);

--VIP账户维护VIP类型
delete from G_INQ_CFG where SQL_ID='050319901';
INSERT INTO G_INQ_CFG (CORP_ID, SQL_ID, SQL_STRING, DETAIL_SQL_STRING, SYSTEM, REMARKS, UPD_TIME, CRT_TIME, RSV1, RSV2, RSV3, RSV4, RSV5) VALUES ('SCB', '050319901', 'SELECT t.VIP_TYPE,
    t.VIP_ACTNO,
    t.VIP_NAME,
    t.VIP_LEVEL,
	t.REMARKS,
	t.CRT_TIME,
	t.UPD_TIME
FROM
    SCB_VIPACCT_INFO t
WHERE
    1=1
AND VIP_ACTNO=:"VIP_ACTNO"
AND VIP_NAME=:"VIP_NAME"
AND VIP_LEVEL=:"VIP_LEVEL"
AND VIP_TYPE=:"VIP_TYPE"', null, 'SCB', null, null, null, null, null, null, null, null);

delete from G_INQ_CFG where SQL_ID='050329901';
INSERT INTO G_INQ_CFG (CORP_ID, SQL_ID, SQL_STRING, DETAIL_SQL_STRING, SYSTEM, REMARKS, UPD_TIME, CRT_TIME, RSV1, RSV2, RSV3, RSV4, RSV5) VALUES ('ALL', '050329901', 'SELECT
*
FROM
    SCB_VIPACCT_INFO_TMP
WHERE
1=1
AND VIP_ACTNO=:"VIP_ACTNO"', null, 'CIPS', null, null, null, null, null, null, null, null);


