package com.gingkoo.cips.client.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.event.ValueChangeEvent;
import com.gingkoo.gui.data.client.dataset.event.ValueChangedListener;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.events.ReferencePageGetDataEvent;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class Page0511101Cust extends Page0511101 {

	private static final long serialVersionUID = 1L;
	protected boolean sSupportV2 = true; //2.0

	protected ValueChangedListener frmSKXX_PAYEE_ACTNO_Listener;
	protected ValueChangedListener frmJYXX_CHARGE_BEARER_Listener;
	protected ValueChangedListener frmJYXX_ORI_AMT_CURCD_Listener;
	protected ValueChangedListener frmFKXX_PAYER_ACTNO_Listener;

	//2.0
	protected ValueChangedListener frmFKXX_PAYER_TYPE_Listener;
	protected ValueChangedListener frmSKXX_PAYEE_TYPE_Listener;

	protected ValueChangedListener frmFKXX_PAYER_ACCT_ORG_TYPE_Listener;
	protected ValueChangedListener frmSKXX_PAYEE_ACCT_ORG_TYPE_Listener;

	//2.0End

	protected ValueChangedListener frmJYXX_AMT_Listener;
	protected ClickListener BTN_OK_Listener;
	protected ClickListener BTN_ADD_Listener;
	protected ClickListener BTN_DEL_Listener;

	private static String confirmFlag = "0";
	private static String paymentPlatformMode = "0";

	protected void executeBtnOkCmd() {
		inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
		inputDs.setCurrentValue("RCV_BRNO", inputDs.getCurrentValue("PAYEE_ST_BRNO"));

		String[] fields = new String[1];
		fields[0] = "INS_INFORMATION";
		inputDs.setXMLData("LIST", inputDs2, fields);

		HashMap<String, String> map = new HashMap<String, String>();
		BTN_OK_Cmd.setHead("SRV_ID", "CIPS_11101");
		BTN_OK_Cmd.setHead("TXNO", "11101");
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
					inputDs2.removeAllData();
					inputDs2.sync();
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
	protected void defaultSetForInputDs(HashMap<String, Object> map) {
		//2.0
		map.put("PAYER_TYPE", "ORG");
		map.put("PAYEE_TYPE", "ORG");

		map.put("PAYER_ACCT_ORG_TYPE", "BANK");
		map.put("PAYEE_ACCT_ORG_TYPE", "BANK");

		onChangePayerType("ORG");
		onChangePayeeType("ORG");
		onChangePayerAcctOrgType("BANK");
		onChangePayeeAcctOrgType("BANK");
		//2.0 END

	}

	//2.0
	private void onChangePayeeStBrno(boolean supportV2) {
		if (sSupportV2 == supportV2) {
			return;
		} else {
			sSupportV2 = supportV2;
		}

		if (supportV2) {

			frmFKXX_PAYER_RES_CTRY.show();
			frmFKXX_PAYER_EID.show();
			frmFKXX_PAYER_TYPE.show();
			frmFKXX_PAYER_ACCT_ORG_TYPE.show();

			frmSKXX_PAYEE_RES_CTRY.show();
			frmSKXX_PAYEE_EID.show();
			frmSKXX_PAYEE_TYPE.show();
			frmSKXX_PAYEE_ACCT_ORG_TYPE.show();

			frmJYXX_ORDER_ID.show();
			frmJYXX_ORDER_DESC1.show();
			frmJYXX_ORDER_DESC2.show();
			frmJYXX_ORDER_DESC3.show();
			frmJYXX_ORDER_DESC4.show();
			frmJYXX_ORDER_DESC5.show();
			frmJYXX_ORDER_DESC6.show();
			frmJYXX_ORDER_DESC7.show();
			frmJYXX_ORDER_DESC8.show();

			inputDs.setCurrentValue("PAYER_TYPE", "ORG");
			inputDs.setCurrentValue("PAYEE_TYPE", "ORG");

			inputDs.setCurrentValue("PAYER_ACCT_ORG_TYPE", "BANK");
			inputDs.setCurrentValue("PAYEE_ACCT_ORG_TYPE", "BANK");
			onChangePayerType("ORG");
			onChangePayeeType("ORG");
			onChangePayerAcctOrgType("BANK");
			onChangePayeeAcctOrgType("BANK");

			inputDs.sync();
		} else {
			frmFKXX_PAYER_RES_CTRY.hide();
			frmFKXX_PAYER_EID.hide();
			frmFKXX_PAYER_TYPE.hide();
			frmFKXX_PAYER_ORG_ID.hide();
			frmFKXX_PAYER_ID_TYPE.hide();
			frmFKXX_PAYER_ID_NO.hide();
			frmFKXX_PAYER_ACCT_ORG_TYPE.hide();
			frmFKXX_PAYER_BR_ACTNO.hide();
			frmFKXX_PAYER_BR_ADDR1.hide();
			frmFKXX_PAYER_BR_ADDR2.hide();
			frmFKXX_PAYER_BR_ADDR3.hide();
			frmFKXX_PAYER_BR_ADDR4.hide();
			frmFKXX_PAYER_BR_ADDR5.hide();
			frmFKXX_PAYER_BR_ADDR6.hide();
			frmFKXX_PAYER_BR_ADDR7.hide();

			frmSKXX_PAYEE_RES_CTRY.hide();
			frmSKXX_PAYEE_EID.hide();
			frmSKXX_PAYEE_TYPE.hide();
			frmSKXX_PAYEE_ORG_ID.hide();
			frmSKXX_PAYEE_ID_TYPE.hide();
			frmSKXX_PAYEE_ID_NO.hide();
			frmSKXX_PAYEE_ACCT_ORG_TYPE.hide();
			frmSKXX_PAYEE_BR_ACTNO.hide();
			frmSKXX_PAYEE_BR_ADDR1.hide();
			frmSKXX_PAYEE_BR_ADDR2.hide();
			frmSKXX_PAYEE_BR_ADDR3.hide();
			frmSKXX_PAYEE_BR_ADDR4.hide();
			frmSKXX_PAYEE_BR_ADDR5.hide();
			frmSKXX_PAYEE_BR_ADDR6.hide();
			frmSKXX_PAYEE_BR_ADDR7.hide();

			frmJYXX_ORDER_ID.hide();
			frmJYXX_ORDER_DESC1.hide();
			frmJYXX_ORDER_DESC2.hide();
			frmJYXX_ORDER_DESC3.hide();
			frmJYXX_ORDER_DESC4.hide();
			frmJYXX_ORDER_DESC5.hide();
			frmJYXX_ORDER_DESC6.hide();
			frmJYXX_ORDER_DESC7.hide();
			frmJYXX_ORDER_DESC8.hide();

			inputDs.setCurrentValue("PAYER_TYPE", "");
			inputDs.setCurrentValue("PAYER_ACCT_ORG_TYPE", "");
			inputDs.setCurrentValue("PAYER_RES_CTRY", "");
			inputDs.setCurrentValue("PAYER_EID", "");

			inputDs.setCurrentValue("PAYER_ORG_ID", "");
			inputDs.setCurrentValue("PAYER_ID_TYPE", "");
			inputDs.setCurrentValue("PAYER_ID_NO", "");

			inputDs.setCurrentValue("PAYER_BR_ACTNO", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR1", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR2", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR3", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR4", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR5", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR6", "");
			inputDs.setCurrentValue("PAYER_BR_ADDR7", "");

			inputDs.setCurrentValue("PAYEE_TYPE", "");
			inputDs.setCurrentValue("PAYEE_ACCT_ORG_TYPE", "");
			inputDs.setCurrentValue("PAYEE_RES_CTRY", "");
			inputDs.setCurrentValue("PAYEE_EID", "");

			inputDs.setCurrentValue("PAYEE_ORG_ID", "");
			inputDs.setCurrentValue("PAYEE_ID_TYPE", "");
			inputDs.setCurrentValue("PAYEE_ID_NO", "");

			inputDs.setCurrentValue("PAYEE_BR_ACTNO", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR1", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR2", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR3", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR4", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR5", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR6", "");
			inputDs.setCurrentValue("PAYEE_BR_ADDR7", "");

			inputDs.setCurrentValue("ORDER_ID", "");
			inputDs.setCurrentValue("ORDER_DESC1", "");
			inputDs.setCurrentValue("ORDER_DESC2", "");
			inputDs.setCurrentValue("ORDER_DESC3", "");
			inputDs.setCurrentValue("ORDER_DESC4", "");
			inputDs.setCurrentValue("ORDER_DESC5", "");
			inputDs.setCurrentValue("ORDER_DESC6", "");
			inputDs.setCurrentValue("ORDER_DESC7", "");
			inputDs.setCurrentValue("ORDER_DESC8", "");

			inputDs.sync();

		}
	}

	private void onChangePayerType(String payerType) {
		frmFKXX_PAYER_ORG_ID.hide();
		frmFKXX_PAYER_ID_TYPE.hide();
		frmFKXX_PAYER_ID_NO.hide();

		inputDs.setCurrentValue("PAYER_ORG_ID", "");
		inputDs.setCurrentValue("PAYER_ID_TYPE", "");
		inputDs.setCurrentValue("PAYER_ID_NO", "");
		inputDs.sync();

		if ("ORG".equals(payerType)) {
			frmFKXX_PAYER_ORG_ID.show();
		} else if ("PRI".equals(payerType)) {
			frmFKXX_PAYER_ID_TYPE.show();
			frmFKXX_PAYER_ID_NO.show();
		}
	}

	private void onChangePayeeType(String payeeType) {
		frmSKXX_PAYEE_ORG_ID.hide();
		frmSKXX_PAYEE_ID_TYPE.hide();
		frmSKXX_PAYEE_ID_NO.hide();

		inputDs.setCurrentValue("PAYEE_ORG_ID", "");
		inputDs.setCurrentValue("PAYEE_ID_TYPE", "");
		inputDs.setCurrentValue("PAYEE_ID_NO", "");
		inputDs.sync();

		if ("ORG".equals(payeeType)) {
			frmSKXX_PAYEE_ORG_ID.show();
		} else if ("PRI".equals(payeeType)) {
			frmSKXX_PAYEE_ID_TYPE.show();
			frmSKXX_PAYEE_ID_NO.show();
		}
	}

	private void onChangePayerAcctOrgType(String payerAcctOrgType) {
		frmFKXX_PAYER_BR_ACTNO.hide();
		frmFKXX_PAYER_ACCT_BRNO.hide();
		frmFKXX_PAYER_ACCT_BRNAME.hide();
		frmFKXX_PAYER_BR_ADDR1.hide();
		frmFKXX_PAYER_BR_ADDR2.hide();
		frmFKXX_PAYER_BR_ADDR3.hide();
		frmFKXX_PAYER_BR_ADDR4.hide();
		frmFKXX_PAYER_BR_ADDR5.hide();
		frmFKXX_PAYER_BR_ADDR6.hide();
		frmFKXX_PAYER_BR_ADDR7.hide();

		inputDs.setCurrentValue("PAYER_BR_ACTNO", "");
		inputDs.setCurrentValue("PAYER_ACCT_BRNO", "");
		inputDs.setCurrentValue("PAYER_ACCT_BRNAME", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR1", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR2", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR3", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR4", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR5", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR6", "");
		inputDs.setCurrentValue("PAYER_BR_ADDR7", "");
		inputDs.sync();

		if ("BANK".equals(payerAcctOrgType)) {
			frmFKXX_PAYER_ACCT_BRNO.show();
			frmFKXX_PAYER_ACCT_BRNAME.show();
			frmFKXX_PAYER_ACCT_BRNAME.setTitle("付款人开户行行名");
		} else if ("NBNK".equals(payerAcctOrgType)) {
			frmFKXX_PAYER_ACCT_BRNAME.show();
			frmFKXX_PAYER_ACCT_BRNAME.setTitle("付款非银行支付机构名称");
			frmFKXX_PAYER_BR_ACTNO.show();
			frmFKXX_PAYER_BR_ADDR1.show();
			frmFKXX_PAYER_BR_ADDR2.show();
			frmFKXX_PAYER_BR_ADDR3.show();
			frmFKXX_PAYER_BR_ADDR4.show();
			frmFKXX_PAYER_BR_ADDR5.show();
			frmFKXX_PAYER_BR_ADDR6.show();
			frmFKXX_PAYER_BR_ADDR7.show();
		}
	}

	private void onChangePayeeAcctOrgType(String payeeAcctOrgType) {
		frmSKXX_PAYEE_BR_ACTNO.hide();
		frmSKXX_PAYEE_ACCT_BRNO.hide();
		frmSKXX_PAYEE_ACCT_BRNAME.hide();
		frmSKXX_PAYEE_BR_ADDR1.hide();
		frmSKXX_PAYEE_BR_ADDR2.hide();
		frmSKXX_PAYEE_BR_ADDR3.hide();
		frmSKXX_PAYEE_BR_ADDR4.hide();
		frmSKXX_PAYEE_BR_ADDR5.hide();
		frmSKXX_PAYEE_BR_ADDR6.hide();
		frmSKXX_PAYEE_BR_ADDR7.hide();

		inputDs.setCurrentValue("PAYEE_BR_ACTNO", "");
		inputDs.setCurrentValue("PAYEE_ACCT_BRNO", "");
		inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR1", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR2", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR3", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR4", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR5", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR6", "");
		inputDs.setCurrentValue("PAYEE_BR_ADDR7", "");
		inputDs.sync();

		if ("BANK".equals(payeeAcctOrgType)) {
			frmSKXX_PAYEE_ACCT_BRNO.show();
			frmSKXX_PAYEE_ACCT_BRNAME.show();
			frmSKXX_PAYEE_ACCT_BRNAME.setTitle("收款人开户行行名");
		} else if ("NBNK".equals(payeeAcctOrgType)) {
			frmSKXX_PAYEE_ACCT_BRNAME.show();
			frmSKXX_PAYEE_ACCT_BRNAME.setTitle("收款非银行支付机构名称");
			frmSKXX_PAYEE_BR_ACTNO.show();
			frmSKXX_PAYEE_BR_ADDR1.show();
			frmSKXX_PAYEE_BR_ADDR2.show();
			frmSKXX_PAYEE_BR_ADDR3.show();
			frmSKXX_PAYEE_BR_ADDR4.show();
			frmSKXX_PAYEE_BR_ADDR5.show();
			frmSKXX_PAYEE_BR_ADDR6.show();
			frmSKXX_PAYEE_BR_ADDR7.show();
		}
	}

	//2.0End

	@Override
	protected void beforeRender() {
		confirmFlag = "0";
	//  sSupportV2 = true;   
		BTN_CLOSE.hide();

		/* 默认设置 */
		frmJYXX.setReadOnly("FEE1_AMT", false);
		frmJYXX.setReadOnly("FEE1_BRNO", false);
		frmJYXX.setReadOnly("FEE2_AMT", false);
		frmJYXX.setReadOnly("FEE2_BRNO", false);

//		frmJYXX_FEE1_AMT.setRequired(false);
//		frmJYXX_FEE1_BRNO.setRequired(false);
//		frmJYXX_RATE.setRequired(false);

//    	frmFKXX_PAYER_ACCT_BRNO.setReferenceCmd(refCmd);
		frmFKXX_PAYER_BRNO.setReferenceCmd(refCmd);
		frmFKXX_PAYER_ST_BRNO.setReferenceCmd(refCmd);

//    	frmSKXX_PAYEE_ACCT_BRNO.setReferenceCmd(refCmd);
		frmSKXX_PAYEE_BRNO.setReferenceCmd(refCmd);
		frmSKXX_PAYEE_ST_BRNO.setReferenceCmd(refCmd);

//     	frmJYXX_FEE1_BRNO.setReferenceCmd(refCmd);
//     	frmJYXX_FEE2_BRNO.setReferenceCmd(refCmd);
//     	frmJYXX_IM1_BANK.setReferenceCmd(refCmd);
// frmJYXX_IM2_BANK.setReferenceCmd(refCmd);

		paymentPlatformMode = ContextHelper.getContext().getValue("PAYMENT_PLATFORM_MODE");
		if (paymentPlatformMode.equals("0")) {
			frmJYXX_CHARGE_AMT.hide();
		}

		onChangePayeeStBrno(true); //2.0
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("SND_BRNO", ContextHelper.getContext().getValue("CIPS_ST_BRNO"));

		map.put("PAYER_ACCT_BRNO", ContextHelper.getContext().getValue("CIPS_BRNO"));
		map.put("PAYER_ACCT_BRNAME", ContextHelper.getContext().getValue("CIPS_BRNAME"));
		map.put("PAYER_ST_BRNO", ContextHelper.getContext().getValue("CIPS_ST_BRNO"));
		map.put("PAYER_ST_BRNAME", ContextHelper.getContext().getValue("CIPS_ST_BRNAME"));
//        if (ContextHelper.getContext().getValue("CIPS_BRNO").equals(ContextHelper.getContext().getValue("CIPS_ST_BRNO"))) {
//        	map.put("PAYER_BRNO", "");
//            map.put("PAYER_BRNAME", "");
//        } else {
//        	map.put("PAYER_BRNO", ContextHelper.getContext().getValue("CIPS_BRNO"));
//            map.put("PAYER_BRNAME", ContextHelper.getContext().getValue("CIPS_BRNAME"));
//        }

		map.put("BIZ_PRIO", "URGT");
		map.put("FEE_AMT", "0");
		defaultSetForInputDs(map);
		inputDs.addDataRecord(new DataRecord(map), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
				ListGridRecord gridRecord = record.getViewRecord();
				frmFKXX.editRecord(gridRecord);
				frmSKXX.editRecord(gridRecord);
				frmJYXX.editRecord(gridRecord);
			}
		});
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		feeDs.addDataRecord(new DataRecord(map1), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
				ListGridRecord gridRecord = record.getViewRecord();

			}
		});

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		detailDs.addDataRecord(new DataRecord(map2), new DataAction() {
			@Override
			public void doAction(DataRecord record) {
				System.out.println("insert empty record: " + record.getDataMap());
			}
		});

	}

	@Override
	protected void bindEvent() {

		//2.0
		frmFKXX_PAYER_TYPE_Listener = new ValueChangedListener("PAYER_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				onChangePayerType((String) event.getNewValue());
			}
		};
		frmFKXX_PAYER_TYPE.addValueChangedListener(frmFKXX_PAYER_TYPE_Listener);

		frmSKXX_PAYEE_TYPE_Listener = new ValueChangedListener("PAYEE_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				onChangePayeeType((String) event.getNewValue());
			}
		};
		frmSKXX_PAYEE_TYPE.addValueChangedListener(frmSKXX_PAYEE_TYPE_Listener);

		frmFKXX_PAYER_ACCT_ORG_TYPE_Listener = new ValueChangedListener("PAYER_ACCT_ORG_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				onChangePayerAcctOrgType((String) event.getNewValue());
			}
		};
		frmFKXX_PAYER_ACCT_ORG_TYPE.addValueChangedListener(frmFKXX_PAYER_ACCT_ORG_TYPE_Listener);

		frmSKXX_PAYEE_ACCT_ORG_TYPE_Listener = new ValueChangedListener("PAYEE_ACCT_ORG_TYPE") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				onChangePayeeAcctOrgType((String) event.getNewValue());
			}
		};
		frmSKXX_PAYEE_ACCT_ORG_TYPE.addValueChangedListener(frmSKXX_PAYEE_ACCT_ORG_TYPE_Listener);
		//2.0 END

		// 录入框[收款人账号]的ValueChange事件
		frmSKXX_PAYEE_ACTNO_Listener = new ValueChangedListener("PAYEE_ACTNO") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {

				String payeeActno = inputDs.getCurrentValue("PAYEE_ACTNO").replace(" ", "");
				inputDs.fireDataLoadedEvent();

				inputDs.setCurrentValue("OPP_ACTNO", inputDs.getCurrentValue("PAYEE_ACTNO"));
				String fieldNames[] = new String[1];
				fieldNames[0] = "OPP_ACTNO";

				Query_Cmd.clearExtraInfo();
				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
				Query_Cmd.setQuerySqlid("051110101");
				Query_Cmd.setQueryCondition(inputDs, fieldNames);
				Query_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {
						if (status && callback.getCallbackCount() == 1) {
							
							
							
							
							
							
							
							
							inputDs.setCurrentValue("PAYEE_RES_CTRY", resultDs.getCurrentValue("OPP_RES_CTRY"));
							inputDs.setCurrentValue("PAYEE_EID", resultDs.getCurrentValue("OPP_EID"));
							inputDs.setCurrentValue("PAYEE_ORG_ID", resultDs.getCurrentValue("OPP_ORG_ID"));
							
							
							
							if (!CIPSCommon.isDataNull(resultDs, "OPP_ID_NO")) {
								inputDs.setCurrentValue("PAYEE_TYPE", "PRI");
								
								onChangePayeeType("PRI");
								
								inputDs.setCurrentValue("PAYEE_ORG_ID", "");
								inputDs.setCurrentValue("PAYEE_ID_TYPE", resultDs.getCurrentValue("OPP_ID_TYPE"));
								inputDs.setCurrentValue("PAYEE_ID_NO", resultDs.getCurrentValue("OPP_ID_NO"));
								
							} else if (!CIPSCommon.isDataNull(resultDs, "OPP_ORG_ID")) {
								inputDs.setCurrentValue("PAYEE_TYPE", "ORG");
								onChangePayeeType("ORG");
								inputDs.setCurrentValue("PAYEE_ORG_ID", resultDs.getCurrentValue("OPP_ORG_ID"));
								inputDs.setCurrentValue("PAYEE_ID_TYPE", "");
								inputDs.setCurrentValue("PAYEE_ID_NO", "");
							} else {
								inputDs.setCurrentValue("PAYEE_TYPE", "ORG");
								onChangePayeeType("ORG");
								inputDs.setCurrentValue("PAYEE_ORG_ID", "");
								inputDs.setCurrentValue("PAYEE_ID_TYPE", "");
								inputDs.setCurrentValue("PAYEE_ID_NO", "");
							}
							
							if (!CIPSCommon.isDataNull(resultDs, "OPP_BR_ACTNO")) {
								inputDs.setCurrentValue("PAYEE_ACCT_ORG_TYPE", "NBNK");
								onChangePayeeAcctOrgType("NBNK");
								inputDs.setCurrentValue("PAYEE_ACCT_BRNO", "");
								inputDs.setCurrentValue("PAYEE_BR_ACTNO", resultDs.getCurrentValue("OPP_BR_ACTNO"));
								inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", resultDs.getCurrentValue("OPP_ACCT_BRNAME"));
								inputDs.setCurrentValue("PAYEE_BR_ADDR_M", resultDs.getCurrentValue("OPP_BR_ADDR_M"));
							} else {
								inputDs.setCurrentValue("PAYEE_ACCT_ORG_TYPE", "BANK");
								onChangePayeeAcctOrgType("BANK");
								inputDs.setCurrentValue("PAYEE_ACCT_BRNO", resultDs.getCurrentValue("OPP_ACCT_BRNO"));
								inputDs.setCurrentValue("PAYEE_BR_ACTNO", "");
								inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", resultDs.getCurrentValue("OPP_ACCT_BRNAME"));
								inputDs.setCurrentValue("PAYEE_BR_ADDR_M", "");
							}
							inputDs.setCurrentValue("PAYEE_NAME", resultDs.getCurrentValue("OPP_NAME"));
							inputDs.setCurrentValue("PAYEE_ADDR1", resultDs.getCurrentValue("OPP_ADDR"));
							inputDs.setCurrentValue("PAYEE_ADDR2", resultDs.getCurrentValue("OPP_ADDR1"));
							inputDs.setCurrentValue("PAYEE_ADDR3", resultDs.getCurrentValue("OPP_ADDR2"));
							inputDs.setCurrentValue("PAYEE_ADDR4", resultDs.getCurrentValue("OPP_ADDR3"));
							inputDs.setCurrentValue("PAYEE_ADDR5", resultDs.getCurrentValue("OPP_ADDR4"));
							inputDs.setCurrentValue("PAYEE_ADDR6", resultDs.getCurrentValue("OPP_ADDR5"));
							inputDs.setCurrentValue("PAYEE_ADDR7", resultDs.getCurrentValue("OPP_ADDR6"));
							inputDs.setCurrentValue("PAYEE_BRNO", resultDs.getCurrentValue("OPP_BRNO"));
							inputDs.setCurrentValue("PAYEE_BRNAME", resultDs.getCurrentValue("OPP_BRNAME"));
							inputDs.setCurrentValue("PAYEE_ACCT_BRNO", resultDs.getCurrentValue("OPP_ACCT_BRNO"));
							inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", resultDs.getCurrentValue("OPP_ACCT_BRNAME"));
							inputDs.setCurrentValue("PAYEE_ST_BRNO", resultDs.getCurrentValue("OPP_ST_BRNO"));
							inputDs.setCurrentValue("PAYEE_ST_BRNAME", resultDs.getCurrentValue("OPP_ST_BRNAME"));
							
							
							
							
							
							
							
							
							
							
							System.out.println("CIPS_111_V2_AUTH " + resultDs.getCurrentValue("CIPS_111_V2_AUTH"));
							if ("1".equals(resultDs.getCurrentValue("CIPS_111_V2_AUTH"))) {
								onChangePayeeStBrno(true);
								System.out.println("true");
							} else {
								onChangePayeeStBrno(false);
								System.out.println("false");
							}
	
							
							inputDs.sync();
							resultDs.removeAllData();
							resultDs.sync();
							
							
						} else if (status && callback.getCallbackCount() == 0) {
							/*
							inputDs.setCurrentValue("PAYEE_NAME", "");
							inputDs.setCurrentValue("PAYEE_ADDR", "");
							inputDs.setCurrentValue("PAYEE_BRNO", "");
							inputDs.setCurrentValue("PAYEE_BRNAME", "");
							inputDs.setCurrentValue("PAYEE_ACCT_BRNO", "");
							inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", "");
							inputDs.setCurrentValue("PAYEE_ST_BRNO", "");
							inputDs.setCurrentValue("PAYEE_ST_BRNAME", "");
							
							inputDs.setCurrentValue("PAYEE_ADDR1", "");
							inputDs.setCurrentValue("PAYEE_ADDR2", "");
							inputDs.setCurrentValue("PAYEE_ADDR3", "");
							inputDs.setCurrentValue("PAYEE_ADDR4", "");
							inputDs.setCurrentValue("PAYEE_ADDR5", "");
							inputDs.setCurrentValue("PAYEE_ADDR6", "");
							inputDs.setCurrentValue("PAYEE_ADDR7", "");
							*/

							// inputDs.setCurrentValue("CNAPS_FLAG",
							// resultDs.getCurrentValue("CNAPS_FLAG"));
							inputDs.sync();
							resultDs.removeAllData();
							resultDs.sync();
						}
					}
				});

			}

		};
		frmSKXX_PAYEE_ACTNO.addValueChangedListener(frmSKXX_PAYEE_ACTNO_Listener);

		frmJYXX_CHARGE_BEARER_Listener = new ValueChangedListener("CHARGE_BEARER") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {

				/* 默认设置 */
				frmJYXX.setReadOnly("FEE1_AMT", false);
				frmJYXX.setReadOnly("FEE1_BRNO", false);
				frmJYXX.setReadOnly("FEE2_AMT", false);
				frmJYXX.setReadOnly("FEE2_BRNO", false);
				frmJYXX_FEE1_AMT.setRequired(false);
//				frmJYXX_FEE1_BRNO.setRequired(false);

				String newVal = (String) event.getNewValue();
				if ("DEBT".equals(newVal)) {
					inputDs.setCurrentValue("FEE1_AMT", "");
					inputDs.setCurrentValue("FEE1_BRNO", "");
					inputDs.setCurrentValue("FEE1_BRNAME", "");
					inputDs.setCurrentValue("FEE2_AMT", "");
					inputDs.setCurrentValue("FEE2_BRNO", "");
					inputDs.setCurrentValue("FEE2_BRNAME", "");
					inputDs.sync();

					frmJYXX.setReadOnly("FEE1_AMT", true);
					frmJYXX.setReadOnly("FEE1_BRNO", true);
					frmJYXX.setReadOnly("FEE2_AMT", true);
					frmJYXX.setReadOnly("FEE2_BRNO", true);

				} else if ("CRED".equals(newVal)) {
					frmJYXX_FEE1_AMT.setRequired(true);
//					frmJYXX_FEE1_BRNO.setRequired(true);
				} else {
				}

			}
		};
		frmJYXX_CHARGE_BEARER.addValueChangedListener(frmJYXX_CHARGE_BEARER_Listener);

		/*frmJYXX_ORI_AMT_CURCD_Listener = new ValueChangedListener("ORI_AMT_CURCD") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {			
				String newVal = (String)event.getNewValue();
				if ("CNY".equals(newVal)||"".equals(newVal)||newVal==null) {
					frmJYXX_RATE.setRequired(false);
				} else {
					frmJYXX_RATE.setRequired(true);
				}

			}
		};
		frmJYXX_ORI_AMT_CURCD.addValueChangedListener(frmJYXX_ORI_AMT_CURCD_Listener);*/

		frmFKXX_PAYER_ACTNO_Listener = new ValueChangedListener("PAYER_ACTNO") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				if (CIPSCommon.isDataNull(inputDs, "PAYER_ACTNO")) {
					return;
				}
				inputDs.setCurrentValue("PAYER_ACTNO", inputDs.getCurrentValue("PAYER_ACTNO").trim());

				inputDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));
				inputDs.setCurrentValue("SYS_CODE", "CIPS");

				String fieldNames[] = new String[2];
				fieldNames[0] = "ACTNO";
				fieldNames[1] = "SYS_CODE";

				 Map<String, String> extra = Query_Cmd.getExtraInfo();
