-- auto-generated definition
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

