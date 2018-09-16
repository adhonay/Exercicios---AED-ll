import java.io.*;
import java.io.File;
import java.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.*;
import java.time.LocalDateTime;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;


class MyIO {
 
   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
 
   public static void print(){
   }
 
   public static void print(int x){
      System.out.print(x);
   }
 
   public static void print(double x){
      System.out.print(x);
   }
 
   public static void print(String x){
      System.out.print(x);
   }
 
   public static void print(boolean x){
      System.out.print(x);
   }
 
   public static void println(){
   }
 
   public static void println(int x){
      System.out.println(x);
   }
 
   public static void println(double x){
      System.out.println(x);
   }
 
   public static void println(String x){
      System.out.println(x);
   }
 
   public static void println(boolean x){
      System.out.println(x);
   }
 
   public static void printf(String formato, double x){
      System.out.printf(formato, x);// "%.2f"
   }
 
   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }
      catch(Exception e){}
      return d;
   }
 
   public static double readDouble(String str){
      System.out.print(str);
      return readDouble();
   }
 
   public static float readFloat(){
      return (float) readDouble();
   }
 
   public static float readFloat(String str){
      return (float) readDouble(str);
   }
 
   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }
      catch(Exception e){}
      return i;
   }
 
   public static int readInt(String str){
      System.out.print(str);
      return readInt();
   }
 
   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }
      catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }
 
   public static String readString(String str){
      System.out.print(str);
      return readString();
   }
 
   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }
      catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }
 
   public static String readLine(String str){
      System.out.print(str);
      return readLine();
   }
 
   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }
      catch(Exception e){}
      return resp;
   }
 
   public static char readChar(String str){
      System.out.print(str);
      return readChar();
   }
 
   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";
   
      try{
         str = readString();
      }
      catch(Exception e){}
   
      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
         str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
      }
   
      return resp;
   }
 
   public static boolean readBoolean(String str){
      System.out.print(str);
      return readBoolean();
   }
 
   public static void pause(){
      try{
         in.read();
      }
      catch(Exception e){}
   }
 
   public static void pause(String str){
      System.out.print(str);
      pause();
   }
}
//========================================================================================================
class Arq{

   private static boolean write = false;
   private static boolean read = false;
   private static Formatter saida = null;
   private static Scanner entrada = null;

   public static boolean openWrite(String nomeArq) {
      boolean resp = false;
   
      close();
   
      try{
         saida = new Formatter(nomeArq);
         resp = write = true;
      }  
      catch (Exception e) {}
   
      return resp;
   }

   public static boolean openWrite(String nomeArq, String charset) {
      boolean resp = false;
   
      close();
   
      try{
         saida = new Formatter(nomeArq, charset);
         resp = write = true;
      }  
      catch (Exception e) {}
   
      return resp;
   }

   public static boolean openRead(String nomeArq) {
      boolean resp = false;
   
      close();
   
      try{
         entrada = new Scanner(new File(nomeArq));
         resp = read = true;
      }  
      catch (Exception e) {}
   
      return resp;
   }

   public static boolean openRead(String nomeArq, String charset) {
      boolean resp = false;
   
      close();
   
      try{
         entrada = new Scanner(new File(nomeArq), charset);
         resp = read = true;
      }  
      catch (Exception e) {}
   
      return resp;
   }

   public static void close() {
      if(write == true){
         saida.close();
         write = false;
      }
      if(read == true){
         entrada.close();
         read = false;
      }
   }

   public static void print(int x){
      if(write == true){
         saida.format( "%d", x);
      }
   }

   public static void print(double x){
      if(write == true){
         saida.format( "%f", x);
      }
   }

   public static void print(String x){
      if(write == true){
         saida.format( "%s", x);
      }
   }

   public static void print(boolean x){
      if(write == true){
         saida.format( "%s", ((x) ? "true" : "false"));
      }
   }

   public static void print(char x){
      if(write == true){
         saida.format( "%c", x);
      }
   }

   public static void println(int x){
      if(write == true){
         saida.format( "%d\n", x);
      }
   }

   public static void println(double x){
      if(write == true){
         saida.format( "%f\n", x);
      }
   }

   public static void println(String x){
      if(write == true){
         saida.format( "%s\n", x);
      }
   }

   public static void println(boolean x){
      if(write == true){
         saida.format( "%s\n", ((x) ? "true" : "false"));
      }
   }

   public static void println(char x){
      if(write == true){
         saida.format( "%c\n", x);
      }
   }

