package com.gingkoo.anz.client;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gingkoo.cips.client.app.common.CIPS114RefCommon;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.cips.client.view.*;
import com.gingkoo.gui.core.client.config.BaseConfig;
import com.gingkoo.gui.core.client.config.PageViewConfig;
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
import com.gingkoo.gui.ui.component.client.form.UDynamicForm;
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
	private static String confirmFlag = "0";
	private static String isMod = "0";

	protected Page0501398_114 page114 = new Page0501398_114();
	private final CommonPageView page = this;
	protected ValueChangedListener frmBCXXCommon_COMPL_TYPE_Listener;

	protected Page05111 Page05111 = new Page05111();
	protected Page05114 Page05114 = new Page05114();
	protected List<String> msgNoSupport = Arrays.asList("111", "114");

	protected void executeBtnOkCmd() {
		Logger logger = Logger.getLogger("NameOfYourLogger");
		logger.log(Level.SEVERE, "gnan7:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));

		try{
			CIPSCommon.validateForm(CIPSCommon.getFormOfPage(Page05111, "frmBCXXCommon"),"交易信息检查不通过！");
			logger.log(Level.SEVERE, "gnan8:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));

		}catch (Exception e) {
			return;
		}
		UPrompt.alert("提示", "2");
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
				UPrompt.alert("提示", "3");
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
			public void onCallback(boolean status, Callback callback,
								   String commandItemName) {
				// TODO Auto-generated method stub
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

		Logger logger = Logger.getLogger("NameOfYourLogger");
		logger.log(Level.SEVERE, "gnan a:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));


		btn1.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				confirmFlag = "2";
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				logger.log(Level.SEVERE, "gnan b:" + inputDs.getCurrentValue("CNMS_SEQ_NO"));

				executeBtnOkCmd();
				promptWindow.close();
			}
		});

		btn2.addClickListener(new ClickListener(){
			@Override
			public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				if (flag) {
					BTN_SUB_OK_Cmd.setHead("SRV_ID", "ANZ_MADE_CNCL");
					inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
					logger.log(Level.SEVERE, "gnan c:" + inputDs.getCurrentValue("CNMS_SEQ_NO"));
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

				Logger logger = Logger.getLogger("NameOfYourLogger");
				logger.log(Level.SEVERE, "datasets:" + getDatasets().keySet());
				logger.log(Level.SEVERE, "controls:" + getControls().keySet());
				logger.log(Level.SEVERE, "msgNo:" + resultDs.getCurrentValue("MSG_NO"));


				if ("114".equals(resultDs.getCurrentValue("MSG_NO"))) {
					detailSwCommon.setTitle("退汇业务");
					SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").setEntity(page114.P114_inputDs);
				} else {
					SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").setEntity(Page05111.P05111_inputDs);
				}
				logger.log(Level.SEVERE, "entity:" + SUBWINDOW_Cmd.getCommandItem("SUBWINDOW_CmdItem").getEntity().getID());

				SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
				SUBWINDOW_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {

						String msgNo = resultDs.getCurrentValue("MSG_NO").toLowerCase();
						if ("111".equals(msgNo)) {
							Page05111.P05111_inputDs.setCurrentValue("COMPL_TYPE", "1");
							Page05111.P05111_inputDs.setCurrentValue("C_BOP_FLAG", "N");
							Page05111.P05111_inputDs.setCurrentValue("C_RCFE_FLAG", "N");
							Page05111.P05111_inputDs.setCurrentValue("RT_REASON", "");
							Page05111.P05111_inputDs.sync();

							// 添加日志
							System.out.println("=== 设置了111页面的默认值 ===");
							System.out.println("COMPL_TYPE: " + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE"));
							System.out.println("C_BOP_FLAG: " + Page05111.P05111_inputDs.getCurrentValue("C_BOP_FLAG"));
							System.out.println("C_RCFE_FLAG: " + Page05111.P05111_inputDs.getCurrentValue("C_RCFE_FLAG"));
							System.out.println("RT_REASON: " + Page05111.P05111_inputDs.getCurrentValue("RT_REASON"));


							Page0511101Common.settingBeforeShowInSubWindow(page, PageTypeEnum.QUERY, Page05111,false, new RunAsyncCallback() {
								@Override
								public void onFailure(Throwable reason) {
									UPrompt.alert("提示信息", "系统异常");
								}
								@Override
								public void onSuccess() {
									CIPSCommon.getWindowOfPage(Page0501398Cust.this, "detailSw111").show();
								}
							});
						} else if ("114".equals(msgNo)) {
							Page0511401Common.settingBeforeShowInSubWindow(page, PageTypeEnum.QUERY, Page05114,false, new RunAsyncCallback() {
								@Override
								public void onFailure(Throwable reason) {
									UPrompt.alert("提示信息", "系统异常");
								}
								@Override
								public void onSuccess() {
									CIPSCommon.getWindowOfPage(Page0501398Cust.this, "detailSw114").show();
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
							UPrompt.alert("错误", "报文类型非法");
							return;
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

				/*//xuh 201708 Enhance
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
				frmJYXX_IM2_NAME.setCanEdit(false);*/

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

		for (String msgNo : msgNoSupport) {
			CIPSCommon.getButtonOfPage(page, "BTN_SUB_CLOSE" + msgNo).addClickListener(new ClickListener() {
				@Override
				public void onClick(ClickEvent event) {
					CIPSCommon.getWindowOfPage(page, "detailSw" + msgNo).hide();
				}
			});

			CIPSCommon.getButtonOfPage(page, "BTN_SUB_OK" + msgNo).addClickListener(new ClickListener() {
				@Override
				public void onClick(ClickEvent event) {
					System.out.println("isMod=" + isMod);
					//测试
					Logger logger = Logger.getLogger("NameOfYourLogger");
					logger.log(Level.SEVERE, "gnan:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));//获取到值了
					//测试结束
					//start
					//转汇交易判断是否修改了原交易
					if (Page05111.P05111_inputDs.getCurrentValue("DBTR_NAME").equals(Page05111.P05111_inputDs.getCurrentValue("DBTR_NAME"))) {//付款人账户账号
						isMod = "0";
						logger.log(Level.SEVERE, "gnan1:" + Page05111.P05111_inputDs.getCurrentValue("DBTR_NAME"));

					} else {
						isMod = "1";
						logger.log(Level.SEVERE, "gnan2:" + Page05111.P05111_inputDs.getCurrentValue("DBTR_NAME"));

					}
					System.out.println("isMod=" + isMod);
					logger.log(Level.SEVERE, "gnan3:" + isMod);
					logger.log(Level.SEVERE, "gnan4:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + "5".equals(Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE"))
							+ "gnantest:" +!Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中"));//获取到值了
					// 转汇重新扫描
					if ("5".equals(Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE")) || !Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")) {
						logger.log(Level.SEVERE, "gnan5:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));//获取到值了
						executeBtnOkCmd();
					} else {
						logger.log(Level.SEVERE, "gnan6:" + Page05111.P05111_inputDs.getCurrentValue("COMPL_TYPE") + "gnantest:" + Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"));//获取到值了
						confirm(Page05111.P05111_inputDs.getCurrentValue("CHK_RESULT"),Page05111.P05111_inputDs.getCurrentValue("CNMS_SEQ_NO"),false);//测试通过20260426 10：30
					}
					//end
				}

			});
		}
	}


	@Override
	protected void mergeExternalConfigs(PageViewConfig config) {
		super.mergeExternalConfigs(config);

		List<BaseConfig> postComponents111 = new ArrayList<>();
		List<BaseConfig> postComponents114 = new ArrayList<>();

		postComponents111.add(CIPSCommon.buildButtonGroup("buttonGroup111", new CIPSCommon.IdAndNamePair("BTN_SUB_OK111", "确认"), new CIPSCommon.IdAndNamePair("BTN_SUB_CLOSE111", "关闭啦")));
		postComponents114.add(CIPSCommon.buildButtonGroup("buttonGroup114", new CIPSCommon.IdAndNamePair("BTN_SUB_OK114", "确认"), new CIPSCommon.IdAndNamePair("BTN_SUB_CLOSE114", "关闭")));

		CIPSCommon.mergeRefPageConfig(config, Page05111, "detailSw111", "客户汇款", new ArrayList<>(), postComponents111);
		CIPSCommon.mergeRefPageConfig(config, Page05114, "detailSw114", "退汇", new ArrayList<>(), postComponents114);
	}

	@Override
	protected void afterInitControls() {
		super.afterInitControls();
		Logger logger = Logger.getLogger("NameOfYourLogger");
		logger.log(Level.SEVERE, "window name:" + detailSwCommon.getID());

		Page05111.initControls(page);
		CIPSCommon.injectRefPage(page, page114, "detailSwCommon");
	}

}
