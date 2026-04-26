package com.gingkoo.cips.client.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartgwt.client.util.SC;

import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.core.client.utils.DateUtils;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.event.ValueChangeEvent;
import com.gingkoo.gui.data.client.dataset.event.ValueChangedListener;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;

public class Page0511101Impl extends Page0511101Cust {

    private static final long serialVersionUID = 1L;
    private static String confirmFlag = "0";
    //protected ValueChangedListener frmFKXX_CUST_ACTNO_Listener;
    protected ValueChangedListener frmFKXX_NAME_SELECTED_Listener;
    protected ClickListener ClickListener;
    private static String opType = "";
    
    protected void cnmsAlert(String info,final String seqNo){
    	opType = "";
    	final UWindow promptWindow = new UWindow();
    	UButton btn1 = new UButton();
		btn1.setTitle("重试");
		UButton btn2 = new UButton();
		btn2.setTitle("暂存交易");
		UButton btn3 = new UButton();
		btn3.setTitle("取消");
    	CIPSCommon.AlertBox(promptWindow,info,btn1,btn2,btn3);
		
		btn1.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				opType = "RETRY";
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				executeBtnOkCmd();
				promptWindow.close();
			}
		});
		btn2.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				// 交易暂存提交
				confirmFlag = "3";
				opType = "SAVE";
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				executeBtnOkCmd();
				promptWindow.close();
			}
		});
		btn3.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				opType = "";
				confirmFlag = "0";
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				promptWindow.close();
			}
		});
    }
    
    protected void confirm(String info,final String seqNo){
    	opType = "";
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
				opType = "CNCL";
				BTN_SUB_CNCL_Cmd.setHead("SRV_ID", "ANZ_MADE_CNCL");
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				BTN_SUB_CNCL_Cmd.execute(new CommandCallback() {
					
					@Override
					public void onCallback(boolean status, Callback callback,
							String commandItemName) {
						// TODO Auto-generated method stub
//						if (status){
//							SC.say("交易录入取消！");
//							beforeRender();
//							inputDs2.removeAllData();
//							inputDs2.sync();
//						} else {
//							SC.say("交易录入取消失败,错误信息" + callback.getErrorMessage());
//						}
					}
				});
				promptWindow.close();
			}
		});	
    }
    
    @Override
    protected void executeBtnOkCmd() {
		inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
		inputDs.setCurrentValue("OP_TYPE", opType);
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
					String blockStatus = data.get("CNMS_BLOCK_STATUS").toString();
					if ("ON".equals(blockStatus)) {
						SC.say("提交成功，流水号为[" + TXN_SEQ_NO + "]<br>远程黑名单系统已关闭，需要进行人工校验");
					} else {
						SC.say("提交成功，流水号为[" + TXN_SEQ_NO + "]");
					}
					
					beforeRender();
					inputDs2.removeAllData();
					inputDs2.sync();
				} else {
					System.out.println("===ErrorCode===:"+ callback.getErrorCode());
                    System.out.println("===ErrorMessage===:"+ callback.getErrorMessage());
                    
					final String errMsg = callback.getErrorMessage();
					// 交易重账
					//此处errMsg内容为：059006:交易疑似重账+扫描流水号
					if (errMsg != null && errMsg.length() > 6 && "059006".equals(errMsg.substring(0, 6))) {
						UPrompt.confirm("提示", "该业务有风险: 交易疑似重账,是否仍要提交?", new PromptCallback() {
							@Override
							public void execute(Boolean value) {
								if (value != null && value) {
									// 重账继续提交
									confirmFlag = "1";
									inputDs.setCurrentValue("CNMS_SEQ_NO", errMsg.substring(errMsg.length()-20));
									executeBtnOkCmd();
								} else {
									confirmFlag = "0";
									opType = "";
									inputDs.setCurrentValue("CNMS_SEQ_NO", errMsg.substring(errMsg.length()-20));
								}
							}
						});
					} else if (errMsg != null && errMsg.length() > 6 && "ANZ005".equals(errMsg.substring(0, 6))) {
						confirm(errMsg.substring(7, errMsg.length()-20),errMsg.substring(errMsg.length()-20));
						//此处errMsg内容为：errcode+黑名单信息+扫描流水号
					} else if (errMsg != null && errMsg.length() > 6 && "ANZ006".equals(errMsg.substring(0, 6))) {
						//此处errMsg内容为：ANZ006:CNMS应答超时+扫描流水号
						cnmsAlert("黑名单扫描应答超时，是否重试？",errMsg.substring(errMsg.length()-20));
					} else {
						SC.say("提交失败,错误信息" + callback.getErrorMessage());
					}

				}
			}
		});
	}

    @Override
    protected void beforeRender() {
    	confirmFlag = "0";
    	opType = "";

    	super.beforeRender();
    }
    
    // 客户话可通过override该方法对inputDs设置默认值
