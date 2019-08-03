package com.server;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.client.GreetingService;
import com.shared.Requestedhawkerdetails;
import com.shared.PlanRequest;
import com.shared.Add;
import com.shared.Assignedhawkerdetails;
import com.shared.CustomerDetails;
import com.shared.CommonList;
import com.shared.RegisterDetails;
import com.shared.RequestAccept;
import com.shared.gcd;
import com.shared.HawkerDetails;
import com.shared.NewCustomerInfo;
import com.shared.PaymentDetails;
import com.shared.logindetails;
import com.shared.planDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.shared.Cale;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {
	MongoClient mongo;
	String dbName;
	DB db;
	public void init()
	{
		mongo=new MongoClient("localhost",27017);
		dbName="huckster";
		db = mongo.getDB(dbName);
	}
	

	@Override
	public String loginDetails(logindetails l) throws IllegalArgumentException {
		String username,password;
		username=l.getUsername();
		password=l.getPassword();
		init();
		DBCollection table = db.getCollection("client");
		BasicDBObject whereQuery=new BasicDBObject();
		whereQuery.put("email",username);
		BasicDBObject fields=new BasicDBObject();
		fields.put("password",5);
		DBCursor cursor=table.find(whereQuery,fields);
		if(!cursor.hasNext())
		{
			return "Invalid User";
		}
		else
		{
			String pass=cursor.next().get("password").toString();
			if(pass.equals(password))
			{
				return "success";
			}
		}
		return "Invalid Password";
		
	}



	@Override
	public CommonList Haw(String S) throws IllegalArgumentException {
		int n,i=0;
		init();
		DBCollection table=db.getCollection("hawkers");
		BasicDBObject query=new BasicDBObject("plan."+S,new BasicDBObject("$exists",true));
		DBCursor cursor=table.find(query);
		n=cursor.count();
		String a[]=new String[n];
		while(cursor.hasNext())
		{
			a[i]=cursor.next().get("email").toString();
			i++;
		}
		CommonList h=new CommonList();
		h.setN(n);
		h.setC(a);
		return h;
	}

	@Override
	public HawkerDetails hawkerDetails(String hawkeremail) throws IllegalArgumentException {
		init();
		DBCollection table = db.getCollection("hawkers");
		BasicDBObject query=new BasicDBObject();
		query.put("email",hawkeremail);
		DBCursor cursor=table.find(query);
		HawkerDetails hd=new HawkerDetails();
		if(cursor.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)cursor.next();
			hd.setAddress(obj.getString("address"));
			hd.setName(obj.getString("name"));
			hd.setPhone(obj.getString("phone"));
			hd.setEmail(obj.getString("email"));
			BasicDBObject obj2=(BasicDBObject)obj.get("plan");
			BasicDBObject obj3=(BasicDBObject)obj2.get("milk");
			BasicDBObject obj4=(BasicDBObject)obj2.get("newspaper");
			BasicDBObject obj5=(BasicDBObject)obj2.get("combo");
			if(obj3!=null)
			{
				hd.setMilkprice(obj3.getString("price"));
			}
			if(obj4!=null)
			{ 	System.out.println("hii"+obj4.getString("price"));
				hd.setNewspaperprice(obj4.getString("price"));
			}
			if(obj5!=null)
			{
				
				hd.setComboprice(obj5.getString("price"));
			}
		}
		
		return hd;
	}



	@Override
	public String request(PlanRequest pr) throws IllegalArgumentException {
		String clientemail=pr.getClientemail();
		String hawkeremail=pr.getHawkeremail();
		String plan=pr.getPlan();
		String plancost=pr.getPlancost();
		init();
		DBCollection table=db.getCollection("clientrequest");
		BasicDBObject document=new BasicDBObject();
		document.put("clientemail",clientemail);
		document.put("hawkeremail", hawkeremail);
		document.put("plan",plan);
		document.put("plancost",plancost);
		table.insert(document);
		return "Plan Added Successfully.";
	}

	@Override
	public Assignedhawkerdetails assignedHawker(String hawkeremail,String clientemail) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("hawkers");
		BasicDBObject query=new BasicDBObject();
		BasicDBObject query2=new BasicDBObject();
		query.put("email", hawkeremail);
		DBCursor cursor=table.find(query);
		Assignedhawkerdetails ahd=new Assignedhawkerdetails();

			BasicDBObject obj=new BasicDBObject();
			obj=(BasicDBObject)cursor.next();
			ahd.setName(obj.getString("name"));
			ahd.setPhone(obj.getString("phone"));
			ahd.setEmail(obj.getString("email"));
			ahd.setAddress(obj.getString("address"));
			table=db.getCollection("assignedhawkersandclients");
			query=new BasicDBObject();
			query.put("clientemail",clientemail);
			query2.put("hawkeremail",hawkeremail);
			List<BasicDBObject> query3=new ArrayList<BasicDBObject>();
			query3.add(query);
			query3.add(query2);
			BasicDBObject andQuery=new BasicDBObject();
			andQuery.put("$and", query3);
			cursor=table.find(andQuery);
			obj=new BasicDBObject();
			obj=(BasicDBObject)cursor.next();
			obj.getString("plan");
			ahd.setService(obj.getString("plan"));
			BasicDBList list=(BasicDBList)obj.get("leavedates");
			ahd.setN(list.size());
			ahd.setMonthlyplan(obj.getString("plancost"));
			String a[]=new String[list.size()];
			int i=0;
			for(Object element:list)
			{
				a[i++]=(String)element;
			}
			ahd.setLeave(a);
		return ahd;
	}

	@Override
	public PaymentDetails pay() throws IllegalArgumentException {
		PaymentDetails p=new PaymentDetails();
		p.setMonthlycost(500);
		p.setDays(5);
		return p;
	}
	@Override
	public Add Calci(int a1, Add ab) throws IllegalArgumentException {

		ab.setDate1(Integer.toString(a1));
		return ab;
	}

	@Override
	public Add SetCalci(String a2, Add ab1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		ab1.setDate1(a2);
		return ab1;
	}

	@Override
	public String hawkerloginDetails(logindetails l) throws IllegalArgumentException {
		String username,password;
		username=l.getUsername();
		password=l.getPassword();
		init();
		DBCollection table = db.getCollection("hawkers");
		BasicDBObject whereQuery=new BasicDBObject();
		whereQuery.put("email",username);
		BasicDBObject fields=new BasicDBObject();
		fields.put("password",5);
		DBCursor cursor=table.find(whereQuery,fields);
		if(!cursor.hasNext())
		{
			return "Invalid User";
		}
		else
		{
			String pass=cursor.next().get("password").toString();
			if(pass.equals(password))
			{
				return "success";
			}
		}
		return "Invalid Password";
	}

	@Override
	public String registerDetails(RegisterDetails sd) throws IllegalArgumentException {
		String name,email,address,phone,password;
		name=sd.getName();
		email=sd.getEmail();
		address=sd.getAddress();
		phone=sd.getPhone();
		password=sd.getPassword();
		init();
		DBCollection table = db.getCollection("client");
		BasicDBObject document = new BasicDBObject();
		DBCursor cursor=table.find();
		while(cursor.hasNext())
		{
			if((cursor.next().get("email").toString()).equals(email))
			{
				return "Username Already Exists.";
			}
		}
		List<String> list=new ArrayList<String>();
		document.put("name", name);
		document.put("email",email);
		document.put("address",address);
		document.put("phone",phone);
		document.put("password", password);
		table.insert(document);
		table = db.getCollection("calendar");
		document=new BasicDBObject();
		document.put("clientemail",email);
		document.put("hawkeremail","");
		document.put("leavedates",list);
		table.insert(document);
		return "success";
	}

	@Override
	public String plandetails(planDetails sd) throws IllegalArgumentException {
		init();
		DBCollection table = db.getCollection("hawkers");
		String mpm,qm,mpn,mpc,qc,email;
		email=sd.getEmail();
		mpm=sd.getMpm();
		qm=sd.getQm();
		mpn=sd.getMpn();
		mpc=sd.getMpc();
		qc=sd.getQc();
		BasicDBObject query=new BasicDBObject();
		query.put("email", email);
		System.out.println(email);
		BasicDBObject doc1=new BasicDBObject();
		if(!mpm.equals("none"))
		{
			BasicDBObject doc=new BasicDBObject();
			doc.put("price", mpm);
			doc.put("quantity",qm);
			doc1.put("milk", doc);
		}
		if(!mpn.equals("none"))
		{
			BasicDBObject doc=new BasicDBObject();
			doc.put("price", mpn);
			doc1.put("newspaper", doc);
		}
		if(!mpc.equals("none"))
		{
			BasicDBObject doc=new BasicDBObject();
			doc.put("price", mpc);
			doc.put("quantity", qc);
			doc1.put("combo", doc);
		}
		BasicDBObject update=new BasicDBObject();
		BasicDBObject doc2=new BasicDBObject();
		doc2.put("plan", doc1);
		update.put("$set",doc2);
		WriteResult result=table.update(query,update);
		return "success";
	}

	@Override
	public CommonList cust(String hawkeremail) throws IllegalArgumentException {
		int n,i=0;
		init();
		DBCollection table=db.getCollection("existingclients");
		BasicDBObject query=new BasicDBObject();
		query.put("hawkeremail", hawkeremail);
		DBCursor cursor=table.find(query);
			BasicDBList dlist=(BasicDBList)cursor.next().get("clientsemail");
			n=dlist.size();
			String a[]=new String[n];
			for(Object element:dlist)
			{
				a[i]=(String)element;
				i++;
			}
			
			CommonList c=new CommonList();
			c.setN(n);
			c.setC(a);
			return c;
	}

	@Override
	public CustomerDetails customerDetails(String hawkeremail,String clientemail) throws IllegalArgumentException {
		CustomerDetails cd=new CustomerDetails();
		init();
		DBCollection table=db.getCollection("client");
		BasicDBObject query=new BasicDBObject();
		BasicDBObject query2=new BasicDBObject();
		query.put("email", clientemail);
		DBCursor cursor=table.find(query);
			BasicDBObject obj=(BasicDBObject)cursor.next();
			cd.setName(obj.getString("name"));
			cd.setEmail(obj.getString("email"));
			cd.setAddress(obj.getString("address"));
			cd.setPhone(obj.getString("phone"));
			table=db.getCollection("assignedhawkersandclients");
			query=new BasicDBObject();
			query.put("clientemail",clientemail);
			query2.put("hawkeremail",hawkeremail);
			List<BasicDBObject> query3=new ArrayList<BasicDBObject>();
			query3.add(query);
			query3.add(query2);
			BasicDBObject andQuery=new BasicDBObject();
			andQuery.put("$and", query3);
			cursor=table.find(andQuery);
			obj=(BasicDBObject)cursor.next();
			cd.setPlan(obj.getString("plan"));
			cd.setPayment(obj.getString("plancost"));
			BasicDBList list=(BasicDBList)obj.get("leavedates");
		int n,i=0;
		n=list.size();
		String x[]=new String[n];
		for(Object element:list)
		{
			x[i++]=(String)element;
		}
		cd.setN(n);
		cd.setLeave(x);
		return cd;
	}

	@Override
	public CommonList newCustomers(String hawkeremail) throws IllegalArgumentException {
		int n,i=0;
		init();
		DBCollection table=db.getCollection("clientrequest");
		BasicDBObject query=new BasicDBObject();
		query.put("hawkeremail",hawkeremail);
		DBCursor cursor=table.find(query);
		n=cursor.count();
		String a[]=new String[n];
		while(cursor.hasNext())
		{
			a[i]=cursor.next().get("clientemail").toString();
			i++;
		}
		CommonList c=new CommonList();
		c.setN(n);
		c.setC(a);
		return c;
	}

	@Override
	public NewCustomerInfo newCustomersInfo(String clientemail,String hawkeremail) throws IllegalArgumentException {
		NewCustomerInfo nci=new NewCustomerInfo();
		init();
		DBCollection table=db.getCollection("client");
		BasicDBObject query=new BasicDBObject();
		BasicDBObject query2=new BasicDBObject();
		BasicDBObject query3=new BasicDBObject();
		query.put("email",clientemail);
		DBCursor cursor=table.find(query);
		if(cursor.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)cursor.next();
			nci.setName(obj.getString("name"));
			nci.setEmail(obj.getString("email"));
			nci.setAddress(obj.getString("address"));
			nci.setPhone(obj.getString("phone"));
		}
		table=db.getCollection("clientrequest");
		query=new BasicDBObject();
		query.put("clientemail",clientemail);
		query2.put("hawkeremail",hawkeremail);
		List<BasicDBObject> list=new ArrayList<BasicDBObject>();
		list.add(query);
		list.add(query2);
		query3.put("$and",list);
		cursor=table.find(query3);
		if(cursor.hasNext())
		{	BasicDBObject obj=new BasicDBObject();
			obj=(BasicDBObject)cursor.next();
			nci.setPlan(obj.getString("plan"));
			nci.setPlancost(obj.getString("plancost"));
		}

		return nci;
	}


	


	@Override
	public String requestAccept(RequestAccept ra) throws IllegalArgumentException {
		String hawkeremail,clientemail;
		hawkeremail=ra.getHawkeremail();
		clientemail=ra.getClientemail();
		init();
		DBCollection table=db.getCollection("existingclients");
		BasicDBObject query=new BasicDBObject();
		query.put("hawkeremail",hawkeremail);
		BasicDBObject updatequery=new BasicDBObject();
		updatequery.put("clientsemail",clientemail);
		BasicDBObject doc=new BasicDBObject();
		doc.put("$push", updatequery);
		table.update(query, doc);
		table=db.getCollection("clientrequest");
		query=new BasicDBObject();
		query.put("clientemail", clientemail);
		DBCursor cursor=table.find(query);
		doc=new BasicDBObject();
		doc=(BasicDBObject)cursor.next();
		String plan=doc.getString("plan");
		String plancost=doc.getString("plancost");
		table.remove(query);
		table=db.getCollection("calendar");
		query=new BasicDBObject();
		query.put("clientemail", clientemail);
		cursor=table.find(query);
		BasicDBList list=(BasicDBList)cursor.next().get("leavedates");
		int i=0,n=list.size();
		String a[]=new String[n];
		
		for(Object element:list)
		{
			a[i++]=(String)element;
		}
		ArrayList <String> l=new ArrayList<String>();
		table=db.getCollection("assignedhawkersandclients");
		BasicDBObject document=new BasicDBObject();
		document.put("clientemail", clientemail);
		document.put("hawkeremail", hawkeremail);
		document.put("plan",plan);
		document.put("plancost", plancost);
		document.put("leavedates",l);
		table.insert(document);
		document=new BasicDBObject();
		query=new BasicDBObject();
		query.put("clientemail", clientemail);
		document=new BasicDBObject();
		BasicDBObject doc1=new BasicDBObject();
		for(int j=0;j<n;j++)
		{
			document.put("leavedates",a[j]);
			doc1.put("$push",document);
			table.update(query, doc1);
			
		}
		
	
		return "success";
	}

	@Override
	public CommonList AllHaw(String hawkeremail) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("hawkers");
		DBCursor cursor=table.find();
		CommonList c=new CommonList();
		int n=cursor.count();
		String a[]=new String[n];
		int i=0;
		while(cursor.hasNext())
		{
			a[i]=cursor.next().get("email").toString();
			i++;
		}
		c.setC(a);
		c.setN(n);
		return c;
	}



	@Override
	public String removeHawker(String hawkeremail) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("hawkers");
		BasicDBObject query=new BasicDBObject();
		query.put("email", hawkeremail);
		table.remove(query);
		table=db.getCollection("assignedhawkersandclients");
		query=new BasicDBObject();
		query.put("hawkeremail",hawkeremail);
		table.remove(query);
		table=db.getCollection("existingclients");
		table.remove(query);
		return "success";
	}



	@Override
	public String adminloginDetails(logindetails l) throws IllegalArgumentException {
		String username,password;
		username=l.getUsername();
		password=l.getPassword();
		init();
		DBCollection table = db.getCollection("admin");
		BasicDBObject whereQuery=new BasicDBObject();
		whereQuery.put("email",username);
		BasicDBObject fields=new BasicDBObject();
		fields.put("password",5);
		DBCursor cursor=table.find(whereQuery,fields);
		if(!cursor.hasNext())
		{
			return "Invalid User";
		}
		else
		{
			String pass=cursor.next().get("password").toString();
			if(pass.equals(password))
			{
				return "success";
			}
		}
		return "Invalid Password";
	}



	@Override
	public CommonList Allcust(String hn) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("client");
		DBCursor cursor=table.find();
		CommonList c=new CommonList();
		int n=cursor.count();
		String a[]=new String[n];
		int i=0;
		while(cursor.hasNext())
		{
			a[i]=cursor.next().get("email").toString();
			i++;
		}
		c.setC(a);
		c.setN(n);
		return c;
	}



	@Override
	public String removeClient(String clientemail) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("client");
		BasicDBObject query=new BasicDBObject();
		query.put("email", clientemail);
		table.remove(query);
		table=db.getCollection("assignedhawkersandclients");
		query=new BasicDBObject();
		query.put("clientemail",clientemail);
		table.remove(query);
		table=db.getCollection("calendar");
		table.remove(query);
		table=db.getCollection("existingclients");
		query=new BasicDBObject();
		query.put("clientsemail",clientemail);
		BasicDBObject doc=new BasicDBObject();
		doc.put("$pull", query);
		table.update(query, doc);
		return "success";
	}


	@Override
	public String registerDetailsHawkers(RegisterDetails rd) throws IllegalArgumentException {
		String name,email,address,phone,password;
		name=rd.getName();
		email=rd.getEmail();
		address=rd.getAddress();
		phone=rd.getPhone();
		password=rd.getPassword();
		init();
		DBCollection table = db.getCollection("hawkers");
		DBCursor cursor=table.find();
		while(cursor.hasNext())
		{
			if((cursor.next().get("email").toString()).equals(email))
			{
				return "Username Already Exists.";
			}
		}
		List<String> array = new ArrayList<String>();
		BasicDBObject document = new BasicDBObject();
		document.put("name", name);
		document.put("email",email);
		document.put("address",address);
		document.put("phone",phone);
		document.put("password", password);
		table.insert(document);
		table=db.getCollection("existingclients");
		document=new BasicDBObject();
		document.put("hawkeremail",email);
		document.put("clientsemail", array);
		table.insert(document);
		return "success";
	}


	@Override
	public String Cal(Cale d) throws IllegalArgumentException {
		init();
		int n;
		n=d.getN();
		Date a[]=new Date[n];
		a=d.getD();
		String x[]=new String[n];
		for(int i=0;i<n;i++)
		{
			x[i]=a[i].toString();
		}
		DBCollection table = db.getCollection("calendar");
		BasicDBObject query = new BasicDBObject();
		BasicDBObject updatequery = new BasicDBObject();
		BasicDBObject doc1 = new BasicDBObject();
		BasicDBObject doc2 = new BasicDBObject();
		query.put("clientemail", d.getClientemail());
		doc2.put("hawkeremail",d.getHawkeremail());
		doc1.put("$set", doc2);
		table.update(query, doc1);
		doc1=new BasicDBObject();
		for(int i=0;i<n;i++)
		{
		updatequery.put("leavedates", x[i]);
		doc1.put("$push",updatequery);
		table.update(query, doc1);
		
		}
		
		
		return "OK";
	}


	@Override
	public gcd getCustomerDetails(String x) throws IllegalArgumentException {
		init();
		DBCollection table=db.getCollection("client");
		BasicDBObject query=new BasicDBObject();
		query.put("email", x);
		DBCursor cursor=table.find(query);
		BasicDBObject obj=(BasicDBObject)cursor.next();
		String name=obj.getString("name");
		String email=obj.getString("email");
		String phone=obj.getString("phone");
		String address=obj.getString("address");
		gcd g=new gcd();
		g.setName(name);
		g.setAddress(address);
		g.setEmail(email);
		g.setPhone(phone);
		return g;
	}


	@Override
	public CommonList assignedHawkerList(String clientemail) throws IllegalArgumentException {
		init();
		CommonList cl=new CommonList();
		DBCollection table=db.getCollection("assignedhawkersandclients");
		BasicDBObject query=new BasicDBObject();
		query.put("clientemail",clientemail);
		DBCursor cursor=table.find(query);
		int n,i=0;
		n=cursor.count();
		String a[]=new String[n];
		while(cursor.hasNext())
		{
			a[i++]=cursor.next().get("hawkeremail").toString();
		}
		cl.setN(n);
		cl.setC(a);
		return cl;
	}


	@Override
	public CommonList getRequestedHawkers(String clientemail) throws IllegalArgumentException {
		init();
		CommonList cl=new CommonList();
		DBCollection table=db.getCollection("clientrequest");
		BasicDBObject query=new BasicDBObject();
		query.put("clientemail",clientemail);
		DBCursor cursor=table.find(query);
		int n=cursor.count();
		String a[]=new String[n];
		int i=0;
		while(cursor.hasNext())
		{
			a[i++]=cursor.next().get("hawkeremail").toString();
		}
		cl.setN(n);
		cl.setC(a);
		return cl;
	}


	@Override
	public Requestedhawkerdetails requestedHawkerDetails(String hawkeremail, String clientemail)
			throws IllegalArgumentException {
		Requestedhawkerdetails rhd=new Requestedhawkerdetails();
		init();
		DBCollection table=db.getCollection("hawkers");
		BasicDBObject query=new BasicDBObject();
		BasicDBObject query2=new BasicDBObject();
		BasicDBObject query3=new BasicDBObject();
		query.put("email",hawkeremail);
		DBCursor cursor=table.find(query);
		if(cursor.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)cursor.next();
			rhd.setName(obj.getString("name"));
			rhd.setEmail(obj.getString("email"));
			rhd.setAddress(obj.getString("address"));
			rhd.setPhone(obj.getString("phone"));
		}
		table=db.getCollection("clientrequest");
		query=new BasicDBObject();
		query.put("clientemail",clientemail);
		query2.put("hawkeremail",hawkeremail);
		List<BasicDBObject> list=new ArrayList<BasicDBObject>();
		list.add(query);
		list.add(query2);
		query3.put("$and",list);
		cursor=table.find(query3);
		if(cursor.hasNext())
		{	BasicDBObject obj=new BasicDBObject();
			obj=(BasicDBObject)cursor.next();
			rhd.setPlan(obj.getString("plan"));
			rhd.setPlancost(obj.getString("plancost"));
		}
		
		
		return rhd;
	}

}
