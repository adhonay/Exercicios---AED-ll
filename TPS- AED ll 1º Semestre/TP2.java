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
//----------------------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------------------
class Celula {
   public PropriedadeArquivo elemento; // Elemento inserido na celula.
   public Celula prox; // Aponta a celula prox.
 
 
    /**
     * Construtor da classe.
     */
   Celula(PropriedadeArquivo elemento) {
      this.elemento = elemento;
      this.prox = null;
   }
 
    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
   Celula(PropriedadeArquivo elemento, Celula prox) {
      this.elemento = elemento;
      this.prox = prox;
   }
}
//----------------------------------------------------------------------------------------------------------
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
   public void inserirInicio(PropriedadeArquivo elemento) {
   
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
   public void inserirFim(PropriedadeArquivo elemento) {
        
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
   public PropriedadeArquivo removerInicio() throws Exception {
        
      PropriedadeArquivo resp = null;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      }
      else{
         Celula tmp = primeiro;
         primeiro = primeiro.prox;
         resp = primeiro.elemento;
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
   public PropriedadeArquivo removerFim() throws Exception {
        
      PropriedadeArquivo resp = null;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover (vazia)!");
      } 
   
        // Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);
   
      resp = ultimo.elemento; 
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
   public void inserirMeio(PropriedadeArquivo elemento, int pos) throws Exception {
   
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
   public PropriedadeArquivo removerMeio(int pos) throws Exception {
      PropriedadeArquivo resp = null;
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
         resp = tmp.elemento;
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
   public boolean pesquisar(PropriedadeArquivo elemento) {
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


//-----------------------------------------
   /**
    * Metodo  que faz algumas inserçoes e remocoes
    * na LISTA DINAMICA SIMPLES e mostra em arquivo 
    * as alteracoes realizadas em arquivo.
    */



   void questao01() throws Exception {
    
      Lista lista = new Lista();
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		    MyIO.readLine()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }
   
      String nomeArquivo = MyIO.readString();
      int vezes = Integer.parseInt( nomeArquivo );
      int posicao = 0;
   
   
      for(int i = 0 ; i < vezes ; i++){
      
         nomeArquivo = MyIO.readString();
      
      
         if(nomeArquivo.equals("II")){
            nomeArquivo = MyIO.readString();
            lista.inserirInicio(new PropriedadeArquivo(nomeArquivo));
         }
         
         else if(nomeArquivo.equals("IM")){
            nomeArquivo = MyIO.readString();
            posicao= Integer.parseInt(MyIO.readString());
            lista.inserirMeio(new PropriedadeArquivo(nomeArquivo),posicao);
         }
         
         else if(nomeArquivo.equals("IF")){
            nomeArquivo = MyIO.readString();
            lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
         }
         
         else if(nomeArquivo.equals("RI")){
            MyIO.println("(R) "+lista.removerInicio().getNome());
         }
         
         else if(nomeArquivo.equals("RM")){
            posicao= Integer.parseInt(MyIO.readString());
            MyIO.println("(R) "+lista.removerMeio(posicao).getNome());
         }
         
         else if(nomeArquivo.equals("RF")){
            MyIO.println("(R) "+lista.removerFim().getNome());
         }
      
      }
   
      lista.mostrar();
   } 
}  
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
   public void inserir(PropriedadeArquivo elemento) {
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
   public PropriedadeArquivo remover() throws Exception {
        
      PropriedadeArquivo resp = null;
   
      if (topo == null) {
         throw new Exception("Erro ao remover!");
      }
      else{
         resp = topo.elemento;
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
	
//--------------------------------------------------

    /**
    * Metodo - chamada - Pilha com alocacao  
    * Flexivel que inseri suas propriedades  
    * na pilha e depois remova cada objeto da mesma.
    */

   void questao02() throws Exception {
      
      Pilha pilha = new Pilha();
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
      
         pilha.inserir(new PropriedadeArquivo(nomeArquivo));
      }
      int n = 50 ;// n= numeros de linha da saida.
      while(n > 0){
      
         pilha.remover().imprimir();
         n--;
      }
   }
}
//---------------------------------------------------------------------------------------------------------

class Filla {
   private Celula primeiro;
   private Celula ultimo;
   private int tamanho;
 
    /**
     * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
     */
   public Filla() {
      primeiro = new Celula(null);
      ultimo = primeiro;
      tamanho = 5;
   
   }
 
 
    /**
     * Insere elemento na fila (politica FIFO).
     * @param x int elemento a inserir.
     */
   public void inserir(PropriedadeArquivo elemento) {
      if(0 < tamanho){
         ultimo.prox = new Celula(elemento);
         ultimo = ultimo.prox;
         tamanho--;
      }
   }
 
 
    /**
     * Remove elemento da fila (politica FIFO).
     * @return Elemento removido.
     * @trhows Exception Se a fila nao tiver elementos.
     */

   public PropriedadeArquivo remover() throws Exception {
        
      PropriedadeArquivo resp = null;
   
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }
      else{
         Celula tmp = primeiro;
         primeiro = primeiro.prox;
         resp = primeiro.elemento;
         tmp.prox = null;
         tmp = null;
      }
      tamanho++;
      return resp;
   }
    
   public int somar(){
      int retorno=0;
      for(Celula i = primeiro.prox; i != null; i = i.prox){
         retorno += i.elemento.getTamanho();
      }
      return retorno;
   }
 
    /**
     * Mostra os elementos separados por espacos.
     */
   public void mostrar() {
   
         
      for(Celula i = primeiro.prox; i != null; i = i.prox) {
         i.elemento.imprimir();
      }
         
   }

//-------------------------------------------------------

     /**
    * Metodo Filaa com com alocacao Flexivel que inseri suas
    * propriedades na Filla e caso ela estiver cheia deve
    * remover um objeto na mesma para que seja posivel a insercao. 
    */


   void questao03() throws Exception {
      
      Filla filla = new Filla();
         	
      int total = 0;
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
        
         filla.inserir(new PropriedadeArquivo(nomeArquivo));
         total = filla.somar();
         System.out.println(total);
      
         if(filla.tamanho == 0){
            filla.remover();
         }
        
      
      }
   }
}
//---------------------------------------------------------------------------------------------------------  


class CelulaDupla {
   public PropriedadeArquivo elemento;
   public CelulaDupla ant;
   public CelulaDupla prox;
 
    /**
     * Construtor da classe.
     */
   public CelulaDupla(PropriedadeArquivo elemento) {
      this.elemento = elemento;
      this.ant = null;
      this.prox = null;
   }
 
 
    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
   public CelulaDupla(PropriedadeArquivo elemento, CelulaDupla ant , CelulaDupla prox) {
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
   public void inserirInicio(PropriedadeArquivo elemento) {
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
   public void inserirFim(PropriedadeArquivo elemento) {
      ultimo.prox = new CelulaDupla(elemento);
      ultimo.prox.ant = ultimo;
      ultimo = ultimo.prox;
   }
 
 
    /**
     * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
   public PropriedadeArquivo removerInicio() throws Exception {
       
      PropriedadeArquivo resp = null;
   
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
   public PropriedadeArquivo removerFim() throws Exception {
       
      PropriedadeArquivo resp = null;
   
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
   public void inserirMeio(PropriedadeArquivo elemento, int pos) throws Exception {
   
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
   public PropriedadeArquivo removerMeio(int pos) throws Exception {
     
      PropriedadeArquivo resp = null;
   
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
   public boolean pesquisar(PropriedadeArquivo elemento) {
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
    * do algoritimo do quicksort passando tamanho 
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
      
         while( x.elemento.getTamanho() < pivo){ i++; x = x.prox; }
         while( y.elemento.getTamanho() > pivo){ j--; y = y.ant;  } 
      
         if (i <= j){     
            
            PropriedadeArquivo temp = new PropriedadeArquivo();
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
     
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
      
         listadupla.inserirFim(new PropriedadeArquivo(nomeArquivo));
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
     * metodo que chama os outros metodos e funcoes deacordo com o desejado
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

public class TP2{

   public static void main (String args[]) throws Exception{
     
      Lista lista = new Lista();
      Pilha pilha = new Pilha();
      Filla filla = new Filla();
      ListaDupla listadupla = new ListaDupla();
      Matriz matriz = new Matriz();
   
    //lista.questao01();
    //pilha.questao02();
    //filla.questao03();
    //listadupla.questao04();
      matriz.questao05();
   
     
   }
}
