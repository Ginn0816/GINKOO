package com.gingkoo.cips.client.view;

import java.util.HashMap;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.core.client.context.ContextHelper;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.events.ReferencePageGetDataEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.util.SC;

public class Page0511107Impl extends Page0511107 {

    private static final long serialVersionUID = 1L;
    protected ClickListener BTN_INQ_Listener;
    protected ClickListener BTN_SUB_OK_Listener;
    protected RecordClickListener resultTb2_Listener;
	private static String confirmFlag = "0";
	
	protected void executeBtnOkCmd() {
    	inputDs.setCurrentValue("CONFIRM_FLAG", confirmFlag);

    	BTN_SUB_OK_Cmd.setHead("SRV_ID", "CIPS_11107");
        BTN_SUB_OK.setDisabled(true);
        BTN_SUB_OK_Cmd.execute(new CommandCallback() {
             @Override
             public void onCallback(boolean status, Callback callback,String commandItemName) {
                 BTN_SUB_OK.setDisabled(false);
                 if (status) {
                     System.out.println("===返回值===:"+ callback.getCallbackData());
						SC.say("授权成功");
	                     resultDs.setCurrentValue("CHK_FLAG", "&radic;");
	                     resultTb.redraw();
	                     detailSw.hide();
	                     confirmFlag = "0";
                 } else {
                	 HashMap<String, String> result = (HashMap<String, String>)callback.getExtraData();

                	 System.out.println("===ErrorCode===:"+ callback.getErrorCode());
                     System.out.println("===ErrorMessage===:"+ callback.getErrorMessage());

                    String errMsg = callback.getErrorMessage();
                	if (errMsg != null && errMsg.length() > 6  && "059006".equals(errMsg.substring(0, 6))) {
                		UPrompt.confirm("提示", "该业务有风险: " + callback.getErrorMessage().substring(7) 
                				+ ",是否仍要授权?", new PromptCallback() {
    						@Override
    						public void execute(Boolean value) {
    							if (value != null && value) {
    								confirmFlag = "1";
    								executeBtnOkCmd();
    							}
    						}
    					});
                	} else {
                		SC.say("授权失败,错误信息"+callback.getErrorMessage());
                	}                 
                }
             }
         });
    }
	
