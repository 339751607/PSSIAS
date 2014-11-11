package net.java.dev.ec.table.view;


import java.util.Iterator;

import org.extremecomponents.table.bean.Export;
import org.extremecomponents.table.core.TableConstants;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.html.BuilderUtils;
import org.extremecomponents.table.view.html.StatusBarBuilder;
import org.extremecomponents.table.view.html.TwoColumnRowLayout;
import org.extremecomponents.util.HtmlBuilder;
import org.extremecomponents.table.view.UserToolbarBuilder;

// Referenced classes of package org.extremecomponents.table.view:
//            UserToolbarBuilder
//增加删除工具条
public class EditCompactToolbar extends TwoColumnRowLayout
{

	public EditCompactToolbar(HtmlBuilder html, TableModel model)
    {
        super(html, model);
    }

    protected boolean showLayout(TableModel model)
    {
        boolean showStatusBar = BuilderUtils.showStatusBar(model);
        boolean filterable = BuilderUtils.filterable(model);
        boolean showExports = BuilderUtils.showExports(model);
        boolean showPagination = BuilderUtils.showPagination(model);
        boolean showTitle = BuilderUtils.showTitle(model);
        return showStatusBar || filterable || showExports || showPagination || showTitle;
    }

    public void layout()
    {
        if(!showLayout(getTableModel()))
        {
            return;
        } else
        {
            getHtmlBuilder().tr(1).style("padding: 0px;").close();
            getHtmlBuilder().td(2).colSpan(String.valueOf(getTableModel().getColumnHandler().columnCount() * getMultiColumn())).close();
            getHtmlBuilder().table(2).border("0").cellPadding("0").cellSpacing("0").width("100%").close();
            getHtmlBuilder().tr(3).close();
            columnLeft(getHtmlBuilder(), getTableModel());
            columnRight(getHtmlBuilder(), getTableModel());
            getHtmlBuilder().trEnd(3);
            getHtmlBuilder().tableEnd(2);
            getHtmlBuilder().newline();
            getHtmlBuilder().tabs(2);
            getHtmlBuilder().tdEnd();
            getHtmlBuilder().trEnd(1);
            getHtmlBuilder().tabs(2);
            getHtmlBuilder().newline();
            return;
        }
    }

    protected void columnLeft(HtmlBuilder html, TableModel model)
    {
        boolean showStatusBar = BuilderUtils.showStatusBar(model);
        if(!showStatusBar)
        {
            return;
        } else
        {
            html.td(4).styleClass("statusBar").close();
            (new StatusBarBuilder(html, model)).statusMessage();
            html.tdEnd();
            return;
        }
    }

    protected void columnRight(HtmlBuilder html, TableModel model)
    {
        boolean filterable = BuilderUtils.filterable(model);
        boolean showPagination = BuilderUtils.showPagination(model);
        boolean showExports = BuilderUtils.showExports(model);
        UserToolbarBuilder toolbarBuilder = new UserToolbarBuilder(html, model);
        html.td(4).styleClass("compactToolbar").align("right").close();
        html.table(4).border("0").cellPadding("1").cellSpacing("2").close();
        html.tr(5).close();
        
        html.td(5).close();
        html.input("button").name(model.getTableHandler().prefixWithTableId() + TableConstants.ROWS_DISPLAYED).value("增 加").onclick("javascript:doAdd();");
        html.xclose();
        html.tdEnd();
       
        
       
        
        html.td(6).close();
        html.input("button").name(model.getTableHandler().prefixWithTableId() + TableConstants.ROWS_DISPLAYED).value("删 除").onclick("javascript:doDel();");
        html.xclose();
        html.tdEnd();
       
        
        html.td(7).close();
        html.nbsp();html.nbsp();html.nbsp();html.nbsp();  
        html.tdEnd();
        
        if(showPagination)
        {
            html.td(8).close();
            toolbarBuilder.firstPageItemAsImage();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.prevPageItemAsImage();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.pageLinkItemAsText();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.nextPageItemAsImage();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.lastPageItemAsImage();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.separator();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.rowsDisplayedDroplist();
            html.tdEnd();
            if(showExports)
            {
                html.td(8).close();
                toolbarBuilder.separator();
                html.tdEnd();
            }
        }
        if(showExports)
        {
            Iterator iterator = model.getExportHandler().getExports().iterator();
            for(Iterator iter = iterator; iter.hasNext(); html.tdEnd())
            {
                html.td(8).close();
                Export export = (Export)iter.next();
                toolbarBuilder.exportItemAsImage(export);
            }

        }
        if(filterable)
        {
            if(showExports || showPagination)
            {
                html.td(8).close();
                toolbarBuilder.separator();
                html.tdEnd();
            }
            html.td(8).close();
            toolbarBuilder.filterItemAsImage();
            html.tdEnd();
            html.td(8).close();
            toolbarBuilder.clearItemAsImage();
            html.tdEnd();
        }
        html.trEnd(5);
        html.tableEnd(4);
        html.tdEnd();
    }

    private int getMultiColumn()
    {
        String c = getTableModel().getPreferences().getPreference("column.multi");
        if(c == null)
            return 1;
        else
            return Integer.valueOf(c).intValue();
    }
}
