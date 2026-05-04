create table CIPS_111_REMIT
(
    SEQ_NO              CHAR(20) not null
        constraint CIPS_111_REMIT_PK
            primary key,
    CORP_ID             VARCHAR2(20),
    TXN_SEQ_NO          CHAR(20),
    ORI_SEQ_NO          CHAR(20),
    TXN_DIR             CHAR,
    SND_ST_BRNO         VARCHAR2(35),
    SND_ST_BRNAME       VARCHAR2(420),
    RCV_ST_BRNO         VARCHAR2(35),
    RCV_ST_BRNAME       VARCHAR2(420),
    SYS_CODE            CHAR(4),
    SRC_SYS             CHAR(4),
    DEST_SYS            CHAR(4),
    MSG_TYPE            VARCHAR2(20),
    MSG_SND_TIME        CHAR(14),
    MSG_PRIO            CHAR,
    MSG_ID              VARCHAR2(35),
    TXN_ID              VARCHAR2(35),
    WORK_DATE           CHAR(8),
    CENTER_DATE         CHAR(8),
    COMM_STATUS         CHAR(2),
    PBOC_STATUS         CHAR(4),
    TOTAL               NUMBER(15),
    ST_MTD              CHAR(4),
    E2E_ID              VARCHAR2(35),
    AMT_CURCD           CHAR(3),
    AMT                 NUMBER(18),
    INTR_DATE           CHAR(8),
    BIZ_CATE_CODE       VARCHAR2(35),
    BIZ_PRIO            CHAR(4),
    ST_TIME             VARCHAR2(14),
    ORI_AMT_CURCD       CHAR(3),
    ORI_AMT             NUMBER(18),
    RATE                VARCHAR2(12),
    CHARGE_BEARER       CHAR(4),
    FEE1_AMT_CURCD      CHAR(3),
    FEE1_AMT            NUMBER(18),
    FEE1_BRNO           VARCHAR2(35),
    FEE1_BRNAME         VARCHAR2(420),
    FEE2_AMT_CURCD      CHAR(3),
    FEE2_AMT            NUMBER(18),
    FEE2_BRNO           VARCHAR2(35),
    FEE2_BRNAME         VARCHAR2(420),
    PAYER_ST_BRNO       VARCHAR2(35),
    PAYER_ST_BRNAME     VARCHAR2(420),
    PAYER_BRNO          VARCHAR2(35),
    PAYER_BRNAME        VARCHAR2(420),
    PAYER_ACCT_BRNO     VARCHAR2(35),
    PAYER_ACCT_BRNAME   VARCHAR2(420),
    PAYER_ACTNO         VARCHAR2(34),
    PAYER_NAME          VARCHAR2(420),
    PAYER_ADDR1         VARCHAR2(210),
    PAYER_ADDR2         VARCHAR2(210),
    PAYER_ADDR3         VARCHAR2(210),
    PAYER_ADDR4         VARCHAR2(210),
    PAYER_ADDR5         VARCHAR2(210),
    PAYER_ADDR6         VARCHAR2(210),
    PAYER_ADDR7         VARCHAR2(210),
    PAYEE_ST_BRNO       VARCHAR2(35),
    PAYEE_ST_BRNAME     VARCHAR2(420),
    PAYEE_BRNO          VARCHAR2(35),
    PAYEE_BRNAME        VARCHAR2(420),
    PAYEE_ACCT_BRNO     VARCHAR2(35),
    PAYEE_ACCT_BRNAME   VARCHAR2(420),
    PAYEE_ACTNO         VARCHAR2(34),
    PAYEE_NAME          VARCHAR2(420),
    PAYEE_ADDR1         VARCHAR2(210),
    PAYEE_ADDR2         VARCHAR2(210),
    PAYEE_ADDR3         VARCHAR2(210),
    PAYEE_ADDR4         VARCHAR2(210),
    PAYEE_ADDR5         VARCHAR2(210),
    PAYEE_ADDR6         VARCHAR2(210),
    PAYEE_ADDR7         VARCHAR2(210),
    IM1_BANK            VARCHAR2(35),
    IM1_NAME            VARCHAR2(420),
    IM2_BANK            VARCHAR2(35),
    IM2_NAME            VARCHAR2(420),
    PS1                 VARCHAR2(420),
    PS2                 VARCHAR2(420),
    PS3                 VARCHAR2(420),
    PS4                 VARCHAR2(420),
    PLACE_AND_NAME      VARCHAR2(350),
    EXP_ST_DATE         CHAR(8),
    RSV1                VARCHAR2(420),
    RSV2                VARCHAR2(420),
    RSV3                VARCHAR2(420),
    RSV4                VARCHAR2(420),
    RSV5                VARCHAR2(420),
    DAY_NIGHT_FLG       CHAR(4),
    PAYER_ACCT_ORG_TYPE VARCHAR2(4),
    PAYER_TYPE          VARCHAR2(3),
    PAYER_ORG_ID        VARCHAR2(35),
    PAYER_ID_NO         VARCHAR2(105),
    PAYER_ID_TYPE       CHAR(2),
    PAYER_RES_CTRY      CHAR(2),
    PAYER_BR_ADDR1      VARCHAR2(210),
    PAYER_BR_ADDR2      VARCHAR2(210),
    PAYER_BR_ADDR3      VARCHAR2(210),
    PAYER_BR_ADDR4      VARCHAR2(210),
    PAYER_BR_ADDR5      VARCHAR2(210),
    PAYER_BR_ADDR6      VARCHAR2(210),
    PAYER_BR_ADDR7      VARCHAR2(210),
    PAYER_BR_ACTNO      VARCHAR2(34),
    PAYER_EID           VARCHAR2(60),
    PAYEE_ACCT_ORG_TYPE VARCHAR2(4),
    PAYEE_TYPE          VARCHAR2(3),
    PAYEE_ORG_ID        VARCHAR2(35),
    PAYEE_ID_NO         VARCHAR2(105),
    PAYEE_ID_TYPE       CHAR(2),
    PAYEE_RES_CTRY      CHAR(2),
    PAYEE_BR_ADDR1      VARCHAR2(210),
    PAYEE_BR_ADDR2      VARCHAR2(210),
    PAYEE_BR_ADDR3      VARCHAR2(210),
    PAYEE_BR_ADDR4      VARCHAR2(210),
    PAYEE_BR_ADDR5      VARCHAR2(210),
    PAYEE_BR_ADDR6      VARCHAR2(210),
    PAYEE_BR_ADDR7      VARCHAR2(210),
    PAYEE_BR_ACTNO      VARCHAR2(34),
    PAYEE_EID           VARCHAR2(60),
    ORDER_ID            VARCHAR2(35),
    ORDER_DESC1         VARCHAR2(105),
    ORDER_DESC2         VARCHAR2(105),
    ORDER_DESC3         VARCHAR2(105),
    ORDER_DESC4         VARCHAR2(105),
    ORDER_DESC5         VARCHAR2(105),
    ORDER_DESC6         VARCHAR2(105),
    ORDER_DESC7         VARCHAR2(105),
    ORDER_DESC8         VARCHAR2(105),
    PAYER_ADDR_M        VARCHAR2(1470),
    PAYER_BR_ADDR_M     VARCHAR2(1470),
    PAYEE_ADDR_M        VARCHAR2(1470),
    PAYEE_BR_ADDR_M     VARCHAR2(1470),
    PS_M                VARCHAR2(1680),
    ORDER_DESC_M        VARCHAR2(840),
    INS_INFORMATION_M   VARCHAR2(4000)
)
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

