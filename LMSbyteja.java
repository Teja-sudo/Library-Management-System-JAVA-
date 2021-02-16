import java.util.*;
import java.io.*; 

class data 
{
	public static int ck=0;
	String scred,ts,da,oldcon="",oldli,newcon="",oldcont="",oldlin,newcont="";
	String[] sa=new String[4];
	String[] saa=new String[4];
	String[] sa1=new String[2];
	String get()
	{
		Scanner sc=new Scanner(System.in);
		ts=sc.nextLine();
		return ts;
	}
	void set1()
	{
		try{
		System.out.print("Enter registration number : ");
		saa[0]=get();
		System.out.print("\nEnter password : ");
		saa[1]=get();
                System.out.println();
		saa[2]="0";
		saa[3]=" ";
		da=saa[0]+","+saa[1]+","+saa[2]+","+saa[3]+System.lineSeparator()+"";
		//File fobj=new File("LMS_Database.txt");
		FileWriter fws1=new FileWriter("LMS_Database.txt",true);
		//BufferedWriter bw=new BufferedWriter(fws1);
		fws1.write(da);
		fws1.close();
		ck=2;
		credential(saa[0]);
		}
		catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
	}
	void credential(String st)
	{
		try{
		FileReader fr1=new FileReader("LMS_DataBase.txt");
		LineNumberReader lr=new LineNumberReader(fr1);
		sa[0]="0";
		while((da=lr.readLine())!=null){
		oldcont=oldcont+da+System.lineSeparator()+"";
		if(da.contains(st))
		{
			oldlin=da;
			sa=da.split(",",5);
		}
		
		}
		fr1.close();
		lr.close();
		if(sa[0].equals("0")&&ck==0) {
			System.out.println("User account not exist enter following details to create an account\n");
		set1();}
		
		}
		catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
	}
	
	void showbookrecord()
	{
		try{
		FileReader fr2=new FileReader("Bookrecord.txt");
		LineNumberReader lr1=new LineNumberReader(fr2);
		System.out.println("Book Name\t\t\tAvailable");
		while((da=lr1.readLine())!=null){
			sa1=da.split(",",3);
			System.out.println(sa1[0]+"\t\t\t  "+sa1[1]);
		}
		fr2.close();
		lr1.close();
		}
		catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
	}
	void selectbook(String sel)
		{
			try
			{
		FileReader fr3=new FileReader("Bookrecord.txt");
		LineNumberReader lr2=new LineNumberReader(fr3);
		System.out.println("Book Name\t\tAvailable");
		while((da=lr2.readLine())!=null)
		{
			oldcon=oldcon+da+System.lineSeparator()+"";
			if(da.contains(sel))
			{
			oldli=da;
			sa1=da.split(",",5);
			System.out.println(sa1[0]+"\t\t\t "+sa1[1]);
		    }
		}
		fr3.close();
		lr2.close();
		}
		catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
		}
}


