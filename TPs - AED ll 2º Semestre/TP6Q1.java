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
class No {
	public Partida elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
	
   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No(Partida elemento) {
	this(elemento, null, null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	No(Partida elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}//Classe no
//---------------------------------------------------------------------------------
/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
class ArvoreBinaria {
    private No raiz; // Raiz da arvore.
 
    /**
     * Construtor da classe.
     */
    public ArvoreBinaria() {
        raiz = null;
    }
  

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String x) {
	System.out.print("raiz ");
        return pesquisar(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para pesquisar elemento.
     * @param no No em analise.
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    private boolean pesquisar(No no, String x) {
      boolean resp;
        if (no == null) {
         resp = false;
         
      } else if (Double.parseDouble(x) == (no.elemento.getProbMandante())) {
         resp = true;

      } else if (Double.parseDouble(x) < (no.elemento.getProbMandante()) ) {
         System.out.print("esq ");
         resp = pesquisar(no.esq, x);
 
      } else {
         System.out.print("dir ");
         resp = pesquisar(no.dir, x);
      }
      return resp;
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarCentral() {
        System.out.print("[ ");
        mostrarCentral(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarCentral(No no) {
        if (no != null) {
            mostrarCentral(no.esq); // Elementos da esquerda.
            System.out.print(no.elemento + " "); // Conteudo do no.
            mostrarCentral(no.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPre() {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarPre(No no) {
        if (no != null) {
            System.out.print(no.elemento + " "); // Conteudo do no.
            mostrarPre(no.esq); // Elementos da esquerda.
            mostrarPre(no.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPos() {
        System.out.print("[ ");
        mostrarPos(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarPos(No no) {
        if (no != null) {
            mostrarPos(no.esq); // Elementos da esquerda.
            mostrarPos(no.dir); // Elementos da direita.
            System.out.print(no.elemento + " "); // Conteudo do no.
        }
    }
 
 
    /**
     * Metodo publico iterativo para inserir elemento.
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
     void inserir(Partida x)throws Exception   {
        raiz = inserir(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * @param no No em analise.
     * @param x Elemento a ser inserido.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(No no, Partida x)throws Exception   {
        if (no == null) {
         no = new No(x);
 
      } else if (x.getProbMandante() < (no.elemento.getProbMandante()) ) {
         no.esq = inserir(no.esq, x);
 
      } else if (x.getProbMandante() > (no.elemento.getProbMandante()) ) {
         no.dir = inserir(no.dir, x);
      }
        return no;
    }
 
    /**
     * Metodo publico iterativo para remover elemento.
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
     void remover(Partida x) throws Exception  {
        raiz = remover(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para remover elemento.
     * @param no No em analise.
     * @param x Elemento a ser removido.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se nao encontrar elemento.
     */
    private No remover(No no, Partida x)throws Exception  {
 
        if (no == null) {
         throw new Exception("Erro ao remover!");
 
      } else if (x.getProbMandante() < (no.elemento.getProbMandante()) ) {
         no.esq = remover(no.esq, x);
 
      } else if (x.getProbMandante() > (no.elemento.getProbMandante()) ) {
         no.dir = remover(no.dir, x);
 
      // Sem no a direita.
      } else if (no.dir == null) {
         no = no.esq;
 
      // Sem no a esquerda.
      } else if (no.esq == null) {
         no = no.dir;
 
      // No a esquerda e no a direita.
      } else {
         no.esq = antecessor(no, no.esq);
        }
 
        return no;
    }
 
    /**
     * Metodo para trocar no removido pelo antecessor.
     * @param n1 No que teve o elemento removido.
     * @param n2 No da subarvore esquerda.
     * @return No em analise, alterado ou nao.
     */
    private No antecessor(No n1, No n2)throws Exception  {
 
      // Existe no a direita.
        if (n2.dir != null) {
         // Caminha para direita.
            n2.dir = antecessor(n1, n2.dir);
 
      // Encontrou o maximo da subarvore esquerda.
        } else {
            n1.elemento = n2.elemento; // Substitui N1 por N2.
            n2 = n2.esq; // Substitui N2 por N2.ESQ.
        }
        return n2;
    }
/**
   * Metodo que procura dentro da arvore
   * de  elementos e usando o metodo
   * da classe arvorebinaria pesquisar
   */


    void questao1() throws Exception{
  	
     	ArvoreBinaria binaria = new ArvoreBinaria();

	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
     
         Arq.openRead(nomeArquivo, "ISO-8859-1");
         String tmp;
         for(tmp = ""; tmp.equals("</tr>") == false; tmp = Arq.readString());
    
         do {
            
            tmp = Arq.readLine(); //ler o <tr>
            if(tmp.contains("<tr>") == true){
               binaria.inserir(Partida.readPartidaUsingArq());
            }
         } while (tmp.contains("</table>") == false);
      }

      	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		MyIO.readLine()){
      
        	if( binaria.pesquisar(nomeArquivo) == true ){
        
          		System.out.println(" SIM");
        	}
        	else{
       
          		System.out.println(" NAO");
        	}
      }
    }
}

//---------------------------------------------------------------------------------
public class TP6Q1{
   public static void main (String args[]) throws Exception{
     
	 ArvoreBinaria binaria = new ArvoreBinaria();

  		binaria.questao1();

   
     
   }
}
