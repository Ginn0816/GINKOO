package com.gingkoo.cips.client.view;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.event.ValueChangeEvent;
import com.gingkoo.gui.data.client.dataset.event.ValueChangedListener;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.events.ReferencePageGetDataEvent;
import com.gingkoo.gui.ui.component.client.form.UDynamicForm;
import com.gingkoo.gui.data.client.parser.xml.XMLParser;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.form.fields.UTextItem;
import com.gingkoo.gui.ui.component.client.form.fields.events.DoubleClickEvent;
import com.gingkoo.gui.ui.component.client.form.fields.events.DoubleClickListener;
import com.gingkoo.gui.ui.component.client.form.validator.CustValidator;
import com.gingkoo.gui.ui.component.client.upload.UploadListener;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.gingkoo.gui.ui.component.client.upload.UploadListener;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Positioning;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;

public class Page0511102Impl extends Page0511102Cust {

    private static final long serialVersionUID = 1L;
//    protected ValueChangedListener frmFKXX_CUST_ACTNO_Listener;
    protected ValueChangedListener frmFKXX_NAME_SELECTED_Listener;
    protected ValueChangedListener frmSKXX_PAYEE_ACTNO_Listener;
    private static String confirmFlag = "0";
	protected ClickListener ClickListener1;
	protected ClickListener BTN_MOD_OK_ClickListener;


    protected void executeBtnOkCmd() {
    	inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);
//        inputDs.setCurrentValue("RCV_BRNO", inputDs.getCurrentValue("PAYEE_ST_BRNO"));