comment on column CIPS_111_REMIT.TXN_ID is '交易标识号'
/

comment on column CIPS_111_REMIT.WORK_DATE is '工作日期'
/

comment on column CIPS_111_REMIT.CENTER_DATE is '中心日期'
/

comment on column CIPS_111_REMIT.COMM_STATUS is '通讯状态'
/

comment on column CIPS_111_REMIT.PBOC_STATUS is '人行状态'
/

comment on column CIPS_111_REMIT.TOTAL is 'NumberOfTransactions'
/

comment on column CIPS_111_REMIT.ST_MTD is '清算方法'
/

comment on column CIPS_111_REMIT.E2E_ID is '端到端标识号'
/

comment on column CIPS_111_REMIT.AMT_CURCD is '交易币种'
/

comment on column CIPS_111_REMIT.AMT is '交易金额'
/

comment on column CIPS_111_REMIT.INTR_DATE is '起息日'
/

comment on column CIPS_111_REMIT.BIZ_CATE_CODE is '业务种类编码'
/

comment on column CIPS_111_REMIT.BIZ_PRIO is '业务优先级'
/

comment on column CIPS_111_REMIT.ST_TIME is '结算时间'
/

comment on column CIPS_111_REMIT.ORI_AMT_CURCD is '原始币种'
/

