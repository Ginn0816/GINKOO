package com.gingkoo.cips.client.view;

import java.util.List;
import java.util.Map;

import com.gingkoo.cips.client.app.common.CIPS114Common;
import com.gingkoo.cips.client.app.common.CIPSCommon;
import com.gingkoo.cips.client.app.common.PageTypeEnum;
import com.gingkoo.gui.data.client.async.Callback;
import com.gingkoo.gui.data.client.command.callback.CommandCallback;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UPrompt;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.basic.UPrompt.PromptCallback;
import com.gingkoo.gui.ui.component.client.events.ClickEvent;
import com.gingkoo.gui.ui.component.client.events.ClickListener;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickEvent;
import com.gingkoo.gui.ui.component.client.grid.events.RecordDoubleClickListener;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;

import com.smartgwt.client.util.SC;

public class Page0511403Impl extends Page0511403Cust {
    private static final long serialVersionUID = 1L;
    protected ClickListener okClickListener;
    protected ClickListener rejClickListener;
    protected RecordDoubleClickListener recordDoubleClickListener;
    private final CommonPageView page = this;

    @Override
    protected void bindEvent() {
        super.bindEvent();
        okClickListener = new ClickListener() {
            @Override
            public void onClick(ClickEvent event) {
                if (inputDs.getCurrentValue("CHK_RESULT").contains("交易疑似重账")) {
                    UPrompt.confirm("提示", "检查到该业务疑似重账,是否仍要提交?", new PromptCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value != null && value) {
                                System.out.println("重账，用户选择继续提交");

                                if (inputDs.getCurrentValue("CHK_RESULT").contains("黑名单命中")
                                        && !"05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {//取消交易复核不提示黑名单
                                    confirm(inputDs.getCurrentValue("CHK_RESULT"), "OK");
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
                        confirm(inputDs.getCurrentValue("CHK_RESULT"), "OK");
                    } else {
                        BTN_OK();
                    }
                }
            }
        };
        BTN_SUB_OK.addClickListener(okClickListener);

        recordDoubleClickListener = new RecordDoubleClickListener() {
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
                    public void onCallback(boolean status, Callback callback,
                                           String commandItemName) {

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

                        CIPS114Common.settingBeforeShowInSubWindow(page, PageTypeEnum.CHECK);
                        //取消复核
                        if ("05".equals(inputDs.getCurrentValue("TXN_STATUS"))) {
                            frmORITXN_OTXN_MSG_ID.setCanEdit(false);
                            frmRTR_RTRD_ST_AMT.setCanEdit(false);
                        } else {
                            frmORITXN_OTXN_MSG_ID.setCanEdit(true);
                            frmRTR_RTRD_ST_AMT.setCanEdit(true);
                            inputDs.setCurrentValue("OTXN_MSG_ID", "");
                            inputDs.setCurrentValue("RTRD_ST_AMT", "");
                        }

                        inputDs.sync();
                        detailSw.show();
                    }
                });
            }
        };
        this.resultTb.addRecordDoubleClickListener(recordDoubleClickListener);
    }

    protected void confirm(String info, final String type) {
        final UWindow promptWindow = new UWindow();
        UButton btn1 = new UButton();
        btn1.setTitle("继续");
        UButton btn2 = new UButton();
        btn2.setTitle("取消");
        CIPSCommon.msgBox(promptWindow, info, inputDs, btn1, btn2);

        btn1.addClickListener(new ClickListener() {
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

        btn2.addClickListener(new ClickListener() {
            @Override
            public void onClick(
                    com.gingkoo.gui.ui.component.client.events.ClickEvent event) {
                promptWindow.close();
            }
        });
    }

    protected void BTN_OK() {
        inputDs.setCurrentValue("SEQ_NO",
                resultDs.getCurrentValue("SEQ_NO"));
        BTN_SUB_OK_Cmd.setHead("SRV_ID", "CIPS_11403");
        String fieldNames[] = new String[3];
        fieldNames[0] = "SEQ_NO";
        fieldNames[1] = "OTXN_MSG_ID";
        fieldNames[2] = "RTRD_ST_AMT";
        BTN_SUB_OK_Cmd.setQueryCondition(inputDs, fieldNames);
        BTN_SUB_OK.setDisabled(true);
        BTN_SUB_OK_Cmd.execute(new CommandCallback() {
            @Override
            public void onCallback(boolean status, Callback callback,
                                   String commandItemName) {
                BTN_SUB_OK.setDisabled(false);
                if (status) {
                    System.out.println("===返回值===:"
                            + callback.getCallbackData());
                    resultDs.setCurrentValue("CHK_FLAG", "&radic;");
                    List<Map> datas = (List<Map>) callback.getCallbackData();
                    Map data = datas.get(0);
                    String authFlag = data.get("AUTH_FLAG").toString();
                    if ("1".equals(authFlag)) {
                        SC.say("该笔交易需要授权");
                    } else {
                        SC.say("复核成功");
                    }
                    resultTb.redraw();
                    detailSw.hide();
                } else {
                    SC.say("复核失败,错误信息" + callback.getErrorMessage());
                }
            }
        });
    }

    protected void BTN_REJ() {
        BTN_SUB_REJ_Cmd.setHead("SRV_ID", "CIPS_11406");
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


}
