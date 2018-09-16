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
//--------------------------------------------------------------------------------- 

class Celula {
    public Partida elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.
 
    /**
     * Construtor da classe.
     * @param elemento Elemento inserido na celula.
     */
    Celula(Partida elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
 
    /**
     * Construtor da classe.
     * @param elemento Elemento inserido na celula.
     * @param prox Aponta a celula prox.
     */
    Celula(Partida elemento, Celula prox) {
        this.elemento = elemento;
        this.prox = prox;
    }
}
//--------------------------------------------------------------------------------- 

/**
 * Lista dinamica simplesmente encadeada
 */
class Lista {
    public Celula primeiro; 
    public Celula ultimo; 
 
    /**
     * Construtor da classe: Instancia uma celula (primeira e ultima).
     */
    public Lista() {
        primeiro = new Celula(null);
        ultimo = primeiro;
    }
 
    /**
     * Mostra os elementos separados por espacos.
     */
    public void mostrar() {
      
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
      
    }
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar1(double x) {

	
        boolean retorno = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.getProbMandante() == x){
            retorno = true;
            i = ultimo;
         }
        }
        return retorno;
    }
 
    /**
     * Insere um elemento na primeira posicao da sequencia.
     * @param elemento Elemento a inserir.
     */
    public void inserirInicio(Partida elemento) {
        Celula tmp = new Celula(elemento);
      tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
      tmp = null;
    }
 
    /**
     * Insere um elemento na ultima posicao da sequencia.
     * @param elemento Elemento a inserir.
     */
    public void inserirFim(Partida elemento) {
        Celula tmp = new Celula(elemento);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
      tmp = null;
    }
}

//---------------------------------------------------------------------------------
     /**
     * class tabela rash indireta
     * insire e pesquisa em arquivos referente  
     * a Partida e inteiros
     * retorna true caso elemento for encontrado 
     * ou false caso contrario
     */
class HashIL {
   Lista tabela[];
   int tamanho;
 
   HashIL (){
      tamanho = 21;
      tabela = new Lista[tamanho];
      for(int i = 0; i < tamanho; i++){
         tabela[i] = new Lista();
      }
   }
 
   HashIL (int tamanho){
      this.tamanho = tamanho;
      tabela = new Lista[tamanho];
      for(int i = 0; i < tamanho; i++){
         tabela[i] = new Lista();
      }
   }
 
   int funcaoTransformacao(double valor){
      return (int)(valor % tamanho);
   }
 
   void inserir(Partida valor){
      int pos = funcaoTransformacao(valor.getProbMandante());
      if(tabela[pos].ultimo.elemento == null ) 
      {
	
	tabela[pos].inserirFim(valor);
      }
      else
      {
       tabela[pos].inserirFim(valor);
      }
   }
   int pesquisar(String valor1){
   
	double x = Double.parseDouble(valor1);
	int resp = -1;
	int pos = funcaoTransformacao(x);
  	if(tabela[pos].pesquisar1(x)){
		resp = pos;
	}
	return resp;
	
   }
  
//---------------------------------------------------------------------------------
    void questao7() throws Exception{
  	
     HashIL hash = new HashIL();;

        for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
     
         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
    
         do {
            
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               hash.inserir(Partida.readPartidaUsingArq());
            }
         } while (tmp.contains("</table>") == false);
      }

	
      	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
	
        	if( hash.pesquisar(nomeArquivo) == -1){
        
          		System.out.println("NAO");
        	}
        	else{
       
          		System.out.println(hash.pesquisar(nomeArquivo));
        	}
        	
      }
    }
}


//---------------------------------------------------------------------------------
public class TP6Q7{
   public static void main (String args[]) throws Exception{
     
	 HashIL hash = new HashIL();
	 hash.questao7();

   
     
   }
}
