package com.gingkoo.cips.client.view;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.smartgwt.client.util.SC;

public class Page0511402Impl extends Page0511402Cust {

    private static final long serialVersionUID = 1L;
    private static String confirmFlag = "0";
	protected ClickListener BTN_MOD_OK_ClickListener;

    @Override
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
					List<Map> datas = (List<Map>) callback.getCallbackData();
					Map data = datas.get(0);
					String blockStatus = data.get("CNMS_BLOCK_STATUS").toString();
                    if ("ON".equals(blockStatus)) {
						SC.say("提交成功，流水号为[" + resultDs.getCurrentValue("TXN_SEQ_NO")  +"]  "+data.get("BIZ_REJ_INFO") 
								+"<br>远程黑名单系统已关闭，需要进行人工校验");
					} else {
						SC.say("提交成功，流水号为[" + resultDs.getCurrentValue("TXN_SEQ_NO")  +"]  "+data.get("BIZ_REJ_INFO") );
					}
					resultTb.redraw();
					detailSw.hide();
					chrgDs.removeAllData();
					chrgDs.sync();
				} else {
					HashMap<String, String> result = (HashMap<String, String>) callback.getExtraData();

					System.out.println("===ErrorCode===:" + callback.getErrorCode());
					System.out.println("===ErrorMessage===:" + callback.getErrorMessage());

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

		BTN_MOD_OK.removeClickListener(BTN_MOD_OK_Listener);
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
    }
}
