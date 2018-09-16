import java.time.LocalDateTime;
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

class Lista {

   private PropriedadeArquivo[] array;
   private int n;
   private int numCaractere;

   public Lista () {
      this(6);
   }


   public Lista (int tamanho){
      array = new PropriedadeArquivo[tamanho];
      n = 0;
      numCaractere = 0;
   }

   public Lista Clone(){
   
      Lista lista = new Lista();
      lista.numCaractere = this.numCaractere;	
      return lista;
   }

   public int getNumCaractere( ){
   
      return numCaractere;
   }

   public void setNumCaractere (int numCaractere ){
   
      this.numCaractere = numCaractere;
   }

   public PropriedadeArquivo Clonearrayposicao(int pos)throws Exception {
      return array[pos];
   }

   public PropriedadeArquivo[] Clonearray()throws Exception {
      return array;
   }

   public void inserirInicio(PropriedadeArquivo x) throws Exception {
   
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


   public void inserirFim(PropriedadeArquivo x) throws Exception {
   
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }
   
      array[n] = x.clone();
      n++;
   }


   public void inserirMeio(PropriedadeArquivo x, int pos) throws Exception {
   
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


   public PropriedadeArquivo removerInicio() throws Exception {
   
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
   
      PropriedadeArquivo resp = array[0].clone();
      n--;
   
      for(int i = 0; i < n; i++){
         array[i] = array[i+1].clone();
      }
   
      return resp;
   }


   public PropriedadeArquivo removerFim() throws Exception {
   
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
   
      return array[--n].clone();
   }


   public PropriedadeArquivo removerMeio(int pos) throws Exception {
   
      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }
   
      PropriedadeArquivo resp = array[pos].clone();
      n--;
   
      for(int i = pos; i < n; i++){
         array[i] = array[i+1].clone();
      }
   
      return resp;
   }

   public boolean pesquisar(PropriedadeArquivo x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }

   public void mostrar (){
      for(int i = 0; i < n; i++){
         array[i].imprimir();
      }
   }

   public void mostrar (int i){
      array[i].imprimir();
   }

   public int quantos (){
      return n;
   }

//-----------------------------------------------------------------------------------------------------------
    /**
    * @param elemento - Objeto do tipo texto.
    * Metodo que faz insercoes no fim do
    * array arquivo passando os atributos
    * pedidos.
    */


   void questao01() throws Exception {
   	
      Lista lista = new Lista(200);
        
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		    MyIO.readLine()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }
   
      lista.mostrar();
   }

//-----------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz algumas inserçoes e remocoes
    * no array de objetos e mostra na tela as alteracoes
    * realizadas em arquivo.
    */

   void questao02() throws Exception {
    
      Lista lista = new Lista(200);
   
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

//-----------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz pesquisa sequencial
    * informando caso seja igual ele retorna
    * um valor booleano de acordo com o caso.
    */

   void questao03() throws Exception {
        
      Lista lista = new Lista(200);
    
      boolean resp = false;
      String temp = " ";
   	
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		     MyIO.readLine()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }
      PropriedadeArquivo array;
      int tamanho = lista.quantos();
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		     MyIO.readLine()){
      
         resp = false;
      
         for( int i = 0 ; i < tamanho; i++){
         
            array=lista.Clonearrayposicao(i);
            temp=array.getNome();
         
            if(nomeArquivo.equals(temp)){
               resp = true;
            }      
         }
        
         if(resp){
            System.out.println("SIM");
         }
         else{
            System.out.println("NAO");
         }  
      }
   }
    
//-----------------------------------------------------------------------------------------------------------
   /**
    * Metodo  que faz uma pesquisa binaria
    * dividindo e pesquisando caso seja igual
    * um valor booleano de acordo com o caso.
    */

   boolean Binario (String palavra){
     
      int esquerda = 0,meio = 0, direita = n; 
   
      boolean retorno = false;    
            
      while(esquerda <= direita){
              
      
         meio = (esquerda + direita) / 2;
      
         int resp = palavra.compareTo(array[meio].getNome());
      
         if(resp == 0){
         
            retorno = true;
            esquerda = n;
         
         }
         else if(resp> 0){
         
            esquerda = meio + 1;
         }
         else{
            direita = meio-1;
         }
      
      }
      return retorno;
   
   }


   void questao04() throws Exception {
     
      Lista lista = new Lista(200);	 
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }
   
      boolean retorno = false;    	
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
      
         retorno = lista.Binario(nomeArquivo);
      
        
         if(retorno==true){
         	
            System.out.println("SIM");
         } 
         
         else{ 
         
            System.out.println("NAO");
         }
      
      }
   }
