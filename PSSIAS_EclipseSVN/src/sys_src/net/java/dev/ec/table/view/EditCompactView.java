package net.java.dev.ec.table.view;


import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.util.HtmlBuilder;
import org.extremecomponents.table.view.AbstractHtmlView;

// Referenced classes of package org.extremecomponents.table.view:
//            AbstractHtmlView, UserCompactToolbar

public class EditCompactView extends AbstractHtmlView
{
	  public EditCompactView()
	    {
	    }

	    protected void beforeBodyInternal(TableModel model)
	    {
	        getTableBuilder().tableStart();
	        getTableBuilder().theadStart();
	        getTableBuilder().titleRowSpanColumns();
	        if("both".equals(getToolbarShow()) || "top".equals(getToolbarShow()))
	            toolbar(getHtmlBuilder(), getTableModel());
	        getTableBuilder().filterRow();
	        getTableBuilder().headerRow();
	        getTableBuilder().theadEnd();
	        getTableBuilder().tbodyStart();
	    }

	    private String getToolbarShow()
	    {
	        String result = getTableModel().getPreferences().getPreference("table.toolbarShow");
	        if(result == null)
	            result = "both";
	        return result.trim();
	    }

	    protected void afterBodyInternal(TableModel model)
	    {
	        getCalcBuilder().defaultCalcLayout();
	        getTableBuilder().tbodyEnd();
	        if("both".equals(getToolbarShow()) || "bottom".equals(getToolbarShow()))
	            toolbar(getHtmlBuilder(), getTableModel());
	        getTableBuilder().tableEnd();
	    }

	    protected void toolbar(HtmlBuilder html, TableModel model)
	    {
	        (new EditCompactToolbar(html, model)).layout();
	    }
}
