package com.gingkoo.cips.client.view;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.gingkoo.cips.client.app.common.CIPSCommon;
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

public class Page0511103Impl extends Page0511103Cust {

    private static final long serialVersionUID = 1L;
    protected RecordDoubleClickListener doubleClickListener2;
    protected ClickListener ClickListener2;
    protected ClickListener rejClickListener;
    
    void BTN_OK() {
    	
    	 inputDs.setCurrentValue("TXN_SEQ_NO", resultDs.getCurrentValue("TXN_SEQ_NO"));
         // TODO 按钮点击事件
		 BTN_SUB_OK_Cmd.setHead("SRV_ID", "CIPS_11103");
	     String fieldNames[] = new String[5];
	     fieldNames[0] = "TXN_SEQ_NO";
	     fieldNames[1] = "PAYER_ACTNO";
	     fieldNames[2] = "PAYEE_ACTNO";
	     fieldNames[3] = "AMT";
	     fieldNames[4] = "ACCOUNT_TYPE";
	     BTN_SUB_OK_Cmd.setQueryCondition(inputDs,fieldNames);
	     BTN_SUB_OK.setDisabled(true);
	     BTN_SUB_OK_Cmd.execute(new CommandCallback() {
	          @Override
	          public void onCallback(boolean status, Callback callback,String commandItemName) {
	              BTN_SUB_OK.setDisabled(false);
	              if (status) {
	            	  System.out.println("===返回值===:"+ callback.getCallbackData());
	             	  resultDs.setCurrentValue("CHK_FLAG", "&radic;");
	             	  List<Map> datas = (List<Map>) callback.getCallbackData();
	             	  Map data = datas.get(0);
	             	  String authFlag = data.get("AUTH_FLAG").toString();
	             	  if ("1".equals(authFlag)){
	             		  SC.say("该笔交易需要授权");
	             	  } else {
	             		  SC.say("复核成功");
	             	  }
	//             	  SC.say("复核成功");
	                  resultTb.redraw();
	                  detailSw.hide();
	              } else {
	                  SC.say("复核失败,错误信息"+callback.getErrorMessage());
	              }
	          }
	      });
    }
    
    protected void BTN_REJ(){
    	BTN_SUB_REJ_Cmd.setHead("SRV_ID", "CIPS_11106");
		inputDs.setCurrentValue("REJ_TYPE", "1");
		BTN_SUB_REJ.setDisabled(true);
		BTN_SUB_REJ_Cmd.execute(new CommandCallback() {

			@Override
			public void onCallback(boolean status,
					Callback callback, String commandItemName) {
				BTN_SUB_REJ.setDisabled(false);
				if (status) {
					System.out.println("===返回值===:"
							+ callback.getCallbackData());
					SC.say("复核拒绝成功");
					resultDs.setCurrentValue("CHK_FLAG", "&chi;");
					resultTb.redraw();
					detailSw.hide();
				} else {
					SC.say("复核拒绝失败,错误信息"
							+ callback.getErrorMessage());
				}
			}
		});
    }
    
