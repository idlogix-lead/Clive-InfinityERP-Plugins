package com.idlogix.forms;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.ClientInfo;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.apps.form.WCreateFromWindow;
import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.ListModelTable;
import org.adempiere.webui.component.Listbox;
import org.adempiere.webui.component.ListboxFactory;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.editor.WTableDirEditor;
import org.adempiere.webui.event.ActionEvent;
import org.adempiere.webui.event.ActionListener;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.event.ValueChangeListener;
import org.adempiere.webui.util.ZKUpdateUtil;
import org.compiere.model.GridTab;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Vlayout;

public class CreateFromLaborWageUI extends CreateFromArticle implements ActionListener, EventListener<Event>, ValueChangeListener {

	private WCreateFromWindow window;
	private int p_WindowNo;
	String issoTrx="N";
	int c_bpartner_id;
	int m_locator_id;
	protected Label cOrderLabel = new Label();
	protected WEditor cOrderField;
	protected Label locatorLabel = new Label();
	public static Listbox locatorField = ListboxFactory.newDropdownListbox();
	private int noOfParameterColumn;
	private Grid parameterStdLayout;
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();

	public CreateFromLaborWageUI(GridTab gridTab) {
		super(gridTab);
		window = new WCreateFromWindow(this, getGridTab().getWindowNo());
		p_WindowNo = getGridTab().getWindowNo();
		getGridTab().getRecord_ID();
		try
		{
			if (!dynInit())
				return;
			zkInit();
			setInitOK(true);
			//loadTableOIS(data);
			
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "", e);
			setInitOK(false);
			throw new AdempiereException(e.getMessage());
		}
		window.setClosable(true);
		AEnv.showWindow(window);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void valueChange(ValueChangeEvent evt) {
		// TODO Auto-generated method stub
		if(cOrderField.getValue() !=null){
			int C_Order_ID = (int)cOrderField.getValue();
			loadTableOIS(getOrderData(C_Order_ID));
		}
	}

	@Override
	public void onEvent(Event e) throws Exception {
		// TODO Auto-generated method stub
		String a = "";
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String a = "";
	}
	public boolean dynInit() throws Exception
	{
		log.config("");
		super.dynInit();
		window.setTitle(getTitle());
		initBPartner(false);
		cOrderField.addValueChangeListener(this);
		return true;
	}
	protected void zkInit() throws Exception
	{

		m_locator_id = (Integer)getGridTab().getValue("M_Locator_ID");
    	cOrderLabel.setText(Msg.getElement(Env.getCtx(), "C_BPartner_ID"));
		Vlayout vlayout = new Vlayout();
		ZKUpdateUtil.setVflex(vlayout, "min");
		ZKUpdateUtil.setWidth(vlayout, "100%");
    	Panel parameterPanel = window.getParameterPanel();
		parameterPanel.appendChild(vlayout);		
		parameterStdLayout = GridFactory.newGridLayout();
    	vlayout.appendChild(parameterStdLayout);
    	ZKUpdateUtil.setVflex(vlayout, "parameterStdLayout");
		Rows rows = (Rows) parameterStdLayout.newRows();
		Row row = rows.newRow();
		cOrderLabel.setText("Purchase order");
		row.appendChild(cOrderLabel.rightAlign());
		if (cOrderField != null) {
			row.appendChild(cOrderField.getComponent());
			cOrderField.fillHorizontal();
		}			
		locatorLabel.setText("Locator");
		row.appendChild(locatorLabel.rightAlign());
	    row.appendChild(locatorField);
	    ZKUpdateUtil.setHflex(locatorField, "1");
	    
	    int index = -1;
		locatorField.removeAllItems();
		ArrayList<KeyNamePair> loclist = getLocatorList();
		for(KeyNamePair knp : loclist) {
			if(knp.getKey()==m_locator_id)
				index = loclist.indexOf(knp);
			locatorField.addItem(knp);
		}
		locatorField.setSelectedIndex(index);
	    
	}
	protected void setupColumns(Grid parameterGrid) {
		noOfParameterColumn = ClientInfo.maxWidth((ClientInfo.EXTRA_SMALL_WIDTH+ClientInfo.SMALL_WIDTH)/2) ? 2 : 4;
		Columns columns = new Columns();
		parameterGrid.appendChild(columns);
		
		if (ClientInfo.maxWidth((ClientInfo.EXTRA_SMALL_WIDTH+ClientInfo.SMALL_WIDTH)/2))
		{
			Column column = new Column();
			ZKUpdateUtil.setWidth(column, "35%");
			columns.appendChild(column);
			column = new Column();
			ZKUpdateUtil.setWidth(column, "65%");
			columns.appendChild(column);
		}
		else
		{
			Column column = new Column();
			columns.appendChild(column);		
			column = new Column();
			ZKUpdateUtil.setWidth(column, "10%");
			columns.appendChild(column);
			ZKUpdateUtil.setWidth(column, "35%");
			column = new Column();
			ZKUpdateUtil.setWidth(column, "25%");
			columns.appendChild(column);
			column = new Column();
			ZKUpdateUtil.setWidth(column, "25%");
			columns.appendChild(column);			
			column = new Column();
			ZKUpdateUtil.setWidth(column, "25%");
			columns.appendChild(column);
		}
	}
	protected void loadTableOIS (Vector<?> data)
	{
//		Env.getCtx().getProperty("")
		window.getWListbox().clear();
		window.getWListbox().getModel().removeTableModelListener(window);
		window.getWListbox().setAllowIDColumnForReadWrite(true);
		ListModelTable model = new ListModelTable(data);
		model.addTableModelListener(window);
		window.getWListbox().setData(model, getOISColumnNames());
		configureMiniTable(window.getWListbox());
	}
	public void showWindow()
	{
		window.setVisible(true);
	}
	
	public void closeWindow()
	{
		window.dispose();
	}

	@Override
	public Object getWindow() {
		return window;
	}
	protected void initBPartner (boolean forInvoice) throws Exception
	{
		int AD_Column_ID = 2161;        //  M_InOut.C_Order_ID
		MLookup lookup = MLookupFactory.get (Env.getCtx(), p_WindowNo, 0, AD_Column_ID, DisplayType.Table);
		cOrderField = new WTableDirEditor("C_Order_ID", true, false, true, lookup);
	}   //  initBPartner
	

}
