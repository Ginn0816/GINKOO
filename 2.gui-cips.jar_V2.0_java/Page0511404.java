package com.gingkoo.cips.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.dev.util.collect.Lists;
import com.gingkoo.gui.core.client.config.BaseConfig;
import com.gingkoo.gui.core.client.config.PageViewConfig;
import com.gingkoo.gui.core.shared.annotations.reflection.ClassForNameAble;
import com.gingkoo.gui.data.client.command.DatasetCommand;
import com.gingkoo.gui.data.client.dataset.ViewDataset;
import com.gingkoo.gui.ui.component.client.basic.UButton;
import com.gingkoo.gui.ui.component.client.basic.UWindow;
import com.gingkoo.gui.ui.component.client.basic.UCustomReference;
import com.gingkoo.gui.ui.component.client.form.UDynamicForm;
import com.gingkoo.gui.ui.component.client.form.UFileUploadForm;
import com.gingkoo.gui.ui.component.client.form.fields.UUploadItem;
import com.gingkoo.gui.ui.component.client.form.fields.USectionItem;
import com.gingkoo.gui.ui.component.client.form.fields.UDateItem;
import com.gingkoo.gui.ui.component.client.form.fields.UCheckboxItem;
import com.gingkoo.gui.ui.component.client.form.fields.UMoneyItem;
import com.gingkoo.gui.ui.component.client.form.fields.USelectItem;
import com.gingkoo.gui.ui.component.client.form.fields.UTextAreaItem;
import com.gingkoo.gui.ui.component.client.form.fields.UTextItem;
import com.gingkoo.gui.ui.component.client.tree.UTreeGrid;
import com.gingkoo.gui.ui.component.client.grid.UNavigateBar;
import com.gingkoo.gui.ui.component.client.form.fields.UQueryBankItem;
import com.gingkoo.gui.ui.component.client.form.validator.CharSetAValidator;
import com.gingkoo.gui.ui.component.client.form.validator.CharSetNValidator;
import com.gingkoo.gui.ui.component.client.form.validator.CharSetXValidator;
import com.gingkoo.gui.ui.component.client.form.validator.CustValidator;
import com.gingkoo.gui.ui.component.client.grid.UTable;
import com.gingkoo.gui.ui.component.client.basic.UImage;
import com.gingkoo.gui.ui.component.client.layout.UVLayout;
import com.gingkoo.gui.ui.component.client.ocx.UOcx;
import com.gingkoo.gui.ui.component.client.upload.GALUploader;
import com.gingkoo.gui.ui.component.client.grid.USelectableTable;
import com.gingkoo.gui.ui.component.client.form.fields.UPasswordItem;
import com.gingkoo.gui.ui.component.client.view.CommonPageView;

@ClassForNameAble
public class Page0511404 extends CommonPageView {

    private static final long serialVersionUID = 1L;

    // Data set
    // protected ViewDataset queryDs;
        public ViewDataset resultDs;
        public ViewDataset chrgDs;
        public ViewDataset queryDs;
        public ViewDataset inputDs;
        public ViewDataset chrgDtlDs;

    // Command
    // protected DatasetCommand BTN_INQ_Cmd;
        protected DatasetCommand BTN_INQ_Cmd;
        protected DatasetCommand SUBWINDOW_Cmd;
        protected DatasetCommand SUBWINDOW_Cmd2;
        protected DatasetCommand BTN_SUB_OK_Cmd;
        protected DatasetCommand BTN_SUB_REJ_Cmd;

    // Form
    // protected UDynamicForm frmCXTJ;
    // protected UTextItem frmCXTJ_DSPT_ID;
    // protected USelectItem frmCXTJ_DSPT_RSN_CD;
        protected UDynamicForm frmCXTJ;
            protected UDateItem frmCXTJ_WORK_DATE;
            protected UTextItem frmCXTJ_TXN_SEQ_NO;
            protected UMoneyItem frmCXTJ_START_AMT;
            protected UMoneyItem frmCXTJ_END_AMT;
            protected UTextItem frmCXTJ_OTXN_MSG_ID;
            protected UTextItem frmCXTJ_MADE_USER;
        protected UDynamicForm frmHEAD;
            protected UTextItem frmHEAD_MSG_ID;
            protected UTextItem frmHEAD_MSG_SND_TIME;
            protected UTextItem frmHEAD_TXN_NUM;
            protected UTextItem frmHEAD_ST_METHOD;
            protected UTextItem frmHEAD_CLR_SYS_REF;
        protected UDynamicForm frmSTAC;
            protected UTextItem frmSTAC_ST_AC_IBAN;
            protected UTextItem frmSTAC_ST_AC_ID;
            protected UTextItem frmSTAC_ST_AC_ID_SCHE;
            protected UTextItem frmSTAC_ST_AC_ID_SCHEX;
            protected UTextItem frmSTAC_ST_AC_ID_ISSR;
            protected UTextItem frmSTAC_ST_AC_TYPE;
            protected UTextItem frmSTAC_ST_AC_TYPEX;
            protected USelectItem frmSTAC_ST_AC_CCY;
            protected UTextItem frmSTAC_ST_AC_NAME;
            protected UTextItem frmSTAC_ST_AC_AKA_ID_TP;
            protected UTextItem frmSTAC_ST_AC_AKA_ID_TPX;
            protected UTextItem frmSTAC_ST_AC_AKA_ID;
        protected UDynamicForm frmSCENARIO;
            protected USelectItem frmSCENARIO_RETURN_SCENARIO;
        protected UDynamicForm frmORITXN;
            protected UTextItem frmORITXN_OTXN_MSG_ID;
            protected USelectItem frmORITXN_OTXN_MSG_TYPE;
            protected UTextItem frmORITXN_OTXN_MSG_SND_TIME;
            protected UTextItem frmORITXN_OTXN_INSTR_ID;
            protected UTextItem frmORITXN_OTXN_E2E_ID;
            protected UTextItem frmORITXN_OTXN_TXN_ID;
            protected UTextItem frmORITXN_OTXN_UETR;
            protected UTextItem frmORITXN_OTXN_CLR_SYS_REF;
            protected UMoneyItem frmORITXN_OTXN_AMT;
            protected USelectItem frmORITXN_OTXN_AMT_CURCD;
            protected UDateItem frmORITXN_OTXN_ST_DATE;
            protected UTextItem frmORITXN_OTXN_BIZ_CATE_CODE;
        protected UDynamicForm frmRTR;
            protected UTextItem frmRTR_RTR_ID;
            protected UMoneyItem frmRTR_RTRD_ST_AMT;
            protected USelectItem frmRTR_RTRD_ST_AMT_CURCD;
            protected UDateItem frmRTR_ST_DATE;
            protected UTextItem frmRTR_ST_PRIO;
            protected UTextItem frmRTR_ST_DR_TIME;
            protected UTextItem frmRTR_ST_CR_TIME;
            protected UMoneyItem frmRTR_RTRD_INSTD_AMT;
            protected USelectItem frmRTR_RTRD_INSTD_AMT_CURCD;
            protected UTextItem frmRTR_FX_RATE;
            protected USelectItem frmRTR_CHRG_BEAR;
            protected USelectItem frmRTR_RTR_REASON_CD;
            protected UTextItem frmRTR_ADDTL_INF1;
            protected UTextItem frmRTR_ADDTL_INF2;
        protected UDynamicForm frmINSTG;
            protected UTextItem frmINSTG_INSTG_AGT_BIC;
            protected UTextItem frmINSTG_INSTG_AGT_CLR_SYS;
            protected UTextItem frmINSTG_INSTG_AGT_CLR_SYS_MMBID;
            protected UTextItem frmINSTG_INSTG_AGT_LEI;
        protected UDynamicForm frmINSTD;
            protected UTextItem frmINSTD_INSTD_AGT_BIC;
            protected UTextItem frmINSTD_INSTD_AGT_CLR_SYS;
            protected UTextItem frmINSTD_INSTD_AGT_CLR_SYS_MMBID;
            protected UTextItem frmINSTD_INSTD_AGT_LEI;
        protected UDynamicForm frmUDBTR;
            protected UTextItem frmUDBTR_UDBTR_NAME;
            protected UTextAreaItem frmUDBTR_UDBTR_ADR_M;
            protected UTextItem frmUDBTR_UDBTR_ADR_DEPT;
            protected UTextItem frmUDBTR_UDBTR_ADR_SDEPT;
            protected UTextItem frmUDBTR_UDBTR_ADR_STRT_NM;
            protected UTextItem frmUDBTR_UDBTR_ADR_BLDG_NB;
            protected UTextItem frmUDBTR_UDBTR_ADR_BLDG_NM;
            protected UTextItem frmUDBTR_UDBTR_ADR_FLR;
            protected UTextItem frmUDBTR_UDBTR_ADR_PST_BX;
            protected UTextItem frmUDBTR_UDBTR_ADR_ROOM;
            protected UTextItem frmUDBTR_UDBTR_ADR_PST_CD;
            protected UTextItem frmUDBTR_UDBTR_ADR_TWN;
            protected UTextItem frmUDBTR_UDBTR_ADR_TWN_LOC;
            protected UTextItem frmUDBTR_UDBTR_ADR_DSTRCT;
            protected UTextItem frmUDBTR_UDBTR_ADR_AREA;
            protected USelectItem frmUDBTR_UDBTR_ADR_CTRY;
            protected UTextItem frmUDBTR_UDBTR_C_BIC;
            protected UTextItem frmUDBTR_UDBTR_C_LEI;
            protected UTextItem frmUDBTR_UDBTR_C_ID;
            protected UTextItem frmUDBTR_UDBTR_C_ID_SCHE;
            protected UTextItem frmUDBTR_UDBTR_C_ID_SCHEX;
            protected UTextItem frmUDBTR_UDBTR_C_ID_ISSR;
            protected UDateItem frmUDBTR_UDBTR_P_BIRTH_DATE;
            protected UTextItem frmUDBTR_UDBTR_P_BIRTH_PRVC;
            protected UTextItem frmUDBTR_UDBTR_P_BIRTH_CITY;
            protected USelectItem frmUDBTR_UDBTR_P_BIRTH_CTRY;
            protected UTextItem frmUDBTR_UDBTR_P_ID;
            protected UTextItem frmUDBTR_UDBTR_P_ID_SCHE;
            protected USelectItem frmUDBTR_UDBTR_P_ID_SCHEX;
            protected UTextItem frmUDBTR_UDBTR_P_ID_ISSR;
            protected USelectItem frmUDBTR_UDBTR_RES_CTRY;
        protected UDynamicForm frmDBTR_PTY;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_NAME;
            protected UTextAreaItem frmDBTR_PTY_DBTR_PTY_ADR_M;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_DEPT;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_SDEPT;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_STRT_NM;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_BLDG_NB;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_BLDG_NM;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_FLR;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_PST_BX;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_ROOM;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_PST_CD;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_TWN;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_TWN_LOC;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_DSTRCT;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_AREA;
            protected USelectItem frmDBTR_PTY_DBTR_PTY_ADR_CTRY;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE1;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE2;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE3;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_C_BIC;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_C_LEI;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_C_ID;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_C_ID_SCHE;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_C_ID_ISSR;
            protected UDateItem frmDBTR_PTY_DBTR_PTY_P_BIRTH_DATE;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_P_BIRTH_PRVC;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_P_BIRTH_CITY;
            protected USelectItem frmDBTR_PTY_DBTR_PTY_P_BIRTH_CTRY;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_P_ID;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_P_ID_SCHE;
            protected USelectItem frmDBTR_PTY_DBTR_PTY_P_ID_SCHEX;
            protected UTextItem frmDBTR_PTY_DBTR_PTY_P_ID_ISSR;
            protected USelectItem frmDBTR_PTY_DBTR_PTY_RES_CTRY;
        protected UDynamicForm frmDBTR_PTYF;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_BIC;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_CLR_SYS;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_CLR_SYS_MMBID;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_LEI;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_NAME;
            protected UTextAreaItem frmDBTR_PTYF_DBTR_PTYF_ADR_M;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_DEPT;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_SDEPT;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_STRT_NM;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_BLDG_NB;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_BLDG_NM;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_FLR;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_PST_BX;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_ROOM;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_PST_CD;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_TWN;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_TWN_LOC;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_DSTRCT;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_AREA;
            protected USelectItem frmDBTR_PTYF_DBTR_PTYF_ADR_CTRY;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE1;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE2;
            protected UTextItem frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE3;
        protected UDynamicForm frmINIT_PTY;
            protected UTextItem frmINIT_PTY_INIT_PTY_NAME;
            protected UTextAreaItem frmINIT_PTY_INIT_PTY_ADR_M;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_DEPT;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_SDEPT;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_STRT_NM;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_BLDG_NB;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_BLDG_NM;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_FLR;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_PST_BX;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_ROOM;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_PST_CD;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_TWN;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_TWN_LOC;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_DSTRCT;
            protected UTextItem frmINIT_PTY_INIT_PTY_ADR_AREA;
            protected USelectItem frmINIT_PTY_INIT_PTY_ADR_CTRY;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_BIC;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_LEI;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_ID;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_ID_SCHE;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_ID_SCHEX;
            protected UTextItem frmINIT_PTY_INIT_PTY_C_ID_ISSR;
            protected UDateItem frmINIT_PTY_INIT_PTY_P_BIRTH_DATE;
            protected UTextItem frmINIT_PTY_INIT_PTY_P_BIRTH_PRVC;
            protected UTextItem frmINIT_PTY_INIT_PTY_P_BIRTH_CITY;
            protected USelectItem frmINIT_PTY_INIT_PTY_P_BIRTH_CTRY;
            protected UTextItem frmINIT_PTY_INIT_PTY_P_ID;
            protected UTextItem frmINIT_PTY_INIT_PTY_P_ID_SCHE;
            protected USelectItem frmINIT_PTY_INIT_PTY_P_ID_SCHEX;
            protected UTextItem frmINIT_PTY_INIT_PTY_P_ID_ISSR;
            protected USelectItem frmINIT_PTY_INIT_PTY_RES_CTRY;
        protected UDynamicForm frmDBTR_AGT;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_BIC;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_CLR_SYS;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_CLR_SYS_MMBID;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_LEI;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_NAME;
            protected UTextAreaItem frmDBTR_AGT_DBTR_AGT_ADR_M;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_DEPT;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_SDEPT;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_STRT_NM;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_BLDG_NB;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_BLDG_NM;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_FLR;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_PST_BX;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_ROOM;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_PST_CD;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_TWN;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_TWN_LOC;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_DSTRCT;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_AREA;
            protected USelectItem frmDBTR_AGT_DBTR_AGT_ADR_CTRY;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE1;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE2;
            protected UTextItem frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE3;
        protected UDynamicForm frmPRE_AGT1;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_BIC;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_CLR_SYS;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_CLR_SYS_MMBID;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_LEI;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_NAME;
            protected UTextAreaItem frmPRE_AGT1_PRE_AGT1_ADR_M;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_DEPT;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_SDEPT;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_STRT_NM;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_BLDG_NB;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_BLDG_NM;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_FLR;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_PST_BX;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_ROOM;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_PST_CD;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_TWN;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_TWN_LOC;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_DSTRCT;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_AREA;
            protected USelectItem frmPRE_AGT1_PRE_AGT1_ADR_CTRY;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE1;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE2;
            protected UTextItem frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE3;
        protected UDynamicForm frmPRE_AGT2;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_BIC;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_CLR_SYS;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_CLR_SYS_MMBID;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_LEI;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_NAME;
            protected UTextAreaItem frmPRE_AGT2_PRE_AGT2_ADR_M;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_DEPT;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_SDEPT;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_STRT_NM;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_BLDG_NB;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_BLDG_NM;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_FLR;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_PST_BX;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_ROOM;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_PST_CD;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_TWN;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_TWN_LOC;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_DSTRCT;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_AREA;
            protected USelectItem frmPRE_AGT2_PRE_AGT2_ADR_CTRY;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE1;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE2;
            protected UTextItem frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE3;
        protected UDynamicForm frmPRE_AGT3;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_BIC;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_CLR_SYS;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_CLR_SYS_MMBID;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_LEI;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_NAME;
            protected UTextAreaItem frmPRE_AGT3_PRE_AGT3_ADR_M;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_DEPT;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_SDEPT;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_STRT_NM;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_BLDG_NB;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_BLDG_NM;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_FLR;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_PST_BX;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_ROOM;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_PST_CD;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_TWN;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_TWN_LOC;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_DSTRCT;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_AREA;
            protected USelectItem frmPRE_AGT3_PRE_AGT3_ADR_CTRY;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE1;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE2;
            protected UTextItem frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE3;
        protected UDynamicForm frmIM_AGT1;
            protected UTextItem frmIM_AGT1_IM_AGT1_BIC;
            protected UTextItem frmIM_AGT1_IM_AGT1_CLR_SYS;
            protected UTextItem frmIM_AGT1_IM_AGT1_CLR_SYS_MMBID;
            protected UTextItem frmIM_AGT1_IM_AGT1_LEI;
            protected UTextItem frmIM_AGT1_IM_AGT1_NAME;
            protected UTextAreaItem frmIM_AGT1_IM_AGT1_ADR_M;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_DEPT;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_SDEPT;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_STRT_NM;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_BLDG_NB;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_BLDG_NM;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_FLR;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_PST_BX;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_ROOM;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_PST_CD;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_TWN;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_TWN_LOC;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_DSTRCT;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_AREA;
            protected USelectItem frmIM_AGT1_IM_AGT1_ADR_CTRY;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_ADR_LINE1;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_ADR_LINE2;
            protected UTextItem frmIM_AGT1_IM_AGT1_ADR_ADR_LINE3;
        protected UDynamicForm frmIM_AGT2;
            protected UTextItem frmIM_AGT2_IM_AGT2_BIC;
            protected UTextItem frmIM_AGT2_IM_AGT2_CLR_SYS;
            protected UTextItem frmIM_AGT2_IM_AGT2_CLR_SYS_MMBID;
            protected UTextItem frmIM_AGT2_IM_AGT2_LEI;
            protected UTextItem frmIM_AGT2_IM_AGT2_NAME;
            protected UTextAreaItem frmIM_AGT2_IM_AGT2_ADR_M;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_DEPT;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_SDEPT;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_STRT_NM;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_BLDG_NB;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_BLDG_NM;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_FLR;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_PST_BX;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_ROOM;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_PST_CD;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_TWN;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_TWN_LOC;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_DSTRCT;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_AREA;
            protected USelectItem frmIM_AGT2_IM_AGT2_ADR_CTRY;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_ADR_LINE1;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_ADR_LINE2;
            protected UTextItem frmIM_AGT2_IM_AGT2_ADR_ADR_LINE3;
        protected UDynamicForm frmIM_AGT3;
            protected UTextItem frmIM_AGT3_IM_AGT3_BIC;
            protected UTextItem frmIM_AGT3_IM_AGT3_CLR_SYS;
            protected UTextItem frmIM_AGT3_IM_AGT3_CLR_SYS_MMBID;
            protected UTextItem frmIM_AGT3_IM_AGT3_LEI;
            protected UTextItem frmIM_AGT3_IM_AGT3_NAME;
            protected UTextAreaItem frmIM_AGT3_IM_AGT3_ADR_M;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_DEPT;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_SDEPT;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_STRT_NM;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_BLDG_NB;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_BLDG_NM;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_FLR;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_PST_BX;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_ROOM;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_PST_CD;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_TWN;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_TWN_LOC;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_DSTRCT;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_AREA;
            protected USelectItem frmIM_AGT3_IM_AGT3_ADR_CTRY;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_ADR_LINE1;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_ADR_LINE2;
            protected UTextItem frmIM_AGT3_IM_AGT3_ADR_ADR_LINE3;
        protected UDynamicForm frmCDTR_AGT;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_BIC;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_CLR_SYS;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_CLR_SYS_MMBID;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_LEI;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_NAME;
            protected UTextAreaItem frmCDTR_AGT_CDTR_AGT_ADR_M;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_DEPT;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_SDEPT;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_STRT_NM;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_BLDG_NB;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_BLDG_NM;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_FLR;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_PST_BX;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_ROOM;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_PST_CD;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_TWN;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_TWN_LOC;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_DSTRCT;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_AREA;
            protected USelectItem frmCDTR_AGT_CDTR_AGT_ADR_CTRY;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE1;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE2;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE3;
            protected UTextItem frmCDTR_AGT_CDTR_AGT_BR_ID;
        protected UDynamicForm frmCDTR_PTY;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_NAME;
            protected UTextAreaItem frmCDTR_PTY_CDTR_PTY_ADR_M;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_DEPT;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_SDEPT;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_STRT_NM;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_BLDG_NB;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_BLDG_NM;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_FLR;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_PST_BX;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_ROOM;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_PST_CD;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_TWN;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_TWN_LOC;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_DSTRCT;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_AREA;
            protected USelectItem frmCDTR_PTY_CDTR_PTY_ADR_CTRY;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE1;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE2;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE3;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_BIC;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_LEI;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_ID;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_ID_SCHE;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_ID_SCHEX;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_C_ID_ISSR;
            protected UDateItem frmCDTR_PTY_CDTR_PTY_P_BIRTH_DATE;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_P_BIRTH_PRVC;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_P_BIRTH_CITY;
            protected USelectItem frmCDTR_PTY_CDTR_PTY_P_BIRTH_CTRY;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_P_ID;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_P_ID_SCHE;
            protected USelectItem frmCDTR_PTY_CDTR_PTY_P_ID_SCHEX;
            protected UTextItem frmCDTR_PTY_CDTR_PTY_P_ID_ISSR;
            protected USelectItem frmCDTR_PTY_CDTR_PTY_RES_CTRY;
        protected UDynamicForm frmCDTR_PTYF;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_BIC;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_CLR_SYS;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_CLR_SYS_MMBID;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_LEI;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_NAME;
            protected UTextAreaItem frmCDTR_PTYF_CDTR_PTYF_ADR_M;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_DEPT;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_SDEPT;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_STRT_NM;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_BLDG_NB;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_BLDG_NM;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_FLR;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_PST_BX;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_ROOM;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_PST_CD;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_TWN;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_TWN_LOC;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_DSTRCT;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_AREA;
            protected USelectItem frmCDTR_PTYF_CDTR_PTYF_ADR_CTRY;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE1;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE2;
            protected UTextItem frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE3;
        protected UDynamicForm frmUCDTR;
            protected UTextItem frmUCDTR_UCDTR_NAME;
            protected UTextAreaItem frmUCDTR_UCDTR_ADR_M;
            protected UTextItem frmUCDTR_UCDTR_ADR_DEPT;
            protected UTextItem frmUCDTR_UCDTR_ADR_SDEPT;
            protected UTextItem frmUCDTR_UCDTR_ADR_STRT_NM;
            protected UTextItem frmUCDTR_UCDTR_ADR_BLDG_NB;
            protected UTextItem frmUCDTR_UCDTR_ADR_BLDG_NM;
            protected UTextItem frmUCDTR_UCDTR_ADR_FLR;
            protected UTextItem frmUCDTR_UCDTR_ADR_PST_BX;
            protected UTextItem frmUCDTR_UCDTR_ADR_ROOM;
            protected UTextItem frmUCDTR_UCDTR_ADR_PST_CD;
            protected UTextItem frmUCDTR_UCDTR_ADR_TWN;
            protected UTextItem frmUCDTR_UCDTR_ADR_TWN_LOC;
            protected UTextItem frmUCDTR_UCDTR_ADR_DSTRCT;
            protected UTextItem frmUCDTR_UCDTR_ADR_AREA;
            protected USelectItem frmUCDTR_UCDTR_ADR_CTRY;
            protected UTextItem frmUCDTR_UCDTR_C_BIC;
            protected UTextItem frmUCDTR_UCDTR_C_LEI;
            protected UTextItem frmUCDTR_UCDTR_C_ID;
            protected UTextItem frmUCDTR_UCDTR_C_ID_SCHE;
            protected UTextItem frmUCDTR_UCDTR_C_ID_SCHEX;
            protected UTextItem frmUCDTR_UCDTR_C_ID_ISSR;
            protected UDateItem frmUCDTR_UCDTR_P_BIRTH_DATE;
            protected UTextItem frmUCDTR_UCDTR_P_BIRTH_PRVC;
            protected UTextItem frmUCDTR_UCDTR_P_BIRTH_CITY;
            protected USelectItem frmUCDTR_UCDTR_P_BIRTH_CTRY;
            protected UTextItem frmUCDTR_UCDTR_P_ID;
            protected UTextItem frmUCDTR_UCDTR_P_ID_SCHE;
            protected USelectItem frmUCDTR_UCDTR_P_ID_SCHEX;
            protected UTextItem frmUCDTR_UCDTR_P_ID_ISSR;
            protected USelectItem frmUCDTR_UCDTR_RES_CTRY;
        protected UDynamicForm frmRTR_ORGTR;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_NAME;
            protected UTextAreaItem frmRTR_ORGTR_RTR_ORGTR_ADR_M;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_DEPT;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_SDEPT;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_STRT_NM;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_BLDG_NB;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_BLDG_NM;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_FLR;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_PST_BX;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_ROOM;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_PST_CD;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_TWN;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_TWN_LOC;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_DSTRCT;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_AREA;
            protected USelectItem frmRTR_ORGTR_RTR_ORGTR_ADR_CTRY;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE1;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE2;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE3;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_BIC;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_LEI;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_ID;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_ID_SCHE;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_ID_SCHEX;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_C_ID_ISSR;
            protected UDateItem frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_DATE;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_PRVC;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_CITY;
            protected USelectItem frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_CTRY;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_P_ID;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_P_ID_SCHE;
            protected USelectItem frmRTR_ORGTR_RTR_ORGTR_P_ID_SCHEX;
            protected UTextItem frmRTR_ORGTR_RTR_ORGTR_P_ID_ISSR;
            protected USelectItem frmRTR_ORGTR_RTR_ORGTR_RES_CTRY;
        protected UDynamicForm frmJYZTXX;
            protected UTextItem frmJYZTXX_TXN_SEQ_NO;
            protected UTextItem frmJYZTXX_MADE_USER;
            protected UTextItem frmJYZTXX_MADE_TIME;
            protected USelectItem frmJYZTXX_PBOC_STATUS;
            protected USelectItem frmJYZTXX_TXN_STATUS;
            protected USelectItem frmJYZTXX_COMM_STATUS;
            protected UTextAreaItem frmJYZTXX_BIZ_PROC_INFO;
            protected UTextAreaItem frmJYZTXX_BIZ_CNCL_INFO;
        protected UDynamicForm frmJJXX;
            protected UTextAreaItem frmJJXX_BIZ_REJ_INFO;
        protected UDynamicForm frmCHRG_DTL;
            protected UMoneyItem frmCHRG_DTL_CHRG_AMT;
            protected USelectItem frmCHRG_DTL_CHRG_AMT_CURCD;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_BIC;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_CLR_SYS;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_CLR_SYS_MMBID;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_LEI;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_NAME;
            protected UTextAreaItem frmCHRG_DTL_CHRG_AGT_ADR_M;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_DEPT;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_SDEPT;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_STRT_NM;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_BLDG_NB;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_BLDG_NM;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_FLR;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_PST_BX;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_ROOM;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_PST_CD;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_TWN;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_TWN_LOC;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_DSTRCT;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_AREA;
            protected USelectItem frmCHRG_DTL_CHRG_AGT_ADR_CTRY;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE1;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE2;
            protected UTextItem frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE3;