   public static int readInt(){
      int resp = -1;
      try{
         resp = entrada.nextInt();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp = (char)entrada.nextByte();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static double readDouble(){
      double resp = -1;
      try{
         resp = entrada.nextDouble();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static String readString(){
      String resp = "";
      try{
         resp = entrada.next();
      }  
      catch (Exception e) { System.out.println(e.getMessage()); }
      return resp;
   }

   public static boolean readBoolean(){
      boolean resp = false;
      try{
         resp = (entrada.next().equals("true")) ? true : false;
      }  
      catch (Exception e) {}
      return resp;
   }

   public static String readLine(){
      String resp = "";
      try{
         resp = entrada.nextLine();
      }  
      catch (Exception e) { System.out.println(e.getMessage()); }
      return resp;
   }


   public static boolean hasNext(){
      return entrada.hasNext();
   }

   public static String readAll(){
      String resp = "";
      while(hasNext()){
         resp += (readLine() + "\n");
      }
      return resp;
   }
}
// ========================================================================================================
class Partida {
   private Date data;
   private String mandante;
   private String visitante;
   private int golMandante;
   private int golVisitante;
   private double probMandante;
   private double probVisitante;
   private double probEmpate;

   public Partida (){
      data = new Date();
      mandante = visitante = "";
      golMandante = golVisitante = 0;
      probMandante = probEmpate = probVisitante = 0.0;
   }

   public Date getData(){
      return data;
   }

   public void setData(Date data){
      this.data = data;
   }

   public String getMandante(){
      return mandante;
   }

   public void setMandante(String mandante){
      this.mandante = mandante;
   } 

   public String getVisitante(){
      return visitante;
   }

   public void setVisitante(String visitante){
      this.visitante = visitante;
   }

   public int getGolMandante(){
      return golMandante;
   }

   public void setGolMandante(int golMandante){
      this.golMandante = golMandante;
   } 

   public int getGolVisitante(){
      return golVisitante;
   }

   public void setGolVisitante(int golVisitante){
      this.golVisitante = golVisitante;
   } 

   public double getProbMandante(){
      return probMandante;
   }

   public void setProbMandante(double probMandante){
      this.probMandante = probMandante;
   } 

   public double getProbVisitante(){
      return probVisitante;
   }

   public void setProbVisitante(double probVisitante){
      this.probVisitante = probVisitante;
   }

   public double getProbEmpate(){
      return probEmpate;
   }

   public void setProbEmpate(double probEmpate){
      this.probEmpate = probEmpate;
   }

   public void read (){
      String tmp;
   
      for(tmp = ""; tmp.equals("</tr>") == false; tmp = MyIO.readString());
      do {
         tmp = MyIO.readString(); //ler o <tr>
         if(tmp.equals("<tr>") == true){
            readPartidaUsingMyIO();
         }
      } while (tmp.equals("</table>") == false);
   
   }

   public static Partida readPartidaUsingArq (){
      Partida resp = new Partida();
      String aux;
      int i;
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
      
   
      //ler a data
      int dia = Integer.parseInt(aux.substring(0,2));
      int mes = Integer.parseInt(aux.substring(3,5));
      int ano = Integer.parseInt(aux.substring(6,10));
      Calendar calendar = Calendar.getInstance();
      calendar.set(ano, mes - 1, dia, 0, 0);
      resp.data = calendar.getTime();
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
      //ler o mandante
      for(resp.mandante = "", i = 0; aux.charAt(i) != '<'; resp.mandante += aux.charAt(i++));
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler os gols do mandante
      for(i = 0; aux.charAt(i) != 'x'; i++);
      resp.golMandante = Integer.parseInt(aux.substring(0,i).trim());
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler os gols do visitante
      for(i = 0; aux.charAt(i) != '<'; i++);
      resp.golVisitante = Integer.parseInt(aux.substring(0,i).trim());
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler o visitante
      for(resp.visitante = "", i = 0; aux.charAt(i) != '<'; resp.visitante += aux.charAt(i++));
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler a probabilidade de vitoria do mandante
      for(i = 0; aux.charAt(i) != ' '; i++);
      resp.probMandante = Double.parseDouble(aux.substring(0,i).trim());
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler a probabilidade de empate
      for(i = 0; aux.charAt(i) != ' '; i++);
      resp.probEmpate = Double.parseDouble(aux.substring(0,i).trim());
   
   
      //ler e remover os caracteres referentes ao <td> e <font>
      aux = Arq.readLine();
      for(i = 0; aux.charAt(i) != '>'; i++);//ler o <td>
      for(i++; aux.charAt(i) != '>'; i++);  //ler o <font>
      aux = aux.substring(i + 1, aux.length() - 1);
   
   
      //ler a probabilidade de vitoria do visitante
      for(i = 0; aux.charAt(i) != ' '; i++);
      resp.probVisitante = Double.parseDouble(aux.substring(0,i).trim());
   
      Arq.readLine(); //ler o </tr>
   
      return resp;
   }


   public void readPartidaUsingMyIO (){
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      String aux = MyIO.readLine();
      
      int dia = Integer.parseInt(aux.substring(0,2));
      int mes = Integer.parseInt(aux.substring(3,5));
      int ano = Integer.parseInt(aux.substring(6,10));
      Calendar calendar = Calendar.getInstance();
      calendar.set(ano, mes - 1, dia, 0, 0);
      data = calendar.getTime();
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      mandante = "";
      for(char tmp = MyIO.readChar(); tmp != '<'; mandante += tmp, tmp = MyIO.readChar()); 
      MyIO.readLine(); //ler o resto da linha
   
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      aux = "";
      for(char c = (char) MyIO.readChar(); c != 'x'; aux += c, c = (char) MyIO.readChar());
      golMandante = Integer.parseInt(aux.trim());
   
      aux = "";
      for(char c = (char) MyIO.readChar(); c != '<'; aux += c, c = (char) MyIO.readChar());
      golVisitante = Integer.parseInt(aux.trim());
      MyIO.readLine(); //ler o resto da linha
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      visitante = "";
      for(char tmp = MyIO.readChar(); tmp != '<'; visitante += tmp, tmp = MyIO.readChar()); 
      MyIO.readLine(); //ler o resto da linha
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      probMandante = MyIO.readDouble();
      MyIO.readLine(); //ler o resto da linha
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      probEmpate = MyIO.readDouble();
      MyIO.readLine(); //ler o resto da linha
   
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <td>
      for(char tmp = ' '; tmp != '>'; tmp = MyIO.readChar()); //ler o <fonte>
   
      probVisitante = MyIO.readDouble();
      MyIO.readLine(); //ler o resto da linha
   
      MyIO.readLine(); //ler o </tr>
   }

   public Partida clone (){
      Partida partida = new Partida();
      partida.data = (Date)this.data.clone();
      partida.mandante = this.mandante;
      partida.visitante = this.visitante;
      partida.golMandante = this.golMandante;
      partida.golVisitante = this.golVisitante;
      partida.probMandante = this.probMandante;
      partida.probEmpate = this.probEmpate;
      partida.probVisitante = this.probVisitante;
      return partida;
   }

   public static String toString(Date d){
      return (new SimpleDateFormat("dd/MM/yyyy")).format(d);
   }

   public void imprimir(){
      System.setProperty("file.encoding", "ISO-8859-1");
      System.out.println(toString(data) + " (" + golMandante + ") " + mandante + " x " + visitante + " (" + golVisitante + ") " + probMandante + " " + probEmpate + " " + probVisitante);
   }

public static  Partida readPartidaUsingString(String aux)
   	{
		Partida resp = new Partida();
		int i = 11;
		//ler a data
		int dia = Integer.parseInt(aux.substring(0,2));
	      	int mes = Integer.parseInt(aux.substring(3,5));
	      	int ano = Integer.parseInt(aux.substring(6,10));
	      	Calendar calendar = Calendar.getInstance();
	      	calendar.set(ano, mes - 1, dia, 0, 0);
	      	resp.data = calendar.getTime();
		
		//ler mandante
		for(;aux.charAt(i) != '-';i++)
		{
			if(aux.charAt(i) == ' ')
			{
				if(!(aux.charAt(i + 1) == '-'))
				{
					resp.mandante += aux.charAt(i);
				}
			}
			else
			{
				resp.mandante += aux.charAt(i);
			}
		}
		//ler golMandante		
		i += 2;
		resp.golMandante = Integer.parseInt(aux.substring(i,i + 1));
		//ler golVisitante
		i += 2;
		resp.golVisitante = Integer.parseInt(aux.substring(i,i + 1 ));
		//ler visitante
		i += 2;
		for(;aux.charAt(i) != '-';i++)
		{
			if(aux.charAt(i) == ' ')
			{
				if(aux.charAt(i + 1) != '-')
				{
					resp.visitante += aux.charAt(i);
				}
			}
			else
			{
				resp.visitante += aux.charAt(i);
			}
		}
		//ler probMandante
		i += 2;
		resp.probMandante = Double.parseDouble(aux.substring(i,i + 4));
		//ler probEmpate
		i += 5;
		resp.probEmpate = Double.parseDouble(aux.substring(i,i + 4));
		//ler probVisitante
		i +=  5;
		resp.probVisitante = Double.parseDouble(aux.substring(i,i + 4));
				
		
		return resp;
   	}

}//class
// ========================================================================================================
/*
* classe para comparar em relacao 
* ao mandante para saber o maior
*/
class compMandante{

public static String semAcento(String txt) {  
    String s="";  
    for (int i = 0; i < txt.length(); i++) {  
       char c=txt.charAt(i);  
       switch (c) {  
         case 'Á':  
         case 'À':  
         case 'Ã':  
           c='A';  
           break;  
         case 'É':  
         case 'Ê':  
           c='E';  
           break;  
         case 'Í':  
           c='I';  
           break;  
         case 'Ó':  
         case 'Õ':  
         case 'Ô':  
           c='O';  
           break;  
         case 'Ú':  
           c='U';  
           break;  
         case 'Ç':  
           c='C';  
             
         case 'á':  
         case 'à':  
         case 'ã':  
           c='a';  
           break;  
         case 'é':  
         case 'ê':  
           c='e';  
           break;  
         case 'í':  
           c='i';  
           break;  
         case 'ó':  
         case 'õ':  
         case 'ô':  
           c='o';  
           break;  
         case 'ú':  
           c='u';  
           break;  
         case 'ç':  
           c='c';  
           break;  
       }  
       s+=c;  
    }  
    return s;  
  } 
	public static boolean comparar( String s1 , String s2){// se s1 for maior que s2 retorne verdadeiro
		
		boolean resp = true;

		if ( semAcento(s1).compareTo(semAcento(s2)) <= 0){
	
			resp = false;
		}
	
		return resp;
	}

}
// ========================================================================================================
class compData{

	public static boolean comparar( String s1 , String s2){

 	 	boolean resp = true;
         	if(Integer.parseInt(s1.substring(6,10)) < Integer.parseInt(s2.substring(6,10))){ // ano
        
            		resp = false;
        	 }
		 else if(Integer.parseInt(s1.substring(6,10)) == Integer.parseInt(s2.substring(6,10))){ // ano igual
		
	 		if(Integer.parseInt(s1.substring(3,5)) < Integer.parseInt(s2.substring(3,5))){ //mes

		 		resp = false;

	      		}
         		else if(Integer.parseInt(s1.substring(3,5)) == Integer.parseInt(s2.substring(3,5))){  // mes igual
		
				if(Integer.parseInt(s1.substring(0,2)) <= Integer.parseInt(s2.substring(0,2))){ // dia
			 		resp = false;
	     			}
			}
		}
		return resp;
	}
}

// ========================================================================================================
class Lista {

   private Partida[] array;
   private int n;


   public Lista () {
      this(6);
   }


   public Lista (int tamanho){
      array = new Partida[tamanho];
      n = 0;
   
   }

   public void inserirInicio(Partida x) throws Exception {
   
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      } 
   
      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1].clone();
      }
   
      array[0] = x.clone();
      n++;
   }


   public void inserirFim(Partida x) throws Exception {
   
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }
   
      array[n] = x.clone();
      n++;
   }