//    @Override
//    protected void defaultSetForInputDs(HashMap<String, Object> map) {
//    	map.put("PAYER_ACCT_BRNAME", "");
//    	map.put("INTR_DATE", DateUtils.parseDate(ContextHelper.getContext().getValue("WORK_DATE")));
//    	map.put("C_BOP_FLAG", "N");
//    	map.put("C_RCFE_FLAG", "N");
//    	//2.0
//		map.put("PAYER_TYPE", "ORG");
//		map.put("PAYEE_TYPE", "ORG");
//
//		map.put("PAYER_ACCT_ORG_TYPE", "BANK");
//		map.put("PAYEE_ACCT_ORG_TYPE", "BANK");
//
//		onChangePayerType("ORG");
//		onChangePayeeType("ORG");
//		onChangePayerAcctOrgType("BANK");
//		onChangePayeeAcctOrgType("BANK");
//    }
    
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
    protected void bindEvent() {
    	super.bindEvent();
//    	frmFKXX_PAYER_ACTNO.removeValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);
//    	frmFKXX_PAYER_ACTNO_Listener = new ValueChangedListener("PAYER_ACTNO") {
//			@Override
//			public void onValueChange(String fieldName, ValueChangeEvent event)
//			{
//				inputDs.setCurrentValue("PAYER_ACTNO", inputDs.getCurrentValue("PAYER_ACTNO").trim());
//				inputDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));
//				inputDs.setCurrentValue("SYS_CODE", "CIPS");
//
//				String fieldNames[] = new String[2];
//				fieldNames[0] = "ACTNO";
//				fieldNames[1] = "SYS_CODE";
//
//				Query_Cmd.clearExtraInfo();
//				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
//				Query_Cmd.setQuerySqlid("GPAY_ACCT_CUST_INFO");
//				Query_Cmd.setQueryCondition(inputDs, fieldNames);
//				Query_Cmd.execute(new CommandCallback() {
//					@Override
//					public void onCallback(boolean status, Callback callback, String commandItemName) {
//						if (status) {
//							if (callback.getCallbackCount() == 1) {
//								inputDs.setCurrentValue("PAYER_NAME", resultDs.getCurrentValue("EN_NAME"));
//								inputDs.setCurrentValue("PAYER_ADDR1", resultDs.getCurrentValue("ADDR"));
//								inputDs.setCurrentValue("PAYER_ACCT_BRNO", resultDs.getCurrentValue("BRNO"));
//								inputDs.setCurrentValue("PAYER_ACCT_BRNAME", resultDs.getCurrentValue("BRNAME"));
//								inputDs.setCurrentValue("CUST_ID", resultDs.getCurrentValue("CUST_ID"));
//								inputDs.setCurrentValue("C_NRA_FLAG", resultDs.getCurrentValue("C_NRA_FLAG"));
//							}
////							else {
////
//////								inputDs.setCurrentValue("PAYER_ACCT_BRNO", ContextHelper.getContext().getValue("CIPS_BRNO"));
//////								inputDs.setCurrentValue("PAYER_ACCT_BRNAME", ContextHelper.getContext().getValue("CIPS_BRNAME"));
////								UPrompt.alert("提示", "账号不存在");
////							}
//							inputDs.sync();
//						}
////						else {
////							UPrompt.alert("提示", "查询失败");
////						}
//					}
//				});
//			}
//		};
//		frmFKXX_PAYER_ACTNO.addValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);
//
//    	frmJYXX_AMT.removeValueChangedListener(frmJYXX_AMT_Listener);
//    	frmJYXX_AMT_Listener = new ValueChangedListener("AMT") {
//    		String paymentPlatformMode = ContextHelper.getContext().getValue("PAYMENT_PLATFORM_MODE");
//			@Override
//			public void onValueChange(String fieldName, ValueChangeEvent event)
//			{
//
//				if(paymentPlatformMode.equals("0")) {
//					return;
//				}
//
////				String accountType = inputDs.getCurrentValue("ACCOUNT_TYPE");
////				if ("0".equals(accountType)){
////					inputDs.setCurrentValue("CHARGE_AMT", "0.00");
////					inputDs.sync();
////					return;
////				}
//
//				System.out.println("+++new value = [" + event.getNewValue() + "] ++++++ old value = [" + event.getOldValue() + "] +++");
//
//				String AMT=(String) event.getNewValue();
//				System.out.println("AMT = [" + AMT + "]");
//				if(AMT==null||AMT.equals("")||AMT.equals("null")){
//					inputDs.setCurrentValue("CHARGE_AMT", "0.00");
//					inputDs.sync();
//					return;
//				}
//
//				if(!event.getOldValue().equals(event.getNewValue())){
//					if(AMT.equals("0") || AMT.equals("0.00")) {
//						inputDs.setCurrentValue("CHARGE_AMT", "0.00");
//						inputDs.sync();
//						return;
//					}
//
//					feeDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("PAYER_ACTNO"));
//					feeDs.setCurrentValue("CUST_ID", inputDs.getCurrentValue("CUST_ID"));
//					feeDs.setCurrentValue("AMT", event.getNewValue());
//					feeDs.setCurrentValue("SYS_CODE", "CIPS");
//
//					FEE_AMT_Cmd.setHead("SRV_ID", "ANZ_GETTXNFEE");
//
//	                FEE_AMT_Cmd.execute(new CommandCallback() {
//	                    @Override
//	                    public void onCallback(boolean status, Callback callback,String commandItemName) {
//	                    	if (status) {
//	                    		inputDs.setCurrentValue("CHARGE_AMT", resultDs.getCurrentValue("CHARGE_AMT"));
//	                        	inputDs.sync();
//	                        }
////	                    	else {
////	                            SC.say("提交失败,错误信息"+callback.getErrorMessage());
////	                        }
//	                    }
//	                });
//				}
//
//			}
//		};
//		frmJYXX_AMT.addValueChangedListener(frmJYXX_AMT_Listener);
		
//		BTN_OK.removeClickListener(BTN_OK_Listener);
		ClickListener = new ClickListener() {
			
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
//				if (sSupportV2 == false || "BANK".equals(payerAcctOrgType)) {
//					// （8）	付款人开户行行号和付款人开户行名称两者至少需要填写一项，收款人开户行行号和收款人开户行名称两者至少需要填写一项。
//					if (CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNO") && CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNAME")) {
//						UPrompt.alert("提示信息", "[付款人开户行行号] 与 [付款人开户行名称] 两者至少需要填写一项; 如果对应行号有BIC，建议收/付款人开户行行号填写BIC；如果没有BIC，建议填写收/付款人开户行名称");
//						return;
//					}
//				} else if ("NBNK".equals(payerAcctOrgType)) {
//					// 付款人开户机构如果为非银行金融机构，则付款非银行支付机构账号必填，
//					// 付款非银行支付机构名称和付款非银行支付机构地址两者至少需要填写一项
//					if (CIPSCommon.isDataNull(inputDs, "PAYER_ACCT_BRNAME") && CIPSCommon.isDataNull(inputDs, "PAYER_BR_ADDR1")) {
//						UPrompt.alert("提示信息", "[付款非银行支付机构名称] 与 [付款非银行支付机构地址] 两者至少需要填写一项");
//						return;
//					}
//				} else {
//					UPrompt.alert("提示信息", "付款人开户机构类型非法");
//					return;
//				}
//
//				String payeeAcctOrgType = inputDs.getCurrentValue("PAYEE_ACCT_ORG_TYPE");
//				if (sSupportV2 == false || "BANK".equals(payeeAcctOrgType)) {
//					// （8）	收款人开户行行号和收款人开户行名称两者至少需要填写一项，收款人开户行行号和收款人开户行名称两者至少需要填写一项。
//					if (CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNO") && CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNAME")) {
//						UPrompt.alert("提示信息", "[收款人开户行行号] 与 [收款人开户行名称] 两者至少需要填写一项; 如果对应行号有BIC，建议收/付款人开户行行号填写BIC；如果没有BIC，建议填写收/付款人开户行名称");
//						return;
//					}
//				} else if ("NBNK".equals(payeeAcctOrgType)) {
//					// 收款人开户机构如果为非银行金融机构，则收款非银行支付机构账号必填，
//					// 收款非银行支付机构名称和收款非银行支付机构地址两者至少需要填写一项
//					if (CIPSCommon.isDataNull(inputDs, "PAYEE_ACCT_BRNAME") && CIPSCommon.isDataNull(inputDs, "PAYEE_BR_ADDR1")) {
//						UPrompt.alert("提示信息", "[收款非银行支付机构名称] 与 [收款非银行支付机构地址] 两者至少需要填写一项");
//						return;
//					}
//				} else {
//					UPrompt.alert("提示信息", "收款人开户机构类型非法");
//					return;
//				}

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

				// modify by luoxin 20201212 费用承担方选”CRED-BEN”的时候，费用1、付费行号1均设为必填项，且费用1参数设置为>=0
				if ((CIPSCommon.isAmtNullZeroExcluded(inputDs, "FEE1_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))
						|| (!CIPSCommon.isAmtNullZeroExcluded(inputDs, "FEE1_AMT") && CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))) {
					UPrompt.alert("提示信息", "[费用1] 与 [付费行1] 必须同时填写");
					return;
				}
				// 费用 & 付费行 必须同时填写
//				if ((CIPSCommon.isAmtNull(inputDs, "FEE1_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))
//						|| (!CIPSCommon.isAmtNull(inputDs, "FEE1_AMT") && CIPSCommon.isDataNull(inputDs, "FEE1_BRNO"))) {
//					UPrompt.alert("提示信息", "[费用1] 与 [付费行1] 必须同时填写");
//					return;
//				}
				
				
				if ((CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))
						|| (!CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))) {
					UPrompt.alert("提示信息", "[费用2] 与 [付费行2] 必须同时填写");
					return;
				}

				executeBtnOkCmd();
			}
		};
		this.BTN_OK.addClickListener(ClickListener);
		
