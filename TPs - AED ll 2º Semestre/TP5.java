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
//----------------------------------------------------------------------------------------------------------
class Celula {
   public Partida elemento; // Elemento inserido na celula.
   public Celula prox; // Aponta a celula prox.
 
 
    /**
     * Construtor da classe.
     */
   Celula(Partida elemento) {
      this.elemento = elemento;
      this.prox = null;
   }
 
    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
   Celula(Partida elemento, Celula prox) {
      this.elemento = elemento;
      this.prox = prox;
   }
}
//----------------------------------------------------------------------------------------------------------
/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class Lista {
   private Celula primeiro;
   private Celula ultimo;
   
 
    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
	
   public Lista() {
      primeiro = new Celula(null);
      ultimo = primeiro;
   }
 
 
    /**
     * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
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
     * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
     */
   public void inserirFim(Partida elemento) {
        
      Celula tmp = new Celula(elemento);
      ultimo.prox = tmp;
      ultimo = ultimo.prox;
      tmp =null;
   }
 
 
    /**
     * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
   public String removerInicio() throws Exception {
        
      String resp;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      }
      else{
         Celula tmp = primeiro;
         primeiro = primeiro.prox;
         resp = primeiro.elemento.toString(primeiro.elemento.getData()) + " " + primeiro.elemento.getMandante();;
         tmp.prox = null;
         tmp = null;
      }
      return resp;
   }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
   public String removerFim() throws Exception {
        
      String resp;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      } 
   
        // Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);
   
      resp = ultimo.elemento.toString(ultimo.elemento.getData()) + " " + ultimo.elemento.getMandante();; 
      ultimo = i; 
      i = ultimo.prox = null;
       
      return resp;
   }
 
 
    /**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
   public void inserirMeio(Partida elemento, int pos) throws Exception {
   
      int tamanho = tamanho();
   
      if(pos < 0 || pos > tamanho){
         throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } 
      else if (pos == 0){
         inserirInicio(elemento);
      } 
      else if (pos == tamanho){
         inserirFim(elemento);
      } 
      else {
           // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
         
         Celula tmp = new Celula(elemento);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }
 
 
    /**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
     * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
   public String removerMeio(int pos) throws Exception {
      String resp;
      int tamanho = tamanho();
   
      if (primeiro == ultimo){
         throw new Exception("Erro ao remover (vazia)!");
      
      } 
      else if(pos < 0 || pos >= tamanho){
         throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } 
      else if (pos == 0){
         resp = removerInicio();
      } 
      else if (pos == tamanho - 1){
         resp = removerFim();
      } 
      else {
           // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
         
         Celula tmp = i.prox;
         resp = tmp.elemento.toString(tmp.elemento.getData()) + " " + tmp.elemento.getMandante();
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }
   
      return resp;
   }
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
   public void mostrar() {
        
      for (Celula i = primeiro.prox; i != null; i = i.prox) {
         i.elemento.imprimir();
      }
      
   }
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
   public boolean pesquisar(Partida elemento) {
      boolean resp = false;
      for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == elemento){
            resp = true;
            i = ultimo;
         }
      }
      return resp;
   }
 
    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * @return resp int tamanho
     */
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
//----------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz algumas insercoes e remocoes
    * na LISTA DINAMICA SIMPLES e salva em arquivo 
    * as alteracoes realizadas.
    */



void questao01() throws Exception {
      
      Lista lista = new Lista();
     
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
      
      
      int vezes = Integer.parseInt( MyIO.readLine() );
      int posicao = 0;
      for(int i = 0 ; i < vezes ; i++){  
       
        String nomeArquivo = MyIO.readLine();
        
         if(nomeArquivo.substring(0,2).equals("II")){
            
            lista.inserirInicio(Partida.readPartidaUsingString(nomeArquivo.substring(3)));
         }
	 else if(nomeArquivo.substring(0,2).equals("IM")){
            
            posicao= Integer.parseInt(nomeArquivo.substring(nomeArquivo.length() -2));
            lista.inserirMeio(Partida.readPartidaUsingString(nomeArquivo.substring(3)),posicao);
         }
         
         else if(nomeArquivo.substring(0,2).equals("IF")){
          
            lista.inserirFim(Partida.readPartidaUsingString(nomeArquivo.substring(3)));
         }
         
         else if(nomeArquivo.substring(0,2).equals("RI")){
            MyIO.println("(R) "+lista.removerInicio());
         }
         
         else if(nomeArquivo.substring(0,2).equals("RM")){
            posicao= Integer.parseInt(nomeArquivo.substring(nomeArquivo.length() -2));
            MyIO.println("(R) "+lista.removerMeio(posicao));
         }
         
         else if(nomeArquivo.substring(0,2).equals("RF")){
            MyIO.println("(R) "+lista.removerFim());
         }
      
      }
   
      lista.mostrar();
      Arq.close();
   }

}// fim class fila 
//----------------------------------------------------------------------------------------------------------
class Pilha {
   private Celula topo;
 