   public void inserirMeio(Partida x, int pos) throws Exception {
   
      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }
   
      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1].clone();
      }
   
      array[pos] = x.clone();
      n++;
   }


   public String removerInicio() throws Exception {
   
      String resp;
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
   
      resp = array[0].toString(array[0].getData()) + " " + array[0].getMandante();
      n--;
   
      for(int i = 0; i < n; i++){
         array[i] = array[i+1].clone();
      }
   
      return resp;
   }


   public String removerFim() throws Exception {
   
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
   
      return array[--n].toString(array[n].getData()) + " " + array[n].getMandante();
   }


   public String removerMeio(int pos) throws Exception {
   
      String resp;
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }
   
      resp = array[pos].toString(array[pos].getData()) + " " + array[pos].getMandante();
      n--;
   
      for(int i = pos; i < n; i++){
         array[i] = array[i+1].clone();
      }
   
      return resp;
   }

   public boolean pesquisar(Partida x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }
   
   public Partida posicao( int ps) throws Exception{

	if ( n == 0 || ps >= n || ps < 0){

		throw new Exception("Erro!");
	}

	return array[ps].clone();
   }

   public void mostrar (){
      for(int i = 0; i < n; i++){
         array[i].imprimir();
      }
   }

   public void mostrar (int i){
      array[i].imprimir();
   }

   public int quantos ()throws Exception{
      return n;
   }

   public void Swap(int x, int y)throws Exception{

	  if(x < 0 || x > n || y < 0 || y > n || n == 0){

		throw new Exception("Erro no Swap");
	  }
	
       	    Partida temp = array[x].clone();
            array[x] = array[y].clone();
            array[y] = temp.clone();
   }
   public void alterarpartida(Partida i , int posicao){
	array[posicao] = i.clone();
   }