//		frmJYXX_CHARGE_BEARER.removeValueChangedListener(frmJYXX_CHARGE_BEARER_Listener);
//		frmJYXX_CHARGE_BEARER_Listener = new ValueChangedListener("CHARGE_BEARER") {
//
//			@Override
//			public void onValueChange(String fieldName, ValueChangeEvent event) {
//				// TODO Auto-generated method stub
//				/* 默认设置 */
//				frmJYXX.setReadOnly("FEE1_AMT", false);
//				frmJYXX.setReadOnly("FEE1_BRNO", false);
//				frmJYXX.setReadOnly("FEE2_AMT", false);
//				frmJYXX.setReadOnly("FEE2_BRNO", false);
//				frmJYXX_FEE1_AMT.setRequired(false);
//				frmJYXX_FEE1_BRNO.setRequired(false);
//
//				String newVal = (String) event.getNewValue();
//				if ("DEBT".equals(newVal)) {
//					inputDs.setCurrentValue("FEE1_AMT", "");
//					inputDs.setCurrentValue("FEE1_BRNO", "");
//					inputDs.setCurrentValue("FEE1_BRNAME", "");
//					inputDs.setCurrentValue("FEE2_AMT", "");
//					inputDs.setCurrentValue("FEE2_BRNO", "");
//					inputDs.setCurrentValue("FEE2_BRNAME", "");
//					inputDs.sync();
//
//					frmJYXX.setReadOnly("FEE1_AMT", true);
//					frmJYXX.setReadOnly("FEE1_BRNO", true);
//					frmJYXX.setReadOnly("FEE2_AMT", true);
//					frmJYXX.setReadOnly("FEE2_BRNO", true);
//
//				} else if ("CRED".equals(newVal)) {
//					frmJYXX_FEE1_AMT.setRequired(true);
//					frmJYXX_FEE1_BRNO.setRequired(true);
//				} else {
//				}
//			}
//		};
//		frmJYXX_CHARGE_BEARER.addValueChangedListener(frmJYXX_CHARGE_BEARER_Listener);
	