    /**
     * Construtor da classe que cria uma fila sem elementos.
     */
   public Pilha() {
      topo = null;
   
   }
 
 
    /**
     * Insere elemento na pilha (politica FILO).
     * @param x int elemento a inserir.
     */
   public void inserir(Partida elemento) {
      Celula tmp = new Celula(elemento);
      tmp.prox = topo;
      topo = tmp;
      tmp = null;
   }
 
    /**
     * Remove elemento da pilha (politica FILO).
     * @return Elemento removido.
     * @trhows Exception Se a sequencia nao contiver elementos.
     */
   public String remover() throws Exception {
        
      String resp;
   
      if (topo == null) {
         throw new Exception("Erro ao remover!");
      }
      else{
         resp = topo.elemento.toString(topo.elemento.getData()) + " " + topo.elemento.getMandante();;
         Celula tmp = topo;
         topo = topo.prox;
         tmp.prox = null;
         tmp = null;
      }
      return resp;
   }
    /**
     * Mostra os elementos separados por espacos, comecando do topo.
     */
   public void mostrar() {
          
      for(Celula i = topo; i != null; i = i.prox){
         i.elemento.imprimir();
      }
   
   }
	
//-------------------------------------------------------------------------
    /**
    * Metodo - chamada - Pilha com alocacao  
    * Flexivel que inseri suas propriedades da classe 
    * partida na pilha e depois remova cada objeto da mesma.
    */



   void questao02() throws Exception {
      
      Pilha pilha = new Pilha();
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
      
         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
            
               pilha.inserir(Partida.readPartidaUsingArq());
            }
         } while (tmp.contains("</table>") == false);
        
      }

      int vezes = Integer.parseInt( MyIO.readLine() );
      int posicao = 0;

      for(int i = 0 ; i < vezes ; i++){  
         
          String nomeArquivo = MyIO.readLine();
        
	if(nomeArquivo.substring(0,1).equals("I")){
            
            pilha.inserir(Partida.readPartidaUsingString(nomeArquivo.substring(2)));
         }
	 else{
            
            MyIO.println("(R) " + pilha.remover());
         }
      }
      pilha.mostrar();
      Arq.close();
   }
}//fim classe pilha
//----------------------------------------------------------------------------------------------------------
class Filaa {
   private Celula primeiro;
   private Celula ultimo;
   private int tamanho;
 
    /**
     * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
     */
   public Filaa() {
      primeiro = new Celula(null);
      ultimo = primeiro;
      tamanho = 0;
   
   }

