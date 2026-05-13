package com.gingkoo.anz.client;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.gingkoo.cips.client.app.common.CIPS114RefCommon;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.core.client.utils.DateUtils;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.event.ValueChangeEvent;
import com.gingkoo.gui.data.client.dataset.event.ValueChangedListener;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.events.ReferencePageGetDataEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.util.SC;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;

public class Page0501398Cust extends Page0501398 {

	private static final long serialVersionUID = 1L;
	protected ValueChangedListener frmBCXX_COMPL_TYPE_Listener;
	protected ValueChangedListener frmBCXX_CUST_ACTNO_Listener;
	protected ValueChangedListener frmBCXXCommon_COMPL_TYPE_Listener;

	private static String confirmFlag = "0";
	private static String isMod = "0";

	protected Page0501398_114 page114 = new Page0501398_114();
	private final CommonPageView page = this;

	protected void executeBtnOkCmd() {
		try{
			CIPSCommon.validateForm(frmBCXX,"交易信息检查不通过！");
		}catch (Exception e) {
			return;
		}
		inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
		inputDs.setCurrentValue("IS_MOD", isMod);
		inputDs.setCurrentValue("A_TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
		BTN_SUB_OK_Cmd.getCommandItem("BTN_SUB_OK_CmdItem").setEntity(inputDs);
		BTN_SUB_OK_Cmd.setHead("SRV_ID", "ANZ_01398");
		BTN_SUB_OK_Cmd.setHead("TXNO", "01398");
		BTN_SUB_OK.setDisabled(true);
		BTN_SUB_OK_Cmd.execute(new CommandCallback() {
			@Override
			public void onCallback(boolean status, Callback callback,String commandItemName) {
				System.out.println("===额外返回值===:"+ callback.getExtraData());
				BTN_SUB_OK.setDisabled(false);
				if (status) {
					System.out.println("===返回值===:"+ callback.getCallbackData());

					resultDs.setCurrentValue("CHK_FLAG", "&radic;");
					List<Map> datas = (List<Map>) callback.getCallbackData();
					Map data = datas.get(0);
					String authFlag = data.get("AUTH_FLAG").toString();
					String TXN_SEQ_NO = data.get("TXN_SEQ_NO").toString();
					String blockStatus = data.get("CNMS_BLOCK_STATUS").toString();
					if ("ON".equals(blockStatus)) {
						if ("1".equals(authFlag)){
							SC.say("该笔交易需要授权<br>远程黑名单系统已关闭，需要进行人工校验");
						} else {
							SC.say("提交成功，流水号为[" + TXN_SEQ_NO  +"]<br>远程黑名单系统已关闭，需要进行人工校验");
						}
					} else {
						if ("1".equals(authFlag)){
							SC.say("该笔交易需要授权");
						} else {
							SC.say("提交成功，流水号为[" + TXN_SEQ_NO  +"]");
						}
					}

					beforeRender();
					resultTb.redraw();
					detailSw.hide();
				} else {
					String errMsg = callback.getErrorMessage();
					if (errMsg != null && errMsg.length() > 6  && "059006".equals(errMsg.substring(0, 6))){
						UPrompt.confirm("提示", "您操作的交易为当日夜间来账且不属于VIP客户，按业务设" +
								"定应该T+1入账，继续操作将按T日入账，是否继续?", new PromptCallback() {
							@Override
							public void execute(Boolean value) {
								if (value != null && value) {
									confirmFlag = "1";
									// 继续提交
									executeBtnOkCmd();
								}
							}
						});
					}else if (errMsg != null && errMsg.length() > 6  && "ANZ004".equals(errMsg.substring(0, 6))){
						UPrompt.alert("提示", "超过入账截止时间点！");
						return;
					} else if (errMsg != null && errMsg.length() > 6 && "ANZ005".equals(errMsg.substring(0, 6))) {
						confirm(errMsg.substring(7, errMsg.length()-20),errMsg.substring(errMsg.length()-20),true);
					} else if (errMsg != null && errMsg.length() > 6 && "ANZ006".equals(errMsg.substring(0,6))) {
						UPrompt.confirm("提示", "黑名单扫描应答超时，是否重试？", new PromptCallback() {
							@Override
							public void execute(Boolean value) {
								if (value != null && value) {
									executeBtnOkCmd();
								}
							}
						});
					} else if (errMsg != null && errMsg.length() > 6  && "ANZ007".equals(errMsg.substring(0, 6))){
						btnRechkCmd();
					} else if (errMsg != null && errMsg.length() > 6  && "ANZ009".equals(errMsg.substring(0, 6))){
						UPrompt.alert("提示", "黑名单超时交易，如需修改，请勿转汇！");
						return;
					} else {
						SC.say("提交失败,错误信息"+callback.getErrorMessage());
					}
				}
			}
		});
	}

	protected void executeBtnOkCmd_114() {

		page114.P114_inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
		page114.P114_inputDs.setCurrentValue("IS_MOD", isMod);
		page114.P114_inputDs.setCurrentValue("A_TXN_SEQ_NO", page114.P114_inputDs.getCurrentValue("TXN_SEQ_NO"));
		page114.P114_inputDs.setCurrentValue("MSG_NO", "114");
		BTN_SUB_OK_Cmd.getCommandItem("BTN_SUB_OK_CmdItem").setEntity(page114.P114_inputDs);
		BTN_SUB_OK_Cmd.setHead("SRV_ID", "ANZ_01398");
		BTN_SUB_OK_Cmd.setHead("TXNO", "01398");
		BTN_SUB_OK.setDisabled(true);
		BTN_SUB_OK_Cmd.execute(new CommandCallback() {
			@Override
			public void onCallback(boolean status, Callback callback,String commandItemName) {
				System.out.println("===额外返回值===:"+ callback.getExtraData());
				BTN_SUB_OK.setDisabled(false);
				if (status) {
					System.out.println("===返回值===:"+ callback.getCallbackData());

					resultDs.setCurrentValue("CHK_FLAG", "&radic;");
					List<Map> datas = (List<Map>) callback.getCallbackData();
					Map data = datas.get(0);
					String authFlag = data.get("AUTH_FLAG").toString();
					String TXN_SEQ_NO = data.get("TXN_SEQ_NO").toString();
					if ("1".equals(authFlag)){
						SC.say("该笔交易需要授权");
					} else {
						SC.say("提交成功，流水号为[" + TXN_SEQ_NO  +"]");
					}

					beforeRender();
					resultTb.redraw();
					detailSw.hide();
					detailSwCommon.hide();

				} else {
					SC.say("提交失败,错误信息"+callback.getErrorMessage());
				}

			}
		});





	}

	protected void btnRechkCmd(){
		BTN_SUB_RECHK_Cmd.setHead("SRV_ID", "ANZ_CNMS_RECHK");
		inputDs.setCurrentValue("A_TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
		BTN_SUB_RECHK.setDisabled(true);
		BTN_SUB_RECHK_Cmd.execute(new CommandCallback() {

			@Override
			public void onCallback(boolean status, Callback callback, String commandItemName) {
				BTN_SUB_RECHK.setDisabled(false);
				if (status) {
					List<Map> datas = (List<Map>) callback.getCallbackData();
					Map data = datas.get(0);
					String chkReslut = data.get("CHK_RESULT").toString();
					String seqNo = data.get("CNMS_SEQ_NO").toString();
					// 来账未扫描交易转汇，重新扫描原交易不弹窗提醒
					if (!"".equals(chkReslut) && isMod == "0"){
						confirm(chkReslut,seqNo,false);
					} else {
						executeBtnOkCmd();
					}
				} else {
					String errMsg = callback.getErrorMessage();
					if (errMsg != null && errMsg.length() > 6 && "ANZ006".equals(errMsg.substring(0,6))) {
						UPrompt.confirm("提示", "黑名单扫描应答超时，是否重试？", new PromptCallback() {
							@Override
							public void execute(Boolean value) {
								if (value != null && value) {
									btnRechkCmd();
								}
							}
						});
					} else if (errMsg != null && errMsg.length() > 6 && "ANZ008".equals(errMsg.substring(0,6))) {
						SC.say("黑名单系统挡板开启，请稍后重试！");
					} else {
						SC.say("黑名单扫描失败,错误信息" + callback.getErrorMessage());
					}
				}
			}
		});
	}

	protected void confirm(String info,final String seqNo,final Boolean flag){
		final UWindow promptWindow = new UWindow();
		UButton btn1 = new UButton();
		btn1.setTitle("继续");
		UButton btn2 = new UButton();
		btn2.setTitle("取消");
		CIPSCommon.msgBox(promptWindow, info, inputDs, btn1, btn2);

		btn1.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				confirmFlag = "2";
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				executeBtnOkCmd();
				promptWindow.close();
			}
		});