//    	frmFKXX_CUST_ACTNO_Listener = new ValueChangedListener("CUST_ACTNO") {
//			@Override
//			public void onValueChange(String fieldName, ValueChangeEvent event) 
//			{
//				inputDs.setCurrentValue("CUST_ACTNO", inputDs.getCurrentValue("CUST_ACTNO").trim());
//				inputDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("CUST_ACTNO"));
//				inputDs.setCurrentValue("SYS_CODE", "CIPS");
//
//				inputDs.sync();
//				
//				String fieldNames[] = new String[2];
//				fieldNames[0] = "ACTNO";
//				fieldNames[1] = "SYS_CODE";
//				
//				Query_Cmd.clearExtraInfo();
//				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
//				Query_Cmd.setQuerySqlid("GPAY_ACCT_CUST_INFO");
//				Query_Cmd.setQueryCondition(inputDs, fieldNames);
//				Query_Cmd.execute(new CommandCallback() {
//					@Override
//					public void onCallback(boolean status, Callback callback, String commandItemName) {
//						if (status) {
//							if (callback.getCallbackCount() == 1) {
//								if (!CIPSCommon.isDataNull(resultDs, "CN_NAME")) {
//									inputDs.setCurrentValue("CUST_NAME", resultDs.getCurrentValue("CN_NAME"));
//								} else {
//									inputDs.setCurrentValue("CUST_NAME", resultDs.getCurrentValue("EN_NAME"));
//								}
////								resultDs.removeAllData();
//								resultDs.sync();
//							} else {
//								UPrompt.alert("提示", "记账账号不存在");
//							}
//							inputDs.sync();
//							
//							String paymentPlatformMode = ContextHelper.getContext().getValue("PAYMENT_PLATFORM_MODE"); 
//							if(paymentPlatformMode.equals("0")) {
//								return;
//							}
//							
////							String accountType = inputDs.getCurrentValue("ACCOUNT_TYPE");
////							if ("0".equals(accountType)){
////								inputDs.setCurrentValue("CHARGE_AMT", "0.00");
////								inputDs.sync();
////								return;
////							}
//							
//							String AMT=inputDs.getCurrentValue("AMT");
//							if(!(AMT==null||AMT.equals("")||AMT.equals("null"))){
//								if(AMT.equals("0") || AMT.equals("0.00")) {
//									inputDs.setCurrentValue("CHARGE_AMT", "0.00");
//									inputDs.sync();
//									return;
//								}
//								
//								feeDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("CUST_ACTNO"));
//								feeDs.setCurrentValue("CUST_ID", inputDs.getCurrentValue("CUST_ID"));
//								feeDs.setCurrentValue("AMT", inputDs.getCurrentValue("AMT"));
//								feeDs.setCurrentValue("SYS_CODE", "CIPS");
//								
//								FEE_AMT_Cmd.setHead("SRV_ID", "ANZ_GETTXNFEE");
//				                FEE_AMT_Cmd.execute(new CommandCallback() {
//				                    @Override
//				                    public void onCallback(boolean status, Callback callback,String commandItemName) {
//				                    	
//				                        if (status) {
//				                        	inputDs.setCurrentValue("CHARGE_AMT", resultDs.getCurrentValue("CHARGE_AMT"));
//				                        	inputDs.sync();
//				                        } else {
//				                            SC.say("提交失败,错误信息"+callback.getErrorMessage());
//				                        }
//				                    }
//				                });
//							}
//						} else {
//							UPrompt.alert("提示", "查询失败");
//						}
//					}
//				});
//				
//				
//			}
//		};
//		frmFKXX_CUST_ACTNO.addValueChangedListener(frmFKXX_CUST_ACTNO_Listener);
		
