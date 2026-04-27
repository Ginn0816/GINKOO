# PageCustomization XML 配置指南

## 概述

PageCustomization XML 是 CIPS-HIS 系统提供的页面定制化机制，允许在**不修改模板生成的页面代码**的情况下，通过 XML 配置对页面的表单字段、表格列、组件布局进行增删改和重排序。

配置文件路径：
```
src/main/java/com/gingkoo/gui/ui/component/client/view/PageCustomization.xml
```

## XML 结构总览

```xml
<Document>
    <Customization applyToPage="页面类名(正则)">
        <!-- 1. 添加字段 -->
        <AddField ...>
            <Field .../>
        </AddField>

        <!-- 2. 删除字段 -->
        <RemoveField .../>

        <!-- 3. 添加组件 -->
        <AddComponent ...>
            <Form ...>
                <Field .../>
            </Form>
        </AddComponent>

        <!-- 4. 删除组件 -->
        <RemoveComponent .../>

        <!-- 5. 字段重排序 -->
        <ReorderFields ...>
            <Field id="..." order="..."/>
        </ReorderFields>

        <!-- 6. 组件重排序 -->
        <ReorderComponents ...>
            <Component id="..." order="..."/>
        </ReorderComponents>

        <!-- 7. 缩略显示 -->
        <CompactView ...>
            <Field .../>
        </CompactView>
    </Customization>
</Document>
```

---

## 操作详解

### 1. AddField — 向已有组件添加字段

向已有的 Form（表单）或 Table（表格）中添加新的字段/列。同时会自动将新字段注册到对应的 Dataset 中。

**别名**：`FieldGroup`（旧版名称，功能完全相同）

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `applyToComponent` | 是 | 目标组件 ID（如 `frmBASIC`、`tbCHRG_LIST`） |
| `dataset` | 是 | 关联的数据集 ID（如 `inputDs`、`listDs`），新字段会自动添加到此 Dataset |
| `relatedField` | 是 | 参照字段 ID，新字段插入到此字段的前面或后面 |
| `location` | 是 | 插入位置：`PRE`（参照字段之前）或 `POST`（参照字段之后） |

#### 子元素 `<Field>` 属性

| 属性 | 必填 | 说明 | 示例值 |
|-----|:---:|------|-------|
| `id` | 是 | 字段唯一标识（用于数据绑定） | `CUST_FIELD1` |
| `title` | 是 | 字段中文标题 | `定制化字段1` |
| `dataType` | 是 | 字段类型，决定渲染的控件类型 | `Text` / `Select` / `Date` / `Money` / `TextArea` |
| `length` | 是 | 字段长度。纯数字如 `20`；含小数的如 `18,2`（总长18，小数2位）| `20`、`18,2` |
| `required` | 否 | 是否必填 | `true` / `false`（默认） |
| `readOnly` | 否 | 是否只读 | `true` / `false`（默认） |
| `colspan` | 否 | 是否跨列显示（占满整行） | `true` / `false`（默认） |
| `dict` | 否 | 字典代码，仅 `dataType="Select"` 时有效，自动加载下拉选项 | `050032` |

#### dataType 与渲染控件的映射

| dataType | 渲染控件 | Dataset 字段类型 |
|----------|---------|----------------|
| `Text` | `UTextItem`（单行文本） | `string` |
| `TextArea` | `UTextAreaItem`（多行文本），自动跨列 | `string` |
| `Select` | `USelectItem`（下拉选择） | `string` |
| `Date` | `UDateItem`（日期选择） | `date` |
| `Money` | `UMoneyItem`（金额输入） | `money` |

#### 示例

```xml
<!-- 在 frmBASIC 表单的 AMT 字段后面添加 3 个新字段 -->
<AddField applyToComponent="frmBASIC" dataset="inputDs" relatedField="AMT" location="POST">
    <Field id="CUST_FIELD1" title="定制化字段1" dataType="Text" length="20" required="true" readOnly="false"/>
    <Field id="CUST_FIELD2" title="定制化字段2(Select)" dataType="Select" length="32" required="false" readOnly="false" dict="050032"/>
    <Field id="NAME_SELECTED" title="中英文名选择" dataType="Select" length="20" required="true" readOnly="false" colspan="true" dict="050032"/>
</AddField>

<!-- 在 tbCHRG_LIST 表格的 CHRG_AGT_CLR_SYS_MMBID 列前面添加一个新列 -->
<AddField applyToComponent="tbCHRG_LIST" dataset="listDs" relatedField="CHRG_AGT_CLR_SYS_MMBID" location="PRE">
    <Field id="CUST_COL1" title="自定义列1" dataType="Text" length="20"/>
</AddField>
```