//-----------------------------------------------------------------------------------------------------------
 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se selecao passando nome
    * como um atributo e ordenando por ele.
    */

   void selecao (){
    
   
   
    
      for( int i = 0; i < (n-1); i++ ){
        	
         int menor = i;
      
         for( int j = (i + 1); j < n; j++ ){
         
            int resp = array[menor].getNome().compareTo(array[j].getNome());
         
            if( resp > 0 ){
               menor = j;
            }
         }
      
         PropriedadeArquivo palavra  = array[i];
         array[i] = array[menor];
         array[menor] = palavra;	
      } 
   }
  
   void questao07()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.selecao();
      lista.mostrar();	
   }
//----------------------------------------------------------------------------------------------------------------------------------------------

 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se selecao recursivo passando nome
    * como um atributo e ordenando por ele.
    */
   void recursivoselecao (int low){
        
    
      if(low <= n){
        	
         int menor = low;
      
         for( int j = (low + 1); j < n; j++ ){
         
            int resp = array[menor].getNome().compareTo(array[j].getNome());
         
            if(resp > 0){
               menor = j;
            }
         }
      
         PropriedadeArquivo palavra  = array[low];
         array[low] = array[menor];
         array[menor] = palavra;	
      
         recursivoselecao(low +1);
      } 
   }

  
   void questao08()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.recursivoselecao(0);
      lista.mostrar();	
   }

//----------------------------------------------------------------------------------------------------------------------------------------------

 /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo se insercao passando permissao
    * como um atributo e ordenando por ele.
    */
   void insercao (){
    
      for (int i = 1; i < n; i++) {
      
         int j = i - 1;
      
         PropriedadeArquivo tmp = array[i];	 
         int resp = Integer.parseInt(array[i].getPermissao());
      
         while ((j >= 0) && Integer.parseInt(array[j].getPermissao()) >= resp) {
         
            array[j + 1] = array[j];
            j--;
         }
         array[j + 1] = tmp ;
      }
   }
  
   void questao09()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.insercao();
      lista.mostrar();	
   }



//----------------------------------------------------------------------------------------------------------------------------------------------

  /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do shell passando datamodificado
    * como um atributo e ordenando por ele.
    */
   void shell() {
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
   public void insercaoPorCor(int cor, int h){
   
      for (int i = (h + cor); i < n; i+=h) {
      
         PropriedadeArquivo tmp = array[i];
         int j = i - h;
      
         int resp = array[j].getDataModificado().compareTo(tmp.getDataModificado());
         while ((j >= 0) && (array[j].getDataModificado().compareTo(tmp.getDataModificado()) > 0)) {
         
            array[j + h] = array[j];
            j-=h;
         }
         array[j + h] = tmp;
      }
   }



  
   void questao10()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.shell();
      lista.mostrar();	
   }



//----------------------------------------------------------------------------------------------------------------------------------------------
    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do heap passando data de 
    * acesso como um atributo e ordenando por ele.
    */   


   public void make(int tamanho){
   
      for(int i=tamanho; i>1 && array[i-1].getDataAcesso().compareTo(array[i/2-1].getDataAcesso())>0; i /= 2)
      { 
         PropriedadeArquivo tmp = array[i/2-1];
         array[i/2-1]=array[i-1];
         array[i-1]=tmp;
      }
   }

   public PropriedadeArquivo remover(int tamanho){
   
      PropriedadeArquivo removido = array[0];
      int temp;
      array[0] = array[tamanho-1];
   
      for(int i = 1; i <= (tamanho/2); i = temp){
      
         boolean resp = (2*i == tamanho) || 
            (array[(2*i) - 1].getDataAcesso().compareTo(array[(2*i+1)-1].getDataAcesso())>0);
      
         temp = (2*i) + ((resp) ? 0 : 1);
      
         if(array[i-1].getDataAcesso().compareTo(array[temp-1].getDataAcesso())<0){
            
            PropriedadeArquivo x=array[i-1];
            array[i-1]=array[temp-1];
            array[temp-1]=x;
         }
         else{
            temp=tamanho;
         }
      }
      return removido;
   }
   void heap() {
   
      for(int tamanho = 1; tamanho <= n; tamanho++){
         make(tamanho);
      }
      
      for(int tamanho = n; tamanho > 0; tamanho--){
         array[tamanho-1] = remover(tamanho);
      }
   }

   void questao11()throws Exception {
   
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 	MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.heap();
      lista.mostrar();	
   }