//		frmFKXX_PAYER_ACTNO.removeValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);
//        frmFKXX_PAYER_ACTNO_Listener = new ValueChangedListener("PAYER_ACTNO") {
//            @Override
//            public void onValueChange(String fieldName, ValueChangeEvent event) 
//            {
//                inputDs.setCurrentValue("ACTNO", event.getNewValue());
//                inputDs.setCurrentValue("SYS_CODE", "CIPS");
//
//                inputDs.sync();
//                
//                String fieldNames[] = new String[2];
//                fieldNames[0] = "ACTNO";
//                fieldNames[1] = "SYS_CODE";
//                
//                Query_Cmd.clearExtraInfo();
//                Query_Cmd.setHead("SRV_ID", "GPAY_9999");
//                Query_Cmd.setQuerySqlid("GPAY_ACCT_CUST_INFO");
//                Query_Cmd.setQueryCondition(inputDs, fieldNames);
//                Query_Cmd.execute(new CommandCallback() {
//                    @Override
//                    public void onCallback(boolean status, Callback callback, String commandItemName) {
//                        if (status) {
//                            if (callback.getCallbackCount() == 1) {
//								if (!CIPSCommon.isDataNull(resultDs, "CN_NAME")) {
//	                                inputDs.setCurrentValue("NAME_SELECTED", "CN");
//	                                inputDs.setCurrentValue("PAYER_NAME", resultDs.getCurrentValue("CN_NAME"));
//								} else if (!CIPSCommon.isDataNull(resultDs, "EN_NAME")){
//	                                inputDs.setCurrentValue("NAME_SELECTED", "EN");
//	                                inputDs.setCurrentValue("PAYER_NAME", resultDs.getCurrentValue("EN_NAME"));
//								} else {
//	                                inputDs.setCurrentValue("NAME_SELECTED", "CN");
//								}
//                                inputDs.setCurrentValue("CN_NAME", resultDs.getCurrentValue("CN_NAME"));
//                                inputDs.setCurrentValue("EN_NAME", resultDs.getCurrentValue("EN_NAME"));
//                                inputDs.setCurrentValue("PAYER_ADDR1", resultDs.getCurrentValue("ADDR"));
//                                inputDs.setCurrentValue("PAYER_ACCT_BRNO", resultDs.getCurrentValue("BRNO"));
//                                inputDs.setCurrentValue("PAYER_ACCT_BRNAME", resultDs.getCurrentValue("BRNAME"));
//                                resultDs.removeAllData();
//                                resultDs.sync();
//                            } else {
//                                UPrompt.alert("提示", "账号不存在");
//                            }
//                            inputDs.sync();
//                        } else {
//                            UPrompt.alert("提示", "查询失败");
//                        }
//                    }
//                });
//            }
//        };
//        frmFKXX_PAYER_ACTNO.addValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);
    	
    }

}
//inputDs.setValue("SND_BRNO", "value1");
//inputDs.setValue("RCV_BRNO", "value1");
//resultDs.setValue("FEE_AMT", "value1");
//feeDs.setValue("PAYER_ACTNO", "value1");
//feeDs.setValue("AMT", "value1");
//feeDs.setValue("TYPE", "value1");
