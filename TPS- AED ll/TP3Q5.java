import java.nio.charset.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.io.*;

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

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim());
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
         System.out.println(" lerPalavra:: " + ioe.getMessage());
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
         resp = readString().charAt(0);
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
//---------------------------------------------------------------------------------
class Arq{
   private static boolean write = false;
   private static boolean read = false;
   private static Formatter saida = null;
   private static Scanner entrada = null;

   public static void openWrite(String nomeArq) {
      close();
   
      try{
         saida = new Formatter(nomeArq);
         write = true;
      }  
      catch (Exception e) {}
   }

   public static void openRead(String nomeArq) {
      close();
   
      try{
         entrada = new Scanner(new File(nomeArq));
         read = true;
      }  
      catch (Exception e) {}
   }

   public static void volta(String arq, long time){
      File file = new File(arq);
      long antes = file.lastModified();
      file.setLastModified(file.lastModified() - time);
   
      file = new File(arq);
      long depois = (new File(arq)).lastModified();
   
      System.out.println(arq + " " +antes +  " " + depois);
   }

   public static void setDataModificado(String nomeArq, int ano, int mes, int dia, int hora, int minuto, int segundo){
      String data = Integer.toString(ano);
      data += ((mes < 10)     ? "0" : "") + Integer.toString(mes);
      data += ((dia < 10)     ? "0" : "") + Integer.toString(dia);
      data += ((hora < 10)    ? "0" : "") + Integer.toString(hora);
      data += ((minuto < 10)  ? "0" : "") + Integer.toString(minuto);
      data += ".";
      data += ((segundo < 10) ? "0" : "") + Integer.toString(segundo);
      try {
         Process p = Runtime.getRuntime().exec("touch -m -t " + data + " " + nomeArq);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void setDataAcesso(String nomeArq, int ano, int mes, int dia, int hora, int minuto, int segundo){
      String data = Integer.toString(ano);
      data += ((mes < 10)     ? "0" : "") + Integer.toString(mes);
      data += ((dia < 10)     ? "0" : "") + Integer.toString(dia);
      data += ((hora < 10)    ? "0" : "") + Integer.toString(hora);
      data += ((minuto < 10)  ? "0" : "") + Integer.toString(minuto);
      data += ".";
      data += ((segundo < 10) ? "0" : "") + Integer.toString(segundo);
      try {
         Process p = Runtime.getRuntime().exec("touch -a -t " + data + " " + nomeArq);
      } 
      catch (Exception e) {
         System.out.println("Error... setDataAcesso...");
         e.printStackTrace();
      }
   }

   public static void setPermissao(String nomeArq, int permissao){
      try {
         Process p = Runtime.getRuntime().exec("chmod " + permissao + " " + nomeArq);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static String getAbsolutePath(String nomeArquivo){
      return (new File(nomeArquivo)).getAbsolutePath();
   }


   public static String getCanonicalPath(String nomeArquivo){
      String resp = "";
      try {
         resp = (new File(nomeArquivo)).getCanonicalPath();
      } 
      catch (Exception e) {}
      return resp;
   }


   public static String getName(String nomeArquivo){
      return (new File(nomeArquivo)).getName();
   }


   public static String getParent(String nomeArquivo){
      return (new File(nomeArquivo)).getParent();
   }


   public static String getPath(String nomeArquivo){
      return (new File(nomeArquivo)).getPath();
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
         resp = entrada.next().charAt(0);
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
      catch (Exception e) {}
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
      catch (Exception e) {}
      return resp;
   }


   public static boolean hasNext(){
      return entrada.hasNext();
   }
}
//---------------------------------------------------------------------------------
class PropriedadeArquivo {
   private String ip;
   private String nome;
   private String caminho;
   private String permissao;
   private int tamanho;
   private Date dataAcesso;
   private Date dataModificado;
   private String dono;

   public PropriedadeArquivo (){
      ip = nome = caminho = permissao = dono = "";
      tamanho = 0;
      dataAcesso = new Date();
      dataModificado = new Date();
   }

   public PropriedadeArquivo (String nomeArquivo){
      ip = "127.1.1.1";
      nome = Arq.getName(nomeArquivo);
      caminho = Arq.getAbsolutePath(nomeArquivo);
   
      try {
      
         Process p = Runtime.getRuntime().exec("ls -l --full-time " + nomeArquivo);
         BufferedReader leitor = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String propriedade = leitor.readLine();
      
         String tmp = "" + propriedade.charAt(0);
         for(int i = 1; i < propriedade.length(); i++){
            if(propriedade.charAt(i) != ' '){
               tmp += propriedade.charAt(i);
            }
            else if (tmp.charAt(tmp.length()-1) != ' '){
               tmp += ' ';
            }
         }
         propriedade = tmp;
      
         String[] vet = propriedade.split(" ");
      
      
         //[0] - Permissao
         int user =  (int)Math.pow(2,0) * ((vet[0].charAt(9) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(8) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(7) == 'r') ? 1 : 0); 
      
         int group = (int)Math.pow(2,0) * ((vet[0].charAt(6) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(5) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(4) == 'r') ? 1 : 0);
      
         int other = (int)Math.pow(2,0) * ((vet[0].charAt(3) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(2) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(1) == 'r') ? 1 : 0);
         
         int permissaoInt = user + group * 10 + other * 100;
         if(permissaoInt < 10){
            permissao = "00" + permissaoInt;
         } 
         else if(permissaoInt < 100){
            permissao = "0" + permissaoInt;
         } 
         else {
            permissao = "" + permissaoInt;
         }
      
         dono = vet[2];
         tamanho = Integer.parseInt(vet[4]);
         int ano = Integer.parseInt(vet[5].substring(0,4));
         int mes = Integer.parseInt(vet[5].substring(5,7));
         int dia = Integer.parseInt(vet[5].substring(8,10));
         int hora = Integer.parseInt(vet[6].substring(0,2));
         int minuto = Integer.parseInt(vet[6].substring(3,5));
         int segundo = Integer.parseInt(vet[6].substring(6,8));
      
         Calendar c = Calendar.getInstance();
         c.set(ano, mes - 1, dia, hora, minuto);
         dataModificado = c.getTime();
      
         p = Runtime.getRuntime().exec("ls -u -l --full-time " + nomeArquivo);
         leitor = new BufferedReader(new InputStreamReader(p.getInputStream()));
         propriedade = leitor.readLine();
         tmp = "" + propriedade.charAt(0);
         for(int i = 1; i < propriedade.length(); i++){
            if(propriedade.charAt(i) != ' '){
               tmp += propriedade.charAt(i);
            }
            else if (tmp.charAt(tmp.length()-1) != ' '){
               tmp += ' ';
            }
         }
         propriedade = tmp;
         vet = propriedade.split(" ");
         ano = Integer.parseInt(vet[5].substring(0,4));
         mes = Integer.parseInt(vet[5].substring(5,7));
         dia = Integer.parseInt(vet[5].substring(8,10));
         hora = Integer.parseInt(vet[6].substring(0,2));
         minuto = Integer.parseInt(vet[6].substring(3,5));
         segundo = Integer.parseInt(vet[6].substring(6,8));
      
         c.set(ano, mes - 1, dia, hora, minuto);
         dataAcesso = c.getTime();
      
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public PropriedadeArquivo clone (){
      PropriedadeArquivo pa = new PropriedadeArquivo();
      pa.ip = this.ip;
      pa.nome = this.nome;
      pa.caminho = this.caminho;
      pa.permissao = this.permissao;
      pa.tamanho = this.tamanho;
      pa.dataAcesso = this.dataAcesso;
      pa.dataModificado = this.dataModificado;
      pa.dono = this.dono;
      return pa;
   }

   public String toString(Date d){
      return (new SimpleDateFormat("dd/MM/yyyy hh:mm")).format(d);
   }

   public void imprimir(){
      System.out.println(ip + " " + nome + " " + permissao + " " + tamanho + " " + toString(dataModificado) + " " + toString(dataAcesso));
   }

   public String getIp(){
      return ip;
   }

   public void setIp(String ip){
      this.ip = ip;
   } 

   public String getNome(){
      return nome;
   }

   public void setNome(String nome){
      this.nome = nome;
   }

   public String getCaminho(){
      return caminho;
   } 

   public void setCaminho(String caminho){
      this.caminho = caminho;
   } 

   public String getPermissao(){
      return permissao;
   }

   public void setPermissao(String permissao){
      this.permissao = permissao;
   }

   public int getTamanho(){
      return tamanho;
   }

   public void setTamanho(int tamanho){
      this.tamanho = tamanho;
   } 

   public Date getDataAcesso(){
      return dataAcesso;
   }

   public void setDataAcesso(Date dataAcesso){
      this.dataAcesso = dataAcesso;
   }

   public Date getDataModificado(){
      return dataModificado;
   }

   public void setDataModificado(Date dataModificado){
      this.dataModificado = dataModificado;
   }

   public String getDono(){
      return dono;
   }

   public void setDono(String dono){
      this.dono = dono;
   } 
}
//---------------------------------------------------------------------------------
     /**
     * classe tabela rash direta com reserva
     * insire e pesquisa em arquivos referente  
     * a propiedadeArquivo e inteiros
     * retorna true caso elemento for encontrado 
     * ou false caso contrario
     */
class HashDR {
   PropriedadeArquivo tabela[];
   int m1, m2, m, reserva;
    
   
 
   HashDR (){
   this(21,9);
   }
 
   HashDR (int m1, int m2){
      this.m1 = m1;
      this.m2 =  m2;
      this.m = m1 + m2;
      this.tabela = new PropriedadeArquivo [this.m];
      for(int i = 0; i < m; i++){
         tabela[i] = new PropriedadeArquivo();
      }
      reserva  = 0;
   }
 
   int funcaoTransformacao(int valor){
      return (valor % m1);
   }

 
   public boolean inserir (PropriedadeArquivo valor){
      boolean resp = false;
    
      if(valor != null) {
         int pos = funcaoTransformacao(valor.getTamanho());
         if(tabela[pos].getTamanho() == 0 ){
            tabela[pos] = valor;
            resp = true;
         } 
					
         else if (reserva < m2){
            tabela[m1 + reserva] = valor;
            reserva++;
            resp = true;
         }      
      } 
      return resp;
   }
 
 
   public boolean pesquisar (int valor){
      boolean resp = false;
      
      int pos = funcaoTransformacao(valor);
      if(tabela[pos].getTamanho() == valor){
         resp = true;
      } 
      else {
         for(int i = 0; i < reserva; i++){
            if(tabela[ m1 + i].getTamanho() == valor){
               resp = true;
               i = reserva;
            }
         }
      }
      return resp;
   }
 
//---------------------------------------------------------------------------------
    void questao5() throws Exception{
  	
     HashDR hash = new HashDR();;

     for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
    
     hash.inserir(new PropriedadeArquivo(nomeArquivo));

   } 
     int converter = 0;
     for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){

        converter = Integer.parseInt( nomeArquivo );

        if( hash.pesquisar(converter) == true )
        {
          System.out.println("SIM");
        }
        else
        {
          System.out.println("NAO");
        }
      }
    }
}


//---------------------------------------------------------------------------------
public class TP3Q5{
   public static void main (String args[]) throws Exception{
     
	 HashDR hash = new HashDR();

  	hash.questao5();

   
     
   }
}