//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do quicksort passando tamanho 
    * como um atributo e ordenando por ele.
    */   


   void quick(){  
     
      quick(0,n-1);
   
   }
   void quick(int i, int j){
   
      int esq=i, dir=j;
   
      int pivo = array[(i+j)/2].getTamanho();
   
      while(esq < dir){
      
      
      
         while(array[esq].getTamanho()<pivo){ 
            esq++;
         }
         while(array[dir].getTamanho()>pivo){
            dir--;
         }
      
         if(esq <= dir){
           
            PropriedadeArquivo x = new PropriedadeArquivo();
         
            x = array[esq];
            array[esq] = array[dir];
            array[dir] = x;
         
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
   

   void questao12()throws Exception {
   
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.quick();
      lista.mostrar();	
   }

//----------------------------------------------------------------------------------------------------------------------------------------------



    /**
    *funçao para pegar o maior valor contido no array
    */
   int maior() {
   
      int maior = array[0].getTamanho();
   
      for (int i = 0; i < n; i++) {
         if(maior < array[i].getTamanho()){
         
            maior = array[i].getTamanho();
         }
      }
      return maior;    
   }

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do countingsort passando tamanho 
    * como um atributo e ordenando por ele.
    */
   void counting() {
      
      int [] v = new int[maior() + 1];
   
      PropriedadeArquivo[] x = new PropriedadeArquivo[n];
      
      for(int i=0; i < v.length; v[i]=0, i++);
     
      for(int i=0; i < n; v[array[i].getTamanho()]++, i++);
     
      for(int i=1; i < v.length; v[i] += v[i-1], i++);
     
      for(int i=n-1; i >= 0; x[v[array[i].getTamanho()]-1] 
                  = array[i], v[array[i].getTamanho()]--,i--);
      
      for(int i = 0; i < n; array[i] = x[i], i++);
   }


   void questao13()throws Exception {
   
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.counting();
      lista.mostrar();	
   }


//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo da bolha passando tamanho
    * como um atributo e ordenando por ele.
    */


   void bolha() {
   
      for (int i = (n - 1); i > 0; i--) {
         for (int j = 0; j < i; j++) {
            if (array[j].getTamanho() > array[j + 1].getTamanho()) {
            
               PropriedadeArquivo palavra  = array[j];
               array[j] = array[j+1];
               array[j+1] = palavra;	
            
            }
         }
      }
   }

   void questao14()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.bolha();
      lista.mostrar();	
   }

//----------------------------------------------------------------------------------------------------------------------------------------------

    /**
    * Metodo  que faz uma ordenaçao atravez
    * do algoritimo do Counting passando tamanho
    * como um atributo e ordenando por ele.
    */

   void merge(){
   
      merge(0, n-1);
   
   }
   
   void merge(int inicio, int fim) {
   
      if (fim <= inicio){
         return;
      }
   
      int meio = (inicio + fim)/2;
   
      merge(inicio, meio);
      merge(meio + 1, fim);
   
      PropriedadeArquivo[] resp1 = new PropriedadeArquivo[meio - inicio + 1];
      PropriedadeArquivo[] resp2 = new PropriedadeArquivo[fim - meio];
   
      for (int i = 0; i <= meio - inicio; i++) {
         resp1[i] = array[inicio + i];
      }
      for (int i = 0; i <= fim - meio - 1; i++) {
         resp2[i] = array[meio + 1 + i];
      }
   
      int i = 0;
      int j = 0;
   
      for (int pos = inicio; pos <= fim; pos++) {
      
         if (i < resp1.length && j < resp2.length) {
         
            if (resp1[i].getTamanho() <= resp2[j].getTamanho()) {
               array[pos] = resp1[i++];
            }
            else {
               array[pos] = resp2[j++];
            }
         }
         else if (i < resp1.length) {
            array[pos] = resp1[i++];
         } 
         else if (j < resp2.length) {
            array[pos] = resp2[j++];
         }
      }
   }

   void questao15()throws Exception {
   
    
    
      Lista lista = new Lista(200);
    
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =	 MyIO.readLine ()){
         lista.inserirFim(new PropriedadeArquivo(nomeArquivo));
      }   	
   
    	
      lista.merge();
      lista.mostrar();	
   }

}
//----------------------------------------------------------------------------------------------------------------------------------------------
class Pilha {

