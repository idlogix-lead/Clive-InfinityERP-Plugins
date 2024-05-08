package com.idlogix.callouts;
import java.util.Properties;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.adempiere.base.IColumnCallout;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import com.idlogix.models.X_ER_Article_Group3;
import com.idlogix.models.X_M_Year;
import org.compiere.util.DB;

public class FG_KeyGenerator implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		
		//ids below
		
		String numeric_code="";
		String prod_code = "";
		int range_id = mTab.getValue("ER_Article_Group3_ID")==null?-1:(Integer)(mTab.getValue("ER_Article_Group3_ID"));
		X_ER_Article_Group3 range = new X_ER_Article_Group3 ( ctx, range_id, null);
		
		if(range.getName()!=null)
			prod_code =prod_code.concat(range.getName());
		String strSQL = "select right((max(er_article_id)+1)::varchar,4) numeric_code\n"
				+ "from adempiere.er_article"  ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (strSQL.toString(), null);
			rs = pstmt.executeQuery ();
			
			while (rs.next ())		//	Order
			{
				numeric_code = rs.getString("numeric_code");
			}
		}
		catch (Exception e)
		{
			throw new AdempiereException(e);
		}
		prod_code = prod_code.concat("-").concat(numeric_code);
		mTab.setValue("Value", prod_code);
		mTab.setValue("Name", prod_code);

		
		
	
		
		
		
		
		return null;
	}

}