    /**
     * Insere elemento na fila (politica FIFO).
     * @param x int elemento a inserir.
     */
   public int inserir(Partida elemento)throws Exception {
      int resp = 0;

        if(tamanho < 4){
         	ultimo.prox = new Celula(elemento);
         	ultimo = ultimo.prox;
         	tamanho++;
        }else if (tamanho == 4){
		
		ultimo.prox = new Celula(elemento);
		ultimo = ultimo.prox;
		ultimo.prox = primeiro;
		tamanho++;
	}else{
		remover();
		ultimo.prox = new Celula(elemento);
		ultimo = ultimo.prox;
		ultimo.prox = primeiro;	
	}
		Celula tmp = primeiro.prox;
		for (int j = 0; j < tamanho; j++,tmp = tmp.prox){
			if(tmp.elemento.getGolMandante() == tmp.elemento.getGolVisitante()){
				resp++;
		}
	}
	tmp = null;
	return resp;
   }
 
 
    /**
     * Remove elemento da fila (politica FIFO).
     * @return Elemento removido.
     * @trhows Exception Se a fila nao tiver elementos.
     */

   public void remover() throws Exception {
        
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }
      else{
         Celula tmp = primeiro;
         primeiro = primeiro.prox;
         tmp.prox = null;
         tmp = null;
      }
   }
    public int somar(){
      int retorno=0;
      for(Celula i = primeiro.prox; i != null; i = i.prox){

	if( i.prox != null && i.elemento.getGolMandante() == i.prox.elemento.getGolVisitante()){
		retorno++;
	}
      }
      return retorno;
   }
   public void mostrar() {
   
         
      for(Celula i = primeiro.prox; i != null; i = i.prox) {
         i.elemento.imprimir();
      }
         
   }

//----------------------------------------------------------------------------------------------------------
  
  /**
    * Metodo Filaa com com alocacao Flexivel que inseri suas
    * propriedades na Filla e caso ela estiver cheia deve
    * remover um objeto na mesma para que seja posivel a insercao. 
    */



void questao03() throws Exception {
      
      Filaa filaa = new Filaa();
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
      
         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
         do {
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){

               System.out.println(filaa.inserir(Partida.readPartidaUsingArq()));
              
            }
         } while (tmp.contains("</table>") == false);
         Arq.close();
      }
   }      

}//fim classe fillaa

//----------------------------------------------------------------------------------------------------------

class CelulaDupla {
   public Partida elemento;
   public CelulaDupla ant;
   public CelulaDupla prox;
 