comment on column CIPS_111_REMIT.ORI_AMT is '原始金额'
/

comment on column CIPS_111_REMIT.RATE is '汇率'
/

comment on column CIPS_111_REMIT.CHARGE_BEARER is '费用承担方'
/

comment on column CIPS_111_REMIT.FEE1_AMT_CURCD is '费用1币种'
/

comment on column CIPS_111_REMIT.FEE1_AMT is '费用1'
/

comment on column CIPS_111_REMIT.FEE1_BRNO is '付费行号1'
/

comment on column CIPS_111_REMIT.FEE1_BRNAME is '付费行名1'
/

comment on column CIPS_111_REMIT.FEE2_AMT_CURCD is '费用2币种'
/

comment on column CIPS_111_REMIT.FEE2_AMT is '费用2'
/

comment on column CIPS_111_REMIT.FEE2_BRNO is '付费行号2'
/

comment on column CIPS_111_REMIT.FEE2_BRNAME is '付费行名2'
/

comment on column CIPS_111_REMIT.PAYER_ST_BRNO is '付款清算行行号'
/

comment on column CIPS_111_REMIT.PAYER_ST_BRNAME is '付款清算行行名'
/

comment on column CIPS_111_REMIT.PAYER_BRNO is '付款行行号'
/

comment on column CIPS_111_REMIT.PAYER_BRNAME is '付款行行名'
/

comment on column CIPS_111_REMIT.PAYER_ACCT_BRNO is '付款人开户行行号'
/

comment on column CIPS_111_REMIT.PAYER_ACCT_BRNAME is '付款人开户行名称'
/

comment on column CIPS_111_REMIT.PAYER_ACTNO is '付款人账号'
/

comment on column CIPS_111_REMIT.PAYER_NAME is '付款人名称'
/

comment on column CIPS_111_REMIT.PAYER_ADDR1 is '付款人地址1'
/

comment on column CIPS_111_REMIT.PAYER_ADDR2 is '付款人地址2'
/

comment on column CIPS_111_REMIT.PAYER_ADDR3 is '付款人地址3'
/

comment on column CIPS_111_REMIT.PAYER_ADDR4 is '付款人地址4'
/

comment on column CIPS_111_REMIT.PAYER_ADDR5 is '付款人地址5'
/

comment on column CIPS_111_REMIT.PAYER_ADDR6 is '付款人地址6'
/

comment on column CIPS_111_REMIT.PAYER_ADDR7 is '付款人地址7'
/

comment on column CIPS_111_REMIT.PAYEE_ST_BRNO is '收款清算行行号'
/

comment on column CIPS_111_REMIT.PAYEE_ST_BRNAME is '收款清算行行名'
/

comment on column CIPS_111_REMIT.PAYEE_BRNO is '收款行行号'
/

comment on column CIPS_111_REMIT.PAYEE_BRNAME is '收款行行名'
/

comment on column CIPS_111_REMIT.PAYEE_ACCT_BRNO is '收款人开户行行号'
/

comment on column CIPS_111_REMIT.PAYEE_ACCT_BRNAME is '收款人开户行名称'
/

comment on column CIPS_111_REMIT.PAYEE_ACTNO is '收款人账号'
/

comment on column CIPS_111_REMIT.PAYEE_NAME is '收款人名称'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR1 is '收款人地址1'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR2 is '收款人地址2'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR3 is '收款人地址3'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR4 is '收款人地址4'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR5 is '收款人地址5'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR6 is '收款人地址6'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR7 is '收款人地址7'
/

comment on column CIPS_111_REMIT.IM1_BANK is '中介机构1'
/

comment on column CIPS_111_REMIT.IM1_NAME is '中介机构1名称'
/

comment on column CIPS_111_REMIT.IM2_BANK is '中介机构2'
/

comment on column CIPS_111_REMIT.IM2_NAME is '中介机构2名称'
/

comment on column CIPS_111_REMIT.PS1 is '附言1'
/

comment on column CIPS_111_REMIT.PS2 is '附言2'
/

