// 파일을 읽고 쓰기 기능을 이용하여 일반문서를 읽고 암호화 하여 
// 저장하고 암호화된 문서를 읽고 일반 문서로 변환하는 프로그램 작성하기

import java.io.*;
import java.util.*;


public class Test
{   
	public static void main(String[] args) throws IOException
	{
		System.out.println("1번과 2번중 하나를 눌러주세요 1번:파일을 읽고 암호화 합니다. " + " 2번:암호화 문서읽고 일반으로 변화합니다." );
		System.out.print(":");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();	// 번호 입력할수있다.
   
		FileReader fr = null;
		FileWriter fw = null;
		int secret = 3;	// 암호화&복호화 해주려는 값
    
		try
		{    
			if(input == 1)	// 1번 입력
			{   
				System.out.println("일반문서중 불러오고자 하는 문서명을 입력해주세요.ex)test.txt  ");
				System.out.print(":");
				String fileName = new Scanner(System.in).nextLine();	// 불러오고자 하는파일명 입력  
				fr=new FileReader(fileName);						// 불러온 파일에서 내용읽어온다.
 
  
				System.out.println("암호화된 파일을 저장할  .txt 명을 입력해주세요. ex)sos.txt");
				System.out.print(":");
				String encryptionFileName = new Scanner(System.in).nextLine();	// 불러오고자 하는파일명 입력
				fw=new FileWriter(encryptionFileName);	// 암호화될 파일을 만든다.

				int data = 0;
  
				while( (data=fr.read()) != -1 )
				{ 
					data += secret;   // 암호화
					char ch = (char)data;   
					System.out.print(ch);         // 암호화 출력     
					fw.write(data);  // 암호화된 데이터를 저장한다.         
				} //while
			} //if 
			else if(input == 2)
			{
				System.out.println("암호화 문서만 불러오세요 .ex)sos.txt  ");
				System.out.print(":");
				String fileName = new Scanner(System.in).nextLine();	// 불러오고자 하는파일명 입력  
				fr = new FileReader(fileName);	// 복호화 문서 파일 내용을 읽어온다.
 
				System.out.println("복호화될 파일을 저장할  .txt 명을 입력해주세요. ex)sos.txt");
				System.out.print(":");
				String encryptionFileName = new Scanner(System.in).nextLine();  // 불러오고자 하는파일명 입력
				fw = new FileWriter(encryptionFileName);	// 복호화될 파일을 만든다.
  
				int data = 0;
				while((data = fr.read())!=-1)
				{
					data -= secret;	// 복호화
					char ch = (char)data;
					System.out.print(ch);	//복호화 출력
					fw.write(data);	// 복호화된 데이터를 저장한다.
				} // while
			}	// else if
		} //try{}
		catch(FileNotFoundException abc)		{			System.out.println("파일을 찾을수 없습니다.");		}
		catch(IOException ee){	System.out.println("파일 읽을수 없다.");	}
		finally
		{
			try
			{ 
				fr.close();
				fw.close();	// 저장값을 반환해준다.
			}
			catch(Exception ee){} 
		} // finally
	} //main() 
}