---

### 2. RemoveField — 删除已有字段

从 Form 或 Table 中移除指定字段。

> **注意**：谨慎使用，页面事件代码 (`*Cust.java`) 中可能依赖被删除的字段，可能导致运行时错误。

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `applyToComponent` | 是 | 目标组件 ID |
| `fieldId` | 是 | 要删除的字段 ID |

#### 示例

```xml
<!-- 从 frmBASIC 表单中删除 SVC_LVLX2 字段 -->
<RemoveField applyToComponent="frmBASIC" fieldId="SVC_LVLX2"/>

<!-- 从 tbCHRG_LIST 表格中删除 CHRG_AGT_BIC 列 -->
<RemoveField applyToComponent="tbCHRG_LIST" fieldId="CHRG_AGT_BIC"/>
```

---

### 3. AddComponent — 添加新组件

在指定参照组件的前面或后面插入新的 Form 组件。如果新 Form 使用了新的 Dataset（不在页面原有 Dataset 列表中），系统会自动创建该 Dataset。

**别名**：`NewForm`（旧版名称，功能相同但语法略有不同）

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `applyToComponent` | 是 | 参照组件 ID，新组件插入到它的前面或后面 |
| `location` | 是 | 插入位置：`PRE`（前面）或 `POST`（后面） |

#### 子元素 `<Form>` 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `formId` | 是 | 新表单的唯一 ID（如 `frmEXTRA`） |
| `formName` | 是 | 新表单的中文标题 |
| `dataset` | 是 | 绑定的数据集 ID（可以是已有的或新的） |

`<Form>` 内部包含 `<Field>` 子元素，属性与 AddField 中的 `<Field>` 相同。

#### 示例

```xml
<!-- 在 frmBASIC 表单后面添加一个新的"扩展信息"表单（使用已有 inputDs） -->
<AddComponent applyToComponent="frmBASIC" location="POST">
    <Form formId="frmEXTRA" formName="扩展信息" dataset="inputDs">
        <Field id="EXT_FIELD1" title="扩展字段1" dataType="Text" length="50" required="false" readOnly="false"/>
        <Field id="EXT_FIELD2" title="扩展字段2(Date)" dataType="Date" length="8" required="false" readOnly="false"/>
    </Form>
</AddComponent>

<!-- 在 frmBASIC 表单前面添加一个新表单（使用新的 newPreDs 数据集，系统自动创建） -->
<AddComponent applyToComponent="frmBASIC" location="PRE">
    <Form formId="frmPREINFO" formName="前置信息" dataset="newPreDs">
        <Field id="PRE_F1" title="前置字段1" dataType="Text" length="20" required="true" readOnly="true"/>
    </Form>
</AddComponent>
```

#### 旧版语法 (NewForm)

```xml
<!-- 功能相同，但 dataset 和 location 直接写在 NewForm 上 -->
<NewForm applyToComponent="frmBASIC" formId="frmPRE" formName="前置信息" dataset="newPreDs" location="PRE">
    <Field id="CUST_FIELD12" title="定制化字段12" dataType="Text" length="20" required="true" readOnly="true" colspan="true"/>
</NewForm>
```

---

### 4. RemoveComponent — 删除已有组件

从页面中移除整个 Form 或 Table 组件。

> **注意**：强烈不建议使用。页面事件代码 (`*Cust.java`) 中通常会引用这些组件，删除后会导致 `NullPointerException`。

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `componentId` | 是 | 要删除的组件 ID |

#### 示例

```xml
<RemoveComponent componentId="frmDBTR"/>
<RemoveComponent componentId="tbREG_LIST"/>
```

---

### 5. ReorderFields — 字段重排序

调整 Form 或 Table 内字段的显示顺序。