//-----------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz pesquisa sequencial
    * informando caso seja igual ele retorna
    * um valor booleano de acordo com o caso.
    */

   void questao01() throws Exception {
        
      Lista lista = new Lista(1000);
    
      boolean resp = false;
      String temp; 
   			
 	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
   	}

      Partida array;
      int tamanho = lista.quantos();

      

      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = MyIO.readLine()){
        
		if(tamanho == 0 ) {
	
			throw new Exception("Erro ao inserir!");
		}
		boolean resp1 = false;
		for( int i = 0;  i < tamanho; i++){
     			
			String comparacao = "" + lista.posicao(i).toString(lista.posicao(i).getData());
 				//System.out.println("c"+comparacao);
				//System.out.println("a"+nomeArquivo);

				if(comparacao.equals(nomeArquivo)){
				
					resp1 = true;
				}
					
		}

	
			if(resp1 == true ){
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}	
					
     }
    Arq.close();
   }
//-----------------------------------------------------------------------------------------------------------
   /**
    * Metodo  que faz uma pesquisa binaria
    * dividindo e pesquisando caso seja igual
    * um valor booleano de acordo com o caso.
    */

   boolean Binario (String palavra)throws Exception{
     
      int esquerda = 0,meio = 0, direita = n -1; 
   
      boolean retorno = false;    
          
      while(esquerda <= direita){
              
         meio = (esquerda + direita) / 2;
    
         String resp = posicao(meio).toString(posicao(meio).getData());
	    

         if(resp.equals(palavra)){
         
            retorno = true;
            esquerda = n;
         
         }
         else if(resp.substring(6,10).compareTo(palavra.substring(6,10)) < 0){
         
            esquerda = meio + 1;
	    
         }
	 else if(resp.substring(6,10).compareTo(palavra.substring(6,10)) == 0){
		
	    if(resp.substring(3,5).compareTo(palavra.substring(3,5)) < 0){
		 esquerda = meio + 1;
	      }
            else if(resp.substring(3,5).compareTo(palavra.substring(3,5)) == 0){
		
			if(resp.substring(0,2).compareTo(palavra.substring(0,2)) < 0){
			 	esquerda = meio + 1;
	     		 }
			else{
				 direita = meio-1;
	  		}
	    }

	    else{
	    direita = meio-1;
	    
	    }
	 
	}
         else{
            direita = meio-1;
         }     
      }
      return retorno;
   
   }


   void questao02() throws Exception {
     
     Lista lista = new Lista(1000);
    
      boolean resp = false;
      Date temp; 
   			
 	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         
   	}

      boolean retorno;   	
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
      	 
	if(lista.quantos() == 0 ) {
	
		throw new Exception("Erro ao inserir!");
	}

         retorno = lista.Binario(nomeArquivo);
      
        
         if(retorno==true){
         	
            System.out.println("SIM");
         } 
         
         else{ 
         
            System.out.println("NAO");
         }
      
      }
	Arq.close();
   }    