    protected void confirm(String info,final String type){
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
				if ("OK".equals(type)) {
					BTN_OK();
				} else {
					BTN_REJ();
				}
				promptWindow.close();
			}
		});
		
		btn2.addClickListener(new ClickListener(){
			@Override
			public void onClick(
					com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
				promptWindow.close();
			}
		});	
    }
    
    @Override
    protected void bindEvent() {
    	super.bindEvent();
    	
//    	resultTb.removeRecordDoubleClickListener(doubleClickListener);
    	doubleClickListener2 = new RecordDoubleClickListener(){
            @Override
            public void onRecordClick(RecordDoubleClickEvent event) {
            	 if (resultDs.getCurrentValue("CHK_FLAG") != null) {
                     UPrompt.alert("复核结果", "该记录已复核！");
                     return;
                 }
            	 inputDs.setCurrentValue("INQ_CONTENT", "");

                SUBWINDOW_Cmd.setHead("SRV_ID", "GPAY_9999");
                SUBWINDOW_Cmd.setHead("TXNO", "9999");
                
                String fieldNames[] = new String[1];
                fieldNames[0] = "TXN_SEQ_NO";
                SUBWINDOW_Cmd.setQueryCondition(resultDs, fieldNames);
                
                SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
                SUBWINDOW_Cmd.execute(new CommandCallback() {
                    @Override
                    public void onCallback(boolean status, Callback callback,String commandItemName) {
                    	
                    	 // 查询子列表
                        BTN_INQ_Cmd2.setHead("SRV_ID", "GPAY_9999");
                        BTN_INQ_Cmd2.setHead("TXNO", "9999");
                        BTN_INQ_Cmd2.setQuerySqlid("051110302");
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
                        
                        
//                    	if(inputDs.getCurrentValue("PBOC_STATUS").equals("RJCT")||inputDs.getCurrentValue("PBOC_STATUS").equals("EDRN")){
//                    		frmJYZTXX1.show();
//                    	}else{
//                    		frmJYZTXX1.hide();
//                    	}
                    	detailSw.show();
                    	if ("05".equals(inputDs.getCurrentValue("TXN_STATUS"))){
                    		//取消复核
                    		frmFKXX.setReadOnly("PAYER_ACTNO", true);
                    		frmSKXX.setReadOnly("PAYEE_ACTNO", true);
                    		frmJYXX.setReadOnly("AMT", true);
                    		frmJYXX.setReadOnly("ACCOUNT_TYPE", true);
                    	} else {
                    		inputDs.setCurrentValue("ORI_MSG_ID", inputDs.getCurrentValue("MSG_ID"));
                        	inputDs.setCurrentValue("ORI_SND_BRNO", inputDs.getCurrentValue("SND_BRNO"));
                        	inputDs.setCurrentValue("ORI_SND_BRNAME", inputDs.getCurrentValue("SND_BRNAME"));
                        	inputDs.setCurrentValue("ORI_MSG_TYPE", inputDs.getCurrentValue("MSG_TYPE"));
                        	inputDs.setCurrentValue("PAYER_ACTNO", "");
                            inputDs.setCurrentValue("PAYEE_ACTNO", "");
                            inputDs.setCurrentValue("AMT", "");
//                            inputDs.setCurrentValue("ACCOUNT_TYPE", "");
                            String nullvalue = null;
                            inputDs.setCurrentValue("ACCOUNT_TYPE", nullvalue);
                            frmFKXX.setReadOnly("PAYER_ACTNO", false);
                    		frmSKXX.setReadOnly("PAYEE_ACTNO", false);
                    		frmJYXX.setReadOnly("AMT", false);
                    		frmJYXX.setReadOnly("ACCOUNT_TYPE", false);
                    	}
                    	
                        inputDs.sync();
                    }
                });
            }
        };
        super.resultTb.addRecordDoubleClickListener(doubleClickListener2);
        
//        BTN_SUB_OK.removeClickListener(ClickListener);
        ClickListener2 = new ClickListener(){
            @Override
            public void onClick(ClickEvent event) {
            	/*String errmsg = "";
            	String payerActno = resultDs.getCurrentValue("PAYER_ACTNO");
            	String payeeActno = resultDs.getCurrentValue("PAYEE_ACTNO");
            	String amt = resultDs.getCurrentValue("AMT");
            	String acctType = resultDs.getCurrentValue("ACCOUNT_TYPE");
            	if (!payerActno.equals(inputDs.getCurrentValue("PAYER_ACTNO"))) {
					errmsg += "[付款人账号]";
				}
            	if (!payeeActno.equals(inputDs.getCurrentValue("PAYEE_ACTNO"))) {
					errmsg += "[收款人账号]";
				}
            	if (!amt.equals(inputDs.getCurrentValue("AMT"))) {
					errmsg += "[金额]";
				}
            	if (!acctType.equals(inputDs.getCurrentValue("ACCOUNT_TYPE"))) {
					errmsg += "[记账标志]";
				}
            	if (!"".equals(errmsg)) {
					SC.say("复核失败！错误描述为" + errmsg);
					return;
				}
            	
				DUP_CHK_INQ_Cmd.setHead("SRV_ID", "GPAY_9999");
				DUP_CHK_INQ_Cmd.setHead("TXNO", "9999");
				DUP_CHK_INQ_Cmd.setHead("ESCAPEFLAG", "TRUE");
				DUP_CHK_INQ_Cmd.setQueryCondition(inputDs);
				// 对于通用查询需要设置SQLID的值
				DUP_CHK_INQ_Cmd.setQuerySqlid("ANZ_111_DUP_CHECK");
				BTN_SUB_OK.setDisabled(true);
				DUP_CHK_INQ_Cmd.execute(new CommandCallback() {
					@Override
					public void onCallback(boolean status, Callback callback,
							String commandItemName) {
							BTN_SUB_OK.setDisabled(false);
							
							if (status) {
								if (!"0".equals(dupDs.getCurrentValue("DUP_CNT"))) {
									UPrompt.confirm("提示", "检查到该业务疑似重账,是否仍要提交?", new PromptCallback() {
			    						@Override
			    						public void execute(Boolean value) {
			    							if (value != null && value) {
			    								System.out.println("重账，用户选择继续提交");
			    								
			    								if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中") 
			    										&& !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {//取消交易复核不提示黑名单
			    									confirm(inputDs.getCurrentValue("CHK_RESULT"),"OK");
			    								} else {
				    								BTN_OK();
			    								}
			    								
			    							} else {
			    								System.out.println("重账，用户选择终止提交");
			    								return;
			    							}
			    						}
			    					});
								} else {
									
    								System.out.println("未重账");
    								
    								if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")
    										&& !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {
    									confirm(inputDs.getCurrentValue("CHK_RESULT"),"OK");
    								} else {
	    								BTN_OK();
    								}
    								
								}
							} else {
								UPrompt.alert("提示", "重账检查失败");
							}
						}
				});*/
            	if (inputDs.getCurrentValue("CHK_RESULT").contains("交易疑似重账")) {
            		UPrompt.confirm("提示", "检查到该业务疑似重账,是否仍要提交?", new PromptCallback() {
            			@Override
						public void execute(Boolean value) {
							if (value != null && value) {
								System.out.println("重账，用户选择继续提交");
								
								if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中") 
										&& !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {//取消交易复核不提示黑名单
									confirm(inputDs.getCurrentValue("CHK_RESULT"),"OK");
								} else {
    								BTN_OK();
								}
								
							} else {
								System.out.println("重账，用户选择终止提交");
								return;
							}
						}
            		});
            	} else {
					System.out.println("未重账");
					if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")
							&& !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {
						confirm(inputDs.getCurrentValue("CHK_RESULT"),"OK");
					} else {
						BTN_OK();
					}
				}
	         }
        };
        BTN_SUB_OK.addClickListener(ClickListener2);
        
//        BTN_SUB_REJ.removeClickListener(BTN_SUB_REJ_Listener);
        rejClickListener = new ClickListener() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (CIPSCommon.isDataNull(inputDs, "BIZ_REJ_INFO")) {
					UPrompt.confirm("提示", "未输入拒绝信息，是否继续", new PromptCallback() {
						@Override
						public void execute(Boolean value) {
							if (value != null && value) {
//								if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")) {
//									confirm(inputDs.getCurrentValue("CHK_RESULT"),"REJ");
//								} else {
//									BTN_REJ();
//								}
								BTN_REJ();
							}
						}
					});
				} else {
//					if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")) {
//						confirm(inputDs.getCurrentValue("CHK_RESULT"),"REJ");
//					} else {
//						BTN_REJ();
//					}
					BTN_REJ();
				}
			}
		};
		BTN_SUB_REJ.addClickListener(rejClickListener);
    }
}