#### 排序规则
- 在 `<ReorderFields>` 中列出的字段按照指定的 `order` 值从小到大排列
- **未列出的字段**保持原有的相对顺序，排在有 `order` 值的字段之后
- `order` 值可以是任意整数，只要能表达相对顺序即可

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `applyToComponent` | 是 | 目标组件 ID |

#### 子元素 `<Field>` 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `id` | 是 | 字段 ID |
| `order` | 是 | 排序值（整数），值越小越靠前 |

#### 示例

```xml
<!-- 将 frmBASIC 表单中 3 个字段排到最前面 -->
<ReorderFields applyToComponent="frmBASIC">
    <Field id="SVC_LVLX3" order="91"/>
    <Field id="CUST_FIELD2" order="92"/>
    <Field id="SVC_LVL3" order="93"/>
</ReorderFields>
```

排序结果：`SVC_LVLX3` → `CUST_FIELD2` → `SVC_LVL3` → 其余字段按原顺序

---

### 6. ReorderComponents — 组件重排序

调整同一父容器下的 Form/Table 组件的显示顺序。

#### 排序规则
- 与 ReorderFields 相同：列出的按 `order` 排，未列出的按原顺序排在后面

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `parentComponent` | 是 | 父容器的组件 ID（如子窗口布局的 ID `LtdtlSubWin`） |

#### 子元素 `<Component>` 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `id` | 是 | 组件 ID |
| `order` | 是 | 排序值（整数），值越小越靠前 |

#### 示例

```xml
<!-- 调整子窗口 LtdtlSubWin 中的表单顺序 -->
<ReorderComponents parentComponent="LtdtlSubWin">
    <Component id="frmBASIC" order="1"/>
    <Component id="frmTECH" order="2"/>
    <Component id="frmID" order="3"/>
</ReorderComponents>
```

---

### 7. CompactView — 缩略显示

在指定组件（通常是子窗口）的最前面添加一个缩略表单，从该组件下所有已有表单中提取指定字段，汇总到一个简洁的表单中展示。

#### 工作原理
1. 遍历目标组件下的所有 Form（排除已有的 `frmCOMPACT*` 表单）
2. 收集所有 FormItem 的配置
3. 根据 `<Field>` 列表中指定的字段 ID，从收集的配置中复制对应的 FormItem
4. 创建一个新的 Form 组件（4 列布局），插入到目标组件内容的最前面

#### 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `applyToComponent` | 是 | 目标容器组件 ID（通常是子窗口 ID，如 `detailSw111`） |
| `dataset` | 是 | 缩略表单绑定的数据集 ID |
| `formId` | 是 | 缩略表单的 ID（通常以 `frmCOMPACT` 开头） |
| `formName` | 是 | 缩略表单的标题 |

#### 子元素 `<Field>` 属性

| 属性 | 必填 | 说明 |
|-----|:---:|------|
| `id` | 是 | 要提取的字段 ID（必须存在于目标组件下某个 Form 中） |
| `title` | 否 | 覆盖字段的显示标题（不填则使用原标题） |
| `colspan` | 否 | 是否跨列显示 | 

#### 示例

```xml
<!-- 在子窗口 detailSw111 最前面添加缩略显示 -->
<CompactView applyToComponent="detailSw111" dataset="inputDs" formId="frmCOMPACT111" formName="缩略显示">
    <Field id="MSG_ID"/>
    <Field id="DBTR_NAME" title="付款人"/>
    <Field id="CDTR_NAME" title="收款人"/>
    <Field id="AMT" title="金额" colspan="true"/>
</CompactView>
```

---

## 完整示例

以下是一个完整的配置示例，展示了所有 7 种操作类型：

