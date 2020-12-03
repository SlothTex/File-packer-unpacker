//package template;
//Final Template
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Container;  
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.*;
class File_pack_unpack
{
	public static void main(String arg[])
	{
		Front obj = new Front();
	}
}

class Front
{
	public Front()
	{
		JFrame f=new JFrame();
		JPanel panel= new JPanel();
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		GroupLayout gl = new GroupLayout(b); 
		JButton b1 = new JButton("Pack Files");
		JTextField tf2 = new JTextField(1);
		JTextField tf1 = new JTextField(1);
	//public FinalTemplate()
//{ 
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		a.setLayout(new GridLayout(2,1));  
		gl.setAutoCreateGaps(true);  
		gl.setAutoCreateContainerGaps(true);  
		b.setLayout(gl);
		a.setBackground( Color.WHITE );
		b.setBackground( Color.BLUE  );
		c.setBackground( Color.BLUE ); 
		panel.add(a);
		panel.add(b);
		panel.add(c);
		f.add(panel);
		f.setSize(500,500);
		f.setVisible(true);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//}

	//public void setpanelA()
	//{
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		int second=cal.get(Calendar.SECOND);
		int minute=cal.get(Calendar.MINUTE);
		int hour=cal.get(Calendar.HOUR);
		JLabel l1=new JLabel("hello",JLabel.CENTER);
		JLabel l3=new JLabel("WELCOME TO FILE PACKER-UPACKER PROJECT",JLabel.CENTER);
		l3.setFont(new Font("New Times Roman", Font.PLAIN, 25));
		l1.setText("Date:-"+day+"/"+month+"/"+year+"    "+"Time:-"+hour+":"+minute+":"+second);
		l1.setFont(new Font("New Times Roman", Font.PLAIN, 28));
		a.add(l3);
		a.add(l1);
	//}
	//public void setpanelB()
	//{	
		JLabel l4=new JLabel("hello",JLabel.CENTER);
		l4.setFont(new Font("New Times Roman", Font.BOLD, 25));
		l4.setForeground(Color.black);
		l4.setText("Enter Directory name -");
		JLabel l5=new JLabel("hello",JLabel.CENTER);
		l5.setFont(new Font("New Times Roman", Font.BOLD, 25));
		l5.setForeground(Color.black);
		l5.setText("Enter file name -");
		gl.setHorizontalGroup(gl.createParallelGroup(CENTER)  
                .addGroup(gl.createSequentialGroup().addComponent(l4).addComponent(tf1))  
                .addGroup(gl.createSequentialGroup().addComponent(l5).addComponent(tf2)));
        gl.setVerticalGroup(gl.createSequentialGroup()  
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(l4).addComponent(tf1))  
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(l5).addComponent(tf2)));		
		b.add(l4);
		b.add(tf1);
		b.add(l5);
		b.add(tf2);
	//}
	//public void setpanelC()
	//{
		b1.setSize(100,50);
		c.add(b1);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent eobj)
			{
				Packer pobj = new Packer(tf1.getText(), tf2.getText());
				f.setVisible(false);
				JOptionPane.showMessageDialog(null, "Packed files successfully are ");
				FrontunP o = new FrontunP();
			}
		});
	
	}
}

class Packer
{
	// Object for file writing
	public FileOutputStream outstream = null;

