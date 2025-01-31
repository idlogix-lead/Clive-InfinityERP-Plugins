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
package com.clive.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.model.MTable;
import org.compiere.util.KeyNamePair;

/** Generated Interface for ER_Packing_Plan
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
public interface I_ER_Packing_Plan 
{

    /** TableName=ER_Packing_Plan */
    public static final String Table_Name = "ER_Packing_Plan";

    /** AD_Table_ID=1000065 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name ER_DailyProduction_ID */
    public static final String COLUMNNAME_ER_DailyProduction_ID = "ER_DailyProduction_ID";

	/** Set Daily Production	  */
	public void setER_DailyProduction_ID (int ER_DailyProduction_ID);

	/** Get Daily Production	  */
	public int getER_DailyProduction_ID();

	public I_ER_DailyProduction getER_DailyProduction() throws RuntimeException;

    /** Column name ER_Packing_Plan_ID */
    public static final String COLUMNNAME_ER_Packing_Plan_ID = "ER_Packing_Plan_ID";

	/** Set Packing Plan	  */
	public void setER_Packing_Plan_ID (int ER_Packing_Plan_ID);

	/** Get Packing Plan	  */
	public int getER_Packing_Plan_ID();

    /** Column name ER_Packing_Plan_UU */
    public static final String COLUMNNAME_ER_Packing_Plan_UU = "ER_Packing_Plan_UU";

	/** Set ER_Packing_Plan_UU	  */
	public void setER_Packing_Plan_UU (String ER_Packing_Plan_UU);

	/** Get ER_Packing_Plan_UU	  */
	public String getER_Packing_Plan_UU();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name PlanDate */
    public static final String COLUMNNAME_PlanDate = "PlanDate";

	/** Set Plan Date.
	  * Plan Date for a record
	  */
	public void setPlanDate (Timestamp PlanDate);

	/** Get Plan Date.
	  * Plan Date for a record
	  */
	public Timestamp getPlanDate();

    /** Column name PP_Production_Line_ID */
    public static final String COLUMNNAME_PP_Production_Line_ID = "PP_Production_Line_ID";

	/** Set Production Floor Line	  */
	public void setPP_Production_Line_ID (int PP_Production_Line_ID);

	/** Get Production Floor Line	  */
	public int getPP_Production_Line_ID();

	public I_PP_Production_Line getPP_Production_Line() throws RuntimeException;

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
