package com.gingkoo.cips.client.view;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import com.gingkoo.cips.client.app.common.AddrComponentDeclareFinal;
import com.gingkoo.cips.client.app.common.AddrComponentDeclareFinal.AddrComponent;
import com.gingkoo.cips.client.app.common.CIPS114Common;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;

public class Page0511402Cust extends Page0511402 {

	private static final long serialVersionUID = 1L;
	private static String opr;

	private final CommonPageView page = this;

	protected ClickListener BTN_INQ_Listener;
	protected ClickListener BTN_MOD_OK_Listener;
	protected ClickListener BTN_MOD_CNCL_Listener;
	protected RecordDoubleClickListener resultTb_Listener;
	protected ClickListener BTN_ADD_ClickListener;
	protected ClickListener BTN_DEL_ClickListener;
	protected RecordClickListener resultTb1_Listener;

	private static String confirmFlag = "0";
	private static String paymentPlatformMode = "0";

	protected void executeBtnOkCmd() {
		inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
		inputDs.setCurrentValue("RCV_BRNO", inputDs.getCurrentValue("INSTD_AGT_BIC"));
		inputDs.setXMLData("LIST", chrgDs, chrgDs.getFieldNames());

		HashMap<String, String> map = new HashMap<String, String>();
		BTN_MOD_OK_Cmd.setHead("SRV_ID", "CIPS_11402");
		BTN_MOD_OK_Cmd.setHead("TXNO", "1142");
		BTN_MOD_OK.setDisabled(true);
		BTN_MOD_OK_Cmd.execute(new CommandCallback() {
			@Override
			public void onCallback(boolean status, Callback callback, String commandItemName) {
				System.out.println("===返回值===:" + callback.getCallbackData());
				System.out.println("===额外返回值===:" + callback.getExtraData());

				BTN_MOD_OK.setDisabled(false);
				if (status) {
					resultDs.setCurrentValue("CHK_FLAG", "&radic;");
					SC.say("提交成功");
					resultTb.redraw();
					detailSw.hide();
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

	@Override
	protected void setting() {
		this.setPageID("");
	}

	@Override
	protected boolean beforeInitControls() {
		return super.beforeInitControls();
	}

	// 客户话可通过override该方法对inputDs设置默认值
	protected void defaultSetForInputDs(HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> map3) {

	}

	@Override
	protected void beforeRender() {
		confirmFlag = "0";

		CIPS114Common.settingBeforeRender(this, PageTypeEnum.MODE);

		resultTb.setHeight("480px");

		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();

		map2.put("SND_BRNO", ContextHelper.getContext().getValue("CIPS_BRNO"));
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		defaultSetForInputDs(map, map2, map3);
		queryDs.addDataRecord(new DataRecord(map), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
				ListGridRecord gridRecord = record.getViewRecord();
				frmCXTJ.editRecord(gridRecord);
			}
		});


	}

	@Override
	protected void bindEvent() {
		CIPS114Common.bindEvent(this);

		BTN_INQ_Listener = new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				BTN_INQ_Cmd.setHead("SRV_ID", "GPAY_9999");
				BTN_INQ_Cmd.setHead("TXNO", "9999");
				BTN_INQ_Cmd.setHead("ESCAPEFLAG", "TRUE");
				BTN_INQ_Cmd.setQueryCondition(queryDs);
				BTN_INQ_Cmd.setQuerySqlid("051140201");
				BTN_INQ.setDisabled(true);
				BTN_INQ_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {

						BTN_INQ.setDisabled(false);
					}
				});
			}
		};
		this.BTN_INQ.addClickListener(BTN_INQ_Listener);

