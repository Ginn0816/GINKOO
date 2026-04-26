package com.gingkoo.cips.client.view;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gingkoo.cips.client.app.common.AddrComponentDeclare;
import com.gingkoo.cips.client.app.common.AddrComponentDeclare.AddrComponent;
import com.gingkoo.cips.client.app.common.CIPS114Common;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.core.client.utils.DateUtils;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.form.fields.events.DoubleClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.fields.SectionItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class Page0511401Cust extends Page0511401 {

    private static final long serialVersionUID = 1L;

    protected ClickListener BTN_OK_Listener;

    private static String confirmFlag = "0";
    private static String paymentPlatformMode = "0";

    private final CommonPageView page = this;


    private static String opr;

    @Override
    protected void setting() {
        this.setPageID("");
    }

    @Override
    protected boolean beforeInitControls() {
        return super.beforeInitControls();
    }

    @Override
    protected void beforeRender() {
        confirmFlag = "0";
        frmSCENARIO_RETURN_SCENARIO.setCanEdit(true);

        CIPS114Common.settingBeforeRender(this, PageTypeEnum.ADD);

//
//    	frmZYGSLR_CONTENT.setEnforceLength(true);
//    	frmZYGSLR_CONTENT.setLength(1750);
//
//       	frmZYGSLR_SND_ST_BRNO.hide();
//    	frmZYGSLR_SND_ST_BRNAME.hide();
//
//    	frmZYGSLR_RCV_ST_BRNO.setReferenceCmd(refCmd);

        HashMap<String, Object> map = new HashMap<String, Object>();


        // 默认值
        map.put("RETURN_SCENARIO", "DRPT");
        map.put("TXN_NUM", "1");
        map.put("ST_METHOD", "CLRG");
        map.put("ST_PRIO", "URGT");
        map.put("RTRD_ST_AMT_CURCD", "CNY");


        //只读
        frmSTAC.setReadOnly(true);
        frmHEAD_MSG_ID.setCanEdit(false);
        frmHEAD_MSG_SND_TIME.setCanEdit(false);
        frmHEAD_TXN_NUM.setCanEdit(false);
        frmHEAD_ST_METHOD.setCanEdit(false);
        frmHEAD_CLR_SYS_REF.setCanEdit(false);
        frmRTR_ST_PRIO.setCanEdit(false);
        frmRTR_ST_DR_TIME.setCanEdit(false);
        frmRTR_ST_CR_TIME.setCanEdit(false);
        frmRTR_RTRD_ST_AMT_CURCD.setCanEdit(false);
        frmINSTG_INSTG_AGT_BIC.setCanEdit(false);
        frmRTR_ST_DATE.setCanEdit(false);


        //必填
        frmSCENARIO_RETURN_SCENARIO.setRequired(true);
        frmHEAD_TXN_NUM.setRequired(true);
        frmHEAD_ST_METHOD.setRequired(true);
        frmORITXN_OTXN_MSG_ID.setRequired(true);
        frmORITXN_OTXN_MSG_TYPE.setRequired(true);
        frmORITXN_OTXN_E2E_ID.setRequired(true);
        frmRTR_RTRD_ST_AMT.setRequired(true);
        frmRTR_RTRD_ST_AMT_CURCD.setRequired(true);
        frmRTR_CHRG_BEAR.setRequired(true);
        frmINSTG_INSTG_AGT_BIC.setRequired(true);
        frmINSTD_INSTD_AGT_BIC.setRequired(true);
        frmRTR_RTR_REASON_CD.setRequired(true);
        
        frmRTR_ACCOUNT_TYPE.setRequired(true);
        frmRTR_PAYER_ACTNO.setRequired(true);
        frmRTR_VALUE_DATE.setRequired(true);
        frmRTR_CHARGE_AMT.setRequired(true);
        frmRTR_C_BOP_FLAG.setRequired(true);
        frmRTR_C_RCFE_FLAG.setRequired(true);

        // 子页面必填
        frmCHRG_DTL_CHRG_AMT.setRequired(true);
        frmCHRG_DTL_CHRG_AMT_CURCD.setRequired(true);



        // 默认值
        map.put("INSTG_AGT_BIC", ContextHelper.getContext().getValue("CIPS_ST_BRNO"));
        map.put("ACCOUNT_TYPE", "1");

        map.put("SND_ST_BRNO", ContextHelper.getContext().getValue("CIPS_ST_BRNO"));
        map.put("SND_ST_BRNAME", ContextHelper.getContext().getValue("CIPS_ST_BRNAME"));
        tbCHRG.setHeight(80);
        inputDs.addDataRecord(new DataRecord(map), new DataAction() {
            @Override
            public void doAction(DataRecord record) {
                System.out.println("insert empty record: " + record.getDataMap());
                ListGridRecord gridRecord = record.getViewRecord();
                frmCDTR_PTY.editRecord(gridRecord);
                frmCDTR_PTYF.editRecord(gridRecord);
                frmCDTR_AGT.editRecord(gridRecord);
//                frmCHRG.editRecord(gridRecord);
                frmDBTR_PTY.editRecord(gridRecord);
                frmDBTR_PTYF.editRecord(gridRecord);
                frmDBTR_AGT.editRecord(gridRecord);
                frmHEAD.editRecord(gridRecord);
                frmIM_AGT1.editRecord(gridRecord);
                frmIM_AGT2.editRecord(gridRecord);
                frmIM_AGT3.editRecord(gridRecord);
                frmINIT_PTY.editRecord(gridRecord);
                frmINSTD.editRecord(gridRecord);
                frmINSTG.editRecord(gridRecord);
                frmORITXN.editRecord(gridRecord);
                frmPRE_AGT1.editRecord(gridRecord);
                frmPRE_AGT2.editRecord(gridRecord);
                frmPRE_AGT3.editRecord(gridRecord);
                frmRTR.editRecord(gridRecord);
                frmRTR_ORGTR.editRecord(gridRecord);
                frmSTAC.editRecord(gridRecord);
                frmUCDTR.editRecord(gridRecord);
                frmUDBTR.editRecord(gridRecord);
            }
        });

        HashMap<String, Object> otxnQryDsMap = new HashMap<String, Object>();
        otxnQryDs.addDataRecord(new DataRecord(otxnQryDsMap), new DataAction() {
            @Override
            public void doAction(DataRecord record) {
            }
        });

    }


    @Override
    protected void bindEvent() {
        CIPS114Common.bindEvent(this);

        frmORITXN_OTXN_MSG_ID.addDoubleClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(com.gingkoo.gui.ui.component.client.form.fields.events.DoubleClickEvent doubleClickEvent) {
                otxnQryDs.removeAllData();
                otxnQryDs.sync();
                otxnRstDs.removeAllData();
                otxnRstDs.sync();
                queryTxnSubWin.show();
                CIPSCommon.insertEmptyRecord(otxnQryDs);
            }
        });


        // 原交易查询
        this.BTN_OTXN_QRY.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                // TODO 按钮点击事件
                QueryTxn_Cmd.setHead("SRV_ID", "GPAY_9999");
                QueryTxn_Cmd.setHead("TXNO", "9999");
                QueryTxn_Cmd.setHead("ESCAPEFLAG", "TRUE");
                QueryTxn_Cmd.setQueryCondition(otxnQryDs);
                QueryTxn_Cmd.setQuerySqlid("051140102");
                BTN_OTXN_QRY.setDisabled(true);
                QueryTxn_Cmd.execute(new CommandCallback() {
                    @Override
                    public void onCallback(boolean status, Callback callback, String commandItemName) {
                        BTN_OTXN_QRY.setDisabled(false);
                    }
                });
            }
        });

        // 原交易查询双击选择
        this.tbOTXN.addRecordDoubleClickListener(new RecordDoubleClickListener() {
            @Override
            public void onRecordClick(RecordDoubleClickEvent recordDoubleClickEvent) {
                frmSCENARIO_RETURN_SCENARIO.setCanEdit(false);
                DataRecord record = recordDoubleClickEvent.getRecord();
                String oTxnMsgNo = record.getValue("MSG_NO");
                // 原交易信息
                inputDs.setCurrentValue("OTXN_MSG_ID"           , record.getValue("MSG_ID"));
                inputDs.setCurrentValue("OTXN_MSG_TYPE"         , record.getValue("MSG_TYPE"));
                inputDs.setCurrentValue("OTXN_MSG_SND_TIME"     , record.getValue("MSG_SND_TIME"));
                inputDs.setCurrentValue("OTXN_E2E_ID"           , record.getValue("E2E_ID"));
                inputDs.setCurrentValue("OTXN_AMT"              , record.getValue("AMT"));
                inputDs.setCurrentValue("OTXN_AMT_CURCD"        , "CNY");
                inputDs.setCurrentValue("OTXN_ST_DATE"          , record.getValueAsDate("CENTER_DATE"));
                inputDs.setCurrentValue("OTXN_BIZ_CATE_CODE"    , record.getValue("BIZ_CATE_CODE"));

                //交易补充信息
                inputDs.setCurrentValue("PAYER_ACTNO"           , record.getValue("PAYEE_ACTNO"));
                inputDs.setCurrentValue("VALUE_DATE"            , DateUtils.parseDate(ContextHelper.getContext().getValue("WORK_DATE")));
//                inputDs.setCurrentValue("AMT"                   , record.getValue("AMT"));
                if ("IAC".equals(record.getValue("C_BOP_FLAG"))){
                	inputDs.setCurrentValue("C_BOP_FLAG"        , "OTT"); 
                }else if ("IAS".equals(record.getValue("C_BOP_FLAG"))) {
                	inputDs.setCurrentValue("C_BOP_FLAG"        , "OTS"); 
                }else {
                	inputDs.setCurrentValue("C_BOP_FLAG"        , "N"); 
				}
                if ("2101".equals(record.getValue("C_RCFE_FLAG"))){
                	inputDs.setCurrentValue("C_RCFE_FLAG"        , "2111"); 
                }else if ("2107".equals(record.getValue("C_RCFE_FLAG"))) {
                	inputDs.setCurrentValue("C_RCFE_FLAG"        , "2107"); 
                }else {
                	inputDs.setCurrentValue("C_RCFE_FLAG"        , "N"); 
				}
       
                // 退汇结算金额/退汇金额
                inputDs.setCurrentValue("RTRD_ST_AMT"           , record.getValue("AMT"));
                inputDs.setCurrentValue("RTRD_ST_AMT_CURCD"     , "CNY");
                inputDs.setCurrentValue("RTRD_INSTD_AMT"        , record.getValue("AMT"));
                inputDs.setCurrentValue("RTRD_INSTD_AMT_CURCD"  , "CNY");
                // 费用承担方
                inputDs.setCurrentValue("CHRG_BEAR"             , "SHAR");

                // 收报行
                inputDs.setCurrentValue("INSTD_AGT_BIC"         , record.getValue("PAYER_ST_BRNO"));

                // 付款人，收款人
                String returnScenario = inputDs.getCurrentValue("RETURN_SCENARIO");

                if ("DRPT".equals(returnScenario)) {
                    // 原收款直参填入114付款行
                    inputDs.setCurrentValue("DBTR_PTYF_BIC"             , record.getValue("PAYEE_ST_BRNO"));
                    inputDs.setCurrentValue("DBTR_PTYF_NAME"            , record.getValue("PAYEE_ST_BRNAME"));
                    // 付款开户行留空

                    // 前序机构1留空
                } else if ("IDPT".equals(returnScenario)) {
                    // 原收款间参填入114付款行
                    //NOTE 可能选了间参行发起，但是选的交易没间参，此处赋值结果就为空
                    inputDs.setCurrentValue("DBTR_PTYF_BIC"             , record.getValue("PAYEE_BRNO"));
                    inputDs.setCurrentValue("DBTR_PTYF_NAME"            , record.getValue("PAYEE_BRNAME"));
                    // 付款开户行赋值为原收款直参
                    inputDs.setCurrentValue("DBTR_AGT_BIC"              , record.getValue("PAYEE_ST_BRNO"));
                    // 前序机构1留空
                } else if ("CUST".equals(returnScenario)) {
                    // 付款人名称
                    //NOTE: 原业务是112也映射到“人”？
                    inputDs.setCurrentValue("DBTR_PTY_NAME"         , record.getValue("PAYEE_NAME"));
                    // 付款人地址？只能用非结构化地址，7x70=》3x35，暂不映射

                    // 付款开户行赋值为原收款开户行
                    if (record.getValue("PAYEE_ACCT_BRNO") != null && !record.getValue("PAYEE_ACCT_BRNO").isEmpty()) {
                        inputDs.setCurrentValue("DBTR_AGT_BIC"    , record.getValue("PAYEE_ACCT_BRNO"));
                    } else {
                        inputDs.setCurrentValue("DBTR_AGT_NAME"             , record.getValue("PAYEE_ACCT_BRNAME"));
                    }

                    // 前序机构1填写发起间参（如果有）
                    inputDs.setCurrentValue("PRE_AGT1_BIC"    , record.getValue("PAYEE_BRNO"));
                } else {
                    SC.say("错误: 错误场景类型的值错误[" + returnScenario + "]");
                    return;
                }
                if (record.getValue("PAYER_ACCT_BRNO") != null && !record.getValue("PAYER_ACCT_BRNO").isEmpty()) {
                    inputDs.setCurrentValue("CDTR_AGT_BIC"    , record.getValue("PAYER_ACCT_BRNO"));
                }


                // CLRG场景下，中介机构1填写接收间参（如果有）
                inputDs.setCurrentValue("IM_AGT1_BIC"           , record.getValue("PAYER_BRNO"));

                // 收款开户行
                if (record.getValue("PAYER_ACCT_BRNO") != null && !record.getValue("PAYER_ACCT_BRNO").isEmpty()) {
                    inputDs.setCurrentValue("CDTR_AGT_BIC"    , record.getValue("PAYER_ACCT_BRNO"));
                } else {
                    inputDs.setCurrentValue("CDTR_AGT_NAME"             , record.getValue("PAYER_ACCT_BRNAME"));
                }

                // 收款人
                if ("112".equals(oTxnMsgNo)) {
                    if (record.getValue("PAYER_NAME") != null && !record.getValue("PAYER_NAME").isEmpty()) {
                        inputDs.setCurrentValue("CDTR_PTY_NAME", record.getValue("PAYER_NAME"));
                    } else {
                        inputDs.setCurrentValue("CDTR_PTY_NAME", record.getValue("PAYER_BR_BRNO"));
                    }
                } else {
                    inputDs.setCurrentValue("CDTR_PTY_NAME"         , record.getValue("PAYER_NAME"));
                }

                // 发起退汇的个人、机构等 退汇发起行行号(或退汇发起人身份标 识)、名称、地址至少填写一项，行号 /身份标识和名称优先填写
                inputDs.setCurrentValue("RTR_ORGTR_C_BIC"           , record.getValue("PAYEE_ST_BRNO"));

//                inputDs.sync();
//                queryTxnSubWin.close();
                //判断原交易是否已生成退汇报文
                String rtnFlag = record.getValue("RTN_FLAG");
                if ("1".equals(rtnFlag)) {
                	UPrompt.confirm("确认", "该笔交易已存在退汇记录，是否仍要退汇？", new PromptCallback() {
						
						@Override
						public void execute(Boolean value) {
							if (value != null && value) {
								inputDs.sync();
								queryTxnSubWin.close();
							}
						}
					});
                } else {
                	inputDs.sync();
                	queryTxnSubWin.close();
				}
            }
        });

        // 原交易查询关闭
        this.BTN_OTXN_CLOSE.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                queryTxnSubWin.close();
            }
        });


        BTN_OK_Listener = new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                try {
                    CIPSCommon.validateForm(frmSCENARIO,"退汇场景检查不通过!");
                    CIPSCommon.validateForm(frmHEAD,"业务头检查不通过!");
                    CIPSCommon.validateForm(frmSTAC,"结算账户检查不通过!");
                    CIPSCommon.validateForm(frmORITXN,"原交易信息检查不通过!");
                    CIPSCommon.validateForm(frmRTR,"退汇信息检查不通过!");
//                    CIPSCommon.validateForm(frmCHRG,"费用信息检查不通过!");
                    CIPSCommon.validateForm(frmINSTG,"发报方检查不通过!");
                    CIPSCommon.validateForm(frmINSTD,"收报方检查不通过!");
                    CIPSCommon.validateForm(frmUDBTR,"退汇链路/最终付款人检查不通过!");
                    CIPSCommon.validateForm(frmDBTR_PTY,"退汇链路/付款人检查不通过!");
                    CIPSCommon.validateForm(frmDBTR_PTYF,"退汇链路/付款行检查不通过!");
                    CIPSCommon.validateForm(frmINIT_PTY,"退汇链路/发起方检查不通过!");
                    CIPSCommon.validateForm(frmDBTR_AGT,"退汇链路/付款开户行检查不通过!");
                    CIPSCommon.validateForm(frmPRE_AGT1,"退汇链路/前序机构1检查不通过!");
                    CIPSCommon.validateForm(frmPRE_AGT2,"退汇链路/前序机构2检查不通过!");
                    CIPSCommon.validateForm(frmPRE_AGT3,"退汇链路/前序机构3检查不通过!");
                    CIPSCommon.validateForm(frmIM_AGT1,"退汇链路/中介机构1检查不通过!");
                    CIPSCommon.validateForm(frmIM_AGT2,"退汇链路/中介机构2检查不通过!");
                    CIPSCommon.validateForm(frmIM_AGT3,"退汇链路/中介机构3检查不通过!");
                    CIPSCommon.validateForm(frmCDTR_AGT,"退汇链路/收款开户行检查不通过!");
                    CIPSCommon.validateForm(frmCDTR_PTY,"退汇链路/收款人检查不通过!");
                    CIPSCommon.validateForm(frmCDTR_PTYF,"退汇链路/收款行检查不通过!");
                    CIPSCommon.validateForm(frmUCDTR,"退汇链路/最终收款人检查不通过!");
                    CIPSCommon.validateForm(frmRTR_ORGTR,"退汇链路/退汇发起方检查不通过!");

                    

//                    CIPSCommon.validateForm(frmCHRG_DTL,"费用明细检查不通过!");

                } catch (Exception e) {
                    return;
                }
                
                inputDs.sync();
                executeBtnOkCmd();
            }
        };
        this.BTN_OK.addClickListener(BTN_OK_Listener);



