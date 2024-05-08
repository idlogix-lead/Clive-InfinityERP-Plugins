/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.clive.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for ER_BottomHdr
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_ER_BottomHdr extends PO implements I_ER_BottomHdr, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220422L;

    /** Standard Constructor */
    public X_ER_BottomHdr (Properties ctx, int ER_BottomHdr_ID, String trxName)
    {
      super (ctx, ER_BottomHdr_ID, trxName);
      /** if (ER_BottomHdr_ID == 0)
        {
			setER_BottomHdr_ID (0);
			setProcessed (false);
        } */
    }

    /** Load Constructor */
    public X_ER_BottomHdr (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_ER_BottomHdr[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Add Production.
		@param AddProduction Add Production	  */
	public void setAddProduction (String AddProduction)
	{
		set_Value (COLUMNNAME_AddProduction, AddProduction);
	}

	/** Get Add Production.
		@return Add Production	  */
	public String getAddProduction () 
	{
		return (String)get_Value(COLUMNNAME_AddProduction);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Bottom.
		@param ER_BottomHdr_ID Bottom	  */
	public void setER_BottomHdr_ID (int ER_BottomHdr_ID)
	{
		if (ER_BottomHdr_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_ER_BottomHdr_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_ER_BottomHdr_ID, Integer.valueOf(ER_BottomHdr_ID));
	}

	/** Get Bottom.
		@return Bottom	  */
	public int getER_BottomHdr_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ER_BottomHdr_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ER_BottomHdr_UU.
		@param ER_BottomHdr_UU ER_BottomHdr_UU	  */
	public void setER_BottomHdr_UU (String ER_BottomHdr_UU)
	{
		set_ValueNoCheck (COLUMNNAME_ER_BottomHdr_UU, ER_BottomHdr_UU);
	}

	/** Get ER_BottomHdr_UU.
		@return ER_BottomHdr_UU	  */
	public String getER_BottomHdr_UU () 
	{
		return (String)get_Value(COLUMNNAME_ER_BottomHdr_UU);
	}

	public I_ER_DailyProduction getER_DailyProduction() throws RuntimeException
    {
		return (I_ER_DailyProduction)MTable.get(getCtx(), I_ER_DailyProduction.Table_Name)
			.getPO(getER_DailyProduction_ID(), get_TrxName());	}

	/** Set Daily Production.
		@param ER_DailyProduction_ID Daily Production	  */
	public void setER_DailyProduction_ID (int ER_DailyProduction_ID)
	{
		if (ER_DailyProduction_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_ER_DailyProduction_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_ER_DailyProduction_ID, Integer.valueOf(ER_DailyProduction_ID));
	}

	/** Get Daily Production.
		@return Daily Production	  */
	public int getER_DailyProduction_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ER_DailyProduction_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Movement Date.
		@param MovementDate 
		Date a product was moved in or out of inventory
	  */
	public void setMovementDate (Timestamp MovementDate)
	{
		set_ValueNoCheck (COLUMNNAME_MovementDate, MovementDate);
	}

	/** Get Movement Date.
		@return Date a product was moved in or out of inventory
	  */
	public Timestamp getMovementDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_MovementDate);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}