   private PropriedadeArquivo[] array;
   private int n; 

   public Pilha () {
      this(6);
   }


   public Pilha (int tamanho){
      array = new PropriedadeArquivo[tamanho];
      n = 0;
   }


   public void inserir(PropriedadeArquivo x) throws Exception {
   
      if(array.length  <= n){
         throw new Exception("Erro ao inserir!");
      }
   
      array[n] = x.clone();
      n++;
   }

   public PropriedadeArquivo remover() throws Exception {
   
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }
      return array[--n].clone();
   }

   public int quantos (){
      return n;
   }
   
//-----------------------------------------------------------------------------------------------------------   
    /**
    * Metodo - chamada -Pilha com alocacao  
    * sequencial que inseri suas propriedades  
    * na pilha e depois remova cada objeto da mesma.
    */

   void questao05() throws Exception {
      
      Pilha pilha = new Pilha(200);
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
      
         pilha.inserir(new PropriedadeArquivo(nomeArquivo));
      }
   
      while(0 < pilha.quantos()){
      
         pilha.remover().imprimir();
      }
   }
}
//-----------------------------------------------------------------------------------------------------------
class Filaa {

   private PropriedadeArquivo[] array;
   private int n; 
   private int numero;
   private int tamanho;
   
   public Filaa() {
      this(6);
   }


   public Filaa (int tamanho){
      array = new PropriedadeArquivo[tamanho];
      n = 0;
   }

   public int Soma(int tamanho) throws Exception {
     
      for(int i = 0; i < 5 ; i++){
      
         tamanho = tamanho + array[i].getTamanho();
      }
      return tamanho;
   }
 
   public int Somapersonalizada(int tamanho) throws Exception {
      
      for(int i = 0; i < n; i++){
         tamanho = tamanho + array[i].getTamanho();
      }	
      return tamanho;
   }

   public void inserirMeio(int pos,PropriedadeArquivo x) throws Exception {
      
      array[pos] = x;
   }

//-----------------------------------------------------------------------------------------------------------   
    /**
    * Metodo Filaa com alocacao sequencial que inseri suas
    * propriedades na Filla e caso ela estiver cheia deve
    * remover um objeto na mesma para que seja posivel a insercao. 
    */

   public int inserir(PropriedadeArquivo x) throws Exception {
   
      
      if(array.length <= n){
      
         numero = n % 5;
      
         inserirMeio(numero,x);
      
         tamanho = Soma(0);
      
         n++;
      }
      else{
      
         array[n] = x.clone();
      
         n++;
      
         tamanho = Somapersonalizada(0);
      }
      return tamanho;
   }


   void questao06() throws Exception {
      
      Filaa filaa = new Filaa(005);
   
      for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = 		    MyIO.readLine()){
      
         System.out.println(filaa.inserir(new PropriedadeArquivo(nomeArquivo)));
      
      }
   }      
//-----------------------------------------------------------------------------------------------------------
}

public class TP1{

   public static void main (String args[]) throws Exception{
     	   
      Lista lista = new Lista(200);
      Pilha pilha = new Pilha(200);
      Filaa filaa = new Filaa(005);
   
    //lista.questao01();
    //lista.questao02();
    //lista.questao03();
    //lista.questao04();
    //pilha.questao05();
    //filaa.questao06();
    //lista.questao07();
    //lista.questao08();
    //lista.questao09();
    //lista.questao10();
    //lista.questao11();
    //lista.questao12();//1 
    //lista.questao13();
    //lista.questao14();
      lista.questao15();
   
     
   }
}