//        ((SectionItem) (frmCHRG.getFields()[0])).addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent clickEvent) {
//                if (tbCHRG.isVisible()) {
//                    BTN_ADD_CHARG_ITEM.setVisible(false);
//                    BTN_MOD_CHARG_ITEM.setVisible(false);
//                    BTN_DEL_CHARG_ITEM.setVisible(false);
//                    tbCHRG.setVisible(false);
//                    nvtbCHRG.setVisible(false);
//                } else {
//                    BTN_ADD_CHARG_ITEM.setVisible(true);
//                    BTN_MOD_CHARG_ITEM.setVisible(true);
//                    BTN_DEL_CHARG_ITEM.setVisible(true);
//                    tbCHRG.setVisible(true);
//                    nvtbCHRG.setVisible(true);
//                }
//                tbCHRG.draw();
//            }
//        });
        frmHEAD.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent doubleClickEvent) {
                frmHEAD.setIsGroup(true);
                frmHEAD.setGroupBorderCSS("1px solid black");
                frmHEAD.setPadding(10);
                frmHEAD.setGroupLabelBackgroundColor("red");
                frmHEAD.setCanDragResize(true);
//                frmCHAIN.focus();
//                frmCHAIN.setShowShadow(true);
//                frmCHAIN.setShadowDepth(5);
//                frmCHAIN.moveBelow();
//                frmHEAD.setBorder("");

//

//                SectionItem sectionItem = new SectionItem();
//                sectionItem.setDefaultValue("section1");
//                sectionItem.setSectionExpanded(false);
//                sectionItem.setItemIds("MSG_ID", "MSG_SND_TIME", "TXN_NUM");
////
////
//                FormItem[] fields = frmHEAD.getFields();
//                FormItem[] newFields = new FormItem[fields.length + 1];
//                newFields[0] = sectionItem;
//                for (int i = 0; i<fields.length; i++) {
//                    newFields[i+1] = fields[i];
//                }
//
//                frmHEAD.setItems(newFields);


//                sectionItem.setCanCollapse(true);

                        ((SectionItem) frmHEAD.getFields()[0]).setCanCollapse(true);
                        ((SectionItem) frmHEAD.getFields()[0]).setSectionHeaderClass("mySection");
                    }
                });





        // 费用相关事件
        // 双击查看
        this.tbCHRG.addRecordDoubleClickListener(new RecordDoubleClickListener() {
            @Override
            public void onRecordClick(RecordDoubleClickEvent recordDoubleClickEvent) {
                Map dataMap = chrgDs.getCurrentRecord().getDataMap();
                Map dataMapDup = new HashMap<String, Object>();
                dataMapDup.putAll(dataMap);
                dataMapDup.remove("itemID");
                chrgDtlDs.addDataRecord(new DataRecord(dataMapDup), new DataAction() {
                    @Override
                    public void doAction(DataRecord record) {
                        CIPS114Common.setChrgAddr(page);
                        chrgSubWin.show();
                        BTN_CHRG_DTL_OK.hide();
                    }
                });
            }
        });

        // 新增费用记录
        this.BTN_ADD_CHARG_ITEM.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent clickEvent) {
                HashMap<String, Object> chrgDtlDsMap = new HashMap<String, Object>();
                chrgDtlDs.addDataRecord(new DataRecord(chrgDtlDsMap), new DataAction() {
                    @Override
                    public void doAction(DataRecord record) {
                        opr = "ADD";
                        CIPS114Common.setChrgAddr(page);
                        chrgSubWin.show();
                        BTN_CHRG_DTL_OK.show();
                    }
                });
            }
        });

        // 修改费用记录
        this.BTN_MOD_CHARG_ITEM.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent clickEvent) {
                Map dataMap = chrgDs.getCurrentRecord().getDataMap();
                Map dataMapDup = new HashMap<String, Object>();
                dataMapDup.putAll(dataMap);
                dataMapDup.remove("itemID");
                chrgDtlDs.addDataRecord(new DataRecord(dataMapDup), new DataAction() {
                    @Override
                    public void doAction(DataRecord record) {
                        opr = "MOD";
                        CIPS114Common.setChrgAddr(page);
                        chrgSubWin.show();
                        BTN_CHRG_DTL_OK.show();
                    }
                });
            }
        });

        // 删除费用记录
        this.BTN_DEL_CHARG_ITEM.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent clickEvent) {
                chrgDs.removeCurrentRecord();
            }
        });

        // 退汇费用画面确定
        this.BTN_CHRG_DTL_OK.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent clickEvent) {

                try {
                    CIPSCommon.validateForm(frmCHRG_DTL,"费用明细不通过!");
                } catch (Exception e) {
                    return;
                }

                Logger logger = Logger.getLogger("NameOfYourLogger");
                logger.log(Level.FINE, "BTN_CHRG_DTL_OK clicked");
                logger.log(Level.FINE, "map:" + chrgDtlDs.getCurrentRecord().getDataMap().toString());
                String CHRG_AMT =chrgDtlDs.getCurrentValue("CHRG_AMT");
                String CHRG_AMT_CURCD =chrgDtlDs.getCurrentValue("CHRG_AMT_CURCD");
                String CHRG_AGT_BIC =chrgDtlDs.getCurrentValue("CHRG_AGT_BIC");
                String CHRG_AGT_LEI =chrgDtlDs.getCurrentValue("CHRG_AGT_LEI");
                String warnMessage = "";
                if("".equals(CHRG_AMT) || CHRG_AMT==null ){
                	 warnMessage = warnMessage + "金额不能为空！";
				}
                if("".equals(CHRG_AMT_CURCD) || CHRG_AMT_CURCD==null ){
                	 warnMessage = warnMessage + "金额币种不能为空！";
				}
                
//                if(!"".equals( CHRG_AMT) &&  CHRG_AMT !=null){
//                	if( ! CHRG_AMT .matches("(0|[1-9][0-9]{0,17})")){
//                		warnMessage = warnMessage +"金额输入不正确！";
//                	}
//                }
                if(!"".equals( CHRG_AMT_CURCD) &&  CHRG_AMT_CURCD !=null){
                	if( ! CHRG_AMT_CURCD .matches("[A-Z]{3,3}")){
                		warnMessage = warnMessage +"币种输入不正确！";
                	}
                }
                if(!"".equals(CHRG_AGT_BIC) && CHRG_AGT_BIC !=null){
                	if( !CHRG_AGT_BIC .matches("[A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}")){
                		warnMessage = warnMessage +"BIC码正则校验不通过！";
                	}
                }
                if(!"".equals(CHRG_AGT_LEI) && CHRG_AGT_LEI !=null){
                	if( !CHRG_AGT_LEI .matches("[A-Z0-9]{18,18}[0-9]{2,2}")){
                		warnMessage = warnMessage +"LEI码正则校验不通过！";
                	}
                }
              if(!"".equals(warnMessage) && warnMessage!=null ){
            	  System.out.println("warnMessage:           " + warnMessage);	
            	  SC.say("提交失败,错误信息:" +warnMessage);
            	  return ;
				}

                switch (opr) {
                    case "ADD":
                        Map dataMap = chrgDtlDs.getCurrentRecord().getDataMap();
                        Map dataMapDup = new HashMap<String, Object>();
                        dataMapDup.putAll(dataMap);
                        dataMapDup.remove("itemID");
                        chrgDs.addDataRecord(new DataRecord(dataMapDup), new DataAction() {
                            @Override
                            public void doAction(DataRecord record) {
                                chrgDtlDs.removeAllData();
                                chrgDtlDs.flushData();
                                chrgSubWin.close();
                                chrgDs.sync();
                            }
                        });
                        break;
                    case "MOD":
                        String[] fieldNames = chrgDs.getFieldNames();
                        for (int i=0; i<fieldNames.length; i++) {
                            String key = fieldNames[i];
                            if ("itemID".equals(key)) {
                                continue;
                            }
                            chrgDs.setCurrentValue(key, chrgDtlDs.getCurrentValue(key));
                        }
                        chrgDtlDs.removeAllData();
                        chrgDtlDs.flushData();
                        chrgSubWin.close();
                        chrgDs.sync();
                        break;
                    default:
                        logger.log(Level.SEVERE, "map:" + chrgDtlDs.getCurrentRecord().getDataMap().toString());
                        break;
                }

            }
        });
        // 退汇费用画面关闭
        this.BTN_CHRG_DTL_CLOSE.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                chrgSubWin.close();
            }
        });
    }


    protected void executeBtnOkCmd() {
        inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
        inputDs.setCurrentValue("RCV_BRNO", inputDs.getCurrentValue("INSTD_AGT_BIC"));
        inputDs.setXMLData("LIST", chrgDs, chrgDs.getFieldNames());
        HashMap<String, String> map = new HashMap<String, String>();
        BTN_OK_Cmd.setHead("SRV_ID", "CIPS_11401");
        BTN_OK_Cmd.setHead("TXNO", "11401");
        BTN_OK.setDisabled(true);
        BTN_OK_Cmd.execute(new CommandCallback() {
            @Override
            public void onCallback(boolean status, Callback callback, String commandItemName) {
                System.out.println("===返回值===:" + callback.getCallbackData());
                System.out.println("===额外返回值===:" + callback.getExtraData());

                BTN_OK.setDisabled(false);
                if (status) {
                    List<Map> datas = (List<Map>) callback.getCallbackData();
                    Map data = datas.get(0);
                    String TXN_SEQ_NO = data.get("TXN_SEQ_NO").toString();
                    SC.say("提交成功，流水号为[" + TXN_SEQ_NO + "]");
                    beforeRender();
                    chrgDs.removeAllData();
                    chrgDs.sync();
                } else {
                    HashMap<String, String> result = (HashMap<String, String>) callback.getExtraData();

                    System.out.println("===ErrorCode===:" + callback.getErrorCode());
                    System.out.println("===ErrorMessage===:" + callback.getErrorMessage());

                    String errMsg = callback.getErrorMessage();
                    if (errMsg != null && errMsg.length() > 6 && "059006".equals(errMsg.substring(0, 6))) {
                        UPrompt.confirm("提示", "该业务有风险: " + callback.getErrorMessage().substring(7) + ",是否仍要提交?", new PromptCallback() {
                            @Override
                            public void execute(Boolean value) {
                                if (value != null && value) {
                                    confirmFlag = "1";
                                    // 继续提交
                                    executeBtnOkCmd();
                                }
                            }
                        });
                    } else {
                        SC.say("提交失败,错误信息" + callback.getErrorMessage());
                    }

                }
            }
        });
    }



}
