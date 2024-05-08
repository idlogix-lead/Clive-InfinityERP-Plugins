package com.idlogix.callouts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.clive.model.MBottom;
import com.clive.model.MBottomHdr;
import com.clive.model.MLasting;
import java.sql.Timestamp;
import java.time.Instant;
import com.clive.model.MLastingHdr;
import java.math.BigDecimal;

public class LastingCallout implements IColumnCallout {
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub

		int rows = 0; 
		String resultMsg ="";
		String id=""; int Hdrid=1000001;
			MBottomHdr BottomHdr= new MBottomHdr(Env.getCtx(), 1000001, null);
				String strSQL = "select * from  M_Production where  ER_DailyProduction_ID=" + 1000430  ; 
								PreparedStatement pstmt = null;
				ResultSet rs = null;
		PreparedStatement pstmtbal = null;
				ResultSet rs_bal = null;
		Timestamp movementDate=Timestamp.from(Instant.now());;
		int balqty =0;
		try
				{
					
					
		//balqty =10;
		pstmt = DB.prepareStatement (strSQL.toString(), null);
					rs = pstmt.executeQuery ();
					while (rs.next ())		//	Order
					{
		String strSQLbal = "select * from er_Bottom_balance_size_v where balanceqty>0 and M_Production_ID=" + rs.getInt("M_Production_ID"); 
					pstmtbal = DB.prepareStatement (strSQLbal.toString(), null);
					rs_bal = pstmtbal.executeQuery ();
		balqty=0;
		while (rs_bal.next ())		//	Order
					{
		balqty = rs_bal.getInt("balanceqty");
					
		}
						rows =rows+1;				
						MBottom pline = new MBottom(Env.getCtx(), 0, null);
						pline.setAD_Org_ID(rs.getInt("AD_Org_ID"));
//						pline.setAD_Client_ID(rs.getInt("AD_Client_ID"));
						pline.setM_Production_ID(rs.getInt("M_Production_ID"));
						pline.setQty(new BigDecimal(balqty));
						pline.set_ValueOfColumn("M_Product_ID", rs.getInt("m_product_id"));
						pline.set_ValueOfColumn("ER_BottomHdr_ID", Hdrid);
		                                //pline.set_ValueOfColumn("PP_Production_Line_ID", P_PP_Production_Line_ID);
//						pline.set_Value("MovementDate",new Timestamp(movementDate.getTime()));
		                                if(balqty>0){				
		                                    pline.saveEx();
		resultMsg ="I was Here";
		}
//					id ="" + A_PO.get_Value("ER_BottomHdr_ID");
//						rows =  pline.get_Value("M_Product_ID");
//					resultMsg="inserted rows " + rows + " id="+id;		
		}
		//BottomHdr.set_Value("Processed",'Y');
		BottomHdr.save();	
				//	resultMsg="product"+rows+" Production Saved Successfully.";


				}
				catch (Exception e)
				{
				resultMsg="exception:"+e.getMessage();
				}


		return null;
	}
}
