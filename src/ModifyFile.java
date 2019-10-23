import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ModifyFile {

	public static void main(String[] args) {

		//String content = "input maxlength=320 class=\"form-control auth-input\" name=\"email\" placeholder=\"Email address\" type=\"text\">";
		String findString = "name=";
				
		File file1 = new File("C:\\Eclipse Workspace\\read.txt");
		File file2 = new File("C:\\Eclipse Workspace\\write.txt");
		String words[] = null;
		try{
			FileReader fileReader = new FileReader(file1);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String s;
			while((s=bufferedReader.readLine())!=null){
				words=s.split(" ");
				for(String word: words){
					if(word.contains(findString)){
						//System.out.println("Match Found!");
						FileWriter fileWriter = new FileWriter(file2, true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 	
							//PrintWriter pw = new PrintWriter(bufferedWriter);
						int indexNo = s.indexOf(findString);
//						StringTokenizer st = new StringTokenizer(s, "=");
//						while(st.hasMoreTokens()){
//							System.out.println(st.nextToken());
//						}
						
						String croppedString = s.substring(indexNo, s.length()-1);
						String temp = croppedString.substring(0, croppedString.indexOf(" ")+1);
						if(temp.contains("=")){
							String arr[] = temp.split("=");
							String newString = "id="+arr[1]+temp;
							String finalContent = s.replace(temp, newString);
							bufferedWriter.write(finalContent);
						}
						}
					}
				}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