    /**
     * Construtor da classe.
     */
   public CelulaDupla(Partida elemento) {
      this.elemento = elemento;
      this.ant = null;
      this.prox = null;
   }
 
 
    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
   public CelulaDupla(Partida elemento, CelulaDupla ant , CelulaDupla prox) {
      this.elemento = elemento;
      this.ant = ant;
      this.prox = prox;
   }
}
//----------------------------------------------------------------------------------------------------------
class ListaDupla {
   private CelulaDupla primeiro;
   private CelulaDupla ultimo;
 
 
    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
   public ListaDupla() {
      primeiro = new CelulaDupla(null);
      ultimo = primeiro;
   }
 
 
    /**
     * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
     */
   public void inserirInicio(Partida elemento) {
      CelulaDupla tmp = new CelulaDupla(elemento);
   
      tmp.ant = primeiro;
      tmp.prox = primeiro.prox;
      primeiro.prox = tmp;
      if(primeiro == ultimo){
         ultimo = tmp;
      }
      else{
         tmp.prox.ant = tmp;
      }
      tmp = null;
   }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
     */
   public void inserirFim(Partida elemento) {
      ultimo.prox = new CelulaDupla(elemento);
      ultimo.prox.ant = ultimo;
      ultimo = ultimo.prox;
   }
 
 
    /**
     * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
   public Partida removerInicio() throws Exception {
       
      Partida resp = null;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      }
      else{
         CelulaDupla tmp = primeiro;
         primeiro = primeiro.prox;
         resp = primeiro.elemento;
         tmp.prox = primeiro.ant = null;
         tmp = null;
      }
      return resp;
   }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
   public Partida removerFim() throws Exception {
       
      Partida resp = null;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      } 
      else{
         resp = ultimo.elemento;
         ultimo = ultimo.ant;
         ultimo.prox.ant = null;
         ultimo.prox = null;
      }
      return resp;
   }
 
 
    /**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
   public void inserirMeio(Partida elemento, int pos) throws Exception {
   
      int tamanho = tamanho();
   
      if(pos < 0 || pos > tamanho){
         throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } 
      else if (pos == 0){
         inserirInicio(elemento);
      } 
      else if (pos == tamanho){
         inserirFim(elemento);
      } 
      else {
           // Caminhar ate a posicao anterior a insercao
         CelulaDupla i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
         
         CelulaDupla tmp = new CelulaDupla(elemento);
         tmp.ant = i;
         tmp.prox = i.prox;
         tmp.ant.prox = tmp.prox.ant = tmp;
         tmp = i = null;
      }
   }
 
 
    /**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
     * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
   public Partida removerMeio(int pos) throws Exception {
     
      Partida resp = null;
   
      int tamanho = tamanho();
   
      if (primeiro == ultimo){
         throw new Exception("Erro ao remover (vazia)!");
      
      } 
      else if(pos < 0 || pos >= tamanho){
         throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } 
      else if (pos == 0){
         resp = removerInicio();
      } 
      else if (pos == tamanho - 1){
         resp = removerFim();
      } 
      else {
           // Caminhar ate a posicao anterior a insercao
         CelulaDupla i = primeiro.prox;
         for(int j = 0; j < pos; j++, i = i.prox);
         
         i.ant.prox = i.prox;
         i.prox.ant = i.ant;
         resp = i.elemento;
         i.prox = i.ant = null;
         i = null;
      }
   
      return resp;
   }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
   public void mostrar() {
      
      for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
         i.elemento.imprimir(); 
      }
   
   }
 
 
    /**
     * Mostra os elementos da lista de forma invertida 
    * e separados por espacos.
     */
   public void mostrarInverso() {
     
      for (CelulaDupla i = ultimo; i != primeiro; i = i.ant){
         i.elemento.imprimir();
      }
        
   }
 
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
   public boolean pesquisar(Partida elemento) {
      boolean resp = false;
      for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == elemento){
            resp = true;
            i = ultimo;
         }
      }
      return resp;
   }
 
    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * @return resp int tamanho
     */
   public int tamanho() {
      int tamanho = 0; 
      for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }

//----------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz uma ordencao atravez
    * do algoritimo do quicksort passando 
    * probabilidade de vitoria do visitante 
    * como um atributo e ordenando por ele
    * atravez da lista duplamente encadeada.
    */ 


   void quick(){
   
      int tamanho = 0;
      for(CelulaDupla i = primeiro ; i.prox != null; i = i.prox, tamanho++){
      
         quick(0, tamanho);     
      }
   }   
 

   void quick(int esq, int dir) {
      
    
      int i; int j; 
      i = esq;  j = dir;
   
      int pivo = (i+j) / 2;
     
      CelulaDupla x = primeiro;
      CelulaDupla y = ultimo;
   
      while (i <= j){
      
         while(x.ant !=null && x.elemento.getProbVisitante() < pivo){ i++; x = x.prox; }
         while(y.prox !=null && y.elemento.getProbVisitante() > pivo){ j--; y = y.ant;  } 
      
         if (i <= j){     
            
            Partida temp = new Partida();
            temp = x.elemento;
            x.elemento = y.elemento;
            y.elemento = temp; 
            temp = null; 
         
            i++; 
            j--;
         }
      } 
   
      if (esq < j) quick(esq, j);
      if (i < dir) quick(i, dir);
   }

   void questao04() throws Exception {
      
      ListaDupla listadupla = new ListaDupla();
     
     for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
     
         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
     
   
         do {
            
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               listadupla.inserirFim(Partida.readPartidaUsingArq());
            }
         } while (tmp.contains("</table>") == false);
      }
        	
        
      listadupla.quick();
      listadupla.mostrar();
   
   }
}





//----------------------------------------------------------------------------------------------------------

class CelulaMatriz {
   int elemento;
   CelulaMatriz inf, sup, ant, prox;