class lms extends data
{
	String spwd,ts2,ts3,ts4;
	void disp()
	{
		try{
		System.out.print("\n1)Issue Book\n2)Return Book\nEnter 1 for issue book and 2 for return book : ");
            int i1;
			i1=Integer.parseInt(super.get());
			if(i1==1)
			{
				
				super.showbookrecord();
				System.out.print("Enter Available(greater than 0 only) book name : ");
				ts4=super.get();
				super.selectbook(ts4);
				if(!super.sa1[0].equals(ts4))
				{
					System.out.println("Book not available enter only available book");
					disp();
				}
				if( super.sa1[1].equals("0"))
				{
					System.out.println("Book not available enter only available book");
					disp();
				}
				super.sa1[1]=String.valueOf(Integer.parseInt(super.sa1[1])-1);
				super.sa[2]=String.valueOf(Integer.parseInt(super.sa[2])+1);
				super.sa[3]=super.sa[3]+ts4;
				super.newcont=super.sa[0]+","+super.sa[1]+","+super.sa[2]+","+super.sa[3]+System.lineSeparator();
				super.newcon=super.sa1[0]+super.sa1[1]+System.lineSeparator();
		 		FileWriter fnw1 = new FileWriter("LMS_DataBase.txt",false);
				//System.out.println(super.oldcon);
				//System.out.println(super.oldcont);
				String nstr1=super.oldcont.replaceAll(super.oldlin, super.newcont);
                fnw1.write(nstr1);
                fnw1.close();
				String nstr2=super.oldcon.replaceAll(super.oldli, super.newcon);
				FileWriter fnw2 = new FileWriter("Bookrecord.txt",false);
                fnw2.write(nstr2);
                fnw2.close();
				System.out.println("Thank You for visiting\nProgram terminated......");
				
			}
				else{
				System.out.print("Enter book name : ");
				ts3=super.get();
                                System.out.println();
				super.selectbook(ts3);
				if(super.sa[2].equals("0"))
				{
					System.out.println("you haven't take "+ts3+"book");
					disp();
				}
				String a=super.sa1[0].trim();
				/*if(!a.equals(ts3))
				{
					System.out.println("you haven't take "+ts3+"book");
					disp();
				}*/
				super.sa1[1]=String.valueOf(Integer.parseInt(super.sa1[1])+1);
				super.sa[2]=String.valueOf(Integer.parseInt(super.sa[2])-1);
				super.sa[3]="\t";
				super.newcont=super.sa[0]+","+super.sa[1]+","+super.sa[2]+","+super.sa[3]+System.lineSeparator()+"";
				super.newcon=super.sa1[0]+super.sa1[1]+System.lineSeparator()+"";
		 		FileWriter fnw11 = new FileWriter("LMS_DataBase.txt",false);
				//System.out.println(super.oldcon);
				//System.out.println(super.oldcont);
				String nstr11=super.oldcont.replaceAll(super.oldlin, super.newcont);
                fnw11.write(nstr11);
                fnw11.close();
				String nstr22=super.oldcon.replaceAll(super.oldli, super.newcon);
				FileWriter fnw22 = new FileWriter("Bookrecord.txt",false);
                fnw22.write(nstr22);
                fnw22.close();
				System.out.println("Thank You for visiting\nProgram terminated......");
				}
				
			
		}
		catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
	}
	void disp1()
	{
		System.out.print("Enter your password : ");
		spwd=super.get();
		if(spwd.equals(super.sa[1]))
		{
			System.out.println("\nRegistration number\t\tBooks issued count\t\tBook Name\n"+sa[0]+"\t\t\t\t"+sa[2]+"\t\t\t\t"+sa[3]);
            disp();	
		}
		else
		{
			System.out.println("Wrong password ");
			disp1();
		}
	}
}


class Library
{
	public static void main(String[] ar)
	{
		try
	 {
	  
	  File f1 = new File("LMS_Database.txt");
	  File f2 = new File("Bookrecord.txt");
      if (!f1.exists()) 
	  {
		f1.createNewFile();
        String s1="Registration number,password,issued_bookcount,book name"+System.lineSeparator()+"11602316,1234,0,\t"+System.lineSeparator()+"11702316,abcd,1,python"+System.lineSeparator()+"11802316,ab12,1,java"+System.lineSeparator();
		FileWriter f1w = new FileWriter("LMS_DataBase.txt");
        f1w.write(s1);
        f1w.close();
		
      }
	 // f1.close();
	   if (!f2.exists()) 
	  {
		f2.createNewFile();
        String s2="book name,availability count"+System.lineSeparator()+"maths,10"+System.lineSeparator()+"c++,10"+System.lineSeparator()+"java,9"+System.lineSeparator()+"python,8"+System.lineSeparator()+"physics,10"+System.lineSeparator()+"chemistry,10"+System.lineSeparator()+"c language,10"+System.lineSeparator();
		FileWriter f2w = new FileWriter("Bookrecord.txt");
        f2w.write(s2);
		f2w.close();
		
      }
	  //f2.close();
	  String sreg;
	  lms obj1=new lms();
	  System.out.print("Enter registration number : ");
	  sreg=obj1.get();
	  obj1.credential(sreg);
	  obj1.disp1();
	  
	 }
		 catch (Exception e)
		 {
          System.out.println(e.getMessage());
          }
		
	}
}