//-----------------------------------------------------------------------------------------------------------
 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se selecao passando mandante
    * como um chave e ordenando por ele.
    */
   void selecao ()throws Exception{
  
      for( int i = 0; i < (n-1); i++ ){
        	
         int menor = i;
      
         for( int j = (i + 1); j < n; j++ ){
         
	    
            int resp = array[menor].getMandante().compareTo(array[j].getMandante());
            
	   if(compMandante.comparar(array[menor].getMandante(),array[j].getMandante())){ // 
            
		menor = j;
            }
	    else if( resp == 0){
		if(compData.comparar(posicao(menor).toString(posicao(menor).getData()),posicao(j).toString(posicao(j).getData())) == true){
			  menor = j;
		}
	    }
         }
         Partida palavra  = array[i].clone();
         array[i] = array[menor].clone();
         array[menor] = palavra;	
      } 
   }
  
   void questao03()throws Exception {
   
    
    
      Lista lista = new Lista(500);
    
  		
 	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	} 	
    	
      lista.selecao();
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------

 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se selecao recursivo passando 
    * mandante como um chave e ordenando por ele.
    */
   void recursivoselecao (int low)throws Exception{
        
    
      if(low <= n){
        	
         int menor = low;
      
         for( int j = (low + 1); j < n; j++ ){
         
            int resp = array[menor].getMandante().compareTo(array[j].getMandante());
         
           if(compMandante.comparar(array[menor].getMandante(),array[j].getMandante())){ // 
            
		menor = j;
            }
	    else if( resp == 0){
		if(compData.comparar(posicao(menor).toString(posicao(menor).getData()),posicao(j).toString(posicao(j).getData())) == true){
			  menor = j;
		}
	    }
         }
      
         Partida palavra  = array[low];
         array[low] = array[menor];
         array[menor] = palavra;	
      
         recursivoselecao(low +1);
      } 
   }

  
   void questao04()throws Exception {
   
    
    
       Lista lista = new Lista(500);
    
  		
 	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  	
   
    	
      lista.recursivoselecao(0);
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------

 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se insercao passando visitante
    * como um chave e ordenando por ele.
    */


   void insercao ()throws Exception{
    
      for (int i = 1; i < n; i++) {
         
	 Partida tmp = array[i];
         int j = i - 1;
         		 
 	 String resp = array[i].getVisitante();
	 String da = posicao(i).toString(posicao(i).getData());
	  
         while ((j >= 0) && (compMandante.comparar(array[j].getVisitante(),resp)) || (j >= 0) && (resp.compareTo(array[j].getVisitante()) == 0) && (compData.comparar(posicao(j).toString(posicao(j).getData()),da))){

	    		array[j + 1] = array[j].clone();
            		j--;		
         }
	 
         array[j + 1] = tmp.clone() ;

      }
  

   }
  
   void questao05()throws Exception {
   
    
    
      Lista lista = new Lista(500);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  	 	
   
    	
      lista.insercao();
      lista.mostrar();	
   }

//----------------------------------------------------------------------------------------------------------------------------------------------

  /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do shell passando probabilidade de 
    * vitoria do mandante como um chave e ordenando por ele.
    */
  void shell() throws Exception{
      int h = 1;

      do { h = (h * 3) + 1; } while (h < n);

      do {
         h /= 3;

         for(int cor = 0; cor < h; cor++){

            insercaoPorCor(cor, h);
         }

      } while (h != 1);
   }

   /**
    * Metodo que efetua a insercao nos pseudo-arrays do Shellsort.
    * @param int cor cor do pseudo array.
    * @param int h passo do shelsort
    */
   public void insercaoPorCor(int cor, int h)throws Exception{

      for (int i = (h + cor); i < n; i+=h) {

         Partida tmp = array[i];
         int j = i - h;

	 String da = posicao(i).toString(posicao(i).getData());

         while ((j >= 0) && (array[j].getProbMandante() > (tmp.getProbMandante())) || (j >= 0) && (array[j].getProbMandante() == (tmp.getProbMandante())) && (compData.comparar(posicao(j).toString(posicao(j).getData()),da))) {

            array[j + h] = array[j];
            j-=h;
         }
         array[j + h] = tmp;
      }
   }
  
   void questao06()throws Exception {
   
	Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  
    	
      lista.shell();
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do heap passando probabilidade 
    * de empate como um chave e ordenando por ele.
    */   


   public void make(Lista lista, int tamanho)throws Exception{

      if( tamanho == 0){
		throw new Exception("Erro no make");
	}
      for( int i = 0; i < tamanho; i++){

	for( int j = tamanho - i; j > 1 ; j/=2){
		  
		if( lista.posicao((j-1)/2).getProbEmpate() <  lista.posicao(j-1).getProbEmpate()){
			lista.Swap((j-1)/2,j-1);
		}
		else if (lista.posicao((j-1)/2).getProbEmpate() ==  lista.posicao(j-1).getProbEmpate()){
			
			if(compData.comparar(lista.posicao(j-1).toString(lista.posicao(j-1).getData()),lista.posicao((j-1)/2).toString(lista.posicao((j-1)/2).getData()))){
				lista.Swap((j-1)/2,j-1);
				//System.out.println("1");
			}

			else if(lista.posicao((j-1)/2).toString(lista.posicao((j-1)/2).getData()).compareTo(lista.posicao(j-1).toString(lista.posicao(j-1).getData())) == 0){

				if(compMandante.comparar(lista.posicao(j-1).getMandante(),lista.posicao((j-1)/2).getMandante())){
					lista.Swap((j-1)/2,j-1);
					//System.out.println("2");
				}
				
				else{
					j = 0;
				}
			}

			else{
				j = 0;
			}
		}else{
			j = 0;
		}
	}
      }
    }	
		
    void heap(Lista lista)throws Exception {
  
	if(lista.quantos() == 0){

		throw new Exception("Erro lista nula");
	}

	lista.make(lista,lista.quantos());

	for( int i = 1 ; i < lista.quantos(); i++){

	    	lista.Swap(0,lista.quantos()- i);
		lista.make(lista,lista.quantos()- i);
	
	}
    }
     		

   

   void questao07()throws Exception {
   
       Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  	
   
    	
      lista.heap(lista);
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do quicksort passando probabilidade 
    * de vitoria do visitante como um chave e ordenando por ele.
    */   


     void quick()throws Exception{  
     
       quick(0,n-1);

     }
     void quick(int i, int j)throws Exception{

      int esq=i, dir=j;

      double pivo = array[(i+j)/2].getProbVisitante();

      while(esq < dir){

   

          while(array[esq].getProbVisitante()<(double)pivo){ 
		esq++;
	  }
          while(array[dir].getProbVisitante()>(double)pivo){
		 dir--;
	  }

          if(esq < dir){
          
              Partida x = new Partida();
              x = array[esq];
              array[esq] = array[dir];
              array[dir] = x;

              esq++;
              dir--;
	  }
	  if( esq == dir){
		//System.out.println("esq: "+posicao(esq).toString(posicao(esq).getData()));
		//System.out.println("dir: "+posicao(dir).toString(posicao(dir).getData()));
		if(compData.comparar(posicao(esq).toString(posicao(esq).getData()),posicao(dir).toString(posicao(dir).getData()))){ 

			 Partida x = new Partida();
              		 x = array[esq];
             		 array[esq] = array[dir];
             		 array[dir] = x;
				
           		 esq++;
             		 dir--;	
		}
		 esq++;
                dir--;			
          }
      }
      
      if(i<dir){ 
	quick(i,dir);
      }	
      if(esq<j){
	quick(esq,j);
      }
   }
   

  void questao08()throws Exception {
   
	Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  
    	
      lista.quick();
      lista.mostrar();	
 }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    *funçao para pegar o maior valor contido no array
    */
    int maior() {

      int maior = array[0].getGolMandante();

      for (int i = 0; i < n; i++) {
         if(maior < array[i].getGolMandante()){

            maior = array[i].getGolMandante();
         }
      }
      return maior;    
   }

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do countingsort passando 
    * numero de gols do mandante
    * como um chave e ordenando por ele.
    */
    void counting() {
      
      int [] v = new int[maior() + 1];

      Partida[] x = new Partida[n];
      
      for(int i=0; i < v.length; v[i]=0, i++);
     
      for(int i=0; i < n; v[array[i].getGolMandante()]++, i++);
     
      for(int i=1; i < v.length; v[i] += v[i-1], i++);
     
      for(int i=n-1; i >= 0; x[v[array[i].getGolMandante()]-1] 
                  = array[i], v[array[i].getGolMandante()]--,i--);
      
      for(int i = 0; i < n; array[i] = x[i], i++);
   }


    void questao09()throws Exception {
   
	Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  
    	
    	
      lista.counting();
      lista.mostrar();	
 }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo da bolha passando numero 
    * de gols do visitante como um chave e ordenando por ele.
    */


    void bolha()throws Exception  {

        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {

		if(compMandante.comparar(array[j].getMandante(),array[j+1].getMandante())){
		 Partida palavra  = array[j];
         	 array[j] = array[j+1];
         	 array[j+1] = palavra;
		 }

                if (array[j].getGolVisitante() > array[j + 1].getGolVisitante()) {

 	 Partida palavra  = array[j];
         array[j] = array[j+1];
         array[j+1] = palavra;	
      
                }
		else if(array[j].getGolVisitante() == array[j + 1].getGolVisitante() ){

			if(compData.comparar(posicao(j).toString(posicao(j).getData()),posicao(j+1).toString(posicao(j+1).getData()))){				

			Partida palavra  = array[j];
         		array[j] = array[j+1];
         		array[j+1] = palavra;
			}
		}
	
            }
        }
     }

   void questao10()throws Exception {
   
	 Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  
    	
      lista.bolha();
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * da chave numero de gols na partida e ordenando por ele.
    * @ chave - soma dos gols mandante e visitante.
    */

	 void merge(Lista lista,int inicio, int fim) throws Exception
   	{
      		if(lista.quantos() == 0)
      		{
        		throw new Exception("Erro ao ordenar por MergeSort!");
      		}
	      	if(fim <= inicio)
	      	{
	        	 return;
	      	}
	      	int meio = (fim + inicio)/2;

	      	merge(lista,inicio,meio);
	      	merge(lista,meio + 1,fim);

	      	Lista A = new Lista( meio - inicio + 1);
	      	Lista B = new Lista( fim - meio);

	      	for(int i = 0; i <= meio - inicio; i++)
	      	{
	        	
			//lista.partida(i).imprimir();

			A.inserirFim(lista.posicao(i + inicio));
	      	}
	      	for(int j = 0; j <= fim - meio - 1;j++)
	      	{
		
			//lista.partida(j).imprimir();

	        	B.inserirFim(lista.posicao(meio + 1 + j));
	      	}
	      	int i = 0;
	      	int j = 0;
	      	for(int k = inicio;k <= fim;k++)
	      	{
	        	if(i < A.quantos() && j < B.quantos())
	         	{
				
	            		if((A.posicao(i).getGolMandante() + A.posicao(i).getGolVisitante()) < (B.posicao(j).getGolMandante() + B.posicao(j).getGolVisitante()))
	            		{
				
	               			lista.alterarpartida(A.posicao(i),k);
					i++;
	            		}
	            		else if((A.posicao(i).getGolMandante() + A.posicao(i).getGolVisitante()) == (B.posicao(j).getGolMandante() + B.posicao(j).getGolVisitante()))
	            		{
	               			if(compData.comparar(B.posicao(j).toString(B.posicao(j).getData()),A.posicao(i).toString(A.posicao(i).getData())))
	               			{
						
	                  			lista.alterarpartida(A.posicao(i),k);
						i++;
	               			}
	               			else if(B.posicao(j).toString(B.posicao(j).getData()).compareTo(A.posicao(i).toString(A.posicao(i).getData())) == 0)
	               			{
	                  			if(compMandante.comparar(B.posicao(j).getMandante(),A.posicao(i).getMandante()))
	                  			{
							
	                     				lista.alterarpartida(A.posicao(i),k);
							i++;
	                  			}
	                  			else
	                  			{	
							
	                     				lista.alterarpartida(B.posicao(j),k);
							j++;
	                  			}
	               			}
	               			else
	               			{
						
	                  			lista.alterarpartida(B.posicao(j),k);
						j++;
	               			}
	            		}               
	            		else
	            		{
					
	            			lista.alterarpartida(B.posicao(j),k);
					j++;
	            		}
	         	}
	         	else if(i < A.quantos())
	         	{
				
	            		lista.alterarpartida(A.posicao(i),k);
				i++;
	         	}
	         	else if(j < B.quantos())
	         	{
				
	            		lista.alterarpartida(B.posicao(j),k);
				j++;
	        
		 	}
		//lista.mostrar();
	      	}
	}

  void questao11()throws Exception {
   
	Lista lista = new Lista(500);
    
     	 for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 			MyIO.readLine()){

         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               lista.inserirFim(Partida.readPartidaUsingArq());	       
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
   	}  
    	
      lista.merge(lista,0,lista.quantos()-1);
      lista.mostrar();	
   }

}

// ========================================================================================================

public class TP4{


   public static void main (String args[]) throws Exception {
 
	Partida partida = new Partida();
	Lista lista = new Lista(500);

	//lista.questao01();
	//lista.questao02();
	//lista.questao03();
	//lista.questao04();
	//lista.questao05(); 
	//lista.questao06(); 
	//lista.questao07();
	//lista.questao08(); 
	//lista.questao09(); 
	//lista.questao10(); 
	lista.questao11(); 
   }
}