   public CelulaMatriz(){
      elemento = 0;
      inf = sup = ant = prox = null;
   }

   public CelulaMatriz(int elemento){
      this.elemento = elemento;
      inf = sup = ant = prox = null;
   }

   public CelulaMatriz(int elemento, CelulaMatriz inf, CelulaMatriz sup, CelulaMatriz ant, CelulaMatriz prox){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.ant = ant;
      this.prox = prox;
   }
}
//----------------------------------------------------------------------------------------------------------

class Matriz {
   private CelulaMatriz inicio;
   private int linha, coluna;
 
   public Matriz (){
      this.linha = this.coluna = 3;
   
      //alocar a matriz com this.linha linhas e this.coluna colunas
   }
 
   public Matriz (int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;
      inicio = montar();
      //alocar a matriz com this.linha linhas e this.coluna colunas
   }
 

   public boolean isQuadrada(){
      return (this.linha == this.coluna);
   }
 
  /**
     * Funcao que coNstroi a linha da matriz
     * @return novo do tipo CelulaMatriz
     */
   public CelulaMatriz arquitetura(){
   
      CelulaMatriz novo = new CelulaMatriz(1);
      CelulaMatriz temp = novo;
      
      for(int i=1; i<coluna; i++){
         temp = new CelulaMatriz(1, null, null, temp, null);
         temp.ant.prox = temp;
      }
      return novo;
   }

    /**
     * Funcao que monta a matriz apartir da 
     * chamado da funcao que controi a linha.
     */
   public CelulaMatriz montar(){
   
      CelulaMatriz x1 = arquitetura();
      CelulaMatriz x = x1;
      CelulaMatriz y;
   
      for(int i=1; i<linha; i++){
         CelulaMatriz y1 = arquitetura();
         y = y1;
         for(int j=0; j<coluna; j++){
            y1.sup = x1;
            x1.inf = y1;
            y1 = y1.prox;
            x1 = x1.prox;
         }
         x1 = y;
      }
      return x;
   }
    /**
     * Funcao que soma uma matriz com a outra retornando  
     * uma terceira matriz no caso a resp com os novos valores.
     */
   public Matriz soma (Matriz m) {
      
      Matriz resp = null;
   
      if(this.linha == m.linha && this.coluna == m.coluna){
      
         resp = new Matriz(linha,coluna);
      
         CelulaMatriz y = inicio, y1 = m.inicio, y2 = resp.inicio;
      
         CelulaMatriz x = y, x1 = y1, x2 = y2;
      
         for(int i=0; i<linha; i++){
            for(int j=0; j<coluna; j++){
            
               x2.elemento = x1.elemento + x.elemento;
               x = x.prox;
               x1 = x1.prox;
               x2 = x2.prox;
            
            }// soma = primeiro elemento(m1) + primeiro elemento(m2) ....
            y = y.inf;
            x=y;
            y1 = y1.inf;
            x1=y1;
            y2 = y2.inf;
            x2=y2;
         }
      }
      return resp;
   }

     /**
     * Funcao que multiplica uma matriz com a outra chamando outra funcao 
     * (multiplicar) eretornando uma terceira matriz no caso a resp com os novos valores.
     */

   public Matriz multiplicacao (Matriz m) {
      
      Matriz resp = null;
   
      if(linha == m.linha && coluna == m.coluna){
      
         resp = new Matriz(linha,coluna);
      
         CelulaMatriz y = inicio, y1 = m.inicio, y2 = resp.inicio;
      
         CelulaMatriz x = y, x1 = y1, x2 = y2;
      
         for(int i=0; i<linha; i++){
            for(int j=0; j<coluna; j++){
            
               x2.elemento = multiplicar(x,x1);
               x1 = x1.prox;
               x2 = x2.prox;
            
            }// multiplicacao = 1l  x 1c , 1l x2c ,2l x 1c , 2l x 2c ...
            y = y.inf;
            x = y;
            x1 = y1;
            y2 = y2.inf;
            x2 = y2;
         }
      }
      return resp;
   }