		btn2.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				if (flag) {
					BTN_SUB_OK_Cmd.setHead("SRV_ID", "ANZ_MADE_CNCL");
					inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
					BTN_SUB_OK_Cmd.execute(new CommandCallback() {

						@Override
						public void onCallback(boolean status, Callback callback, String commandItemName) {
						}
					});
				}
				promptWindow.close();
			}
		});
	}


	protected void confirm_114(String info,final String seqNo,final Boolean flag){
		final UWindow promptWindow = new UWindow();
		UButton btn1 = new UButton();
		btn1.setTitle("继续");
		UButton btn2 = new UButton();
		btn2.setTitle("取消");
		CIPSCommon.msgBox(promptWindow, info, page114.P114_inputDs, btn1, btn2);

		btn1.addClickListener(new ClickListener(){
			@Override
			public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				confirmFlag = "2";
				page114.P114_inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				executeBtnOkCmd_114();
				promptWindow.close();
			}
		});

		btn2.addClickListener(new ClickListener(){
			@Override
			public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				promptWindow.close();
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

	@Override
	protected void beforeRender() {

		confirmFlag = "0";
		isMod = "0";
		frmBCXX_PAYEE_BRNO.setReferenceCmd(refCmd);
		//frmBCXX_PAYEE_ST_BRNO.setReferenceCmd(refCmd);
		//
		//frmYHHP_CMB_SIGN_BRNO.setReferenceCmd(refCmd);
		//在第一个数据集中加入一条默认记录，这里可以设置提交/查询Form的初始值
		//首先把初始值写到一个map，其key为fieldname,然后将该map传递给addDataRecord回调函数
		HashMap<String, Object> map = new HashMap<String, Object>();
		//日期赋值示例 map.put("WORK_DATE", DateUtils.parseDate(ContextHelper.getContext().getValue("WORK_DATE")));
		map.put("IS_VIP", "0");
		queryDs.addDataRecord(new DataRecord(map), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
				ListGridRecord gridRecord = record.getViewRecord();
				frmCXTJ.editRecord(gridRecord);
			}
		});

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		//日期赋值示例 map.put("WORK_DATE", DateUtils.parseDate(ContextHelper.getContext().getValue("WORK_DATE")));
		inputDs.addDataRecord(new DataRecord(map2), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
				ListGridRecord gridRecord = record.getViewRecord();
				frmBCXX.editRecord(gridRecord);
			}
		});

		inputDs.setCurrentValue("ACT_SYS", "1");
		frmBCXX.setReadOnly("ACT_SYS", true);
		frmBCXX_CUST_ACTNO.hide();
		frmBCXX_CUST_NAME.hide();
		frmBCXX_RT_REASON.hide();
		frmBCXX_RTR_REASON_CD.hide();
		frmBCXX_PAYEE_BRNO.hide();
		frmBCXX_PAYEE_BRNAME.hide();
		frmBCXX_LEDGER_ACTNO.hide();
		frmPlaceHolder.hide();

		// 隐藏重新检索黑名单按钮，改为判断后自动发起检索
		BTN_SUB_RECHK.hide();
	}

	@Override
	protected void bindEvent() {
		CIPS114RefCommon.bindEvent(this);

		this.BTN_INQ.addClickListener(new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
				//提交Command
				// 提交报文头的SRV_ID和TXNO)
				BTN_INQ_Cmd.setHead("SRV_ID", "GPAY_9999");
				BTN_INQ_Cmd.setHead("TXNO", "9999");
				//对于通用查询需要设置SQLID的值
				BTN_INQ_Cmd.setQueryCondition(queryDs);
				BTN_INQ_Cmd.setQuerySqlid("050139801");
				BTN_INQ.setDisabled(true);
				BTN_INQ_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback,String commandItemName) {
						BTN_INQ.setDisabled(false);
					}
				});
			}
		});
		this.BTN_RESET.addClickListener(new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
				beforeRender();
			}
		});
		this.resultTb.addRecordDoubleClickListener(new RecordDoubleClickListener() {
			@Override
			public void onRecordClick(RecordDoubleClickEvent event) {
				isMod = "0";
				if (resultDs.getCurrentValue("CHK_FLAG") != null) {
					UPrompt.alert("处理结果", "该记录已处理！");
					return;
				}
				frmJYXX_AMT.disableValueChangeEvent();

				inputDs.removeAllData();
				inputDs.sync();

				SUBWINDOW_Cmd.setHead("SRV_ID", "GPAY_9999");
				SUBWINDOW_Cmd.setHead("TXNO", "9999");

				String fieldNames[] = new String[1];
				fieldNames[0] = "TXN_SEQ_NO";
				SUBWINDOW_Cmd.setQueryCondition(resultDs, fieldNames);


				if ("114".equals(resultDs.getCurrentValue("MSG_NO"))) {
					detailSwCommon.setTitle("退汇业务");
					SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").setEntity(page114.P114_inputDs);
				} else {
					SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").setEntity(inputDs);
				}

				SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
				SUBWINDOW_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback,String commandItemName) {
						// 查询子列表
						if ("114".equals(resultDs.getCurrentValue("MSG_NO"))) {
							CIPS114RefCommon.settingBeforeShowInSubWindow(page, PageTypeEnum.QUERY, new RunAsyncCallback() {
								@Override
								public void onFailure(Throwable reason) {
									UPrompt.alert("提示信息", "系统异常");
								}
								@Override
								public void onSuccess() {
									detailSwCommon.show();
									page114.frmBCXXCommon_ACCOUNT_TYPE.hide();
									page114.frmBCXXCommon_PAYER_ACTNO.hide();
									page114.frmBCXXCommon_VALUE_DATE.hide();
									page114.frmBCXXCommon_AMT.hide();
									page114.frmBCXXCommon_C_BOP_FLAG.hide();
									page114.frmBCXXCommon_C_RCFE_FLAG.hide();

									SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").setEntity(inputDs);
									SUBWINDOW_Cmd.setQuerySqlid("050139804");
									SUBWINDOW_Cmd.execute(new CommandCallback() {
										@Override
										public void onCallback(boolean status, Callback callback,String commandItemName) {
											// TODO Auto-generated method stub
											page114.P114_inputDs.setCurrentValue("PAYER_ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));

										}
									});
								}
							});
						}else {
							BTN_INQ_Cmd2.setHead("SRV_ID", "GPAY_9999");
							BTN_INQ_Cmd2.setHead("TXNO", "9999");
							BTN_INQ_Cmd2.setQuerySqlid("050139802");
							BTN_INQ_Cmd2.setQueryCondition(resultDs);
							BTN_INQ_Cmd2.execute(new CommandCallback() {
								@Override
								public void onCallback(boolean status,
													   Callback callback, String commandItemName) {
									detailDs2.setCurrentValue("INS_INFORMATION",
											resultDs2.getCurrentValue("INS_INFORMATION"));
									detailDs2.sync();
								}
							});

							inputDs.setCurrentValue("COMPL_TYPE", "1");
							inputDs.setCurrentValue("C_BOP_FLAG", "N");
							inputDs.setCurrentValue("C_RCFE_FLAG", "N");
							inputDs.setCurrentValue("RT_REASON", "");
							inputDs.sync();
							detailSw.show();
							frmBCXX_CUST_ACTNO.show();
							frmBCXX_CUST_NAME.show();
							frmBCXX_RT_REASON.hide();
							frmBCXX_RTR_REASON_CD.hide();
							frmBCXX_ACT_SYS.hide();
							frmBCXX_PAYEE_BRNO.hide();
							frmBCXX_PAYEE_BRNAME.hide();
							frmBCXX_LEDGER_ACTNO.hide();

							//xuh 201708 Enhance
							frmFKXX_PAYER_ACTNO.setCanEdit(false);
							frmFKXX_PAYER_NAME.setCanEdit(false);
							frmFKXX_PAYER_ADDR1.setCanEdit(false);
							frmFKXX_PAYER_ADDR2.setCanEdit(false);
							frmFKXX_PAYER_ADDR3.setCanEdit(false);
							frmFKXX_PAYER_ADDR4.setCanEdit(false);
							frmFKXX_PAYER_ADDR5.setCanEdit(false);
							frmFKXX_PAYER_ADDR6.setCanEdit(false);
							frmFKXX_PAYER_ADDR7.setCanEdit(false);
							frmFKXX_PAYER_BRNO.setCanEdit(false);
							frmFKXX_PAYER_BRNAME.setCanEdit(false);
							frmFKXX_PAYER_ACCT_BRNO.setCanEdit(false);
							frmFKXX_PAYER_ACCT_BRNAME.setCanEdit(false);
							frmSKXX_PAYEE_ACTNO.setCanEdit(false);
							frmSKXX_PAYEE_NAME.setCanEdit(false);
							frmSKXX_PAYEE_ADDR1.setCanEdit(false);
							frmSKXX_PAYEE_ADDR2.setCanEdit(false);
							frmSKXX_PAYEE_ADDR3.setCanEdit(false);
							frmSKXX_PAYEE_ADDR4.setCanEdit(false);
							frmSKXX_PAYEE_ADDR5.setCanEdit(false);
							frmSKXX_PAYEE_ADDR6.setCanEdit(false);
							frmSKXX_PAYEE_ADDR7.setCanEdit(false);
							frmSKXX_PAYEE_BRNO.setCanEdit(false);
							frmSKXX_PAYEE_BRNAME.setCanEdit(false);
							frmSKXX_PAYEE_ACCT_BRNO.setCanEdit(false);
							frmSKXX_PAYEE_ACCT_BRNAME.setCanEdit(false);
							frmJYXX_PS1.setCanEdit(false);
							frmJYXX_PS2.setCanEdit(false);
							frmJYXX_PS3.setCanEdit(false);
							frmJYXX_PS4.setCanEdit(false);
							//xuh
							frmJYXX_IM1_BANK.setCanEdit(false);
							frmJYXX_IM1_NAME.setCanEdit(false);
							frmJYXX_IM2_BANK.setCanEdit(false);
							frmJYXX_IM2_NAME.setCanEdit(false);

							String fieldNames[] = new String[1];
							fieldNames[0] = "TXN_SEQ_NO";
							Query_Cmd2.setHead("SRV_ID", "GPAY_9999");
							Query_Cmd2.setQuerySqlid("050139803");
							Query_Cmd2.setQueryCondition(inputDs, fieldNames);
							Query_Cmd2.execute(new CommandCallback() {

								@Override
								public void onCallback(boolean status, Callback callback,
													   String commandItemName) {
									// TODO Auto-generated method stub
								}
							});
						}
					}
				});
			}
		});

		frmBCXX_COMPL_TYPE_Listener = new ValueChangedListener("COMPL_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {

				frmBCXX_CUST_ACTNO.hide();
				frmBCXX_CUST_NAME.hide();
				frmBCXX_RT_REASON.hide();
				frmBCXX_ACT_SYS.hide();
				frmBCXX_PAYEE_BRNO.hide();
				frmBCXX_PAYEE_BRNAME.hide();
				frmBCXX_LEDGER_ACTNO.hide();
				frmBCXX_RTR_REASON_CD.hide();



				//xuh 201708 Enhance
				frmFKXX_PAYER_ACTNO.setCanEdit(false);
				frmFKXX_PAYER_NAME.setCanEdit(false);
				frmFKXX_PAYER_ADDR1.setCanEdit(false);
				frmFKXX_PAYER_ADDR2.setCanEdit(false);
				frmFKXX_PAYER_ADDR3.setCanEdit(false);
				frmFKXX_PAYER_ADDR4.setCanEdit(false);
				frmFKXX_PAYER_ADDR5.setCanEdit(false);
				frmFKXX_PAYER_ADDR6.setCanEdit(false);
				frmFKXX_PAYER_ADDR7.setCanEdit(false);
				frmFKXX_PAYER_BRNO.setCanEdit(false);
				frmFKXX_PAYER_BRNAME.setCanEdit(false);
				frmFKXX_PAYER_ACCT_BRNO.setCanEdit(false);
				frmFKXX_PAYER_ACCT_BRNAME.setCanEdit(false);
				frmSKXX_PAYEE_ACTNO.setCanEdit(false);
				frmSKXX_PAYEE_NAME.setCanEdit(false);
				frmSKXX_PAYEE_ADDR1.setCanEdit(false);
				frmSKXX_PAYEE_ADDR2.setCanEdit(false);
				frmSKXX_PAYEE_ADDR3.setCanEdit(false);
				frmSKXX_PAYEE_ADDR4.setCanEdit(false);
				frmSKXX_PAYEE_ADDR5.setCanEdit(false);
				frmSKXX_PAYEE_ADDR6.setCanEdit(false);
				frmSKXX_PAYEE_ADDR7.setCanEdit(false);
				frmSKXX_PAYEE_BRNO.setCanEdit(false);
				frmSKXX_PAYEE_BRNAME.setCanEdit(false);
				frmSKXX_PAYEE_ACCT_BRNO.setCanEdit(false);
				frmSKXX_PAYEE_ACCT_BRNAME.setCanEdit(false);
				frmJYXX_PS1.setCanEdit(false);
				frmJYXX_PS2.setCanEdit(false);
				frmJYXX_PS3.setCanEdit(false);
				frmJYXX_PS4.setCanEdit(false);
				//xuh
				frmJYXX_IM1_BANK.setCanEdit(false);
				frmJYXX_IM1_NAME.setCanEdit(false);
				frmJYXX_IM2_BANK.setCanEdit(false);
				frmJYXX_IM2_NAME.setCanEdit(false);

				// 1-入账
				// 2-挂账
				// 3-退汇
				//5-转汇
				String newVal = (String)event.getNewValue();
				if ("1".equals(newVal)) {
					frmBCXX_CUST_ACTNO.show();
					frmBCXX_CUST_NAME.show();
					inputDs.setCurrentValue("RT_REASON", "");
					inputDs.sync();
				} else if ("2".equals(newVal)) {
					inputDs.setCurrentValue("ACT_SYS", "1");
					frmBCXX_ACT_SYS.show();
					frmBCXX_LEDGER_ACTNO.show();
					inputDs.setCurrentValue("RT_REASON", "");
					inputDs.sync();
				} else if ("3".equals(newVal)) {
					frmBCXX_RTR_REASON_CD.show();
					frmBCXX_RT_REASON.show();
					inputDs.setCurrentValue("CUST_ACTNO", "");
					inputDs.setCurrentValue("CUST_NAME", "");
					inputDs.sync();
				}else if ("5".equals(newVal)){
					//xuh 201708 Enhance
					frmFKXX_PAYER_ACTNO.setCanEdit(true);
					frmFKXX_PAYER_NAME.setCanEdit(true);
					frmFKXX_PAYER_ADDR1.setCanEdit(true);
					frmFKXX_PAYER_ADDR2.setCanEdit(true);
					frmFKXX_PAYER_ADDR3.setCanEdit(true);
					frmFKXX_PAYER_ADDR4.setCanEdit(true);
					frmFKXX_PAYER_ADDR5.setCanEdit(true);
					frmFKXX_PAYER_ADDR6.setCanEdit(true);
					frmFKXX_PAYER_ADDR7.setCanEdit(true);
					frmFKXX_PAYER_BRNO.setCanEdit(true);
					frmFKXX_PAYER_BRNAME.setCanEdit(true);
					frmFKXX_PAYER_ACCT_BRNO.setCanEdit(true);
					frmFKXX_PAYER_ACCT_BRNAME.setCanEdit(true);
					frmSKXX_PAYEE_ACTNO.setCanEdit(true);
					frmSKXX_PAYEE_NAME.setCanEdit(true);
					frmSKXX_PAYEE_ADDR1.setCanEdit(true);
					frmSKXX_PAYEE_ADDR2.setCanEdit(true);
					frmSKXX_PAYEE_ADDR3.setCanEdit(true);
					frmSKXX_PAYEE_ADDR4.setCanEdit(true);
					frmSKXX_PAYEE_ADDR5.setCanEdit(true);
					frmSKXX_PAYEE_ADDR6.setCanEdit(true);
					frmSKXX_PAYEE_ADDR7.setCanEdit(true);
					frmSKXX_PAYEE_BRNO.setCanEdit(true);
					frmSKXX_PAYEE_BRNAME.setCanEdit(true);
					frmSKXX_PAYEE_ACCT_BRNO.setCanEdit(true);
					frmSKXX_PAYEE_ACCT_BRNAME.setCanEdit(true);
					frmJYXX_PS1.setCanEdit(true);
					frmJYXX_PS2.setCanEdit(true);
					frmJYXX_PS3.setCanEdit(true);
					frmJYXX_PS4.setCanEdit(true);
					//xuh
					//luoxin-20181226
					frmJYXX_IM1_BANK.setCanEdit(true);
					frmJYXX_IM1_NAME.setCanEdit(true);
					frmJYXX_IM2_BANK.setCanEdit(true);
					frmJYXX_IM2_NAME.setCanEdit(true);

					frmBCXX_PAYEE_BRNO.show();
					frmBCXX_PAYEE_BRNAME.show();
					inputDs.setCurrentValue("RT_REASON", "");
					inputDs.sync();
				} else {
					inputDs.sync();
				}
			}
		};
		frmBCXX_COMPL_TYPE.addValueChangedListener(frmBCXX_COMPL_TYPE_Listener);


		this.BTN_SUB_OK.addClickListener(new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {

				try{
					CIPSCommon.validateForm(frmBCXX,"补充信息检查不通过！");
				}catch (Exception e) {
					return;
				}

				String alertMsg = "";
				String alertMsg1 = "";
				String alertMsg2 = "";
				String alertMsg3 = "";
				String alertMsg4 = "";
				if ("5".equals(inputDs.getCurrentValue("COMPL_TYPE"))) {
					String nameAddr = "";
					String payerName = inputDs.getCurrentValueAsString("PAYER_NAME");
					String payerAddr1 = inputDs.getCurrentValueAsString("PAYER_ADDR1");
					String payerAddr2 = inputDs.getCurrentValueAsString("PAYER_ADDR2");
					String payerAddr3 = inputDs.getCurrentValueAsString("PAYER_ADDR3");
					String payerAddr4 = inputDs.getCurrentValueAsString("PAYER_ADDR4");
					String payerAddr5 = inputDs.getCurrentValueAsString("PAYER_ADDR5");
					String payerAddr6 = inputDs.getCurrentValueAsString("PAYER_ADDR6");
					String payerAddr7 = inputDs.getCurrentValueAsString("PAYER_ADDR7");

					//            			nameAddr = nameAddr + " ADD. " +  payerAddr1 + payerAddr2 + payerAddr3 + payerAddr4 + payerAddr5 + payerAddr6 + payerAddr7;

					if (payerName != null && !("null").equals(payerName) && !("").equals(payerName)) {
						nameAddr = nameAddr + payerName;
					}

					if (payerAddr1 != null && !("null").equals(payerAddr1) && !("").equals(payerAddr1)) {
//            			nameAddr = nameAddr  + " ADD. " + payerAddr1;
						nameAddr = nameAddr + payerAddr1;
					}
					if (payerAddr2 != null && !("null").equals(payerAddr2) && !("").equals(payerAddr2)) {
						nameAddr = nameAddr + payerAddr2;
					}
					if (payerAddr3 != null && !("null").equals(payerAddr3) && !("").equals(payerAddr3)) {
						nameAddr = nameAddr + payerAddr3;
					}
					if (payerAddr4 != null && !("null").equals(payerAddr4) && !("").equals(payerAddr4)) {
						nameAddr = nameAddr + payerAddr4;
					}
					if (payerAddr5 != null && !("null").equals(payerAddr5) && !("").equals(payerAddr5)) {
						nameAddr = nameAddr + payerAddr5;
					}
					if (payerAddr6 != null && !("null").equals(payerAddr6) && !("").equals(payerAddr6)) {
						nameAddr = nameAddr + payerAddr6;
					}
					if (payerAddr7 != null && !("null").equals(payerAddr7) && !("").equals(payerAddr7)) {
						nameAddr = nameAddr + payerAddr7;
					}

					nameAddr = nameAddr.replaceAll("\r|\n|\t", " ");
					if (nameAddr.length() > 140) {
						alertMsg1 = "付款人户名+地址长度超长,当前长度[" + nameAddr.length() + "]多出 [" + (nameAddr.length()-140) + "]个字符;";
					}

					nameAddr = "";
					String payeeName = inputDs.getCurrentValueAsString("PAYEE_NAME");
					String payeeAddr1 = inputDs.getCurrentValueAsString("PAYEE_ADDR1");
					String payeeAddr2 = inputDs.getCurrentValueAsString("PAYEE_ADDR2");
					String payeeAddr3 = inputDs.getCurrentValueAsString("PAYEE_ADDR3");
					String payeeAddr4 = inputDs.getCurrentValueAsString("PAYEE_ADDR4");
					String payeeAddr5 = inputDs.getCurrentValueAsString("PAYEE_ADDR5");
					String payeeAddr6 = inputDs.getCurrentValueAsString("PAYEE_ADDR6");
					String payeeAddr7 = inputDs.getCurrentValueAsString("PAYEE_ADDR7");

					if (payeeName != null && !("null").equals(payeeName) && !("").equals(payeeName)) {
						nameAddr = nameAddr + payeeName;
					}
					if (payeeAddr1 != null && !("null").equals(payeeAddr1) && !("").equals(payeeAddr1)) {
						nameAddr = nameAddr + payeeAddr1;
					}
					if (payeeAddr2 != null && !("null").equals(payeeAddr2) && !("").equals(payeeAddr2)) {
						nameAddr = nameAddr + payeeAddr2;
					}
					if (payeeAddr3 != null && !("null").equals(payeeAddr3) && !("").equals(payeeAddr3)) {
						nameAddr = nameAddr + payeeAddr3;
					}
					if (payeeAddr4 != null && !("null").equals(payeeAddr4) && !("").equals(payeeAddr4)) {
						nameAddr = nameAddr + payeeAddr4;
					}
					if (payeeAddr5 != null && !("null").equals(payeeAddr5) && !("").equals(payeeAddr5)) {
						nameAddr = nameAddr + payeeAddr5;
					}
					if (payeeAddr6 != null && !("null").equals(payeeAddr6) && !("").equals(payeeAddr6)) {
						nameAddr = nameAddr + payeeAddr6;
					}
					if (payeeAddr7 != null && !("null").equals(payeeAddr7) && !("").equals(payeeAddr7)) {
						nameAddr = nameAddr + payeeAddr7;
					}


					nameAddr = nameAddr.replaceAll("\r|\n|\t", " ");
					if (nameAddr.length() > 140) {
						alertMsg2 = "收款人户名+地址长度超长,当前长度[" + nameAddr.length() + "]多出 [" + (nameAddr.length()-140) + "]个字符;";
					}

					String ps1 = inputDs.getCurrentValueAsString("PS1");
					String ps2 = inputDs.getCurrentValueAsString("PS2");
					String ps3 = inputDs.getCurrentValueAsString("PS3");
					String ps4 = inputDs.getCurrentValueAsString("PS4");
					String payerBrno = inputDs.getCurrentValueAsString("PAYER_BRNO");
					String payerStBrno = inputDs.getCurrentValueAsString("PAYER_ST_BRNO");
					String tmp72 = "";
					ps1 = ps1.replaceAll("\r|\n|\t", " ");
					if (ps1.length() > 140) {
						alertMsg3 = "附言1长度超长,当前长度[" + ps1.length() + "]多出 [" + (ps1.length()-140) + "]个字符;";
					}
					// XXXXXX取代6位SWIFT code
					if (payerBrno != null && !("null").equals(payerBrno) && !("").equals(payerBrno)) {
						tmp72 = "/ACC/XXXXXX/INS/" +payerBrno+ "/INS/" +payerStBrno;
					} else {
						tmp72 = "/ACC/XXXXXX/INS/" +payerStBrno;
					}
					if ((ps2 != null && !("").equals(ps2)) ||
							(ps3 != null && !("").equals(ps3)) ||
							(ps4 != null && !("").equals(ps4))) {
						tmp72 = tmp72 + "/ACC/";
					}
					tmp72 = tmp72 + ps2 + ps3 + ps4;
					tmp72 = tmp72.replaceAll("\r|\n|\t", " ");
					// tag72第一行35字符，换行后以//开头，每行33字符，总字符要加上//个数
					int len = tmp72.length();
					int line = (len - 35) / 33;
					int modle = (len - 35) % 33;
					if (modle != 0) {
						line += 1;
					}
					if (len + line * 2 > 35 * 6) {
						alertMsg4 = "附言2,3,4长度超长,当前长度[" + (len + line * 2) + "]多出 [" + ((len + line * 2)-35*6) + "]个字符;";
					}
					alertMsg = alertMsg1 + alertMsg2 + alertMsg3 + alertMsg4;
					if (!"".equals(alertMsg) && alertMsg != null) {
						UPrompt.alert("提示", alertMsg);
						return;
					}


					//转汇交易判断是否修改了原交易
					if (inputDs.getCurrentValue("PAYER_ACTNO").equals(queryDs.getCurrentValue("PAYER_ACTNO")) &&
							inputDs.getCurrentValue("PAYER_NAME").equals(queryDs.getCurrentValue("PAYER_NAME")) &&
							inputDs.getCurrentValue("PAYER_ADDR1").equals(queryDs.getCurrentValue("PAYER_ADDR1")) &&
							inputDs.getCurrentValue("PAYER_ADDR2").equals(queryDs.getCurrentValue("PAYER_ADDR2")) &&
							inputDs.getCurrentValue("PAYER_ADDR3").equals(queryDs.getCurrentValue("PAYER_ADDR3")) &&
							inputDs.getCurrentValue("PAYER_ADDR4").equals(queryDs.getCurrentValue("PAYER_ADDR4")) &&
							inputDs.getCurrentValue("PAYER_ADDR5").equals(queryDs.getCurrentValue("PAYER_ADDR5")) &&
							inputDs.getCurrentValue("PAYER_ADDR6").equals(queryDs.getCurrentValue("PAYER_ADDR6")) &&
							inputDs.getCurrentValue("PAYER_ADDR7").equals(queryDs.getCurrentValue("PAYER_ADDR7")) &&
							inputDs.getCurrentValue("PAYER_BRNO").equals(queryDs.getCurrentValue("PAYER_BRNO")) &&
							inputDs.getCurrentValue("PAYER_BRNAME").equals(queryDs.getCurrentValue("PAYER_BRNAME")) &&
							inputDs.getCurrentValue("PAYER_ACCT_BRNO").equals(queryDs.getCurrentValue("PAYER_ACCT_BRNO")) &&
							inputDs.getCurrentValue("PAYER_ACCT_BRNAME").equals(queryDs.getCurrentValue("PAYER_ACCT_BRNAME")) &&
							inputDs.getCurrentValue("PAYEE_ACTNO").equals(queryDs.getCurrentValue("PAYEE_ACTNO")) &&
							inputDs.getCurrentValue("PAYEE_NAME").equals(queryDs.getCurrentValue("PAYEE_NAME")) &&
							inputDs.getCurrentValue("PAYEE_ADDR1").equals(queryDs.getCurrentValue("PAYEE_ADDR1")) &&
							inputDs.getCurrentValue("PAYEE_ADDR2").equals(queryDs.getCurrentValue("PAYEE_ADDR2")) &&
							inputDs.getCurrentValue("PAYEE_ADDR3").equals(queryDs.getCurrentValue("PAYEE_ADDR3")) &&
							inputDs.getCurrentValue("PAYEE_ADDR4").equals(queryDs.getCurrentValue("PAYEE_ADDR4")) &&
							inputDs.getCurrentValue("PAYEE_ADDR5").equals(queryDs.getCurrentValue("PAYEE_ADDR5")) &&
							inputDs.getCurrentValue("PAYEE_ADDR6").equals(queryDs.getCurrentValue("PAYEE_ADDR6")) &&
							inputDs.getCurrentValue("PAYEE_ADDR7").equals(queryDs.getCurrentValue("PAYEE_ADDR7")) &&
							inputDs.getCurrentValue("PAYEE_BRNO").equals(queryDs.getCurrentValue("PAYEE_BRNO")) &&
							inputDs.getCurrentValue("PAYEE_BRNAME").equals(queryDs.getCurrentValue("PAYEE_BRNAME")) &&
							inputDs.getCurrentValue("PAYEE_ACCT_BRNO").equals(queryDs.getCurrentValue("PAYEE_ACCT_BRNO")) &&
							inputDs.getCurrentValue("PAYEE_ACCT_BRNAME").equals(queryDs.getCurrentValue("PAYEE_ACCT_BRNAME")) &&
							inputDs.getCurrentValue("PS1").equals(queryDs.getCurrentValue("PS1")) &&
							inputDs.getCurrentValue("PS2").equals(queryDs.getCurrentValue("PS2")) &&
							inputDs.getCurrentValue("PS3").equals(queryDs.getCurrentValue("PS3")) &&
							inputDs.getCurrentValue("PS4").equals(queryDs.getCurrentValue("PS4")) &&
							inputDs.getCurrentValue("IM1_BANK").equals(queryDs.getCurrentValue("IM1_BANK")) &&
							inputDs.getCurrentValue("IM1_NAME").equals(queryDs.getCurrentValue("IM1_NAME")) &&
							inputDs.getCurrentValue("IM2_BANK").equals(queryDs.getCurrentValue("IM2_BANK")) &&
							inputDs.getCurrentValue("IM2_NAME").equals(queryDs.getCurrentValue("IM2_NAME"))) {
						isMod = "0";
					} else {
						isMod = "1";
					}
				}


				System.out.println("isMod=" + isMod);
				// 转汇重新扫描
				if ("5".equals(inputDs.getCurrentValue("COMPL_TYPE")) || !inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")) {
					executeBtnOkCmd();
				} else {
					confirm(inputDs.getCurrentValue("CHK_RESULT"),inputDs.getCurrentValue("CNMS_SEQ_NO"),false);
				}
			}
		});
		this.BTN_SUB_CLOSE.addClickListener(new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
				//关闭当前子窗体
				detailSw.hide();
			}
		});

		frmBCXX_CUST_ACTNO_Listener = new ValueChangedListener("CUST_ACTNO") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event)
			{
				inputDs.setCurrentValue("CUST_ACTNO", inputDs.getCurrentValue("CUST_ACTNO").trim());
				inputDs.setCurrentValue("ACTNO", event.getNewValue().toString().trim());
				inputDs.setCurrentValue("SYS_CODE", "CIPS");

				inputDs.sync();

				String fieldNames[] = new String[2];
				fieldNames[0] = "ACTNO";
				fieldNames[1] = "SYS_CODE";

				Query_Cmd.clearExtraInfo();
				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
				Query_Cmd.setQuerySqlid("GPAY_ACCT_CUST_INFO");
				Query_Cmd.setQueryCondition(inputDs, fieldNames);
				Query_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {
						if (status) {
							String name="";
							if (callback.getCallbackCount() == 1) {
								if (!CIPSCommon.isDataNull(result2Ds, "CN_NAME")) {
									inputDs.setCurrentValue("CUST_NAME", result2Ds.getCurrentValue("CN_NAME"));
									name = result2Ds.getCurrentValue("CN_NAME");
								} else {
									inputDs.setCurrentValue("CUST_NAME", result2Ds.getCurrentValue("EN_NAME"));
									name = result2Ds.getCurrentValue("EN_NAME");
								}
								frmBCXX_CUST_NAME.setValue(name);
								result2Ds.removeAllData();
								result2Ds.sync();
							} else {
								UPrompt.alert("提示", "记账账号不存在");
							}
							inputDs.sync();
						} else {
							UPrompt.alert("提示", "查询失败");
						}
					}
				});
			}
		};
		frmBCXX_CUST_ACTNO.addValueChangedListener(frmBCXX_CUST_ACTNO_Listener);


		page114.BTN_SUB_OK_COMMON.addClickListener(new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				try{
					CIPSCommon.validateForm(page114.frmBCXXCommon,"补充信息检查不通过！");
				}catch (Exception e) {
					return;
				}

				if (!page114.P114_inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")) {
					executeBtnOkCmd_114();
				} else {
					confirm_114(page114.P114_inputDs.getCurrentValue("CHK_RESULT"),page114.P114_inputDs.getCurrentValue("CNMS_SEQ_NO"),false);
				}

			}
		});

		page114.BTN_SUB_CLOSE_COMMON.addClickListener(new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				//关闭当前子窗体
				detailSwCommon.hide();
			}
		});


		frmBCXXCommon_COMPL_TYPE_Listener = new ValueChangedListener("COMPL_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {

				page114.frmBCXXCommon_ACCOUNT_TYPE.hide();
				page114.frmBCXXCommon_PAYER_ACTNO.hide();
				page114.frmBCXXCommon_VALUE_DATE.hide();
				page114.frmBCXXCommon_AMT.hide();
				page114.frmBCXXCommon_C_BOP_FLAG.hide();
				page114.frmBCXXCommon_C_RCFE_FLAG.hide();

				// 1-发起重汇
				// 2-退回客户账
				// 3-置为已处置
				String newVal = (String)event.getNewValue();
				if ("2".equals(newVal)) {
					page114.frmBCXXCommon_ACCOUNT_TYPE.show();
					page114.frmBCXXCommon_PAYER_ACTNO.show();
					page114.frmBCXXCommon_VALUE_DATE.show();
					page114.frmBCXXCommon_AMT.show();
					page114.frmBCXXCommon_C_BOP_FLAG.show();
					page114.frmBCXXCommon_C_RCFE_FLAG.show();
					page114.P114_inputDs.setCurrentValue("C_BOP_FLAG", "N");
					page114.P114_inputDs.setCurrentValue("C_RCFE_FLAG", "N");
					page114.P114_inputDs.setCurrentValue("VALUE_DATE", DateUtils.parseDate(ContextHelper.getContext().getValue("WORK_DATE")));
					page114.P114_inputDs.sync();
				} else {
					page114.P114_inputDs.sync();
				}
			}
		};
		page114.frmBCXXCommon_COMPL_TYPE.addValueChangedListener(frmBCXXCommon_COMPL_TYPE_Listener);

	}

	//在reference中选取数据并点确定时触发此事件，在行号框按回车并正确查询也触发，可以取得Map<String,Object>的返回数据列表
	///BRNO	参与机构行号
	///BANK_NAME	参与机构全称
	///BANK_ST_BRNO	所属清算（直参）行号
	///BANK_ST_NAME	所属清算（直参）行名
	///SYS_JOIN_FLAG	加入业务系统标识
	///CNAPS_FLAG	一二代标识
	///BANK_TYPE	行别代码
	@Override
	public void onReferencePageGetData(ReferencePageGetDataEvent event)
	{
		System.out.println("===reference page get data===");
		System.out.println(event.getSource());
		System.out.println(event.getCallbackData());

		Map<String, Object> map = event.getCallbackData();
		String BRNO = "", BRNAME = "";

		if (map.get("BRNO") != null) {
			BRNO = (String) map.get("BRNO");
		}
		if (map.get("BRNAME") != null) {
			BRNAME = (String) map.get("BRNAME");
		}
		String source = event.getSource();
		inputDs.setCurrentValue("PAYEE_BRNO", BRNO);
		inputDs.setCurrentValue("PAYEE_BRNAME", BRNAME);
		inputDs.sync();

	}

	@Override
	protected void afterInitControls() {
		super.afterInitControls();
		CIPSCommon.injectRefPage(page, page114, "detailSwCommon");
	}
}
