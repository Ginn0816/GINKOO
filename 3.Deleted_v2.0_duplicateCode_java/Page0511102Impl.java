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
    	
     	ClickListener1 = new ClickListener(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO 按钮点击事件
				HashMap<String, String> map = new HashMap<String, String>();
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
				if ((CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && !CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))
						|| (!CIPSCommon.isAmtNull(inputDs, "FEE2_AMT") && CIPSCommon.isDataNull(inputDs, "FEE2_BRNO"))) {
					UPrompt.alert("提示信息", "[费用2] 与 [付费行2] 必须同时填写");
					return;
				}

				inputDs.setCurrentValue("A_TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
				executeBtnOkCmd();
			}
		};
		this.BTN_MOD_OK.addClickListener(BTN_MOD_OK_ClickListener);
    }
}