		this.BTN_RESET.addClickListener(new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				beforeRender();
			}
		});

		resultTb_Listener = new RecordDoubleClickListener() {
			@Override
			public void onRecordClick(RecordDoubleClickEvent event) {
				if (resultDs.getCurrentValue("CHK_FLAG") != null) {
					UPrompt.alert("处理结果", "该记录已处理！");
					return;
				}

				SUBWINDOW_Cmd.setHead("SRV_ID", "GPAY_9999");
				SUBWINDOW_Cmd.setHead("TXNO", "9999");

				final String fieldNames[] = new String[1];
				fieldNames[0] = "TXN_SEQ_NO";
				SUBWINDOW_Cmd.setQueryCondition(resultDs, fieldNames);

				SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
				SUBWINDOW_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {
						SUBWINDOW_Cmd2.setHead("SRV_ID", "GPAY_9999");
						SUBWINDOW_Cmd2.setHead("TXNO", "9999");
						SUBWINDOW_Cmd2.setQuerySqlid("05114_qry_chrg_list");
						SUBWINDOW_Cmd2.setQueryCondition(resultDs, new String[]{"SEQ_NO"});
						SUBWINDOW_Cmd2.execute(new CommandCallback() {
							@Override
							public void onCallback(boolean status, Callback callback, String commandItemName) {

							}
						});


						//只读
						frmSCENARIO_RETURN_SCENARIO.setCanEdit(false);
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


						// 子页面必填
						frmCHRG_DTL_CHRG_AMT.setRequired(true);
						frmCHRG_DTL_CHRG_AMT_CURCD.setRequired(true);
						CIPS114Common.settingBeforeShowInSubWindow(page, PageTypeEnum.MODE);

						detailSw.show();
					}
				});

			}
		};
		this.resultTb.addRecordDoubleClickListener(resultTb_Listener);




		BTN_MOD_OK_Listener = new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {

				try {
					CIPSCommon.validateForm(frmSCENARIO,"退汇场景检查不通过!");
					CIPSCommon.validateForm(frmHEAD,"业务头检查不通过!");
					CIPSCommon.validateForm(frmSTAC,"结算账户检查不通过!");
					CIPSCommon.validateForm(frmORITXN,"原交易信息检查不通过!");
					CIPSCommon.validateForm(frmRTR,"退汇信息检查不通过!");
//					CIPSCommon.validateForm(frmCHRG,"费用信息检查不通过!");
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
					CIPSCommon.validateForm(frmCDTR_PTY, "退汇链路/收款人检查不通过!");
					CIPSCommon.validateForm(frmCDTR_PTYF,"退汇链路/收款行检查不通过!");
					CIPSCommon.validateForm(frmUCDTR,"退汇链路/最终收款人检查不通过!");
					CIPSCommon.validateForm(frmRTR_ORGTR,"退汇链路/退汇发起方检查不通过!");
				} catch (Exception e) {
					return;
				}

				inputDs.setCurrentValue("A_TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
				executeBtnOkCmd();
			}
		};
		this.BTN_MOD_OK.addClickListener(BTN_MOD_OK_Listener);

		BTN_MOD_CNCL_Listener = new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				HashMap<String, String> map = new HashMap<String, String>();
				BTN_MOD_CNCL_Cmd.setHead("SRV_ID", "CIPS_11405");
				BTN_MOD_CNCL_Cmd.setHead("TXNO", "11405");
				BTN_MOD_CNCL.setDisabled(true);
				BTN_MOD_CNCL_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {
						BTN_MOD_CNCL.setDisabled(false);
						if (status) {
							System.out.println("===返回值===:" + callback.getCallbackData());
							SC.say("取消成功");
							resultDs.setCurrentValue("CHK_FLAG", "&chi;");
							resultTb.redraw();
							detailSw.hide();
						} else {
							SC.say("提交失败,错误信息" + callback.getErrorMessage());
						}
					}
				});
			}
		};
		this.BTN_MOD_CNCL.addClickListener(BTN_MOD_CNCL_Listener);

		this.BTN_MOD_CLOSE.addClickListener(new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				detailSw.hide();
				chrgDs.removeAllData();
				chrgDs.sync();
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



}