    	String [] fields = new String [1];
        fields[0] = "INS_INFORMATION";
        inputDs.setXMLData("LIST", inputDs2, fields);
        
        
        HashMap<String, String> map = new HashMap<String, String>();
        BTN_MOD_OK_Cmd.setHead("SRV_ID", "CIPS_11102");
   	 	BTN_MOD_OK_Cmd.setHead("TXNO", "1353");
   	 	BTN_MOD_OK.setDisabled(true);
        BTN_MOD_OK_Cmd.execute(new CommandCallback() {
            @Override
            public void onCallback(boolean status, Callback callback,String commandItemName) {
                System.out.println("===返回值===:"+ callback.getCallbackData());
                System.out.println("===额外返回值===:"+ callback.getExtraData());

                BTN_MOD_OK.setDisabled(false);
                if (status) {
                	resultDs.setCurrentValue("CHK_FLAG", "&radic;");
                	System.out.println("===返回值===:"+ callback.getCallbackData());
                	List<Map> datas = (List<Map>) callback.getCallbackData();
					Map data = datas.get(0);
					String blockStatus = data.get("CNMS_BLOCK_STATUS").toString();
//                    SC.say("提交成功，流水号为[" + resultDs.getCurrentValue("TXN_SEQ_NO")  +"]  "+data.get("BIZ_REJ_INFO") );
                    if ("ON".equals(blockStatus)) {
						SC.say("提交成功，流水号为[" + resultDs.getCurrentValue("TXN_SEQ_NO")  +"]  "+data.get("BIZ_REJ_INFO") 
								+"<br>远程黑名单系统已关闭，需要进行人工校验");
					} else {
						SC.say("提交成功，流水号为[" + resultDs.getCurrentValue("TXN_SEQ_NO")  +"]  "+data.get("BIZ_REJ_INFO") );
					}
                    beforeRender();
                    resultTb.redraw();
					detailSw.hide();
                } else {
                	HashMap<String, String> result = (HashMap<String, String>)callback.getExtraData();

                	 System.out.println("===ErrorCode===:"+ callback.getErrorCode());
                     System.out.println("===ErrorMessage===:"+ callback.getErrorMessage());

                    final String errMsg = callback.getErrorMessage();
                    //此处errMsg内容为：059006:交易疑似重账+扫描流水号
                	if (errMsg != null && errMsg.length() > 6  && "059006".equals(errMsg.substring(0, 6))) {
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
								}
    						}
    					});
                	} else if (errMsg != null && errMsg.length() > 6  && "ANZ005".equals(errMsg.substring(0, 6))) {
                		//此处errMsg内容为：errcode+:+TAG_GSE_CTX_RSP_META_RSTR+扫描流水号
                		btnOkConfirm(errMsg.substring(7, errMsg.length()-20),errMsg.substring(errMsg.length()-20));
                	} else if (errMsg != null && errMsg.length() > 6 && "ANZ006".equals(errMsg.substring(0, 6))) {
                		UPrompt.confirm("提示", "黑名单扫描应答超时,是否重试?", new PromptCallback() {
							@Override
							public void execute(Boolean value) {
								if (value != null && value) {
									executeBtnOkCmd();
								}
							}
						});
					} else {
                		SC.say("提交失败,错误信息"+callback.getErrorMessage());
                	}
                }
            }
        });
    }

    protected void btnOkConfirm(String info,final String seqNo){
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
				BTN_SUB_CNCL_Cmd.setHead("SRV_ID", "ANZ_MADE_CNCL");
				inputDs.setCurrentValue("CNMS_SEQ_NO", seqNo);
				BTN_SUB_CNCL_Cmd.execute(new CommandCallback() {
					
					@Override
					public void onCallback(boolean status, Callback callback,
							String commandItemName) {
						// TODO Auto-generated method stub
//						if (status){
//							SC.say("交易修改取消！");
//							beforeRender();
//							resultTb.redraw();
//  							detailSw.hide();
//						} else {
//							SC.say("交易录入取消失败,错误信息" + callback.getErrorMessage());
//						}
					}
				});
				promptWindow.close();
			}
		});	
    }
    
    protected void btnCnclExecute(){
    	
    }
    
    @Override
    protected void beforeRender() {
    	confirmFlag = "0";

    	super.beforeRender();
    }
    
    @Override
    protected void bindEvent() {
    	super.bindEvent();
    	
    	
//    	BTN_CNCL_OK.removeClickListener(BTN_CNCL_OK_Listener);
    	ClickListener1 = new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
				HashMap<String, String> map = new HashMap<String, String>();
				// if(inputDs.getCurrentValue("BIZ_CNCL_INFO").equals("")||inputDs.getCurrentValue("BIZ_CNCL_INFO")==null){
				// UPrompt.alert("取消结果", "请输入取消原因！");
				// return;
				// }
				BTN_CNCL_OK_Cmd.setHead("SRV_ID", "CIPS_11105");
				BTN_CNCL_OK_Cmd.setHead("TXNO", "11105");
				BTN_CNCL_OK.setDisabled(true);
				BTN_CNCL_OK_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback,
							String commandItemName) {
						BTN_CNCL_OK.setDisabled(false);
						if (status) {
							System.out.println("===返回值===:"+ callback.getCallbackData());
							SC.say("取消成功,交易流水号为："+ resultDs.getCurrentValue("TXN_SEQ_NO"));
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
		this.BTN_CNCL_OK.addClickListener(ClickListener1);
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
//								if (!CIPSCommon.isDataNull(result2Ds, "CN_NAME")) {
//									inputDs.setCurrentValue("CUST_NAME", result2Ds.getCurrentValue("CN_NAME"));
//								} else {
//									inputDs.setCurrentValue("CUST_NAME", result2Ds.getCurrentValue("EN_NAME"));
//								}
////								result2Ds.removeAllData();
//								result2Ds.sync();
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
//				                        	inputDs.setCurrentValue("CHARGE_AMT", result2Ds.getCurrentValue("CHARGE_AMT"));
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
		
//		frmJYXX_AMT.removeValueChangedListener(frmJYXX_AMT_Listener);
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
//	                    		inputDs.setCurrentValue("CHARGE_AMT", result2Ds.getCurrentValue("CHARGE_AMT"));
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
		
//		frmFKXX_PAYER_ACTNO.removeValueChangedListener(frmFKXX_PAYER_ACTNO_Listener);
//    	frmFKXX_PAYER_ACTNO_Listener = new ValueChangedListener("PAYER_ACTNO") {
//			@Override
//			public void onValueChange(String fieldName, ValueChangeEvent event)
//			{
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
//								inputDs.setCurrentValue("PAYER_NAME", result2Ds.getCurrentValue("CN_NAME"));
//								inputDs.setCurrentValue("PAYER_ADDR1", result2Ds.getCurrentValue("ADDR"));
//								inputDs.setCurrentValue("PAYER_ACCT_BRNO", result2Ds.getCurrentValue("BRNO"));
//								inputDs.setCurrentValue("PAYER_ACCT_BRNAME", result2Ds.getCurrentValue("BRNAME"));
//								inputDs.setCurrentValue("CUST_ID", result2Ds.getCurrentValue("CUST_ID"));
//								inputDs.setCurrentValue("C_NRA_FLAG", result2Ds.getCurrentValue("C_NRA_FLAG"));
//								inputDs.sync();
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
		
//		BTN_MOD_OK.removeClickListener(BTN_MOD_OK_Listener);
		BTN_MOD_OK_ClickListener = new ClickListener() {
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

				// （9） 付款人名称和付款人地址两者至少需要填写一项，收款人名称和收款人地址两者至少需要填写一项。
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
				// 原始币种、金额 必须同时填写
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

				inputDs.setCurrentValue("A_TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
				/*
				 * BTN_MOD_OK_Cmd.setHead("SRV_ID", "CIPS_11102");
				 * BTN_MOD_OK_Cmd.setHead("TXNO", "1353");
				 * BTN_MOD_OK.setDisabled(true); BTN_MOD_OK_Cmd.execute(new
				 * CommandCallback() {
				 * 
				 * @Override public void onCallback(boolean status, Callback
				 * callback,String commandItemName) {
				 * BTN_MOD_OK.setDisabled(false); if (status) {
				 * System.out.println("===返回值===:"+ callback.getCallbackData());
				 * resultDs.setCurrentValue("CHK_FLAG", "&radic;");
				 * SC.say("提交成功"); resultTb.redraw(); detailSw.hide();
				 * 
				 * } else { // SC.say("提交失败,错误信息"+callback.getErrorMessage());
				 * 
				 * } } });
				 */
				executeBtnOkCmd();
			}
		};
		this.BTN_MOD_OK.addClickListener(BTN_MOD_OK_ClickListener);
		
//		frmJYXX_AMT.removeValueChangedListener(frmJYXX_AMT_Listener);
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
//				String accountType = inputDs.getCurrentValue("ACCOUNT_TYPE");
//				if ("0".equals(accountType)){
//					inputDs.setCurrentValue("CHARGE_AMT", "0.00");
//					inputDs.sync();
//					return;
//				}
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
//					feeDs.setCurrentValue("ACTNO", inputDs.getCurrentValue("CUST_ACTNO"));
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
//	                    		inputDs.setCurrentValue("CHARGE_AMT", result2Ds.getCurrentValue("CHARGE_AMT"));
//	                        	inputDs.sync();
//	                        } else {
//	                            SC.say("提交失败,错误信息"+callback.getErrorMessage());
//	                        }
//	                    }
//	                });
//				}
//				
//			}
//		};
//		frmJYXX_AMT.addValueChangedListener(frmJYXX_AMT_Listener);
		
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
//        
//        	// 录入框[收款人账号]的ValueChange事件
//     		frmSKXX_PAYEE_ACTNO_Listener = new ValueChangedListener("PAYEE_ACTNO") {
//     			@Override
//     			public void onValueChange(String fieldName, ValueChangeEvent event) {
//
//     				inputDs.setCurrentValue("OPP_ACTNO", inputDs.getCurrentValue("PAYEE_ACTNO"));
//     				String fieldNames[] = new String[1];
//     				fieldNames[0] = "OPP_ACTNO";
//     				
//     				Query_Cmd.clearExtraInfo();
//     				Query_Cmd.setHead("SRV_ID", "GPAY_9999");
//     				Query_Cmd.setQuerySqlid("051110101");
//     				Query_Cmd.setQueryCondition(inputDs, fieldNames);
//     				Query_Cmd.execute(new CommandCallback() {
//     					@Override
//     					public void onCallback(boolean status, Callback callback, String commandItemName) {
//     						if (status && callback.getCallbackCount() == 1) {
//     							inputDs.setCurrentValue("PAYEE_NAME", resultDs.getCurrentValue("OPP_NAME"));
//     							inputDs.setCurrentValue("PAYEE_ADDR1", resultDs.getCurrentValue("OPP_ADDR"));
//     							inputDs.setCurrentValue("PAYEE_ADDR2", resultDs.getCurrentValue("OPP_ADDR1"));
//     							inputDs.setCurrentValue("PAYEE_ADDR3", resultDs.getCurrentValue("OPP_ADDR2"));
//     							inputDs.setCurrentValue("PAYEE_ADDR4", resultDs.getCurrentValue("OPP_ADDR3"));
//     							inputDs.setCurrentValue("PAYEE_ADDR5", resultDs.getCurrentValue("OPP_ADDR4"));
//     							inputDs.setCurrentValue("PAYEE_ADDR6", resultDs.getCurrentValue("OPP_ADDR5"));
//     							inputDs.setCurrentValue("PAYEE_ADDR7", resultDs.getCurrentValue("OPP_ADDR6"));
//     							inputDs.setCurrentValue("PAYEE_BRNO", resultDs.getCurrentValue("OPP_BRNO"));
//     							inputDs.setCurrentValue("PAYEE_BRNAME", resultDs.getCurrentValue("OPP_BRNAME"));
//     							inputDs.setCurrentValue("PAYEE_ACCT_BRNO", resultDs.getCurrentValue("OPP_ACCT_BRNO"));
//     							inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", resultDs.getCurrentValue("OPP_ACCT_BRNAME"));
//     							inputDs.setCurrentValue("PAYEE_ST_BRNO", resultDs.getCurrentValue("OPP_ST_BRNO"));
//     							inputDs.setCurrentValue("PAYEE_ST_BRNAME", resultDs.getCurrentValue("OPP_ST_BRNAME"));
//     							// inputDs.setCurrentValue("CNAPS_FLAG",
//     							// resultDs.getCurrentValue("CNAPS_FLAG"));
//     							inputDs.sync();
//     							resultDs.removeAllData();
//     							resultDs.sync();
//     						} else if (status && callback.getCallbackCount() == 0){
//     							/*
//     							inputDs.setCurrentValue("PAYEE_NAME", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR", "");
//     							inputDs.setCurrentValue("PAYEE_BRNO", "");
//     							inputDs.setCurrentValue("PAYEE_BRNAME", "");
//     							inputDs.setCurrentValue("PAYEE_ACCT_BRNO", "");
//     							inputDs.setCurrentValue("PAYEE_ACCT_BRNAME", "");
//     							inputDs.setCurrentValue("PAYEE_ST_BRNO", "");
//     							inputDs.setCurrentValue("PAYEE_ST_BRNAME", "");
//     							
//     							inputDs.setCurrentValue("PAYEE_ADDR1", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR2", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR3", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR4", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR5", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR6", "");
//     							inputDs.setCurrentValue("PAYEE_ADDR7", "");
//     							*/
//
//     							// inputDs.setCurrentValue("CNAPS_FLAG",
//     							// resultDs.getCurrentValue("CNAPS_FLAG"));
//     							inputDs.sync();
//     							resultDs.removeAllData();
//     							resultDs.sync();
//     						}
//     					}
//     				});
//
//     			}
//     			
//     		};
//     		frmSKXX_PAYEE_ACTNO.addValueChangedListener(frmSKXX_PAYEE_ACTNO_Listener);
    }
}
