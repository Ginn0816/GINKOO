package com.gingkoo.cips.client.view;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import com.gingkoo.cips.client.app.common.CIPS114Common;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.data.client.dataset.action.DataAction;
import com.gingkoo.gui.data.client.dataset.record.DataRecord;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;

public class Page0511407Cust extends Page0511407 {

    private static final long serialVersionUID = 1L;
    private final CommonPageView page = this;

    protected ClickListener BTN_INQ_Listener;
    protected ClickListener BTN_SUB_OK_Listener;
    protected RecordClickListener resultTb2_Listener;

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
        CIPS114Common.settingBeforeRender(this, PageTypeEnum.AUTHORIZE);

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

//        String paymentPlatformMode = ContextHelper.getContext().getValue("PAYMENT_PLATFORM_MODE");
//    	if(paymentPlatformMode.equals("0")) {
//    		frmJYXX_CHARGE_AMT.hide();
//    	}
    }

    @Override
    protected void bindEvent() {
        CIPS114Common.bindEvent(this);

        BTN_INQ_Listener = new ClickListener() {
            @Override
            public void onClick(ClickEvent event) {
                BTN_INQ_Cmd.setHead("SRV_ID", "GPAY_9999");
                BTN_INQ_Cmd.setHead("TXNO", "9999");
                BTN_INQ_Cmd.setQueryCondition(queryDs);
                BTN_INQ_Cmd.setQuerySqlid("051140701");
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
                }//（查询）并显示子窗体
           	HashMap<String, String> map = new HashMap<String, String>();
               
               SUBWINDOW_Cmd.setHead("SRV_ID", "GPAY_9999");
               SUBWINDOW_Cmd.setHead("TXNO", "9999");
               
               String fieldNames[] = new String[1];
               fieldNames[0] = "TXN_SEQ_NO";
               SUBWINDOW_Cmd.setQueryCondition(resultDs, fieldNames);
                               
               //对于通用查询需要设置SQLID的值
               SUBWINDOW_Cmd.setQuerySqlid("CIPS_TXN_DTL");
               SUBWINDOW_Cmd.execute(new CommandCallback() {
                   @Override
                   public void onCallback(boolean status, Callback callback,String commandItemName) {

                       // 查询子列表
                       SUBWINDOW_Cmd2.setHead("SRV_ID", "GPAY_9999");
                       SUBWINDOW_Cmd2.setHead("TXNO", "9999");
                       SUBWINDOW_Cmd2.setQuerySqlid("05114_qry_chrg_list");
                       SUBWINDOW_Cmd2.setQueryCondition(resultDs);
                       SUBWINDOW_Cmd2.execute(new CommandCallback() {
                           @Override
                           public void onCallback(boolean status,
                                   Callback callback, String commandItemName) {

                           }
                       });

                       CIPS114Common.settingBeforeShowInSubWindow(page, PageTypeEnum.AUTHORIZE);
                       detailSw.show();
                   }
               });
           }
        });
        

        BTN_SUB_OK_Listener = new ClickListener() {
            @Override
            public void onClick(ClickEvent event) {
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
						}
					});
                } else {
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
            }
        });
        this.BTN_SUB_CLOSE.addClickListener(new ClickListener(){
            @Override
            public void onClick(ClickEvent event) {
                detailSw.hide();
                chrgDs.removeAllData();
                chrgDs.sync();
            }
        });
        
        detailSw.addCloseClickHandler(new CloseClickHandler() {
            
            @Override
            public void onCloseClick(CloseClickEvent event) {
                detailSw.hide();
                chrgDs.removeAllData();
                chrgDs.sync();
            }
        });


        // 费用相关事件
        // 双击查看
        this.tbCHRG.addRecordDoubleClickListener(new RecordDoubleClickListener() {
            @Override
            public void onRecordClick(RecordDoubleClickEvent recordDoubleClickEvent) {
                Map dataMap = chrgDs.getCurrentRecord().getDataMap();
                Map dataMapDup = new HashMap<String, Object>();
                dataMapDup.putAll(dataMap);
                dataMapDup.remove("itemID");
                chrgDtlDs.addDataRecord(new DataRecord(dataMapDup), new DataAction() {
                    @Override
                    public void doAction(DataRecord record) {
                        CIPS114Common.setChrgAddr(page);
                        chrgSubWin.show();
                    }
                });
            }
        });

        // 退汇费用画面关闭
        this.BTN_CHRG_DTL_CLOSE.addClickListener(new ClickListener() {
            @Override
            public void onClick(com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                chrgSubWin.close();
            }
        });


    }
}