comment on column CIPS_111_REMIT.PS3 is '附言3'
/

comment on column CIPS_111_REMIT.PS4 is '附言4'
/

comment on column CIPS_111_REMIT.PLACE_AND_NAME is 'PLACE_AND_NAME'
/

comment on column CIPS_111_REMIT.EXP_ST_DATE is '期望结算日期'
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

comment on column CIPS_111_REMIT.DAY_NIGHT_FLG is '日间夜间标志'
/

comment on column CIPS_111_REMIT.PAYER_ACCT_ORG_TYPE is '付款人开户机构类型'
/

comment on column CIPS_111_REMIT.PAYER_TYPE is '付款人类型'
/

comment on column CIPS_111_REMIT.PAYER_ORG_ID is '付款人组织机构代码'
/

comment on column CIPS_111_REMIT.PAYER_ID_NO is '付款人证件号码'
/

comment on column CIPS_111_REMIT.PAYER_ID_TYPE is '付款人证件类型'
/

comment on column CIPS_111_REMIT.PAYER_RES_CTRY is '付款人常驻国家(地区)代码'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR1 is '付款非银行支付机构地址1'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR2 is '付款非银行支付机构地址2'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR3 is '付款非银行支付机构地址3'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR4 is '付款非银行支付机构地址4'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR5 is '付款非银行支付机构地址5'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR6 is '付款非银行支付机构地址6'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR7 is '付款非银行支付机构地址7'
/

comment on column CIPS_111_REMIT.PAYER_BR_ACTNO is '付款非银行支付机构账号'
/

comment on column CIPS_111_REMIT.PAYER_EID is '付款人EID'
/

comment on column CIPS_111_REMIT.PAYEE_ACCT_ORG_TYPE is '收款人开户机构类型'
/

comment on column CIPS_111_REMIT.PAYEE_TYPE is '收款人类型'
/

comment on column CIPS_111_REMIT.PAYEE_ORG_ID is '收款人组织机构代码'
/

comment on column CIPS_111_REMIT.PAYEE_ID_NO is '收款人证件号码'
/

comment on column CIPS_111_REMIT.PAYEE_ID_TYPE is '收款人证件类型'
/

comment on column CIPS_111_REMIT.PAYEE_RES_CTRY is '收款人常驻国家(地区)代码'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR1 is '收款非银行支付机构地址1'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR2 is '收款非银行支付机构地址2'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR3 is '收款非银行支付机构地址3'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR4 is '收款非银行支付机构地址4'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR5 is '收款非银行支付机构地址5'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR6 is '收款非银行支付机构地址6'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR7 is '收款非银行支付机构地址7'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ACTNO is '收款非银行支付机构账号'
/

comment on column CIPS_111_REMIT.PAYEE_EID is '收款人EID'
/

comment on column CIPS_111_REMIT.ORDER_ID is '订单编号'
/

comment on column CIPS_111_REMIT.ORDER_DESC1 is '订单描述1'
/

comment on column CIPS_111_REMIT.ORDER_DESC2 is '订单描述2'
/

comment on column CIPS_111_REMIT.ORDER_DESC3 is '订单描述3'
/

comment on column CIPS_111_REMIT.ORDER_DESC4 is '订单描述4'
/

comment on column CIPS_111_REMIT.ORDER_DESC5 is '订单描述5'
/

comment on column CIPS_111_REMIT.ORDER_DESC6 is '订单描述6'
/

comment on column CIPS_111_REMIT.ORDER_DESC7 is '订单描述7'
/

comment on column CIPS_111_REMIT.ORDER_DESC8 is '订单描述8'
/

comment on column CIPS_111_REMIT.PAYER_ADDR_M is '付款人地址'
/

comment on column CIPS_111_REMIT.PAYER_BR_ADDR_M is '付款非银行支付机构地址'
/

comment on column CIPS_111_REMIT.PAYEE_ADDR_M is '收款人地址'
/

comment on column CIPS_111_REMIT.PAYEE_BR_ADDR_M is '收款非银行支付机构地址'
/

comment on column CIPS_111_REMIT.PS_M is '附言'
/

comment on column CIPS_111_REMIT.ORDER_DESC_M is '订单描述'
/

comment on column CIPS_111_REMIT.INS_INFORMATION_M is '致收款银行附言'
/


