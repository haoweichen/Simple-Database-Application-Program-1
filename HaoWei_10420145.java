package assignment1;

import java.beans.Customizer;
import java.sql.*;
public class sdap1 {
	/*private static String strs[];
	private static String[] quants;
	private static String[] years;
	private static String[] months;
	private static String[] days;
	private static String[] prods;
	private static String[] custs;
	private static String customers[];
*/
	public static void main(String[] args)
	{
		String usr ="postgres";
		String pwd ="";
		String url ="jdbc:postgresql://localhost:5432/postgres";
		

		
		try
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Success loading Driver!");
		}

		catch(Exception e)
		{
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try
		{
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sales");

			
			String[] custs_max = new String[50];
			String[] prods_max = new String[50];
			String[] state_max = new String[50];
			String[] days_max = new String[50];
			String[] months_max = new String[50];
			String[] years_max = new String[50];
		    int[] quants_max = new int[50];
		    
		    String[] custs_min = new String[50];
			String[] prods_min = new String[50];
			String[] state_min = new String[50];
			String[] days_min = new String[50];
			String[] months_min = new String[50];
			String[] years_min = new String[50];
		    int[] quants_min = new int[50];
		    
		    int[] sum = new int[50];
			int[] count = new int[50];
			
			String[] custs = new String[50];
			String[] prods = new String[50];
			int[] quants_ctmax = new int[50];
			String[] days_ct = new String[50];
			String[] months_ct = new String[50];
			String[] years_ct = new String[50];
			int[] quants_nymin = new int[50];
			String[] days_ny = new String[50];
			String[] months_ny = new String[50];
			String[] years_ny = new String[50];
			int[] quants_njmin = new int[50];
			String[] days_nj = new String[50];
			String[] months_nj = new String[50];
			String[] years_nj = new String[50];
			
			
		    while (rs.next())
			{
		    	boolean IsNew = true;
				int dbQuant = Integer.parseInt(rs.getString("quant"));
				int i = 0; 
				// figure out weather the product exists in the max_array
				for (i = 0; i < prods_max.length && prods_max[i] != null; i++)
				{	
					if (rs.getString("prod").equals(prods_max[i]))
					{
						IsNew = false;
						break;
					}
				}
				count[i]++;
				sum[i] = sum[i] + dbQuant;
				// the product is not in the array
				if (IsNew)
				{
						custs_max[i] = rs.getString("cust");
						prods_max[i] = rs.getString("prod");
						state_max[i] = rs.getString("state");
						days_max[i] = rs.getString("day");
						months_max[i] = rs.getString("month");
						years_max[i] = rs.getString("year");
                        quants_max[i] = dbQuant;
						
						custs_min[i] = rs.getString("cust");
						prods_min[i] = rs.getString("prod");
						state_min[i] = rs.getString("state");
						days_min[i] = rs.getString("day");
						months_min[i] = rs.getString("month");
						years_min[i] = rs.getString("year");
						quants_min[i] = dbQuant;
	            // if the product is in the array already, then compare the value of quant in the array and in the table
				}else{
					if (quants_max[i] < dbQuant)
					{
						quants_max[i] = dbQuant;
						custs_max[i] = rs.getString("cust");
						prods_max[i] = rs.getString("prod");
						state_max[i] = rs.getString("state");
						days_max[i] = rs.getString("day");
						months_max[i] = rs.getString("month");
						years_max[i] = rs.getString("year");
					}
					if (quants_min[i] > dbQuant)
					{
						quants_min[i] = dbQuant;
						custs_min[i] = rs.getString("cust");
						state_min[i] = rs.getString("state");
						prods_min[i] = rs.getString("prod");
						days_min[i] = rs.getString("day");
						months_min[i] = rs.getString("month");
						years_min[i] = rs.getString("year");
					}
				}
				/*System.out.println(rs.getString("cust") + " " + rs.getString("prod") + " " + rs.getString("day") + " " +
					   	rs.getString("month") + " " + rs.getString("year") + " " + rs.getString("quant"));*/
			
				IsNew = true;
				int dbYear = Integer.parseInt(rs.getString("year"));
				//figure out wheather the products from CT, NY and NJ exist in the array or not
				for (i = 0; i < prods.length && prods[i] != null; i++)
				{	
					if (rs.getString("prod").equals(prods[i]) && rs.getString("cust").equals(custs[i]))
					{
						if ( rs.getString("state").equals("CT") && dbYear >= 2000 && dbYear <= 2005)
						{
							IsNew = false;
							break;
						}
						if (rs.getString("state").equals("NY") || rs.getString("state").equals("NJ"))
						{
							IsNew = false;
							break;
						}	
					}	
				}
				// if the data is not in the array, then store it in the array 
				if (IsNew){
					if (rs.getString("state").equals("CT") && dbYear >= 2000 && dbYear <= 2005)
					{
						prods[i] = rs.getString("prod");
						custs[i] = rs.getString("cust");
						quants_ctmax[i] = dbQuant;
						days_ct[i] = rs.getString("day");
						months_ct[i] = rs.getString("month");
						years_ct[i] = rs.getString("year");
					}
					if (rs.getString("state").equals("NY"))
					{
						prods[i] = rs.getString("prod");
						custs[i] = rs.getString("cust");
						quants_nymin[i] = dbQuant;
						days_ny[i] = rs.getString("day");
						months_ny[i] = rs.getString("month");
						years_ny[i] = rs.getString("year");
					}
					if (rs.getString("state").equals("NJ"))
					{
						prods[i] = rs.getString("prod");
						custs[i] = rs.getString("cust");
						quants_njmin[i] = dbQuant;
						days_nj[i] = rs.getString("day");
						months_nj[i] = rs.getString("month");
						years_nj[i] = rs.getString("year");
					}
				}
				// if the data is in the array already, then compare the value of quant between array ctmax and table, array nymin and table, array njmin and table
				if (!IsNew && rs.getString("state").equals("CT"))
				{
					if (quants_ctmax[i] < dbQuant)
					{
						quants_ctmax[i] = dbQuant;
						days_ct[i] = rs.getString("day");
						months_ct[i] = rs.getString("month");
						years_ct[i] = rs.getString("year");
					}
					if (quants_ctmax[i] == 0)
					{
						quants_ctmax[i] = dbQuant;
						days_ct[i] = rs.getString("day");
						months_ct[i] = rs.getString("month");
						years_ct[i] = rs.getString("year");
					}
				}
				if (!IsNew && rs.getString("state").equals("NY"))
				{
					if (quants_nymin[i] > dbQuant)
					{
						quants_nymin[i] = dbQuant;
						days_ny[i] = rs.getString("day");
						months_ny[i] = rs.getString("month");
						years_ny[i] = rs.getString("year");
					}
					if (quants_nymin[i] == 0)
					{
						quants_nymin[i] = dbQuant;
						days_ny[i] = rs.getString("day");
						months_ny[i] = rs.getString("month");
						years_ny[i] = rs.getString("year");
					}
				}
				if (!IsNew && rs.getString("state").equals("NJ"))
				{
					if (quants_njmin[i] >dbQuant)
					{
						quants_njmin[i] = dbQuant;
						days_nj[i] = rs.getString("day");
						months_nj[i] = rs.getString("month");
						years_nj[i] = rs.getString("year");
					}
					if (quants_njmin[i] == 0)
					{
						quants_njmin[i] = dbQuant;
						days_nj[i] = rs.getString("day");
						months_nj[i] = rs.getString("month");
						years_nj[i] = rs.getString("year");
					}	
				}
			}
		   
		    System.out.printf("%-8s %-8s %-8s %-10s %-2s %-8s %-8s %-10s %-2s %-8s\n", "PRODUCT", "MAX_Q", "CUSTOMER", "DATE", "ST", "MIN_Q", "CUSTOMER", "DATE", "ST", "AVG_Q");
		    System.out.printf("%8s %8s %8s %10s %2s %8s %8s %10s %2s %8s\n", "========", "========", "========", "==========", "==", "========", "========", "==========","==","========");
		   for (int i = 0; i < 10; i++)
		   {			   			   
			   System.out.printf("%-8s %8d %-8s %2s/%2s/%4s %2s %8d %-8s %2s/%2s/%4s %-2s %8d\n", 
					   prods_max[i], quants_max[i], custs_max[i], months_max[i], days_max[i], years_max[i], state_max[i], quants_min[i], custs_min[i], months_min[i], days_min[i], years_min[i], state_min[i], sum[i]/count[i]);	
		   }
		   System.out.println("");
		   System.out.println("");
		   System.out.printf("%-8s %-8s %-8s %-10s %-8s %-10s %-8s %-8s\n", "CUSTOMER", "PRODUCT", "CT_MAX", "DATE", "NY_MIN", "DATE", "NJ_MIN", "DATE");
		   System.out.printf("%8s %8s %8s %10s %8s %10s %8s %8s\n", "========", "========","========","==========","========","==========","========","==========");
		   for (int i = 0; i < 50; i++)
		   {
			   System.out.printf("%-8s %8s",custs[i], prods[i]);
			   if (quants_ctmax[i] == 0)
			   {
				System.out.printf(" %8s %10s", "NULL", "NULL");
			   }else{
				   System.out.printf(" %8s %2s/%2s/%4s", quants_ctmax[i], months_ct[i], days_ct[i], years_ct[i]);
			   }
			   if (quants_nymin[i] == 0)
			   {
				   System.out.printf(" %8s %10s", "NULL", "NULL");
			   }else{
				   System.out.printf(" %8s %2s/%2s/%4s", quants_nymin[i], months_ny[i], days_ny[i], years_ny[i]);
			   }
			   if (quants_njmin[i] == 0)
			   {
				   System.out.printf(" %8s %10s", "NULL", "NULL"); 
			   }else{
				   System.out.printf(" %8s %2s/%2s/%4s", quants_njmin[i], months_nj[i], days_nj[i], years_nj[i]);
			   }
			   System.out.println("");
		   }
		}

		catch(SQLException e)
		{
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}



}
