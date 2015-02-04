import java.util.Hashtable;
import java.util.Scanner;

public class large_polynomials {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime=0;
		long endTime = 0;
		Scanner scan = new Scanner(System.in);
		linkedlist exec_order = new linkedlist();
		linkedlist printlist = new linkedlist();
		linkedlist L1 = new linkedlist();
		linkedlist L2 = new linkedlist();
		linkedlist L3 = new linkedlist();
		linkedlist loop_list = new linkedlist();
		String expr,Decimalvalue,toprint;
		int assgn_split;
		String parts[];
		char var1,var2,var3,var4,var5;
		char check_num = 0;
		Hashtable h1 = new Hashtable();
		int line_num,loop_line;
		int expr_len;
		// Handle input from the user
		// Using Hash map to store variable and its value with variable as key
		// Linked list exec_order to save the order of execution with line number
		while(true)
		{
			startTime = System.currentTimeMillis();
			line_num = Integer.parseInt(scan.next());
			expr = scan.next();
			exec_order.insert_exp(expr,line_num);
			expr_len = expr.length();
			assgn_split=expr.split("=").length;
			if(assgn_split>1)
			{
				check_num = expr.charAt(2);
			}
			if(expr_len == 1)
			{
				var1 = expr.charAt(0);
				printlist = (linkedlist) h1.get(var1);
				toprint = printlist.NumToStr(printlist);
				System.out.println(toprint);
				endTime = System.currentTimeMillis();
				

			}
			else if(assgn_split == 2 && Character.isDigit(check_num))
			{
				assgn_split =0;
				var1 = expr.charAt(0);
				var2 = expr.charAt(1);
				parts = expr.split("=");
				Decimalvalue = parts[1];
				switch(var2)
				{
				case '=':linkedlist a = new linkedlist();
				a = a.StrToNum(Decimalvalue);
				h1.put(var1, a);

				break;
				case '?':
					break;

				}
			}
			else if(expr_len == 3 && assgn_split!=2)
			{
				var1 = expr.charAt(0);
				var2 = expr.charAt(1);
				parts = expr.split("\\?");
				loop_line = Integer.parseInt(parts[1].toString());
				switch(var2)
				{

				case '?':node loop_exec = exec_order.head.getNext();
				loop_list = (linkedlist) h1.get(var1);

				while(!loop_list.IsZero())
				{
					loop_exec = exec_order.head.getNext();
					for(int i=1;i<loop_line;i++)
					{
						loop_exec = loop_exec.getNext();
					}
					for(int j=1;j<=(line_num-loop_line);j++)
					{
						//line_num = loop_exec.getLinenumber();
						expr = loop_exec.getData().toString();
						//exec_order.insert_exp(expr,line_num);
						expr_len = expr.length();
						assgn_split=expr.split("=").length;
						if(assgn_split>1)
						{
							check_num = expr.charAt(2);
						}
						if(expr_len == 1)
						{
							var1 = expr.charAt(0);
							printlist = (linkedlist) h1.get(var1);
							toprint = printlist.NumToStr(printlist);
							System.out.println(toprint);

						}
						else if(assgn_split == 2 && Character.isDigit(check_num))
						{
							assgn_split =0;
							var1 = expr.charAt(0);
							var2 = expr.charAt(1);
							parts = expr.split("=");
							Decimalvalue = parts[1];
							switch(var2)
							{
							case '=':linkedlist a = new linkedlist();
							a = a.StrToNum(Decimalvalue);
							h1.put(var1, a);

							break;
							case '?':
								break;

							}
						}
						else if(expr_len == 5)
						{
							var1 = expr.charAt(0);
							var2 = expr.charAt(1);
							var3 = expr.charAt(2);
							var4 = expr.charAt(3);
							var5 = expr.charAt(4);
							switch(var4)
							{

							case '+':L1 = (linkedlist) h1.get(var3);
							L2 = (linkedlist) h1.get(var5);
							L3 = L3.add(L1, L2);
							h1.put(var1, L3);
							break;
							case '-':L1 = (linkedlist) h1.get(var3);
							L2 = (linkedlist) h1.get(var5);
							L3 = L3.Subtract(L1, L2);
							h1.put(var1, L3);
							break;
							case '*':L1 = (linkedlist) h1.get(var3);
							L2 = (linkedlist) h1.get(var5);
							L3 = L3.multiply(L1, L2);
							h1.put(var1, L3);
							break;
							case '^':L1 = (linkedlist) h1.get(var3);
							L2 = (linkedlist) h1.get(var5);
							L3 = L3.Power(L1, L2);
							h1.put(var1, L3);
							break;


							}
						}
						else
						{
							System.out.println("input format error");
						}
						loop_exec = loop_exec.getNext();
						loop_list = (linkedlist) h1.get(var1);
					}
				}
				break;

				}
			}
			else if(expr_len == 5)
			{
				var1 = expr.charAt(0);
				var2 = expr.charAt(1);
				var3 = expr.charAt(2);
				var4 = expr.charAt(3);
				var5 = expr.charAt(4);
				switch(var4)
				{

				case '+':L1 = (linkedlist) h1.get(var3);
				L2 = (linkedlist) h1.get(var5);
				L3 = L3.add(L1, L2);
				h1.put(var1, L3);
				break;
				case '-':L1 = (linkedlist) h1.get(var3);
				L2 = (linkedlist) h1.get(var5);
				L3 = L3.Subtract(L1, L2);
				h1.put(var1, L3);
				break;
				case '*':L1 = (linkedlist) h1.get(var3);
				L2 = (linkedlist) h1.get(var5);
				L3 = L3.multiply(L1, L2);
				h1.put(var1, L3);
				break;
				case '^':L1 = (linkedlist) h1.get(var3);
				L2 = (linkedlist) h1.get(var5);
				L3 = L3.Power(L1, L2);
				h1.put(var1, L3);
				break;


				}
			}
			else
			{
				System.out.println("input format error");
			}

		}


	}

}
class linkedlist
{
	public node head;
	private int listcount;