	protected void executeBtnRejCmd() {
		BTN_SUB_REJ_Cmd.setHead("SRV_ID", "CIPS_11108");
        inputDs.setCurrentValue("REJ_TYPE", "3");
        BTN_SUB_REJ.setDisabled(true);
        BTN_SUB_REJ_Cmd.execute(new CommandCallback() {

            @Override
            public void onCallback(boolean status, Callback callback, String commandItemName) {
                BTN_SUB_REJ.setDisabled(false);
                 if (status) {
                	 	System.out.println("===返回值===:"+ callback.getCallbackData());
                        SC.say("拒绝成功");
                        resultDs.setCurrentValue("CHK_FLAG", "&chi;");
                        resultTb.redraw();
                        detailSw.hide();
                    } else {
                        SC.say("拒绝失败,错误信息"+callback.getErrorMessage());
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
					executeBtnOkCmd();
				} else {
					executeBtnRejCmd();
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
    protected void setting() {
        this.setPageID("");
    }

    @Override
    protected boolean beforeInitControls() {
        return super.beforeInitControls();
    }

    @Override
    protected void beforeRender() {
    	resultTb.setHeight("480px");

        HashMap<String, Object> map = new HashMap<String, Object>();

        queryDs.addDataRecord(new DataRecord(map), new DataAction() {
            @Override
            public void doAction(DataRecord record) {
                System.out.println("insert empty record: " + record.getDataMap());
                ListGridRecord gridRecord = record.getViewRecord();
                frmCXTJ.editRecord(gridRecord);
            }
        });
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        detailDs2.addDataRecord(new DataRecord(map2), new DataAction() {
            @Override
            public void doAction(DataRecord record) {
                System.out.println("insert empty record: "
                        + record.getDataMap());
            }
        });
        String paymentPlatformMode = ContextHelper.getContext().getValue("PAYMENT_PLATFORM_MODE");
    	if(paymentPlatformMode.equals("0")) {
    		frmJYXX_CHARGE_AMT.hide();
    	}
    }

    @Override
    protected void bindEvent() {
    	BTN_INQ_Listener = new ClickListener() {
            @Override
            public void onClick(ClickEvent event) {
                BTN_INQ_Cmd.setHead("SRV_ID", "GPAY_9999");
                BTN_INQ_Cmd.setHead("TXNO", "9999");
                BTN_INQ_Cmd.setQueryCondition(queryDs);
                BTN_INQ_Cmd.setQuerySqlid("051110701");
                BTN_INQ.setDisabled(true);
                BTN_INQ_Cmd.execute(new CommandCallback() {
                    @Override
                    public void onCallback(boolean status, Callback callback,String commandItemName) {
                        BTN_INQ.setDisabled(false);
                    }
                });
            }
        };
        this.BTN_INQ.addClickListener(BTN_INQ_Listener);
        
        this.BTN_RESET.addClickListener(new ClickListener(){
            @Override
            public void onClick(ClickEvent event) {
            	beforeRender();
            }
        });
        this.resultTb.addRecordDoubleClickListener(new RecordDoubleClickListener() {
            @Override
            public void onRecordClick(RecordDoubleClickEvent event) {
           	 if (resultDs.getCurrentValue("CHK_FLAG") != null) {
                    UPrompt.alert("授权结果", "该记录已授权！");
                    return;
                }
           	HashMap<String, String> map = new HashMap<String, String>();
               
               SUBWINDOW_Cmd.setHead("SRV_ID", "GPAY_9999");
               SUBWINDOW_Cmd.setHead("TXNO", "9999");
               
               String fieldNames[] = new String[1];
               fieldNames[0] = "TXN_SEQ_NO";
               SUBWINDOW_Cmd.setQueryCondition(resultDs, fieldNames);
                               
               SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
               SUBWINDOW_Cmd.execute(new CommandCallback() {
                   @Override
                   public void onCallback(boolean status, Callback callback,String commandItemName) {
                       BTN_INQ_Cmd2.setHead("SRV_ID", "GPAY_9999");
                       BTN_INQ_Cmd2.setHead("TXNO", "9999");
                       BTN_INQ_Cmd2.setQuerySqlid("051110702");
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
                	   if(inputDs.getCurrentValue("PBOC_STATUS").equals("RJCT")||inputDs.getCurrentValue("PBOC_STATUS").equals("EDRN")){
	                   		frmJYZTXX1.show();
	                   	}else{
	                   		frmJYZTXX1.hide();
	                   	}
                       detailSw.show();
                   }
               });
           }
        });
        
        resultTb2_Listener = new RecordClickListener() {
            
            @Override
            public void onRecordClick(RecordClickEvent event) {
                detailDs2.setCurrentValue("INS_INFORMATION",
                        resultDs2.getCurrentValue("INS_INFORMATION"));
                detailDs2.sync();
            }
        };
        this.resultTb2.addRecordClickListener(resultTb2_Listener);
        
          BTN_SUB_OK_Listener = new ClickListener() {
              @Override
              public void onClick(ClickEvent event) {
            	  if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")
            			  && !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {
            		  confirm(inputDs.getCurrentValue("CHK_RESULT"),"OK");
					} else {
						executeBtnOkCmd();
					}
              }
          };
          this.BTN_SUB_OK.addClickListener(BTN_SUB_OK_Listener);

        this.BTN_SUB_REJ.addClickListener(new ClickListener(){
            @Override
            public void onClick(ClickEvent event) {
            	if(CIPSCommon.isDataNull(inputDs, "BIZ_REJ_INFO")){
            		UPrompt.confirm("提示", "未输入拒绝信息，是否继续", new PromptCallback() {
						@Override
						public void execute(Boolean value) {
							if (value != null && value) {
								executeBtnRejCmd();
							} 
						}
					});
                } else {
                	executeBtnRejCmd();
                }
            }
        });
        this.BTN_SUB_CLOSE.addClickListener(new ClickListener(){
            @Override
            public void onClick(ClickEvent event) {
                detailSw.hide();
                detailDs2.setCurrentValue("INS_INFORMATION", "");
                detailDs2.sync();
                resultDs2.removeAllData();
                resultDs2.sync();
            }
        });
        
        detailSw.addCloseClickHandler(new CloseClickHandler() {
            
            @Override
            public void onCloseClick(CloseClickEvent event) {
                detailSw.hide();
                detailDs2.setCurrentValue("INS_INFORMATION", "");
                detailDs2.sync();
                resultDs2.removeAllData();
                resultDs2.sync();
            }
        });
        
    }
    @Override
    public void onReferencePageGetData(ReferencePageGetDataEvent event)
    {
        System.out.println("===reference page get data===");
        System.out.println(event.getSource());
        System.out.println(event.getCallbackData());
    }
}

