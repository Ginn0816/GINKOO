package com.gingkoo.cips.client.view;

import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.smartgwt.client.util.SC;

public class Page0511407Impl extends Page0511407Cust {

    private static final long serialVersionUID = 1L;
    protected ClickListener okClickListener;
	
	protected void executeBtnOkCmd() {
		BTN_SUB_OK_Cmd.setHead("SRV_ID", "CIPS_11407");
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
                 } else {
                	SC.say("授权失败,错误信息"+callback.getErrorMessage());
                 }
             }
         });
    }
	
	protected void executeBtnRejCmd() {
		BTN_SUB_REJ_Cmd.setHead("SRV_ID", "CIPS_11408");
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
    protected void bindEvent() {
    	super.bindEvent();
    	okClickListener = new ClickListener() {
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
        this.BTN_SUB_OK.addClickListener(okClickListener);
        
    }
}