	public linkedlist()
	{
		head = new node(null);
		setListcount(0);
	}
	public void insert(Object data)
	{
		node temp = new node(data);
		node current = head;

		while(current.getNext()!= null)
		{
			current = current.getNext();
		}
		current.setNext(temp);
		setListcount(getListcount() + 1);
	}
	public void insert_exp(Object data,int line_num)
	{
		node temp = new node(data,line_num);
		node current = head;

		while(current.getNext()!= null)
		{
			current = current.getNext();
		}
		current.setNext(temp);
		setListcount(getListcount() + 1);
	}
	public linkedlist StrToNum(String number)
	{
		for(int i=1;i<=number.length();i++)
		{
			this.insert(number.charAt(number.length()-i));
		}
		return this;
	}

	public String NumToStr(linkedlist number)
	{
		String s="";
		node temp = number.head.getNext();
		for(int i=0;i<=number.getListcount()&&temp.getNext()!=null;i++)
		{
			s += temp.getData().toString();
			temp = temp.getNext();
		}
		s += temp.getData().toString();
		s = new StringBuilder(s).reverse().toString();
		s = s.replaceFirst("^0+(?!$)", "");

		return s;
	}
	public  linkedlist add(linkedlist a,linkedlist b)
	{
		linkedlist temp = new linkedlist();
		node temp1 = a.head.getNext();
		node temp2 = b.head.getNext();
		int carry=0;
		int temp_add=0;
		while(temp1.getNext()!=null && temp2.getNext()!=null)
		{
			temp_add = Integer.parseInt(temp1.getData().toString()) + Integer.parseInt(temp2.getData().toString()) +carry;
			if(temp_add >= 10)
			{
				carry = temp_add/10;
				temp_add = temp_add%10;
			}
			else
			{
				carry =0;
			}

			temp.insert(temp_add);
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		{
			temp_add = Integer.parseInt(temp1.getData().toString()) + Integer.parseInt(temp2.getData().toString()) +carry;
			if(temp_add >= 10)
			{
				carry = temp_add/10;
				temp_add = temp_add%10;
			}
			else
			{
				carry =0;
			}

			temp.insert(temp_add);

		}
		if(temp1.getNext()!=null)
		{
			temp1 = temp1.getNext();
			while(temp1.getNext()!=null)
			{
				temp_add = 	Integer.parseInt(temp1.getData().toString()) + carry;

				if(temp_add >= 10)
				{
					carry = temp_add/10;
					temp_add = temp_add%10;
				}
				else
				{
					carry =0;
				}

				temp.insert(temp_add);
				temp1 = temp1.getNext();
			}
			temp_add = 	Integer.parseInt(temp1.getData().toString()) + carry;

			if(temp_add >= 10)
			{
				carry = temp_add/10;
				temp_add = temp_add%10;
			}
			else
			{
				carry =0;
			}

			temp.insert(temp_add);
		}
		if(temp2.getNext()!=null)
		{
			temp2 = temp2.getNext();
			while(temp2.getNext()!=null)
			{
				temp_add = Integer.parseInt(temp2.getData().toString()) + carry;

				if(temp_add >= 10)
				{
					carry = temp_add/10;
					temp_add = temp_add%10;
				}
				else
				{
					carry =0;
				}

				temp.insert(temp_add);
				temp2 = temp2.getNext();
			}
			temp_add = Integer.parseInt(temp2.getData().toString()) + carry;

			if(temp_add >= 10)
			{
				carry = temp_add/10;
				temp_add = temp_add%10;
			}
			else
			{
				carry =0;
			}

			temp.insert(temp_add);
		}
		if(carry !=0)
		{
			temp.insert(carry);
		}
		return temp;
	}
	public linkedlist Subtract(linkedlist n1,linkedlist n2)
	{
		linkedlist temp = new linkedlist();
		node temp1 = n1.head.getNext();
		node temp2 = n2.head.getNext();

		int temp_sub=0;
		boolean negative = false;
		if(n1.listcount == n2.listcount)
		{
			while(temp1.getNext()!=null && temp2.getNext()!=null)
			{
				temp_sub = Integer.parseInt(temp1.getData().toString()) - Integer.parseInt(temp2.getData().toString());
				if(temp_sub < 0)
				{
					negative = true;
				}
				else if(temp_sub==0 && negative==true)
				{
					negative = true;
				}
				else
				{
					negative =false;
				}

				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}
			{
				temp_sub = Integer.parseInt(temp1.getData().toString()) - Integer.parseInt(temp2.getData().toString());
				if(temp_sub < 0)
				{
					negative = true;
				}
				else if(temp_sub==0 && negative==true)
				{
					negative = true;
				}
				else
				{
					negative =false;
				}

			}
			if(negative)
			{
				int b = 0;
				int number1,number2;
				 temp2 = n1.head.getNext();
				 temp1 = n2.head.getNext();
				while(temp2.getNext()!=null)
				{

					number1 = Integer.parseInt(temp1.getData().toString()) - b;
					number2 = Integer.parseInt(temp2.getData().toString());
					if(number1 < number2)
					{
						b=1;
						number1 = number1 +10;
						temp_sub = number1 - number2;
					}
					else
					{
						b=0;
						temp_sub = number1 - number2;
					}
					temp1 = temp1.getNext();
					temp2= temp2.getNext();
					
					temp.insert(temp_sub);
				}
				number1 = Integer.parseInt(temp1.getData().toString()) - b;
				number2 = Integer.parseInt(temp2.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}

				temp.insert(temp_sub);
			}
			else
			{
				int b = 0;
				int number1,number2;
				 temp1 = n1.head.getNext();
				 temp2 = n2.head.getNext();
				
				while(temp2.getNext()!=null)
				{

					number1 = Integer.parseInt(temp1.getData().toString()) - b;
					number2 = Integer.parseInt(temp2.getData().toString());
					if(number1 < number2)
					{
						b=1;
						number1 = number1 +10;
						temp_sub = number1 - number2;
					}
					else
					{
						b=0;
						temp_sub = number1 - number2;
					}
					temp1 = temp1.getNext();
					temp2= temp2.getNext();
					
					temp.insert(temp_sub);
				}
					
				number1 = Integer.parseInt(temp1.getData().toString()) - b;
				number2 = Integer.parseInt(temp2.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}

				temp.insert(temp_sub);
			}
		}
		if(n1.listcount > n2.listcount )
		{
			negative = false;
			int number1,number2;
			int b=0;
			while(temp2.getNext()!=null)
			{

				number1 = Integer.parseInt(temp1.getData().toString()) - b;
				number2 = Integer.parseInt(temp2.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}
				temp1 = temp1.getNext();
				temp2= temp2.getNext();
				
				temp.insert(temp_sub);
			}
			{
				number1 = Integer.parseInt(temp1.getData().toString()) - b;
				number2 = Integer.parseInt(temp2.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}

				temp.insert(temp_sub);
			}
			temp1= temp1.getNext();
			
			while(temp1.getNext()!=null)
			{
				number1 = Integer.parseInt(temp1.getData().toString()) - b;
				if(number1 < 0)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - 0;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - 0;
				}
				temp.insert(temp_sub);
				temp1= temp1.getNext();
			}
			temp.insert(Integer.parseInt(temp1.getData().toString()) - b);
		}
		if(n2.listcount > n1.listcount)
		{
			negative = true;
			int number1,number2;
			int b = 0;
			while(temp1.getNext()!=null)
			{

				number1 = Integer.parseInt(temp2.getData().toString()) - b;
				number2 = Integer.parseInt(temp1.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}
				temp1 = temp1.getNext();
				temp2= temp2.getNext();
				
				temp.insert(temp_sub);
			}
			{
				number1 = Integer.parseInt(temp2.getData().toString()) - b;
				number2 = Integer.parseInt(temp1.getData().toString());
				if(number1 < number2)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - number2;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - number2;
				}

				temp.insert(temp_sub);
			}
			temp2= temp2.getNext();
			
			while(temp2.getNext()!=null)
			{
				number1 = Integer.parseInt(temp2.getData().toString()) -b;
				if(number1 < 0)
				{
					b=1;
					number1 = number1 +10;
					temp_sub = number1 - 0;
					
				}
				else
				{
					b=0;
					temp_sub = number1 - 0;
				}
				temp.insert(temp_sub);
				temp2= temp2.getNext();
			}
			temp.insert(Integer.parseInt(temp2.getData().toString()) - b);
		}
		if(negative)
		{
			temp.insert("-");
		}
		return temp;
	}
	public linkedlist multiply(linkedlist l1,linkedlist l2)
	{
		linkedlist temp = new linkedlist();
		linkedlist temp_sec = new linkedlist();
		node temp1 = l1.head.getNext();
		node temp2 = l2.head.getNext();
		int temp_mul = 0;
		int carry =0;
		for(int i=1;i<=l1.listcount;i++)
		{
			temp2 = l2.head.getNext();
			if(i>1)
			{
				temp_sec.head.setNext(null);
				carry =0;

			}
			for(int k=1;k<i;k++)
			{
				temp_sec.insert(0);
			}
			for(int j=1;j<=l2.listcount;j++)
			{
				temp_mul = (Integer.parseInt((temp1.getData().toString())) * Integer.parseInt((temp2.getData().toString()))) + carry;
				if(temp_mul >= 10)
				{
					carry = temp_mul/10;
					temp_mul = temp_mul%10;
				}
				else
				{
					carry = 0;

				}
				if(i>1)
				{
					temp_sec.insert(temp_mul);
				}
				else
				{
					temp.insert(temp_mul);
				}
				temp2 = temp2.getNext();
			}
			if(carry!=0 && i>1)
			{
				temp_sec.insert(carry);
			}
			if(carry!=0 && i==1)
			{
				temp.insert(carry);
			}
			if(i>1)
			{
				temp = temp.add(temp, temp_sec);
			}

			temp1 = temp1.getNext();

		}

		return temp;

	}
	public linkedlist Power(linkedlist l1,linkedlist l2)
	{
		linkedlist temp = new linkedlist();
		node temp2 = l2.head.getNext();
		temp.head.setNext(l1.head.getNext());
		temp.setListcount(l1.getListcount());
		boolean first = true;
		int k=1;
		for(int i=1;i<=l2.getListcount();i++)
		{
			if(i>1)
			{
				k=k*10;
			}
			for(int j=1;j<=(Integer.parseInt(temp2.getData().toString())*k);j++)
			{
				if(!first)
				{
					temp = temp.multiply(l1, temp);
				}
				if(first)
				{
					first = false;
				}

			}
			temp2 = temp2.getNext();
		}
		return temp;
	}
	public boolean IsZero()
	{
		boolean ret = true;
		node temp = this.head.getNext();
		while(temp.getNext()!=null)
		{
			if(Integer.parseInt(temp.getData().toString())!=0)
			{
				ret = false;
			}
			temp = temp.getNext();
		}
		if(Integer.parseInt(temp.getData().toString())!=0)
		{
			ret = false;
		}
		return ret;
	}
	public int getListcount() {
		return listcount;
	}
	public void setListcount(int listcount) {
		this.listcount = listcount;
	}

}
class node{
	private Object data;
	private int linenumber;
	private node next;

	public node()
	{
		this.data = null;
		this.setNext(null);
	}
	public node(Object data)
	{
		this.data = data;
		this.next= null;
	}
	public node(Object data,int line_num)
	{
		this.data = data;
		this.linenumber=line_num;
		this.next= null;
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public node getNext() {
		return next;
	}

	public void setNext(node next) {
		this.next = next;
	}
	public int getLinenumber() {
		return linenumber;
	}
	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}
}