package com.idlogix.processes;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import com.idlogix.models.X_IDL_Assortment_Line;
import com.idlogix.models.X_M_Parent_Product;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;

public class addSO_Lines extends SvrProcess {
	
	int pp_ID;
	int assortID;
	int tax_id;
	int boxes;
	private Map<Integer,Integer> prodIds;
	private int record_id;
	private int order_id;
	private Map<Integer,Integer> assortMapper;
	private MOrder order;
	Map<Integer,Integer> orderLines;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		record_id = getRecord_ID();
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter p : paras) {
			String name = p.getParameterName();
			if(name.equalsIgnoreCase("C_Order_ID"))
				order_id = p.getParameterAsInt();
			else if (name.equalsIgnoreCase("M_Parent_Product_ID"))
				pp_ID = p.getParameterAsInt();
			else if (name.equalsIgnoreCase("IDL_Assortment_ID"))
				assortID = p.getParameterAsInt();	
			else if(name.equalsIgnoreCase("Boxes"))
				boxes = p.getParameterAsInt();
			else if (name.equalsIgnoreCase("C_Tax_ID"))
				tax_id = p.getParameterAsInt();
			else {
				log.severe("Unknown Parameter: " + name);
			}
		}
		boxes = Math.abs(boxes);		
	}

	@Override
	protected String doIt() throws Exception {
		// Get Parent Product and Order from Ctx. Get Assortment_ID from parent prod
		// and get all sizes against that assortment in form of size-to-qty mapper.
		// check if lines already present than update otherwise insert.
		
		
		order =new MOrder(getCtx(), order_id, null);
		final String docstatus = order.getDocStatus();
		if(docstatus.equalsIgnoreCase("CO"))
			return null;
		prodIds = X_M_Parent_Product.getChildProdIds(pp_ID,assortID);
		assortMapper = X_IDL_Assortment_Line.sizeToQtyMapper(assortID);	
		orderLines = getOrderLines(order_id);
		updateOrInsertLines();
		return null;
	}	
	public void updateOrInsertLines() {
		Iterator<Integer> itr = prodIds.keySet().iterator();
		while (itr.hasNext()) 
		{
			 int prodId = itr.next();
		     if(orderLines.get(prodId) != null) {
		    	    MOrderLine line = new MOrderLine(getCtx(), orderLines.get(prodId), null);					
					int qty = assortMapper.getOrDefault(prodIds.get(prodId),Integer.MIN_VALUE);
					qty*=boxes;
					line.set_ValueOfColumn("QtyEntered",new BigDecimal(qty));
					line.set_ValueOfColumn("QtyOrdered",new BigDecimal(qty));
					line.saveEx();
		     }
		     else {
		    	 	int qty = assortMapper.getOrDefault(prodIds.get(prodId),Integer.MIN_VALUE);
		    	 	qty=qty*boxes;
		    	    MOrderLine line = new MOrderLine(getCtx(), 0, null);
					line.setAD_Org_ID(Env.getAD_Org_ID(getCtx()));
					line.set_ValueOfColumn("M_Product_ID", prodId);
					line.set_ValueOfColumn("QtyEntered",new BigDecimal(qty));
					line.set_ValueOfColumn("QtyOrdered",new BigDecimal(qty));
					line.set_ValueOfColumn("C_Order_ParentProduct_ID", record_id);
					line.set_ValueOfColumn("M_Parent_Product_ID", pp_ID);
					line.set_ValueOfColumn("IDL_Assortment_ID", assortID);
					line.setC_Tax_ID(tax_id);
					line.setC_Order_ID(order_id);
					line.setOrder(order);
					log.fine(line.getPriceEntered().toString());
					line.saveEx();
		     }	     
		}		
	}
	public Map<Integer,Integer> getOrderLines(int orderID){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		String strSQL =   "select ol.m_product_id::integer,ol.c_orderline_id::integer \n"
						+ " from adempiere.c_orderline ol\n"
						+ " join adempiere.m_product pd ON ol.m_product_id = pd.m_product_id "
						+ " where ol.c_order_id =  " + order_id +"\n"
						+ " and ol.m_parent_product_id = "+ pp_ID+"\n"
						+ " and pd.idl_assortment_id = "+ assortID+"\n"
						+ " and ol.isActive = 'Y' and pd.isActive = 'Y' " ;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;	
		 try
		 {
		 pstmt = DB.prepareStatement (strSQL.toString(), null);
		 rs = pstmt.executeQuery ();
			 while(rs.next()) {
			  map.put(rs.getInt("m_product_id"),rs.getInt("c_orderline_id"));			  
			 }
		 }
		 catch (Exception e)
		 {
		 	throw new AdempiereException(e);
		 }
		 return map;
	}
	public void deleteOrderLines() {
		String strSQL = "DELETE\n"
				+ " FROM ADEMPIERE.C_ORDERLINE\n"
				+ " WHERE C_ORDER_PARENTPRODUCT_ID = " + record_id;
			 PreparedStatement pstmt = null;	
			 try
			 {
			 pstmt = DB.prepareStatement (strSQL.toString(), null);
			 pstmt.executeUpdate();
			 }
			 catch (Exception e)
			 {
			 	throw new AdempiereException(e);
			 }		
	}
}