```xml
<Document>
    <Customization applyToPage="Page0511103Cust">

        <!-- 1. 在 frmBASIC 的 AMT 字段后添加定制化字段 -->
        <AddField applyToComponent="frmBASIC" dataset="inputDs" relatedField="AMT" location="POST">
            <Field id="CUST_FIELD1" title="定制化字段1" dataType="Text" length="20" required="true" readOnly="false"/>
            <Field id="CUST_FIELD2" title="定制化字段2" dataType="Select" length="32" dict="050032"/>
        </AddField>

        <!-- 2. 删除不需要的字段 -->
        <RemoveField applyToComponent="frmBASIC" fieldId="SVC_LVLX2"/>

        <!-- 3. 添加全新的扩展表单 -->
        <AddComponent applyToComponent="frmBASIC" location="POST">
            <Form formId="frmEXTRA" formName="扩展信息" dataset="inputDs">
                <Field id="EXT_FIELD1" title="扩展字段1" dataType="Text" length="50"/>
            </Form>
        </AddComponent>

        <!-- 4. 删除不需要的组件（慎用） -->
        <RemoveComponent componentId="frmDBTR"/>

        <!-- 5. 调整字段顺序 -->
        <ReorderFields applyToComponent="frmBASIC">
            <Field id="SVC_LVLX3" order="91"/>
            <Field id="CUST_FIELD2" order="92"/>
        </ReorderFields>

        <!-- 6. 调整子窗口内组件顺序 -->
        <ReorderComponents parentComponent="LtdtlSubWin">
            <Component id="frmBASIC" order="1"/>
            <Component id="frmTECH" order="2"/>
            <Component id="frmID" order="3"/>
        </ReorderComponents>

        <!-- 7. 添加缩略显示 -->
        <CompactView applyToComponent="detailSw111" dataset="inputDs"
                     formId="frmCOMPACT111" formName="缩略显示">
            <Field id="MSG_ID"/>
            <Field id="DBTR_NAME" title="付款人"/>
            <Field id="CDTR_NAME" title="收款人"/>
            <Field id="AMT" title="金额" colspan="true"/>
        </CompactView>
    </Customization>
</Document>
```

---



## 生效时机与执行顺序

### 在页面生命周期中的位置

加载默认配置（即Cust.java父类中的内容） 
    ↓
合并通过mergeExternalConfigs()引用的子页面配置(如11120中引用CIPS05111)
    ↓
`应用 Customization XML 的所有变换`
    ↓
最终渲染页面组件

### 操作类型的执行顺序

对于每一个匹配的 `<Customization>` 块，7 种操作按以下**固定顺序**执行（与 XML 中的书写顺序无关）：

| 顺序 | 操作类型              | 说明                           |
| :--: | --------------------- | ------------------------------ |
|  1   | **AddField**          | 向已有 Form/Table 添加字段/列  |
|  2   | **RemoveField**       | 从已有 Form/Table 删除字段/列  |
|  3   | **AddComponent**      | 添加新的 Form 组件             |
|  4   | **RemoveComponent**   | 删除已有的 Form/Table 组件     |
|  5   | **ReorderFields**     | 调整 Form/Table 内字段的顺序   |
|  6   | **ReorderComponents** | 调整同级 Form/Table 组件的顺序 |
|  7   | **CompactView**       | 创建缩略显示表单               |

### 页面匹配机制

`applyToPage` 属性的值是一个**正则表达式**，会与页面类的 Java 简单类名（`getClass().getSimpleName()`）进行匹配。

```xml
<!-- 精确匹配单个页面 -->
<Customization applyToPage="Page0511103Cust">

<!-- 正则匹配多个页面 -->
<Customization applyToPage="Page051110[1-4]Cust">

<!-- 匹配所有页面（慎用） -->
<Customization applyToPage=".*">
```

---

## 注意事项

1. **不要删除事件代码依赖的字段或组件**：`*Cust.java` 中的 `bindEvent()` 可能引用了特定字段或组件，删除会导致运行时异常
2. **新 Dataset 会自动创建**：如果 AddComponent 中使用了页面原本不存在的 Dataset ID，系统会自动根据 Field 定义创建该 Dataset
3. **applyToPage 支持正则**：可以用一个配置块覆盖多个页面，但要注意正则的精确性
4. **字段 ID 需全局唯一**：在同一个 Dataset 内，字段 ID 不能重复
5. **XML 在 GWT 编译时打包**：修改 XML 后需要重新编译 GWT 模块才能生效
6. **组件操作：**通过配置（引用子页面）带入的组件不会有变量绑定，无法通过变量直接访问这些组件，只能通过id从页面中get后进行操作，示例
   1. CIPSCommon.getButtonOfPage(page, "BTN_SUB_REJ"+ msgNo).addClickListener()
   2. CIPSCommon.getFormOfPage(page, "frmID").getField("INSTR_ID").setRequired(true);
