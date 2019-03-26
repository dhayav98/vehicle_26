package Vehicle_package;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class VehicleDAO
{
	public static Connection GetConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cogdb","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

	public static int SaveDetails(User v)
	{
	   int savedstatus=0;
	   try
	   {
		Connection con=VehicleDAO.GetConnection();
		PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,v.getEmployeeid());
		ps.setString(2,v.getFirstname());
		ps.setString(3,v.getLastname());
		ps.setInt(4,v.getAge());
		ps.setString(5,v.getGender());
		ps.setLong(6,v.getPhone());
		ps.setString(7,v.getEmailid());
		ps.setString(8,v.getPassword());
		ps.setString(9,v.getBranch() );
		savedstatus=ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		System.out.println(e);
	   }
	   return savedstatus;
   }
	
	public static int logincheck(User v)
	{
		int loginstatus=0;
		try
		{
			String empid=v.getEmployeeid();
			String password=v.getPassword();
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select employeeid,password from userdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if((empid.equalsIgnoreCase(rs.getString(1)))&& (password.equalsIgnoreCase(rs.getString(2))))
				{
					loginstatus=1;
					break;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return loginstatus;
	}
	
	public static int SaveVehicleDetails(Vehicle v)
	{
		int status=0;
		try
		{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
			
			java.util.Date d1=sdf.parse(v.getInsurance_expiry());
			java.sql.Date sqldate1= new java.sql.Date(d1.getTime());
			
			java.util.Date d2=sdf.parse(v.getInsurance_expiry());
			java.sql.Date sqldate2= new java.sql.Date(d2.getTime());
			
			java.util.Date d3=sdf.parse(v.getInsurance_expiry());
			java.sql.Date sqldate3= new java.sql.Date(d3.getTime());
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("insert into vehicledetails values(?,?,?,?,?,?)");
			ps.setInt(1,v.getVehicleno());
			ps.setString(2,v.getBranch());
			ps.setString(3,v.getVehicletype());
			//System.out.println("1");
			ps.setDate(4,sqldate1);
			//System.out.println("2");
			ps.setDate(5,sqldate2);
			//System.out.println("3");
			ps.setDate(6,sqldate3);
			//System.out.println("4");
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("vechileDAO vehicledeatails :"+e);
		}
		
		return status;
	}
	 
	public static ArrayList SearchVehicleDetails()
	{
		ArrayList<Vehicle> list=new ArrayList<Vehicle>();
		try
		{
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from vehicledetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Vehicle v= new Vehicle();
				v.setVehicleno(rs.getInt("vehicleno"));
				v.setBranch(rs.getString("branch"));
				v.setVehicletype(rs.getString("vehicletype"));
				v.setInsurance_expiry(rs.getDate("insurance_expiry").toString());
				v.setService_due_date(rs.getDate("service_due_date").toString());
				v.setLast_serviced_date(rs.getDate("last_serviced_date").toString());
				list.add(v);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static ArrayList SearchCriteria(int choice,String data)
	{
		ArrayList<Vehicle> list1=new ArrayList<Vehicle>();
		try
		{
			//Connection con=VehicleDAO.GetConnection();
			Connection con=null;
			PreparedStatement ps;
			int status;
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d1=null;
			ResultSet rs=null;
			switch(choice)
			{
				case 1:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where branch=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
				case 2:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where vehicletype=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
				case 3:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where insurance_expiry=?");
					d1=sdf.parse(data);
					java.sql.Date sqldate1= new java.sql.Date(d1.getTime());
					ps.setDate(1,sqldate1);
					rs=ps.executeQuery();
					break;
				case 4:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where service_due_date=?");
					d1=sdf.parse(data);
					java.sql.Date sqldate2= new java.sql.Date(d1.getTime());
					ps.setDate(1,sqldate2);
					rs=ps.executeQuery();
					break;
					
			}
			while(rs.next())
			{
				Vehicle v= new Vehicle();
				v.setVehicleno(rs.getInt("vehicleno"));
				v.setBranch(rs.getString("branch"));
				v.setVehicletype(rs.getString("vehicletype"));
				v.setInsurance_expiry(rs.getDate("insurance_expiry").toString());
				v.setService_due_date(rs.getDate("service_due_date").toString());
				v.setLast_serviced_date(rs.getDate("last_serviced_date").toString());
				list1.add(v);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		return list1;
	}
	
	public static int UpdateVehicleDetails(int choice, String s, int vehicleno) throws Exception
	{
		int status=0;
		try
		{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d1=null;
			Connection con=null;
			PreparedStatement ps;
			switch(choice)
			{
				
				case 1:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set branch=? where vehicleno=?");
					ps.setString(1,s);
					ps.setInt(2,vehicleno);
					status=ps.executeUpdate();
					break;

				case 2:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set vehicletype=? where vehicleno=?");
					ps.setString(1,s);
					ps.setInt(2,vehicleno);
					status=ps.executeUpdate();
					break;

				case 3:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set insurance_expiry=? where vehicleno=?");
					d1=sdf.parse(s);
					java.sql.Date sqldate1= new java.sql.Date(d1.getTime());
					ps.setDate(1,sqldate1);
					ps.setInt(2,vehicleno);
					status=ps.executeUpdate();
					break;
				case 4:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set last_serviced_date=? where vehicleno=?");
					d1=sdf.parse(s);
					java.sql.Date sqldate2= new java.sql.Date(d1.getTime());
					ps.setDate(1,sqldate2);
					ps.setInt(2,vehicleno);
					status=ps.executeUpdate();
					break;
				case 5:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set service_due_date=? where vehicleno=?");
					d1=sdf.parse(s);
					java.sql.Date sqldate3= new java.sql.Date(d1.getTime());
					ps.setDate(1,sqldate3);
					ps.setInt(2,vehicleno);
					status=ps.executeUpdate();
					break;			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

}