    // Button
    // protected UButton BTN_INQ;
        protected UButton BTN_INQ;
        protected UButton BTN_RESET;
        protected UButton BTN_SUB_OK;
        protected UButton BTN_SUB_REJ;
        protected UButton BTN_SUB_CLOSE;
        protected UButton BTN_CHRG_DTL_CLOSE;

    // Table
    // protected UTable resultTb;
    // protected UNavigateBar nvresultTb;
        protected UTable resultTb;
        protected UNavigateBar nvresultTb;
        protected UTable tbCHRG;
        protected UNavigateBar nvtbCHRG;

    // Subwindow
    // protected UWindow detailSw1;
        protected UWindow detailSw;
        protected UWindow chrgSubWin;

    //默认
    @Override
    protected void afterInitDatasets() {
        super.afterInitDatasets();
    }

    @Override
    protected PageViewConfig initConfig() {
        PageViewConfig config = super.initConfig();
        BaseConfig render = config.getRenderConfig();
        super.afterInitControls();


        // datasets init begin
        BaseConfig dataset = config.getDatasetsConfig();
        // dataset queryDs
        // dataset.put("queryDs", sub_ds_queryDs());
        dataset.put("resultDs", sub_ds_resultDs());
        dataset.put("chrgDs", sub_ds_chrgDs());
        dataset.put("queryDs", sub_ds_queryDs());
        dataset.put("inputDs", sub_ds_inputDs());
        dataset.put("chrgDtlDs", sub_ds_chrgDtlDs());
        // datasets init end


        // commands init begin
        BaseConfig command = config.getCommandsConfig();
        // command BTN_INQ_Cmd
        // command.put("BTN_INQ_Cmd", sub_cmd_BTN_INQ_Cmd());
        command.put("BTN_INQ_Cmd", sub_cmd_BTN_INQ_Cmd());
        command.put("SUBWINDOW_Cmd", sub_cmd_SUBWINDOW_Cmd());
        command.put("SUBWINDOW_Cmd2", sub_cmd_SUBWINDOW_Cmd2());
        command.put("BTN_SUB_OK_Cmd", sub_cmd_BTN_SUB_OK_Cmd());
        command.put("BTN_SUB_REJ_Cmd", sub_cmd_BTN_SUB_REJ_Cmd());
        // commands init end


        // renders init begin

        // render for main window
        BaseConfig _renderLayer = new BaseConfig();
        _renderLayer.setXmlTag("Layout");
        _renderLayer.put("id", "renderLayer");
        _renderLayer.put("fragmentId", "");
        _renderLayer.put("type", "VFlow");
        _renderLayer.put("row", "");
        _renderLayer.put("column", "");
        _renderLayer.put("labelAlign", "left");
        _renderLayer.put("componentAlignment", "Top_Center");
        _renderLayer.put("margin", "false");
        _renderLayer.put("spacing", "false");
        _renderLayer.put("columnExpandRatio", "");
        _renderLayer.put("width", "");
        _renderLayer.put("height", "");
        _renderLayer.put("enable", "true");
        _renderLayer.put("readOnly", "false");
        _renderLayer.put("visible", "true");
        List<BaseConfig> _renderLayerList = new ArrayList<BaseConfig>();
        _renderLayer.put("_renderLayerList",_renderLayerList);

   //        BaseConfig _frmCXTJ = sub_form_frmCXTJ();
        //        _renderLayerList.add(_frmCXTJ);
            BaseConfig _frmCXTJ = sub_form_frmCXTJ();
            _renderLayerList.add(_frmCXTJ);




            BaseConfig _btnGroupQRY = new BaseConfig();
            _btnGroupQRY.setXmlTag("Layout");
            _btnGroupQRY.put("id", "btnGroup");
            _btnGroupQRY.put("type", "HFlow");
            _btnGroupQRY.put("row", "");
            _btnGroupQRY.put("column", "");
            _btnGroupQRY.put("labelAlign", "left");
            _btnGroupQRY.put("componentAlignment", "Top_Left");
            _btnGroupQRY.put("margin", "true");
            _btnGroupQRY.put("defaultLayoutAlign", "right");
            _btnGroupQRY.put("spacing", "true");
            _btnGroupQRY.put("columnExpandRatio", "");
            _btnGroupQRY.put("width", "");
            _btnGroupQRY.put("height", "");
            _btnGroupQRY.put("enable", "true");
            _btnGroupQRY.put("readOnly", "false");
            _btnGroupQRY.put("visible", "true");
            List<BaseConfig> _btnGroupQRYList = new ArrayList<BaseConfig>();
            _btnGroupQRY.put("_btnGroupQRYList",_btnGroupQRYList);
                BaseConfig _BTN_INQ = new BaseConfig();
                _BTN_INQ.setXmlTag("Button");
                _BTN_INQ.put("id", "BTN_INQ");
                _BTN_INQ.put("type", "Base");
                _BTN_INQ.put("title", "查询");
                _BTN_INQ.put("command", "");
                _BTN_INQ.put("width", "");
                _BTN_INQ.put("height", "");
                _BTN_INQ.put("columnStart", "");
                _BTN_INQ.put("columnEnd", "");
                _BTN_INQ.put("rowStart", "");
                _BTN_INQ.put("rowEnd", "");
                _BTN_INQ.put("enable", "true");
                _BTN_INQ.put("readOnly", "false");
                _BTN_INQ.put("visible", "true");
                _btnGroupQRYList.add(_BTN_INQ);
                BaseConfig _BTN_RESET = new BaseConfig();
                _BTN_RESET.setXmlTag("Button");
                _BTN_RESET.put("id", "BTN_RESET");
                _BTN_RESET.put("type", "Base");
                _BTN_RESET.put("title", "重置");
                _BTN_RESET.put("command", "");
                _BTN_RESET.put("width", "");
                _BTN_RESET.put("height", "");
                _BTN_RESET.put("columnStart", "");
                _BTN_RESET.put("columnEnd", "");
                _BTN_RESET.put("rowStart", "");
                _BTN_RESET.put("rowEnd", "");
                _BTN_RESET.put("enable", "true");
                _BTN_RESET.put("readOnly", "false");
                _BTN_RESET.put("visible", "true");
                _btnGroupQRYList.add(_BTN_RESET);
            _renderLayerList.add(_btnGroupQRY);




            BaseConfig _resultTb = sub_table_resultTb();
                    _renderLayerList.add(_resultTb);
                    BaseConfig _nvresultTb = new BaseConfig();
                    _nvresultTb.setXmlTag("Navigation");
                    _nvresultTb.put("id", "nvresultTb");
                    _nvresultTb.put("fragmentId", "");
                    _nvresultTb.put("type", "Pagebar");
                    _nvresultTb.put("dataset", "resultDs");
                    _nvresultTb.put("showPagesize", "");
                    _nvresultTb.put("showFirstAndLast", "");
                    _nvresultTb.put("showRefresh", "");
                    _nvresultTb.put("showDetail", "");
                    _nvresultTb.put("showTotalCount", "");
                    _nvresultTb.put("enable", "true");
                    _nvresultTb.put("readOnly", "false");
                    _nvresultTb.put("visible", "true");
                    _renderLayerList.add(_nvresultTb);

        render.put("_renderLayer", _renderLayer);

            BaseConfig _detailSw = new BaseConfig();
                    _detailSw.setXmlTag("Window");
                    _detailSw.put("id", "detailSw");
                    _detailSw.put("fragmentId", "");
                    _detailSw.put("type", "Sub");
                    _detailSw.put("title", "退汇业务审核");
                    _detailSw.put("closeable", "true");
                    _detailSw.put("draggable", "false");
                    _detailSw.put("resizeable", "true");
                    _detailSw.put("shortcut", "");
                    _detailSw.put("modal", "true");
                    _detailSw.put("center", "");
                    _detailSw.put("positionX", "220");
                    _detailSw.put("positionY", "30");
                    _detailSw.put("border", "1");
                    _detailSw.put("width", "65%");
                    _detailSw.put("height", "85%");
                    _detailSw.put("enable", "true");
                    _detailSw.put("readOnly", "false");
                    _detailSw.put("visible", "true");
                    List<BaseConfig> _detailSwList = new ArrayList<BaseConfig>();
                    _detailSw.put("_detailSwList",_detailSwList);
                    BaseConfig _LtdetailSw = new BaseConfig();
                    _LtdetailSw.setXmlTag("Layout");
                    _LtdetailSw.put("id", "LtdetailSw");
                    _LtdetailSw.put("fragmentId", "");
                    _LtdetailSw.put("type", "VFlow");
                    _LtdetailSw.put("row", "");
                    _LtdetailSw.put("column", "");
                    _LtdetailSw.put("labelAlign", "top");
                    _LtdetailSw.put("componentAlignment", "Top_Left");
                    _LtdetailSw.put("margin", "true");
                    _LtdetailSw.put("spacing", "true");
                    _LtdetailSw.put("columnExpandRatio", "");
                    _LtdetailSw.put("width", "100%");
                    _LtdetailSw.put("height", "");
                    _LtdetailSw.put("enable", "true");
                    _LtdetailSw.put("readOnly", "false");
                    _LtdetailSw.put("visible", "true");
                    List<BaseConfig> _LtdetailSwList = new ArrayList<BaseConfig>();
                    _LtdetailSw.put("_LtdetailSwList",_LtdetailSwList);

                BaseConfig _frmHEAD = sub_form_frmHEAD();
                _LtdetailSwList.add(_frmHEAD);


                BaseConfig _frmSTAC = sub_form_frmSTAC();
                _LtdetailSwList.add(_frmSTAC);


                BaseConfig _frmSCENARIO = sub_form_frmSCENARIO();
                _LtdetailSwList.add(_frmSCENARIO);


                BaseConfig _frmORITXN = sub_form_frmORITXN();
                _LtdetailSwList.add(_frmORITXN);


                BaseConfig _frmRTR = sub_form_frmRTR();
                _LtdetailSwList.add(_frmRTR);




                BaseConfig _tbCHRG = sub_table_tbCHRG();
                _LtdetailSwList.add(_tbCHRG);
                        BaseConfig _nvtbCHRG = new BaseConfig();
                        _nvtbCHRG.setXmlTag("Navigation");
                        _nvtbCHRG.put("id", "nvtbCHRG");
                        _nvtbCHRG.put("fragmentId", "");
                        _nvtbCHRG.put("type", "Pagebar");
                        _nvtbCHRG.put("dataset", "chrgDs");
                        _nvtbCHRG.put("showPagesize", "");
                        _nvtbCHRG.put("showFirstAndLast", "");
                        _nvtbCHRG.put("showRefresh", "");
                        _nvtbCHRG.put("showDetail", "");
                        _nvtbCHRG.put("showTotalCount", "");
                        _nvtbCHRG.put("enable", "true");
                        _nvtbCHRG.put("readOnly", "false");
                        _nvtbCHRG.put("visible", "true");
                 _LtdetailSwList.add(_nvtbCHRG);
                BaseConfig _frmINSTG = sub_form_frmINSTG();
                _LtdetailSwList.add(_frmINSTG);


                BaseConfig _frmINSTD = sub_form_frmINSTD();
                _LtdetailSwList.add(_frmINSTD);


                BaseConfig _frmUDBTR = sub_form_frmUDBTR();
                _LtdetailSwList.add(_frmUDBTR);


                BaseConfig _frmDBTR_PTY = sub_form_frmDBTR_PTY();
                _LtdetailSwList.add(_frmDBTR_PTY);


                BaseConfig _frmDBTR_PTYF = sub_form_frmDBTR_PTYF();
                _LtdetailSwList.add(_frmDBTR_PTYF);


                BaseConfig _frmINIT_PTY = sub_form_frmINIT_PTY();
                _LtdetailSwList.add(_frmINIT_PTY);


                BaseConfig _frmDBTR_AGT = sub_form_frmDBTR_AGT();
                _LtdetailSwList.add(_frmDBTR_AGT);


                BaseConfig _frmPRE_AGT1 = sub_form_frmPRE_AGT1();
                _LtdetailSwList.add(_frmPRE_AGT1);


                BaseConfig _frmPRE_AGT2 = sub_form_frmPRE_AGT2();
                _LtdetailSwList.add(_frmPRE_AGT2);


                BaseConfig _frmPRE_AGT3 = sub_form_frmPRE_AGT3();
                _LtdetailSwList.add(_frmPRE_AGT3);


                BaseConfig _frmIM_AGT1 = sub_form_frmIM_AGT1();
                _LtdetailSwList.add(_frmIM_AGT1);


                BaseConfig _frmIM_AGT2 = sub_form_frmIM_AGT2();
                _LtdetailSwList.add(_frmIM_AGT2);


                BaseConfig _frmIM_AGT3 = sub_form_frmIM_AGT3();
                _LtdetailSwList.add(_frmIM_AGT3);


                BaseConfig _frmCDTR_AGT = sub_form_frmCDTR_AGT();
                _LtdetailSwList.add(_frmCDTR_AGT);


                BaseConfig _frmCDTR_PTY = sub_form_frmCDTR_PTY();
                _LtdetailSwList.add(_frmCDTR_PTY);


                BaseConfig _frmCDTR_PTYF = sub_form_frmCDTR_PTYF();
                _LtdetailSwList.add(_frmCDTR_PTYF);


                BaseConfig _frmUCDTR = sub_form_frmUCDTR();
                _LtdetailSwList.add(_frmUCDTR);


                BaseConfig _frmRTR_ORGTR = sub_form_frmRTR_ORGTR();
                _LtdetailSwList.add(_frmRTR_ORGTR);


                BaseConfig _frmJYZTXX = sub_form_frmJYZTXX();
                _LtdetailSwList.add(_frmJYZTXX);


                BaseConfig _frmJJXX = sub_form_frmJJXX();
                _LtdetailSwList.add(_frmJJXX);



                BaseConfig _btnGroupBOTTOM = new BaseConfig();
                _btnGroupBOTTOM.setXmlTag("Layout");
                _btnGroupBOTTOM.put("id", "btnGroup");
                _btnGroupBOTTOM.put("type", "HFlow");
                _btnGroupBOTTOM.put("row", "");
                _btnGroupBOTTOM.put("column", "");
                _btnGroupBOTTOM.put("labelAlign", "left");
                _btnGroupBOTTOM.put("componentAlignment", "Top_Left");
                _btnGroupBOTTOM.put("margin", "true");
                _btnGroupBOTTOM.put("defaultLayoutAlign", "right");
                _btnGroupBOTTOM.put("spacing", "true");
                _btnGroupBOTTOM.put("columnExpandRatio", "");
                _btnGroupBOTTOM.put("width", "");
                _btnGroupBOTTOM.put("height", "");
                _btnGroupBOTTOM.put("enable", "true");
                _btnGroupBOTTOM.put("readOnly", "false");
                _btnGroupBOTTOM.put("visible", "true");
                List<BaseConfig> _btnGroupBOTTOMList = new ArrayList<BaseConfig>();
                _btnGroupBOTTOM.put("_btnGroupBOTTOMList",_btnGroupBOTTOMList);
                    BaseConfig _BTN_SUB_OK = new BaseConfig();
                    _BTN_SUB_OK.setXmlTag("Button");
                    _BTN_SUB_OK.put("id", "BTN_SUB_OK");
                    _BTN_SUB_OK.put("type", "Base");
                    _BTN_SUB_OK.put("title", "确认");
                    _BTN_SUB_OK.put("command", "");
                    _BTN_SUB_OK.put("width", "");
                    _BTN_SUB_OK.put("height", "");
                    _BTN_SUB_OK.put("columnStart", "");
                    _BTN_SUB_OK.put("columnEnd", "");
                    _BTN_SUB_OK.put("rowStart", "");
                    _BTN_SUB_OK.put("rowEnd", "");
                    _BTN_SUB_OK.put("enable", "true");
                    _BTN_SUB_OK.put("readOnly", "false");
                    _BTN_SUB_OK.put("visible", "true");
                    _btnGroupBOTTOMList.add(_BTN_SUB_OK);
                    BaseConfig _BTN_SUB_REJ = new BaseConfig();
                    _BTN_SUB_REJ.setXmlTag("Button");
                    _BTN_SUB_REJ.put("id", "BTN_SUB_REJ");
                    _BTN_SUB_REJ.put("type", "Base");
                    _BTN_SUB_REJ.put("title", "拒绝");
                    _BTN_SUB_REJ.put("command", "");
                    _BTN_SUB_REJ.put("width", "");
                    _BTN_SUB_REJ.put("height", "");
                    _BTN_SUB_REJ.put("columnStart", "");
                    _BTN_SUB_REJ.put("columnEnd", "");
                    _BTN_SUB_REJ.put("rowStart", "");
                    _BTN_SUB_REJ.put("rowEnd", "");
                    _BTN_SUB_REJ.put("enable", "true");
                    _BTN_SUB_REJ.put("readOnly", "false");
                    _BTN_SUB_REJ.put("visible", "true");
                    _btnGroupBOTTOMList.add(_BTN_SUB_REJ);
                    BaseConfig _BTN_SUB_CLOSE = new BaseConfig();
                    _BTN_SUB_CLOSE.setXmlTag("Button");
                    _BTN_SUB_CLOSE.put("id", "BTN_SUB_CLOSE");
                    _BTN_SUB_CLOSE.put("type", "Base");
                    _BTN_SUB_CLOSE.put("title", "关闭");
                    _BTN_SUB_CLOSE.put("command", "");
                    _BTN_SUB_CLOSE.put("width", "");
                    _BTN_SUB_CLOSE.put("height", "");
                    _BTN_SUB_CLOSE.put("columnStart", "");
                    _BTN_SUB_CLOSE.put("columnEnd", "");
                    _BTN_SUB_CLOSE.put("rowStart", "");
                    _BTN_SUB_CLOSE.put("rowEnd", "");
                    _BTN_SUB_CLOSE.put("enable", "true");
                    _BTN_SUB_CLOSE.put("readOnly", "false");
                    _BTN_SUB_CLOSE.put("visible", "true");
                    _btnGroupBOTTOMList.add(_BTN_SUB_CLOSE);
                _LtdetailSwList.add(_btnGroupBOTTOM);


            _detailSwList.add(_LtdetailSw);
            render.put("_detailSw", _detailSw);
            BaseConfig _chrgSubWin = new BaseConfig();
                    _chrgSubWin.setXmlTag("Window");
                    _chrgSubWin.put("id", "chrgSubWin");
                    _chrgSubWin.put("fragmentId", "");
                    _chrgSubWin.put("type", "Sub");
                    _chrgSubWin.put("title", "退汇费用");
                    _chrgSubWin.put("closeable", "true");
                    _chrgSubWin.put("draggable", "false");
                    _chrgSubWin.put("resizeable", "true");
                    _chrgSubWin.put("shortcut", "");
                    _chrgSubWin.put("modal", "true");
                    _chrgSubWin.put("center", "");
                    _chrgSubWin.put("positionX", "220");
                    _chrgSubWin.put("positionY", "30");
                    _chrgSubWin.put("border", "1");
                    _chrgSubWin.put("width", "65%");
                    _chrgSubWin.put("height", "85%");
                    _chrgSubWin.put("enable", "true");
                    _chrgSubWin.put("readOnly", "false");
                    _chrgSubWin.put("visible", "true");
                    List<BaseConfig> _chrgSubWinList = new ArrayList<BaseConfig>();
                    _chrgSubWin.put("_chrgSubWinList",_chrgSubWinList);
                    BaseConfig _LtchrgSubWin = new BaseConfig();
                    _LtchrgSubWin.setXmlTag("Layout");
                    _LtchrgSubWin.put("id", "LtchrgSubWin");
                    _LtchrgSubWin.put("fragmentId", "");
                    _LtchrgSubWin.put("type", "VFlow");
                    _LtchrgSubWin.put("row", "");
                    _LtchrgSubWin.put("column", "");
                    _LtchrgSubWin.put("labelAlign", "top");
                    _LtchrgSubWin.put("componentAlignment", "Top_Left");
                    _LtchrgSubWin.put("margin", "true");
                    _LtchrgSubWin.put("spacing", "true");
                    _LtchrgSubWin.put("columnExpandRatio", "");
                    _LtchrgSubWin.put("width", "100%");
                    _LtchrgSubWin.put("height", "");
                    _LtchrgSubWin.put("enable", "true");
                    _LtchrgSubWin.put("readOnly", "false");
                    _LtchrgSubWin.put("visible", "true");
                    List<BaseConfig> _LtchrgSubWinList = new ArrayList<BaseConfig>();
                    _LtchrgSubWin.put("_LtchrgSubWinList",_LtchrgSubWinList);

                BaseConfig _frmCHRG_DTL = sub_form_frmCHRG_DTL();
                _LtchrgSubWinList.add(_frmCHRG_DTL);



                BaseConfig _btnGroupCHRGDTL = new BaseConfig();
                _btnGroupCHRGDTL.setXmlTag("Layout");
                _btnGroupCHRGDTL.put("id", "btnGroup");
                _btnGroupCHRGDTL.put("type", "HFlow");
                _btnGroupCHRGDTL.put("row", "");
                _btnGroupCHRGDTL.put("column", "");
                _btnGroupCHRGDTL.put("labelAlign", "left");
                _btnGroupCHRGDTL.put("componentAlignment", "Top_Left");
                _btnGroupCHRGDTL.put("margin", "true");
                _btnGroupCHRGDTL.put("defaultLayoutAlign", "right");
                _btnGroupCHRGDTL.put("spacing", "true");
                _btnGroupCHRGDTL.put("columnExpandRatio", "");
                _btnGroupCHRGDTL.put("width", "");
                _btnGroupCHRGDTL.put("height", "");
                _btnGroupCHRGDTL.put("enable", "true");
                _btnGroupCHRGDTL.put("readOnly", "false");
                _btnGroupCHRGDTL.put("visible", "true");
                List<BaseConfig> _btnGroupCHRGDTLList = new ArrayList<BaseConfig>();
                _btnGroupCHRGDTL.put("_btnGroupCHRGDTLList",_btnGroupCHRGDTLList);
                    BaseConfig _BTN_CHRG_DTL_CLOSE = new BaseConfig();
                    _BTN_CHRG_DTL_CLOSE.setXmlTag("Button");
                    _BTN_CHRG_DTL_CLOSE.put("id", "BTN_CHRG_DTL_CLOSE");
                    _BTN_CHRG_DTL_CLOSE.put("type", "Base");
                    _BTN_CHRG_DTL_CLOSE.put("title", "关闭");
                    _BTN_CHRG_DTL_CLOSE.put("command", "");
                    _BTN_CHRG_DTL_CLOSE.put("width", "");
                    _BTN_CHRG_DTL_CLOSE.put("height", "");
                    _BTN_CHRG_DTL_CLOSE.put("columnStart", "");
                    _BTN_CHRG_DTL_CLOSE.put("columnEnd", "");
                    _BTN_CHRG_DTL_CLOSE.put("rowStart", "");
                    _BTN_CHRG_DTL_CLOSE.put("rowEnd", "");
                    _BTN_CHRG_DTL_CLOSE.put("enable", "true");
                    _BTN_CHRG_DTL_CLOSE.put("readOnly", "false");
                    _BTN_CHRG_DTL_CLOSE.put("visible", "true");
                    _btnGroupCHRGDTLList.add(_BTN_CHRG_DTL_CLOSE);
                _LtchrgSubWinList.add(_btnGroupCHRGDTL);


            _chrgSubWinList.add(_LtchrgSubWin);
            render.put("_chrgSubWin", _chrgSubWin);
        //renders init end

        return config;
    }