	// parametrised constructor
	public Packer(String FolderName, String FileName)
	{
		try
		{
			// Create new file for packing
			File outfile = new File(FileName);
			outstream = new FileOutputStream(FileName);

			// Set the current working directory for folder traversal
			// System.setProperty("user.dir",FolderName);
			
			TravelDirectory(FolderName);
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}

	public void TravelDirectory(String path)
	{
		File directoryPath = new File(path);
		int counter = 0;
		// Get all file names from directory
		File arr[] = directoryPath.listFiles();

		System.out.println("-------------------------------");
		for(File filename : arr)
		{
			//System.out.println(filename.getAbsolutePath());
			
			if(filename.getName().endsWith(".txt"))
			{
				counter++;
				System.out.println("Packed file : "+filename.getName());
				PackFile(filename.getAbsolutePath());	
			}		
		}
		
		//System.out.println("Succesfully packed files : "+counter);
		
	}

	public void PackFile(String FilePath)
	{
//		System.out.println("File name received "+ FilePath);
		byte Header[] = new byte[100];
		byte Buffer[] = new byte[1024];
		int length = 0;

		FileInputStream istream = null;

		File fobj = new File(FilePath);

		String temp = FilePath+" "+fobj.length();
		
			// Create header of 100 bytes
		for(int i = temp.length(); i< 100; i++)
		{
			temp = temp + " ";
		}	

		Header = temp.getBytes();
		try
		{
			// open the file for reading
			istream = new FileInputStream(FilePath);

			outstream.write(Header,0,Header.length);
			int cnt=0;
			while((length = istream.read(Buffer)) > 0)
			{
				byte brr=10;
					
					for(int i=0;i<Buffer.length;i++)
					{   
						byte key=0;
						key =(byte)(Buffer[i]^brr);
						
						Buffer[i]=key;
					}
				outstream.write(Buffer,0,length);
				cnt++;
			}
				istream.close();
		}
		catch(Exception obj)
		{}
	}
}
//-----------------------------------------------------------------------------------------------------------------
//unpack file template and code

class FrontunP
{
	public FrontunP()
	{
		JFrame fobj=new JFrame();
		JPanel mpanel= new JPanel();
		JPanel aobj = new JPanel();
		JPanel bobj = new JPanel();
		JPanel cobj = new JPanel();
		GroupLayout globj = new GroupLayout(bobj); 
		JButton b1obj = new JButton("UnPack Files");
		JTextField tf1obj = new JTextField(1);
	//public FinalTemplate()
//{ 
		mpanel.setLayout(new BoxLayout(mpanel, BoxLayout.Y_AXIS));
		aobj.setLayout(new GridLayout(2,1));  
		globj.setAutoCreateGaps(true);  
		globj.setAutoCreateContainerGaps(true);  
		bobj.setLayout(globj);
		aobj.setBackground( Color.WHITE );
		bobj.setBackground( Color.BLUE  );
		cobj.setBackground( Color.BLUE ); 
		mpanel.add(aobj);
		mpanel.add(bobj);
		mpanel.add(cobj);
		fobj.add(mpanel);
		fobj.setSize(500,500);
		fobj.setVisible(true);  
		fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//}

	//public void setpanelA()
	//{
		Calendar calobj=new GregorianCalendar();
		int day=calobj.get(Calendar.DAY_OF_MONTH);
		int month=calobj.get(Calendar.MONTH);
		int year=calobj.get(Calendar.YEAR);
		int second=calobj.get(Calendar.SECOND);
		int minute=calobj.get(Calendar.MINUTE);
		int hour=calobj.get(Calendar.HOUR);
		JLabel l1obj=new JLabel("hello",JLabel.CENTER);
		JLabel l3obj=new JLabel("WELCOME TO FILE PACKER-UPACKER PROJECT",JLabel.CENTER);
		l3obj.setFont(new Font("New Times Roman", Font.PLAIN, 25));
		l1obj.setText("Date:-"+day+"/"+month+"/"+year+"    "+"Time:-"+hour+":"+minute+":"+second);
		l1obj.setFont(new Font("New Times Roman", Font.PLAIN, 28));
		aobj.add(l3obj);
		aobj.add(l1obj);
	//}
	//public void setpanelB()
	//{	
		JLabel l4obj=new JLabel("hello",JLabel.CENTER);
		l4obj.setFont(new Font("New Times Roman", Font.BOLD, 25));
		l4obj.setForeground(Color.black);
		l4obj.setText("Enter File name -");
		globj.setHorizontalGroup(globj.createParallelGroup(CENTER)  
                .addGroup(globj.createSequentialGroup().addComponent(l4obj).addComponent(tf1obj)));  
        globj.setVerticalGroup(globj.createSequentialGroup()  
                .addGroup(globj.createParallelGroup(BASELINE).addComponent(l4obj).addComponent(tf1obj)));  
		bobj.add(l4obj);
		bobj.add(tf1obj);
	//}
	//public void setpanelC()
	//{
		b1obj.setSize(100,50);
		cobj.add(b1obj);
		
		b1obj.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent eobj)
			{
				Unpacking uobj = new Unpacking(tf1obj.getText());
				fobj.setVisible(false);
				JOptionPane.showMessageDialog(null, "Files Unpacked successfully are ");
				//NewWindow o = new NewWindow();
			}
		});
	
	}
}
//------------------------------------------------------------------------------------------------------
class Unpacking
{
		public FileOutputStream outstream=null;
		
		public Unpacking(String src)
		{
			
			unpackfile(src);
		}

		public void unpackfile(String filepath)
		{
			try
			{
				System.out.println("hello");
				FileInputStream istream=new FileInputStream(filepath);
				byte Header[]=new byte[100];
				int length=0;
				int counter=0;
				while((length=istream.read(Header,0,100))>0)
				{
					System.out.println("length"+length);
					String str=new String(Header);
					System.out.println("str: "+str+"\n");
					String ext=str.substring(str.lastIndexOf("\\"));
					System.out.println("ext :"+ext+"\n");
					System.out.println("hello file\n");
					ext=ext.substring(1);
					System.out.println("ext"+ext+"\n");
					String words[]=ext.split("\\s");
					
					String name=words[0];
					
					int size=Integer.parseInt(words[1]);
					
					byte arr[]=new byte[size];
					
					istream.read(arr,0,size);
					
					System.out.printf("New file successfully created"+name);
					
					FileOutputStream fout=new FileOutputStream(name);
					byte brr=10;
					for(int i=0;i<size;i++)
					{
						byte key=0;
						
						key=(byte)(arr[i]^brr);
						arr[i]=key;
					}
					fout.write(arr,0,size);
					counter++;
					
				}
				
				System.out.println("FIle successfully got unpacked"+counter);
			}
			catch(Exception obj)
			{}
		}	
}