     /**
     * Funcao que multiplica um elemento com a outro ambos de matrizes distintas   
     * retornando uma multiplicacao das matrizes no caso a soma amarmazena os novos valores.
     */

   public int multiplicar(CelulaMatriz x, CelulaMatriz y){
   
      int soma=0;
      for(int i=0; i<coluna; i++){
         soma += x.elemento * y.elemento;
         x = x.prox;// 1 linha(m1)
         y = y.inf;// 1 coluna(m2)
      }
      return soma;
   }
     /**
     *  metodo que mostra a diagonal principal de uma matriz onde o numero da linhas e igual o da coluna
     */
   public void mostrarDiagonalPrincipal (){
   
      if(isQuadrada() == true){
         if(coluna >0){
            CelulaMatriz tmp = inicio;
         
            for(int i=0; i<linha; i++){
               System.out.print(tmp.elemento+" ");
            
               if(i != linha-1){
                  tmp = tmp.inf;
                  tmp = tmp.prox;
               }
            }
            System.out.println();
         }
      }
   }
     /**
     *  metodo que mostra a diagonal secundaria de uma matriz onde o numero da coluna e menor que o numero da linha 
     */
   public void mostrarDiagonalSecundaria (){
   
      if(isQuadrada() == true){
         if(coluna >0){
            CelulaMatriz tmp = inicio;
         
            for(int i=0; i<linha-1; i++, tmp = tmp.prox);//tmp = ultima posicao da lista
            for(int i=0; i<linha; i++){
            
               System.out.print(tmp.elemento+" ");
            
               if(i != linha-1){
                  tmp = tmp.inf;
                  tmp = tmp.ant;
               }
            }
            System.out.println();
         }
      }
   }
     /**
     * metodo que le um arquivo de inteiros em formato matriz 
     */

   public void LerArquivo(){
   
      CelulaMatriz y = inicio;
      CelulaMatriz x = y;
   
      x.elemento = MyIO.readInt();
   
      for(int i=0; i<linha; i++){
         for(int j=0; j<coluna-1; j++){
         
            x = x.prox;
            x.elemento = MyIO.readInt();
         }
      
         y=y.inf;
         x=y;
         if(i != linha-1){
            x.elemento = MyIO.readInt();
         
         }
      }
   }
    /**
     * metodo que mostra uma matriz deacordo com que vai percorrendo a mesma
     */
   public void mostrar(){
   
      CelulaMatriz y = inicio;
      CelulaMatriz x = y;
   
      for(int i=0; i<linha; i++){
         for(int j=0; j<coluna; j++){
            System.out.print(x.elemento+" ");
            x = x.prox;
         }
         System.out.println();
         y = y.inf;
         x=y;
      }
   }
     /**
     * metodo que chama os outros metodos e funcoes deacordo com o desejado.
     */

   void questao05() throws Exception {
      
        
     
      int tamanho = MyIO.readInt();// primeira linha 
   
      for(int i=0; i < tamanho ; i++){
      
         int x = MyIO.readInt(); 
         int y = MyIO.readInt();
         Matriz m1 = new Matriz(x,y);
         m1.LerArquivo();
         m1.mostrarDiagonalPrincipal();
         m1.mostrarDiagonalSecundaria();
      
         x = MyIO.readInt();
         y = MyIO.readInt();
         Matriz m2 = new Matriz(x,y);
         m2.LerArquivo();
      
         m1.soma(m2).mostrar();
         m1.multiplicacao(m2).mostrar(); 
      
      }
   }
}




//----------------------------------------------------------------------------------------------------------
public class TP5{


   public static void main (String args[]) throws Exception {
   

      Lista lista = new Lista();
      Pilha pilha = new Pilha();
      Filaa filaa = new Filaa();
      ListaDupla listadupla = new ListaDupla();
      Matriz matriz = new Matriz();

    //lista.questao01(); 
    //pilha.questao02(); 
    //filaa.questao03();  
    //listadupla.questao04();
    matriz.questao05();
   }
}