    // Dataset define
     private BaseConfig sub_ds_resultDs(){
             BaseConfig resultDs = new BaseConfig();
             List<BaseConfig> fieldsresultDs = new ArrayList<BaseConfig>();

            //inputDsFieldAttrList
            List<DsFieldAttr> list = new ArrayList<>();
            list.add(new DsFieldAttr( "CHK_FLAG","Base","处理状态","string","512","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_SEQ_NO","Base","交易流水号","string","512","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "AMT","Base","退汇金额","money","512","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_TYPE","Base","原报文类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_ID","Base","原报文标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OP_ST_BRNO","Base","对手直接参与者行号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OP_ST_BRNAME","Base","对手直接参与者行名","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_SEQ_NO","Base","","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "SEQ_NO","Base","","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "MSG_NO","Base","","string","3","0","","","","false","false","right"));

            for (DsFieldAttr attr : list) {
                BaseConfig fieldBaseConfig = new BaseConfig();
                fieldBaseConfig.put("name", attr.getName());
                fieldBaseConfig.put("type", attr.getType());
                fieldBaseConfig.put("caption", attr.getCaption());
                fieldBaseConfig.put("dataType", attr.getDataType());
                fieldBaseConfig.put("precision", attr.getPrecision());
                fieldBaseConfig.put("scale", attr.getScale());
                fieldBaseConfig.put("defaultValue", attr.getDefaultValue());
                fieldBaseConfig.put("format", attr.getFormat());
                fieldBaseConfig.put("dropdown", attr.getDropdown());
                fieldBaseConfig.put("nullable", attr.getNullable());
                fieldBaseConfig.put("readOnly", attr.getReadOnly());
                fieldBaseConfig.put("msgAlign", attr.getMsgAlign());
                fieldsresultDs .add(fieldBaseConfig);
           }
             resultDs.put("fields", fieldsresultDs);
             return resultDs;
         }
     private BaseConfig sub_ds_chrgDs(){
             BaseConfig chrgDs = new BaseConfig();
             List<BaseConfig> fieldschrgDs = new ArrayList<BaseConfig>();

            //inputDsFieldAttrList
            List<DsFieldAttr> list = new ArrayList<>();
            list.add(new DsFieldAttr( "CHRG_AMT","Base","金额","money","18","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AMT_CURCD","Base","金额币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));

            for (DsFieldAttr attr : list) {
                BaseConfig fieldBaseConfig = new BaseConfig();
                fieldBaseConfig.put("name", attr.getName());
                fieldBaseConfig.put("type", attr.getType());
                fieldBaseConfig.put("caption", attr.getCaption());
                fieldBaseConfig.put("dataType", attr.getDataType());
                fieldBaseConfig.put("precision", attr.getPrecision());
                fieldBaseConfig.put("scale", attr.getScale());
                fieldBaseConfig.put("defaultValue", attr.getDefaultValue());
                fieldBaseConfig.put("format", attr.getFormat());
                fieldBaseConfig.put("dropdown", attr.getDropdown());
                fieldBaseConfig.put("nullable", attr.getNullable());
                fieldBaseConfig.put("readOnly", attr.getReadOnly());
                fieldBaseConfig.put("msgAlign", attr.getMsgAlign());
                fieldschrgDs .add(fieldBaseConfig);
           }
             chrgDs.put("fields", fieldschrgDs);
             return chrgDs;
         }
     private BaseConfig sub_ds_queryDs(){
             BaseConfig queryDs = new BaseConfig();
             List<BaseConfig> fieldsqueryDs = new ArrayList<BaseConfig>();

            //inputDsFieldAttrList
            List<DsFieldAttr> list = new ArrayList<>();
            list.add(new DsFieldAttr( "WORK_DATE","Base","工作日","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_SEQ_NO","Base","交易流水号","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "START_AMT","Base","金额[起]","money","","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "END_AMT","Base","金额[止]","money","","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_ID","Base","原报文标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "MADE_USER","Base","录入操作员","string","20","0","","","","false","false","right"));

            for (DsFieldAttr attr : list) {
                BaseConfig fieldBaseConfig = new BaseConfig();
                fieldBaseConfig.put("name", attr.getName());
                fieldBaseConfig.put("type", attr.getType());
                fieldBaseConfig.put("caption", attr.getCaption());
                fieldBaseConfig.put("dataType", attr.getDataType());
                fieldBaseConfig.put("precision", attr.getPrecision());
                fieldBaseConfig.put("scale", attr.getScale());
                fieldBaseConfig.put("defaultValue", attr.getDefaultValue());
                fieldBaseConfig.put("format", attr.getFormat());
                fieldBaseConfig.put("dropdown", attr.getDropdown());
                fieldBaseConfig.put("nullable", attr.getNullable());
                fieldBaseConfig.put("readOnly", attr.getReadOnly());
                fieldBaseConfig.put("msgAlign", attr.getMsgAlign());
                fieldsqueryDs .add(fieldBaseConfig);
           }
             queryDs.put("fields", fieldsqueryDs);
             return queryDs;
         }
     private BaseConfig sub_ds_inputDs(){
             BaseConfig inputDs = new BaseConfig();
             List<BaseConfig> fieldsinputDs = new ArrayList<BaseConfig>();

            //inputDsFieldAttrList
            List<DsFieldAttr> list = new ArrayList<>();
            list.add(new DsFieldAttr( "MSG_ID","Base","报文标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "MSG_SND_TIME","Base","报文发送时间","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_NUM","Base","交易笔数","string","15","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_METHOD","Base","结算方式","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CLR_SYS_REF","Base","清算系统参考号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_IBAN","Base","IBAN码","string","34","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_ID","Base","账号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_ID_SCHE","Base","身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_ID_SCHEX","Base","身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_ID_ISSR","Base","发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_TYPE","Base","类型代码","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_TYPEX","Base","用途说明","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_CCY","Base","币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_NAME","Base","名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_AKA_ID_TP","Base","账户别名类型（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_AKA_ID_TPX","Base","账户别名类型（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_AC_AKA_ID","Base","账户别名","string","2048","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RETURN_SCENARIO","Base","退汇场景类型","string","","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_ID","Base","原报文标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_TYPE","Base","原报文类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_MSG_SND_TIME","Base","原报文发送时间","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_INSTR_ID","Base","原报文参考号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_E2E_ID","Base","原端到端标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_TXN_ID","Base","原交易标识号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_UETR","Base","原UETR","string","36","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_CLR_SYS_REF","Base","原清算系统参考号","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_AMT","Base","原金额","money","18","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_AMT_CURCD","Base","原金额币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_ST_DATE","Base","原结算日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "OTXN_BIZ_CATE_CODE","Base","原业务种类编码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ID","Base","退汇唯一标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTRD_ST_AMT","Base","退汇结算金额","money","18","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTRD_ST_AMT_CURCD","Base","退汇结算金额币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_DATE","Base","银行间结算日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_PRIO","Base","业务优先级","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_DR_TIME","Base","借记时间","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ST_CR_TIME","Base","贷记时间","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTRD_INSTD_AMT","Base","发起退汇金额","money","18","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTRD_INSTD_AMT_CURCD","Base","发起退汇金额币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "FX_RATE","Base","汇率","string","12","10","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_BEAR","Base","费用承担方","string","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_REASON_CD","Base","退汇原因代码","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ADDTL_INF1","Base","附加信息1","string","105","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "ADDTL_INF2","Base","附加信息2","string","105","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTG_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTG_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTG_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTG_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTD_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTD_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTD_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INSTD_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_ID_SCHEX","Base","【组织】身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UDBTR_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTY_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_BIC","Base","【代理机构】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_CLR_SYS","Base","【代理机构】清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_CLR_SYS_MMBID","Base","【代理机构】参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_LEI","Base","【代理机构】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_NAME","Base","【代理机构】名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_M","Base","【代理机构】地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_DEPT","Base","【代理机构】地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_SDEPT","Base","【代理机构】地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_STRT_NM","Base","【代理机构】地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_BLDG_NB","Base","【代理机构】地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_BLDG_NM","Base","【代理机构】地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_FLR","Base","【代理机构】地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_PST_BX","Base","【代理机构】地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_ROOM","Base","【代理机构】地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_PST_CD","Base","【代理机构】地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_TWN","Base","【代理机构】地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_TWN_LOC","Base","【代理机构】地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_DSTRCT","Base","【代理机构】地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_AREA","Base","【代理机构】地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_CTRY","Base","【代理机构】地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_ADR_LINE1","Base","【代理机构】地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_ADR_LINE2","Base","【代理机构】地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_PTYF_ADR_ADR_LINE3","Base","【代理机构】地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_ID_SCHEX","Base","【组织】身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "INIT_PTY_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "DBTR_AGT_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT1_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT2_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PRE_AGT3_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT1_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT2_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "IM_AGT3_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_AGT_BR_ID","Base","分支机构标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_ID_SCHEX","Base","【组织】身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTY_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_BIC","Base","【代理机构】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_CLR_SYS","Base","【代理机构】清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_CLR_SYS_MMBID","Base","【代理机构】参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_LEI","Base","【代理机构】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_NAME","Base","【代理机构】名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_M","Base","【代理机构】地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_DEPT","Base","【代理机构】地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_SDEPT","Base","【代理机构】地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_STRT_NM","Base","【代理机构】地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_BLDG_NB","Base","【代理机构】地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_BLDG_NM","Base","【代理机构】地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_FLR","Base","【代理机构】地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_PST_BX","Base","【代理机构】地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_ROOM","Base","【代理机构】地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_PST_CD","Base","【代理机构】地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_TWN","Base","【代理机构】地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_TWN_LOC","Base","【代理机构】地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_DSTRCT","Base","【代理机构】地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_AREA","Base","【代理机构】地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_CTRY","Base","【代理机构】地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_ADR_LINE1","Base","【代理机构】地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_ADR_LINE2","Base","【代理机构】地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CDTR_PTYF_ADR_ADR_LINE3","Base","【代理机构】地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_ID_SCHEX","Base","【组织】身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "UCDTR_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_NAME","Base","个人或组织名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_BIC","Base","【组织】BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_LEI","Base","【组织】LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_ID","Base","【组织】CIPS ID或组织机构代码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_ID_SCHE","Base","【组织】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_ID_SCHEX","Base","【组织】身份标识方案名称（自定义内容）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_C_ID_ISSR","Base","【组织】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_BIRTH_DATE","Base","【个人】出生日期","date","32","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_BIRTH_PRVC","Base","【个人】出生省份","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_BIRTH_CITY","Base","【个人】出生城市","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_BIRTH_CTRY","Base","【个人】出生国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_ID","Base","【个人】证件号码","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_ID_SCHE","Base","【个人】身份标识方案名称（代码）","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_ID_SCHEX","Base","【个人】证件类型","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_P_ID_ISSR","Base","【个人】发码方","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "RTR_ORGTR_RES_CTRY","Base","居住国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_SEQ_NO","Base","交易流水号","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "MADE_USER","Base","录入操作员","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "MADE_TIME","Base","录入时间","string","21","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "PBOC_STATUS","Base","人行状态","string","4","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "TXN_STATUS","Base","业务状态","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "COMM_STATUS","Base","通讯状态","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "BIZ_PROC_INFO","Base","人行处理信息","string","100","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "BIZ_CNCL_INFO","Base","取消原因","string","100","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "BIZ_REJ_INFO","Base","拒绝原因","string","100","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "A_TXN_SEQ_NO","Base","","string","20","0","","","","false","false","right"));

            for (DsFieldAttr attr : list) {
                BaseConfig fieldBaseConfig = new BaseConfig();
                fieldBaseConfig.put("name", attr.getName());
                fieldBaseConfig.put("type", attr.getType());
                fieldBaseConfig.put("caption", attr.getCaption());
                fieldBaseConfig.put("dataType", attr.getDataType());
                fieldBaseConfig.put("precision", attr.getPrecision());
                fieldBaseConfig.put("scale", attr.getScale());
                fieldBaseConfig.put("defaultValue", attr.getDefaultValue());
                fieldBaseConfig.put("format", attr.getFormat());
                fieldBaseConfig.put("dropdown", attr.getDropdown());
                fieldBaseConfig.put("nullable", attr.getNullable());
                fieldBaseConfig.put("readOnly", attr.getReadOnly());
                fieldBaseConfig.put("msgAlign", attr.getMsgAlign());
                fieldsinputDs .add(fieldBaseConfig);
           }
             inputDs.put("fields", fieldsinputDs);
             return inputDs;
         }
     private BaseConfig sub_ds_chrgDtlDs(){
             BaseConfig chrgDtlDs = new BaseConfig();
             List<BaseConfig> fieldschrgDtlDs = new ArrayList<BaseConfig>();

            //inputDsFieldAttrList
            List<DsFieldAttr> list = new ArrayList<>();
            list.add(new DsFieldAttr( "CHRG_AMT","Base","金额","money","18","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AMT_CURCD","Base","金额币种","string","3","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_BIC","Base","BIC码","string","11","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_CLR_SYS","Base","清算系统标识（代码）","string","5","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_CLR_SYS_MMBID","Base","参与者身份标识","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_LEI","Base","LEI码","string","20","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_NAME","Base","名称","string","140","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_M","Base","地址","string","4000","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_DEPT","Base","地址_部门","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_SDEPT","Base","地址_分部","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_STRT_NM","Base","地址_街道名称","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_BLDG_NB","Base","地址_建筑编号","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_BLDG_NM","Base","地址_建筑名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_FLR","Base","地址_建筑楼层","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_PST_BX","Base","地址_邮政信箱","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ROOM","Base","地址_房间号","string","70","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_PST_CD","Base","地址_邮政编码","string","16","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_TWN","Base","地址_城镇名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_TWN_LOC","Base","地址_城镇地址","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_DSTRCT","Base","地址_地区名称","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_AREA","Base","地址_国家区域（区/洲）","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_CTRY","Base","地址_国家","string","2","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE1","Base","地址_自由格式地址1","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE2","Base","地址_自由格式地址2","string","35","0","","","","false","false","right"));
            list.add(new DsFieldAttr( "CHRG_AGT_ADR_ADR_LINE3","Base","地址_自由格式地址3","string","35","0","","","","false","false","right"));

            for (DsFieldAttr attr : list) {
                BaseConfig fieldBaseConfig = new BaseConfig();
                fieldBaseConfig.put("name", attr.getName());
                fieldBaseConfig.put("type", attr.getType());
                fieldBaseConfig.put("caption", attr.getCaption());
                fieldBaseConfig.put("dataType", attr.getDataType());
                fieldBaseConfig.put("precision", attr.getPrecision());
                fieldBaseConfig.put("scale", attr.getScale());
                fieldBaseConfig.put("defaultValue", attr.getDefaultValue());
                fieldBaseConfig.put("format", attr.getFormat());
                fieldBaseConfig.put("dropdown", attr.getDropdown());
                fieldBaseConfig.put("nullable", attr.getNullable());
                fieldBaseConfig.put("readOnly", attr.getReadOnly());
                fieldBaseConfig.put("msgAlign", attr.getMsgAlign());
                fieldschrgDtlDs .add(fieldBaseConfig);
           }
             chrgDtlDs.put("fields", fieldschrgDtlDs);
             return chrgDtlDs;
         }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private BaseConfig sub_cmd_BTN_INQ_Cmd(){
            BaseConfig BTN_INQ_Cmd = new BaseConfig();
            List<BaseConfig> fieldsBTN_INQ_Cmd = new ArrayList<BaseConfig>();
            BaseConfig BTN_INQ_Cmd_ = new BaseConfig();
            BTN_INQ_Cmd_.put("id", "BTN_INQ_CmdItem");
            BTN_INQ_Cmd_.put("type", "Pkg");
            BTN_INQ_Cmd_.put("bizType", "Query");
            BTN_INQ_Cmd_.put("ref", "");
            BTN_INQ_Cmd_.put("callbackFields", "");
            BTN_INQ_Cmd_.put("backfillFields", "");
            BTN_INQ_Cmd_.put("flushDataOnSuccess", "false");
            BTN_INQ_Cmd_.put("clearOriginalData", "false");
            BTN_INQ_Cmd_.put("bank", "bank");
            BTN_INQ_Cmd_.put("application", "canps2");
            BTN_INQ_Cmd_.put("pkgId", "GPAY_9999");
            BTN_INQ_Cmd_.put("datascope", "Current");
            BTN_INQ_Cmd_.put("sqlId", "");
            BTN_INQ_Cmd_.put("optType", "selectList");
            BTN_INQ_Cmd_.put("entityDataset", "resultDs");
            BTN_INQ_Cmd_.put("conditionDataset", "queryDs");
            BTN_INQ_Cmd_.put("validForm", "inputForm");
            BTN_INQ_Cmd_.put("templateTable", "");
            BTN_INQ_Cmd_.put("ifNoneResultNotification", "true");
            fieldsBTN_INQ_Cmd.add(BTN_INQ_Cmd_);
            BTN_INQ_Cmd.put("items", fieldsBTN_INQ_Cmd);
            return BTN_INQ_Cmd;
        }
    private BaseConfig sub_cmd_SUBWINDOW_Cmd(){
            BaseConfig SUBWINDOW_Cmd = new BaseConfig();
            List<BaseConfig> fieldsSUBWINDOW_Cmd = new ArrayList<BaseConfig>();
            BaseConfig SUBWINDOW_Cmd_ = new BaseConfig();
            SUBWINDOW_Cmd_.put("id", "SUBWINDOW_CmdItem");
            SUBWINDOW_Cmd_.put("type", "Pkg");
            SUBWINDOW_Cmd_.put("bizType", "Query");
            SUBWINDOW_Cmd_.put("ref", "");
            SUBWINDOW_Cmd_.put("callbackFields", "");
            SUBWINDOW_Cmd_.put("backfillFields", "");
            SUBWINDOW_Cmd_.put("flushDataOnSuccess", "false");
            SUBWINDOW_Cmd_.put("clearOriginalData", "false");
            SUBWINDOW_Cmd_.put("bank", "bank");
            SUBWINDOW_Cmd_.put("application", "canps2");
            SUBWINDOW_Cmd_.put("pkgId", "GPAY_9999");
            SUBWINDOW_Cmd_.put("datascope", "Current");
            SUBWINDOW_Cmd_.put("sqlId", "");
            SUBWINDOW_Cmd_.put("optType", "selectList");
            SUBWINDOW_Cmd_.put("entityDataset", "inputDs");
            SUBWINDOW_Cmd_.put("conditionDataset", "resultDs");
            SUBWINDOW_Cmd_.put("validForm", "inputForm");
            SUBWINDOW_Cmd_.put("templateTable", "");
            SUBWINDOW_Cmd_.put("ifNoneResultNotification", "true");
            fieldsSUBWINDOW_Cmd.add(SUBWINDOW_Cmd_);
            SUBWINDOW_Cmd.put("items", fieldsSUBWINDOW_Cmd);
            return SUBWINDOW_Cmd;
        }
    private BaseConfig sub_cmd_SUBWINDOW_Cmd2(){
            BaseConfig SUBWINDOW_Cmd2 = new BaseConfig();
            List<BaseConfig> fieldsSUBWINDOW_Cmd2 = new ArrayList<BaseConfig>();
            BaseConfig SUBWINDOW_Cmd2_ = new BaseConfig();
            SUBWINDOW_Cmd2_.put("id", "SUBWINDOW_Cmd2Item");
            SUBWINDOW_Cmd2_.put("type", "Pkg");
            SUBWINDOW_Cmd2_.put("bizType", "Query");
            SUBWINDOW_Cmd2_.put("ref", "");
            SUBWINDOW_Cmd2_.put("callbackFields", "");
            SUBWINDOW_Cmd2_.put("backfillFields", "");
            SUBWINDOW_Cmd2_.put("flushDataOnSuccess", "false");
            SUBWINDOW_Cmd2_.put("clearOriginalData", "false");
            SUBWINDOW_Cmd2_.put("bank", "bank");
            SUBWINDOW_Cmd2_.put("application", "canps2");
            SUBWINDOW_Cmd2_.put("pkgId", "GPAY_9999");
            SUBWINDOW_Cmd2_.put("datascope", "Current");
            SUBWINDOW_Cmd2_.put("sqlId", "");
            SUBWINDOW_Cmd2_.put("optType", "selectList");
            SUBWINDOW_Cmd2_.put("entityDataset", "chrgDs");
            SUBWINDOW_Cmd2_.put("conditionDataset", "resultDs");
            SUBWINDOW_Cmd2_.put("validForm", "inputForm");
            SUBWINDOW_Cmd2_.put("templateTable", "");
            SUBWINDOW_Cmd2_.put("ifNoneResultNotification", "true");
            fieldsSUBWINDOW_Cmd2.add(SUBWINDOW_Cmd2_);
            SUBWINDOW_Cmd2.put("items", fieldsSUBWINDOW_Cmd2);
            return SUBWINDOW_Cmd2;
        }
    private BaseConfig sub_cmd_BTN_SUB_OK_Cmd(){
            BaseConfig BTN_SUB_OK_Cmd = new BaseConfig();
            List<BaseConfig> fieldsBTN_SUB_OK_Cmd = new ArrayList<BaseConfig>();
            BaseConfig BTN_SUB_OK_Cmd_ = new BaseConfig();
            BTN_SUB_OK_Cmd_.put("id", "BTN_SUB_OK_CmdItem");
            BTN_SUB_OK_Cmd_.put("type", "Pkg");
            BTN_SUB_OK_Cmd_.put("bizType", "Commit");
            BTN_SUB_OK_Cmd_.put("ref", "");
            BTN_SUB_OK_Cmd_.put("callbackFields", "");
            BTN_SUB_OK_Cmd_.put("backfillFields", "");
            BTN_SUB_OK_Cmd_.put("flushDataOnSuccess", "false");
            BTN_SUB_OK_Cmd_.put("clearOriginalData", "false");
            BTN_SUB_OK_Cmd_.put("bank", "bank");
            BTN_SUB_OK_Cmd_.put("application", "canps2");
            BTN_SUB_OK_Cmd_.put("pkgId", "CIPS_APV");
            BTN_SUB_OK_Cmd_.put("datascope", "Current");
            BTN_SUB_OK_Cmd_.put("sqlId", "");
            BTN_SUB_OK_Cmd_.put("optType", "selectList");
            BTN_SUB_OK_Cmd_.put("entityDataset", "inputDs");
            BTN_SUB_OK_Cmd_.put("conditionDataset", "");
            BTN_SUB_OK_Cmd_.put("validForm", "inputForm");
            BTN_SUB_OK_Cmd_.put("templateTable", "");
            BTN_SUB_OK_Cmd_.put("ifNoneResultNotification", "true");
            fieldsBTN_SUB_OK_Cmd.add(BTN_SUB_OK_Cmd_);
            BTN_SUB_OK_Cmd.put("items", fieldsBTN_SUB_OK_Cmd);
            return BTN_SUB_OK_Cmd;
        }
    private BaseConfig sub_cmd_BTN_SUB_REJ_Cmd(){
            BaseConfig BTN_SUB_REJ_Cmd = new BaseConfig();
            List<BaseConfig> fieldsBTN_SUB_REJ_Cmd = new ArrayList<BaseConfig>();
            BaseConfig BTN_SUB_REJ_Cmd_ = new BaseConfig();
            BTN_SUB_REJ_Cmd_.put("id", "BTN_SUB_REJ_CmdItem");
            BTN_SUB_REJ_Cmd_.put("type", "Pkg");
            BTN_SUB_REJ_Cmd_.put("bizType", "Commit");
            BTN_SUB_REJ_Cmd_.put("ref", "");
            BTN_SUB_REJ_Cmd_.put("callbackFields", "");
            BTN_SUB_REJ_Cmd_.put("backfillFields", "");
            BTN_SUB_REJ_Cmd_.put("flushDataOnSuccess", "false");
            BTN_SUB_REJ_Cmd_.put("clearOriginalData", "false");
            BTN_SUB_REJ_Cmd_.put("bank", "bank");
            BTN_SUB_REJ_Cmd_.put("application", "canps2");
            BTN_SUB_REJ_Cmd_.put("pkgId", "CIPS_REJ");
            BTN_SUB_REJ_Cmd_.put("datascope", "Current");
            BTN_SUB_REJ_Cmd_.put("sqlId", "");
            BTN_SUB_REJ_Cmd_.put("optType", "selectList");
            BTN_SUB_REJ_Cmd_.put("entityDataset", "inputDs");
            BTN_SUB_REJ_Cmd_.put("conditionDataset", "");
            BTN_SUB_REJ_Cmd_.put("validForm", "inputForm");
            BTN_SUB_REJ_Cmd_.put("templateTable", "");
            BTN_SUB_REJ_Cmd_.put("ifNoneResultNotification", "true");
            fieldsBTN_SUB_REJ_Cmd.add(BTN_SUB_REJ_Cmd_);
            BTN_SUB_REJ_Cmd.put("items", fieldsBTN_SUB_REJ_Cmd);
            return BTN_SUB_REJ_Cmd;
        }


        // Form

         private BaseConfig sub_form_frmCXTJ() {
                BaseConfig _frmCXTJ = new BaseConfig();
                _frmCXTJ.setXmlTag("Form");
                _frmCXTJ.put("id", "frmCXTJ");
                _frmCXTJ.put("type", "Auto");
                _frmCXTJ.put("title", "查询条件");
                _frmCXTJ.put("dataset", "queryDs");
                _frmCXTJ.put("labelAlign", "left");
                _frmCXTJ.put("width", "100%");
                _frmCXTJ.put("height", "");
                _frmCXTJ.put("enable", "true");
                _frmCXTJ.put("readOnly", "false");
                _frmCXTJ.put("visible", "true");
                _frmCXTJ.put("numCols", "4");

                List<BaseConfig> _frmCXTJItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "WORK_DATE","工作日","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "TXN_SEQ_NO","交易流水号","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "START_AMT","金额[起]","","","Money","true","false","false"));
                    list.add(new FormFieldAttr( "END_AMT","金额[止]","","","Money","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_MSG_ID","原报文标识号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "MADE_USER","录入操作员","","20","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmCXTJ_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "queryDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmCXTJItemList.add(formFieldBaseConfig);
                    }


                _frmCXTJ.put("formItemList",_frmCXTJItemList);
                List<BaseConfig> _lfrmCXTJ = new ArrayList<BaseConfig>();
                _lfrmCXTJ.add(_frmCXTJ);
                return _frmCXTJ;
            }

         private BaseConfig sub_form_frmHEAD() {
                BaseConfig _frmHEAD = new BaseConfig();
                _frmHEAD.setXmlTag("Form");
                _frmHEAD.put("id", "frmHEAD");
                _frmHEAD.put("type", "Auto");
                _frmHEAD.put("title", "业务头");
                _frmHEAD.put("dataset", "inputDs");
                _frmHEAD.put("labelAlign", "left");
                _frmHEAD.put("width", "100%");
                _frmHEAD.put("height", "");
                _frmHEAD.put("enable", "true");
                _frmHEAD.put("readOnly", "false");
                _frmHEAD.put("visible", "true");
                _frmHEAD.put("numCols", "4");

                List<BaseConfig> _frmHEADItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "MSG_ID","报文标识号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "MSG_SND_TIME","报文发送时间","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "TXN_NUM","交易笔数","","15","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_METHOD","结算方式","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CLR_SYS_REF","清算系统参考号","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmHEAD_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmHEADItemList.add(formFieldBaseConfig);
                    }


                _frmHEAD.put("formItemList",_frmHEADItemList);
                List<BaseConfig> _lfrmHEAD = new ArrayList<BaseConfig>();
                _lfrmHEAD.add(_frmHEAD);
                return _frmHEAD;
            }

         private BaseConfig sub_form_frmSTAC() {
                BaseConfig _frmSTAC = new BaseConfig();
                _frmSTAC.setXmlTag("Form");
                _frmSTAC.put("id", "frmSTAC");
                _frmSTAC.put("type", "Auto");
                _frmSTAC.put("title", "结算账户");
                _frmSTAC.put("dataset", "inputDs");
                _frmSTAC.put("labelAlign", "left");
                _frmSTAC.put("width", "100%");
                _frmSTAC.put("height", "");
                _frmSTAC.put("enable", "true");
                _frmSTAC.put("readOnly", "false");
                _frmSTAC.put("visible", "true");
                _frmSTAC.put("numCols", "4");

                List<BaseConfig> _frmSTACItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "ST_AC_IBAN","IBAN码","","34","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_ID","账号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_ID_SCHE","身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_ID_SCHEX","身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_ID_ISSR","发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_TYPE","类型代码","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_TYPEX","用途说明","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_CCY","币种","900001","3","Select","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_NAME","名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_AKA_ID_TP","账户别名类型（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_AKA_ID_TPX","账户别名类型（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_AC_AKA_ID","账户别名","","2048","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmSTAC_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmSTACItemList.add(formFieldBaseConfig);
                    }


                _frmSTAC.put("formItemList",_frmSTACItemList);
                List<BaseConfig> _lfrmSTAC = new ArrayList<BaseConfig>();
                _lfrmSTAC.add(_frmSTAC);
                return _frmSTAC;
            }

         private BaseConfig sub_form_frmSCENARIO() {
                BaseConfig _frmSCENARIO = new BaseConfig();
                _frmSCENARIO.setXmlTag("Form");
                _frmSCENARIO.put("id", "frmSCENARIO");
                _frmSCENARIO.put("type", "Auto");
                _frmSCENARIO.put("title", "退汇场景");
                _frmSCENARIO.put("dataset", "inputDs");
                _frmSCENARIO.put("labelAlign", "left");
                _frmSCENARIO.put("width", "100%");
                _frmSCENARIO.put("height", "");
                _frmSCENARIO.put("enable", "true");
                _frmSCENARIO.put("readOnly", "false");
                _frmSCENARIO.put("visible", "true");
                _frmSCENARIO.put("numCols", "4");

                List<BaseConfig> _frmSCENARIOItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "RETURN_SCENARIO","退汇场景类型","050121","","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmSCENARIO_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmSCENARIOItemList.add(formFieldBaseConfig);
                    }


                _frmSCENARIO.put("formItemList",_frmSCENARIOItemList);
                List<BaseConfig> _lfrmSCENARIO = new ArrayList<BaseConfig>();
                _lfrmSCENARIO.add(_frmSCENARIO);
                return _frmSCENARIO;
            }

         private BaseConfig sub_form_frmORITXN() {
                BaseConfig _frmORITXN = new BaseConfig();
                _frmORITXN.setXmlTag("Form");
                _frmORITXN.put("id", "frmORITXN");
                _frmORITXN.put("type", "Auto");
                _frmORITXN.put("title", "原交易信息");
                _frmORITXN.put("dataset", "inputDs");
                _frmORITXN.put("labelAlign", "left");
                _frmORITXN.put("width", "100%");
                _frmORITXN.put("height", "");
                _frmORITXN.put("enable", "true");
                _frmORITXN.put("readOnly", "false");
                _frmORITXN.put("visible", "true");
                _frmORITXN.put("numCols", "4");

                List<BaseConfig> _frmORITXNItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "OTXN_MSG_ID","原报文标识号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_MSG_TYPE","原报文类型","050116","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_MSG_SND_TIME","原报文发送时间","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_INSTR_ID","原报文参考号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_E2E_ID","原端到端标识号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_TXN_ID","原交易标识号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_UETR","原UETR","","36","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_CLR_SYS_REF","原清算系统参考号","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_AMT","原金额","","18","Money","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_AMT_CURCD","原金额币种","900001","3","Select","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_ST_DATE","原结算日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "OTXN_BIZ_CATE_CODE","原业务种类编码","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmORITXN_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmORITXNItemList.add(formFieldBaseConfig);
                    }


                _frmORITXN.put("formItemList",_frmORITXNItemList);
                List<BaseConfig> _lfrmORITXN = new ArrayList<BaseConfig>();
                _lfrmORITXN.add(_frmORITXN);
                return _frmORITXN;
            }

         private BaseConfig sub_form_frmRTR() {
                BaseConfig _frmRTR = new BaseConfig();
                _frmRTR.setXmlTag("Form");
                _frmRTR.put("id", "frmRTR");
                _frmRTR.put("type", "Auto");
                _frmRTR.put("title", "退汇信息");
                _frmRTR.put("dataset", "inputDs");
                _frmRTR.put("labelAlign", "left");
                _frmRTR.put("width", "100%");
                _frmRTR.put("height", "");
                _frmRTR.put("enable", "true");
                _frmRTR.put("readOnly", "false");
                _frmRTR.put("visible", "true");
                _frmRTR.put("numCols", "4");

                List<BaseConfig> _frmRTRItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "RTR_ID","退汇唯一标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTRD_ST_AMT","退汇结算金额","","18","Money","true","false","false"));
                    list.add(new FormFieldAttr( "RTRD_ST_AMT_CURCD","退汇结算金额币种","900001","3","Select","true","false","false"));
                    list.add(new FormFieldAttr( "ST_DATE","银行间结算日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "ST_PRIO","业务优先级","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_DR_TIME","借记时间","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ST_CR_TIME","贷记时间","","32","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTRD_INSTD_AMT","发起退汇金额","","18","Money","true","false","false"));
                    list.add(new FormFieldAttr( "RTRD_INSTD_AMT_CURCD","发起退汇金额币种","900001","3","Select","true","false","false"));
                    list.add(new FormFieldAttr( "FX_RATE","汇率","","12","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_BEAR","费用承担方","050002","32","Select","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_REASON_CD","退汇原因代码","050118","4","Select","true","false","false"));
                    list.add(new FormFieldAttr( "ADDTL_INF1","附加信息1","","105","Text","true","false","false"));
                    list.add(new FormFieldAttr( "ADDTL_INF2","附加信息2","","105","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmRTR_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmRTRItemList.add(formFieldBaseConfig);
                    }


                _frmRTR.put("formItemList",_frmRTRItemList);
                List<BaseConfig> _lfrmRTR = new ArrayList<BaseConfig>();
                _lfrmRTR.add(_frmRTR);
                return _frmRTR;
            }

         private BaseConfig sub_form_frmINSTG() {
                BaseConfig _frmINSTG = new BaseConfig();
                _frmINSTG.setXmlTag("Form");
                _frmINSTG.put("id", "frmINSTG");
                _frmINSTG.put("type", "Auto");
                _frmINSTG.put("title", "发报方");
                _frmINSTG.put("dataset", "inputDs");
                _frmINSTG.put("labelAlign", "left");
                _frmINSTG.put("width", "100%");
                _frmINSTG.put("height", "");
                _frmINSTG.put("enable", "true");
                _frmINSTG.put("readOnly", "false");
                _frmINSTG.put("visible", "true");
                _frmINSTG.put("numCols", "4");

                List<BaseConfig> _frmINSTGItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "INSTG_AGT_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTG_AGT_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTG_AGT_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTG_AGT_LEI","LEI码","","20","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmINSTG_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmINSTGItemList.add(formFieldBaseConfig);
                    }


                _frmINSTG.put("formItemList",_frmINSTGItemList);
                List<BaseConfig> _lfrmINSTG = new ArrayList<BaseConfig>();
                _lfrmINSTG.add(_frmINSTG);
                return _frmINSTG;
            }

         private BaseConfig sub_form_frmINSTD() {
                BaseConfig _frmINSTD = new BaseConfig();
                _frmINSTD.setXmlTag("Form");
                _frmINSTD.put("id", "frmINSTD");
                _frmINSTD.put("type", "Auto");
                _frmINSTD.put("title", "收报方");
                _frmINSTD.put("dataset", "inputDs");
                _frmINSTD.put("labelAlign", "left");
                _frmINSTD.put("width", "100%");
                _frmINSTD.put("height", "");
                _frmINSTD.put("enable", "true");
                _frmINSTD.put("readOnly", "false");
                _frmINSTD.put("visible", "true");
                _frmINSTD.put("numCols", "4");

                List<BaseConfig> _frmINSTDItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "INSTD_AGT_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTD_AGT_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTD_AGT_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INSTD_AGT_LEI","LEI码","","20","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmINSTD_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmINSTDItemList.add(formFieldBaseConfig);
                    }


                _frmINSTD.put("formItemList",_frmINSTDItemList);
                List<BaseConfig> _lfrmINSTD = new ArrayList<BaseConfig>();
                _lfrmINSTD.add(_frmINSTD);
                return _frmINSTD;
            }