//				Query_Cmd.clearExtraInfo();
				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
				Query_Cmd.setQuerySqlid("GPAY_ACCT_CUST_INFO");
				Query_Cmd.setQueryCondition(inputDs, fieldNames);
				Query_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback, String commandItemName) {
						if (status) {
							if (callback.getCallbackCount() == 1) {
								inputDs.setCurrentValue("PAYER_NAME", resultDs.getCurrentValue("CN_NAME"));
								inputDs.setCurrentValue("PAYER_ADDR1", resultDs.getCurrentValue("ADDR"));
								inputDs.setCurrentValue("PAYER_ACCT_BRNO", resultDs.getCurrentValue("BRNO"));
								inputDs.setCurrentValue("PAYER_ACCT_BRNAME", resultDs.getCurrentValue("BRNAME"));
								inputDs.setCurrentValue("CUST_ID", resultDs.getCurrentValue("CUST_ID"));
							} else {

//								inputDs.setCurrentValue("PAYER_ACCT_BRNO", ContextHelper.getContext().getValue("CIPS_BRNO"));
//								inputDs.setCurrentValue("PAYER_ACCT_BRNAME", ContextHelper.getContext().getValue("CIPS_BRNAME"));
								UPrompt.alert("提示", "账号不存在");
							}
							inputDs.sync();
						} else {
							UPrompt.alert("提示", "查询失败");
						}
					}
				});

				if (paymentPlatformMode.equals("0")) {
					return;
				}

				String AMT = inputDs.getCurrentValue("AMT");
				if (!(AMT == null || AMT.equals("") || AMT.equals("null"))) {
					if (AMT.equals("0") || AMT.equals("0.00")) {
						inputDs.setCurrentValue("CHARGE_AMT", "0.00");
						inputDs.sync();
						return;
					}

					feeDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));
					feeDs.setCurrentValue("CUST_ID", inputDs.getCurrentValue("CUST_ID"));
					feeDs.setCurrentValue("AMT", inputDs.getCurrentValue("AMT"));
					feeDs.setCurrentValue("SYS_CODE", "CIPS");

					FEE_AMT_Cmd.setHead("SRV_ID", "GPAY_GETTXNFEE");
					FEE_AMT_Cmd.execute(new CommandCallback() {
						@Override
						public void onCallback(boolean status, Callback callback, String commandItemName) {

							if (status) {
								inputDs.setCurrentValue("CHARGE_AMT", resultDs.getCurrentValue("CHARGE_AMT"));
								inputDs.sync();
							} else {
								SC.say("提交失败,错误信息" + callback.getErrorMessage());
							}
						}
					});
				}
			}
		};
		frmFKXX_PAYER_ACTNO.addValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);

		frmJYXX_AMT_Listener = new ValueChangedListener("AMT") {
			@Override
			public void onValueChange(String fieldName, ValueChangeEvent event) {
				if (paymentPlatformMode.equals("0")) {
					return;
				}

				System.out.println("+++new value = [" + event.getNewValue() + "] ++++++ old value = [" + event.getOldValue() + "] +++");

				String AMT = (String) event.getNewValue();
				System.out.println("AMT = [" + AMT + "]");
				if (AMT == null || AMT.equals("") || AMT.equals("null")) {
					inputDs.setCurrentValue("CHARGE_AMT", "0.00");
					inputDs.sync();
					return;
				}

				if (!event.getOldValue().equals(event.getNewValue())) {
					if (AMT.equals("0") || AMT.equals("0.00")) {
						inputDs.setCurrentValue("CHARGE_AMT", "0.00");
						inputDs.sync();
						return;
					}

					feeDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));
					feeDs.setCurrentValue("CUST_ID", inputDs.getCurrentValue("CUST_ID"));
					feeDs.setCurrentValue("AMT", event.getNewValue());
					feeDs.setCurrentValue("SYS_CODE", "CIPS");

					FEE_AMT_Cmd.setHead("SRV_ID", "GPAY_GETTXNFEE");

					FEE_AMT_Cmd.execute(new CommandCallback() {
						@Override
						public void onCallback(boolean status, Callback callback, String commandItemName) {
							if (status) {
								inputDs.setCurrentValue("CHARGE_AMT", resultDs.getCurrentValue("CHARGE_AMT"));
								inputDs.sync();
							} else {
								SC.say("提交失败,错误信息" + callback.getErrorMessage());
							}
						}
					});
				}

			}
		};
		frmJYXX_AMT.addValueChangedListener(frmJYXX_AMT_Listener);

		BTN_ADD_Listener = new ClickListener() {

			@Override
			public void onClick(ClickEvent event) {

				if (CIPSCommon.isDataNull(detailDs, "INS_INFORMATION")) {
					UPrompt.alert("提示信息", "请输入附言内容");
					return;
				}

				if (detailDs.getCurrentValue("INS_INFORMATION").length() > 140) {
					UPrompt.alert("提示信息", "附言内容超过最大长度140");
					return;
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("INS_INFORMATION", detailDs.getCurrentValue("INS_INFORMATION"));

				inputDs2.addDataRecord(new DataRecord(map), new DataAction() {

					@Override
					public void doAction(DataRecord record) {
						System.out.println("insert empty record: " + record.getDataMap());
						detailDs.setCurrentValue("INS_INFORMATION", "");
						detailDs.sync();
					}
				});

				inputDs2.sync();

			}
		};
		this.BTN_ADD.addClickListener(BTN_ADD_Listener);

		BTN_DEL_Listener = new ClickListener() {

			@Override
			public void onClick(ClickEvent event) {
				inputDs2.removeCurrentRecord();
				inputDs2.sync();
			}
		};
		this.BTN_DEL.addClickListener(BTN_DEL_Listener);

		BTN_OK_Listener = new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {

				try {
					CIPSCommon.validateForm(frmFKXX, "付款信息检查不通过！");
					CIPSCommon.validateForm(frmSKXX, "收款信息检查不通过！");
					CIPSCommon.validateForm(frmJYXX, "交易信息检查不通过！");
					if ("0.00".equals(inputDs.getCurrentValue("AMT"))) {
						UPrompt.alert("提示信息", "汇款金额不能为0.00元！");
						return;
					}
				} catch (Exception e) {
					return;
				}

				String payerAcctOrgType = inputDs.getCurrentValue("PAYER_ACCT_ORG_TYPE");
				if (sSupportV2 == false || "BANK".equals(payerAcctOrgType)) {
					// （8）	付款人开户行行号和付款人开户行名称两者至少需要填写一项，收款人开户行行号和收款人开户行名称两者至少需要填写一项。
					if (CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNO") && CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNAME")) {
						UPrompt.alert("提示信息", "[付款人开户行行号] 与 [付款人开户行名称] 两者至少需要填写一项; 如果对应行号有BIC，建议收/付款人开户行行号填写BIC；如果没有BIC，建议填写收/付款人开户行名称");
						return;
					}
				} else if ("NBNK".equals(payerAcctOrgType)) {
					// 付款人开户机构如果为非银行金融机构，则付款非银行支付机构账号必填，
					// 付款非银行支付机构名称和付款非银行支付机构地址两者至少需要填写一项
					if (CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNAME") && CIPSCommon.isDataNull(inputDs, "PAYER_BR_ADDR1")) {
						UPrompt.alert("提示信息", "[付款非银行支付机构名称] 与 [付款非银行支付机构地址] 两者至少需要填写一项");
						return;
					}
				} else {
					UPrompt.alert("提示信息", "付款人开户机构类型非法");
					return;
				}

				String payeeAcctOrgType = inputDs.getCurrentValue("PAYEE_ACCT_ORG_TYPE");
				if (sSupportV2 == false || "BANK".equals(payeeAcctOrgType)) {
					// （8）	收款人开户行行号和收款人开户行名称两者至少需要填写一项，收款人开户行行号和收款人开户行名称两者至少需要填写一项。
					if (CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNO") && CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNAME")) {
						UPrompt.alert("提示信息", "[收款人开户行行号] 与 [收款人开户行名称] 两者至少需要填写一项; 如果对应行号有BIC，建议收/付款人开户行行号填写BIC；如果没有BIC，建议填写收/付款人开户行名称");
						return;
					}
				} else if ("NBNK".equals(payeeAcctOrgType)) {
					// 收款人开户机构如果为非银行金融机构，则收款非银行支付机构账号必填，
					// 收款非银行支付机构名称和收款非银行支付机构地址两者至少需要填写一项
					if (CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNAME") && CIPSCommon.isDataNull(inputDs, "PAYEE_BR_ADDR1")) {
						UPrompt.alert("提示信息", "[收款非银行支付机构名称] 与 [收款非银行支付机构地址] 两者至少需要填写一项");
						return;
					}
				} else {
					UPrompt.alert("提示信息", "收款人开户机构类型非法");
					return;
				}

				//（9）	付款人名称和付款人地址两者至少需要填写一项，收款人名称和收款人地址两者至少需要填写一项。
				if (CIPSCommon.isDataNull(inputDs, "PAYER_NAME") && CIPSCommon.isDataNull(inputDs, "PAYER_ADDR1")
						&& CIPSCommon.isDataNull(inputDs, "PAYER_ADDR2") && CIPSCommon.isDataNull(inputDs, "PAYER_ADDR3")
						&& CIPSCommon.isDataNull(inputDs, "PAYER_ADDR4") && CIPSCommon.isDataNull(inputDs, "PAYER_ADDR5")
						&& CIPSCommon.isDataNull(inputDs, "PAYER_ADDR6") && CIPSCommon.isDataNull(inputDs, "PAYER_ADDR7")) {
					UPrompt.alert("提示信息", "[付款人名称] 与 [付款人地址] 两者至少需要填写一项");
					return;
				}

				if (CIPSCommon.isDataNull(inputDs, "PAYEE_NAME") && CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR1")
						&& CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR2") && CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR3")
						&& CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR4") && CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR5")
						&& CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR6") && CIPSCommon.isDataNull(inputDs, "PAYEE_ADDR7")) {
					UPrompt.alert("提示信息", "[收款人名称] 与 [收款人地址] 两者至少需要填写一项");
					return;
				}
				//原始币种、金额 必须同时填写
				if ((CIPSCommon.isAmtNull(inputDs, "ORI_AMT_CURCD") && !CIPSCommon.isDataNull(inputDs, "ORI_AMT"))
						|| (!CIPSCommon.isAmtNull(inputDs, "ORI_AMT_CURCD") && CIPSCommon.isDataNull(inputDs, "ORI_AMT"))) {
					UPrompt.alert("提示信息", "[原始币种] 与 [原始金额] 必须同时填写");
					return;
				}

				// 费用 & 付费行 必须同时填写
				if ((CIPSCommon.isAmtNull(inputDs, "FEE1_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))
						|| (!CIPSCommon.isAmtNull(inputDs, "FEE1_AMT") && CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))) {
					UPrompt.alert("提示信息", "[费用1] 与 [付费行1] 必须同时填写");
					return;
				}

				if ((CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))
						|| (!CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))) {
					UPrompt.alert("提示信息", "[费用2] 与 [付费行2] 必须同时填写");
					return;
				}

				executeBtnOkCmd();

			}
		};
		this.BTN_OK.addClickListener(BTN_OK_Listener);
		this.BTN_CLOSE.addClickListener(new ClickListener() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
			}
		});
	}

	@Override
	public void onReferencePageGetData(ReferencePageGetDataEvent event) {
		System.out.println("===reference page get data===");
		System.out.println(event.getSource());
		System.out.println(event.getCallbackData());

		Map<String, Object> map = event.getCallbackData();
		String BRNO = "", BRNAME = "", ST_BRNO = "", ST_BRNAME = "";

		if (map.get("BRNO") != null) {
			BRNO = (String) map.get("BRNO");
		}
		if (map.get("BRNAME") != null) {
			BRNAME = (String) map.get("BRNAME");
		}

		if (map.get("ST_BRNO") != null) {
			ST_BRNO = (String) map.get("ST_BRNO");
		}
		if (map.get("ST_BRNAME") != null) {
			ST_BRNAME = (String) map.get("ST_BRNAME");
		}

		String source = event.getSource();
		if (source.equals("PAYER_BRNO") || source.equals("PAYER_ST_BRNO")) {

			if (!ST_BRNO.equals(ContextHelper.getContext().getValue("CIPS_ST_BRNO"))) {
				UPrompt.alert("提示", "非本清算行下的行号，请重新输入");
				return;
			}
			inputDs.setCurrentValue("PAYER_ST_BRNO", ST_BRNO);
			inputDs.setCurrentValue("PAYER_ST_BRNAME", ST_BRNAME);
			if (BRNO.equals(ST_BRNO)) {
				inputDs.setCurrentValue("PAYER_BRNO", "");
				inputDs.setCurrentValue("PAYER_BRNAME", "");
			} else {
				inputDs.setCurrentValue("PAYER_BRNO", BRNO);
				inputDs.setCurrentValue("PAYER_BRNAME", BRNAME);
			}
		} else if (source.equals("PAYEE_BRNO") || source.equals("PAYEE_ST_BRNO")) {
			inputDs.setCurrentValue("PAYEE_ST_BRNO", ST_BRNO);
			inputDs.setCurrentValue("PAYEE_ST_BRNAME", ST_BRNAME);
			if (BRNO.equals(ST_BRNO)) {
				inputDs.setCurrentValue("PAYEE_BRNO", "");
				inputDs.setCurrentValue("PAYEE_BRNAME", "");
			} else {
				inputDs.setCurrentValue("PAYEE_BRNO", BRNO);
				inputDs.setCurrentValue("PAYEE_BRNAME", BRNAME);
			}
		} else if (source.equals("FEE1_BRNO")) {
			inputDs.setCurrentValue("FEE1_BRNO", BRNO);
			inputDs.setCurrentValue("FEE1_BRNAME", BRNAME);
		} else if (source.equals("FEE2_BRNO")) {
			inputDs.setCurrentValue("FEE2_BRNO", BRNO);
			inputDs.setCurrentValue("FEE2_BRNAME", BRNAME);
		} else if (source.equals("IM1_BANK")) {
			inputDs.setCurrentValue("IM1_BANK", BRNO);
			inputDs.setCurrentValue("IM1_NAME", BRNAME);
		} else if (source.equals("IM2_BANK")) {
			inputDs.setCurrentValue("IM2_BANK", BRNO);
			inputDs.setCurrentValue("IM2_NAME", BRNAME);
		}

		inputDs.sync();

		//2.0
		if ("1".equals((String) map.get("CIPS_111_V2_AUTH"))) {
			onChangePayeeStBrno(true);
			System.out.println("true");
		} else {
			onChangePayeeStBrno(false);
			System.out.println("false");
		}
		//2.0End

	}
}