         private BaseConfig sub_form_frmUDBTR() {
                BaseConfig _frmUDBTR = new BaseConfig();
                _frmUDBTR.setXmlTag("Form");
                _frmUDBTR.put("id", "frmUDBTR");
                _frmUDBTR.put("type", "Auto");
                _frmUDBTR.put("title", "退汇链路/最终付款方");
                _frmUDBTR.put("dataset", "inputDs");
                _frmUDBTR.put("labelAlign", "left");
                _frmUDBTR.put("width", "100%");
                _frmUDBTR.put("height", "");
                _frmUDBTR.put("enable", "true");
                _frmUDBTR.put("readOnly", "false");
                _frmUDBTR.put("visible", "true");
                _frmUDBTR.put("numCols", "4");

                List<BaseConfig> _frmUDBTRItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "UDBTR_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_ID_SCHEX","【组织】身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UDBTR_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmUDBTR_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmUDBTRItemList.add(formFieldBaseConfig);
                    }


                _frmUDBTR.put("formItemList",_frmUDBTRItemList);
                List<BaseConfig> _lfrmUDBTR = new ArrayList<BaseConfig>();
                _lfrmUDBTR.add(_frmUDBTR);
                return _frmUDBTR;
            }

         private BaseConfig sub_form_frmDBTR_PTY() {
                BaseConfig _frmDBTR_PTY = new BaseConfig();
                _frmDBTR_PTY.setXmlTag("Form");
                _frmDBTR_PTY.put("id", "frmDBTR_PTY");
                _frmDBTR_PTY.put("type", "Auto");
                _frmDBTR_PTY.put("title", "退汇链路/付款人");
                _frmDBTR_PTY.put("dataset", "inputDs");
                _frmDBTR_PTY.put("labelAlign", "left");
                _frmDBTR_PTY.put("width", "100%");
                _frmDBTR_PTY.put("height", "");
                _frmDBTR_PTY.put("enable", "true");
                _frmDBTR_PTY.put("readOnly", "false");
                _frmDBTR_PTY.put("visible", "true");
                _frmDBTR_PTY.put("numCols", "4");

                List<BaseConfig> _frmDBTR_PTYItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "DBTR_PTY_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTY_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmDBTR_PTY_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmDBTR_PTYItemList.add(formFieldBaseConfig);
                    }


                _frmDBTR_PTY.put("formItemList",_frmDBTR_PTYItemList);
                List<BaseConfig> _lfrmDBTR_PTY = new ArrayList<BaseConfig>();
                _lfrmDBTR_PTY.add(_frmDBTR_PTY);
                return _frmDBTR_PTY;
            }

         private BaseConfig sub_form_frmDBTR_PTYF() {
                BaseConfig _frmDBTR_PTYF = new BaseConfig();
                _frmDBTR_PTYF.setXmlTag("Form");
                _frmDBTR_PTYF.put("id", "frmDBTR_PTYF");
                _frmDBTR_PTYF.put("type", "Auto");
                _frmDBTR_PTYF.put("title", "退汇链路/付款行");
                _frmDBTR_PTYF.put("dataset", "inputDs");
                _frmDBTR_PTYF.put("labelAlign", "left");
                _frmDBTR_PTYF.put("width", "100%");
                _frmDBTR_PTYF.put("height", "");
                _frmDBTR_PTYF.put("enable", "true");
                _frmDBTR_PTYF.put("readOnly", "false");
                _frmDBTR_PTYF.put("visible", "true");
                _frmDBTR_PTYF.put("numCols", "4");

                List<BaseConfig> _frmDBTR_PTYFItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "DBTR_PTYF_BIC","【代理机构】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_CLR_SYS","【代理机构】清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_CLR_SYS_MMBID","【代理机构】参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_LEI","【代理机构】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_NAME","【代理机构】名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_M","【代理机构】地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_DEPT","【代理机构】地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_SDEPT","【代理机构】地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_STRT_NM","【代理机构】地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_BLDG_NB","【代理机构】地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_BLDG_NM","【代理机构】地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_FLR","【代理机构】地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_PST_BX","【代理机构】地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_ROOM","【代理机构】地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_PST_CD","【代理机构】地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_TWN","【代理机构】地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_TWN_LOC","【代理机构】地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_DSTRCT","【代理机构】地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_AREA","【代理机构】地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_CTRY","【代理机构】地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_ADR_LINE1","【代理机构】地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_ADR_LINE2","【代理机构】地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_PTYF_ADR_ADR_LINE3","【代理机构】地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmDBTR_PTYF_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmDBTR_PTYFItemList.add(formFieldBaseConfig);
                    }


                _frmDBTR_PTYF.put("formItemList",_frmDBTR_PTYFItemList);
                List<BaseConfig> _lfrmDBTR_PTYF = new ArrayList<BaseConfig>();
                _lfrmDBTR_PTYF.add(_frmDBTR_PTYF);
                return _frmDBTR_PTYF;
            }

         private BaseConfig sub_form_frmINIT_PTY() {
                BaseConfig _frmINIT_PTY = new BaseConfig();
                _frmINIT_PTY.setXmlTag("Form");
                _frmINIT_PTY.put("id", "frmINIT_PTY");
                _frmINIT_PTY.put("type", "Auto");
                _frmINIT_PTY.put("title", "退汇链路/发起方");
                _frmINIT_PTY.put("dataset", "inputDs");
                _frmINIT_PTY.put("labelAlign", "left");
                _frmINIT_PTY.put("width", "100%");
                _frmINIT_PTY.put("height", "");
                _frmINIT_PTY.put("enable", "true");
                _frmINIT_PTY.put("readOnly", "false");
                _frmINIT_PTY.put("visible", "true");
                _frmINIT_PTY.put("numCols", "4");

                List<BaseConfig> _frmINIT_PTYItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "INIT_PTY_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_ID_SCHEX","【组织】身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "INIT_PTY_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmINIT_PTY_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmINIT_PTYItemList.add(formFieldBaseConfig);
                    }


                _frmINIT_PTY.put("formItemList",_frmINIT_PTYItemList);
                List<BaseConfig> _lfrmINIT_PTY = new ArrayList<BaseConfig>();
                _lfrmINIT_PTY.add(_frmINIT_PTY);
                return _frmINIT_PTY;
            }

         private BaseConfig sub_form_frmDBTR_AGT() {
                BaseConfig _frmDBTR_AGT = new BaseConfig();
                _frmDBTR_AGT.setXmlTag("Form");
                _frmDBTR_AGT.put("id", "frmDBTR_AGT");
                _frmDBTR_AGT.put("type", "Auto");
                _frmDBTR_AGT.put("title", "退汇链路/付款开户行");
                _frmDBTR_AGT.put("dataset", "inputDs");
                _frmDBTR_AGT.put("labelAlign", "left");
                _frmDBTR_AGT.put("width", "100%");
                _frmDBTR_AGT.put("height", "");
                _frmDBTR_AGT.put("enable", "true");
                _frmDBTR_AGT.put("readOnly", "false");
                _frmDBTR_AGT.put("visible", "true");
                _frmDBTR_AGT.put("numCols", "4");

                List<BaseConfig> _frmDBTR_AGTItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "DBTR_AGT_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "DBTR_AGT_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmDBTR_AGT_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmDBTR_AGTItemList.add(formFieldBaseConfig);
                    }


                _frmDBTR_AGT.put("formItemList",_frmDBTR_AGTItemList);
                List<BaseConfig> _lfrmDBTR_AGT = new ArrayList<BaseConfig>();
                _lfrmDBTR_AGT.add(_frmDBTR_AGT);
                return _frmDBTR_AGT;
            }

         private BaseConfig sub_form_frmPRE_AGT1() {
                BaseConfig _frmPRE_AGT1 = new BaseConfig();
                _frmPRE_AGT1.setXmlTag("Form");
                _frmPRE_AGT1.put("id", "frmPRE_AGT1");
                _frmPRE_AGT1.put("type", "Auto");
                _frmPRE_AGT1.put("title", "退汇链路/前序机构1");
                _frmPRE_AGT1.put("dataset", "inputDs");
                _frmPRE_AGT1.put("labelAlign", "left");
                _frmPRE_AGT1.put("width", "100%");
                _frmPRE_AGT1.put("height", "");
                _frmPRE_AGT1.put("enable", "true");
                _frmPRE_AGT1.put("readOnly", "false");
                _frmPRE_AGT1.put("visible", "true");
                _frmPRE_AGT1.put("numCols", "4");

                List<BaseConfig> _frmPRE_AGT1ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "PRE_AGT1_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT1_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmPRE_AGT1_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmPRE_AGT1ItemList.add(formFieldBaseConfig);
                    }


                _frmPRE_AGT1.put("formItemList",_frmPRE_AGT1ItemList);
                List<BaseConfig> _lfrmPRE_AGT1 = new ArrayList<BaseConfig>();
                _lfrmPRE_AGT1.add(_frmPRE_AGT1);
                return _frmPRE_AGT1;
            }

         private BaseConfig sub_form_frmPRE_AGT2() {
                BaseConfig _frmPRE_AGT2 = new BaseConfig();
                _frmPRE_AGT2.setXmlTag("Form");
                _frmPRE_AGT2.put("id", "frmPRE_AGT2");
                _frmPRE_AGT2.put("type", "Auto");
                _frmPRE_AGT2.put("title", "退汇链路/前序机构2");
                _frmPRE_AGT2.put("dataset", "inputDs");
                _frmPRE_AGT2.put("labelAlign", "left");
                _frmPRE_AGT2.put("width", "100%");
                _frmPRE_AGT2.put("height", "");
                _frmPRE_AGT2.put("enable", "true");
                _frmPRE_AGT2.put("readOnly", "false");
                _frmPRE_AGT2.put("visible", "true");
                _frmPRE_AGT2.put("numCols", "4");

                List<BaseConfig> _frmPRE_AGT2ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "PRE_AGT2_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT2_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmPRE_AGT2_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmPRE_AGT2ItemList.add(formFieldBaseConfig);
                    }


                _frmPRE_AGT2.put("formItemList",_frmPRE_AGT2ItemList);
                List<BaseConfig> _lfrmPRE_AGT2 = new ArrayList<BaseConfig>();
                _lfrmPRE_AGT2.add(_frmPRE_AGT2);
                return _frmPRE_AGT2;
            }

         private BaseConfig sub_form_frmPRE_AGT3() {
                BaseConfig _frmPRE_AGT3 = new BaseConfig();
                _frmPRE_AGT3.setXmlTag("Form");
                _frmPRE_AGT3.put("id", "frmPRE_AGT3");
                _frmPRE_AGT3.put("type", "Auto");
                _frmPRE_AGT3.put("title", "退汇链路/前序机构3");
                _frmPRE_AGT3.put("dataset", "inputDs");
                _frmPRE_AGT3.put("labelAlign", "left");
                _frmPRE_AGT3.put("width", "100%");
                _frmPRE_AGT3.put("height", "");
                _frmPRE_AGT3.put("enable", "true");
                _frmPRE_AGT3.put("readOnly", "false");
                _frmPRE_AGT3.put("visible", "true");
                _frmPRE_AGT3.put("numCols", "4");

                List<BaseConfig> _frmPRE_AGT3ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "PRE_AGT3_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PRE_AGT3_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmPRE_AGT3_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmPRE_AGT3ItemList.add(formFieldBaseConfig);
                    }


                _frmPRE_AGT3.put("formItemList",_frmPRE_AGT3ItemList);
                List<BaseConfig> _lfrmPRE_AGT3 = new ArrayList<BaseConfig>();
                _lfrmPRE_AGT3.add(_frmPRE_AGT3);
                return _frmPRE_AGT3;
            }

         private BaseConfig sub_form_frmIM_AGT1() {
                BaseConfig _frmIM_AGT1 = new BaseConfig();
                _frmIM_AGT1.setXmlTag("Form");
                _frmIM_AGT1.put("id", "frmIM_AGT1");
                _frmIM_AGT1.put("type", "Auto");
                _frmIM_AGT1.put("title", "退汇链路/中介机构1");
                _frmIM_AGT1.put("dataset", "inputDs");
                _frmIM_AGT1.put("labelAlign", "left");
                _frmIM_AGT1.put("width", "100%");
                _frmIM_AGT1.put("height", "");
                _frmIM_AGT1.put("enable", "true");
                _frmIM_AGT1.put("readOnly", "false");
                _frmIM_AGT1.put("visible", "true");
                _frmIM_AGT1.put("numCols", "4");

                List<BaseConfig> _frmIM_AGT1ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "IM_AGT1_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT1_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmIM_AGT1_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmIM_AGT1ItemList.add(formFieldBaseConfig);
                    }


                _frmIM_AGT1.put("formItemList",_frmIM_AGT1ItemList);
                List<BaseConfig> _lfrmIM_AGT1 = new ArrayList<BaseConfig>();
                _lfrmIM_AGT1.add(_frmIM_AGT1);
                return _frmIM_AGT1;
            }

         private BaseConfig sub_form_frmIM_AGT2() {
                BaseConfig _frmIM_AGT2 = new BaseConfig();
                _frmIM_AGT2.setXmlTag("Form");
                _frmIM_AGT2.put("id", "frmIM_AGT2");
                _frmIM_AGT2.put("type", "Auto");
                _frmIM_AGT2.put("title", "退汇链路/中介机构2");
                _frmIM_AGT2.put("dataset", "inputDs");
                _frmIM_AGT2.put("labelAlign", "left");
                _frmIM_AGT2.put("width", "100%");
                _frmIM_AGT2.put("height", "");
                _frmIM_AGT2.put("enable", "true");
                _frmIM_AGT2.put("readOnly", "false");
                _frmIM_AGT2.put("visible", "true");
                _frmIM_AGT2.put("numCols", "4");

                List<BaseConfig> _frmIM_AGT2ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "IM_AGT2_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT2_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmIM_AGT2_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmIM_AGT2ItemList.add(formFieldBaseConfig);
                    }


                _frmIM_AGT2.put("formItemList",_frmIM_AGT2ItemList);
                List<BaseConfig> _lfrmIM_AGT2 = new ArrayList<BaseConfig>();
                _lfrmIM_AGT2.add(_frmIM_AGT2);
                return _frmIM_AGT2;
            }

         private BaseConfig sub_form_frmIM_AGT3() {
                BaseConfig _frmIM_AGT3 = new BaseConfig();
                _frmIM_AGT3.setXmlTag("Form");
                _frmIM_AGT3.put("id", "frmIM_AGT3");
                _frmIM_AGT3.put("type", "Auto");
                _frmIM_AGT3.put("title", "退汇链路/中介机构3");
                _frmIM_AGT3.put("dataset", "inputDs");
                _frmIM_AGT3.put("labelAlign", "left");
                _frmIM_AGT3.put("width", "100%");
                _frmIM_AGT3.put("height", "");
                _frmIM_AGT3.put("enable", "true");
                _frmIM_AGT3.put("readOnly", "false");
                _frmIM_AGT3.put("visible", "true");
                _frmIM_AGT3.put("numCols", "4");

                List<BaseConfig> _frmIM_AGT3ItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "IM_AGT3_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "IM_AGT3_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmIM_AGT3_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmIM_AGT3ItemList.add(formFieldBaseConfig);
                    }


                _frmIM_AGT3.put("formItemList",_frmIM_AGT3ItemList);
                List<BaseConfig> _lfrmIM_AGT3 = new ArrayList<BaseConfig>();
                _lfrmIM_AGT3.add(_frmIM_AGT3);
                return _frmIM_AGT3;
            }

         private BaseConfig sub_form_frmCDTR_AGT() {
                BaseConfig _frmCDTR_AGT = new BaseConfig();
                _frmCDTR_AGT.setXmlTag("Form");
                _frmCDTR_AGT.put("id", "frmCDTR_AGT");
                _frmCDTR_AGT.put("type", "Auto");
                _frmCDTR_AGT.put("title", "退汇链路/收款开户行");
                _frmCDTR_AGT.put("dataset", "inputDs");
                _frmCDTR_AGT.put("labelAlign", "left");
                _frmCDTR_AGT.put("width", "100%");
                _frmCDTR_AGT.put("height", "");
                _frmCDTR_AGT.put("enable", "true");
                _frmCDTR_AGT.put("readOnly", "false");
                _frmCDTR_AGT.put("visible", "true");
                _frmCDTR_AGT.put("numCols", "4");

                List<BaseConfig> _frmCDTR_AGTItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "CDTR_AGT_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_AGT_BR_ID","分支机构标识","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmCDTR_AGT_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmCDTR_AGTItemList.add(formFieldBaseConfig);
                    }


                _frmCDTR_AGT.put("formItemList",_frmCDTR_AGTItemList);
                List<BaseConfig> _lfrmCDTR_AGT = new ArrayList<BaseConfig>();
                _lfrmCDTR_AGT.add(_frmCDTR_AGT);
                return _frmCDTR_AGT;
            }

         private BaseConfig sub_form_frmCDTR_PTY() {
                BaseConfig _frmCDTR_PTY = new BaseConfig();
                _frmCDTR_PTY.setXmlTag("Form");
                _frmCDTR_PTY.put("id", "frmCDTR_PTY");
                _frmCDTR_PTY.put("type", "Auto");
                _frmCDTR_PTY.put("title", "退汇链路/收款人");
                _frmCDTR_PTY.put("dataset", "inputDs");
                _frmCDTR_PTY.put("labelAlign", "left");
                _frmCDTR_PTY.put("width", "100%");
                _frmCDTR_PTY.put("height", "");
                _frmCDTR_PTY.put("enable", "true");
                _frmCDTR_PTY.put("readOnly", "false");
                _frmCDTR_PTY.put("visible", "true");
                _frmCDTR_PTY.put("numCols", "4");

                List<BaseConfig> _frmCDTR_PTYItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "CDTR_PTY_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_ID_SCHEX","【组织】身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTY_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmCDTR_PTY_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmCDTR_PTYItemList.add(formFieldBaseConfig);
                    }


                _frmCDTR_PTY.put("formItemList",_frmCDTR_PTYItemList);
                List<BaseConfig> _lfrmCDTR_PTY = new ArrayList<BaseConfig>();
                _lfrmCDTR_PTY.add(_frmCDTR_PTY);
                return _frmCDTR_PTY;
            }

         private BaseConfig sub_form_frmCDTR_PTYF() {
                BaseConfig _frmCDTR_PTYF = new BaseConfig();
                _frmCDTR_PTYF.setXmlTag("Form");
                _frmCDTR_PTYF.put("id", "frmCDTR_PTYF");
                _frmCDTR_PTYF.put("type", "Auto");
                _frmCDTR_PTYF.put("title", "退汇链路/收款行");
                _frmCDTR_PTYF.put("dataset", "inputDs");
                _frmCDTR_PTYF.put("labelAlign", "left");
                _frmCDTR_PTYF.put("width", "100%");
                _frmCDTR_PTYF.put("height", "");
                _frmCDTR_PTYF.put("enable", "true");
                _frmCDTR_PTYF.put("readOnly", "false");
                _frmCDTR_PTYF.put("visible", "true");
                _frmCDTR_PTYF.put("numCols", "4");

                List<BaseConfig> _frmCDTR_PTYFItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "CDTR_PTYF_BIC","【代理机构】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_CLR_SYS","【代理机构】清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_CLR_SYS_MMBID","【代理机构】参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_LEI","【代理机构】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_NAME","【代理机构】名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_M","【代理机构】地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_DEPT","【代理机构】地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_SDEPT","【代理机构】地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_STRT_NM","【代理机构】地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_BLDG_NB","【代理机构】地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_BLDG_NM","【代理机构】地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_FLR","【代理机构】地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_PST_BX","【代理机构】地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_ROOM","【代理机构】地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_PST_CD","【代理机构】地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_TWN","【代理机构】地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_TWN_LOC","【代理机构】地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_DSTRCT","【代理机构】地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_AREA","【代理机构】地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_CTRY","【代理机构】地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_ADR_LINE1","【代理机构】地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_ADR_LINE2","【代理机构】地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CDTR_PTYF_ADR_ADR_LINE3","【代理机构】地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmCDTR_PTYF_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmCDTR_PTYFItemList.add(formFieldBaseConfig);
                    }


                _frmCDTR_PTYF.put("formItemList",_frmCDTR_PTYFItemList);
                List<BaseConfig> _lfrmCDTR_PTYF = new ArrayList<BaseConfig>();
                _lfrmCDTR_PTYF.add(_frmCDTR_PTYF);
                return _frmCDTR_PTYF;
            }

         private BaseConfig sub_form_frmUCDTR() {
                BaseConfig _frmUCDTR = new BaseConfig();
                _frmUCDTR.setXmlTag("Form");
                _frmUCDTR.put("id", "frmUCDTR");
                _frmUCDTR.put("type", "Auto");
                _frmUCDTR.put("title", "退汇链路/最终收款方");
                _frmUCDTR.put("dataset", "inputDs");
                _frmUCDTR.put("labelAlign", "left");
                _frmUCDTR.put("width", "100%");
                _frmUCDTR.put("height", "");
                _frmUCDTR.put("enable", "true");
                _frmUCDTR.put("readOnly", "false");
                _frmUCDTR.put("visible", "true");
                _frmUCDTR.put("numCols", "4");

                List<BaseConfig> _frmUCDTRItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "UCDTR_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_ID_SCHEX","【组织】身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "UCDTR_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmUCDTR_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmUCDTRItemList.add(formFieldBaseConfig);
                    }


                _frmUCDTR.put("formItemList",_frmUCDTRItemList);
                List<BaseConfig> _lfrmUCDTR = new ArrayList<BaseConfig>();
                _lfrmUCDTR.add(_frmUCDTR);
                return _frmUCDTR;
            }

         private BaseConfig sub_form_frmRTR_ORGTR() {
                BaseConfig _frmRTR_ORGTR = new BaseConfig();
                _frmRTR_ORGTR.setXmlTag("Form");
                _frmRTR_ORGTR.put("id", "frmRTR_ORGTR");
                _frmRTR_ORGTR.put("type", "Auto");
                _frmRTR_ORGTR.put("title", "退汇链路/退汇发起方");
                _frmRTR_ORGTR.put("dataset", "inputDs");
                _frmRTR_ORGTR.put("labelAlign", "left");
                _frmRTR_ORGTR.put("width", "100%");
                _frmRTR_ORGTR.put("height", "");
                _frmRTR_ORGTR.put("enable", "true");
                _frmRTR_ORGTR.put("readOnly", "false");
                _frmRTR_ORGTR.put("visible", "true");
                _frmRTR_ORGTR.put("numCols", "4");

                List<BaseConfig> _frmRTR_ORGTRItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "RTR_ORGTR_NAME","个人或组织名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_BIC","【组织】BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_LEI","【组织】LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_ID","【组织】CIPS ID或组织机构代码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_ID_SCHE","【组织】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_ID_SCHEX","【组织】身份标识方案名称（自定义内容）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_C_ID_ISSR","【组织】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_BIRTH_DATE","【个人】出生日期","","32","Date","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_BIRTH_PRVC","【个人】出生省份","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_BIRTH_CITY","【个人】出生城市","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_BIRTH_CTRY","【个人】出生国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_ID","【个人】证件号码","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_ID_SCHE","【个人】身份标识方案名称（代码）","","4","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_ID_SCHEX","【个人】证件类型","050062","35","Select","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_P_ID_ISSR","【个人】发码方","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "RTR_ORGTR_RES_CTRY","居住国家","050022","2","Select","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmRTR_ORGTR_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmRTR_ORGTRItemList.add(formFieldBaseConfig);
                    }


                _frmRTR_ORGTR.put("formItemList",_frmRTR_ORGTRItemList);
                List<BaseConfig> _lfrmRTR_ORGTR = new ArrayList<BaseConfig>();
                _lfrmRTR_ORGTR.add(_frmRTR_ORGTR);
                return _frmRTR_ORGTR;
            }

         private BaseConfig sub_form_frmJYZTXX() {
                BaseConfig _frmJYZTXX = new BaseConfig();
                _frmJYZTXX.setXmlTag("Form");
                _frmJYZTXX.put("id", "frmJYZTXX");
                _frmJYZTXX.put("type", "Auto");
                _frmJYZTXX.put("title", "交易状态信息");
                _frmJYZTXX.put("dataset", "inputDs");
                _frmJYZTXX.put("labelAlign", "left");
                _frmJYZTXX.put("width", "100%");
                _frmJYZTXX.put("height", "");
                _frmJYZTXX.put("enable", "true");
                _frmJYZTXX.put("readOnly", "false");
                _frmJYZTXX.put("visible", "true");
                _frmJYZTXX.put("numCols", "4");

                List<BaseConfig> _frmJYZTXXItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "TXN_SEQ_NO","交易流水号","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "MADE_USER","录入操作员","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "MADE_TIME","录入时间","","21","Text","true","false","false"));
                    list.add(new FormFieldAttr( "PBOC_STATUS","人行状态","050003","4","Select","true","false","false"));
                    list.add(new FormFieldAttr( "TXN_STATUS","业务状态","900218","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "COMM_STATUS","通讯状态","900219","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "BIZ_PROC_INFO","人行处理信息","","100","TextArea","true","false","false"));
                    list.add(new FormFieldAttr( "BIZ_CNCL_INFO","取消原因","","100","TextArea","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmJYZTXX_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmJYZTXXItemList.add(formFieldBaseConfig);
                    }


                _frmJYZTXX.put("formItemList",_frmJYZTXXItemList);
                List<BaseConfig> _lfrmJYZTXX = new ArrayList<BaseConfig>();
                _lfrmJYZTXX.add(_frmJYZTXX);
                return _frmJYZTXX;
            }

         private BaseConfig sub_form_frmJJXX() {
                BaseConfig _frmJJXX = new BaseConfig();
                _frmJJXX.setXmlTag("Form");
                _frmJJXX.put("id", "frmJJXX");
                _frmJJXX.put("type", "Auto");
                _frmJJXX.put("title", "拒绝信息");
                _frmJJXX.put("dataset", "inputDs");
                _frmJJXX.put("labelAlign", "left");
                _frmJJXX.put("width", "100%");
                _frmJJXX.put("height", "");
                _frmJJXX.put("enable", "true");
                _frmJJXX.put("readOnly", "false");
                _frmJJXX.put("visible", "true");
                _frmJJXX.put("numCols", "4");

                List<BaseConfig> _frmJJXXItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "BIZ_REJ_INFO","拒绝原因","","100","TextArea","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmJJXX_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "inputDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmJJXXItemList.add(formFieldBaseConfig);
                    }


                _frmJJXX.put("formItemList",_frmJJXXItemList);
                List<BaseConfig> _lfrmJJXX = new ArrayList<BaseConfig>();
                _lfrmJJXX.add(_frmJJXX);
                return _frmJJXX;
            }

         private BaseConfig sub_form_frmCHRG_DTL() {
                BaseConfig _frmCHRG_DTL = new BaseConfig();
                _frmCHRG_DTL.setXmlTag("Form");
                _frmCHRG_DTL.put("id", "frmCHRG_DTL");
                _frmCHRG_DTL.put("type", "Auto");
                _frmCHRG_DTL.put("title", "费用明细");
                _frmCHRG_DTL.put("dataset", "chrgDtlDs");
                _frmCHRG_DTL.put("labelAlign", "left");
                _frmCHRG_DTL.put("width", "100%");
                _frmCHRG_DTL.put("height", "");
                _frmCHRG_DTL.put("enable", "true");
                _frmCHRG_DTL.put("readOnly", "false");
                _frmCHRG_DTL.put("visible", "true");
                _frmCHRG_DTL.put("numCols", "4");

                List<BaseConfig> _frmCHRG_DTLItemList = new ArrayList<BaseConfig>();


                //fieldAttrList
                List<FormFieldAttr> list = new ArrayList<>();
                    list.add(new FormFieldAttr( "CHRG_AMT","金额","","18","Money","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AMT_CURCD","金额币种","900001","3","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_BIC","BIC码","","11","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_CLR_SYS","清算系统标识（代码）","","5","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_CLR_SYS_MMBID","参与者身份标识","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_LEI","LEI码","","20","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_NAME","名称","","140","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_M","地址","","4000","TextArea","true","false","true"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_DEPT","地址_部门","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_SDEPT","地址_分部","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_STRT_NM","地址_街道名称","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_BLDG_NB","地址_建筑编号","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_BLDG_NM","地址_建筑名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_FLR","地址_建筑楼层","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_PST_BX","地址_邮政信箱","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_ROOM","地址_房间号","","70","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_PST_CD","地址_邮政编码","","16","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_TWN","地址_城镇名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_TWN_LOC","地址_城镇地址","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_DSTRCT","地址_地区名称","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_AREA","地址_国家区域（区/洲）","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_CTRY","地址_国家","050022","2","Select","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_ADR_LINE1","地址_自由格式地址1","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_ADR_LINE2","地址_自由格式地址2","","35","Text","true","false","false"));
                    list.add(new FormFieldAttr( "CHRG_AGT_ADR_ADR_LINE3","地址_自由格式地址3","","35","Text","true","false","false"));

                BaseConfig formFieldBaseConfig;

                for (FormFieldAttr fieldAttr : list) {
                    String fieldId = fieldAttr.getId();
                    String fieldName = fieldAttr.getName();
                    String fieldDict = fieldAttr.getDict();
                    String fieldLen = fieldAttr.getLen();
                    String fieldComponentType = capitalize(fieldAttr.getComponentType());
                    String fieldOptional = fieldAttr.getOptional();
                    String fieldReadOnly = fieldAttr.getReadOnly();
                    String fieldColSpan = fieldAttr.getColspan();
                    formFieldBaseConfig = new BaseConfig();
                    formFieldBaseConfig.setXmlTag("FormItem");
                    formFieldBaseConfig.put("id", "frmCHRG_DTL_" + fieldId);

                    switch (fieldComponentType) {
                    case "Date":
                        formFieldBaseConfig.put("type", "Date");
                        break;
                    case "Money":
                        formFieldBaseConfig.put("type", "Money");
                        break;
                    case "TextArea":
                        formFieldBaseConfig.put("type", "TextArea");
                        formFieldBaseConfig.put("colSpan", "2");
                        formFieldBaseConfig.put("columnStart", "4");
                        formFieldBaseConfig.put("columnEnd", "12");
                        break;
                    case "Select":
                        formFieldBaseConfig.put("type", "ComboBox");
                        break;
                    case "Text":
                        formFieldBaseConfig.put("type", "Text");
                        break;
                    default:
                    throw new IllegalStateException("Unexpected value: " + fieldComponentType);
                    }

                    formFieldBaseConfig.put("title", fieldName);
                    formFieldBaseConfig.put("dataset", "chrgDtlDs");
                    formFieldBaseConfig.put("name", fieldId);
                    formFieldBaseConfig.put("moduleid", fieldDict);
                    formFieldBaseConfig.put("bizCode", "");
                    formFieldBaseConfig.put("format", "");
                    if ("true".equals(fieldOptional)) {
                    formFieldBaseConfig.put("required", "false");
                    } else {
                    formFieldBaseConfig.put("required", "true");
                    }

                    formFieldBaseConfig.put("length", fieldLen);
                    formFieldBaseConfig.put("columnStart", "");
                    formFieldBaseConfig.put("columnEnd", "");
                    formFieldBaseConfig.put("rowStart", "");
                    formFieldBaseConfig.put("rowEnd", "");
                    formFieldBaseConfig.put("width", "");
                    formFieldBaseConfig.put("height", "");
                    formFieldBaseConfig.put("enable", "true");
                    if ("true".equals(fieldReadOnly)) {
                    formFieldBaseConfig.put("readOnly", "true");
                    } else {
                    formFieldBaseConfig.put("readOnly", "false");
                    }
                    formFieldBaseConfig.put("visible", "true");
                    if ("true".equals(fieldColSpan)) {
                    formFieldBaseConfig.put("colSpan", "2");
                    formFieldBaseConfig.put("columnStart", "4");
                    formFieldBaseConfig.put("columnEnd", "12");
                    }


                    _frmCHRG_DTLItemList.add(formFieldBaseConfig);
                    }


                _frmCHRG_DTL.put("formItemList",_frmCHRG_DTLItemList);
                List<BaseConfig> _lfrmCHRG_DTL = new ArrayList<BaseConfig>();
                _lfrmCHRG_DTL.add(_frmCHRG_DTL);
                return _frmCHRG_DTL;
            }



	    private BaseConfig sub_table_resultTb() {
	        BaseConfig _resultTb = new BaseConfig();
	        _resultTb.setXmlTag("Table");
	        _resultTb.put("id", "resultTb");
	        _resultTb.put("selectField", "");
	        _resultTb.put("type", "Base");
	        _resultTb.put("title", "");
	        _resultTb.put("highLight", "true");
	        _resultTb.put("dataset", "resultDs");
	        _resultTb.put("width", "100%");
	        _resultTb.put("height", "180px");
	        _resultTb.put("pageLength", "10");
	        _resultTb.put("enable", "true");
	        _resultTb.put("readOnly", "false");
	        _resultTb.put("visible", "true");
	        _resultTb.put("reorderingAllowed", "true");
	        _resultTb.put("collapsingAllowed", "true");
	        List<BaseConfig> _resultTbFieldList = new ArrayList<BaseConfig>();



	        BaseConfig resultTb_CHK_FLAG = new BaseConfig();
	        resultTb_CHK_FLAG.setXmlTag("ListGridField");
	        resultTb_CHK_FLAG.put("type", "Base");
	        resultTb_CHK_FLAG.put("name", "CHK_FLAG");
	        resultTb_CHK_FLAG.put("id", "CHK_FLAG");
	        resultTb_CHK_FLAG.put("field", "CHK_FLAG");
	        resultTb_CHK_FLAG.put("title", "处理状态");
	        resultTb_CHK_FLAG.put("bizCode", "");
	        resultTb_CHK_FLAG.put("moduleid", "");
	        resultTb_CHK_FLAG.put("dropdown", "");
	        resultTb_CHK_FLAG.put("enable", "");
	        resultTb_CHK_FLAG.put("readOnly", "");
	        resultTb_CHK_FLAG.put("visible", "");
	        _resultTbFieldList.add(resultTb_CHK_FLAG);


	        BaseConfig resultTb_TXN_SEQ_NO = new BaseConfig();
	        resultTb_TXN_SEQ_NO.setXmlTag("ListGridField");
	        resultTb_TXN_SEQ_NO.put("type", "Base");
	        resultTb_TXN_SEQ_NO.put("name", "TXN_SEQ_NO");
	        resultTb_TXN_SEQ_NO.put("id", "TXN_SEQ_NO");
	        resultTb_TXN_SEQ_NO.put("field", "TXN_SEQ_NO");
	        resultTb_TXN_SEQ_NO.put("title", "交易流水号");
	        resultTb_TXN_SEQ_NO.put("bizCode", "");
	        resultTb_TXN_SEQ_NO.put("moduleid", "");
	        resultTb_TXN_SEQ_NO.put("dropdown", "");
	        resultTb_TXN_SEQ_NO.put("enable", "");
	        resultTb_TXN_SEQ_NO.put("readOnly", "");
	        resultTb_TXN_SEQ_NO.put("visible", "");
	        _resultTbFieldList.add(resultTb_TXN_SEQ_NO);


	        BaseConfig resultTb_AMT = new BaseConfig();
	        resultTb_AMT.setXmlTag("ListGridField");
	        resultTb_AMT.put("type", "Base");
	        resultTb_AMT.put("name", "AMT");
	        resultTb_AMT.put("id", "AMT");
	        resultTb_AMT.put("field", "AMT");
	        resultTb_AMT.put("title", "退汇金额");
	        resultTb_AMT.put("bizCode", "");
	        resultTb_AMT.put("moduleid", "");
	        resultTb_AMT.put("dropdown", "");
	        resultTb_AMT.put("enable", "");
	        resultTb_AMT.put("readOnly", "");
	        resultTb_AMT.put("visible", "");
	        _resultTbFieldList.add(resultTb_AMT);


	        BaseConfig resultTb_OTXN_MSG_TYPE = new BaseConfig();
	        resultTb_OTXN_MSG_TYPE.setXmlTag("ListGridField");
	        resultTb_OTXN_MSG_TYPE.put("type", "Base");
	        resultTb_OTXN_MSG_TYPE.put("name", "OTXN_MSG_TYPE");
	        resultTb_OTXN_MSG_TYPE.put("id", "OTXN_MSG_TYPE");
	        resultTb_OTXN_MSG_TYPE.put("field", "OTXN_MSG_TYPE");
	        resultTb_OTXN_MSG_TYPE.put("title", "原报文类型");
	        resultTb_OTXN_MSG_TYPE.put("bizCode", "");
	        resultTb_OTXN_MSG_TYPE.put("moduleid", "050116");
	        resultTb_OTXN_MSG_TYPE.put("dropdown", "");
	        resultTb_OTXN_MSG_TYPE.put("enable", "");
	        resultTb_OTXN_MSG_TYPE.put("readOnly", "");
	        resultTb_OTXN_MSG_TYPE.put("visible", "");
	        _resultTbFieldList.add(resultTb_OTXN_MSG_TYPE);


	        BaseConfig resultTb_OTXN_MSG_ID = new BaseConfig();
	        resultTb_OTXN_MSG_ID.setXmlTag("ListGridField");
	        resultTb_OTXN_MSG_ID.put("type", "Base");
	        resultTb_OTXN_MSG_ID.put("name", "OTXN_MSG_ID");
	        resultTb_OTXN_MSG_ID.put("id", "OTXN_MSG_ID");
	        resultTb_OTXN_MSG_ID.put("field", "OTXN_MSG_ID");
	        resultTb_OTXN_MSG_ID.put("title", "原报文标识号");
	        resultTb_OTXN_MSG_ID.put("bizCode", "");
	        resultTb_OTXN_MSG_ID.put("moduleid", "");
	        resultTb_OTXN_MSG_ID.put("dropdown", "");
	        resultTb_OTXN_MSG_ID.put("enable", "");
	        resultTb_OTXN_MSG_ID.put("readOnly", "");
	        resultTb_OTXN_MSG_ID.put("visible", "");
	        _resultTbFieldList.add(resultTb_OTXN_MSG_ID);


	        BaseConfig resultTb_OP_ST_BRNO = new BaseConfig();
	        resultTb_OP_ST_BRNO.setXmlTag("ListGridField");
	        resultTb_OP_ST_BRNO.put("type", "Base");
	        resultTb_OP_ST_BRNO.put("name", "OP_ST_BRNO");
	        resultTb_OP_ST_BRNO.put("id", "OP_ST_BRNO");
	        resultTb_OP_ST_BRNO.put("field", "OP_ST_BRNO");
	        resultTb_OP_ST_BRNO.put("title", "对手直接参与者行号");
	        resultTb_OP_ST_BRNO.put("bizCode", "");
	        resultTb_OP_ST_BRNO.put("moduleid", "");
	        resultTb_OP_ST_BRNO.put("dropdown", "");
	        resultTb_OP_ST_BRNO.put("enable", "");
	        resultTb_OP_ST_BRNO.put("readOnly", "");
	        resultTb_OP_ST_BRNO.put("visible", "");
	        _resultTbFieldList.add(resultTb_OP_ST_BRNO);


	        BaseConfig resultTb_OP_ST_BRNAME = new BaseConfig();
	        resultTb_OP_ST_BRNAME.setXmlTag("ListGridField");
	        resultTb_OP_ST_BRNAME.put("type", "Base");
	        resultTb_OP_ST_BRNAME.put("name", "OP_ST_BRNAME");
	        resultTb_OP_ST_BRNAME.put("id", "OP_ST_BRNAME");
	        resultTb_OP_ST_BRNAME.put("field", "OP_ST_BRNAME");
	        resultTb_OP_ST_BRNAME.put("title", "对手直接参与者行名");
	        resultTb_OP_ST_BRNAME.put("bizCode", "");
	        resultTb_OP_ST_BRNAME.put("moduleid", "");
	        resultTb_OP_ST_BRNAME.put("dropdown", "");
	        resultTb_OP_ST_BRNAME.put("enable", "");
	        resultTb_OP_ST_BRNAME.put("readOnly", "");
	        resultTb_OP_ST_BRNAME.put("visible", "");
	        _resultTbFieldList.add(resultTb_OP_ST_BRNAME);


	        _resultTb.put("tableFieldConfigList", _resultTbFieldList);
	        return _resultTb;
	    }
	    private BaseConfig sub_table_tbCHRG() {
	        BaseConfig _tbCHRG = new BaseConfig();
	        _tbCHRG.setXmlTag("Table");
	        _tbCHRG.put("id", "tbCHRG");
	        _tbCHRG.put("selectField", "");
	        _tbCHRG.put("type", "Base");
	        _tbCHRG.put("title", "");
	        _tbCHRG.put("highLight", "true");
	        _tbCHRG.put("dataset", "chrgDs");
	        _tbCHRG.put("width", "100%");
	        _tbCHRG.put("height", "180px");
	        _tbCHRG.put("pageLength", "10");
	        _tbCHRG.put("enable", "true");
	        _tbCHRG.put("readOnly", "false");
	        _tbCHRG.put("visible", "true");
	        _tbCHRG.put("reorderingAllowed", "true");
	        _tbCHRG.put("collapsingAllowed", "true");
	        List<BaseConfig> _tbCHRGFieldList = new ArrayList<BaseConfig>();



	        BaseConfig tbCHRG_CHRG_AMT = new BaseConfig();
	        tbCHRG_CHRG_AMT.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AMT.put("type", "Base");
	        tbCHRG_CHRG_AMT.put("name", "CHRG_AMT");
	        tbCHRG_CHRG_AMT.put("id", "CHRG_AMT");
	        tbCHRG_CHRG_AMT.put("field", "CHRG_AMT");
	        tbCHRG_CHRG_AMT.put("title", "金额");
	        tbCHRG_CHRG_AMT.put("bizCode", "");
	        tbCHRG_CHRG_AMT.put("moduleid", "");
	        tbCHRG_CHRG_AMT.put("dropdown", "");
	        tbCHRG_CHRG_AMT.put("enable", "");
	        tbCHRG_CHRG_AMT.put("readOnly", "");
	        tbCHRG_CHRG_AMT.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AMT);


	        BaseConfig tbCHRG_CHRG_AMT_CURCD = new BaseConfig();
	        tbCHRG_CHRG_AMT_CURCD.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AMT_CURCD.put("type", "Base");
	        tbCHRG_CHRG_AMT_CURCD.put("name", "CHRG_AMT_CURCD");
	        tbCHRG_CHRG_AMT_CURCD.put("id", "CHRG_AMT_CURCD");
	        tbCHRG_CHRG_AMT_CURCD.put("field", "CHRG_AMT_CURCD");
	        tbCHRG_CHRG_AMT_CURCD.put("title", "金额币种");
	        tbCHRG_CHRG_AMT_CURCD.put("bizCode", "");
	        tbCHRG_CHRG_AMT_CURCD.put("moduleid", "900001");
	        tbCHRG_CHRG_AMT_CURCD.put("dropdown", "");
	        tbCHRG_CHRG_AMT_CURCD.put("enable", "");
	        tbCHRG_CHRG_AMT_CURCD.put("readOnly", "");
	        tbCHRG_CHRG_AMT_CURCD.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AMT_CURCD);


	        BaseConfig tbCHRG_CHRG_AGT_BIC = new BaseConfig();
	        tbCHRG_CHRG_AGT_BIC.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_BIC.put("type", "Base");
	        tbCHRG_CHRG_AGT_BIC.put("name", "CHRG_AGT_BIC");
	        tbCHRG_CHRG_AGT_BIC.put("id", "CHRG_AGT_BIC");
	        tbCHRG_CHRG_AGT_BIC.put("field", "CHRG_AGT_BIC");
	        tbCHRG_CHRG_AGT_BIC.put("title", "BIC码");
	        tbCHRG_CHRG_AGT_BIC.put("bizCode", "");
	        tbCHRG_CHRG_AGT_BIC.put("moduleid", "");
	        tbCHRG_CHRG_AGT_BIC.put("dropdown", "");
	        tbCHRG_CHRG_AGT_BIC.put("enable", "");
	        tbCHRG_CHRG_AGT_BIC.put("readOnly", "");
	        tbCHRG_CHRG_AGT_BIC.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_BIC);


	        BaseConfig tbCHRG_CHRG_AGT_CLR_SYS = new BaseConfig();
	        tbCHRG_CHRG_AGT_CLR_SYS.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("type", "Base");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("name", "CHRG_AGT_CLR_SYS");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("id", "CHRG_AGT_CLR_SYS");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("field", "CHRG_AGT_CLR_SYS");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("title", "清算系统标识（代码）");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("bizCode", "");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("moduleid", "");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("dropdown", "");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("enable", "");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("readOnly", "");
	        tbCHRG_CHRG_AGT_CLR_SYS.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_CLR_SYS);


	        BaseConfig tbCHRG_CHRG_AGT_CLR_SYS_MMBID = new BaseConfig();
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("type", "Base");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("name", "CHRG_AGT_CLR_SYS_MMBID");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("id", "CHRG_AGT_CLR_SYS_MMBID");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("field", "CHRG_AGT_CLR_SYS_MMBID");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("title", "参与者身份标识");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("bizCode", "");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("moduleid", "");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("dropdown", "");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("enable", "");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("readOnly", "");
	        tbCHRG_CHRG_AGT_CLR_SYS_MMBID.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_CLR_SYS_MMBID);


	        BaseConfig tbCHRG_CHRG_AGT_LEI = new BaseConfig();
	        tbCHRG_CHRG_AGT_LEI.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_LEI.put("type", "Base");
	        tbCHRG_CHRG_AGT_LEI.put("name", "CHRG_AGT_LEI");
	        tbCHRG_CHRG_AGT_LEI.put("id", "CHRG_AGT_LEI");
	        tbCHRG_CHRG_AGT_LEI.put("field", "CHRG_AGT_LEI");
	        tbCHRG_CHRG_AGT_LEI.put("title", "LEI码");
	        tbCHRG_CHRG_AGT_LEI.put("bizCode", "");
	        tbCHRG_CHRG_AGT_LEI.put("moduleid", "");
	        tbCHRG_CHRG_AGT_LEI.put("dropdown", "");
	        tbCHRG_CHRG_AGT_LEI.put("enable", "");
	        tbCHRG_CHRG_AGT_LEI.put("readOnly", "");
	        tbCHRG_CHRG_AGT_LEI.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_LEI);


	        BaseConfig tbCHRG_CHRG_AGT_NAME = new BaseConfig();
	        tbCHRG_CHRG_AGT_NAME.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_NAME.put("type", "Base");
	        tbCHRG_CHRG_AGT_NAME.put("name", "CHRG_AGT_NAME");
	        tbCHRG_CHRG_AGT_NAME.put("id", "CHRG_AGT_NAME");
	        tbCHRG_CHRG_AGT_NAME.put("field", "CHRG_AGT_NAME");
	        tbCHRG_CHRG_AGT_NAME.put("title", "名称");
	        tbCHRG_CHRG_AGT_NAME.put("bizCode", "");
	        tbCHRG_CHRG_AGT_NAME.put("moduleid", "");
	        tbCHRG_CHRG_AGT_NAME.put("dropdown", "");
	        tbCHRG_CHRG_AGT_NAME.put("enable", "");
	        tbCHRG_CHRG_AGT_NAME.put("readOnly", "");
	        tbCHRG_CHRG_AGT_NAME.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_NAME);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_M = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_M.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_M.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_M.put("name", "CHRG_AGT_ADR_M");
	        tbCHRG_CHRG_AGT_ADR_M.put("id", "CHRG_AGT_ADR_M");
	        tbCHRG_CHRG_AGT_ADR_M.put("field", "CHRG_AGT_ADR_M");
	        tbCHRG_CHRG_AGT_ADR_M.put("title", "地址");
	        tbCHRG_CHRG_AGT_ADR_M.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_M.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_M.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_M.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_M.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_M.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_M);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_DEPT = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_DEPT.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("name", "CHRG_AGT_ADR_DEPT");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("id", "CHRG_AGT_ADR_DEPT");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("field", "CHRG_AGT_ADR_DEPT");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("title", "地址_部门");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_DEPT.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_DEPT);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_SDEPT = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_SDEPT.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("name", "CHRG_AGT_ADR_SDEPT");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("id", "CHRG_AGT_ADR_SDEPT");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("field", "CHRG_AGT_ADR_SDEPT");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("title", "地址_分部");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_SDEPT.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_SDEPT);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_STRT_NM = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("name", "CHRG_AGT_ADR_STRT_NM");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("id", "CHRG_AGT_ADR_STRT_NM");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("field", "CHRG_AGT_ADR_STRT_NM");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("title", "地址_街道名称");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_STRT_NM.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_STRT_NM);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_BLDG_NB = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("name", "CHRG_AGT_ADR_BLDG_NB");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("id", "CHRG_AGT_ADR_BLDG_NB");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("field", "CHRG_AGT_ADR_BLDG_NB");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("title", "地址_建筑编号");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NB.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_BLDG_NB);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_BLDG_NM = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("name", "CHRG_AGT_ADR_BLDG_NM");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("id", "CHRG_AGT_ADR_BLDG_NM");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("field", "CHRG_AGT_ADR_BLDG_NM");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("title", "地址_建筑名称");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_BLDG_NM.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_BLDG_NM);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_FLR = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_FLR.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("name", "CHRG_AGT_ADR_FLR");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("id", "CHRG_AGT_ADR_FLR");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("field", "CHRG_AGT_ADR_FLR");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("title", "地址_建筑楼层");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_FLR.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_FLR);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_PST_BX = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_PST_BX.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("name", "CHRG_AGT_ADR_PST_BX");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("id", "CHRG_AGT_ADR_PST_BX");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("field", "CHRG_AGT_ADR_PST_BX");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("title", "地址_邮政信箱");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_PST_BX.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_PST_BX);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_ROOM = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_ROOM.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("name", "CHRG_AGT_ADR_ROOM");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("id", "CHRG_AGT_ADR_ROOM");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("field", "CHRG_AGT_ADR_ROOM");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("title", "地址_房间号");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_ROOM.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_ROOM);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_PST_CD = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_PST_CD.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("name", "CHRG_AGT_ADR_PST_CD");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("id", "CHRG_AGT_ADR_PST_CD");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("field", "CHRG_AGT_ADR_PST_CD");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("title", "地址_邮政编码");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_PST_CD.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_PST_CD);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_TWN = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_TWN.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("name", "CHRG_AGT_ADR_TWN");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("id", "CHRG_AGT_ADR_TWN");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("field", "CHRG_AGT_ADR_TWN");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("title", "地址_城镇名称");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_TWN.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_TWN);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_TWN_LOC = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("name", "CHRG_AGT_ADR_TWN_LOC");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("id", "CHRG_AGT_ADR_TWN_LOC");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("field", "CHRG_AGT_ADR_TWN_LOC");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("title", "地址_城镇地址");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_TWN_LOC.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_TWN_LOC);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_DSTRCT = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("name", "CHRG_AGT_ADR_DSTRCT");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("id", "CHRG_AGT_ADR_DSTRCT");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("field", "CHRG_AGT_ADR_DSTRCT");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("title", "地址_地区名称");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_DSTRCT.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_DSTRCT);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_AREA = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_AREA.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("name", "CHRG_AGT_ADR_AREA");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("id", "CHRG_AGT_ADR_AREA");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("field", "CHRG_AGT_ADR_AREA");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("title", "地址_国家区域（区/洲）");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_AREA.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_AREA);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_CTRY = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_CTRY.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("name", "CHRG_AGT_ADR_CTRY");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("id", "CHRG_AGT_ADR_CTRY");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("field", "CHRG_AGT_ADR_CTRY");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("title", "地址_国家");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("moduleid", "050022");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_CTRY.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_CTRY);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_ADR_LINE1 = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("name", "CHRG_AGT_ADR_ADR_LINE1");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("id", "CHRG_AGT_ADR_ADR_LINE1");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("field", "CHRG_AGT_ADR_ADR_LINE1");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("title", "地址_自由格式地址1");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE1.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_ADR_LINE1);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_ADR_LINE2 = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("name", "CHRG_AGT_ADR_ADR_LINE2");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("id", "CHRG_AGT_ADR_ADR_LINE2");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("field", "CHRG_AGT_ADR_ADR_LINE2");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("title", "地址_自由格式地址2");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE2.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_ADR_LINE2);


	        BaseConfig tbCHRG_CHRG_AGT_ADR_ADR_LINE3 = new BaseConfig();
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.setXmlTag("ListGridField");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("type", "Base");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("name", "CHRG_AGT_ADR_ADR_LINE3");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("id", "CHRG_AGT_ADR_ADR_LINE3");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("field", "CHRG_AGT_ADR_ADR_LINE3");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("title", "地址_自由格式地址3");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("bizCode", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("moduleid", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("dropdown", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("enable", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("readOnly", "");
	        tbCHRG_CHRG_AGT_ADR_ADR_LINE3.put("visible", "");
	        _tbCHRGFieldList.add(tbCHRG_CHRG_AGT_ADR_ADR_LINE3);


	        _tbCHRG.put("tableFieldConfigList", _tbCHRGFieldList);
	        return _tbCHRG;
	    }




    @Override
    protected void afterInitControls() {
        super.afterInitControls();

        // Dataset
        resultDs = (ViewDataset)this.getDatasets().get("resultDs");
        chrgDs = (ViewDataset)this.getDatasets().get("chrgDs");
        queryDs = (ViewDataset)this.getDatasets().get("queryDs");
        inputDs = (ViewDataset)this.getDatasets().get("inputDs");
        chrgDtlDs = (ViewDataset)this.getDatasets().get("chrgDtlDs");

        // Command
        BTN_INQ_Cmd = (DatasetCommand)this.getCommands().get("BTN_INQ_Cmd");
        SUBWINDOW_Cmd = (DatasetCommand)this.getCommands().get("SUBWINDOW_Cmd");
        SUBWINDOW_Cmd2 = (DatasetCommand)this.getCommands().get("SUBWINDOW_Cmd2");
        BTN_SUB_OK_Cmd = (DatasetCommand)this.getCommands().get("BTN_SUB_OK_Cmd");
        BTN_SUB_REJ_Cmd = (DatasetCommand)this.getCommands().get("BTN_SUB_REJ_Cmd");

        // Form
        frmCXTJ = (UDynamicForm)this.getControls().get("frmCXTJ");
        frmCXTJ_WORK_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("WORK_DATE");
        frmCXTJ_TXN_SEQ_NO = (UTextItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("TXN_SEQ_NO");
        frmCXTJ_START_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("START_AMT");
        frmCXTJ_END_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("END_AMT");
        frmCXTJ_OTXN_MSG_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("OTXN_MSG_ID");
        frmCXTJ_MADE_USER = (UTextItem)((UDynamicForm)this.getControls().get("frmCXTJ")).getField("MADE_USER");
        frmHEAD = (UDynamicForm)this.getControls().get("frmHEAD");
        frmHEAD_MSG_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmHEAD")).getField("MSG_ID");
        frmHEAD_MSG_SND_TIME = (UTextItem)((UDynamicForm)this.getControls().get("frmHEAD")).getField("MSG_SND_TIME");
        frmHEAD_TXN_NUM = (UTextItem)((UDynamicForm)this.getControls().get("frmHEAD")).getField("TXN_NUM");
        frmHEAD_ST_METHOD = (UTextItem)((UDynamicForm)this.getControls().get("frmHEAD")).getField("ST_METHOD");
        frmHEAD_CLR_SYS_REF = (UTextItem)((UDynamicForm)this.getControls().get("frmHEAD")).getField("CLR_SYS_REF");
        frmSTAC = (UDynamicForm)this.getControls().get("frmSTAC");
        frmSTAC_ST_AC_IBAN = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_IBAN");
        frmSTAC_ST_AC_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_ID");
        frmSTAC_ST_AC_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_ID_SCHE");
        frmSTAC_ST_AC_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_ID_SCHEX");
        frmSTAC_ST_AC_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_ID_ISSR");
        frmSTAC_ST_AC_TYPE = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_TYPE");
        frmSTAC_ST_AC_TYPEX = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_TYPEX");
        frmSTAC_ST_AC_CCY = (USelectItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_CCY");
        frmSTAC_ST_AC_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_NAME");
        frmSTAC_ST_AC_AKA_ID_TP = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_AKA_ID_TP");
        frmSTAC_ST_AC_AKA_ID_TPX = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_AKA_ID_TPX");
        frmSTAC_ST_AC_AKA_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmSTAC")).getField("ST_AC_AKA_ID");
        frmSCENARIO = (UDynamicForm)this.getControls().get("frmSCENARIO");
        frmSCENARIO_RETURN_SCENARIO = (USelectItem)((UDynamicForm)this.getControls().get("frmSCENARIO")).getField("RETURN_SCENARIO");
        frmORITXN = (UDynamicForm)this.getControls().get("frmORITXN");
        frmORITXN_OTXN_MSG_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_MSG_ID");
        frmORITXN_OTXN_MSG_TYPE = (USelectItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_MSG_TYPE");
        frmORITXN_OTXN_MSG_SND_TIME = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_MSG_SND_TIME");
        frmORITXN_OTXN_INSTR_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_INSTR_ID");
        frmORITXN_OTXN_E2E_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_E2E_ID");
        frmORITXN_OTXN_TXN_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_TXN_ID");
        frmORITXN_OTXN_UETR = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_UETR");
        frmORITXN_OTXN_CLR_SYS_REF = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_CLR_SYS_REF");
        frmORITXN_OTXN_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_AMT");
        frmORITXN_OTXN_AMT_CURCD = (USelectItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_AMT_CURCD");
        frmORITXN_OTXN_ST_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_ST_DATE");
        frmORITXN_OTXN_BIZ_CATE_CODE = (UTextItem)((UDynamicForm)this.getControls().get("frmORITXN")).getField("OTXN_BIZ_CATE_CODE");
        frmRTR = (UDynamicForm)this.getControls().get("frmRTR");
        frmRTR_RTR_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTR_ID");
        frmRTR_RTRD_ST_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTRD_ST_AMT");
        frmRTR_RTRD_ST_AMT_CURCD = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTRD_ST_AMT_CURCD");
        frmRTR_ST_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ST_DATE");
        frmRTR_ST_PRIO = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ST_PRIO");
        frmRTR_ST_DR_TIME = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ST_DR_TIME");
        frmRTR_ST_CR_TIME = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ST_CR_TIME");
        frmRTR_RTRD_INSTD_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTRD_INSTD_AMT");
        frmRTR_RTRD_INSTD_AMT_CURCD = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTRD_INSTD_AMT_CURCD");
        frmRTR_FX_RATE = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("FX_RATE");
        frmRTR_CHRG_BEAR = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("CHRG_BEAR");
        frmRTR_RTR_REASON_CD = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("RTR_REASON_CD");
        frmRTR_ADDTL_INF1 = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ADDTL_INF1");
        frmRTR_ADDTL_INF2 = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR")).getField("ADDTL_INF2");
        frmINSTG = (UDynamicForm)this.getControls().get("frmINSTG");
        frmINSTG_INSTG_AGT_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTG")).getField("INSTG_AGT_BIC");
        frmINSTG_INSTG_AGT_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTG")).getField("INSTG_AGT_CLR_SYS");
        frmINSTG_INSTG_AGT_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTG")).getField("INSTG_AGT_CLR_SYS_MMBID");
        frmINSTG_INSTG_AGT_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTG")).getField("INSTG_AGT_LEI");
        frmINSTD = (UDynamicForm)this.getControls().get("frmINSTD");
        frmINSTD_INSTD_AGT_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTD")).getField("INSTD_AGT_BIC");
        frmINSTD_INSTD_AGT_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTD")).getField("INSTD_AGT_CLR_SYS");
        frmINSTD_INSTD_AGT_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTD")).getField("INSTD_AGT_CLR_SYS_MMBID");
        frmINSTD_INSTD_AGT_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmINSTD")).getField("INSTD_AGT_LEI");
        frmUDBTR = (UDynamicForm)this.getControls().get("frmUDBTR");
        frmUDBTR_UDBTR_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_NAME");
        frmUDBTR_UDBTR_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_M");
        frmUDBTR_UDBTR_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_DEPT");
        frmUDBTR_UDBTR_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_SDEPT");
        frmUDBTR_UDBTR_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_STRT_NM");
        frmUDBTR_UDBTR_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_BLDG_NB");
        frmUDBTR_UDBTR_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_BLDG_NM");
        frmUDBTR_UDBTR_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_FLR");
        frmUDBTR_UDBTR_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_PST_BX");
        frmUDBTR_UDBTR_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_ROOM");
        frmUDBTR_UDBTR_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_PST_CD");
        frmUDBTR_UDBTR_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_TWN");
        frmUDBTR_UDBTR_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_TWN_LOC");
        frmUDBTR_UDBTR_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_DSTRCT");
        frmUDBTR_UDBTR_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_AREA");
        frmUDBTR_UDBTR_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_ADR_CTRY");
        frmUDBTR_UDBTR_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_BIC");
        frmUDBTR_UDBTR_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_LEI");
        frmUDBTR_UDBTR_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_ID");
        frmUDBTR_UDBTR_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_ID_SCHE");
        frmUDBTR_UDBTR_C_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_ID_SCHEX");
        frmUDBTR_UDBTR_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_C_ID_ISSR");
        frmUDBTR_UDBTR_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_BIRTH_DATE");
        frmUDBTR_UDBTR_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_BIRTH_PRVC");
        frmUDBTR_UDBTR_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_BIRTH_CITY");
        frmUDBTR_UDBTR_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_BIRTH_CTRY");
        frmUDBTR_UDBTR_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_ID");
        frmUDBTR_UDBTR_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_ID_SCHE");
        frmUDBTR_UDBTR_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_ID_SCHEX");
        frmUDBTR_UDBTR_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_P_ID_ISSR");
        frmUDBTR_UDBTR_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUDBTR")).getField("UDBTR_RES_CTRY");
        frmDBTR_PTY = (UDynamicForm)this.getControls().get("frmDBTR_PTY");
        frmDBTR_PTY_DBTR_PTY_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_NAME");
        frmDBTR_PTY_DBTR_PTY_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_M");
        frmDBTR_PTY_DBTR_PTY_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_DEPT");
        frmDBTR_PTY_DBTR_PTY_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_SDEPT");
        frmDBTR_PTY_DBTR_PTY_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_STRT_NM");
        frmDBTR_PTY_DBTR_PTY_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_BLDG_NB");
        frmDBTR_PTY_DBTR_PTY_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_BLDG_NM");
        frmDBTR_PTY_DBTR_PTY_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_FLR");
        frmDBTR_PTY_DBTR_PTY_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_PST_BX");
        frmDBTR_PTY_DBTR_PTY_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_ROOM");
        frmDBTR_PTY_DBTR_PTY_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_PST_CD");
        frmDBTR_PTY_DBTR_PTY_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_TWN");
        frmDBTR_PTY_DBTR_PTY_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_TWN_LOC");
        frmDBTR_PTY_DBTR_PTY_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_DSTRCT");
        frmDBTR_PTY_DBTR_PTY_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_AREA");
        frmDBTR_PTY_DBTR_PTY_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_CTRY");
        frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_ADR_LINE1");
        frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_ADR_LINE2");
        frmDBTR_PTY_DBTR_PTY_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_ADR_ADR_LINE3");
        frmDBTR_PTY_DBTR_PTY_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_C_BIC");
        frmDBTR_PTY_DBTR_PTY_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_C_LEI");
        frmDBTR_PTY_DBTR_PTY_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_C_ID");
        frmDBTR_PTY_DBTR_PTY_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_C_ID_SCHE");
        frmDBTR_PTY_DBTR_PTY_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_C_ID_ISSR");
        frmDBTR_PTY_DBTR_PTY_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_BIRTH_DATE");
        frmDBTR_PTY_DBTR_PTY_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_BIRTH_PRVC");
        frmDBTR_PTY_DBTR_PTY_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_BIRTH_CITY");
        frmDBTR_PTY_DBTR_PTY_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_BIRTH_CTRY");
        frmDBTR_PTY_DBTR_PTY_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_ID");
        frmDBTR_PTY_DBTR_PTY_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_ID_SCHE");
        frmDBTR_PTY_DBTR_PTY_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_ID_SCHEX");
        frmDBTR_PTY_DBTR_PTY_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_P_ID_ISSR");
        frmDBTR_PTY_DBTR_PTY_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_PTY")).getField("DBTR_PTY_RES_CTRY");
        frmDBTR_PTYF = (UDynamicForm)this.getControls().get("frmDBTR_PTYF");
        frmDBTR_PTYF_DBTR_PTYF_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_BIC");
        frmDBTR_PTYF_DBTR_PTYF_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_CLR_SYS");
        frmDBTR_PTYF_DBTR_PTYF_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_CLR_SYS_MMBID");
        frmDBTR_PTYF_DBTR_PTYF_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_LEI");
        frmDBTR_PTYF_DBTR_PTYF_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_NAME");
        frmDBTR_PTYF_DBTR_PTYF_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_M");
        frmDBTR_PTYF_DBTR_PTYF_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_DEPT");
        frmDBTR_PTYF_DBTR_PTYF_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_SDEPT");
        frmDBTR_PTYF_DBTR_PTYF_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_STRT_NM");
        frmDBTR_PTYF_DBTR_PTYF_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_BLDG_NB");
        frmDBTR_PTYF_DBTR_PTYF_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_BLDG_NM");
        frmDBTR_PTYF_DBTR_PTYF_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_FLR");
        frmDBTR_PTYF_DBTR_PTYF_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_PST_BX");
        frmDBTR_PTYF_DBTR_PTYF_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_ROOM");
        frmDBTR_PTYF_DBTR_PTYF_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_PST_CD");
        frmDBTR_PTYF_DBTR_PTYF_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_TWN");
        frmDBTR_PTYF_DBTR_PTYF_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_TWN_LOC");
        frmDBTR_PTYF_DBTR_PTYF_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_DSTRCT");
        frmDBTR_PTYF_DBTR_PTYF_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_AREA");
        frmDBTR_PTYF_DBTR_PTYF_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_CTRY");
        frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_ADR_LINE1");
        frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_ADR_LINE2");
        frmDBTR_PTYF_DBTR_PTYF_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_PTYF")).getField("DBTR_PTYF_ADR_ADR_LINE3");
        frmINIT_PTY = (UDynamicForm)this.getControls().get("frmINIT_PTY");
        frmINIT_PTY_INIT_PTY_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_NAME");
        frmINIT_PTY_INIT_PTY_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_M");
        frmINIT_PTY_INIT_PTY_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_DEPT");
        frmINIT_PTY_INIT_PTY_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_SDEPT");
        frmINIT_PTY_INIT_PTY_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_STRT_NM");
        frmINIT_PTY_INIT_PTY_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_BLDG_NB");
        frmINIT_PTY_INIT_PTY_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_BLDG_NM");
        frmINIT_PTY_INIT_PTY_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_FLR");
        frmINIT_PTY_INIT_PTY_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_PST_BX");
        frmINIT_PTY_INIT_PTY_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_ROOM");
        frmINIT_PTY_INIT_PTY_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_PST_CD");
        frmINIT_PTY_INIT_PTY_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_TWN");
        frmINIT_PTY_INIT_PTY_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_TWN_LOC");
        frmINIT_PTY_INIT_PTY_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_DSTRCT");
        frmINIT_PTY_INIT_PTY_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_AREA");
        frmINIT_PTY_INIT_PTY_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_ADR_CTRY");
        frmINIT_PTY_INIT_PTY_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_BIC");
        frmINIT_PTY_INIT_PTY_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_LEI");
        frmINIT_PTY_INIT_PTY_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_ID");
        frmINIT_PTY_INIT_PTY_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_ID_SCHE");
        frmINIT_PTY_INIT_PTY_C_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_ID_SCHEX");
        frmINIT_PTY_INIT_PTY_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_C_ID_ISSR");
        frmINIT_PTY_INIT_PTY_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_BIRTH_DATE");
        frmINIT_PTY_INIT_PTY_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_BIRTH_PRVC");
        frmINIT_PTY_INIT_PTY_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_BIRTH_CITY");
        frmINIT_PTY_INIT_PTY_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_BIRTH_CTRY");
        frmINIT_PTY_INIT_PTY_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_ID");
        frmINIT_PTY_INIT_PTY_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_ID_SCHE");
        frmINIT_PTY_INIT_PTY_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_ID_SCHEX");
        frmINIT_PTY_INIT_PTY_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_P_ID_ISSR");
        frmINIT_PTY_INIT_PTY_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmINIT_PTY")).getField("INIT_PTY_RES_CTRY");
        frmDBTR_AGT = (UDynamicForm)this.getControls().get("frmDBTR_AGT");
        frmDBTR_AGT_DBTR_AGT_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_BIC");
        frmDBTR_AGT_DBTR_AGT_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_CLR_SYS");
        frmDBTR_AGT_DBTR_AGT_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_CLR_SYS_MMBID");
        frmDBTR_AGT_DBTR_AGT_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_LEI");
        frmDBTR_AGT_DBTR_AGT_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_NAME");
        frmDBTR_AGT_DBTR_AGT_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_M");
        frmDBTR_AGT_DBTR_AGT_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_DEPT");
        frmDBTR_AGT_DBTR_AGT_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_SDEPT");
        frmDBTR_AGT_DBTR_AGT_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_STRT_NM");
        frmDBTR_AGT_DBTR_AGT_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_BLDG_NB");
        frmDBTR_AGT_DBTR_AGT_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_BLDG_NM");
        frmDBTR_AGT_DBTR_AGT_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_FLR");
        frmDBTR_AGT_DBTR_AGT_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_PST_BX");
        frmDBTR_AGT_DBTR_AGT_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_ROOM");
        frmDBTR_AGT_DBTR_AGT_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_PST_CD");
        frmDBTR_AGT_DBTR_AGT_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_TWN");
        frmDBTR_AGT_DBTR_AGT_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_TWN_LOC");
        frmDBTR_AGT_DBTR_AGT_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_DSTRCT");
        frmDBTR_AGT_DBTR_AGT_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_AREA");
        frmDBTR_AGT_DBTR_AGT_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_CTRY");
        frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_ADR_LINE1");
        frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_ADR_LINE2");
        frmDBTR_AGT_DBTR_AGT_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmDBTR_AGT")).getField("DBTR_AGT_ADR_ADR_LINE3");
        frmPRE_AGT1 = (UDynamicForm)this.getControls().get("frmPRE_AGT1");
        frmPRE_AGT1_PRE_AGT1_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_BIC");
        frmPRE_AGT1_PRE_AGT1_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_CLR_SYS");
        frmPRE_AGT1_PRE_AGT1_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_CLR_SYS_MMBID");
        frmPRE_AGT1_PRE_AGT1_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_LEI");
        frmPRE_AGT1_PRE_AGT1_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_NAME");
        frmPRE_AGT1_PRE_AGT1_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_M");
        frmPRE_AGT1_PRE_AGT1_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_DEPT");
        frmPRE_AGT1_PRE_AGT1_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_SDEPT");
        frmPRE_AGT1_PRE_AGT1_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_STRT_NM");
        frmPRE_AGT1_PRE_AGT1_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_BLDG_NB");
        frmPRE_AGT1_PRE_AGT1_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_BLDG_NM");
        frmPRE_AGT1_PRE_AGT1_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_FLR");
        frmPRE_AGT1_PRE_AGT1_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_PST_BX");
        frmPRE_AGT1_PRE_AGT1_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_ROOM");
        frmPRE_AGT1_PRE_AGT1_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_PST_CD");
        frmPRE_AGT1_PRE_AGT1_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_TWN");
        frmPRE_AGT1_PRE_AGT1_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_TWN_LOC");
        frmPRE_AGT1_PRE_AGT1_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_DSTRCT");
        frmPRE_AGT1_PRE_AGT1_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_AREA");
        frmPRE_AGT1_PRE_AGT1_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_CTRY");
        frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_ADR_LINE1");
        frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_ADR_LINE2");
        frmPRE_AGT1_PRE_AGT1_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT1")).getField("PRE_AGT1_ADR_ADR_LINE3");
        frmPRE_AGT2 = (UDynamicForm)this.getControls().get("frmPRE_AGT2");
        frmPRE_AGT2_PRE_AGT2_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_BIC");
        frmPRE_AGT2_PRE_AGT2_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_CLR_SYS");
        frmPRE_AGT2_PRE_AGT2_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_CLR_SYS_MMBID");
        frmPRE_AGT2_PRE_AGT2_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_LEI");
        frmPRE_AGT2_PRE_AGT2_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_NAME");
        frmPRE_AGT2_PRE_AGT2_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_M");
        frmPRE_AGT2_PRE_AGT2_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_DEPT");
        frmPRE_AGT2_PRE_AGT2_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_SDEPT");
        frmPRE_AGT2_PRE_AGT2_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_STRT_NM");
        frmPRE_AGT2_PRE_AGT2_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_BLDG_NB");
        frmPRE_AGT2_PRE_AGT2_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_BLDG_NM");
        frmPRE_AGT2_PRE_AGT2_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_FLR");
        frmPRE_AGT2_PRE_AGT2_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_PST_BX");
        frmPRE_AGT2_PRE_AGT2_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_ROOM");
        frmPRE_AGT2_PRE_AGT2_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_PST_CD");
        frmPRE_AGT2_PRE_AGT2_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_TWN");
        frmPRE_AGT2_PRE_AGT2_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_TWN_LOC");
        frmPRE_AGT2_PRE_AGT2_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_DSTRCT");
        frmPRE_AGT2_PRE_AGT2_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_AREA");
        frmPRE_AGT2_PRE_AGT2_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_CTRY");
        frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_ADR_LINE1");
        frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_ADR_LINE2");
        frmPRE_AGT2_PRE_AGT2_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT2")).getField("PRE_AGT2_ADR_ADR_LINE3");
        frmPRE_AGT3 = (UDynamicForm)this.getControls().get("frmPRE_AGT3");
        frmPRE_AGT3_PRE_AGT3_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_BIC");
        frmPRE_AGT3_PRE_AGT3_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_CLR_SYS");
        frmPRE_AGT3_PRE_AGT3_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_CLR_SYS_MMBID");
        frmPRE_AGT3_PRE_AGT3_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_LEI");
        frmPRE_AGT3_PRE_AGT3_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_NAME");
        frmPRE_AGT3_PRE_AGT3_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_M");
        frmPRE_AGT3_PRE_AGT3_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_DEPT");
        frmPRE_AGT3_PRE_AGT3_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_SDEPT");
        frmPRE_AGT3_PRE_AGT3_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_STRT_NM");
        frmPRE_AGT3_PRE_AGT3_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_BLDG_NB");
        frmPRE_AGT3_PRE_AGT3_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_BLDG_NM");
        frmPRE_AGT3_PRE_AGT3_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_FLR");
        frmPRE_AGT3_PRE_AGT3_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_PST_BX");
        frmPRE_AGT3_PRE_AGT3_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_ROOM");
        frmPRE_AGT3_PRE_AGT3_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_PST_CD");
        frmPRE_AGT3_PRE_AGT3_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_TWN");
        frmPRE_AGT3_PRE_AGT3_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_TWN_LOC");
        frmPRE_AGT3_PRE_AGT3_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_DSTRCT");
        frmPRE_AGT3_PRE_AGT3_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_AREA");
        frmPRE_AGT3_PRE_AGT3_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_CTRY");
        frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_ADR_LINE1");
        frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_ADR_LINE2");
        frmPRE_AGT3_PRE_AGT3_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmPRE_AGT3")).getField("PRE_AGT3_ADR_ADR_LINE3");
        frmIM_AGT1 = (UDynamicForm)this.getControls().get("frmIM_AGT1");
        frmIM_AGT1_IM_AGT1_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_BIC");
        frmIM_AGT1_IM_AGT1_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_CLR_SYS");
        frmIM_AGT1_IM_AGT1_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_CLR_SYS_MMBID");
        frmIM_AGT1_IM_AGT1_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_LEI");
        frmIM_AGT1_IM_AGT1_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_NAME");
        frmIM_AGT1_IM_AGT1_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_M");
        frmIM_AGT1_IM_AGT1_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_DEPT");
        frmIM_AGT1_IM_AGT1_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_SDEPT");
        frmIM_AGT1_IM_AGT1_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_STRT_NM");
        frmIM_AGT1_IM_AGT1_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_BLDG_NB");
        frmIM_AGT1_IM_AGT1_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_BLDG_NM");
        frmIM_AGT1_IM_AGT1_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_FLR");
        frmIM_AGT1_IM_AGT1_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_PST_BX");
        frmIM_AGT1_IM_AGT1_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_ROOM");
        frmIM_AGT1_IM_AGT1_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_PST_CD");
        frmIM_AGT1_IM_AGT1_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_TWN");
        frmIM_AGT1_IM_AGT1_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_TWN_LOC");
        frmIM_AGT1_IM_AGT1_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_DSTRCT");
        frmIM_AGT1_IM_AGT1_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_AREA");
        frmIM_AGT1_IM_AGT1_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_CTRY");
        frmIM_AGT1_IM_AGT1_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_ADR_LINE1");
        frmIM_AGT1_IM_AGT1_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_ADR_LINE2");
        frmIM_AGT1_IM_AGT1_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT1")).getField("IM_AGT1_ADR_ADR_LINE3");
        frmIM_AGT2 = (UDynamicForm)this.getControls().get("frmIM_AGT2");
        frmIM_AGT2_IM_AGT2_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_BIC");
        frmIM_AGT2_IM_AGT2_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_CLR_SYS");
        frmIM_AGT2_IM_AGT2_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_CLR_SYS_MMBID");
        frmIM_AGT2_IM_AGT2_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_LEI");
        frmIM_AGT2_IM_AGT2_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_NAME");
        frmIM_AGT2_IM_AGT2_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_M");
        frmIM_AGT2_IM_AGT2_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_DEPT");
        frmIM_AGT2_IM_AGT2_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_SDEPT");
        frmIM_AGT2_IM_AGT2_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_STRT_NM");
        frmIM_AGT2_IM_AGT2_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_BLDG_NB");
        frmIM_AGT2_IM_AGT2_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_BLDG_NM");
        frmIM_AGT2_IM_AGT2_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_FLR");
        frmIM_AGT2_IM_AGT2_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_PST_BX");
        frmIM_AGT2_IM_AGT2_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_ROOM");
        frmIM_AGT2_IM_AGT2_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_PST_CD");
        frmIM_AGT2_IM_AGT2_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_TWN");
        frmIM_AGT2_IM_AGT2_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_TWN_LOC");
        frmIM_AGT2_IM_AGT2_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_DSTRCT");
        frmIM_AGT2_IM_AGT2_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_AREA");
        frmIM_AGT2_IM_AGT2_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_CTRY");
        frmIM_AGT2_IM_AGT2_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_ADR_LINE1");
        frmIM_AGT2_IM_AGT2_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_ADR_LINE2");
        frmIM_AGT2_IM_AGT2_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT2")).getField("IM_AGT2_ADR_ADR_LINE3");
        frmIM_AGT3 = (UDynamicForm)this.getControls().get("frmIM_AGT3");
        frmIM_AGT3_IM_AGT3_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_BIC");
        frmIM_AGT3_IM_AGT3_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_CLR_SYS");
        frmIM_AGT3_IM_AGT3_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_CLR_SYS_MMBID");
        frmIM_AGT3_IM_AGT3_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_LEI");
        frmIM_AGT3_IM_AGT3_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_NAME");
        frmIM_AGT3_IM_AGT3_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_M");
        frmIM_AGT3_IM_AGT3_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_DEPT");
        frmIM_AGT3_IM_AGT3_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_SDEPT");
        frmIM_AGT3_IM_AGT3_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_STRT_NM");
        frmIM_AGT3_IM_AGT3_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_BLDG_NB");
        frmIM_AGT3_IM_AGT3_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_BLDG_NM");
        frmIM_AGT3_IM_AGT3_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_FLR");
        frmIM_AGT3_IM_AGT3_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_PST_BX");
        frmIM_AGT3_IM_AGT3_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_ROOM");
        frmIM_AGT3_IM_AGT3_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_PST_CD");
        frmIM_AGT3_IM_AGT3_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_TWN");
        frmIM_AGT3_IM_AGT3_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_TWN_LOC");
        frmIM_AGT3_IM_AGT3_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_DSTRCT");
        frmIM_AGT3_IM_AGT3_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_AREA");
        frmIM_AGT3_IM_AGT3_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_CTRY");
        frmIM_AGT3_IM_AGT3_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_ADR_LINE1");
        frmIM_AGT3_IM_AGT3_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_ADR_LINE2");
        frmIM_AGT3_IM_AGT3_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmIM_AGT3")).getField("IM_AGT3_ADR_ADR_LINE3");
        frmCDTR_AGT = (UDynamicForm)this.getControls().get("frmCDTR_AGT");
        frmCDTR_AGT_CDTR_AGT_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_BIC");
        frmCDTR_AGT_CDTR_AGT_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_CLR_SYS");
        frmCDTR_AGT_CDTR_AGT_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_CLR_SYS_MMBID");
        frmCDTR_AGT_CDTR_AGT_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_LEI");
        frmCDTR_AGT_CDTR_AGT_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_NAME");
        frmCDTR_AGT_CDTR_AGT_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_M");
        frmCDTR_AGT_CDTR_AGT_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_DEPT");
        frmCDTR_AGT_CDTR_AGT_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_SDEPT");
        frmCDTR_AGT_CDTR_AGT_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_STRT_NM");
        frmCDTR_AGT_CDTR_AGT_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_BLDG_NB");
        frmCDTR_AGT_CDTR_AGT_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_BLDG_NM");
        frmCDTR_AGT_CDTR_AGT_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_FLR");
        frmCDTR_AGT_CDTR_AGT_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_PST_BX");
        frmCDTR_AGT_CDTR_AGT_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_ROOM");
        frmCDTR_AGT_CDTR_AGT_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_PST_CD");
        frmCDTR_AGT_CDTR_AGT_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_TWN");
        frmCDTR_AGT_CDTR_AGT_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_TWN_LOC");
        frmCDTR_AGT_CDTR_AGT_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_DSTRCT");
        frmCDTR_AGT_CDTR_AGT_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_AREA");
        frmCDTR_AGT_CDTR_AGT_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_CTRY");
        frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_ADR_LINE1");
        frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_ADR_LINE2");
        frmCDTR_AGT_CDTR_AGT_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_ADR_ADR_LINE3");
        frmCDTR_AGT_CDTR_AGT_BR_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_AGT")).getField("CDTR_AGT_BR_ID");
        frmCDTR_PTY = (UDynamicForm)this.getControls().get("frmCDTR_PTY");
        frmCDTR_PTY_CDTR_PTY_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_NAME");
        frmCDTR_PTY_CDTR_PTY_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_M");
        frmCDTR_PTY_CDTR_PTY_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_DEPT");
        frmCDTR_PTY_CDTR_PTY_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_SDEPT");
        frmCDTR_PTY_CDTR_PTY_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_STRT_NM");
        frmCDTR_PTY_CDTR_PTY_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_BLDG_NB");
        frmCDTR_PTY_CDTR_PTY_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_BLDG_NM");
        frmCDTR_PTY_CDTR_PTY_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_FLR");
        frmCDTR_PTY_CDTR_PTY_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_PST_BX");
        frmCDTR_PTY_CDTR_PTY_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_ROOM");
        frmCDTR_PTY_CDTR_PTY_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_PST_CD");
        frmCDTR_PTY_CDTR_PTY_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_TWN");
        frmCDTR_PTY_CDTR_PTY_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_TWN_LOC");
        frmCDTR_PTY_CDTR_PTY_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_DSTRCT");
        frmCDTR_PTY_CDTR_PTY_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_AREA");
        frmCDTR_PTY_CDTR_PTY_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_CTRY");
        frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_ADR_LINE1");
        frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_ADR_LINE2");
        frmCDTR_PTY_CDTR_PTY_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_ADR_ADR_LINE3");
        frmCDTR_PTY_CDTR_PTY_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_BIC");
        frmCDTR_PTY_CDTR_PTY_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_LEI");
        frmCDTR_PTY_CDTR_PTY_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_ID");
        frmCDTR_PTY_CDTR_PTY_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_ID_SCHE");
        frmCDTR_PTY_CDTR_PTY_C_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_ID_SCHEX");
        frmCDTR_PTY_CDTR_PTY_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_C_ID_ISSR");
        frmCDTR_PTY_CDTR_PTY_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_BIRTH_DATE");
        frmCDTR_PTY_CDTR_PTY_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_BIRTH_PRVC");
        frmCDTR_PTY_CDTR_PTY_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_BIRTH_CITY");
        frmCDTR_PTY_CDTR_PTY_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_BIRTH_CTRY");
        frmCDTR_PTY_CDTR_PTY_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_ID");
        frmCDTR_PTY_CDTR_PTY_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_ID_SCHE");
        frmCDTR_PTY_CDTR_PTY_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_ID_SCHEX");
        frmCDTR_PTY_CDTR_PTY_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_P_ID_ISSR");
        frmCDTR_PTY_CDTR_PTY_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_PTY")).getField("CDTR_PTY_RES_CTRY");
        frmCDTR_PTYF = (UDynamicForm)this.getControls().get("frmCDTR_PTYF");
        frmCDTR_PTYF_CDTR_PTYF_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_BIC");
        frmCDTR_PTYF_CDTR_PTYF_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_CLR_SYS");
        frmCDTR_PTYF_CDTR_PTYF_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_CLR_SYS_MMBID");
        frmCDTR_PTYF_CDTR_PTYF_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_LEI");
        frmCDTR_PTYF_CDTR_PTYF_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_NAME");
        frmCDTR_PTYF_CDTR_PTYF_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_M");
        frmCDTR_PTYF_CDTR_PTYF_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_DEPT");
        frmCDTR_PTYF_CDTR_PTYF_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_SDEPT");
        frmCDTR_PTYF_CDTR_PTYF_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_STRT_NM");
        frmCDTR_PTYF_CDTR_PTYF_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_BLDG_NB");
        frmCDTR_PTYF_CDTR_PTYF_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_BLDG_NM");
        frmCDTR_PTYF_CDTR_PTYF_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_FLR");
        frmCDTR_PTYF_CDTR_PTYF_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_PST_BX");
        frmCDTR_PTYF_CDTR_PTYF_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_ROOM");
        frmCDTR_PTYF_CDTR_PTYF_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_PST_CD");
        frmCDTR_PTYF_CDTR_PTYF_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_TWN");
        frmCDTR_PTYF_CDTR_PTYF_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_TWN_LOC");
        frmCDTR_PTYF_CDTR_PTYF_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_DSTRCT");
        frmCDTR_PTYF_CDTR_PTYF_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_AREA");
        frmCDTR_PTYF_CDTR_PTYF_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_CTRY");
        frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_ADR_LINE1");
        frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_ADR_LINE2");
        frmCDTR_PTYF_CDTR_PTYF_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmCDTR_PTYF")).getField("CDTR_PTYF_ADR_ADR_LINE3");
        frmUCDTR = (UDynamicForm)this.getControls().get("frmUCDTR");
        frmUCDTR_UCDTR_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_NAME");
        frmUCDTR_UCDTR_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_M");
        frmUCDTR_UCDTR_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_DEPT");
        frmUCDTR_UCDTR_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_SDEPT");
        frmUCDTR_UCDTR_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_STRT_NM");
        frmUCDTR_UCDTR_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_BLDG_NB");
        frmUCDTR_UCDTR_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_BLDG_NM");
        frmUCDTR_UCDTR_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_FLR");
        frmUCDTR_UCDTR_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_PST_BX");
        frmUCDTR_UCDTR_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_ROOM");
        frmUCDTR_UCDTR_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_PST_CD");
        frmUCDTR_UCDTR_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_TWN");
        frmUCDTR_UCDTR_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_TWN_LOC");
        frmUCDTR_UCDTR_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_DSTRCT");
        frmUCDTR_UCDTR_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_AREA");
        frmUCDTR_UCDTR_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_ADR_CTRY");
        frmUCDTR_UCDTR_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_BIC");
        frmUCDTR_UCDTR_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_LEI");
        frmUCDTR_UCDTR_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_ID");
        frmUCDTR_UCDTR_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_ID_SCHE");
        frmUCDTR_UCDTR_C_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_ID_SCHEX");
        frmUCDTR_UCDTR_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_C_ID_ISSR");
        frmUCDTR_UCDTR_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_BIRTH_DATE");
        frmUCDTR_UCDTR_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_BIRTH_PRVC");
        frmUCDTR_UCDTR_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_BIRTH_CITY");
        frmUCDTR_UCDTR_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_BIRTH_CTRY");
        frmUCDTR_UCDTR_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_ID");
        frmUCDTR_UCDTR_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_ID_SCHE");
        frmUCDTR_UCDTR_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_ID_SCHEX");
        frmUCDTR_UCDTR_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_P_ID_ISSR");
        frmUCDTR_UCDTR_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmUCDTR")).getField("UCDTR_RES_CTRY");
        frmRTR_ORGTR = (UDynamicForm)this.getControls().get("frmRTR_ORGTR");
        frmRTR_ORGTR_RTR_ORGTR_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_NAME");
        frmRTR_ORGTR_RTR_ORGTR_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_M");
        frmRTR_ORGTR_RTR_ORGTR_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_DEPT");
        frmRTR_ORGTR_RTR_ORGTR_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_SDEPT");
        frmRTR_ORGTR_RTR_ORGTR_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_STRT_NM");
        frmRTR_ORGTR_RTR_ORGTR_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_BLDG_NB");
        frmRTR_ORGTR_RTR_ORGTR_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_BLDG_NM");
        frmRTR_ORGTR_RTR_ORGTR_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_FLR");
        frmRTR_ORGTR_RTR_ORGTR_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_PST_BX");
        frmRTR_ORGTR_RTR_ORGTR_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_ROOM");
        frmRTR_ORGTR_RTR_ORGTR_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_PST_CD");
        frmRTR_ORGTR_RTR_ORGTR_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_TWN");
        frmRTR_ORGTR_RTR_ORGTR_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_TWN_LOC");
        frmRTR_ORGTR_RTR_ORGTR_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_DSTRCT");
        frmRTR_ORGTR_RTR_ORGTR_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_AREA");
        frmRTR_ORGTR_RTR_ORGTR_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_CTRY");
        frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_ADR_LINE1");
        frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_ADR_LINE2");
        frmRTR_ORGTR_RTR_ORGTR_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_ADR_ADR_LINE3");
        frmRTR_ORGTR_RTR_ORGTR_C_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_BIC");
        frmRTR_ORGTR_RTR_ORGTR_C_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_LEI");
        frmRTR_ORGTR_RTR_ORGTR_C_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_ID");
        frmRTR_ORGTR_RTR_ORGTR_C_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_ID_SCHE");
        frmRTR_ORGTR_RTR_ORGTR_C_ID_SCHEX = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_ID_SCHEX");
        frmRTR_ORGTR_RTR_ORGTR_C_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_C_ID_ISSR");
        frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_DATE = (UDateItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_BIRTH_DATE");
        frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_PRVC = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_BIRTH_PRVC");
        frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_CITY = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_BIRTH_CITY");
        frmRTR_ORGTR_RTR_ORGTR_P_BIRTH_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_BIRTH_CTRY");
        frmRTR_ORGTR_RTR_ORGTR_P_ID = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_ID");
        frmRTR_ORGTR_RTR_ORGTR_P_ID_SCHE = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_ID_SCHE");
        frmRTR_ORGTR_RTR_ORGTR_P_ID_SCHEX = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_ID_SCHEX");
        frmRTR_ORGTR_RTR_ORGTR_P_ID_ISSR = (UTextItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_P_ID_ISSR");
        frmRTR_ORGTR_RTR_ORGTR_RES_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmRTR_ORGTR")).getField("RTR_ORGTR_RES_CTRY");
        frmJYZTXX = (UDynamicForm)this.getControls().get("frmJYZTXX");
        frmJYZTXX_TXN_SEQ_NO = (UTextItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("TXN_SEQ_NO");
        frmJYZTXX_MADE_USER = (UTextItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("MADE_USER");
        frmJYZTXX_MADE_TIME = (UTextItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("MADE_TIME");
        frmJYZTXX_PBOC_STATUS = (USelectItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("PBOC_STATUS");
        frmJYZTXX_TXN_STATUS = (USelectItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("TXN_STATUS");
        frmJYZTXX_COMM_STATUS = (USelectItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("COMM_STATUS");
        frmJYZTXX_BIZ_PROC_INFO = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("BIZ_PROC_INFO");
        frmJYZTXX_BIZ_CNCL_INFO = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmJYZTXX")).getField("BIZ_CNCL_INFO");
        frmJJXX = (UDynamicForm)this.getControls().get("frmJJXX");
        frmJJXX_BIZ_REJ_INFO = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmJJXX")).getField("BIZ_REJ_INFO");
        frmCHRG_DTL = (UDynamicForm)this.getControls().get("frmCHRG_DTL");
        frmCHRG_DTL_CHRG_AMT = (UMoneyItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AMT");
        frmCHRG_DTL_CHRG_AMT_CURCD = (USelectItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AMT_CURCD");
        frmCHRG_DTL_CHRG_AGT_BIC = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_BIC");
        frmCHRG_DTL_CHRG_AGT_CLR_SYS = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_CLR_SYS");
        frmCHRG_DTL_CHRG_AGT_CLR_SYS_MMBID = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_CLR_SYS_MMBID");
        frmCHRG_DTL_CHRG_AGT_LEI = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_LEI");
        frmCHRG_DTL_CHRG_AGT_NAME = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_NAME");
        frmCHRG_DTL_CHRG_AGT_ADR_M = (UTextAreaItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_M");
        frmCHRG_DTL_CHRG_AGT_ADR_DEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_DEPT");
        frmCHRG_DTL_CHRG_AGT_ADR_SDEPT = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_SDEPT");
        frmCHRG_DTL_CHRG_AGT_ADR_STRT_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_STRT_NM");
        frmCHRG_DTL_CHRG_AGT_ADR_BLDG_NB = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_BLDG_NB");
        frmCHRG_DTL_CHRG_AGT_ADR_BLDG_NM = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_BLDG_NM");
        frmCHRG_DTL_CHRG_AGT_ADR_FLR = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_FLR");
        frmCHRG_DTL_CHRG_AGT_ADR_PST_BX = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_PST_BX");
        frmCHRG_DTL_CHRG_AGT_ADR_ROOM = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_ROOM");
        frmCHRG_DTL_CHRG_AGT_ADR_PST_CD = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_PST_CD");
        frmCHRG_DTL_CHRG_AGT_ADR_TWN = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_TWN");
        frmCHRG_DTL_CHRG_AGT_ADR_TWN_LOC = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_TWN_LOC");
        frmCHRG_DTL_CHRG_AGT_ADR_DSTRCT = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_DSTRCT");
        frmCHRG_DTL_CHRG_AGT_ADR_AREA = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_AREA");
        frmCHRG_DTL_CHRG_AGT_ADR_CTRY = (USelectItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_CTRY");
        frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE1 = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_ADR_LINE1");
        frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE2 = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_ADR_LINE2");
        frmCHRG_DTL_CHRG_AGT_ADR_ADR_LINE3 = (UTextItem)((UDynamicForm)this.getControls().get("frmCHRG_DTL")).getField("CHRG_AGT_ADR_ADR_LINE3");

        // Table
        resultTb = (UTable)this.getControls().get("resultTb");
        nvresultTb = (UNavigateBar)this.getControls().get("nvresultTb");
        tbCHRG = (UTable)this.getControls().get("tbCHRG");
        nvtbCHRG = (UNavigateBar)this.getControls().get("nvtbCHRG");

        // Button
        BTN_INQ = (UButton)this.getControls().get("BTN_INQ");
        BTN_RESET = (UButton)this.getControls().get("BTN_RESET");
        BTN_SUB_OK = (UButton)this.getControls().get("BTN_SUB_OK");
        BTN_SUB_REJ = (UButton)this.getControls().get("BTN_SUB_REJ");
        BTN_SUB_CLOSE = (UButton)this.getControls().get("BTN_SUB_CLOSE");
        BTN_CHRG_DTL_CLOSE = (UButton)this.getControls().get("BTN_CHRG_DTL_CLOSE");

        // SubWindow
        detailSw = (UWindow)this.getControls().get("detailSw");
        chrgSubWin = (UWindow)this.getControls().get("chrgSubWin");
        return;
    }


public static class DsFieldAttr {
             private String name;
             private String type;
             private String caption;
             private String dataType;
             private String precision;
             private String scale;
             private String defaultValue;
             private String format;
             private String dropdown;
             private String nullable;
             private String readOnly;
             private String msgAlign;

             public DsFieldAttr(String name, String type, String caption, String dataType, String precision, String scale, String defaultValue, String format, String dropdown, String nullable, String readOnly, String msgAlign) {
                 this.name = name;
                 this.type = type;
                 this.caption = caption;
                 this.dataType = dataType;
                 this.precision = precision;
                 this.scale = scale;
                 this.defaultValue = defaultValue;
                 this.format = format;
                 this.dropdown = dropdown;
                 this.nullable = nullable;
                 this.readOnly = readOnly;
                 this.msgAlign = msgAlign;
             }


             public String getName() {
                 return name;
             }

             public String getType() {
                 return type;
             }

             public String getCaption() {
                 return caption;
             }

             public String getDataType() {
                 return dataType;
             }

             public String getPrecision() {
                 return precision;
             }

             public String getScale() {
                 return scale;
             }

             public String getDefaultValue() {
                 return defaultValue;
             }

             public String getFormat() {
                 return format;
             }

             public String getDropdown() {
                 return dropdown;
             }

             public String getNullable() {
                 return nullable;
             }

             public String getReadOnly() {
                 return readOnly;
             }

             public String getMsgAlign() {
                 return msgAlign;
             }
         }

public static class FormFieldAttr {
         private String id;
         private String name;
         private String dict;
         private String len;
         private String componentType;
         private String optional;
         private String readOnly;
         private String colspan;

        public FormFieldAttr(String id, String name, String dict, String len, String componentType, String optional, String readOnly, String colspan) {
            this.id = id;
            this.name = name;
            this.dict = dict;
            this.len = len;
            this.componentType = componentType;
            this.optional = optional;
            this.readOnly = readOnly;
            this.colspan = colspan;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDict() {
            return dict;
        }

        public String getLen() {
            return len;
        }

        public String getComponentType() {
            return componentType;
        }

        public String getOptional() {
            return optional;
        }

        public String getReadOnly() {
            return readOnly;
        }

        public String getColspan() {
            return colspan;
        }
    }
}